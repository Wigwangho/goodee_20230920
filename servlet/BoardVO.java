package com.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok의 활용
@Data
//@Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정
@NoArgsConstructor
//파라미터가 없는 디폴트 생성자를 생성
public class BoardVO {


	private int b_no = 0;          
	private String b_title = null;
	private String b_writer  = null; 
	private String b_content  = null;
	private int b_hit = 0;    
	private String b_date = null  ; 
	private String b_file   = null    ;   
	
	//롬복이 제공하는 builder -> 파라미터 개수와 타입을 일일이 맞추지 않고도 자유롭게 사용이 가능함!
	//사용이란: 생성자의 파라미터값을 통한 전역변수들의 초기화 작업
	@Builder
	public BoardVO(int b_no, String b_title, String b_water, String b_content, int b_hint, String b_date, String b_file ) {
		super();
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_content =b_content;
		this.b_hit = b_hit;
		this.b_date = b_date;
		this.b_file = b_file;
		
		
	}
}
