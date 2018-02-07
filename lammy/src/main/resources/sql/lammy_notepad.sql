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

-- ----------------------------
-- Table structure for lammy_gauging
-- ----------------------------
DROP TABLE IF EXISTS `lammy_gauging`;
CREATE TABLE `lammy_gauging` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `send_person` varchar(255) DEFAULT NULL COMMENT '送样人',
  `sample_name` varchar(255) DEFAULT NULL,
  `gauging_no` varchar(255) DEFAULT NULL,
  `gauging_date` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `SiO2` varchar(255) DEFAULT NULL,
  `Fe2O3` varchar(255) DEFAULT NULL,
  `Al2O3` varchar(255) DEFAULT NULL,
  `CaO` varchar(255) DEFAULT NULL,
  `MgO` varchar(255) DEFAULT NULL,
  `Cd` varchar(255) DEFAULT NULL,
  `Pb` varchar(255) DEFAULT NULL,
  `H2O` varchar(255) DEFAULT NULL,
  `XRD` varchar(255) DEFAULT NULL,
  `SSA` varchar(255) DEFAULT NULL,
  `pH` varchar(255) DEFAULT NULL,
  `minus_Twoμm` varchar(255) DEFAULT NULL COMMENT '-2μm',
  `whiteness` varchar(255) DEFAULT NULL COMMENT '白度',
  `IL` varchar(255) DEFAULT NULL,
  `suspensibility` varchar(255) DEFAULT NULL COMMENT '悬浮度/mL',
  `adsorbed` varchar(255) DEFAULT NULL COMMENT '胶质价ml/15g',
  `bentonites` varchar(255) DEFAULT NULL COMMENT '膨胀容ml/g',
  `viscosity` varchar(255) DEFAULT NULL COMMENT '粘度',
  `methylene_blue` varchar(255) DEFAULT NULL COMMENT '吸蓝量',
  `oil_absorption` varchar(255) DEFAULT NULL COMMENT '吸油量g/100g',
  `created_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `is_delete` bigint(4) DEFAULT NULL COMMENT '删除标志（0:未删除1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
