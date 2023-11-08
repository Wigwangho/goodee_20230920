first =(param)=>{
  console.log("1");
  param();
}

second =()=>{
  console.log("2");
}
first(second);
//콜백함수란: 매개변수로 함수를 갖게 되는 함수를 뜻함
