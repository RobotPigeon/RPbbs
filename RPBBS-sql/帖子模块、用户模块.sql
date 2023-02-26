-- rpbbs.`user` definition

drop table if exists `user`;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(24) NOT NULL COMMENT '用户名',
  `password` varchar(24) NOT NULL COMMENT '密码',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(12) DEFAULT NULL COMMENT '手机号码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `status` int NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- rpbbs.user_info definition

drop table if exists `user_info`;

CREATE TABLE `user_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(18) NOT NULL COMMENT '关联用户id',
  `level` int NOT NULL DEFAULT '0' COMMENT '用户等级',
  `message` tinytext COMMENT '用户简讯',
  `avatar_path` varchar(100) DEFAULT NULL COMMENT '用户头像资源路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- rpbbs.block definition

drop table if exists `block`;

CREATE TABLE `block` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `block_name` varchar(12) NOT NULL COMMENT '板块名',
  `pic_path` varchar(100) DEFAULT NULL COMMENT '图片资源路径',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `status` int NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- rpbbs.card definition

drop table if exists `card`;

CREATE TABLE `card` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(64) NOT NULL COMMENT '标题',
  `message` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文本内容',
  `create_by_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者id',
  `block_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属板块id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `status` int NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- rpbbs.card_reply definition

drop table if exists `card_reply`;

CREATE TABLE `card_reply` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `message` text COMMENT '文本内容',
  `create_by_id` varchar(18) NOT NULL COMMENT '创建者id',
  `card_id` varchar(32) NOT NULL COMMENT '从属帖子id',
  `rank` int NOT NULL COMMENT '所在楼层',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `status` int NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `card_reply_un` (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- rpbbs.card_reply_reply definition

drop table if exists `card_reply_reply`;

CREATE TABLE `card_reply_reply` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `message` text COMMENT '文本内容',
  `create_by_id` varchar(18) NOT NULL COMMENT '创建者id',
  `card_id` varchar(100) NOT NULL COMMENT '从属帖子id',
  `reply_id` varchar(100) NOT NULL COMMENT '从属回复帖子id',
  `reply_to_id` varchar(18) DEFAULT NULL COMMENT '回复对象id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `status` int NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- rpbbs.card_info definition

drop table if exists `card_info`;

CREATE TABLE `card_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `card_id` varchar(32) NOT NULL COMMENT '相关帖子id',
  `card_type_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '帖子类型',
  `like_num` bigint NOT NULL DEFAULT '0' COMMENT '喜欢数量',
  `richtext` text COMMENT '富文本',
  `source_path` varchar(255) DEFAULT NULL COMMENT '资源路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- rpbbs.card_type definition

drop table if exists `card_type`;

CREATE TABLE `card_type` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type_name` varchar(16) NOT NULL DEFAULT ' ' COMMENT '类型名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `status` int NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


