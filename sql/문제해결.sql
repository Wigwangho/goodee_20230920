

문제1:사원번호가 7500번 이상인 사원들의 이름과 입사일자 급여를
출력하시오.

컬럼명 :  ename, hiredate, sal
조건절 :  where, having(GROUP BY)
집합명 : emp

SELECT
              ename, hiredate, sal
   FROM emp
  WHERE empno >= 7500;

문제2:입사한 년도가 1981년인 사원들의 사번을 출력하시오.

hiredate
XXX인것 - 조건절 - decode, case when
empno

SELECT
               empno
    FROM emp
  WHERE hiredate = to_date(1981, 'YYYY') ;
  
  SELECT
               hiredate, to_date(1981, 'YYYY')
              ,to_date(1981, 'YYYY')-1
    FROM emp;
  
SELECT
               empno,to_char(hiredate,'YYYY')
    FROM emp
  WHERE '1981' = to_char(hiredate, 'YYYY') ;
  
-- 선분조건 -  range scan - 구간검색  
  
문제3:사원의 이름이 A로 시작되는 사원들의 사원번호를 
출력하시오.  

SELECT empno
  FROM emp
 WHERE ename LIKE 'A%';
 
 
 SELECT empno, ename
  FROM emp
 WHERE ename LIKE :x||'%';

SELECT empno, ename
  FROM emp
 WHERE Substring(ename, 1, 1) = 'A';
 
 
 문제4:입사일자가 1981년 2월1일 에서 1981년 6월30일사이에 
있는 사원들의 사번과 명단을 출력하시오  

SELECT sal
  FROM emp
 WHERE sal BETWEEN 1000 AND 2000;
 
SELECT sal
  FROM emp
 WHERE sal >= 1000
     AND  sal  <= 2000;
 
SELECT empno, ename, hiredate
  FROM emp
 WHERE hiredate BETWEEN '1981-02-01' AND '1981-06-30'; 

문제5:급여가 1000불보다 크거나 같고 3000불보다 작거나 같은
직원들의 이름과 급여를 출력하시오. 

SELECT ename, sal
  FROM emp
 WHERE sal BETWEEN 1000 AND 3000;
 
--구간검색에서 크거나 같다 작거나 같다 둘다  만족해야 한다.
--교집합 - INTERSECT

SELECT deptno FROM emp
INTERSECT 
SELECT deptno FROM dept; 
 
SELECT ename, sal
  FROM emp
 WHERE sal >= 1000
     AND  sal  <= 3000;
     
문제6:급여가 3000불이 아닌 사원들의 사번과 이름을 출력하시오.   

SELECT
             empno, ename
  FROM emp;
  
SELECT
             empno, ename
  FROM emp
 WHERE sal != 3000;  
 
 --검증하는 개발자들
 
 SELECT
             empno, ename, sal
  FROM emp
 WHERE sal != 3000;  

-- 아닌 걸 찾을 때도 색인을 사용할 수 있나요?
--인덱스만 읽고도 조회가 된다??
--인덱스관리하는 테이블이 있다.
--인덱스키 + rowid

--힌트문에 대해서 
--힌트문에 오타가 있으면 무시된다. - 원래 실행계획대로 검색해준다
--RDBMS가 세운 실행계획보다 개발자가 세운 실행계획이 옳다 라고 판단될때
--옵티마이저에게 내 생각을 전달할 수 있는 유일한 방법이다.

--인덱스
--pk가 아닌 일반컬럼도 인덱스 가질 수  있다.
--일반컬럼에 인덱스를 생성할 때도 DDL구문을 사용한다.
--인덱스가 있어도 조건에 사용되지 않으면 실행계획에 반영되지 않는다???


SELECT ename
   FROM emp;
   
SELECT /*+index_desc555(emp pk_emp) */ empno,ename
   FROM emp;   
   --힌트문: 내림차순으로 정렬(emp 테이블의 인덱스 기준)
 SELECT /*+ Rule333 */
              emp.empno, dept.dname
    FROM emp, dept
  WHERE emp.deptno = dept.deptno; 
  
