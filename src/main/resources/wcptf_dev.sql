# Host: localhost  (Version: 5.1.52-community)
# Date: 2013-09-04 14:50:41
# Generator: MySQL-Front 5.3  (Build 4.9)

/*!40101 SET NAMES utf8 */;

#
# Source for table "activity"
#

DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weiid` varchar(32) NOT NULL DEFAULT '' COMMENT '活动发起者微信号',
  `companyid` int(11) NOT NULL DEFAULT '0' COMMENT '商品所属商家id',
  `type` int(5) NOT NULL DEFAULT '0' COMMENT '相关的商品种类，0普通商品，1团购',
  `goodsid` int(11) NOT NULL DEFAULT '0' COMMENT '相对应的普通商品或团购等的id',
  `time` varchar(14) NOT NULL DEFAULT '' COMMENT '发起活动时间戳',
  `brief` varchar(64) NOT NULL DEFAULT '' COMMENT '活动简介',
  `detail` text NOT NULL COMMENT '活动详细信息',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '活动发起者名字',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '活动密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `link` (`weiid`,`type`,`goodsid`,`time`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='发起活动';

#
# Data for table "activity"
#


#
# Source for table "company"
#

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(40) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
  `address` text NOT NULL COMMENT '地址',
  `weiid` varchar(32) NOT NULL DEFAULT '' COMMENT '微信号',
  `director` varchar(255) NOT NULL DEFAULT '' COMMENT '负责人',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '电话',
  `description` text NOT NULL COMMENT '简介',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业';

#
# Data for table "company"
#


#
# Source for table "member"
#

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weiid` varchar(32) NOT NULL DEFAULT '' COMMENT '微信号',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `gender` int(2) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `address` text COMMENT '住址',
  `mail` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `points` int(11) NOT NULL DEFAULT '0' COMMENT '积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='会员';

#
# Data for table "member"
#


#
# Source for table "member_company"
#

DROP TABLE IF EXISTS `member_company`;
CREATE TABLE `member_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) NOT NULL DEFAULT '0' COMMENT '会员id',
  `weiid` varchar(32) NOT NULL DEFAULT '' COMMENT '微信号',
  `companyid` int(11) NOT NULL DEFAULT '0' COMMENT '商家id',
  `points` int(11) NOT NULL DEFAULT '0' COMMENT '会员在该商家的积分',
  PRIMARY KEY (`id`),
  UNIQUE KEY `weiid_companyid` (`weiid`,`companyid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='会员商家对应关系';

#
# Data for table "member_company"
#


#
# Source for table "product"
#

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) NOT NULL DEFAULT '0' COMMENT '所属商家',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
  `price` double NOT NULL DEFAULT '0' COMMENT '价格',
  `description` text NOT NULL COMMENT '简介',
  `cover` varchar(255) DEFAULT '' COMMENT '封面图片存放路径',
  `start_date` date NOT NULL DEFAULT '0000-00-00' COMMENT '开始日期',
  `end_date` date NOT NULL DEFAULT '0000-00-00' COMMENT '结束日期',
  `point` int(11) NOT NULL DEFAULT '0' COMMENT '积分',
  `stock` int(11) NOT NULL DEFAULT '0' COMMENT '库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品';

#
# Data for table "product"
#


#
# Source for table "product_picture"
#

DROP TABLE IF EXISTS `product_picture`;
CREATE TABLE `product_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) NOT NULL DEFAULT '0' COMMENT '商品id',
  `picture` varchar(255) NOT NULL DEFAULT '' COMMENT '图片存放路径',
  PRIMARY KEY (`id`),
  KEY `productid` (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商品拥有的图片';

#
# Data for table "product_picture"
#


#
# Source for table "product_type"
#

DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) NOT NULL DEFAULT '0' COMMENT '商品id',
  `typeid` int(11) NOT NULL DEFAULT '0' COMMENT '类型id',
  PRIMARY KEY (`id`),
  KEY `productid` (`productid`),
  KEY `typeid` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商品所属类型';

#
# Data for table "product_type"
#


#
# Source for table "signup"
#

DROP TABLE IF EXISTS `signup`;
CREATE TABLE `signup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activityid` int(11) NOT NULL DEFAULT '0' COMMENT '报名的活动id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='报名活动';

#
# Data for table "signup"
#


#
# Source for table "type"
#

DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '类型名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品类型';

#
# Data for table "type"
#

INSERT INTO `type` VALUES (4,'Food'),(5,'Snack');
