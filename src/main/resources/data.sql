-- drop table if exists member cascade;
-- create table member;
--
-- alter table member add name varchar(255);
--
-- INSERT INTO member (name) VALUES ('이름1');
-- INSERT INTO member (name) VALUES ('이름2');
-- INSERT INTO member (name) VALUES ('이름3');
--
-- select * from member;
drop table if exists article cascade;
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목1', '내용1', now(), now());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목2', '내용2', now(), now());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목3', '내용3', now(), now());

drop table if exists book cascade;
INSERT INTO book (id, name, author) VALUES ('1', 'JAVA', 'author');
INSERT INTO book (id, name, author) VALUES ('2', 'name', 'author');
INSERT INTO book (id, name, author) VALUES ('3', 'name', 'author');

SELECT *
FROM users
WHERE email = #{email}