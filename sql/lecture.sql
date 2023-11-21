CREATE TABLE LECTURE (LEC_ID VARCHAR2(05),LEC_TIME NUMBER,LEC_POINT NUMBER);
INSERT INTO LECTURE VALUES('L0001',3,3);
INSERT INTO LECTURE VALUES('L0002',3,2);
INSERT INTO LECTURE VALUES('L0003',2,3);
INSERT INTO LECTURE VALUES('L0004',2,2);
INSERT INTO LECTURE VALUES('L0005',3,1);
COMMIT;

SELECT * FROM lecture;

SELECT lec_id, decode(lec_time, lec_point, '일반과목')
FROM lecture;

-- 문제 2. 주당강의시간과 학점이 같은 강의의 숫자를 알고 싶다.
-- 쿼리문을 작성하십시오

SELECT count(decode(lec_time, lec_point, 1))
FROM lecture;

-- 문제 3. 강의시간이 학점보다 크면 실험과목을 리턴 받고싶다

SELECT decode(sign(lec_time, lec_point), 0, '일반과목', 1, '실험과목', -1, '기타과목') AS lect
FROM lecture;

SELECT
    lec_id,
    DECODE(SIGN(lec_time - lec_point),
           0, '일반과목',
           1, '실험과목',
          -1, '기타과목'
    ) AS lect
FROM lecture;

