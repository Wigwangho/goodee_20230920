
import java.util.Scanner;
import java.util.Random;

class randomNumGame{
  //무작위 0-9 사이의 숫자를 맞춰보는 게임입니다.

	//인스턴스화할 때도 메소드와 동일하게 파라미터 갯수와 타입을 맞춰야 함.
	Scanner sc = new Scanner(System.in);
	//getfirst 메소드를 선언하여 사용자로부터 숫자를 입력받는 메소드를 구현해 보시오.
	public int getFirst() {
		// 유저로부터 숫자를 받는 메소드
		int num;
		System.out.println("원하는 숫자는?");
		num = sc.nextInt();
		return num;
		
		
		
	}
	public void getSecond(){
    //두 수를 유저로부터 받아 그 합을 받는 메소드
    //게임과는 관련없음
		System.out.println("두 숫자를 적어 주세요: ");
		int firstnum = sc.nextInt();
		int secnum = sc.nextInt();
		int answer = firstnum + secnum;
		System.out.println("두 수의 합은 " + answer + " 입니다.");

	}
	public void game() {
    //본 메소드
    //게임 시작 선언, 그에 필요한 클래스와 여러 가지 지역변수 선언 및 초기화
		System.out.println("게임 시작!");
		E e = new E();
		int num = e.getFirst();
		boolean win = false;
		Random random = new Random();
		int answer = random.nextInt(10);

    //deathCounter 변수가 5가 되면 게임 오버. 그때까지 게임 반복.
		for (int deathCounter = 0;deathCounter <5; deathCounter++) {
			
		if(answer>num) {
			System.out.println("숫자를 높이세요.");
			e.getFirst();
		
		}
		else if(answer<num) {
			System.out.println("숫자를 낮추세요.");
			e.getFirst();
			
			
		}
		else if(answer ==num) {
			System.out.println("정답입니다!");
			win = true;
      //중간에 정답을 맞출 경우 break 를 통해 for 문에서 빠져나오게 됨.
			break;
		}
		
	}
		if (win) {
			System.out.println("축하합니다! 게임에서 승리했습니다.");
		}
		else {
			System.out.println("게임 오버.");
		}
    //win 이라는 boolean 변수를 활용하여, 결과적으로 게임에서 승리했는지 여부 확인
}
public class Emain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	 E e = new E();
	 
	 e.game();
		
		
	}
