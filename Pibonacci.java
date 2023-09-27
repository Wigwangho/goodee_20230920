
class PibNumArray{
	public void Pib(int maxNum) {//피보나치 수열을 계산하고 출력하는 메소드
		
		int[] answerArr = new int[maxNum];
		answerArr[0] = 0;
		if(maxNum>1) {//maxNum 이 1일 때 발생하는 배열 크기 초과 오류 방지용
		answerArr[1] = 1;
		for (int i = 2; i<maxNum; i++) {
			answerArr[i] = answerArr[i-1]+answerArr[i-2];
			
		}
		
		}
		for (int j = 0; j<maxNum; j++) {
			System.out.println(answerArr[j]);
		}
		
	}
}
public class Pibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PibNumArray pna = new PibNumArray();
		pna.Pib(3);
	}

}
