CREATE DATABASE `blogdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use blogdb;

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for article
-- ----------------------------
CREATE TABLE `Article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `classifyId` bigint(20) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `down` int(11) NOT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `up` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for classify
-- ----------------------------
CREATE TABLE `Classify` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
CREATE TABLE `Collect` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
CREATE TABLE `Feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article` tinyblob,
  `content` varchar(4000) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for news
-- ----------------------------
CREATE TABLE `News` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(4000) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for specialfeedback
-- ----------------------------
CREATE TABLE `Specialfeedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(4000) DEFAULT NULL,
  `specialTalkId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for specialtalk
-- ----------------------------
CREATE TABLE `Specialtalk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attachment` varchar(4000) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `exercise` varchar(4000) DEFAULT NULL,
  `howto` varchar(4000) DEFAULT NULL,
  `introduction` varchar(4000) DEFAULT NULL,
  `persons` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `User` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `photoUrl` varchar(255) DEFAULT NULL,
  `point` int(11) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;