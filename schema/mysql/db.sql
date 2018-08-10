-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: sybang
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(60) NOT NULL DEFAULT '' COMMENT '用户名',
  `phone` varchar(14) NOT NULL DEFAULT '' COMMENT '手机号码',
  `password` varchar(45) NOT NULL DEFAULT '123456',
  `mail` varchar(248) DEFAULT NULL COMMENT '邮箱地址',
  `weibo` varchar(248) DEFAULT NULL COMMENT '微博',
  `wechat` varchar(248) DEFAULT NULL COMMENT '微信',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `mail_UNIQUE` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `staffid` varchar(45) DEFAULT NULL,
  `userid` varchar(45) DEFAULT NULL,
  `callid` varchar(45) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `rating` int(11) DEFAULT '0',
  `orderid` varchar(45) DEFAULT NULL,
  `reward` int(11) DEFAULT '0',
  `isanonymous` tinyint(1) DEFAULT NULL,
  `content` varchar(248) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `jobTitle` varchar(45) DEFAULT NULL,
  `minSalary` int(11) NOT NULL DEFAULT '-1',
  `maxSalary` int(11) NOT NULL DEFAULT '-1',
  `city` varchar(45) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  `workplace` varchar(248) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `minAge` int(11) NOT NULL DEFAULT '16',
  `maxAge` int(11) NOT NULL DEFAULT '65',
  `company` varchar(248) DEFAULT NULL,
  `jobContent` varchar(248) DEFAULT NULL,
  `requirement` varchar(248) DEFAULT NULL,
  `workTime` varchar(248) DEFAULT NULL,
  `dayOff` varchar(248) DEFAULT NULL,
  `salary` varchar(248) DEFAULT NULL,
  `insurance` varchar(248) DEFAULT NULL,
  `roomBoard` varchar(248) DEFAULT NULL,
  `holiday` varchar(248) DEFAULT NULL,
  `contract` varchar(248) DEFAULT NULL,
  `annualBonus` varchar(248) DEFAULT NULL,
  `benefits` varchar(248) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `amount` int(11) NOT NULL DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(45) NOT NULL DEFAULT 'test',
  `staffid` varchar(45) DEFAULT NULL,
  `videourl` varchar(248) DEFAULT NULL,
  `uploadtime` datetime DEFAULT NULL,
  `replyurl` varchar(248) DEFAULT NULL,
  `replytime` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `orderid` varchar(45) DEFAULT NULL,
  `reward` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-15 15:50:28
