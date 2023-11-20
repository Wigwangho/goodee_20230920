--1. 월급을 홀수 달에는 연봉의 1/18, 짝수 달에는 연봉의 1/9 를 받음

SELECT SALARY/18 FROM TEMP;
SELECT (salary/18)*2 FROM temp;

--2. 월급에 교통비 10만언 추가, 짝수 달에는 두 배로 줌
SELECT SALARY/18+100000 FROM TEMP;
SELECT (salary/18+100000)*2 FROM temp;

--3. 취미 란이 공란이 아닌 직원
SELECT EMP_NAME, HOBBY  FROM TEMP WHERE HOBBY IS NOT NULL;

--4. 취미 란이 공란인 직원(취미없음)
SELECT EMP_NAME, HOBBY  FROM TEMP WHERE HOBBY IS NULL;

--5. 취미가 등산인 직원의 취미 란을 공란으로
UPDATE TEMP SET HOBBY = null WHERE HOBBY IS '등산';
SELECT hobby FROM temp;

--6. as -> 이름 새로 붙여서 데이터 보이기
SELECT emp_id AS "사번", emp_name AS "사원명" FROM TEMP;

-- 데이터 오름차순, 내림차순 정렬
SELECT * FROM temp ORDER BY LEV ASC, emp_id DESC; 

SELECT emp_name, hobby FROM TEMP WHERE HOBBY = '등산';
