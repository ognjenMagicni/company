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
-- Table structure for table `user_cred`
--

DROP TABLE IF EXISTS `user_cred`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_cred` (
  `username` varchar(45) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `fk_role` int DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `fk_user_cred_1_idx` (`fk_role`),
  CONSTRAINT `fk_user_cred_1` FOREIGN KEY (`fk_role`) REFERENCES `roles` (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_cred`
--

LOCK TABLES `user_cred` WRITE;
/*!40000 ALTER TABLE `user_cred` DISABLE KEYS */;
INSERT INTO `user_cred` VALUES ('0000000000001','$2a$10$VGdZFkex1p.3e7hndT.oLO/dRnpyhRvwavXeofPo5EerwaEWlcZI2',2),('0000000000002',NULL,2),('0000000000003','$2a$10$VGdZFkex1p.3e7hndT.oLO/dRnpyhRvwavXeofPo5EerwaEWlcZI2',2),('1122334455667','$2a$10$VGdZFkex1p.3e7hndT.oLO/dRnpyhRvwavXeofPo5EerwaEWlcZI2',3),('1234567890123',NULL,1),('5678901234567',NULL,1),('9876543210987',NULL,1),('ivanludii','$2a$10$VGdZFkex1p.3e7hndT.oLO/dRnpyhRvwavXeofPo5EerwaEWlcZI2',1),('ivanmali','$2a$10$KfokztHfP9C327Ey5QdbfeHFkISasNW8o3YA3kZ6yc1yo5ioQLxp.',1),('lucijano','$2a$10$6WqF0inJlZtK9NWbv5HYdOPI1yRWdyfBNYGTr1Ja8HcTCLuXyuncC',2),('mprelevic','$2a$10$hx0HxDupxwQJpodvHsMUmezDjfQRmXJSZD5HjiAXNBJBcLQpHGcsy',1),('noviVozac','$2a$10$NIS9PQMVFu4MxpEX/u9pJeknPKxciPOJnfeLpamM1kY.ogKFUwnrK',2),('Vozac','$2a$10$5xeE7rspa9r7339saEIbsuK/DVx/XL3zD7rpTMxm7GLlGmZU1K49G',2);
/*!40000 ALTER TABLE `user_cred` ENABLE KEYS */;
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
