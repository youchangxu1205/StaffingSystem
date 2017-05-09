/*
Navicat MySQL Data Transfer

Source Server         : 本地服务器
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : staffing_system

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-05-09 21:36:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for staffing_emp
-- ----------------------------
DROP TABLE IF EXISTS `staffing_emp`;
CREATE TABLE `staffing_emp` (
  `empId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '员工ID',
  `empName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '员工姓名',
  `empPhone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '员工手机号',
  `empAvatarUrl` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '员工头像',
  `empStatus` tinyint(4) DEFAULT '1' COMMENT '员工状态:-2:离职 -1:试岗离开 1:试岗中 2:在职 3:休长假',
  `otherInfo` text COLLATE utf8_bin COMMENT '员工其他信息,用json格式保存',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `entryTime` timestamp NULL DEFAULT NULL COMMENT '入职时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `beFormalTime` timestamp NULL DEFAULT NULL COMMENT '转正时间',
  `userName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '员工登录名',
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staffing_emp
-- ----------------------------

-- ----------------------------
-- Table structure for staffing_org
-- ----------------------------
DROP TABLE IF EXISTS `staffing_org`;
CREATE TABLE `staffing_org` (
  `orgId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `orgName` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '部门名称',
  `pOrgId` bigint(20) DEFAULT NULL COMMENT '上级部门',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `orgType` tinyint(4) DEFAULT NULL COMMENT '1为企业 2为部门',
  PRIMARY KEY (`orgId`)
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
  `orgId` bigint(20) NOT NULL COMMENT '部门ID',
  `empId` bigint(20) NOT NULL COMMENT '员工ID',
  `status` tinyint(4) DEFAULT '1' COMMENT '是否有效 1有效 2无效',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`orgId`,`empId`),
  KEY `org_emp_id` (`empId`),
  CONSTRAINT `emp_org_id` FOREIGN KEY (`orgId`) REFERENCES `staffing_org` (`orgId`),
  CONSTRAINT `org_emp_id` FOREIGN KEY (`empId`) REFERENCES `staffing_emp` (`empId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staffing_org_emp
-- ----------------------------

-- ----------------------------
-- Table structure for staffing_permission
-- ----------------------------
DROP TABLE IF EXISTS `staffing_permission`;
CREATE TABLE `staffing_permission` (
  `permissionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `permissionValue` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `permissionUri` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `permissionIcon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `permissionStatus` tinyint(4) DEFAULT NULL,
  `permissionType` tinyint(4) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `pPermissionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`permissionId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staffing_permission
-- ----------------------------
INSERT INTO `staffing_permission` VALUES ('1', '组织架构管理', null, null, null, '1', '1', '2017-05-09 21:15:45', '0');
INSERT INTO `staffing_permission` VALUES ('2', '部门管理', null, '/org/index', null, '1', '2', '2017-05-09 21:16:13', '1');
INSERT INTO `staffing_permission` VALUES ('3', '员工管理', null, '/emp/index', null, '1', '2', '2017-05-09 21:18:30', '1');
INSERT INTO `staffing_permission` VALUES ('4', '权限角色管理', null, null, null, '1', '1', '2017-05-09 21:19:25', '0');
INSERT INTO `staffing_permission` VALUES ('5', '权限管理', null, '/permission/index', null, '1', '2', '2017-05-09 21:19:47', '4');

-- ----------------------------
-- Table structure for staffing_post
-- ----------------------------
DROP TABLE IF EXISTS `staffing_post`;
CREATE TABLE `staffing_post` (
  `postId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `postName` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '岗位名称',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`postId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staffing_post
-- ----------------------------

-- ----------------------------
-- Table structure for staffing_post_emp
-- ----------------------------
DROP TABLE IF EXISTS `staffing_post_emp`;
CREATE TABLE `staffing_post_emp` (
  `postId` bigint(20) NOT NULL COMMENT '岗位ID',
  `empId` bigint(20) NOT NULL COMMENT '员工ID',
  `status` tinyint(4) DEFAULT '1' COMMENT '是否有效 1 有效 0 无效',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`postId`,`empId`),
  KEY `post_emp_id` (`empId`),
  CONSTRAINT `emp_post_id` FOREIGN KEY (`postId`) REFERENCES `staffing_post` (`postId`),
  CONSTRAINT `post_emp_id` FOREIGN KEY (`empId`) REFERENCES `staffing_emp` (`empId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staffing_post_emp
-- ----------------------------
