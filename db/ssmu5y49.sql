/*
 Navicat Premium Data Transfer

 Source Server         : local_3307
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3307
 Source Schema         : ssmu5y49

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 08/01/2024 21:20:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT ' user id',
  `adminid` bigint(20) DEFAULT NULL COMMENT 'Administrator id',
  `ask` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '提问',
  `reply` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '回复',
  `isreply` int(11) DEFAULT NULL COMMENT '是否回复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1704719865958 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Help center' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES (101, '2030-04-15 21:24:46', 1, 1, '提问1', '回复1', 1);
INSERT INTO `chat` VALUES (102, '2030-04-15 21:24:46', 2, 2, '提问2', '回复2', 2);
INSERT INTO `chat` VALUES (103, '2030-04-15 21:24:46', 3, 3, '提问3', '回复3', 3);
INSERT INTO `chat` VALUES (104, '2030-04-15 21:24:46', 4, 4, '提问4', '回复4', 4);
INSERT INTO `chat` VALUES (105, '2030-04-15 21:24:46', 5, 5, '提问5', '回复5', 5);
INSERT INTO `chat` VALUES (106, '2030-04-15 21:24:46', 6, 6, '提问6', '回复6', 6);
INSERT INTO `chat` VALUES (107, '2030-04-15 21:24:46', 7, 7, '提问7', '回复7', 7);
INSERT INTO `chat` VALUES (108, '2030-04-15 21:24:46', 8, 8, '提问8', '回复8', 8);
INSERT INTO `chat` VALUES (1681565225810, '2030-04-15 21:27:05', 11, NULL, '1111', NULL, 0);
INSERT INTO `chat` VALUES (1681565239948, '2030-04-15 21:27:19', 11, 1, NULL, '3333', 0);
INSERT INTO `chat` VALUES (1704719865957, '2024-01-08 21:17:45', 11, NULL, '您好，我有一些 review有问题，请帮忙解决一下', NULL, 1);

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置参数 name',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'picture1', 'upload/picture1.jpg');
INSERT INTO `config` VALUES (2, 'picture2', 'upload/picture2.jpg');
INSERT INTO `config` VALUES (3, 'picture3', 'upload/picture3.jpg');

-- ----------------------------
-- Table structure for discussgequxinxi
-- ----------------------------
DROP TABLE IF EXISTS `discussgequxinxi`;
CREATE TABLE `discussgequxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT ' user id',
  `avatarurl` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'avatar',
  `nickname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' user name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Comment content',
  `reply` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Reply content',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1704719823543 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Song INFO review表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discussgequxinxi
-- ----------------------------
INSERT INTO `discussgequxinxi` VALUES (1704719823542, '2024-01-08 21:17:03', 41, 11, 'upload/yonghu_touxiang1.jpg', ' user Account number1', '1111111', NULL);

-- ----------------------------
-- Table structure for discussgeshouxinxi
-- ----------------------------
DROP TABLE IF EXISTS `discussgeshouxinxi`;
CREATE TABLE `discussgeshouxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT ' user id',
  `avatarurl` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'avatar',
  `nickname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' user name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Comment content',
  `reply` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Reply content',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Singer INFO review表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for discusslepingxinxi
-- ----------------------------
DROP TABLE IF EXISTS `discusslepingxinxi`;
CREATE TABLE `discusslepingxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT ' user id',
  `avatarurl` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'avatar',
  `nickname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' user name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Comment content',
  `reply` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Reply content',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Music review INFO review表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for discussniandubangdan
-- ----------------------------
DROP TABLE IF EXISTS `discussniandubangdan`;
CREATE TABLE `discussniandubangdan`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT ' user id',
  `avatarurl` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'avatar',
  `nickname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' user name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Comment content',
  `reply` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Reply content',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1704719846744 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Annual list review表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discussniandubangdan
-- ----------------------------
INSERT INTO `discussniandubangdan` VALUES (1704719846743, '2024-01-08 21:17:25', 91, 11, 'upload/yonghu_touxiang1.jpg', ' user Account number1', '11111', NULL);

-- ----------------------------
-- Table structure for discussyinlebangdan
-- ----------------------------
DROP TABLE IF EXISTS `discussyinlebangdan`;
CREATE TABLE `discussyinlebangdan`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT ' user id',
  `avatarurl` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'avatar',
  `nickname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' user name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Comment content',
  `reply` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Reply content',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1704719840470 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Music charts review表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discussyinlebangdan
-- ----------------------------
INSERT INTO `discussyinlebangdan` VALUES (1704719840469, '2024-01-08 21:17:19', 81, 11, 'upload/yonghu_touxiang1.jpg', ' user Account number1', '111111', NULL);

-- ----------------------------
-- Table structure for discussyinlemv
-- ----------------------------
DROP TABLE IF EXISTS `discussyinlemv`;
CREATE TABLE `discussyinlemv`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT ' user id',
  `avatarurl` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'avatar',
  `nickname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' user name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Comment content',
  `reply` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Reply content',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1704719832078 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Music MV review表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discussyinlemv
-- ----------------------------
INSERT INTO `discussyinlemv` VALUES (1704719832077, '2024-01-08 21:17:11', 61, 11, 'upload/yonghu_touxiang1.jpg', ' user Account number1', '1111111', NULL);

-- ----------------------------
-- Table structure for discussyinlezhuanji
-- ----------------------------
DROP TABLE IF EXISTS `discussyinlezhuanji`;
CREATE TABLE `discussyinlezhuanji`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT ' user id',
  `avatarurl` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'avatar',
  `nickname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' user name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Comment content',
  `reply` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Reply content',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1704719814163 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Music album review表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discussyinlezhuanji
-- ----------------------------
INSERT INTO `discussyinlezhuanji` VALUES (1704719814162, '2024-01-08 21:16:53', 51, 11, 'upload/yonghu_touxiang1.jpg', ' user Account number1', '11111', NULL);

-- ----------------------------
-- Table structure for gequxinxi
-- ----------------------------
DROP TABLE IF EXISTS `gequxinxi`;
CREATE TABLE `gequxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `songname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Song name',
  `yinlefenlei` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Music classification',
  `fengmian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'cover',
  `singer` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Singer',
  `yuyan` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Language',
  `songfile` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Music file',
  `zhuanji` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'album',
  `shizhang` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'duration',
  `faxingfang` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'issuer',
  `gequjianjie` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Song introduction',
  `thumbsupnum` int(11) DEFAULT 0 COMMENT ' praise',
  `crazilynum` int(11) DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Song INFO' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gequxinxi
-- ----------------------------
INSERT INTO `gequxinxi` VALUES (41, '2030-04-15 21:24:46', 'Song name1', 'Music classification1', 'upload/gequxinxi_fengmian1.jpg,upload/gequxinxi_fengmian2.jpg,upload/gequxinxi_fengmian3.jpg', 'Singer1', 'Language1', '', 'album1', 'duration1', 'issuer1', 'Song introduction1', 3, 1);
INSERT INTO `gequxinxi` VALUES (42, '2030-04-15 21:24:46', 'Song name2', 'Music classification2', 'upload/gequxinxi_fengmian2.jpg,upload/gequxinxi_fengmian3.jpg,upload/gequxinxi_fengmian4.jpg', 'Singer2', 'Language2', '', 'album2', 'duration2', 'issuer2', 'Song introduction2', 3, 2);
INSERT INTO `gequxinxi` VALUES (43, '2030-04-15 21:24:46', 'Song name3', 'Music classification3', 'upload/gequxinxi_fengmian3.jpg,upload/gequxinxi_fengmian4.jpg,upload/gequxinxi_fengmian5.jpg', 'Singer3', 'Language3', '', 'album3', 'duration3', 'issuer3', 'Song introduction3', 3, 3);
INSERT INTO `gequxinxi` VALUES (44, '2030-04-15 21:24:46', 'Song name4', 'Music classification4', 'upload/gequxinxi_fengmian4.jpg,upload/gequxinxi_fengmian5.jpg,upload/gequxinxi_fengmian6.jpg', 'Singer4', 'Language4', '', 'album4', 'duration4', 'issuer4', 'Song introduction4', 6, 4);
INSERT INTO `gequxinxi` VALUES (45, '2030-04-15 21:24:46', 'Song name5', 'Music classification5', 'upload/gequxinxi_fengmian5.jpg,upload/gequxinxi_fengmian6.jpg,upload/gequxinxi_fengmian7.jpg', 'Singer5', 'Language5', '', 'album5', 'duration5', 'issuer5', 'Song introduction5', 7, 5);
INSERT INTO `gequxinxi` VALUES (46, '2030-04-15 21:24:46', 'Song name6', 'Music classification6', 'upload/gequxinxi_fengmian6.jpg,upload/gequxinxi_fengmian7.jpg,upload/gequxinxi_fengmian8.jpg', 'Singer6', 'Language6', '', 'album6', 'duration6', 'issuer6', 'Song introduction6', 8, 6);
INSERT INTO `gequxinxi` VALUES (47, '2030-04-15 21:24:46', 'Song name7', 'Music classification7', 'upload/gequxinxi_fengmian7.jpg,upload/gequxinxi_fengmian8.jpg,upload/gequxinxi_fengmian9.jpg', 'Singer7', 'Language7', '', 'album7', 'duration7', 'issuer7', 'Song introduction7', 8, 7);
INSERT INTO `gequxinxi` VALUES (48, '2030-04-15 21:24:46', 'Song name8', 'Music classification8', 'upload/gequxinxi_fengmian8.jpg,upload/gequxinxi_fengmian9.jpg,upload/gequxinxi_fengmian10.jpg', 'Singer8', 'Language8', '', 'album8', 'duration8', 'issuer8', 'Song introduction8', 8, 8);

-- ----------------------------
-- Table structure for geshouxinxi
-- ----------------------------
DROP TABLE IF EXISTS `geshouxinxi`;
CREATE TABLE `geshouxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `geshouxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Singer name',
  `geshouxingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Singersex',
  `liupai` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'school',
  `biaoqian` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'label',
  `chudaoriqi` date DEFAULT NULL COMMENT 'Debut date',
  `chengminggequ` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Fame song',
  `touxiang` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'avatar',
  `remengequ` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Hit song',
  `zhuanjijieshao` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Album introduction',
  `geshoujieshao` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Singer introduce',
  `thumbsupnum` int(11) DEFAULT 0 COMMENT ' praise',
  `crazilynum` int(11) DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Singer INFO' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of geshouxinxi
-- ----------------------------
INSERT INTO `geshouxinxi` VALUES (31, '2030-04-15 21:24:46', 'Singer name1', 'male', 'school1', 'label1', '2030-04-15', 'Fame song1', 'upload/geshouxinxi_touxiang1.jpg,upload/geshouxinxi_touxiang2.jpg,upload/geshouxinxi_touxiang3.jpg', 'Hit song1', 'Album introduction1', 'Singer introduce1', 2, 1);
INSERT INTO `geshouxinxi` VALUES (32, '2030-04-15 21:24:46', 'Singer name2', 'male', 'school2', 'label2', '2030-04-15', 'Fame song2', 'upload/geshouxinxi_touxiang2.jpg,upload/geshouxinxi_touxiang3.jpg,upload/geshouxinxi_touxiang4.jpg', 'Hit song2', 'Album introduction2', 'Singer introduce2', 2, 2);
INSERT INTO `geshouxinxi` VALUES (33, '2030-04-15 21:24:46', 'Singer name3', 'male', 'school3', 'label3', '2030-04-15', 'Fame song3', 'upload/geshouxinxi_touxiang3.jpg,upload/geshouxinxi_touxiang4.jpg,upload/geshouxinxi_touxiang5.jpg', 'Hit song3', 'Album introduction3', 'Singer introduce3', 3, 3);
INSERT INTO `geshouxinxi` VALUES (34, '2030-04-15 21:24:46', 'Singer name4', 'male', 'school4', 'label4', '2030-04-15', 'Fame song4', 'upload/geshouxinxi_touxiang4.jpg,upload/geshouxinxi_touxiang5.jpg,upload/geshouxinxi_touxiang6.jpg', 'Hit song4', 'Album introduction4', 'Singer introduce4', 4, 4);
INSERT INTO `geshouxinxi` VALUES (35, '2030-04-15 21:24:46', 'Singer name5', 'male', 'school5', 'label5', '2030-04-15', 'Fame song5', 'upload/geshouxinxi_touxiang5.jpg,upload/geshouxinxi_touxiang6.jpg,upload/geshouxinxi_touxiang7.jpg', 'Hit song5', 'Album introduction5', 'Singer introduce5', 5, 5);
INSERT INTO `geshouxinxi` VALUES (36, '2030-04-15 21:24:46', 'Singer name6', 'male', 'school6', 'label6', '2030-04-15', 'Fame song6', 'upload/geshouxinxi_touxiang6.jpg,upload/geshouxinxi_touxiang7.jpg,upload/geshouxinxi_touxiang8.jpg', 'Hit song6', 'Album introduction6', 'Singer introduce6', 6, 6);
INSERT INTO `geshouxinxi` VALUES (37, '2030-04-15 21:24:46', 'Singer name7', 'male', 'school7', 'label7', '2030-04-15', 'Fame song7', 'upload/geshouxinxi_touxiang7.jpg,upload/geshouxinxi_touxiang8.jpg,upload/geshouxinxi_touxiang9.jpg', 'Hit song7', 'Album introduction7', 'Singer introduce7', 7, 7);
INSERT INTO `geshouxinxi` VALUES (38, '2030-04-15 21:24:46', 'Singer name8', 'male', 'school8', 'label8', '2030-04-15', 'Fame song8', 'upload/geshouxinxi_touxiang8.jpg,upload/geshouxinxi_touxiang9.jpg,upload/geshouxinxi_touxiang10.jpg', 'Hit song8', 'Album introduction8', 'Singer introduce8', 8, 8);

-- ----------------------------
-- Table structure for lepingxinxi
-- ----------------------------
DROP TABLE IF EXISTS `lepingxinxi`;
CREATE TABLE `lepingxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' user Account number',
  `yonghuxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' user  name',
  `zhuanjimingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'album name',
  `songname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Song name',
  `singer` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Singer',
  `yinlefenlei` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Music classification',
  `fengmian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'cover',
  `songfile` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Music file',
  `pingjia` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'evaluate',
  `lepingshijian` date DEFAULT NULL COMMENT 'Music review time',
  `lepingneirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Music review content',
  `thumbsupnum` int(11) DEFAULT 0 COMMENT ' praise',
  `crazilynum` int(11) DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Music review INFO' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lepingxinxi
-- ----------------------------
INSERT INTO `lepingxinxi` VALUES (71, '2030-04-15 21:24:46', ' user Account number1', ' user  name1', 'album name1', 'Song name1', 'Singer1', 'Music classification1', 'upload/lepingxinxi_fengmian1.jpg,upload/lepingxinxi_fengmian2.jpg,upload/lepingxinxi_fengmian3.jpg', '', '★', '2030-04-15', 'Music review content1', 1, 1);
INSERT INTO `lepingxinxi` VALUES (72, '2030-04-15 21:24:46', ' user Account number2', ' user  name2', 'album name2', 'Song name2', 'Singer2', 'Music classification2', 'upload/lepingxinxi_fengmian2.jpg,upload/lepingxinxi_fengmian3.jpg,upload/lepingxinxi_fengmian4.jpg', '', '★', '2030-04-15', 'Music review content2', 2, 2);
INSERT INTO `lepingxinxi` VALUES (73, '2030-04-15 21:24:46', ' user Account number3', ' user  name3', 'album name3', 'Song name3', 'Singer3', 'Music classification3', 'upload/lepingxinxi_fengmian3.jpg,upload/lepingxinxi_fengmian4.jpg,upload/lepingxinxi_fengmian5.jpg', '', '★', '2030-04-15', 'Music review content3', 3, 3);
INSERT INTO `lepingxinxi` VALUES (74, '2030-04-15 21:24:46', ' user Account number4', ' user  name4', 'album name4', 'Song name4', 'Singer4', 'Music classification4', 'upload/lepingxinxi_fengmian4.jpg,upload/lepingxinxi_fengmian5.jpg,upload/lepingxinxi_fengmian6.jpg', '', '★', '2030-04-15', 'Music review content4', 4, 4);
INSERT INTO `lepingxinxi` VALUES (75, '2030-04-15 21:24:46', ' user Account number5', ' user  name5', 'album name5', 'Song name5', 'Singer5', 'Music classification5', 'upload/lepingxinxi_fengmian5.jpg,upload/lepingxinxi_fengmian6.jpg,upload/lepingxinxi_fengmian7.jpg', '', '★', '2030-04-15', 'Music review content5', 5, 5);
INSERT INTO `lepingxinxi` VALUES (76, '2030-04-15 21:24:46', ' user Account number6', ' user  name6', 'album name6', 'Song name6', 'Singer6', 'Music classification6', 'upload/lepingxinxi_fengmian6.jpg,upload/lepingxinxi_fengmian7.jpg,upload/lepingxinxi_fengmian8.jpg', '', '★', '2030-04-15', 'Music review content6', 6, 6);
INSERT INTO `lepingxinxi` VALUES (77, '2030-04-15 21:24:46', ' user Account number7', ' user  name7', 'album name7', 'Song name7', 'Singer7', 'Music classification7', 'upload/lepingxinxi_fengmian7.jpg,upload/lepingxinxi_fengmian8.jpg,upload/lepingxinxi_fengmian9.jpg', '', '★', '2030-04-15', 'Music review content7', 7, 7);
INSERT INTO `lepingxinxi` VALUES (78, '2030-04-15 21:24:46', ' user Account number8', ' user  name8', 'album name8', 'Song name8', 'Singer8', 'Music classification8', 'upload/lepingxinxi_fengmian8.jpg,upload/lepingxinxi_fengmian9.jpg,upload/lepingxinxi_fengmian10.jpg', '', '★', '2030-04-15', 'Music review content8', 8, 8);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'title',
  `introduction` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'intro',
  `picture` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' picture',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'content',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 129 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Music INFO' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (121, '2030-04-15 21:24:46', '有梦想，就要努力去实现', '不管你想要怎样的生活，你都要去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。', 'upload/news_picture1.jpg', '<p>不管你想要怎样的生活，你都要去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?</p><p>你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。其实，我已经厌倦了你这样说说而已的把戏，我觉得就算我告诉你如何去做，你也不会照做，因为你根本什么都不做。</p><p>真正有行动力的人不需要别人告诉他如何做，因为他已经在做了。就算碰到问题，他也会自己想办法，自己动手去解决或者主动寻求可以帮助他的人，而不是等着别人为自己解决问题。</p><p>首先要学习独立思考。花一点时间想一下自己喜欢什么，梦想是什么，不要别人说想环游世界，你就说你的梦想是环游世界。</p><p>很多人说现实束缚了自己，其实在这个世界上，我们一直都可以有很多选择，生活的决定权也—直都在自己手上，只是我们缺乏行动力而已。</p><p>如果你觉得安于现状是你想要的，那选择安于现状就会让你幸福和满足;如果你不甘平庸，选择一条改变、进取和奋斗的道路，在这个追求的过程中，你也一样会感到快乐。所谓的 succeed，即是按照自己想要的生活方式生活。最糟糕的status，莫过于当你想要选择一条不甘平庸、改变、进取和奋斗的道路时，却以一种安于现状的方式生活，最后抱怨自己没有得到想要的人生。</p><p>因为喜欢，你不是在苦苦坚持，也因为喜欢，你愿意投入时间、精力，长久以往，获得 succeed就是自然而然的事情。</p>');
INSERT INTO `news` VALUES (122, '2030-04-15 21:24:46', '又是一年毕业季', '又是一年毕业季，感慨万千，还记的自己刚进学校那时候的情景，我拖着沉重的行李箱站在偌大的教学楼前面，感叹自己未来的日子即将在这个陌生的校园里度过，而如今斗转星移，浮光掠影，弹指之间，那些青葱岁月如同白驹过隙般悄然从指缝溜走。过去的种种在胸口交集纠结，像打翻的五味瓶，甜蜜，酸楚，苦涩，一并涌上心头。', 'upload/news_picture2.jpg', '<p>又是一年毕业季，感慨万千，还记的自己刚进学校那时候的情景，我拖着沉重的行李箱站在偌大的教学楼前面，感叹自己未来的日子即将在这个陌生的校园里度过，而如今斗转星移，浮光掠影，弹指之间，那些青葱岁月如同白驹过隙般悄然从指缝溜走。</p><p>过去的种种在胸口交集纠结，像打翻的五味瓶，甜蜜，酸楚，苦涩，一并涌上心头。一直都是晚会的忠实参与者，无论是台前还是幕后，忽然间，角色转变，那种感觉确实难以用Language表达。</p><p>	过去的三年，总是默默地期盼着这个好雨时节，因为这时候，会有灿烂的阳光，会有满目的百花争艳，会有香甜的冰激凌，这是个毕业的季节，当时不经世事的我们会殷切地期待学校那一大堆的活动，期待穿上绚丽的演出服或者礼仪服，站在大礼堂镁光灯下尽情挥洒我们的澎拜的激情。</p><p>百感交集，隔岸观火与身临其境的感觉竟是如此不同。从来没想过一场晚会送走的是我们自己的时候会是怎样的感情，毕业就真的意味着结束吗?倔强的我们不愿意承认，谢谢学弟学妹们慷慨的将这次的主题定为“我们在这里”。我知道，这可能是他们对我们这些过来人的尊敬和施舍。</p><p>没有为这场晚会排练、奔波，没有为班级、学生会、文学院出点力，还真有点不习惯，百般无奈中，用“工作忙”个万能的借口来搪塞自己，欺骗别人。其实自己心里明白，那只是在逃避，只是不愿面对繁华落幕后的萧条和落寞。大四了，大家各奔东西，想凑齐班上的人真的是难上加难，敏燕从越南回来，刚落地就匆匆回了学校，那么恋家的人也启程回来了，睿睿学姐也是从家赶来跟我们团圆。大家—如既往的寒暄、打趣、调侃对方，似乎一切又回到了当初的单纯美好。</p><p>看着舞台上活泼可爱的学弟学妹们，如同一群机灵的小精灵，清澈的眼神，稚嫩的肢体，轻快地步伐，用他们那热情洋溢的舞姿渲染着在场的每一个人，我知道，我不应该羡慕嫉妒他们，不应该顾自怜惜逝去的青春，不应该感叹夕阳无限好，曾经，我们也拥有过，曾经，我们也年轻过，曾经，我们也灿烂过。我深深地告诉自己，人生的每个阶段都是美的，年轻有年轻的活力，成熟也有成熟的魅力。多—份稳重、淡然、优雅，也是漫漫时光掠影遗留下的.珍贵赏赐。</p>');
INSERT INTO `news` VALUES (123, '2030-04-15 21:24:46', '挫折路上，坚持常在心间', '回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是 succeed运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。', 'upload/news_picture3.jpg', '<p>回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是 succeed运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?</p><p>清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。</p><p>是的，面对道途上那无情的嘲讽，面对步伐中那重复的摔跤，面对激流与硬石之间猛烈的碰撞，我们必须选择那富于阴雨，却最终见到彩虹的荆棘路。也许，经历了那暴风雨的洗礼，我们便会变得自信，幸福也随之而来。</p><p>司马迁屡遭羞辱，却依然在狱中撰写《史记》，作为一名史学家，不因王权而极度 praise赏，也不因卑微而极度批判，然而他在坚持自己操守的同时，却依然要受统治阶级的阻碍，他似乎无权选择自己的本职。但是，他不顾于此，只是在面对道途的阻隔之时，他依然选择了走下去的信念。终于一部开山巨作《史记》诞生，为后人留下一份馈赠，也许在他完成毕生的杰作之时，他微微地笑了，没有什么比梦想实现更快乐的了......</p><p>	或许正如“长风破浪会有时，直挂云帆济沧海”一般，欣欣然地走向看似深渊的崎岖路，而在一番耕耘之后，便会发现这里另有一番天地。也许这就是困难与快乐的交融。</p><p>也许在形形色色的社会中，我们常能看到一份坚持，一份自信，但这里却还有一类人。这类人在暴风雨来临之际，只会闪躲，从未懂得这也是一种历炼，这何尝不是一份快乐。在阴暗的角落里，总是独自在哭，带着伤愁，看不到一点希望。</p><p>我们不能堕落于此，而要像海燕那般，在苍茫的大海上，高傲地飞翔，任何事物都无法阻挡，任何事都是幸福快乐的。</p>');
INSERT INTO `news` VALUES (124, '2030-04-15 21:24:46', '挫折是另一个生命的开端', '当遇到挫折或失败，你是看见失败还是看见机会?挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。', 'upload/news_picture4.jpg', '<p>当遇到挫折或失败，你是看见失败还是看见机会?</p><p>挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。</p><p>人生在世，从古到今，不分天子平民，机遇虽有不同，但总不免有身陷困境或遭遇难题之处，这时候唯有通权达变，才能使人转危为安，甚至反败为胜。</p><p>大部分的人，一生当中，最痛苦的经验是失去所爱的人，其次是丢掉一份工作。其实，经得起考验的人，就算是被开除也不会惊慌，要学会面对。</p><p>	“塞翁失马，焉知非福。”人生的道路，并不是每一步都迈向 succeed，这就是追求的意义。我们还要认识到一点，挫折作为一种情绪status和一种个人体验，各人的耐受性是大不相同的，有的人经历了一次次挫折，就能够坚忍不拔，百折不挠;有的人稍遇挫折便意志消沉，一蹶不振。所以，挫折感是一种主观感受，因为人的目的和需要不同， succeed标准不同，所以同一种活动对于不同的人可能会造成不同的挫折感受。</p><p>凡事皆以平常心来看待，对于生命顺逆不要太执著。能够“破我执”是很高层的人生境界。</p><p>人事的艰难就是一种考验。就像—支剑要有磨刀来磨，剑才会利:一块璞玉要有粗石来磨，才会发出耀眼的光芒。我们能够做到的，只是如何减少、避免那些由于自身的原因所造成的挫折，而在遇到痛苦和挫折之后，则力求化解痛苦，争取幸福。我们要知道，痛苦和挫折是双重性的，它既是我们人生中难以完全避免的，也是我们在争取 succeed时，不可缺少的一种动力。因为我认为，推动我们奋斗的力量，不仅仅是对 succeed的渴望，还有为摆脱痛苦和挫折而 proceed 的奋斗。</p>');
INSERT INTO `news` VALUES (125, '2030-04-15 21:24:46', '你要去相信，没有到不了的明天', '有梦想就去努力，因为在这一辈子里面，现在不去勇敢的努力，也许就再也没有机会了。你要去相信，一定要相信，没有到不了的明天。不要被命运打败，让自己变得更强大。不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心址笑着的时候闪过一丝落寞。', 'upload/news_picture5.jpg', '<p>有梦想就去努力，因为在这一辈子里面，现在不去勇敢的努力，也许就再也没有机会了。你要去相信，一定要相信，没有到不了的明天。不要被命运打败，让自己变得更强大。</p><p>不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心址笑着的时候闪过一丝落寞。</p><p>	不管你现在是在图书馆里背着怎么也看不进去的英语单词，还是你现在迷茫地看不清未来的方向不知道要往哪走。</p><p>不管你现在是在努力着去实现梦想却没能拉近与梦想的距离，还是你已经慢慢地找不到自己的梦想了。</p><p>你都要去相信，没有到不了的明天。</p><p>	有的时候你的梦想太大，别人说你的梦想根本不可能实现;有的时候你的梦想又太小，又有人说你胸无大志;有的时候你对死党说着将来要去环游世界的梦想，却换来他的不屑一顾，于是你再也不提自己的梦想;有的时候你突然说起将来要开个小店的愿望，却发现你讲述的那个人，并没有听到你在说什么。</p><p>不过又能怎么样呢，未来始终是自己的，梦想始终是自己的，没有人会来帮你实现它。</p><p>也许很多时候我们只是需要朋友的一句鼓励，一句安慰，却也得不到。但是相信我，世界上还有很多人，只是想要和你说说话。</p><p>因为我们都一样。一样的被人说成固执，一样的在追逐他们眼里根本不在意的东西。</p><p>所以，又有什么关系呢，别人始终不是你、不能懂你的心情，你又何必多去解释呢。这个世界会来阻止你，困难也会接踵而至，其实真正关键的只有自己，有没有那个倔强。</p><p>这个世界上没有不带伤的人，真正能治愈自己的，只有自己。</p>');
INSERT INTO `news` VALUES (126, '2030-04-15 21:24:46', '离开是一种痛苦，是一种勇气，但同样也是一个考验，是一个新的开端', '无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。', 'upload/news_picture6.jpg', '<p>无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。离别的确是一种痛苦，但同样也是我们走入社会，走向新环境、新领域的一个开端，希望大家在以后新的工作岗位上能够confirm自己的新起点，坚持不懈，向着Renewal、更高的目标前进，因为人生最美好的东西永远都在最前方!</p><p>忆往昔峥嵘岁月，看今朝潮起潮落，望未来任重而道远。作为新时代的我们，就应在失败时，能拼搏奋起，去谱写人生的辉煌。在 succeed时，亦能居安思危，不沉湎于一时的荣耀、鲜花和掌声中，时时刻刻怀着一颗积极寻找自己新的奶酪的心，处变不惊、成败不渝，始终踏着自己坚实的步伐，从零开始，不断向前迈进，这样才能在这风起云涌、变幻莫测的社会大潮中成为真正的弄潮儿!</p>');
INSERT INTO `news` VALUES (127, '2030-04-15 21:24:46', 'Leave未必是一种痛苦', '无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。', 'upload/news_picture7.jpg', '<p>无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。离别的确是一种痛苦，但同样也是我们走入社会，走向新环境、新领域的一个开端，希望大家在以后新的工作岗位上能够confirm自己的新起点，坚持不懈，向着Renewal、更高的目标前进，因为人生最美好的东西永远都在最前方!</p><p>忆往昔峥嵘岁月，看今朝潮起潮落，望未来任重而道远。作为新时代的我们，就应在失败时，能拼搏奋起，去谱写人生的辉煌。在 succeed时，亦能居安思危，不沉湎于一时的荣耀、鲜花和掌声中，时时刻刻怀着一颗积极寻找自己新的奶酪的心，处变不惊、成败不渝，始终踏着自己坚实的步伐，从零开始，不断向前迈进，这样才能在这风起云涌、变幻莫测的社会大潮中成为真正的弄潮儿!</p>');
INSERT INTO `news` VALUES (128, '2030-04-15 21:24:46', '坚持才会 succeed', '回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是 succeed运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。', 'upload/news_picture8.jpg', '<p>回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是 succeed运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?</p><p>清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。</p><p>是的，面对道途上那无情的嘲讽，面对步伐中那重复的摔跤，面对激流与硬石之间猛烈的碰撞，我们必须选择那富于阴雨，却最终见到彩虹的荆棘路。也许，经历了那暴风雨的洗礼，我们便会变得自信，幸福也随之而来。</p><p>司马迁屡遭羞辱，却依然在狱中撰写《史记》，作为一名史学家，不因王权而极度 praise赏，也不因卑微而极度批判，然而他在坚持自己操守的同时，却依然要受统治阶级的阻碍，他似乎无权选择自己的本职。但是，他不顾于此，只是在面对道途的阻隔之时，他依然选择了走下去的信念。终于一部开山巨作《史记》诞生，为后人留下一份馈赠，也许在他完成毕生的杰作之时，他微微地笑了，没有什么比梦想实现更快乐的了......</p><p>	或许正如“长风破浪会有时，直挂云帆济沧海”一般，欣欣然地走向看似深渊的崎岖路，而在一番耕耘之后，便会发现这里另有一番天地。也许这就是困难与快乐的交融。</p><p>也许在形形色色的社会中，我们常能看到一份坚持，一份自信，但这里却还有一类人。这类人在暴风雨来临之际，只会闪躲，从未懂得这也是一种历炼，这何尝不是一份快乐。在阴暗的角落里，总是独自在哭，带着伤愁，看不到一点希望。</p><p>我们不能堕落于此，而要像海燕那般，在苍茫的大海上，高傲地飞翔，任何事物都无法阻挡，任何事都是幸福快乐的。</p>');

-- ----------------------------
-- Table structure for niandubangdan
-- ----------------------------
DROP TABLE IF EXISTS `niandubangdan`;
CREATE TABLE `niandubangdan`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `nianfen` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Year',
  `bofangliang` int(11) DEFAULT NULL COMMENT 'view counts',
  `songname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Song name',
  `gequmingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Song name',
  `singer` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Singer',
  `yinlefenlei` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Music classification',
  `fengmian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'cover',
  `songfile` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Music file',
  `zhuanjimingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'album name',
  `faxingriqi` date DEFAULT NULL COMMENT 'Issue date',
  `geci` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'lyric ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 99 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Annual list' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of niandubangdan
-- ----------------------------
INSERT INTO `niandubangdan` VALUES (91, '2030-04-15 21:24:46', 'Year1', 1, 'Song name1', 'Song name1', 'Singer1', 'Music classification1', 'upload/niandubangdan_fengmian1.jpg,upload/niandubangdan_fengmian2.jpg,upload/niandubangdan_fengmian3.jpg', '', 'album name1', '2030-04-15', 'lyric 1');
INSERT INTO `niandubangdan` VALUES (92, '2030-04-15 21:24:46', 'Year2', 2, 'Song name2', 'Song name2', 'Singer2', 'Music classification2', 'upload/niandubangdan_fengmian2.jpg,upload/niandubangdan_fengmian3.jpg,upload/niandubangdan_fengmian4.jpg', '', 'album name2', '2030-04-15', 'lyric 2');
INSERT INTO `niandubangdan` VALUES (93, '2030-04-15 21:24:46', 'Year3', 3, 'Song name3', 'Song name3', 'Singer3', 'Music classification3', 'upload/niandubangdan_fengmian3.jpg,upload/niandubangdan_fengmian4.jpg,upload/niandubangdan_fengmian5.jpg', '', 'album name3', '2030-04-15', 'lyric 3');
INSERT INTO `niandubangdan` VALUES (94, '2030-04-15 21:24:46', 'Year4', 4, 'Song name4', 'Song name4', 'Singer4', 'Music classification4', 'upload/niandubangdan_fengmian4.jpg,upload/niandubangdan_fengmian5.jpg,upload/niandubangdan_fengmian6.jpg', '', 'album name4', '2030-04-15', 'lyric 4');
INSERT INTO `niandubangdan` VALUES (95, '2030-04-15 21:24:46', 'Year5', 5, 'Song name5', 'Song name5', 'Singer5', 'Music classification5', 'upload/niandubangdan_fengmian5.jpg,upload/niandubangdan_fengmian6.jpg,upload/niandubangdan_fengmian7.jpg', '', 'album name5', '2030-04-15', 'lyric 5');
INSERT INTO `niandubangdan` VALUES (96, '2030-04-15 21:24:46', 'Year6', 6, 'Song name6', 'Song name6', 'Singer6', 'Music classification6', 'upload/niandubangdan_fengmian6.jpg,upload/niandubangdan_fengmian7.jpg,upload/niandubangdan_fengmian8.jpg', '', 'album name6', '2030-04-15', 'lyric 6');
INSERT INTO `niandubangdan` VALUES (97, '2030-04-15 21:24:46', 'Year7', 7, 'Song name7', 'Song name7', 'Singer7', 'Music classification7', 'upload/niandubangdan_fengmian7.jpg,upload/niandubangdan_fengmian8.jpg,upload/niandubangdan_fengmian9.jpg', '', 'album name7', '2030-04-15', 'lyric 7');
INSERT INTO `niandubangdan` VALUES (98, '2030-04-15 21:24:46', 'Year8', 8, 'Song name8', 'Song name8', 'Singer8', 'Music classification8', 'upload/niandubangdan_fengmian8.jpg,upload/niandubangdan_fengmian9.jpg,upload/niandubangdan_fengmian10.jpg', '', 'album name8', '2030-04-15', 'lyric 8');

-- ----------------------------
-- Table structure for storeup
-- ----------------------------
DROP TABLE IF EXISTS `storeup`;
CREATE TABLE `storeup`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT ' user id',
  `refid` bigint(20) DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '表名',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' name',
  `picture` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' picture',
  `type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '类型(1: Collect,21: praise,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' Recommended类型',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1704719773264 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = ' Collect表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storeup
-- ----------------------------
INSERT INTO `storeup` VALUES (1704719565996, '2024-01-08 21:12:45', 11, 42, 'gequxinxi', 'Song name2', 'upload/gequxinxi_fengmian2.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (1704719568843, '2024-01-08 21:12:48', 11, 47, 'gequxinxi', 'Song name7', 'upload/gequxinxi_fengmian7.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (1704719571773, '2024-01-08 21:12:51', 11, 45, 'gequxinxi', 'Song name5', 'upload/gequxinxi_fengmian5.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (1704719586222, '2024-01-08 21:13:05', 12, 44, 'gequxinxi', 'Song name4', 'upload/gequxinxi_fengmian4.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (1704719588620, '2024-01-08 21:13:08', 12, 46, 'gequxinxi', 'Song name6', 'upload/gequxinxi_fengmian6.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (1704719591845, '2024-01-08 21:13:10', 12, 41, 'gequxinxi', 'Song name1', 'upload/gequxinxi_fengmian1.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (1704719600599, '2024-01-08 21:13:20', 13, 45, 'gequxinxi', 'Song name5', 'upload/gequxinxi_fengmian5.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (1704719605530, '2024-01-08 21:13:24', 13, 47, 'gequxinxi', 'Song name7', 'upload/gequxinxi_fengmian7.jpg', '1', 'Music classification7', NULL);
INSERT INTO `storeup` VALUES (1704719608385, '2024-01-08 21:13:27', 13, 44, 'gequxinxi', 'Song name4', 'upload/gequxinxi_fengmian4.jpg', '1', 'Music classification4', NULL);
INSERT INTO `storeup` VALUES (1704719630577, '2024-01-08 21:13:49', 14, 41, 'gequxinxi', 'Song name1', 'upload/gequxinxi_fengmian1.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (1704719633354, '2024-01-08 21:13:52', 14, 44, 'gequxinxi', 'Song name4', 'upload/gequxinxi_fengmian4.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (1704719635644, '2024-01-08 21:13:54', 14, 45, 'gequxinxi', 'Song name5', 'upload/gequxinxi_fengmian5.jpg', '1', 'Music classification5', NULL);
INSERT INTO `storeup` VALUES (1704719660900, '2024-01-08 21:14:20', 15, 46, 'gequxinxi', 'Song name6', 'upload/gequxinxi_fengmian6.jpg', '21', NULL, NULL);
INSERT INTO `storeup` VALUES (1704719664042, '2024-01-08 21:14:23', 15, 44, 'gequxinxi', 'Song name4', 'upload/gequxinxi_fengmian4.jpg', '1', 'Music classification4', NULL);
INSERT INTO `storeup` VALUES (1704719773263, '2024-01-08 21:16:12', 11, 31, 'geshouxinxi', 'Singer name1', 'upload/geshouxinxi_touxiang1.jpg', '21', NULL, NULL);

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT ' user id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' user name',
  `tablename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'password',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'new时间',
  `expiratedtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 11, ' user Account number1', 'yonghu', ' user ', '9w5fdvlex95xqmosonf430hic0s6293c', '2030-04-15 21:27:01', '2024-01-08 22:18:31');
INSERT INTO `token` VALUES (2, 1, 'admin', 'users', 'Administrator ', '3d6lridntdvzeuhvk79ghs52qbkm1qzw', '2030-04-15 21:27:10', '2024-01-08 22:18:40');
INSERT INTO `token` VALUES (3, 12, ' user Account number2', 'yonghu', ' user ', '41ab4jg8jls40cgp98wj7nluy30mmqy1', '2024-01-08 21:13:02', '2024-01-08 22:17:59');
INSERT INTO `token` VALUES (4, 13, ' user Account number3', 'yonghu', ' user ', '8jnboz0hndov0dr61k4sqpsq4l2n1k2k', '2024-01-08 21:13:17', '2024-01-08 22:18:06');
INSERT INTO `token` VALUES (5, 14, ' user Account number4', 'yonghu', ' user ', '0xjjp9l9ftbaggi5ia8hmek8tn721fvo', '2024-01-08 21:13:47', '2024-01-08 22:18:14');
INSERT INTO `token` VALUES (6, 15, ' user Account number5', 'yonghu', ' user ', 'wdivrg0rx63rmu7fmndqmknh35vlpwbl', '2024-01-08 21:14:16', '2024-01-08 22:14:17');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' user name',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'password',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'Administrator ' COMMENT '角色',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'new时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = ' user 表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'admin', 'Administrator ', '2030-04-15 21:24:46');

-- ----------------------------
-- Table structure for yinlebangdan
-- ----------------------------
DROP TABLE IF EXISTS `yinlebangdan`;
CREATE TABLE `yinlebangdan`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bofangliang` int(11) DEFAULT NULL COMMENT 'view counts',
  `gequmingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Song name',
  `yinlefenlei` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Music classification',
  `geshou` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Singer',
  `fengmian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'cover',
  `zhuanjimingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'album name',
  `bofang` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'play back',
  `faxingriqi` date DEFAULT NULL COMMENT 'Issue date',
  `geci` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'lyric ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Music charts' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yinlebangdan
-- ----------------------------
INSERT INTO `yinlebangdan` VALUES (81, '2030-04-15 21:24:46', 1, 'Song name1', 'Music classification1', 'Singer1', 'upload/yinlebangdan_fengmian1.jpg,upload/yinlebangdan_fengmian2.jpg,upload/yinlebangdan_fengmian3.jpg', 'album name1', '', '2030-04-15', 'lyric 1');
INSERT INTO `yinlebangdan` VALUES (82, '2030-04-15 21:24:46', 2, 'Song name2', 'Music classification2', 'Singer2', 'upload/yinlebangdan_fengmian2.jpg,upload/yinlebangdan_fengmian3.jpg,upload/yinlebangdan_fengmian4.jpg', 'album name2', '', '2030-04-15', 'lyric 2');
INSERT INTO `yinlebangdan` VALUES (83, '2030-04-15 21:24:46', 3, 'Song name3', 'Music classification3', 'Singer3', 'upload/yinlebangdan_fengmian3.jpg,upload/yinlebangdan_fengmian4.jpg,upload/yinlebangdan_fengmian5.jpg', 'album name3', '', '2030-04-15', 'lyric 3');
INSERT INTO `yinlebangdan` VALUES (84, '2030-04-15 21:24:46', 4, 'Song name4', 'Music classification4', 'Singer4', 'upload/yinlebangdan_fengmian4.jpg,upload/yinlebangdan_fengmian5.jpg,upload/yinlebangdan_fengmian6.jpg', 'album name4', '', '2030-04-15', 'lyric 4');
INSERT INTO `yinlebangdan` VALUES (85, '2030-04-15 21:24:46', 5, 'Song name5', 'Music classification5', 'Singer5', 'upload/yinlebangdan_fengmian5.jpg,upload/yinlebangdan_fengmian6.jpg,upload/yinlebangdan_fengmian7.jpg', 'album name5', '', '2030-04-15', 'lyric 5');
INSERT INTO `yinlebangdan` VALUES (86, '2030-04-15 21:24:46', 6, 'Song name6', 'Music classification6', 'Singer6', 'upload/yinlebangdan_fengmian6.jpg,upload/yinlebangdan_fengmian7.jpg,upload/yinlebangdan_fengmian8.jpg', 'album name6', '', '2030-04-15', 'lyric 6');
INSERT INTO `yinlebangdan` VALUES (87, '2030-04-15 21:24:46', 7, 'Song name7', 'Music classification7', 'Singer7', 'upload/yinlebangdan_fengmian7.jpg,upload/yinlebangdan_fengmian8.jpg,upload/yinlebangdan_fengmian9.jpg', 'album name7', '', '2030-04-15', 'lyric 7');
INSERT INTO `yinlebangdan` VALUES (88, '2030-04-15 21:24:46', 8, 'Song name8', 'Music classification8', 'Singer8', 'upload/yinlebangdan_fengmian8.jpg,upload/yinlebangdan_fengmian9.jpg,upload/yinlebangdan_fengmian10.jpg', 'album name8', '', '2030-04-15', 'lyric 8');

-- ----------------------------
-- Table structure for yinlefenlei
-- ----------------------------
DROP TABLE IF EXISTS `yinlefenlei`;
CREATE TABLE `yinlefenlei`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yinlefenlei` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Music classification',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yinlefenlei`(`yinlefenlei`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Music classification' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yinlefenlei
-- ----------------------------
INSERT INTO `yinlefenlei` VALUES (21, '2030-04-15 21:24:46', 'Music classification1');
INSERT INTO `yinlefenlei` VALUES (22, '2030-04-15 21:24:46', 'Music classification2');
INSERT INTO `yinlefenlei` VALUES (23, '2030-04-15 21:24:46', 'Music classification3');
INSERT INTO `yinlefenlei` VALUES (24, '2030-04-15 21:24:46', 'Music classification4');
INSERT INTO `yinlefenlei` VALUES (25, '2030-04-15 21:24:46', 'Music classification5');
INSERT INTO `yinlefenlei` VALUES (26, '2030-04-15 21:24:46', 'Music classification6');
INSERT INTO `yinlefenlei` VALUES (27, '2030-04-15 21:24:46', 'Music classification7');
INSERT INTO `yinlefenlei` VALUES (28, '2030-04-15 21:24:46', 'Music classification8');

-- ----------------------------
-- Table structure for yinlemv
-- ----------------------------
DROP TABLE IF EXISTS `yinlemv`;
CREATE TABLE `yinlemv`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mvmingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'mv name',
  `yinlefenlei` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Music classification',
  `geshouxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Singer name',
  `shipin` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'video',
  `faburiqi` date DEFAULT NULL COMMENT 'Release date',
  `gecixiangqing` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'lyric details',
  `fengmiantupian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'cover picture',
  `thumbsupnum` int(11) DEFAULT 0 COMMENT ' praise',
  `crazilynum` int(11) DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Music MV' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yinlemv
-- ----------------------------
INSERT INTO `yinlemv` VALUES (61, '2030-04-15 21:24:46', 'mv name1', 'Music classification1', 'Singer name1', '', '2030-04-15', 'lyric details1', 'upload/yinlemv_fengmiantupian1.jpg,upload/yinlemv_fengmiantupian2.jpg,upload/yinlemv_fengmiantupian3.jpg', 1, 1);
INSERT INTO `yinlemv` VALUES (62, '2030-04-15 21:24:46', 'mv name2', 'Music classification2', 'Singer name2', '', '2030-04-15', 'lyric details2', 'upload/yinlemv_fengmiantupian2.jpg,upload/yinlemv_fengmiantupian3.jpg,upload/yinlemv_fengmiantupian4.jpg', 2, 2);
INSERT INTO `yinlemv` VALUES (63, '2030-04-15 21:24:46', 'mv name3', 'Music classification3', 'Singer name3', '', '2030-04-15', 'lyric details3', 'upload/yinlemv_fengmiantupian3.jpg,upload/yinlemv_fengmiantupian4.jpg,upload/yinlemv_fengmiantupian5.jpg', 3, 3);
INSERT INTO `yinlemv` VALUES (64, '2030-04-15 21:24:46', 'mv name4', 'Music classification4', 'Singer name4', '', '2030-04-15', 'lyric details4', 'upload/yinlemv_fengmiantupian4.jpg,upload/yinlemv_fengmiantupian5.jpg,upload/yinlemv_fengmiantupian6.jpg', 4, 4);
INSERT INTO `yinlemv` VALUES (65, '2030-04-15 21:24:46', 'mv name5', 'Music classification5', 'Singer name5', '', '2030-04-15', 'lyric details5', 'upload/yinlemv_fengmiantupian5.jpg,upload/yinlemv_fengmiantupian6.jpg,upload/yinlemv_fengmiantupian7.jpg', 5, 5);
INSERT INTO `yinlemv` VALUES (66, '2030-04-15 21:24:46', 'mv name6', 'Music classification6', 'Singer name6', '', '2030-04-15', 'lyric details6', 'upload/yinlemv_fengmiantupian6.jpg,upload/yinlemv_fengmiantupian7.jpg,upload/yinlemv_fengmiantupian8.jpg', 6, 6);
INSERT INTO `yinlemv` VALUES (67, '2030-04-15 21:24:46', 'mv name7', 'Music classification7', 'Singer name7', '', '2030-04-15', 'lyric details7', 'upload/yinlemv_fengmiantupian7.jpg,upload/yinlemv_fengmiantupian8.jpg,upload/yinlemv_fengmiantupian9.jpg', 7, 7);
INSERT INTO `yinlemv` VALUES (68, '2030-04-15 21:24:46', 'mv name8', 'Music classification8', 'Singer name8', '', '2030-04-15', 'lyric details8', 'upload/yinlemv_fengmiantupian8.jpg,upload/yinlemv_fengmiantupian9.jpg,upload/yinlemv_fengmiantupian10.jpg', 8, 8);

-- ----------------------------
-- Table structure for yinlezhuanji
-- ----------------------------
DROP TABLE IF EXISTS `yinlezhuanji`;
CREATE TABLE `yinlezhuanji`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhuanjimingcheng` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'album name',
  `songname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Song name',
  `yinlefenlei` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Music classification',
  `singer` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Singer',
  `fengmian` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'cover',
  `songfile` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Music file',
  `yinlefengge` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Musical style',
  `faxingshijian` date DEFAULT NULL COMMENT 'Issue time',
  `zhuanjijieshao` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Album introduction',
  `thumbsupnum` int(11) DEFAULT 0 COMMENT ' praise',
  `crazilynum` int(11) DEFAULT 0 COMMENT '踩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Music album' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yinlezhuanji
-- ----------------------------
INSERT INTO `yinlezhuanji` VALUES (51, '2030-04-15 21:24:46', 'album name1', 'Song name1', 'Music classification1', 'Singer1', 'upload/yinlezhuanji_fengmian1.jpg,upload/yinlezhuanji_fengmian2.jpg,upload/yinlezhuanji_fengmian3.jpg', '', 'Musical style1', '2030-04-15', 'Album introduction1', 1, 1);
INSERT INTO `yinlezhuanji` VALUES (52, '2030-04-15 21:24:46', 'album name2', 'Song name2', 'Music classification2', 'Singer2', 'upload/yinlezhuanji_fengmian2.jpg,upload/yinlezhuanji_fengmian3.jpg,upload/yinlezhuanji_fengmian4.jpg', '', 'Musical style2', '2030-04-15', 'Album introduction2', 2, 2);
INSERT INTO `yinlezhuanji` VALUES (53, '2030-04-15 21:24:46', 'album name3', 'Song name3', 'Music classification3', 'Singer3', 'upload/yinlezhuanji_fengmian3.jpg,upload/yinlezhuanji_fengmian4.jpg,upload/yinlezhuanji_fengmian5.jpg', '', 'Musical style3', '2030-04-15', 'Album introduction3', 3, 3);
INSERT INTO `yinlezhuanji` VALUES (54, '2030-04-15 21:24:46', 'album name4', 'Song name4', 'Music classification4', 'Singer4', 'upload/yinlezhuanji_fengmian4.jpg,upload/yinlezhuanji_fengmian5.jpg,upload/yinlezhuanji_fengmian6.jpg', '', 'Musical style4', '2030-04-15', 'Album introduction4', 4, 4);
INSERT INTO `yinlezhuanji` VALUES (55, '2030-04-15 21:24:46', 'album name5', 'Song name5', 'Music classification5', 'Singer5', 'upload/yinlezhuanji_fengmian5.jpg,upload/yinlezhuanji_fengmian6.jpg,upload/yinlezhuanji_fengmian7.jpg', '', 'Musical style5', '2030-04-15', 'Album introduction5', 5, 5);
INSERT INTO `yinlezhuanji` VALUES (56, '2030-04-15 21:24:46', 'album name6', 'Song name6', 'Music classification6', 'Singer6', 'upload/yinlezhuanji_fengmian6.jpg,upload/yinlezhuanji_fengmian7.jpg,upload/yinlezhuanji_fengmian8.jpg', '', 'Musical style6', '2030-04-15', 'Album introduction6', 6, 6);
INSERT INTO `yinlezhuanji` VALUES (57, '2030-04-15 21:24:46', 'album name7', 'Song name7', 'Music classification7', 'Singer7', 'upload/yinlezhuanji_fengmian7.jpg,upload/yinlezhuanji_fengmian8.jpg,upload/yinlezhuanji_fengmian9.jpg', '', 'Musical style7', '2030-04-15', 'Album introduction7', 7, 7);
INSERT INTO `yinlezhuanji` VALUES (58, '2030-04-15 21:24:46', 'album name8', 'Song name8', 'Music classification8', 'Singer8', 'upload/yinlezhuanji_fengmian8.jpg,upload/yinlezhuanji_fengmian9.jpg,upload/yinlezhuanji_fengmian10.jpg', '', 'Musical style8', '2030-04-15', 'Album introduction8', 8, 8);

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' user Account number',
  `mima` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'password',
  `yonghuxingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT ' user  name',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'sex',
  `nianling` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'age',
  `youxiang` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'mailbox',
  `shoujihao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Mobile phone number',
  `touxiang` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'avatar',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yonghuzhanghao`(`yonghuzhanghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = ' user ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES (11, '2030-04-15 21:24:46', ' user Account number1', '1', ' user  name1', 'male', 'age1', '773890001@qq.com', '13823888881', 'upload/yonghu_touxiang1.jpg');
INSERT INTO `yonghu` VALUES (12, '2030-04-15 21:24:46', ' user Account number2', '1', ' user  name2', 'male', 'age2', '773890002@qq.com', '13823888882', 'upload/yonghu_touxiang2.jpg');
INSERT INTO `yonghu` VALUES (13, '2030-04-15 21:24:46', ' user Account number3', '1', ' user  name3', 'male', 'age3', '773890003@qq.com', '13823888883', 'upload/yonghu_touxiang3.jpg');
INSERT INTO `yonghu` VALUES (14, '2030-04-15 21:24:46', ' user Account number4', '1', ' user  name4', 'male', 'age4', '773890004@qq.com', '13823888884', 'upload/yonghu_touxiang4.jpg');
INSERT INTO `yonghu` VALUES (15, '2030-04-15 21:24:46', ' user Account number5', '1', ' user  name5', 'male', 'age5', '773890005@qq.com', '13823888885', 'upload/yonghu_touxiang5.jpg');
INSERT INTO `yonghu` VALUES (16, '2030-04-15 21:24:46', ' user Account number6', '123456', ' user  name6', 'male', 'age6', '773890006@qq.com', '13823888886', 'upload/yonghu_touxiang6.jpg');
INSERT INTO `yonghu` VALUES (17, '2030-04-15 21:24:46', ' user Account number7', '123456', ' user  name7', 'male', 'age7', '773890007@qq.com', '13823888887', 'upload/yonghu_touxiang7.jpg');
INSERT INTO `yonghu` VALUES (18, '2030-04-15 21:24:46', ' user Account number8', '123456', ' user  name8', 'male', 'age8', '773890008@qq.com', '13823888888', 'upload/yonghu_touxiang8.jpg');

SET FOREIGN_KEY_CHECKS = 1;
