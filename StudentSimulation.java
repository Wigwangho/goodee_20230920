package com.week1;

public class StudentSimulator {
	
	//학생들의 정보를 저장하는 메소드
	Student setStudent(int java, int html, int css, String name) {
		Student std = new Student();
		//Student.java 파일 필요
		std.html 	= html;
		std.java 	= java;
		std.css 	= css;
		std.name  	= name;
		//학생 정보를 불러온다 
		//불러오지 않고 그냥 종료하면? 지역변수라 저장한 모든 클래스가 사라짐!
		//void를 사용하는 대신 Student 클래스를 이용해 새로은 클래스 std를 리턴받음.
		
		return std;
	}
	

	public static void main(String[] args) {
		
		StudentSimulator ss = new StudentSimulator();
		Student std2 = new Student();
		std2 = ss.setStudent(95, 100, 70, "나잘해");
		System.out.println(std2.name + " 학생의 총점 : " + std2.sum + " \n" + std2.name + " 학생의 평균: "+ std2.avg);
	}

}
