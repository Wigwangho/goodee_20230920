package com.week5;
//입력: - add(element) boolean 응답처리 시 선택
// add(int, element) void 응답처리시 리턴 타입이 boolean이라서 처리결과 읃답을 바로 받는 ㅇ일산 방법.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

class List5{
	List<Map<Integer, Integer>> rank = new ArrayList();
	void init(){
		
		Map<Integer, Integer> map = new HashMap<>();//map 초기화, 데이터 추가
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		rank.add(map);
	
	}	

	boolean rankUpdate(int index, int value) {//맵에서 데이터 쑥 뽑고 도로 집어넣고... 난리났다 증말!
		boolean isOk =false;
		Map<Integer, Integer> mp = rank.get(0);
		Integer in = mp.get(index);
		if(in != null) {
			if(in != value) {
				isOk = true;
			}
		}
		if(isOk) {
			int temp = mp.get(value);
			mp.remove(in);
			mp.put(in, value);
			mp.remove(value);
			mp.put(value, in);
		}
		
		rank.set(0, mp);
		return isOk;
		
	}
}
public class ListMain5 {

	public static void main(String[] args) {//최종 실행. 입력받은 숫자를 | 연산자로 분류하고, 두 숫자간의 순위를 변경하다.
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
