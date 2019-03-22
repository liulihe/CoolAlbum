/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : coolalbum

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-03-22 20:51:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `f_id` int(16) NOT NULL AUTO_INCREMENT,
  `f_memberid` int(16) DEFAULT NULL,
  `f_friendacct` varchar(32) DEFAULT NULL,
  `f_friendid` int(16) DEFAULT NULL,
  `f_namedfriend` varchar(32) DEFAULT '',
  `f_isblack` char(1) DEFAULT '0',
  PRIMARY KEY (`f_id`),
  KEY `fk_memberid` (`f_memberid`),
  KEY `fk_friendid` (`f_friendid`),
  CONSTRAINT `fk_friendid` FOREIGN KEY (`f_friendid`) REFERENCES `member` (`m_id`),
  CONSTRAINT `fk_memberid` FOREIGN KEY (`f_memberid`) REFERENCES `member` (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `m_id` int(16) NOT NULL AUTO_INCREMENT,
  `m_accountname` varchar(16) NOT NULL,
  `m_nickname` varchar(16) DEFAULT NULL,
  `m_password` varchar(64) DEFAULT NULL,
  `m_email` varchar(40) DEFAULT NULL,
  `m_phone` varchar(16) DEFAULT NULL,
  `m_createtime` varchar(64) DEFAULT NULL,
  `m_signature` varchar(127) DEFAULT NULL,
  `m_status` char(1) DEFAULT '0',
  PRIMARY KEY (`m_id`),
  UNIQUE KEY `in_1` (`m_accountname`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `m_id` varchar(256) NOT NULL,
  `m_message_receiver_id` int(16) DEFAULT NULL,
  `m_sponsor` varchar(16) DEFAULT NULL,
  `m_content` varchar(10000) DEFAULT NULL,
  `m_createtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for message_reply
-- ----------------------------
DROP TABLE IF EXISTS `message_reply`;
CREATE TABLE `message_reply` (
  `m_id` varchar(256) NOT NULL,
  `m_sponsor_acct` varchar(16) DEFAULT NULL,
  `m_receiver_acct` varchar(16) DEFAULT NULL,
  `m_reply_content` varchar(10000) DEFAULT NULL,
  `m_reply_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `m_reply_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `m_reply_referto` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `p_id` int(16) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(63) DEFAULT NULL,
  `p_createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `p_moditytime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `p_url` varchar(127) DEFAULT NULL,
  `p_description` varchar(1023) DEFAULT NULL,
  `p_likenum` int(16) DEFAULT NULL,
  `p_clicklike_memberid` varchar(127) DEFAULT NULL,
  `p_type_id` int(16) DEFAULT NULL,
  `p_member_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  KEY `fk_type_id` (`p_type_id`),
  KEY `fk_member_id` (`p_member_id`),
  CONSTRAINT `fk_member_id` FOREIGN KEY (`p_member_id`) REFERENCES `member` (`m_id`),
  CONSTRAINT `fk_type_id` FOREIGN KEY (`p_type_id`) REFERENCES `phototype` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=853 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for phototype
-- ----------------------------
DROP TABLE IF EXISTS `phototype`;
CREATE TABLE `phototype` (
  `p_id` int(16) NOT NULL AUTO_INCREMENT,
  `p_typename` varchar(16) DEFAULT NULL,
  `p_member_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  KEY `fjlsj` (`p_member_id`),
  CONSTRAINT `fjlsj` FOREIGN KEY (`p_member_id`) REFERENCES `member` (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(16) NOT NULL AUTO_INCREMENT,
  `u_accountname` varchar(16) NOT NULL,
  `u_nickname` varchar(16) DEFAULT NULL,
  `u_password` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
