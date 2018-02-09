/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : lammy

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-02-09 13:51:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lammy_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `lammy_dictionary`;
CREATE TABLE `lammy_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_code` varchar(255) DEFAULT NULL,
  `dict_name` varchar(255) DEFAULT NULL,
  `dict_type` varchar(255) DEFAULT NULL,
  `created_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '删除标志（0:未删除1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lammy_dictionary
-- ----------------------------
INSERT INTO `lammy_dictionary` VALUES ('1', 'rt001', '一般试剂（固体）', 'reagent_type', null, null, '0');
INSERT INTO `lammy_dictionary` VALUES ('2', 'rt002', '一般试剂（液体）', 'reagent_type', null, null, '0');
INSERT INTO `lammy_dictionary` VALUES ('3', 'rt003', '指示剂、基准试剂', 'reagent_type', null, null, '0');
INSERT INTO `lammy_dictionary` VALUES ('4', 'rt004', '强酸及有毒试剂（液体）', 'reagent_type', null, null, '0');
INSERT INTO `lammy_dictionary` VALUES ('5', 'qn001', '瓶', 'quantity_unit', null, null, '0');
INSERT INTO `lammy_dictionary` VALUES ('6', 'qn002', '包', 'quantity_unit', null, null, '0');
INSERT INTO `lammy_dictionary` VALUES ('7', 'qn003', '支', 'quantity_unit', null, null, '0');

-- ----------------------------
-- Table structure for lammy_dictionary_type
-- ----------------------------
DROP TABLE IF EXISTS `lammy_dictionary_type`;
CREATE TABLE `lammy_dictionary_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_code` varchar(255) DEFAULT NULL COMMENT '类型编码',
  `type_name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `created_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '删除标志（0:未删除1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lammy_dictionary_type
-- ----------------------------
INSERT INTO `lammy_dictionary_type` VALUES ('1', 'reagent_type', '试剂类型', null, null, '0');
INSERT INTO `lammy_dictionary_type` VALUES ('2', 'quantity_unit', '数量单位', null, null, '0');

-- ----------------------------
-- Table structure for lammy_gauging
-- ----------------------------
DROP TABLE IF EXISTS `lammy_gauging`;
CREATE TABLE `lammy_gauging` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `send_person` varchar(255) DEFAULT NULL COMMENT '送样人',
  `sample_name` varchar(255) DEFAULT NULL,
  `gauging_no` varchar(255) DEFAULT NULL,
  `gauging_no_order` int(11) DEFAULT NULL,
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
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '删除标志（0:未删除1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lammy_gauging
-- ----------------------------

-- ----------------------------
-- Table structure for lammy_notepad
-- ----------------------------
DROP TABLE IF EXISTS `lammy_notepad`;
CREATE TABLE `lammy_notepad` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `state` varchar(255) DEFAULT NULL COMMENT '当前状态（0：未完成1:已完成）',
  `is_remind` varchar(255) DEFAULT NULL COMMENT '是否提醒',
  `complete_time` varchar(255) DEFAULT NULL COMMENT '完成时间',
  `remind_time` varchar(255) DEFAULT NULL COMMENT '提醒时间',
  `created_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '删除标志（0:未删除1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lammy_notepad
-- ----------------------------

-- ----------------------------
-- Table structure for lammy_reagent
-- ----------------------------
DROP TABLE IF EXISTS `lammy_reagent`;
CREATE TABLE `lammy_reagent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reagent_name` varchar(255) DEFAULT NULL COMMENT '试剂名称',
  `standard` varchar(255) DEFAULT NULL COMMENT '规格',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `stock` varchar(255) DEFAULT NULL COMMENT '库存',
  `created_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '删除标志（0:未删除1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lammy_reagent
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
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '删除标志（0:未删除1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10', 'admin', 'admin', '2018-01-29 16:10:44', '2018-01-29 16:10:44', '0');

-- ----------------------------
-- Table structure for lammy_reagent_stock
-- ----------------------------
DROP TABLE IF EXISTS `lammy_reagent_stock`;
CREATE TABLE `lammy_reagent_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reagent_id` int(11) DEFAULT NULL COMMENT '试剂id',
  `operation` int(11) DEFAULT NULL COMMENT '操作类型（1、入库2、出库）',
  `operationDate` varchar(255) DEFAULT NULL COMMENT '操作时间',
  `count` int(11) DEFAULT NULL COMMENT '操作数量',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `created_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '删除标志（0:未删除1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
