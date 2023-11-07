// 기본으로 내보내기
// default 키워드는 한 번만 사용 가능함 - 주의
export default 123
//즉 module1만 가져오고 아무 말 없으면 123을 가져오는 것이다.


//module1 내부의 다양한 변수들을 선언
export const str = 'hello';
export const fruits = ['🍎','🍓','🍅'];

export const hap = (i, j) => {
  return i+j;
}

//클래스도 선언할 수 있다
export class Sonata {
  constructor(){
    this.wheelNum = 4;
    this.speed = 30
  }
  speedUp = () => {
    this.speed = this.speed + 1;
  }
}