SELECT empno
   FROM emp;  
   
SELECT empno, ename
   FROM emp;     
   
SELECT empno, ename
   FROM emp
  WHERE empno = 7566;   
  
  SELECT empno, ename
   FROM emp
  WHERE ename = 'SMITH'; 
  
CREATE index i_ename ON emp(ename asc);  

SELECT empno
   FROM emp;

SELECT ename
   FROM emp;
   
SELECT ename
   FROM emp
  WHERE ename='SMITH';   

SELECT ename
   FROM emp
  WHERE ename='';   
  
SELECT ename
   FROM emp
  WHERE ename=' ';     
  
SELECT empno, ename
   FROM emp
  WHERE empno != 7566;     
  
 SELECT /*+rule */ empno, ename
   FROM emp
  WHERE empno = 7566;    
  
SELECT ename, hiredate
   FROM emp
  WHERE ename !='SMITH';     
  
  
문제7:사원들의 부서별 급여평균을 구하시오. 

평균 : avg

SELECT sal FROM emp;  

SELECT sum(sal), count(sal), count(comm), avg(sal) 
  FROM emp;  
  
SELECT deptno, avg(sal) 
  FROM emp;    
 
--문법적인 문제만 해결하는 사람 
  
SELECT min(deptno), avg(sal) 
  FROM emp;      
 
--저기 min의미가 있는 값인가요? 
-- 그룹함수를 사용해서 문법적인 문제는 피할 수 있지만 그 결과는 의미없더라
-- 의미있는 결과를 보고 싶은거라면 group by절을 추가한다면 유의미한 정보를 출력할 수 있다.
SELECT max(deptno), avg(sal) 
  FROM emp;      
  
SELECT deptno, avg(sal) 
  FROM emp
GROUP BY deptno;  

-- 서브쿼리에 대해서....
-- 직접적인 조건이 아니라 간접조건을 주고 원하는 결과를 찾아달라고 할 때이면....
--위치인데
--from절에 select문이면 인라인뷰(테이블자리)
-- 인라인뷰에 사용한 컬럼명은 별칭이더라도 주쿼리에 사용이 가능함
--조건절에 select문이면 서브쿼리(값)

SELECT words_vc
   FROM t_letitbe

SELECT words_vc
   FROM t_letitbe
 WHERE words_vc LIKE 'Let%';
 
 SELECT DECODE(MOD(seq_vc,2),0, words_vc) A
   FROM t_letitbe;
   
 SELECT DECODE(MOD(seq_vc,2),0, words_vc) A
   FROM t_letitbe
  WHERE A LIKE 'Let%';   
  

SELECT
            A
  FROM (
                  SELECT DECODE(MOD(seq_vc,2),1, words_vc) A
                   FROM t_letitbe
             ) 
  WHERE A LIKE 'Let%';                
  
  

1.temp에서 연봉이 가장 많은 직원의 row를 찾아서 이 금액과 동일한 금액을
받는 직원의 사번과 성명을 출력하시오.

SELECT MAX(salary) FROM temp;

SELECT MAX(salary), emp_name FROM temp;


SELECT emp_id, emp_name FROM temp
WHERE salary = 100000000;


SELECT emp_id, emp_name FROM temp
WHERE salary = (SELECT문)


SELECT emp_id, emp_name FROM temp
WHERE salary = (SELECT MAX(salary) FROM temp);


--2.temp의 자료를 이용하여 salary의 평균을 구하고 이보다 큰 금액을 salary로 
--받는 직원의 사번과 성명, 연봉을 보여주시오.

SELECT emp_id, emp_name, salary FROM temp;

SELECT avg(salary) FROM temp;

SELECT emp_id, emp_name, salary FROM temp
WHERE salary > 43800000;

SELECT emp_id, emp_name, salary FROM temp
WHERE salary > (SELECT avg(salary) FROM temp);

