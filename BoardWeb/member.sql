create table member(
member_id varchar2(30) primary key,
password varchar2(30) not null,
name varchar2(30) not null,
email varchar2(50) not null,
create_date timestamp default sysdate,
update_date timestamp
);
drop table member;

alter table member modify email varchar2(50);

commit;

select * from member;


create or replace procedure members
is
i number := 0;
begin
    loop
    insert into member(member_id, password, name, email)
    values(concat('id', i), '1234', concat('name', i), concat('email', i));
    i := i + 1;
    exit when i > 100;
    end loop;
end;