/**
 * D:/JEE_workspace/branroom/src/main/resources/sql/branbase.sql
 * 
 * table user
 * 
 */


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `posttime` datetime NOT NULL,
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `author` (`author`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`author`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `gender` tinyint(1) DEFAULT '0',
  `avatar` varchar(255) NOT NULL DEFAULT 'default.png',
  `permission` varchar(63) DEFAULT 'plain_user' COMMENT '权限',
  `email` varchar(255) DEFAULT ' ',
  `introduction` varchar(255) DEFAULT ' ',
  `salt` varchar(255) DEFAULT NULL COMMENT '盐',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for watch
-- ----------------------------
DROP TABLE IF EXISTS `watch`;
CREATE TABLE `watch` (
  `userId` varchar(255) NOT NULL,
  `wuser` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`,`wuser`),
  KEY `wuser` (`wuser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
