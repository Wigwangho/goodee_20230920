--사원테이블에서 job이 clerk인 사람의 급여 합,  salesman인 사람의
--급여의 합을 구하고 나머지 job에 대해서는 기타 합으로 구하시오.

SELECT *
FROM EMP;

SELECT sum(sal) AS clerksal, null AS salesal
FROM EMP e
WHERE e.JOB = 'CLERK'
UNION
SELECT null AS clerksal, sum(SAL) AS salesal
FROM EMP e
WHERE e.JOB = 'SALESMAN';

SELECT 
    SUM(CASE WHEN JOB = 'CLERK' THEN sal ELSE 0 END) AS 점원급여총합,
    SUM(CASE WHEN JOB = 'SALESMAN' THEN sal ELSE 0 END) AS 영업급여총합,
    SUM(CASE WHEN JOB NOT IN ('CLERK', 'SALESMAN') THEN sal ELSE 0 END) AS 기타급여총합
FROM EMP;

--실전문제 : 로우에 있는 이름을 컬럼 레벨에 나는 출력할 수 있다

SELECT * FROM EMP;
SELECT * 
FROM (
    SELECT ENAME, EMPNO, JOB
    FROM EMP
)
PIVOT(
    MAX(ENAME) FOR DEPTNO IN (10, 20, 30)
);

SELECT *
FROM (
    SELECT DEPTNO, ENAME
    FROM EMP
)
PIVOT (
    MAX(SAL) FOR ENAME IN (*)
);

-- 아직 해결 못핢
