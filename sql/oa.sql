/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-06-21 11:13:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log_201906
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_201906`;
CREATE TABLE `sys_log_201906` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `t` varchar(128) DEFAULT NULL,
  `tg` varchar(128) DEFAULT NULL,
  `src` varchar(1024) DEFAULT NULL,
  `u_id` varchar(128) DEFAULT NULL,
  `u_name` varchar(128) DEFAULT NULL,
  `ip` varchar(128) DEFAULT NULL,
  `msg` varchar(4000) DEFAULT NULL,
  `opUser` varchar(36) DEFAULT NULL COMMENT '操作人',
  `create_time` bigint(64) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(64) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `role_name` varchar(120) DEFAULT NULL COMMENT '介绍名称',
  `comments` varchar(255) DEFAULT NULL COMMENT '备注说明',
  `isDelete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  `opUser` varchar(36) DEFAULT NULL COMMENT '操作人',
  `create_time` bigint(64) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(64) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `username` varchar(120) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickName` varchar(255) DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `emailVerified` tinyint(1) DEFAULT NULL COMMENT '邮箱验证',
  `state` tinyint(1) DEFAULT '0' COMMENT '用户状态',
  `opUser` varchar(36) DEFAULT NULL COMMENT '操作人',
  `create_time` bigint(64) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(64) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `uid` varchar(36) DEFAULT NULL COMMENT '用户id',
  `rid` varchar(36) DEFAULT NULL COMMENT '角色id',
  `opUser` varchar(36) DEFAULT NULL COMMENT '操作人',
  `create_time` bigint(64) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(64) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