3.temp의 직원 중 인천에 근무하는 직원의 사번과 성명을 읽어오는 SQL을 서브
쿼리를 이용해 만들어보시오.

SELECT * FROM tdept;

SELECT dept_code FROM tdept WHERE area = '인천';

SELECT ename, deptno FROM emp
WHERE deptno IN(10,20);

SELECT emp_id, emp_name FROM temp
WHERE dept_code IN(SELECT dept_code FROM tdept WHERE area = '인천');

4.tcom에 연봉 외에 커미션을 받는 직원의 사번이 보관되어 있다.
이 정보를 서브쿼리로 select하여 부서 명칭별로 커미션을 받는
인원수를 세는 문장을 만들어 보시오.

SELECT emp_id FROM temp
INTERSECT
SELECT emp_id FROM tcom;

SELECT
             b.dept_name
  FROM temp a, tdept b
 WHERE a.dept_code = b.dept_code;
 
SELECT
             b.dept_name
  FROM temp a, tdept b
 WHERE a.dept_code = b.dept_code
      AND a.emp_id IN(SELECT emp_id FROM tcom);
      
      SELECT
             b.dept_name, count(a.emp_id)
  FROM temp a, tdept b
 WHERE a.dept_code = b.dept_code
      AND a.emp_id IN(SELECT emp_id FROM tcom)
GROUP BY b.dept_name; 

도전문제 -  이전레코드 참조하기

SELECT * FROM test02;

SELECT rownum org_no, cdate, crate, amt FROM test02;

SELECT rownum copy_no, cdate, crate, amt FROM test02;

SELECT
              *
   FROM (
                SELECT rownum org_no, cdate, crate, amt FROM test02
              )a,
              (
                SELECT rownum copy_no, cdate, crate, amt FROM test02            
              )b;       
              

SELECT
              *
   FROM (
                SELECT rownum org_no, cdate, crate, amt FROM test02
              )a,
              (
                SELECT rownum copy_no, cdate, crate, amt FROM test02            
              )b
 WHERE a.org_no-1 = b.copy_no;              
 
 
 SELECT
              a.CDATE, a.amt, b.crate
             , a.AMT*b.crate as "한화금액"
   FROM (
                SELECT rownum org_no, cdate, crate, amt FROM test02
              )a,
              (
                SELECT rownum copy_no, cdate, crate, amt FROM test02            
              )b
 WHERE a.org_no-1 = b.copy_no;     
 
  SELECT
              a.CDATE, a.amt, b.crate
             , to_char((a.AMT*b.crate), '9,999,999,999')||'원' as "한화금액"
   FROM (
                SELECT rownum org_no, cdate, crate, amt FROM test02
              )a,
              (
                SELECT rownum copy_no, cdate, crate, amt FROM test02            
              )b
 WHERE a.org_no-1 = b.copy_no;     
 
 
--소계 및 총계 구하기

 -- 총계라는 셀을 추가한다
 --총계 위에는 날짜가 있다.
 --없는 셀을 어떻게 만들지?
 --데이터를 복제하자 - 2배수로 복제한다
 --한 번은 날짜별로 계산되어야 하고 또 다른 한번은 총계를 구하는데 쓴다
 -- 숫자가 1번이면 날짜별 계산에서 사용하고 2번이면 총계를 계산할 떄 쓴다
 
 SELECT 1 rno FROM dual
 UNION  ALL
 SELECT 2 FROM dual;
 
 로우 수를 줄인다. 
 컬럼은 줄일 수 있다.
 
 --rownum은 조회 결과에 대해서 순차적으로 번호를 매겨준다
 --크다 비교 안된다
 --작거나 같은만 된다
 --1과 같다 라고 조건을 붙이면 하나만 읽어서 출력된다. - stop key
 --판정을 할 수 있는 경우 일 테니까 부분범위처리가 가능하다.
 -- 아이디를 중복검사하는데 만명 중에서 100번째 아이디가 존재하는걸 확인하였다.
 --그렇다면 이 아이디는 사용이 불가하다 판정이 가능함
 --101번째 아이디와는 더 이상 비교할 필요가 없다???왜냐면 회원가입할때마다 아이디 중복검사를 했으니까
 --단 2로 비교는 불가하다 1만된다.
 
 
 
 
 SELECT rownum rno FROM dept
 WHERE rownum  =2;
 
 SELECT indate_vc FROM t_orderbasket;
 
  SELECT indate_vc FROM t_orderbasket
  GROUP BY indate_vc;
 
  SELECT indate_vc, min(qty_nu) FROM t_orderbasket
  GROUP BY indate_vc;
 
