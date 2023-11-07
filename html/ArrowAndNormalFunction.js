funcname = (firstname, lastname) =>{
  return `${firstname} ${lastname}`;
}

//함수의 선언

let lastname = '나';
let firstname ='신입';
let fullname = `${lastname} ${firstname}`;

console.log(fullname);
console.log(funcname(firstname, lastname))
console.log(funcname2(firstname, lastname))
//arrow function을 사용하지 않았을 때의 function은 절차(순서)에 구애받지 않음

function funcname2 (firstname, lastname){
  return `${firstname} ${lastname}`;
}

lastname = '야';
firstname ='나두';
fullname = `${lastname} ${firstname}`;

console.log(fullname);

//일일히 let 붙여주고, 순서 바꾸고... 매우 귀찮다!
//같은 작업이 반복될수록 더더욱 귀찮아진다
//이럴 때 사용하는 것이 function

