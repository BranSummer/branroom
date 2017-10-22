/**
 * D:/JEE_workspace/branroom/src/main/resources/sql/branbase.sql
 * 
 * table user
 * 
 */
drop table if exists user;
create table user(
	userId varchar(255) not null primary key,
	password varchar(255) not null,
	gender tinyint(1) null default 0,
	avatar varchar(255) not null default 'default.png',
	permission varchar(63) default 'plain_user', 
	email varchar(255) null default ' ',
	introduction varchar(255) null default ' ' 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/**
 * initialize the table 'user'
 */
insert into user 
values
('admin','123456','0','gintaman.jpg','superadmin','123456@example.com','my world'),
('test01','123456','0','default.png','test_user','test@bran.com','test user');