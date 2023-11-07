import number, {str, fruits, Sonata} from "./module1.js"
// {str, fruits, Sonata, hap} - 구조분해할당
//모듈1 자바스크립트 파일로부터 모든 const들을 가지고 왔다
console.log(number);//123. number 따로 없으므로 default 인 123을 가져온다.
console.log(str);//'hello'
console.log(fruits);//이모지들을 가져온다
console.log(fruits.length);
const myCar = new Sonata()
console.log(myCar.speed);
myCar.speedUp()//함수 이름 뒤에 괄호가 있어야 호출이다
console.log(myCar.carColor);
//자바에서는 전변을 반드시 선언하고 this.머시기 사용해야 하는데
//자스에서는 생략이 가능함 - 선언없이 this가 붙으면 전변임
console.log(myCar.wheelNum);
