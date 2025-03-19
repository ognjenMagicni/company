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
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package` (
  `id_package` int NOT NULL AUTO_INCREMENT,
  `fk_user` varchar(13) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `height` int DEFAULT NULL,
  `width` int DEFAULT NULL,
  `length` int DEFAULT NULL,
  `city_start` int DEFAULT NULL,
  `city_end` int DEFAULT NULL,
  `date_start` datetime DEFAULT NULL,
  `price` float DEFAULT NULL,
  `stage` int DEFAULT NULL,
  `address_start` varchar(200) DEFAULT NULL,
  `address_end` varchar(200) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `fk_driver` varchar(45) DEFAULT NULL,
  `grade` int DEFAULT NULL,
  `comment` text,
  PRIMARY KEY (`id_package`),
  KEY `fk_package_user_idx` (`fk_user`),
  KEY `fk_package_city1_idx` (`city_start`),
  KEY `fk_package_city2_idx` (`city_end`),
  KEY `fk_package_stage1_idx` (`stage`),
  KEY `fk_package_1_idx` (`fk_driver`),
  CONSTRAINT `fk_package_1` FOREIGN KEY (`fk_driver`) REFERENCES `driver` (`id_driver`),
  CONSTRAINT `fk_package_city1` FOREIGN KEY (`city_start`) REFERENCES `city` (`id_city`),
  CONSTRAINT `fk_package_city2` FOREIGN KEY (`city_end`) REFERENCES `city` (`id_city`),
  CONSTRAINT `fk_package_stage1` FOREIGN KEY (`stage`) REFERENCES `stage` (`id_stage`),
  CONSTRAINT `fk_package_user` FOREIGN KEY (`fk_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
INSERT INTO `package` VALUES (9,'1234567890123',10,50,40,30,1,2,'2025-02-25 10:00:00',25.99,3,'123 Main St, City A','456 Elm St, City B',NULL,'0000000000001',NULL,NULL),(10,'9876543210987',15,60,45,35,3,4,'2025-02-26 14:30:00',35.5,2,'789 Oak St, City C','321 Pine St, City D',NULL,NULL,NULL,NULL),(11,'5678901234567',5,30,25,20,5,6,'2025-03-01 08:15:00',15.75,3,'100 River Rd, City E','200 Hill St, City F',NULL,'0000000000001',NULL,NULL),(12,'1234567890123',8,40,35,25,2,3,'2025-03-02 12:45:00',20.5,2,'150 Sunset Blvd, City B','300 Maple St, City C',NULL,NULL,NULL,NULL),(13,'9876543210987',20,70,50,40,4,5,'2025-03-03 15:30:00',45,3,'250 Birch St, City D','400 Cedar Rd, City E',NULL,NULL,NULL,NULL),(14,'5678901234567',12,55,40,35,6,7,'2025-03-04 09:00:00',30.25,1,'500 Oak Ave, City F','600 Spruce St, City G',NULL,NULL,NULL,NULL),(15,'1234567890123',25,80,60,50,1,7,'2025-03-05 17:10:00',55.99,2,'700 Pine Ln, City A','800 Walnut St, City G',NULL,NULL,NULL,NULL),(16,NULL,2.5,10,20,30,NULL,NULL,NULL,25.99,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,NULL,2.5,10,20,30,1,2,'2023-10-01 12:00:00',25.99,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'1234567890123',2.5,10,20,30,1,2,'2023-10-01 12:00:00',25.99,NULL,'123 Main St, City A','456 Elm St, City B',NULL,NULL,NULL,NULL),(22,'1234567890123',2.5,10,20,30,1,2,'2023-10-01 12:00:00',25.99,1,'123 Main St, City A','456 Elm St, City B',NULL,NULL,NULL,NULL),(56,'mprelevic',40,50,45,80,NULL,NULL,NULL,7880,3,'Grad1','Grad2','Paket babi','0000000000001',5,'Odlicna usluga'),(57,'mprelevic',0,0,0,0,NULL,NULL,NULL,0,2,'grad1','grad3','PAket tetki','0000000000001',NULL,NULL),(58,'mprelevic',30,30,30,30,NULL,NULL,NULL,1620,3,'Podgorica','Arandjelovac','Poveci paket','0000000000001',4,'Amazing and fast service'),(59,'mprelevic',50,5,50,50,NULL,NULL,NULL,3000,3,'Pg','Bg','Novi Paket','0000000000001',NULL,NULL),(60,'mprelevic',40,40,40,40,NULL,NULL,NULL,3840,1,'Podgorica','Pljevlja','Paket za moju nanu',NULL,NULL,NULL),(61,'ivanmali',50,100,100,100,NULL,NULL,NULL,30000,3,'Podgorica','Zabljak','Ivanov paket','0000000000003',10,'Fenomenalna i brza isporuka');
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
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
