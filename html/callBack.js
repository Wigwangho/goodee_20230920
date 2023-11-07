//일급 객체(first class object)
/*
일급 객체란 일반객체처럼 모든 연산이 가능한 것.
1. 함수의 매개변수로 전달 가능
2. 함수의 반환값으로 쓸 수 있음
3. 할당 명령문 사용 가능
4. 동일비교대상

일급함수는 코트린과 파이썬에서도 지원하며, 자바도 8부터 지원한다.
일급함수란? << 함수가 일반객체처럼 모든 연산이 가능한 것.
- 함수의 매개변수로 전달 가능함
- 함수의 반환값으로 쓸 수 있음
- 할당 명령문 사용 가능
- 동일비교대상

고차함수 High order function

- 인자로 함수를 받음(콜백함수)
-함수를 반환하는 함수
*/

//실습내용 - 콜백함수
//함수도 객체가 될 수 있다 - 일급 객체라고 말하기도 한다

const hap = (a,b) => a+b;
const minus = (a,b) =>a-b;
//파라미터 자리는 외부에서 결정된다.
//아래 함수에서 세 번째 파라미터는 함수. 
//이렇게 외부로 주어지는 함수를 콜백함수라 한다.

function account(a,b,action){
  if(a<0||b<0){//둘 중 하나라도 0보다 작으면 리턴하면서 함수를 빠져나감
    return;//action은 호출될 기회가 없다
  }
  
  let result = action(a,b);
  return result;
}
// 전달된 action(hap, minus)은 콜백함수다
//언제 호출될지 모르는 경우에도 콜백함수라 할 수 있다
//전달될 당시에 함수를 바로 호출해서 반환된 값을 전달(X)
//함수를 가리키고 있는 함수의 참조값이 전달된다(O)
console.log(account(1,2,hap));
console.log(account(1,2,minus));