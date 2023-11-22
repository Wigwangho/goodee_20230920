SELECT d.dname, e.deptno, e.job, SUM(e.sal) AS total_salary
FROM emp e
JOIN dept d ON d.deptno = e.deptno
GROUP BY d.dname, e.deptno, e.job;

--emp 테이블과 dept 테이블을 조인한다.
--이때 fk는 deptno이다.
--부서명과 부서번호, 직업명을 바탕으로 해당 직책의 봉급 합을 구한다.
