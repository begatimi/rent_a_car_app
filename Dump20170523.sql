CREATE DATABASE  IF NOT EXISTS `rent_a_car` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rent_a_car`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: rent_a_car
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `kategorite`
--

DROP TABLE IF EXISTS `kategorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategorite` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `kategorite` varchar(45) CHARACTER SET utf8 NOT NULL,
  `kostojaDitore` int(11) NOT NULL,
  `kostojaJavore` int(11) NOT NULL,
  `kostojaMujore` int(11) NOT NULL,
  PRIMARY KEY (`kid`),
  UNIQUE KEY `kategorite_UNIQUE` (`kategorite`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategorite`
--

LOCK TABLES `kategorite` WRITE;
/*!40000 ALTER TABLE `kategorite` DISABLE KEYS */;
INSERT INTO `kategorite` VALUES (1,'Familjar i Vogël',15,90,405),(2,'Familjar i Madhë',25,140,550),(3,'Sport',30,180,4500),(4,'Super Sport',50,300,7500),(5,'Luksoz',30,185,4600),(6,'Mini',12,60,99);
/*!40000 ALTER TABLE `kategorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `listoveturat`
--

DROP TABLE IF EXISTS `listoveturat`;
/*!50001 DROP VIEW IF EXISTS `listoveturat`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `listoveturat` AS SELECT 
 1 AS `VID`,
 1 AS `Marka`,
 1 AS `Modeli`,
 1 AS `Viti Prodhimit`,
 1 AS `Nderruesi Shpejt.`,
 1 AS `Nr. Uleseve`,
 1 AS `Karburanti`,
 1 AS `Shpenzimet`,
 1 AS `Sasia Totale`,
 1 AS `Sasia Lire`,
 1 AS `Sasia Rezervuar`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `llogarite`
--

DROP TABLE IF EXISTS `llogarite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `llogarite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perdoruesi` varchar(25) NOT NULL,
  `fjalekalimi` varchar(45) NOT NULL,
  `salti` varchar(45) NOT NULL,
  `eshteAktiv` varchar(2) NOT NULL,
  `emri` varchar(45) NOT NULL,
  `mbiemri` varchar(45) NOT NULL,
  `numriTelefonit` varchar(15) NOT NULL,
  `emaili` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llogarite`
--

LOCK TABLES `llogarite` WRITE;
/*!40000 ALTER TABLE `llogarite` DISABLE KEYS */;
INSERT INTO `llogarite` VALUES (1,'admin','bef52577069eb3d6a2ab414122d5732a','dk0QwHJLh69wSz2Bw3EQAQ==','po','Getoar','Gaxherri','049442171','',''),(3,'test','c014498562f86b35ba0b5867d1163ac5','9DANvlU6mnQ/MBeDX+ckRQ==','po','Filan','Fisteku','044567891','filan@fisteku.com','Prishtine'),(4,'Said','68f582c86fc76310c67b121b51b2489a','0yenGK2wzDB4taP1PZeCNQ==','po','Said','Sylejmani','044431084','saidsljmn@gmail.com','dodona1'),(5,'Begatim','ad56883ec0a8c4aeb33591514f6dc98d','dCfRSrnhl2QCvuPX4C86qg==','po','Begatim ','Lekaj','042042042','begia@gkdgj.com','prishtine');
/*!40000 ALTER TABLE `llogarite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezervimet`
--

DROP TABLE IF EXISTS `rezervimet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rezervimet` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `vid` int(11) NOT NULL,
  `emriMbiemri` varchar(45) NOT NULL,
  `numriTelefonit` varchar(45) NOT NULL,
  `prej` date NOT NULL,
  `deri` date NOT NULL,
  `cmimi` double NOT NULL,
  PRIMARY KEY (`rid`),
  KEY `vid_idx` (`vid`),
  CONSTRAINT `vid` FOREIGN KEY (`vid`) REFERENCES `veturat` (`vid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezervimet`
--

LOCK TABLES `rezervimet` WRITE;
/*!40000 ALTER TABLE `rezervimet` DISABLE KEYS */;
INSERT INTO `rezervimet` VALUES (6,4,'Said Sid','123232123','2017-05-22','2017-05-24',30),(7,2,'Getoar Gaxherri','04444444','2017-05-22','2017-05-23',25);
/*!40000 ALTER TABLE `rezervimet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `shfaqrezervimet`
--

DROP TABLE IF EXISTS `shfaqrezervimet`;
/*!50001 DROP VIEW IF EXISTS `shfaqrezervimet`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `shfaqrezervimet` AS SELECT 
 1 AS `RID`,
 1 AS `Marka`,
 1 AS `Modeli`,
 1 AS `Viti Prodhimit`,
 1 AS `Nderruesi Shpejt.`,
 1 AS `Emri dhe Mbiemri`,
 1 AS `Nr. Telefonit`,
 1 AS `Prej Dates`,
 1 AS `Deri ne Daten`,
 1 AS `Cmimi`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `veturat`
--

DROP TABLE IF EXISTS `veturat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veturat` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `kid` int(11) NOT NULL,
  `marka` varchar(45) CHARACTER SET utf8 NOT NULL,
  `modeli` varchar(50) CHARACTER SET utf8 NOT NULL,
  `vitiProdhimit` int(11) NOT NULL,
  `nderruesi` varchar(45) CHARACTER SET ascii NOT NULL,
  `numriUleseve` int(11) NOT NULL,
  `karburanti` varchar(45) CHARACTER SET utf8 NOT NULL,
  `shpenzimet` varchar(45) CHARACTER SET utf8 NOT NULL,
  `sasiaTotale` int(11) NOT NULL,
  `sasiaLire` int(11) NOT NULL,
  PRIMARY KEY (`vid`),
  UNIQUE KEY `veturatUnike` (`marka`,`modeli`,`vitiProdhimit`,`nderruesi`,`numriUleseve`,`karburanti`,`shpenzimet`),
  KEY `kid_idx` (`kid`),
  CONSTRAINT `kid` FOREIGN KEY (`kid`) REFERENCES `kategorite` (`kid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veturat`
--

LOCK TABLES `veturat` WRITE;
/*!40000 ALTER TABLE `veturat` DISABLE KEYS */;
INSERT INTO `veturat` VALUES (1,1,'Audi','RS4',2010,'Automatik',5,'Dizell','15',13,13),(2,2,'Audi','RS6',2011,'Manual',5,'Benzin','15',11,10),(3,6,'Buggati','Veyron',2017,'Manual',2,'Benzim','20',1,1),(4,1,'bmw','520',1988,'Manual',5,'Benzinë-Elektrik','15',1,0);
/*!40000 ALTER TABLE `veturat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `listoveturat`
--

/*!50001 DROP VIEW IF EXISTS `listoveturat`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `listoveturat` AS (select `veturat`.`vid` AS `VID`,`veturat`.`marka` AS `Marka`,`veturat`.`modeli` AS `Modeli`,`veturat`.`vitiProdhimit` AS `Viti Prodhimit`,`veturat`.`nderruesi` AS `Nderruesi Shpejt.`,`veturat`.`numriUleseve` AS `Nr. Uleseve`,`veturat`.`karburanti` AS `Karburanti`,`veturat`.`shpenzimet` AS `Shpenzimet`,`veturat`.`sasiaTotale` AS `Sasia Totale`,`veturat`.`sasiaLire` AS `Sasia Lire`,`LLOGARITSASINEREZERVUAR`(`veturat`.`sasiaTotale`,`veturat`.`sasiaLire`) AS `Sasia Rezervuar` from `veturat`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `shfaqrezervimet`
--

/*!50001 DROP VIEW IF EXISTS `shfaqrezervimet`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `shfaqrezervimet` AS (select `r`.`rid` AS `RID`,`v`.`marka` AS `Marka`,`v`.`modeli` AS `Modeli`,`v`.`vitiProdhimit` AS `Viti Prodhimit`,`v`.`nderruesi` AS `Nderruesi Shpejt.`,`r`.`emriMbiemri` AS `Emri dhe Mbiemri`,`r`.`numriTelefonit` AS `Nr. Telefonit`,`r`.`prej` AS `Prej Dates`,`r`.`deri` AS `Deri ne Daten`,`r`.`cmimi` AS `Cmimi` from (`veturat` `v` join `rezervimet` `r`) where (`r`.`vid` = `v`.`vid`)) */;
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

-- Dump completed on 2017-05-23 10:15:00
