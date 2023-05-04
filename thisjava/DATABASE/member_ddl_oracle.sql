create table member (
	memberid varchar2(20) primary key,
	name varchar2(20) not null,
	phone varchar2(20) unique,
	age number(3)
);

insert into member values ('user1', '홍길동', null, 30);

select * from member;
