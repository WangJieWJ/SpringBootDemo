-- 用户表
DROP TABLE IF EXISTS `shiro_user`;
CREATE TABLE `shiro_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `salt` varchar(255) NOT NULL COMMENT '盐',
  `theme` varchar(50) NOT NULL COMMENT '用户主题',
  `trueName` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `enName` varchar(50) DEFAULT NULL COMMENT '英文名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `remarks` varchar(250) DEFAULT NULL COMMENT '备注',
  `gender` int(1) DEFAULT NULL COMMENT '性别,1男2女',
  `delFlag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `upUserId` int(11) DEFAULT NULL COMMENT '更新人',
  `upTime` datetime DEFAULT NULL COMMENT '更新时间',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  `pic` varchar(400) DEFAULT NULL COMMENT '头像地址',
  `status` int(1) DEFAULT '1' COMMENT '状态,1为正常 2为已停用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName_index` (`username`),
  KEY `status_index` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户';

-- 角色表
DROP TABLE IF EXISTS `shiro_role`;
CREATE TABLE `shiro_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '名称',
  `enName` varchar(50) NOT NULL COMMENT '英文名称，全局唯一',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `upUserId` int(11) DEFAULT NULL COMMENT '更新人',
  `upTime` datetime DEFAULT NULL COMMENT '更新时间',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `enName_index` (`enName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- 用户角色关联表
DROP TABLE IF EXISTS `shiro_user_role`;
CREATE TABLE `shiro_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户id',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `userId_index` (`userId`),
  KEY `roleId_index` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户的角色';

-- 权限表
DROP TABLE IF EXISTS `shiro_permission`;
CREATE TABLE `shiro_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '名称',
  `enName` varchar(20) NOT NULL COMMENT '英文名称',
  `desc` varchar(100) DEFAULT NULL COMMENT '描述',
  `delFlag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `upUserId` int(11) DEFAULT NULL COMMENT '更新人',
  `upTime` datetime DEFAULT NULL COMMENT '更新时间',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `enName_index` (`enName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原子权限';

-- 角色与权限关联表
DROP TABLE IF EXISTS `shiro_role_permission`;
CREATE TABLE `shiro_role_permission`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`permissionId` int(11) NOT NULL COMMENT '权限id',
	`roleId` int(11) NOT NULL COMMENT '角色id',
  `crUserId` int(11) DEFAULT NULL COMMENT '创建人',
  `crTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
	KEY `userId_index` (`permissionId`),
  KEY `roleId_index` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色下的权限';

