package com.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

class ListVO{
	private String name;
	private int prize;
	List<ListVO> list = new ArrayList<>();
	

public ListVO(String name, int prize){
		this.name = name;
		this.prize = prize;
	}	
void init() {
	ListVO lv1 = new ListVO("나일등", 1);
	ListVO lv2 = new ListVO("박이등", 2);
	ListVO lv3 = new ListVO("최삼등",3);
	list.add(lv1);
	list.add(lv2);
	list.add(lv3);
	
}

	boolean rankUpdate(int index, int value) {
		boolean isOk =false;
		
		int pr = list.get(index).prize;
		String name =list.get(index).name;
			if(pr != value) {
				isOk = true;
			}
		
		if(isOk) {
			int temp = pr;
			pr = list.get(value).prize;
			
		}
		
		
		return isOk;
		
	}
}
public class ListMainVO {

	public static void main(String[] args) {
		System.out.println("수정하고자 하는 위치값과 숫자를 입력");
		Scanner sc = new Scanner(System.in);
		String user = sc.nextLine();
		StringTokenizer st = new StringTokenizer(user, "|");
		String imsi = st.nextToken();
		int index = Integer.parseInt(imsi);
		String value = st.nextToken();
		int ivalue = Integer.parseInt(value);
		List5 l5 = new List5();
		l5.init();
		boolean isOk = l5.rankUpdate(index, ivalue);
		if(isOk) System.out.println("수정 처리되었습니다"+l5.rank.get(0) );
		else System.out.println("수정 실패");
	}
	
	
}
