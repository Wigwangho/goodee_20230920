xport default 123

export const str = 'hello';
export const fruits = ['🍎','🍓','🍅'];

export const hap = (i, j) => {
  return i+j;
}

export class Sonata {
  constructor(){
    this.wheelNum = 4;
    this.speed = 30
  }
  speedUp = () => {
    this.speed = this.speed + 1;
  }
}

//모듈 -> 다른 js에서 사용이 가능하도록 export 해 놓음
