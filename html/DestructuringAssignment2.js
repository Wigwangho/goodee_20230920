//배열 -> filter -> 얕은 복사 or 깊은 복사
const words = ['spray', 'elite', 'exuberant', 'destruction', 'present'];
// -> filter는 다른 여러 객체에서도 재사용할 수 있는 프로토타입으로 설계되었다.
//filter 함수는 리턴 타입이 배열이다. 그런데 깊은 복사 -> 새로운 배열이 나온다(주소번지 동일X)
const result = words.filter((word) => word.length > 6);
console.log(typeof result);
words.push('abcdefg')
console.log(words);
//filter 프로토타입의 리턴 타입은 깊은 복사이다
console.log(result);
// Expected output: Array ["exuberant", "destruction", "present"]

const [r1, r2, r3] = result;
console.log(r1);
console.log(r2);
console.log(r3);
//구조분해의 할당이란 객체에 들어 있는 변수를 지정함으로서 한 줄에 초기화를 끝낼 수 있다
//구조분해할당 -> react -> props

//구조분해할당이 없다면?
const a1 = result[0];
const a2 = result[1];
const a3 = result[2];
const arr = {a1, a2, a3};
console.log(arr);
