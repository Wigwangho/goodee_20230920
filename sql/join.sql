-- 1:n 관계로 join 이 가능한 관계

SELECT
             dept.dname, emp.deptno, dept.deptno
  FROM emp, dept
 WHERE emp.deptno = dept.deptno;
  
SELECT
             dept.dname, emp.deptno, dept.deptno
  FROM emp, dept;  
  
