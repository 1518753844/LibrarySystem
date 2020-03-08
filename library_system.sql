/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : library_system

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 26/02/2020 22:56:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` smallint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ISBN` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cate_id` smallint(0) UNSIGNED NOT NULL,
  `remaining_qty` smallint(0) UNSIGNED NOT NULL,
  `lend_out_qty` smallint(0) UNSIGNED NOT NULL DEFAULT 0,
  `price` float(8, 2) NOT NULL,
  `author` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `lSBN`(`ISBN`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '数据结构与算法分析', '978-7-111-62195-9', 2, 4, 2, 79.00, '马克·艾伦·维斯');
INSERT INTO `book` VALUES (2, '刻意练习', '978-7-111-55128-7', 3, 3, 4, 39.00, '安德尔·艾利克森和罗伯特·普尔');
INSERT INTO `book` VALUES (3, '你当像鸟飞往你的山', '978-7-5442-7698-6', 1, 1, 2, 59.00, '米歇尔');
INSERT INTO `book` VALUES (4, '简·爱', '978-7-5402-2502-5', 1, 3, 2, 25.00, '夏洛蒂·勃朗特');

-- ----------------------------
-- Table structure for book_cate
-- ----------------------------
DROP TABLE IF EXISTS `book_cate`;
CREATE TABLE `book_cate`  (
  `id` smallint(0) UNSIGNED NOT NULL,
  `cate_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `book_cate_cart_name_uindex`(`cate_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_cate
-- ----------------------------
INSERT INTO `book_cate` VALUES (3, '实用类');
INSERT INTO `book_cate` VALUES (1, '文学类');
INSERT INTO `book_cate` VALUES (2, '计算机类');

-- ----------------------------
-- Table structure for book_category
-- ----------------------------
DROP TABLE IF EXISTS `book_category`;
CREATE TABLE `book_category`  (
  `id` smallint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for common_staff
-- ----------------------------
DROP TABLE IF EXISTS `common_staff`;
CREATE TABLE `common_staff`  (
  `id` smallint(0) UNSIGNED NOT NULL,
  `truth_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `common_staff_mobile_uindex`(`mobile`) USING BTREE,
  UNIQUE INDEX `common_staff_email_uindex`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of common_staff
-- ----------------------------
INSERT INTO `common_staff` VALUES (1, '小明', '男', '147@qq.com', '147');
INSERT INTO `common_staff` VALUES (2, '小红', '女', '258@qq.com', '258');
INSERT INTO `common_staff` VALUES (3, '小蓝', '女', '369@qq.com', '369');
INSERT INTO `common_staff` VALUES (4, '小新', '男', '159@qq.com', '159');
INSERT INTO `common_staff` VALUES (5, '小欣', '女', '753@qq.com', '753');

-- ----------------------------
-- Table structure for curator
-- ----------------------------
DROP TABLE IF EXISTS `curator`;
CREATE TABLE `curator`  (
  `id` smallint(0) UNSIGNED NOT NULL,
  `truth_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `curator_mobile_uindex`(`mobile`) USING BTREE,
  UNIQUE INDEX `curator_email_uindex`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of curator
-- ----------------------------
INSERT INTO `curator` VALUES (6, '痞老板', '男', 'piboss@qq.com', '7890');
INSERT INTO `curator` VALUES (7, '蟹老板', '男', 'xieboss@qq.com', '5678');
INSERT INTO `curator` VALUES (8, '海绵宝宝', '男', 'haimian@qq.com', '1234');

-- ----------------------------
-- Table structure for job_name
-- ----------------------------
DROP TABLE IF EXISTS `job_name`;
CREATE TABLE `job_name`  (
  `id` tinyint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `job_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `job_name_job_name_uindex`(`job_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of job_name
-- ----------------------------
INSERT INTO `job_name` VALUES (4, '书籍信息管理员');
INSERT INTO `job_name` VALUES (5, '总管理员');
INSERT INTO `job_name` VALUES (3, '普通职员');
INSERT INTO `job_name` VALUES (2, '馆长');

-- ----------------------------
-- Table structure for library
-- ----------------------------
DROP TABLE IF EXISTS `library`;
CREATE TABLE `library`  (
  `id` smallint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `library_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `curator_id` smallint(0) UNSIGNED NOT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of library
-- ----------------------------
INSERT INTO `library` VALUES (1, '海绵宝宝图书馆', 8, '菠萝屋');
INSERT INTO `library` VALUES (2, '痞老板图书馆', 6, '水底');
INSERT INTO `library` VALUES (3, '蟹老板图书馆', 7, '蟹黄堡');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` smallint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `job_id` smallint(0) UNSIGNED NOT NULL DEFAULT 1,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `psw` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `member_of_library` smallint(0) UNSIGNED NOT NULL,
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `on_commission` tinyint(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 3, '147xiaoming', '147xiaoming', 1, '小明', 1);
INSERT INTO `user` VALUES (2, 3, '258xiaohong', '258xiaohong', 2, '小红', 1);
INSERT INTO `user` VALUES (3, 3, '369xiaolan', '369xiaolan', 1, '小蓝', 1);
INSERT INTO `user` VALUES (4, 3, '159xioaxin', '159xioaxin', 3, '小新', 0);
INSERT INTO `user` VALUES (5, 3, '753xiaoxin', '753xiaoxin', 2, '小欣', 0);
INSERT INTO `user` VALUES (6, 2, 'piboss77', 'piboss77', 2, '痞老板', 1);
INSERT INTO `user` VALUES (7, 2, 'xieboss66', 'xieboss66', 3, '蟹老板', 1);
INSERT INTO `user` VALUES (8, 2, 'baobao11', 'baobao11', 1, '海绵宝宝', 1);

SET FOREIGN_KEY_CHECKS = 1;
