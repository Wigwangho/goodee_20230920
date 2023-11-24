SELECT
            workcd_vc, time_nu
           ,rank() over(order by time_nu) rnk
  FROM t_worktime;
  
SELECT rownum rno, workcd_vc, time_nu FROM t_worktime
WHERE rownum < 4;

--

SELECT
             *
   FROM (
                SELECT rownum rno, workcd_vc, time_nu FROM t_worktime
                WHERE rownum < 4   
             )a,
             (
             SELECT rownum rno, workcd_vc, time_nu FROM t_worktime
                WHERE rownum < 4
             )b;
             
             
SELECT
             a.workcd_vc, a.TIME_NU,  count(b.workcd_vc)
   FROM (
                SELECT rownum rno, workcd_vc, time_nu FROM t_worktime
                WHERE rownum < 4   
             )a,
             (
             SELECT rownum rno, workcd_vc, time_nu FROM t_worktime
                WHERE rownum < 4
             )b
 WHERE a.time_nu >= b.time_nu
 GROUP BY a.workcd_vc, a.time_nu;

--
