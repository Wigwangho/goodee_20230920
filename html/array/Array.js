/* 
Array -> 연관된 값들을 하나의 그룹으로 묶어 나열한 자료구조 -> map, set 등
자바와는 약간 차이가 있다
js에서는 array가 아주 쓸모있다!
*/

const colors = ["red", "blue", "green"]
console.log(colors);

//forEach 문이란??
//배열의 값 하나 하나를 ()안의 파라미터에 넣어주는 것
colors.forEach((color)=>{
  console.log(color);
  console.log(color[0]);
})
console.log(colors[0]);//r, b, g
console.log(colors[1]);//e, l, r
console.log(colors[2]);

//foreach 문과 map은 똑같은 기능인가?
//거의 동일한 기능을 한다
//forEach는 콜백함수를 인자로 받고 각 요소에 콜백함수를 실행시킨다. (반환X) 즉, 따로 반환하는 구문이 필요하다.
//map은 콜백함수를 인자로 받고 각 요소에 콜백함수를 실행시킨 새로운 배열을 반환한다.
colors.map((color)=>{
  console.log(color);
  console.log(color[0]);
})

const arr1 = ["a", "b", "c"]
let cnt = 0;
arr1.forEach(function(element){
  console.log(`element ===> ${element}`);
  cnt++
})
console.log(cnt);
//map도 똑같은대...?
cnt = 0;
arr1.map(function(element){
  console.log(`element ===> ${element}`);
  cnt++
})
console.log(cnt);

//프런트엔드에서 백엔드의 도움 없이 단독으로 테스트해 볼 수 있는 사람이 되려면..
const names =["나신입", "강감찬", "이순신"];
const copy = []
console.log(copy);

//얕은 복사 >> 원본 혹은 복사본을 변경할 경우, 모든 것이 변형되는 복사. 주소번지가 같다
//깊은 복사 >> 원본과 복사본이 완전히 독립적인 복사, 완전히 새로운 배열을 생성

for(let i =0 ;i<names.length;i++){
  copy.push(names[i]);
  console.log(`copy[${i}]:${copy[i]}`);
}
copy.push("나초보");
console.log(copy);
console.log(names);
//즉 copy와 names는 깊은 복사

names.forEach((copy) => {
  console.log(copy);
  //여기서는 얕은 복사?
});

