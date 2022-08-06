/*
 Navicat Premium Data Transfer

 Source Server         : mine
 Source Server Type    : MySQL
 Source Server Version : 100424
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 100424
 File Encoding         : 65001

 Date: 06/08/2022 18:48:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `private` int NULL DEFAULT 0,
  `business` int NULL DEFAULT 0,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `first_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `last_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT current_timestamp,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `forgot_password_question` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `forgot_password_answer` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bio` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `last_login` datetime NULL DEFAULT NULL,
  `registered_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name_UNIQUE`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES (1, 0, 0, '1.png', 'reza', 'rezaei', 'reza', NULL, 'reza@gmail.com', '2022-07-26', '1', 'xbsdg', 'xfbjxn', 'dbfngm', '2022-06-28 14:47:27', '2022-07-14 14:49:40');
INSERT INTO `accounts` VALUES (2, 0, 0, '2.png', 'ali', 'alinia', 'alip', NULL, 'ali1@gmail.com', '2022-07-06', '1', 'fdbgzfd', 'vxbncm', 'fxbngcm', '2022-07-19 14:47:30', '2022-07-28 14:49:35');
INSERT INTO `accounts` VALUES (3, 0, 0, '3.png', 'alireza', 'rezaei', 'mamad', NULL, 'reza@gmail.com', '2022-07-10', '1', 'fbb', 'vxcbcvnb', 'xbncb', '2022-07-03 14:47:35', '2022-07-04 14:49:31');
INSERT INTO `accounts` VALUES (4, 0, 0, '4.png', 'ahmad', 'alinia', 'arya', NULL, 'ali1@gmail.com', '2022-06-30', '1', 'fb', 'vcbcb', 'xbnvc', '2022-07-19 14:47:40', '2022-07-19 14:49:24');
INSERT INTO `accounts` VALUES (5, 0, 0, '5.png', 'hassan', 'hassani', 'parsaaaa', NULL, 'kami@yahoo.com', '2022-07-05', '1', 'bxcb', 'xvcv b', 'vn', '2022-07-22 14:47:46', '2022-07-10 14:49:19');
INSERT INTO `accounts` VALUES (6, 0, 0, NULL, 'aa', 'bb', 'arta', NULL, 'kkkk@gmail.com', '2022-11-23', '1', 'dbxcb', 'bxf', 'uuyhbjg', '2022-07-30 14:47:49', '2022-07-11 14:49:15');
INSERT INTO `accounts` VALUES (7, 0, 0, NULL, 'aaa', 'qqqq', 'pourya', NULL, 'kjh@gmail.com', '2022-01-05', '1', 'dxbbxcb', 'vcbvb', 'rehtnr', '2022-07-24 14:47:54', '2022-07-23 14:49:12');
INSERT INTO `accounts` VALUES (8, 0, 0, NULL, 'DLCSN, ', 'ADJCBNL', 'majid', NULL, 'kami@gmail.com', '2022-07-16', '1', 'bbx ', 'vcxbv', 'thsdndnhd', '2022-07-23 14:47:58', '2022-07-10 14:49:08');
INSERT INTO `accounts` VALUES (9, 0, 0, '', 'DCLJN', 'SDCKN', 'nilofar', NULL, 'kami@mail.com', '2022-07-10', '1', 'cbxc b', 'vcv bx', 'gnfxhm', '2022-07-16 14:48:02', '2022-07-23 14:49:04');
INSERT INTO `accounts` VALUES (10, 0, 0, '340840270001200.png', 'parsa', 'ecwv', 'parsa', '', 'parsa@gmail.com', '1970-01-01', '1', 'who is your first school teacher?', 'fathi', 'assdc', '2022-06-07 11:00:18', '2022-06-07 11:00:15');
INSERT INTO `accounts` VALUES (11, 0, 0, '6.png', 'safsghdg', 'esgdgf', 'atena', NULL, 'dsfdbgnmjh.gamil', '2022-07-23', '1', 'ccb', 'hdgjh,bj', 'xnjmku', '2022-07-10 14:48:07', '2022-07-19 14:49:00');
INSERT INTO `accounts` VALUES (12, 0, 0, '7.png', '11111', '11111', 'fatemeh', NULL, 'kami@hotmail.com', '2022-07-04', '1', 'xcbfb', 'fcgn', 'xfgnfmj', '2022-07-17 14:48:11', '2022-07-19 14:48:46');
INSERT INTO `accounts` VALUES (13, 0, 0, '8.png', 'DSLMD', ';dlcmklsn', 'melika', NULL, 'qef.gamil.com', '2022-07-08', '1', 'dxbxc xcb', 'cxcv', 'urtjyk', '2022-07-30 14:48:15', '2022-07-22 14:48:51');
INSERT INTO `accounts` VALUES (14, 0, 0, '9.png', '231', '321', '32p1', '321', '321', '2022-07-20', '1', 'xcb xc ', 'xbccvn', 'dfnxgm', '2022-07-17 14:48:18', '0000-00-00 00:00:00');
INSERT INTO `accounts` VALUES (15, 0, 0, '10.png', '1321', '321', '11111', '321', '321', '2022-07-01', '1', 'xc xcbdb', 'zvdbxn', 'fdngf,', '2022-07-23 14:48:26', '2022-07-20 14:48:55');
INSERT INTO `accounts` VALUES (16, 0, 0, NULL, 'ehsan', 'farahani', 'asdfg', NULL, 'SDVfdbg', '2022-08-09', 'asdfgj', NULL, NULL, NULL, NULL, '2022-07-23 08:24:02');
INSERT INTO `accounts` VALUES (17, 0, 0, NULL, 'aa', 'aa', 'aaaaaaaa', NULL, 'qqqqqq', '2022-08-18', '123456', 'null', 'null', NULL, NULL, '2022-07-26 11:25:10');
INSERT INTO `accounts` VALUES (23, 0, 0, NULL, 'vdasdv', 'sdvzsdv', 'sdvSDv', NULL, '@', '2022-08-23', 'sdvzdsdv', 'null', 'null', NULL, NULL, '2022-07-30 11:11:51');
INSERT INTO `accounts` VALUES (24, 0, 0, NULL, 'alex', 'white', 'alexw', NULL, 'axw@gmail.com', '2022-08-23', 'abcdef', 'null', 'null', NULL, NULL, '2022-08-02 04:12:28');
INSERT INTO `accounts` VALUES (25, 0, 0, NULL, 'reza', 'rezaee', 'rezar', NULL, 'dfv@gmail.com', '2022-08-23', '123456', 'null', 'null', NULL, NULL, '2022-08-02 09:51:47');
INSERT INTO `accounts` VALUES (26, 0, 0, NULL, 'zdv', 'asdgf', 'aaa', NULL, 'aedgf@', '2022-08-16', '123456', 'null', 'null', NULL, NULL, '2022-08-02 12:13:28');
INSERT INTO `accounts` VALUES (27, 0, 0, NULL, 'sss', 'sss', 'sss', NULL, 'sss@', '2022-08-02', '123456', 'null', 'null', NULL, NULL, '2022-08-02 12:17:09');
INSERT INTO `accounts` VALUES (28, 0, 0, NULL, 'etcvbui', 'tffgvbnkl', 'uybbku', NULL, 'sdcc@', '2022-08-03', '123456', 'null', 'null', NULL, NULL, '2022-08-03 11:30:22');
INSERT INTO `accounts` VALUES (29, 0, 0, NULL, 'hbk', 'hgnvhkb', 'fghcjvhvm', NULL, 'hfgcvmj@', '2022-08-03', '123456', 'null', 'null', NULL, NULL, '2022-08-03 13:17:49');
INSERT INTO `accounts` VALUES (30, 0, 0, NULL, 'qq', 'qq', 'qqqqq', NULL, '111@qqqq', '2022-08-03', '111111', 'null', 'null', NULL, NULL, '2022-08-03 13:34:19');
INSERT INTO `accounts` VALUES (31, 0, 0, NULL, 'qq', 'qq', 'qqqq', NULL, '11@qqqqq', '2022-08-03', '111111', 'null', 'null', NULL, NULL, '2022-08-03 13:38:12');
INSERT INTO `accounts` VALUES (32, 0, 0, NULL, 'ww', 'ww', 'wwww', NULL, 'ww@ww', '2022-08-03', 'wwwwww', 'null', 'null', NULL, NULL, '2022-08-03 13:41:31');
INSERT INTO `accounts` VALUES (33, 0, 0, NULL, 'a', 'b', 'c', NULL, 'reza@gmail.com', '2022-08-04', '123456', 'null', 'null', NULL, NULL, '2022-08-04 09:53:46');
INSERT INTO `accounts` VALUES (34, 0, 0, '', 'vv', 'vv', 'vv', NULL, 'vv@', '2022-08-06', 'vvvvvv', 'null', 'null', NULL, NULL, '2022-08-06 12:07:28');
INSERT INTO `accounts` VALUES (35, 0, 0, '324222493488700.jpg', 'kk', 'kk', 'kk', NULL, 'kk@', '2022-08-06', 'kkkkkk', 'null', 'null', NULL, NULL, '2022-08-06 12:08:49');

-- ----------------------------
-- Table structure for blocks
-- ----------------------------
DROP TABLE IF EXISTS `blocks`;
CREATE TABLE `blocks`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `blocker_id` int NULL DEFAULT NULL,
  `blocked_id` int NULL DEFAULT NULL,
  `blocked_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blocks
-- ----------------------------
INSERT INTO `blocks` VALUES (13, 10, 11, '2022-08-02 13:33:33');
INSERT INTO `blocks` VALUES (14, 10, 12, '2022-08-02 13:33:34');
INSERT INTO `blocks` VALUES (16, 10, 4, '2022-08-06 11:18:20');
INSERT INTO `blocks` VALUES (17, 10, 1, '2022-08-06 11:18:25');

-- ----------------------------
-- Table structure for business_faq
-- ----------------------------
DROP TABLE IF EXISTS `business_faq`;
CREATE TABLE `business_faq`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `account_id` int NULL DEFAULT NULL,
  `question` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `answer` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `added_at` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of business_faq
-- ----------------------------

-- ----------------------------
-- Table structure for business_product_categories
-- ----------------------------
DROP TABLE IF EXISTS `business_product_categories`;
CREATE TABLE `business_product_categories`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `account_id` int NULL DEFAULT NULL,
  `category_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `category_image` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of business_product_categories
-- ----------------------------

-- ----------------------------
-- Table structure for business_products
-- ----------------------------
DROP TABLE IF EXISTS `business_products`;
CREATE TABLE `business_products`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `account_id` int NOT NULL,
  `category_id` int NULL DEFAULT NULL,
  `product_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `product_description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `media` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cost` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of business_products
-- ----------------------------

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `account_id` int NULL DEFAULT NULL,
  `store_id` int NULL DEFAULT NULL,
  `product_id` int NULL DEFAULT NULL,
  `added_at` datetime NULL DEFAULT NULL,
  `process` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of carts
-- ----------------------------

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `sender_id` int NULL DEFAULT NULL,
  `post_id` int NULL DEFAULT NULL,
  `reply_id` int NULL DEFAULT NULL,
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `media` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sent_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (6, 8, 16, NULL, 'serhdtfy', NULL, '2022-06-09 11:09:01');
INSERT INTO `comments` VALUES (9, 10, 16, NULL, 'erwt', NULL, '2022-06-16 10:28:54');
INSERT INTO `comments` VALUES (15, 10, 15, NULL, 'wsfvs', NULL, '2022-08-01 15:31:13');
INSERT INTO `comments` VALUES (16, 10, 15, 15, 'asdv', NULL, '2022-08-01 15:31:53');
INSERT INTO `comments` VALUES (23, 1, 9, NULL, 'aaa', NULL, '2022-08-04 13:26:42');
INSERT INTO `comments` VALUES (24, 2, 9, NULL, 'bbb', NULL, '2022-08-04 13:26:43');
INSERT INTO `comments` VALUES (25, 3, 9, NULL, 'ccc', NULL, '2022-08-04 13:26:45');
INSERT INTO `comments` VALUES (26, 4, 9, NULL, 'ryh', NULL, '2022-08-06 18:16:06');
INSERT INTO `comments` VALUES (27, 5, 9, NULL, 'e5y', NULL, '2022-08-06 18:16:10');
INSERT INTO `comments` VALUES (28, 6, 9, NULL, 'e4', NULL, '2022-08-06 18:16:14');
INSERT INTO `comments` VALUES (29, 7, 9, NULL, 'sety456u5', NULL, '2022-08-06 18:16:14');
INSERT INTO `comments` VALUES (30, 8, 9, NULL, 'w5uye56iu', NULL, '2022-08-06 18:16:14');
INSERT INTO `comments` VALUES (31, 9, 9, NULL, '347ej', NULL, '2022-08-06 18:16:15');
INSERT INTO `comments` VALUES (32, 10, 9, NULL, '45uerg', NULL, '2022-08-06 18:16:15');
INSERT INTO `comments` VALUES (33, 11, 9, NULL, 'wterg', NULL, '2022-08-06 18:16:15');
INSERT INTO `comments` VALUES (34, 12, 9, NULL, '34y6679', NULL, '2022-08-06 18:16:16');
INSERT INTO `comments` VALUES (35, 13, 9, NULL, 'rtyw6', NULL, '2022-08-06 18:16:16');
INSERT INTO `comments` VALUES (36, 14, 9, NULL, 'io67i', NULL, '2022-08-06 18:16:16');
INSERT INTO `comments` VALUES (37, 15, 9, NULL, 'q34t45', NULL, '2022-08-06 18:16:17');
INSERT INTO `comments` VALUES (38, 5, 9, NULL, 'r6ir8o', NULL, '2022-08-06 18:16:17');
INSERT INTO `comments` VALUES (39, 4, 9, NULL, '346w5y', NULL, '2022-08-06 18:16:17');
INSERT INTO `comments` VALUES (40, 3, 9, NULL, '865', NULL, '2022-08-06 18:16:17');
INSERT INTO `comments` VALUES (41, 1, 9, NULL, 'q34657', NULL, '2022-08-06 18:16:17');
INSERT INTO `comments` VALUES (42, 2, 9, NULL, '6ir6u8', NULL, '2022-08-06 18:16:19');

-- ----------------------------
-- Table structure for followings
-- ----------------------------
DROP TABLE IF EXISTS `followings`;
CREATE TABLE `followings`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `follower_id` int NULL DEFAULT NULL,
  `followed_id` int NULL DEFAULT NULL,
  `followed_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 189 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of followings
-- ----------------------------
INSERT INTO `followings` VALUES (168, 10, 1, '2022-08-06 11:30:09');
INSERT INTO `followings` VALUES (169, 10, 2, '2022-08-06 11:30:10');
INSERT INTO `followings` VALUES (170, 10, 3, '2022-08-06 11:30:12');
INSERT INTO `followings` VALUES (171, 10, 4, '2022-08-06 11:30:13');
INSERT INTO `followings` VALUES (172, 10, 5, '2022-08-06 11:30:16');
INSERT INTO `followings` VALUES (173, 1, 10, '2022-08-06 11:30:21');
INSERT INTO `followings` VALUES (174, 2, 10, '2022-08-06 11:30:21');
INSERT INTO `followings` VALUES (175, 3, 10, '2022-08-06 11:30:22');
INSERT INTO `followings` VALUES (176, 4, 10, '2022-08-06 11:30:22');
INSERT INTO `followings` VALUES (177, 5, 10, '2022-08-06 11:30:24');
INSERT INTO `followings` VALUES (178, 6, 10, '2022-08-06 11:30:34');
INSERT INTO `followings` VALUES (179, 7, 10, '2022-08-06 11:30:34');
INSERT INTO `followings` VALUES (180, 8, 10, '2022-08-06 11:30:35');
INSERT INTO `followings` VALUES (181, 9, 10, '2022-08-06 11:30:36');
INSERT INTO `followings` VALUES (182, 10, 11, '2022-08-06 11:30:47');
INSERT INTO `followings` VALUES (187, 10, 6, '2022-08-06 11:38:26');
INSERT INTO `followings` VALUES (188, 10, 7, '2022-08-06 11:39:55');

-- ----------------------------
-- Table structure for group_members
-- ----------------------------
DROP TABLE IF EXISTS `group_members`;
CREATE TABLE `group_members`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `group_id` int NULL DEFAULT NULL,
  `member_id` int NULL DEFAULT NULL,
  `title` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `joined_at` datetime NULL DEFAULT current_timestamp,
  `is_admin` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of group_members
-- ----------------------------
INSERT INTO `group_members` VALUES (23, 13, 0, 'a', '2022-06-09 09:28:24', b'0');
INSERT INTO `group_members` VALUES (28, 16, 1, 'a', '2022-06-16 09:03:41', b'0');
INSERT INTO `group_members` VALUES (29, 16, 2, 'a', '2022-06-16 09:03:41', b'0');
INSERT INTO `group_members` VALUES (33, 8, 10, 'a', '2022-06-20 04:49:18', b'1');
INSERT INTO `group_members` VALUES (43, 7, 8, 'a', '2022-06-20 04:51:36', b'0');
INSERT INTO `group_members` VALUES (45, 8, 10, 'a', '2022-06-20 04:51:45', b'0');
INSERT INTO `group_members` VALUES (46, 8, 12, 'a', '2022-06-20 04:51:50', b'0');
INSERT INTO `group_members` VALUES (47, 8, 13, 'a', '2022-06-20 04:51:52', b'0');
INSERT INTO `group_members` VALUES (55, 18, 10, 'a', '2022-08-04 12:29:10', b'0');
INSERT INTO `group_members` VALUES (56, 18, 1, 'a', '2022-08-04 12:29:12', b'0');
INSERT INTO `group_members` VALUES (57, 18, 2, 'a', '2022-08-04 12:29:14', b'0');
INSERT INTO `group_members` VALUES (58, 18, 3, 'a', '2022-08-04 12:29:15', b'0');
INSERT INTO `group_members` VALUES (59, 18, 4, 'a', '2022-08-04 12:29:17', b'0');
INSERT INTO `group_members` VALUES (60, 18, 5, 'a', '2022-08-04 12:29:18', b'0');
INSERT INTO `group_members` VALUES (61, 19, 6, 'a', '2022-08-04 12:29:21', b'0');
INSERT INTO `group_members` VALUES (62, 19, 7, 'a', '2022-08-04 12:29:22', b'0');
INSERT INTO `group_members` VALUES (63, 19, 8, 'a', '2022-08-04 12:29:24', b'0');
INSERT INTO `group_members` VALUES (64, 19, 9, 'a', '2022-08-04 12:29:25', b'0');
INSERT INTO `group_members` VALUES (65, 19, 10, 'a', '2022-08-04 12:29:27', b'0');
INSERT INTO `group_members` VALUES (66, 19, 11, 'a', '2022-08-04 12:29:28', b'0');
INSERT INTO `group_members` VALUES (67, 19, 12, 'a', '2022-08-04 12:29:30', b'0');
INSERT INTO `group_members` VALUES (68, 24, 10, NULL, '2022-08-06 11:43:48', b'0');
INSERT INTO `group_members` VALUES (69, 25, 10, NULL, '2022-08-06 11:44:26', b'0');
INSERT INTO `group_members` VALUES (70, 24, 1, NULL, '2022-08-06 13:08:32', b'0');
INSERT INTO `group_members` VALUES (71, 24, 2, NULL, '2022-08-06 13:08:38', b'0');
INSERT INTO `group_members` VALUES (72, 24, 3, NULL, '2022-08-06 13:08:39', b'0');
INSERT INTO `group_members` VALUES (73, 24, 4, NULL, '2022-08-06 13:08:47', b'0');
INSERT INTO `group_members` VALUES (74, 24, 5, NULL, '2022-08-06 13:08:52', b'0');

-- ----------------------------
-- Table structure for group_messages
-- ----------------------------
DROP TABLE IF EXISTS `group_messages`;
CREATE TABLE `group_messages`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `group_id` int NULL DEFAULT NULL,
  `sender_id` int NULL DEFAULT NULL,
  `reply_id` int NULL DEFAULT NULL,
  `type` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `forwarded_from_id` int NULL DEFAULT NULL,
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `media` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `seen` int NULL DEFAULT NULL,
  `edited` int NULL DEFAULT NULL,
  `sent_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of group_messages
-- ----------------------------
INSERT INTO `group_messages` VALUES (21, 18, 1, NULL, NULL, NULL, 'hi', NULL, NULL, NULL, '2022-08-04 12:30:23');
INSERT INTO `group_messages` VALUES (22, 18, 2, NULL, NULL, NULL, 'hello', NULL, NULL, NULL, '2022-08-04 12:30:25');
INSERT INTO `group_messages` VALUES (23, 18, 3, NULL, NULL, NULL, 'how are u', NULL, NULL, NULL, '2022-08-04 12:30:27');
INSERT INTO `group_messages` VALUES (24, 18, 4, NULL, NULL, NULL, 'fine ', NULL, NULL, NULL, '2022-08-04 12:30:28');
INSERT INTO `group_messages` VALUES (25, 18, 5, NULL, NULL, NULL, 'good', NULL, NULL, NULL, '2022-08-04 12:30:28');
INSERT INTO `group_messages` VALUES (26, 18, 10, NULL, NULL, NULL, 'perfect', NULL, NULL, NULL, '2022-08-04 12:30:31');
INSERT INTO `group_messages` VALUES (27, 18, 2, NULL, NULL, NULL, 'great ', NULL, NULL, NULL, '2022-08-04 12:30:34');
INSERT INTO `group_messages` VALUES (28, 18, 3, NULL, NULL, NULL, 'what about u?', NULL, NULL, NULL, '2022-08-04 12:30:34');
INSERT INTO `group_messages` VALUES (29, 18, 4, NULL, NULL, NULL, 'good morning', NULL, NULL, NULL, '2022-08-04 12:30:35');
INSERT INTO `group_messages` VALUES (30, 18, 10, NULL, NULL, NULL, 'sfb', NULL, NULL, NULL, '2022-08-04 12:30:35');
INSERT INTO `group_messages` VALUES (31, 18, 10, NULL, NULL, NULL, 'zsrbzx', NULL, NULL, NULL, '2022-08-04 12:30:36');
INSERT INTO `group_messages` VALUES (32, 18, 1, NULL, NULL, NULL, 'rg', NULL, NULL, NULL, '2022-08-04 12:30:37');
INSERT INTO `group_messages` VALUES (33, 19, 6, NULL, NULL, NULL, 'rfbzxb', NULL, NULL, NULL, '2022-08-04 12:30:39');
INSERT INTO `group_messages` VALUES (34, 19, 10, NULL, NULL, NULL, 'rhsdfb', NULL, NULL, NULL, '2022-08-04 12:30:42');
INSERT INTO `group_messages` VALUES (35, 19, 7, NULL, NULL, NULL, 'sethzdfb', NULL, NULL, NULL, '2022-08-04 12:30:42');
INSERT INTO `group_messages` VALUES (36, 19, 8, NULL, NULL, NULL, 'aerhbzfb', NULL, NULL, NULL, '2022-08-04 12:30:43');
INSERT INTO `group_messages` VALUES (37, 19, 10, NULL, NULL, NULL, 'trueius', NULL, NULL, NULL, '2022-08-04 12:30:44');
INSERT INTO `group_messages` VALUES (38, 19, 9, NULL, NULL, NULL, 'segaey', NULL, NULL, NULL, '2022-08-04 12:30:47');
INSERT INTO `group_messages` VALUES (39, 19, 10, NULL, NULL, NULL, 'zdfndtyuk', NULL, NULL, NULL, '2022-08-04 12:30:47');
INSERT INTO `group_messages` VALUES (40, 19, 11, NULL, NULL, NULL, 'aetaerzhfb', NULL, NULL, NULL, '2022-08-04 12:30:48');
INSERT INTO `group_messages` VALUES (41, 19, 12, NULL, NULL, NULL, 'zdf', NULL, NULL, NULL, '2022-08-04 12:30:49');
INSERT INTO `group_messages` VALUES (42, 19, 10, NULL, NULL, NULL, 'earhsfgn', NULL, NULL, NULL, '2022-08-04 12:30:49');
INSERT INTO `group_messages` VALUES (43, 19, 8, NULL, NULL, NULL, 'srtjsdfn', NULL, NULL, NULL, '2022-08-04 12:30:51');
INSERT INTO `group_messages` VALUES (44, 18, 10, NULL, NULL, NULL, 'sfdfdsfs', NULL, NULL, NULL, '2022-08-04 12:39:21');
INSERT INTO `group_messages` VALUES (45, 18, 10, NULL, NULL, NULL, 'dsfdsfsdfds', NULL, NULL, NULL, '2022-08-04 12:39:24');
INSERT INTO `group_messages` VALUES (46, 18, 10, NULL, NULL, NULL, 'uyytyy', NULL, NULL, NULL, '2022-08-04 12:41:15');
INSERT INTO `group_messages` VALUES (47, 18, 10, NULL, NULL, NULL, 'yuyuyuyy', NULL, NULL, NULL, '2022-08-04 12:41:17');
INSERT INTO `group_messages` VALUES (48, 18, 10, NULL, NULL, NULL, 'yuyuyuu', NULL, NULL, NULL, '2022-08-04 12:41:18');
INSERT INTO `group_messages` VALUES (49, 24, 10, NULL, NULL, NULL, 'rthsb', NULL, NULL, NULL, '2022-08-06 13:09:13');
INSERT INTO `group_messages` VALUES (50, 24, 1, NULL, NULL, NULL, 'serrgserg', NULL, NULL, NULL, '2022-08-06 13:09:14');
INSERT INTO `group_messages` VALUES (51, 24, 2, NULL, NULL, NULL, 'er5erg', NULL, NULL, NULL, '2022-08-06 13:09:15');
INSERT INTO `group_messages` VALUES (52, 24, 2, NULL, NULL, NULL, 'werhgserg', NULL, NULL, NULL, '2022-08-06 13:09:17');
INSERT INTO `group_messages` VALUES (53, 24, 3, NULL, NULL, NULL, 'awrt4y', NULL, NULL, NULL, '2022-08-06 13:09:18');
INSERT INTO `group_messages` VALUES (54, 24, 4, NULL, NULL, NULL, 'awrghsg', NULL, NULL, NULL, '2022-08-06 13:09:20');
INSERT INTO `group_messages` VALUES (55, 24, 5, NULL, NULL, NULL, 'erhsreg', NULL, NULL, NULL, '2022-08-06 13:09:22');
INSERT INTO `group_messages` VALUES (56, 24, 10, NULL, NULL, NULL, 'strhseg', NULL, NULL, NULL, '2022-08-06 13:09:37');
INSERT INTO `group_messages` VALUES (57, 24, 1, NULL, NULL, NULL, 'etrhsg', NULL, NULL, NULL, '2022-08-06 13:09:38');
INSERT INTO `group_messages` VALUES (58, 24, 4, NULL, NULL, NULL, 'rgsg', NULL, NULL, NULL, '2022-08-06 13:09:39');
INSERT INTO `group_messages` VALUES (59, 24, 5, NULL, NULL, NULL, 'etryjrth', NULL, NULL, NULL, '2022-08-06 13:09:40');
INSERT INTO `group_messages` VALUES (60, 24, 3, NULL, NULL, NULL, 'WRGH', NULL, NULL, NULL, '2022-08-06 13:09:42');

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `creator_id` int NULL DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bio` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `profile_picture` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `link` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES (2, 8, 'group 2', 'group 2', '2.jpg', NULL, '2022-06-07 10:18:45');
INSERT INTO `groups` VALUES (5, 3, 'group 5', 'group 5', '5.jpg', NULL, '2022-06-07 10:18:45');
INSERT INTO `groups` VALUES (7, 10, 'g2', 'g2', 'g2', 'g2', '2022-06-09 08:57:17');
INSERT INTO `groups` VALUES (8, 10, 'g3', 'g3', '340810571331300.png', 'null', '2022-06-09 08:58:05');
INSERT INTO `groups` VALUES (10, 10, 'g5', 'g5', 'g5', 'g5', '2022-06-09 09:02:37');
INSERT INTO `groups` VALUES (11, 10, 'g6', 'g6', 'g6', 'g6', '2022-06-09 09:03:52');
INSERT INTO `groups` VALUES (12, 10, 'g7', 'g7', 'g7', 'g7', '2022-06-09 09:28:24');
INSERT INTO `groups` VALUES (13, 10, 'g10', 'g10', 'g10', 'g10', '2022-06-16 09:03:41');
INSERT INTO `groups` VALUES (18, 10, 'g11', 'g11bio', 'g11pic', 'g11link', '2022-08-04 12:27:52');
INSERT INTO `groups` VALUES (19, 3, 'g12', 'g12bio', 'g12pic', 'g12link', '2022-08-04 12:28:11');
INSERT INTO `groups` VALUES (24, 10, 'ddd', 'dd', '340804148733100.png', 'null', '2022-08-06 11:43:48');
INSERT INTO `groups` VALUES (25, 10, 'mmm', 'mm', '332618281338700.jpg', 'null', '2022-08-06 11:44:26');

-- ----------------------------
-- Table structure for humen
-- ----------------------------
DROP TABLE IF EXISTS `humen`;
CREATE TABLE `humen`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `family` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of humen
-- ----------------------------
INSERT INTO `humen` VALUES (1, 'ali', 'rezaei');
INSERT INTO `humen` VALUES (2, 'ali', 'rezaei');

-- ----------------------------
-- Table structure for posts
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `account_id` int NULL DEFAULT NULL,
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `media` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sent_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of posts
-- ----------------------------
INSERT INTO `posts` VALUES (9, 10, 'adsghd', '1.jpg', '2022-06-16 14:16:26');
INSERT INTO `posts` VALUES (10, 10, 'post 6', '2.jpg', '2022-06-20 14:16:29');
INSERT INTO `posts` VALUES (12, 10, 'post 8', '3.jpg', '2022-06-18 14:16:35');
INSERT INTO `posts` VALUES (15, 2, 'wdaes', '4.jpg', '2022-05-29 14:16:40');
INSERT INTO `posts` VALUES (16, 2, 'others test post 1', '5.jpg', '2022-06-15 14:16:22');
INSERT INTO `posts` VALUES (21, 2, 'egrhtjf', '6.jpg', '2022-06-09 09:47:52');
INSERT INTO `posts` VALUES (22, 2, 'afesgrhd', '7.jpg', '2022-06-09 09:47:54');
INSERT INTO `posts` VALUES (23, 2, 'safvdbgf', '8.jpg', '2022-06-09 09:47:58');
INSERT INTO `posts` VALUES (24, 2, 'fasdgfgn', '9.jpg', '2022-06-09 09:48:03');
INSERT INTO `posts` VALUES (25, 2, 'safdgfhg', '10.jpg', '2022-06-09 09:48:05');
INSERT INTO `posts` VALUES (26, 11, 'sczvdxbfg', '11.jpg', '2022-06-09 09:48:06');
INSERT INTO `posts` VALUES (27, 11, 'CSzvdxbf', '12.jpg', '2022-06-09 09:48:06');
INSERT INTO `posts` VALUES (28, 11, 'sdfdgf', '13.jpg', '2022-06-09 09:48:07');
INSERT INTO `posts` VALUES (29, 11, 'xc', '14.jpg', '2022-06-09 09:48:08');
INSERT INTO `posts` VALUES (30, 11, 'dvsbgfd', '15.jpg', '2022-06-09 09:48:10');
INSERT INTO `posts` VALUES (31, 13, 'sdb', '16.jpg', '2022-06-09 09:48:11');
INSERT INTO `posts` VALUES (32, 13, 'afesgr', '17.jpg', '2022-06-09 09:48:11');
INSERT INTO `posts` VALUES (33, 13, 'fegr', '18.jpg', '2022-06-09 09:48:12');
INSERT INTO `posts` VALUES (34, 13, 'fesgr', '19.jpg', '2022-06-09 09:48:12');
INSERT INTO `posts` VALUES (35, 13, 'aesrhdr', '20.jpg', '2022-06-09 09:48:13');
INSERT INTO `posts` VALUES (36, 13, 'SEy', '1.jpg', '2022-06-09 09:48:22');
INSERT INTO `posts` VALUES (43, 10, 'dfvzsdv', '2.jpg', '2022-08-02 15:14:25');
INSERT INTO `posts` VALUES (44, 10, 'ghjbkn', '3.jpg', '2022-08-02 15:42:25');
INSERT INTO `posts` VALUES (45, 10, 'ghvjbn,', '4.jpg', '2022-08-02 15:42:27');
INSERT INTO `posts` VALUES (46, 10, 'po;ljhkj', '5.jpg', '2022-08-02 15:42:28');
INSERT INTO `posts` VALUES (47, 10, 'tdxfcghv', '6.jpg', '2022-08-02 15:42:30');
INSERT INTO `posts` VALUES (48, 10, '1.jpg', '7.jpg', '2022-08-03 12:21:13');
INSERT INTO `posts` VALUES (49, 10, '2.jpg', '8.jpg', '2022-08-03 12:30:25');
INSERT INTO `posts` VALUES (50, 10, 'ddddddd', '9.jpg', '2022-08-03 12:34:42');
INSERT INTO `posts` VALUES (51, 10, '222222222', '10.jpg', '2022-08-03 12:34:57');
INSERT INTO `posts` VALUES (54, 10, 'sdsfds', '11.jpg', '2022-08-05 18:46:56');
INSERT INTO `posts` VALUES (55, 10, 'xcvxcvc', '12.jpg', '2022-08-05 18:51:48');

-- ----------------------------
-- Table structure for private_messages
-- ----------------------------
DROP TABLE IF EXISTS `private_messages`;
CREATE TABLE `private_messages`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sender_id` int NULL DEFAULT NULL,
  `receiver_id` int NULL DEFAULT NULL,
  `reply_id` int NULL DEFAULT NULL,
  `forwarded_from_id` int NULL DEFAULT NULL,
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `media` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sent_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of private_messages
-- ----------------------------
INSERT INTO `private_messages` VALUES (1, NULL, 10, 2, NULL, NULL, '1', NULL, '2022-06-07 14:34:57');
INSERT INTO `private_messages` VALUES (2, NULL, 10, 3, NULL, NULL, '2', NULL, '2022-05-31 14:35:01');
INSERT INTO `private_messages` VALUES (4, NULL, 1, 10, NULL, NULL, '4', NULL, '2022-07-09 14:35:05');
INSERT INTO `private_messages` VALUES (5, NULL, 3, 10, NULL, NULL, '5', NULL, '2022-06-04 14:35:09');
INSERT INTO `private_messages` VALUES (6, NULL, 3, 10, NULL, NULL, '6', NULL, '2022-06-20 14:35:12');
INSERT INTO `private_messages` VALUES (7, NULL, 3, 10, NULL, NULL, '7', NULL, '2022-06-17 14:35:15');
INSERT INTO `private_messages` VALUES (8, NULL, 10, 3, NULL, NULL, '8', NULL, '2022-06-13 14:35:20');
INSERT INTO `private_messages` VALUES (10, NULL, 10, 3, NULL, NULL, '9', NULL, '2022-06-11 14:35:47');
INSERT INTO `private_messages` VALUES (11, NULL, 10, 3, NULL, NULL, '10', NULL, '2022-06-29 14:35:51');
INSERT INTO `private_messages` VALUES (12, NULL, 10, 2, NULL, NULL, '11', NULL, '2022-07-14 14:35:56');
INSERT INTO `private_messages` VALUES (13, NULL, 10, 2, NULL, NULL, '12', NULL, '2022-07-11 14:36:01');
INSERT INTO `private_messages` VALUES (14, NULL, 10, 3, NULL, NULL, '13', NULL, '2022-07-24 14:36:05');
INSERT INTO `private_messages` VALUES (15, NULL, 10, 1, NULL, 14, 'ddddddddddddddddddddddddddddddddddddd', NULL, '2022-06-21 14:36:10');
INSERT INTO `private_messages` VALUES (16, NULL, 10, 2, NULL, 3, '15', NULL, '2022-06-17 14:36:15');
INSERT INTO `private_messages` VALUES (17, NULL, 1, 2, NULL, 4, '16', NULL, '2022-06-16 09:48:57');
INSERT INTO `private_messages` VALUES (18, NULL, 10, 1, NULL, NULL, '17', NULL, '2022-06-16 10:00:05');
INSERT INTO `private_messages` VALUES (19, NULL, 10, 1, NULL, NULL, '18', NULL, '2022-06-16 10:00:22');
INSERT INTO `private_messages` VALUES (20, NULL, 10, 1, NULL, NULL, 'wwwwwwwwwwwwwwwwwwwwwwwwww', NULL, '2022-06-19 05:53:12');
INSERT INTO `private_messages` VALUES (21, NULL, 10, 1, NULL, NULL, 'hhhhhhhhhhhh', NULL, '2022-06-19 05:54:19');
INSERT INTO `private_messages` VALUES (22, NULL, 10, 1, 4, NULL, 'ghfhhghgfh', NULL, '2022-06-19 06:18:34');
INSERT INTO `private_messages` VALUES (23, NULL, 10, 1, NULL, 8, 'dfgdfgfgfdgfgdfgfdg', NULL, '2022-06-20 06:22:18');
INSERT INTO `private_messages` VALUES (24, NULL, 1, 2, NULL, 4, '4', NULL, '2022-06-20 06:33:43');
INSERT INTO `private_messages` VALUES (25, NULL, 10, 1, NULL, 1, '4', NULL, '2022-06-20 06:43:42');
INSERT INTO `private_messages` VALUES (26, NULL, 10, 1, NULL, NULL, 'hi reza', NULL, '2022-07-27 09:25:24');
INSERT INTO `private_messages` VALUES (27, NULL, 10, 1, NULL, NULL, 'reeeeezzzzzaaaa', NULL, '2022-08-03 10:40:33');
INSERT INTO `private_messages` VALUES (28, NULL, 1, 10, NULL, NULL, 'hi', NULL, '2022-08-04 14:38:38');
INSERT INTO `private_messages` VALUES (29, NULL, 10, 1, NULL, NULL, 'dfbgfdgdfgfg', NULL, '2022-08-03 15:02:29');
INSERT INTO `private_messages` VALUES (30, NULL, 10, 1, NULL, NULL, 'dfbgfdgdfgfgdfgfdgfdgdf', NULL, '2022-08-03 15:02:31');
INSERT INTO `private_messages` VALUES (31, NULL, 10, 1, NULL, NULL, 'dthgfgh', NULL, '2022-08-03 15:04:45');
INSERT INTO `private_messages` VALUES (32, NULL, 10, 1, NULL, NULL, 'fhfghgfh', NULL, '2022-08-03 15:04:47');
INSERT INTO `private_messages` VALUES (33, NULL, 10, 1, NULL, NULL, 'fghfgghgf', NULL, '2022-08-03 15:04:49');
INSERT INTO `private_messages` VALUES (34, NULL, 10, 1, NULL, NULL, 'fghfghfgh', NULL, '2022-08-03 15:04:51');

-- ----------------------------
-- Table structure for profile_pictures
-- ----------------------------
DROP TABLE IF EXISTS `profile_pictures`;
CREATE TABLE `profile_pictures`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `account_id` int NULL DEFAULT NULL,
  `image_address` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `sent_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of profile_pictures
-- ----------------------------
INSERT INTO `profile_pictures` VALUES (4, 10, 'agyvjh', '2022-06-18 14:34:42');
INSERT INTO `profile_pictures` VALUES (7, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (8, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (9, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (10, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (14, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (15, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (16, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (17, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (18, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (19, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (20, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (21, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (22, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (23, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (24, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (25, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (26, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (27, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (28, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (29, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (30, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (31, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (32, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (33, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (34, 10, 'zzzz', '2022-08-01 16:57:16');
INSERT INTO `profile_pictures` VALUES (35, 10, 'zzzz', '2022-08-01 16:57:16');

-- ----------------------------
-- Table structure for reactions
-- ----------------------------
DROP TABLE IF EXISTS `reactions`;
CREATE TABLE `reactions`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `sender_id` int NULL DEFAULT NULL,
  `content_type` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content_id` int NULL DEFAULT NULL,
  `reaction` int NULL DEFAULT NULL,
  `reacted_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of reactions
-- ----------------------------
INSERT INTO `reactions` VALUES (64, 10, 'post', 9, 9, '2022-06-16 07:27:58');
INSERT INTO `reactions` VALUES (67, 10, 'post', 6, 3, '2022-06-16 07:29:22');
INSERT INTO `reactions` VALUES (69, 10, 'post', 10, 2, '2022-06-16 07:30:04');
INSERT INTO `reactions` VALUES (73, 10, 'comment', 4, 1, '2022-06-16 07:39:16');
INSERT INTO `reactions` VALUES (74, 10, 'post', 16, 7, '2022-06-16 07:51:25');
INSERT INTO `reactions` VALUES (75, 10, 'comment', 6, 6, '2022-06-16 07:51:41');
INSERT INTO `reactions` VALUES (77, 10, 'private message', 4, 2, '2022-06-16 08:13:55');
INSERT INTO `reactions` VALUES (78, 10, 'group message', 7, 1, '2022-06-16 08:39:30');
INSERT INTO `reactions` VALUES (79, 10, 'group message', 11, 6, '2022-06-16 08:56:50');
INSERT INTO `reactions` VALUES (80, 10, 'comment', 15, 2, '2022-08-01 15:31:39');
INSERT INTO `reactions` VALUES (83, 10, 'comment', 17, 3, '2022-08-01 17:48:04');
INSERT INTO `reactions` VALUES (85, 10, 'comment', 19, 3, '2022-08-02 10:37:44');
INSERT INTO `reactions` VALUES (86, 4, 'post', 9, 2, '2022-08-04 13:27:39');
INSERT INTO `reactions` VALUES (87, 5, 'post', 9, 1, '2022-08-04 13:27:46');

-- ----------------------------
-- Table structure for requests
-- ----------------------------
DROP TABLE IF EXISTS `requests`;
CREATE TABLE `requests`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `from` int NULL DEFAULT NULL,
  `to` int NULL DEFAULT NULL,
  `sent_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of requests
-- ----------------------------
INSERT INTO `requests` VALUES (1, 10, 13, '2022-06-29 15:20:04');
INSERT INTO `requests` VALUES (11, 14, 10, '2022-08-02 14:16:04');
INSERT INTO `requests` VALUES (12, 15, 10, '2022-08-02 14:16:06');
INSERT INTO `requests` VALUES (13, 16, 10, '2022-08-02 14:16:08');
INSERT INTO `requests` VALUES (14, 17, 10, '2022-08-02 14:16:17');

-- ----------------------------
-- Table structure for searched_accounts
-- ----------------------------
DROP TABLE IF EXISTS `searched_accounts`;
CREATE TABLE `searched_accounts`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `searcher_id` int NULL DEFAULT NULL,
  `searched_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of searched_accounts
-- ----------------------------
INSERT INTO `searched_accounts` VALUES (9, 10, 2);
INSERT INTO `searched_accounts` VALUES (10, 10, 3);
INSERT INTO `searched_accounts` VALUES (12, 10, 5);

-- ----------------------------
-- Table structure for views
-- ----------------------------
DROP TABLE IF EXISTS `views`;
CREATE TABLE `views`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `message_type` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `message_id` int NULL DEFAULT NULL,
  `account_id` int NULL DEFAULT NULL,
  `seen_at` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of views
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
