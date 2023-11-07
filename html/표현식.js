//함수 선언문 function name(){}
//함수 표현식 const name = function(){} - 익명함수(익명 클래스)
//익명함수는 외부에서 사용이 불가함

let hap = function(a,b){
  return a+b;
}
hap = (a,b) => a+b;//위 함수와 다른 점은?

//arrow function을 이용할 경우 return을 생략할 수 있다
//리액트에 자주 출몰하는 유형a

console.log(hap(1,2));

//imedicately invoke function expression - IIFE
//정의되자마자 즉시 실행되는 함수
(function run(){
  console.log('run');
})();


let hap2 = function sum(a,b){
  return a+b;
}

console.log(hap2(1,2));
console.log(sum(1,2));//위에있잔아...

//변수에 함수를 할당하여 표현하는 경우
//변수에 이름을 지어주어도 외부에서 사용하는 건 불가능하다
//쓰지마세요...
