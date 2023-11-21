/*
 System Name    :  TEST                                        
 Entity Name    :  휴가이력                                   
 Table  Name    :  T_GIFTPOINT , T_GIFTMEM
 작성자         :  노정환 					
 작성일         :  2003.12.25                             
 내용           :   선물 받기
 비고	    :  
*/
CREATE TABLE T_GIFTPOINT
(
GIFTID_VC VARCHAR2(5) NOT NULL,
NAME_VC VARCHAR2(20) NOT NULL,
POINT_NU NUMBER NOT NULL
)

CREATE TABLE T_GIFTMEM
(
MEMCD_VC VARCHAR2(9) NOT NULL,
NAME_VC  VARCHAR2(20) NOT NULL,
POINT_NU NUMBER NOT NULL
)

INSERT INTO T_GIFTPOINT (GIFTID_VC,NAME_VC,POINT_NU) VALUES ('A0001','문화상품권',5000 );
INSERT INTO T_GIFTPOINT (GIFTID_VC,NAME_VC,POINT_NU) VALUES ('A0002','영화티켓',15000);
INSERT INTO T_GIFTPOINT (GIFTID_VC,NAME_VC,POINT_NU) VALUES ('A0003','구두상품권',60000);
INSERT INTO T_GIFTPOINT (GIFTID_VC,NAME_VC,POINT_NU) VALUES ('B0001','한과세트',50000);
INSERT INTO T_GIFTPOINT (GIFTID_VC,NAME_VC,POINT_NU) VALUES ('B0002','과일바구니',30000);
INSERT INTO T_GIFTPOINT (GIFTID_VC,NAME_VC,POINT_NU) VALUES ('B0003','과자종합',20000);
INSERT INTO T_GIFTMEM  (MEMCD_VC,NAME_VC,POINT_NU) VALUES (10,'노정환',40208);
INSERT INTO T_GIFTMEM  (MEMCD_VC,NAME_VC,POINT_NU) VALUES (13,'김현식',100205);
INSERT INTO T_GIFTMEM  (MEMCD_VC,NAME_VC,POINT_NU) VALUES (16,'김선우',80204);
INSERT INTO T_GIFTMEM  (MEMCD_VC,NAME_VC,POINT_NU) VALUES (19,'김유신',50012);
INSERT INTO T_GIFTMEM  (MEMCD_VC,NAME_VC,POINT_NU) VALUES (22,'이순신',8500);
COMMIT;

SELECT * FROM t_giftpoint;
SELECT * FROM t_giftmem;

--영화 티켓을 받을 수 있는 사람의 명단과 현재 가지고 있는 포인트, 영화 티켓의 포인트
--그리고 그 티켓을 사용한 후 남은 예상 포인트를 출력하시오.

SELECT name_vc, point_nu
FROM t_giftmem
WHERE (point_nu >= (SELECT point_nu FROM T_GIFTPOINT WHERE giftid_vc = 'A0002'));

SELECT name_vc, point_nu - (SELECT point_nu FROM T_GIFTPOINT WHERE giftid_vc = 'A0002') AS remained
FROM t_giftmem
WHERE (point_nu >= (SELECT point_nu FROM T_GIFTPOINT WHERE giftid_vc = 'A0002'));

--김유신씨가 보유하고 있는 마일리지 포인트로 얻을 수 있는 상품 중 가장 포인트가 높은 것은 무엇인가?
--김유신씨가 구매 가능한 상품들 정렬
--그 중 max

SELECT point_nu AS 구매가능
FROM T_GIFTPOINT 
WHERE point_nu < (SELECT point_nu FROM T_GIFTMEM WHERE memcd_vc = 19);

CREATE INDEX idx_point_nu ON T_GIFTPOINT (point_nu);
CREATE INDEX idx_memcd_vc ON T_GIFTMEM (memcd_vc);

SELECT gp.name_vc AS 물건명
FROM T_GIFTPOINT gp
WHERE gp.point_nu = (
SELECT MAX(gp.point_nu) AS 제일비싼거
FROM T_GIFTPOINT gp
JOIN T_GIFTMEM gm ON gp.point_nu <= (SELECT gm.point_nu FROM T_GIFTMEM gm WHERE gm.memcd_vc = 19 ));



WHERE gm.memcd_vc = 19;
SELECT max(point_nu) AS 제일비싼거
FROM T_GIFTPOINT 
WHERE point_nu <= (SELECT point_nu FROM T_GIFTMEM WHERE memcd_vc = 19);