SELECT ename FROM emp
GROUP BY ename;

SELECT deptno FROM emp
GROUP BY deptno;

  SELECT indate_vc FROM t_orderbasket
  GROUP BY indate_vc
  UNION ALL
  SELECT '총계' FROM dual;
  
  54 건이 108건이 되었다.
  54개는 날짜별 계산에 사용되지만 나머지 54개는 총계 하나로 묶는다
  
   SELECT indate_vc FROM t_orderbasket,
   (SELECT rownum rno FROM dept WHERE rownum <3); 
   
   SELECT decode(b.rno,1, indate_vc,2,'총계') FROM t_orderbasket,
   (SELECT rownum rno FROM dept WHERE rownum <3) b;    
   
     SELECT decode(b.rno,1, indate_vc,2,'총계') FROM t_orderbasket,
   (SELECT rownum rno FROM dept WHERE rownum <3) b
   GROUP BY  decode(b.rno,1, indate_vc,2,'총계') ;
   
      SELECT decode(b.rno,1, indate_vc,2,'총계'), sum(qty_nu) FROM t_orderbasket,
   (SELECT rownum rno FROM dept WHERE rownum <3) b
   GROUP BY  decode(b.rno,1, indate_vc,2,'총계') ;  
   
      SELECT decode(b.rno,1, indate_vc,2,'총계'), sum(qty_nu) ||'EA' as "판매수량" FROM t_orderbasket,
   (SELECT rownum rno FROM dept WHERE rownum <3) b
   GROUP BY  decode(b.rno,1, indate_vc,2,'총계') ;     
   
      SELECT decode(b.rno,1, indate_vc,2,'총계')
                 , sum(qty_nu) ||'EA' as "판매수량" 
         FROM t_orderbasket,
                   (SELECT rownum rno FROM dept 
                     WHERE rownum <3) b
               GROUP BY  decode(b.rno,1, indate_vc,2,'총계') ;    
               
      SELECT decode(b.rno,1, indate_vc,2,'총계') as "판매날짜"
                 , sum(qty_nu) ||'EA' as "판매수량" 
         FROM t_orderbasket,
                   (SELECT rownum rno FROM dept 
                     WHERE rownum <3) b
               GROUP BY  decode(b.rno,1, indate_vc,2,'총계') 
            ORDER BY  decode(b.rno,1, indate_vc,2,'총계') ;    
            
      SELECT decode(b.rno,1, indate_vc,2,'총계') as "판매날짜"
                 , sum(qty_nu) ||'EA' as "판매수량" 
                 ,sum(qty_nu*price_nu) as "판매금액"
         FROM t_orderbasket,
                   (SELECT rownum rno FROM dept 
                     WHERE rownum <3) b
               GROUP BY  decode(b.rno,1, indate_vc,2,'총계') 
            ORDER BY  decode(b.rno,1, indate_vc,2,'총계') ;   
            

SELECT decode(b.rno,1, indate_vc,2,'총계', 3, '소계') 
            , decode(b.rno,3, gubun_vc||'계', 1, gubun_vc)
  FROM t_orderbasket,
             (SELECT rownum rno FROM dept 
               WHERE rownum <4) b
GROUP BY  decode(b.rno,1, indate_vc,2,'총계', 3,'소계')
                   ,decode(b.rno,3, gubun_vc||'계', 1, gubun_vc)
