create or replace trigger trg_deptcopy
after
insert or update or delete  on dept
for each row
begin
    if inserting then
        insert into dept_copy(deptno, dname, loc)
        values(:new.deptno, :new.dname, :new.loc);
--삽입햏ㅆ을 때 발생하는 현상
--dept_copy 테이블(백업) 또한 동일하게 행동한다
    elsif updating then
        update dept_copy
        set dname = :new.dname, loc = :new.loc
        where deptno = :old.deptno;
-- 업데이트했을 때 발생하는 현상
    elsif deleting then
        delete from dept_copy
        where deptno = :old.deptno;
    end if;
end;
-- 삭제했을 때 발생하는 현상
​
-- 데이터 복제 트리거 적용 여부 확인하기
​
insert into dept(deptno, dname,loc) values(70,'전산과','서울');
​
select * from dept_copy where deptno = 70;
​
update dept set loc='포항' where deptno = 70;
​
delete from dept where deptno = 70;
​
