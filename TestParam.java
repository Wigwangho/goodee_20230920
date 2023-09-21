// 파라미터에 대해
class Param{
	int ival;// 전역변수는 초기화 생성이 가능하다(쌩성자가 대신 해 주므로)
	}
public class TestParam {

	void effectParam(Param p) {
		//1. p라는 변수명과 파라미터 값이 중복된다. 정상적으로 되지 않음
		//2. p가 아닌 p2로 전부 변경해 인스턴스화하면 해결 가능.
		//그런데 그럼 파라미터를 넣을 이유가 없다.
       p = new Param();
		p.ival = 100;
		System.out.println("sub ival >>"+p.ival);
	}

		public static void main(String[] args) {
		
			Param p = new Param();
		
			p.ival = 500;

			TestParam tp = new TestParam();
			tp.effectParam(p);
		
			System.out.println("main ival >>"+p.ival);


	}

}
/*
TestParam.java 하나의 문서 안에 두 개의 클래스가 존재한다.
TestParam.class 와 TestParam.class에는 오직 ival 변수 하나만 있는 상태. 그 디폴트 값은 0이다.
그런데 main 메소드는 TestParam에 있다. 즉, 모든 클래스가 main 메소드를 가질 필요는 없다.
단, main이 존재하는 class 는 TestParam 이므로 해당 클래스만 실행할 수 있다.
11번째 줄에서는 TestParam에 선언되지 않은 ival 변수를 사용하였다.
그러기 위해서는 반드시 인스턴스화를 해야만 함.
그런데 effectParam 메소드는 호출되지 않았다.

-> effectParam 메소드를 호출하기 위해 TestParam을 인스턴스화하였다.
*/
