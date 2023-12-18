package com.example.demo.step1;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/*")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    // http://localhost:8000/user/login?mem_id=kiwi&mem_pw=123
    // 쿼리스트링을 사용해 값을 넘기는 GET 방식
    @GetMapping("login")
    public String login(HttpServletRequest req) {
        String mem_id = req.getParameter("mem_id");
        String mem_pw = req.getParameter("mem_pw");
        logger.info(mem_id + ", " + mem_pw);

        return "redirect:/index.jsp";

    }

    @GetMapping("login2")
    public String login2(@RequestParam("mem_id") String mem_id, @RequestParam("mem_pw") String mem_pw) {

        logger.info(mem_id + ", " + mem_pw);

        return "redirect:/index.jsp";
  //하나하나 다 가져오는 건 불편하다
    }

    @GetMapping("login3")
    public String login3(@RequestParam String mem_id, String mem_pw) {

        logger.info(mem_id + ", " + mem_pw);

        return "redirect:/index.jsp";

    }

    @GetMapping("login4")
    public String login4(@RequestParam Map<String, Object> pmap) {

        logger.info(pmap.get("mem_id") + ", " + pmap.get("mem_pw"));

        return "redirect:/index.jsp";

    }

        @GetMapping("login5")
    public String login5(@RequestParam Map<String, Object> pmap) {

        logger.info(pmap.get("mem_id") + ", " + pmap.get("mem_pw")+pmap.get("mem_name"));

        return "redirect:/index.jsp";
//Map 의 힘을 쓰면 따로 파라미터를 지정하지 않아도 된다
    }

    @GetMapping("loginForm")
    public String loginForm() {
        return "/user/loginForm";
        // return "redirect:/user/loginForm.jsp";
    }


    @GetMapping("loginForm2")
    public ModelAndView loginForm2() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/loginForm2");

        // return new ModelAndView();// WEB-INF/views/user/loginForm2.jsp
        return mav;
    }

    @GetMapping("loginForm3")
    public String loginForm3() {

        return "redirect:/user/loginForm.jsp";
    }
}
