package com.example.demo.pojo1;
//추상 메소드만 가질 수 있음. 클래스의 명세서 역할??
//구현할 수 없다. 결정된 바가 없으니까...

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException;
}
