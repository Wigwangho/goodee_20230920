//전개 연산자 ... >> spread operator
//이것을 사용하여 배열을 복사하면 깊은 복사이다

let dept ={
  deptno: 10,
  dname: '총무부',
  loc:'부산'
  
}

let emp ={

  empno: 7566,
  ename:'강감찬'
}

let depts =[
  {deptno:10, dname:'총무부', loc:'부산'},
  {deptno:20, dname:'개발부', loc:'서울'},
  {deptno:30, dname:'인사부', loc:'인천'}
]

let depts2 = [...depts, {deptno:40, dname:'경영부', loc:'제주'}]
console.log(depts2[3]);
let dept3 = [...depts2, {deptno:50}]
console.log(dept3[4]);
depts.forEach(dept=>console.log(dept));
depts.forEach((dept, index)=>{
  if(index ===1){
    console.log(dept);
    console.log(dept.dname);
    console.log(dept['loc']);
  }
})
//spread 연산자는 해당 배열의 모든 값을 총괄해 더하는 것을 뜻한다.

depts.map(dept=>console.log(dept));
depts.map((dept, index)=>{
  if(index ===1){
    console.log(dept);
    console.log(dept.dname);
    console.log(dept['loc']);
  }
})
depts.map((dept, index, arr)=>{
 
    console.log(dept);
    console.log(index);
    console.log(arr);
  })

let newObject = {...dept, ...emp}
console.log(newObject);
const names =["나신입", "강감찬", "이순신"];
const names2 = [...names, "나초보"];
const names3 = ["나신입", "강감찬", "이순신"];
console.log(names2);
console.log(names);
console.log(names == names2);
console.log(names ===names2);
console.log(names == names3);
console.log(names === names3);
