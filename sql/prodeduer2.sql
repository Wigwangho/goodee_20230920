create or replace procedure proc_account1(p_examno in varchar2, msg out varchar2)
is
--수험생이 입력한 1번 답안
    u1 number(1):=0;
--수험생이 입력한 2번 답안    
    u2 number(1):=0;
--수험생이 입력한 3번 답안    
    u3 number(1):=0;
--수험생이 입력한 4번 답안    
    u4 number(1):=0;
--수험생이 맞춘 정답 수를 담음    
    r1 number(3):=0;
--수험생이 틀린 수를 담음        
    w1 number(3):=0;
    jdap number(2):=0;--커서에서 꺼낸값담기
    d_no number(3):=1;--문제번호를 담기
-- 괄호 안 숫자는 당연하지만 바이트 크기이다
-- 여기서 각 변수들을 초기화함
    cursor dap_cur is
      
    select dap from sw_design;
-- 다른 테이블에서 가져온 후 커서 선언
--커서란 특정 SQL 문장을 처리한 결과를 담고있는 메모리 영역을 가리키는 일종의 포인터
begin
    open dap_cur;
--커서 불러오기
    SELECT  dap1, dap2, dap3, dap4 INTO u1, u2, u3, u4
      FROM exam_paper
     where exam_no  = p_examno;
    loop
        fetch dap_cur into jdap;
        exit when dap_cur%notfound;
        if d_no=1 then
          --1번 문제
            if jdap = u1 then
                r1 := r1 +1;
            else
                w1 := w1 + 1;
            end if;
        elsif d_no=2 then
            if jdap = u2 then
                r1 := r1 +1;
            else
                w1 := w1 + 1;
            end if;     
        elsif d_no=3 then
            if jdap = u3 then
                r1 := r1 +1;
            else
                w1 := w1 + 1;
            end if;   
        elsif d_no=4 then
            if jdap = u4 then
                r1 := r1 +1;
            else
               w1 := w1 + 1;
            end if;                                          
        end if;        
        d_no := d_no + 1;
    end loop;
    close dap_cur;
    msg :='정답 : '||r1|| ' 오답 : '||w1;
    update exam_paper
          set right_answer = r1,
                 wrong_answer = w1
    where exam_no = p_examno;
    commit;
end;
