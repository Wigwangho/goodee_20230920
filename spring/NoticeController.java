package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.logic.NoticeLogic;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/notice/*")
  //매핑
public class NoticeController {
    Logger logger = LoggerFactory.getLogger(NoticeController.class);
    @Autowired
    NoticeLogic noticeLogic = null;

    @GetMapping("noticeList")
    public String noticeList(@RequestParam Map<String, Object> pmap, HttpServletRequest req) {

        logger.info(pmap.get("gubun").toString());

        logger.info(pmap.get("keyword").toString());
        List<Map<String, Object>> list = null;
        list = noticeLogic.noticeList(pmap);//로직으로 넘기기
        return "forward:noticeList.jsp";// forward 붙었으므로 webapp아래에서 찾는다
    }

    // insert into notice(n_no, n_title, n_content, n_writer) values(?, ?, ?, ?)
    @GetMapping("noticeInsert")
    public String noticeInsert(@RequestParam Map<String, Object> pmap) {

        logger.info(pmap.get("n_title").toString());
        logger.info(pmap.get("n_content").toString());
        return "redirect:noticeList";// 화면을 호출하는 것이 아니라 url을 호출한다 - 9번째 라인 noticeList 실행 - 화면을 유지할 필요 없으므로 redirect
      //현재 상태: 모양만 잡아두었음
    }

    @GetMapping("noticeUpdate")
    public String noticeUpdate() {

        logger.info("noticeUpdate");
        return "redirect:noticeList.jsp";// 화면을 호출하는 것이 아니라 url을 호출한다 - 9번째 라인 noticeList 실행 - 화면을 유지할 필요 없으므로 redirect
    }

    @GetMapping("noticeDelete")
    public String noticeDelete() {

        logger.info("noticeDelete");
        return "redirect:noticeList.jsp";// 화면을 호출하는 것이 아니라 url을 호출한다 - 9번째 라인 noticeList 실행 - 화면을 유지할 필요 없으므로 redirect
    }
}
