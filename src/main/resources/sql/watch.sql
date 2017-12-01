
/**
 * D:/JEE_workspace/branroom/src/main/resources/sql/watch.sql
 */

drop table if exists watch;
create table watch(
	userId varchar(255) not null,
	wuser varchar(255) not null,
	PRIMARY KEY(userId,wuser),
	FOREIGN KEY(userId) REFERENCES user(userId),
	FOREIGN KEY(wuser) REFERENCES user(userId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;