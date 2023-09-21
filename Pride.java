//getter 와 setter 메소드에 대해

class Pride{
	private int Speed;
	private String carName;
	private int Excel;
	public int getSpeed() {//getter: 전역변수에 담긴 값을 꺼내 사용
		return Speed;
	}
	public void setSpeed(int Speed) {//setter: 전역변수가 private이기 때문에 메소드의 파라미터 자리를 활용하여 변수 설정.
		//메소드의 파라미터 자리를 활용하여, 사용자 및 업무 담당자가 그 값을 전역변수에 초기화해 줌
		this.Speed = Speed;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getExcel() {
		return Excel;
	}
	public void setExcel(int excel) {
		Excel = excel;
	}
	
	
}
public class PrideSimulation {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pride myCar    	= new Pride();//30km/h
		Pride yourCar 	= new Pride();//50km/h
		Pride hisCar    	= new Pride();//100km/h
		
		myCar.setSpeed(30);
		System.out.println(myCar.getSpeed());
		//1. 결과값에 엑셀 값을 더한다.
		
		int excel = 30;
		System.out.println(myCar.getSpeed()+excel);
		//2. 자동차의 종류별로 다른 엑셀값을 부여할 수 있다.
		
		myCar.setExcel(30);
		yourCar.setExcel(40);
		hisCar.setExcel(20);
		System.out.println("엑셀을 밟았을 때 속도는 "+(myCar.getSpeed()+myCar.getExcel())+" 입니다.");

		
	}

}
