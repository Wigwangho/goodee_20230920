//호이스팅이란 블록 안에서 선언된 지역변수가 코드 블록 밖으로 끌어올려지면서 강제로 전역변수화되는 현상이다.
//변수를 let으로 설정해 회피하기

//즉시실행함수를 사용해, 괄호로 가두고 파라미터로는 i를 받지만 가두어진 파라미터 자리에는 index 변수를 사용
//호이스팅이 발동하는 변수 i를 아닌 index 값(외부의 영향을 받지 않는)을 사용하게 된다
const btns = document.querySelectorAll("ul li")
console.log(typeof btns);
console.log(btns.length);

//아래 변수의 형태가 var 일 경우, 호이스팅 이슈가 발생한다
for(let i =0; i<btns.length;i++){
  btns[i].addEventListener('click', (event)=>{
    console.log(event.target);
    console.log(i);
  })
}
