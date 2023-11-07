//파라미터, 매개변수, 인자
//public static void main(String[] args)<<args == argument
//파라미터 기본값은 undefined 이다
function hap(a,b){
  console.log(arguments);
  console.log(arguments[0])//1
  console.log(arguments[2])//null
  return a+b+arguments[2];//<<이런거 하지마!!!!!
  //불필요한 side effect의 원인이 될 수 있다
}

hap(1,2,3);//6
console.log(hap(1,2,3))//6
hap(1,2,null);//3
console.log(hap(1,2))//undefined 더해져서 오류남



//매개변수의 기본값을 부여할 수 있다 >> js 에서만 가능
function hap1(a=2, b=3){
  return a+b;
}

console.log(hap1());//따로 호출할 때 매개변수를 주지 않으면 5가 찍힌다
console.log(hap1(3,4))

//rest parameters
//매개변수가 여러개여도 가능한 것
function sum(... numbers){
  console.log(numbers);
}

sum(1,3,5,7,9)

function sum2(x, y, ... numbers){
  console.log(x);
  console.log(y);
  console.log(numbers);//array 로 나올 것
}

sum2(1,3,4,5,6)
