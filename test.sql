/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 100417
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 100417
 File Encoding         : 65001

 Date: 06/08/2022 00:56:04
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
  UNIQUE INDEX `user_name_UNIQUE`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES (1, 0, 0, NULL, 'reza', 'rezaei', 'reza', NULL, 'reza@gmail.com', '2022-07-26', '1', 'xbsdg', 'xfbjxn', 'dbfngm', '2022-06-28 14:47:27', '2022-07-14 14:49:40');
INSERT INTO `accounts` VALUES (2, 0, 0, NULL, 'ali', 'alinia', 'alip', NULL, 'ali1@gmail.com', '2022-07-06', '1', 'fdbgzfd', 'vxbncm', 'fxbngcm', '2022-07-19 14:47:30', '2022-07-28 14:49:35');
INSERT INTO `accounts` VALUES (3, 0, 0, NULL, 'alireza', 'rezaei', 'mamad', NULL, 'reza@gmail.com', '2022-07-10', '1', 'fbb', 'vxcbcvnb', 'xbncb', '2022-07-03 14:47:35', '2022-07-04 14:49:31');
INSERT INTO `accounts` VALUES (4, 0, 0, NULL, 'ahmad', 'alinia', 'arya', NULL, 'ali1@gmail.com', '2022-06-30', '1', 'fb', 'vcbcb', 'xbnvc', '2022-07-19 14:47:40', '2022-07-19 14:49:24');
INSERT INTO `accounts` VALUES (5, 0, 0, NULL, 'hassan', 'hassani', 'parsaaaa', NULL, 'kami@yahoo.com', '2022-07-05', '1', 'bxcb', 'xvcv b', 'vn', '2022-07-22 14:47:46', '2022-07-10 14:49:19');
INSERT INTO `accounts` VALUES (6, 0, 0, NULL, 'aa', 'bb', 'arta', NULL, 'kkkk@gmail.com', '2022-11-23', '1', 'dbxcb', 'bxf', 'uuyhbjg', '2022-07-30 14:47:49', '2022-07-11 14:49:15');
INSERT INTO `accounts` VALUES (7, 0, 0, NULL, 'aaa', 'qqqq', 'pourya', NULL, 'kjh@gmail.com', '2022-01-05', '1', 'dxbbxcb', 'vcbvb', 'rehtnr', '2022-07-24 14:47:54', '2022-07-23 14:49:12');
INSERT INTO `accounts` VALUES (8, 0, 0, NULL, 'DLCSN, ', 'ADJCBNL', 'majid', NULL, 'kami@gmail.com', '2022-07-16', '1', 'bbx ', 'vcxbv', 'thsdndnhd', '2022-07-23 14:47:58', '2022-07-10 14:49:08');
INSERT INTO `accounts` VALUES (9, 0, 0, NULL, 'DCLJN', 'SDCKN', 'nilofar', NULL, 'kami@mail.com', '2022-07-10', '1', 'cbxc b', 'vcv bx', 'gnfxhm', '2022-07-16 14:48:02', '2022-07-23 14:49:04');
INSERT INTO `accounts` VALUES (10, 0, 0, NULL, 'parsa', 'ecwv', 'parsa', '', 'parsa@gmail.com', '1970-01-01', '1', 'who is your first school teacher?', 'fathi', 'assdc', '2022-06-07 11:00:18', '2022-06-07 11:00:15');
INSERT INTO `accounts` VALUES (11, 0, 0, NULL, 'safsghdg', 'esgdgf', 'atena', NULL, 'dsfdbgnmjh.gamil', '2022-07-23', '1', 'ccb', 'hdgjh,bj', 'xnjmku', '2022-07-10 14:48:07', '2022-07-19 14:49:00');
INSERT INTO `accounts` VALUES (12, 0, 0, NULL, '11111', '11111', 'fatemeh', NULL, 'kami@hotmail.com', '2022-07-04', '1', 'xcbfb', 'fcgn', 'xfgnfmj', '2022-07-17 14:48:11', '2022-07-19 14:48:46');
INSERT INTO `accounts` VALUES (13, 0, 0, NULL, 'DSLMD', ';dlcmklsn', 'melika', NULL, 'qef.gamil.com', '2022-07-08', '1', 'dxbxc xcb', 'cxcv', 'urtjyk', '2022-07-30 14:48:15', '2022-07-22 14:48:51');
INSERT INTO `accounts` VALUES (14, 0, 0, NULL, '231', '321', '32p1', '321', '321', '2022-07-20', '1', 'xcb xc ', 'xbccvn', 'dfnxgm', '2022-07-17 14:48:18', '0000-00-00 00:00:00');
INSERT INTO `accounts` VALUES (15, 0, 0, NULL, '1321', '321', '11111', '321', '321', '2022-07-01', '1', 'xc xcbdb', 'zvdbxn', 'fdngf,', '2022-07-23 14:48:26', '2022-07-20 14:48:55');
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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blocks
-- ----------------------------
INSERT INTO `blocks` VALUES (13, 10, 11, '2022-08-02 13:33:33');
INSERT INTO `blocks` VALUES (14, 10, 12, '2022-08-02 13:33:34');
INSERT INTO `blocks` VALUES (15, 10, 13, '2022-08-02 13:33:37');

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
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 142 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of followings
-- ----------------------------
INSERT INTO `followings` VALUES (4, 1, 4, '2022-07-27 13:02:26');
INSERT INTO `followings` VALUES (5, 2, 4, '2022-07-27 13:02:38');
INSERT INTO `followings` VALUES (6, 3, 5, '2022-07-27 13:02:53');
INSERT INTO `followings` VALUES (7, 6, 1, '2022-07-27 13:03:05');
INSERT INTO `followings` VALUES (8, 6, 2, '2022-07-27 13:03:11');
INSERT INTO `followings` VALUES (9, 7, 1, '2022-07-27 13:03:24');
INSERT INTO `followings` VALUES (43, 4, 10, '2022-07-31 14:52:39');
INSERT INTO `followings` VALUES (46, 1, 10, '2022-08-01 17:38:44');
INSERT INTO `followings` VALUES (47, 2, 10, '2022-08-01 17:38:55');
INSERT INTO `followings` VALUES (48, 3, 10, '2022-08-01 17:39:20');
INSERT INTO `followings` VALUES (55, 10, 1, '2022-08-02 11:32:17');
INSERT INTO `followings` VALUES (56, 10, 2, '2022-08-02 11:32:20');
INSERT INTO `followings` VALUES (57, 10, 3, '2022-08-02 11:32:23');
INSERT INTO `followings` VALUES (58, 10, 4, '2022-08-02 11:32:25');
INSERT INTO `followings` VALUES (59, 1, 10, '2022-08-02 14:36:33');
INSERT INTO `followings` VALUES (60, 2, 10, '2022-08-02 14:36:35');
INSERT INTO `followings` VALUES (61, 3, 10, '2022-08-02 14:36:36');
INSERT INTO `followings` VALUES (62, 4, 10, '2022-08-02 14:36:37');
INSERT INTO `followings` VALUES (63, 5, 10, '2022-08-02 14:36:38');
INSERT INTO `followings` VALUES (64, 10, 6, '2022-08-02 14:36:41');
INSERT INTO `followings` VALUES (65, 10, 7, '2022-08-02 14:36:42');
INSERT INTO `followings` VALUES (66, 10, 8, '2022-08-02 14:36:43');
INSERT INTO `followings` VALUES (67, 10, 9, '2022-08-02 14:36:43');
INSERT INTO `followings` VALUES (68, 10, 11, '2022-08-02 14:36:44');
INSERT INTO `followings` VALUES (69, 10, 12, '2022-08-02 14:36:48');
INSERT INTO `followings` VALUES (70, 7, 5, '2022-08-02 14:37:29');
INSERT INTO `followings` VALUES (71, 8, 5, '2022-08-02 14:37:34');
INSERT INTO `followings` VALUES (72, 9, 5, '2022-08-02 14:37:42');
INSERT INTO `followings` VALUES (73, 10, 5, '2022-08-03 10:38:15');
INSERT INTO `followings` VALUES (74, 10, 5, '2022-08-03 10:38:15');
INSERT INTO `followings` VALUES (75, 2, 10, '2022-08-05 17:49:36');
INSERT INTO `followings` VALUES (76, 2, 10, '2022-08-05 17:49:37');
INSERT INTO `followings` VALUES (77, 2, 10, '2022-08-05 17:49:42');
INSERT INTO `followings` VALUES (78, 2, 10, '2022-08-05 17:49:42');
INSERT INTO `followings` VALUES (79, 2, 10, '2022-08-05 17:49:43');
INSERT INTO `followings` VALUES (80, 2, 10, '2022-08-05 17:49:43');
INSERT INTO `followings` VALUES (81, 2, 10, '2022-08-05 17:49:44');
INSERT INTO `followings` VALUES (82, 2, 10, '2022-08-05 17:49:44');
INSERT INTO `followings` VALUES (83, 2, 10, '2022-08-05 17:49:45');
INSERT INTO `followings` VALUES (84, 2, 10, '2022-08-05 17:49:45');
INSERT INTO `followings` VALUES (85, 2, 10, '2022-08-05 17:49:46');
INSERT INTO `followings` VALUES (86, 2, 10, '2022-08-05 17:49:46');
INSERT INTO `followings` VALUES (87, 2, 10, '2022-08-05 17:49:46');
INSERT INTO `followings` VALUES (88, 2, 10, '2022-08-05 17:49:46');
INSERT INTO `followings` VALUES (89, 2, 10, '2022-08-05 17:49:47');
INSERT INTO `followings` VALUES (90, 2, 10, '2022-08-05 17:49:47');
INSERT INTO `followings` VALUES (91, 2, 10, '2022-08-05 17:49:55');
INSERT INTO `followings` VALUES (92, 2, 10, '2022-08-05 17:49:55');
INSERT INTO `followings` VALUES (93, 2, 10, '2022-08-05 17:49:56');
INSERT INTO `followings` VALUES (94, 2, 10, '2022-08-05 17:49:56');
INSERT INTO `followings` VALUES (95, 2, 10, '2022-08-05 17:49:57');
INSERT INTO `followings` VALUES (96, 2, 10, '2022-08-05 17:49:57');
INSERT INTO `followings` VALUES (97, 2, 10, '2022-08-05 17:49:57');
INSERT INTO `followings` VALUES (98, 2, 10, '2022-08-05 17:49:57');
INSERT INTO `followings` VALUES (99, 2, 10, '2022-08-05 17:49:59');
INSERT INTO `followings` VALUES (100, 2, 10, '2022-08-05 17:49:59');
INSERT INTO `followings` VALUES (101, 2, 10, '2022-08-05 17:50:00');
INSERT INTO `followings` VALUES (102, 2, 10, '2022-08-05 17:50:00');
INSERT INTO `followings` VALUES (103, 2, 10, '2022-08-05 17:50:01');
INSERT INTO `followings` VALUES (104, 2, 10, '2022-08-05 17:50:01');
INSERT INTO `followings` VALUES (105, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (106, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (107, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (108, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (109, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (110, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (111, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (112, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (113, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (114, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (115, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (116, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (117, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (118, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (119, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (120, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (121, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (122, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (123, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (124, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (125, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (126, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (127, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (128, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (129, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (130, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (131, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (132, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (133, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (134, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (135, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (136, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (137, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (138, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (139, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (140, 10, 2, '2022-08-05 17:58:26');
INSERT INTO `followings` VALUES (141, 10, 2, '2022-08-05 17:58:26');

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
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES (2, 8, 'group 2', 'group 2', '2.jpg', NULL, '2022-06-07 10:18:45');
INSERT INTO `groups` VALUES (5, 3, 'group 5', 'group 5', '5.jpg', NULL, '2022-06-07 10:18:45');
INSERT INTO `groups` VALUES (7, 10, 'g2', 'g2', 'g2', 'g2', '2022-06-09 08:57:17');
INSERT INTO `groups` VALUES (8, 10, 'g3', 'g3', 'g3', 'g3', '2022-06-09 08:58:05');
INSERT INTO `groups` VALUES (10, 10, 'g5', 'g5', 'g5', 'g5', '2022-06-09 09:02:37');
INSERT INTO `groups` VALUES (11, 10, 'g6', 'g6', 'g6', 'g6', '2022-06-09 09:03:52');
INSERT INTO `groups` VALUES (12, 10, 'g7', 'g7', 'g7', 'g7', '2022-06-09 09:28:24');
INSERT INTO `groups` VALUES (13, 10, 'g10', 'g10', 'g10', 'g10', '2022-06-16 09:03:41');
INSERT INTO `groups` VALUES (18, 10, 'g11', 'g11bio', 'g11pic', 'g11link', '2022-08-04 12:27:52');
INSERT INTO `groups` VALUES (19, 3, 'g12', 'g12bio', 'g12pic', 'g12link', '2022-08-04 12:28:11');

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
INSERT INTO `posts` VALUES (9, 10, 'adsghd', 'c://:test/1.jpg', '2022-06-16 14:16:26');
INSERT INTO `posts` VALUES (10, 10, 'post 6', '', '2022-06-20 14:16:29');
INSERT INTO `posts` VALUES (12, 10, 'post 8', 'c://:test/1.jpg', '2022-06-18 14:16:35');
INSERT INTO `posts` VALUES (15, 2, 'wdaes', '', '2022-05-29 14:16:40');
INSERT INTO `posts` VALUES (16, 2, 'others test post 1', '', '2022-06-15 14:16:22');
INSERT INTO `posts` VALUES (21, 2, 'egrhtjf', '', '2022-06-09 09:47:52');
INSERT INTO `posts` VALUES (22, 2, 'afesgrhd', '', '2022-06-09 09:47:54');
INSERT INTO `posts` VALUES (23, 2, 'safvdbgf', '', '2022-06-09 09:47:58');
INSERT INTO `posts` VALUES (24, 2, 'fasdgfgn', '', '2022-06-09 09:48:03');
INSERT INTO `posts` VALUES (25, 2, 'safdgfhg', '', '2022-06-09 09:48:05');
INSERT INTO `posts` VALUES (26, 11, 'sczvdxbfg', '', '2022-06-09 09:48:06');
INSERT INTO `posts` VALUES (27, 11, 'CSzvdxbf', '', '2022-06-09 09:48:06');
INSERT INTO `posts` VALUES (28, 11, 'sdfdgf', '', '2022-06-09 09:48:07');
INSERT INTO `posts` VALUES (29, 11, 'xc', '', '2022-06-09 09:48:08');
INSERT INTO `posts` VALUES (30, 11, 'dvsbgfd', '', '2022-06-09 09:48:10');
INSERT INTO `posts` VALUES (31, 13, 'sdb', 'regsfvreg', '2022-06-09 09:48:11');
INSERT INTO `posts` VALUES (32, 13, 'afesgr', 'ncgn', '2022-06-09 09:48:11');
INSERT INTO `posts` VALUES (33, 13, 'fegr', 'dfgn', '2022-06-09 09:48:12');
INSERT INTO `posts` VALUES (34, 13, 'fesgr', 'dfbs', '2022-06-09 09:48:12');
INSERT INTO `posts` VALUES (35, 13, 'aesrhdr', 'dfbberr', '2022-06-09 09:48:13');
INSERT INTO `posts` VALUES (36, 13, 'SEy', 'srvsrger', '2022-06-09 09:48:22');
INSERT INTO `posts` VALUES (43, 10, 'dfvzsdv', 'null', '2022-08-02 15:14:25');
INSERT INTO `posts` VALUES (44, 10, 'ghjbkn', 'c://:test/1.png', '2022-08-02 15:42:25');
INSERT INTO `posts` VALUES (45, 10, 'ghvjbn,', 'c://:test/2.jpg', '2022-08-02 15:42:27');
INSERT INTO `posts` VALUES (46, 10, 'po;ljhkj', 'c://:test/3.jpeg', '2022-08-02 15:42:28');
INSERT INTO `posts` VALUES (47, 10, 'tdxfcghv', 'c://:test/4.png', '2022-08-02 15:42:30');
INSERT INTO `posts` VALUES (48, 10, '1.jpg', 'sdfsdf', '2022-08-03 12:21:13');
INSERT INTO `posts` VALUES (49, 10, '2.jpg', 'fdfdsfsd', '2022-08-03 12:30:25');
INSERT INTO `posts` VALUES (50, 10, 'ddddddd', '1.jpg', '2022-08-03 12:34:42');
INSERT INTO `posts` VALUES (51, 10, '222222222', '333.png', '2022-08-03 12:34:57');
INSERT INTO `posts` VALUES (54, 10, 'sdsfds', '9507362357700.png', '2022-08-05 18:46:56');
INSERT INTO `posts` VALUES (55, 10, 'xcvxcvc', '9799619507800.png', '2022-08-05 18:51:48');

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
