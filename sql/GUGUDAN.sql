create or replace procedure proc_gugudan(dan in number)
is
     n_i number(2);
begin
    n_i :=0;
    dbms_output.put_line(dan||'단을 출력합니다.');
    for n_i in 1..9 loop
       dbms_output.put_line(dan||'*'||n_i||'='||(dan*n_i));
    end loop; 
end;

-- 프로시저 - 함수와 유사한 기능이지만, 다르다.

begin

proc_gugudan(3)

end;

-- 이러면 3단을 출력한다
-- 함수와의 차이점: 프로시저는 return 예약어를 사용하지 않고 파라미터 자리에
--OUT속성을 추가하여 자바단으로 내보낼 수 있다.

-- SELECT ... INTO 변수 문을 지원한다. - 단 한개로우에 대해서만 가능하다
-- 만일 멀티 로우에 있는 값을 담으려면 반드시 cursor를 사용해야 한다.
