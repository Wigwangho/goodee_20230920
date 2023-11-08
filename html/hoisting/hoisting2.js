const btns = document.querySelectorAll("ul li")
console.log(typeof btns);
console.log(btns.length);

for(var i =0; i<btns.length;i++){
  ((index) =>{
  btns[index].addEventListener('click', (event)=>{
        console.log(index);
  })
})(i);
}

//let으로 설정하는 변수가 없었을 때에는 호이스팅 이유를 위와 같은 방식으로 회피하엿다.
//함수 내부에서만 사용되는 변수 index를 이용하는 방법임. 이러면 html 버튼을 클릭했을 때 원하는 대로 숫자가 나온다.
//호이스팅 이슈 발생할 경우 -> var 전역변수화되어, 계속 3으로 고정됨
