
/**
 * D:/JEE_workspace/branroom/src/main/resources/sql/blog.sql
 */

/**
 * drop table if exists blog;
 */

create table if not exists blog(
	id int auto_increment primary key,
	title varchar(255) not null,
	author varchar(255) not null,
	content text not null,
	posttime datetime not null,
	foreign key(author) references user(userid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table if not exists blogtime(
	id int not null,
	firsttime datetime not null,
	lasttime datetime not null,
	foreign key(id) references blog(id)
)ENGINE=InniDB DEFAULT CHARSET=utf8;