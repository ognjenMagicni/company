CREATE DATABASE  IF NOT EXISTS `transport` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `transport`;
-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: transport
-- ------------------------------------------------------
-- Server version	8.0.40-0ubuntu0.24.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `package_driver`
--

DROP TABLE IF EXISTS `package_driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package_driver` (
  `fk_driver` varchar(13) NOT NULL,
  `fk_package` int NOT NULL,
  `grade` int DEFAULT NULL,
  `comment` text,
  PRIMARY KEY (`fk_driver`,`fk_package`),
  KEY `fk_package_driver_package1_idx` (`fk_package`),
  CONSTRAINT `fk_package_driver_driver1` FOREIGN KEY (`fk_driver`) REFERENCES `driver` (`id_driver`),
  CONSTRAINT `fk_package_driver_package1` FOREIGN KEY (`fk_package`) REFERENCES `package` (`id_package`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_driver`
--

LOCK TABLES `package_driver` WRITE;
/*!40000 ALTER TABLE `package_driver` DISABLE KEYS */;
INSERT INTO `package_driver` VALUES ('0000000000001',9,5,'Excellent service, very professional!'),('0000000000001',11,3,'Average experience, package was handled fine.'),('0000000000001',12,5,'Fast and reliable delivery!'),('0000000000001',15,5,'Perfect service! Will use again.'),('0000000000001',56,NULL,NULL),('0000000000001',57,NULL,NULL),('0000000000002',14,3,'Acceptable service, but packaging could be better.'),('0000000000003',10,4,'Good, but delivery was slightly delayed.'),('0000000000003',13,4,'Driver was polite, but package arrived a bit late.');
/*!40000 ALTER TABLE `package_driver` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-19  9:55:27
