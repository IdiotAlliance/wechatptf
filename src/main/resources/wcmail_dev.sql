# Host: localhost  (Version: 5.1.52-community)
# Date: 2013-09-04 14:50:33
# Generator: MySQL-Front 5.3  (Build 4.9)

/*!40101 SET NAMES utf8 */;

#
# Source for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(40) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '密码',
  `mail` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='已验证用户';

#
# Data for table "user"
#


#
# Source for table "usertemp"
#

DROP TABLE IF EXISTS `usertemp`;
CREATE TABLE `usertemp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(40) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '密码',
  `mail` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='未验证用户';

#
# Data for table "usertemp"
#


#
# Source for table "verify"
#

DROP TABLE IF EXISTS `verify`;
CREATE TABLE `verify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(40) NOT NULL DEFAULT '' COMMENT '用户名',
  `account_md5` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名md5格式',
  `random_md5` varchar(32) NOT NULL DEFAULT '' COMMENT '随机数md5格式',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='待验证用户';

#
# Data for table "verify"
#

