/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : mybatis_db

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 23/07/2020 16:39:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `grade_id` int NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(10) DEFAULT NULL,
  `school` int DEFAULT NULL,
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of grade
-- ----------------------------
BEGIN;
INSERT INTO `grade` VALUES (1, 'cesewre', 2);
COMMIT;

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50) DEFAULT NULL,
  `unit_price` bigint DEFAULT NULL,
  `create_time` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_item
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for product_order
-- ----------------------------
DROP TABLE IF EXISTS `product_order`;
CREATE TABLE `product_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `order_no` varchar(30) DEFAULT NULL,
  `total_price` bigint DEFAULT NULL,
  `pay_type` int DEFAULT NULL,
  `create_time` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_order
-- ----------------------------
BEGIN;
INSERT INTO `product_order` VALUES (1, '测试订单00000000009', '202007011000000009', 23200, 4, 1594710115268);
INSERT INTO `product_order` VALUES (7, '测试订单00000000006', '202007011000000006', 22200, 1, 1594781952268);
INSERT INTO `product_order` VALUES (10, '测试订单00000000006', '202007011000000006', 22200, 1, 1594781959080);
INSERT INTO `product_order` VALUES (11, '测试订单00000000006', '202007011000000006', 22200, 1, 1594781959646);
INSERT INTO `product_order` VALUES (12, '测试订单00000000006', '202007011000000006', 22200, 1, 1594781959866);
INSERT INTO `product_order` VALUES (13, '测试订单00000000006', '202007011000000006', 22200, 1, 1594781960420);
COMMIT;

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `school_id` int NOT NULL AUTO_INCREMENT,
  `school_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of school
-- ----------------------------
BEGIN;
INSERT INTO `school` VALUES (1, '上海大学');
INSERT INTO `school` VALUES (2, '北京大学');
COMMIT;

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `url` varchar(150) DEFAULT NULL COMMENT '链接',
  `pid` int DEFAULT '0' COMMENT '父级节点',
  `create_time` bigint NOT NULL COMMENT '创建时间',
  `modify_time` bigint DEFAULT NULL COMMENT '修改时间',
  `is_deleted` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------
BEGIN;
INSERT INTO `sys_permissions` VALUES (1, '权限管理', '/getProductOrderParam', 0, 20200716095619, 20200716095619, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `create_time` bigint NOT NULL COMMENT '创建时间',
  `modify_time` bigint DEFAULT NULL COMMENT '修改时间',
  `is_deleted` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '管理员', 20200716095016, 20200716095016, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permissions`;
CREATE TABLE `sys_role_permissions` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `role_id` int DEFAULT NULL COMMENT '角色id',
  `permissions_id` int DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_role_permissions
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_permissions` VALUES (1, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `account` varchar(50) NOT NULL COMMENT '账号',
  `pass_word` varchar(50) NOT NULL COMMENT '密码',
  `status` int DEFAULT '0' COMMENT '账号状态 0 启用,1 禁用',
  `login_time` bigint DEFAULT NULL COMMENT '登陆时间',
  `create_time` bigint NOT NULL COMMENT '创建时间',
  `modify_time` bigint DEFAULT NULL COMMENT '修改时间',
  `is_deleted` int NOT NULL DEFAULT '0',
  `role_id` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, '名字1111', 'admin', 'admin', 0, 20200716094839, 20200716094839, 20200716094839, 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `t_id` int NOT NULL AUTO_INCREMENT,
  `t_name` varchar(50) DEFAULT NULL,
  `t_age` int DEFAULT '0',
  `t_address` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (5, '张三1', 20, '上海1');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `pass_word` varchar(50) DEFAULT NULL,
  `gender` int DEFAULT '0',
  `age` int DEFAULT '0',
  `school` int DEFAULT NULL,
  `grade` int DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '2222', '2324', 1, 23, 1, 1);
INSERT INTO `user` VALUES (2, '张三', '7788881', 1, 23, 1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
