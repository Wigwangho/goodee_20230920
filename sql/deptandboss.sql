    SELECT
              a.emp_id, a.emp_name, b.dept_code, b.dept_name
             ,c.dept_code as "상위부서코드"
             ,c.dept_name as "상위부서명"
             ,c.BOSS_ID as "상위부서장코드"
             ,d.EMP_NAME as "상위부서장명"
   FROM temp a, tdept b, tdept c, temp d   
 WHERE  a.dept_code = b.dept_code
     AND   b.parent_dept = c.dept_code
     AND   c.boss_id = d.emp_id
     AND  c.dept_code = 'CA0001'; 
