// 함수는 하나의 데이터 이다.
const getNumber = function(){
  return 123;
}
const getNumber2 = () => {
  return 5;
}

console.log(typeof getNumber);//Function출력
console.log(typeof getNumber());//number출력
console.log(typeof getNumber2());//number출력

//자바스크립트에서의 function은 객체와 동일하므로, console.log를 통해 return 값을 출력할 수 있다.
