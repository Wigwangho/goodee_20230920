package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.logic.NoticeLogic;
import java.util.*;
import jakarta.servlet.http.HttpServletRequest;

//스프링에서는 URL매핑이 4번을 디폴트로 하고 있다
//서블릿컨테이너와는 다르게  메소드 마다 URL지정할 수 있다
//URL 요청 - 요청방식 - get,post(바이너리처리-첨부파일처리가능함),put,delete - 전송방식 차이
//@Controller는 클래스 선언 앞에 온다 -페이지 출력일 때사용한다. 
//만일 @Controller가 있는 클래스에서 JSON포맷을 예외적으로 사용하고 싶다면 @ResponseBody사용함
//@RestController @Controller와 같이 컨트롤계층을 지원하는 어노테이션임 - 처리 결과가 페이지가 아닌경우 사용
//프론트계층(Reactjs사용)과 백엔드 계층 분리
//RequestMapping은 클래스 이름 앞에 , 메소드 이름앞에도 가능한데 최근에는 GetMapping과 PostMappiing지원함에
//따라서 대체로 클래스 선언앞에서만 주로 사용
//@RequestParam은 메소드의 파라미터 자리에 사용되는 어노테이션이다.
//@Service은 서비스계층(모델계층-처리-기능 - 비즈니스로직+퍼시스턴스계층)
//DB연동을 위한 클래스를 따로 설계추천함 - myBatis, hibernate 라이브러리, 프렘임워크지원되므로
@Controller
@RequestMapping("/notice/*")
public class NoticeController {
    Logger logger = LoggerFactory.getLogger(NoticeController.class);
    @Autowired
    NoticeLogic noticeLogic = null;

    // 전체 조회 및 조건 검색일 때
    // SELECT * FROM notice WHERE gubun=? AND keyword=?
    @GetMapping("noticeList")
    public String noticeList(@RequestParam Map<String, Object> pmap, HttpServletRequest req, Model model) {
        List<Map<String, Object>> list = noticeLogic.noticeList(pmap);
        model.addAttribute("nList", list);
        return "forward:noticeList.jsp";// webapp아래에서 찾는다
    }

    // insert into notice(n_no, n_title, n_content, n_writer) values(?,?,?,?)
    @PostMapping("noticeInsert")
    public String noticeInsert(@RequestParam Map<String, Object> pmap, Model model) {
        logger.info(pmap.get("n_title").toString());
        logger.info(pmap.get("n_content").toString());
        List<Map<String, Object>> list = noticeLogic.noticeInsert(pmap);
        model.addAttribute("nList", list);
        return "redirect:noticeList";// 화면을 호출하는게 아니라 url을 호출한다 - 9번라인
    }

  //현재 noticeInsert까지 구현
  //
    @GetMapping("noticeUpdate")
    public String noticeUpdate() {
        logger.info("noticeUpdate");
        return "redirect:noticeList.jsp";// 화면을 호출하는게 아니라 url을 호출한다 - 9번라인
    }

    @GetMapping("noticeDelete")
    public String noticeDelete() {
        logger.info("noticeDelete");
        return "redirect:noticeList.jsp";// 화면을 호출하는게 아니라 url을 호출한다 - 9번라인
    }
}
