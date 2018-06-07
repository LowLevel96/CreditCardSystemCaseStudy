-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: CASESTUDY
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Table structure for table `Branch`
--
CREATE DATABASE CASESTUDY;
USE CASESTUDY;

DROP TABLE IF EXISTS `Branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_code` int(9) NOT NULL,
  `branch_name` varchar(25) NOT NULL,
  `branch_street` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `zip` int(7) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `state` int(11) NOT NULL,
  `LAST_UPDATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `state` (`state`),
  CONSTRAINT `Branch_ibfk_1` FOREIGN KEY (`state`) REFERENCES `State` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Branch`
--

LOCK TABLES `Branch` WRITE;
/*!40000 ALTER TABLE `Branch` DISABLE KEYS */;
INSERT INTO `Branch` VALUES (1,853966189,'Branch-Aaren','Street-Aaren','New York',5724,'527189976',27,'2018-05-09 15:35:25'),(2,255511981,'Branch-Aarika','Street-Aarika','New York',18667,'590041424',2,'2018-05-09 15:35:25'),(3,810705737,'Branch-Abagael','Street-Abagael','New York',69962,'628728244',11,'2018-05-09 15:35:25'),(4,167109945,'Branch-Abagail','Street-Abagail','New York',2900,'396819286',35,'2018-05-09 15:35:25'),(5,855595807,'Branch-Abbe','Street-Abbe','New York',74816,'503429828',24,'2018-05-09 15:35:25'),(6,692677429,'Branch-Abbey','Street-Abbey','New York',35594,'533892618',33,'2018-05-09 15:35:25'),(7,23801472,'Branch-Abbi','Street-Abbi','New York',90630,'416898983',41,'2018-05-09 15:35:25'),(8,852797386,'Branch-Abbie','Street-Abbie','New York',92174,'86891531',44,'2018-05-09 15:35:25'),(9,425740667,'Branch-Abby','Street-Abby','New York',74917,'796484086',12,'2018-05-09 15:35:25');
/*!40000 ALTER TABLE `Branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `CDW_SAPP_D_BRANCH`
--

DROP TABLE IF EXISTS `CDW_SAPP_D_BRANCH`;
/*!50001 DROP VIEW IF EXISTS `CDW_SAPP_D_BRANCH`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `CDW_SAPP_D_BRANCH` AS SELECT 
 1 AS `BRANCH_CODE`,
 1 AS `BRANCH_NAME`,
 1 AS `BRANCH_STREET`,
 1 AS `BRANCH_CITY`,
 1 AS `BRANCH_STATE`,
 1 AS `BRANCH_ZIP`,
 1 AS `BRANCH_PHONE`,
 1 AS `LAST_UPDATED`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `CDW_SAPP_D_CUSTOMER`
--

DROP TABLE IF EXISTS `CDW_SAPP_D_CUSTOMER`;
/*!50001 DROP VIEW IF EXISTS `CDW_SAPP_D_CUSTOMER`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `CDW_SAPP_D_CUSTOMER` AS SELECT 
 1 AS `CUST_SSN`,
 1 AS `CUST_F_NAME`,
 1 AS `CUST_M_NAME`,
 1 AS `CUST_L_NAME`,
 1 AS `CUST_CC_NO`,
 1 AS `CUST_STREET`,
 1 AS `CUST_CITY`,
 1 AS `CUST_STATE`,
 1 AS `CUST_COUNTRY`,
 1 AS `CUST_ZIP`,
 1 AS `CUST_PHONE`,
 1 AS `CUST_EMAIL`,
 1 AS `LAST_UPDATED`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `CDW_SAPP_D_TIME`
--

DROP TABLE IF EXISTS `CDW_SAPP_D_TIME`;
/*!50001 DROP VIEW IF EXISTS `CDW_SAPP_D_TIME`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `CDW_SAPP_D_TIME` AS SELECT 
 1 AS `TIMEID`,
 1 AS `day`,
 1 AS `month`,
 1 AS `Quarter`,
 1 AS `year`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `CDW_SAPP_F_CREDIT_CARD`
--

DROP TABLE IF EXISTS `CDW_SAPP_F_CREDIT_CARD`;
/*!50001 DROP VIEW IF EXISTS `CDW_SAPP_F_CREDIT_CARD`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `CDW_SAPP_F_CREDIT_CARD` AS SELECT 
 1 AS `id`,
 1 AS `credit_card_no`,
 1 AS `TIMEID`,
 1 AS `ssn`,
 1 AS `branch_code`,
 1 AS `transaction_type`,
 1 AS `transaction_value`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `Countries`
--

DROP TABLE IF EXISTS `Countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Countries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Countries`
--

LOCK TABLES `Countries` WRITE;
/*!40000 ALTER TABLE `Countries` DISABLE KEYS */;
INSERT INTO `Countries` VALUES (1,'United States');
/*!40000 ALTER TABLE `Countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CreditCard`
--

DROP TABLE IF EXISTS `CreditCard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CreditCard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` int(2) NOT NULL,
  `month` int(2) NOT NULL,
  `year` int(4) NOT NULL,
  `credit_card_no` varchar(16) NOT NULL,
  `branch_code` int(11) NOT NULL,
  `customer` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `branch_code` (`branch_code`),
  KEY `customer` (`customer`),
  CONSTRAINT `CreditCard_ibfk_1` FOREIGN KEY (`branch_code`) REFERENCES `Branch` (`id`),
  CONSTRAINT `CreditCard_ibfk_2` FOREIGN KEY (`customer`) REFERENCES `Customer` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CreditCard`
--

LOCK TABLES `CreditCard` WRITE;
/*!40000 ALTER TABLE `CreditCard` DISABLE KEYS */;
INSERT INTO `CreditCard` VALUES (1,7,11,2020,'1671099454571238',4,1),(2,7,11,2020,'1671099451665626',4,2),(3,7,11,2020,'6926774293761424',6,3),(4,7,11,2020,'4257406673855039',9,4),(5,7,11,2020,'8555958079656359',5,5),(6,7,11,2020,'8539661891748824',1,6),(7,7,11,2020,'8555958071656466',5,7),(8,7,11,2020,'8555958073946071',5,8),(9,7,11,2020,'2555119812116849',2,9),(10,7,11,2020,'4257406674071919',9,10),(11,7,11,2020,'8539661896982544',1,11),(12,7,11,2020,'425740667268990',9,12),(13,7,11,2020,'4257406671046187',9,13),(14,7,11,2020,'855595807438988',5,14),(15,7,11,2020,'4257406672216782',9,15),(16,7,11,2020,'8527973862640227',8,16),(17,7,11,2020,'8527973861135368',8,17),(18,7,11,2020,'4257406673576510',9,18),(19,7,11,2020,'8527973868162568',8,19),(20,7,11,2020,'238014724523778',7,20);
/*!40000 ALTER TABLE `CreditCard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(40) NOT NULL,
  `middle_name` varchar(40) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `phone` int(10) NOT NULL,
  `email` varchar(40) NOT NULL,
  `ssn` varchar(9) NOT NULL,
  `zip` varchar(7) NOT NULL,
  `apt_no` varchar(7) NOT NULL,
  `street_name` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` int(11) NOT NULL,
  `number_of_cc` int(11) NOT NULL,
  `LAST_UPDATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `state` (`state`),
  CONSTRAINT `Customer_ibfk_1` FOREIGN KEY (`state`) REFERENCES `State` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (1,'Norry','Mitch','Helena',280529077,'Norry@gmail.com','533379877','3116367','23F','7. Juli','New York',3,1,'2018-05-09 15:36:25'),(2,'Manda','Rupert','Bushore',416097713,'Manda@gmail.com','183688870','148800','68F','7. Juli','New York',14,1,'2018-05-09 15:36:25'),(3,'Saloma','Hyman','Bertasi',507521641,'Saloma@gmail.com','645387280','453344','3F','7. Juli','New York',22,1,'2018-05-09 15:36:25'),(4,'Cassandry','Rurik','Flower',855137964,'Cassandry@gmail.com','817435294','7980977','76F','7. Juli','New York',13,1,'2018-05-09 15:36:25'),(5,'Nicol','Isaac','Chadwick',431964264,'Nicol@gmail.com','90958236','6032381','11F','7. Juli','New York',19,1,'2018-05-09 15:36:25'),(6,'Marthena','Farley','Radman',73654274,'Marthena@gmail.com','302945804','7623926','76F','7. Juli','New York',13,1,'2018-05-09 15:36:25'),(7,'Kellyann','Farlie','Reena',438341260,'Kellyann@gmail.com','615600673','9935157','1F','7. Juli','New York',15,1,'2018-05-09 15:36:25'),(8,'Tomi','Stanton','Cam',487639636,'Tomi@gmail.com','728543360','5439129','30F','7. Juli','New York',3,1,'2018-05-09 15:36:25'),(9,'Licha','Nolan','Fauver',10746856,'Licha@gmail.com','44802142','3732983','58F','7. Juli','New York',21,1,'2018-05-09 15:36:25'),(10,'Adrian','Jone','Earl',106272983,'Adrian@gmail.com','495321808','9094355','75F','7. Juli','New York',11,1,'2018-05-09 15:36:25'),(11,'Heida','Delmer','Canada',370757618,'Heida@gmail.com','908056067','8772571','31F','7. Juli','New York',44,1,'2018-05-09 15:36:25'),(12,'Leese','Manfred','Lawry',958439817,'Leese@gmail.com','269198976','6632883','84F','7. Juli','New York',22,1,'2018-05-09 15:36:25'),(13,'Carole','Etan','Coffee',671816625,'Carole@gmail.com','938066022','8303289','26F','7. Juli','New York',7,1,'2018-05-09 15:36:25'),(14,'Vivien','Sheffy','Lowrie',534515842,'Vivien@gmail.com','106504367','872056','9F','7. Juli','New York',7,1,'2018-05-09 15:36:25'),(15,'Kippy','Virgil','Oran',857654869,'Kippy@gmail.com','455781494','2256335','50F','7. Juli','New York',47,1,'2018-05-09 15:36:25'),(16,'Nananne','Reamonn','Dare',850414596,'Nananne@gmail.com','587333156','5574907','80F','7. Juli','New York',28,1,'2018-05-09 15:36:25'),(17,'Rozella','Whitby','Miksen',938457387,'Rozella@gmail.com','741288646','7438328','89F','7. Juli','New York',5,1,'2018-05-09 15:36:25'),(18,'Myriam','Royce','Concha',906367591,'Myriam@gmail.com','744251199','2274947','68F','7. Juli','New York',44,1,'2018-05-09 15:36:25'),(19,'Goldina','Davide','Firmin',775989148,'Goldina@gmail.com','588953483','6092373','73F','7. Juli','New York',10,1,'2018-05-09 15:36:25'),(20,'Nikki','Elroy','Dempster',428272683,'Nikki@gmail.com','958884362','3499867','17F','7. Juli','New York',41,1,'2018-05-09 15:36:25');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Payments`
--

DROP TABLE IF EXISTS `Payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `month` varchar(2) NOT NULL,
  `year` varchar(4) NOT NULL,
  `balance` float NOT NULL,
  `payments` float NOT NULL,
  `credit_card` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `credit_card` (`credit_card`),
  CONSTRAINT `Payments_ibfk_1` FOREIGN KEY (`credit_card`) REFERENCES `CreditCard` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payments`
--

LOCK TABLES `Payments` WRITE;
/*!40000 ALTER TABLE `Payments` DISABLE KEYS */;
INSERT INTO `Payments` VALUES (1,'1','2018',50679,0,1),(2,'4','2018',18875,0,1),(3,'3','2018',36096,0,1),(4,'2','2018',618,0,1),(5,'3','2018',16648,0,2),(6,'1','2018',24799,0,2),(7,'2','2018',18221,0,2),(8,'2','2018',806,0,3),(9,'3','2018',780,0,3),(10,'1','2018',5849,0,4),(11,'2','2018',25385,0,4),(12,'3','2018',1529,0,4),(13,'4','2018',5165,0,4),(14,'3','2018',29790,0,5),(15,'2','2018',32888,0,5),(16,'1','2018',18415,0,5),(17,'2','2018',7896,0,6),(18,'1','2018',18428,0,6),(19,'4','2018',8216,0,6),(20,'2','2018',6897,0,7),(21,'1','2018',28061,0,7),(22,'3','2018',18439,0,7),(23,'1','2018',13787,0,8),(24,'4','2018',3401,0,8),(25,'2','2018',45583,0,8),(26,'3','2018',5187,0,8),(27,'1','2018',15985,0,9),(28,'3','2018',11692,0,9),(29,'2','2018',6229,0,9),(30,'2','2018',9517,0,10),(31,'1','2018',2614,0,10),(32,'4','2018',15687,0,10),(33,'3','2018',8904,0,10),(34,'2','2018',50633,0,11),(35,'1','2018',32583,0,11),(36,'4','2018',13220,0,11),(37,'3','2018',25263,0,11),(38,'2','2018',20138,0,12),(39,'1','2018',32545,0,12),(40,'4','2018',14027,0,12),(41,'3','2018',19205,0,12),(42,'2','2018',15957,0,13),(43,'3','2018',43474,0,13),(44,'1','2018',38308,0,13),(45,'4','2018',4738,0,13),(46,'3','2018',53989,0,14),(47,'2','2018',36870,0,14),(48,'1','2018',24545,0,14),(49,'4','2018',9920,0,14),(50,'3','2018',26617,0,15),(51,'4','2018',25647,0,15),(52,'1','2018',22801,0,15),(53,'2','2018',18536,0,15),(54,'1','2018',31001,0,16),(55,'3','2018',57288,0,16),(56,'2','2018',9942,0,16),(57,'4','2018',7499,0,16),(58,'3','2018',23516,0,17),(59,'1','2018',30989,0,17),(60,'2','2018',20740,0,17),(61,'4','2018',5262,0,17),(62,'3','2018',39162,0,18),(63,'1','2018',29572,0,18),(64,'4','2018',30899,0,18),(65,'2','2018',42637,0,18),(66,'3','2018',24159,0,19),(67,'1','2018',2512,0,19),(68,'2','2018',24995,0,19),(69,'2','2018',13505,0,20),(70,'3','2018',27190,0,20),(71,'1','2018',11455,0,20),(72,'4','2018',26292,0,20);
/*!40000 ALTER TABLE `Payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `State`
--

DROP TABLE IF EXISTS `State`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `State` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `State_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `Countries` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `State`
--

LOCK TABLES `State` WRITE;
/*!40000 ALTER TABLE `State` DISABLE KEYS */;
INSERT INTO `State` VALUES (1,'Alabama',1),(2,'Alaska',1),(3,'Arizona',1),(4,'Arkansas',1),(5,'California',1),(6,'Colorado',1),(7,'Connecticut',1),(8,'Delaware',1),(9,'Florida',1),(10,'Georgia',1),(11,'Hawaii',1),(12,'Idaho',1),(13,'Illinois',1),(14,'Indiana',1),(15,'Iowa',1),(16,'Kansas',1),(17,'Kentucky',1),(18,'Louisiana',1),(19,'Maine',1),(20,'Maryland',1),(21,'Massachusetts',1),(22,'Michigan',1),(23,'Minnesota',1),(24,'Mississippi',1),(25,'Missouri',1),(26,'Montana',1),(27,'Nebraska',1),(28,'Nevada',1),(29,'New Hampshire',1),(30,'New Jersey',1),(31,'New Mexico',1),(32,'New York',1),(33,'North Carolina',1),(34,'North Dakota',1),(35,'Ohio',1),(36,'Oklahoma',1),(37,'Oregon',1),(38,'Pennsylvania',1),(39,'Rhode Island',1),(40,'South Carolina',1),(41,'South Dakota',1),(42,'Tennessee',1),(43,'Texas',1),(44,'Utah',1),(45,'Vermont',1),(46,'Virginia',1),(47,'Washington',1),(48,'West Virginia',1),(49,'Wisconsin',1),(50,'Wyoming',1);
/*!40000 ALTER TABLE `State` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Transactions`
--

DROP TABLE IF EXISTS `Transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Transactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `credit_card_no` int(11) NOT NULL,
  `transaction_type` varchar(30) NOT NULL,
  `transaction_value` double NOT NULL,
  `transaction_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `credit_card_no` (`credit_card_no`),
  CONSTRAINT `Transactions_ibfk_1` FOREIGN KEY (`credit_card_no`) REFERENCES `CreditCard` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Transactions`
--

LOCK TABLES `Transactions` WRITE;
/*!40000 ALTER TABLE `Transactions` DISABLE KEYS */;
INSERT INTO `Transactions` VALUES (1,1,'Type2',4240,'2018-01-31 00:00:00'),(2,1,'Type8',7617,'2018-04-01 00:00:00'),(3,1,'Type6',3232,'2018-01-11 00:00:00'),(4,1,'Type2',3663,'2018-01-29 00:00:00'),(5,1,'Type0',7508,'2018-03-21 00:00:00'),(6,1,'Type5',1134,'2018-03-18 00:00:00'),(7,1,'Type4',1959,'2018-04-12 00:00:00'),(8,1,'Type8',8894,'2018-03-19 00:00:00'),(9,1,'Type1',438,'2018-01-31 00:00:00'),(10,1,'Type6',2792,'2018-01-10 00:00:00'),(11,1,'Type6',4886,'2018-03-17 00:00:00'),(12,1,'Type5',7808,'2018-01-21 00:00:00'),(13,1,'Type1',4238,'2018-04-01 00:00:00'),(14,1,'Type3',5580,'2018-01-22 00:00:00'),(15,1,'Type9',9583,'2018-03-19 00:00:00'),(16,1,'Type5',7355,'2018-01-28 00:00:00'),(17,1,'Type3',4091,'2018-03-27 00:00:00'),(18,1,'Type0',5061,'2018-04-06 00:00:00'),(19,1,'Type5',618,'2018-02-05 00:00:00'),(20,1,'Type1',6279,'2018-01-18 00:00:00'),(21,1,'Type9',9292,'2018-01-08 00:00:00'),(22,2,'Type5',2299,'2018-03-03 00:00:00'),(23,2,'Type7',8710,'2018-01-31 00:00:00'),(24,2,'Type6',4415,'2018-02-10 00:00:00'),(25,2,'Type8',3178,'2018-03-30 00:00:00'),(26,2,'Type8',5448,'2018-03-12 00:00:00'),(27,2,'Type7',4245,'2018-03-20 00:00:00'),(28,2,'Type1',9526,'2018-01-08 00:00:00'),(29,2,'Type4',5373,'2018-02-22 00:00:00'),(30,2,'Type5',2742,'2018-01-08 00:00:00'),(31,2,'Type7',427,'2018-03-31 00:00:00'),(32,2,'Type4',1051,'2018-03-22 00:00:00'),(33,2,'Type3',2660,'2018-02-10 00:00:00'),(34,2,'Type3',5773,'2018-02-10 00:00:00'),(35,2,'Type8',3821,'2018-01-07 00:00:00'),(36,3,'Type3',806,'2018-02-11 00:00:00'),(37,3,'Type5',780,'2018-03-01 00:00:00'),(38,4,'Type4',5849,'2018-01-18 00:00:00'),(39,4,'Type3',4861,'2018-02-10 00:00:00'),(40,4,'Type9',2600,'2018-02-20 00:00:00'),(41,4,'Type0',3809,'2018-02-04 00:00:00'),(42,4,'Type1',9507,'2018-02-09 00:00:00'),(43,4,'Type2',4608,'2018-02-01 00:00:00'),(44,4,'Type9',1529,'2018-03-02 00:00:00'),(45,4,'Type7',5165,'2018-04-05 00:00:00'),(46,5,'Type1',4691,'2018-03-21 00:00:00'),(47,5,'Type0',8727,'2018-02-05 00:00:00'),(48,5,'Type0',1030,'2018-01-19 00:00:00'),(49,5,'Type4',5005,'2018-01-01 00:00:00'),(50,5,'Type1',6453,'2018-03-24 00:00:00'),(51,5,'Type8',6644,'2018-02-08 00:00:00'),(52,5,'Type0',5546,'2018-03-30 00:00:00'),(53,5,'Type7',5197,'2018-03-07 00:00:00'),(54,5,'Type9',4242,'2018-01-14 00:00:00'),(55,5,'Type8',2191,'2018-02-27 00:00:00'),(56,5,'Type6',8138,'2018-01-04 00:00:00'),(57,5,'Type5',8170,'2018-02-25 00:00:00'),(58,5,'Type4',7156,'2018-02-03 00:00:00'),(59,5,'Type3',7903,'2018-03-24 00:00:00'),(60,6,'Type3',2226,'2018-02-05 00:00:00'),(61,6,'Type5',5231,'2018-01-12 00:00:00'),(62,6,'Type5',5670,'2018-02-12 00:00:00'),(63,6,'Type0',8216,'2018-04-11 00:00:00'),(64,6,'Type4',609,'2018-01-13 00:00:00'),(65,6,'Type4',5334,'2018-01-23 00:00:00'),(66,6,'Type1',7254,'2018-01-04 00:00:00'),(67,7,'Type6',6897,'2018-02-25 00:00:00'),(68,7,'Type1',5822,'2018-01-05 00:00:00'),(69,7,'Type2',9624,'2018-01-04 00:00:00'),(70,7,'Type2',3950,'2018-03-11 00:00:00'),(71,7,'Type6',2589,'2018-03-23 00:00:00'),(72,7,'Type9',4962,'2018-03-17 00:00:00'),(73,7,'Type1',6938,'2018-03-21 00:00:00'),(74,7,'Type6',7330,'2018-01-23 00:00:00'),(75,7,'Type5',5285,'2018-01-01 00:00:00'),(76,8,'Type2',8511,'2018-01-28 00:00:00'),(77,8,'Type9',3401,'2018-04-10 00:00:00'),(78,8,'Type0',8877,'2018-02-18 00:00:00'),(79,8,'Type8',2726,'2018-01-19 00:00:00'),(80,8,'Type3',8612,'2018-02-21 00:00:00'),(81,8,'Type7',4800,'2018-02-08 00:00:00'),(82,8,'Type3',1663,'2018-03-16 00:00:00'),(83,8,'Type0',770,'2018-03-27 00:00:00'),(84,8,'Type2',464,'2018-01-06 00:00:00'),(85,8,'Type9',2161,'2018-02-02 00:00:00'),(86,8,'Type1',894,'2018-02-18 00:00:00'),(87,8,'Type2',8458,'2018-02-13 00:00:00'),(88,8,'Type3',3769,'2018-02-27 00:00:00'),(89,8,'Type7',253,'2018-01-30 00:00:00'),(90,8,'Type4',1539,'2018-01-02 00:00:00'),(91,8,'Type8',294,'2018-01-09 00:00:00'),(92,8,'Type3',2754,'2018-03-25 00:00:00'),(93,8,'Type2',8012,'2018-02-10 00:00:00'),(94,9,'Type4',7476,'2018-01-04 00:00:00'),(95,9,'Type0',7434,'2018-03-22 00:00:00'),(96,9,'Type4',4258,'2018-03-01 00:00:00'),(97,9,'Type2',8509,'2018-01-06 00:00:00'),(98,9,'Type2',6229,'2018-02-19 00:00:00'),(99,10,'Type2',4479,'2018-02-15 00:00:00'),(100,10,'Type6',2614,'2018-01-22 00:00:00'),(101,10,'Type2',5038,'2018-02-20 00:00:00'),(102,10,'Type9',9796,'2018-04-04 00:00:00'),(103,10,'Type7',8904,'2018-03-24 00:00:00'),(104,10,'Type9',5891,'2018-04-04 00:00:00'),(105,11,'Type2',6435,'2018-02-07 00:00:00'),(106,11,'Type5',467,'2018-01-17 00:00:00'),(107,11,'Type8',8326,'2018-04-12 00:00:00'),(108,11,'Type9',4333,'2018-01-06 00:00:00'),(109,11,'Type2',5179,'2018-03-22 00:00:00'),(110,11,'Type9',4471,'2018-02-10 00:00:00'),(111,11,'Type9',4232,'2018-01-06 00:00:00'),(112,11,'Type6',666,'2018-02-15 00:00:00'),(113,11,'Type0',2887,'2018-01-01 00:00:00'),(114,11,'Type9',8152,'2018-01-06 00:00:00'),(115,11,'Type6',9249,'2018-02-06 00:00:00'),(116,11,'Type5',6497,'2018-02-15 00:00:00'),(117,11,'Type5',1045,'2018-02-23 00:00:00'),(118,11,'Type3',1318,'2018-01-21 00:00:00'),(119,11,'Type0',8449,'2018-01-24 00:00:00'),(120,11,'Type1',664,'2018-03-22 00:00:00'),(121,11,'Type5',2745,'2018-01-08 00:00:00'),(122,11,'Type7',917,'2018-02-28 00:00:00'),(123,11,'Type1',1219,'2018-03-20 00:00:00'),(124,11,'Type0',6873,'2018-03-10 00:00:00'),(125,11,'Type8',7135,'2018-02-09 00:00:00'),(126,11,'Type7',6236,'2018-03-31 00:00:00'),(127,11,'Type8',6215,'2018-02-12 00:00:00'),(128,11,'Type6',4894,'2018-04-11 00:00:00'),(129,11,'Type0',3910,'2018-03-31 00:00:00'),(130,11,'Type5',8003,'2018-02-05 00:00:00'),(131,11,'Type3',1182,'2018-03-28 00:00:00'),(132,12,'Type8',9370,'2018-02-25 00:00:00'),(133,12,'Type5',8244,'2018-01-12 00:00:00'),(134,12,'Type4',2013,'2018-04-12 00:00:00'),(135,12,'Type3',6466,'2018-01-11 00:00:00'),(136,12,'Type4',6939,'2018-02-10 00:00:00'),(137,12,'Type7',3391,'2018-04-02 00:00:00'),(138,12,'Type1',4265,'2018-04-03 00:00:00'),(139,12,'Type0',3847,'2018-01-17 00:00:00'),(140,12,'Type0',1976,'2018-02-04 00:00:00'),(141,12,'Type2',4358,'2018-04-09 00:00:00'),(142,12,'Type7',1853,'2018-02-06 00:00:00'),(143,12,'Type8',3580,'2018-01-29 00:00:00'),(144,12,'Type6',1820,'2018-01-11 00:00:00'),(145,12,'Type0',9369,'2018-03-19 00:00:00'),(146,12,'Type8',9836,'2018-03-23 00:00:00'),(147,12,'Type0',8588,'2018-01-20 00:00:00'),(148,13,'Type8',2126,'2018-02-20 00:00:00'),(149,13,'Type3',2424,'2018-03-20 00:00:00'),(150,13,'Type4',4995,'2018-03-10 00:00:00'),(151,13,'Type6',114,'2018-01-04 00:00:00'),(152,13,'Type8',6645,'2018-01-24 00:00:00'),(153,13,'Type0',6914,'2018-03-13 00:00:00'),(154,13,'Type0',4773,'2018-01-08 00:00:00'),(155,13,'Type6',8289,'2018-03-30 00:00:00'),(156,13,'Type8',4538,'2018-02-19 00:00:00'),(157,13,'Type3',448,'2018-02-10 00:00:00'),(158,13,'Type1',4740,'2018-03-21 00:00:00'),(159,13,'Type5',4738,'2018-04-12 00:00:00'),(160,13,'Type4',4032,'2018-01-30 00:00:00'),(161,13,'Type9',1119,'2018-01-17 00:00:00'),(162,13,'Type0',4201,'2018-03-01 00:00:00'),(163,13,'Type5',4493,'2018-01-08 00:00:00'),(164,13,'Type9',4836,'2018-01-31 00:00:00'),(165,13,'Type2',2645,'2018-03-03 00:00:00'),(166,13,'Type1',6868,'2018-03-19 00:00:00'),(167,13,'Type9',9159,'2018-01-31 00:00:00'),(168,13,'Type7',2398,'2018-03-22 00:00:00'),(169,13,'Type6',8845,'2018-02-28 00:00:00'),(170,13,'Type1',3137,'2018-01-30 00:00:00'),(171,14,'Type6',2072,'2018-03-07 00:00:00'),(172,14,'Type0',959,'2018-02-24 00:00:00'),(173,14,'Type1',3936,'2018-01-26 00:00:00'),(174,14,'Type8',246,'2018-03-30 00:00:00'),(175,14,'Type2',8142,'2018-02-06 00:00:00'),(176,14,'Type6',7234,'2018-03-05 00:00:00'),(177,14,'Type3',5670,'2018-03-18 00:00:00'),(178,14,'Type8',6096,'2018-03-10 00:00:00'),(179,14,'Type8',8154,'2018-01-26 00:00:00'),(180,14,'Type4',9920,'2018-04-12 00:00:00'),(181,14,'Type0',9350,'2018-02-10 00:00:00'),(182,14,'Type7',9652,'2018-02-14 00:00:00'),(183,14,'Type0',6982,'2018-03-08 00:00:00'),(184,14,'Type2',8767,'2018-02-21 00:00:00'),(185,14,'Type5',2830,'2018-03-24 00:00:00'),(186,14,'Type4',1276,'2018-01-25 00:00:00'),(187,14,'Type7',3348,'2018-03-01 00:00:00'),(188,14,'Type0',9099,'2018-01-16 00:00:00'),(189,14,'Type5',9826,'2018-03-25 00:00:00'),(190,14,'Type3',9685,'2018-03-10 00:00:00'),(191,14,'Type5',2080,'2018-01-07 00:00:00'),(192,15,'Type5',6172,'2018-03-17 00:00:00'),(193,15,'Type1',3380,'2018-04-10 00:00:00'),(194,15,'Type0',289,'2018-01-02 00:00:00'),(195,15,'Type0',5003,'2018-03-02 00:00:00'),(196,15,'Type5',3770,'2018-03-19 00:00:00'),(197,15,'Type2',2820,'2018-01-25 00:00:00'),(198,15,'Type2',8819,'2018-04-04 00:00:00'),(199,15,'Type3',298,'2018-04-11 00:00:00'),(200,15,'Type2',5037,'2018-01-04 00:00:00'),(201,15,'Type6',265,'2018-01-04 00:00:00'),(202,15,'Type9',6357,'2018-01-13 00:00:00'),(203,15,'Type5',2655,'2018-03-25 00:00:00'),(204,15,'Type3',8163,'2018-04-08 00:00:00'),(205,15,'Type7',8596,'2018-02-15 00:00:00'),(206,15,'Type7',4176,'2018-03-17 00:00:00'),(207,15,'Type9',9940,'2018-02-24 00:00:00'),(208,15,'Type0',3047,'2018-03-09 00:00:00'),(209,15,'Type9',611,'2018-04-05 00:00:00'),(210,15,'Type8',300,'2018-03-02 00:00:00'),(211,15,'Type5',8033,'2018-01-29 00:00:00'),(212,15,'Type0',1494,'2018-03-18 00:00:00'),(213,15,'Type9',4376,'2018-04-02 00:00:00'),(214,16,'Type1',9014,'2018-01-29 00:00:00'),(215,16,'Type4',2968,'2018-03-18 00:00:00'),(216,16,'Type5',8392,'2018-03-13 00:00:00'),(217,16,'Type3',7907,'2018-01-02 00:00:00'),(218,16,'Type3',6362,'2018-03-31 00:00:00'),(219,16,'Type5',7015,'2018-03-09 00:00:00'),(220,16,'Type6',9942,'2018-02-13 00:00:00'),(221,16,'Type1',3652,'2018-01-11 00:00:00'),(222,16,'Type6',1788,'2018-01-15 00:00:00'),(223,16,'Type9',5369,'2018-03-06 00:00:00'),(224,16,'Type9',9740,'2018-03-02 00:00:00'),(225,16,'Type8',7499,'2018-04-06 00:00:00'),(226,16,'Type7',8845,'2018-03-02 00:00:00'),(227,16,'Type3',8597,'2018-03-11 00:00:00'),(228,16,'Type7',8640,'2018-01-12 00:00:00'),(229,17,'Type4',9855,'2018-03-01 00:00:00'),(230,17,'Type2',884,'2018-01-14 00:00:00'),(231,17,'Type9',2934,'2018-01-12 00:00:00'),(232,17,'Type3',1132,'2018-02-16 00:00:00'),(233,17,'Type5',5237,'2018-02-07 00:00:00'),(234,17,'Type8',6423,'2018-01-04 00:00:00'),(235,17,'Type9',8343,'2018-01-12 00:00:00'),(236,17,'Type5',6945,'2018-03-31 00:00:00'),(237,17,'Type3',462,'2018-04-04 00:00:00'),(238,17,'Type6',7934,'2018-02-18 00:00:00'),(239,17,'Type8',3864,'2018-01-17 00:00:00'),(240,17,'Type8',8541,'2018-01-29 00:00:00'),(241,17,'Type4',6716,'2018-03-07 00:00:00'),(242,17,'Type5',4800,'2018-04-09 00:00:00'),(243,17,'Type2',5925,'2018-02-05 00:00:00'),(244,17,'Type9',512,'2018-02-16 00:00:00'),(245,18,'Type7',8382,'2018-03-24 00:00:00'),(246,18,'Type2',3365,'2018-03-02 00:00:00'),(247,18,'Type2',2893,'2018-03-15 00:00:00'),(248,18,'Type0',3588,'2018-01-30 00:00:00'),(249,18,'Type9',2198,'2018-04-04 00:00:00'),(250,18,'Type4',8440,'2018-04-07 00:00:00'),(251,18,'Type0',2377,'2018-01-13 00:00:00'),(252,18,'Type4',4707,'2018-02-12 00:00:00'),(253,18,'Type5',4550,'2018-04-07 00:00:00'),(254,18,'Type1',1217,'2018-02-22 00:00:00'),(255,18,'Type9',9099,'2018-04-01 00:00:00'),(256,18,'Type1',1736,'2018-03-17 00:00:00'),(257,18,'Type9',8470,'2018-02-04 00:00:00'),(258,18,'Type6',4338,'2018-02-06 00:00:00'),(259,18,'Type1',385,'2018-03-12 00:00:00'),(260,18,'Type9',1395,'2018-02-22 00:00:00'),(261,18,'Type7',8392,'2018-01-08 00:00:00'),(262,18,'Type0',7847,'2018-01-30 00:00:00'),(263,18,'Type3',6612,'2018-04-03 00:00:00'),(264,18,'Type1',7368,'2018-01-01 00:00:00'),(265,18,'Type0',8612,'2018-02-16 00:00:00'),(266,18,'Type0',6692,'2018-02-25 00:00:00'),(267,18,'Type5',6182,'2018-03-29 00:00:00'),(268,18,'Type9',9599,'2018-03-30 00:00:00'),(269,18,'Type6',5226,'2018-02-23 00:00:00'),(270,18,'Type7',4791,'2018-03-01 00:00:00'),(271,18,'Type3',1829,'2018-03-06 00:00:00'),(272,18,'Type2',1980,'2018-02-05 00:00:00'),(273,19,'Type1',3037,'2018-03-18 00:00:00'),(274,19,'Type1',3643,'2018-03-08 00:00:00'),(275,19,'Type3',3014,'2018-03-15 00:00:00'),(276,19,'Type5',1783,'2018-01-19 00:00:00'),(277,19,'Type1',8384,'2018-02-24 00:00:00'),(278,19,'Type3',2555,'2018-03-31 00:00:00'),(279,19,'Type8',9731,'2018-02-21 00:00:00'),(280,19,'Type0',6203,'2018-03-02 00:00:00'),(281,19,'Type1',5707,'2018-03-02 00:00:00'),(282,19,'Type8',729,'2018-01-31 00:00:00'),(283,19,'Type2',6880,'2018-02-22 00:00:00'),(284,20,'Type1',8567,'2018-02-26 00:00:00'),(285,20,'Type5',2720,'2018-03-24 00:00:00'),(286,20,'Type0',2893,'2018-01-08 00:00:00'),(287,20,'Type0',6569,'2018-04-01 00:00:00'),(288,20,'Type0',3922,'2018-03-11 00:00:00'),(289,20,'Type4',4953,'2018-03-15 00:00:00'),(290,20,'Type9',3724,'2018-03-30 00:00:00'),(291,20,'Type1',2306,'2018-03-13 00:00:00'),(292,20,'Type4',4113,'2018-04-05 00:00:00'),(293,20,'Type7',6970,'2018-04-08 00:00:00'),(294,20,'Type3',1028,'2018-02-09 00:00:00'),(295,20,'Type2',5047,'2018-04-06 00:00:00'),(296,20,'Type0',9565,'2018-03-24 00:00:00'),(297,20,'Type9',8562,'2018-01-13 00:00:00'),(298,20,'Type8',3430,'2018-04-12 00:00:00'),(299,20,'Type1',3910,'2018-02-19 00:00:00'),(300,20,'Type6',163,'2018-04-10 00:00:00');
/*!40000 ALTER TABLE `Transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `CDW_SAPP_D_BRANCH`
--

/*!50001 DROP VIEW IF EXISTS `CDW_SAPP_D_BRANCH`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `CDW_SAPP_D_BRANCH` AS select `b`.`branch_code` AS `BRANCH_CODE`,`b`.`branch_name` AS `BRANCH_NAME`,`b`.`branch_street` AS `BRANCH_STREET`,`b`.`city` AS `BRANCH_CITY`,`s`.`name` AS `BRANCH_STATE`,`b`.`zip` AS `BRANCH_ZIP`,`b`.`phone` AS `BRANCH_PHONE`,`b`.`LAST_UPDATED` AS `LAST_UPDATED` from (`Branch` `b` join `State` `s` on((`b`.`state` = `s`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `CDW_SAPP_D_CUSTOMER`
--

/*!50001 DROP VIEW IF EXISTS `CDW_SAPP_D_CUSTOMER`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `CDW_SAPP_D_CUSTOMER` AS select `c`.`ssn` AS `CUST_SSN`,`c`.`first_name` AS `CUST_F_NAME`,`c`.`middle_name` AS `CUST_M_NAME`,`c`.`last_name` AS `CUST_L_NAME`,`cc`.`credit_card_no` AS `CUST_CC_NO`,concat(concat(`c`.`apt_no`,' '),`c`.`street_name`) AS `CUST_STREET`,`c`.`city` AS `CUST_CITY`,`s`.`name` AS `CUST_STATE`,`Countries`.`name` AS `CUST_COUNTRY`,`c`.`zip` AS `CUST_ZIP`,`c`.`phone` AS `CUST_PHONE`,`c`.`email` AS `CUST_EMAIL`,`c`.`LAST_UPDATED` AS `LAST_UPDATED` from (((`Customer` `c` left join `CreditCard` `cc` on((`c`.`Id` = `cc`.`customer`))) left join `State` `s` on((`c`.`state` = `s`.`id`))) left join `Countries` on((`s`.`country_id` = `Countries`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `CDW_SAPP_D_TIME`
--

/*!50001 DROP VIEW IF EXISTS `CDW_SAPP_D_TIME`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `CDW_SAPP_D_TIME` AS select concat(`cc`.`day`,`cc`.`month`,`cc`.`year`) AS `TIMEID`,`cc`.`day` AS `day`,`cc`.`month` AS `month`,(case when (quarter(concat(`cc`.`year`,'-',`cc`.`month`,'-',`cc`.`day`)) = 1) then 'FIRST' when (quarter(concat(`cc`.`year`,'-',`cc`.`month`,'-',`cc`.`day`)) = 2) then 'SECOND' when (quarter(concat(`cc`.`year`,'-',`cc`.`month`,'-',`cc`.`day`)) = 3) then 'THIRD' when (quarter(concat(`cc`.`year`,'-',`cc`.`month`,'-',`cc`.`day`)) = 4) then 'FOURTH' end) AS `Quarter`,`cc`.`year` AS `year` from `CreditCard` `cc` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `CDW_SAPP_F_CREDIT_CARD`
--

/*!50001 DROP VIEW IF EXISTS `CDW_SAPP_F_CREDIT_CARD`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `CDW_SAPP_F_CREDIT_CARD` AS select `t`.`id` AS `id`,`cc`.`credit_card_no` AS `credit_card_no`,concat(`cc`.`day`,`cc`.`month`,`cc`.`year`) AS `TIMEID`,`c`.`ssn` AS `ssn`,`b`.`branch_code` AS `branch_code`,`t`.`transaction_type` AS `transaction_type`,`t`.`transaction_value` AS `transaction_value` from (((`CreditCard` `cc` join `Customer` `c` on((`cc`.`customer` = `c`.`Id`))) join `Branch` `b` on((`b`.`id` = `cc`.`branch_code`))) join `Transactions` `t` on((`cc`.`id` = `t`.`credit_card_no`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-09 12:14:34
