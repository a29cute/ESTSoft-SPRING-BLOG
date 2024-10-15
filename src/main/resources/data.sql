drop table if exists member cascade;
create table member;

alter table member add name varchar(255);

INSERT INTO member (name) VALUES ('이름1');
INSERT INTO member (name) VALUES ('이름2');
INSERT INTO member (name) VALUES ('이름3');

select * from member;

