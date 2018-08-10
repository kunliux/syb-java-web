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
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'配餐员',1800,-1,'沈阳','皇姑','皇姑','女',25,40,'沈阳某快餐','配餐（给培训）','吃苦耐劳，适应后能长期稳定工作','早9晚7','旺季无休息，淡季每月4天','1800+（有提成每份3元）',NULL,NULL,NULL,NULL,NULL,NULL,'服务',5),(2,'绣工',1530,-1,'沈阳','大东','沈阳东站附近','女',20,50,'绣品厂','印刷图案','吃苦耐劳，适应后能长期稳定工作','早8-晚6/8.3元（加班6点以后每小时14元）','月休10天','8.3元一小时',NULL,'3元餐补/天',NULL,NULL,NULL,NULL,'技术',10),(3,'雕刻师',3500,4500,'沈阳','张士','沈阳张士','男',18,50,'雕刻厂','雕刻','吃苦耐劳，适应后能长期稳定工作','早7:30-晚5:30','月休2天','前3个月200-500元，4个月以500-1000元，出徒以后3500-4500元（满勤100元）','意外险','包住、餐补每月300元','1天休息','有签定',NULL,NULL,'技术',8),(4,'公司职员',2000,-1,'沈阳','辽中','沈阳市辽中县内','男',18,55,'铜业公司','产品分拣、流水线工作','吃苦耐劳，适应后能长期稳定工作','早8-晚5（加班有加班费）','每周日休息','试用期1个月，扣除五险后基本工资到手2000元（试用期即享有转正后的工资）','五险（上班就签）','包吃住，免费提供','正常休息（如加班提供双薪）','有签定','视实际情况发放',NULL,'生产',10),(5,'公司职工',2000,-1,'沈阳','辽中','沈阳市辽中县内','女',18,45,'铜业公司','产品分拣、流水线工作','吃苦耐劳，适应后能长期稳定工作','早8-晚5（加班有加班费）','每周日休息','试用期1个月，扣除五险后基本工资到手2000元（试用期即享有转正后的工资）','五险（上班就签）','包吃住，免费提供','正常休息（如加班提供双薪）','有签定','视实际情况发放',NULL,'生产',10),(6,'绿化员',1600,-1,'沈阳','辽中','沈阳市辽中县内','男',18,55,'铜业公司','园区内绿化','吃苦耐劳，适应后能长期稳定工作','早8-晚5','每周日休息','试用期1个月，扣除五险后基本工资到手2000元（试用期即享有转正后的工资）','五险（上班就签）','包吃住，免费提供','正常休息','有签定','视实际情况发放',NULL,'技术',2),(7,'生产工人',2000,3000,'沈阳','新民','新民胡台开发区','不限',18,40,'知名熟食企业','生产熟食、流水线工作','吃苦耐劳，适应后能长期稳定工作','早晚倒班制（一般无加班）','每月休息4天','试用期1个月，工资1500；转正后1500+提成（到手2000-3000多劳多得）','五险（转正后签）','吃住免费提供','正常休息','试用期后有签定','无，工龄工资每年加50元','年节礼品','生产',10);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-15 16:15:21
