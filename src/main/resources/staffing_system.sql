/*
Navicat MySQL Data Transfer

Source Server         : 本地服务器
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : staffing_system

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-05-08 14:53:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for staffing_emp
-- ----------------------------
DROP TABLE IF EXISTS `staffing_emp`;
CREATE TABLE `staffing_emp` (
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '员工ID',
  `emp_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '员工姓名',
  `emp_phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '员工手机号',
  `emp_avatar_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '员工头像',
  `emp_status` tinyint(4) DEFAULT '1' COMMENT '员工状态:-2:离职 -1:试岗离开 1:试岗中 2:在职 3:休长假',
  `other_info` text COLLATE utf8_bin COMMENT '员工其他信息,用json格式保存',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `entry_time` timestamp NULL DEFAULT NULL COMMENT '入职时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `be_formal_time` timestamp NULL DEFAULT NULL COMMENT '转正时间',
  `user_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '员工登录名',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staffing_emp
-- ----------------------------
INSERT INTO `staffing_emp` VALUES ('1', '徐长友', '18697325393', null, '3', null, '2017-05-05 17:25:04', null, '2017-05-06 10:10:35', null, 'xuchangyou');
INSERT INTO `staffing_emp` VALUES ('2', '李康1', '13523016867', '', '2', '', '2017-05-05 17:43:51', '2017-05-05 17:55:02', '2017-05-06 10:10:43', '2017-05-05 17:56:29', 'likang1');
INSERT INTO `staffing_emp` VALUES ('3', '李康3', '13523016867', '', '1', '', '2017-05-05 17:58:05', '2017-05-05 17:58:06', '2017-05-06 10:10:49', '2017-05-05 17:58:06', 'likang3');
INSERT INTO `staffing_emp` VALUES ('4', '王五', '15538003366', null, '-1', null, '2017-05-06 09:23:40', null, '2017-05-06 10:10:52', null, 'wangwu');
INSERT INTO `staffing_emp` VALUES ('5', '赵四', '13833003366', null, '-2', null, '2017-05-06 09:24:10', null, '2017-05-06 10:10:55', null, 'zhaosi');
INSERT INTO `staffing_emp` VALUES ('6', '123', null, null, '1', null, '2017-05-06 11:50:16', '2017-05-01 00:00:00', '2017-05-08 14:51:37', '2017-05-11 00:00:00', '123');
INSERT INTO `staffing_emp` VALUES ('7', '111', null, null, '1', null, '2017-05-08 11:00:59', '2017-05-08 00:00:00', '2017-05-08 14:52:22', '2017-05-08 00:00:00', '1');
INSERT INTO `staffing_emp` VALUES ('8', '123', null, null, '1', null, '2017-05-08 11:02:28', null, '2017-05-08 11:02:28', null, '1');
INSERT INTO `staffing_emp` VALUES ('9', '123', null, null, '1', null, '2017-05-08 11:04:22', null, '2017-05-08 11:04:22', null, '1234');

-- ----------------------------
-- Table structure for staffing_org
-- ----------------------------
DROP TABLE IF EXISTS `staffing_org`;
CREATE TABLE `staffing_org` (
  `org_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `org_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '部门名称',
  `p_org_id` bigint(20) DEFAULT NULL COMMENT '上级部门',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `org_type` tinyint(4) DEFAULT NULL COMMENT '1为企业 2为部门',
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staffing_org
-- ----------------------------
INSERT INTO `staffing_org` VALUES ('1', '玖零多态科技', null, '2017-05-08 09:03:26', '2017-05-08 09:03:26', '1');
INSERT INTO `staffing_org` VALUES ('2', '研发部', '1', '2017-05-08 09:03:37', '2017-05-08 09:03:37', '2');
INSERT INTO `staffing_org` VALUES ('3', '市场部', '1', '2017-05-08 09:03:49', '2017-05-08 09:06:02', '2');

-- ----------------------------
-- Table structure for staffing_org_emp
-- ----------------------------
DROP TABLE IF EXISTS `staffing_org_emp`;
CREATE TABLE `staffing_org_emp` (
  `org_id` bigint(20) NOT NULL COMMENT '部门ID',
  `emp_id` bigint(20) NOT NULL COMMENT '员工ID',
  `status` tinyint(4) DEFAULT '1' COMMENT '是否有效 1有效 2无效',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`org_id`,`emp_id`),
  KEY `org_emp_id` (`emp_id`),
  CONSTRAINT `emp_org_id` FOREIGN KEY (`org_id`) REFERENCES `staffing_org` (`org_id`),
  CONSTRAINT `org_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `staffing_emp` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staffing_org_emp
-- ----------------------------

-- ----------------------------
-- Table structure for staffing_post
-- ----------------------------
DROP TABLE IF EXISTS `staffing_post`;
CREATE TABLE `staffing_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '岗位名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staffing_post
-- ----------------------------

-- ----------------------------
-- Table structure for staffing_post_emp
-- ----------------------------
DROP TABLE IF EXISTS `staffing_post_emp`;
CREATE TABLE `staffing_post_emp` (
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  `emp_id` bigint(20) NOT NULL COMMENT '员工ID',
  `status` tinyint(4) DEFAULT '1' COMMENT '是否有效 1 有效 0 无效',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`post_id`,`emp_id`),
  KEY `post_emp_id` (`emp_id`),
  CONSTRAINT `emp_post_id` FOREIGN KEY (`post_id`) REFERENCES `staffing_post` (`post_id`),
  CONSTRAINT `post_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `staffing_emp` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staffing_post_emp
-- ----------------------------
