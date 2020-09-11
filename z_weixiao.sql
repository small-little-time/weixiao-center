/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : z_weixiao

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-06-02 14:18:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for z_adm_admin
-- ----------------------------
DROP TABLE IF EXISTS `z_adm_admin`;
CREATE TABLE `z_adm_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `icon` varchar(500) DEFAULT 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=735090639,1763140201&fm=11&gp=0.jpg' COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) NOT NULL COMMENT '昵称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0-禁用 1-启用',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='后台用户表';

-- ----------------------------
-- Records of z_adm_admin
-- ----------------------------
INSERT INTO `z_adm_admin` VALUES ('1', 'root', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=735090639,1763140201&fm=11&gp=0.jpg', 'sx@qq.com', 'z_', '3', '2020-05-30 13:44:50', '2019-11-20 17:32:50', '2020-02-21 14:42:41', '1', '1');
INSERT INTO `z_adm_admin` VALUES ('2', 'admin', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=735090639,1763140201&fm=11&gp=0.jpg', 'user@qq.com', 'user_', '3', '2020-04-25 15:48:42', '2019-11-21 14:11:23', '2019-11-21 14:11:23', '1', '1');
INSERT INTO `z_adm_admin` VALUES ('3', 'user1', '$2a$10$gX2XkedIXYHOeezPJFF3R.wI3rB0gP7xEUZQbEbUyeRsj.m4NVL52', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=735090639,1763140201&fm=11&gp=0.jpg', 'user1@qq.com', 'user1_', '3', '2019-11-28 11:06:03', '2019-11-21 14:22:41', '2019-11-21 14:22:41', '1', '0');
INSERT INTO `z_adm_admin` VALUES ('6', 'adm', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=735090639,1763140201&fm=11&gp=0.jpg', 'adm@sx.com', 'adm', '3', '2020-02-28 14:56:51', '2019-11-28 15:03:16', '2020-02-21 14:36:10', '0', '1');
INSERT INTO `z_adm_admin` VALUES ('18', 'super', '$2a$10$rZi2MMGnPLF5SZociZmFg.nR7lPY29sOPyZCPM22OByZe7MM5SVBe', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=735090639,1763140201&fm=11&gp=0.jpg', 'super@sx.com', 'super', null, '2020-02-21 17:50:39', '2020-02-21 14:17:47', '2020-02-21 14:17:47', '1', '1');
INSERT INTO `z_adm_admin` VALUES ('23', 'content', '$2a$10$0kgFzwDwvp3IIPdnPPF02u1mrM504Rrf1L8Rqacij27FdqHHYhz4q', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=735090639,1763140201&fm=11&gp=0.jpg', 'sx@qq.com', 'content', null, null, '2020-04-25 15:45:31', '2020-04-25 15:45:31', '1', '1');
INSERT INTO `z_adm_admin` VALUES ('24', 'activity', '$2a$10$O/7jQbxKu8ma8Tc2p6AXtOuDB5qeK0JbjZY5WbdblMrb654u.6r5u', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=735090639,1763140201&fm=11&gp=0.jpg', 'sx@qq.com', 'activity', null, '2020-05-30 14:43:21', '2020-04-25 15:46:04', '2020-04-25 15:46:04', '1', '1');
INSERT INTO `z_adm_admin` VALUES ('25', 'student', '$2a$10$I/DgJ6L5YveZ6aPnNAPb/OijKsEaEzt89OvbPNSOsKrUDkdQzhZ7u', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=735090639,1763140201&fm=11&gp=0.jpg', 'sx@qq.com', 'student', null, null, '2020-04-25 15:46:44', '2020-04-25 15:46:44', '1', '1');

-- ----------------------------
-- Table structure for z_adm_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `z_adm_admin_role_relation`;
CREATE TABLE `z_adm_admin_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NOT NULL COMMENT '用户主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色主键',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='后台用户和角色关系表';

-- ----------------------------
-- Records of z_adm_admin_role_relation
-- ----------------------------
INSERT INTO `z_adm_admin_role_relation` VALUES ('4', '1', '1', '2019-11-20 17:26:53', '2019-11-20 17:26:53', '1');
INSERT INTO `z_adm_admin_role_relation` VALUES ('5', '2', '2', '2019-11-22 11:36:06', '2019-11-22 11:36:06', '1');
INSERT INTO `z_adm_admin_role_relation` VALUES ('6', '6', '3', '2020-02-18 14:55:26', '2020-02-23 16:47:13', '0');
INSERT INTO `z_adm_admin_role_relation` VALUES ('7', '2', '3', '2020-02-23 12:42:38', '2020-02-23 15:41:33', '0');
INSERT INTO `z_adm_admin_role_relation` VALUES ('10', '2', '3', '2020-02-23 15:53:05', '2020-02-23 15:53:05', '1');
INSERT INTO `z_adm_admin_role_relation` VALUES ('11', '6', '4', '2020-02-23 16:44:45', '2020-02-23 16:47:13', '0');
INSERT INTO `z_adm_admin_role_relation` VALUES ('12', '6', '3', '2020-02-23 16:47:23', '2020-02-23 16:47:23', '1');
INSERT INTO `z_adm_admin_role_relation` VALUES ('16', '23', '6', '2020-04-25 15:47:16', '2020-04-25 15:47:16', '1');
INSERT INTO `z_adm_admin_role_relation` VALUES ('17', '24', '5', '2020-04-25 15:47:25', '2020-05-27 09:55:51', '0');
INSERT INTO `z_adm_admin_role_relation` VALUES ('18', '25', '4', '2020-04-25 15:47:33', '2020-04-25 15:47:33', '1');
INSERT INTO `z_adm_admin_role_relation` VALUES ('19', '24', '5', '2020-05-27 10:02:20', '2020-05-29 23:01:31', '0');
INSERT INTO `z_adm_admin_role_relation` VALUES ('20', '24', '5', '2020-05-29 23:01:39', '2020-05-30 11:23:44', '0');
INSERT INTO `z_adm_admin_role_relation` VALUES ('21', '24', '5', '2020-05-30 14:41:17', '2020-05-30 14:41:17', '1');

-- ----------------------------
-- Table structure for z_adm_permission
-- ----------------------------
DROP TABLE IF EXISTS `z_adm_permission`;
CREATE TABLE `z_adm_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `value` varchar(200) DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) DEFAULT NULL COMMENT '图标',
  `type` int(1) DEFAULT NULL COMMENT '权限类型：0-目录 1-菜单 2-按钮（接口绑定权限）',
  `uri` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
  `status` int(1) DEFAULT NULL COMMENT '启用状态；0-禁用 1-启用',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='后台用户权限表';

-- ----------------------------
-- Records of z_adm_permission
-- ----------------------------
INSERT INTO `z_adm_permission` VALUES ('1', '0', '管理员', '', null, null, null, null, null, '2019-11-21 12:48:01', '2019-11-21 12:48:01', '1');
INSERT INTO `z_adm_permission` VALUES ('2', '1', '管理员创建', 'adm:admin:create', null, null, null, null, null, '2019-11-21 12:48:13', '2019-11-21 12:48:13', '1');
INSERT INTO `z_adm_permission` VALUES ('3', '1', '管理员查询', 'adm:admin:read', null, null, null, null, null, '2019-11-21 12:48:39', '2019-11-21 12:48:39', '1');
INSERT INTO `z_adm_permission` VALUES ('4', '1', '管理员修改', 'adm:admin:update', null, null, null, null, null, '2019-11-22 11:39:20', '2019-11-22 11:39:20', '1');
INSERT INTO `z_adm_permission` VALUES ('5', '1', '管理员删除', 'adm:admin:detele', null, null, null, null, null, '2019-11-22 11:39:33', '2019-11-22 11:39:33', '1');

-- ----------------------------
-- Table structure for z_adm_role
-- ----------------------------
DROP TABLE IF EXISTS `z_adm_role`;
CREATE TABLE `z_adm_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
  `status` int(1) DEFAULT '1' COMMENT '启用状态：0-禁用 1-启用',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='后台用户角色表';

-- ----------------------------
-- Records of z_adm_role
-- ----------------------------
INSERT INTO `z_adm_role` VALUES ('1', '超级管理员', 'admin', null, '1', '0', '2019-11-21 12:41:20', '2019-11-21 12:41:20', '1');
INSERT INTO `z_adm_role` VALUES ('2', '普通管理员', 'primary', null, '1', '0', '2019-11-22 11:35:15', '2019-11-22 11:35:15', '1');
INSERT INTO `z_adm_role` VALUES ('3', '热点管理员', 'hot', null, '1', '0', '2020-02-18 14:54:30', '2020-02-18 14:54:30', '1');
INSERT INTO `z_adm_role` VALUES ('4', '学生管理员', 'student', null, '1', '0', '2020-02-18 14:54:47', '2020-02-18 14:54:47', '1');
INSERT INTO `z_adm_role` VALUES ('5', '活动管理员', 'activity', null, '1', '0', '2020-04-25 14:12:02', '2020-04-25 14:12:02', '1');
INSERT INTO `z_adm_role` VALUES ('6', '内容管理员', 'content', null, '1', '0', '2020-04-25 14:12:41', '2020-04-25 14:12:41', '1');

-- ----------------------------
-- Table structure for z_adm_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `z_adm_role_permission_relation`;
CREATE TABLE `z_adm_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色主键',
  `permission_id` bigint(20) NOT NULL COMMENT '权限主键',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='后台用户角色和权限关系表';

-- ----------------------------
-- Records of z_adm_role_permission_relation
-- ----------------------------
INSERT INTO `z_adm_role_permission_relation` VALUES ('2', '1', '2', '2019-11-21 12:41:38', '2019-11-21 12:41:38', '1');
INSERT INTO `z_adm_role_permission_relation` VALUES ('3', '1', '3', '2019-11-21 12:48:54', '2019-11-21 12:48:54', '1');
INSERT INTO `z_adm_role_permission_relation` VALUES ('4', '2', '3', '2019-11-22 11:40:49', '2019-11-22 11:40:49', '1');

-- ----------------------------
-- Table structure for z_common_area
-- ----------------------------
DROP TABLE IF EXISTS `z_common_area`;
CREATE TABLE `z_common_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL DEFAULT '0' COMMENT '编号',
  `name` varchar(255) DEFAULT '' COMMENT '名称',
  `area_type` int(11) DEFAULT '0' COMMENT '城市类型',
  `parent_number` int(11) DEFAULT '0' COMMENT '父城市编号',
  PRIMARY KEY (`id`,`number`),
  UNIQUE KEY `number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=4034 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_common_area
-- ----------------------------
INSERT INTO `z_common_area` VALUES ('1', '110000', '北京市', '1', '0');
INSERT INTO `z_common_area` VALUES ('2', '120000', '天津市', '1', '0');
INSERT INTO `z_common_area` VALUES ('3', '130000', '河北省', '1', '0');
INSERT INTO `z_common_area` VALUES ('4', '140000', '山西省', '1', '0');
INSERT INTO `z_common_area` VALUES ('5', '150000', '内蒙古自治区', '1', '0');
INSERT INTO `z_common_area` VALUES ('6', '210000', '辽宁省', '1', '0');
INSERT INTO `z_common_area` VALUES ('7', '220000', '吉林省', '1', '0');
INSERT INTO `z_common_area` VALUES ('8', '230000', '黑龙江省', '1', '0');
INSERT INTO `z_common_area` VALUES ('9', '310000', '上海市', '1', '0');
INSERT INTO `z_common_area` VALUES ('10', '320000', '江苏省', '1', '0');
INSERT INTO `z_common_area` VALUES ('11', '330000', '浙江省', '1', '0');
INSERT INTO `z_common_area` VALUES ('12', '340000', '安徽省', '1', '0');
INSERT INTO `z_common_area` VALUES ('13', '350000', '福建省', '1', '0');
INSERT INTO `z_common_area` VALUES ('14', '360000', '江西省', '1', '0');
INSERT INTO `z_common_area` VALUES ('15', '370000', '山东省', '1', '0');
INSERT INTO `z_common_area` VALUES ('16', '410000', '河南省', '1', '0');
INSERT INTO `z_common_area` VALUES ('17', '420000', '湖北省', '1', '0');
INSERT INTO `z_common_area` VALUES ('18', '430000', '湖南省', '1', '0');
INSERT INTO `z_common_area` VALUES ('19', '440000', '广东省', '1', '0');
INSERT INTO `z_common_area` VALUES ('20', '450000', '广西壮族自治区', '1', '0');
INSERT INTO `z_common_area` VALUES ('21', '460000', '海南省', '1', '0');
INSERT INTO `z_common_area` VALUES ('22', '500000', '重庆市', '1', '0');
INSERT INTO `z_common_area` VALUES ('23', '510000', '四川省', '1', '0');
INSERT INTO `z_common_area` VALUES ('24', '520000', '贵州省', '1', '0');
INSERT INTO `z_common_area` VALUES ('25', '530000', '云南省', '1', '0');
INSERT INTO `z_common_area` VALUES ('26', '540000', '西藏自治区', '1', '0');
INSERT INTO `z_common_area` VALUES ('27', '610000', '陕西省', '1', '0');
INSERT INTO `z_common_area` VALUES ('28', '620000', '甘肃省', '1', '0');
INSERT INTO `z_common_area` VALUES ('29', '630000', '青海省', '1', '0');
INSERT INTO `z_common_area` VALUES ('30', '640000', '宁夏回族自治区', '1', '0');
INSERT INTO `z_common_area` VALUES ('31', '650000', '新疆维吾尔自治区', '1', '0');
INSERT INTO `z_common_area` VALUES ('32', '710000', '台湾省', '1', '0');
INSERT INTO `z_common_area` VALUES ('33', '810000', '香港特别行政区', '1', '0');
INSERT INTO `z_common_area` VALUES ('34', '820000', '澳门特别行政区', '1', '0');
INSERT INTO `z_common_area` VALUES ('35', '900000', '海外', '1', '0');
INSERT INTO `z_common_area` VALUES ('36', '110100', '北京市', '2', '110000');
INSERT INTO `z_common_area` VALUES ('37', '120100', '天津市', '2', '120000');
INSERT INTO `z_common_area` VALUES ('38', '130100', '石家庄市', '2', '130000');
INSERT INTO `z_common_area` VALUES ('39', '130200', '唐山市', '2', '130000');
INSERT INTO `z_common_area` VALUES ('40', '130300', '秦皇岛市', '2', '130000');
INSERT INTO `z_common_area` VALUES ('41', '130400', '邯郸市', '2', '130000');
INSERT INTO `z_common_area` VALUES ('42', '130500', '邢台市', '2', '130000');
INSERT INTO `z_common_area` VALUES ('43', '130600', '保定市', '2', '130000');
INSERT INTO `z_common_area` VALUES ('44', '130700', '张家口市', '2', '130000');
INSERT INTO `z_common_area` VALUES ('45', '130800', '承德市', '2', '130000');
INSERT INTO `z_common_area` VALUES ('46', '130900', '沧州市', '2', '130000');
INSERT INTO `z_common_area` VALUES ('47', '131000', '廊坊市', '2', '130000');
INSERT INTO `z_common_area` VALUES ('48', '131100', '衡水市', '2', '130000');
INSERT INTO `z_common_area` VALUES ('49', '140100', '太原市', '2', '140000');
INSERT INTO `z_common_area` VALUES ('50', '140200', '大同市', '2', '140000');
INSERT INTO `z_common_area` VALUES ('51', '140300', '阳泉市', '2', '140000');
INSERT INTO `z_common_area` VALUES ('52', '140400', '长治市', '2', '140000');
INSERT INTO `z_common_area` VALUES ('53', '140500', '晋城市', '2', '140000');
INSERT INTO `z_common_area` VALUES ('54', '140600', '朔州市', '2', '140000');
INSERT INTO `z_common_area` VALUES ('55', '140700', '晋中市', '2', '140000');
INSERT INTO `z_common_area` VALUES ('56', '140800', '运城市', '2', '140000');
INSERT INTO `z_common_area` VALUES ('57', '140900', '忻州市', '2', '140000');
INSERT INTO `z_common_area` VALUES ('58', '141000', '临汾市', '2', '140000');
INSERT INTO `z_common_area` VALUES ('59', '141100', '吕梁市', '2', '140000');
INSERT INTO `z_common_area` VALUES ('60', '150100', '呼和浩特市', '2', '150000');
INSERT INTO `z_common_area` VALUES ('61', '150200', '包头市', '2', '150000');
INSERT INTO `z_common_area` VALUES ('62', '150300', '乌海市', '2', '150000');
INSERT INTO `z_common_area` VALUES ('63', '150400', '赤峰市', '2', '150000');
INSERT INTO `z_common_area` VALUES ('64', '150500', '通辽市', '2', '150000');
INSERT INTO `z_common_area` VALUES ('65', '150600', '鄂尔多斯市', '2', '150000');
INSERT INTO `z_common_area` VALUES ('66', '150700', '呼伦贝尔市', '2', '150000');
INSERT INTO `z_common_area` VALUES ('67', '150800', '巴彦淖尔市', '2', '150000');
INSERT INTO `z_common_area` VALUES ('68', '150900', '乌兰察布市', '2', '150000');
INSERT INTO `z_common_area` VALUES ('69', '152200', '兴安盟', '2', '150000');
INSERT INTO `z_common_area` VALUES ('70', '152500', '锡林郭勒盟', '2', '150000');
INSERT INTO `z_common_area` VALUES ('71', '152900', '阿拉善盟', '2', '150000');
INSERT INTO `z_common_area` VALUES ('72', '210100', '沈阳市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('73', '210200', '大连市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('74', '210300', '鞍山市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('75', '210400', '抚顺市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('76', '210500', '本溪市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('77', '210600', '丹东市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('78', '210700', '锦州市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('79', '210800', '营口市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('80', '210900', '阜新市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('81', '211000', '辽阳市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('82', '211100', '盘锦市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('83', '211200', '铁岭市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('84', '211300', '朝阳市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('85', '211400', '葫芦岛市', '2', '210000');
INSERT INTO `z_common_area` VALUES ('86', '220100', '长春市', '2', '220000');
INSERT INTO `z_common_area` VALUES ('87', '220200', '吉林市', '2', '220000');
INSERT INTO `z_common_area` VALUES ('88', '220300', '四平市', '2', '220000');
INSERT INTO `z_common_area` VALUES ('89', '220400', '辽源市', '2', '220000');
INSERT INTO `z_common_area` VALUES ('90', '220500', '通化市', '2', '220000');
INSERT INTO `z_common_area` VALUES ('91', '220600', '白山市', '2', '220000');
INSERT INTO `z_common_area` VALUES ('92', '220700', '松原市', '2', '220000');
INSERT INTO `z_common_area` VALUES ('93', '220800', '白城市', '2', '220000');
INSERT INTO `z_common_area` VALUES ('94', '222400', '延边朝鲜族自治州', '2', '220000');
INSERT INTO `z_common_area` VALUES ('95', '230100', '哈尔滨市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('96', '230200', '齐齐哈尔市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('97', '230300', '鸡西市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('98', '230400', '鹤岗市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('99', '230500', '双鸭山市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('100', '230600', '大庆市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('101', '230700', '伊春市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('102', '230800', '佳木斯市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('103', '230900', '七台河市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('104', '231000', '牡丹江市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('105', '231100', '黑河市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('106', '231200', '绥化市', '2', '230000');
INSERT INTO `z_common_area` VALUES ('107', '232700', '大兴安岭地区', '2', '230000');
INSERT INTO `z_common_area` VALUES ('108', '310100', '上海市', '2', '310000');
INSERT INTO `z_common_area` VALUES ('109', '320100', '南京市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('110', '320200', '无锡市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('111', '320300', '徐州市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('112', '320400', '常州市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('113', '320500', '苏州市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('114', '320600', '南通市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('115', '320700', '连云港市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('116', '320800', '淮安市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('117', '320900', '盐城市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('118', '321000', '扬州市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('119', '321100', '镇江市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('120', '321200', '泰州市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('121', '321300', '宿迁市', '2', '320000');
INSERT INTO `z_common_area` VALUES ('122', '330100', '杭州市', '2', '330000');
INSERT INTO `z_common_area` VALUES ('123', '330200', '宁波市', '2', '330000');
INSERT INTO `z_common_area` VALUES ('124', '330300', '温州市', '2', '330000');
INSERT INTO `z_common_area` VALUES ('125', '330400', '嘉兴市', '2', '330000');
INSERT INTO `z_common_area` VALUES ('126', '330500', '湖州市', '2', '330000');
INSERT INTO `z_common_area` VALUES ('127', '330600', '绍兴市', '2', '330000');
INSERT INTO `z_common_area` VALUES ('128', '330700', '金华市', '2', '330000');
INSERT INTO `z_common_area` VALUES ('129', '330800', '衢州市', '2', '330000');
INSERT INTO `z_common_area` VALUES ('130', '330900', '舟山市', '2', '330000');
INSERT INTO `z_common_area` VALUES ('131', '331000', '台州市', '2', '330000');
INSERT INTO `z_common_area` VALUES ('132', '331100', '丽水市', '2', '330000');
INSERT INTO `z_common_area` VALUES ('133', '340100', '合肥市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('134', '340200', '芜湖市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('135', '340300', '蚌埠市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('136', '340400', '淮南市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('137', '340500', '马鞍山市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('138', '340600', '淮北市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('139', '340700', '铜陵市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('140', '340800', '安庆市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('141', '341000', '黄山市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('142', '341100', '滁州市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('143', '341200', '阜阳市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('144', '341300', '宿州市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('145', '341500', '六安市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('146', '341600', '亳州市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('147', '341700', '池州市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('148', '341800', '宣城市', '2', '340000');
INSERT INTO `z_common_area` VALUES ('149', '350100', '福州市', '2', '350000');
INSERT INTO `z_common_area` VALUES ('150', '350200', '厦门市', '2', '350000');
INSERT INTO `z_common_area` VALUES ('151', '350300', '莆田市', '2', '350000');
INSERT INTO `z_common_area` VALUES ('152', '350400', '三明市', '2', '350000');
INSERT INTO `z_common_area` VALUES ('153', '350500', '泉州市', '2', '350000');
INSERT INTO `z_common_area` VALUES ('154', '350600', '漳州市', '2', '350000');
INSERT INTO `z_common_area` VALUES ('155', '350700', '南平市', '2', '350000');
INSERT INTO `z_common_area` VALUES ('156', '350800', '龙岩市', '2', '350000');
INSERT INTO `z_common_area` VALUES ('157', '350900', '宁德市', '2', '350000');
INSERT INTO `z_common_area` VALUES ('158', '360100', '南昌市', '2', '360000');
INSERT INTO `z_common_area` VALUES ('159', '360200', '景德镇市', '2', '360000');
INSERT INTO `z_common_area` VALUES ('160', '360300', '萍乡市', '2', '360000');
INSERT INTO `z_common_area` VALUES ('161', '360400', '九江市', '2', '360000');
INSERT INTO `z_common_area` VALUES ('162', '360500', '新余市', '2', '360000');
INSERT INTO `z_common_area` VALUES ('163', '360600', '鹰潭市', '2', '360000');
INSERT INTO `z_common_area` VALUES ('164', '360700', '赣州市', '2', '360000');
INSERT INTO `z_common_area` VALUES ('165', '360800', '吉安市', '2', '360000');
INSERT INTO `z_common_area` VALUES ('166', '360900', '宜春市', '2', '360000');
INSERT INTO `z_common_area` VALUES ('167', '361000', '抚州市', '2', '360000');
INSERT INTO `z_common_area` VALUES ('168', '361100', '上饶市', '2', '360000');
INSERT INTO `z_common_area` VALUES ('169', '370100', '济南市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('170', '370200', '青岛市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('171', '370300', '淄博市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('172', '370400', '枣庄市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('173', '370500', '东营市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('174', '370600', '烟台市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('175', '370700', '潍坊市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('176', '370800', '济宁市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('177', '370900', '泰安市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('178', '371000', '威海市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('179', '371100', '日照市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('180', '371300', '临沂市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('181', '371400', '德州市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('182', '371500', '聊城市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('183', '371600', '滨州市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('184', '371700', '菏泽市', '2', '370000');
INSERT INTO `z_common_area` VALUES ('185', '410100', '郑州市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('186', '410200', '开封市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('187', '410300', '洛阳市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('188', '410400', '平顶山市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('189', '410500', '安阳市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('190', '410600', '鹤壁市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('191', '410700', '新乡市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('192', '410800', '焦作市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('193', '410900', '濮阳市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('194', '411000', '许昌市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('195', '411100', '漯河市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('196', '411200', '三门峡市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('197', '411300', '南阳市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('198', '411400', '商丘市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('199', '411500', '信阳市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('200', '411600', '周口市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('201', '411700', '驻马店市', '2', '410000');
INSERT INTO `z_common_area` VALUES ('202', '419000', '省直辖县', '2', '410000');
INSERT INTO `z_common_area` VALUES ('203', '420100', '武汉市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('204', '420200', '黄石市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('205', '420300', '十堰市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('206', '420500', '宜昌市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('207', '420600', '襄阳市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('208', '420700', '鄂州市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('209', '420800', '荆门市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('210', '420900', '孝感市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('211', '421000', '荆州市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('212', '421100', '黄冈市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('213', '421200', '咸宁市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('214', '421300', '随州市', '2', '420000');
INSERT INTO `z_common_area` VALUES ('215', '422800', '恩施土家族苗族自治州', '2', '420000');
INSERT INTO `z_common_area` VALUES ('216', '429000', '省直辖县', '2', '420000');
INSERT INTO `z_common_area` VALUES ('217', '430100', '长沙市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('218', '430200', '株洲市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('219', '430300', '湘潭市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('220', '430400', '衡阳市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('221', '430500', '邵阳市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('222', '430600', '岳阳市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('223', '430700', '常德市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('224', '430800', '张家界市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('225', '430900', '益阳市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('226', '431000', '郴州市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('227', '431100', '永州市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('228', '431200', '怀化市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('229', '431300', '娄底市', '2', '430000');
INSERT INTO `z_common_area` VALUES ('230', '433100', '湘西土家族苗族自治州', '2', '430000');
INSERT INTO `z_common_area` VALUES ('231', '440100', '广州市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('232', '440200', '韶关市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('233', '440300', '深圳市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('234', '440400', '珠海市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('235', '440500', '汕头市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('236', '440600', '佛山市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('237', '440700', '江门市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('238', '440800', '湛江市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('239', '440900', '茂名市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('240', '441200', '肇庆市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('241', '441300', '惠州市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('242', '441400', '梅州市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('243', '441500', '汕尾市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('244', '441600', '河源市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('245', '441700', '阳江市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('246', '441800', '清远市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('247', '441900', '东莞市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('248', '442000', '中山市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('249', '445100', '潮州市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('250', '445200', '揭阳市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('251', '445300', '云浮市', '2', '440000');
INSERT INTO `z_common_area` VALUES ('252', '450100', '南宁市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('253', '450200', '柳州市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('254', '450300', '桂林市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('255', '450400', '梧州市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('256', '450500', '北海市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('257', '450600', '防城港市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('258', '450700', '钦州市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('259', '450800', '贵港市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('260', '450900', '玉林市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('261', '451000', '百色市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('262', '451100', '贺州市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('263', '451200', '河池市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('264', '451300', '来宾市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('265', '451400', '崇左市', '2', '450000');
INSERT INTO `z_common_area` VALUES ('266', '460100', '海口市', '2', '460000');
INSERT INTO `z_common_area` VALUES ('267', '460200', '三亚市', '2', '460000');
INSERT INTO `z_common_area` VALUES ('268', '460300', '三沙市', '2', '460000');
INSERT INTO `z_common_area` VALUES ('269', '460400', '儋州市', '2', '460000');
INSERT INTO `z_common_area` VALUES ('270', '469000', '省直辖县', '2', '460000');
INSERT INTO `z_common_area` VALUES ('271', '500100', '重庆市', '2', '500000');
INSERT INTO `z_common_area` VALUES ('272', '500200', '县', '2', '500000');
INSERT INTO `z_common_area` VALUES ('273', '510100', '成都市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('274', '510300', '自贡市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('275', '510400', '攀枝花市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('276', '510500', '泸州市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('277', '510600', '德阳市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('278', '510700', '绵阳市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('279', '510800', '广元市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('280', '510900', '遂宁市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('281', '511000', '内江市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('282', '511100', '乐山市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('283', '511300', '南充市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('284', '511400', '眉山市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('285', '511500', '宜宾市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('286', '511600', '广安市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('287', '511700', '达州市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('288', '511800', '雅安市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('289', '511900', '巴中市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('290', '512000', '资阳市', '2', '510000');
INSERT INTO `z_common_area` VALUES ('291', '513200', '阿坝藏族羌族自治州', '2', '510000');
INSERT INTO `z_common_area` VALUES ('292', '513300', '甘孜藏族自治州', '2', '510000');
INSERT INTO `z_common_area` VALUES ('293', '513400', '凉山彝族自治州', '2', '510000');
INSERT INTO `z_common_area` VALUES ('294', '520100', '贵阳市', '2', '520000');
INSERT INTO `z_common_area` VALUES ('295', '520200', '六盘水市', '2', '520000');
INSERT INTO `z_common_area` VALUES ('296', '520300', '遵义市', '2', '520000');
INSERT INTO `z_common_area` VALUES ('297', '520400', '安顺市', '2', '520000');
INSERT INTO `z_common_area` VALUES ('298', '520500', '毕节市', '2', '520000');
INSERT INTO `z_common_area` VALUES ('299', '520600', '铜仁市', '2', '520000');
INSERT INTO `z_common_area` VALUES ('300', '522300', '黔西南布依族苗族自治州', '2', '520000');
INSERT INTO `z_common_area` VALUES ('301', '522600', '黔东南苗族侗族自治州', '2', '520000');
INSERT INTO `z_common_area` VALUES ('302', '522700', '黔南布依族苗族自治州', '2', '520000');
INSERT INTO `z_common_area` VALUES ('303', '530100', '昆明市', '2', '530000');
INSERT INTO `z_common_area` VALUES ('304', '530300', '曲靖市', '2', '530000');
INSERT INTO `z_common_area` VALUES ('305', '530400', '玉溪市', '2', '530000');
INSERT INTO `z_common_area` VALUES ('306', '530500', '保山市', '2', '530000');
INSERT INTO `z_common_area` VALUES ('307', '530600', '昭通市', '2', '530000');
INSERT INTO `z_common_area` VALUES ('308', '530700', '丽江市', '2', '530000');
INSERT INTO `z_common_area` VALUES ('309', '530800', '普洱市', '2', '530000');
INSERT INTO `z_common_area` VALUES ('310', '530900', '临沧市', '2', '530000');
INSERT INTO `z_common_area` VALUES ('311', '532300', '楚雄彝族自治州', '2', '530000');
INSERT INTO `z_common_area` VALUES ('312', '532500', '红河哈尼族彝族自治州', '2', '530000');
INSERT INTO `z_common_area` VALUES ('313', '532600', '文山壮族苗族自治州', '2', '530000');
INSERT INTO `z_common_area` VALUES ('314', '532800', '西双版纳傣族自治州', '2', '530000');
INSERT INTO `z_common_area` VALUES ('315', '532900', '大理白族自治州', '2', '530000');
INSERT INTO `z_common_area` VALUES ('316', '533100', '德宏傣族景颇族自治州', '2', '530000');
INSERT INTO `z_common_area` VALUES ('317', '533300', '怒江傈僳族自治州', '2', '530000');
INSERT INTO `z_common_area` VALUES ('318', '533400', '迪庆藏族自治州', '2', '530000');
INSERT INTO `z_common_area` VALUES ('319', '540100', '拉萨市', '2', '540000');
INSERT INTO `z_common_area` VALUES ('320', '540200', '日喀则市', '2', '540000');
INSERT INTO `z_common_area` VALUES ('321', '540300', '昌都市', '2', '540000');
INSERT INTO `z_common_area` VALUES ('322', '540400', '林芝市', '2', '540000');
INSERT INTO `z_common_area` VALUES ('323', '540500', '山南市', '2', '540000');
INSERT INTO `z_common_area` VALUES ('324', '540600', '那曲市', '2', '540000');
INSERT INTO `z_common_area` VALUES ('325', '542500', '阿里地区', '2', '540000');
INSERT INTO `z_common_area` VALUES ('326', '610100', '西安市', '2', '610000');
INSERT INTO `z_common_area` VALUES ('327', '610200', '铜川市', '2', '610000');
INSERT INTO `z_common_area` VALUES ('328', '610300', '宝鸡市', '2', '610000');
INSERT INTO `z_common_area` VALUES ('329', '610400', '咸阳市', '2', '610000');
INSERT INTO `z_common_area` VALUES ('330', '610500', '渭南市', '2', '610000');
INSERT INTO `z_common_area` VALUES ('331', '610600', '延安市', '2', '610000');
INSERT INTO `z_common_area` VALUES ('332', '610700', '汉中市', '2', '610000');
INSERT INTO `z_common_area` VALUES ('333', '610800', '榆林市', '2', '610000');
INSERT INTO `z_common_area` VALUES ('334', '610900', '安康市', '2', '610000');
INSERT INTO `z_common_area` VALUES ('335', '611000', '商洛市', '2', '610000');
INSERT INTO `z_common_area` VALUES ('336', '620100', '兰州市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('337', '620200', '嘉峪关市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('338', '620300', '金昌市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('339', '620400', '白银市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('340', '620500', '天水市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('341', '620600', '武威市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('342', '620700', '张掖市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('343', '620800', '平凉市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('344', '620900', '酒泉市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('345', '621000', '庆阳市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('346', '621100', '定西市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('347', '621200', '陇南市', '2', '620000');
INSERT INTO `z_common_area` VALUES ('348', '622900', '临夏回族自治州', '2', '620000');
INSERT INTO `z_common_area` VALUES ('349', '623000', '甘南藏族自治州', '2', '620000');
INSERT INTO `z_common_area` VALUES ('350', '630100', '西宁市', '2', '630000');
INSERT INTO `z_common_area` VALUES ('351', '630200', '海东市', '2', '630000');
INSERT INTO `z_common_area` VALUES ('352', '632200', '海北藏族自治州', '2', '630000');
INSERT INTO `z_common_area` VALUES ('353', '632300', '黄南藏族自治州', '2', '630000');
INSERT INTO `z_common_area` VALUES ('354', '632500', '海南藏族自治州', '2', '630000');
INSERT INTO `z_common_area` VALUES ('355', '632600', '果洛藏族自治州', '2', '630000');
INSERT INTO `z_common_area` VALUES ('356', '632700', '玉树藏族自治州', '2', '630000');
INSERT INTO `z_common_area` VALUES ('357', '632800', '海西蒙古族藏族自治州', '2', '630000');
INSERT INTO `z_common_area` VALUES ('358', '640100', '银川市', '2', '640000');
INSERT INTO `z_common_area` VALUES ('359', '640200', '石嘴山市', '2', '640000');
INSERT INTO `z_common_area` VALUES ('360', '640300', '吴忠市', '2', '640000');
INSERT INTO `z_common_area` VALUES ('361', '640400', '固原市', '2', '640000');
INSERT INTO `z_common_area` VALUES ('362', '640500', '中卫市', '2', '640000');
INSERT INTO `z_common_area` VALUES ('363', '650100', '乌鲁木齐市', '2', '650000');
INSERT INTO `z_common_area` VALUES ('364', '650200', '克拉玛依市', '2', '650000');
INSERT INTO `z_common_area` VALUES ('365', '650400', '吐鲁番市', '2', '650000');
INSERT INTO `z_common_area` VALUES ('366', '650500', '哈密市', '2', '650000');
INSERT INTO `z_common_area` VALUES ('367', '652300', '昌吉回族自治州', '2', '650000');
INSERT INTO `z_common_area` VALUES ('368', '652700', '博尔塔拉蒙古自治州', '2', '650000');
INSERT INTO `z_common_area` VALUES ('369', '652800', '巴音郭楞蒙古自治州', '2', '650000');
INSERT INTO `z_common_area` VALUES ('370', '652900', '阿克苏地区', '2', '650000');
INSERT INTO `z_common_area` VALUES ('371', '653000', '克孜勒苏柯尔克孜自治州', '2', '650000');
INSERT INTO `z_common_area` VALUES ('372', '653100', '喀什地区', '2', '650000');
INSERT INTO `z_common_area` VALUES ('373', '653200', '和田地区', '2', '650000');
INSERT INTO `z_common_area` VALUES ('374', '654000', '伊犁哈萨克自治州', '2', '650000');
INSERT INTO `z_common_area` VALUES ('375', '654200', '塔城地区', '2', '650000');
INSERT INTO `z_common_area` VALUES ('376', '654300', '阿勒泰地区', '2', '650000');
INSERT INTO `z_common_area` VALUES ('377', '659000', '自治区直辖县级行政区划', '2', '650000');
INSERT INTO `z_common_area` VALUES ('378', '710100', '台北市', '2', '710000');
INSERT INTO `z_common_area` VALUES ('379', '710200', '高雄市', '2', '710000');
INSERT INTO `z_common_area` VALUES ('380', '710300', '台南市', '2', '710000');
INSERT INTO `z_common_area` VALUES ('381', '710400', '台中市', '2', '710000');
INSERT INTO `z_common_area` VALUES ('382', '710500', '金门县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('383', '710600', '南投县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('384', '710700', '基隆市', '2', '710000');
INSERT INTO `z_common_area` VALUES ('385', '710800', '新竹市', '2', '710000');
INSERT INTO `z_common_area` VALUES ('386', '710900', '嘉义市', '2', '710000');
INSERT INTO `z_common_area` VALUES ('387', '711100', '新北市', '2', '710000');
INSERT INTO `z_common_area` VALUES ('388', '711200', '宜兰县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('389', '711300', '新竹县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('390', '711400', '桃园县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('391', '711500', '苗栗县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('392', '711700', '彰化县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('393', '711900', '嘉义县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('394', '712100', '云林县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('395', '712400', '屏东县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('396', '712500', '台东县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('397', '712600', '花莲县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('398', '712700', '澎湖县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('399', '712800', '连江县', '2', '710000');
INSERT INTO `z_common_area` VALUES ('400', '810100', '香港岛', '2', '810000');
INSERT INTO `z_common_area` VALUES ('401', '810200', '九龙', '2', '810000');
INSERT INTO `z_common_area` VALUES ('402', '810300', '新界', '2', '810000');
INSERT INTO `z_common_area` VALUES ('403', '820100', '澳门半岛', '2', '820000');
INSERT INTO `z_common_area` VALUES ('404', '820200', '离岛', '2', '820000');
INSERT INTO `z_common_area` VALUES ('405', '900400', '阿富汗', '2', '900000');
INSERT INTO `z_common_area` VALUES ('406', '900800', '阿尔巴尼亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('407', '901000', '南极洲', '2', '900000');
INSERT INTO `z_common_area` VALUES ('408', '901200', '阿尔及利亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('409', '901600', '美属萨摩亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('410', '902000', '安道尔', '2', '900000');
INSERT INTO `z_common_area` VALUES ('411', '902400', '安哥拉', '2', '900000');
INSERT INTO `z_common_area` VALUES ('412', '902800', '安提瓜和巴布达', '2', '900000');
INSERT INTO `z_common_area` VALUES ('413', '903100', '阿塞拜疆', '2', '900000');
INSERT INTO `z_common_area` VALUES ('414', '903200', '阿根廷', '2', '900000');
INSERT INTO `z_common_area` VALUES ('415', '903600', '澳大利亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('416', '904000', '奥地利', '2', '900000');
INSERT INTO `z_common_area` VALUES ('417', '904400', '巴哈马', '2', '900000');
INSERT INTO `z_common_area` VALUES ('418', '904800', '巴林', '2', '900000');
INSERT INTO `z_common_area` VALUES ('419', '905000', '孟加拉', '2', '900000');
INSERT INTO `z_common_area` VALUES ('420', '905100', '亚美尼亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('421', '905200', '巴巴多斯', '2', '900000');
INSERT INTO `z_common_area` VALUES ('422', '905600', '比利时', '2', '900000');
INSERT INTO `z_common_area` VALUES ('423', '906000', '百慕大', '2', '900000');
INSERT INTO `z_common_area` VALUES ('424', '906400', '不丹', '2', '900000');
INSERT INTO `z_common_area` VALUES ('425', '906800', '玻利维亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('426', '907000', '波黑', '2', '900000');
INSERT INTO `z_common_area` VALUES ('427', '907200', '博茨瓦纳', '2', '900000');
INSERT INTO `z_common_area` VALUES ('428', '907400', '布韦岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('429', '907600', '巴西', '2', '900000');
INSERT INTO `z_common_area` VALUES ('430', '908400', '伯利兹', '2', '900000');
INSERT INTO `z_common_area` VALUES ('431', '908600', '英属印度洋领地', '2', '900000');
INSERT INTO `z_common_area` VALUES ('432', '909000', '所罗门群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('433', '909200', '英属维尔京群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('434', '909600', '文莱', '2', '900000');
INSERT INTO `z_common_area` VALUES ('435', '910000', '保加利亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('436', '910400', '缅甸', '2', '900000');
INSERT INTO `z_common_area` VALUES ('437', '910800', '布隆迪', '2', '900000');
INSERT INTO `z_common_area` VALUES ('438', '911200', '白俄罗斯', '2', '900000');
INSERT INTO `z_common_area` VALUES ('439', '911600', '柬埔寨', '2', '900000');
INSERT INTO `z_common_area` VALUES ('440', '912000', '喀麦隆', '2', '900000');
INSERT INTO `z_common_area` VALUES ('441', '912400', '加拿大', '2', '900000');
INSERT INTO `z_common_area` VALUES ('442', '913200', '佛得角', '2', '900000');
INSERT INTO `z_common_area` VALUES ('443', '913600', '开曼群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('444', '914000', '中非', '2', '900000');
INSERT INTO `z_common_area` VALUES ('445', '914400', '斯里兰卡', '2', '900000');
INSERT INTO `z_common_area` VALUES ('446', '914800', '乍得', '2', '900000');
INSERT INTO `z_common_area` VALUES ('447', '915200', '智利', '2', '900000');
INSERT INTO `z_common_area` VALUES ('448', '916200', '圣诞岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('449', '916600', '科科斯群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('450', '917000', '哥伦比亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('451', '917400', '科摩罗', '2', '900000');
INSERT INTO `z_common_area` VALUES ('452', '917500', '马约特', '2', '900000');
INSERT INTO `z_common_area` VALUES ('453', '917800', '刚果（布）', '2', '900000');
INSERT INTO `z_common_area` VALUES ('454', '918000', '刚果（金）', '2', '900000');
INSERT INTO `z_common_area` VALUES ('455', '918400', '库克群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('456', '918800', '哥斯达黎加', '2', '900000');
INSERT INTO `z_common_area` VALUES ('457', '919100', '克罗地亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('458', '919200', '古巴', '2', '900000');
INSERT INTO `z_common_area` VALUES ('459', '919600', '塞浦路斯', '2', '900000');
INSERT INTO `z_common_area` VALUES ('460', '920300', '捷克', '2', '900000');
INSERT INTO `z_common_area` VALUES ('461', '920400', '贝宁', '2', '900000');
INSERT INTO `z_common_area` VALUES ('462', '920800', '丹麦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('463', '921200', '多米尼克', '2', '900000');
INSERT INTO `z_common_area` VALUES ('464', '921400', '多米尼加', '2', '900000');
INSERT INTO `z_common_area` VALUES ('465', '921800', '厄瓜多尔', '2', '900000');
INSERT INTO `z_common_area` VALUES ('466', '922200', '萨尔瓦多', '2', '900000');
INSERT INTO `z_common_area` VALUES ('467', '922600', '赤道几内亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('468', '923100', '埃塞俄比亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('469', '923200', '厄立特里亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('470', '923300', '爱沙尼亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('471', '923400', '法罗群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('472', '923800', '马尔维纳斯群岛（ 福克兰）', '2', '900000');
INSERT INTO `z_common_area` VALUES ('473', '923900', '南乔治亚岛和南桑威奇群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('474', '924200', '斐济群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('475', '924600', '芬兰', '2', '900000');
INSERT INTO `z_common_area` VALUES ('476', '924800', '奥兰群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('477', '925000', '法国', '2', '900000');
INSERT INTO `z_common_area` VALUES ('478', '925400', '法属圭亚那', '2', '900000');
INSERT INTO `z_common_area` VALUES ('479', '925800', '法属波利尼西亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('480', '926000', '法属南部领地', '2', '900000');
INSERT INTO `z_common_area` VALUES ('481', '926200', '吉布提', '2', '900000');
INSERT INTO `z_common_area` VALUES ('482', '926600', '加蓬', '2', '900000');
INSERT INTO `z_common_area` VALUES ('483', '926800', '格鲁吉亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('484', '927000', '冈比亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('485', '927500', '巴勒斯坦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('486', '927600', '德国', '2', '900000');
INSERT INTO `z_common_area` VALUES ('487', '928800', '加纳', '2', '900000');
INSERT INTO `z_common_area` VALUES ('488', '929200', '直布罗陀', '2', '900000');
INSERT INTO `z_common_area` VALUES ('489', '929600', '基里巴斯', '2', '900000');
INSERT INTO `z_common_area` VALUES ('490', '930000', '希腊', '2', '900000');
INSERT INTO `z_common_area` VALUES ('491', '930400', '格陵兰', '2', '900000');
INSERT INTO `z_common_area` VALUES ('492', '930800', '格林纳达', '2', '900000');
INSERT INTO `z_common_area` VALUES ('493', '931200', '瓜德罗普', '2', '900000');
INSERT INTO `z_common_area` VALUES ('494', '931600', '关岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('495', '932000', '危地马拉', '2', '900000');
INSERT INTO `z_common_area` VALUES ('496', '932400', '几内亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('497', '932800', '圭亚那', '2', '900000');
INSERT INTO `z_common_area` VALUES ('498', '933200', '海地', '2', '900000');
INSERT INTO `z_common_area` VALUES ('499', '933400', '赫德岛和麦克唐纳群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('500', '933600', '梵蒂冈', '2', '900000');
INSERT INTO `z_common_area` VALUES ('501', '934000', '洪都拉斯', '2', '900000');
INSERT INTO `z_common_area` VALUES ('502', '934800', '匈牙利', '2', '900000');
INSERT INTO `z_common_area` VALUES ('503', '935200', '冰岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('504', '935600', '印度', '2', '900000');
INSERT INTO `z_common_area` VALUES ('505', '936000', '印尼', '2', '900000');
INSERT INTO `z_common_area` VALUES ('506', '936400', '伊朗', '2', '900000');
INSERT INTO `z_common_area` VALUES ('507', '936800', '伊拉克', '2', '900000');
INSERT INTO `z_common_area` VALUES ('508', '937200', '爱尔兰', '2', '900000');
INSERT INTO `z_common_area` VALUES ('509', '937600', '以色列', '2', '900000');
INSERT INTO `z_common_area` VALUES ('510', '938000', '意大利', '2', '900000');
INSERT INTO `z_common_area` VALUES ('511', '938400', '科特迪瓦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('512', '938800', '牙买加', '2', '900000');
INSERT INTO `z_common_area` VALUES ('513', '939200', '日本', '2', '900000');
INSERT INTO `z_common_area` VALUES ('514', '939800', '哈萨克斯坦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('515', '940000', '约旦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('516', '940400', '肯尼亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('517', '940800', '朝鲜 北朝鲜', '2', '900000');
INSERT INTO `z_common_area` VALUES ('518', '941000', '韩国', '2', '900000');
INSERT INTO `z_common_area` VALUES ('519', '941400', '科威特', '2', '900000');
INSERT INTO `z_common_area` VALUES ('520', '941700', '吉尔吉斯斯坦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('521', '941800', '老挝', '2', '900000');
INSERT INTO `z_common_area` VALUES ('522', '942200', '黎巴嫩', '2', '900000');
INSERT INTO `z_common_area` VALUES ('523', '942600', '莱索托', '2', '900000');
INSERT INTO `z_common_area` VALUES ('524', '942800', '拉脱维亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('525', '943000', '利比里亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('526', '943400', '利比亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('527', '943800', '列支敦士登', '2', '900000');
INSERT INTO `z_common_area` VALUES ('528', '944000', '立陶宛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('529', '944200', '卢森堡', '2', '900000');
INSERT INTO `z_common_area` VALUES ('530', '945000', '马达加斯加', '2', '900000');
INSERT INTO `z_common_area` VALUES ('531', '945400', '马拉维', '2', '900000');
INSERT INTO `z_common_area` VALUES ('532', '945800', '马来西亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('533', '946200', '马尔代夫', '2', '900000');
INSERT INTO `z_common_area` VALUES ('534', '946600', '马里', '2', '900000');
INSERT INTO `z_common_area` VALUES ('535', '947000', '马耳他', '2', '900000');
INSERT INTO `z_common_area` VALUES ('536', '947400', '马提尼克', '2', '900000');
INSERT INTO `z_common_area` VALUES ('537', '947800', '毛里塔尼亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('538', '948000', '毛里求斯', '2', '900000');
INSERT INTO `z_common_area` VALUES ('539', '948400', '墨西哥', '2', '900000');
INSERT INTO `z_common_area` VALUES ('540', '949200', '摩纳哥', '2', '900000');
INSERT INTO `z_common_area` VALUES ('541', '949600', '蒙古国', '2', '900000');
INSERT INTO `z_common_area` VALUES ('542', '949800', '摩尔多瓦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('543', '949900', '黑山', '2', '900000');
INSERT INTO `z_common_area` VALUES ('544', '950000', '蒙塞拉特岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('545', '950400', '摩洛哥', '2', '900000');
INSERT INTO `z_common_area` VALUES ('546', '950800', '莫桑比克', '2', '900000');
INSERT INTO `z_common_area` VALUES ('547', '951200', '阿曼', '2', '900000');
INSERT INTO `z_common_area` VALUES ('548', '951600', '纳米比亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('549', '952000', '瑙鲁', '2', '900000');
INSERT INTO `z_common_area` VALUES ('550', '952400', '尼泊尔', '2', '900000');
INSERT INTO `z_common_area` VALUES ('551', '952800', '荷兰', '2', '900000');
INSERT INTO `z_common_area` VALUES ('552', '953300', '阿鲁巴', '2', '900000');
INSERT INTO `z_common_area` VALUES ('553', '953500', '荷兰加勒比区', '2', '900000');
INSERT INTO `z_common_area` VALUES ('554', '954000', '新喀里多尼亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('555', '954800', '瓦努阿图', '2', '900000');
INSERT INTO `z_common_area` VALUES ('556', '955400', '新西兰', '2', '900000');
INSERT INTO `z_common_area` VALUES ('557', '955800', '尼加拉瓜', '2', '900000');
INSERT INTO `z_common_area` VALUES ('558', '956200', '尼日尔', '2', '900000');
INSERT INTO `z_common_area` VALUES ('559', '956600', '尼日利亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('560', '957000', '纽埃', '2', '900000');
INSERT INTO `z_common_area` VALUES ('561', '957400', '诺福克岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('562', '957800', '挪威', '2', '900000');
INSERT INTO `z_common_area` VALUES ('563', '958000', '北马里亚纳群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('564', '958100', '美国本土外小岛屿', '2', '900000');
INSERT INTO `z_common_area` VALUES ('565', '958300', '密克罗尼西亚联邦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('566', '958400', '马绍尔群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('567', '958500', '帕劳', '2', '900000');
INSERT INTO `z_common_area` VALUES ('568', '958600', '巴基斯坦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('569', '959100', '巴拿马', '2', '900000');
INSERT INTO `z_common_area` VALUES ('570', '959800', '巴布亚新几内亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('571', '960000', '巴拉圭', '2', '900000');
INSERT INTO `z_common_area` VALUES ('572', '960400', '秘鲁', '2', '900000');
INSERT INTO `z_common_area` VALUES ('573', '960800', '菲律宾', '2', '900000');
INSERT INTO `z_common_area` VALUES ('574', '961200', '皮特凯恩群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('575', '961600', '波兰', '2', '900000');
INSERT INTO `z_common_area` VALUES ('576', '962000', '葡萄牙', '2', '900000');
INSERT INTO `z_common_area` VALUES ('577', '962400', '几内亚比绍', '2', '900000');
INSERT INTO `z_common_area` VALUES ('578', '962600', '东帝汶', '2', '900000');
INSERT INTO `z_common_area` VALUES ('579', '963000', '波多黎各', '2', '900000');
INSERT INTO `z_common_area` VALUES ('580', '963400', '卡塔尔', '2', '900000');
INSERT INTO `z_common_area` VALUES ('581', '963800', '留尼汪', '2', '900000');
INSERT INTO `z_common_area` VALUES ('582', '964200', '罗马尼亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('583', '964300', '俄罗斯', '2', '900000');
INSERT INTO `z_common_area` VALUES ('584', '964600', '卢旺达', '2', '900000');
INSERT INTO `z_common_area` VALUES ('585', '965200', '圣巴泰勒米岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('586', '965400', '圣赫勒拿', '2', '900000');
INSERT INTO `z_common_area` VALUES ('587', '965900', '圣基茨和尼维斯', '2', '900000');
INSERT INTO `z_common_area` VALUES ('588', '966000', '安圭拉', '2', '900000');
INSERT INTO `z_common_area` VALUES ('589', '966200', '圣卢西亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('590', '966300', '法属圣马丁', '2', '900000');
INSERT INTO `z_common_area` VALUES ('591', '966600', '圣皮埃尔和密克隆', '2', '900000');
INSERT INTO `z_common_area` VALUES ('592', '967000', '圣文森特和格林纳丁斯', '2', '900000');
INSERT INTO `z_common_area` VALUES ('593', '967400', '圣马力诺', '2', '900000');
INSERT INTO `z_common_area` VALUES ('594', '967800', '圣多美和普林西比', '2', '900000');
INSERT INTO `z_common_area` VALUES ('595', '968200', '沙特阿拉伯', '2', '900000');
INSERT INTO `z_common_area` VALUES ('596', '968600', '塞内加尔', '2', '900000');
INSERT INTO `z_common_area` VALUES ('597', '968800', '塞尔维亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('598', '969000', '塞舌尔', '2', '900000');
INSERT INTO `z_common_area` VALUES ('599', '969400', '塞拉利昂', '2', '900000');
INSERT INTO `z_common_area` VALUES ('600', '970200', '新加坡', '2', '900000');
INSERT INTO `z_common_area` VALUES ('601', '970300', '斯洛伐克', '2', '900000');
INSERT INTO `z_common_area` VALUES ('602', '970400', '越南', '2', '900000');
INSERT INTO `z_common_area` VALUES ('603', '970500', '斯洛文尼亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('604', '970600', '索马里', '2', '900000');
INSERT INTO `z_common_area` VALUES ('605', '971000', '南非', '2', '900000');
INSERT INTO `z_common_area` VALUES ('606', '971600', '津巴布韦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('607', '972400', '西班牙', '2', '900000');
INSERT INTO `z_common_area` VALUES ('608', '972800', '南苏丹', '2', '900000');
INSERT INTO `z_common_area` VALUES ('609', '972900', '苏丹', '2', '900000');
INSERT INTO `z_common_area` VALUES ('610', '973200', '西撒哈拉', '2', '900000');
INSERT INTO `z_common_area` VALUES ('611', '974000', '苏里南', '2', '900000');
INSERT INTO `z_common_area` VALUES ('612', '974400', '斯瓦尔巴群岛和 扬马延岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('613', '974800', '斯威士兰', '2', '900000');
INSERT INTO `z_common_area` VALUES ('614', '975200', '瑞典', '2', '900000');
INSERT INTO `z_common_area` VALUES ('615', '975600', '瑞士', '2', '900000');
INSERT INTO `z_common_area` VALUES ('616', '976000', '叙利亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('617', '976200', '塔吉克斯坦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('618', '976400', '泰国', '2', '900000');
INSERT INTO `z_common_area` VALUES ('619', '976800', '多哥', '2', '900000');
INSERT INTO `z_common_area` VALUES ('620', '977200', '托克劳', '2', '900000');
INSERT INTO `z_common_area` VALUES ('621', '977600', '汤加', '2', '900000');
INSERT INTO `z_common_area` VALUES ('622', '978000', '特立尼达和多巴哥', '2', '900000');
INSERT INTO `z_common_area` VALUES ('623', '978400', '阿联酋', '2', '900000');
INSERT INTO `z_common_area` VALUES ('624', '978800', '突尼斯', '2', '900000');
INSERT INTO `z_common_area` VALUES ('625', '979200', '土耳其', '2', '900000');
INSERT INTO `z_common_area` VALUES ('626', '979500', '土库曼斯坦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('627', '979600', '特克斯和凯科斯群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('628', '979800', '图瓦卢', '2', '900000');
INSERT INTO `z_common_area` VALUES ('629', '980000', '乌干达', '2', '900000');
INSERT INTO `z_common_area` VALUES ('630', '980400', '乌克兰', '2', '900000');
INSERT INTO `z_common_area` VALUES ('631', '980700', '马其顿', '2', '900000');
INSERT INTO `z_common_area` VALUES ('632', '981800', '埃及', '2', '900000');
INSERT INTO `z_common_area` VALUES ('633', '982600', '英国', '2', '900000');
INSERT INTO `z_common_area` VALUES ('634', '983100', '根西岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('635', '983200', '泽西岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('636', '983300', '马恩岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('637', '983400', '坦桑尼亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('638', '984000', '美国', '2', '900000');
INSERT INTO `z_common_area` VALUES ('639', '985000', '美属维尔京群岛', '2', '900000');
INSERT INTO `z_common_area` VALUES ('640', '985400', '布基纳法索', '2', '900000');
INSERT INTO `z_common_area` VALUES ('641', '985800', '乌拉圭', '2', '900000');
INSERT INTO `z_common_area` VALUES ('642', '986000', '乌兹别克斯坦', '2', '900000');
INSERT INTO `z_common_area` VALUES ('643', '986200', '委内瑞拉', '2', '900000');
INSERT INTO `z_common_area` VALUES ('644', '987600', '瓦利斯和富图纳', '2', '900000');
INSERT INTO `z_common_area` VALUES ('645', '988200', '萨摩亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('646', '988700', '也门', '2', '900000');
INSERT INTO `z_common_area` VALUES ('647', '989400', '赞比亚', '2', '900000');
INSERT INTO `z_common_area` VALUES ('648', '110101', '东城区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('649', '110102', '西城区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('650', '110105', '朝阳区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('651', '110106', '丰台区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('652', '110107', '石景山区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('653', '110108', '海淀区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('654', '110109', '门头沟区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('655', '110111', '房山区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('656', '110112', '通州区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('657', '110113', '顺义区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('658', '110114', '昌平区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('659', '110115', '大兴区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('660', '110116', '怀柔区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('661', '110117', '平谷区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('662', '110118', '密云区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('663', '110119', '延庆区', '3', '110100');
INSERT INTO `z_common_area` VALUES ('664', '120101', '和平区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('665', '120102', '河东区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('666', '120103', '河西区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('667', '120104', '南开区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('668', '120105', '河北区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('669', '120106', '红桥区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('670', '120110', '东丽区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('671', '120111', '西青区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('672', '120112', '津南区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('673', '120113', '北辰区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('674', '120114', '武清区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('675', '120115', '宝坻区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('676', '120116', '滨海新区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('677', '120117', '宁河区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('678', '120118', '静海区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('679', '120119', '蓟州区', '3', '120100');
INSERT INTO `z_common_area` VALUES ('680', '130102', '长安区', '3', '130100');
INSERT INTO `z_common_area` VALUES ('681', '130104', '桥西区', '3', '130100');
INSERT INTO `z_common_area` VALUES ('682', '130105', '新华区', '3', '130100');
INSERT INTO `z_common_area` VALUES ('683', '130107', '井陉矿区', '3', '130100');
INSERT INTO `z_common_area` VALUES ('684', '130108', '裕华区', '3', '130100');
INSERT INTO `z_common_area` VALUES ('685', '130109', '藁城区', '3', '130100');
INSERT INTO `z_common_area` VALUES ('686', '130110', '鹿泉区', '3', '130100');
INSERT INTO `z_common_area` VALUES ('687', '130111', '栾城区', '3', '130100');
INSERT INTO `z_common_area` VALUES ('688', '130121', '井陉县', '3', '130100');
INSERT INTO `z_common_area` VALUES ('689', '130123', '正定县', '3', '130100');
INSERT INTO `z_common_area` VALUES ('690', '130125', '行唐县', '3', '130100');
INSERT INTO `z_common_area` VALUES ('691', '130126', '灵寿县', '3', '130100');
INSERT INTO `z_common_area` VALUES ('692', '130127', '高邑县', '3', '130100');
INSERT INTO `z_common_area` VALUES ('693', '130128', '深泽县', '3', '130100');
INSERT INTO `z_common_area` VALUES ('694', '130129', '赞皇县', '3', '130100');
INSERT INTO `z_common_area` VALUES ('695', '130130', '无极县', '3', '130100');
INSERT INTO `z_common_area` VALUES ('696', '130131', '平山县', '3', '130100');
INSERT INTO `z_common_area` VALUES ('697', '130132', '元氏县', '3', '130100');
INSERT INTO `z_common_area` VALUES ('698', '130133', '赵县', '3', '130100');
INSERT INTO `z_common_area` VALUES ('699', '130181', '辛集市', '3', '130100');
INSERT INTO `z_common_area` VALUES ('700', '130183', '晋州市', '3', '130100');
INSERT INTO `z_common_area` VALUES ('701', '130184', '新乐市', '3', '130100');
INSERT INTO `z_common_area` VALUES ('702', '130202', '路南区', '3', '130200');
INSERT INTO `z_common_area` VALUES ('703', '130203', '路北区', '3', '130200');
INSERT INTO `z_common_area` VALUES ('704', '130204', '古冶区', '3', '130200');
INSERT INTO `z_common_area` VALUES ('705', '130205', '开平区', '3', '130200');
INSERT INTO `z_common_area` VALUES ('706', '130207', '丰南区', '3', '130200');
INSERT INTO `z_common_area` VALUES ('707', '130208', '丰润区', '3', '130200');
INSERT INTO `z_common_area` VALUES ('708', '130209', '曹妃甸区', '3', '130200');
INSERT INTO `z_common_area` VALUES ('709', '130224', '滦南县', '3', '130200');
INSERT INTO `z_common_area` VALUES ('710', '130225', '乐亭县', '3', '130200');
INSERT INTO `z_common_area` VALUES ('711', '130227', '迁西县', '3', '130200');
INSERT INTO `z_common_area` VALUES ('712', '130229', '玉田县', '3', '130200');
INSERT INTO `z_common_area` VALUES ('713', '130281', '遵化市', '3', '130200');
INSERT INTO `z_common_area` VALUES ('714', '130283', '迁安市', '3', '130200');
INSERT INTO `z_common_area` VALUES ('715', '130284', '滦州市', '3', '130200');
INSERT INTO `z_common_area` VALUES ('716', '130302', '海港区', '3', '130300');
INSERT INTO `z_common_area` VALUES ('717', '130303', '山海关区', '3', '130300');
INSERT INTO `z_common_area` VALUES ('718', '130304', '北戴河区', '3', '130300');
INSERT INTO `z_common_area` VALUES ('719', '130306', '抚宁区', '3', '130300');
INSERT INTO `z_common_area` VALUES ('720', '130321', '青龙满族自治县', '3', '130300');
INSERT INTO `z_common_area` VALUES ('721', '130322', '昌黎县', '3', '130300');
INSERT INTO `z_common_area` VALUES ('722', '130324', '卢龙县', '3', '130300');
INSERT INTO `z_common_area` VALUES ('723', '130390', '经济技术开发区', '3', '130300');
INSERT INTO `z_common_area` VALUES ('724', '130402', '邯山区', '3', '130400');
INSERT INTO `z_common_area` VALUES ('725', '130403', '丛台区', '3', '130400');
INSERT INTO `z_common_area` VALUES ('726', '130404', '复兴区', '3', '130400');
INSERT INTO `z_common_area` VALUES ('727', '130406', '峰峰矿区', '3', '130400');
INSERT INTO `z_common_area` VALUES ('728', '130407', '肥乡区', '3', '130400');
INSERT INTO `z_common_area` VALUES ('729', '130408', '永年区', '3', '130400');
INSERT INTO `z_common_area` VALUES ('730', '130423', '临漳县', '3', '130400');
INSERT INTO `z_common_area` VALUES ('731', '130424', '成安县', '3', '130400');
INSERT INTO `z_common_area` VALUES ('732', '130425', '大名县', '3', '130400');
INSERT INTO `z_common_area` VALUES ('733', '130426', '涉县', '3', '130400');
INSERT INTO `z_common_area` VALUES ('734', '130427', '磁县', '3', '130400');
INSERT INTO `z_common_area` VALUES ('735', '130430', '邱县', '3', '130400');
INSERT INTO `z_common_area` VALUES ('736', '130431', '鸡泽县', '3', '130400');
INSERT INTO `z_common_area` VALUES ('737', '130432', '广平县', '3', '130400');
INSERT INTO `z_common_area` VALUES ('738', '130433', '馆陶县', '3', '130400');
INSERT INTO `z_common_area` VALUES ('739', '130434', '魏县', '3', '130400');
INSERT INTO `z_common_area` VALUES ('740', '130435', '曲周县', '3', '130400');
INSERT INTO `z_common_area` VALUES ('741', '130481', '武安市', '3', '130400');
INSERT INTO `z_common_area` VALUES ('742', '130502', '桥东区', '3', '130500');
INSERT INTO `z_common_area` VALUES ('743', '130503', '桥西区', '3', '130500');
INSERT INTO `z_common_area` VALUES ('744', '130521', '邢台县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('745', '130522', '临城县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('746', '130523', '内丘县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('747', '130524', '柏乡县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('748', '130525', '隆尧县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('749', '130526', '任县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('750', '130527', '南和县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('751', '130528', '宁晋县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('752', '130529', '巨鹿县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('753', '130530', '新河县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('754', '130531', '广宗县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('755', '130532', '平乡县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('756', '130533', '威县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('757', '130534', '清河县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('758', '130535', '临西县', '3', '130500');
INSERT INTO `z_common_area` VALUES ('759', '130581', '南宫市', '3', '130500');
INSERT INTO `z_common_area` VALUES ('760', '130582', '沙河市', '3', '130500');
INSERT INTO `z_common_area` VALUES ('761', '130602', '竞秀区', '3', '130600');
INSERT INTO `z_common_area` VALUES ('762', '130606', '莲池区', '3', '130600');
INSERT INTO `z_common_area` VALUES ('763', '130607', '满城区', '3', '130600');
INSERT INTO `z_common_area` VALUES ('764', '130608', '清苑区', '3', '130600');
INSERT INTO `z_common_area` VALUES ('765', '130609', '徐水区', '3', '130600');
INSERT INTO `z_common_area` VALUES ('766', '130623', '涞水县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('767', '130624', '阜平县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('768', '130626', '定兴县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('769', '130627', '唐县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('770', '130628', '高阳县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('771', '130629', '容城县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('772', '130630', '涞源县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('773', '130631', '望都县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('774', '130632', '安新县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('775', '130633', '易县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('776', '130634', '曲阳县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('777', '130635', '蠡县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('778', '130636', '顺平县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('779', '130637', '博野县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('780', '130638', '雄县', '3', '130600');
INSERT INTO `z_common_area` VALUES ('781', '130681', '涿州市', '3', '130600');
INSERT INTO `z_common_area` VALUES ('782', '130682', '定州市', '3', '130600');
INSERT INTO `z_common_area` VALUES ('783', '130683', '安国市', '3', '130600');
INSERT INTO `z_common_area` VALUES ('784', '130684', '高碑店市', '3', '130600');
INSERT INTO `z_common_area` VALUES ('785', '130702', '桥东区', '3', '130700');
INSERT INTO `z_common_area` VALUES ('786', '130703', '桥西区', '3', '130700');
INSERT INTO `z_common_area` VALUES ('787', '130705', '宣化区', '3', '130700');
INSERT INTO `z_common_area` VALUES ('788', '130706', '下花园区', '3', '130700');
INSERT INTO `z_common_area` VALUES ('789', '130708', '万全区', '3', '130700');
INSERT INTO `z_common_area` VALUES ('790', '130709', '崇礼区', '3', '130700');
INSERT INTO `z_common_area` VALUES ('791', '130722', '张北县', '3', '130700');
INSERT INTO `z_common_area` VALUES ('792', '130723', '康保县', '3', '130700');
INSERT INTO `z_common_area` VALUES ('793', '130724', '沽源县', '3', '130700');
INSERT INTO `z_common_area` VALUES ('794', '130725', '尚义县', '3', '130700');
INSERT INTO `z_common_area` VALUES ('795', '130726', '蔚县', '3', '130700');
INSERT INTO `z_common_area` VALUES ('796', '130727', '阳原县', '3', '130700');
INSERT INTO `z_common_area` VALUES ('797', '130728', '怀安县', '3', '130700');
INSERT INTO `z_common_area` VALUES ('798', '130730', '怀来县', '3', '130700');
INSERT INTO `z_common_area` VALUES ('799', '130731', '涿鹿县', '3', '130700');
INSERT INTO `z_common_area` VALUES ('800', '130732', '赤城县', '3', '130700');
INSERT INTO `z_common_area` VALUES ('801', '130802', '双桥区', '3', '130800');
INSERT INTO `z_common_area` VALUES ('802', '130803', '双滦区', '3', '130800');
INSERT INTO `z_common_area` VALUES ('803', '130804', '鹰手营子矿区', '3', '130800');
INSERT INTO `z_common_area` VALUES ('804', '130821', '承德县', '3', '130800');
INSERT INTO `z_common_area` VALUES ('805', '130822', '兴隆县', '3', '130800');
INSERT INTO `z_common_area` VALUES ('806', '130824', '滦平县', '3', '130800');
INSERT INTO `z_common_area` VALUES ('807', '130825', '隆化县', '3', '130800');
INSERT INTO `z_common_area` VALUES ('808', '130826', '丰宁满族自治县', '3', '130800');
INSERT INTO `z_common_area` VALUES ('809', '130827', '宽城满族自治县', '3', '130800');
INSERT INTO `z_common_area` VALUES ('810', '130828', '围场满族蒙古族自治县', '3', '130800');
INSERT INTO `z_common_area` VALUES ('811', '130881', '平泉市', '3', '130800');
INSERT INTO `z_common_area` VALUES ('812', '130902', '新华区', '3', '130900');
INSERT INTO `z_common_area` VALUES ('813', '130903', '运河区', '3', '130900');
INSERT INTO `z_common_area` VALUES ('814', '130921', '沧县', '3', '130900');
INSERT INTO `z_common_area` VALUES ('815', '130922', '青县', '3', '130900');
INSERT INTO `z_common_area` VALUES ('816', '130923', '东光县', '3', '130900');
INSERT INTO `z_common_area` VALUES ('817', '130924', '海兴县', '3', '130900');
INSERT INTO `z_common_area` VALUES ('818', '130925', '盐山县', '3', '130900');
INSERT INTO `z_common_area` VALUES ('819', '130926', '肃宁县', '3', '130900');
INSERT INTO `z_common_area` VALUES ('820', '130927', '南皮县', '3', '130900');
INSERT INTO `z_common_area` VALUES ('821', '130928', '吴桥县', '3', '130900');
INSERT INTO `z_common_area` VALUES ('822', '130929', '献县', '3', '130900');
INSERT INTO `z_common_area` VALUES ('823', '130930', '孟村回族自治县', '3', '130900');
INSERT INTO `z_common_area` VALUES ('824', '130981', '泊头市', '3', '130900');
INSERT INTO `z_common_area` VALUES ('825', '130982', '任丘市', '3', '130900');
INSERT INTO `z_common_area` VALUES ('826', '130983', '黄骅市', '3', '130900');
INSERT INTO `z_common_area` VALUES ('827', '130984', '河间市', '3', '130900');
INSERT INTO `z_common_area` VALUES ('828', '131002', '安次区', '3', '131000');
INSERT INTO `z_common_area` VALUES ('829', '131003', '广阳区', '3', '131000');
INSERT INTO `z_common_area` VALUES ('830', '131022', '固安县', '3', '131000');
INSERT INTO `z_common_area` VALUES ('831', '131023', '永清县', '3', '131000');
INSERT INTO `z_common_area` VALUES ('832', '131024', '香河县', '3', '131000');
INSERT INTO `z_common_area` VALUES ('833', '131025', '大城县', '3', '131000');
INSERT INTO `z_common_area` VALUES ('834', '131026', '文安县', '3', '131000');
INSERT INTO `z_common_area` VALUES ('835', '131028', '大厂回族自治县', '3', '131000');
INSERT INTO `z_common_area` VALUES ('836', '131081', '霸州市', '3', '131000');
INSERT INTO `z_common_area` VALUES ('837', '131082', '三河市', '3', '131000');
INSERT INTO `z_common_area` VALUES ('838', '131090', '开发区', '3', '131000');
INSERT INTO `z_common_area` VALUES ('839', '131102', '桃城区', '3', '131100');
INSERT INTO `z_common_area` VALUES ('840', '131103', '冀州区', '3', '131100');
INSERT INTO `z_common_area` VALUES ('841', '131121', '枣强县', '3', '131100');
INSERT INTO `z_common_area` VALUES ('842', '131122', '武邑县', '3', '131100');
INSERT INTO `z_common_area` VALUES ('843', '131123', '武强县', '3', '131100');
INSERT INTO `z_common_area` VALUES ('844', '131124', '饶阳县', '3', '131100');
INSERT INTO `z_common_area` VALUES ('845', '131125', '安平县', '3', '131100');
INSERT INTO `z_common_area` VALUES ('846', '131126', '故城县', '3', '131100');
INSERT INTO `z_common_area` VALUES ('847', '131127', '景县', '3', '131100');
INSERT INTO `z_common_area` VALUES ('848', '131128', '阜城县', '3', '131100');
INSERT INTO `z_common_area` VALUES ('849', '131182', '深州市', '3', '131100');
INSERT INTO `z_common_area` VALUES ('850', '140105', '小店区', '3', '140100');
INSERT INTO `z_common_area` VALUES ('851', '140106', '迎泽区', '3', '140100');
INSERT INTO `z_common_area` VALUES ('852', '140107', '杏花岭区', '3', '140100');
INSERT INTO `z_common_area` VALUES ('853', '140108', '尖草坪区', '3', '140100');
INSERT INTO `z_common_area` VALUES ('854', '140109', '万柏林区', '3', '140100');
INSERT INTO `z_common_area` VALUES ('855', '140110', '晋源区', '3', '140100');
INSERT INTO `z_common_area` VALUES ('856', '140121', '清徐县', '3', '140100');
INSERT INTO `z_common_area` VALUES ('857', '140122', '阳曲县', '3', '140100');
INSERT INTO `z_common_area` VALUES ('858', '140123', '娄烦县', '3', '140100');
INSERT INTO `z_common_area` VALUES ('859', '140181', '古交市', '3', '140100');
INSERT INTO `z_common_area` VALUES ('860', '140212', '新荣区', '3', '140200');
INSERT INTO `z_common_area` VALUES ('861', '140213', '平城区', '3', '140200');
INSERT INTO `z_common_area` VALUES ('862', '140214', '云冈区', '3', '140200');
INSERT INTO `z_common_area` VALUES ('863', '140215', '云州区', '3', '140200');
INSERT INTO `z_common_area` VALUES ('864', '140221', '阳高县', '3', '140200');
INSERT INTO `z_common_area` VALUES ('865', '140222', '天镇县', '3', '140200');
INSERT INTO `z_common_area` VALUES ('866', '140223', '广灵县', '3', '140200');
INSERT INTO `z_common_area` VALUES ('867', '140224', '灵丘县', '3', '140200');
INSERT INTO `z_common_area` VALUES ('868', '140225', '浑源县', '3', '140200');
INSERT INTO `z_common_area` VALUES ('869', '140226', '左云县', '3', '140200');
INSERT INTO `z_common_area` VALUES ('870', '140302', '城区', '3', '140300');
INSERT INTO `z_common_area` VALUES ('871', '140303', '矿区', '3', '140300');
INSERT INTO `z_common_area` VALUES ('872', '140311', '郊区', '3', '140300');
INSERT INTO `z_common_area` VALUES ('873', '140321', '平定县', '3', '140300');
INSERT INTO `z_common_area` VALUES ('874', '140322', '盂县', '3', '140300');
INSERT INTO `z_common_area` VALUES ('875', '140403', '潞州区', '3', '140400');
INSERT INTO `z_common_area` VALUES ('876', '140404', '上党区', '3', '140400');
INSERT INTO `z_common_area` VALUES ('877', '140405', '屯留区', '3', '140400');
INSERT INTO `z_common_area` VALUES ('878', '140406', '潞城区', '3', '140400');
INSERT INTO `z_common_area` VALUES ('879', '140423', '襄垣县', '3', '140400');
INSERT INTO `z_common_area` VALUES ('880', '140425', '平顺县', '3', '140400');
INSERT INTO `z_common_area` VALUES ('881', '140426', '黎城县', '3', '140400');
INSERT INTO `z_common_area` VALUES ('882', '140427', '壶关县', '3', '140400');
INSERT INTO `z_common_area` VALUES ('883', '140428', '长子县', '3', '140400');
INSERT INTO `z_common_area` VALUES ('884', '140429', '武乡县', '3', '140400');
INSERT INTO `z_common_area` VALUES ('885', '140430', '沁县', '3', '140400');
INSERT INTO `z_common_area` VALUES ('886', '140431', '沁源县', '3', '140400');
INSERT INTO `z_common_area` VALUES ('887', '140502', '城区', '3', '140500');
INSERT INTO `z_common_area` VALUES ('888', '140521', '沁水县', '3', '140500');
INSERT INTO `z_common_area` VALUES ('889', '140522', '阳城县', '3', '140500');
INSERT INTO `z_common_area` VALUES ('890', '140524', '陵川县', '3', '140500');
INSERT INTO `z_common_area` VALUES ('891', '140525', '泽州县', '3', '140500');
INSERT INTO `z_common_area` VALUES ('892', '140581', '高平市', '3', '140500');
INSERT INTO `z_common_area` VALUES ('893', '140602', '朔城区', '3', '140600');
INSERT INTO `z_common_area` VALUES ('894', '140603', '平鲁区', '3', '140600');
INSERT INTO `z_common_area` VALUES ('895', '140621', '山阴县', '3', '140600');
INSERT INTO `z_common_area` VALUES ('896', '140622', '应县', '3', '140600');
INSERT INTO `z_common_area` VALUES ('897', '140623', '右玉县', '3', '140600');
INSERT INTO `z_common_area` VALUES ('898', '140681', '怀仁市', '3', '140600');
INSERT INTO `z_common_area` VALUES ('899', '140702', '榆次区', '3', '140700');
INSERT INTO `z_common_area` VALUES ('900', '140721', '榆社县', '3', '140700');
INSERT INTO `z_common_area` VALUES ('901', '140722', '左权县', '3', '140700');
INSERT INTO `z_common_area` VALUES ('902', '140723', '和顺县', '3', '140700');
INSERT INTO `z_common_area` VALUES ('903', '140724', '昔阳县', '3', '140700');
INSERT INTO `z_common_area` VALUES ('904', '140725', '寿阳县', '3', '140700');
INSERT INTO `z_common_area` VALUES ('905', '140726', '太谷县', '3', '140700');
INSERT INTO `z_common_area` VALUES ('906', '140727', '祁县', '3', '140700');
INSERT INTO `z_common_area` VALUES ('907', '140728', '平遥县', '3', '140700');
INSERT INTO `z_common_area` VALUES ('908', '140729', '灵石县', '3', '140700');
INSERT INTO `z_common_area` VALUES ('909', '140781', '介休市', '3', '140700');
INSERT INTO `z_common_area` VALUES ('910', '140802', '盐湖区', '3', '140800');
INSERT INTO `z_common_area` VALUES ('911', '140821', '临猗县', '3', '140800');
INSERT INTO `z_common_area` VALUES ('912', '140822', '万荣县', '3', '140800');
INSERT INTO `z_common_area` VALUES ('913', '140823', '闻喜县', '3', '140800');
INSERT INTO `z_common_area` VALUES ('914', '140824', '稷山县', '3', '140800');
INSERT INTO `z_common_area` VALUES ('915', '140825', '新绛县', '3', '140800');
INSERT INTO `z_common_area` VALUES ('916', '140826', '绛县', '3', '140800');
INSERT INTO `z_common_area` VALUES ('917', '140827', '垣曲县', '3', '140800');
INSERT INTO `z_common_area` VALUES ('918', '140828', '夏县', '3', '140800');
INSERT INTO `z_common_area` VALUES ('919', '140829', '平陆县', '3', '140800');
INSERT INTO `z_common_area` VALUES ('920', '140830', '芮城县', '3', '140800');
INSERT INTO `z_common_area` VALUES ('921', '140881', '永济市', '3', '140800');
INSERT INTO `z_common_area` VALUES ('922', '140882', '河津市', '3', '140800');
INSERT INTO `z_common_area` VALUES ('923', '140902', '忻府区', '3', '140900');
INSERT INTO `z_common_area` VALUES ('924', '140921', '定襄县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('925', '140922', '五台县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('926', '140923', '代县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('927', '140924', '繁峙县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('928', '140925', '宁武县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('929', '140926', '静乐县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('930', '140927', '神池县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('931', '140928', '五寨县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('932', '140929', '岢岚县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('933', '140930', '河曲县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('934', '140931', '保德县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('935', '140932', '偏关县', '3', '140900');
INSERT INTO `z_common_area` VALUES ('936', '140981', '原平市', '3', '140900');
INSERT INTO `z_common_area` VALUES ('937', '141002', '尧都区', '3', '141000');
INSERT INTO `z_common_area` VALUES ('938', '141021', '曲沃县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('939', '141022', '翼城县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('940', '141023', '襄汾县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('941', '141024', '洪洞县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('942', '141025', '古县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('943', '141026', '安泽县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('944', '141027', '浮山县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('945', '141028', '吉县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('946', '141029', '乡宁县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('947', '141030', '大宁县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('948', '141031', '隰县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('949', '141032', '永和县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('950', '141033', '蒲县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('951', '141034', '汾西县', '3', '141000');
INSERT INTO `z_common_area` VALUES ('952', '141081', '侯马市', '3', '141000');
INSERT INTO `z_common_area` VALUES ('953', '141082', '霍州市', '3', '141000');
INSERT INTO `z_common_area` VALUES ('954', '141102', '离石区', '3', '141100');
INSERT INTO `z_common_area` VALUES ('955', '141121', '文水县', '3', '141100');
INSERT INTO `z_common_area` VALUES ('956', '141122', '交城县', '3', '141100');
INSERT INTO `z_common_area` VALUES ('957', '141123', '兴县', '3', '141100');
INSERT INTO `z_common_area` VALUES ('958', '141124', '临县', '3', '141100');
INSERT INTO `z_common_area` VALUES ('959', '141125', '柳林县', '3', '141100');
INSERT INTO `z_common_area` VALUES ('960', '141126', '石楼县', '3', '141100');
INSERT INTO `z_common_area` VALUES ('961', '141127', '岚县', '3', '141100');
INSERT INTO `z_common_area` VALUES ('962', '141128', '方山县', '3', '141100');
INSERT INTO `z_common_area` VALUES ('963', '141129', '中阳县', '3', '141100');
INSERT INTO `z_common_area` VALUES ('964', '141130', '交口县', '3', '141100');
INSERT INTO `z_common_area` VALUES ('965', '141181', '孝义市', '3', '141100');
INSERT INTO `z_common_area` VALUES ('966', '141182', '汾阳市', '3', '141100');
INSERT INTO `z_common_area` VALUES ('967', '150102', '新城区', '3', '150100');
INSERT INTO `z_common_area` VALUES ('968', '150103', '回民区', '3', '150100');
INSERT INTO `z_common_area` VALUES ('969', '150104', '玉泉区', '3', '150100');
INSERT INTO `z_common_area` VALUES ('970', '150105', '赛罕区', '3', '150100');
INSERT INTO `z_common_area` VALUES ('971', '150121', '土默特左旗', '3', '150100');
INSERT INTO `z_common_area` VALUES ('972', '150122', '托克托县', '3', '150100');
INSERT INTO `z_common_area` VALUES ('973', '150123', '和林格尔县', '3', '150100');
INSERT INTO `z_common_area` VALUES ('974', '150124', '清水河县', '3', '150100');
INSERT INTO `z_common_area` VALUES ('975', '150125', '武川县', '3', '150100');
INSERT INTO `z_common_area` VALUES ('976', '150202', '东河区', '3', '150200');
INSERT INTO `z_common_area` VALUES ('977', '150203', '昆都仑区', '3', '150200');
INSERT INTO `z_common_area` VALUES ('978', '150204', '青山区', '3', '150200');
INSERT INTO `z_common_area` VALUES ('979', '150205', '石拐区', '3', '150200');
INSERT INTO `z_common_area` VALUES ('980', '150206', '白云鄂博矿区', '3', '150200');
INSERT INTO `z_common_area` VALUES ('981', '150207', '九原区', '3', '150200');
INSERT INTO `z_common_area` VALUES ('982', '150221', '土默特右旗', '3', '150200');
INSERT INTO `z_common_area` VALUES ('983', '150222', '固阳县', '3', '150200');
INSERT INTO `z_common_area` VALUES ('984', '150223', '达尔罕茂明安联合旗', '3', '150200');
INSERT INTO `z_common_area` VALUES ('985', '150302', '海勃湾区', '3', '150300');
INSERT INTO `z_common_area` VALUES ('986', '150303', '海南区', '3', '150300');
INSERT INTO `z_common_area` VALUES ('987', '150304', '乌达区', '3', '150300');
INSERT INTO `z_common_area` VALUES ('988', '150402', '红山区', '3', '150400');
INSERT INTO `z_common_area` VALUES ('989', '150403', '元宝山区', '3', '150400');
INSERT INTO `z_common_area` VALUES ('990', '150404', '松山区', '3', '150400');
INSERT INTO `z_common_area` VALUES ('991', '150421', '阿鲁科尔沁旗', '3', '150400');
INSERT INTO `z_common_area` VALUES ('992', '150422', '巴林左旗', '3', '150400');
INSERT INTO `z_common_area` VALUES ('993', '150423', '巴林右旗', '3', '150400');
INSERT INTO `z_common_area` VALUES ('994', '150424', '林西县', '3', '150400');
INSERT INTO `z_common_area` VALUES ('995', '150425', '克什克腾旗', '3', '150400');
INSERT INTO `z_common_area` VALUES ('996', '150426', '翁牛特旗', '3', '150400');
INSERT INTO `z_common_area` VALUES ('997', '150428', '喀喇沁旗', '3', '150400');
INSERT INTO `z_common_area` VALUES ('998', '150429', '宁城县', '3', '150400');
INSERT INTO `z_common_area` VALUES ('999', '150430', '敖汉旗', '3', '150400');
INSERT INTO `z_common_area` VALUES ('1000', '150502', '科尔沁区', '3', '150500');
INSERT INTO `z_common_area` VALUES ('1001', '150521', '科尔沁左翼中旗', '3', '150500');
INSERT INTO `z_common_area` VALUES ('1002', '150522', '科尔沁左翼后旗', '3', '150500');
INSERT INTO `z_common_area` VALUES ('1003', '150523', '开鲁县', '3', '150500');
INSERT INTO `z_common_area` VALUES ('1004', '150524', '库伦旗', '3', '150500');
INSERT INTO `z_common_area` VALUES ('1005', '150525', '奈曼旗', '3', '150500');
INSERT INTO `z_common_area` VALUES ('1006', '150526', '扎鲁特旗', '3', '150500');
INSERT INTO `z_common_area` VALUES ('1007', '150581', '霍林郭勒市', '3', '150500');
INSERT INTO `z_common_area` VALUES ('1008', '150602', '东胜区', '3', '150600');
INSERT INTO `z_common_area` VALUES ('1009', '150603', '康巴什区', '3', '150600');
INSERT INTO `z_common_area` VALUES ('1010', '150621', '达拉特旗', '3', '150600');
INSERT INTO `z_common_area` VALUES ('1011', '150622', '准格尔旗', '3', '150600');
INSERT INTO `z_common_area` VALUES ('1012', '150623', '鄂托克前旗', '3', '150600');
INSERT INTO `z_common_area` VALUES ('1013', '150624', '鄂托克旗', '3', '150600');
INSERT INTO `z_common_area` VALUES ('1014', '150625', '杭锦旗', '3', '150600');
INSERT INTO `z_common_area` VALUES ('1015', '150626', '乌审旗', '3', '150600');
INSERT INTO `z_common_area` VALUES ('1016', '150627', '伊金霍洛旗', '3', '150600');
INSERT INTO `z_common_area` VALUES ('1017', '150702', '海拉尔区', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1018', '150703', '扎赉诺尔区', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1019', '150721', '阿荣旗', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1020', '150722', '莫力达瓦达斡尔族自治旗', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1021', '150723', '鄂伦春自治旗', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1022', '150724', '鄂温克族自治旗', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1023', '150725', '陈巴尔虎旗', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1024', '150726', '新巴尔虎左旗', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1025', '150727', '新巴尔虎右旗', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1026', '150781', '满洲里市', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1027', '150782', '牙克石市', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1028', '150783', '扎兰屯市', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1029', '150784', '额尔古纳市', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1030', '150785', '根河市', '3', '150700');
INSERT INTO `z_common_area` VALUES ('1031', '150802', '临河区', '3', '150800');
INSERT INTO `z_common_area` VALUES ('1032', '150821', '五原县', '3', '150800');
INSERT INTO `z_common_area` VALUES ('1033', '150822', '磴口县', '3', '150800');
INSERT INTO `z_common_area` VALUES ('1034', '150823', '乌拉特前旗', '3', '150800');
INSERT INTO `z_common_area` VALUES ('1035', '150824', '乌拉特中旗', '3', '150800');
INSERT INTO `z_common_area` VALUES ('1036', '150825', '乌拉特后旗', '3', '150800');
INSERT INTO `z_common_area` VALUES ('1037', '150826', '杭锦后旗', '3', '150800');
INSERT INTO `z_common_area` VALUES ('1038', '150902', '集宁区', '3', '150900');
INSERT INTO `z_common_area` VALUES ('1039', '150921', '卓资县', '3', '150900');
INSERT INTO `z_common_area` VALUES ('1040', '150922', '化德县', '3', '150900');
INSERT INTO `z_common_area` VALUES ('1041', '150923', '商都县', '3', '150900');
INSERT INTO `z_common_area` VALUES ('1042', '150924', '兴和县', '3', '150900');
INSERT INTO `z_common_area` VALUES ('1043', '150925', '凉城县', '3', '150900');
INSERT INTO `z_common_area` VALUES ('1044', '150926', '察哈尔右翼前旗', '3', '150900');
INSERT INTO `z_common_area` VALUES ('1045', '150927', '察哈尔右翼中旗', '3', '150900');
INSERT INTO `z_common_area` VALUES ('1046', '150928', '察哈尔右翼后旗', '3', '150900');
INSERT INTO `z_common_area` VALUES ('1047', '150929', '四子王旗', '3', '150900');
INSERT INTO `z_common_area` VALUES ('1048', '150981', '丰镇市', '3', '150900');
INSERT INTO `z_common_area` VALUES ('1049', '152201', '乌兰浩特市', '3', '152200');
INSERT INTO `z_common_area` VALUES ('1050', '152202', '阿尔山市', '3', '152200');
INSERT INTO `z_common_area` VALUES ('1051', '152221', '科尔沁右翼前旗', '3', '152200');
INSERT INTO `z_common_area` VALUES ('1052', '152222', '科尔沁右翼中旗', '3', '152200');
INSERT INTO `z_common_area` VALUES ('1053', '152223', '扎赉特旗', '3', '152200');
INSERT INTO `z_common_area` VALUES ('1054', '152224', '突泉县', '3', '152200');
INSERT INTO `z_common_area` VALUES ('1055', '152501', '二连浩特市', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1056', '152502', '锡林浩特市', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1057', '152522', '阿巴嘎旗', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1058', '152523', '苏尼特左旗', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1059', '152524', '苏尼特右旗', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1060', '152525', '东乌珠穆沁旗', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1061', '152526', '西乌珠穆沁旗', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1062', '152527', '太仆寺旗', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1063', '152528', '镶黄旗', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1064', '152529', '正镶白旗', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1065', '152530', '正蓝旗', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1066', '152531', '多伦县', '3', '152500');
INSERT INTO `z_common_area` VALUES ('1067', '152921', '阿拉善左旗', '3', '152900');
INSERT INTO `z_common_area` VALUES ('1068', '152922', '阿拉善右旗', '3', '152900');
INSERT INTO `z_common_area` VALUES ('1069', '152923', '额济纳旗', '3', '152900');
INSERT INTO `z_common_area` VALUES ('1070', '210102', '和平区', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1071', '210103', '沈河区', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1072', '210104', '大东区', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1073', '210105', '皇姑区', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1074', '210106', '铁西区', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1075', '210111', '苏家屯区', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1076', '210112', '浑南区', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1077', '210113', '沈北新区', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1078', '210114', '于洪区', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1079', '210115', '辽中区', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1080', '210123', '康平县', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1081', '210124', '法库县', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1082', '210181', '新民市', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1083', '210190', '经济技术开发区', '3', '210100');
INSERT INTO `z_common_area` VALUES ('1084', '210202', '中山区', '3', '210200');
INSERT INTO `z_common_area` VALUES ('1085', '210203', '西岗区', '3', '210200');
INSERT INTO `z_common_area` VALUES ('1086', '210204', '沙河口区', '3', '210200');
INSERT INTO `z_common_area` VALUES ('1087', '210211', '甘井子区', '3', '210200');
INSERT INTO `z_common_area` VALUES ('1088', '210212', '旅顺口区', '3', '210200');
INSERT INTO `z_common_area` VALUES ('1089', '210213', '金州区', '3', '210200');
INSERT INTO `z_common_area` VALUES ('1090', '210214', '普兰店区', '3', '210200');
INSERT INTO `z_common_area` VALUES ('1091', '210224', '长海县', '3', '210200');
INSERT INTO `z_common_area` VALUES ('1092', '210281', '瓦房店市', '3', '210200');
INSERT INTO `z_common_area` VALUES ('1093', '210283', '庄河市', '3', '210200');
INSERT INTO `z_common_area` VALUES ('1094', '210302', '铁东区', '3', '210300');
INSERT INTO `z_common_area` VALUES ('1095', '210303', '铁西区', '3', '210300');
INSERT INTO `z_common_area` VALUES ('1096', '210304', '立山区', '3', '210300');
INSERT INTO `z_common_area` VALUES ('1097', '210311', '千山区', '3', '210300');
INSERT INTO `z_common_area` VALUES ('1098', '210321', '台安县', '3', '210300');
INSERT INTO `z_common_area` VALUES ('1099', '210323', '岫岩满族自治县', '3', '210300');
INSERT INTO `z_common_area` VALUES ('1100', '210381', '海城市', '3', '210300');
INSERT INTO `z_common_area` VALUES ('1101', '210390', '高新区', '3', '210300');
INSERT INTO `z_common_area` VALUES ('1102', '210402', '新抚区', '3', '210400');
INSERT INTO `z_common_area` VALUES ('1103', '210403', '东洲区', '3', '210400');
INSERT INTO `z_common_area` VALUES ('1104', '210404', '望花区', '3', '210400');
INSERT INTO `z_common_area` VALUES ('1105', '210411', '顺城区', '3', '210400');
INSERT INTO `z_common_area` VALUES ('1106', '210421', '抚顺县', '3', '210400');
INSERT INTO `z_common_area` VALUES ('1107', '210422', '新宾满族自治县', '3', '210400');
INSERT INTO `z_common_area` VALUES ('1108', '210423', '清原满族自治县', '3', '210400');
INSERT INTO `z_common_area` VALUES ('1109', '210502', '平山区', '3', '210500');
INSERT INTO `z_common_area` VALUES ('1110', '210503', '溪湖区', '3', '210500');
INSERT INTO `z_common_area` VALUES ('1111', '210504', '明山区', '3', '210500');
INSERT INTO `z_common_area` VALUES ('1112', '210505', '南芬区', '3', '210500');
INSERT INTO `z_common_area` VALUES ('1113', '210521', '本溪满族自治县', '3', '210500');
INSERT INTO `z_common_area` VALUES ('1114', '210522', '桓仁满族自治县', '3', '210500');
INSERT INTO `z_common_area` VALUES ('1115', '210602', '元宝区', '3', '210600');
INSERT INTO `z_common_area` VALUES ('1116', '210603', '振兴区', '3', '210600');
INSERT INTO `z_common_area` VALUES ('1117', '210604', '振安区', '3', '210600');
INSERT INTO `z_common_area` VALUES ('1118', '210624', '宽甸满族自治县', '3', '210600');
INSERT INTO `z_common_area` VALUES ('1119', '210681', '东港市', '3', '210600');
INSERT INTO `z_common_area` VALUES ('1120', '210682', '凤城市', '3', '210600');
INSERT INTO `z_common_area` VALUES ('1121', '210702', '古塔区', '3', '210700');
INSERT INTO `z_common_area` VALUES ('1122', '210703', '凌河区', '3', '210700');
INSERT INTO `z_common_area` VALUES ('1123', '210711', '太和区', '3', '210700');
INSERT INTO `z_common_area` VALUES ('1124', '210726', '黑山县', '3', '210700');
INSERT INTO `z_common_area` VALUES ('1125', '210727', '义县', '3', '210700');
INSERT INTO `z_common_area` VALUES ('1126', '210781', '凌海市', '3', '210700');
INSERT INTO `z_common_area` VALUES ('1127', '210782', '北镇市', '3', '210700');
INSERT INTO `z_common_area` VALUES ('1128', '210793', '经济技术开发区', '3', '210700');
INSERT INTO `z_common_area` VALUES ('1129', '210802', '站前区', '3', '210800');
INSERT INTO `z_common_area` VALUES ('1130', '210803', '西市区', '3', '210800');
INSERT INTO `z_common_area` VALUES ('1131', '210804', '鲅鱼圈区', '3', '210800');
INSERT INTO `z_common_area` VALUES ('1132', '210811', '老边区', '3', '210800');
INSERT INTO `z_common_area` VALUES ('1133', '210881', '盖州市', '3', '210800');
INSERT INTO `z_common_area` VALUES ('1134', '210882', '大石桥市', '3', '210800');
INSERT INTO `z_common_area` VALUES ('1135', '210902', '海州区', '3', '210900');
INSERT INTO `z_common_area` VALUES ('1136', '210903', '新邱区', '3', '210900');
INSERT INTO `z_common_area` VALUES ('1137', '210904', '太平区', '3', '210900');
INSERT INTO `z_common_area` VALUES ('1138', '210905', '清河门区', '3', '210900');
INSERT INTO `z_common_area` VALUES ('1139', '210911', '细河区', '3', '210900');
INSERT INTO `z_common_area` VALUES ('1140', '210921', '阜新蒙古族自治县', '3', '210900');
INSERT INTO `z_common_area` VALUES ('1141', '210922', '彰武县', '3', '210900');
INSERT INTO `z_common_area` VALUES ('1142', '211002', '白塔区', '3', '211000');
INSERT INTO `z_common_area` VALUES ('1143', '211003', '文圣区', '3', '211000');
INSERT INTO `z_common_area` VALUES ('1144', '211004', '宏伟区', '3', '211000');
INSERT INTO `z_common_area` VALUES ('1145', '211005', '弓长岭区', '3', '211000');
INSERT INTO `z_common_area` VALUES ('1146', '211011', '太子河区', '3', '211000');
INSERT INTO `z_common_area` VALUES ('1147', '211021', '辽阳县', '3', '211000');
INSERT INTO `z_common_area` VALUES ('1148', '211081', '灯塔市', '3', '211000');
INSERT INTO `z_common_area` VALUES ('1149', '211102', '双台子区', '3', '211100');
INSERT INTO `z_common_area` VALUES ('1150', '211103', '兴隆台区', '3', '211100');
INSERT INTO `z_common_area` VALUES ('1151', '211104', '大洼区', '3', '211100');
INSERT INTO `z_common_area` VALUES ('1152', '211122', '盘山县', '3', '211100');
INSERT INTO `z_common_area` VALUES ('1153', '211202', '银州区', '3', '211200');
INSERT INTO `z_common_area` VALUES ('1154', '211204', '清河区', '3', '211200');
INSERT INTO `z_common_area` VALUES ('1155', '211221', '铁岭县', '3', '211200');
INSERT INTO `z_common_area` VALUES ('1156', '211223', '西丰县', '3', '211200');
INSERT INTO `z_common_area` VALUES ('1157', '211224', '昌图县', '3', '211200');
INSERT INTO `z_common_area` VALUES ('1158', '211281', '调兵山市', '3', '211200');
INSERT INTO `z_common_area` VALUES ('1159', '211282', '开原市', '3', '211200');
INSERT INTO `z_common_area` VALUES ('1160', '211302', '双塔区', '3', '211300');
INSERT INTO `z_common_area` VALUES ('1161', '211303', '龙城区', '3', '211300');
INSERT INTO `z_common_area` VALUES ('1162', '211321', '朝阳县', '3', '211300');
INSERT INTO `z_common_area` VALUES ('1163', '211322', '建平县', '3', '211300');
INSERT INTO `z_common_area` VALUES ('1164', '211324', '喀喇沁左翼蒙古族自治县', '3', '211300');
INSERT INTO `z_common_area` VALUES ('1165', '211381', '北票市', '3', '211300');
INSERT INTO `z_common_area` VALUES ('1166', '211382', '凌源市', '3', '211300');
INSERT INTO `z_common_area` VALUES ('1167', '211402', '连山区', '3', '211400');
INSERT INTO `z_common_area` VALUES ('1168', '211403', '龙港区', '3', '211400');
INSERT INTO `z_common_area` VALUES ('1169', '211404', '南票区', '3', '211400');
INSERT INTO `z_common_area` VALUES ('1170', '211421', '绥中县', '3', '211400');
INSERT INTO `z_common_area` VALUES ('1171', '211422', '建昌县', '3', '211400');
INSERT INTO `z_common_area` VALUES ('1172', '211481', '兴城市', '3', '211400');
INSERT INTO `z_common_area` VALUES ('1173', '220102', '南关区', '3', '220100');
INSERT INTO `z_common_area` VALUES ('1174', '220103', '宽城区', '3', '220100');
INSERT INTO `z_common_area` VALUES ('1175', '220104', '朝阳区', '3', '220100');
INSERT INTO `z_common_area` VALUES ('1176', '220105', '二道区', '3', '220100');
INSERT INTO `z_common_area` VALUES ('1177', '220106', '绿园区', '3', '220100');
INSERT INTO `z_common_area` VALUES ('1178', '220112', '双阳区', '3', '220100');
INSERT INTO `z_common_area` VALUES ('1179', '220113', '九台区', '3', '220100');
INSERT INTO `z_common_area` VALUES ('1180', '220122', '农安县', '3', '220100');
INSERT INTO `z_common_area` VALUES ('1181', '220182', '榆树市', '3', '220100');
INSERT INTO `z_common_area` VALUES ('1182', '220183', '德惠市', '3', '220100');
INSERT INTO `z_common_area` VALUES ('1183', '220192', '经济技术开发区', '3', '220100');
INSERT INTO `z_common_area` VALUES ('1184', '220202', '昌邑区', '3', '220200');
INSERT INTO `z_common_area` VALUES ('1185', '220203', '龙潭区', '3', '220200');
INSERT INTO `z_common_area` VALUES ('1186', '220204', '船营区', '3', '220200');
INSERT INTO `z_common_area` VALUES ('1187', '220211', '丰满区', '3', '220200');
INSERT INTO `z_common_area` VALUES ('1188', '220221', '永吉县', '3', '220200');
INSERT INTO `z_common_area` VALUES ('1189', '220281', '蛟河市', '3', '220200');
INSERT INTO `z_common_area` VALUES ('1190', '220282', '桦甸市', '3', '220200');
INSERT INTO `z_common_area` VALUES ('1191', '220283', '舒兰市', '3', '220200');
INSERT INTO `z_common_area` VALUES ('1192', '220284', '磐石市', '3', '220200');
INSERT INTO `z_common_area` VALUES ('1193', '220302', '铁西区', '3', '220300');
INSERT INTO `z_common_area` VALUES ('1194', '220303', '铁东区', '3', '220300');
INSERT INTO `z_common_area` VALUES ('1195', '220322', '梨树县', '3', '220300');
INSERT INTO `z_common_area` VALUES ('1196', '220323', '伊通满族自治县', '3', '220300');
INSERT INTO `z_common_area` VALUES ('1197', '220381', '公主岭市', '3', '220300');
INSERT INTO `z_common_area` VALUES ('1198', '220382', '双辽市', '3', '220300');
INSERT INTO `z_common_area` VALUES ('1199', '220402', '龙山区', '3', '220400');
INSERT INTO `z_common_area` VALUES ('1200', '220403', '西安区', '3', '220400');
INSERT INTO `z_common_area` VALUES ('1201', '220421', '东丰县', '3', '220400');
INSERT INTO `z_common_area` VALUES ('1202', '220422', '东辽县', '3', '220400');
INSERT INTO `z_common_area` VALUES ('1203', '220502', '东昌区', '3', '220500');
INSERT INTO `z_common_area` VALUES ('1204', '220503', '二道江区', '3', '220500');
INSERT INTO `z_common_area` VALUES ('1205', '220521', '通化县', '3', '220500');
INSERT INTO `z_common_area` VALUES ('1206', '220523', '辉南县', '3', '220500');
INSERT INTO `z_common_area` VALUES ('1207', '220524', '柳河县', '3', '220500');
INSERT INTO `z_common_area` VALUES ('1208', '220581', '梅河口市', '3', '220500');
INSERT INTO `z_common_area` VALUES ('1209', '220582', '集安市', '3', '220500');
INSERT INTO `z_common_area` VALUES ('1210', '220602', '浑江区', '3', '220600');
INSERT INTO `z_common_area` VALUES ('1211', '220605', '江源区', '3', '220600');
INSERT INTO `z_common_area` VALUES ('1212', '220621', '抚松县', '3', '220600');
INSERT INTO `z_common_area` VALUES ('1213', '220622', '靖宇县', '3', '220600');
INSERT INTO `z_common_area` VALUES ('1214', '220623', '长白朝鲜族自治县', '3', '220600');
INSERT INTO `z_common_area` VALUES ('1215', '220681', '临江市', '3', '220600');
INSERT INTO `z_common_area` VALUES ('1216', '220702', '宁江区', '3', '220700');
INSERT INTO `z_common_area` VALUES ('1217', '220721', '前郭尔罗斯蒙古族自治县', '3', '220700');
INSERT INTO `z_common_area` VALUES ('1218', '220722', '长岭县', '3', '220700');
INSERT INTO `z_common_area` VALUES ('1219', '220723', '乾安县', '3', '220700');
INSERT INTO `z_common_area` VALUES ('1220', '220781', '扶余市', '3', '220700');
INSERT INTO `z_common_area` VALUES ('1221', '220802', '洮北区', '3', '220800');
INSERT INTO `z_common_area` VALUES ('1222', '220821', '镇赉县', '3', '220800');
INSERT INTO `z_common_area` VALUES ('1223', '220822', '通榆县', '3', '220800');
INSERT INTO `z_common_area` VALUES ('1224', '220881', '洮南市', '3', '220800');
INSERT INTO `z_common_area` VALUES ('1225', '220882', '大安市', '3', '220800');
INSERT INTO `z_common_area` VALUES ('1226', '222401', '延吉市', '3', '222400');
INSERT INTO `z_common_area` VALUES ('1227', '222402', '图们市', '3', '222400');
INSERT INTO `z_common_area` VALUES ('1228', '222403', '敦化市', '3', '222400');
INSERT INTO `z_common_area` VALUES ('1229', '222404', '珲春市', '3', '222400');
INSERT INTO `z_common_area` VALUES ('1230', '222405', '龙井市', '3', '222400');
INSERT INTO `z_common_area` VALUES ('1231', '222406', '和龙市', '3', '222400');
INSERT INTO `z_common_area` VALUES ('1232', '222424', '汪清县', '3', '222400');
INSERT INTO `z_common_area` VALUES ('1233', '222426', '安图县', '3', '222400');
INSERT INTO `z_common_area` VALUES ('1234', '230102', '道里区', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1235', '230103', '南岗区', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1236', '230104', '道外区', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1237', '230108', '平房区', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1238', '230109', '松北区', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1239', '230110', '香坊区', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1240', '230111', '呼兰区', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1241', '230112', '阿城区', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1242', '230113', '双城区', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1243', '230123', '依兰县', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1244', '230124', '方正县', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1245', '230125', '宾县', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1246', '230126', '巴彦县', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1247', '230127', '木兰县', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1248', '230128', '通河县', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1249', '230129', '延寿县', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1250', '230183', '尚志市', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1251', '230184', '五常市', '3', '230100');
INSERT INTO `z_common_area` VALUES ('1252', '230202', '龙沙区', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1253', '230203', '建华区', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1254', '230204', '铁锋区', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1255', '230205', '昂昂溪区', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1256', '230206', '富拉尔基区', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1257', '230207', '碾子山区', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1258', '230208', '梅里斯达斡尔族区', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1259', '230221', '龙江县', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1260', '230223', '依安县', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1261', '230224', '泰来县', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1262', '230225', '甘南县', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1263', '230227', '富裕县', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1264', '230229', '克山县', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1265', '230230', '克东县', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1266', '230231', '拜泉县', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1267', '230281', '讷河市', '3', '230200');
INSERT INTO `z_common_area` VALUES ('1268', '230302', '鸡冠区', '3', '230300');
INSERT INTO `z_common_area` VALUES ('1269', '230303', '恒山区', '3', '230300');
INSERT INTO `z_common_area` VALUES ('1270', '230304', '滴道区', '3', '230300');
INSERT INTO `z_common_area` VALUES ('1271', '230305', '梨树区', '3', '230300');
INSERT INTO `z_common_area` VALUES ('1272', '230306', '城子河区', '3', '230300');
INSERT INTO `z_common_area` VALUES ('1273', '230307', '麻山区', '3', '230300');
INSERT INTO `z_common_area` VALUES ('1274', '230321', '鸡东县', '3', '230300');
INSERT INTO `z_common_area` VALUES ('1275', '230381', '虎林市', '3', '230300');
INSERT INTO `z_common_area` VALUES ('1276', '230382', '密山市', '3', '230300');
INSERT INTO `z_common_area` VALUES ('1277', '230402', '向阳区', '3', '230400');
INSERT INTO `z_common_area` VALUES ('1278', '230403', '工农区', '3', '230400');
INSERT INTO `z_common_area` VALUES ('1279', '230404', '南山区', '3', '230400');
INSERT INTO `z_common_area` VALUES ('1280', '230405', '兴安区', '3', '230400');
INSERT INTO `z_common_area` VALUES ('1281', '230406', '东山区', '3', '230400');
INSERT INTO `z_common_area` VALUES ('1282', '230407', '兴山区', '3', '230400');
INSERT INTO `z_common_area` VALUES ('1283', '230421', '萝北县', '3', '230400');
INSERT INTO `z_common_area` VALUES ('1284', '230422', '绥滨县', '3', '230400');
INSERT INTO `z_common_area` VALUES ('1285', '230502', '尖山区', '3', '230500');
INSERT INTO `z_common_area` VALUES ('1286', '230503', '岭东区', '3', '230500');
INSERT INTO `z_common_area` VALUES ('1287', '230505', '四方台区', '3', '230500');
INSERT INTO `z_common_area` VALUES ('1288', '230506', '宝山区', '3', '230500');
INSERT INTO `z_common_area` VALUES ('1289', '230521', '集贤县', '3', '230500');
INSERT INTO `z_common_area` VALUES ('1290', '230522', '友谊县', '3', '230500');
INSERT INTO `z_common_area` VALUES ('1291', '230523', '宝清县', '3', '230500');
INSERT INTO `z_common_area` VALUES ('1292', '230524', '饶河县', '3', '230500');
INSERT INTO `z_common_area` VALUES ('1293', '230602', '萨尔图区', '3', '230600');
INSERT INTO `z_common_area` VALUES ('1294', '230603', '龙凤区', '3', '230600');
INSERT INTO `z_common_area` VALUES ('1295', '230604', '让胡路区', '3', '230600');
INSERT INTO `z_common_area` VALUES ('1296', '230605', '红岗区', '3', '230600');
INSERT INTO `z_common_area` VALUES ('1297', '230606', '大同区', '3', '230600');
INSERT INTO `z_common_area` VALUES ('1298', '230621', '肇州县', '3', '230600');
INSERT INTO `z_common_area` VALUES ('1299', '230622', '肇源县', '3', '230600');
INSERT INTO `z_common_area` VALUES ('1300', '230623', '林甸县', '3', '230600');
INSERT INTO `z_common_area` VALUES ('1301', '230624', '杜尔伯特蒙古族自治县', '3', '230600');
INSERT INTO `z_common_area` VALUES ('1302', '230702', '伊春区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1303', '230703', '南岔区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1304', '230704', '友好区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1305', '230705', '西林区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1306', '230706', '翠峦区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1307', '230707', '新青区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1308', '230708', '美溪区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1309', '230709', '金山屯区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1310', '230710', '五营区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1311', '230711', '乌马河区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1312', '230712', '汤旺河区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1313', '230713', '带岭区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1314', '230714', '乌伊岭区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1315', '230715', '红星区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1316', '230716', '上甘岭区', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1317', '230722', '嘉荫县', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1318', '230781', '铁力市', '3', '230700');
INSERT INTO `z_common_area` VALUES ('1319', '230803', '向阳区', '3', '230800');
INSERT INTO `z_common_area` VALUES ('1320', '230804', '前进区', '3', '230800');
INSERT INTO `z_common_area` VALUES ('1321', '230805', '东风区', '3', '230800');
INSERT INTO `z_common_area` VALUES ('1322', '230811', '郊区', '3', '230800');
INSERT INTO `z_common_area` VALUES ('1323', '230822', '桦南县', '3', '230800');
INSERT INTO `z_common_area` VALUES ('1324', '230826', '桦川县', '3', '230800');
INSERT INTO `z_common_area` VALUES ('1325', '230828', '汤原县', '3', '230800');
INSERT INTO `z_common_area` VALUES ('1326', '230881', '同江市', '3', '230800');
INSERT INTO `z_common_area` VALUES ('1327', '230882', '富锦市', '3', '230800');
INSERT INTO `z_common_area` VALUES ('1328', '230883', '抚远市', '3', '230800');
INSERT INTO `z_common_area` VALUES ('1329', '230902', '新兴区', '3', '230900');
INSERT INTO `z_common_area` VALUES ('1330', '230903', '桃山区', '3', '230900');
INSERT INTO `z_common_area` VALUES ('1331', '230904', '茄子河区', '3', '230900');
INSERT INTO `z_common_area` VALUES ('1332', '230921', '勃利县', '3', '230900');
INSERT INTO `z_common_area` VALUES ('1333', '231002', '东安区', '3', '231000');
INSERT INTO `z_common_area` VALUES ('1334', '231003', '阳明区', '3', '231000');
INSERT INTO `z_common_area` VALUES ('1335', '231004', '爱民区', '3', '231000');
INSERT INTO `z_common_area` VALUES ('1336', '231005', '西安区', '3', '231000');
INSERT INTO `z_common_area` VALUES ('1337', '231025', '林口县', '3', '231000');
INSERT INTO `z_common_area` VALUES ('1338', '231081', '绥芬河市', '3', '231000');
INSERT INTO `z_common_area` VALUES ('1339', '231083', '海林市', '3', '231000');
INSERT INTO `z_common_area` VALUES ('1340', '231084', '宁安市', '3', '231000');
INSERT INTO `z_common_area` VALUES ('1341', '231085', '穆棱市', '3', '231000');
INSERT INTO `z_common_area` VALUES ('1342', '231086', '东宁市', '3', '231000');
INSERT INTO `z_common_area` VALUES ('1343', '231102', '爱辉区', '3', '231100');
INSERT INTO `z_common_area` VALUES ('1344', '231121', '嫩江县', '3', '231100');
INSERT INTO `z_common_area` VALUES ('1345', '231123', '逊克县', '3', '231100');
INSERT INTO `z_common_area` VALUES ('1346', '231124', '孙吴县', '3', '231100');
INSERT INTO `z_common_area` VALUES ('1347', '231181', '北安市', '3', '231100');
INSERT INTO `z_common_area` VALUES ('1348', '231182', '五大连池市', '3', '231100');
INSERT INTO `z_common_area` VALUES ('1349', '231202', '北林区', '3', '231200');
INSERT INTO `z_common_area` VALUES ('1350', '231221', '望奎县', '3', '231200');
INSERT INTO `z_common_area` VALUES ('1351', '231222', '兰西县', '3', '231200');
INSERT INTO `z_common_area` VALUES ('1352', '231223', '青冈县', '3', '231200');
INSERT INTO `z_common_area` VALUES ('1353', '231224', '庆安县', '3', '231200');
INSERT INTO `z_common_area` VALUES ('1354', '231225', '明水县', '3', '231200');
INSERT INTO `z_common_area` VALUES ('1355', '231226', '绥棱县', '3', '231200');
INSERT INTO `z_common_area` VALUES ('1356', '231281', '安达市', '3', '231200');
INSERT INTO `z_common_area` VALUES ('1357', '231282', '肇东市', '3', '231200');
INSERT INTO `z_common_area` VALUES ('1358', '231283', '海伦市', '3', '231200');
INSERT INTO `z_common_area` VALUES ('1359', '232701', '漠河市', '3', '232700');
INSERT INTO `z_common_area` VALUES ('1360', '232721', '呼玛县', '3', '232700');
INSERT INTO `z_common_area` VALUES ('1361', '232722', '塔河县', '3', '232700');
INSERT INTO `z_common_area` VALUES ('1362', '232790', '松岭区', '3', '232700');
INSERT INTO `z_common_area` VALUES ('1363', '232791', '呼中区', '3', '232700');
INSERT INTO `z_common_area` VALUES ('1364', '232792', '加格达奇区', '3', '232700');
INSERT INTO `z_common_area` VALUES ('1365', '232793', '新林区', '3', '232700');
INSERT INTO `z_common_area` VALUES ('1366', '310101', '黄浦区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1367', '310104', '徐汇区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1368', '310105', '长宁区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1369', '310106', '静安区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1370', '310107', '普陀区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1371', '310109', '虹口区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1372', '310110', '杨浦区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1373', '310112', '闵行区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1374', '310113', '宝山区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1375', '310114', '嘉定区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1376', '310115', '浦东新区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1377', '310116', '金山区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1378', '310117', '松江区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1379', '310118', '青浦区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1380', '310120', '奉贤区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1381', '310151', '崇明区', '3', '310100');
INSERT INTO `z_common_area` VALUES ('1382', '320102', '玄武区', '3', '320100');
INSERT INTO `z_common_area` VALUES ('1383', '320104', '秦淮区', '3', '320100');
INSERT INTO `z_common_area` VALUES ('1384', '320105', '建邺区', '3', '320100');
INSERT INTO `z_common_area` VALUES ('1385', '320106', '鼓楼区', '3', '320100');
INSERT INTO `z_common_area` VALUES ('1386', '320111', '浦口区', '3', '320100');
INSERT INTO `z_common_area` VALUES ('1387', '320113', '栖霞区', '3', '320100');
INSERT INTO `z_common_area` VALUES ('1388', '320114', '雨花台区', '3', '320100');
INSERT INTO `z_common_area` VALUES ('1389', '320115', '江宁区', '3', '320100');
INSERT INTO `z_common_area` VALUES ('1390', '320116', '六合区', '3', '320100');
INSERT INTO `z_common_area` VALUES ('1391', '320117', '溧水区', '3', '320100');
INSERT INTO `z_common_area` VALUES ('1392', '320118', '高淳区', '3', '320100');
INSERT INTO `z_common_area` VALUES ('1393', '320205', '锡山区', '3', '320200');
INSERT INTO `z_common_area` VALUES ('1394', '320206', '惠山区', '3', '320200');
INSERT INTO `z_common_area` VALUES ('1395', '320211', '滨湖区', '3', '320200');
INSERT INTO `z_common_area` VALUES ('1396', '320213', '梁溪区', '3', '320200');
INSERT INTO `z_common_area` VALUES ('1397', '320214', '新吴区', '3', '320200');
INSERT INTO `z_common_area` VALUES ('1398', '320281', '江阴市', '3', '320200');
INSERT INTO `z_common_area` VALUES ('1399', '320282', '宜兴市', '3', '320200');
INSERT INTO `z_common_area` VALUES ('1400', '320302', '鼓楼区', '3', '320300');
INSERT INTO `z_common_area` VALUES ('1401', '320303', '云龙区', '3', '320300');
INSERT INTO `z_common_area` VALUES ('1402', '320305', '贾汪区', '3', '320300');
INSERT INTO `z_common_area` VALUES ('1403', '320311', '泉山区', '3', '320300');
INSERT INTO `z_common_area` VALUES ('1404', '320312', '铜山区', '3', '320300');
INSERT INTO `z_common_area` VALUES ('1405', '320321', '丰县', '3', '320300');
INSERT INTO `z_common_area` VALUES ('1406', '320322', '沛县', '3', '320300');
INSERT INTO `z_common_area` VALUES ('1407', '320324', '睢宁县', '3', '320300');
INSERT INTO `z_common_area` VALUES ('1408', '320381', '新沂市', '3', '320300');
INSERT INTO `z_common_area` VALUES ('1409', '320382', '邳州市', '3', '320300');
INSERT INTO `z_common_area` VALUES ('1410', '320391', '工业园区', '3', '320300');
INSERT INTO `z_common_area` VALUES ('1411', '320402', '天宁区', '3', '320400');
INSERT INTO `z_common_area` VALUES ('1412', '320404', '钟楼区', '3', '320400');
INSERT INTO `z_common_area` VALUES ('1413', '320411', '新北区', '3', '320400');
INSERT INTO `z_common_area` VALUES ('1414', '320412', '武进区', '3', '320400');
INSERT INTO `z_common_area` VALUES ('1415', '320413', '金坛区', '3', '320400');
INSERT INTO `z_common_area` VALUES ('1416', '320481', '溧阳市', '3', '320400');
INSERT INTO `z_common_area` VALUES ('1417', '320505', '虎丘区', '3', '320500');
INSERT INTO `z_common_area` VALUES ('1418', '320506', '吴中区', '3', '320500');
INSERT INTO `z_common_area` VALUES ('1419', '320507', '相城区', '3', '320500');
INSERT INTO `z_common_area` VALUES ('1420', '320508', '姑苏区', '3', '320500');
INSERT INTO `z_common_area` VALUES ('1421', '320509', '吴江区', '3', '320500');
INSERT INTO `z_common_area` VALUES ('1422', '320581', '常熟市', '3', '320500');
INSERT INTO `z_common_area` VALUES ('1423', '320582', '张家港市', '3', '320500');
INSERT INTO `z_common_area` VALUES ('1424', '320583', '昆山市', '3', '320500');
INSERT INTO `z_common_area` VALUES ('1425', '320585', '太仓市', '3', '320500');
INSERT INTO `z_common_area` VALUES ('1426', '320590', '工业园区', '3', '320500');
INSERT INTO `z_common_area` VALUES ('1427', '320591', '高新区', '3', '320500');
INSERT INTO `z_common_area` VALUES ('1428', '320602', '崇川区', '3', '320600');
INSERT INTO `z_common_area` VALUES ('1429', '320611', '港闸区', '3', '320600');
INSERT INTO `z_common_area` VALUES ('1430', '320612', '通州区', '3', '320600');
INSERT INTO `z_common_area` VALUES ('1431', '320623', '如东县', '3', '320600');
INSERT INTO `z_common_area` VALUES ('1432', '320681', '启东市', '3', '320600');
INSERT INTO `z_common_area` VALUES ('1433', '320682', '如皋市', '3', '320600');
INSERT INTO `z_common_area` VALUES ('1434', '320684', '海门市', '3', '320600');
INSERT INTO `z_common_area` VALUES ('1435', '320685', '海安市', '3', '320600');
INSERT INTO `z_common_area` VALUES ('1436', '320691', '高新区', '3', '320600');
INSERT INTO `z_common_area` VALUES ('1437', '320703', '连云区', '3', '320700');
INSERT INTO `z_common_area` VALUES ('1438', '320706', '海州区', '3', '320700');
INSERT INTO `z_common_area` VALUES ('1439', '320707', '赣榆区', '3', '320700');
INSERT INTO `z_common_area` VALUES ('1440', '320722', '东海县', '3', '320700');
INSERT INTO `z_common_area` VALUES ('1441', '320723', '灌云县', '3', '320700');
INSERT INTO `z_common_area` VALUES ('1442', '320724', '灌南县', '3', '320700');
INSERT INTO `z_common_area` VALUES ('1443', '320803', '淮安区', '3', '320800');
INSERT INTO `z_common_area` VALUES ('1444', '320804', '淮阴区', '3', '320800');
INSERT INTO `z_common_area` VALUES ('1445', '320812', '清江浦区', '3', '320800');
INSERT INTO `z_common_area` VALUES ('1446', '320813', '洪泽区', '3', '320800');
INSERT INTO `z_common_area` VALUES ('1447', '320826', '涟水县', '3', '320800');
INSERT INTO `z_common_area` VALUES ('1448', '320830', '盱眙县', '3', '320800');
INSERT INTO `z_common_area` VALUES ('1449', '320831', '金湖县', '3', '320800');
INSERT INTO `z_common_area` VALUES ('1450', '320890', '经济开发区', '3', '320800');
INSERT INTO `z_common_area` VALUES ('1451', '320902', '亭湖区', '3', '320900');
INSERT INTO `z_common_area` VALUES ('1452', '320903', '盐都区', '3', '320900');
INSERT INTO `z_common_area` VALUES ('1453', '320904', '大丰区', '3', '320900');
INSERT INTO `z_common_area` VALUES ('1454', '320921', '响水县', '3', '320900');
INSERT INTO `z_common_area` VALUES ('1455', '320922', '滨海县', '3', '320900');
INSERT INTO `z_common_area` VALUES ('1456', '320923', '阜宁县', '3', '320900');
INSERT INTO `z_common_area` VALUES ('1457', '320924', '射阳县', '3', '320900');
INSERT INTO `z_common_area` VALUES ('1458', '320925', '建湖县', '3', '320900');
INSERT INTO `z_common_area` VALUES ('1459', '320981', '东台市', '3', '320900');
INSERT INTO `z_common_area` VALUES ('1460', '321002', '广陵区', '3', '321000');
INSERT INTO `z_common_area` VALUES ('1461', '321003', '邗江区', '3', '321000');
INSERT INTO `z_common_area` VALUES ('1462', '321012', '江都区', '3', '321000');
INSERT INTO `z_common_area` VALUES ('1463', '321023', '宝应县', '3', '321000');
INSERT INTO `z_common_area` VALUES ('1464', '321081', '仪征市', '3', '321000');
INSERT INTO `z_common_area` VALUES ('1465', '321084', '高邮市', '3', '321000');
INSERT INTO `z_common_area` VALUES ('1466', '321090', '经济开发区', '3', '321000');
INSERT INTO `z_common_area` VALUES ('1467', '321102', '京口区', '3', '321100');
INSERT INTO `z_common_area` VALUES ('1468', '321111', '润州区', '3', '321100');
INSERT INTO `z_common_area` VALUES ('1469', '321112', '丹徒区', '3', '321100');
INSERT INTO `z_common_area` VALUES ('1470', '321181', '丹阳市', '3', '321100');
INSERT INTO `z_common_area` VALUES ('1471', '321182', '扬中市', '3', '321100');
INSERT INTO `z_common_area` VALUES ('1472', '321183', '句容市', '3', '321100');
INSERT INTO `z_common_area` VALUES ('1473', '321202', '海陵区', '3', '321200');
INSERT INTO `z_common_area` VALUES ('1474', '321203', '高港区', '3', '321200');
INSERT INTO `z_common_area` VALUES ('1475', '321204', '姜堰区', '3', '321200');
INSERT INTO `z_common_area` VALUES ('1476', '321281', '兴化市', '3', '321200');
INSERT INTO `z_common_area` VALUES ('1477', '321282', '靖江市', '3', '321200');
INSERT INTO `z_common_area` VALUES ('1478', '321283', '泰兴市', '3', '321200');
INSERT INTO `z_common_area` VALUES ('1479', '321302', '宿城区', '3', '321300');
INSERT INTO `z_common_area` VALUES ('1480', '321311', '宿豫区', '3', '321300');
INSERT INTO `z_common_area` VALUES ('1481', '321322', '沭阳县', '3', '321300');
INSERT INTO `z_common_area` VALUES ('1482', '321323', '泗阳县', '3', '321300');
INSERT INTO `z_common_area` VALUES ('1483', '321324', '泗洪县', '3', '321300');
INSERT INTO `z_common_area` VALUES ('1484', '330102', '上城区', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1485', '330103', '下城区', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1486', '330104', '江干区', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1487', '330105', '拱墅区', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1488', '330106', '西湖区', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1489', '330108', '滨江区', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1490', '330109', '萧山区', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1491', '330110', '余杭区', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1492', '330111', '富阳区', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1493', '330112', '临安区', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1494', '330122', '桐庐县', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1495', '330127', '淳安县', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1496', '330182', '建德市', '3', '330100');
INSERT INTO `z_common_area` VALUES ('1497', '330203', '海曙区', '3', '330200');
INSERT INTO `z_common_area` VALUES ('1498', '330205', '江北区', '3', '330200');
INSERT INTO `z_common_area` VALUES ('1499', '330206', '北仑区', '3', '330200');
INSERT INTO `z_common_area` VALUES ('1500', '330211', '镇海区', '3', '330200');
INSERT INTO `z_common_area` VALUES ('1501', '330212', '鄞州区', '3', '330200');
INSERT INTO `z_common_area` VALUES ('1502', '330213', '奉化区', '3', '330200');
INSERT INTO `z_common_area` VALUES ('1503', '330225', '象山县', '3', '330200');
INSERT INTO `z_common_area` VALUES ('1504', '330226', '宁海县', '3', '330200');
INSERT INTO `z_common_area` VALUES ('1505', '330281', '余姚市', '3', '330200');
INSERT INTO `z_common_area` VALUES ('1506', '330282', '慈溪市', '3', '330200');
INSERT INTO `z_common_area` VALUES ('1507', '330302', '鹿城区', '3', '330300');
INSERT INTO `z_common_area` VALUES ('1508', '330303', '龙湾区', '3', '330300');
INSERT INTO `z_common_area` VALUES ('1509', '330304', '瓯海区', '3', '330300');
INSERT INTO `z_common_area` VALUES ('1510', '330305', '洞头区', '3', '330300');
INSERT INTO `z_common_area` VALUES ('1511', '330324', '永嘉县', '3', '330300');
INSERT INTO `z_common_area` VALUES ('1512', '330326', '平阳县', '3', '330300');
INSERT INTO `z_common_area` VALUES ('1513', '330327', '苍南县', '3', '330300');
INSERT INTO `z_common_area` VALUES ('1514', '330328', '文成县', '3', '330300');
INSERT INTO `z_common_area` VALUES ('1515', '330329', '泰顺县', '3', '330300');
INSERT INTO `z_common_area` VALUES ('1516', '330381', '瑞安市', '3', '330300');
INSERT INTO `z_common_area` VALUES ('1517', '330382', '乐清市', '3', '330300');
INSERT INTO `z_common_area` VALUES ('1518', '330402', '南湖区', '3', '330400');
INSERT INTO `z_common_area` VALUES ('1519', '330411', '秀洲区', '3', '330400');
INSERT INTO `z_common_area` VALUES ('1520', '330421', '嘉善县', '3', '330400');
INSERT INTO `z_common_area` VALUES ('1521', '330424', '海盐县', '3', '330400');
INSERT INTO `z_common_area` VALUES ('1522', '330481', '海宁市', '3', '330400');
INSERT INTO `z_common_area` VALUES ('1523', '330482', '平湖市', '3', '330400');
INSERT INTO `z_common_area` VALUES ('1524', '330483', '桐乡市', '3', '330400');
INSERT INTO `z_common_area` VALUES ('1525', '330502', '吴兴区', '3', '330500');
INSERT INTO `z_common_area` VALUES ('1526', '330503', '南浔区', '3', '330500');
INSERT INTO `z_common_area` VALUES ('1527', '330521', '德清县', '3', '330500');
INSERT INTO `z_common_area` VALUES ('1528', '330522', '长兴县', '3', '330500');
INSERT INTO `z_common_area` VALUES ('1529', '330523', '安吉县', '3', '330500');
INSERT INTO `z_common_area` VALUES ('1530', '330602', '越城区', '3', '330600');
INSERT INTO `z_common_area` VALUES ('1531', '330603', '柯桥区', '3', '330600');
INSERT INTO `z_common_area` VALUES ('1532', '330604', '上虞区', '3', '330600');
INSERT INTO `z_common_area` VALUES ('1533', '330624', '新昌县', '3', '330600');
INSERT INTO `z_common_area` VALUES ('1534', '330681', '诸暨市', '3', '330600');
INSERT INTO `z_common_area` VALUES ('1535', '330683', '嵊州市', '3', '330600');
INSERT INTO `z_common_area` VALUES ('1536', '330702', '婺城区', '3', '330700');
INSERT INTO `z_common_area` VALUES ('1537', '330703', '金东区', '3', '330700');
INSERT INTO `z_common_area` VALUES ('1538', '330723', '武义县', '3', '330700');
INSERT INTO `z_common_area` VALUES ('1539', '330726', '浦江县', '3', '330700');
INSERT INTO `z_common_area` VALUES ('1540', '330727', '磐安县', '3', '330700');
INSERT INTO `z_common_area` VALUES ('1541', '330781', '兰溪市', '3', '330700');
INSERT INTO `z_common_area` VALUES ('1542', '330782', '义乌市', '3', '330700');
INSERT INTO `z_common_area` VALUES ('1543', '330783', '东阳市', '3', '330700');
INSERT INTO `z_common_area` VALUES ('1544', '330784', '永康市', '3', '330700');
INSERT INTO `z_common_area` VALUES ('1545', '330802', '柯城区', '3', '330800');
INSERT INTO `z_common_area` VALUES ('1546', '330803', '衢江区', '3', '330800');
INSERT INTO `z_common_area` VALUES ('1547', '330822', '常山县', '3', '330800');
INSERT INTO `z_common_area` VALUES ('1548', '330824', '开化县', '3', '330800');
INSERT INTO `z_common_area` VALUES ('1549', '330825', '龙游县', '3', '330800');
INSERT INTO `z_common_area` VALUES ('1550', '330881', '江山市', '3', '330800');
INSERT INTO `z_common_area` VALUES ('1551', '330902', '定海区', '3', '330900');
INSERT INTO `z_common_area` VALUES ('1552', '330903', '普陀区', '3', '330900');
INSERT INTO `z_common_area` VALUES ('1553', '330921', '岱山县', '3', '330900');
INSERT INTO `z_common_area` VALUES ('1554', '330922', '嵊泗县', '3', '330900');
INSERT INTO `z_common_area` VALUES ('1555', '331002', '椒江区', '3', '331000');
INSERT INTO `z_common_area` VALUES ('1556', '331003', '黄岩区', '3', '331000');
INSERT INTO `z_common_area` VALUES ('1557', '331004', '路桥区', '3', '331000');
INSERT INTO `z_common_area` VALUES ('1558', '331022', '三门县', '3', '331000');
INSERT INTO `z_common_area` VALUES ('1559', '331023', '天台县', '3', '331000');
INSERT INTO `z_common_area` VALUES ('1560', '331024', '仙居县', '3', '331000');
INSERT INTO `z_common_area` VALUES ('1561', '331081', '温岭市', '3', '331000');
INSERT INTO `z_common_area` VALUES ('1562', '331082', '临海市', '3', '331000');
INSERT INTO `z_common_area` VALUES ('1563', '331083', '玉环市', '3', '331000');
INSERT INTO `z_common_area` VALUES ('1564', '331102', '莲都区', '3', '331100');
INSERT INTO `z_common_area` VALUES ('1565', '331121', '青田县', '3', '331100');
INSERT INTO `z_common_area` VALUES ('1566', '331122', '缙云县', '3', '331100');
INSERT INTO `z_common_area` VALUES ('1567', '331123', '遂昌县', '3', '331100');
INSERT INTO `z_common_area` VALUES ('1568', '331124', '松阳县', '3', '331100');
INSERT INTO `z_common_area` VALUES ('1569', '331125', '云和县', '3', '331100');
INSERT INTO `z_common_area` VALUES ('1570', '331126', '庆元县', '3', '331100');
INSERT INTO `z_common_area` VALUES ('1571', '331127', '景宁畲族自治县', '3', '331100');
INSERT INTO `z_common_area` VALUES ('1572', '331181', '龙泉市', '3', '331100');
INSERT INTO `z_common_area` VALUES ('1573', '340102', '瑶海区', '3', '340100');
INSERT INTO `z_common_area` VALUES ('1574', '340103', '庐阳区', '3', '340100');
INSERT INTO `z_common_area` VALUES ('1575', '340104', '蜀山区', '3', '340100');
INSERT INTO `z_common_area` VALUES ('1576', '340111', '包河区', '3', '340100');
INSERT INTO `z_common_area` VALUES ('1577', '340121', '长丰县', '3', '340100');
INSERT INTO `z_common_area` VALUES ('1578', '340122', '肥东县', '3', '340100');
INSERT INTO `z_common_area` VALUES ('1579', '340123', '肥西县', '3', '340100');
INSERT INTO `z_common_area` VALUES ('1580', '340124', '庐江县', '3', '340100');
INSERT INTO `z_common_area` VALUES ('1581', '340181', '巢湖市', '3', '340100');
INSERT INTO `z_common_area` VALUES ('1582', '340190', '高新技术开发区', '3', '340100');
INSERT INTO `z_common_area` VALUES ('1583', '340191', '经济技术开发区', '3', '340100');
INSERT INTO `z_common_area` VALUES ('1584', '340202', '镜湖区', '3', '340200');
INSERT INTO `z_common_area` VALUES ('1585', '340203', '弋江区', '3', '340200');
INSERT INTO `z_common_area` VALUES ('1586', '340207', '鸠江区', '3', '340200');
INSERT INTO `z_common_area` VALUES ('1587', '340208', '三山区', '3', '340200');
INSERT INTO `z_common_area` VALUES ('1588', '340221', '芜湖县', '3', '340200');
INSERT INTO `z_common_area` VALUES ('1589', '340222', '繁昌县', '3', '340200');
INSERT INTO `z_common_area` VALUES ('1590', '340223', '南陵县', '3', '340200');
INSERT INTO `z_common_area` VALUES ('1591', '340225', '无为县', '3', '340200');
INSERT INTO `z_common_area` VALUES ('1592', '340302', '龙子湖区', '3', '340300');
INSERT INTO `z_common_area` VALUES ('1593', '340303', '蚌山区', '3', '340300');
INSERT INTO `z_common_area` VALUES ('1594', '340304', '禹会区', '3', '340300');
INSERT INTO `z_common_area` VALUES ('1595', '340311', '淮上区', '3', '340300');
INSERT INTO `z_common_area` VALUES ('1596', '340321', '怀远县', '3', '340300');
INSERT INTO `z_common_area` VALUES ('1597', '340322', '五河县', '3', '340300');
INSERT INTO `z_common_area` VALUES ('1598', '340323', '固镇县', '3', '340300');
INSERT INTO `z_common_area` VALUES ('1599', '340402', '大通区', '3', '340400');
INSERT INTO `z_common_area` VALUES ('1600', '340403', '田家庵区', '3', '340400');
INSERT INTO `z_common_area` VALUES ('1601', '340404', '谢家集区', '3', '340400');
INSERT INTO `z_common_area` VALUES ('1602', '340405', '八公山区', '3', '340400');
INSERT INTO `z_common_area` VALUES ('1603', '340406', '潘集区', '3', '340400');
INSERT INTO `z_common_area` VALUES ('1604', '340421', '凤台县', '3', '340400');
INSERT INTO `z_common_area` VALUES ('1605', '340422', '寿县', '3', '340400');
INSERT INTO `z_common_area` VALUES ('1606', '340503', '花山区', '3', '340500');
INSERT INTO `z_common_area` VALUES ('1607', '340504', '雨山区', '3', '340500');
INSERT INTO `z_common_area` VALUES ('1608', '340506', '博望区', '3', '340500');
INSERT INTO `z_common_area` VALUES ('1609', '340521', '当涂县', '3', '340500');
INSERT INTO `z_common_area` VALUES ('1610', '340522', '含山县', '3', '340500');
INSERT INTO `z_common_area` VALUES ('1611', '340523', '和县', '3', '340500');
INSERT INTO `z_common_area` VALUES ('1612', '340602', '杜集区', '3', '340600');
INSERT INTO `z_common_area` VALUES ('1613', '340603', '相山区', '3', '340600');
INSERT INTO `z_common_area` VALUES ('1614', '340604', '烈山区', '3', '340600');
INSERT INTO `z_common_area` VALUES ('1615', '340621', '濉溪县', '3', '340600');
INSERT INTO `z_common_area` VALUES ('1616', '340705', '铜官区', '3', '340700');
INSERT INTO `z_common_area` VALUES ('1617', '340706', '义安区', '3', '340700');
INSERT INTO `z_common_area` VALUES ('1618', '340711', '郊区', '3', '340700');
INSERT INTO `z_common_area` VALUES ('1619', '340722', '枞阳县', '3', '340700');
INSERT INTO `z_common_area` VALUES ('1620', '340802', '迎江区', '3', '340800');
INSERT INTO `z_common_area` VALUES ('1621', '340803', '大观区', '3', '340800');
INSERT INTO `z_common_area` VALUES ('1622', '340811', '宜秀区', '3', '340800');
INSERT INTO `z_common_area` VALUES ('1623', '340822', '怀宁县', '3', '340800');
INSERT INTO `z_common_area` VALUES ('1624', '340824', '潜山县', '3', '340800');
INSERT INTO `z_common_area` VALUES ('1625', '340825', '太湖县', '3', '340800');
INSERT INTO `z_common_area` VALUES ('1626', '340826', '宿松县', '3', '340800');
INSERT INTO `z_common_area` VALUES ('1627', '340827', '望江县', '3', '340800');
INSERT INTO `z_common_area` VALUES ('1628', '340828', '岳西县', '3', '340800');
INSERT INTO `z_common_area` VALUES ('1629', '340881', '桐城市', '3', '340800');
INSERT INTO `z_common_area` VALUES ('1630', '341002', '屯溪区', '3', '341000');
INSERT INTO `z_common_area` VALUES ('1631', '341003', '黄山区', '3', '341000');
INSERT INTO `z_common_area` VALUES ('1632', '341004', '徽州区', '3', '341000');
INSERT INTO `z_common_area` VALUES ('1633', '341021', '歙县', '3', '341000');
INSERT INTO `z_common_area` VALUES ('1634', '341022', '休宁县', '3', '341000');
INSERT INTO `z_common_area` VALUES ('1635', '341023', '黟县', '3', '341000');
INSERT INTO `z_common_area` VALUES ('1636', '341024', '祁门县', '3', '341000');
INSERT INTO `z_common_area` VALUES ('1637', '341102', '琅琊区', '3', '341100');
INSERT INTO `z_common_area` VALUES ('1638', '341103', '南谯区', '3', '341100');
INSERT INTO `z_common_area` VALUES ('1639', '341122', '来安县', '3', '341100');
INSERT INTO `z_common_area` VALUES ('1640', '341124', '全椒县', '3', '341100');
INSERT INTO `z_common_area` VALUES ('1641', '341125', '定远县', '3', '341100');
INSERT INTO `z_common_area` VALUES ('1642', '341126', '凤阳县', '3', '341100');
INSERT INTO `z_common_area` VALUES ('1643', '341181', '天长市', '3', '341100');
INSERT INTO `z_common_area` VALUES ('1644', '341182', '明光市', '3', '341100');
INSERT INTO `z_common_area` VALUES ('1645', '341202', '颍州区', '3', '341200');
INSERT INTO `z_common_area` VALUES ('1646', '341203', '颍东区', '3', '341200');
INSERT INTO `z_common_area` VALUES ('1647', '341204', '颍泉区', '3', '341200');
INSERT INTO `z_common_area` VALUES ('1648', '341221', '临泉县', '3', '341200');
INSERT INTO `z_common_area` VALUES ('1649', '341222', '太和县', '3', '341200');
INSERT INTO `z_common_area` VALUES ('1650', '341225', '阜南县', '3', '341200');
INSERT INTO `z_common_area` VALUES ('1651', '341226', '颍上县', '3', '341200');
INSERT INTO `z_common_area` VALUES ('1652', '341282', '界首市', '3', '341200');
INSERT INTO `z_common_area` VALUES ('1653', '341302', '埇桥区', '3', '341300');
INSERT INTO `z_common_area` VALUES ('1654', '341321', '砀山县', '3', '341300');
INSERT INTO `z_common_area` VALUES ('1655', '341322', '萧县', '3', '341300');
INSERT INTO `z_common_area` VALUES ('1656', '341323', '灵璧县', '3', '341300');
INSERT INTO `z_common_area` VALUES ('1657', '341324', '泗县', '3', '341300');
INSERT INTO `z_common_area` VALUES ('1658', '341390', '经济开发区', '3', '341300');
INSERT INTO `z_common_area` VALUES ('1659', '341502', '金安区', '3', '341500');
INSERT INTO `z_common_area` VALUES ('1660', '341503', '裕安区', '3', '341500');
INSERT INTO `z_common_area` VALUES ('1661', '341504', '叶集区', '3', '341500');
INSERT INTO `z_common_area` VALUES ('1662', '341522', '霍邱县', '3', '341500');
INSERT INTO `z_common_area` VALUES ('1663', '341523', '舒城县', '3', '341500');
INSERT INTO `z_common_area` VALUES ('1664', '341524', '金寨县', '3', '341500');
INSERT INTO `z_common_area` VALUES ('1665', '341525', '霍山县', '3', '341500');
INSERT INTO `z_common_area` VALUES ('1666', '341602', '谯城区', '3', '341600');
INSERT INTO `z_common_area` VALUES ('1667', '341621', '涡阳县', '3', '341600');
INSERT INTO `z_common_area` VALUES ('1668', '341622', '蒙城县', '3', '341600');
INSERT INTO `z_common_area` VALUES ('1669', '341623', '利辛县', '3', '341600');
INSERT INTO `z_common_area` VALUES ('1670', '341702', '贵池区', '3', '341700');
INSERT INTO `z_common_area` VALUES ('1671', '341721', '东至县', '3', '341700');
INSERT INTO `z_common_area` VALUES ('1672', '341722', '石台县', '3', '341700');
INSERT INTO `z_common_area` VALUES ('1673', '341723', '青阳县', '3', '341700');
INSERT INTO `z_common_area` VALUES ('1674', '341802', '宣州区', '3', '341800');
INSERT INTO `z_common_area` VALUES ('1675', '341821', '郎溪县', '3', '341800');
INSERT INTO `z_common_area` VALUES ('1676', '341822', '广德县', '3', '341800');
INSERT INTO `z_common_area` VALUES ('1677', '341823', '泾县', '3', '341800');
INSERT INTO `z_common_area` VALUES ('1678', '341824', '绩溪县', '3', '341800');
INSERT INTO `z_common_area` VALUES ('1679', '341825', '旌德县', '3', '341800');
INSERT INTO `z_common_area` VALUES ('1680', '341881', '宁国市', '3', '341800');
INSERT INTO `z_common_area` VALUES ('1681', '350102', '鼓楼区', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1682', '350103', '台江区', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1683', '350104', '仓山区', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1684', '350105', '马尾区', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1685', '350111', '晋安区', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1686', '350112', '长乐区', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1687', '350121', '闽侯县', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1688', '350122', '连江县', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1689', '350123', '罗源县', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1690', '350124', '闽清县', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1691', '350125', '永泰县', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1692', '350128', '平潭县', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1693', '350181', '福清市', '3', '350100');
INSERT INTO `z_common_area` VALUES ('1694', '350203', '思明区', '3', '350200');
INSERT INTO `z_common_area` VALUES ('1695', '350205', '海沧区', '3', '350200');
INSERT INTO `z_common_area` VALUES ('1696', '350206', '湖里区', '3', '350200');
INSERT INTO `z_common_area` VALUES ('1697', '350211', '集美区', '3', '350200');
INSERT INTO `z_common_area` VALUES ('1698', '350212', '同安区', '3', '350200');
INSERT INTO `z_common_area` VALUES ('1699', '350213', '翔安区', '3', '350200');
INSERT INTO `z_common_area` VALUES ('1700', '350302', '城厢区', '3', '350300');
INSERT INTO `z_common_area` VALUES ('1701', '350303', '涵江区', '3', '350300');
INSERT INTO `z_common_area` VALUES ('1702', '350304', '荔城区', '3', '350300');
INSERT INTO `z_common_area` VALUES ('1703', '350305', '秀屿区', '3', '350300');
INSERT INTO `z_common_area` VALUES ('1704', '350322', '仙游县', '3', '350300');
INSERT INTO `z_common_area` VALUES ('1705', '350402', '梅列区', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1706', '350403', '三元区', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1707', '350421', '明溪县', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1708', '350423', '清流县', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1709', '350424', '宁化县', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1710', '350425', '大田县', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1711', '350426', '尤溪县', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1712', '350427', '沙县', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1713', '350428', '将乐县', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1714', '350429', '泰宁县', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1715', '350430', '建宁县', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1716', '350481', '永安市', '3', '350400');
INSERT INTO `z_common_area` VALUES ('1717', '350502', '鲤城区', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1718', '350503', '丰泽区', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1719', '350504', '洛江区', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1720', '350505', '泉港区', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1721', '350521', '惠安县', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1722', '350524', '安溪县', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1723', '350525', '永春县', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1724', '350526', '德化县', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1725', '350527', '金门县', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1726', '350581', '石狮市', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1727', '350582', '晋江市', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1728', '350583', '南安市', '3', '350500');
INSERT INTO `z_common_area` VALUES ('1729', '350602', '芗城区', '3', '350600');
INSERT INTO `z_common_area` VALUES ('1730', '350603', '龙文区', '3', '350600');
INSERT INTO `z_common_area` VALUES ('1731', '350622', '云霄县', '3', '350600');
INSERT INTO `z_common_area` VALUES ('1732', '350623', '漳浦县', '3', '350600');
INSERT INTO `z_common_area` VALUES ('1733', '350624', '诏安县', '3', '350600');
INSERT INTO `z_common_area` VALUES ('1734', '350625', '长泰县', '3', '350600');
INSERT INTO `z_common_area` VALUES ('1735', '350626', '东山县', '3', '350600');
INSERT INTO `z_common_area` VALUES ('1736', '350627', '南靖县', '3', '350600');
INSERT INTO `z_common_area` VALUES ('1737', '350628', '平和县', '3', '350600');
INSERT INTO `z_common_area` VALUES ('1738', '350629', '华安县', '3', '350600');
INSERT INTO `z_common_area` VALUES ('1739', '350681', '龙海市', '3', '350600');
INSERT INTO `z_common_area` VALUES ('1740', '350702', '延平区', '3', '350700');
INSERT INTO `z_common_area` VALUES ('1741', '350703', '建阳区', '3', '350700');
INSERT INTO `z_common_area` VALUES ('1742', '350721', '顺昌县', '3', '350700');
INSERT INTO `z_common_area` VALUES ('1743', '350722', '浦城县', '3', '350700');
INSERT INTO `z_common_area` VALUES ('1744', '350723', '光泽县', '3', '350700');
INSERT INTO `z_common_area` VALUES ('1745', '350724', '松溪县', '3', '350700');
INSERT INTO `z_common_area` VALUES ('1746', '350725', '政和县', '3', '350700');
INSERT INTO `z_common_area` VALUES ('1747', '350781', '邵武市', '3', '350700');
INSERT INTO `z_common_area` VALUES ('1748', '350782', '武夷山市', '3', '350700');
INSERT INTO `z_common_area` VALUES ('1749', '350783', '建瓯市', '3', '350700');
INSERT INTO `z_common_area` VALUES ('1750', '350802', '新罗区', '3', '350800');
INSERT INTO `z_common_area` VALUES ('1751', '350803', '永定区', '3', '350800');
INSERT INTO `z_common_area` VALUES ('1752', '350821', '长汀县', '3', '350800');
INSERT INTO `z_common_area` VALUES ('1753', '350823', '上杭县', '3', '350800');
INSERT INTO `z_common_area` VALUES ('1754', '350824', '武平县', '3', '350800');
INSERT INTO `z_common_area` VALUES ('1755', '350825', '连城县', '3', '350800');
INSERT INTO `z_common_area` VALUES ('1756', '350881', '漳平市', '3', '350800');
INSERT INTO `z_common_area` VALUES ('1757', '350902', '蕉城区', '3', '350900');
INSERT INTO `z_common_area` VALUES ('1758', '350921', '霞浦县', '3', '350900');
INSERT INTO `z_common_area` VALUES ('1759', '350922', '古田县', '3', '350900');
INSERT INTO `z_common_area` VALUES ('1760', '350923', '屏南县', '3', '350900');
INSERT INTO `z_common_area` VALUES ('1761', '350924', '寿宁县', '3', '350900');
INSERT INTO `z_common_area` VALUES ('1762', '350925', '周宁县', '3', '350900');
INSERT INTO `z_common_area` VALUES ('1763', '350926', '柘荣县', '3', '350900');
INSERT INTO `z_common_area` VALUES ('1764', '350981', '福安市', '3', '350900');
INSERT INTO `z_common_area` VALUES ('1765', '350982', '福鼎市', '3', '350900');
INSERT INTO `z_common_area` VALUES ('1766', '360102', '东湖区', '3', '360100');
INSERT INTO `z_common_area` VALUES ('1767', '360103', '西湖区', '3', '360100');
INSERT INTO `z_common_area` VALUES ('1768', '360104', '青云谱区', '3', '360100');
INSERT INTO `z_common_area` VALUES ('1769', '360105', '湾里区', '3', '360100');
INSERT INTO `z_common_area` VALUES ('1770', '360111', '青山湖区', '3', '360100');
INSERT INTO `z_common_area` VALUES ('1771', '360112', '新建区', '3', '360100');
INSERT INTO `z_common_area` VALUES ('1772', '360121', '南昌县', '3', '360100');
INSERT INTO `z_common_area` VALUES ('1773', '360123', '安义县', '3', '360100');
INSERT INTO `z_common_area` VALUES ('1774', '360124', '进贤县', '3', '360100');
INSERT INTO `z_common_area` VALUES ('1775', '360190', '经济技术开发区', '3', '360100');
INSERT INTO `z_common_area` VALUES ('1776', '360192', '高新区', '3', '360100');
INSERT INTO `z_common_area` VALUES ('1777', '360202', '昌江区', '3', '360200');
INSERT INTO `z_common_area` VALUES ('1778', '360203', '珠山区', '3', '360200');
INSERT INTO `z_common_area` VALUES ('1779', '360222', '浮梁县', '3', '360200');
INSERT INTO `z_common_area` VALUES ('1780', '360281', '乐平市', '3', '360200');
INSERT INTO `z_common_area` VALUES ('1781', '360302', '安源区', '3', '360300');
INSERT INTO `z_common_area` VALUES ('1782', '360313', '湘东区', '3', '360300');
INSERT INTO `z_common_area` VALUES ('1783', '360321', '莲花县', '3', '360300');
INSERT INTO `z_common_area` VALUES ('1784', '360322', '上栗县', '3', '360300');
INSERT INTO `z_common_area` VALUES ('1785', '360323', '芦溪县', '3', '360300');
INSERT INTO `z_common_area` VALUES ('1786', '360402', '濂溪区', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1787', '360403', '浔阳区', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1788', '360404', '柴桑区', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1789', '360423', '武宁县', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1790', '360424', '修水县', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1791', '360425', '永修县', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1792', '360426', '德安县', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1793', '360428', '都昌县', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1794', '360429', '湖口县', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1795', '360430', '彭泽县', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1796', '360481', '瑞昌市', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1797', '360482', '共青城市', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1798', '360483', '庐山市', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1799', '360490', '经济技术开发区', '3', '360400');
INSERT INTO `z_common_area` VALUES ('1800', '360502', '渝水区', '3', '360500');
INSERT INTO `z_common_area` VALUES ('1801', '360521', '分宜县', '3', '360500');
INSERT INTO `z_common_area` VALUES ('1802', '360602', '月湖区', '3', '360600');
INSERT INTO `z_common_area` VALUES ('1803', '360603', '余江区', '3', '360600');
INSERT INTO `z_common_area` VALUES ('1804', '360681', '贵溪市', '3', '360600');
INSERT INTO `z_common_area` VALUES ('1805', '360702', '章贡区', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1806', '360703', '南康区', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1807', '360704', '赣县区', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1808', '360722', '信丰县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1809', '360723', '大余县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1810', '360724', '上犹县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1811', '360725', '崇义县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1812', '360726', '安远县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1813', '360727', '龙南县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1814', '360728', '定南县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1815', '360729', '全南县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1816', '360730', '宁都县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1817', '360731', '于都县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1818', '360732', '兴国县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1819', '360733', '会昌县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1820', '360734', '寻乌县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1821', '360735', '石城县', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1822', '360781', '瑞金市', '3', '360700');
INSERT INTO `z_common_area` VALUES ('1823', '360802', '吉州区', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1824', '360803', '青原区', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1825', '360821', '吉安县', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1826', '360822', '吉水县', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1827', '360823', '峡江县', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1828', '360824', '新干县', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1829', '360825', '永丰县', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1830', '360826', '泰和县', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1831', '360827', '遂川县', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1832', '360828', '万安县', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1833', '360829', '安福县', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1834', '360830', '永新县', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1835', '360881', '井冈山市', '3', '360800');
INSERT INTO `z_common_area` VALUES ('1836', '360902', '袁州区', '3', '360900');
INSERT INTO `z_common_area` VALUES ('1837', '360921', '奉新县', '3', '360900');
INSERT INTO `z_common_area` VALUES ('1838', '360922', '万载县', '3', '360900');
INSERT INTO `z_common_area` VALUES ('1839', '360923', '上高县', '3', '360900');
INSERT INTO `z_common_area` VALUES ('1840', '360924', '宜丰县', '3', '360900');
INSERT INTO `z_common_area` VALUES ('1841', '360925', '靖安县', '3', '360900');
INSERT INTO `z_common_area` VALUES ('1842', '360926', '铜鼓县', '3', '360900');
INSERT INTO `z_common_area` VALUES ('1843', '360981', '丰城市', '3', '360900');
INSERT INTO `z_common_area` VALUES ('1844', '360982', '樟树市', '3', '360900');
INSERT INTO `z_common_area` VALUES ('1845', '360983', '高安市', '3', '360900');
INSERT INTO `z_common_area` VALUES ('1846', '361002', '临川区', '3', '361000');
INSERT INTO `z_common_area` VALUES ('1847', '361003', '东乡区', '3', '361000');
INSERT INTO `z_common_area` VALUES ('1848', '361021', '南城县', '3', '361000');
INSERT INTO `z_common_area` VALUES ('1849', '361022', '黎川县', '3', '361000');
INSERT INTO `z_common_area` VALUES ('1850', '361023', '南丰县', '3', '361000');
INSERT INTO `z_common_area` VALUES ('1851', '361024', '崇仁县', '3', '361000');
INSERT INTO `z_common_area` VALUES ('1852', '361025', '乐安县', '3', '361000');
INSERT INTO `z_common_area` VALUES ('1853', '361026', '宜黄县', '3', '361000');
INSERT INTO `z_common_area` VALUES ('1854', '361027', '金溪县', '3', '361000');
INSERT INTO `z_common_area` VALUES ('1855', '361028', '资溪县', '3', '361000');
INSERT INTO `z_common_area` VALUES ('1856', '361030', '广昌县', '3', '361000');
INSERT INTO `z_common_area` VALUES ('1857', '361102', '信州区', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1858', '361103', '广丰区', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1859', '361121', '上饶县', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1860', '361123', '玉山县', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1861', '361124', '铅山县', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1862', '361125', '横峰县', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1863', '361126', '弋阳县', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1864', '361127', '余干县', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1865', '361128', '鄱阳县', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1866', '361129', '万年县', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1867', '361130', '婺源县', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1868', '361181', '德兴市', '3', '361100');
INSERT INTO `z_common_area` VALUES ('1869', '370102', '历下区', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1870', '370103', '市中区', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1871', '370104', '槐荫区', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1872', '370105', '天桥区', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1873', '370112', '历城区', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1874', '370113', '长清区', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1875', '370114', '章丘区', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1876', '370115', '济阳区', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1877', '370116', '莱芜区', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1878', '370117', '钢城区', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1879', '370124', '平阴县', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1880', '370126', '商河县', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1881', '370190', '高新区', '3', '370100');
INSERT INTO `z_common_area` VALUES ('1882', '370202', '市南区', '3', '370200');
INSERT INTO `z_common_area` VALUES ('1883', '370203', '市北区', '3', '370200');
INSERT INTO `z_common_area` VALUES ('1884', '370211', '黄岛区', '3', '370200');
INSERT INTO `z_common_area` VALUES ('1885', '370212', '崂山区', '3', '370200');
INSERT INTO `z_common_area` VALUES ('1886', '370213', '李沧区', '3', '370200');
INSERT INTO `z_common_area` VALUES ('1887', '370214', '城阳区', '3', '370200');
INSERT INTO `z_common_area` VALUES ('1888', '370215', '即墨区', '3', '370200');
INSERT INTO `z_common_area` VALUES ('1889', '370281', '胶州市', '3', '370200');
INSERT INTO `z_common_area` VALUES ('1890', '370283', '平度市', '3', '370200');
INSERT INTO `z_common_area` VALUES ('1891', '370285', '莱西市', '3', '370200');
INSERT INTO `z_common_area` VALUES ('1892', '370290', '开发区', '3', '370200');
INSERT INTO `z_common_area` VALUES ('1893', '370302', '淄川区', '3', '370300');
INSERT INTO `z_common_area` VALUES ('1894', '370303', '张店区', '3', '370300');
INSERT INTO `z_common_area` VALUES ('1895', '370304', '博山区', '3', '370300');
INSERT INTO `z_common_area` VALUES ('1896', '370305', '临淄区', '3', '370300');
INSERT INTO `z_common_area` VALUES ('1897', '370306', '周村区', '3', '370300');
INSERT INTO `z_common_area` VALUES ('1898', '370321', '桓台县', '3', '370300');
INSERT INTO `z_common_area` VALUES ('1899', '370322', '高青县', '3', '370300');
INSERT INTO `z_common_area` VALUES ('1900', '370323', '沂源县', '3', '370300');
INSERT INTO `z_common_area` VALUES ('1901', '370402', '市中区', '3', '370400');
INSERT INTO `z_common_area` VALUES ('1902', '370403', '薛城区', '3', '370400');
INSERT INTO `z_common_area` VALUES ('1903', '370404', '峄城区', '3', '370400');
INSERT INTO `z_common_area` VALUES ('1904', '370405', '台儿庄区', '3', '370400');
INSERT INTO `z_common_area` VALUES ('1905', '370406', '山亭区', '3', '370400');
INSERT INTO `z_common_area` VALUES ('1906', '370481', '滕州市', '3', '370400');
INSERT INTO `z_common_area` VALUES ('1907', '370502', '东营区', '3', '370500');
INSERT INTO `z_common_area` VALUES ('1908', '370503', '河口区', '3', '370500');
INSERT INTO `z_common_area` VALUES ('1909', '370505', '垦利区', '3', '370500');
INSERT INTO `z_common_area` VALUES ('1910', '370522', '利津县', '3', '370500');
INSERT INTO `z_common_area` VALUES ('1911', '370523', '广饶县', '3', '370500');
INSERT INTO `z_common_area` VALUES ('1912', '370602', '芝罘区', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1913', '370611', '福山区', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1914', '370612', '牟平区', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1915', '370613', '莱山区', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1916', '370634', '长岛县', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1917', '370681', '龙口市', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1918', '370682', '莱阳市', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1919', '370683', '莱州市', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1920', '370684', '蓬莱市', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1921', '370685', '招远市', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1922', '370686', '栖霞市', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1923', '370687', '海阳市', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1924', '370690', '开发区', '3', '370600');
INSERT INTO `z_common_area` VALUES ('1925', '370702', '潍城区', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1926', '370703', '寒亭区', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1927', '370704', '坊子区', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1928', '370705', '奎文区', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1929', '370724', '临朐县', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1930', '370725', '昌乐县', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1931', '370781', '青州市', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1932', '370782', '诸城市', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1933', '370783', '寿光市', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1934', '370784', '安丘市', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1935', '370785', '高密市', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1936', '370786', '昌邑市', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1937', '370790', '开发区', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1938', '370791', '高新区', '3', '370700');
INSERT INTO `z_common_area` VALUES ('1939', '370811', '任城区', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1940', '370812', '兖州区', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1941', '370826', '微山县', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1942', '370827', '鱼台县', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1943', '370828', '金乡县', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1944', '370829', '嘉祥县', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1945', '370830', '汶上县', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1946', '370831', '泗水县', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1947', '370832', '梁山县', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1948', '370881', '曲阜市', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1949', '370883', '邹城市', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1950', '370890', '高新区', '3', '370800');
INSERT INTO `z_common_area` VALUES ('1951', '370902', '泰山区', '3', '370900');
INSERT INTO `z_common_area` VALUES ('1952', '370911', '岱岳区', '3', '370900');
INSERT INTO `z_common_area` VALUES ('1953', '370921', '宁阳县', '3', '370900');
INSERT INTO `z_common_area` VALUES ('1954', '370923', '东平县', '3', '370900');
INSERT INTO `z_common_area` VALUES ('1955', '370982', '新泰市', '3', '370900');
INSERT INTO `z_common_area` VALUES ('1956', '370983', '肥城市', '3', '370900');
INSERT INTO `z_common_area` VALUES ('1957', '371002', '环翠区', '3', '371000');
INSERT INTO `z_common_area` VALUES ('1958', '371003', '文登区', '3', '371000');
INSERT INTO `z_common_area` VALUES ('1959', '371082', '荣成市', '3', '371000');
INSERT INTO `z_common_area` VALUES ('1960', '371083', '乳山市', '3', '371000');
INSERT INTO `z_common_area` VALUES ('1961', '371091', '经济技术开发区', '3', '371000');
INSERT INTO `z_common_area` VALUES ('1962', '371102', '东港区', '3', '371100');
INSERT INTO `z_common_area` VALUES ('1963', '371103', '岚山区', '3', '371100');
INSERT INTO `z_common_area` VALUES ('1964', '371121', '五莲县', '3', '371100');
INSERT INTO `z_common_area` VALUES ('1965', '371122', '莒县', '3', '371100');
INSERT INTO `z_common_area` VALUES ('1966', '371302', '兰山区', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1967', '371311', '罗庄区', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1968', '371312', '河东区', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1969', '371321', '沂南县', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1970', '371322', '郯城县', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1971', '371323', '沂水县', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1972', '371324', '兰陵县', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1973', '371325', '费县', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1974', '371326', '平邑县', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1975', '371327', '莒南县', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1976', '371328', '蒙阴县', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1977', '371329', '临沭县', '3', '371300');
INSERT INTO `z_common_area` VALUES ('1978', '371402', '德城区', '3', '371400');
INSERT INTO `z_common_area` VALUES ('1979', '371403', '陵城区', '3', '371400');
INSERT INTO `z_common_area` VALUES ('1980', '371422', '宁津县', '3', '371400');
INSERT INTO `z_common_area` VALUES ('1981', '371423', '庆云县', '3', '371400');
INSERT INTO `z_common_area` VALUES ('1982', '371424', '临邑县', '3', '371400');
INSERT INTO `z_common_area` VALUES ('1983', '371425', '齐河县', '3', '371400');
INSERT INTO `z_common_area` VALUES ('1984', '371426', '平原县', '3', '371400');
INSERT INTO `z_common_area` VALUES ('1985', '371427', '夏津县', '3', '371400');
INSERT INTO `z_common_area` VALUES ('1986', '371428', '武城县', '3', '371400');
INSERT INTO `z_common_area` VALUES ('1987', '371481', '乐陵市', '3', '371400');
INSERT INTO `z_common_area` VALUES ('1988', '371482', '禹城市', '3', '371400');
INSERT INTO `z_common_area` VALUES ('1989', '371502', '东昌府区', '3', '371500');
INSERT INTO `z_common_area` VALUES ('1990', '371521', '阳谷县', '3', '371500');
INSERT INTO `z_common_area` VALUES ('1991', '371522', '莘县', '3', '371500');
INSERT INTO `z_common_area` VALUES ('1992', '371523', '茌平县', '3', '371500');
INSERT INTO `z_common_area` VALUES ('1993', '371524', '东阿县', '3', '371500');
INSERT INTO `z_common_area` VALUES ('1994', '371525', '冠县', '3', '371500');
INSERT INTO `z_common_area` VALUES ('1995', '371526', '高唐县', '3', '371500');
INSERT INTO `z_common_area` VALUES ('1996', '371581', '临清市', '3', '371500');
INSERT INTO `z_common_area` VALUES ('1997', '371602', '滨城区', '3', '371600');
INSERT INTO `z_common_area` VALUES ('1998', '371603', '沾化区', '3', '371600');
INSERT INTO `z_common_area` VALUES ('1999', '371621', '惠民县', '3', '371600');
INSERT INTO `z_common_area` VALUES ('2000', '371622', '阳信县', '3', '371600');
INSERT INTO `z_common_area` VALUES ('2001', '371623', '无棣县', '3', '371600');
INSERT INTO `z_common_area` VALUES ('2002', '371625', '博兴县', '3', '371600');
INSERT INTO `z_common_area` VALUES ('2003', '371681', '邹平市', '3', '371600');
INSERT INTO `z_common_area` VALUES ('2004', '371702', '牡丹区', '3', '371700');
INSERT INTO `z_common_area` VALUES ('2005', '371703', '定陶区', '3', '371700');
INSERT INTO `z_common_area` VALUES ('2006', '371721', '曹县', '3', '371700');
INSERT INTO `z_common_area` VALUES ('2007', '371722', '单县', '3', '371700');
INSERT INTO `z_common_area` VALUES ('2008', '371723', '成武县', '3', '371700');
INSERT INTO `z_common_area` VALUES ('2009', '371724', '巨野县', '3', '371700');
INSERT INTO `z_common_area` VALUES ('2010', '371725', '郓城县', '3', '371700');
INSERT INTO `z_common_area` VALUES ('2011', '371726', '鄄城县', '3', '371700');
INSERT INTO `z_common_area` VALUES ('2012', '371728', '东明县', '3', '371700');
INSERT INTO `z_common_area` VALUES ('2013', '410102', '中原区', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2014', '410103', '二七区', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2015', '410104', '管城回族区', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2016', '410105', '金水区', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2017', '410106', '上街区', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2018', '410108', '惠济区', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2019', '410122', '中牟县', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2020', '410181', '巩义市', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2021', '410182', '荥阳市', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2022', '410183', '新密市', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2023', '410184', '新郑市', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2024', '410185', '登封市', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2025', '410190', '高新技术开发区', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2026', '410191', '经济技术开发区', '3', '410100');
INSERT INTO `z_common_area` VALUES ('2027', '410202', '龙亭区', '3', '410200');
INSERT INTO `z_common_area` VALUES ('2028', '410203', '顺河回族区', '3', '410200');
INSERT INTO `z_common_area` VALUES ('2029', '410204', '鼓楼区', '3', '410200');
INSERT INTO `z_common_area` VALUES ('2030', '410205', '禹王台区', '3', '410200');
INSERT INTO `z_common_area` VALUES ('2031', '410212', '祥符区', '3', '410200');
INSERT INTO `z_common_area` VALUES ('2032', '410221', '杞县', '3', '410200');
INSERT INTO `z_common_area` VALUES ('2033', '410222', '通许县', '3', '410200');
INSERT INTO `z_common_area` VALUES ('2034', '410223', '尉氏县', '3', '410200');
INSERT INTO `z_common_area` VALUES ('2035', '410225', '兰考县', '3', '410200');
INSERT INTO `z_common_area` VALUES ('2036', '410302', '老城区', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2037', '410303', '西工区', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2038', '410304', '瀍河回族区', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2039', '410305', '涧西区', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2040', '410306', '吉利区', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2041', '410311', '洛龙区', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2042', '410322', '孟津县', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2043', '410323', '新安县', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2044', '410324', '栾川县', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2045', '410325', '嵩县', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2046', '410326', '汝阳县', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2047', '410327', '宜阳县', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2048', '410328', '洛宁县', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2049', '410329', '伊川县', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2050', '410381', '偃师市', '3', '410300');
INSERT INTO `z_common_area` VALUES ('2051', '410402', '新华区', '3', '410400');
INSERT INTO `z_common_area` VALUES ('2052', '410403', '卫东区', '3', '410400');
INSERT INTO `z_common_area` VALUES ('2053', '410404', '石龙区', '3', '410400');
INSERT INTO `z_common_area` VALUES ('2054', '410411', '湛河区', '3', '410400');
INSERT INTO `z_common_area` VALUES ('2055', '410421', '宝丰县', '3', '410400');
INSERT INTO `z_common_area` VALUES ('2056', '410422', '叶县', '3', '410400');
INSERT INTO `z_common_area` VALUES ('2057', '410423', '鲁山县', '3', '410400');
INSERT INTO `z_common_area` VALUES ('2058', '410425', '郏县', '3', '410400');
INSERT INTO `z_common_area` VALUES ('2059', '410481', '舞钢市', '3', '410400');
INSERT INTO `z_common_area` VALUES ('2060', '410482', '汝州市', '3', '410400');
INSERT INTO `z_common_area` VALUES ('2061', '410502', '文峰区', '3', '410500');
INSERT INTO `z_common_area` VALUES ('2062', '410503', '北关区', '3', '410500');
INSERT INTO `z_common_area` VALUES ('2063', '410505', '殷都区', '3', '410500');
INSERT INTO `z_common_area` VALUES ('2064', '410506', '龙安区', '3', '410500');
INSERT INTO `z_common_area` VALUES ('2065', '410522', '安阳县', '3', '410500');
INSERT INTO `z_common_area` VALUES ('2066', '410523', '汤阴县', '3', '410500');
INSERT INTO `z_common_area` VALUES ('2067', '410526', '滑县', '3', '410500');
INSERT INTO `z_common_area` VALUES ('2068', '410527', '内黄县', '3', '410500');
INSERT INTO `z_common_area` VALUES ('2069', '410581', '林州市', '3', '410500');
INSERT INTO `z_common_area` VALUES ('2070', '410590', '开发区', '3', '410500');
INSERT INTO `z_common_area` VALUES ('2071', '410602', '鹤山区', '3', '410600');
INSERT INTO `z_common_area` VALUES ('2072', '410603', '山城区', '3', '410600');
INSERT INTO `z_common_area` VALUES ('2073', '410611', '淇滨区', '3', '410600');
INSERT INTO `z_common_area` VALUES ('2074', '410621', '浚县', '3', '410600');
INSERT INTO `z_common_area` VALUES ('2075', '410622', '淇县', '3', '410600');
INSERT INTO `z_common_area` VALUES ('2076', '410702', '红旗区', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2077', '410703', '卫滨区', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2078', '410704', '凤泉区', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2079', '410711', '牧野区', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2080', '410721', '新乡县', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2081', '410724', '获嘉县', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2082', '410725', '原阳县', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2083', '410726', '延津县', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2084', '410727', '封丘县', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2085', '410728', '长垣县', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2086', '410781', '卫辉市', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2087', '410782', '辉县市', '3', '410700');
INSERT INTO `z_common_area` VALUES ('2088', '410802', '解放区', '3', '410800');
INSERT INTO `z_common_area` VALUES ('2089', '410803', '中站区', '3', '410800');
INSERT INTO `z_common_area` VALUES ('2090', '410804', '马村区', '3', '410800');
INSERT INTO `z_common_area` VALUES ('2091', '410811', '山阳区', '3', '410800');
INSERT INTO `z_common_area` VALUES ('2092', '410821', '修武县', '3', '410800');
INSERT INTO `z_common_area` VALUES ('2093', '410822', '博爱县', '3', '410800');
INSERT INTO `z_common_area` VALUES ('2094', '410823', '武陟县', '3', '410800');
INSERT INTO `z_common_area` VALUES ('2095', '410825', '温县', '3', '410800');
INSERT INTO `z_common_area` VALUES ('2096', '410882', '沁阳市', '3', '410800');
INSERT INTO `z_common_area` VALUES ('2097', '410883', '孟州市', '3', '410800');
INSERT INTO `z_common_area` VALUES ('2098', '410902', '华龙区', '3', '410900');
INSERT INTO `z_common_area` VALUES ('2099', '410922', '清丰县', '3', '410900');
INSERT INTO `z_common_area` VALUES ('2100', '410923', '南乐县', '3', '410900');
INSERT INTO `z_common_area` VALUES ('2101', '410926', '范县', '3', '410900');
INSERT INTO `z_common_area` VALUES ('2102', '410927', '台前县', '3', '410900');
INSERT INTO `z_common_area` VALUES ('2103', '410928', '濮阳县', '3', '410900');
INSERT INTO `z_common_area` VALUES ('2104', '411002', '魏都区', '3', '411000');
INSERT INTO `z_common_area` VALUES ('2105', '411003', '建安区', '3', '411000');
INSERT INTO `z_common_area` VALUES ('2106', '411024', '鄢陵县', '3', '411000');
INSERT INTO `z_common_area` VALUES ('2107', '411025', '襄城县', '3', '411000');
INSERT INTO `z_common_area` VALUES ('2108', '411081', '禹州市', '3', '411000');
INSERT INTO `z_common_area` VALUES ('2109', '411082', '长葛市', '3', '411000');
INSERT INTO `z_common_area` VALUES ('2110', '411102', '源汇区', '3', '411100');
INSERT INTO `z_common_area` VALUES ('2111', '411103', '郾城区', '3', '411100');
INSERT INTO `z_common_area` VALUES ('2112', '411104', '召陵区', '3', '411100');
INSERT INTO `z_common_area` VALUES ('2113', '411121', '舞阳县', '3', '411100');
INSERT INTO `z_common_area` VALUES ('2114', '411122', '临颍县', '3', '411100');
INSERT INTO `z_common_area` VALUES ('2115', '411202', '湖滨区', '3', '411200');
INSERT INTO `z_common_area` VALUES ('2116', '411203', '陕州区', '3', '411200');
INSERT INTO `z_common_area` VALUES ('2117', '411221', '渑池县', '3', '411200');
INSERT INTO `z_common_area` VALUES ('2118', '411224', '卢氏县', '3', '411200');
INSERT INTO `z_common_area` VALUES ('2119', '411281', '义马市', '3', '411200');
INSERT INTO `z_common_area` VALUES ('2120', '411282', '灵宝市', '3', '411200');
INSERT INTO `z_common_area` VALUES ('2121', '411302', '宛城区', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2122', '411303', '卧龙区', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2123', '411321', '南召县', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2124', '411322', '方城县', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2125', '411323', '西峡县', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2126', '411324', '镇平县', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2127', '411325', '内乡县', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2128', '411326', '淅川县', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2129', '411327', '社旗县', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2130', '411328', '唐河县', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2131', '411329', '新野县', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2132', '411330', '桐柏县', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2133', '411381', '邓州市', '3', '411300');
INSERT INTO `z_common_area` VALUES ('2134', '411402', '梁园区', '3', '411400');
INSERT INTO `z_common_area` VALUES ('2135', '411403', '睢阳区', '3', '411400');
INSERT INTO `z_common_area` VALUES ('2136', '411421', '民权县', '3', '411400');
INSERT INTO `z_common_area` VALUES ('2137', '411422', '睢县', '3', '411400');
INSERT INTO `z_common_area` VALUES ('2138', '411423', '宁陵县', '3', '411400');
INSERT INTO `z_common_area` VALUES ('2139', '411424', '柘城县', '3', '411400');
INSERT INTO `z_common_area` VALUES ('2140', '411425', '虞城县', '3', '411400');
INSERT INTO `z_common_area` VALUES ('2141', '411426', '夏邑县', '3', '411400');
INSERT INTO `z_common_area` VALUES ('2142', '411481', '永城市', '3', '411400');
INSERT INTO `z_common_area` VALUES ('2143', '411502', '浉河区', '3', '411500');
INSERT INTO `z_common_area` VALUES ('2144', '411503', '平桥区', '3', '411500');
INSERT INTO `z_common_area` VALUES ('2145', '411521', '罗山县', '3', '411500');
INSERT INTO `z_common_area` VALUES ('2146', '411522', '光山县', '3', '411500');
INSERT INTO `z_common_area` VALUES ('2147', '411523', '新县', '3', '411500');
INSERT INTO `z_common_area` VALUES ('2148', '411524', '商城县', '3', '411500');
INSERT INTO `z_common_area` VALUES ('2149', '411525', '固始县', '3', '411500');
INSERT INTO `z_common_area` VALUES ('2150', '411526', '潢川县', '3', '411500');
INSERT INTO `z_common_area` VALUES ('2151', '411527', '淮滨县', '3', '411500');
INSERT INTO `z_common_area` VALUES ('2152', '411528', '息县', '3', '411500');
INSERT INTO `z_common_area` VALUES ('2153', '411602', '川汇区', '3', '411600');
INSERT INTO `z_common_area` VALUES ('2154', '411621', '扶沟县', '3', '411600');
INSERT INTO `z_common_area` VALUES ('2155', '411622', '西华县', '3', '411600');
INSERT INTO `z_common_area` VALUES ('2156', '411623', '商水县', '3', '411600');
INSERT INTO `z_common_area` VALUES ('2157', '411624', '沈丘县', '3', '411600');
INSERT INTO `z_common_area` VALUES ('2158', '411625', '郸城县', '3', '411600');
INSERT INTO `z_common_area` VALUES ('2159', '411626', '淮阳县', '3', '411600');
INSERT INTO `z_common_area` VALUES ('2160', '411627', '太康县', '3', '411600');
INSERT INTO `z_common_area` VALUES ('2161', '411628', '鹿邑县', '3', '411600');
INSERT INTO `z_common_area` VALUES ('2162', '411681', '项城市', '3', '411600');
INSERT INTO `z_common_area` VALUES ('2163', '411690', '经济开发区', '3', '411600');
INSERT INTO `z_common_area` VALUES ('2164', '411702', '驿城区', '3', '411700');
INSERT INTO `z_common_area` VALUES ('2165', '411721', '西平县', '3', '411700');
INSERT INTO `z_common_area` VALUES ('2166', '411722', '上蔡县', '3', '411700');
INSERT INTO `z_common_area` VALUES ('2167', '411723', '平舆县', '3', '411700');
INSERT INTO `z_common_area` VALUES ('2168', '411724', '正阳县', '3', '411700');
INSERT INTO `z_common_area` VALUES ('2169', '411725', '确山县', '3', '411700');
INSERT INTO `z_common_area` VALUES ('2170', '411726', '泌阳县', '3', '411700');
INSERT INTO `z_common_area` VALUES ('2171', '411727', '汝南县', '3', '411700');
INSERT INTO `z_common_area` VALUES ('2172', '411728', '遂平县', '3', '411700');
INSERT INTO `z_common_area` VALUES ('2173', '411729', '新蔡县', '3', '411700');
INSERT INTO `z_common_area` VALUES ('2174', '419001', '济源市', '3', '419000');
INSERT INTO `z_common_area` VALUES ('2175', '420102', '江岸区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2176', '420103', '江汉区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2177', '420104', '硚口区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2178', '420105', '汉阳区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2179', '420106', '武昌区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2180', '420107', '青山区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2181', '420111', '洪山区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2182', '420112', '东西湖区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2183', '420113', '汉南区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2184', '420114', '蔡甸区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2185', '420115', '江夏区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2186', '420116', '黄陂区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2187', '420117', '新洲区', '3', '420100');
INSERT INTO `z_common_area` VALUES ('2188', '420202', '黄石港区', '3', '420200');
INSERT INTO `z_common_area` VALUES ('2189', '420203', '西塞山区', '3', '420200');
INSERT INTO `z_common_area` VALUES ('2190', '420204', '下陆区', '3', '420200');
INSERT INTO `z_common_area` VALUES ('2191', '420205', '铁山区', '3', '420200');
INSERT INTO `z_common_area` VALUES ('2192', '420222', '阳新县', '3', '420200');
INSERT INTO `z_common_area` VALUES ('2193', '420281', '大冶市', '3', '420200');
INSERT INTO `z_common_area` VALUES ('2194', '420302', '茅箭区', '3', '420300');
INSERT INTO `z_common_area` VALUES ('2195', '420303', '张湾区', '3', '420300');
INSERT INTO `z_common_area` VALUES ('2196', '420304', '郧阳区', '3', '420300');
INSERT INTO `z_common_area` VALUES ('2197', '420322', '郧西县', '3', '420300');
INSERT INTO `z_common_area` VALUES ('2198', '420323', '竹山县', '3', '420300');
INSERT INTO `z_common_area` VALUES ('2199', '420324', '竹溪县', '3', '420300');
INSERT INTO `z_common_area` VALUES ('2200', '420325', '房县', '3', '420300');
INSERT INTO `z_common_area` VALUES ('2201', '420381', '丹江口市', '3', '420300');
INSERT INTO `z_common_area` VALUES ('2202', '420502', '西陵区', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2203', '420503', '伍家岗区', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2204', '420504', '点军区', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2205', '420505', '猇亭区', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2206', '420506', '夷陵区', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2207', '420525', '远安县', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2208', '420526', '兴山县', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2209', '420527', '秭归县', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2210', '420528', '长阳土家族自治县', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2211', '420529', '五峰土家族自治县', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2212', '420581', '宜都市', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2213', '420582', '当阳市', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2214', '420583', '枝江市', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2215', '420590', '经济开发区', '3', '420500');
INSERT INTO `z_common_area` VALUES ('2216', '420602', '襄城区', '3', '420600');
INSERT INTO `z_common_area` VALUES ('2217', '420606', '樊城区', '3', '420600');
INSERT INTO `z_common_area` VALUES ('2218', '420607', '襄州区', '3', '420600');
INSERT INTO `z_common_area` VALUES ('2219', '420624', '南漳县', '3', '420600');
INSERT INTO `z_common_area` VALUES ('2220', '420625', '谷城县', '3', '420600');
INSERT INTO `z_common_area` VALUES ('2221', '420626', '保康县', '3', '420600');
INSERT INTO `z_common_area` VALUES ('2222', '420682', '老河口市', '3', '420600');
INSERT INTO `z_common_area` VALUES ('2223', '420683', '枣阳市', '3', '420600');
INSERT INTO `z_common_area` VALUES ('2224', '420684', '宜城市', '3', '420600');
INSERT INTO `z_common_area` VALUES ('2225', '420702', '梁子湖区', '3', '420700');
INSERT INTO `z_common_area` VALUES ('2226', '420703', '华容区', '3', '420700');
INSERT INTO `z_common_area` VALUES ('2227', '420704', '鄂城区', '3', '420700');
INSERT INTO `z_common_area` VALUES ('2228', '420802', '东宝区', '3', '420800');
INSERT INTO `z_common_area` VALUES ('2229', '420804', '掇刀区', '3', '420800');
INSERT INTO `z_common_area` VALUES ('2230', '420822', '沙洋县', '3', '420800');
INSERT INTO `z_common_area` VALUES ('2231', '420881', '钟祥市', '3', '420800');
INSERT INTO `z_common_area` VALUES ('2232', '420882', '京山市', '3', '420800');
INSERT INTO `z_common_area` VALUES ('2233', '420902', '孝南区', '3', '420900');
INSERT INTO `z_common_area` VALUES ('2234', '420921', '孝昌县', '3', '420900');
INSERT INTO `z_common_area` VALUES ('2235', '420922', '大悟县', '3', '420900');
INSERT INTO `z_common_area` VALUES ('2236', '420923', '云梦县', '3', '420900');
INSERT INTO `z_common_area` VALUES ('2237', '420981', '应城市', '3', '420900');
INSERT INTO `z_common_area` VALUES ('2238', '420982', '安陆市', '3', '420900');
INSERT INTO `z_common_area` VALUES ('2239', '420984', '汉川市', '3', '420900');
INSERT INTO `z_common_area` VALUES ('2240', '421002', '沙市区', '3', '421000');
INSERT INTO `z_common_area` VALUES ('2241', '421003', '荆州区', '3', '421000');
INSERT INTO `z_common_area` VALUES ('2242', '421022', '公安县', '3', '421000');
INSERT INTO `z_common_area` VALUES ('2243', '421023', '监利县', '3', '421000');
INSERT INTO `z_common_area` VALUES ('2244', '421024', '江陵县', '3', '421000');
INSERT INTO `z_common_area` VALUES ('2245', '421081', '石首市', '3', '421000');
INSERT INTO `z_common_area` VALUES ('2246', '421083', '洪湖市', '3', '421000');
INSERT INTO `z_common_area` VALUES ('2247', '421087', '松滋市', '3', '421000');
INSERT INTO `z_common_area` VALUES ('2248', '421102', '黄州区', '3', '421100');
INSERT INTO `z_common_area` VALUES ('2249', '421121', '团风县', '3', '421100');
INSERT INTO `z_common_area` VALUES ('2250', '421122', '红安县', '3', '421100');
INSERT INTO `z_common_area` VALUES ('2251', '421123', '罗田县', '3', '421100');
INSERT INTO `z_common_area` VALUES ('2252', '421124', '英山县', '3', '421100');
INSERT INTO `z_common_area` VALUES ('2253', '421125', '浠水县', '3', '421100');
INSERT INTO `z_common_area` VALUES ('2254', '421126', '蕲春县', '3', '421100');
INSERT INTO `z_common_area` VALUES ('2255', '421127', '黄梅县', '3', '421100');
INSERT INTO `z_common_area` VALUES ('2256', '421181', '麻城市', '3', '421100');
INSERT INTO `z_common_area` VALUES ('2257', '421182', '武穴市', '3', '421100');
INSERT INTO `z_common_area` VALUES ('2258', '421202', '咸安区', '3', '421200');
INSERT INTO `z_common_area` VALUES ('2259', '421221', '嘉鱼县', '3', '421200');
INSERT INTO `z_common_area` VALUES ('2260', '421222', '通城县', '3', '421200');
INSERT INTO `z_common_area` VALUES ('2261', '421223', '崇阳县', '3', '421200');
INSERT INTO `z_common_area` VALUES ('2262', '421224', '通山县', '3', '421200');
INSERT INTO `z_common_area` VALUES ('2263', '421281', '赤壁市', '3', '421200');
INSERT INTO `z_common_area` VALUES ('2264', '421303', '曾都区', '3', '421300');
INSERT INTO `z_common_area` VALUES ('2265', '421321', '随县', '3', '421300');
INSERT INTO `z_common_area` VALUES ('2266', '421381', '广水市', '3', '421300');
INSERT INTO `z_common_area` VALUES ('2267', '422801', '恩施市', '3', '422800');
INSERT INTO `z_common_area` VALUES ('2268', '422802', '利川市', '3', '422800');
INSERT INTO `z_common_area` VALUES ('2269', '422822', '建始县', '3', '422800');
INSERT INTO `z_common_area` VALUES ('2270', '422823', '巴东县', '3', '422800');
INSERT INTO `z_common_area` VALUES ('2271', '422825', '宣恩县', '3', '422800');
INSERT INTO `z_common_area` VALUES ('2272', '422826', '咸丰县', '3', '422800');
INSERT INTO `z_common_area` VALUES ('2273', '422827', '来凤县', '3', '422800');
INSERT INTO `z_common_area` VALUES ('2274', '422828', '鹤峰县', '3', '422800');
INSERT INTO `z_common_area` VALUES ('2275', '429004', '仙桃市', '3', '429000');
INSERT INTO `z_common_area` VALUES ('2276', '429005', '潜江市', '3', '429000');
INSERT INTO `z_common_area` VALUES ('2277', '429006', '天门市', '3', '429000');
INSERT INTO `z_common_area` VALUES ('2278', '429021', '神农架林区', '3', '429000');
INSERT INTO `z_common_area` VALUES ('2279', '430102', '芙蓉区', '3', '430100');
INSERT INTO `z_common_area` VALUES ('2280', '430103', '天心区', '3', '430100');
INSERT INTO `z_common_area` VALUES ('2281', '430104', '岳麓区', '3', '430100');
INSERT INTO `z_common_area` VALUES ('2282', '430105', '开福区', '3', '430100');
INSERT INTO `z_common_area` VALUES ('2283', '430111', '雨花区', '3', '430100');
INSERT INTO `z_common_area` VALUES ('2284', '430112', '望城区', '3', '430100');
INSERT INTO `z_common_area` VALUES ('2285', '430121', '长沙县', '3', '430100');
INSERT INTO `z_common_area` VALUES ('2286', '430181', '浏阳市', '3', '430100');
INSERT INTO `z_common_area` VALUES ('2287', '430182', '宁乡市', '3', '430100');
INSERT INTO `z_common_area` VALUES ('2288', '430202', '荷塘区', '3', '430200');
INSERT INTO `z_common_area` VALUES ('2289', '430203', '芦淞区', '3', '430200');
INSERT INTO `z_common_area` VALUES ('2290', '430204', '石峰区', '3', '430200');
INSERT INTO `z_common_area` VALUES ('2291', '430211', '天元区', '3', '430200');
INSERT INTO `z_common_area` VALUES ('2292', '430212', '渌口区', '3', '430200');
INSERT INTO `z_common_area` VALUES ('2293', '430223', '攸县', '3', '430200');
INSERT INTO `z_common_area` VALUES ('2294', '430224', '茶陵县', '3', '430200');
INSERT INTO `z_common_area` VALUES ('2295', '430225', '炎陵县', '3', '430200');
INSERT INTO `z_common_area` VALUES ('2296', '430281', '醴陵市', '3', '430200');
INSERT INTO `z_common_area` VALUES ('2297', '430302', '雨湖区', '3', '430300');
INSERT INTO `z_common_area` VALUES ('2298', '430304', '岳塘区', '3', '430300');
INSERT INTO `z_common_area` VALUES ('2299', '430321', '湘潭县', '3', '430300');
INSERT INTO `z_common_area` VALUES ('2300', '430381', '湘乡市', '3', '430300');
INSERT INTO `z_common_area` VALUES ('2301', '430382', '韶山市', '3', '430300');
INSERT INTO `z_common_area` VALUES ('2302', '430405', '珠晖区', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2303', '430406', '雁峰区', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2304', '430407', '石鼓区', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2305', '430408', '蒸湘区', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2306', '430412', '南岳区', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2307', '430421', '衡阳县', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2308', '430422', '衡南县', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2309', '430423', '衡山县', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2310', '430424', '衡东县', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2311', '430426', '祁东县', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2312', '430481', '耒阳市', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2313', '430482', '常宁市', '3', '430400');
INSERT INTO `z_common_area` VALUES ('2314', '430502', '双清区', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2315', '430503', '大祥区', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2316', '430511', '北塔区', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2317', '430521', '邵东县', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2318', '430522', '新邵县', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2319', '430523', '邵阳县', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2320', '430524', '隆回县', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2321', '430525', '洞口县', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2322', '430527', '绥宁县', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2323', '430528', '新宁县', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2324', '430529', '城步苗族自治县', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2325', '430581', '武冈市', '3', '430500');
INSERT INTO `z_common_area` VALUES ('2326', '430602', '岳阳楼区', '3', '430600');
INSERT INTO `z_common_area` VALUES ('2327', '430603', '云溪区', '3', '430600');
INSERT INTO `z_common_area` VALUES ('2328', '430611', '君山区', '3', '430600');
INSERT INTO `z_common_area` VALUES ('2329', '430621', '岳阳县', '3', '430600');
INSERT INTO `z_common_area` VALUES ('2330', '430623', '华容县', '3', '430600');
INSERT INTO `z_common_area` VALUES ('2331', '430624', '湘阴县', '3', '430600');
INSERT INTO `z_common_area` VALUES ('2332', '430626', '平江县', '3', '430600');
INSERT INTO `z_common_area` VALUES ('2333', '430681', '汨罗市', '3', '430600');
INSERT INTO `z_common_area` VALUES ('2334', '430682', '临湘市', '3', '430600');
INSERT INTO `z_common_area` VALUES ('2335', '430702', '武陵区', '3', '430700');
INSERT INTO `z_common_area` VALUES ('2336', '430703', '鼎城区', '3', '430700');
INSERT INTO `z_common_area` VALUES ('2337', '430721', '安乡县', '3', '430700');
INSERT INTO `z_common_area` VALUES ('2338', '430722', '汉寿县', '3', '430700');
INSERT INTO `z_common_area` VALUES ('2339', '430723', '澧县', '3', '430700');
INSERT INTO `z_common_area` VALUES ('2340', '430724', '临澧县', '3', '430700');
INSERT INTO `z_common_area` VALUES ('2341', '430725', '桃源县', '3', '430700');
INSERT INTO `z_common_area` VALUES ('2342', '430726', '石门县', '3', '430700');
INSERT INTO `z_common_area` VALUES ('2343', '430781', '津市市', '3', '430700');
INSERT INTO `z_common_area` VALUES ('2344', '430802', '永定区', '3', '430800');
INSERT INTO `z_common_area` VALUES ('2345', '430811', '武陵源区', '3', '430800');
INSERT INTO `z_common_area` VALUES ('2346', '430821', '慈利县', '3', '430800');
INSERT INTO `z_common_area` VALUES ('2347', '430822', '桑植县', '3', '430800');
INSERT INTO `z_common_area` VALUES ('2348', '430902', '资阳区', '3', '430900');
INSERT INTO `z_common_area` VALUES ('2349', '430903', '赫山区', '3', '430900');
INSERT INTO `z_common_area` VALUES ('2350', '430921', '南县', '3', '430900');
INSERT INTO `z_common_area` VALUES ('2351', '430922', '桃江县', '3', '430900');
INSERT INTO `z_common_area` VALUES ('2352', '430923', '安化县', '3', '430900');
INSERT INTO `z_common_area` VALUES ('2353', '430981', '沅江市', '3', '430900');
INSERT INTO `z_common_area` VALUES ('2354', '431002', '北湖区', '3', '431000');
INSERT INTO `z_common_area` VALUES ('2355', '431003', '苏仙区', '3', '431000');
INSERT INTO `z_common_area` VALUES ('2356', '431021', '桂阳县', '3', '431000');
INSERT INTO `z_common_area` VALUES ('2357', '431022', '宜章县', '3', '431000');
INSERT INTO `z_common_area` VALUES ('2358', '431023', '永兴县', '3', '431000');
INSERT INTO `z_common_area` VALUES ('2359', '431024', '嘉禾县', '3', '431000');
INSERT INTO `z_common_area` VALUES ('2360', '431025', '临武县', '3', '431000');
INSERT INTO `z_common_area` VALUES ('2361', '431026', '汝城县', '3', '431000');
INSERT INTO `z_common_area` VALUES ('2362', '431027', '桂东县', '3', '431000');
INSERT INTO `z_common_area` VALUES ('2363', '431028', '安仁县', '3', '431000');
INSERT INTO `z_common_area` VALUES ('2364', '431081', '资兴市', '3', '431000');
INSERT INTO `z_common_area` VALUES ('2365', '431102', '零陵区', '3', '431100');
INSERT INTO `z_common_area` VALUES ('2366', '431103', '冷水滩区', '3', '431100');
INSERT INTO `z_common_area` VALUES ('2367', '431121', '祁阳县', '3', '431100');
INSERT INTO `z_common_area` VALUES ('2368', '431122', '东安县', '3', '431100');
INSERT INTO `z_common_area` VALUES ('2369', '431123', '双牌县', '3', '431100');
INSERT INTO `z_common_area` VALUES ('2370', '431124', '道县', '3', '431100');
INSERT INTO `z_common_area` VALUES ('2371', '431125', '江永县', '3', '431100');
INSERT INTO `z_common_area` VALUES ('2372', '431126', '宁远县', '3', '431100');
INSERT INTO `z_common_area` VALUES ('2373', '431127', '蓝山县', '3', '431100');
INSERT INTO `z_common_area` VALUES ('2374', '431128', '新田县', '3', '431100');
INSERT INTO `z_common_area` VALUES ('2375', '431129', '江华瑶族自治县', '3', '431100');
INSERT INTO `z_common_area` VALUES ('2376', '431202', '鹤城区', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2377', '431221', '中方县', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2378', '431222', '沅陵县', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2379', '431223', '辰溪县', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2380', '431224', '溆浦县', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2381', '431225', '会同县', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2382', '431226', '麻阳苗族自治县', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2383', '431227', '新晃侗族自治县', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2384', '431228', '芷江侗族自治县', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2385', '431229', '靖州苗族侗族自治县', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2386', '431230', '通道侗族自治县', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2387', '431281', '洪江市', '3', '431200');
INSERT INTO `z_common_area` VALUES ('2388', '431302', '娄星区', '3', '431300');
INSERT INTO `z_common_area` VALUES ('2389', '431321', '双峰县', '3', '431300');
INSERT INTO `z_common_area` VALUES ('2390', '431322', '新化县', '3', '431300');
INSERT INTO `z_common_area` VALUES ('2391', '431381', '冷水江市', '3', '431300');
INSERT INTO `z_common_area` VALUES ('2392', '431382', '涟源市', '3', '431300');
INSERT INTO `z_common_area` VALUES ('2393', '433101', '吉首市', '3', '433100');
INSERT INTO `z_common_area` VALUES ('2394', '433122', '泸溪县', '3', '433100');
INSERT INTO `z_common_area` VALUES ('2395', '433123', '凤凰县', '3', '433100');
INSERT INTO `z_common_area` VALUES ('2396', '433124', '花垣县', '3', '433100');
INSERT INTO `z_common_area` VALUES ('2397', '433125', '保靖县', '3', '433100');
INSERT INTO `z_common_area` VALUES ('2398', '433126', '古丈县', '3', '433100');
INSERT INTO `z_common_area` VALUES ('2399', '433127', '永顺县', '3', '433100');
INSERT INTO `z_common_area` VALUES ('2400', '433130', '龙山县', '3', '433100');
INSERT INTO `z_common_area` VALUES ('2401', '440103', '荔湾区', '3', '440100');
INSERT INTO `z_common_area` VALUES ('2402', '440104', '越秀区', '3', '440100');
INSERT INTO `z_common_area` VALUES ('2403', '440105', '海珠区', '3', '440100');
INSERT INTO `z_common_area` VALUES ('2404', '440106', '天河区', '3', '440100');
INSERT INTO `z_common_area` VALUES ('2405', '440111', '白云区', '3', '440100');
INSERT INTO `z_common_area` VALUES ('2406', '440112', '黄埔区', '3', '440100');
INSERT INTO `z_common_area` VALUES ('2407', '440113', '番禺区', '3', '440100');
INSERT INTO `z_common_area` VALUES ('2408', '440114', '花都区', '3', '440100');
INSERT INTO `z_common_area` VALUES ('2409', '440115', '南沙区', '3', '440100');
INSERT INTO `z_common_area` VALUES ('2410', '440117', '从化区', '3', '440100');
INSERT INTO `z_common_area` VALUES ('2411', '440118', '增城区', '3', '440100');
INSERT INTO `z_common_area` VALUES ('2412', '440203', '武江区', '3', '440200');
INSERT INTO `z_common_area` VALUES ('2413', '440204', '浈江区', '3', '440200');
INSERT INTO `z_common_area` VALUES ('2414', '440205', '曲江区', '3', '440200');
INSERT INTO `z_common_area` VALUES ('2415', '440222', '始兴县', '3', '440200');
INSERT INTO `z_common_area` VALUES ('2416', '440224', '仁化县', '3', '440200');
INSERT INTO `z_common_area` VALUES ('2417', '440229', '翁源县', '3', '440200');
INSERT INTO `z_common_area` VALUES ('2418', '440232', '乳源瑶族自治县', '3', '440200');
INSERT INTO `z_common_area` VALUES ('2419', '440233', '新丰县', '3', '440200');
INSERT INTO `z_common_area` VALUES ('2420', '440281', '乐昌市', '3', '440200');
INSERT INTO `z_common_area` VALUES ('2421', '440282', '南雄市', '3', '440200');
INSERT INTO `z_common_area` VALUES ('2422', '440303', '罗湖区', '3', '440300');
INSERT INTO `z_common_area` VALUES ('2423', '440304', '福田区', '3', '440300');
INSERT INTO `z_common_area` VALUES ('2424', '440305', '南山区', '3', '440300');
INSERT INTO `z_common_area` VALUES ('2425', '440306', '宝安区', '3', '440300');
INSERT INTO `z_common_area` VALUES ('2426', '440307', '龙岗区', '3', '440300');
INSERT INTO `z_common_area` VALUES ('2427', '440308', '盐田区', '3', '440300');
INSERT INTO `z_common_area` VALUES ('2428', '440309', '龙华区', '3', '440300');
INSERT INTO `z_common_area` VALUES ('2429', '440310', '坪山区', '3', '440300');
INSERT INTO `z_common_area` VALUES ('2430', '440311', '光明区', '3', '440300');
INSERT INTO `z_common_area` VALUES ('2431', '440402', '香洲区', '3', '440400');
INSERT INTO `z_common_area` VALUES ('2432', '440403', '斗门区', '3', '440400');
INSERT INTO `z_common_area` VALUES ('2433', '440404', '金湾区', '3', '440400');
INSERT INTO `z_common_area` VALUES ('2434', '440507', '龙湖区', '3', '440500');
INSERT INTO `z_common_area` VALUES ('2435', '440511', '金平区', '3', '440500');
INSERT INTO `z_common_area` VALUES ('2436', '440512', '濠江区', '3', '440500');
INSERT INTO `z_common_area` VALUES ('2437', '440513', '潮阳区', '3', '440500');
INSERT INTO `z_common_area` VALUES ('2438', '440514', '潮南区', '3', '440500');
INSERT INTO `z_common_area` VALUES ('2439', '440515', '澄海区', '3', '440500');
INSERT INTO `z_common_area` VALUES ('2440', '440523', '南澳县', '3', '440500');
INSERT INTO `z_common_area` VALUES ('2441', '440604', '禅城区', '3', '440600');
INSERT INTO `z_common_area` VALUES ('2442', '440605', '南海区', '3', '440600');
INSERT INTO `z_common_area` VALUES ('2443', '440606', '顺德区', '3', '440600');
INSERT INTO `z_common_area` VALUES ('2444', '440607', '三水区', '3', '440600');
INSERT INTO `z_common_area` VALUES ('2445', '440608', '高明区', '3', '440600');
INSERT INTO `z_common_area` VALUES ('2446', '440703', '蓬江区', '3', '440700');
INSERT INTO `z_common_area` VALUES ('2447', '440704', '江海区', '3', '440700');
INSERT INTO `z_common_area` VALUES ('2448', '440705', '新会区', '3', '440700');
INSERT INTO `z_common_area` VALUES ('2449', '440781', '台山市', '3', '440700');
INSERT INTO `z_common_area` VALUES ('2450', '440783', '开平市', '3', '440700');
INSERT INTO `z_common_area` VALUES ('2451', '440784', '鹤山市', '3', '440700');
INSERT INTO `z_common_area` VALUES ('2452', '440785', '恩平市', '3', '440700');
INSERT INTO `z_common_area` VALUES ('2453', '440802', '赤坎区', '3', '440800');
INSERT INTO `z_common_area` VALUES ('2454', '440803', '霞山区', '3', '440800');
INSERT INTO `z_common_area` VALUES ('2455', '440804', '坡头区', '3', '440800');
INSERT INTO `z_common_area` VALUES ('2456', '440811', '麻章区', '3', '440800');
INSERT INTO `z_common_area` VALUES ('2457', '440823', '遂溪县', '3', '440800');
INSERT INTO `z_common_area` VALUES ('2458', '440825', '徐闻县', '3', '440800');
INSERT INTO `z_common_area` VALUES ('2459', '440881', '廉江市', '3', '440800');
INSERT INTO `z_common_area` VALUES ('2460', '440882', '雷州市', '3', '440800');
INSERT INTO `z_common_area` VALUES ('2461', '440883', '吴川市', '3', '440800');
INSERT INTO `z_common_area` VALUES ('2462', '440890', '经济技术开发区', '3', '440800');
INSERT INTO `z_common_area` VALUES ('2463', '440902', '茂南区', '3', '440900');
INSERT INTO `z_common_area` VALUES ('2464', '440904', '电白区', '3', '440900');
INSERT INTO `z_common_area` VALUES ('2465', '440981', '高州市', '3', '440900');
INSERT INTO `z_common_area` VALUES ('2466', '440982', '化州市', '3', '440900');
INSERT INTO `z_common_area` VALUES ('2467', '440983', '信宜市', '3', '440900');
INSERT INTO `z_common_area` VALUES ('2468', '441202', '端州区', '3', '441200');
INSERT INTO `z_common_area` VALUES ('2469', '441203', '鼎湖区', '3', '441200');
INSERT INTO `z_common_area` VALUES ('2470', '441204', '高要区', '3', '441200');
INSERT INTO `z_common_area` VALUES ('2471', '441223', '广宁县', '3', '441200');
INSERT INTO `z_common_area` VALUES ('2472', '441224', '怀集县', '3', '441200');
INSERT INTO `z_common_area` VALUES ('2473', '441225', '封开县', '3', '441200');
INSERT INTO `z_common_area` VALUES ('2474', '441226', '德庆县', '3', '441200');
INSERT INTO `z_common_area` VALUES ('2475', '441284', '四会市', '3', '441200');
INSERT INTO `z_common_area` VALUES ('2476', '441302', '惠城区', '3', '441300');
INSERT INTO `z_common_area` VALUES ('2477', '441303', '惠阳区', '3', '441300');
INSERT INTO `z_common_area` VALUES ('2478', '441322', '博罗县', '3', '441300');
INSERT INTO `z_common_area` VALUES ('2479', '441323', '惠东县', '3', '441300');
INSERT INTO `z_common_area` VALUES ('2480', '441324', '龙门县', '3', '441300');
INSERT INTO `z_common_area` VALUES ('2481', '441402', '梅江区', '3', '441400');
INSERT INTO `z_common_area` VALUES ('2482', '441403', '梅县区', '3', '441400');
INSERT INTO `z_common_area` VALUES ('2483', '441422', '大埔县', '3', '441400');
INSERT INTO `z_common_area` VALUES ('2484', '441423', '丰顺县', '3', '441400');
INSERT INTO `z_common_area` VALUES ('2485', '441424', '五华县', '3', '441400');
INSERT INTO `z_common_area` VALUES ('2486', '441426', '平远县', '3', '441400');
INSERT INTO `z_common_area` VALUES ('2487', '441427', '蕉岭县', '3', '441400');
INSERT INTO `z_common_area` VALUES ('2488', '441481', '兴宁市', '3', '441400');
INSERT INTO `z_common_area` VALUES ('2489', '441502', '城区', '3', '441500');
INSERT INTO `z_common_area` VALUES ('2490', '441521', '海丰县', '3', '441500');
INSERT INTO `z_common_area` VALUES ('2491', '441523', '陆河县', '3', '441500');
INSERT INTO `z_common_area` VALUES ('2492', '441581', '陆丰市', '3', '441500');
INSERT INTO `z_common_area` VALUES ('2493', '441602', '源城区', '3', '441600');
INSERT INTO `z_common_area` VALUES ('2494', '441621', '紫金县', '3', '441600');
INSERT INTO `z_common_area` VALUES ('2495', '441622', '龙川县', '3', '441600');
INSERT INTO `z_common_area` VALUES ('2496', '441623', '连平县', '3', '441600');
INSERT INTO `z_common_area` VALUES ('2497', '441624', '和平县', '3', '441600');
INSERT INTO `z_common_area` VALUES ('2498', '441625', '东源县', '3', '441600');
INSERT INTO `z_common_area` VALUES ('2499', '441702', '江城区', '3', '441700');
INSERT INTO `z_common_area` VALUES ('2500', '441704', '阳东区', '3', '441700');
INSERT INTO `z_common_area` VALUES ('2501', '441721', '阳西县', '3', '441700');
INSERT INTO `z_common_area` VALUES ('2502', '441781', '阳春市', '3', '441700');
INSERT INTO `z_common_area` VALUES ('2503', '441802', '清城区', '3', '441800');
INSERT INTO `z_common_area` VALUES ('2504', '441803', '清新区', '3', '441800');
INSERT INTO `z_common_area` VALUES ('2505', '441821', '佛冈县', '3', '441800');
INSERT INTO `z_common_area` VALUES ('2506', '441823', '阳山县', '3', '441800');
INSERT INTO `z_common_area` VALUES ('2507', '441825', '连山壮族瑶族自治县', '3', '441800');
INSERT INTO `z_common_area` VALUES ('2508', '441826', '连南瑶族自治县', '3', '441800');
INSERT INTO `z_common_area` VALUES ('2509', '441881', '英德市', '3', '441800');
INSERT INTO `z_common_area` VALUES ('2510', '441882', '连州市', '3', '441800');
INSERT INTO `z_common_area` VALUES ('2511', '441901', '中堂镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2512', '441903', '南城街道办事处', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2513', '441904', '长安镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2514', '441905', '东坑镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2515', '441906', '樟木头镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2516', '441907', '莞城街道办事处', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2517', '441908', '石龙镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2518', '441909', '桥头镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2519', '441910', '万江街道办事处', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2520', '441911', '麻涌镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2521', '441912', '虎门镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2522', '441913', '谢岗镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2523', '441914', '石碣镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2524', '441915', '茶山镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2525', '441916', '东城街道办事处', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2526', '441917', '洪梅镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2527', '441918', '道滘镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2528', '441919', '高埗镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2529', '441920', '企石镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2530', '441921', '凤岗镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2531', '441922', '大岭山镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2532', '441923', '松山湖管委会', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2533', '441924', '清溪镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2534', '441925', '望牛墩镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2535', '441926', '厚街镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2536', '441927', '常平镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2537', '441928', '寮步镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2538', '441929', '石排镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2539', '441930', '横沥镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2540', '441931', '塘厦镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2541', '441932', '黄江镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2542', '441933', '大朗镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2543', '441934', '东莞港', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2544', '441935', '东莞生态园', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2545', '441990', '沙田镇', '3', '441900');
INSERT INTO `z_common_area` VALUES ('2546', '442001', '南头镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2547', '442002', '神湾镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2548', '442003', '东凤镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2549', '442004', '五桂山街道办事处', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2550', '442005', '黄圃镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2551', '442006', '小榄镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2552', '442007', '石岐区街道办事处', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2553', '442008', '横栏镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2554', '442009', '三角镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2555', '442010', '三乡镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2556', '442011', '港口镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2557', '442012', '沙溪镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2558', '442013', '板芙镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2559', '442015', '东升镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2560', '442016', '阜沙镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2561', '442017', '民众镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2562', '442018', '东区街道办事处', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2563', '442019', '火炬开发区街道办事处', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2564', '442020', '西区街道办事处', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2565', '442021', '南区街道办事处', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2566', '442022', '古镇镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2567', '442023', '坦洲镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2568', '442024', '大涌镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2569', '442025', '南朗镇', '3', '442000');
INSERT INTO `z_common_area` VALUES ('2570', '445102', '湘桥区', '3', '445100');
INSERT INTO `z_common_area` VALUES ('2571', '445103', '潮安区', '3', '445100');
INSERT INTO `z_common_area` VALUES ('2572', '445122', '饶平县', '3', '445100');
INSERT INTO `z_common_area` VALUES ('2573', '445202', '榕城区', '3', '445200');
INSERT INTO `z_common_area` VALUES ('2574', '445203', '揭东区', '3', '445200');
INSERT INTO `z_common_area` VALUES ('2575', '445222', '揭西县', '3', '445200');
INSERT INTO `z_common_area` VALUES ('2576', '445224', '惠来县', '3', '445200');
INSERT INTO `z_common_area` VALUES ('2577', '445281', '普宁市', '3', '445200');
INSERT INTO `z_common_area` VALUES ('2578', '445302', '云城区', '3', '445300');
INSERT INTO `z_common_area` VALUES ('2579', '445303', '云安区', '3', '445300');
INSERT INTO `z_common_area` VALUES ('2580', '445321', '新兴县', '3', '445300');
INSERT INTO `z_common_area` VALUES ('2581', '445322', '郁南县', '3', '445300');
INSERT INTO `z_common_area` VALUES ('2582', '445381', '罗定市', '3', '445300');
INSERT INTO `z_common_area` VALUES ('2583', '450102', '兴宁区', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2584', '450103', '青秀区', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2585', '450105', '江南区', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2586', '450107', '西乡塘区', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2587', '450108', '良庆区', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2588', '450109', '邕宁区', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2589', '450110', '武鸣区', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2590', '450123', '隆安县', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2591', '450124', '马山县', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2592', '450125', '上林县', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2593', '450126', '宾阳县', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2594', '450127', '横县', '3', '450100');
INSERT INTO `z_common_area` VALUES ('2595', '450202', '城中区', '3', '450200');
INSERT INTO `z_common_area` VALUES ('2596', '450203', '鱼峰区', '3', '450200');
INSERT INTO `z_common_area` VALUES ('2597', '450204', '柳南区', '3', '450200');
INSERT INTO `z_common_area` VALUES ('2598', '450205', '柳北区', '3', '450200');
INSERT INTO `z_common_area` VALUES ('2599', '450206', '柳江区', '3', '450200');
INSERT INTO `z_common_area` VALUES ('2600', '450222', '柳城县', '3', '450200');
INSERT INTO `z_common_area` VALUES ('2601', '450223', '鹿寨县', '3', '450200');
INSERT INTO `z_common_area` VALUES ('2602', '450224', '融安县', '3', '450200');
INSERT INTO `z_common_area` VALUES ('2603', '450225', '融水苗族自治县', '3', '450200');
INSERT INTO `z_common_area` VALUES ('2604', '450226', '三江侗族自治县', '3', '450200');
INSERT INTO `z_common_area` VALUES ('2605', '450302', '秀峰区', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2606', '450303', '叠彩区', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2607', '450304', '象山区', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2608', '450305', '七星区', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2609', '450311', '雁山区', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2610', '450312', '临桂区', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2611', '450321', '阳朔县', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2612', '450323', '灵川县', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2613', '450324', '全州县', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2614', '450325', '兴安县', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2615', '450326', '永福县', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2616', '450327', '灌阳县', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2617', '450328', '龙胜各族自治县', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2618', '450329', '资源县', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2619', '450330', '平乐县', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2620', '450332', '恭城瑶族自治县', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2621', '450381', '荔浦市', '3', '450300');
INSERT INTO `z_common_area` VALUES ('2622', '450403', '万秀区', '3', '450400');
INSERT INTO `z_common_area` VALUES ('2623', '450405', '长洲区', '3', '450400');
INSERT INTO `z_common_area` VALUES ('2624', '450406', '龙圩区', '3', '450400');
INSERT INTO `z_common_area` VALUES ('2625', '450421', '苍梧县', '3', '450400');
INSERT INTO `z_common_area` VALUES ('2626', '450422', '藤县', '3', '450400');
INSERT INTO `z_common_area` VALUES ('2627', '450423', '蒙山县', '3', '450400');
INSERT INTO `z_common_area` VALUES ('2628', '450481', '岑溪市', '3', '450400');
INSERT INTO `z_common_area` VALUES ('2629', '450502', '海城区', '3', '450500');
INSERT INTO `z_common_area` VALUES ('2630', '450503', '银海区', '3', '450500');
INSERT INTO `z_common_area` VALUES ('2631', '450512', '铁山港区', '3', '450500');
INSERT INTO `z_common_area` VALUES ('2632', '450521', '合浦县', '3', '450500');
INSERT INTO `z_common_area` VALUES ('2633', '450602', '港口区', '3', '450600');
INSERT INTO `z_common_area` VALUES ('2634', '450603', '防城区', '3', '450600');
INSERT INTO `z_common_area` VALUES ('2635', '450621', '上思县', '3', '450600');
INSERT INTO `z_common_area` VALUES ('2636', '450681', '东兴市', '3', '450600');
INSERT INTO `z_common_area` VALUES ('2637', '450702', '钦南区', '3', '450700');
INSERT INTO `z_common_area` VALUES ('2638', '450703', '钦北区', '3', '450700');
INSERT INTO `z_common_area` VALUES ('2639', '450721', '灵山县', '3', '450700');
INSERT INTO `z_common_area` VALUES ('2640', '450722', '浦北县', '3', '450700');
INSERT INTO `z_common_area` VALUES ('2641', '450802', '港北区', '3', '450800');
INSERT INTO `z_common_area` VALUES ('2642', '450803', '港南区', '3', '450800');
INSERT INTO `z_common_area` VALUES ('2643', '450804', '覃塘区', '3', '450800');
INSERT INTO `z_common_area` VALUES ('2644', '450821', '平南县', '3', '450800');
INSERT INTO `z_common_area` VALUES ('2645', '450881', '桂平市', '3', '450800');
INSERT INTO `z_common_area` VALUES ('2646', '450902', '玉州区', '3', '450900');
INSERT INTO `z_common_area` VALUES ('2647', '450903', '福绵区', '3', '450900');
INSERT INTO `z_common_area` VALUES ('2648', '450921', '容县', '3', '450900');
INSERT INTO `z_common_area` VALUES ('2649', '450922', '陆川县', '3', '450900');
INSERT INTO `z_common_area` VALUES ('2650', '450923', '博白县', '3', '450900');
INSERT INTO `z_common_area` VALUES ('2651', '450924', '兴业县', '3', '450900');
INSERT INTO `z_common_area` VALUES ('2652', '450981', '北流市', '3', '450900');
INSERT INTO `z_common_area` VALUES ('2653', '451002', '右江区', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2654', '451021', '田阳县', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2655', '451022', '田东县', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2656', '451023', '平果县', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2657', '451024', '德保县', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2658', '451026', '那坡县', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2659', '451027', '凌云县', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2660', '451028', '乐业县', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2661', '451029', '田林县', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2662', '451030', '西林县', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2663', '451031', '隆林各族自治县', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2664', '451081', '靖西市', '3', '451000');
INSERT INTO `z_common_area` VALUES ('2665', '451102', '八步区', '3', '451100');
INSERT INTO `z_common_area` VALUES ('2666', '451103', '平桂区', '3', '451100');
INSERT INTO `z_common_area` VALUES ('2667', '451121', '昭平县', '3', '451100');
INSERT INTO `z_common_area` VALUES ('2668', '451122', '钟山县', '3', '451100');
INSERT INTO `z_common_area` VALUES ('2669', '451123', '富川瑶族自治县', '3', '451100');
INSERT INTO `z_common_area` VALUES ('2670', '451202', '金城江区', '3', '451200');
INSERT INTO `z_common_area` VALUES ('2671', '451203', '宜州区', '3', '451200');
INSERT INTO `z_common_area` VALUES ('2672', '451221', '南丹县', '3', '451200');
INSERT INTO `z_common_area` VALUES ('2673', '451222', '天峨县', '3', '451200');
INSERT INTO `z_common_area` VALUES ('2674', '451223', '凤山县', '3', '451200');
INSERT INTO `z_common_area` VALUES ('2675', '451224', '东兰县', '3', '451200');
INSERT INTO `z_common_area` VALUES ('2676', '451225', '罗城仫佬族自治县', '3', '451200');
INSERT INTO `z_common_area` VALUES ('2677', '451226', '环江毛南族自治县', '3', '451200');
INSERT INTO `z_common_area` VALUES ('2678', '451227', '巴马瑶族自治县', '3', '451200');
INSERT INTO `z_common_area` VALUES ('2679', '451228', '都安瑶族自治县', '3', '451200');
INSERT INTO `z_common_area` VALUES ('2680', '451229', '大化瑶族自治县', '3', '451200');
INSERT INTO `z_common_area` VALUES ('2681', '451302', '兴宾区', '3', '451300');
INSERT INTO `z_common_area` VALUES ('2682', '451321', '忻城县', '3', '451300');
INSERT INTO `z_common_area` VALUES ('2683', '451322', '象州县', '3', '451300');
INSERT INTO `z_common_area` VALUES ('2684', '451323', '武宣县', '3', '451300');
INSERT INTO `z_common_area` VALUES ('2685', '451324', '金秀瑶族自治县', '3', '451300');
INSERT INTO `z_common_area` VALUES ('2686', '451381', '合山市', '3', '451300');
INSERT INTO `z_common_area` VALUES ('2687', '451402', '江州区', '3', '451400');
INSERT INTO `z_common_area` VALUES ('2688', '451421', '扶绥县', '3', '451400');
INSERT INTO `z_common_area` VALUES ('2689', '451422', '宁明县', '3', '451400');
INSERT INTO `z_common_area` VALUES ('2690', '451423', '龙州县', '3', '451400');
INSERT INTO `z_common_area` VALUES ('2691', '451424', '大新县', '3', '451400');
INSERT INTO `z_common_area` VALUES ('2692', '451425', '天等县', '3', '451400');
INSERT INTO `z_common_area` VALUES ('2693', '451481', '凭祥市', '3', '451400');
INSERT INTO `z_common_area` VALUES ('2694', '460105', '秀英区', '3', '460100');
INSERT INTO `z_common_area` VALUES ('2695', '460106', '龙华区', '3', '460100');
INSERT INTO `z_common_area` VALUES ('2696', '460107', '琼山区', '3', '460100');
INSERT INTO `z_common_area` VALUES ('2697', '460108', '美兰区', '3', '460100');
INSERT INTO `z_common_area` VALUES ('2698', '460202', '海棠区', '3', '460200');
INSERT INTO `z_common_area` VALUES ('2699', '460203', '吉阳区', '3', '460200');
INSERT INTO `z_common_area` VALUES ('2700', '460204', '天涯区', '3', '460200');
INSERT INTO `z_common_area` VALUES ('2701', '460205', '崖州区', '3', '460200');
INSERT INTO `z_common_area` VALUES ('2702', '460321', '西沙群岛', '3', '460300');
INSERT INTO `z_common_area` VALUES ('2703', '460322', '南沙群岛', '3', '460300');
INSERT INTO `z_common_area` VALUES ('2704', '460323', '中沙群岛的岛礁及其海域', '3', '460300');
INSERT INTO `z_common_area` VALUES ('2705', '460401', '那大镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2706', '460402', '和庆镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2707', '460403', '南丰镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2708', '460404', '大成镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2709', '460405', '雅星镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2710', '460406', '兰洋镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2711', '460407', '光村镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2712', '460408', '木棠镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2713', '460409', '海头镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2714', '460410', '峨蔓镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2715', '460411', '王五镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2716', '460412', '白马井镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2717', '460413', '中和镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2718', '460414', '排浦镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2719', '460415', '东成镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2720', '460416', '新州镇', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2721', '460417', '洋浦经济开发区', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2722', '460418', '华南热作学院', '3', '460400');
INSERT INTO `z_common_area` VALUES ('2723', '469001', '五指山市', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2724', '469002', '琼海市', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2725', '469005', '文昌市', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2726', '469006', '万宁市', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2727', '469007', '东方市', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2728', '469021', '定安县', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2729', '469022', '屯昌县', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2730', '469023', '澄迈县', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2731', '469024', '临高县', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2732', '469025', '白沙黎族自治县', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2733', '469026', '昌江黎族自治县', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2734', '469027', '乐东黎族自治县', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2735', '469028', '陵水黎族自治县', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2736', '469029', '保亭黎族苗族自治县', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2737', '469030', '琼中黎族苗族自治县', '3', '469000');
INSERT INTO `z_common_area` VALUES ('2738', '500101', '万州区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2739', '500102', '涪陵区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2740', '500103', '渝中区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2741', '500104', '大渡口区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2742', '500105', '江北区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2743', '500106', '沙坪坝区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2744', '500107', '九龙坡区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2745', '500108', '南岸区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2746', '500109', '北碚区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2747', '500110', '綦江区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2748', '500111', '大足区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2749', '500112', '渝北区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2750', '500113', '巴南区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2751', '500114', '黔江区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2752', '500115', '长寿区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2753', '500116', '江津区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2754', '500117', '合川区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2755', '500118', '永川区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2756', '500119', '南川区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2757', '500120', '璧山区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2758', '500151', '铜梁区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2759', '500152', '潼南区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2760', '500153', '荣昌区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2761', '500154', '开州区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2762', '500155', '梁平区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2763', '500156', '武隆区', '3', '500100');
INSERT INTO `z_common_area` VALUES ('2764', '500229', '城口县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2765', '500230', '丰都县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2766', '500231', '垫江县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2767', '500233', '忠县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2768', '500235', '云阳县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2769', '500236', '奉节县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2770', '500237', '巫山县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2771', '500238', '巫溪县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2772', '500240', '石柱土家族自治县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2773', '500241', '秀山土家族苗族自治县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2774', '500242', '酉阳土家族苗族自治县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2775', '500243', '彭水苗族土家族自治县', '3', '500200');
INSERT INTO `z_common_area` VALUES ('2776', '510104', '锦江区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2777', '510105', '青羊区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2778', '510106', '金牛区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2779', '510107', '武侯区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2780', '510108', '成华区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2781', '510112', '龙泉驿区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2782', '510113', '青白江区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2783', '510114', '新都区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2784', '510115', '温江区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2785', '510116', '双流区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2786', '510117', '郫都区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2787', '510121', '金堂县', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2788', '510129', '大邑县', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2789', '510131', '蒲江县', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2790', '510132', '新津县', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2791', '510181', '都江堰市', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2792', '510182', '彭州市', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2793', '510183', '邛崃市', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2794', '510184', '崇州市', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2795', '510185', '简阳市', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2796', '510191', '高新区', '3', '510100');
INSERT INTO `z_common_area` VALUES ('2797', '510302', '自流井区', '3', '510300');
INSERT INTO `z_common_area` VALUES ('2798', '510303', '贡井区', '3', '510300');
INSERT INTO `z_common_area` VALUES ('2799', '510304', '大安区', '3', '510300');
INSERT INTO `z_common_area` VALUES ('2800', '510311', '沿滩区', '3', '510300');
INSERT INTO `z_common_area` VALUES ('2801', '510321', '荣县', '3', '510300');
INSERT INTO `z_common_area` VALUES ('2802', '510322', '富顺县', '3', '510300');
INSERT INTO `z_common_area` VALUES ('2803', '510402', '东区', '3', '510400');
INSERT INTO `z_common_area` VALUES ('2804', '510403', '西区', '3', '510400');
INSERT INTO `z_common_area` VALUES ('2805', '510411', '仁和区', '3', '510400');
INSERT INTO `z_common_area` VALUES ('2806', '510421', '米易县', '3', '510400');
INSERT INTO `z_common_area` VALUES ('2807', '510422', '盐边县', '3', '510400');
INSERT INTO `z_common_area` VALUES ('2808', '510502', '江阳区', '3', '510500');
INSERT INTO `z_common_area` VALUES ('2809', '510503', '纳溪区', '3', '510500');
INSERT INTO `z_common_area` VALUES ('2810', '510504', '龙马潭区', '3', '510500');
INSERT INTO `z_common_area` VALUES ('2811', '510521', '泸县', '3', '510500');
INSERT INTO `z_common_area` VALUES ('2812', '510522', '合江县', '3', '510500');
INSERT INTO `z_common_area` VALUES ('2813', '510524', '叙永县', '3', '510500');
INSERT INTO `z_common_area` VALUES ('2814', '510525', '古蔺县', '3', '510500');
INSERT INTO `z_common_area` VALUES ('2815', '510603', '旌阳区', '3', '510600');
INSERT INTO `z_common_area` VALUES ('2816', '510604', '罗江区', '3', '510600');
INSERT INTO `z_common_area` VALUES ('2817', '510623', '中江县', '3', '510600');
INSERT INTO `z_common_area` VALUES ('2818', '510681', '广汉市', '3', '510600');
INSERT INTO `z_common_area` VALUES ('2819', '510682', '什邡市', '3', '510600');
INSERT INTO `z_common_area` VALUES ('2820', '510683', '绵竹市', '3', '510600');
INSERT INTO `z_common_area` VALUES ('2821', '510703', '涪城区', '3', '510700');
INSERT INTO `z_common_area` VALUES ('2822', '510704', '游仙区', '3', '510700');
INSERT INTO `z_common_area` VALUES ('2823', '510705', '安州区', '3', '510700');
INSERT INTO `z_common_area` VALUES ('2824', '510722', '三台县', '3', '510700');
INSERT INTO `z_common_area` VALUES ('2825', '510723', '盐亭县', '3', '510700');
INSERT INTO `z_common_area` VALUES ('2826', '510725', '梓潼县', '3', '510700');
INSERT INTO `z_common_area` VALUES ('2827', '510726', '北川羌族自治县', '3', '510700');
INSERT INTO `z_common_area` VALUES ('2828', '510727', '平武县', '3', '510700');
INSERT INTO `z_common_area` VALUES ('2829', '510781', '江油市', '3', '510700');
INSERT INTO `z_common_area` VALUES ('2830', '510791', '高新区', '3', '510700');
INSERT INTO `z_common_area` VALUES ('2831', '510802', '利州区', '3', '510800');
INSERT INTO `z_common_area` VALUES ('2832', '510811', '昭化区', '3', '510800');
INSERT INTO `z_common_area` VALUES ('2833', '510812', '朝天区', '3', '510800');
INSERT INTO `z_common_area` VALUES ('2834', '510821', '旺苍县', '3', '510800');
INSERT INTO `z_common_area` VALUES ('2835', '510822', '青川县', '3', '510800');
INSERT INTO `z_common_area` VALUES ('2836', '510823', '剑阁县', '3', '510800');
INSERT INTO `z_common_area` VALUES ('2837', '510824', '苍溪县', '3', '510800');
INSERT INTO `z_common_area` VALUES ('2838', '510903', '船山区', '3', '510900');
INSERT INTO `z_common_area` VALUES ('2839', '510904', '安居区', '3', '510900');
INSERT INTO `z_common_area` VALUES ('2840', '510921', '蓬溪县', '3', '510900');
INSERT INTO `z_common_area` VALUES ('2841', '510922', '射洪县', '3', '510900');
INSERT INTO `z_common_area` VALUES ('2842', '510923', '大英县', '3', '510900');
INSERT INTO `z_common_area` VALUES ('2843', '511002', '市中区', '3', '511000');
INSERT INTO `z_common_area` VALUES ('2844', '511011', '东兴区', '3', '511000');
INSERT INTO `z_common_area` VALUES ('2845', '511024', '威远县', '3', '511000');
INSERT INTO `z_common_area` VALUES ('2846', '511025', '资中县', '3', '511000');
INSERT INTO `z_common_area` VALUES ('2847', '511083', '隆昌市', '3', '511000');
INSERT INTO `z_common_area` VALUES ('2848', '511102', '市中区', '3', '511100');
INSERT INTO `z_common_area` VALUES ('2849', '511111', '沙湾区', '3', '511100');
INSERT INTO `z_common_area` VALUES ('2850', '511112', '五通桥区', '3', '511100');
INSERT INTO `z_common_area` VALUES ('2851', '511113', '金口河区', '3', '511100');
INSERT INTO `z_common_area` VALUES ('2852', '511123', '犍为县', '3', '511100');
INSERT INTO `z_common_area` VALUES ('2853', '511124', '井研县', '3', '511100');
INSERT INTO `z_common_area` VALUES ('2854', '511126', '夹江县', '3', '511100');
INSERT INTO `z_common_area` VALUES ('2855', '511129', '沐川县', '3', '511100');
INSERT INTO `z_common_area` VALUES ('2856', '511132', '峨边彝族自治县', '3', '511100');
INSERT INTO `z_common_area` VALUES ('2857', '511133', '马边彝族自治县', '3', '511100');
INSERT INTO `z_common_area` VALUES ('2858', '511181', '峨眉山市', '3', '511100');
INSERT INTO `z_common_area` VALUES ('2859', '511302', '顺庆区', '3', '511300');
INSERT INTO `z_common_area` VALUES ('2860', '511303', '高坪区', '3', '511300');
INSERT INTO `z_common_area` VALUES ('2861', '511304', '嘉陵区', '3', '511300');
INSERT INTO `z_common_area` VALUES ('2862', '511321', '南部县', '3', '511300');
INSERT INTO `z_common_area` VALUES ('2863', '511322', '营山县', '3', '511300');
INSERT INTO `z_common_area` VALUES ('2864', '511323', '蓬安县', '3', '511300');
INSERT INTO `z_common_area` VALUES ('2865', '511324', '仪陇县', '3', '511300');
INSERT INTO `z_common_area` VALUES ('2866', '511325', '西充县', '3', '511300');
INSERT INTO `z_common_area` VALUES ('2867', '511381', '阆中市', '3', '511300');
INSERT INTO `z_common_area` VALUES ('2868', '511402', '东坡区', '3', '511400');
INSERT INTO `z_common_area` VALUES ('2869', '511403', '彭山区', '3', '511400');
INSERT INTO `z_common_area` VALUES ('2870', '511421', '仁寿县', '3', '511400');
INSERT INTO `z_common_area` VALUES ('2871', '511423', '洪雅县', '3', '511400');
INSERT INTO `z_common_area` VALUES ('2872', '511424', '丹棱县', '3', '511400');
INSERT INTO `z_common_area` VALUES ('2873', '511425', '青神县', '3', '511400');
INSERT INTO `z_common_area` VALUES ('2874', '511502', '翠屏区', '3', '511500');
INSERT INTO `z_common_area` VALUES ('2875', '511503', '南溪区', '3', '511500');
INSERT INTO `z_common_area` VALUES ('2876', '511504', '叙州区', '3', '511500');
INSERT INTO `z_common_area` VALUES ('2877', '511523', '江安县', '3', '511500');
INSERT INTO `z_common_area` VALUES ('2878', '511524', '长宁县', '3', '511500');
INSERT INTO `z_common_area` VALUES ('2879', '511525', '高县', '3', '511500');
INSERT INTO `z_common_area` VALUES ('2880', '511526', '珙县', '3', '511500');
INSERT INTO `z_common_area` VALUES ('2881', '511527', '筠连县', '3', '511500');
INSERT INTO `z_common_area` VALUES ('2882', '511528', '兴文县', '3', '511500');
INSERT INTO `z_common_area` VALUES ('2883', '511529', '屏山县', '3', '511500');
INSERT INTO `z_common_area` VALUES ('2884', '511602', '广安区', '3', '511600');
INSERT INTO `z_common_area` VALUES ('2885', '511603', '前锋区', '3', '511600');
INSERT INTO `z_common_area` VALUES ('2886', '511621', '岳池县', '3', '511600');
INSERT INTO `z_common_area` VALUES ('2887', '511622', '武胜县', '3', '511600');
INSERT INTO `z_common_area` VALUES ('2888', '511623', '邻水县', '3', '511600');
INSERT INTO `z_common_area` VALUES ('2889', '511681', '华蓥市', '3', '511600');
INSERT INTO `z_common_area` VALUES ('2890', '511702', '通川区', '3', '511700');
INSERT INTO `z_common_area` VALUES ('2891', '511703', '达川区', '3', '511700');
INSERT INTO `z_common_area` VALUES ('2892', '511722', '宣汉县', '3', '511700');
INSERT INTO `z_common_area` VALUES ('2893', '511723', '开江县', '3', '511700');
INSERT INTO `z_common_area` VALUES ('2894', '511724', '大竹县', '3', '511700');
INSERT INTO `z_common_area` VALUES ('2895', '511725', '渠县', '3', '511700');
INSERT INTO `z_common_area` VALUES ('2896', '511781', '万源市', '3', '511700');
INSERT INTO `z_common_area` VALUES ('2897', '511802', '雨城区', '3', '511800');
INSERT INTO `z_common_area` VALUES ('2898', '511803', '名山区', '3', '511800');
INSERT INTO `z_common_area` VALUES ('2899', '511822', '荥经县', '3', '511800');
INSERT INTO `z_common_area` VALUES ('2900', '511823', '汉源县', '3', '511800');
INSERT INTO `z_common_area` VALUES ('2901', '511824', '石棉县', '3', '511800');
INSERT INTO `z_common_area` VALUES ('2902', '511825', '天全县', '3', '511800');
INSERT INTO `z_common_area` VALUES ('2903', '511826', '芦山县', '3', '511800');
INSERT INTO `z_common_area` VALUES ('2904', '511827', '宝兴县', '3', '511800');
INSERT INTO `z_common_area` VALUES ('2905', '511902', '巴州区', '3', '511900');
INSERT INTO `z_common_area` VALUES ('2906', '511903', '恩阳区', '3', '511900');
INSERT INTO `z_common_area` VALUES ('2907', '511921', '通江县', '3', '511900');
INSERT INTO `z_common_area` VALUES ('2908', '511922', '南江县', '3', '511900');
INSERT INTO `z_common_area` VALUES ('2909', '511923', '平昌县', '3', '511900');
INSERT INTO `z_common_area` VALUES ('2910', '512002', '雁江区', '3', '512000');
INSERT INTO `z_common_area` VALUES ('2911', '512021', '安岳县', '3', '512000');
INSERT INTO `z_common_area` VALUES ('2912', '512022', '乐至县', '3', '512000');
INSERT INTO `z_common_area` VALUES ('2913', '513201', '马尔康市', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2914', '513221', '汶川县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2915', '513222', '理县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2916', '513223', '茂县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2917', '513224', '松潘县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2918', '513225', '九寨沟县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2919', '513226', '金川县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2920', '513227', '小金县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2921', '513228', '黑水县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2922', '513230', '壤塘县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2923', '513231', '阿坝县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2924', '513232', '若尔盖县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2925', '513233', '红原县', '3', '513200');
INSERT INTO `z_common_area` VALUES ('2926', '513301', '康定市', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2927', '513322', '泸定县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2928', '513323', '丹巴县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2929', '513324', '九龙县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2930', '513325', '雅江县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2931', '513326', '道孚县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2932', '513327', '炉霍县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2933', '513328', '甘孜县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2934', '513329', '新龙县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2935', '513330', '德格县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2936', '513331', '白玉县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2937', '513332', '石渠县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2938', '513333', '色达县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2939', '513334', '理塘县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2940', '513335', '巴塘县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2941', '513336', '乡城县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2942', '513337', '稻城县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2943', '513338', '得荣县', '3', '513300');
INSERT INTO `z_common_area` VALUES ('2944', '513401', '西昌市', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2945', '513422', '木里藏族自治县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2946', '513423', '盐源县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2947', '513424', '德昌县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2948', '513425', '会理县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2949', '513426', '会东县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2950', '513427', '宁南县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2951', '513428', '普格县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2952', '513429', '布拖县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2953', '513430', '金阳县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2954', '513431', '昭觉县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2955', '513432', '喜德县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2956', '513433', '冕宁县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2957', '513434', '越西县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2958', '513435', '甘洛县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2959', '513436', '美姑县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2960', '513437', '雷波县', '3', '513400');
INSERT INTO `z_common_area` VALUES ('2961', '520102', '南明区', '3', '520100');
INSERT INTO `z_common_area` VALUES ('2962', '520103', '云岩区', '3', '520100');
INSERT INTO `z_common_area` VALUES ('2963', '520111', '花溪区', '3', '520100');
INSERT INTO `z_common_area` VALUES ('2964', '520112', '乌当区', '3', '520100');
INSERT INTO `z_common_area` VALUES ('2965', '520113', '白云区', '3', '520100');
INSERT INTO `z_common_area` VALUES ('2966', '520115', '观山湖区', '3', '520100');
INSERT INTO `z_common_area` VALUES ('2967', '520121', '开阳县', '3', '520100');
INSERT INTO `z_common_area` VALUES ('2968', '520122', '息烽县', '3', '520100');
INSERT INTO `z_common_area` VALUES ('2969', '520123', '修文县', '3', '520100');
INSERT INTO `z_common_area` VALUES ('2970', '520181', '清镇市', '3', '520100');
INSERT INTO `z_common_area` VALUES ('2971', '520201', '钟山区', '3', '520200');
INSERT INTO `z_common_area` VALUES ('2972', '520203', '六枝特区', '3', '520200');
INSERT INTO `z_common_area` VALUES ('2973', '520221', '水城县', '3', '520200');
INSERT INTO `z_common_area` VALUES ('2974', '520281', '盘州市', '3', '520200');
INSERT INTO `z_common_area` VALUES ('2975', '520302', '红花岗区', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2976', '520303', '汇川区', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2977', '520304', '播州区', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2978', '520322', '桐梓县', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2979', '520323', '绥阳县', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2980', '520324', '正安县', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2981', '520325', '道真仡佬族苗族自治县', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2982', '520326', '务川仡佬族苗族自治县', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2983', '520327', '凤冈县', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2984', '520328', '湄潭县', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2985', '520329', '余庆县', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2986', '520330', '习水县', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2987', '520381', '赤水市', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2988', '520382', '仁怀市', '3', '520300');
INSERT INTO `z_common_area` VALUES ('2989', '520402', '西秀区', '3', '520400');
INSERT INTO `z_common_area` VALUES ('2990', '520403', '平坝区', '3', '520400');
INSERT INTO `z_common_area` VALUES ('2991', '520422', '普定县', '3', '520400');
INSERT INTO `z_common_area` VALUES ('2992', '520423', '镇宁布依族苗族自治县', '3', '520400');
INSERT INTO `z_common_area` VALUES ('2993', '520424', '关岭布依族苗族自治县', '3', '520400');
INSERT INTO `z_common_area` VALUES ('2994', '520425', '紫云苗族布依族自治县', '3', '520400');
INSERT INTO `z_common_area` VALUES ('2995', '520502', '七星关区', '3', '520500');
INSERT INTO `z_common_area` VALUES ('2996', '520521', '大方县', '3', '520500');
INSERT INTO `z_common_area` VALUES ('2997', '520522', '黔西县', '3', '520500');
INSERT INTO `z_common_area` VALUES ('2998', '520523', '金沙县', '3', '520500');
INSERT INTO `z_common_area` VALUES ('2999', '520524', '织金县', '3', '520500');
INSERT INTO `z_common_area` VALUES ('3000', '520525', '纳雍县', '3', '520500');
INSERT INTO `z_common_area` VALUES ('3001', '520526', '威宁彝族回族苗族自治县', '3', '520500');
INSERT INTO `z_common_area` VALUES ('3002', '520527', '赫章县', '3', '520500');
INSERT INTO `z_common_area` VALUES ('3003', '520602', '碧江区', '3', '520600');
INSERT INTO `z_common_area` VALUES ('3004', '520603', '万山区', '3', '520600');
INSERT INTO `z_common_area` VALUES ('3005', '520621', '江口县', '3', '520600');
INSERT INTO `z_common_area` VALUES ('3006', '520622', '玉屏侗族自治县', '3', '520600');
INSERT INTO `z_common_area` VALUES ('3007', '520623', '石阡县', '3', '520600');
INSERT INTO `z_common_area` VALUES ('3008', '520624', '思南县', '3', '520600');
INSERT INTO `z_common_area` VALUES ('3009', '520625', '印江土家族苗族自治县', '3', '520600');
INSERT INTO `z_common_area` VALUES ('3010', '520626', '德江县', '3', '520600');
INSERT INTO `z_common_area` VALUES ('3011', '520627', '沿河土家族自治县', '3', '520600');
INSERT INTO `z_common_area` VALUES ('3012', '520628', '松桃苗族自治县', '3', '520600');
INSERT INTO `z_common_area` VALUES ('3013', '522301', '兴义市', '3', '522300');
INSERT INTO `z_common_area` VALUES ('3014', '522302', '兴仁市', '3', '522300');
INSERT INTO `z_common_area` VALUES ('3015', '522323', '普安县', '3', '522300');
INSERT INTO `z_common_area` VALUES ('3016', '522324', '晴隆县', '3', '522300');
INSERT INTO `z_common_area` VALUES ('3017', '522325', '贞丰县', '3', '522300');
INSERT INTO `z_common_area` VALUES ('3018', '522326', '望谟县', '3', '522300');
INSERT INTO `z_common_area` VALUES ('3019', '522327', '册亨县', '3', '522300');
INSERT INTO `z_common_area` VALUES ('3020', '522328', '安龙县', '3', '522300');
INSERT INTO `z_common_area` VALUES ('3021', '522601', '凯里市', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3022', '522622', '黄平县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3023', '522623', '施秉县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3024', '522624', '三穗县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3025', '522625', '镇远县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3026', '522626', '岑巩县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3027', '522627', '天柱县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3028', '522628', '锦屏县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3029', '522629', '剑河县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3030', '522630', '台江县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3031', '522631', '黎平县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3032', '522632', '榕江县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3033', '522633', '从江县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3034', '522634', '雷山县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3035', '522635', '麻江县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3036', '522636', '丹寨县', '3', '522600');
INSERT INTO `z_common_area` VALUES ('3037', '522701', '都匀市', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3038', '522702', '福泉市', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3039', '522722', '荔波县', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3040', '522723', '贵定县', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3041', '522725', '瓮安县', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3042', '522726', '独山县', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3043', '522727', '平塘县', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3044', '522728', '罗甸县', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3045', '522729', '长顺县', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3046', '522730', '龙里县', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3047', '522731', '惠水县', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3048', '522732', '三都水族自治县', '3', '522700');
INSERT INTO `z_common_area` VALUES ('3049', '530102', '五华区', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3050', '530103', '盘龙区', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3051', '530111', '官渡区', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3052', '530112', '西山区', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3053', '530113', '东川区', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3054', '530114', '呈贡区', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3055', '530115', '晋宁区', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3056', '530124', '富民县', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3057', '530125', '宜良县', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3058', '530126', '石林彝族自治县', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3059', '530127', '嵩明县', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3060', '530128', '禄劝彝族苗族自治县', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3061', '530129', '寻甸回族彝族自治县', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3062', '530181', '安宁市', '3', '530100');
INSERT INTO `z_common_area` VALUES ('3063', '530302', '麒麟区', '3', '530300');
INSERT INTO `z_common_area` VALUES ('3064', '530303', '沾益区', '3', '530300');
INSERT INTO `z_common_area` VALUES ('3065', '530304', '马龙区', '3', '530300');
INSERT INTO `z_common_area` VALUES ('3066', '530322', '陆良县', '3', '530300');
INSERT INTO `z_common_area` VALUES ('3067', '530323', '师宗县', '3', '530300');
INSERT INTO `z_common_area` VALUES ('3068', '530324', '罗平县', '3', '530300');
INSERT INTO `z_common_area` VALUES ('3069', '530325', '富源县', '3', '530300');
INSERT INTO `z_common_area` VALUES ('3070', '530326', '会泽县', '3', '530300');
INSERT INTO `z_common_area` VALUES ('3071', '530381', '宣威市', '3', '530300');
INSERT INTO `z_common_area` VALUES ('3072', '530402', '红塔区', '3', '530400');
INSERT INTO `z_common_area` VALUES ('3073', '530403', '江川区', '3', '530400');
INSERT INTO `z_common_area` VALUES ('3074', '530422', '澄江县', '3', '530400');
INSERT INTO `z_common_area` VALUES ('3075', '530423', '通海县', '3', '530400');
INSERT INTO `z_common_area` VALUES ('3076', '530424', '华宁县', '3', '530400');
INSERT INTO `z_common_area` VALUES ('3077', '530425', '易门县', '3', '530400');
INSERT INTO `z_common_area` VALUES ('3078', '530426', '峨山彝族自治县', '3', '530400');
INSERT INTO `z_common_area` VALUES ('3079', '530427', '新平彝族傣族自治县', '3', '530400');
INSERT INTO `z_common_area` VALUES ('3080', '530428', '元江哈尼族彝族傣族自治县', '3', '530400');
INSERT INTO `z_common_area` VALUES ('3081', '530502', '隆阳区', '3', '530500');
INSERT INTO `z_common_area` VALUES ('3082', '530521', '施甸县', '3', '530500');
INSERT INTO `z_common_area` VALUES ('3083', '530523', '龙陵县', '3', '530500');
INSERT INTO `z_common_area` VALUES ('3084', '530524', '昌宁县', '3', '530500');
INSERT INTO `z_common_area` VALUES ('3085', '530581', '腾冲市', '3', '530500');
INSERT INTO `z_common_area` VALUES ('3086', '530602', '昭阳区', '3', '530600');
INSERT INTO `z_common_area` VALUES ('3087', '530621', '鲁甸县', '3', '530600');
INSERT INTO `z_common_area` VALUES ('3088', '530622', '巧家县', '3', '530600');
INSERT INTO `z_common_area` VALUES ('3089', '530623', '盐津县', '3', '530600');
INSERT INTO `z_common_area` VALUES ('3090', '530624', '大关县', '3', '530600');
INSERT INTO `z_common_area` VALUES ('3091', '530625', '永善县', '3', '530600');
INSERT INTO `z_common_area` VALUES ('3092', '530626', '绥江县', '3', '530600');
INSERT INTO `z_common_area` VALUES ('3093', '530627', '镇雄县', '3', '530600');
INSERT INTO `z_common_area` VALUES ('3094', '530628', '彝良县', '3', '530600');
INSERT INTO `z_common_area` VALUES ('3095', '530629', '威信县', '3', '530600');
INSERT INTO `z_common_area` VALUES ('3096', '530681', '水富市', '3', '530600');
INSERT INTO `z_common_area` VALUES ('3097', '530702', '古城区', '3', '530700');
INSERT INTO `z_common_area` VALUES ('3098', '530721', '玉龙纳西族自治县', '3', '530700');
INSERT INTO `z_common_area` VALUES ('3099', '530722', '永胜县', '3', '530700');
INSERT INTO `z_common_area` VALUES ('3100', '530723', '华坪县', '3', '530700');
INSERT INTO `z_common_area` VALUES ('3101', '530724', '宁蒗彝族自治县', '3', '530700');
INSERT INTO `z_common_area` VALUES ('3102', '530802', '思茅区', '3', '530800');
INSERT INTO `z_common_area` VALUES ('3103', '530821', '宁洱哈尼族彝族自治县', '3', '530800');
INSERT INTO `z_common_area` VALUES ('3104', '530822', '墨江哈尼族自治县', '3', '530800');
INSERT INTO `z_common_area` VALUES ('3105', '530823', '景东彝族自治县', '3', '530800');
INSERT INTO `z_common_area` VALUES ('3106', '530824', '景谷傣族彝族自治县', '3', '530800');
INSERT INTO `z_common_area` VALUES ('3107', '530825', '镇沅彝族哈尼族拉祜族自治县', '3', '530800');
INSERT INTO `z_common_area` VALUES ('3108', '530826', '江城哈尼族彝族自治县', '3', '530800');
INSERT INTO `z_common_area` VALUES ('3109', '530827', '孟连傣族拉祜族佤族自治县', '3', '530800');
INSERT INTO `z_common_area` VALUES ('3110', '530828', '澜沧拉祜族自治县', '3', '530800');
INSERT INTO `z_common_area` VALUES ('3111', '530829', '西盟佤族自治县', '3', '530800');
INSERT INTO `z_common_area` VALUES ('3112', '530902', '临翔区', '3', '530900');
INSERT INTO `z_common_area` VALUES ('3113', '530921', '凤庆县', '3', '530900');
INSERT INTO `z_common_area` VALUES ('3114', '530922', '云县', '3', '530900');
INSERT INTO `z_common_area` VALUES ('3115', '530923', '永德县', '3', '530900');
INSERT INTO `z_common_area` VALUES ('3116', '530924', '镇康县', '3', '530900');
INSERT INTO `z_common_area` VALUES ('3117', '530925', '双江拉祜族佤族布朗族傣族自治县', '3', '530900');
INSERT INTO `z_common_area` VALUES ('3118', '530926', '耿马傣族佤族自治县', '3', '530900');
INSERT INTO `z_common_area` VALUES ('3119', '530927', '沧源佤族自治县', '3', '530900');
INSERT INTO `z_common_area` VALUES ('3120', '532301', '楚雄市', '3', '532300');
INSERT INTO `z_common_area` VALUES ('3121', '532322', '双柏县', '3', '532300');
INSERT INTO `z_common_area` VALUES ('3122', '532323', '牟定县', '3', '532300');
INSERT INTO `z_common_area` VALUES ('3123', '532324', '南华县', '3', '532300');
INSERT INTO `z_common_area` VALUES ('3124', '532325', '姚安县', '3', '532300');
INSERT INTO `z_common_area` VALUES ('3125', '532326', '大姚县', '3', '532300');
INSERT INTO `z_common_area` VALUES ('3126', '532327', '永仁县', '3', '532300');
INSERT INTO `z_common_area` VALUES ('3127', '532328', '元谋县', '3', '532300');
INSERT INTO `z_common_area` VALUES ('3128', '532329', '武定县', '3', '532300');
INSERT INTO `z_common_area` VALUES ('3129', '532331', '禄丰县', '3', '532300');
INSERT INTO `z_common_area` VALUES ('3130', '532501', '个旧市', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3131', '532502', '开远市', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3132', '532503', '蒙自市', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3133', '532504', '弥勒市', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3134', '532523', '屏边苗族自治县', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3135', '532524', '建水县', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3136', '532525', '石屏县', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3137', '532527', '泸西县', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3138', '532528', '元阳县', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3139', '532529', '红河县', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3140', '532530', '金平苗族瑶族傣族自治县', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3141', '532531', '绿春县', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3142', '532532', '河口瑶族自治县', '3', '532500');
INSERT INTO `z_common_area` VALUES ('3143', '532601', '文山市', '3', '532600');
INSERT INTO `z_common_area` VALUES ('3144', '532622', '砚山县', '3', '532600');
INSERT INTO `z_common_area` VALUES ('3145', '532623', '西畴县', '3', '532600');
INSERT INTO `z_common_area` VALUES ('3146', '532624', '麻栗坡县', '3', '532600');
INSERT INTO `z_common_area` VALUES ('3147', '532625', '马关县', '3', '532600');
INSERT INTO `z_common_area` VALUES ('3148', '532626', '丘北县', '3', '532600');
INSERT INTO `z_common_area` VALUES ('3149', '532627', '广南县', '3', '532600');
INSERT INTO `z_common_area` VALUES ('3150', '532628', '富宁县', '3', '532600');
INSERT INTO `z_common_area` VALUES ('3151', '532801', '景洪市', '3', '532800');
INSERT INTO `z_common_area` VALUES ('3152', '532822', '勐海县', '3', '532800');
INSERT INTO `z_common_area` VALUES ('3153', '532823', '勐腊县', '3', '532800');
INSERT INTO `z_common_area` VALUES ('3154', '532901', '大理市', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3155', '532922', '漾濞彝族自治县', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3156', '532923', '祥云县', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3157', '532924', '宾川县', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3158', '532925', '弥渡县', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3159', '532926', '南涧彝族自治县', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3160', '532927', '巍山彝族回族自治县', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3161', '532928', '永平县', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3162', '532929', '云龙县', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3163', '532930', '洱源县', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3164', '532931', '剑川县', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3165', '532932', '鹤庆县', '3', '532900');
INSERT INTO `z_common_area` VALUES ('3166', '533102', '瑞丽市', '3', '533100');
INSERT INTO `z_common_area` VALUES ('3167', '533103', '芒市', '3', '533100');
INSERT INTO `z_common_area` VALUES ('3168', '533122', '梁河县', '3', '533100');
INSERT INTO `z_common_area` VALUES ('3169', '533123', '盈江县', '3', '533100');
INSERT INTO `z_common_area` VALUES ('3170', '533124', '陇川县', '3', '533100');
INSERT INTO `z_common_area` VALUES ('3171', '533301', '泸水市', '3', '533300');
INSERT INTO `z_common_area` VALUES ('3172', '533323', '福贡县', '3', '533300');
INSERT INTO `z_common_area` VALUES ('3173', '533324', '贡山独龙族怒族自治县', '3', '533300');
INSERT INTO `z_common_area` VALUES ('3174', '533325', '兰坪白族普米族自治县', '3', '533300');
INSERT INTO `z_common_area` VALUES ('3175', '533401', '香格里拉市', '3', '533400');
INSERT INTO `z_common_area` VALUES ('3176', '533422', '德钦县', '3', '533400');
INSERT INTO `z_common_area` VALUES ('3177', '533423', '维西傈僳族自治县', '3', '533400');
INSERT INTO `z_common_area` VALUES ('3178', '540102', '城关区', '3', '540100');
INSERT INTO `z_common_area` VALUES ('3179', '540103', '堆龙德庆区', '3', '540100');
INSERT INTO `z_common_area` VALUES ('3180', '540104', '达孜区', '3', '540100');
INSERT INTO `z_common_area` VALUES ('3181', '540121', '林周县', '3', '540100');
INSERT INTO `z_common_area` VALUES ('3182', '540122', '当雄县', '3', '540100');
INSERT INTO `z_common_area` VALUES ('3183', '540123', '尼木县', '3', '540100');
INSERT INTO `z_common_area` VALUES ('3184', '540124', '曲水县', '3', '540100');
INSERT INTO `z_common_area` VALUES ('3185', '540127', '墨竹工卡县', '3', '540100');
INSERT INTO `z_common_area` VALUES ('3186', '540202', '桑珠孜区', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3187', '540221', '南木林县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3188', '540222', '江孜县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3189', '540223', '定日县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3190', '540224', '萨迦县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3191', '540225', '拉孜县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3192', '540226', '昂仁县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3193', '540227', '谢通门县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3194', '540228', '白朗县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3195', '540229', '仁布县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3196', '540230', '康马县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3197', '540231', '定结县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3198', '540232', '仲巴县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3199', '540233', '亚东县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3200', '540234', '吉隆县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3201', '540235', '聂拉木县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3202', '540236', '萨嘎县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3203', '540237', '岗巴县', '3', '540200');
INSERT INTO `z_common_area` VALUES ('3204', '540302', '卡若区', '3', '540300');
INSERT INTO `z_common_area` VALUES ('3205', '540321', '江达县', '3', '540300');
INSERT INTO `z_common_area` VALUES ('3206', '540322', '贡觉县', '3', '540300');
INSERT INTO `z_common_area` VALUES ('3207', '540323', '类乌齐县', '3', '540300');
INSERT INTO `z_common_area` VALUES ('3208', '540324', '丁青县', '3', '540300');
INSERT INTO `z_common_area` VALUES ('3209', '540325', '察雅县', '3', '540300');
INSERT INTO `z_common_area` VALUES ('3210', '540326', '八宿县', '3', '540300');
INSERT INTO `z_common_area` VALUES ('3211', '540327', '左贡县', '3', '540300');
INSERT INTO `z_common_area` VALUES ('3212', '540328', '芒康县', '3', '540300');
INSERT INTO `z_common_area` VALUES ('3213', '540329', '洛隆县', '3', '540300');
INSERT INTO `z_common_area` VALUES ('3214', '540330', '边坝县', '3', '540300');
INSERT INTO `z_common_area` VALUES ('3215', '540402', '巴宜区', '3', '540400');
INSERT INTO `z_common_area` VALUES ('3216', '540421', '工布江达县', '3', '540400');
INSERT INTO `z_common_area` VALUES ('3217', '540422', '米林县', '3', '540400');
INSERT INTO `z_common_area` VALUES ('3218', '540423', '墨脱县', '3', '540400');
INSERT INTO `z_common_area` VALUES ('3219', '540424', '波密县', '3', '540400');
INSERT INTO `z_common_area` VALUES ('3220', '540425', '察隅县', '3', '540400');
INSERT INTO `z_common_area` VALUES ('3221', '540426', '朗县', '3', '540400');
INSERT INTO `z_common_area` VALUES ('3222', '540502', '乃东区', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3223', '540521', '扎囊县', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3224', '540522', '贡嘎县', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3225', '540523', '桑日县', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3226', '540524', '琼结县', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3227', '540525', '曲松县', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3228', '540526', '措美县', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3229', '540527', '洛扎县', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3230', '540528', '加查县', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3231', '540529', '隆子县', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3232', '540530', '错那县', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3233', '540531', '浪卡子县', '3', '540500');
INSERT INTO `z_common_area` VALUES ('3234', '540602', '色尼区', '3', '540600');
INSERT INTO `z_common_area` VALUES ('3235', '540621', '嘉黎县', '3', '540600');
INSERT INTO `z_common_area` VALUES ('3236', '540622', '比如县', '3', '540600');
INSERT INTO `z_common_area` VALUES ('3237', '540623', '聂荣县', '3', '540600');
INSERT INTO `z_common_area` VALUES ('3238', '540624', '安多县', '3', '540600');
INSERT INTO `z_common_area` VALUES ('3239', '540625', '申扎县', '3', '540600');
INSERT INTO `z_common_area` VALUES ('3240', '540626', '索县', '3', '540600');
INSERT INTO `z_common_area` VALUES ('3241', '540627', '班戈县', '3', '540600');
INSERT INTO `z_common_area` VALUES ('3242', '540628', '巴青县', '3', '540600');
INSERT INTO `z_common_area` VALUES ('3243', '540629', '尼玛县', '3', '540600');
INSERT INTO `z_common_area` VALUES ('3244', '540630', '双湖县', '3', '540600');
INSERT INTO `z_common_area` VALUES ('3245', '542521', '普兰县', '3', '542500');
INSERT INTO `z_common_area` VALUES ('3246', '542522', '札达县', '3', '542500');
INSERT INTO `z_common_area` VALUES ('3247', '542523', '噶尔县', '3', '542500');
INSERT INTO `z_common_area` VALUES ('3248', '542524', '日土县', '3', '542500');
INSERT INTO `z_common_area` VALUES ('3249', '542525', '革吉县', '3', '542500');
INSERT INTO `z_common_area` VALUES ('3250', '542526', '改则县', '3', '542500');
INSERT INTO `z_common_area` VALUES ('3251', '542527', '措勤县', '3', '542500');
INSERT INTO `z_common_area` VALUES ('3252', '610102', '新城区', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3253', '610103', '碑林区', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3254', '610104', '莲湖区', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3255', '610111', '灞桥区', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3256', '610112', '未央区', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3257', '610113', '雁塔区', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3258', '610114', '阎良区', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3259', '610115', '临潼区', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3260', '610116', '长安区', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3261', '610117', '高陵区', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3262', '610118', '鄠邑区', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3263', '610122', '蓝田县', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3264', '610124', '周至县', '3', '610100');
INSERT INTO `z_common_area` VALUES ('3265', '610202', '王益区', '3', '610200');
INSERT INTO `z_common_area` VALUES ('3266', '610203', '印台区', '3', '610200');
INSERT INTO `z_common_area` VALUES ('3267', '610204', '耀州区', '3', '610200');
INSERT INTO `z_common_area` VALUES ('3268', '610222', '宜君县', '3', '610200');
INSERT INTO `z_common_area` VALUES ('3269', '610302', '渭滨区', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3270', '610303', '金台区', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3271', '610304', '陈仓区', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3272', '610322', '凤翔县', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3273', '610323', '岐山县', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3274', '610324', '扶风县', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3275', '610326', '眉县', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3276', '610327', '陇县', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3277', '610328', '千阳县', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3278', '610329', '麟游县', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3279', '610330', '凤县', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3280', '610331', '太白县', '3', '610300');
INSERT INTO `z_common_area` VALUES ('3281', '610402', '秦都区', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3282', '610403', '杨陵区', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3283', '610404', '渭城区', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3284', '610422', '三原县', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3285', '610423', '泾阳县', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3286', '610424', '乾县', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3287', '610425', '礼泉县', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3288', '610426', '永寿县', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3289', '610428', '长武县', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3290', '610429', '旬邑县', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3291', '610430', '淳化县', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3292', '610431', '武功县', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3293', '610481', '兴平市', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3294', '610482', '彬州市', '3', '610400');
INSERT INTO `z_common_area` VALUES ('3295', '610502', '临渭区', '3', '610500');
INSERT INTO `z_common_area` VALUES ('3296', '610503', '华州区', '3', '610500');
INSERT INTO `z_common_area` VALUES ('3297', '610522', '潼关县', '3', '610500');
INSERT INTO `z_common_area` VALUES ('3298', '610523', '大荔县', '3', '610500');
INSERT INTO `z_common_area` VALUES ('3299', '610524', '合阳县', '3', '610500');
INSERT INTO `z_common_area` VALUES ('3300', '610525', '澄城县', '3', '610500');
INSERT INTO `z_common_area` VALUES ('3301', '610526', '蒲城县', '3', '610500');
INSERT INTO `z_common_area` VALUES ('3302', '610527', '白水县', '3', '610500');
INSERT INTO `z_common_area` VALUES ('3303', '610528', '富平县', '3', '610500');
INSERT INTO `z_common_area` VALUES ('3304', '610581', '韩城市', '3', '610500');
INSERT INTO `z_common_area` VALUES ('3305', '610582', '华阴市', '3', '610500');
INSERT INTO `z_common_area` VALUES ('3306', '610602', '宝塔区', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3307', '610603', '安塞区', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3308', '610621', '延长县', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3309', '610622', '延川县', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3310', '610623', '子长县', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3311', '610625', '志丹县', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3312', '610626', '吴起县', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3313', '610627', '甘泉县', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3314', '610628', '富县', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3315', '610629', '洛川县', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3316', '610630', '宜川县', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3317', '610631', '黄龙县', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3318', '610632', '黄陵县', '3', '610600');
INSERT INTO `z_common_area` VALUES ('3319', '610702', '汉台区', '3', '610700');
INSERT INTO `z_common_area` VALUES ('3320', '610703', '南郑区', '3', '610700');
INSERT INTO `z_common_area` VALUES ('3321', '610722', '城固县', '3', '610700');
INSERT INTO `z_common_area` VALUES ('3322', '610723', '洋县', '3', '610700');
INSERT INTO `z_common_area` VALUES ('3323', '610724', '西乡县', '3', '610700');
INSERT INTO `z_common_area` VALUES ('3324', '610725', '勉县', '3', '610700');
INSERT INTO `z_common_area` VALUES ('3325', '610726', '宁强县', '3', '610700');
INSERT INTO `z_common_area` VALUES ('3326', '610727', '略阳县', '3', '610700');
INSERT INTO `z_common_area` VALUES ('3327', '610728', '镇巴县', '3', '610700');
INSERT INTO `z_common_area` VALUES ('3328', '610729', '留坝县', '3', '610700');
INSERT INTO `z_common_area` VALUES ('3329', '610730', '佛坪县', '3', '610700');
INSERT INTO `z_common_area` VALUES ('3330', '610802', '榆阳区', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3331', '610803', '横山区', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3332', '610822', '府谷县', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3333', '610824', '靖边县', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3334', '610825', '定边县', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3335', '610826', '绥德县', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3336', '610827', '米脂县', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3337', '610828', '佳县', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3338', '610829', '吴堡县', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3339', '610830', '清涧县', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3340', '610831', '子洲县', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3341', '610881', '神木市', '3', '610800');
INSERT INTO `z_common_area` VALUES ('3342', '610902', '汉滨区', '3', '610900');
INSERT INTO `z_common_area` VALUES ('3343', '610921', '汉阴县', '3', '610900');
INSERT INTO `z_common_area` VALUES ('3344', '610922', '石泉县', '3', '610900');
INSERT INTO `z_common_area` VALUES ('3345', '610923', '宁陕县', '3', '610900');
INSERT INTO `z_common_area` VALUES ('3346', '610924', '紫阳县', '3', '610900');
INSERT INTO `z_common_area` VALUES ('3347', '610925', '岚皋县', '3', '610900');
INSERT INTO `z_common_area` VALUES ('3348', '610926', '平利县', '3', '610900');
INSERT INTO `z_common_area` VALUES ('3349', '610927', '镇坪县', '3', '610900');
INSERT INTO `z_common_area` VALUES ('3350', '610928', '旬阳县', '3', '610900');
INSERT INTO `z_common_area` VALUES ('3351', '610929', '白河县', '3', '610900');
INSERT INTO `z_common_area` VALUES ('3352', '611002', '商州区', '3', '611000');
INSERT INTO `z_common_area` VALUES ('3353', '611021', '洛南县', '3', '611000');
INSERT INTO `z_common_area` VALUES ('3354', '611022', '丹凤县', '3', '611000');
INSERT INTO `z_common_area` VALUES ('3355', '611023', '商南县', '3', '611000');
INSERT INTO `z_common_area` VALUES ('3356', '611024', '山阳县', '3', '611000');
INSERT INTO `z_common_area` VALUES ('3357', '611025', '镇安县', '3', '611000');
INSERT INTO `z_common_area` VALUES ('3358', '611026', '柞水县', '3', '611000');
INSERT INTO `z_common_area` VALUES ('3359', '620102', '城关区', '3', '620100');
INSERT INTO `z_common_area` VALUES ('3360', '620103', '七里河区', '3', '620100');
INSERT INTO `z_common_area` VALUES ('3361', '620104', '西固区', '3', '620100');
INSERT INTO `z_common_area` VALUES ('3362', '620105', '安宁区', '3', '620100');
INSERT INTO `z_common_area` VALUES ('3363', '620111', '红古区', '3', '620100');
INSERT INTO `z_common_area` VALUES ('3364', '620121', '永登县', '3', '620100');
INSERT INTO `z_common_area` VALUES ('3365', '620122', '皋兰县', '3', '620100');
INSERT INTO `z_common_area` VALUES ('3366', '620123', '榆中县', '3', '620100');
INSERT INTO `z_common_area` VALUES ('3367', '620201', '市辖区', '3', '620200');
INSERT INTO `z_common_area` VALUES ('3368', '620290', '雄关区', '3', '620200');
INSERT INTO `z_common_area` VALUES ('3369', '620291', '长城区', '3', '620200');
INSERT INTO `z_common_area` VALUES ('3370', '620292', '镜铁区', '3', '620200');
INSERT INTO `z_common_area` VALUES ('3371', '620293', '新城镇', '3', '620200');
INSERT INTO `z_common_area` VALUES ('3372', '620294', '峪泉镇', '3', '620200');
INSERT INTO `z_common_area` VALUES ('3373', '620295', '文殊镇', '3', '620200');
INSERT INTO `z_common_area` VALUES ('3374', '620302', '金川区', '3', '620300');
INSERT INTO `z_common_area` VALUES ('3375', '620321', '永昌县', '3', '620300');
INSERT INTO `z_common_area` VALUES ('3376', '620402', '白银区', '3', '620400');
INSERT INTO `z_common_area` VALUES ('3377', '620403', '平川区', '3', '620400');
INSERT INTO `z_common_area` VALUES ('3378', '620421', '靖远县', '3', '620400');
INSERT INTO `z_common_area` VALUES ('3379', '620422', '会宁县', '3', '620400');
INSERT INTO `z_common_area` VALUES ('3380', '620423', '景泰县', '3', '620400');
INSERT INTO `z_common_area` VALUES ('3381', '620502', '秦州区', '3', '620500');
INSERT INTO `z_common_area` VALUES ('3382', '620503', '麦积区', '3', '620500');
INSERT INTO `z_common_area` VALUES ('3383', '620521', '清水县', '3', '620500');
INSERT INTO `z_common_area` VALUES ('3384', '620522', '秦安县', '3', '620500');
INSERT INTO `z_common_area` VALUES ('3385', '620523', '甘谷县', '3', '620500');
INSERT INTO `z_common_area` VALUES ('3386', '620524', '武山县', '3', '620500');
INSERT INTO `z_common_area` VALUES ('3387', '620525', '张家川回族自治县', '3', '620500');
INSERT INTO `z_common_area` VALUES ('3388', '620602', '凉州区', '3', '620600');
INSERT INTO `z_common_area` VALUES ('3389', '620621', '民勤县', '3', '620600');
INSERT INTO `z_common_area` VALUES ('3390', '620622', '古浪县', '3', '620600');
INSERT INTO `z_common_area` VALUES ('3391', '620623', '天祝藏族自治县', '3', '620600');
INSERT INTO `z_common_area` VALUES ('3392', '620702', '甘州区', '3', '620700');
INSERT INTO `z_common_area` VALUES ('3393', '620721', '肃南裕固族自治县', '3', '620700');
INSERT INTO `z_common_area` VALUES ('3394', '620722', '民乐县', '3', '620700');
INSERT INTO `z_common_area` VALUES ('3395', '620723', '临泽县', '3', '620700');
INSERT INTO `z_common_area` VALUES ('3396', '620724', '高台县', '3', '620700');
INSERT INTO `z_common_area` VALUES ('3397', '620725', '山丹县', '3', '620700');
INSERT INTO `z_common_area` VALUES ('3398', '620802', '崆峒区', '3', '620800');
INSERT INTO `z_common_area` VALUES ('3399', '620821', '泾川县', '3', '620800');
INSERT INTO `z_common_area` VALUES ('3400', '620822', '灵台县', '3', '620800');
INSERT INTO `z_common_area` VALUES ('3401', '620823', '崇信县', '3', '620800');
INSERT INTO `z_common_area` VALUES ('3402', '620825', '庄浪县', '3', '620800');
INSERT INTO `z_common_area` VALUES ('3403', '620826', '静宁县', '3', '620800');
INSERT INTO `z_common_area` VALUES ('3404', '620881', '华亭市', '3', '620800');
INSERT INTO `z_common_area` VALUES ('3405', '620902', '肃州区', '3', '620900');
INSERT INTO `z_common_area` VALUES ('3406', '620921', '金塔县', '3', '620900');
INSERT INTO `z_common_area` VALUES ('3407', '620922', '瓜州县', '3', '620900');
INSERT INTO `z_common_area` VALUES ('3408', '620923', '肃北蒙古族自治县', '3', '620900');
INSERT INTO `z_common_area` VALUES ('3409', '620924', '阿克塞哈萨克族自治县', '3', '620900');
INSERT INTO `z_common_area` VALUES ('3410', '620981', '玉门市', '3', '620900');
INSERT INTO `z_common_area` VALUES ('3411', '620982', '敦煌市', '3', '620900');
INSERT INTO `z_common_area` VALUES ('3412', '621002', '西峰区', '3', '621000');
INSERT INTO `z_common_area` VALUES ('3413', '621021', '庆城县', '3', '621000');
INSERT INTO `z_common_area` VALUES ('3414', '621022', '环县', '3', '621000');
INSERT INTO `z_common_area` VALUES ('3415', '621023', '华池县', '3', '621000');
INSERT INTO `z_common_area` VALUES ('3416', '621024', '合水县', '3', '621000');
INSERT INTO `z_common_area` VALUES ('3417', '621025', '正宁县', '3', '621000');
INSERT INTO `z_common_area` VALUES ('3418', '621026', '宁县', '3', '621000');
INSERT INTO `z_common_area` VALUES ('3419', '621027', '镇原县', '3', '621000');
INSERT INTO `z_common_area` VALUES ('3420', '621102', '安定区', '3', '621100');
INSERT INTO `z_common_area` VALUES ('3421', '621121', '通渭县', '3', '621100');
INSERT INTO `z_common_area` VALUES ('3422', '621122', '陇西县', '3', '621100');
INSERT INTO `z_common_area` VALUES ('3423', '621123', '渭源县', '3', '621100');
INSERT INTO `z_common_area` VALUES ('3424', '621124', '临洮县', '3', '621100');
INSERT INTO `z_common_area` VALUES ('3425', '621125', '漳县', '3', '621100');
INSERT INTO `z_common_area` VALUES ('3426', '621126', '岷县', '3', '621100');
INSERT INTO `z_common_area` VALUES ('3427', '621202', '武都区', '3', '621200');
INSERT INTO `z_common_area` VALUES ('3428', '621221', '成县', '3', '621200');
INSERT INTO `z_common_area` VALUES ('3429', '621222', '文县', '3', '621200');
INSERT INTO `z_common_area` VALUES ('3430', '621223', '宕昌县', '3', '621200');
INSERT INTO `z_common_area` VALUES ('3431', '621224', '康县', '3', '621200');
INSERT INTO `z_common_area` VALUES ('3432', '621225', '西和县', '3', '621200');
INSERT INTO `z_common_area` VALUES ('3433', '621226', '礼县', '3', '621200');
INSERT INTO `z_common_area` VALUES ('3434', '621227', '徽县', '3', '621200');
INSERT INTO `z_common_area` VALUES ('3435', '621228', '两当县', '3', '621200');
INSERT INTO `z_common_area` VALUES ('3436', '622901', '临夏市', '3', '622900');
INSERT INTO `z_common_area` VALUES ('3437', '622921', '临夏县', '3', '622900');
INSERT INTO `z_common_area` VALUES ('3438', '622922', '康乐县', '3', '622900');
INSERT INTO `z_common_area` VALUES ('3439', '622923', '永靖县', '3', '622900');
INSERT INTO `z_common_area` VALUES ('3440', '622924', '广河县', '3', '622900');
INSERT INTO `z_common_area` VALUES ('3441', '622925', '和政县', '3', '622900');
INSERT INTO `z_common_area` VALUES ('3442', '622926', '东乡族自治县', '3', '622900');
INSERT INTO `z_common_area` VALUES ('3443', '622927', '积石山保安族东乡族撒拉族自治县', '3', '622900');
INSERT INTO `z_common_area` VALUES ('3444', '623001', '合作市', '3', '623000');
INSERT INTO `z_common_area` VALUES ('3445', '623021', '临潭县', '3', '623000');
INSERT INTO `z_common_area` VALUES ('3446', '623022', '卓尼县', '3', '623000');
INSERT INTO `z_common_area` VALUES ('3447', '623023', '舟曲县', '3', '623000');
INSERT INTO `z_common_area` VALUES ('3448', '623024', '迭部县', '3', '623000');
INSERT INTO `z_common_area` VALUES ('3449', '623025', '玛曲县', '3', '623000');
INSERT INTO `z_common_area` VALUES ('3450', '623026', '碌曲县', '3', '623000');
INSERT INTO `z_common_area` VALUES ('3451', '623027', '夏河县', '3', '623000');
INSERT INTO `z_common_area` VALUES ('3452', '630102', '城东区', '3', '630100');
INSERT INTO `z_common_area` VALUES ('3453', '630103', '城中区', '3', '630100');
INSERT INTO `z_common_area` VALUES ('3454', '630104', '城西区', '3', '630100');
INSERT INTO `z_common_area` VALUES ('3455', '630105', '城北区', '3', '630100');
INSERT INTO `z_common_area` VALUES ('3456', '630121', '大通回族土族自治县', '3', '630100');
INSERT INTO `z_common_area` VALUES ('3457', '630122', '湟中县', '3', '630100');
INSERT INTO `z_common_area` VALUES ('3458', '630123', '湟源县', '3', '630100');
INSERT INTO `z_common_area` VALUES ('3459', '630202', '乐都区', '3', '630200');
INSERT INTO `z_common_area` VALUES ('3460', '630203', '平安区', '3', '630200');
INSERT INTO `z_common_area` VALUES ('3461', '630222', '民和回族土族自治县', '3', '630200');
INSERT INTO `z_common_area` VALUES ('3462', '630223', '互助土族自治县', '3', '630200');
INSERT INTO `z_common_area` VALUES ('3463', '630224', '化隆回族自治县', '3', '630200');
INSERT INTO `z_common_area` VALUES ('3464', '630225', '循化撒拉族自治县', '3', '630200');
INSERT INTO `z_common_area` VALUES ('3465', '632221', '门源回族自治县', '3', '632200');
INSERT INTO `z_common_area` VALUES ('3466', '632222', '祁连县', '3', '632200');
INSERT INTO `z_common_area` VALUES ('3467', '632223', '海晏县', '3', '632200');
INSERT INTO `z_common_area` VALUES ('3468', '632224', '刚察县', '3', '632200');
INSERT INTO `z_common_area` VALUES ('3469', '632321', '同仁县', '3', '632300');
INSERT INTO `z_common_area` VALUES ('3470', '632322', '尖扎县', '3', '632300');
INSERT INTO `z_common_area` VALUES ('3471', '632323', '泽库县', '3', '632300');
INSERT INTO `z_common_area` VALUES ('3472', '632324', '河南蒙古族自治县', '3', '632300');
INSERT INTO `z_common_area` VALUES ('3473', '632521', '共和县', '3', '632500');
INSERT INTO `z_common_area` VALUES ('3474', '632522', '同德县', '3', '632500');
INSERT INTO `z_common_area` VALUES ('3475', '632523', '贵德县', '3', '632500');
INSERT INTO `z_common_area` VALUES ('3476', '632524', '兴海县', '3', '632500');
INSERT INTO `z_common_area` VALUES ('3477', '632525', '贵南县', '3', '632500');
INSERT INTO `z_common_area` VALUES ('3478', '632621', '玛沁县', '3', '632600');
INSERT INTO `z_common_area` VALUES ('3479', '632622', '班玛县', '3', '632600');
INSERT INTO `z_common_area` VALUES ('3480', '632623', '甘德县', '3', '632600');
INSERT INTO `z_common_area` VALUES ('3481', '632624', '达日县', '3', '632600');
INSERT INTO `z_common_area` VALUES ('3482', '632625', '久治县', '3', '632600');
INSERT INTO `z_common_area` VALUES ('3483', '632626', '玛多县', '3', '632600');
INSERT INTO `z_common_area` VALUES ('3484', '632701', '玉树市', '3', '632700');
INSERT INTO `z_common_area` VALUES ('3485', '632722', '杂多县', '3', '632700');
INSERT INTO `z_common_area` VALUES ('3486', '632723', '称多县', '3', '632700');
INSERT INTO `z_common_area` VALUES ('3487', '632724', '治多县', '3', '632700');
INSERT INTO `z_common_area` VALUES ('3488', '632725', '囊谦县', '3', '632700');
INSERT INTO `z_common_area` VALUES ('3489', '632726', '曲麻莱县', '3', '632700');
INSERT INTO `z_common_area` VALUES ('3490', '632801', '格尔木市', '3', '632800');
INSERT INTO `z_common_area` VALUES ('3491', '632802', '德令哈市', '3', '632800');
INSERT INTO `z_common_area` VALUES ('3492', '632803', '茫崖市', '3', '632800');
INSERT INTO `z_common_area` VALUES ('3493', '632821', '乌兰县', '3', '632800');
INSERT INTO `z_common_area` VALUES ('3494', '632822', '都兰县', '3', '632800');
INSERT INTO `z_common_area` VALUES ('3495', '632823', '天峻县', '3', '632800');
INSERT INTO `z_common_area` VALUES ('3496', '640104', '兴庆区', '3', '640100');
INSERT INTO `z_common_area` VALUES ('3497', '640105', '西夏区', '3', '640100');
INSERT INTO `z_common_area` VALUES ('3498', '640106', '金凤区', '3', '640100');
INSERT INTO `z_common_area` VALUES ('3499', '640121', '永宁县', '3', '640100');
INSERT INTO `z_common_area` VALUES ('3500', '640122', '贺兰县', '3', '640100');
INSERT INTO `z_common_area` VALUES ('3501', '640181', '灵武市', '3', '640100');
INSERT INTO `z_common_area` VALUES ('3502', '640202', '大武口区', '3', '640200');
INSERT INTO `z_common_area` VALUES ('3503', '640205', '惠农区', '3', '640200');
INSERT INTO `z_common_area` VALUES ('3504', '640221', '平罗县', '3', '640200');
INSERT INTO `z_common_area` VALUES ('3505', '640302', '利通区', '3', '640300');
INSERT INTO `z_common_area` VALUES ('3506', '640303', '红寺堡区', '3', '640300');
INSERT INTO `z_common_area` VALUES ('3507', '640323', '盐池县', '3', '640300');
INSERT INTO `z_common_area` VALUES ('3508', '640324', '同心县', '3', '640300');
INSERT INTO `z_common_area` VALUES ('3509', '640381', '青铜峡市', '3', '640300');
INSERT INTO `z_common_area` VALUES ('3510', '640402', '原州区', '3', '640400');
INSERT INTO `z_common_area` VALUES ('3511', '640422', '西吉县', '3', '640400');
INSERT INTO `z_common_area` VALUES ('3512', '640423', '隆德县', '3', '640400');
INSERT INTO `z_common_area` VALUES ('3513', '640424', '泾源县', '3', '640400');
INSERT INTO `z_common_area` VALUES ('3514', '640425', '彭阳县', '3', '640400');
INSERT INTO `z_common_area` VALUES ('3515', '640502', '沙坡头区', '3', '640500');
INSERT INTO `z_common_area` VALUES ('3516', '640521', '中宁县', '3', '640500');
INSERT INTO `z_common_area` VALUES ('3517', '640522', '海原县', '3', '640500');
INSERT INTO `z_common_area` VALUES ('3518', '650102', '天山区', '3', '650100');
INSERT INTO `z_common_area` VALUES ('3519', '650103', '沙依巴克区', '3', '650100');
INSERT INTO `z_common_area` VALUES ('3520', '650104', '新市区', '3', '650100');
INSERT INTO `z_common_area` VALUES ('3521', '650105', '水磨沟区', '3', '650100');
INSERT INTO `z_common_area` VALUES ('3522', '650106', '头屯河区', '3', '650100');
INSERT INTO `z_common_area` VALUES ('3523', '650107', '达坂城区', '3', '650100');
INSERT INTO `z_common_area` VALUES ('3524', '650109', '米东区', '3', '650100');
INSERT INTO `z_common_area` VALUES ('3525', '650121', '乌鲁木齐县', '3', '650100');
INSERT INTO `z_common_area` VALUES ('3526', '650202', '独山子区', '3', '650200');
INSERT INTO `z_common_area` VALUES ('3527', '650203', '克拉玛依区', '3', '650200');
INSERT INTO `z_common_area` VALUES ('3528', '650204', '白碱滩区', '3', '650200');
INSERT INTO `z_common_area` VALUES ('3529', '650205', '乌尔禾区', '3', '650200');
INSERT INTO `z_common_area` VALUES ('3530', '650402', '高昌区', '3', '650400');
INSERT INTO `z_common_area` VALUES ('3531', '650421', '鄯善县', '3', '650400');
INSERT INTO `z_common_area` VALUES ('3532', '650422', '托克逊县', '3', '650400');
INSERT INTO `z_common_area` VALUES ('3533', '650502', '伊州区', '3', '650500');
INSERT INTO `z_common_area` VALUES ('3534', '650521', '巴里坤哈萨克自治县', '3', '650500');
INSERT INTO `z_common_area` VALUES ('3535', '650522', '伊吾县', '3', '650500');
INSERT INTO `z_common_area` VALUES ('3536', '652301', '昌吉市', '3', '652300');
INSERT INTO `z_common_area` VALUES ('3537', '652302', '阜康市', '3', '652300');
INSERT INTO `z_common_area` VALUES ('3538', '652323', '呼图壁县', '3', '652300');
INSERT INTO `z_common_area` VALUES ('3539', '652324', '玛纳斯县', '3', '652300');
INSERT INTO `z_common_area` VALUES ('3540', '652325', '奇台县', '3', '652300');
INSERT INTO `z_common_area` VALUES ('3541', '652327', '吉木萨尔县', '3', '652300');
INSERT INTO `z_common_area` VALUES ('3542', '652328', '木垒哈萨克自治县', '3', '652300');
INSERT INTO `z_common_area` VALUES ('3543', '652701', '博乐市', '3', '652700');
INSERT INTO `z_common_area` VALUES ('3544', '652702', '阿拉山口市', '3', '652700');
INSERT INTO `z_common_area` VALUES ('3545', '652722', '精河县', '3', '652700');
INSERT INTO `z_common_area` VALUES ('3546', '652723', '温泉县', '3', '652700');
INSERT INTO `z_common_area` VALUES ('3547', '652801', '库尔勒市', '3', '652800');
INSERT INTO `z_common_area` VALUES ('3548', '652822', '轮台县', '3', '652800');
INSERT INTO `z_common_area` VALUES ('3549', '652823', '尉犁县', '3', '652800');
INSERT INTO `z_common_area` VALUES ('3550', '652824', '若羌县', '3', '652800');
INSERT INTO `z_common_area` VALUES ('3551', '652825', '且末县', '3', '652800');
INSERT INTO `z_common_area` VALUES ('3552', '652826', '焉耆回族自治县', '3', '652800');
INSERT INTO `z_common_area` VALUES ('3553', '652827', '和静县', '3', '652800');
INSERT INTO `z_common_area` VALUES ('3554', '652828', '和硕县', '3', '652800');
INSERT INTO `z_common_area` VALUES ('3555', '652829', '博湖县', '3', '652800');
INSERT INTO `z_common_area` VALUES ('3556', '652901', '阿克苏市', '3', '652900');
INSERT INTO `z_common_area` VALUES ('3557', '652922', '温宿县', '3', '652900');
INSERT INTO `z_common_area` VALUES ('3558', '652923', '库车县', '3', '652900');
INSERT INTO `z_common_area` VALUES ('3559', '652924', '沙雅县', '3', '652900');
INSERT INTO `z_common_area` VALUES ('3560', '652925', '新和县', '3', '652900');
INSERT INTO `z_common_area` VALUES ('3561', '652926', '拜城县', '3', '652900');
INSERT INTO `z_common_area` VALUES ('3562', '652927', '乌什县', '3', '652900');
INSERT INTO `z_common_area` VALUES ('3563', '652928', '阿瓦提县', '3', '652900');
INSERT INTO `z_common_area` VALUES ('3564', '652929', '柯坪县', '3', '652900');
INSERT INTO `z_common_area` VALUES ('3565', '653001', '阿图什市', '3', '653000');
INSERT INTO `z_common_area` VALUES ('3566', '653022', '阿克陶县', '3', '653000');
INSERT INTO `z_common_area` VALUES ('3567', '653023', '阿合奇县', '3', '653000');
INSERT INTO `z_common_area` VALUES ('3568', '653024', '乌恰县', '3', '653000');
INSERT INTO `z_common_area` VALUES ('3569', '653101', '喀什市', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3570', '653121', '疏附县', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3571', '653122', '疏勒县', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3572', '653123', '英吉沙县', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3573', '653124', '泽普县', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3574', '653125', '莎车县', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3575', '653126', '叶城县', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3576', '653127', '麦盖提县', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3577', '653128', '岳普湖县', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3578', '653129', '伽师县', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3579', '653130', '巴楚县', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3580', '653131', '塔什库尔干塔吉克自治县', '3', '653100');
INSERT INTO `z_common_area` VALUES ('3581', '653201', '和田市', '3', '653200');
INSERT INTO `z_common_area` VALUES ('3582', '653221', '和田县', '3', '653200');
INSERT INTO `z_common_area` VALUES ('3583', '653222', '墨玉县', '3', '653200');
INSERT INTO `z_common_area` VALUES ('3584', '653223', '皮山县', '3', '653200');
INSERT INTO `z_common_area` VALUES ('3585', '653224', '洛浦县', '3', '653200');
INSERT INTO `z_common_area` VALUES ('3586', '653225', '策勒县', '3', '653200');
INSERT INTO `z_common_area` VALUES ('3587', '653226', '于田县', '3', '653200');
INSERT INTO `z_common_area` VALUES ('3588', '653227', '民丰县', '3', '653200');
INSERT INTO `z_common_area` VALUES ('3589', '654002', '伊宁市', '3', '654000');
INSERT INTO `z_common_area` VALUES ('3590', '654003', '奎屯市', '3', '654000');
INSERT INTO `z_common_area` VALUES ('3591', '654004', '霍尔果斯市', '3', '654000');
INSERT INTO `z_common_area` VALUES ('3592', '654021', '伊宁县', '3', '654000');
INSERT INTO `z_common_area` VALUES ('3593', '654022', '察布查尔锡伯自治县', '3', '654000');
INSERT INTO `z_common_area` VALUES ('3594', '654023', '霍城县', '3', '654000');
INSERT INTO `z_common_area` VALUES ('3595', '654024', '巩留县', '3', '654000');
INSERT INTO `z_common_area` VALUES ('3596', '654025', '新源县', '3', '654000');
INSERT INTO `z_common_area` VALUES ('3597', '654026', '昭苏县', '3', '654000');
INSERT INTO `z_common_area` VALUES ('3598', '654027', '特克斯县', '3', '654000');
INSERT INTO `z_common_area` VALUES ('3599', '654028', '尼勒克县', '3', '654000');
INSERT INTO `z_common_area` VALUES ('3600', '654201', '塔城市', '3', '654200');
INSERT INTO `z_common_area` VALUES ('3601', '654202', '乌苏市', '3', '654200');
INSERT INTO `z_common_area` VALUES ('3602', '654221', '额敏县', '3', '654200');
INSERT INTO `z_common_area` VALUES ('3603', '654223', '沙湾县', '3', '654200');
INSERT INTO `z_common_area` VALUES ('3604', '654224', '托里县', '3', '654200');
INSERT INTO `z_common_area` VALUES ('3605', '654225', '裕民县', '3', '654200');
INSERT INTO `z_common_area` VALUES ('3606', '654226', '和布克赛尔蒙古自治县', '3', '654200');
INSERT INTO `z_common_area` VALUES ('3607', '654301', '阿勒泰市', '3', '654300');
INSERT INTO `z_common_area` VALUES ('3608', '654321', '布尔津县', '3', '654300');
INSERT INTO `z_common_area` VALUES ('3609', '654322', '富蕴县', '3', '654300');
INSERT INTO `z_common_area` VALUES ('3610', '654323', '福海县', '3', '654300');
INSERT INTO `z_common_area` VALUES ('3611', '654324', '哈巴河县', '3', '654300');
INSERT INTO `z_common_area` VALUES ('3612', '654325', '青河县', '3', '654300');
INSERT INTO `z_common_area` VALUES ('3613', '654326', '吉木乃县', '3', '654300');
INSERT INTO `z_common_area` VALUES ('3614', '659001', '石河子市', '3', '659000');
INSERT INTO `z_common_area` VALUES ('3615', '659002', '阿拉尔市', '3', '659000');
INSERT INTO `z_common_area` VALUES ('3616', '659003', '图木舒克市', '3', '659000');
INSERT INTO `z_common_area` VALUES ('3617', '659004', '五家渠市', '3', '659000');
INSERT INTO `z_common_area` VALUES ('3618', '659005', '北屯市', '3', '659000');
INSERT INTO `z_common_area` VALUES ('3619', '659006', '铁门关市', '3', '659000');
INSERT INTO `z_common_area` VALUES ('3620', '659007', '双河市', '3', '659000');
INSERT INTO `z_common_area` VALUES ('3621', '659008', '可克达拉市', '3', '659000');
INSERT INTO `z_common_area` VALUES ('3622', '659009', '昆玉市', '3', '659000');
INSERT INTO `z_common_area` VALUES ('3623', '710101', '中正区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3624', '710102', '大同区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3625', '710103', '中山区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3626', '710104', '松山区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3627', '710105', '大安区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3628', '710106', '万华区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3629', '710107', '信义区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3630', '710108', '士林区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3631', '710109', '北投区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3632', '710110', '内湖区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3633', '710111', '南港区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3634', '710112', '文山区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3635', '710199', '其它区', '3', '710100');
INSERT INTO `z_common_area` VALUES ('3636', '710201', '新兴区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3637', '710202', '前金区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3638', '710203', '芩雅区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3639', '710204', '盐埕区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3640', '710205', '鼓山区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3641', '710206', '旗津区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3642', '710207', '前镇区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3643', '710208', '三民区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3644', '710209', '左营区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3645', '710210', '楠梓区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3646', '710211', '小港区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3647', '710241', '苓雅区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3648', '710242', '仁武区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3649', '710243', '大社区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3650', '710244', '冈山区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3651', '710245', '路竹区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3652', '710246', '阿莲区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3653', '710247', '田寮区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3654', '710248', '燕巢区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3655', '710249', '桥头区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3656', '710250', '梓官区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3657', '710251', '弥陀区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3658', '710252', '永安区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3659', '710253', '湖内区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3660', '710254', '凤山区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3661', '710255', '大寮区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3662', '710256', '林园区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3663', '710257', '鸟松区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3664', '710258', '大树区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3665', '710259', '旗山区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3666', '710260', '美浓区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3667', '710261', '六龟区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3668', '710262', '内门区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3669', '710263', '杉林区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3670', '710264', '甲仙区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3671', '710265', '桃源区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3672', '710266', '那玛夏区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3673', '710267', '茂林区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3674', '710268', '茄萣区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3675', '710299', '其它区', '3', '710200');
INSERT INTO `z_common_area` VALUES ('3676', '710301', '中西区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3677', '710302', '东区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3678', '710303', '南区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3679', '710304', '北区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3680', '710305', '安平区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3681', '710306', '安南区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3682', '710339', '永康区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3683', '710340', '归仁区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3684', '710341', '新化区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3685', '710342', '左镇区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3686', '710343', '玉井区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3687', '710344', '楠西区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3688', '710345', '南化区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3689', '710346', '仁德区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3690', '710347', '关庙区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3691', '710348', '龙崎区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3692', '710349', '官田区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3693', '710350', '麻豆区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3694', '710351', '佳里区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3695', '710352', '西港区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3696', '710353', '七股区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3697', '710354', '将军区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3698', '710355', '学甲区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3699', '710356', '北门区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3700', '710357', '新营区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3701', '710358', '后壁区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3702', '710359', '白河区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3703', '710360', '东山区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3704', '710361', '六甲区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3705', '710362', '下营区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3706', '710363', '柳营区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3707', '710364', '盐水区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3708', '710365', '善化区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3709', '710366', '大内区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3710', '710367', '山上区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3711', '710368', '新市区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3712', '710369', '安定区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3713', '710399', '其它区', '3', '710300');
INSERT INTO `z_common_area` VALUES ('3714', '710401', '中区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3715', '710402', '东区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3716', '710403', '南区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3717', '710404', '西区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3718', '710405', '北区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3719', '710406', '北屯区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3720', '710407', '西屯区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3721', '710408', '南屯区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3722', '710431', '太平区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3723', '710432', '大里区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3724', '710433', '雾峰区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3725', '710434', '乌日区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3726', '710435', '丰原区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3727', '710436', '后里区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3728', '710437', '石冈区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3729', '710438', '东势区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3730', '710439', '和平区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3731', '710440', '新社区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3732', '710441', '潭子区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3733', '710442', '大雅区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3734', '710443', '神冈区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3735', '710444', '大肚区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3736', '710445', '沙鹿区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3737', '710446', '龙井区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3738', '710447', '梧栖区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3739', '710448', '清水区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3740', '710449', '大甲区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3741', '710450', '外埔区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3742', '710451', '大安区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3743', '710499', '其它区', '3', '710400');
INSERT INTO `z_common_area` VALUES ('3744', '710507', '金沙镇', '3', '710500');
INSERT INTO `z_common_area` VALUES ('3745', '710508', '金湖镇', '3', '710500');
INSERT INTO `z_common_area` VALUES ('3746', '710509', '金宁乡', '3', '710500');
INSERT INTO `z_common_area` VALUES ('3747', '710510', '金城镇', '3', '710500');
INSERT INTO `z_common_area` VALUES ('3748', '710511', '烈屿乡', '3', '710500');
INSERT INTO `z_common_area` VALUES ('3749', '710512', '乌坵乡', '3', '710500');
INSERT INTO `z_common_area` VALUES ('3750', '710614', '南投市', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3751', '710615', '中寮乡', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3752', '710616', '草屯镇', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3753', '710617', '国姓乡', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3754', '710618', '埔里镇', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3755', '710619', '仁爱乡', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3756', '710620', '名间乡', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3757', '710621', '集集镇', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3758', '710622', '水里乡', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3759', '710623', '鱼池乡', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3760', '710624', '信义乡', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3761', '710625', '竹山镇', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3762', '710626', '鹿谷乡', '3', '710600');
INSERT INTO `z_common_area` VALUES ('3763', '710701', '仁爱区', '3', '710700');
INSERT INTO `z_common_area` VALUES ('3764', '710702', '信义区', '3', '710700');
INSERT INTO `z_common_area` VALUES ('3765', '710703', '中正区', '3', '710700');
INSERT INTO `z_common_area` VALUES ('3766', '710704', '中山区', '3', '710700');
INSERT INTO `z_common_area` VALUES ('3767', '710705', '安乐区', '3', '710700');
INSERT INTO `z_common_area` VALUES ('3768', '710706', '暖暖区', '3', '710700');
INSERT INTO `z_common_area` VALUES ('3769', '710707', '七堵区', '3', '710700');
INSERT INTO `z_common_area` VALUES ('3770', '710799', '其它区', '3', '710700');
INSERT INTO `z_common_area` VALUES ('3771', '710801', '东区', '3', '710800');
INSERT INTO `z_common_area` VALUES ('3772', '710802', '北区', '3', '710800');
INSERT INTO `z_common_area` VALUES ('3773', '710803', '香山区', '3', '710800');
INSERT INTO `z_common_area` VALUES ('3774', '710899', '其它区', '3', '710800');
INSERT INTO `z_common_area` VALUES ('3775', '710901', '东区', '3', '710900');
INSERT INTO `z_common_area` VALUES ('3776', '710902', '西区', '3', '710900');
INSERT INTO `z_common_area` VALUES ('3777', '710999', '其它区', '3', '710900');
INSERT INTO `z_common_area` VALUES ('3778', '711130', '万里区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3779', '711132', '板桥区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3780', '711133', '汐止区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3781', '711134', '深坑区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3782', '711135', '石碇区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3783', '711136', '瑞芳区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3784', '711137', '平溪区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3785', '711138', '双溪区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3786', '711139', '贡寮区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3787', '711140', '新店区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3788', '711141', '坪林区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3789', '711142', '乌来区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3790', '711143', '永和区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3791', '711144', '中和区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3792', '711145', '土城区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3793', '711146', '三峡区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3794', '711147', '树林区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3795', '711148', '莺歌区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3796', '711149', '三重区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3797', '711150', '新庄区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3798', '711151', '泰山区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3799', '711152', '林口区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3800', '711153', '芦洲区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3801', '711154', '五股区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3802', '711155', '八里区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3803', '711156', '淡水区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3804', '711157', '三芝区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3805', '711158', '石门区', '3', '711100');
INSERT INTO `z_common_area` VALUES ('3806', '711287', '宜兰市', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3807', '711288', '头城镇', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3808', '711289', '礁溪乡', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3809', '711290', '壮围乡', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3810', '711291', '员山乡', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3811', '711292', '罗东镇', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3812', '711293', '三星乡', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3813', '711294', '大同乡', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3814', '711295', '五结乡', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3815', '711296', '冬山乡', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3816', '711297', '苏澳镇', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3817', '711298', '南澳乡', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3818', '711299', '钓鱼台', '3', '711200');
INSERT INTO `z_common_area` VALUES ('3819', '711387', '竹北市', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3820', '711388', '湖口乡', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3821', '711389', '新丰乡', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3822', '711390', '新埔镇', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3823', '711391', '关西镇', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3824', '711392', '芎林乡', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3825', '711393', '宝山乡', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3826', '711394', '竹东镇', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3827', '711395', '五峰乡', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3828', '711396', '横山乡', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3829', '711397', '尖石乡', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3830', '711398', '北埔乡', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3831', '711399', '峨眉乡', '3', '711300');
INSERT INTO `z_common_area` VALUES ('3832', '711414', '中坜区', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3833', '711415', '平镇区', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3834', '711417', '杨梅区', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3835', '711418', '新屋区', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3836', '711419', '观音区', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3837', '711420', '桃园区', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3838', '711421', '龟山区', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3839', '711422', '八德区', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3840', '711423', '大溪区', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3841', '711425', '大园区', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3842', '711426', '芦竹区', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3843', '711487', '中坜市', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3844', '711488', '平镇市', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3845', '711489', '龙潭乡', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3846', '711490', '杨梅市', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3847', '711491', '新屋乡', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3848', '711492', '观音乡', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3849', '711493', '桃园市', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3850', '711494', '龟山乡', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3851', '711495', '八德市', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3852', '711496', '大溪镇', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3853', '711497', '复兴乡', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3854', '711498', '大园乡', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3855', '711499', '芦竹乡', '3', '711400');
INSERT INTO `z_common_area` VALUES ('3856', '711520', '头份市', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3857', '711582', '竹南镇', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3858', '711583', '头份镇', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3859', '711584', '三湾乡', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3860', '711585', '南庄乡', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3861', '711586', '狮潭乡', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3862', '711587', '后龙镇', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3863', '711588', '通霄镇', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3864', '711589', '苑里镇', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3865', '711590', '苗栗市', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3866', '711591', '造桥乡', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3867', '711592', '头屋乡', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3868', '711593', '公馆乡', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3869', '711594', '大湖乡', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3870', '711595', '泰安乡', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3871', '711596', '铜锣乡', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3872', '711597', '三义乡', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3873', '711598', '西湖乡', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3874', '711599', '卓兰镇', '3', '711500');
INSERT INTO `z_common_area` VALUES ('3875', '711736', '员林市', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3876', '711774', '彰化市', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3877', '711775', '芬园乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3878', '711776', '花坛乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3879', '711777', '秀水乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3880', '711778', '鹿港镇', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3881', '711779', '福兴乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3882', '711780', '线西乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3883', '711781', '和美镇', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3884', '711782', '伸港乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3885', '711783', '员林镇', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3886', '711784', '社头乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3887', '711785', '永靖乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3888', '711786', '埔心乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3889', '711787', '溪湖镇', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3890', '711788', '大村乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3891', '711789', '埔盐乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3892', '711790', '田中镇', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3893', '711791', '北斗镇', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3894', '711792', '田尾乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3895', '711793', '埤头乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3896', '711794', '溪州乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3897', '711795', '竹塘乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3898', '711796', '二林镇', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3899', '711797', '大城乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3900', '711798', '芳苑乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3901', '711799', '二水乡', '3', '711700');
INSERT INTO `z_common_area` VALUES ('3902', '711982', '番路乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3903', '711983', '梅山乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3904', '711984', '竹崎乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3905', '711985', '阿里山乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3906', '711986', '中埔乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3907', '711987', '大埔乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3908', '711988', '水上乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3909', '711989', '鹿草乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3910', '711990', '太保市', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3911', '711991', '朴子市', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3912', '711992', '东石乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3913', '711993', '六脚乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3914', '711994', '新港乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3915', '711995', '民雄乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3916', '711996', '大林镇', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3917', '711997', '溪口乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3918', '711998', '义竹乡', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3919', '711999', '布袋镇', '3', '711900');
INSERT INTO `z_common_area` VALUES ('3920', '712180', '斗南镇', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3921', '712181', '大埤乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3922', '712182', '虎尾镇', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3923', '712183', '土库镇', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3924', '712184', '褒忠乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3925', '712185', '东势乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3926', '712186', '台西乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3927', '712187', '仑背乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3928', '712188', '麦寮乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3929', '712189', '斗六市', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3930', '712190', '林内乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3931', '712191', '古坑乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3932', '712192', '莿桐乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3933', '712193', '西螺镇', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3934', '712194', '二仑乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3935', '712195', '北港镇', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3936', '712196', '水林乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3937', '712197', '口湖乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3938', '712198', '四湖乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3939', '712199', '元长乡', '3', '712100');
INSERT INTO `z_common_area` VALUES ('3940', '712451', '崁顶乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3941', '712467', '屏东市', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3942', '712468', '三地门乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3943', '712469', '雾台乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3944', '712470', '玛家乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3945', '712471', '九如乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3946', '712472', '里港乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3947', '712473', '高树乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3948', '712474', '盐埔乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3949', '712475', '长治乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3950', '712476', '麟洛乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3951', '712477', '竹田乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3952', '712478', '内埔乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3953', '712479', '万丹乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3954', '712480', '潮州镇', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3955', '712481', '泰武乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3956', '712482', '来义乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3957', '712483', '万峦乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3958', '712484', '莰顶乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3959', '712485', '新埤乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3960', '712486', '南州乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3961', '712487', '林边乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3962', '712488', '东港镇', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3963', '712489', '琉球乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3964', '712490', '佳冬乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3965', '712491', '新园乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3966', '712492', '枋寮乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3967', '712493', '枋山乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3968', '712494', '春日乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3969', '712495', '狮子乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3970', '712496', '车城乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3971', '712497', '牡丹乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3972', '712498', '恒春镇', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3973', '712499', '满州乡', '3', '712400');
INSERT INTO `z_common_area` VALUES ('3974', '712584', '台东市', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3975', '712585', '绿岛乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3976', '712586', '兰屿乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3977', '712587', '延平乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3978', '712588', '卑南乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3979', '712589', '鹿野乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3980', '712590', '关山镇', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3981', '712591', '海端乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3982', '712592', '池上乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3983', '712593', '东河乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3984', '712594', '成功镇', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3985', '712595', '长滨乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3986', '712596', '金峰乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3987', '712597', '大武乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3988', '712598', '达仁乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3989', '712599', '太麻里乡', '3', '712500');
INSERT INTO `z_common_area` VALUES ('3990', '712686', '花莲市', '3', '712600');
INSERT INTO `z_common_area` VALUES ('3991', '712687', '新城乡', '3', '712600');
INSERT INTO `z_common_area` VALUES ('3992', '712688', '太鲁阁', '3', '712600');
INSERT INTO `z_common_area` VALUES ('3993', '712689', '秀林乡', '3', '712600');
INSERT INTO `z_common_area` VALUES ('3994', '712690', '吉安乡', '3', '712600');
INSERT INTO `z_common_area` VALUES ('3995', '712691', '寿丰乡', '3', '712600');
INSERT INTO `z_common_area` VALUES ('3996', '712692', '凤林镇', '3', '712600');
INSERT INTO `z_common_area` VALUES ('3997', '712693', '光复乡', '3', '712600');
INSERT INTO `z_common_area` VALUES ('3998', '712694', '丰滨乡', '3', '712600');
INSERT INTO `z_common_area` VALUES ('3999', '712695', '瑞穗乡', '3', '712600');
INSERT INTO `z_common_area` VALUES ('4000', '712696', '万荣乡', '3', '712600');
INSERT INTO `z_common_area` VALUES ('4001', '712697', '玉里镇', '3', '712600');
INSERT INTO `z_common_area` VALUES ('4002', '712698', '卓溪乡', '3', '712600');
INSERT INTO `z_common_area` VALUES ('4003', '712699', '富里乡', '3', '712600');
INSERT INTO `z_common_area` VALUES ('4004', '712794', '马公市', '3', '712700');
INSERT INTO `z_common_area` VALUES ('4005', '712795', '西屿乡', '3', '712700');
INSERT INTO `z_common_area` VALUES ('4006', '712796', '望安乡', '3', '712700');
INSERT INTO `z_common_area` VALUES ('4007', '712797', '七美乡', '3', '712700');
INSERT INTO `z_common_area` VALUES ('4008', '712798', '白沙乡', '3', '712700');
INSERT INTO `z_common_area` VALUES ('4009', '712799', '湖西乡', '3', '712700');
INSERT INTO `z_common_area` VALUES ('4010', '712896', '南竿乡', '3', '712800');
INSERT INTO `z_common_area` VALUES ('4011', '712897', '北竿乡', '3', '712800');
INSERT INTO `z_common_area` VALUES ('4012', '712898', '东引乡', '3', '712800');
INSERT INTO `z_common_area` VALUES ('4013', '712899', '莒光乡', '3', '712800');
INSERT INTO `z_common_area` VALUES ('4014', '810101', '中西区', '3', '810100');
INSERT INTO `z_common_area` VALUES ('4015', '810102', '湾仔区', '3', '810100');
INSERT INTO `z_common_area` VALUES ('4016', '810103', '东区', '3', '810100');
INSERT INTO `z_common_area` VALUES ('4017', '810104', '南区', '3', '810100');
INSERT INTO `z_common_area` VALUES ('4018', '810201', '九龙城区', '3', '810200');
INSERT INTO `z_common_area` VALUES ('4019', '810202', '油尖旺区', '3', '810200');
INSERT INTO `z_common_area` VALUES ('4020', '810203', '深水埗区', '3', '810200');
INSERT INTO `z_common_area` VALUES ('4021', '810204', '黄大仙区', '3', '810200');
INSERT INTO `z_common_area` VALUES ('4022', '810205', '观塘区', '3', '810200');
INSERT INTO `z_common_area` VALUES ('4023', '810301', '北区', '3', '810300');
INSERT INTO `z_common_area` VALUES ('4024', '810302', '大埔区', '3', '810300');
INSERT INTO `z_common_area` VALUES ('4025', '810303', '沙田区', '3', '810300');
INSERT INTO `z_common_area` VALUES ('4026', '810304', '西贡区', '3', '810300');
INSERT INTO `z_common_area` VALUES ('4027', '810305', '元朗区', '3', '810300');
INSERT INTO `z_common_area` VALUES ('4028', '810306', '屯门区', '3', '810300');
INSERT INTO `z_common_area` VALUES ('4029', '810307', '荃湾区', '3', '810300');
INSERT INTO `z_common_area` VALUES ('4030', '810308', '葵青区', '3', '810300');
INSERT INTO `z_common_area` VALUES ('4031', '810309', '离岛区', '3', '810300');
INSERT INTO `z_common_area` VALUES ('4032', '820101', '澳门半岛', '3', '820100');
INSERT INTO `z_common_area` VALUES ('4033', '820201', '离岛', '3', '820200');

-- ----------------------------
-- Table structure for z_message_content
-- ----------------------------
DROP TABLE IF EXISTS `z_message_content`;
CREATE TABLE `z_message_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sender_id` bigint(20) NOT NULL COMMENT '发送者主键',
  `receiver_id` bigint(20) NOT NULL COMMENT '接收者主键',
  `content` text CHARACTER SET utf8mb4 NOT NULL COMMENT '内容',
  `sender_avatar` varchar(255) NOT NULL COMMENT '发送者头像',
  `sender_nickname` varchar(255) NOT NULL COMMENT '发送者昵称',
  `is_sign` int(11) NOT NULL DEFAULT '1' COMMENT '是否已读 0-是 1-否',
  `type` int(11) NOT NULL COMMENT '消息类型 1-文字 2-图片 3-视频 ...',
  `send_time` datetime NOT NULL COMMENT '发送时间',
  `receiver_time` datetime DEFAULT NULL COMMENT '接收时间',
  `logic_flag` int(11) NOT NULL DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='聊天消息表';

-- ----------------------------
-- Records of z_message_content
-- ----------------------------

-- ----------------------------
-- Table structure for z_post_activity
-- ----------------------------
DROP TABLE IF EXISTS `z_post_activity`;
CREATE TABLE `z_post_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_id` bigint(20) NOT NULL COMMENT '发布者主键',
  `academy_id` bigint(20) NOT NULL COMMENT '院部主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `abs` varchar(255) DEFAULT NULL COMMENT '摘要',
  `content` text COMMENT '内容',
  `images` varchar(999) DEFAULT NULL COMMENT '图片',
  `category` bigint(20) DEFAULT '0' COMMENT '活动类型',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `release_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `type` int(11) DEFAULT '1' COMMENT '活动类型 1-组织活动 2-报名活动',
  `sign_start_time` datetime DEFAULT NULL COMMENT '报名开始时间',
  `sign_end_time` datetime DEFAULT NULL COMMENT '报名截止时间',
  `max_number` int(11) DEFAULT '10000' COMMENT '人数上限',
  `state` int(11) DEFAULT '1' COMMENT '状态 0-全部 1-未审核 2-通过 3-未通过 4-已结束',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-否 1-是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='活动发布表';

-- ----------------------------
-- Records of z_post_activity
-- ----------------------------
INSERT INTO `z_post_activity` VALUES ('1', '21', '13', '活动', '摘要', '内容<br/>内容<br/>内容<br/>内容内容内容内容内容内容<br/>内容<br/>', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3014871590,1877513669&fm=26&gp=0.jpg', '1', '2020-03-30 16:52:26', '2020-03-31 16:52:29', '2020-03-01 14:04:40', '1', '2020-03-01 14:04:44', '2020-03-01 14:04:46', '10000', '2', '2020-03-01 14:04:53', '2020-03-01 17:12:48', '1');
INSERT INTO `z_post_activity` VALUES ('8', '83', '13', '约跑步', '', '矿大二运', '', '1', '2020-04-01 20:00:00', '2020-04-01 21:00:00', '2020-05-25 14:53:12', '1', null, null, '30', '1', '2020-05-25 14:53:12', '2020-05-25 14:53:12', '1');

-- ----------------------------
-- Table structure for z_post_category
-- ----------------------------
DROP TABLE IF EXISTS `z_post_category`;
CREATE TABLE `z_post_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_name` text NOT NULL COMMENT '类别名称',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='内容类别表';

-- ----------------------------
-- Records of z_post_category
-- ----------------------------
INSERT INTO `z_post_category` VALUES ('1', '生活', '2020-02-12 10:31:02', '2020-02-12 10:31:02', '1');
INSERT INTO `z_post_category` VALUES ('2', '运动', '2020-02-12 10:31:13', '2020-02-12 10:31:13', '1');
INSERT INTO `z_post_category` VALUES ('3', '学习', '2020-02-12 10:31:27', '2020-02-12 10:31:27', '1');
INSERT INTO `z_post_category` VALUES ('4', '其他', '2020-02-12 10:31:34', '2020-02-12 10:31:34', '1');

-- ----------------------------
-- Table structure for z_post_collect
-- ----------------------------
DROP TABLE IF EXISTS `z_post_collect`;
CREATE TABLE `z_post_collect` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_id` bigint(20) NOT NULL COMMENT '学生主键',
  `content_id` bigint(20) NOT NULL COMMENT '内容主键',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) NOT NULL DEFAULT '1' COMMENT '是否逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='收藏表';

-- ----------------------------
-- Records of z_post_collect
-- ----------------------------

-- ----------------------------
-- Table structure for z_post_comment
-- ----------------------------
DROP TABLE IF EXISTS `z_post_comment`;
CREATE TABLE `z_post_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `post_id` bigint(20) NOT NULL COMMENT '发布内容主键',
  `student_id` bigint(20) NOT NULL COMMENT '用户主键',
  `content` text COMMENT '内容',
  `category` bigint(20) DEFAULT '0' COMMENT '内容类型 0-所有 1-活动 2-动态 3-热点',
  `comment_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_post_comment
-- ----------------------------
INSERT INTO `z_post_comment` VALUES ('1', '32', '42', '来了~', '2', '2020-05-06 21:09:56', '2020-05-06 21:09:56', '2020-05-06 21:09:56', '1');
INSERT INTO `z_post_comment` VALUES ('2', '32', '42', '回复微校member：come on~', '2', '2020-05-06 21:31:21', '2020-05-06 21:31:21', '2020-05-06 21:31:21', '1');
INSERT INTO `z_post_comment` VALUES ('3', '32', '42', 'hah~', '2', '2020-05-06 21:32:43', '2020-05-06 21:32:43', '2020-05-06 21:32:43', '1');
INSERT INTO `z_post_comment` VALUES ('4', '32', '42', '回复微校member：heh~', '2', '2020-05-06 21:32:51', '2020-05-06 21:32:51', '2020-05-06 21:32:51', '1');

-- ----------------------------
-- Table structure for z_post_content
-- ----------------------------
DROP TABLE IF EXISTS `z_post_content`;
CREATE TABLE `z_post_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_id` bigint(20) NOT NULL COMMENT '用户主键',
  `academy_id` bigint(20) NOT NULL COMMENT '院部主键',
  `content` text COMMENT '发布内容',
  `images` varchar(999) DEFAULT NULL COMMENT '图片',
  `category` bigint(20) DEFAULT '0' COMMENT '内容类型',
  `release_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `look_num` int(11) DEFAULT '0' COMMENT '浏览次数',
  `like_num` int(11) DEFAULT '0' COMMENT '点赞次数',
  `review_state` int(11) DEFAULT '1' COMMENT '审核状态 0-全部 1-审核中 2-通过 3-不通过',
  `state` int(11) DEFAULT '1' COMMENT '状态 0-全部 1-正常 2-禁用',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='发布内容表';

-- ----------------------------
-- Records of z_post_content
-- ----------------------------
INSERT INTO `z_post_content` VALUES ('30', '42', '13', '这是一个<br/>\n换行的<br/>分享<br/>分享<br/>分享', '', '1', '2020-03-27 15:19:49', '10', '1', '2', '1', '2020-03-27 15:19:49', '2020-03-27 15:19:49', '1');
INSERT INTO `z_post_content` VALUES ('31', '42', '13', '正在测试<br/>换行<br/>分享<br/>加&nbsp;空格', '', '1', '2020-03-27 15:36:14', '10', '0', '3', '1', '2020-03-27 15:36:14', '2020-03-27 15:36:14', '1');
INSERT INTO `z_post_content` VALUES ('32', '71', '13', '我注册了，快来找我聊天~', '', '4', '2020-04-21 11:06:58', '35', '2', '2', '1', '2020-04-21 11:06:58', '2020-04-21 11:06:58', '1');
INSERT INTO `z_post_content` VALUES ('33', '70', '13', '快点来和我聊天啊！太寂寞了！！！', '', '4', '2020-04-22 16:45:54', '6', '0', '1', '1', '2020-04-22 16:45:54', '2020-04-22 16:45:54', '1');
INSERT INTO `z_post_content` VALUES ('39', '82', '13', '约跑步', '', '1', '2020-05-24 00:01:38', '0', '0', '1', '1', '2020-05-24 00:01:38', '2020-05-24 00:01:38', '0');
INSERT INTO `z_post_content` VALUES ('41', '83', '13', '竹苑一号楼', '', '1', '2020-05-25 14:48:24', '0', '0', '1', '1', '2020-05-25 14:48:24', '2020-05-25 14:48:24', '0');
INSERT INTO `z_post_content` VALUES ('42', '83', '13', '竹苑一号楼出洗发水', '', '1', '2020-05-25 14:49:57', '0', '0', '3', '1', '2020-05-25 14:49:57', '2020-05-27 08:50:00', '1');

-- ----------------------------
-- Table structure for z_post_hot
-- ----------------------------
DROP TABLE IF EXISTS `z_post_hot`;
CREATE TABLE `z_post_hot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT '' COMMENT '标题',
  `content` text COMMENT '发布内容',
  `images` varchar(999) DEFAULT NULL COMMENT '图片',
  `release_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
  `look_num` int(11) DEFAULT '0' COMMENT '浏览次数',
  `like_num` int(11) DEFAULT '0' COMMENT '点赞次数',
  `state` int(11) DEFAULT '1' COMMENT '状态 0-禁止 1-正常',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='热点内容表';

-- ----------------------------
-- Records of z_post_hot
-- ----------------------------
INSERT INTO `z_post_hot` VALUES ('1', '热点1', '热点内容', 'http://news.jcrb.com/fzrd/201706/W020170630559466991194.jpg', '2020-02-28 11:44:35', '2019-01-01 09:01:01', '2019-01-01 09:01:01', '0', '1', '1', '2020-02-28 11:44:35', '2020-03-02 12:33:53', '1');
INSERT INTO `z_post_hot` VALUES ('2', '热点热点', '热点内容热点内容', 'http://5b0988e595225.cdn.sohucs.com/images/20180525/0ee76119666645af9d5b7053021b0a53.png', '2020-02-28 11:45:32', '2020-02-28 11:45:32', '2020-05-31 11:45:32', '1', '0', '1', '2020-02-28 11:45:32', '2020-02-28 15:01:58', '1');
INSERT INTO `z_post_hot` VALUES ('3', '新增', '新增热点', 'http://5b0988e595225.cdn.sohucs.com/images/20191203/b779fc83135a42179fe207830275e627.png', '2020-02-28 15:06:41', '2020-02-08 00:00:00', '2020-05-31 00:00:00', '0', '0', '1', '2020-02-28 15:06:41', '2020-03-02 12:35:00', '1');
INSERT INTO `z_post_hot` VALUES ('4', '新增多个', '新增多个', 'http://img1.imgtn.bdimg.com/it/u=3193455894,2633924309&fm=26&gp=0.jpg', '2020-02-28 15:08:10', '2020-02-08 00:00:00', '2020-05-31 00:00:00', '0', '0', '1', '2020-02-28 15:08:10', '2020-03-02 12:33:47', '1');

-- ----------------------------
-- Table structure for z_post_like
-- ----------------------------
DROP TABLE IF EXISTS `z_post_like`;
CREATE TABLE `z_post_like` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) NOT NULL COMMENT '学生主键',
  `content_id` bigint(20) NOT NULL COMMENT '内容主键',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `logic_flag` int(11) NOT NULL DEFAULT '1' COMMENT '是否逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='点赞表';

-- ----------------------------
-- Records of z_post_like
-- ----------------------------

-- ----------------------------
-- Table structure for z_post_reply
-- ----------------------------
DROP TABLE IF EXISTS `z_post_reply`;
CREATE TABLE `z_post_reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `post_id` bigint(20) NOT NULL COMMENT '发布内容主键',
  `comment_id` bigint(20) NOT NULL COMMENT '评论主键',
  `student_id` bigint(20) NOT NULL COMMENT '回复者主键',
  `content` text COMMENT '回复内容',
  `replay_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '回复时间',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回复表';

-- ----------------------------
-- Records of z_post_reply
-- ----------------------------

-- ----------------------------
-- Table structure for z_post_sign
-- ----------------------------
DROP TABLE IF EXISTS `z_post_sign`;
CREATE TABLE `z_post_sign` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) NOT NULL COMMENT '活动主键',
  `student_id` bigint(20) DEFAULT NULL COMMENT '学生主键',
  `qq` varchar(255) DEFAULT NULL COMMENT 'qq号码',
  `phone` varchar(255) DEFAULT '' COMMENT '电话',
  `message` text COMMENT '备注',
  `sign_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '报名时间',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='活动报名表';

-- ----------------------------
-- Records of z_post_sign
-- ----------------------------

-- ----------------------------
-- Table structure for z_school_academy
-- ----------------------------
DROP TABLE IF EXISTS `z_school_academy`;
CREATE TABLE `z_school_academy` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `academy_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `parent_id` bigint(11) DEFAULT NULL,
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COMMENT='院部专业信息表';

-- ----------------------------
-- Records of z_school_academy
-- ----------------------------
INSERT INTO `z_school_academy` VALUES ('1', '经济学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('2', '马克思主义学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('3', '法学与公共管理学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('4', '教育科学学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('5', '体育学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('6', '文学与新闻传播学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('7', '外国语学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('8', '数学与计算科学学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('9', '机械与光电物理学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('10', '化学与材料工程学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('11', '生物与食品工程学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('12', '电气与信息工程学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('13', '计算机科学与工程学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('14', '风景园林学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('15', '商学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('16', '音乐舞蹈学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('17', '美术学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('18', '设计艺术学院', '0', '1');
INSERT INTO `z_school_academy` VALUES ('19', '思想政治教育', '2', '1');
INSERT INTO `z_school_academy` VALUES ('20', '法学', '3', '1');
INSERT INTO `z_school_academy` VALUES ('21', '社会工作', '3', '1');
INSERT INTO `z_school_academy` VALUES ('22', '土地资源管理', '3', '1');
INSERT INTO `z_school_academy` VALUES ('23', '公共事业管理', '3', '1');
INSERT INTO `z_school_academy` VALUES ('24', '小学教育', '4', '1');
INSERT INTO `z_school_academy` VALUES ('25', '学前教育', '4', '1');
INSERT INTO `z_school_academy` VALUES ('26', '人文教育', '4', '1');
INSERT INTO `z_school_academy` VALUES ('27', '科学教育', '4', '1');
INSERT INTO `z_school_academy` VALUES ('28', '体育教育', '5', '1');
INSERT INTO `z_school_academy` VALUES ('29', '社会体育指导与管理', '5', '1');
INSERT INTO `z_school_academy` VALUES ('30', '汉语言文学', '6', '1');
INSERT INTO `z_school_academy` VALUES ('31', '广播电视学', '6', '1');
INSERT INTO `z_school_academy` VALUES ('32', '网络与新媒体', '6', '1');
INSERT INTO `z_school_academy` VALUES ('33', '英语', '7', '1');
INSERT INTO `z_school_academy` VALUES ('34', '商务英语', '7', '1');
INSERT INTO `z_school_academy` VALUES ('35', '数学与应用数学', '8', '1');
INSERT INTO `z_school_academy` VALUES ('36', '信息与计算科学', '8', '1');
INSERT INTO `z_school_academy` VALUES ('37', '物理学', '9', '1');
INSERT INTO `z_school_academy` VALUES ('38', '光电信息科学与工程', '9', '1');
INSERT INTO `z_school_academy` VALUES ('39', '机械设计制造及其自动化', '9', '1');
INSERT INTO `z_school_academy` VALUES ('40', '化学', '10', '1');
INSERT INTO `z_school_academy` VALUES ('41', '制药工程', '10', '1');
INSERT INTO `z_school_academy` VALUES ('42', '材料化学', '10', '1');
INSERT INTO `z_school_academy` VALUES ('43', '材料科学与工程', '10', '1');
INSERT INTO `z_school_academy` VALUES ('44', '生物科学', '11', '1');
INSERT INTO `z_school_academy` VALUES ('45', '生物工程', '11', '1');
INSERT INTO `z_school_academy` VALUES ('46', '食品科学与工程', '11', '1');
INSERT INTO `z_school_academy` VALUES ('47', '食品质量与安全', '11', '1');
INSERT INTO `z_school_academy` VALUES ('48', '生物制药', '11', '1');
INSERT INTO `z_school_academy` VALUES ('49', '电子信息科学与技术', '12', '1');
INSERT INTO `z_school_academy` VALUES ('50', '通信工程', '12', '1');
INSERT INTO `z_school_academy` VALUES ('51', '广播电视工程', '12', '1');
INSERT INTO `z_school_academy` VALUES ('52', '电气工程及其自动化', '12', '1');
INSERT INTO `z_school_academy` VALUES ('53', '计算机科学与技术', '13', '1');
INSERT INTO `z_school_academy` VALUES ('54', '网络工程', '13', '1');
INSERT INTO `z_school_academy` VALUES ('55', '软件工程', '13', '1');
INSERT INTO `z_school_academy` VALUES ('56', '园林', '14', '1');
INSERT INTO `z_school_academy` VALUES ('57', '风景园林', '14', '1');
INSERT INTO `z_school_academy` VALUES ('58', '旅游管理', '15', '1');
INSERT INTO `z_school_academy` VALUES ('59', '物流管理', '15', '1');
INSERT INTO `z_school_academy` VALUES ('60', '财务管理', '15', '1');
INSERT INTO `z_school_academy` VALUES ('61', '酒店管理', '15', '1');
INSERT INTO `z_school_academy` VALUES ('62', '音乐学', '16', '1');
INSERT INTO `z_school_academy` VALUES ('63', '舞蹈学', '16', '1');
INSERT INTO `z_school_academy` VALUES ('64', '音乐表演', '16', '1');
INSERT INTO `z_school_academy` VALUES ('65', '美术学', '17', '1');
INSERT INTO `z_school_academy` VALUES ('66', '工业设计', '18', '1');
INSERT INTO `z_school_academy` VALUES ('67', '视觉传达设计', '18', '1');
INSERT INTO `z_school_academy` VALUES ('68', '环境设计', '18', '1');
INSERT INTO `z_school_academy` VALUES ('69', '产品设计', '18', '1');
INSERT INTO `z_school_academy` VALUES ('70', '服装与服饰设计', '18', '1');
INSERT INTO `z_school_academy` VALUES ('71', '数字媒体艺术', '18', '1');
INSERT INTO `z_school_academy` VALUES ('72', '国际经济与贸易', '1', '1');
INSERT INTO `z_school_academy` VALUES ('73', '投资学', '1', '1');

-- ----------------------------
-- Table structure for z_student_feedback
-- ----------------------------
DROP TABLE IF EXISTS `z_student_feedback`;
CREATE TABLE `z_student_feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_id` bigint(20) NOT NULL COMMENT '学生主键',
  `content` text NOT NULL COMMENT '内容',
  `handle` int(11) NOT NULL DEFAULT '1' COMMENT '是否已处理 0-已处理 1-未处理',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_falg` int(11) NOT NULL DEFAULT '1' COMMENT '是否逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_student_feedback
-- ----------------------------
INSERT INTO `z_student_feedback` VALUES ('1', '70', 'nice', '1', '2020-04-24 11:34:25', '2020-04-24 11:34:25', '1');
INSERT INTO `z_student_feedback` VALUES ('2', '70', '哈哈', '1', '2020-04-24 11:36:05', '2020-04-24 11:36:05', '1');

-- ----------------------------
-- Table structure for z_student_follow
-- ----------------------------
DROP TABLE IF EXISTS `z_student_follow`;
CREATE TABLE `z_student_follow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_id` bigint(20) NOT NULL COMMENT '学生主键',
  `follow_student_id` bigint(20) NOT NULL COMMENT '被关注学生主键',
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(255) DEFAULT '1' COMMENT '是否逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_student_follow
-- ----------------------------

-- ----------------------------
-- Table structure for z_student_member
-- ----------------------------
DROP TABLE IF EXISTS `z_student_member`;
CREATE TABLE `z_student_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `truename` varchar(255) DEFAULT '微校用户' COMMENT '姓名',
  `nickname` varchar(255) DEFAULT '匿名' COMMENT '昵称',
  `sex` int(11) DEFAULT '3' COMMENT '性别 0-所有 1-男 2-女 3-不详',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `area_id` bigint(20) DEFAULT '0' COMMENT '地区id',
  `area` varchar(255) DEFAULT '不详' COMMENT '地区',
  `number` varchar(255) DEFAULT '' COMMENT '学号',
  `phone` varchar(255) DEFAULT '' COMMENT '手机号',
  `face_img` varchar(255) DEFAULT 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg' COMMENT '头像',
  `face_img_min` varchar(255) DEFAULT 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg' COMMENT '聊天头像',
  `academy_id` bigint(20) NOT NULL DEFAULT '100' COMMENT '专业id',
  `autograph` varchar(255) DEFAULT '太懒了，签名都不想写...' COMMENT '个人签名',
  `hide` int(11) DEFAULT '1' COMMENT '是否隐藏个人信息 1-不隐藏 2-隐藏',
  `state` int(11) DEFAULT '1' COMMENT '状态 0-全部 1-启用 2-禁用',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Records of z_student_member
-- ----------------------------
INSERT INTO `z_student_member` VALUES ('10', 'student', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', '微校用户02', 'vip student 2', '0', '0', '0', '不详', '1600130001', '13333333333', 'http://zcoder.top:8080/images/93fe0837ca7af34c5b3a36b937f2d6be.jpg', 'http://zcoder.top:8080/images/93fe0837ca7af34c5b3a36b937f2d6be.jpg', '21', '太懒了，签名都不想写...', '0', '1', '2019-11-27 18:04:37', '2019-11-27 19:07:06', '1');
INSERT INTO `z_student_member` VALUES ('11', 'user1', '$10$gX2XkedIXYHOeezPJFF3R.wI3rB0gP7xEUZQbEbUyeRsj.m4NVL52', '微校用户03', '匿名', '0', '0', '0', '不详', '', '', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3014871590,1877513669&fm=26&gp=0.jpg', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3014871590,1877513669&fm=26&gp=0.jpg', '26', '太懒了，签名都不想写...', '1', '0', '2019-11-28 11:10:17', '2019-11-28 11:10:17', '1');
INSERT INTO `z_student_member` VALUES ('13', 'root', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', '微校用户04', '匿名', '0', '0', '0', '不详', '', '', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3014871590,1877513669&fm=26&gp=0.jpg', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3014871590,1877513669&fm=26&gp=0.jpg', '999', '太懒了，签名都不想写...', '1', '1', '2019-11-28 14:54:18', '2019-11-28 14:54:18', '1');
INSERT INTO `z_student_member` VALUES ('14', 'adm', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', '微校用户05', '这个是管理员同步', '0', '0', '0', '不详', '1600000000', '10000000000', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3014871590,1877513669&fm=26&gp=0.jpg', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3014871590,1877513669&fm=26&gp=0.jpg', '20', '太懒了，签名都不想写...', '1', '1', '2019-11-28 15:03:16', '2019-11-28 15:03:16', '1');
INSERT INTO `z_student_member` VALUES ('18', 'admin', '$2a$10$N74BcfXuXx01eHhwLMs3xumXttW5t6tz6KJ5ELZ4ST50VakS85Sba', '微校用户06', '这个是管理员同步', '0', '0', '0', '不详', '1600000000', '10000000000', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3014871590,1877513669&fm=26&gp=0.jpg', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3014871590,1877513669&fm=26&gp=0.jpg', '999', '太懒了，签名都不想写...', '1', '1', '2020-02-20 14:05:54', '2020-02-20 14:05:54', '1');
INSERT INTO `z_student_member` VALUES ('21', 'stu2', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', '微校用户09', 'vip stu2', '1', '0', '0', '不详', '1600130000', '12222222222', 'http://zcoder.top:8080/images/93fe0837ca7af34c5b3a36b937f2d6be.jpg', 'http://zcoder.top:8080/images/93fe0837ca7af34c5b3a36b937f2d6be.jpg', '53', 'hahaha', '1', '1', '2019-11-27 16:46:17', '2019-11-27 16:46:17', '1');
INSERT INTO `z_student_member` VALUES ('42', 'member', '$2a$10$FQVFioYKOImJFGwxcFjK7e2kYf1OAGB4hvGLwTZDZSvVAsFIeTarK', '微校member', '微校member', '3', '21', '2380', '溆浦县', '1600000000', '17777777777', 'http://zcoder.top:8087/files/42/1dc70266bc4b4354814c80101ffebfdd-下载.jpg', 'http://zcoder.top:8087/files/42/1dc70266bc4b4354814c80101ffebfdd-下载.jpg', '53', '太懒了，签名都不想写...', '1', '1', '2020-04-14 13:37:45', '2020-04-14 13:37:45', '1');
INSERT INTO `z_student_member` VALUES ('67', 'super', '$2a$10$UBxcs/Khq5B8AalIJo4GzuDmk3UH7NKbQ5LvfgSRn95kGqfetESK.', '微校用户', 'super', '1', '21', '2376', '鹤城区', '1600130000', '18211111111', 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg', 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg', '53', 'I am super star~', '1', '1', '2020-04-15 13:10:33', '2020-04-15 13:12:04', '1');
INSERT INTO `z_student_member` VALUES ('70', 'chat1', '$2a$10$wjQI5nW.dn2o.W979VKjneqbUytK1zhqHB/EJrfTEjGmu5Y6vbM2S', 'chat1', 'chat1', '1', '21', '1974', '山东省/临沂市/平邑县', '1600999999', '13333333333', 'http://zcoder.top:8087/files/70/508adcf77e4d4b2cb5eb8e6d88b0a7b3-katong20327.png', 'http://zcoder.top:8087/files/70/508adcf77e4d4b2cb5eb8e6d88b0a7b3-katong20327.png', '71', 'chat1', '1', '1', '2020-04-21 10:41:28', '2020-04-21 10:43:46', '1');
INSERT INTO `z_student_member` VALUES ('71', 'chat2', '$2a$10$Tfu93c6e/y0Y4k003dOFiO.grbuX3YPrptjAscDEQngzcFktpMgWm', '微校用户', '匿名', '3', '0', '0', '不详', '', '', 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg', 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg', '100', '太懒了，签名都不想写...', '1', '1', '2020-04-21 11:00:45', '2020-04-21 11:00:45', '1');
INSERT INTO `z_student_member` VALUES ('75', 'content', '$2a$10$0kgFzwDwvp3IIPdnPPF02u1mrM504Rrf1L8Rqacij27FdqHHYhz4q', '微校用户', '这个是管理员同步', '3', '0', '0', '不详', '1600000000', '10000000000', 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg', 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg', '999', '太懒了，签名都不想写...', '1', '1', '2020-04-25 15:45:28', '2020-04-25 15:45:28', '1');
INSERT INTO `z_student_member` VALUES ('76', 'activity', '$2a$10$O/7jQbxKu8ma8Tc2p6AXtOuDB5qeK0JbjZY5WbdblMrb654u.6r5u', '微校用户', '这个是管理员同步', '3', '0', '0', '不详', '1600000000', '10000000000', 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg', 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg', '999', '太懒了，签名都不想写...', '1', '1', '2020-04-25 15:46:02', '2020-04-25 15:46:02', '1');
INSERT INTO `z_student_member` VALUES ('77', '1600130238', '$2a$10$Ecr1/8.ybXT1D1KNcepJXOlKGB4odP3LB/jaRvSQB74zlRbVziRNS', '张家伟', '张张张', '1', '22', '2380', '湖南省/怀化市/溆浦县', '1600130238', '18244838512', 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg', 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg', '53', '我是创建者哦~', '1', '1', '2020-04-26 09:20:10', '2020-04-26 09:21:27', '1');
INSERT INTO `z_student_member` VALUES ('82', '15605219117', '$2a$10$o1NLCGAFdSBxQAPr0UyRG.IQx4veSonY3/n6juTOkxUJshhpj4cEm', 'zhangsan', 'zhangsan', '2', '20', '648', '北京市/北京市/东城区', '08172222', '15605219117', 'http://zcoder.top:8080/images/93fe0837ca7af34c5b3a36b937f2d6be.jpg', 'http://zcoder.top:8080/images/93fe0837ca7af34c5b3a36b937f2d6be.jpg', '72', '1111', '1', '1', '2020-05-23 23:56:57', '2020-05-23 23:58:51', '1');
INSERT INTO `z_student_member` VALUES ('83', '13838406334', '$2a$10$gihfU0BgrqM2N7kvC8tqVuCyp9DsiCXV6bx1z2RFf0lh1MeoIwM..', '程亚倩', '程亚倩', '2', '20', '1404', '江苏省/徐州市/铜山区', '08172798', '13838406334', 'http://zcoder.top:8080/images/93fe0837ca7af34c5b3a36b937f2d6be.jpg', 'http://zcoder.top:8080/images/93fe0837ca7af34c5b3a36b937f2d6be.jpg', '53', 'xxx', '1', '1', '2020-05-25 14:15:11', '2020-05-25 14:22:28', '1');

-- ----------------------------
-- Table structure for z_student_member_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `z_student_member_permission_relation`;
CREATE TABLE `z_student_member_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_id` bigint(20) DEFAULT NULL COMMENT '用户主键',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限主键',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='学生权限关系表';

-- ----------------------------
-- Records of z_student_member_permission_relation
-- ----------------------------
INSERT INTO `z_student_member_permission_relation` VALUES ('2', '1', '2', '2019-11-21 12:41:38', '2019-11-21 12:41:38', '1');
INSERT INTO `z_student_member_permission_relation` VALUES ('3', '1', '3', '2019-11-21 12:48:54', '2019-11-21 12:48:54', '1');
INSERT INTO `z_student_member_permission_relation` VALUES ('4', '2', '3', '2019-11-22 11:40:49', '2019-11-22 11:40:49', '1');

-- ----------------------------
-- Table structure for z_student_permission
-- ----------------------------
DROP TABLE IF EXISTS `z_student_permission`;
CREATE TABLE `z_student_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `value` varchar(200) DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) DEFAULT NULL COMMENT '权限',
  `type` int(1) DEFAULT NULL COMMENT '权限类型：0-目录 1-菜单 2-按钮（接口绑定权限）',
  `uri` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
  `status` int(1) DEFAULT NULL COMMENT '启用状态；0-禁用 1-启用',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='学生权限表';

-- ----------------------------
-- Records of z_student_permission
-- ----------------------------
INSERT INTO `z_student_permission` VALUES ('1', '0', '管理员', '', 'common', null, null, null, null, '2019-11-21 12:48:01', '2019-11-21 12:48:01', '1');
INSERT INTO `z_student_permission` VALUES ('2', '1', '管理员创建', 'adm:admin:create', 'common', null, null, null, null, '2019-11-21 12:48:13', '2019-11-21 12:48:13', '1');
INSERT INTO `z_student_permission` VALUES ('3', '1', '管理员查询', 'adm:admin:read', 'common', null, null, null, null, '2019-11-21 12:48:39', '2019-11-21 12:48:39', '1');
INSERT INTO `z_student_permission` VALUES ('4', '1', '管理员修改', 'adm:admin:update', 'common', null, null, null, null, '2019-11-22 11:39:20', '2019-11-22 11:39:20', '1');
INSERT INTO `z_student_permission` VALUES ('5', '1', '管理员删除', 'adm:admin:detele', 'common', null, null, null, null, '2019-11-22 11:39:33', '2019-11-22 11:39:33', '1');

-- ----------------------------
-- Table structure for z_student_report
-- ----------------------------
DROP TABLE IF EXISTS `z_student_report`;
CREATE TABLE `z_student_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_id` bigint(20) NOT NULL COMMENT '举报人主键',
  `student_name` varchar(255) NOT NULL DEFAULT '' COMMENT '举报人姓名',
  `report_student_id` bigint(20) DEFAULT NULL COMMENT '被举报人主键',
  `report_student_name` varchar(255) DEFAULT '' COMMENT '被举报人姓名',
  `category_id` bigint(20) DEFAULT '0' COMMENT '内容类型',
  `post_id` bigint(20) DEFAULT '0' COMMENT '发布内容主键',
  `content` varchar(255) DEFAULT '' COMMENT '举报说明',
  `state` int(11) DEFAULT '1' COMMENT '举报状态 0-全部 1-正在处理 2-已处理',
  `reply` varchar(255) DEFAULT '' COMMENT '反馈',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='举报表';

-- ----------------------------
-- Records of z_student_report
-- ----------------------------
INSERT INTO `z_student_report` VALUES ('4', '70', 'chat1', null, '', '0', '0', '暴力！！！！', '1', '', '2020-04-24 11:00:08', '2020-04-24 11:00:08', '1');
INSERT INTO `z_student_report` VALUES ('13', '70', 'chat1', '20', 'vip student1', '3', '27', '不给力~', '1', '', '2020-04-24 11:18:51', '2020-04-24 11:18:51', '1');

-- ----------------------------
-- Table structure for z_student_setting
-- ----------------------------
DROP TABLE IF EXISTS `z_student_setting`;
CREATE TABLE `z_student_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_id` bigint(20) NOT NULL COMMENT '用户主键',
  `chat_set` int(11) DEFAULT '1' COMMENT '是否允许私聊 0-否 1-是',
  `sex_set` int(11) DEFAULT '1' COMMENT '是否展示性别 0-否 1-是',
  `academy_set` int(11) DEFAULT '1' COMMENT '是否显示院部 0-否 1-是',
  `created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `logic_flag` int(11) DEFAULT '1' COMMENT '逻辑删除 0-是 1-否',
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_id` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='学生设置表';

-- ----------------------------
-- Records of z_student_setting
-- ----------------------------
INSERT INTO `z_student_setting` VALUES ('3', '53', '1', '1', '1', '2020-04-15 10:54:53', '2020-04-15 10:54:53', '1');
INSERT INTO `z_student_setting` VALUES ('17', '67', '1', '1', '1', '2020-04-15 13:10:33', '2020-04-15 13:10:33', '1');
INSERT INTO `z_student_setting` VALUES ('18', '68', '1', '1', '1', '2020-04-15 14:16:33', '2020-04-15 14:16:33', '1');
INSERT INTO `z_student_setting` VALUES ('19', '69', '1', '1', '1', '2020-04-15 15:28:29', '2020-04-15 15:28:29', '1');
INSERT INTO `z_student_setting` VALUES ('20', '47', '1', '1', '0', '2020-04-16 17:16:58', '2020-04-16 17:16:58', '1');
INSERT INTO `z_student_setting` VALUES ('21', '70', '1', '1', '1', '2020-04-21 10:41:28', '2020-04-21 10:41:28', '1');
INSERT INTO `z_student_setting` VALUES ('22', '71', '1', '1', '1', '2020-04-21 11:00:45', '2020-04-21 11:00:45', '1');
INSERT INTO `z_student_setting` VALUES ('23', '72', '1', '1', '1', '2020-04-21 11:02:47', '2020-04-21 11:02:47', '1');
INSERT INTO `z_student_setting` VALUES ('24', '73', '1', '1', '1', '2020-04-21 11:03:58', '2020-04-21 11:03:58', '1');
INSERT INTO `z_student_setting` VALUES ('25', '74', '1', '1', '1', '2020-04-21 11:03:58', '2020-04-21 11:03:58', '1');
INSERT INTO `z_student_setting` VALUES ('26', '77', '1', '1', '1', '2020-04-26 09:20:10', '2020-04-26 09:20:10', '1');
INSERT INTO `z_student_setting` VALUES ('27', '78', '1', '1', '1', '2020-04-26 10:06:22', '2020-04-26 10:06:22', '1');
INSERT INTO `z_student_setting` VALUES ('28', '79', '1', '1', '1', '2020-04-26 10:17:46', '2020-04-26 10:17:46', '1');
INSERT INTO `z_student_setting` VALUES ('29', '80', '1', '1', '1', '2020-04-28 21:52:37', '2020-04-28 21:52:37', '1');
INSERT INTO `z_student_setting` VALUES ('30', '81', '1', '1', '1', '2020-05-01 19:51:03', '2020-05-01 19:51:03', '1');
INSERT INTO `z_student_setting` VALUES ('31', '42', '1', '1', '1', '2020-05-23 14:44:51', '2020-05-23 14:44:51', '1');
INSERT INTO `z_student_setting` VALUES ('32', '82', '1', '1', '1', '2020-05-23 23:56:57', '2020-05-23 23:56:57', '1');
INSERT INTO `z_student_setting` VALUES ('33', '83', '1', '1', '1', '2020-05-25 14:15:11', '2020-05-25 14:15:11', '1');
INSERT INTO `z_student_setting` VALUES ('34', '84', '1', '1', '1', '2020-06-01 19:39:18', '2020-06-01 19:39:18', '1');
INSERT INTO `z_student_setting` VALUES ('35', '85', '1', '1', '1', '2020-06-02 08:18:45', '2020-06-02 08:18:45', '1');
