const a = document.querySelector('a');

console.dir(a);

a.onclick = () =>{
  console.log('링크 클릭');
}

a.onclick= () =>{
  console.log('링크 클릭 다시');
}

a.addEventListener('click', ()=>{
  console.log('you click');
})

a.addEventListener('click', ()=>{
  console.log('you click again');
})

//두 번째부터는 두 번째 클릭 이벤트가 계속 반복됨
