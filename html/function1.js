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
