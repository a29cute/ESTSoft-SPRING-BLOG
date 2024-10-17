drop table if exists member cascade;
create table member;

alter table member add name varchar(255);

INSERT INTO member (name) VALUES ('이름1');
INSERT INTO member (name) VALUES ('이름2');
INSERT INTO member (name) VALUES ('이름3');

select * from member;

INSERT INTO article (title, content, created_at, update_at)
VALUES
('제목1', '내용1', now(), now()),
('제목2', '내용2', now(), now()),
('제목3', '내용3', now(), now());
