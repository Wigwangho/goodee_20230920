CREATE OR REPLACE PROCEDURE proc_exception1
is
    n_i NUMBER(5);
BEGIN 
    n_i := 1;
    n_i := 0;
    n_i := TO_NUMBER('ㅇㅇ');
    
EXCEPTION
    WHEN VALUE_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('잘못된 데이터 값 에러');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('잘못된 숫자도, 데이터 값도 아님');
END;

BEGIN
    proc_exception1;
END;

-- n_i 의 현재 형태가 문자열인데, to_number를 사용하여 숫자라 볼 수 없다. value-error 오류 발생
