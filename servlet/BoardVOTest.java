package com.example.demo.pojo2;

import com.vo.BoardVO;
import com.vo.EmpVO;

public class BoardVOTest {

	public static void main(String[] args) {
	
		EmpVO evo = new EmpVO("나잘난");//코드만 보고 나잘난이 무엇인지 유추하기엔 너무 비직관적임(getename 어디갓숴)
		System.out.println("ename: "+evo.getEname() );
		BoardVO bvo3 = new BoardVO();
		bvo3.getB_title();//바로 가져오는 건 private이라 안돼. 캡슐화
		bvo3.setB_title("제목");
		String title = bvo3.getB_title();
		System.out.println(title);
		BoardVO bvo = BoardVO.builder().b_no(3).build();
		
		BoardVO bvo2 = BoardVO.builder().b_title("제목1").build();
		System.out.println(bvo.getB_no());
		System.out.println(bvo.getB_title());//VO에서 null로 초기화되었으니까
	}

}
