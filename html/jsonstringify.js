const gildong = `{
  "name": "홍길동",
  "age": 25,
  "married": false,
  "family": { "father": "홍판서", "mother": "춘섬" },
  "hobbies": ["독서", "도술"],
  "jobs": null
}`

const obj = JSON.parse(gildong);
console.log(obj);
console.log(obj.age);
console.log(obj);
const gildongLong = JSON.stringify(gildong, null, 2);
console.log(gildongLong);
