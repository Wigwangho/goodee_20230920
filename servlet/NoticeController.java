package com.example.demo.pojo1;

import java.io.IOException;
/*
 * 서블릿을 상송받지 않았다 - 결합도를 낮추고 싶기 때문. 그것이 프레임워크의 중요 사상이다
 * 서블릿이 아닌데 req,res는 조상님이 갖다주시나!!!! doGet(req, res) 만이 nullpointerexception을 피할 수 있다

 * 전처리부가 필요하다
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NoticeController implements Action {
	Logger logger = LoggerFactory.getLogger(NoticeController.class);
	NoticeLogic nLogic = new NoticeLogic();
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String n_no = req.getParameter("n_no");
		String n_title = req.getParameter("n_title");
		String n_content = req.getParameter("n__content");
		String n_writer = req.getParameter("n_writer");
		logger.info(n_no+", "+n_title+", "+n_content+", "+ n_writer);
		String upmu[] = (String[]) req.getAttribute("upmu");
		ActionForward af = new ActionForward();
		StringBuilder path = new StringBuilder();
		
		boolean isRedirect = false;
		path.append("/WEB-INF/jsp");
		path.append("/notice/");
		if("noticeList".equals(upmu[1])) {
			logger.info("noticeList");
			List<Map<String, Object>> nList = null;
			nList = nLogic.noticeList();
			req.setAttribute("nList", nList);
			path.append("noticeList.jsp");
			isRedirect = false;//false 이면 forward 처리
		}
		//화면 출력을 ReactJS처럼 다른 언어, 다른 라이브러리 사용하여 처리해야 할 땐, 백엔드에서 해야 할 일은 JSON포맷으로 응답이 나가도록 처리해야 함
		//POJO1-3버전에서는 이 부분도 공통 코드로 담아본다
		else if("JsonNoticeList".equals(upmu[1])) {
			logger.info("noticeList");
			List<Map<String, Object>> nList = null;
			nList = nLogic.noticeList();
			req.setAttribute("nList", nList);
			
			path.append("JsonNoticeList.jsp");
			isRedirect = false;//false 이면 forward 처리
		}
		
		else if("noticeUpdate".equals(upmu[1])) {
			logger.info("noticeUpdate");
			int result = 0;
			result = nLogic.noticeUpdate();
			if(result == 1) {
				path.append(("noticeList.gd"));
				isRedirect=true;
			}
			else {
				path.append("noticeError.jsp");
				isRedirect = true;
			}
		}
		else if("noticeInsert".equals(upmu[1])) {
			logger.info("noticeInsert");
			int result = 0;
			result = nLogic.noticeInsert();
			if(result == 1) {
				path.append(("noticeList.gd"));
				isRedirect=true;
			}
			else {
				path.append("noticeError.jsp");
				isRedirect = true;
			}
		}
		else if("noticeDelete".equals(upmu[1])) {
			logger.info("noticeDelete");
			int result = 0;
			result = nLogic.noticeDelete();
			if(result == 1) {
				path.append(("noticeList.gd"));
				isRedirect=true;
			}
			else {
				path.append("noticeError.jsp");
				isRedirect = true;
			}
		}
		
		af.setPath(path.toString());
		af.setRedirect(isRedirect);
		return af;
	}

}
