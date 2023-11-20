--컬럼명이 오는 자리에 함수를 중첩해서 사용할 수 있다.
--전체조회를 해야 답을 구할 수 있는 함수이다.
--검색속도가 느리다. - 일부 정보만 보고 결과를 말할 수  없다
--시간이 걸리더라도 전체 직원을 모두 검사해야 함

SELECT count(empno) FROM emp;

SELECT count(comm) FROM emp;

SELECT max(sal), min(sal) FROM emp;

--단일그룹함수가 아닙니다.

SELECT max(sal), min(sal), ename FROM emp;
