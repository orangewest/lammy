/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : lammy

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-30 16:45:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lammy_notepad
-- ----------------------------
DROP TABLE IF EXISTS `lammy_notepad`;
CREATE TABLE `lammy_notepad` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) COMMENT '用户id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `state` varchar(255) DEFAULT NULL COMMENT '当前状态（0：未完成1:已完成）',
  `is_remind` varchar(255) DEFAULT NULL COMMENT '是否提醒',
  `complete_time` varchar(255) DEFAULT NULL COMMENT '完成时间',
  `remind_time` varchar(255) DEFAULT NULL COMMENT '提醒时间',
  `created_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `is_delete` bigint(4) DEFAULT NULL COMMENT '删除标志（0:未删除1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lammy_notepad
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `created_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `is_delete` bigint(4) DEFAULT NULL COMMENT '删除标志（0:未删除1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10', 'admin', 'admin', '2018-01-29 16:10:44', '2018-01-29 16:10:44', '0');