ORDER BY decode(b.rno,1, indate_vc,2,'총계', 3, '소계') ;

SELECT decode(b.rno,1, indate_vc,2,'총계', 3, '소계')  as "판매날짜"
            , decode(b.rno,3, gubun_vc||'계', 1, gubun_vc) as "물품구분"
            , sum(qty_nu) as "판매갯수"
  FROM t_orderbasket,
             (SELECT rownum rno FROM dept 
               WHERE rownum <4) b
GROUP BY  decode(b.rno,1, indate_vc,2,'총계', 3,'소계')
                   ,decode(b.rno,3, gubun_vc||'계', 1, gubun_vc)
ORDER BY decode(b.rno,1, indate_vc,2,'총계', 3, '소계') ;


SELECT decode(b.rno,1, indate_vc,2,'총계', 3, '소계')  as "판매날짜"
            , decode(b.rno,3, gubun_vc||'계', 1, gubun_vc) as "물품구분"
            , sum(qty_nu) as "판매갯수"
            , sum(qty_nu*price_nu) as "판매가격"
  FROM t_orderbasket,
             (SELECT rownum rno FROM dept 
               WHERE rownum <4) b
GROUP BY  decode(b.rno,1, indate_vc,2,'총계', 3,'소계')
                   ,decode(b.rno,3, gubun_vc||'계', 1, gubun_vc)
ORDER BY decode(b.rno,1, indate_vc,2,'총계', 3, '소계') ;

SELECT ename
  FROM emp;
  
SELECT ename
  FROM emp
GROUP BY ename;  

SELECT deptno
  FROM emp
GROUP BY deptno;  

SELECT deptno, ename
  FROM emp
GROUP BY deptno, ename;  

n: n은 조인걸면 망한다
1:1, 1:n 은 조인을 걸어도 된다
업무에 대한 정의가 덜 된 경우이므로 DBA가서 확인할것

학생과 과목
수강신청 - 행위엔티티라고 한다.교차엔티티

조인

natural join

self join

outer join

non-equal join


SELECT
      sum(decode(job,'CLERK',sal)) clerk_sal
     ,sum(decode(job,'SALESMAN',sal)) salesman_sal
     ,sum(decode(job, 'CLERK', null, 'SALESMAN', null, sal)) etc
  FROM scott.emp a, scott.dept b
 WHERE a.deptno = b.deptno  
       
 
SELECT 
      nvl(decode(b.no, '1', dname), '총계') dname
     ,sum(clerk) clerk
     ,sum(manager) manager
     ,sum(etc) etc
     ,sum(dept_sal) dept_sal
  FROM (
        SELECT bb.dname, clerk, manager, etc, dept_sal
          FROM (
                SELECT deptno
                      ,sum(decode(job, 'CLERK', sal)) clerk
                      ,sum(decode(job, 'MANAGER', sal)) manager
                      ,sum(decode(job, 'CLERK', null, 'MANAGER', null, sal)) etc
                      ,sum(sal) dept_sal 
                 FROM emp a
                GROUP BY deptno
               )aa, dept bb
         WHERE aa.deptno = bb.deptno  
       )a,
       (SELECT '1' no FROM dual
        union all
        SELECT '2' FROM dual 
       )b     
       GROUP BY decode(b.no, '1', dname)
ORDER BY dname 


-- 가능하다면 테이블은 한 번만 읽어서 처리한다
--경우의 수줄인다 ->  인라인뷰 또는 Group by 
--조인을 하기 전에 미리 먼저 그룹핑을 한다(14건이 3건으로 줄어듦)
--그룹핑을 하면서 그룹함수가 필요한 부분(sum(decode패턴))이 있다면 같이 해도 된다.
-- 대용량데이터베이스 키워드가 들어간 책
--541~551 -> 한번씩만 테이블 읽었다

--왜 조인을 했나?
--부서번호가 아니라 부서명을 출력하는 것이 직관적이니까
--553~556 : 더미집합 사용함 - 데이터 복제하기 - 카타시안곱 - 2배수로 복제함

