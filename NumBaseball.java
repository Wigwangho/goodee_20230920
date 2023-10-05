import java.util.Scanner;
import java.util.Random;

class Numarr{
	int strike = 0;
	int ball = 0;
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	static int[] answer = new int[3]; 
	
	 private static boolean exists(int n[], int index) {//answer 배열을 중복해서 만들지 않게 해 주는 메소드
	        for (int i = 0; i < n.length; i++) {
	            if(n[i] == index)
	                return true;
	        }
	        return false;
	    } 
	 
	
	public void SetAnswer() {//정답 배열인 answer 배열을 리턴하는 메소드
        int index = 0;
        for(int i = 0; i<answer.length;i++) {
            do {
                index = (int)(Math.random()*10);
            }while(exists(answer,index));
           answer[i] = index;
        }
        
		
	}
	public void menu() {//메뉴를 띄워주는 메소드
		Numarr na = new Numarr();
		System.out.println("메뉴\n1. 숫자 초기화\n2. 게임 시작");
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();
		if (menu ==1) {
			na.SetAnswer();
			System.out.println("초기화되었습니다.");
			na.menu();
		}
		else if (menu == 2) {
			na.Pitch();
		}
	}
	
	public void Pitch() {//정답을 던져 보는 메소드
		System.out.println("세 수를 입력: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] arr= new int[3];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		Numarr na = new Numarr();
		for (int i = 0; i <arr.length; i++) {
			if (arr[i] == answer[i]) {
				strike = strike +1;
			}
			else if(arr[i] == answer[0] || arr[i] == answer[1] || arr[i] == answer[2] ) {
				ball = ball+1;
			}
		}
		if (strike == 3) {
			System.out.println("정답입니다!");
			na.menu();
		}
		else {
			System.out.println(strike + "스트라이크 "+ ball + "볼. 다시 해 보세요.");
			na.Pitch();
		}
	}
	
}
public class NumBaseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Numarr na = new Numarr();
		na.menu();
		
	}

}
