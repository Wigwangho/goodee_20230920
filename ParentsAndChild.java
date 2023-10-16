class Aclass{

int i = 1;
  public void method(){
  
  System.out.println("method activated");
  }
}
class Bclass extends Aclass{//Aclass에 상속받아, 그것이 가진 변수와 메소드를 사용한다
  Bclass(){//생성자
  System.out.println(i);
  method();
  }
}

class ParentsAndChild(){
  
  public void main(String[] args){
    Bclass b = new Bclass();//생성자가 있으므로 B클래스 생성자 내부에 있는 변수와 메소드를 실행한다
    
  }
  
}
