select 
    emp.ename,
    DEPT.DNAME
from 
    emp
join dept on
    DEPT.DEPTNO = emp.deptno;
--inner join

select 
    emp.ename,
    DEPT.dname
from 
    dept
left join emp on
    DEPT.DEPTNO = emp.deptno;

--left join
--부서 중 사람이 없는 부서는 ename 이 null 로 나온
--full join - 사람 없는 부서, 부서 없는 사람 다 나온
