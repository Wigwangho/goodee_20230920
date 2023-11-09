//구조분해할당
//1. 배열
const colors = ['red', 'green', 'blue']
//es5
const color1 = colors[0]
const color2 = colors[1]
const color3 = colors[2]
//es6 구조분해할당
const [c1, c2, c3] = colors;
console.log(c1+c2+c3);
//개꿀이네요..

//2.객체
const dept={
  deptno:10,
  dname:'개발부',
  loc:'서울'
}

const{deptno, dname, loc} = dept
//es5
console.log(dept.deptno);
console.log(dept['dname']);
//구조분해할당이 되었을 시
console.log(deptno);
console.log(dname);
console.log(loc);
