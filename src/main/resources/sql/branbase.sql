/**
 * table user
 */
drop table if exists user;
create table user(
	userId varchar(255) not null primary key,
	password varchar(255) not null,
	gender tinyint(1) not null,
	avatar varchar(255) not null default 'default.png',
	permission varchar(63) not null,
	email varchar(255) null,
	introduction varchar(255) null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/**
 * initialize the table 'user'
 */
insert into user 
values('admin','123456','0','gintaman.jpg','superadmin','123456@example.com','my world');