CREATE OR REPLACE PROCEDURE proc_emp_sa(p_empno IN NUMBER, msg OUT VARCHAR2)
IS
    ename VARCHAR2(30) := '';
    sal NUMBER(7) := 0;
    avg_sal NUMBER(10, 2) := 0;
    rate NUMBER(5, 2) := 0; -- 소수 자릿수 추가

BEGIN
    SELECT ename, sal INTO ename, sal
    FROM emp
    WHERE empno = p_empno;

    SELECT AVG(sal) INTO avg_sal
    FROM emp
    WHERE deptno = (SELECT deptno FROM emp WHERE empno = p_empno);

    IF sal > avg_sal THEN
        rate := 1.1;
    ELSE
        rate := 1.2;
    END IF;

    UPDATE emp
    SET sal = sal * rate
    WHERE empno = p_empno;

    msg := ename || ' 사원의 ' || sal || '급여가 ' || rate || '인상분으로 ' || sal * rate || '인상되었습니다.';

    COMMIT; -- 트랜잭션 완료
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK; -- 예외 발생 시 롤백 처리
        RAISE; -- 예외를 호출 측으로 전파
END;

-- 프로시저와 테이블 사용
