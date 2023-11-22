SELECT *
FROM (
SELECT emp_name,
CASE
WHEN salary <= 30000000 THEN 'D'
WHEN salary between 30000000 and 50000000 THEN 'C'
WHEN salary between 50000000 AND 70000000 THEN 'B'
WHEN salary > 70000000 THEN 'A'
END AS sal_lv
FROM temp
)
PIVOT (
count(emp_name)
FOR sal_lv IN ('A', 'B', 'C', 'D')
);

-- 연습문제: 연봉 수준에 따라 다른 문자를 반환한다.
-- 이때 피봇을 사용해 A급인 사람, B급인 사람... 각각 따로 반환한다.