SELECT deptno FROM dept
MINUS
SELECT deptno FROM emp;

SELECT deptno
                      ,sum(decode(job, 'CLERK', sal)) clerk
                      ,sum(decode(job, 'MANAGER', sal)) manager
                      ,sum(decode(job, 'CLERK', null, 'MANAGER', null, sal)) etc
                      ,sum(sal) dept_sal 
                 FROM emp a
                GROUP BY deptno
                
총계를 넣고 싶은데 보니까 deptno이다. - 타입이 number이다  - 그래서 총계 못넣는다
총계 부분을 따로 계산하여 합집합으로 처리하면 같은 집합은 두번 읽게 된다.


GROUP BY 하기전에 먼저 조인한다.

decode(dommy.rno,1, dname, 2,'총계')
지금 조인이 먼저 이다                

        SELECT bb.dname, clerk, manager, etc, dept_sal
          FROM (
                SELECT deptno
                      ,sum(decode(job, 'CLERK', sal)) clerk
                      ,sum(decode(job, 'MANAGER', sal)) manager
                      ,sum(decode(job, 'CLERK', null, 'MANAGER', null, sal)) etc
                      ,sum(sal) dept_sal 
                 FROM emp a
                GROUP BY deptno
               )aa, dept bb
         WHERE aa.deptno = bb.deptno  
         
-- 14건을 3건으로
--부서명 얻기 위해 조인을 선택
-- GROUP BY decode(b.no, '1', dname)        


SELECT 
decode(b.no,1, a.dname, 2,'총계'),
     clerk
     ,manager
     ,etc
     ,dept_sal
  FROM (
        SELECT bb.dname, clerk, manager, etc, dept_sal
          FROM (
                SELECT deptno
                      ,sum(decode(job, 'CLERK', sal)) clerk
                      ,sum(decode(job, 'MANAGER', sal)) manager
                      ,sum(decode(job, 'CLERK', null, 'MANAGER', null, sal)) etc
                      ,sum(sal) dept_sal 
                 FROM emp a
                GROUP BY deptno
               )aa, dept bb
         WHERE aa.deptno = bb.deptno  
       )a,
       (SELECT '1' no FROM dual
        union all
        SELECT '2' FROM dual 
       )b   

SELECT 
decode(b.no,1, a.dname, 2,'총계')
  FROM (
        SELECT bb.dname, clerk, manager, etc, dept_sal
          FROM (
                SELECT deptno
                      ,sum(decode(job, 'CLERK', sal)) clerk
                      ,sum(decode(job, 'MANAGER', sal)) manager
                      ,sum(decode(job, 'CLERK', null, 'MANAGER', null, sal)) etc
                      ,sum(sal) dept_sal 
                 FROM emp a
                GROUP BY deptno
               )aa, dept bb
         WHERE aa.deptno = bb.deptno  
       )a,
       (SELECT '1' no FROM dual
        union all
        SELECT '2' FROM dual 
       )b   
GROUP BY  decode(b.no,1, a.dname, 2,'총계')     

SELECT decode(b.no,1, a.dname, 2,'총계'),     
     sum(clerk) clerk
     ,sum(manager) manager
     ,sum(etc) etc
     ,sum(dept_sal) dept_sal
  FROM (
        SELECT bb.dname, clerk, manager, etc, dept_sal
          FROM (
                SELECT deptno
                      ,sum(decode(job, 'CLERK', sal)) clerk
                      ,sum(decode(job, 'MANAGER', sal)) manager
                      ,sum(decode(job, 'CLERK', null, 'MANAGER', null, sal)) etc
                      ,sum(sal) dept_sal 
                 FROM emp a
                GROUP BY deptno
               )aa, dept bb
         WHERE aa.deptno = bb.deptno  
       )a,
       (SELECT '1' no FROM dual
        union all
        SELECT '2' FROM dual 
       )b     
       GROUP BY  decode(b.no,1, a.dname, 2,'총계')     
