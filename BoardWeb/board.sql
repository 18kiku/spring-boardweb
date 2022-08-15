CREATE SEQUENCE board_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

CREATE SEQUENCE comment_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;
       
create table board(
board_id number primary key,
writer varchar2(30) not null,
title varchar2(100) not null,
content clob not null,
cnt number default 0,
create_date timestamp default sysdate,
update_date timestamp,
CONSTRAINT board_writer_fk FOREIGN KEY(writer)
REFERENCES member(member_id) on delete cascade
);

drop table board;

create table comments(
comment_id number primary key,
board_id number not null,
writer varchar2(30) not null,
comments clob not null,
create_date timestamp default sysdate,
update_date timestamp,
CONSTRAINT comments_writer_fk FOREIGN KEY(writer)
REFERENCES member(member_id) on delete cascade,
CONSTRAINT comments_board_id_fk FOREIGN KEY(board_id)
REFERENCES board(board_id) on delete cascade
);

/*
create or replace procedure boards
is
i number := 0;
begin
    loop
    insert into board(board_id, writer, title, content)
    values(board_seq.nextval, concat('id', i), concat('title', i), concat('content', i));
    i := i + 1;
    exit when i > 100;
    end loop;
end;
*/
/*
create or replace procedure commentss
is
i number := 0;
begin
    loop
    insert into comments(comment_id, board_id, writer, comments)
    values(comment_seq.nextval, 100, concat('id', i), concat('conmment', i));
    i := i + 1;
    exit when i > 20;
    end loop;
end;
*/
desc board;

select * from member;

update member set NAME = 'chiroru' where MEMBER_ID = 'bbb2222';
delete from member;
commit;
desc board;

insert into member(member_id, password, name, email) values('aaa1111', '1234', '치로루', 'chiroru@gmail.com');

delete from member where member_id like 'id%';

select * from member;

select * from member;

select * from (
    select b.*, row_number() over(order by board_id desc) as rnum from board b
    ) where rnum >= 101 and rnum <= 105;
    
select * from member;

select * from board;

select * from comments;


