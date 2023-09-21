//private 변수에 대해 접근하는 방법

package com.step2;
//클래스 안에 여러 가지의 변수를 담을 수 있다
public class Dept {
  private int deptno =0;//부서 번호
  private String dname =null;//부서 명
  private String loc=null;// 부서 위치. 근무 지역
//저장, 기록하기 코드
  public void setDeptno(int deptno){
    this.deptno = deptno;


  }
  public void setDname(String dname){
  this.dname = dname;
}

public void setloc(String loc){
  this.loc = loc;
}
//read 읽어오기

public int getDeptno(){
  return deptno;
}
public String getDname(){

  return dname;
}
public String getLoc(){

  return loc;
}
}
