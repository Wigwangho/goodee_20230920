package com.example.demo.pojo1;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//얘도 서블릿이 아니면 null뿐이야
/*
 * http://localhost:8000/member/memberInsert.gd - insert: int - 입력
 * http://localhost:8000/lecture/lectureInsert.gd
 * http://localhost:8000/notice/noticeInsert.gd
 * http://localhost:8000/member/memberUpdate.gd
 * http://localhost:8000/lecture/lectureUpdate.gd - update:int - 수정
 * http://localhost:8000/notice/noticeUpdate.gd
 * http://localhost:8000/member/memberDelete.gd
 * http://localhost:8000/lecture/lectureDelete.gd - delete:int - 삭제
 * http://localhost:8000/notice/noticeDelete.gd
 * http://localhost:8000/member/memberList.gd - select - dispatcher(forward) - false - 확인
 * http://localhost:8000/lecture/lectureListgd - select - forward - false
 * http://localhost:8000/notice/noticeList.gd - select - forward - false
 */

@WebServlet("*.gd")

public class frontMVC extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(frontMVC.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService");
		String  uri = req.getRequestURI(); // => /notice/noticeInsert.gd
		logger.info(uri);
		String context = req.getContextPath();// /
		logger.info(context);
		String command = uri.substring(context.length()+1);//-> notice/noticeInsert.gd
		logger.info(command);
		//뒤에 의미없는 확장자 gd를 잘라내기
		int end = command.lastIndexOf(".");//점이 있는 위치정보를 가져온다
		logger.info(""+end);
		command =  command.substring(0,end);//-> notice/noticeInsert까지만 가져온다. .gd는 빼고서....
		logger.info(command);//-> notice/noticeList or notice/noticeInsert or notice/noticeUpdate or notice/noticeDelete
		String upmu[] = null;
		upmu = command.split("/");
		for(String name:upmu) {
			logger.info(name);
		}
		ActionForward af = null;
		NoticeController nc = new NoticeController();//결합도가 강하다-별로다-제어역전아니다
		//MemberController mc = new MemberController();
		//LectureController lc = new LectureController();
		////////////////////////[[  어떤 컨트롤러를 태울것인가? ]]/////////////////////////
		//이 지점은 내려가는 방향이다
		if("notice".equals(upmu[0])) {
			//왜 NoticeController클래스에 upmu[]을 넣어주나요? - 메소드
			//메소드 이름을 가지고 NoticeController에서 if문(조건식이 필요함-upmu[1])을 적어야 한다.
			//4가지 - noticeList, noticeInsert, noticeUpdate, noticeDelete
			//왜냐면 NoticeController에서 NoticeLogic클래스를 인스턴스화 해야 하니까
			//왜요? NoticeLogic에 정의된 메소드를 여기서 호출해야 하니까...
			//설계 관점 아쉬움 - 우리는 XXXController에서 부터 메소드를 가질 수 없었나?
			//이유- 나는 아직은 메소드마다 req, res에 대한 객체 주입을 처리할 수 없는 구조이니까
			req.setAttribute("upmu",upmu);
			af = nc.execute(req, res);//NoticeController클래스로 건너감 - upmu[1]-메소드이름이니까...
		}
		//이 지점은 java와 오라클 서버를 경유한 뒤 시점이다.
		
		/////////// end of if - 응답페이지 호출하기 - 포워드
		else if("member".equals(upmu[0])) {
			
		}
		else if("lecture".equals(upmu[0])) {
			
		}
		if(af !=null) {
			if(af.isRedirect()) {
				res.sendRedirect(af.getPath());
			}
			else{
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());
				view.forward(req, res);
			}
	
	////////////////////////////////[컨트롤을 타고 난 뒤 할 일]
	
	
	////////////////////////////////[어떤 컨트롤러를 태울 것인가]
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doPut-수정할때");
		String n_no = req.getParameter("n_no");
		String n_title = req.getParameter("n_title");
		String n_content = req.getParameter("n__content");
		String n_writer = req.getParameter("n_writer");
		logger.info(n_no+", "+n_title+", "+n_content+", "+ n_writer);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("dodelteed-수정할때");
		String n_no = req.getParameter("n_no");
		logger.info(n_no);		
	}
}
