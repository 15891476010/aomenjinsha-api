/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.2.18
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 192.168.2.18:3306
 Source Schema         : usdt_pg

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 17/05/2025 02:14:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gen_config
-- ----------------------------
DROP TABLE IF EXISTS `gen_config`;
CREATE TABLE `gen_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `table_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '表名',
  `module_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模块名',
  `package_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '包名',
  `business_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '业务名',
  `entity_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实体类名',
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者',
  `parent_menu_id` bigint NULL DEFAULT NULL COMMENT '上级菜单ID，对应sys_menu的id ',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` bit(1) NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tablename`(`table_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '代码生成基础配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_config
-- ----------------------------
INSERT INTO `gen_config` VALUES (1, 'sys_config', 'system', 'com.youlai.boot', '系统配置', 'SysConfig', 'youlaitech', NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11', b'0');
INSERT INTO `gen_config` VALUES (2, 'sys_form_temp', 'system', 'com.youlai.boot', '表单模板', 'SysFormTemp', 'MrZhang', NULL, '2025-05-07 15:29:29', '2025-05-07 15:32:39', b'0');
INSERT INTO `gen_config` VALUES (3, 'sys_attachment_type', 'system', 'com.youlai.boot', '附件分类列管理', 'SysAttachmentType', 'MrZhang', NULL, '2025-05-10 18:10:55', '2025-05-10 18:22:14', b'0');
INSERT INTO `gen_config` VALUES (4, 'sys_attachment', 'system', 'com.youlai.boot', '附件管理', 'Attachment', 'MrZhang', NULL, '2025-05-13 07:07:27', '2025-05-13 13:06:51', b'0');
INSERT INTO `gen_config` VALUES (5, 'sys_group', 'system', 'com.youlai.boot', '组合数据分类', 'SysGroup', 'MrZhang', NULL, '2025-05-15 00:13:40', '2025-05-15 00:13:40', b'0');
INSERT INTO `gen_config` VALUES (6, 'sys_group_data', 'system', 'com.youlai.boot', '组合分类数据', 'SysGroupData', 'MrZhang', NULL, '2025-05-15 00:48:48', '2025-05-15 00:48:48', b'0');

-- ----------------------------
-- Table structure for gen_field_config
-- ----------------------------
DROP TABLE IF EXISTS `gen_field_config`;
CREATE TABLE `gen_field_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `config_id` bigint NOT NULL COMMENT '关联的配置ID',
  `column_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `column_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `column_length` int NULL DEFAULT NULL,
  `field_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字段名称',
  `field_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字段类型',
  `field_sort` int NULL DEFAULT NULL COMMENT '字段排序',
  `field_comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字段描述',
  `max_length` int NULL DEFAULT NULL,
  `is_required` tinyint(1) NULL DEFAULT NULL COMMENT '是否必填',
  `is_show_in_list` tinyint(1) NULL DEFAULT 0 COMMENT '是否在列表显示',
  `is_show_in_form` tinyint(1) NULL DEFAULT 0 COMMENT '是否在表单显示',
  `is_show_in_query` tinyint(1) NULL DEFAULT 0 COMMENT '是否在查询条件显示',
  `query_type` tinyint NULL DEFAULT NULL COMMENT '查询方式',
  `form_type` tinyint NULL DEFAULT NULL COMMENT '表单类型',
  `dict_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典类型',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `config_id`(`config_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '代码生成字段配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_field_config
-- ----------------------------
INSERT INTO `gen_field_config` VALUES (1, 1, 'id', 'bigint', NULL, 'id', 'Long', 1, '', NULL, 1, 1, 1, 0, 1, 1, NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11');
INSERT INTO `gen_field_config` VALUES (2, 1, 'config_name', 'varchar', NULL, 'configName', 'String', 2, '配置名称', 50, 1, 1, 1, 0, 1, 1, NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11');
INSERT INTO `gen_field_config` VALUES (3, 1, 'config_key', 'varchar', NULL, 'configKey', 'String', 3, '配置key', 50, 1, 1, 1, 0, 1, 1, NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11');
INSERT INTO `gen_field_config` VALUES (4, 1, 'config_value', 'varchar', NULL, 'configValue', 'String', 4, '配置值', 100, 1, 1, 1, 0, 1, 1, NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11');
INSERT INTO `gen_field_config` VALUES (5, 1, 'remark', 'varchar', NULL, 'remark', 'String', 5, '备注', 255, 0, 1, 1, 0, 1, 1, NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11');
INSERT INTO `gen_field_config` VALUES (6, 1, 'form_id', 'int', NULL, 'formId', 'Integer', 6, '表单对应id', NULL, 1, 1, 1, 0, 1, 1, NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11');
INSERT INTO `gen_field_config` VALUES (7, 1, 'create_time', 'datetime', NULL, 'createTime', 'LocalDateTime', 7, '创建时间', NULL, 0, 1, 1, 0, 1, 9, NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11');
INSERT INTO `gen_field_config` VALUES (8, 1, 'create_by', 'bigint', NULL, 'createBy', 'Long', 8, '创建人ID', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11');
INSERT INTO `gen_field_config` VALUES (9, 1, 'update_time', 'datetime', NULL, 'updateTime', 'LocalDateTime', 9, '更新时间', NULL, 0, 1, 1, 0, 1, 9, NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11');
INSERT INTO `gen_field_config` VALUES (10, 1, 'update_by', 'bigint', NULL, 'updateBy', 'Long', 10, '更新人ID', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11');
INSERT INTO `gen_field_config` VALUES (11, 1, 'is_deleted', 'tinyint', NULL, 'isDeleted', 'Integer', 11, '逻辑删除标识(0-未删除 1-已删除)', NULL, 1, 1, 1, 0, 1, 1, NULL, '2025-05-05 22:47:11', '2025-05-05 22:47:11');
INSERT INTO `gen_field_config` VALUES (12, 2, 'id', 'int', NULL, 'id', 'Integer', 1, '表单模板id', NULL, 1, 1, 1, 1, 1, 1, NULL, '2025-05-07 15:29:29', '2025-05-07 15:32:39');
INSERT INTO `gen_field_config` VALUES (13, 2, 'name', 'varchar', NULL, 'name', 'String', 2, '表单名称', 500, 1, 1, 1, 1, 2, 1, NULL, '2025-05-07 15:29:29', '2025-05-07 15:32:39');
INSERT INTO `gen_field_config` VALUES (14, 2, 'info', 'varchar', NULL, 'info', 'String', 3, '表单简介', 500, 1, 1, 1, 0, 1, 1, NULL, '2025-05-07 15:29:29', '2025-05-07 15:32:39');
INSERT INTO `gen_field_config` VALUES (15, 2, 'content', 'text', NULL, 'content', 'String', 4, '表单内容', 65535, 1, 1, 1, 0, 1, 7, NULL, '2025-05-07 15:29:29', '2025-05-07 15:32:39');
INSERT INTO `gen_field_config` VALUES (16, 2, 'create_time', 'timestamp', NULL, 'createTime', NULL, 5, '创建时间', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-07 15:29:29', '2025-05-07 15:32:39');
INSERT INTO `gen_field_config` VALUES (17, 2, 'update_time', 'timestamp', NULL, 'updateTime', NULL, 6, '更新时间', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-07 15:29:29', '2025-05-07 15:32:39');
INSERT INTO `gen_field_config` VALUES (18, 3, 'id', 'int', NULL, 'id', 'Integer', 1, '自增id', NULL, 0, 1, 1, 1, 1, 1, NULL, '2025-05-10 18:10:55', '2025-05-10 18:22:14');
INSERT INTO `gen_field_config` VALUES (19, 3, 'name', 'varchar', NULL, 'name', 'String', 2, '文件分类名称', 255, 0, 1, 1, 1, 2, 1, NULL, '2025-05-10 18:10:55', '2025-05-10 18:22:14');
INSERT INTO `gen_field_config` VALUES (20, 3, 'common', 'varchar', NULL, 'common', 'String', 3, '备注', 255, 0, 1, 1, 1, 2, 1, NULL, '2025-05-10 18:10:55', '2025-05-10 18:22:14');
INSERT INTO `gen_field_config` VALUES (21, 3, 'create_time', 'timestamp', NULL, 'createTime', NULL, 4, '创建时间', NULL, 0, 1, 1, 1, 1, 9, NULL, '2025-05-10 18:10:55', '2025-05-10 18:22:14');
INSERT INTO `gen_field_config` VALUES (22, 3, 'update_time', 'timestamp', NULL, 'updateTime', NULL, 5, '更新时间', NULL, 0, 1, 1, 1, 1, 9, NULL, '2025-05-10 18:10:55', '2025-05-10 18:22:14');
INSERT INTO `gen_field_config` VALUES (23, 4, 'att_id', 'int', NULL, 'attId', 'Integer', 1, '', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-13 07:07:28', '2025-05-13 13:06:51');
INSERT INTO `gen_field_config` VALUES (24, 4, 'name', 'varchar', NULL, 'name', 'String', 2, '附件名称', 100, 0, 1, 1, 0, 1, 1, NULL, '2025-05-13 07:07:28', '2025-05-13 13:06:51');
INSERT INTO `gen_field_config` VALUES (25, 4, 'att_dir', 'varchar', NULL, 'attDir', 'String', 3, '附件路径', 200, 0, 1, 1, 0, 1, 1, NULL, '2025-05-13 07:07:28', '2025-05-13 13:06:51');
INSERT INTO `gen_field_config` VALUES (26, 4, 'satt_dir', 'varchar', NULL, 'sattDir', 'String', 4, '压缩图片路径', 200, 0, 1, 1, 0, 1, 1, NULL, '2025-05-13 07:07:28', '2025-05-13 13:06:52');
INSERT INTO `gen_field_config` VALUES (27, 4, 'att_size', 'char', NULL, 'attSize', 'String', 5, '附件大小', 30, 0, 1, 1, 0, 1, 1, NULL, '2025-05-13 07:07:28', '2025-05-13 13:06:52');
INSERT INTO `gen_field_config` VALUES (28, 4, 'att_type', 'char', NULL, 'attType', 'String', 6, '附件类型', 30, 0, 1, 1, 0, 1, 1, NULL, '2025-05-13 07:07:28', '2025-05-13 13:06:52');
INSERT INTO `gen_field_config` VALUES (29, 4, 'pid', 'int', NULL, 'pid', 'Integer', 7, '分类ID', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-13 07:07:28', '2025-05-13 13:06:52');
INSERT INTO `gen_field_config` VALUES (30, 4, 'image_type', 'tinyint', NULL, 'imageType', 'Integer', 8, '图片上传类型', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-13 07:07:28', '2025-05-13 13:06:52');
INSERT INTO `gen_field_config` VALUES (31, 4, 'create_time', 'timestamp', NULL, 'createTime', NULL, 9, '创建时间', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-13 07:07:28', '2025-05-13 13:06:52');
INSERT INTO `gen_field_config` VALUES (32, 4, 'update_time', 'timestamp', NULL, 'updateTime', NULL, 10, '更新时间', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-13 07:07:28', '2025-05-13 13:06:52');
INSERT INTO `gen_field_config` VALUES (33, 5, 'id', 'int', NULL, 'id', 'Integer', 1, '组合数据ID', NULL, 1, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:13:41', '2025-05-15 00:13:41');
INSERT INTO `gen_field_config` VALUES (34, 5, 'name', 'varchar', NULL, 'name', 'String', 2, '数据组名称', 50, 1, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:13:41', '2025-05-15 00:13:41');
INSERT INTO `gen_field_config` VALUES (35, 5, 'info', 'varchar', NULL, 'info', 'String', 3, '简介', 256, 1, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:13:41', '2025-05-15 00:13:41');
INSERT INTO `gen_field_config` VALUES (36, 5, 'form_id', 'int', NULL, 'formId', 'Integer', 4, 'form 表单 id', NULL, 1, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:13:41', '2025-05-15 00:13:41');
INSERT INTO `gen_field_config` VALUES (37, 5, 'create_time', 'timestamp', NULL, 'createTime', NULL, 5, '创建时间', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:13:41', '2025-05-15 00:13:41');
INSERT INTO `gen_field_config` VALUES (38, 5, 'update_time', 'timestamp', NULL, 'updateTime', NULL, 6, '更新时间', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:13:41', '2025-05-15 00:13:41');
INSERT INTO `gen_field_config` VALUES (39, 6, 'id', 'int', NULL, 'id', 'Integer', 1, '组合数据详情ID', NULL, 1, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:48:49', '2025-05-15 00:48:49');
INSERT INTO `gen_field_config` VALUES (40, 6, 'gid', 'int', NULL, 'gid', 'Integer', 2, '对应的数据组id', NULL, 1, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:48:49', '2025-05-15 00:48:49');
INSERT INTO `gen_field_config` VALUES (41, 6, 'value', 'text', NULL, 'value', 'String', 3, '数据组对应的数据值（json数据）', 65535, 1, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:48:49', '2025-05-15 00:48:49');
INSERT INTO `gen_field_config` VALUES (42, 6, 'sort', 'int', NULL, 'sort', 'Integer', 4, '数据排序', NULL, 1, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:48:49', '2025-05-15 00:48:49');
INSERT INTO `gen_field_config` VALUES (43, 6, 'status', 'tinyint', NULL, 'status', 'Integer', 5, '状态（1：开启；2：关闭；）', NULL, 1, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:48:49', '2025-05-15 00:48:49');
INSERT INTO `gen_field_config` VALUES (44, 6, 'create_time', 'timestamp', NULL, 'createTime', NULL, 6, '创建时间', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:48:49', '2025-05-15 00:48:49');
INSERT INTO `gen_field_config` VALUES (45, 6, 'update_time', 'timestamp', NULL, 'updateTime', NULL, 7, '更新时间', NULL, 0, 1, 1, 0, 1, 1, NULL, '2025-05-15 00:48:49', '2025-05-15 00:48:49');

-- ----------------------------
-- Table structure for sys_attachment
-- ----------------------------
DROP TABLE IF EXISTS `sys_attachment`;
CREATE TABLE `sys_attachment`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '附件名称',
  `att_dir` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '附件路径',
  `satt_dir` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '压缩图片路径',
  `att_size` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '附件大小',
  `att_type` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '附件类型',
  `pid` int NOT NULL DEFAULT 0 COMMENT '分类ID',
  `image_type` tinyint UNSIGNED NOT NULL DEFAULT 1 COMMENT '图片上传类型',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '附件管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_attachment
-- ----------------------------
INSERT INTO `sys_attachment` VALUES (63, 'default.avif', '', '/usdt/2025/05/14/c52903a8-9776-4d76-8a18-9fe6fcb605b0', '9425', 'avif', 0, 5, '2025-05-14 20:58:57', '2025-05-14 20:58:57');
INSERT INTO `sys_attachment` VALUES (64, '1921631731896606721.png', '', '/usdt/2025/05/14/3d3fe16a-0d6e-44b5-b7ca-1b6e5eb67321', '36197', 'png', 0, 5, '2025-05-14 21:25:46', '2025-05-14 21:25:46');
INSERT INTO `sys_attachment` VALUES (65, 'bg1.jpg', '', '/usdt/2025/05/14/46b8431a-8547-487b-ad24-1b389fae7e6d', '107240', 'jpeg', 0, 5, '2025-05-14 21:27:14', '2025-05-14 21:27:14');
INSERT INTO `sys_attachment` VALUES (66, 'logo.png', '', '/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', '47329', 'png', 12, 5, '2025-05-14 23:44:37', '2025-05-14 23:44:37');

-- ----------------------------
-- Table structure for sys_category
-- ----------------------------
DROP TABLE IF EXISTS `sys_category`;
CREATE TABLE `sys_category`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `pid` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级ID',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '/0/' COMMENT '路径',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  `type` smallint NULL DEFAULT 1 COMMENT '类型，1 产品分类，2 附件分类，3 文章分类， 4 设置分类， 5 菜单分类，6 配置分类， 7 秒杀配置',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '地址',
  `extra` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '表单配置id',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态, 1正常，0失效',
  `sort` int NOT NULL DEFAULT 99999 COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_category
-- ----------------------------
INSERT INTO `sys_category` VALUES (7, 0, '/0/', '素材管理分类', 2, '素材管理分类', '', 1, 1, '2025-05-12 13:45:31', '2025-05-13 15:14:57');
INSERT INTO `sys_category` VALUES (10, 0, '/0/', '文件上传配置', 6, '文件上传配置', '', 1, 1, '2025-05-13 06:16:08', '2025-05-13 15:15:09');
INSERT INTO `sys_category` VALUES (11, 10, '/0/10/', 'minio配置', 6, 'minio配置', '9', 1, 1, '2025-05-13 06:42:11', '2025-05-13 22:37:34');
INSERT INTO `sys_category` VALUES (12, 7, '/0/7/', 'LOGO', 2, 'LOGO', NULL, 1, 0, '2025-05-13 07:00:39', '2025-05-13 07:00:39');
INSERT INTO `sys_category` VALUES (13, 7, '/0/7/', 'Banner素材', 2, 'Banner素材', NULL, 1, 0, '2025-05-13 07:00:59', '2025-05-13 07:00:59');
INSERT INTO `sys_category` VALUES (14, 7, '/0/7/', '推广海报', 2, '推广海报', NULL, 1, 0, '2025-05-13 07:01:25', '2025-05-13 07:01:25');
INSERT INTO `sys_category` VALUES (15, 0, '/0/', '商城配置', 6, '商城配置', NULL, 1, 0, '2025-05-13 15:00:48', '2025-05-13 15:00:48');
INSERT INTO `sys_category` VALUES (16, 15, '/0/15/', '商城基础配置', 6, '商城基础配置', '11', 1, 0, '2025-05-13 15:01:39', '2025-05-14 23:45:24');
INSERT INTO `sys_category` VALUES (17, 10, '/0/10/', '基础配置', 6, '基础配置', '10', 1, 0, '2025-05-13 15:02:03', '2025-05-13 22:50:09');
INSERT INTO `sys_category` VALUES (20, 7, '/0/', '前端底部tabbar', 2, '', NULL, 1, 0, '2025-05-16 19:17:56', '2025-05-16 19:18:50');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `config_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '配置名称',
  `config_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '配置key',
  `config_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '配置值',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `form_id` int NOT NULL DEFAULT 0 COMMENT '表单对应id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除标识(0-未删除 1-已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '系统限流QPS', 'IP_QPS_THRESHOLD_LIMIT', '100', '单个IP请求的最大每秒查询数（QPS）阈值Key', 0, '2025-05-05 10:04:47', 1, '2025-05-14 03:14:35', 1, 0);
INSERT INTO `sys_config` VALUES (14, 'minioUploadUrl', 'minioUploadUrl', 'https://file.usdtzc.top', NULL, 9, '2025-05-13 22:39:08', NULL, '2025-05-13 22:39:08', NULL, 1);
INSERT INTO `sys_config` VALUES (15, 'minioAccessKey', 'minioAccessKey', 'zhang10867779', NULL, 9, '2025-05-13 22:39:08', NULL, '2025-05-13 22:39:08', NULL, 1);
INSERT INTO `sys_config` VALUES (16, 'minioSecretKey', 'minioSecretKey', 'zhangze123..', NULL, 9, '2025-05-13 22:39:08', NULL, '2025-05-13 22:39:08', NULL, 1);
INSERT INTO `sys_config` VALUES (17, 'minioBucket', 'minioBucket', 'usdt', NULL, 9, '2025-05-13 22:39:08', NULL, '2025-05-13 22:39:08', NULL, 1);
INSERT INTO `sys_config` VALUES (18, 'image_ext_str', 'image_ext_str', 'jpg,jpeg,gif,png,bmp,PNG,JPG,mp4', NULL, 10, '2025-05-13 22:52:26', NULL, '2025-05-14 03:12:52', 1, 1);
INSERT INTO `sys_config` VALUES (19, 'image_max_size', 'image_max_size', '10', NULL, 10, '2025-05-13 22:52:26', NULL, '2025-05-13 22:52:26', NULL, 1);
INSERT INTO `sys_config` VALUES (20, 'file_ext_str', 'file_ext_str', 'zip,doc,docx,xls,xlsx,pdf,mp3,wma,wav,amr,mp4', NULL, 10, '2025-05-13 22:52:26', NULL, '2025-05-13 22:52:26', NULL, 1);
INSERT INTO `sys_config` VALUES (21, 'file_max_size', 'file_max_size', '20', NULL, 10, '2025-05-13 22:52:26', NULL, '2025-05-13 22:52:26', NULL, 1);
INSERT INTO `sys_config` VALUES (22, 'minioUploadUrl', 'minioUploadUrl', 'http://192.168.2.18:9000', NULL, 9, '2025-05-14 01:52:30', NULL, '2025-05-14 01:52:30', NULL, 0);
INSERT INTO `sys_config` VALUES (23, 'minioAccessKey', 'minioAccessKey', 'zhang10867779', NULL, 9, '2025-05-14 01:52:31', NULL, '2025-05-14 01:52:31', NULL, 0);
INSERT INTO `sys_config` VALUES (24, 'minioSecretKey', 'minioSecretKey', 'zhangze123..', NULL, 9, '2025-05-14 01:52:31', NULL, '2025-05-14 01:52:31', NULL, 0);
INSERT INTO `sys_config` VALUES (25, 'minioBucket', 'minioBucket', 'usdt', NULL, 9, '2025-05-14 01:52:31', NULL, '2025-05-14 01:52:31', NULL, 0);
INSERT INTO `sys_config` VALUES (26, 'image_ext_str', 'image_ext_str', 'jpg,jpeg,gif,png,bmp,PNG,JPG,mp4,avif', NULL, 10, '2025-05-14 18:45:15', NULL, '2025-05-14 18:45:15', NULL, 0);
INSERT INTO `sys_config` VALUES (27, 'image_max_size', 'image_max_size', '10', NULL, 10, '2025-05-14 18:45:16', NULL, '2025-05-14 18:45:16', NULL, 0);
INSERT INTO `sys_config` VALUES (28, 'file_ext_str', 'file_ext_str', 'zip,doc,docx,xls,xlsx,pdf,mp3,wma,wav,amr,mp4', NULL, 10, '2025-05-14 18:45:16', NULL, '2025-05-14 18:45:16', NULL, 0);
INSERT INTO `sys_config` VALUES (29, 'file_max_size', 'file_max_size', '20', NULL, 10, '2025-05-14 18:45:16', NULL, '2025-05-14 18:45:16', NULL, 0);
INSERT INTO `sys_config` VALUES (30, 'upload', 'upload', '/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-14 23:54:22', NULL, '2025-05-14 23:54:22', NULL, 1);
INSERT INTO `sys_config` VALUES (31, 'upload', 'upload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-14 23:55:23', NULL, '2025-05-14 23:55:23', NULL, 1);
INSERT INTO `sys_config` VALUES (32, 'upload', 'upload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-14 23:57:00', NULL, '2025-05-14 23:57:00', NULL, 1);
INSERT INTO `sys_config` VALUES (33, 'upload', 'upload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-14 23:59:29', NULL, '2025-05-14 23:59:29', NULL, 1);
INSERT INTO `sys_config` VALUES (34, 'upload', 'upload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-15 00:00:33', NULL, '2025-05-15 00:00:33', NULL, 1);
INSERT INTO `sys_config` VALUES (35, 'upload', 'upload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-15 00:05:58', NULL, '2025-05-15 00:05:58', NULL, 1);
INSERT INTO `sys_config` VALUES (36, 'uoload', 'uoload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-15 00:05:58', NULL, '2025-05-15 00:05:58', NULL, 1);
INSERT INTO `sys_config` VALUES (37, 'upload', 'upload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-15 00:09:04', NULL, '2025-05-15 00:09:04', NULL, 1);
INSERT INTO `sys_config` VALUES (38, 'uoload', 'uoload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-15 00:09:04', NULL, '2025-05-15 00:09:04', NULL, 1);
INSERT INTO `sys_config` VALUES (39, 'upload', 'upload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-15 00:40:44', NULL, '2025-05-15 00:40:44', NULL, 1);
INSERT INTO `sys_config` VALUES (40, 'uoload', 'uoload', '/usdt/2025/05/14/c52903a8-9776-4d76-8a18-9fe6fcb605b0', NULL, 11, '2025-05-15 00:40:45', NULL, '2025-05-15 00:40:45', NULL, 1);
INSERT INTO `sys_config` VALUES (41, 'upload', 'upload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-15 00:42:21', NULL, '2025-05-15 00:42:21', NULL, 1);
INSERT INTO `sys_config` VALUES (42, 'uoload', 'uoload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-15 00:42:21', NULL, '2025-05-15 00:42:21', NULL, 1);
INSERT INTO `sys_config` VALUES (43, 'upload', 'upload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-15 01:41:55', NULL, '2025-05-15 01:41:55', 1, 1);
INSERT INTO `sys_config` VALUES (44, 'uoload', 'uoload', 'http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9', NULL, 11, '2025-05-15 01:41:55', NULL, '2025-05-15 01:41:55', 1, 1);
INSERT INTO `sys_config` VALUES (45, 'Fb2lmao89itpabc', 'Fb2lmao89itpabc', '123123', NULL, 11, '2025-05-15 01:41:55', NULL, '2025-05-15 01:41:55', 1, 1);

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门编号',
  `parent_id` bigint NULL DEFAULT 0 COMMENT '父节点id',
  `tree_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '父节点id路径',
  `sort` smallint NULL DEFAULT 0 COMMENT '显示顺序',
  `status` tinyint NULL DEFAULT 1 COMMENT '状态(1-正常 0-禁用)',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标识(1-已删除 0-未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_code`(`code` ASC) USING BTREE COMMENT '部门编号唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, '有来技术', 'YOULAI', 0, '0', 1, 1, 1, NULL, 1, '2025-05-05 10:04:37', 0);
INSERT INTO `sys_dept` VALUES (2, '研发部门', 'RD001', 1, '0,1', 1, 1, 2, NULL, 2, '2025-05-05 10:04:37', 0);
INSERT INTO `sys_dept` VALUES (3, '测试部门', 'QA001', 1, '0,1', 1, 1, 2, NULL, 2, '2025-05-05 10:04:37', 0);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `dict_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型编码',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型名称',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态(0:正常;1:禁用)',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '是否删除(1-删除，0-未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_dict_code`(`dict_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, 'gender', '性别', 1, NULL, '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1, 0);
INSERT INTO `sys_dict` VALUES (2, 'notice_type', '通知类型', 1, NULL, '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1, 0);
INSERT INTO `sys_dict` VALUES (3, 'notice_level', '通知级别', 1, NULL, '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1, 0);
INSERT INTO `sys_dict` VALUES (4, 'inde_banner', '移动端_主页_轮播图', 1, NULL, '2025-05-05 10:18:09', NULL, '2025-05-05 10:19:15', NULL, 1);
INSERT INTO `sys_dict` VALUES (5, 'sysConfigDict', '系统配置字段字典', 1, NULL, '2025-05-10 19:24:32', NULL, '2025-05-10 19:24:32', NULL, 0);
INSERT INTO `sys_dict` VALUES (6, 'uploadFileConfigDict', '文件上传配置字典', 1, NULL, '2025-05-13 20:36:36', NULL, '2025-05-13 20:36:36', NULL, 0);
INSERT INTO `sys_dict` VALUES (7, 'minioConfigDict', 'minio配置', 1, NULL, '2025-05-13 22:29:22', NULL, '2025-05-13 22:29:22', NULL, 0);

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联字典编码，与sys_dict表中的dict_code对应',
  `value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典项值',
  `label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典项标签',
  `tag_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签类型，用于前端样式展示（如success、warning等）',
  `status` tinyint NULL DEFAULT 0 COMMENT '状态（1-正常，0-禁用）',
  `sort` int NULL DEFAULT 0 COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典项表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES (1, 'gender', '1', '男', 'primary', 1, 1, NULL, '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (2, 'gender', '2', '女', 'danger', 1, 2, NULL, '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (3, 'gender', '0', '保密', 'info', 1, 3, NULL, '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (4, 'notice_type', '1', '系统升级', 'success', 1, 1, '', '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (5, 'notice_type', '2', '系统维护', 'primary', 1, 2, '', '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (6, 'notice_type', '3', '安全警告', 'danger', 1, 3, '', '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (7, 'notice_type', '4', '假期通知', 'success', 1, 4, '', '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (8, 'notice_type', '5', '公司新闻', 'primary', 1, 5, '', '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (9, 'notice_type', '99', '其他', 'info', 1, 99, '', '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (10, 'notice_level', 'L', '低', 'info', 1, 1, '', '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (11, 'notice_level', 'M', '中', 'warning', 1, 2, '', '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (12, 'notice_level', 'H', '高', 'danger', 1, 3, '', '2025-05-05 10:04:38', 1, '2025-05-05 10:04:38', 1);
INSERT INTO `sys_dict_item` VALUES (13, 'minioConfigDict', 'minioUploadUrl', 'minio上传路径', '', 1, 0, NULL, '2025-05-10 19:26:32', NULL, '2025-05-10 19:26:32', NULL);
INSERT INTO `sys_dict_item` VALUES (14, 'minioConfigDict', 'minioAccessKey', 'minio账号', NULL, 1, 0, NULL, '2025-05-13 11:07:59', NULL, '2025-05-13 11:07:59', NULL);
INSERT INTO `sys_dict_item` VALUES (15, 'minioConfigDict', 'minioSecretKey', 'minio密钥', NULL, 1, 1, NULL, '2025-05-13 11:08:39', NULL, '2025-05-13 11:08:39', NULL);
INSERT INTO `sys_dict_item` VALUES (16, 'minioConfigDict', 'minioBucket', 'minio存储桶', NULL, 1, 1, NULL, '2025-05-13 11:09:06', NULL, '2025-05-13 11:09:06', NULL);
INSERT INTO `sys_dict_item` VALUES (17, 'uploadFileConfigDict', 'image_ext_str', '允许上传图片后缀', NULL, 1, 1, NULL, '2025-05-13 20:36:59', NULL, '2025-05-13 20:36:59', NULL);
INSERT INTO `sys_dict_item` VALUES (18, 'uploadFileConfigDict', 'file_ext_str', '允许上传文件后缀', NULL, 1, 0, NULL, '2025-05-13 22:44:18', NULL, '2025-05-13 22:44:18', NULL);
INSERT INTO `sys_dict_item` VALUES (19, 'uploadFileConfigDict', 'image_max_size', '允许上传最大图片', NULL, 1, 0, NULL, '2025-05-13 22:45:27', NULL, '2025-05-13 22:45:27', NULL);
INSERT INTO `sys_dict_item` VALUES (20, 'uploadFileConfigDict', 'file_max_size', '允许上传最大文件', NULL, 1, 0, NULL, '2025-05-13 22:47:04', NULL, '2025-05-13 22:47:04', NULL);

-- ----------------------------
-- Table structure for sys_form_temp
-- ----------------------------
DROP TABLE IF EXISTS `sys_form_temp`;
CREATE TABLE `sys_form_temp`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表单模板id',
  `name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '表单名称',
  `info` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '表单简介',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '表单内容',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_form_temp
-- ----------------------------
INSERT INTO `sys_form_temp` VALUES (9, 'minio配置表单', 'minio配置表单', '{\"rule\":\"[{\\\"type\\\":\\\"input\\\",\\\"field\\\":\\\"minioUploadUrl\\\",\\\"title\\\":\\\"空间域名\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"placeholder\\\":\\\"请输入空间域名\\\"},\\\"_fc_id\\\":\\\"id_Feykmamlvbufacc\\\",\\\"name\\\":\\\"ref_Fwegmamlvbufadc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"input\\\",\\\"mark\\\":\\\"13\\\"},{\\\"type\\\":\\\"input\\\",\\\"field\\\":\\\"minioAccessKey\\\",\\\"title\\\":\\\"AccessKey\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"placeholder\\\":\\\"请输入AccessKey\\\"},\\\"_fc_id\\\":\\\"id_Fqzamamm1ogqafc\\\",\\\"name\\\":\\\"ref_Fqh1mamm1ogqagc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"input\\\",\\\"mark\\\":\\\"14\\\"},{\\\"type\\\":\\\"input\\\",\\\"field\\\":\\\"minioSecretKey\\\",\\\"title\\\":\\\"SecretKey\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"placeholder\\\":\\\"请输入SecretKey\\\",\\\"readonly\\\":false},\\\"_fc_id\\\":\\\"id_Fcicmamm2tb6aic\\\",\\\"name\\\":\\\"ref_Fmcfmamm2tb6ajc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"input\\\",\\\"mark\\\":\\\"15\\\"},{\\\"type\\\":\\\"input\\\",\\\"field\\\":\\\"minioBucket\\\",\\\"title\\\":\\\"存储桶\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"placeholder\\\":\\\"请输入存储桶\\\"},\\\"_fc_id\\\":\\\"id_Ftx3mamm377ualc\\\",\\\"name\\\":\\\"ref_F4akmamm377uamc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"input\\\",\\\"mark\\\":\\\"16\\\"}]\",\"options\":\"{\\\"form\\\":{\\\"inline\\\":false,\\\"hideRequiredAsterisk\\\":false,\\\"labelPosition\\\":\\\"right\\\",\\\"size\\\":\\\"default\\\",\\\"labelWidth\\\":\\\"125px\\\"},\\\"resetBtn\\\":{\\\"show\\\":false,\\\"innerText\\\":\\\"重置\\\"},\\\"submitBtn\\\":{\\\"show\\\":true,\\\"innerText\\\":\\\"提交\\\"}}\"}', '2025-05-13 22:33:00', '2025-05-13 22:33:00');
INSERT INTO `sys_form_temp` VALUES (10, '文件上传-基础配置', '文件上传-本地配置', '{\"rule\":\"[{\\\"type\\\":\\\"input\\\",\\\"field\\\":\\\"image_ext_str\\\",\\\"title\\\":\\\"允许上传图片后缀\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"placeholder\\\":\\\"允许上传图片后缀，多个英文逗号分割允许上传图片后缀\\\"},\\\"_fc_id\\\":\\\"id_Fme6mammm9tsb0c\\\",\\\"name\\\":\\\"ref_F2gzmammm9tsb1c\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"input\\\",\\\"wrap\\\":{\\\"labelWidth\\\":\\\"270px\\\"},\\\"mark\\\":\\\"17\\\"},{\\\"type\\\":\\\"inputNumber\\\",\\\"field\\\":\\\"image_max_size\\\",\\\"title\\\":\\\"允许上传最大图片(单位 M，最大值50 )\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"placeholder\\\":\\\"单位 M允许上传最大图片(单位 M，最大值50 )\\\"},\\\"_fc_id\\\":\\\"id_Fbwdmammnslcb9c\\\",\\\"name\\\":\\\"ref_Fwq8mammnslcbac\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"inputNumber\\\",\\\"wrap\\\":{\\\"labelWidth\\\":\\\"270px\\\"},\\\"style\\\":{\\\"width\\\":\\\"200px\\\"},\\\"mark\\\":\\\"19\\\"},{\\\"type\\\":\\\"input\\\",\\\"field\\\":\\\"file_ext_str\\\",\\\"title\\\":\\\"允许上传文件后缀\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"placeholder\\\":\\\"允许上传文件后缀，多个英文逗号分割允许上传图片后缀\\\"},\\\"_fc_id\\\":\\\"id_F6rjmammn8llb6c\\\",\\\"name\\\":\\\"ref_F16tmammn8llb7c\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"input\\\",\\\"wrap\\\":{\\\"labelWidth\\\":\\\"270px\\\"},\\\"mark\\\":\\\"18\\\"},{\\\"type\\\":\\\"inputNumber\\\",\\\"field\\\":\\\"file_max_size\\\",\\\"title\\\":\\\"允许上传最大文件(单位 M，最大值500 )\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"placeholder\\\":\\\"单位 M允许上传最大文件(单位 M，最大值500 )\\\"},\\\"_fc_id\\\":\\\"id_Fl44mammooetbcc\\\",\\\"name\\\":\\\"ref_Fi6pmammooetbdc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"inputNumber\\\",\\\"wrap\\\":{\\\"labelWidth\\\":\\\"270px\\\"},\\\"style\\\":{\\\"width\\\":\\\"200px\\\"},\\\"mark\\\":\\\"20\\\"}]\",\"options\":\"{\\\"form\\\":{\\\"inline\\\":false,\\\"hideRequiredAsterisk\\\":false,\\\"labelPosition\\\":\\\"right\\\",\\\"size\\\":\\\"default\\\",\\\"labelWidth\\\":\\\"125px\\\"},\\\"resetBtn\\\":{\\\"show\\\":false,\\\"innerText\\\":\\\"重置\\\"},\\\"submitBtn\\\":{\\\"show\\\":true,\\\"innerText\\\":\\\"提交\\\"}}\"}', '2025-05-13 22:49:00', '2025-05-13 22:49:00');
INSERT INTO `sys_form_temp` VALUES (12, 'test', 'test', '{\"rule\":\"[{\\\"type\\\":\\\"input\\\",\\\"field\\\":\\\"box_name\\\",\\\"title\\\":\\\"箱子名称\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"placeholder\\\":\\\"请输入箱子名称\\\"},\\\"_fc_id\\\":\\\"id_Fi46maow2xcyacc\\\",\\\"name\\\":\\\"ref_F0i8maow2xcyadc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"input\\\"},{\\\"type\\\":\\\"FcUploadImage\\\",\\\"field\\\":\\\"icon\\\",\\\"props\\\":{\\\"title\\\":\\\"自定义上传\\\",\\\"formCreateInject\\\":{}},\\\"_fc_id\\\":\\\"id_Fowymaow59fhaec\\\",\\\"name\\\":\\\"ref_Fttlmaow59fhafc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"picture\\\",\\\"title\\\":\\\"箱子图标\\\",\\\"$required\\\":true},{\\\"type\\\":\\\"inputNumber\\\",\\\"field\\\":\\\"odds\\\",\\\"title\\\":\\\"赔率\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"_fc_id\\\":\\\"id_Fkrwmaow6t2nahc\\\",\\\"name\\\":\\\"ref_Fn6emaow6t2naic\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"inputNumber\\\"},{\\\"type\\\":\\\"inputNumber\\\",\\\"field\\\":\\\"real_odds\\\",\\\"title\\\":\\\"真实赔率\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":false,\\\"_fc_id\\\":\\\"id_F3kwmaow86wjakc\\\",\\\"name\\\":\\\"ref_Fcuymaow86wjalc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"inputNumber\\\"}]\",\"options\":\"{\\\"form\\\":{\\\"inline\\\":false,\\\"hideRequiredAsterisk\\\":false,\\\"labelPosition\\\":\\\"right\\\",\\\"size\\\":\\\"default\\\",\\\"labelWidth\\\":\\\"125px\\\"},\\\"resetBtn\\\":{\\\"show\\\":true,\\\"innerText\\\":\\\"重置\\\"},\\\"submitBtn\\\":{\\\"show\\\":true,\\\"innerText\\\":\\\"提交\\\"},\\\"formName\\\":\\\"测试\\\"}\"}', '2025-05-14 23:45:00', '2025-05-14 23:45:00');
INSERT INTO `sys_form_temp` VALUES (13, '前端_底部_tabbar', '前端_底部_tabbar', '{\"rule\":\"[{\\\"type\\\":\\\"input\\\",\\\"field\\\":\\\"title\\\",\\\"title\\\":\\\"标题\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"placeholder\\\":\\\"请输入标题\\\"},\\\"_fc_id\\\":\\\"id_Fbbjmaqp2fpnacc\\\",\\\"name\\\":\\\"ref_Fhujmaqp2fpnadc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"input\\\",\\\"wrap\\\":{\\\"labelWidth\\\":\\\"200px\\\"}},{\\\"type\\\":\\\"colorPicker\\\",\\\"field\\\":\\\"no_choose_text_color\\\",\\\"title\\\":\\\"未选中时文字颜色\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"_fc_id\\\":\\\"id_F5ummaqp3mvrafc\\\",\\\"name\\\":\\\"ref_Fky0maqp3mvragc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"colorPicker\\\",\\\"wrap\\\":{\\\"labelWidth\\\":\\\"200px\\\"}},{\\\"type\\\":\\\"FcUploadImage\\\",\\\"field\\\":\\\"no_choose_icon\\\",\\\"props\\\":{\\\"title\\\":\\\"自定义上传\\\",\\\"formCreateInject\\\":{}},\\\"_fc_id\\\":\\\"id_Fwywmaqp5wlkakc\\\",\\\"name\\\":\\\"ref_F9eamaqp5wlkalc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"picture\\\",\\\"title\\\":\\\"未选中时的图标\\\",\\\"$required\\\":true,\\\"wrap\\\":{\\\"labelWidth\\\":\\\"200px\\\"}},{\\\"type\\\":\\\"colorPicker\\\",\\\"field\\\":\\\"choose_text_color\\\",\\\"title\\\":\\\"选中时文字颜色\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"_fc_id\\\":\\\"id_Fozimaqp5fmaaic\\\",\\\"name\\\":\\\"ref_Fsftmaqp5fmaajc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"colorPicker\\\",\\\"wrap\\\":{\\\"labelWidth\\\":\\\"200px\\\"}},{\\\"type\\\":\\\"FcUploadImage\\\",\\\"field\\\":\\\"choose_icon\\\",\\\"props\\\":{\\\"title\\\":\\\"自定义上传\\\",\\\"formCreateInject\\\":{}},\\\"_fc_id\\\":\\\"id_Fxkimaqp6s08anc\\\",\\\"name\\\":\\\"ref_F5uymaqp6s08aoc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"picture\\\",\\\"title\\\":\\\"选中时的图标\\\",\\\"$required\\\":true,\\\"wrap\\\":{\\\"labelWidth\\\":\\\"200px\\\"}},{\\\"type\\\":\\\"input\\\",\\\"field\\\":\\\"target_url\\\",\\\"title\\\":\\\"跳转地址\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"placeholder\\\":\\\"请输入跳转地址\\\"},\\\"_fc_id\\\":\\\"id_Fm50maqp8ze5aqc\\\",\\\"name\\\":\\\"ref_F65kmaqp8ze5arc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"input\\\",\\\"wrap\\\":{\\\"labelWidth\\\":\\\"200px\\\"}},{\\\"type\\\":\\\"switch\\\",\\\"field\\\":\\\"is_big\\\",\\\"title\\\":\\\"是否放大\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":true,\\\"props\\\":{\\\"activeValue\\\":true,\\\"inactiveValue\\\":false},\\\"_fc_id\\\":\\\"id_Foyzmaqp9wkqatc\\\",\\\"name\\\":\\\"ref_Fegpmaqp9wkqauc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"switch\\\",\\\"wrap\\\":{\\\"labelWidth\\\":\\\"200px\\\"}},{\\\"type\\\":\\\"input\\\",\\\"field\\\":\\\"tag\\\",\\\"title\\\":\\\"活动标签\\\",\\\"info\\\":\\\"\\\",\\\"$required\\\":false,\\\"props\\\":{\\\"placeholder\\\":\\\"用于活动时在上方进行显示的标签\\\"},\\\"_fc_id\\\":\\\"id_Fam0maqpavdwawc\\\",\\\"name\\\":\\\"ref_Fh9jmaqpavdwaxc\\\",\\\"display\\\":true,\\\"hidden\\\":false,\\\"_fc_drag_tag\\\":\\\"input\\\",\\\"wrap\\\":{\\\"labelWidth\\\":\\\"200px\\\"}}]\",\"options\":\"{\\\"form\\\":{\\\"inline\\\":false,\\\"hideRequiredAsterisk\\\":false,\\\"labelPosition\\\":\\\"right\\\",\\\"size\\\":\\\"default\\\",\\\"labelWidth\\\":\\\"125px\\\"},\\\"resetBtn\\\":{\\\"show\\\":false,\\\"innerText\\\":\\\"重置\\\"},\\\"submitBtn\\\":{\\\"show\\\":true,\\\"innerText\\\":\\\"提交\\\"}}\"}', '2025-05-16 19:15:21', '2025-05-16 19:15:21');

-- ----------------------------
-- Table structure for sys_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_group`;
CREATE TABLE `sys_group`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '组合数据ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '数据组名称',
  `info` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '简介',
  `form_id` int NOT NULL DEFAULT 0 COMMENT 'form 表单 id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '组合数据分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_group
-- ----------------------------
INSERT INTO `sys_group` VALUES (1, 'test', 'test', 12, '2025-05-15 00:42:42', '2025-05-15 17:37:50');
INSERT INTO `sys_group` VALUES (2, '前端_底部_tabbar', '前端_底部_tabbar', 13, '2025-05-16 19:17:03', '2025-05-16 19:17:03');

-- ----------------------------
-- Table structure for sys_group_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_group_data`;
CREATE TABLE `sys_group_data`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '组合数据详情ID',
  `gid` int NOT NULL DEFAULT 0 COMMENT '对应的数据组id',
  `value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据组对应的数据值（json数据）',
  `sort` int NOT NULL DEFAULT 0 COMMENT '数据排序',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态（1：开启；2：关闭；）',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '组合分类数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_group_data
-- ----------------------------
INSERT INTO `sys_group_data` VALUES (2, 12, '[{\"type\":\"input\",\"field\":\"box_name\",\"title\":\"箱子名称\",\"info\":\"\",\"$required\":true,\"props\":{\"placeholder\":\"请输入箱子名称\"},\"_fc_id\":\"id_Fi46maow2xcyacc\",\"name\":\"ref_F0i8maow2xcyadc\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"input\",\"on\":{},\"options\":[],\"children\":[],\"value\":\"新手箱\"},{\"type\":\"FcUploadImage\",\"field\":\"icon\",\"props\":{\"title\":\"自定义上传\",\"formCreateInject\":{}},\"_fc_id\":\"id_Fowymaow59fhaec\",\"name\":\"ref_Fttlmaow59fhafc\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"picture\",\"title\":\"箱子图标\",\"$required\":true,\"on\":{},\"options\":[],\"children\":[],\"value\":\"/usdt/2025/05/14/c52903a8-9776-4d76-8a18-9fe6fcb605b0\"},{\"type\":\"inputNumber\",\"field\":\"odds\",\"title\":\"赔率\",\"info\":\"\",\"$required\":true,\"_fc_id\":\"id_Fkrwmaow6t2nahc\",\"name\":\"ref_Fn6emaow6t2naic\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"inputNumber\",\"props\":{},\"on\":{},\"options\":[],\"children\":[],\"value\":0.01},{\"type\":\"inputNumber\",\"field\":\"real_odds\",\"title\":\"真实赔率\",\"info\":\"\",\"$required\":false,\"_fc_id\":\"id_F3kwmaow86wjakc\",\"name\":\"ref_Fcuymaow86wjalc\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"inputNumber\",\"props\":{},\"on\":{},\"options\":[],\"children\":[],\"value\":0}]', 0, 1, '2025-05-15 12:55:12', '2025-05-16 18:09:26');
INSERT INTO `sys_group_data` VALUES (3, 12, '[{\"type\":\"input\",\"field\":\"box_name\",\"title\":\"箱子名称\",\"info\":\"\",\"$required\":true,\"props\":{\"placeholder\":\"请输入箱子名称\"},\"_fc_id\":\"id_Fi46maow2xcyacc\",\"name\":\"ref_F0i8maow2xcyadc\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"input\",\"on\":{},\"options\":[],\"children\":[],\"value\":\"多普勒蝴蝶刀\"},{\"type\":\"FcUploadImage\",\"field\":\"icon\",\"props\":{\"title\":\"自定义上传\",\"formCreateInject\":{}},\"_fc_id\":\"id_Fowymaow59fhaec\",\"name\":\"ref_Fttlmaow59fhafc\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"picture\",\"title\":\"箱子图标\",\"$required\":true,\"on\":{},\"options\":[],\"children\":[],\"value\":\"/usdt/2025/05/14/3d3fe16a-0d6e-44b5-b7ca-1b6e5eb67321\"},{\"type\":\"inputNumber\",\"field\":\"odds\",\"title\":\"赔率\",\"info\":\"\",\"$required\":true,\"_fc_id\":\"id_Fkrwmaow6t2nahc\",\"name\":\"ref_Fn6emaow6t2naic\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"inputNumber\",\"props\":{},\"on\":{},\"options\":[],\"children\":[],\"value\":0.05},{\"type\":\"inputNumber\",\"field\":\"real_odds\",\"title\":\"真实赔率\",\"info\":\"\",\"$required\":false,\"_fc_id\":\"id_F3kwmaow86wjakc\",\"name\":\"ref_Fcuymaow86wjalc\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"inputNumber\",\"props\":{},\"on\":{},\"options\":[],\"children\":[],\"value\":0}]', 1, 1, '2025-05-16 14:09:55', '2025-05-16 16:45:13');
INSERT INTO `sys_group_data` VALUES (4, 12, '[{\"type\":\"input\",\"field\":\"box_name\",\"title\":\"箱子名称\",\"info\":\"\",\"$required\":true,\"props\":{\"placeholder\":\"请输入箱子名称\"},\"_fc_id\":\"id_Fi46maow2xcyacc\",\"name\":\"ref_F0i8maow2xcyadc\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"input\",\"on\":{},\"options\":[],\"children\":[],\"value\":\"高级箱\"},{\"type\":\"FcUploadImage\",\"field\":\"icon\",\"props\":{\"title\":\"自定义上传\",\"formCreateInject\":{}},\"_fc_id\":\"id_Fowymaow59fhaec\",\"name\":\"ref_Fttlmaow59fhafc\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"picture\",\"title\":\"箱子图标\",\"$required\":true,\"on\":{},\"options\":[],\"children\":[],\"value\":\"/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\"},{\"type\":\"inputNumber\",\"field\":\"odds\",\"title\":\"赔率\",\"info\":\"\",\"$required\":true,\"_fc_id\":\"id_Fkrwmaow6t2nahc\",\"name\":\"ref_Fn6emaow6t2naic\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"inputNumber\",\"props\":{},\"on\":{},\"options\":[],\"children\":[],\"value\":0.05},{\"type\":\"inputNumber\",\"field\":\"real_odds\",\"title\":\"真实赔率\",\"info\":\"\",\"$required\":false,\"_fc_id\":\"id_F3kwmaow86wjakc\",\"name\":\"ref_Fcuymaow86wjalc\",\"display\":true,\"hidden\":false,\"_fc_drag_tag\":\"inputNumber\",\"props\":{},\"on\":{},\"options\":[],\"children\":[],\"value\":0.01}]', 0, 1, '2025-05-16 16:44:18', '2025-05-16 16:44:18');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `module` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志模块',
  `request_method` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '请求方式',
  `request_params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '请求参数(批量请求参数可能会超过text)',
  `response_content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '返回参数',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志内容',
  `request_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求路径',
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '方法名',
  `ip` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `province` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省份',
  `city` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '城市',
  `execution_time` bigint NULL DEFAULT NULL COMMENT '执行时间(ms)',
  `browser` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '浏览器',
  `browser_version` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '浏览器版本',
  `os` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '终端系统',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标识(1-已删除 0-未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_create_time`(`create_time`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 714 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.2', '0', '内网IP', 786, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:09:37', 0);
INSERT INTO `sys_log` VALUES (2, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.2', '0', '内网IP', 65, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:09:37', 0);
INSERT INTO `sys_log` VALUES (3, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.2', '0', '内网IP', 60, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:10:05', 0);
INSERT INTO `sys_log` VALUES (4, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":2,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.2', '0', '内网IP', 47, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:10:09', 0);
INSERT INTO `sys_log` VALUES (5, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.2', '0', '内网IP', 51, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:10:13', 0);
INSERT INTO `sys_log` VALUES (6, 'USER', 'GET', '{\"isRoot\":false,\"pageNum\":1,\"pageSize\":20}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 84, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:10:29', 0);
INSERT INTO `sys_log` VALUES (7, 'USER', 'GET', '{\"keywords\":\"\",\"isRoot\":false,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 59, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:10:41', 0);
INSERT INTO `sys_log` VALUES (8, 'USER', 'GET', '{\"isRoot\":false,\"pageNum\":1,\"pageSize\":20}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 76, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:11:28', 0);
INSERT INTO `sys_log` VALUES (9, 'USER', 'GET', '{\"isRoot\":false,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 85, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:11:59', 0);
INSERT INTO `sys_log` VALUES (10, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.2.2', '0', '内网IP', 46, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:12:00', 0);
INSERT INTO `sys_log` VALUES (11, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 80, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:12:05', 0);
INSERT INTO `sys_log` VALUES (12, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.2.2', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:16:48', 0);
INSERT INTO `sys_log` VALUES (13, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.2', '0', '内网IP', 39, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:16:49', 0);
INSERT INTO `sys_log` VALUES (14, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 60, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:17:17', 0);
INSERT INTO `sys_log` VALUES (15, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.2', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:18:09', 0);
INSERT INTO `sys_log` VALUES (16, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.2', '0', '内网IP', 22, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:19:15', 0);
INSERT INTO `sys_log` VALUES (17, 'USER', 'GET', '{\"isRoot\":false,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 64, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:20:28', 0);
INSERT INTO `sys_log` VALUES (18, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.2', '0', '内网IP', 85, 'Chrome', '136.0.0.0', 'Android', 2, '2025-05-05 10:22:30', 0);
INSERT INTO `sys_log` VALUES (19, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.2', '0', '内网IP', 10, 'Chrome', '136.0.0.0', 'Android', 2, '2025-05-05 10:22:30', 0);
INSERT INTO `sys_log` VALUES (20, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:33:20', 0);
INSERT INTO `sys_log` VALUES (21, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:33:46', 0);
INSERT INTO `sys_log` VALUES (22, 'SETTING', 'PUT', '', NULL, '刷新系统配置缓存', '/api/v1/config/refresh', NULL, '192.168.2.2', '0', '内网IP', 91, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:33:57', 0);
INSERT INTO `sys_log` VALUES (23, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:43:57', 0);
INSERT INTO `sys_log` VALUES (24, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:45:07', 0);
INSERT INTO `sys_log` VALUES (25, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:46:22', 0);
INSERT INTO `sys_log` VALUES (26, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 43, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:49:19', 0);
INSERT INTO `sys_log` VALUES (27, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:49:24', 0);
INSERT INTO `sys_log` VALUES (28, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:49:42', 0);
INSERT INTO `sys_log` VALUES (29, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:49:44', 0);
INSERT INTO `sys_log` VALUES (30, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.2.2', '0', '内网IP', 35, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:50:14', 0);
INSERT INTO `sys_log` VALUES (31, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:50:18', 0);
INSERT INTO `sys_log` VALUES (32, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:51:00', 0);
INSERT INTO `sys_log` VALUES (33, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:51:07', 0);
INSERT INTO `sys_log` VALUES (34, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.2.2', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', NULL, '2025-05-05 10:51:43', 0);
INSERT INTO `sys_log` VALUES (35, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.2', '0', '内网IP', 154, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:51:50', 0);
INSERT INTO `sys_log` VALUES (36, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.2', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:51:50', 0);
INSERT INTO `sys_log` VALUES (37, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:54:20', 0);
INSERT INTO `sys_log` VALUES (38, 'SETTING', 'PUT', '', NULL, '刷新系统配置缓存', '/api/v1/config/refresh', NULL, '192.168.2.2', '0', '内网IP', 96, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:54:22', 0);
INSERT INTO `sys_log` VALUES (39, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 37, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:54:24', 0);
INSERT INTO `sys_log` VALUES (40, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:55:17', 0);
INSERT INTO `sys_log` VALUES (41, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.2', '0', '内网IP', 134, 'MSEdge', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:58:47', 0);
INSERT INTO `sys_log` VALUES (42, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.2', '0', '内网IP', 16, 'MSEdge', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 10:58:47', 0);
INSERT INTO `sys_log` VALUES (43, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.2.2', '0', '内网IP', 47, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:00:20', 0);
INSERT INTO `sys_log` VALUES (44, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.2.2', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:00:22', 0);
INSERT INTO `sys_log` VALUES (45, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.2', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:00:23', 0);
INSERT INTO `sys_log` VALUES (46, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 52, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:00:23', 0);
INSERT INTO `sys_log` VALUES (47, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:00:28', 0);
INSERT INTO `sys_log` VALUES (48, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 41, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:02:19', 0);
INSERT INTO `sys_log` VALUES (49, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 40, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:02:22', 0);
INSERT INTO `sys_log` VALUES (50, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.2', '0', '内网IP', 45, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:02:25', 0);
INSERT INTO `sys_log` VALUES (51, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.2.2', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:02:34', 0);
INSERT INTO `sys_log` VALUES (52, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 47, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:03:05', 0);
INSERT INTO `sys_log` VALUES (53, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 35, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:03:09', 0);
INSERT INTO `sys_log` VALUES (54, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 56, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:05:38', 0);
INSERT INTO `sys_log` VALUES (55, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:05:44', 0);
INSERT INTO `sys_log` VALUES (56, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:07:30', 0);
INSERT INTO `sys_log` VALUES (57, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:07:34', 0);
INSERT INTO `sys_log` VALUES (58, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.2.2', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', NULL, '2025-05-05 11:07:54', 0);
INSERT INTO `sys_log` VALUES (59, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.2', '0', '内网IP', 142, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:07:58', 0);
INSERT INTO `sys_log` VALUES (60, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.2', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:07:58', 0);
INSERT INTO `sys_log` VALUES (61, 'USER', 'GET', '{\"isRoot\":false,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 67, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:10:22', 0);
INSERT INTO `sys_log` VALUES (62, 'USER', 'GET', '{\"isRoot\":false,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 77, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 11:14:20', 0);
INSERT INTO `sys_log` VALUES (63, 'USER', 'GET', '{\"isRoot\":false,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 84, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 21:51:58', 0);
INSERT INTO `sys_log` VALUES (64, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.2.2', '0', '内网IP', 55, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 21:52:10', 0);
INSERT INTO `sys_log` VALUES (65, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 63, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 21:52:16', 0);
INSERT INTO `sys_log` VALUES (66, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 50, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 21:54:36', 0);
INSERT INTO `sys_log` VALUES (67, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 77, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 21:54:38', 0);
INSERT INTO `sys_log` VALUES (68, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 21:55:48', 0);
INSERT INTO `sys_log` VALUES (69, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 43, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 21:56:24', 0);
INSERT INTO `sys_log` VALUES (70, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.2.2', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 21:56:28', 0);
INSERT INTO `sys_log` VALUES (71, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 21:58:03', 0);
INSERT INTO `sys_log` VALUES (72, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 37, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:03:16', 0);
INSERT INTO `sys_log` VALUES (73, 'USER', 'GET', '', NULL, '获取个人中心用户信息', '/api/v1/users/profile', NULL, '192.168.2.2', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:03:43', 0);
INSERT INTO `sys_log` VALUES (74, 'USER', 'GET', '{\"isRoot\":false,\"pageNum\":1,\"pageSize\":20}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 71, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:03:54', 0);
INSERT INTO `sys_log` VALUES (75, 'USER', 'GET', '{\"keywords\":\"\",\"createTime\":[],\"isRoot\":false,\"pageNum\":1,\"pageSize\":10}', NULL, '导出用户', '/api/v1/users/export', NULL, '192.168.2.2', '0', '内网IP', 2935, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:04:07', 0);
INSERT INTO `sys_log` VALUES (76, 'USER', 'GET', '{\"isRoot\":false,\"pageNum\":1,\"pageSize\":20}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 62, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:04:12', 0);
INSERT INTO `sys_log` VALUES (77, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.2.2', '0', '内网IP', 53, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:06:47', 0);
INSERT INTO `sys_log` VALUES (78, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:06:50', 0);
INSERT INTO `sys_log` VALUES (79, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:07:31', 0);
INSERT INTO `sys_log` VALUES (80, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:07:35', 0);
INSERT INTO `sys_log` VALUES (81, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 57, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:07:37', 0);
INSERT INTO `sys_log` VALUES (82, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:07:48', 0);
INSERT INTO `sys_log` VALUES (83, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 65, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:07:54', 0);
INSERT INTO `sys_log` VALUES (84, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:08:03', 0);
INSERT INTO `sys_log` VALUES (85, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 35, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:08:06', 0);
INSERT INTO `sys_log` VALUES (86, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:08:19', 0);
INSERT INTO `sys_log` VALUES (87, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 39, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:08:55', 0);
INSERT INTO `sys_log` VALUES (88, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:10:03', 0);
INSERT INTO `sys_log` VALUES (89, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:10:35', 0);
INSERT INTO `sys_log` VALUES (90, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:10:49', 0);
INSERT INTO `sys_log` VALUES (91, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 44, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:10:55', 0);
INSERT INTO `sys_log` VALUES (92, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 38, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:10:57', 0);
INSERT INTO `sys_log` VALUES (93, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:10:58', 0);
INSERT INTO `sys_log` VALUES (94, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 55, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:11:06', 0);
INSERT INTO `sys_log` VALUES (95, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 54, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:11:10', 0);
INSERT INTO `sys_log` VALUES (96, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 27, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:44:59', 0);
INSERT INTO `sys_log` VALUES (97, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:46:02', 0);
INSERT INTO `sys_log` VALUES (98, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:46:13', 0);
INSERT INTO `sys_log` VALUES (99, 'USER', 'GET', '{\"isRoot\":false,\"pageNum\":1,\"pageSize\":20}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 64, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:46:36', 0);
INSERT INTO `sys_log` VALUES (100, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.2', '0', '内网IP', 54, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:46:46', 0);
INSERT INTO `sys_log` VALUES (101, 'OTHER', 'POST', '{\"tableName\":\"sys_config\",\"businessName\":\"系统配置\",\"moduleName\":\"system\",\"packageName\":\"com.youlai.boot\",\"entityName\":\"SysConfig\",\"author\":\"youlaitech\",\"fieldConfigs\":[{\"columnName\":\"id\",\"columnType\":\"bigint\",\"fieldName\":\"id\",\"fieldSort\":1,\"fieldType\":\"Long\",\"fieldComment\":\"\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"config_name\",\"columnType\":\"varchar\",\"fieldName\":\"configName\",\"fieldSort\":2,\"fieldType\":\"String\",\"fieldComment\":\"配置名称\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"maxLength\":50,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"config_key\",\"columnType\":\"varchar\",\"fieldName\":\"configKey\",\"fieldSort\":3,\"fieldType\":\"String\",\"fieldComment\":\"配置key\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"maxLength\":50,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"config_value\",\"columnType\":\"varchar\",\"fieldName\":\"configValue\",\"fieldSort\":4,\"fieldType\":\"String\",\"fieldComment\":\"配置值\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"maxLength\":100,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"remark\",\"columnType\":\"varchar\",\"fieldName\":\"remark\",\"fieldSort\":5,\"fieldType\":\"String\",\"fieldComment\":\"备注\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"maxLength\":255,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"form_id\",\"columnType\":\"int\",\"fieldName\":\"formId\",\"fieldSort\":6,\"fieldType\":\"Integer\",\"fieldComment\":\"表单对应id\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"create_time\",\"columnType\":\"datetime\",\"fieldName\":\"createTime\",\"fieldSort\":7,\"fieldType\":\"LocalDateTime\",\"fieldComment\":\"创建时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"DATE_TIME\",\"queryType\":\"EQ\"},{\"columnName\":\"create_by\",\"columnType\":\"bigint\",\"fieldName\":\"createBy\",\"fieldSort\":8,\"fieldType\":\"Long\",\"fieldComment\":\"创建人ID\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"update_time\",\"columnType\":\"datetime\",\"fieldName\":\"updateTime\",\"fieldSort\":9,\"fieldType\":\"LocalDateTime\",\"fieldComment\":\"更新时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"DATE_TIME\",\"queryType\":\"EQ\"},{\"columnName\":\"update_by\",\"columnType\":\"bigint\",\"fieldName\":\"updateBy\",\"fieldSort\":10,\"fieldType\":\"Long\",\"fieldComment\":\"更新人ID\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"is_deleted\",\"columnType\":\"tinyint\",\"fieldName\":\"isDeleted\",\"fieldSort\":11,\"fieldType\":\"Integer\",\"fieldComment\":\"逻辑删除标识(0-未删除 1-已删除)\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"}],\"backendAppName\":\"youlai-boot\",\"frontendAppName\":\"vue3-element-admin\"}', NULL, '生成代码', '/api/v1/codegen/sys_config/config', NULL, '192.168.2.2', '0', '内网IP', 299, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:47:11', 0);
INSERT INTO `sys_log` VALUES (102, 'OTHER', 'GET', 'sys_config', NULL, '预览生成代码', '/api/v1/codegen/sys_config/preview', NULL, '192.168.2.2', '0', '内网IP', 664, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:47:12', 0);
INSERT INTO `sys_log` VALUES (103, 'USER', 'GET', '{\"isRoot\":false,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 107, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:47:42', 0);
INSERT INTO `sys_log` VALUES (104, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.2.2', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:47:44', 0);
INSERT INTO `sys_log` VALUES (105, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:51:50', 0);
INSERT INTO `sys_log` VALUES (106, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:51:54', 0);
INSERT INTO `sys_log` VALUES (107, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:53:08', 0);
INSERT INTO `sys_log` VALUES (108, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:53:25', 0);
INSERT INTO `sys_log` VALUES (109, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 43, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:53:27', 0);
INSERT INTO `sys_log` VALUES (110, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 57, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:53:30', 0);
INSERT INTO `sys_log` VALUES (111, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-05 22:53:32', 0);
INSERT INTO `sys_log` VALUES (112, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.2.2', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', NULL, '2025-05-05 22:54:01', 0);
INSERT INTO `sys_log` VALUES (113, 'LOGIN', 'POST', 'root 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.2', '0', '内网IP', 287, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-05 22:54:11', 0);
INSERT INTO `sys_log` VALUES (114, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.2', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-05 22:54:11', 0);
INSERT INTO `sys_log` VALUES (115, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-05 22:54:12', 0);
INSERT INTO `sys_log` VALUES (116, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.2', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-05 22:54:23', 0);
INSERT INTO `sys_log` VALUES (117, 'LOGIN', 'POST', 'root 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.2', '0', '内网IP', 983, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 13:20:56', 0);
INSERT INTO `sys_log` VALUES (118, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.2', '0', '内网IP', 39, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 13:20:57', 0);
INSERT INTO `sys_log` VALUES (119, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 13:42:31', 0);
INSERT INTO `sys_log` VALUES (120, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 13:43:07', 0);
INSERT INTO `sys_log` VALUES (121, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 15:24:05', 0);
INSERT INTO `sys_log` VALUES (122, 'CATEGORY', 'POST', '{\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category', NULL, '192.168.2.2', '0', '内网IP', 128, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 15:27:43', 0);
INSERT INTO `sys_log` VALUES (123, 'CATEGORY', 'POST', '{\"pid\":1,\"name\":\"商城基础配置\",\"type\":6,\"url\":\"商城基础配置\",\"extra\":\"1\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category', NULL, '192.168.2.2', '0', '内网IP', 195, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 15:31:54', 0);
INSERT INTO `sys_log` VALUES (124, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 39, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 15:36:29', 0);
INSERT INTO `sys_log` VALUES (125, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 43, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 18:48:39', 0);
INSERT INTO `sys_log` VALUES (126, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 51, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:26:21', 0);
INSERT INTO `sys_log` VALUES (127, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:26:24', 0);
INSERT INTO `sys_log` VALUES (128, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:39:13', 0);
INSERT INTO `sys_log` VALUES (129, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:39:23', 0);
INSERT INTO `sys_log` VALUES (130, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 49, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:39:58', 0);
INSERT INTO `sys_log` VALUES (131, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 27, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:42:38', 0);
INSERT INTO `sys_log` VALUES (132, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.2', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:44:38', 0);
INSERT INTO `sys_log` VALUES (133, 'USER', 'GET', '{\"isRoot\":true,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.2', '0', '内网IP', 100, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:44:44', 0);
INSERT INTO `sys_log` VALUES (134, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 55, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:44:49', 0);
INSERT INTO `sys_log` VALUES (135, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 76, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:47:06', 0);
INSERT INTO `sys_log` VALUES (136, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:47:12', 0);
INSERT INTO `sys_log` VALUES (137, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:47:26', 0);
INSERT INTO `sys_log` VALUES (138, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 39, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:49:06', 0);
INSERT INTO `sys_log` VALUES (139, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 49, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:49:34', 0);
INSERT INTO `sys_log` VALUES (140, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:49:57', 0);
INSERT INTO `sys_log` VALUES (141, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 72, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:50:30', 0);
INSERT INTO `sys_log` VALUES (142, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 50, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:50:59', 0);
INSERT INTO `sys_log` VALUES (143, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 45, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:51:08', 0);
INSERT INTO `sys_log` VALUES (144, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 46, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:51:29', 0);
INSERT INTO `sys_log` VALUES (145, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 43, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:51:50', 0);
INSERT INTO `sys_log` VALUES (146, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 43, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 19:52:31', 0);
INSERT INTO `sys_log` VALUES (147, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.2', '0', '内网IP', 5320, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-06 23:49:10', 0);
INSERT INTO `sys_log` VALUES (148, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.2', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-06 23:49:10', 0);
INSERT INTO `sys_log` VALUES (149, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.2.2', '0', '内网IP', 43, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', NULL, '2025-05-06 23:49:29', 0);
INSERT INTO `sys_log` VALUES (150, 'LOGIN', 'POST', 'root 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.2', '0', '内网IP', 187, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 23:49:35', 0);
INSERT INTO `sys_log` VALUES (151, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.2', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 23:49:36', 0);
INSERT INTO `sys_log` VALUES (152, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 40, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 23:50:51', 0);
INSERT INTO `sys_log` VALUES (153, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 44, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 23:50:59', 0);
INSERT INTO `sys_log` VALUES (154, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 49, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 23:52:00', 0);
INSERT INTO `sys_log` VALUES (155, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 39, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 23:52:21', 0);
INSERT INTO `sys_log` VALUES (156, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 53, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-06 23:55:48', 0);
INSERT INTO `sys_log` VALUES (157, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 60, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 00:00:16', 0);
INSERT INTO `sys_log` VALUES (158, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 41, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 00:02:03', 0);
INSERT INTO `sys_log` VALUES (159, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 41, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 00:03:11', 0);
INSERT INTO `sys_log` VALUES (160, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.2', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 00:26:21', 0);
INSERT INTO `sys_log` VALUES (161, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 00:26:22', 0);
INSERT INTO `sys_log` VALUES (162, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 00:26:44', 0);
INSERT INTO `sys_log` VALUES (163, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.2', '0', '内网IP', 46, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 00:26:51', 0);
INSERT INTO `sys_log` VALUES (164, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.4', '0', '内网IP', 147, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:25:51', 0);
INSERT INTO `sys_log` VALUES (165, 'OTHER', 'POST', '{\"tableName\":\"sys_form_temp\",\"businessName\":\"表单模板\",\"moduleName\":\"system\",\"packageName\":\"com.youlai.boot\",\"entityName\":\"SysFormTemp\",\"author\":\"MrZhang\",\"fieldConfigs\":[{\"columnName\":\"id\",\"columnType\":\"int\",\"fieldName\":\"id\",\"fieldSort\":1,\"fieldType\":\"Integer\",\"fieldComment\":\"表单模板id\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"name\",\"columnType\":\"varchar\",\"fieldName\":\"name\",\"fieldSort\":2,\"fieldType\":\"String\",\"fieldComment\":\"表单名称\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":1,\"maxLength\":500,\"formType\":\"INPUT\",\"queryType\":\"LIKE\"},{\"columnName\":\"info\",\"columnType\":\"varchar\",\"fieldName\":\"info\",\"fieldSort\":3,\"fieldType\":\"String\",\"fieldComment\":\"表单简介\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":1,\"maxLength\":500,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"content\",\"columnType\":\"text\",\"fieldName\":\"content\",\"fieldSort\":4,\"fieldType\":\"String\",\"fieldComment\":\"表单内容\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":1,\"maxLength\":65535,\"formType\":\"TEXT_AREA\",\"queryType\":\"EQ\"},{\"columnName\":\"create_time\",\"columnType\":\"timestamp\",\"fieldName\":\"createTime\",\"fieldSort\":5,\"fieldComment\":\"创建时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"update_time\",\"columnType\":\"timestamp\",\"fieldName\":\"updateTime\",\"fieldSort\":6,\"fieldComment\":\"更新时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"}],\"backendAppName\":\"youlai-boot\",\"frontendAppName\":\"vue3-element-admin\"}', NULL, '生成代码', '/api/v1/codegen/sys_form_temp/config', NULL, '192.168.2.4', '0', '内网IP', 326, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:29:30', 0);
INSERT INTO `sys_log` VALUES (166, 'OTHER', 'GET', 'sys_form_temp', NULL, '预览生成代码', '/api/v1/codegen/sys_form_temp/preview', NULL, '192.168.2.4', '0', '内网IP', 568, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:29:30', 0);
INSERT INTO `sys_log` VALUES (167, 'OTHER', 'GET', 'sys_form_temp', NULL, '下载代码', '/api/v1/codegen/sys_form_temp/download', NULL, '192.168.2.4', '0', '内网IP', 132, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:29:43', 0);
INSERT INTO `sys_log` VALUES (168, 'OTHER', 'POST', '{\"id\":2,\"tableName\":\"sys_form_temp\",\"businessName\":\"表单模板\",\"moduleName\":\"system\",\"packageName\":\"com.youlai.boot\",\"entityName\":\"SysFormTemp\",\"author\":\"MrZhang\",\"fieldConfigs\":[{\"id\":12,\"columnName\":\"id\",\"columnType\":\"int\",\"fieldName\":\"id\",\"fieldSort\":1,\"fieldType\":\"Integer\",\"fieldComment\":\"表单模板id\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":13,\"columnName\":\"name\",\"columnType\":\"varchar\",\"fieldName\":\"name\",\"fieldSort\":2,\"fieldType\":\"String\",\"fieldComment\":\"表单名称\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":1,\"maxLength\":500,\"formType\":\"INPUT\",\"queryType\":\"LIKE\"},{\"id\":14,\"columnName\":\"info\",\"columnType\":\"varchar\",\"fieldName\":\"info\",\"fieldSort\":3,\"fieldType\":\"String\",\"fieldComment\":\"表单简介\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":1,\"maxLength\":500,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":15,\"columnName\":\"content\",\"columnType\":\"text\",\"fieldName\":\"content\",\"fieldSort\":4,\"fieldType\":\"String\",\"fieldComment\":\"表单内容\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":1,\"maxLength\":65535,\"formType\":\"TEXT_AREA\",\"queryType\":\"EQ\"},{\"id\":16,\"columnName\":\"create_time\",\"columnType\":\"timestamp\",\"fieldName\":\"createTime\",\"fieldSort\":5,\"fieldComment\":\"创建时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":17,\"columnName\":\"update_time\",\"columnType\":\"timestamp\",\"fieldName\":\"updateTime\",\"fieldSort\":6,\"fieldComment\":\"更新时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"}],\"backendAppName\":\"youlai-boot\",\"frontendAppName\":\"vue3-element-admin\"}', NULL, '生成代码', '/api/v1/codegen/sys_form_temp/config', NULL, '192.168.2.4', '0', '内网IP', 339, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:32:04', 0);
INSERT INTO `sys_log` VALUES (169, 'OTHER', 'GET', 'sys_form_temp', NULL, '预览生成代码', '/api/v1/codegen/sys_form_temp/preview', NULL, '192.168.2.4', '0', '内网IP', 119, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:32:04', 0);
INSERT INTO `sys_log` VALUES (170, 'OTHER', 'POST', '{\"id\":2,\"tableName\":\"sys_form_temp\",\"businessName\":\"表单模板\",\"moduleName\":\"system\",\"packageName\":\"com.youlai.boot\",\"entityName\":\"SysFormTemp\",\"author\":\"MrZhang\",\"fieldConfigs\":[{\"id\":12,\"columnName\":\"id\",\"columnType\":\"int\",\"fieldName\":\"id\",\"fieldSort\":1,\"fieldType\":\"Integer\",\"fieldComment\":\"表单模板id\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":13,\"columnName\":\"name\",\"columnType\":\"varchar\",\"fieldName\":\"name\",\"fieldSort\":2,\"fieldType\":\"String\",\"fieldComment\":\"表单名称\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":1,\"maxLength\":500,\"formType\":\"INPUT\",\"queryType\":\"LIKE\"},{\"id\":14,\"columnName\":\"info\",\"columnType\":\"varchar\",\"fieldName\":\"info\",\"fieldSort\":3,\"fieldType\":\"String\",\"fieldComment\":\"表单简介\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":1,\"maxLength\":500,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":15,\"columnName\":\"content\",\"columnType\":\"text\",\"fieldName\":\"content\",\"fieldSort\":4,\"fieldType\":\"String\",\"fieldComment\":\"表单内容\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":1,\"maxLength\":65535,\"formType\":\"TEXT_AREA\",\"queryType\":\"EQ\"},{\"id\":16,\"columnName\":\"create_time\",\"columnType\":\"timestamp\",\"fieldName\":\"createTime\",\"fieldSort\":5,\"fieldComment\":\"创建时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":17,\"columnName\":\"update_time\",\"columnType\":\"timestamp\",\"fieldName\":\"updateTime\",\"fieldSort\":6,\"fieldComment\":\"更新时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"}],\"backendAppName\":\"youlai-boot\",\"frontendAppName\":\"vue3-element-admin\"}', NULL, '生成代码', '/api/v1/codegen/sys_form_temp/config', NULL, '192.168.2.4', '0', '内网IP', 353, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:32:39', 0);
INSERT INTO `sys_log` VALUES (171, 'OTHER', 'GET', 'sys_form_temp', NULL, '预览生成代码', '/api/v1/codegen/sys_form_temp/preview', NULL, '192.168.2.4', '0', '内网IP', 126, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:32:39', 0);
INSERT INTO `sys_log` VALUES (172, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.4', '0', '内网IP', 78, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:40:26', 0);
INSERT INTO `sys_log` VALUES (173, 'OTHER', 'GET', 'sys_form_temp', NULL, '预览生成代码', '/api/v1/codegen/sys_form_temp/preview', NULL, '192.168.2.4', '0', '内网IP', 343, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:40:45', 0);
INSERT INTO `sys_log` VALUES (174, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.4', '0', '内网IP', 609, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-07 15:49:53', 0);
INSERT INTO `sys_log` VALUES (175, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.4', '0', '内网IP', 43, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-07 15:49:54', 0);
INSERT INTO `sys_log` VALUES (176, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.4', '0', '内网IP', 87, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-07 15:49:54', 0);
INSERT INTO `sys_log` VALUES (177, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.2.4', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', NULL, '2025-05-07 15:50:03', 0);
INSERT INTO `sys_log` VALUES (178, 'LOGIN', 'POST', 'root 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.4', '0', '内网IP', 159, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:50:11', 0);
INSERT INTO `sys_log` VALUES (179, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.4', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:50:12', 0);
INSERT INTO `sys_log` VALUES (180, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.4', '0', '内网IP', 71, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:50:12', 0);
INSERT INTO `sys_log` VALUES (181, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.4', '0', '内网IP', 57, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:51:09', 0);
INSERT INTO `sys_log` VALUES (182, 'OTHER', 'GET', 'sys_form_temp', NULL, '预览生成代码', '/api/v1/codegen/sys_form_temp/preview', NULL, '192.168.2.4', '0', '内网IP', 404, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 15:52:14', 0);
INSERT INTO `sys_log` VALUES (183, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 55, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 16:56:57', 0);
INSERT INTO `sys_log` VALUES (184, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 54, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 16:57:15', 0);
INSERT INTO `sys_log` VALUES (185, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 39, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 16:57:17', 0);
INSERT INTO `sys_log` VALUES (186, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 58, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 16:57:47', 0);
INSERT INTO `sys_log` VALUES (187, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 44, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 16:58:26', 0);
INSERT INTO `sys_log` VALUES (188, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 41, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 16:58:31', 0);
INSERT INTO `sys_log` VALUES (189, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 37, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 16:58:47', 0);
INSERT INTO `sys_log` VALUES (190, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 37, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 16:58:59', 0);
INSERT INTO `sys_log` VALUES (191, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 39, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 16:59:01', 0);
INSERT INTO `sys_log` VALUES (192, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 39, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 17:00:27', 0);
INSERT INTO `sys_log` VALUES (193, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 50, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 17:00:37', 0);
INSERT INTO `sys_log` VALUES (194, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 43, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 17:00:46', 0);
INSERT INTO `sys_log` VALUES (195, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.4', '0', '内网IP', 56, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-07 17:00:48', 0);
INSERT INTO `sys_log` VALUES (196, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.14', '0', '内网IP', 759, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-10 17:48:19', 0);
INSERT INTO `sys_log` VALUES (197, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.14', '0', '内网IP', 49, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-10 17:48:20', 0);
INSERT INTO `sys_log` VALUES (198, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.2.14', '0', '内网IP', 58, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', NULL, '2025-05-10 17:48:33', 0);
INSERT INTO `sys_log` VALUES (199, 'LOGIN', 'POST', 'root 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.14', '0', '内网IP', 153, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 17:48:48', 0);
INSERT INTO `sys_log` VALUES (200, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 17:48:49', 0);
INSERT INTO `sys_log` VALUES (201, 'USER', 'GET', '{\"isRoot\":true,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.14', '0', '内网IP', 85, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 17:49:06', 0);
INSERT INTO `sys_log` VALUES (202, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 67, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 17:49:20', 0);
INSERT INTO `sys_log` VALUES (203, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.2.14', '0', '内网IP', 36, 'MSEdge', '136.0.0.0', 'Windows 10 or Windows Server 2016', NULL, '2025-05-10 17:50:06', 0);
INSERT INTO `sys_log` VALUES (204, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 106, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 17:54:30', 0);
INSERT INTO `sys_log` VALUES (205, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 17:58:25', 0);
INSERT INTO `sys_log` VALUES (206, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 53, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 18:09:23', 0);
INSERT INTO `sys_log` VALUES (207, 'OTHER', 'POST', '{\"tableName\":\"sys_attachment_type\",\"businessName\":\"附件分类列管理\",\"moduleName\":\"system\",\"packageName\":\"com.youlai.boot\",\"entityName\":\"SysAttachmentType\",\"author\":\"MrZhang\",\"fieldConfigs\":[{\"columnName\":\"id\",\"columnType\":\"int\",\"fieldName\":\"id\",\"fieldSort\":1,\"fieldType\":\"Integer\",\"fieldComment\":\"自增id\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"name\",\"columnType\":\"varchar\",\"fieldName\":\"name\",\"fieldSort\":2,\"fieldType\":\"String\",\"fieldComment\":\"文件分类名称\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":0,\"maxLength\":255,\"formType\":\"INPUT\",\"queryType\":\"LIKE\"},{\"columnName\":\"common\",\"columnType\":\"varchar\",\"fieldName\":\"common\",\"fieldSort\":3,\"fieldType\":\"String\",\"fieldComment\":\"备注\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":0,\"maxLength\":255,\"formType\":\"INPUT\",\"queryType\":\"LIKE\"},{\"columnName\":\"create_time\",\"columnType\":\"timestamp\",\"fieldName\":\"createTime\",\"fieldSort\":4,\"fieldComment\":\"创建时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":0,\"formType\":\"DATE_TIME\",\"queryType\":\"EQ\"},{\"columnName\":\"update_time\",\"columnType\":\"timestamp\",\"fieldName\":\"updateTime\",\"fieldSort\":5,\"fieldComment\":\"更新时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":0,\"formType\":\"DATE_TIME\",\"queryType\":\"EQ\"}],\"backendAppName\":\"youlai-boot\",\"frontendAppName\":\"vue3-element-admin\"}', NULL, '生成代码', '/api/v1/codegen/sys_attachment_type/config', NULL, '192.168.2.14', '0', '内网IP', 327, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 18:10:55', 0);
INSERT INTO `sys_log` VALUES (208, 'OTHER', 'GET', 'sys_attachment_type', NULL, '预览生成代码', '/api/v1/codegen/sys_attachment_type/preview', NULL, '192.168.2.14', '0', '内网IP', 766, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 18:10:56', 0);
INSERT INTO `sys_log` VALUES (209, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 41, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 18:16:15', 0);
INSERT INTO `sys_log` VALUES (210, 'OTHER', 'GET', 'sys_attachment_type', NULL, '预览生成代码', '/api/v1/codegen/sys_attachment_type/preview', NULL, '192.168.2.14', '0', '内网IP', 151, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 18:19:23', 0);
INSERT INTO `sys_log` VALUES (211, 'OTHER', 'POST', '{\"id\":3,\"tableName\":\"sys_attachment_type\",\"businessName\":\"附件分类列管理\",\"moduleName\":\"system\",\"packageName\":\"com.youlai.boot\",\"entityName\":\"SysAttachmentType\",\"author\":\"MrZhang\",\"fieldConfigs\":[{\"id\":18,\"columnName\":\"id\",\"columnType\":\"int\",\"fieldName\":\"id\",\"fieldSort\":1,\"fieldType\":\"Integer\",\"fieldComment\":\"自增id\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":19,\"columnName\":\"name\",\"columnType\":\"varchar\",\"fieldName\":\"name\",\"fieldSort\":2,\"fieldType\":\"String\",\"fieldComment\":\"文件分类名称\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":0,\"maxLength\":255,\"formType\":\"INPUT\",\"queryType\":\"LIKE\"},{\"id\":20,\"columnName\":\"common\",\"columnType\":\"varchar\",\"fieldName\":\"common\",\"fieldSort\":3,\"fieldType\":\"String\",\"fieldComment\":\"备注\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":0,\"maxLength\":255,\"formType\":\"INPUT\",\"queryType\":\"LIKE\"},{\"id\":21,\"columnName\":\"create_time\",\"columnType\":\"timestamp\",\"fieldName\":\"createTime\",\"fieldSort\":4,\"fieldComment\":\"创建时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":0,\"formType\":\"DATE_TIME\",\"queryType\":\"EQ\"},{\"id\":22,\"columnName\":\"update_time\",\"columnType\":\"timestamp\",\"fieldName\":\"updateTime\",\"fieldSort\":5,\"fieldComment\":\"更新时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":1,\"isRequired\":0,\"formType\":\"DATE_TIME\",\"queryType\":\"EQ\"}],\"backendAppName\":\"youlai-boot\",\"frontendAppName\":\"vue3-element-admin\"}', NULL, '生成代码', '/api/v1/codegen/sys_attachment_type/config', NULL, '192.168.2.14', '0', '内网IP', 354, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 18:22:14', 0);
INSERT INTO `sys_log` VALUES (212, 'OTHER', 'GET', 'sys_attachment_type', NULL, '预览生成代码', '/api/v1/codegen/sys_attachment_type/preview', NULL, '192.168.2.14', '0', '内网IP', 108, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 18:22:15', 0);
INSERT INTO `sys_log` VALUES (213, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 66, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 18:39:15', 0);
INSERT INTO `sys_log` VALUES (214, 'LOGIN', 'POST', 'root 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.14', '0', '内网IP', 702, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 19:10:46', 0);
INSERT INTO `sys_log` VALUES (215, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.14', '0', '内网IP', 52, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 19:10:47', 0);
INSERT INTO `sys_log` VALUES (216, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 19:22:53', 0);
INSERT INTO `sys_log` VALUES (217, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-10 19:24:33', 0);
INSERT INTO `sys_log` VALUES (218, 'LOGIN', 'POST', 'root 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.14', '0', '内网IP', 1067, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 01:01:32', 0);
INSERT INTO `sys_log` VALUES (219, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.14', '0', '内网IP', 44, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 01:01:33', 0);
INSERT INTO `sys_log` VALUES (220, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 70, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 01:06:39', 0);
INSERT INTO `sys_log` VALUES (221, 'USER', 'GET', '{\"isRoot\":true,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.14', '0', '内网IP', 72, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 01:06:45', 0);
INSERT INTO `sys_log` VALUES (222, 'USER', 'GET', '{\"isRoot\":true,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.14', '0', '内网IP', 59, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 01:09:12', 0);
INSERT INTO `sys_log` VALUES (223, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 01:09:32', 0);
INSERT INTO `sys_log` VALUES (224, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 54, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 01:09:36', 0);
INSERT INTO `sys_log` VALUES (225, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 01:12:03', 0);
INSERT INTO `sys_log` VALUES (226, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 60, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 01:12:34', 0);
INSERT INTO `sys_log` VALUES (227, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 01:12:43', 0);
INSERT INTO `sys_log` VALUES (228, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 01:12:46', 0);
INSERT INTO `sys_log` VALUES (229, 'CATEGORY', 'POST', '{\"pid\":0,\"name\":\"111\",\"url\":\"111\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 13791, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:10:16', 0);
INSERT INTO `sys_log` VALUES (230, 'CATEGORY', 'POST', '{\"pid\":3,\"name\":\"123\",\"url\":\"1223\",\"extra\":\"2\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 127, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:10:35', 0);
INSERT INTO `sys_log` VALUES (231, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 107, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:35:07', 0);
INSERT INTO `sys_log` VALUES (232, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:35:10', 0);
INSERT INTO `sys_log` VALUES (233, 'USER', 'GET', '{\"isRoot\":true,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.14', '0', '内网IP', 62, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:35:11', 0);
INSERT INTO `sys_log` VALUES (234, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:35:16', 0);
INSERT INTO `sys_log` VALUES (235, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:35:18', 0);
INSERT INTO `sys_log` VALUES (236, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.2.14', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:35:52', 0);
INSERT INTO `sys_log` VALUES (237, 'CATEGORY', 'PUT', '{\"id\":3,\"pid\":0,\"name\":\"111\",\"type\":1,\"url\":\"111\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 2868, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:52:41', 0);
INSERT INTO `sys_log` VALUES (238, 'CATEGORY', 'PUT', '{\"id\":3,\"pid\":0,\"name\":\"111\",\"type\":1,\"url\":\"111\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 30638, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:53:19', 0);
INSERT INTO `sys_log` VALUES (239, 'CATEGORY', 'PUT', '{\"id\":3,\"pid\":0,\"name\":\"111\",\"type\":1,\"url\":\"111\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 14596, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:53:35', 0);
INSERT INTO `sys_log` VALUES (240, 'CATEGORY', 'PUT', '{\"id\":3,\"pid\":0,\"name\":\"111\",\"type\":1,\"url\":\"111\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 5308, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:54:21', 0);
INSERT INTO `sys_log` VALUES (241, 'CATEGORY', 'PUT', '{\"id\":4,\"pid\":3,\"name\":\"0000000\",\"type\":1,\"url\":\"1223\",\"extra\":\"2\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 93, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:54:39', 0);
INSERT INTO `sys_log` VALUES (242, 'CATEGORY', 'POST', '{\"pid\":4,\"name\":\"1111111\",\"type\":1,\"url\":\"\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 109, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:54:51', 0);
INSERT INTO `sys_log` VALUES (243, 'CATEGORY', 'DELETE', '{id=5}', NULL, '删除配置分类', '/api/v1/category/delete/5', NULL, '192.168.2.14', '0', '内网IP', 128, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:55:02', 0);
INSERT INTO `sys_log` VALUES (244, 'CATEGORY', 'DELETE', '{id=4}', NULL, '删除配置分类', '/api/v1/category/delete/4', NULL, '192.168.2.14', '0', '内网IP', 85, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:55:06', 0);
INSERT INTO `sys_log` VALUES (245, 'CATEGORY', 'POST', '{\"pid\":3,\"name\":\"123\",\"type\":1,\"url\":\"\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 147, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:55:47', 0);
INSERT INTO `sys_log` VALUES (246, 'CATEGORY', 'DELETE', '{id=6}', NULL, '删除配置分类', '/api/v1/category/delete/6', NULL, '192.168.2.14', '0', '内网IP', 86, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:55:58', 0);
INSERT INTO `sys_log` VALUES (247, 'CATEGORY', 'DELETE', '{id=3}', NULL, '删除配置分类', '/api/v1/category/delete/3', NULL, '192.168.2.14', '0', '内网IP', 109, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 02:56:01', 0);
INSERT INTO `sys_log` VALUES (248, 'LOGIN', 'POST', 'root 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.14', '0', '内网IP', 550, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 12:37:08', 0);
INSERT INTO `sys_log` VALUES (249, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-11 12:37:08', 0);
INSERT INTO `sys_log` VALUES (250, 'CATEGORY', 'PUT', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 70, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 10:08:00', 0);
INSERT INTO `sys_log` VALUES (251, 'CATEGORY', 'POST', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 10:08:27', 0);
INSERT INTO `sys_log` VALUES (252, 'CATEGORY', 'POST', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 4, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 10:09:21', 0);
INSERT INTO `sys_log` VALUES (253, 'CATEGORY', 'POST', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 8, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 10:12:09', 0);
INSERT INTO `sys_log` VALUES (254, 'CATEGORY', 'PUT', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 94, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 10:14:02', 0);
INSERT INTO `sys_log` VALUES (255, 'CATEGORY', 'PUT', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 61, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 10:15:43', 0);
INSERT INTO `sys_log` VALUES (256, 'CATEGORY', 'PUT', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 54, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 10:24:14', 0);
INSERT INTO `sys_log` VALUES (257, 'CATEGORY', 'PUT', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 54, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 10:25:23', 0);
INSERT INTO `sys_log` VALUES (258, 'CATEGORY', 'PUT', '{\"id\":2,\"pid\":1,\"name\":\"商城基础配置\",\"type\":6,\"url\":\"商城基础配置\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 10:34:14', 0);
INSERT INTO `sys_log` VALUES (259, 'CATEGORY', 'PUT', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 11:25:24', 0);
INSERT INTO `sys_log` VALUES (260, 'CATEGORY', 'PUT', '{\"id\":2,\"pid\":1,\"name\":\"商城基础配置\",\"type\":6,\"url\":\"商城基础配置\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 54, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 11:28:49', 0);
INSERT INTO `sys_log` VALUES (261, 'CATEGORY', 'PUT', '{\"id\":2,\"pid\":1,\"name\":\"商城基础配置\",\"type\":6,\"url\":\"商城基础配置\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 11:30:56', 0);
INSERT INTO `sys_log` VALUES (262, 'CATEGORY', 'PUT', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 124, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 11:32:07', 0);
INSERT INTO `sys_log` VALUES (263, 'CATEGORY', 'PUT', '{\"id\":2,\"pid\":1,\"name\":\"商城基础配置\",\"type\":6,\"url\":\"商城基础配置\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 134, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 11:32:13', 0);
INSERT INTO `sys_log` VALUES (264, 'CATEGORY', 'PUT', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 11:49:23', 0);
INSERT INTO `sys_log` VALUES (265, 'CATEGORY', 'PUT', '{\"id\":1,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 5031, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 13:43:06', 0);
INSERT INTO `sys_log` VALUES (266, 'CATEGORY', 'PUT', '{\"id\":2,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 13:43:12', 0);
INSERT INTO `sys_log` VALUES (267, 'CATEGORY', 'PUT', '{\"id\":2,\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 13:43:19', 0);
INSERT INTO `sys_log` VALUES (268, 'CATEGORY', 'PUT', '{\"id\":2,\"pid\":0,\"name\":\"文件上传配置\",\"type\":2,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":1}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 13:44:04', 0);
INSERT INTO `sys_log` VALUES (269, 'CATEGORY', 'POST', '{\"pid\":0,\"name\":\"文件上传分类\",\"type\":2,\"url\":\"\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 145, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 13:46:32', 0);
INSERT INTO `sys_log` VALUES (270, 'CATEGORY', 'POST', '{\"pid\":7,\"name\":\"基础配置\",\"type\":2,\"url\":\"\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 134, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 13:46:58', 0);
INSERT INTO `sys_log` VALUES (271, 'CATEGORY', 'POST', '{\"pid\":7,\"name\":\"minio配置\",\"type\":2,\"url\":\"\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 141, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 13:47:12', 0);
INSERT INTO `sys_log` VALUES (272, 'CATEGORY', 'PUT', '{\"id\":2,\"pid\":0,\"name\":\"\",\"type\":1,\"url\":\"\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 102, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 13:47:49', 0);
INSERT INTO `sys_log` VALUES (273, 'CATEGORY', 'PUT', '{\"id\":2,\"pid\":0,\"name\":\"\",\"type\":1,\"url\":\"\",\"extra\":\"4\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 126, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 13:48:04', 0);
INSERT INTO `sys_log` VALUES (274, 'CATEGORY', 'DELETE', '{id=2}', NULL, '删除配置分类', '/api/v1/category/delete/2', NULL, '192.168.2.14', '0', '内网IP', 136, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 13:48:44', 0);
INSERT INTO `sys_log` VALUES (275, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:06:24', 0);
INSERT INTO `sys_log` VALUES (276, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:06:46', 0);
INSERT INTO `sys_log` VALUES (277, 'DICT', 'GET', '{\"keywords\":\"mini\",\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:06:56', 0);
INSERT INTO `sys_log` VALUES (278, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:06:58', 0);
INSERT INTO `sys_log` VALUES (279, 'USER', 'GET', '{\"isRoot\":true,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.14', '0', '内网IP', 83, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:07:21', 0);
INSERT INTO `sys_log` VALUES (280, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 59, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:10:57', 0);
INSERT INTO `sys_log` VALUES (281, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 55, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:11:25', 0);
INSERT INTO `sys_log` VALUES (282, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:11:37', 0);
INSERT INTO `sys_log` VALUES (283, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 27, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:12:29', 0);
INSERT INTO `sys_log` VALUES (284, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:13:01', 0);
INSERT INTO `sys_log` VALUES (285, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:01', 0);
INSERT INTO `sys_log` VALUES (286, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:01', 0);
INSERT INTO `sys_log` VALUES (287, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:03', 0);
INSERT INTO `sys_log` VALUES (288, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:03', 0);
INSERT INTO `sys_log` VALUES (289, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:12', 0);
INSERT INTO `sys_log` VALUES (290, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:12', 0);
INSERT INTO `sys_log` VALUES (291, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:16', 0);
INSERT INTO `sys_log` VALUES (292, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 22, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:16', 0);
INSERT INTO `sys_log` VALUES (293, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:20', 0);
INSERT INTO `sys_log` VALUES (294, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:20', 0);
INSERT INTO `sys_log` VALUES (295, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:26', 0);
INSERT INTO `sys_log` VALUES (296, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:15:29', 0);
INSERT INTO `sys_log` VALUES (297, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:16:01', 0);
INSERT INTO `sys_log` VALUES (298, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:16:21', 0);
INSERT INTO `sys_log` VALUES (299, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:16:26', 0);
INSERT INTO `sys_log` VALUES (300, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 22, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:16:29', 0);
INSERT INTO `sys_log` VALUES (301, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:16:30', 0);
INSERT INTO `sys_log` VALUES (302, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:16:31', 0);
INSERT INTO `sys_log` VALUES (303, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:16:34', 0);
INSERT INTO `sys_log` VALUES (304, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:16:36', 0);
INSERT INTO `sys_log` VALUES (305, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:16:48', 0);
INSERT INTO `sys_log` VALUES (306, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:17:11', 0);
INSERT INTO `sys_log` VALUES (307, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:17:15', 0);
INSERT INTO `sys_log` VALUES (308, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:17:42', 0);
INSERT INTO `sys_log` VALUES (309, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:17:45', 0);
INSERT INTO `sys_log` VALUES (310, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 27, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:20:25', 0);
INSERT INTO `sys_log` VALUES (311, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 57, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:20:32', 0);
INSERT INTO `sys_log` VALUES (312, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 60, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:20:40', 0);
INSERT INTO `sys_log` VALUES (313, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:20:57', 0);
INSERT INTO `sys_log` VALUES (314, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:24:01', 0);
INSERT INTO `sys_log` VALUES (315, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:24:26', 0);
INSERT INTO `sys_log` VALUES (316, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:24:45', 0);
INSERT INTO `sys_log` VALUES (317, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:24:46', 0);
INSERT INTO `sys_log` VALUES (318, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:24:48', 0);
INSERT INTO `sys_log` VALUES (319, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:25:51', 0);
INSERT INTO `sys_log` VALUES (320, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:26:32', 0);
INSERT INTO `sys_log` VALUES (321, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:27:11', 0);
INSERT INTO `sys_log` VALUES (322, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:27:14', 0);
INSERT INTO `sys_log` VALUES (323, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:27:29', 0);
INSERT INTO `sys_log` VALUES (324, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:28:04', 0);
INSERT INTO `sys_log` VALUES (325, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:29:20', 0);
INSERT INTO `sys_log` VALUES (326, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 52, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:32:35', 0);
INSERT INTO `sys_log` VALUES (327, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:32:37', 0);
INSERT INTO `sys_log` VALUES (328, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:36:09', 0);
INSERT INTO `sys_log` VALUES (329, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:36:58', 0);
INSERT INTO `sys_log` VALUES (330, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:38:57', 0);
INSERT INTO `sys_log` VALUES (331, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:44:56', 0);
INSERT INTO `sys_log` VALUES (332, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:47:37', 0);
INSERT INTO `sys_log` VALUES (333, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 27, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:48:30', 0);
INSERT INTO `sys_log` VALUES (334, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 15:51:39', 0);
INSERT INTO `sys_log` VALUES (335, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:02:32', 0);
INSERT INTO `sys_log` VALUES (336, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:03:09', 0);
INSERT INTO `sys_log` VALUES (337, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:05:14', 0);
INSERT INTO `sys_log` VALUES (338, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:05:27', 0);
INSERT INTO `sys_log` VALUES (339, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 27, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:07:47', 0);
INSERT INTO `sys_log` VALUES (340, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:12:01', 0);
INSERT INTO `sys_log` VALUES (341, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:12:12', 0);
INSERT INTO `sys_log` VALUES (342, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:19:36', 0);
INSERT INTO `sys_log` VALUES (343, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:19:43', 0);
INSERT INTO `sys_log` VALUES (344, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:21:38', 0);
INSERT INTO `sys_log` VALUES (345, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:21:49', 0);
INSERT INTO `sys_log` VALUES (346, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:24:19', 0);
INSERT INTO `sys_log` VALUES (347, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 27, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:24:28', 0);
INSERT INTO `sys_log` VALUES (348, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:26:23', 0);
INSERT INTO `sys_log` VALUES (349, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 53, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:26:35', 0);
INSERT INTO `sys_log` VALUES (350, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:30:04', 0);
INSERT INTO `sys_log` VALUES (351, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:36:43', 0);
INSERT INTO `sys_log` VALUES (352, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 22, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:45:02', 0);
INSERT INTO `sys_log` VALUES (353, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:50:20', 0);
INSERT INTO `sys_log` VALUES (354, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:54:16', 0);
INSERT INTO `sys_log` VALUES (355, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:54:27', 0);
INSERT INTO `sys_log` VALUES (356, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:57:00', 0);
INSERT INTO `sys_log` VALUES (357, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:57:16', 0);
INSERT INTO `sys_log` VALUES (358, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 16:58:37', 0);
INSERT INTO `sys_log` VALUES (359, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:02:54', 0);
INSERT INTO `sys_log` VALUES (360, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:03:09', 0);
INSERT INTO `sys_log` VALUES (361, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:03:42', 0);
INSERT INTO `sys_log` VALUES (362, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:03:58', 0);
INSERT INTO `sys_log` VALUES (363, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:11:58', 0);
INSERT INTO `sys_log` VALUES (364, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:12:58', 0);
INSERT INTO `sys_log` VALUES (365, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:13:07', 0);
INSERT INTO `sys_log` VALUES (366, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:13:13', 0);
INSERT INTO `sys_log` VALUES (367, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:14:10', 0);
INSERT INTO `sys_log` VALUES (368, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:17:34', 0);
INSERT INTO `sys_log` VALUES (369, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:18:07', 0);
INSERT INTO `sys_log` VALUES (370, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:18:49', 0);
INSERT INTO `sys_log` VALUES (371, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:19:16', 0);
INSERT INTO `sys_log` VALUES (372, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:21:42', 0);
INSERT INTO `sys_log` VALUES (373, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:21:56', 0);
INSERT INTO `sys_log` VALUES (374, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:38:19', 0);
INSERT INTO `sys_log` VALUES (375, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:41:50', 0);
INSERT INTO `sys_log` VALUES (376, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:42:58', 0);
INSERT INTO `sys_log` VALUES (377, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:43:38', 0);
INSERT INTO `sys_log` VALUES (378, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:44:23', 0);
INSERT INTO `sys_log` VALUES (379, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:44:30', 0);
INSERT INTO `sys_log` VALUES (380, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:49:07', 0);
INSERT INTO `sys_log` VALUES (381, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 17:53:58', 0);
INSERT INTO `sys_log` VALUES (382, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 5004, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:01:47', 0);
INSERT INTO `sys_log` VALUES (383, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:02:36', 0);
INSERT INTO `sys_log` VALUES (384, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 11, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:03:17', 0);
INSERT INTO `sys_log` VALUES (385, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:04:20', 0);
INSERT INTO `sys_log` VALUES (386, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 12, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:04:59', 0);
INSERT INTO `sys_log` VALUES (387, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 11, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:07:02', 0);
INSERT INTO `sys_log` VALUES (388, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 12, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:08:18', 0);
INSERT INTO `sys_log` VALUES (389, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:30:36', 0);
INSERT INTO `sys_log` VALUES (390, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:31:20', 0);
INSERT INTO `sys_log` VALUES (391, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 12, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:32:07', 0);
INSERT INTO `sys_log` VALUES (392, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 12, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:33:56', 0);
INSERT INTO `sys_log` VALUES (393, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:34:03', 0);
INSERT INTO `sys_log` VALUES (394, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 11, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:36:56', 0);
INSERT INTO `sys_log` VALUES (395, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:37:23', 0);
INSERT INTO `sys_log` VALUES (396, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:40:12', 0);
INSERT INTO `sys_log` VALUES (397, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:40:46', 0);
INSERT INTO `sys_log` VALUES (398, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:43:49', 0);
INSERT INTO `sys_log` VALUES (399, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 35, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:45:37', 0);
INSERT INTO `sys_log` VALUES (400, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 11, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:46:23', 0);
INSERT INTO `sys_log` VALUES (401, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 12, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:46:28', 0);
INSERT INTO `sys_log` VALUES (402, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-12 19:51:13', 0);
INSERT INTO `sys_log` VALUES (403, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 4995, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 05:08:50', 0);
INSERT INTO `sys_log` VALUES (404, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 05:16:13', 0);
INSERT INTO `sys_log` VALUES (405, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 05:18:35', 0);
INSERT INTO `sys_log` VALUES (406, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 05:32:22', 0);
INSERT INTO `sys_log` VALUES (407, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 05:32:35', 0);
INSERT INTO `sys_log` VALUES (408, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 05:33:16', 0);
INSERT INTO `sys_log` VALUES (409, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 05:33:31', 0);
INSERT INTO `sys_log` VALUES (410, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 05:49:18', 0);
INSERT INTO `sys_log` VALUES (411, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 05:50:03', 0);
INSERT INTO `sys_log` VALUES (412, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 100, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 05:58:39', 0);
INSERT INTO `sys_log` VALUES (413, 'CATEGORY', 'PUT', '{\"id\":9,\"pid\":7,\"name\":\"minio配置\",\"type\":2,\"url\":\"\",\"extra\":\"7\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 142, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:12:13', 0);
INSERT INTO `sys_log` VALUES (414, 'CATEGORY', 'PUT', '{\"id\":9,\"pid\":7,\"name\":\"minio配置\",\"type\":2,\"url\":\"minio配置\",\"extra\":\"7\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:12:23', 0);
INSERT INTO `sys_log` VALUES (415, 'CATEGORY', 'PUT', '{\"id\":9,\"pid\":7,\"name\":\"minio配置\",\"type\":2,\"url\":\"minio配置\",\"extra\":\"7\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 156, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:14:45', 0);
INSERT INTO `sys_log` VALUES (416, 'CATEGORY', 'PUT', '{\"id\":8,\"pid\":7,\"name\":\"minio配置\",\"type\":2,\"url\":\"\",\"extra\":\"7\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 134, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:14:53', 0);
INSERT INTO `sys_log` VALUES (417, 'CATEGORY', 'DELETE', '{id=8}', NULL, '删除配置分类', '/api/v1/category/delete/8', NULL, '192.168.2.14', '0', '内网IP', 97, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:15:19', 0);
INSERT INTO `sys_log` VALUES (418, 'CATEGORY', 'PUT', '{\"id\":1,\"pid\":7,\"name\":\"minio配置\",\"type\":2,\"url\":\"\",\"extra\":\"7\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 127, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:15:25', 0);
INSERT INTO `sys_log` VALUES (419, 'CATEGORY', 'DELETE', '{id=1}', NULL, '删除配置分类', '/api/v1/category/delete/1', NULL, '192.168.2.14', '0', '内网IP', 132, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:15:40', 0);
INSERT INTO `sys_log` VALUES (420, 'CATEGORY', 'POST', '{\"pid\":0,\"name\":\"系统配置\",\"type\":6,\"url\":\"系统配置\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 127, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:17:10', 0);
INSERT INTO `sys_log` VALUES (421, 'CATEGORY', 'PUT', '{\"id\":7,\"pid\":0,\"name\":\"文件上传分类\",\"type\":2,\"url\":\"文件上传分类\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 127, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:25:01', 0);
INSERT INTO `sys_log` VALUES (422, 'CATEGORY', 'PUT', '{\"id\":10,\"pid\":0,\"name\":\"系统配置\",\"type\":6,\"url\":\"系统配置1\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 95, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:25:11', 0);
INSERT INTO `sys_log` VALUES (423, 'CATEGORY', 'PUT', '{\"id\":10,\"pid\":0,\"name\":\"系统配置\",\"type\":6,\"url\":\"系统配置\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 110, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:25:16', 0);
INSERT INTO `sys_log` VALUES (424, 'CATEGORY', 'PUT', '{\"id\":7,\"pid\":7,\"name\":\"文件上传分类\",\"type\":2,\"url\":\"文件上传分类\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 95, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:25:54', 0);
INSERT INTO `sys_log` VALUES (425, 'CATEGORY', 'PUT', '{\"id\":10,\"pid\":0,\"name\":\"系统配置\",\"type\":6,\"url\":\"系统配置\",\"extra\":\"\",\"status\":true,\"sort\":1}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 112, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:27:10', 0);
INSERT INTO `sys_log` VALUES (426, 'CATEGORY', 'PUT', '{\"id\":10,\"pid\":0,\"name\":\"系统配置\",\"type\":6,\"url\":\"系统配置\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 109, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:27:17', 0);
INSERT INTO `sys_log` VALUES (427, 'CATEGORY', 'PUT', '{\"id\":7,\"pid\":0,\"name\":\"文件上传分类\",\"type\":2,\"url\":\"文件上传分类\",\"extra\":\"\",\"status\":true,\"sort\":1}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 127, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:27:20', 0);
INSERT INTO `sys_log` VALUES (428, 'CATEGORY', 'PUT', '{\"id\":10,\"pid\":0,\"name\":\"系统配置\",\"type\":6,\"url\":\"系统配置\",\"extra\":\"\",\"status\":false,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 103, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:32:37', 0);
INSERT INTO `sys_log` VALUES (429, 'CATEGORY', 'PUT', '{\"id\":10,\"pid\":0,\"name\":\"系统配置\",\"type\":6,\"url\":\"系统配置\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 119, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:33:54', 0);
INSERT INTO `sys_log` VALUES (430, 'CATEGORY', 'PUT', '{\"id\":9,\"pid\":7,\"name\":\"minio配置\",\"type\":6,\"url\":\"minio配置\",\"extra\":\"7\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 111, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:42:09', 0);
INSERT INTO `sys_log` VALUES (431, 'CATEGORY', 'POST', '{\"pid\":10,\"name\":\"文件上传配置-minio配置\",\"type\":6,\"url\":\"minio配置\",\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 111, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:43:13', 0);
INSERT INTO `sys_log` VALUES (432, 'CATEGORY', 'POST', '{\"pid\":0,\"extra\":\"7\",\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 262, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:43:21', 0);
INSERT INTO `sys_log` VALUES (433, 'CATEGORY', 'GET', '{} {}', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 148, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:54:16', 0);
INSERT INTO `sys_log` VALUES (434, 'CATEGORY', 'GET', '{} 7', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:58:10', 0);
INSERT INTO `sys_log` VALUES (435, 'CATEGORY', 'GET', '{}', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:58:14', 0);
INSERT INTO `sys_log` VALUES (436, 'CATEGORY', 'GET', '{}', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:58:18', 0);
INSERT INTO `sys_log` VALUES (437, 'CATEGORY', 'GET', '{}', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 88, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:59:24', 0);
INSERT INTO `sys_log` VALUES (438, 'CATEGORY', 'GET', '{} 7', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 118, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 06:59:38', 0);
INSERT INTO `sys_log` VALUES (439, 'CATEGORY', 'GET', '{}', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 107, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:00:18', 0);
INSERT INTO `sys_log` VALUES (440, 'CATEGORY', 'GET', '{} 7', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 110, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:00:21', 0);
INSERT INTO `sys_log` VALUES (441, 'CATEGORY', 'PUT', '{\"id\":7,\"pid\":0,\"name\":\"素材管理分类\",\"type\":2,\"url\":\"素材管理分类\",\"extra\":\"\",\"status\":true,\"sort\":1}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 130, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:01:27', 0);
INSERT INTO `sys_log` VALUES (442, 'CATEGORY', 'POST', '{\"pid\":7,\"name\":\"LOGO\",\"type\":2,\"url\":\"LOGO\",\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 133, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:01:41', 0);
INSERT INTO `sys_log` VALUES (443, 'CATEGORY', 'POST', '{\"pid\":7,\"name\":\"Banner素材\",\"type\":2,\"url\":\"Banner素材\",\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 116, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:02:00', 0);
INSERT INTO `sys_log` VALUES (444, 'CATEGORY', 'POST', '{\"pid\":7,\"name\":\"推广海报\",\"type\":2,\"url\":\"推广海报\",\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 110, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:02:26', 0);
INSERT INTO `sys_log` VALUES (445, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 40, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:06:30', 0);
INSERT INTO `sys_log` VALUES (446, 'OTHER', 'POST', '{\"tableName\":\"sys_attachment\",\"businessName\":\"附件管理\",\"moduleName\":\"system\",\"packageName\":\"com.youlai.boot\",\"entityName\":\"SysAttachment\",\"author\":\"MrZhang\",\"fieldConfigs\":[{\"columnName\":\"att_id\",\"columnType\":\"int\",\"fieldName\":\"attId\",\"fieldSort\":1,\"fieldType\":\"Integer\",\"fieldComment\":\"\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"name\",\"columnType\":\"varchar\",\"fieldName\":\"name\",\"fieldSort\":2,\"fieldType\":\"String\",\"fieldComment\":\"附件名称\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"maxLength\":100,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"att_dir\",\"columnType\":\"varchar\",\"fieldName\":\"attDir\",\"fieldSort\":3,\"fieldType\":\"String\",\"fieldComment\":\"附件路径\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"maxLength\":200,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"satt_dir\",\"columnType\":\"varchar\",\"fieldName\":\"sattDir\",\"fieldSort\":4,\"fieldType\":\"String\",\"fieldComment\":\"压缩图片路径\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"maxLength\":200,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"att_size\",\"columnType\":\"char\",\"fieldName\":\"attSize\",\"fieldSort\":5,\"fieldType\":\"String\",\"fieldComment\":\"附件大小\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"maxLength\":30,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"att_type\",\"columnType\":\"char\",\"fieldName\":\"attType\",\"fieldSort\":6,\"fieldType\":\"String\",\"fieldComment\":\"附件类型\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"maxLength\":30,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"pid\",\"columnType\":\"int\",\"fieldName\":\"pid\",\"fieldSort\":7,\"fieldType\":\"Integer\",\"fieldComment\":\"分类ID\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"image_type\",\"columnType\":\"tinyint\",\"fieldName\":\"imageType\",\"fieldSort\":8,\"fieldType\":\"Integer\",\"fieldComment\":\"图片上传类型\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"create_time\",\"columnType\":\"timestamp\",\"fieldName\":\"createTime\",\"fieldSort\":9,\"fieldComment\":\"创建时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"update_time\",\"columnType\":\"timestamp\",\"fieldName\":\"updateTime\",\"fieldSort\":10,\"fieldComment\":\"更新时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"}],\"backendAppName\":\"youlai-boot\",\"frontendAppName\":\"vue3-element-admin\"}', NULL, '生成代码', '/api/v1/codegen/sys_attachment/config', NULL, '192.168.2.14', '0', '内网IP', 437, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:07:28', 0);
INSERT INTO `sys_log` VALUES (447, 'OTHER', 'GET', 'sys_attachment', NULL, '预览生成代码', '/api/v1/codegen/sys_attachment/preview', NULL, '192.168.2.14', '0', '内网IP', 752, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:07:29', 0);
INSERT INTO `sys_log` VALUES (448, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:07:47', 0);
INSERT INTO `sys_log` VALUES (449, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 44, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:08:58', 0);
INSERT INTO `sys_log` VALUES (450, 'CATEGORY', 'PUT', '{\"id\":7,\"pid\":0,\"name\":\"素材管理分类\",\"type\":2,\"url\":\"素材管理分类\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 92, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 07:19:14', 0);
INSERT INTO `sys_log` VALUES (451, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 09:49:44', 0);
INSERT INTO `sys_log` VALUES (452, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 09:49:51', 0);
INSERT INTO `sys_log` VALUES (453, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 12, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 09:50:00', 0);
INSERT INTO `sys_log` VALUES (454, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 09:51:02', 0);
INSERT INTO `sys_log` VALUES (455, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 11, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 09:51:11', 0);
INSERT INTO `sys_log` VALUES (456, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 09:51:19', 0);
INSERT INTO `sys_log` VALUES (457, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 11:05:31', 0);
INSERT INTO `sys_log` VALUES (458, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 11:05:47', 0);
INSERT INTO `sys_log` VALUES (459, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 11, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 11:09:21', 0);
INSERT INTO `sys_log` VALUES (460, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 12, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 11:09:31', 0);
INSERT INTO `sys_log` VALUES (461, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 11, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 11:09:38', 0);
INSERT INTO `sys_log` VALUES (462, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 80, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 13:05:30', 0);
INSERT INTO `sys_log` VALUES (463, 'OTHER', 'GET', 'sys_attachment', NULL, '预览生成代码', '/api/v1/codegen/sys_attachment/preview', NULL, '192.168.2.14', '0', '内网IP', 424, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 13:05:36', 0);
INSERT INTO `sys_log` VALUES (464, 'OTHER', 'POST', '{\"id\":4,\"tableName\":\"sys_attachment\",\"businessName\":\"附件管理\",\"moduleName\":\"system\",\"packageName\":\"com.youlai.boot\",\"entityName\":\"Attachment\",\"author\":\"MrZhang\",\"fieldConfigs\":[{\"id\":23,\"columnName\":\"att_id\",\"columnType\":\"int\",\"fieldName\":\"attId\",\"fieldSort\":1,\"fieldType\":\"Integer\",\"fieldComment\":\"\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":24,\"columnName\":\"name\",\"columnType\":\"varchar\",\"fieldName\":\"name\",\"fieldSort\":2,\"fieldType\":\"String\",\"fieldComment\":\"附件名称\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"maxLength\":100,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":25,\"columnName\":\"att_dir\",\"columnType\":\"varchar\",\"fieldName\":\"attDir\",\"fieldSort\":3,\"fieldType\":\"String\",\"fieldComment\":\"附件路径\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"maxLength\":200,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":26,\"columnName\":\"satt_dir\",\"columnType\":\"varchar\",\"fieldName\":\"sattDir\",\"fieldSort\":4,\"fieldType\":\"String\",\"fieldComment\":\"压缩图片路径\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"maxLength\":200,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":27,\"columnName\":\"att_size\",\"columnType\":\"char\",\"fieldName\":\"attSize\",\"fieldSort\":5,\"fieldType\":\"String\",\"fieldComment\":\"附件大小\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"maxLength\":30,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":28,\"columnName\":\"att_type\",\"columnType\":\"char\",\"fieldName\":\"attType\",\"fieldSort\":6,\"fieldType\":\"String\",\"fieldComment\":\"附件类型\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"maxLength\":30,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":29,\"columnName\":\"pid\",\"columnType\":\"int\",\"fieldName\":\"pid\",\"fieldSort\":7,\"fieldType\":\"Integer\",\"fieldComment\":\"分类ID\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":30,\"columnName\":\"image_type\",\"columnType\":\"tinyint\",\"fieldName\":\"imageType\",\"fieldSort\":8,\"fieldType\":\"Integer\",\"fieldComment\":\"图片上传类型\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":31,\"columnName\":\"create_time\",\"columnType\":\"timestamp\",\"fieldName\":\"createTime\",\"fieldSort\":9,\"fieldComment\":\"创建时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"id\":32,\"columnName\":\"update_time\",\"columnType\":\"timestamp\",\"fieldName\":\"updateTime\",\"fieldSort\":10,\"fieldComment\":\"更新时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isShowInQuery\":0,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"}],\"backendAppName\":\"youlai-boot\",\"frontendAppName\":\"vue3-element-admin\"}', NULL, '生成代码', '/api/v1/codegen/sys_attachment/config', NULL, '192.168.2.14', '0', '内网IP', 870, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 13:06:52', 0);
INSERT INTO `sys_log` VALUES (465, 'OTHER', 'GET', 'sys_attachment', NULL, '预览生成代码', '/api/v1/codegen/sys_attachment/preview', NULL, '192.168.2.14', '0', '内网IP', 297, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 13:06:53', 0);
INSERT INTO `sys_log` VALUES (466, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 53, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 13:29:49', 0);
INSERT INTO `sys_log` VALUES (467, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 61, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 13:31:40', 0);
INSERT INTO `sys_log` VALUES (468, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 63, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:39:41', 0);
INSERT INTO `sys_log` VALUES (469, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 48, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:39:47', 0);
INSERT INTO `sys_log` VALUES (470, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 44, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:41:07', 0);
INSERT INTO `sys_log` VALUES (471, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:41:13', 0);
INSERT INTO `sys_log` VALUES (472, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 48, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:55:52', 0);
INSERT INTO `sys_log` VALUES (473, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:55:55', 0);
INSERT INTO `sys_log` VALUES (474, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 35, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:56:19', 0);
INSERT INTO `sys_log` VALUES (475, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 99, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:56:23', 0);
INSERT INTO `sys_log` VALUES (476, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 37, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:57:20', 0);
INSERT INTO `sys_log` VALUES (477, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:57:22', 0);
INSERT INTO `sys_log` VALUES (478, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 52, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:58:05', 0);
INSERT INTO `sys_log` VALUES (479, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 38, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:58:07', 0);
INSERT INTO `sys_log` VALUES (480, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 35, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:59:03', 0);
INSERT INTO `sys_log` VALUES (481, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 85, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 14:59:17', 0);
INSERT INTO `sys_log` VALUES (482, 'CATEGORY', 'PUT', '{\"id\":11,\"pid\":10,\"name\":\"minio配置\",\"type\":6,\"url\":\"minio配置\",\"extra\":\"7\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 112, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 15:01:05', 0);
INSERT INTO `sys_log` VALUES (483, 'CATEGORY', 'PUT', '{\"id\":10,\"pid\":0,\"name\":\"文件上传配置\",\"type\":6,\"url\":\"文件上传配置\",\"extra\":\"\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 116, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 15:01:29', 0);
INSERT INTO `sys_log` VALUES (484, 'CATEGORY', 'POST', '{\"pid\":0,\"name\":\"商城配置\",\"type\":6,\"url\":\"商城配置\",\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 106, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 15:01:49', 0);
INSERT INTO `sys_log` VALUES (485, 'CATEGORY', 'POST', '{\"pid\":15,\"name\":\"商城基础配置\",\"type\":6,\"url\":\"商城基础配置\",\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 151, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 15:02:41', 0);
INSERT INTO `sys_log` VALUES (486, 'CATEGORY', 'POST', '{\"pid\":10,\"name\":\"文件上传基础配置\",\"type\":6,\"url\":\"文件上传基础配置\",\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 120, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 15:03:05', 0);
INSERT INTO `sys_log` VALUES (487, 'CATEGORY', 'PUT', '{\"id\":17,\"pid\":10,\"name\":\"基础配置\",\"type\":6,\"url\":\"基础配置\",\"status\":true,\"sort\":0}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 120, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 15:03:14', 0);
INSERT INTO `sys_log` VALUES (488, 'CATEGORY', 'PUT', '{\"id\":11,\"pid\":10,\"name\":\"minio配置\",\"type\":6,\"url\":\"minio配置\",\"extra\":\"7\",\"status\":true,\"sort\":1}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 113, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 15:03:23', 0);
INSERT INTO `sys_log` VALUES (489, 'CATEGORY', 'PUT', '{\"id\":7,\"pid\":0,\"name\":\"素材管理分类\",\"type\":2,\"url\":\"素材管理分类\",\"extra\":\"\",\"status\":true,\"sort\":1}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 117, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 15:15:59', 0);
INSERT INTO `sys_log` VALUES (490, 'CATEGORY', 'PUT', '{\"id\":10,\"pid\":0,\"name\":\"文件上传配置\",\"type\":6,\"url\":\"文件上传配置\",\"extra\":\"\",\"status\":true,\"sort\":1}', NULL, '修改配置分类', '/api/v1/category/update', NULL, '192.168.2.14', '0', '内网IP', 120, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 15:16:10', 0);
INSERT INTO `sys_log` VALUES (491, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:14:16', 0);
INSERT INTO `sys_log` VALUES (492, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:16:37', 0);
INSERT INTO `sys_log` VALUES (493, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:19:04', 0);
INSERT INTO `sys_log` VALUES (494, 'SETTING', 'PUT', '{} {\"minioUploadUrl\":\"1\",\"minioAccessKey\":\"1\",\"minioSecretKey\":\"1\",\"minioBucket\":\"1\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 744, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:19:11', 0);
INSERT INTO `sys_log` VALUES (495, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:19:26', 0);
INSERT INTO `sys_log` VALUES (496, 'SETTING', 'PUT', '{} {\"minioUploadUrl\":\"1\",\"minioAccessKey\":\"1\",\"minioSecretKey\":\"1\",\"minioBucket\":\"1\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 5825, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:21:25', 0);
INSERT INTO `sys_log` VALUES (497, 'SETTING', 'PUT', '{} {\"minioUploadUrl\":\"1\",\"minioAccessKey\":\"1\",\"minioSecretKey\":\"1\",\"minioBucket\":\"1\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 693, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:23:06', 0);
INSERT INTO `sys_log` VALUES (498, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:25:09', 0);
INSERT INTO `sys_log` VALUES (499, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:25:46', 0);
INSERT INTO `sys_log` VALUES (500, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:27:51', 0);
INSERT INTO `sys_log` VALUES (501, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:28:11', 0);
INSERT INTO `sys_log` VALUES (502, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:29:37', 0);
INSERT INTO `sys_log` VALUES (503, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:33:00', 0);
INSERT INTO `sys_log` VALUES (504, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:34:23', 0);
INSERT INTO `sys_log` VALUES (505, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:35:25', 0);
INSERT INTO `sys_log` VALUES (506, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:36:25', 0);
INSERT INTO `sys_log` VALUES (507, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:36:33', 0);
INSERT INTO `sys_log` VALUES (508, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:39:12', 0);
INSERT INTO `sys_log` VALUES (509, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:39:20', 0);
INSERT INTO `sys_log` VALUES (510, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 27, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:44:27', 0);
INSERT INTO `sys_log` VALUES (511, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:45:45', 0);
INSERT INTO `sys_log` VALUES (512, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:48:18', 0);
INSERT INTO `sys_log` VALUES (513, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:52:07', 0);
INSERT INTO `sys_log` VALUES (514, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:53:24', 0);
INSERT INTO `sys_log` VALUES (515, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:53:52', 0);
INSERT INTO `sys_log` VALUES (516, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:54:04', 0);
INSERT INTO `sys_log` VALUES (517, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:54:09', 0);
INSERT INTO `sys_log` VALUES (518, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:54:58', 0);
INSERT INTO `sys_log` VALUES (519, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:55:23', 0);
INSERT INTO `sys_log` VALUES (520, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:55:53', 0);
INSERT INTO `sys_log` VALUES (521, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:55:57', 0);
INSERT INTO `sys_log` VALUES (522, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:56:09', 0);
INSERT INTO `sys_log` VALUES (523, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:56:39', 0);
INSERT INTO `sys_log` VALUES (524, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:56:44', 0);
INSERT INTO `sys_log` VALUES (525, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:57:24', 0);
INSERT INTO `sys_log` VALUES (526, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:57:34', 0);
INSERT INTO `sys_log` VALUES (527, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:57:46', 0);
INSERT INTO `sys_log` VALUES (528, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 18:58:11', 0);
INSERT INTO `sys_log` VALUES (529, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:12:17', 0);
INSERT INTO `sys_log` VALUES (530, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:14:43', 0);
INSERT INTO `sys_log` VALUES (531, 'SETTING', 'PUT', '{} {\"minioUploadUrl\":\"https://file.usdtzc.top\",\"minioAccessKey\":\"zhang10867779\",\"minioSecretKey\":\"zhangze123..\",\"minioBucket\":\"usdt\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 811, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:15:44', 0);
INSERT INTO `sys_log` VALUES (532, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:15:45', 0);
INSERT INTO `sys_log` VALUES (533, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:16:02', 0);
INSERT INTO `sys_log` VALUES (534, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:16:49', 0);
INSERT INTO `sys_log` VALUES (535, 'CATEGORY', 'GET', '{} 8', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 110, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:18:19', 0);
INSERT INTO `sys_log` VALUES (536, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:18:24', 0);
INSERT INTO `sys_log` VALUES (537, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:18:27', 0);
INSERT INTO `sys_log` VALUES (538, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:18:28', 0);
INSERT INTO `sys_log` VALUES (539, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:18:29', 0);
INSERT INTO `sys_log` VALUES (540, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:18:44', 0);
INSERT INTO `sys_log` VALUES (541, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.2.14', '0', '内网IP', 33, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', NULL, '2025-05-13 19:19:20', 0);
INSERT INTO `sys_log` VALUES (542, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.14', '0', '内网IP', 313, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-13 19:19:25', 0);
INSERT INTO `sys_log` VALUES (543, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.14', '0', '内网IP', 27, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-13 19:19:26', 0);
INSERT INTO `sys_log` VALUES (544, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.14', '0', '内网IP', 151, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-13 19:19:29', 0);
INSERT INTO `sys_log` VALUES (545, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-13 19:19:29', 0);
INSERT INTO `sys_log` VALUES (546, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.14', '0', '内网IP', 143, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-13 19:19:31', 0);
INSERT INTO `sys_log` VALUES (547, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-13 19:19:32', 0);
INSERT INTO `sys_log` VALUES (548, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.2.14', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', NULL, '2025-05-13 19:19:57', 0);
INSERT INTO `sys_log` VALUES (549, 'LOGIN', 'POST', 'root 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.14', '0', '内网IP', 147, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:20:09', 0);
INSERT INTO `sys_log` VALUES (550, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.14', '0', '内网IP', 12, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:20:10', 0);
INSERT INTO `sys_log` VALUES (551, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:21:05', 0);
INSERT INTO `sys_log` VALUES (552, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 19:21:08', 0);
INSERT INTO `sys_log` VALUES (553, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 20:35:59', 0);
INSERT INTO `sys_log` VALUES (554, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 20:36:37', 0);
INSERT INTO `sys_log` VALUES (555, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 20:38:45', 0);
INSERT INTO `sys_log` VALUES (556, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 20:38:51', 0);
INSERT INTO `sys_log` VALUES (557, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 12, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 20:39:47', 0);
INSERT INTO `sys_log` VALUES (558, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 20:39:57', 0);
INSERT INTO `sys_log` VALUES (559, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 20:42:20', 0);
INSERT INTO `sys_log` VALUES (560, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 20:42:21', 0);
INSERT INTO `sys_log` VALUES (561, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 20:42:34', 0);
INSERT INTO `sys_log` VALUES (562, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 20:42:35', 0);
INSERT INTO `sys_log` VALUES (563, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 20:42:36', 0);
INSERT INTO `sys_log` VALUES (564, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 21:02:30', 0);
INSERT INTO `sys_log` VALUES (565, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:27:32', 0);
INSERT INTO `sys_log` VALUES (566, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:29:22', 0);
INSERT INTO `sys_log` VALUES (567, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:31:51', 0);
INSERT INTO `sys_log` VALUES (568, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:32:28', 0);
INSERT INTO `sys_log` VALUES (569, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:33:01', 0);
INSERT INTO `sys_log` VALUES (570, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:33:28', 0);
INSERT INTO `sys_log` VALUES (571, 'CATEGORY', 'GET', '{} 9', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 154, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:38:35', 0);
INSERT INTO `sys_log` VALUES (572, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:38:43', 0);
INSERT INTO `sys_log` VALUES (573, 'SETTING', 'PUT', '{} {\"minioUploadUrl\":\"https://file.usdtzc.top\",\"minioAccessKey\":\"zhang10867779\",\"minioSecretKey\":\"zhangze123..\",\"minioBucket\":\"usdt\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 467, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:39:08', 0);
INSERT INTO `sys_log` VALUES (574, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:39:09', 0);
INSERT INTO `sys_log` VALUES (575, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:39:15', 0);
INSERT INTO `sys_log` VALUES (576, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:39:38', 0);
INSERT INTO `sys_log` VALUES (577, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 52, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:39:42', 0);
INSERT INTO `sys_log` VALUES (578, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:42:56', 0);
INSERT INTO `sys_log` VALUES (579, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 41, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:44:00', 0);
INSERT INTO `sys_log` VALUES (580, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 53, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:45:00', 0);
INSERT INTO `sys_log` VALUES (581, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:46:44', 0);
INSERT INTO `sys_log` VALUES (582, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 31, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:48:30', 0);
INSERT INTO `sys_log` VALUES (583, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 22, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:49:03', 0);
INSERT INTO `sys_log` VALUES (584, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 22, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:49:27', 0);
INSERT INTO `sys_log` VALUES (585, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:50:21', 0);
INSERT INTO `sys_log` VALUES (586, 'CATEGORY', 'GET', '{} 10', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 120, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:51:10', 0);
INSERT INTO `sys_log` VALUES (587, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:51:38', 0);
INSERT INTO `sys_log` VALUES (588, 'SETTING', 'PUT', '{} {\"image_ext_str\":\"jpg,jpeg,gif,png,bmp,PNG,JPG,mp4,avif\",\"image_max_size\":\"10\",\"file_ext_str\":\"zip,doc,docx,xls,xlsx,pdf,mp3,wma,wav,amr,mp4\",\"file_max_size\":\"20\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 652, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:52:26', 0);
INSERT INTO `sys_log` VALUES (589, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:52:27', 0);
INSERT INTO `sys_log` VALUES (590, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:52:28', 0);
INSERT INTO `sys_log` VALUES (591, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:52:30', 0);
INSERT INTO `sys_log` VALUES (592, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-13 22:52:42', 0);
INSERT INTO `sys_log` VALUES (593, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 22, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 00:10:00', 0);
INSERT INTO `sys_log` VALUES (594, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 00:10:01', 0);
INSERT INTO `sys_log` VALUES (595, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 35, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 00:10:05', 0);
INSERT INTO `sys_log` VALUES (596, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 22, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 00:10:43', 0);
INSERT INTO `sys_log` VALUES (597, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 00:10:48', 0);
INSERT INTO `sys_log` VALUES (598, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dicts/page', NULL, '192.168.2.14', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 00:30:47', 0);
INSERT INTO `sys_log` VALUES (599, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 38, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 00:30:50', 0);
INSERT INTO `sys_log` VALUES (600, 'SETTING', 'PUT', '', NULL, '刷新系统配置缓存', '/api/v1/config/refresh', NULL, '192.168.2.14', '0', '内网IP', 101, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 00:30:59', 0);
INSERT INTO `sys_log` VALUES (601, 'USER', 'GET', '{\"isRoot\":true,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.2.14', '0', '内网IP', 58, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 00:52:07', 0);
INSERT INTO `sys_log` VALUES (602, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 01:52:21', 0);
INSERT INTO `sys_log` VALUES (603, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 01:52:23', 0);
INSERT INTO `sys_log` VALUES (604, 'SETTING', 'PUT', '{} {\"minioUploadUrl\":\"http://192.168.2.18:9000\",\"minioAccessKey\":\"zhang10867779\",\"minioSecretKey\":\"zhangze123..\",\"minioBucket\":\"usdt\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 799, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 01:52:31', 0);
INSERT INTO `sys_log` VALUES (605, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 01:52:32', 0);
INSERT INTO `sys_log` VALUES (606, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 40, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 01:52:49', 0);
INSERT INTO `sys_log` VALUES (607, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 18, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 03:12:06', 0);
INSERT INTO `sys_log` VALUES (608, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 03:12:09', 0);
INSERT INTO `sys_log` VALUES (609, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 03:12:09', 0);
INSERT INTO `sys_log` VALUES (610, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 03:12:46', 0);
INSERT INTO `sys_log` VALUES (611, 'SETTING', 'PUT', '{} {\"id\":18,\"configName\":\"image_ext_str\",\"configKey\":\"image_ext_str\",\"configValue\":\"jpg,jpeg,gif,png,bmp,PNG,JPG,mp4\",\"formId\":10}', NULL, '修改系统配置', '/api/v1/config/18', NULL, '192.168.2.14', '0', '内网IP', 146, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 03:12:52', 0);
INSERT INTO `sys_log` VALUES (612, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 03:12:53', 0);
INSERT INTO `sys_log` VALUES (613, 'SETTING', 'PUT', '', NULL, '刷新系统配置缓存', '/api/v1/config/refresh', NULL, '192.168.2.14', '0', '内网IP', 86, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 03:13:08', 0);
INSERT INTO `sys_log` VALUES (614, 'SETTING', 'PUT', '{} {\"id\":1,\"configName\":\"系统限流QPS\",\"configKey\":\"IP_QPS_THRESHOLD_LIMIT\",\"configValue\":\"100\",\"remark\":\"单个IP请求的最大每秒查询数（QPS）阈值Key\",\"formId\":0}', NULL, '修改系统配置', '/api/v1/config/1', NULL, '192.168.2.14', '0', '内网IP', 155, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 03:14:36', 0);
INSERT INTO `sys_log` VALUES (615, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 03:14:36', 0);
INSERT INTO `sys_log` VALUES (616, 'SETTING', 'PUT', '', NULL, '刷新系统配置缓存', '/api/v1/config/refresh', NULL, '192.168.2.14', '0', '内网IP', 110, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 03:14:38', 0);
INSERT INTO `sys_log` VALUES (617, 'CATEGORY', 'POST', '{\"name\":\"test\",\"type\":2,\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 117, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 14:48:34', 0);
INSERT INTO `sys_log` VALUES (618, 'CATEGORY', 'POST', '{\"pid\":12,\"name\":\"前端\",\"type\":2,\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 120, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 14:51:35', 0);
INSERT INTO `sys_log` VALUES (619, 'CATEGORY', 'DELETE', '{id=19}', NULL, '删除配置分类', '/api/v1/category/delete/19', NULL, '192.168.2.14', '0', '内网IP', 287, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 14:52:00', 0);
INSERT INTO `sys_log` VALUES (620, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 14:52:56', 0);
INSERT INTO `sys_log` VALUES (621, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 14:52:58', 0);
INSERT INTO `sys_log` VALUES (622, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 14:53:00', 0);
INSERT INTO `sys_log` VALUES (623, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 18:44:56', 0);
INSERT INTO `sys_log` VALUES (624, 'SETTING', 'PUT', '{} {\"image_ext_str\":\"jpg,jpeg,gif,png,bmp,PNG,JPG,mp4,avif\",\"image_max_size\":\"10\",\"file_ext_str\":\"zip,doc,docx,xls,xlsx,pdf,mp3,wma,wav,amr,mp4\",\"file_max_size\":\"20\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 759, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 18:45:16', 0);
INSERT INTO `sys_log` VALUES (625, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 18:45:17', 0);
INSERT INTO `sys_log` VALUES (626, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 64, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 18:45:22', 0);
INSERT INTO `sys_log` VALUES (627, 'SETTING', 'PUT', '', NULL, '刷新系统配置缓存', '/api/v1/config/refresh', NULL, '192.168.2.14', '0', '内网IP', 94, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 18:45:24', 0);
INSERT INTO `sys_log` VALUES (628, 'CATEGORY', 'GET', '{} 11', NULL, '绑定表单', '/api/v1/category/bindForm', NULL, '192.168.2.14', '0', '内网IP', 136, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:46:24', 0);
INSERT INTO `sys_log` VALUES (629, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:46:28', 0);
INSERT INTO `sys_log` VALUES (630, 'SETTING', 'PUT', '{} {}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 55, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:46:35', 0);
INSERT INTO `sys_log` VALUES (631, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:46:35', 0);
INSERT INTO `sys_log` VALUES (632, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 44, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:47:08', 0);
INSERT INTO `sys_log` VALUES (633, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:47:19', 0);
INSERT INTO `sys_log` VALUES (634, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:49:10', 0);
INSERT INTO `sys_log` VALUES (635, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:49:26', 0);
INSERT INTO `sys_log` VALUES (636, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:53:02', 0);
INSERT INTO `sys_log` VALUES (637, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:54:09', 0);
INSERT INTO `sys_log` VALUES (638, 'SETTING', 'PUT', '{} {\"upload\":\"/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 237, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:54:22', 0);
INSERT INTO `sys_log` VALUES (639, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:54:23', 0);
INSERT INTO `sys_log` VALUES (640, 'SETTING', 'PUT', '{} {\"upload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 220, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:55:23', 0);
INSERT INTO `sys_log` VALUES (641, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:55:24', 0);
INSERT INTO `sys_log` VALUES (642, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:56:57', 0);
INSERT INTO `sys_log` VALUES (643, 'SETTING', 'PUT', '{} {\"upload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 211, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:57:01', 0);
INSERT INTO `sys_log` VALUES (644, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:57:01', 0);
INSERT INTO `sys_log` VALUES (645, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:57:13', 0);
INSERT INTO `sys_log` VALUES (646, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:57:20', 0);
INSERT INTO `sys_log` VALUES (647, 'SETTING', 'PUT', '{} {\"upload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 228, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:59:29', 0);
INSERT INTO `sys_log` VALUES (648, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 55, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-14 23:59:29', 0);
INSERT INTO `sys_log` VALUES (649, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:00:26', 0);
INSERT INTO `sys_log` VALUES (650, 'SETTING', 'PUT', '{} {\"upload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 258, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:00:33', 0);
INSERT INTO `sys_log` VALUES (651, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:00:33', 0);
INSERT INTO `sys_log` VALUES (652, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:05:16', 0);
INSERT INTO `sys_log` VALUES (653, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:05:53', 0);
INSERT INTO `sys_log` VALUES (654, 'SETTING', 'PUT', '{} {\"upload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\",\"uoload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 288, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:05:59', 0);
INSERT INTO `sys_log` VALUES (655, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 14, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:05:59', 0);
INSERT INTO `sys_log` VALUES (656, 'SETTING', 'PUT', '{} {\"upload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\",\"uoload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 546, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:09:04', 0);
INSERT INTO `sys_log` VALUES (657, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 23, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:09:05', 0);
INSERT INTO `sys_log` VALUES (658, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:09:08', 0);
INSERT INTO `sys_log` VALUES (659, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 70, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:12:49', 0);
INSERT INTO `sys_log` VALUES (660, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 127, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:12:58', 0);
INSERT INTO `sys_log` VALUES (661, 'OTHER', 'POST', '{\"tableName\":\"sys_group\",\"businessName\":\"组合数据分类\",\"moduleName\":\"system\",\"packageName\":\"com.youlai.boot\",\"entityName\":\"SysGroup\",\"author\":\"MrZhang\",\"fieldConfigs\":[{\"columnName\":\"id\",\"columnType\":\"int\",\"fieldName\":\"id\",\"fieldSort\":1,\"fieldType\":\"Integer\",\"fieldComment\":\"组合数据ID\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"name\",\"columnType\":\"varchar\",\"fieldName\":\"name\",\"fieldSort\":2,\"fieldType\":\"String\",\"fieldComment\":\"数据组名称\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"maxLength\":50,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"info\",\"columnType\":\"varchar\",\"fieldName\":\"info\",\"fieldSort\":3,\"fieldType\":\"String\",\"fieldComment\":\"简介\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"maxLength\":256,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"form_id\",\"columnType\":\"int\",\"fieldName\":\"formId\",\"fieldSort\":4,\"fieldType\":\"Integer\",\"fieldComment\":\"form 表单 id\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"create_time\",\"columnType\":\"timestamp\",\"fieldName\":\"createTime\",\"fieldSort\":5,\"fieldComment\":\"创建时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"update_time\",\"columnType\":\"timestamp\",\"fieldName\":\"updateTime\",\"fieldSort\":6,\"fieldComment\":\"更新时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"}],\"backendAppName\":\"youlai-boot\",\"frontendAppName\":\"vue3-element-admin\"}', NULL, '生成代码', '/api/v1/codegen/sys_group/config', NULL, '192.168.2.14', '0', '内网IP', 313, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:13:41', 0);
INSERT INTO `sys_log` VALUES (662, 'OTHER', 'GET', 'sys_group', NULL, '预览生成代码', '/api/v1/codegen/sys_group/preview', NULL, '192.168.2.14', '0', '内网IP', 1072, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:13:42', 0);
INSERT INTO `sys_log` VALUES (663, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 78, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:31:06', 0);
INSERT INTO `sys_log` VALUES (664, 'OTHER', 'GET', 'sys_group', NULL, '预览生成代码', '/api/v1/codegen/sys_group/preview', NULL, '192.168.2.14', '0', '内网IP', 412, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:31:10', 0);
INSERT INTO `sys_log` VALUES (665, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 56, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:31:43', 0);
INSERT INTO `sys_log` VALUES (666, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 38, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:32:43', 0);
INSERT INTO `sys_log` VALUES (667, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.2.14', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:32:47', 0);
INSERT INTO `sys_log` VALUES (668, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:40:39', 0);
INSERT INTO `sys_log` VALUES (669, 'SETTING', 'PUT', '{} {\"upload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\",\"uoload\":\"/usdt/2025/05/14/c52903a8-9776-4d76-8a18-9fe6fcb605b0\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 438, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:40:45', 0);
INSERT INTO `sys_log` VALUES (670, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 104, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:40:46', 0);
INSERT INTO `sys_log` VALUES (671, 'SETTING', 'PUT', '{} {\"upload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\",\"uoload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 346, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:42:21', 0);
INSERT INTO `sys_log` VALUES (672, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 13, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:42:22', 0);
INSERT INTO `sys_log` VALUES (673, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:48:19', 0);
INSERT INTO `sys_log` VALUES (674, 'OTHER', 'POST', '{\"tableName\":\"sys_group_data\",\"businessName\":\"组合分类数据\",\"moduleName\":\"system\",\"packageName\":\"com.youlai.boot\",\"entityName\":\"SysGroupData\",\"author\":\"MrZhang\",\"fieldConfigs\":[{\"columnName\":\"id\",\"columnType\":\"int\",\"fieldName\":\"id\",\"fieldSort\":1,\"fieldType\":\"Integer\",\"fieldComment\":\"组合数据详情ID\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"gid\",\"columnType\":\"int\",\"fieldName\":\"gid\",\"fieldSort\":2,\"fieldType\":\"Integer\",\"fieldComment\":\"对应的数据组id\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"value\",\"columnType\":\"text\",\"fieldName\":\"value\",\"fieldSort\":3,\"fieldType\":\"String\",\"fieldComment\":\"数据组对应的数据值（json数据）\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"maxLength\":65535,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"sort\",\"columnType\":\"int\",\"fieldName\":\"sort\",\"fieldSort\":4,\"fieldType\":\"Integer\",\"fieldComment\":\"数据排序\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"status\",\"columnType\":\"tinyint\",\"fieldName\":\"status\",\"fieldSort\":5,\"fieldType\":\"Integer\",\"fieldComment\":\"状态（1：开启；2：关闭；）\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":1,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"create_time\",\"columnType\":\"timestamp\",\"fieldName\":\"createTime\",\"fieldSort\":6,\"fieldComment\":\"创建时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"},{\"columnName\":\"update_time\",\"columnType\":\"timestamp\",\"fieldName\":\"updateTime\",\"fieldSort\":7,\"fieldComment\":\"更新时间\",\"isShowInList\":1,\"isShowInForm\":1,\"isRequired\":0,\"formType\":\"INPUT\",\"queryType\":\"EQ\"}],\"backendAppName\":\"youlai-boot\",\"frontendAppName\":\"vue3-element-admin\"}', NULL, '生成代码', '/api/v1/codegen/sys_group_data/config', NULL, '192.168.2.14', '0', '内网IP', 326, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:48:49', 0);
INSERT INTO `sys_log` VALUES (675, 'OTHER', 'GET', 'sys_group_data', NULL, '预览生成代码', '/api/v1/codegen/sys_group_data/preview', NULL, '192.168.2.14', '0', '内网IP', 124, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 00:48:49', 0);
INSERT INTO `sys_log` VALUES (676, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 73, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 01:17:08', 0);
INSERT INTO `sys_log` VALUES (677, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 12, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 01:31:00', 0);
INSERT INTO `sys_log` VALUES (678, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 8, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 01:41:49', 0);
INSERT INTO `sys_log` VALUES (679, 'SETTING', 'PUT', '{} {\"upload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\",\"uoload\":\"http://192.168.2.18:9000/usdt/2025/05/14/f69dc22f-ef46-4dcb-9729-84b11af231b9\",\"Fb2lmao89itpabc\":\"123123\"}', NULL, '根据模板id更新系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 478, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 01:41:55', 0);
INSERT INTO `sys_log` VALUES (680, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 11, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 01:41:56', 0);
INSERT INTO `sys_log` VALUES (681, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 10, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 01:56:34', 0);
INSERT INTO `sys_log` VALUES (682, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 9, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 01:56:42', 0);
INSERT INTO `sys_log` VALUES (683, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 77, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:20:56', 0);
INSERT INTO `sys_log` VALUES (684, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":2,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 40, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:20:59', 0);
INSERT INTO `sys_log` VALUES (685, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 104, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:26:03', 0);
INSERT INTO `sys_log` VALUES (686, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 51, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:26:05', 0);
INSERT INTO `sys_log` VALUES (687, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":2,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 47, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:26:08', 0);
INSERT INTO `sys_log` VALUES (688, 'SETTING', 'DELETE', '{id=44}', NULL, '删除系统配置', '/api/v1/config/44', NULL, '192.168.2.14', '0', '内网IP', 94, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:26:11', 0);
INSERT INTO `sys_log` VALUES (689, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:26:11', 0);
INSERT INTO `sys_log` VALUES (690, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":2,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 27, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:26:14', 0);
INSERT INTO `sys_log` VALUES (691, 'SETTING', 'DELETE', '{id=45}', NULL, '删除系统配置', '/api/v1/config/45', NULL, '192.168.2.14', '0', '内网IP', 103, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:26:17', 0);
INSERT INTO `sys_log` VALUES (692, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 30, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:26:17', 0);
INSERT INTO `sys_log` VALUES (693, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:26:25', 0);
INSERT INTO `sys_log` VALUES (694, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 42, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:26:31', 0);
INSERT INTO `sys_log` VALUES (695, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 32, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:27:46', 0);
INSERT INTO `sys_log` VALUES (696, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 10:27:51', 0);
INSERT INTO `sys_log` VALUES (697, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 36, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 12:48:03', 0);
INSERT INTO `sys_log` VALUES (698, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 8, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 12:53:46', 0);
INSERT INTO `sys_log` VALUES (699, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 9, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 16:56:28', 0);
INSERT INTO `sys_log` VALUES (700, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 10, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 17:39:18', 0);
INSERT INTO `sys_log` VALUES (701, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 10, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 17:39:20', 0);
INSERT INTO `sys_log` VALUES (702, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 11, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 17:39:22', 0);
INSERT INTO `sys_log` VALUES (703, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 15, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 17:39:24', 0);
INSERT INTO `sys_log` VALUES (704, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 16, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 17:39:26', 0);
INSERT INTO `sys_log` VALUES (705, 'SETTING', 'DELETE', '{id=43}', NULL, '删除系统配置', '/api/v1/config/43', NULL, '192.168.2.14', '0', '内网IP', 95, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 17:39:41', 0);
INSERT INTO `sys_log` VALUES (706, 'SETTING', 'GET', '{\"keywords\":\"\",\"pageNum\":1,\"pageSize\":10}', NULL, '系统配置分页列表', '/api/v1/config/page', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 17:39:42', 0);
INSERT INTO `sys_log` VALUES (707, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 8, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 18:31:33', 0);
INSERT INTO `sys_log` VALUES (708, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 9, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 18:32:11', 0);
INSERT INTO `sys_log` VALUES (709, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 11, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 18:32:12', 0);
INSERT INTO `sys_log` VALUES (710, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 11, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 18:32:13', 0);
INSERT INTO `sys_log` VALUES (711, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-15 22:59:49', 0);
INSERT INTO `sys_log` VALUES (712, 'LOGIN', 'POST', 'root 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.14', '0', '内网IP', 1296, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 13:41:22', 0);
INSERT INTO `sys_log` VALUES (713, 'OTHER', 'GET', '{\"excludeTables\":[\"gen_config\",\"gen_field_config\"],\"pageNum\":1,\"pageSize\":10}', NULL, '代码生成分页列表', '/api/v1/codegen/table/page', NULL, '192.168.2.14', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 13:44:25', 0);
INSERT INTO `sys_log` VALUES (714, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 22, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 14:42:01', 0);
INSERT INTO `sys_log` VALUES (715, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 20, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 14:42:03', 0);
INSERT INTO `sys_log` VALUES (716, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 14:42:05', 0);
INSERT INTO `sys_log` VALUES (717, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 21, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 14:42:06', 0);
INSERT INTO `sys_log` VALUES (718, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 24, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 14:42:07', 0);
INSERT INTO `sys_log` VALUES (719, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 34, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 14:43:10', 0);
INSERT INTO `sys_log` VALUES (720, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 15:30:30', 0);
INSERT INTO `sys_log` VALUES (721, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 16:34:16', 0);
INSERT INTO `sys_log` VALUES (722, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 22, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 16:34:18', 0);
INSERT INTO `sys_log` VALUES (723, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 19, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 16:36:09', 0);
INSERT INTO `sys_log` VALUES (724, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 17, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 16:43:16', 0);
INSERT INTO `sys_log` VALUES (725, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.2.14', '0', '内网IP', 5428, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-16 18:56:14', 0);
INSERT INTO `sys_log` VALUES (726, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.2.14', '0', '内网IP', 70, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-05-16 18:56:15', 0);
INSERT INTO `sys_log` VALUES (727, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 28, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 19:06:46', 0);
INSERT INTO `sys_log` VALUES (728, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 27, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 19:16:37', 0);
INSERT INTO `sys_log` VALUES (729, 'CATEGORY', 'POST', '{\"pid\":0,\"name\":\"前端底部tabbar\",\"type\":2,\"status\":true,\"sort\":0}', NULL, '新增配置分类', '/api/v1/category/add', NULL, '192.168.2.14', '0', '内网IP', 128, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 19:18:58', 0);
INSERT INTO `sys_log` VALUES (730, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 29, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 19:19:23', 0);
INSERT INTO `sys_log` VALUES (731, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 26, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 19:19:56', 0);
INSERT INTO `sys_log` VALUES (732, 'SETTING', 'GET', '{}', NULL, '根据模板id获取系统配置', '/api/v1/config/formId', NULL, '192.168.2.14', '0', '内网IP', 25, 'Chrome', '136.0.0.0', 'Windows 10 or Windows Server 2016', 1, '2025-05-16 19:20:01', 0);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` bigint NOT NULL COMMENT '父菜单ID',
  `tree_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父节点ID路径',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
  `type` tinyint NOT NULL COMMENT '菜单类型（1-菜单 2-目录 3-外链 4-按钮）',
  `route_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由名称（Vue Router 中用于命名路由）',
  `route_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由路径（Vue Router 中定义的 URL 路径）',
  `component` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路径（组件页面完整路径，相对于 src/views/，缺省后缀 .vue）',
  `perm` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '【按钮】权限标识',
  `always_show` tinyint NULL DEFAULT 0 COMMENT '【目录】只有一个子路由是否始终显示（1-是 0-否）',
  `keep_alive` tinyint NULL DEFAULT 0 COMMENT '【菜单】是否开启页面缓存（1-是 0-否）',
  `visible` tinyint(1) NULL DEFAULT 1 COMMENT '显示状态（1-显示 0-隐藏）',
  `sort` int NULL DEFAULT 0 COMMENT '排序',
  `icon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `redirect` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '跳转路径',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 156 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '0', '系统管理', 2, '', '/system', 'Layout', NULL, 0, NULL, 1, 1, 'system', '/system/user', '2025-05-05 10:04:39', '2025-05-05 10:49:39', NULL);
INSERT INTO `sys_menu` VALUES (2, 1, '0,1', '用户管理', 1, 'User', 'user', 'system/user/index', NULL, NULL, 1, 1, 1, 'el-icon-User', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (3, 1, '0,1', '角色管理', 1, 'Role', 'role', 'system/role/index', NULL, NULL, 1, 1, 2, 'role', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (4, 1, '0,1', '菜单管理', 1, 'SysMenu', 'menu', 'system/menu/index', NULL, NULL, 1, 1, 3, 'menu', NULL, '2025-05-05 10:04:39', '2025-05-07 17:00:36', NULL);
INSERT INTO `sys_menu` VALUES (5, 1, '0,1', '部门管理', 1, 'Dept', 'dept', 'system/dept/index', NULL, NULL, 1, 1, 4, 'tree', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (6, 1, '0,1', '字典管理', 1, 'Dict', 'dict', 'system/dict/index', NULL, NULL, 1, 1, 5, 'dict', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (20, 0, '0', '多级菜单', 2, NULL, '/multi-level', 'Layout', NULL, 1, NULL, 1, 9, 'cascader', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (21, 20, '0,20', '菜单一级', 1, NULL, 'multi-level1', 'demo/multi-level/level1', NULL, 1, NULL, 1, 1, '', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (22, 21, '0,20,21', '菜单二级', 1, NULL, 'multi-level2', 'demo/multi-level/children/level2', NULL, 0, NULL, 1, 1, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (23, 22, '0,20,21,22', '菜单三级-1', 1, NULL, 'multi-level3-1', 'demo/multi-level/children/children/level3-1', NULL, 0, 1, 1, 1, '', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (24, 22, '0,20,21,22', '菜单三级-2', 1, NULL, 'multi-level3-2', 'demo/multi-level/children/children/level3-2', NULL, 0, 1, 1, 2, '', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (26, 0, '0', '平台文档', 2, '', '/doc', 'Layout', NULL, NULL, NULL, 1, 8, 'document', 'https://juejin.cn/post/7228990409909108793', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (30, 26, '0,26', '平台文档(外链)', 3, NULL, 'https://juejin.cn/post/7228990409909108793', '', NULL, NULL, NULL, 1, 2, 'document', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (31, 2, '0,1,2', '用户新增', 4, NULL, '', NULL, 'sys:user:add', NULL, NULL, 1, 1, '', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (32, 2, '0,1,2', '用户编辑', 4, NULL, '', NULL, 'sys:user:edit', NULL, NULL, 1, 2, '', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (33, 2, '0,1,2', '用户删除', 4, NULL, '', NULL, 'sys:user:delete', NULL, NULL, 1, 3, '', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (36, 0, '0', '组件封装', 2, NULL, '/component', 'Layout', NULL, NULL, NULL, 1, 10, 'menu', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (37, 36, '0,36', '富文本编辑器', 1, NULL, 'wang-editor', 'demo/wang-editor', NULL, NULL, 1, 1, 2, '', '', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (38, 36, '0,36', '图片上传', 1, NULL, 'upload', 'demo/upload', NULL, NULL, 1, 1, 3, '', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (39, 36, '0,36', '图标选择器', 1, NULL, 'icon-selector', 'demo/icon-selector', NULL, NULL, 1, 1, 4, '', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (40, 0, '0', '接口文档', 2, NULL, '/api', 'Layout', NULL, 1, NULL, 1, 7, 'api', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (41, 40, '0,40', 'Apifox', 1, NULL, 'apifox', 'demo/api/apifox', NULL, NULL, 1, 1, 1, 'api', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (70, 3, '0,1,3', '角色新增', 4, NULL, '', NULL, 'sys:role:add', NULL, NULL, 1, 2, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (71, 3, '0,1,3', '角色编辑', 4, NULL, '', NULL, 'sys:role:edit', NULL, NULL, 1, 3, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (72, 3, '0,1,3', '角色删除', 4, NULL, '', NULL, 'sys:role:delete', NULL, NULL, 1, 4, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (73, 4, '0,1,4', '菜单新增', 4, NULL, '', NULL, 'sys:menu:add', NULL, NULL, 1, 1, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (74, 4, '0,1,4', '菜单编辑', 4, NULL, '', NULL, 'sys:menu:edit', NULL, NULL, 1, 3, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (75, 4, '0,1,4', '菜单删除', 4, NULL, '', NULL, 'sys:menu:delete', NULL, NULL, 1, 3, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (76, 5, '0,1,5', '部门新增', 4, NULL, '', NULL, 'sys:dept:add', NULL, NULL, 1, 1, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (77, 5, '0,1,5', '部门编辑', 4, NULL, '', NULL, 'sys:dept:edit', NULL, NULL, 1, 2, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (78, 5, '0,1,5', '部门删除', 4, NULL, '', NULL, 'sys:dept:delete', NULL, NULL, 1, 3, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (79, 6, '0,1,6', '字典新增', 4, NULL, '', NULL, 'sys:dict:add', NULL, NULL, 1, 1, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (81, 6, '0,1,6', '字典编辑', 4, NULL, '', NULL, 'sys:dict:edit', NULL, NULL, 1, 2, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (84, 6, '0,1,6', '字典删除', 4, NULL, '', NULL, 'sys:dict:delete', NULL, NULL, 1, 3, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (88, 2, '0,1,2', '重置密码', 4, NULL, '', NULL, 'sys:user:reset-password', NULL, NULL, 1, 4, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (89, 0, '0', '功能演示', 2, NULL, '/function', 'Layout', NULL, NULL, NULL, 0, 12, 'menu', '', '2025-05-05 10:04:39', '2025-05-05 22:51:49', NULL);
INSERT INTO `sys_menu` VALUES (90, 89, '0,89', 'Websocket', 1, NULL, '/function/websocket', 'demo/websocket', NULL, NULL, 1, 1, 3, '', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (95, 36, '0,36', '字典组件', 1, NULL, 'dict-demo', 'demo/dictionary', NULL, NULL, 1, 1, 4, '', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (97, 89, '0,89', 'Icons', 1, NULL, 'icon-demo', 'demo/icons', NULL, NULL, 1, 1, 2, 'el-icon-Notification', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (102, 26, '0,26', 'document', 3, '', 'internal-doc', 'demo/internal-doc', NULL, NULL, NULL, 1, 1, 'document', '', '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (105, 2, '0,1,2', '用户查询', 4, NULL, '', NULL, 'sys:user:query', 0, 0, 1, 0, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (106, 2, '0,1,2', '用户导入', 4, NULL, '', NULL, 'sys:user:import', NULL, NULL, 1, 5, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (107, 2, '0,1,2', '用户导出', 4, NULL, '', NULL, 'sys:user:export', NULL, NULL, 1, 6, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (108, 36, '0,36', '增删改查', 1, NULL, 'curd', 'demo/curd/index', NULL, NULL, 1, 1, 0, '', '', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (109, 36, '0,36', '列表选择器', 1, NULL, 'table-select', 'demo/table-select/index', NULL, NULL, 1, 1, 1, '', '', NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (110, 0, '0', '路由参数', 2, NULL, '/route-param', 'Layout', NULL, 1, 1, 1, 11, 'el-icon-ElementPlus', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (111, 110, '0,110', '参数(type=1)', 1, NULL, 'route-param-type1', 'demo/route-param', NULL, 0, 1, 1, 1, 'el-icon-Star', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', '{\"type\": \"1\"}');
INSERT INTO `sys_menu` VALUES (112, 110, '0,110', '参数(type=2)', 1, NULL, 'route-param-type2', 'demo/route-param', NULL, 0, 1, 1, 2, 'el-icon-StarFilled', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', '{\"type\": \"2\"}');
INSERT INTO `sys_menu` VALUES (117, 1, '0,1', '系统日志', 1, 'Log', 'log', 'system/log/index', NULL, 0, 1, 1, 6, 'document', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (118, 0, '0', '系统工具', 2, NULL, '/codegen', 'Layout', NULL, 0, 1, 1, 2, 'menu', NULL, '2025-05-05 10:04:39', '2025-05-05 22:08:02', NULL);
INSERT INTO `sys_menu` VALUES (119, 118, '0,118', '代码生成', 1, 'Codegen', 'codegen', 'codegen/index', NULL, 0, 1, 1, 1, 'code', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (120, 1, '0,1', '系统配置', 1, 'Config', 'config', 'system/config/index', NULL, 0, 1, 1, 7, 'setting', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (121, 120, '0,1,120', '系统配置查询', 4, NULL, '', NULL, 'sys:config:query', 0, 1, 1, 1, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (122, 120, '0,1,120', '系统配置新增', 4, NULL, '', NULL, 'sys:config:add', 0, 1, 1, 2, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (123, 120, '0,1,120', '系统配置修改', 4, NULL, '', NULL, 'sys:config:update', 0, 1, 1, 3, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (124, 120, '0,1,120', '系统配置删除', 4, NULL, '', NULL, 'sys:config:delete', 0, 1, 1, 4, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (125, 120, '0,1,120', '系统配置刷新', 4, NULL, '', NULL, 'sys:config:refresh', 0, 1, 1, 5, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (126, 1, '0,1', '通知公告', 1, 'Notice', 'notice', 'system/notice/index', NULL, NULL, NULL, 1, 9, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (127, 126, '0,1,126', '通知查询', 4, NULL, '', NULL, 'sys:notice:query', NULL, NULL, 1, 1, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (128, 126, '0,1,126', '通知新增', 4, NULL, '', NULL, 'sys:notice:add', NULL, NULL, 1, 2, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (129, 126, '0,1,126', '通知编辑', 4, NULL, '', NULL, 'sys:notice:edit', NULL, NULL, 1, 3, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (130, 126, '0,1,126', '通知删除', 4, NULL, '', NULL, 'sys:notice:delete', NULL, NULL, 1, 4, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (133, 126, '0,1,126', '通知发布', 4, NULL, '', NULL, 'sys:notice:publish', 0, 1, 1, 5, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (134, 126, '0,1,126', '通知撤回', 4, NULL, '', NULL, 'sys:notice:revoke', 0, 1, 1, 6, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (135, 1, '0,1', '字典项', 1, 'DictItem', 'dict-item', 'system/dict/dict-item', NULL, 0, 1, 0, 6, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (136, 135, '0,1,135', '字典项新增', 4, NULL, '', NULL, 'sys:dict-item:add', NULL, NULL, 1, 2, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (137, 135, '0,1,135', '字典项编辑', 4, NULL, '', NULL, 'sys:dict-item:edit', NULL, NULL, 1, 3, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (138, 135, '0,1,135', '字典项删除', 4, NULL, '', NULL, 'sys:dict-item:delete', NULL, NULL, 1, 4, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (139, 3, '0,1,3', '角色查询', 4, NULL, '', NULL, 'sys:role:query', NULL, NULL, 1, 1, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (140, 4, '0,1,4', '菜单查询', 4, NULL, '', NULL, 'sys:menu:query', NULL, NULL, 1, 1, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (141, 5, '0,1,5', '部门查询', 4, NULL, '', NULL, 'sys:dept:query', NULL, NULL, 1, 1, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (142, 6, '0,1,6', '字典查询', 4, NULL, '', NULL, 'sys:dict:query', NULL, NULL, 1, 1, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (143, 135, '0,1,135', '字典项查询', 4, NULL, '', NULL, 'sys:dict-item:query', NULL, NULL, 1, 1, '', NULL, '2025-05-05 10:04:39', '2025-05-05 10:04:39', NULL);
INSERT INTO `sys_menu` VALUES (144, 26, '0,26', '后端文档', 3, NULL, 'https://youlai.blog.csdn.net/article/details/145178880', '', NULL, NULL, NULL, 1, 3, 'document', '', '2024-10-05 23:36:03', '2024-10-05 23:36:03', NULL);
INSERT INTO `sys_menu` VALUES (145, 26, '0,26', '移动端文档', 3, NULL, 'https://youlai.blog.csdn.net/article/details/143222890', '', NULL, NULL, NULL, 1, 4, 'document', '', '2024-10-05 23:36:03', '2024-10-05 23:36:03', NULL);
INSERT INTO `sys_menu` VALUES (146, 36, '0,36', '拖拽组件', 1, NULL, 'drag', 'demo/drag', NULL, NULL, NULL, 1, 5, '', '', '2025-03-31 14:14:45', '2025-03-31 14:14:52', NULL);
INSERT INTO `sys_menu` VALUES (147, 36, '0,36', '滚动文本', 1, NULL, 'text-scroll', 'demo/text-scroll', NULL, NULL, NULL, 1, 6, '', '', '2025-03-31 14:14:49', '2025-03-31 14:14:56', NULL);
INSERT INTO `sys_menu` VALUES (148, 89, '0,89', '字典实时同步', 1, NULL, 'dict-sync', 'demo/dict-sync', NULL, NULL, NULL, 1, 3, '', '', '2025-03-31 14:14:49', '2025-03-31 14:14:56', NULL);
INSERT INTO `sys_menu` VALUES (149, 0, '0', '系统维护', 2, NULL, '/maintain', 'Layout', NULL, 1, 1, 1, 3, 'setting', NULL, '2025-05-05 10:46:22', '2025-05-05 22:10:02', NULL);
INSERT INTO `sys_menu` VALUES (150, 149, '0,149', '素材管理', 1, 'Picture', 'picture', 'maintain/picture/index', NULL, NULL, 0, 1, 1, 'el-icon-Menu', NULL, '2025-05-05 10:49:18', '2025-05-05 22:53:24', NULL);
INSERT INTO `sys_menu` VALUES (151, 150, '0,149,150', '上传图片', 4, NULL, NULL, NULL, 'sys:user:add', 0, 1, 1, 1, NULL, NULL, '2025-05-05 22:46:02', '2025-05-05 22:46:02', NULL);
INSERT INTO `sys_menu` VALUES (152, 149, '0,149', '表单配置', 1, 'SysFormIndex', 'maintain/formConfig', 'maintain/formConfig/index', NULL, 0, 1, 1, 1, 'table', NULL, '2025-05-06 19:47:06', '2025-05-11 01:12:34', NULL);
INSERT INTO `sys_menu` VALUES (153, 149, '0,149', '系统分类配置', 1, 'Category', 'maintain/category', 'maintain/category/index', NULL, 1, 1, 1, 1, 'document', NULL, '2025-05-11 01:12:02', '2025-05-11 01:12:42', NULL);
INSERT INTO `sys_menu` VALUES (154, 149, '0,149', '系统设置', 1, 'ConfigIndex', 'maintain/config', 'maintain/config/index', NULL, 1, 0, 1, 1, 'el-icon-Setting', NULL, '2025-05-13 14:41:07', '2025-05-13 14:59:17', NULL);
INSERT INTO `sys_menu` VALUES (155, 149, '0,149', '组合数据', 1, 'SysGroup', 'maintain/group', 'maintain/group/index', NULL, 0, 1, 1, 1, 'table', NULL, '2025-05-15 00:32:42', '2025-05-15 00:32:42', NULL);

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '通知标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '通知内容',
  `type` tinyint NOT NULL COMMENT '通知类型（关联字典编码：notice_type）',
  `level` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '通知等级（字典code：notice_level）',
  `target_type` tinyint NOT NULL COMMENT '目标类型（1: 全体, 2: 指定）',
  `target_user_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '目标人ID集合（多个使用英文逗号,分割）',
  `publisher_id` bigint NULL DEFAULT NULL COMMENT '发布人ID',
  `publish_status` tinyint NULL DEFAULT 0 COMMENT '发布状态（0: 未发布, 1: 已发布, -1: 已撤回）',
  `publish_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `revoke_time` datetime NULL DEFAULT NULL COMMENT '撤回时间',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, 'v2.12.0 新增系统日志，访问趋势统计功能。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 1, 'L', 1, '2', 1, 1, '2025-05-05 10:04:48', '2025-05-05 10:04:48', 2, '2025-05-05 10:04:48', 1, '2025-05-05 22:11:51', 1);
INSERT INTO `sys_notice` VALUES (2, 'v2.13.0 新增菜单搜索。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 1, 'L', 1, '2', 1, 1, '2025-05-05 10:04:48', '2025-05-05 10:04:48', 2, '2025-05-05 10:04:48', 1, '2025-05-05 22:11:51', 1);
INSERT INTO `sys_notice` VALUES (3, 'v2.14.0 新增个人中心。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 1, 'L', 1, '2', 2, 1, '2025-05-05 10:04:48', '2025-05-05 10:04:48', 2, '2025-05-05 10:04:48', 2, '2025-05-05 22:11:51', 1);
INSERT INTO `sys_notice` VALUES (4, 'v2.15.0 登录页面改造。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 1, 'L', 1, '2', 2, 1, '2025-05-05 10:04:48', '2025-05-05 10:04:48', 2, '2025-05-05 10:04:48', 2, '2025-05-05 22:11:51', 1);
INSERT INTO `sys_notice` VALUES (5, 'v2.16.0 通知公告、字典翻译组件。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 1, 'L', 1, '2', 2, 1, '2025-05-05 10:04:48', '2025-05-05 10:04:48', 2, '2025-05-05 10:04:48', 2, '2025-05-05 22:11:51', 1);
INSERT INTO `sys_notice` VALUES (6, '系统将于本周六凌晨 2 点进行维护，预计维护时间为 2 小时。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 2, 'H', 1, '2', 2, 1, '2025-05-05 10:04:48', '2025-05-05 10:04:48', 2, '2025-05-05 10:04:48', 2, '2025-05-05 22:11:51', 1);
INSERT INTO `sys_notice` VALUES (7, '最近发现一些钓鱼邮件，请大家提高警惕，不要点击陌生链接。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 3, 'L', 1, '2', 2, 1, '2025-05-05 10:04:48', '2025-05-05 10:04:48', 2, '2025-05-05 10:04:48', 2, '2025-05-05 22:11:51', 1);
INSERT INTO `sys_notice` VALUES (8, '国庆假期从 10 月 1 日至 10 月 7 日放假，共 7 天。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 4, 'L', 1, '2', 2, 1, '2025-05-05 10:04:48', '2025-05-05 10:04:48', 2, '2025-05-05 10:04:48', 2, '2025-05-05 22:11:51', 1);
INSERT INTO `sys_notice` VALUES (9, '公司将在 10 月 15 日举办新产品发布会，敬请期待。', '公司将在 10 月 15 日举办新产品发布会，敬请期待。', 5, 'H', 1, '2', 2, 1, '2025-05-05 10:04:48', '2025-05-05 10:04:48', 2, '2025-05-05 10:04:48', 2, '2025-05-05 22:11:51', 1);
INSERT INTO `sys_notice` VALUES (10, 'v2.16.1 版本发布。', 'v2.16.1 版本修复了 WebSocket 重复连接导致的后台线程阻塞问题，优化了通知公告。', 1, 'M', 1, '2', 2, 1, '2025-05-05 10:04:48', '2025-05-05 10:04:48', 2, '2025-05-05 10:04:48', 2, '2025-05-05 22:11:51', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色编码',
  `sort` int NULL DEFAULT NULL COMMENT '显示顺序',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '角色状态(1-正常 0-停用)',
  `data_scope` tinyint NULL DEFAULT NULL COMMENT '数据权限(1-所有数据 2-部门及子部门数据 3-本部门数据 4-本人数据)',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人 ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除标识(0-未删除 1-已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name` ASC) USING BTREE COMMENT '角色名称唯一索引',
  UNIQUE INDEX `uk_code`(`code` ASC) USING BTREE COMMENT '角色编码唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'ROOT', 1, 1, 1, NULL, '2025-05-05 10:04:41', NULL, '2025-05-05 10:04:41', 0);
INSERT INTO `sys_role` VALUES (2, '系统管理员', 'ADMIN', 2, 1, 1, NULL, '2025-05-05 10:04:41', NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (3, '访问游客', 'GUEST', 3, 1, 3, NULL, '2025-05-05 10:04:41', NULL, '2025-05-05 10:04:41', 0);
INSERT INTO `sys_role` VALUES (4, '系统管理员1', 'ADMIN1', 4, 1, 1, NULL, '2025-05-05 10:04:41', NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (5, '系统管理员2', 'ADMIN2', 5, 1, 1, NULL, '2025-05-05 10:04:41', NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (6, '系统管理员3', 'ADMIN3', 6, 1, 1, NULL, '2025-05-05 10:04:41', NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (7, '系统管理员4', 'ADMIN4', 7, 1, 1, NULL, '2025-05-05 10:04:41', NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (8, '系统管理员5', 'ADMIN5', 8, 1, 1, NULL, '2025-05-05 10:04:41', NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (9, '系统管理员6', 'ADMIN6', 9, 1, 1, NULL, '2025-05-05 10:04:41', NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (10, '系统管理员7', 'ADMIN7', 10, 1, 1, NULL, '2025-05-05 10:04:41', NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (11, '系统管理员8', 'ADMIN8', 11, 1, 1, NULL, '2025-05-05 10:04:41', NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (12, '系统管理员9', 'ADMIN9', 12, 1, 1, NULL, '2025-05-05 10:04:41', NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  UNIQUE INDEX `uk_roleid_menuid`(`role_id` ASC, `menu_id` ASC) USING BTREE COMMENT '角色菜单唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (2, 5);
INSERT INTO `sys_role_menu` VALUES (2, 6);
INSERT INTO `sys_role_menu` VALUES (2, 20);
INSERT INTO `sys_role_menu` VALUES (2, 21);
INSERT INTO `sys_role_menu` VALUES (2, 22);
INSERT INTO `sys_role_menu` VALUES (2, 23);
INSERT INTO `sys_role_menu` VALUES (2, 24);
INSERT INTO `sys_role_menu` VALUES (2, 26);
INSERT INTO `sys_role_menu` VALUES (2, 30);
INSERT INTO `sys_role_menu` VALUES (2, 31);
INSERT INTO `sys_role_menu` VALUES (2, 32);
INSERT INTO `sys_role_menu` VALUES (2, 33);
INSERT INTO `sys_role_menu` VALUES (2, 36);
INSERT INTO `sys_role_menu` VALUES (2, 37);
INSERT INTO `sys_role_menu` VALUES (2, 38);
INSERT INTO `sys_role_menu` VALUES (2, 39);
INSERT INTO `sys_role_menu` VALUES (2, 40);
INSERT INTO `sys_role_menu` VALUES (2, 41);
INSERT INTO `sys_role_menu` VALUES (2, 70);
INSERT INTO `sys_role_menu` VALUES (2, 71);
INSERT INTO `sys_role_menu` VALUES (2, 72);
INSERT INTO `sys_role_menu` VALUES (2, 73);
INSERT INTO `sys_role_menu` VALUES (2, 74);
INSERT INTO `sys_role_menu` VALUES (2, 75);
INSERT INTO `sys_role_menu` VALUES (2, 76);
INSERT INTO `sys_role_menu` VALUES (2, 77);
INSERT INTO `sys_role_menu` VALUES (2, 78);
INSERT INTO `sys_role_menu` VALUES (2, 79);
INSERT INTO `sys_role_menu` VALUES (2, 81);
INSERT INTO `sys_role_menu` VALUES (2, 84);
INSERT INTO `sys_role_menu` VALUES (2, 85);
INSERT INTO `sys_role_menu` VALUES (2, 86);
INSERT INTO `sys_role_menu` VALUES (2, 87);
INSERT INTO `sys_role_menu` VALUES (2, 88);
INSERT INTO `sys_role_menu` VALUES (2, 89);
INSERT INTO `sys_role_menu` VALUES (2, 90);
INSERT INTO `sys_role_menu` VALUES (2, 91);
INSERT INTO `sys_role_menu` VALUES (2, 95);
INSERT INTO `sys_role_menu` VALUES (2, 97);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 111);
INSERT INTO `sys_role_menu` VALUES (2, 112);
INSERT INTO `sys_role_menu` VALUES (2, 114);
INSERT INTO `sys_role_menu` VALUES (2, 115);
INSERT INTO `sys_role_menu` VALUES (2, 116);
INSERT INTO `sys_role_menu` VALUES (2, 117);
INSERT INTO `sys_role_menu` VALUES (2, 118);
INSERT INTO `sys_role_menu` VALUES (2, 119);
INSERT INTO `sys_role_menu` VALUES (2, 120);
INSERT INTO `sys_role_menu` VALUES (2, 121);
INSERT INTO `sys_role_menu` VALUES (2, 122);
INSERT INTO `sys_role_menu` VALUES (2, 123);
INSERT INTO `sys_role_menu` VALUES (2, 124);
INSERT INTO `sys_role_menu` VALUES (2, 125);
INSERT INTO `sys_role_menu` VALUES (2, 126);
INSERT INTO `sys_role_menu` VALUES (2, 127);
INSERT INTO `sys_role_menu` VALUES (2, 128);
INSERT INTO `sys_role_menu` VALUES (2, 129);
INSERT INTO `sys_role_menu` VALUES (2, 130);
INSERT INTO `sys_role_menu` VALUES (2, 131);
INSERT INTO `sys_role_menu` VALUES (2, 132);
INSERT INTO `sys_role_menu` VALUES (2, 133);
INSERT INTO `sys_role_menu` VALUES (2, 134);
INSERT INTO `sys_role_menu` VALUES (2, 135);
INSERT INTO `sys_role_menu` VALUES (2, 136);
INSERT INTO `sys_role_menu` VALUES (2, 137);
INSERT INTO `sys_role_menu` VALUES (2, 138);
INSERT INTO `sys_role_menu` VALUES (2, 139);
INSERT INTO `sys_role_menu` VALUES (2, 140);
INSERT INTO `sys_role_menu` VALUES (2, 141);
INSERT INTO `sys_role_menu` VALUES (2, 142);
INSERT INTO `sys_role_menu` VALUES (2, 143);
INSERT INTO `sys_role_menu` VALUES (2, 144);
INSERT INTO `sys_role_menu` VALUES (2, 145);
INSERT INTO `sys_role_menu` VALUES (2, 146);
INSERT INTO `sys_role_menu` VALUES (2, 147);
INSERT INTO `sys_role_menu` VALUES (2, 148);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `gender` tinyint(1) NULL DEFAULT 1 COMMENT '性别((1-男 2-女 0-保密)',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `dept_id` int NULL DEFAULT NULL COMMENT '部门ID',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系方式',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态(1-正常 0-禁用)',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除标识(0-未删除 1-已删除)',
  `openid` char(28) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信 openid',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `login_name`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'root', '有来技术', 0, '$2a$10$xVWsNOhHrCxh5UbpCE7/HuJ.PAOKcYAqRxD2CO2nVnJS.IAXkr5aq', NULL, 'https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif', '18812345677', 1, 'youlaitech@163.com', '2025-05-05 10:04:43', NULL, '2025-05-05 10:04:43', NULL, 0, NULL);
INSERT INTO `sys_user` VALUES (2, 'admin', '系统管理员', 1, '$2a$10$xVWsNOhHrCxh5UbpCE7/HuJ.PAOKcYAqRxD2CO2nVnJS.IAXkr5aq', 1, 'https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif', '18812345678', 1, 'youlaitech@163.com', '2025-05-05 10:04:43', NULL, '2025-05-05 10:04:43', NULL, 0, NULL);
INSERT INTO `sys_user` VALUES (3, 'test', '测试小用户', 1, '$2a$10$xVWsNOhHrCxh5UbpCE7/HuJ.PAOKcYAqRxD2CO2nVnJS.IAXkr5aq', 3, 'https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif', '18812345679', 1, 'youlaitech@163.com', '2025-05-05 10:04:43', NULL, '2025-05-05 10:04:43', NULL, 0, NULL);

-- ----------------------------
-- Table structure for sys_user_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_notice`;
CREATE TABLE `sys_user_notice`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `notice_id` bigint NOT NULL COMMENT '公共通知id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `is_read` bigint NULL DEFAULT 0 COMMENT '读取状态（0: 未读, 1: 已读）',
  `read_time` datetime NULL DEFAULT NULL COMMENT '阅读时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除(0: 未删除, 1: 已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_notice
-- ----------------------------
INSERT INTO `sys_user_notice` VALUES (1, 1, 2, 1, NULL, '2025-05-05 10:04:49', '2025-05-05 10:04:49', 1);
INSERT INTO `sys_user_notice` VALUES (2, 2, 2, 1, NULL, '2025-05-05 10:04:49', '2025-05-05 10:04:49', 1);
INSERT INTO `sys_user_notice` VALUES (3, 3, 2, 1, NULL, '2025-05-05 10:04:49', '2025-05-05 10:04:49', 1);
INSERT INTO `sys_user_notice` VALUES (4, 4, 2, 1, NULL, '2025-05-05 10:04:49', '2025-05-05 10:04:49', 1);
INSERT INTO `sys_user_notice` VALUES (5, 5, 2, 1, NULL, '2025-05-05 10:04:49', '2025-05-05 10:04:49', 1);
INSERT INTO `sys_user_notice` VALUES (6, 6, 2, 1, NULL, '2025-05-05 10:04:49', '2025-05-05 10:04:49', 1);
INSERT INTO `sys_user_notice` VALUES (7, 7, 2, 1, NULL, '2025-05-05 10:04:49', '2025-05-05 10:04:49', 1);
INSERT INTO `sys_user_notice` VALUES (8, 8, 2, 1, NULL, '2025-05-05 10:04:49', '2025-05-05 10:04:49', 1);
INSERT INTO `sys_user_notice` VALUES (9, 9, 2, 1, NULL, '2025-05-05 10:04:49', '2025-05-05 10:04:49', 1);
INSERT INTO `sys_user_notice` VALUES (10, 10, 2, 1, NULL, '2025-05-05 10:04:49', '2025-05-05 10:04:49', 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (3, 3);

SET FOREIGN_KEY_CHECKS = 1;
