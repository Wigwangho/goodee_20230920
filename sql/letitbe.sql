/*
 System Name    :  TEST                                        
 Entity Name    :   날짜                                  
 Table  Name    : T_LETIRBE
 작성자         :  노정환 					
 작성일         :  2003.08.11                             
 내용            :  홀수만 짝수만, 영문가사만 보기 , 한글 가사만 보기
 비고	     :  
*/

CREATE TABLE T_LETITBE
(
SEQ_VC VARCHAR2(2),
WORDS_VC VARCHAR2(100)
)

INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (1,'Let it be');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (2,'내버려 두어라');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (3,'When I find myself in times of trouble');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (4,'내가 괴로움의 시간에서 방황할 때면 ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (5,'Mother Mary comes to me Speaking words of wisdom,');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (6,'어머니는 내게 다가와 현명한 말씀을 해주신다. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (7,'Let it be ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (8,'내버려 두어라.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (9,'And in my hour of darkness ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (10,'그리고 내가 어둠속에 헤매일 때, ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (11,'She is standing right in front of me Speaking words of wisdom,');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (12,'그녀는 내 바로 앞에서, 현명한 말씀을 해주신다. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (13,'Let it be. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (14,'내버려 두어라.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (15,'And when the broken hearted people Living in the world agree, There will be an answer, ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (16,'이 세상의 상처받은 사람들은 이 말씀이 방법이 될 거라 믿는다. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (17,'Let it be ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (18,'내버려 두어라.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (19,'For though they may be parted ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (20,'그들이 헤어지더라도 여전히 그들이 만날 기회는 있을것이다. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (21,'There is still a chance that they will see, There will be an answer,');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (22,'방법은 있을 것이다.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (23,'let it be ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (24,'내버려 두어라.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (25,'And the night is cloudy, there is still a light that shines on me.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (26,'구름이 낀 밤에도, 아직 날 비추어주는 빛이 있어. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (27,'Shine until tomorrow, let it be.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (28,'희망은 계속될 것이다.내버려 두어라. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (29,'I wake up to the sound of music,');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (30,'음악 소리에 난 깨어나고, ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (31,'Mother Mary comes to me,Speaking words of whisdom,');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (32,'어머니 메어리는 내게 다가와,현명한 말씀을 해 주신다. ');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (33,'Let it be.');
INSERT INTO T_LETITBE (SEQ_VC,WORDS_VC) VALUES (34,'내버려 두어라. ');
COMMIT;

-- 한글, 영어 각각 출력하기
SELECT Words_Vc AS kor FROM t_letitbe WHERE MOD(seq_vc, 2) = 0
SELECT words_vc AS eng FROM t_letitbe WHERE MOD(seq_vc, 2) = 1


SELECT Words_Vc 
FROM t_letitbe 
WHERE MOD(seq_vc, 2) = 0

UNION

SELECT Words_Vc 
FROM t_letitbe 
WHERE MOD(seq_vc, 2) = 1;

--한글~ 영어 합쳐서. 번갈아 X.

--이하는 똥고쇼의 흔적

SELECT Words_Vc 
FROM t_letitbe 


CREATE TABLE new_table_name (
    kor VARCHAR(255),
    eng VARCHAR(255)
);

INSERT INTO new_table_name (kor, eng)
SELECT
    t1.Words_Vc AS kor,
    t2.Words_Vc AS eng
FROM
    (SELECT Words_Vc, ROW_NUMBER() OVER (ORDER BY seq_vc) AS rn FROM t_letitbe WHERE MOD(seq_vc, 2) = 0) t1
JOIN
    (SELECT Words_Vc, ROW_NUMBER() OVER (ORDER BY seq_vc) AS rn FROM t_letitbe WHERE MOD(seq_vc, 2) = 1) t2
ON t1.rn = t2.rn;
SELECT * FROM NEW_TABLE_NAME ;

-- 번갈아가면서 나타나게 하는 것은 실패
-- 하지만 decode 문의 힘을 쓴다면 어떨까


SELECT
            DECODE(MOD(seq_vc,2),1,  words_vc, '0') eng_words
  FROM t_letitbe;


SELECT
            DECODE(MOD(seq_vc,2),1,  words_vc) eng_words
  FROM t_letitbe
 WHERE eng_words = 1;
 
-- 별칭을 굳이 조건절에서 사용하고 싶다면 인라인뷰를 사용하시오.
 
SELECT
                eng_words
  FROM (
                SELECT
                            DECODE(MOD(seq_vc,2),1,  words_vc) eng_words
                  FROM t_letitbe  
             );
--별칭 eng_words 에 영어 가사만 출력

SELECT
                num, eng_words
  FROM (
                SELECT MOD(seq_vc,2) num
                            ,DECODE(MOD(seq_vc,2),1,  words_vc) eng_words
                  FROM t_letitbe  
             )
WHERE num = 1;

             );


SELECT
                num, KOR_words
  FROM (
                SELECT MOD(seq_vc,2) num
                            ,DECODE(MOD(seq_vc,2),0,  words_vc) KOR_words
                  FROM t_letitbe  
             )
WHERE num = 0;
--한글 가사만 출력

SELECT
            DECODE(MOD(seq_vc,2),1,  words_vc, 0, WORDS_VC) engKOR_words
  FROM t_letitbe;

-- 합쳐서 각각 번갈아 출력
-- 순서(숫자)가 짝수인 경우와 홀수인 경우 각각 순서대로 출력함
-- 사실 select* from t_letitbe와 다를 거 없는 듯...

