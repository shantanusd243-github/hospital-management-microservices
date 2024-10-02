-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: hospitalmanagementsystem
-- ------------------------------------------------------
-- Server version	5.5.62

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
-- Table structure for table `tb_address`
--

DROP TABLE IF EXISTS `tb_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `complement` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpm4x3qy2wea2p4ea7bs217nr5` (`city_id`),
  KEY `FKmgkeodciwq4rofwws5m08v1yh` (`client_id`),
  CONSTRAINT `FKmgkeodciwq4rofwws5m08v1yh` FOREIGN KEY (`client_id`) REFERENCES `tb_client` (`id`),
  CONSTRAINT `FKpm4x3qy2wea2p4ea7bs217nr5` FOREIGN KEY (`city_id`) REFERENCES `tb_city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_address`
--

LOCK TABLES `tb_address` WRITE;
/*!40000 ALTER TABLE `tb_address` DISABLE KEYS */;
INSERT INTO `tb_address` VALUES (1,'Apto 303','Jardim','300','Rua Flores','38220384',1,1),(2,'Apto 300','Jardim','300','Rua Pitanga','38220454',2,1),(3,'Apto 303','Jardim','300','Rua Flores','38220384',5,2),(4,'Apto 300','Jardim','300','Rua Pitanga','38220454',6,2),(5,'Apto 303','Jardim','300','Rua Flores','38220384',9,3),(6,'Apto 300','Jardim','300','Rua Pitanga','38220454',10,3),(7,'Apto 303','Jardim','300','Rua Flores','38220384',13,4),(8,'Apto 300','Jardim','300','Rua Pitanga','38220454',14,4),(9,'Apto 303','Jardim','300','Rua Flores','38220384',17,5),(10,'Apto 300','Jardim','300','Rua Pitanga','38220454',18,5),(11,'Apto 303','Jardim','300','Rua Flores','38220384',21,6),(12,'Apto 300','Jardim','300','Rua Pitanga','38220454',22,6),(13,'Apto 303','Jardim','300','Rua Flores','38220384',25,7),(14,'Apto 300','Jardim','300','Rua Pitanga','38220454',26,7),(15,'Apto 303','Jardim','300','Rua Flores','38220384',29,8),(16,'Apto 300','Jardim','300','Rua Pitanga','38220454',30,8),(17,'Apto 303','Jardim','300','Rua Flores','38220384',33,9),(18,'Apto 300','Jardim','300','Rua Pitanga','38220454',34,9),(19,'Apto 303','Jardim','300','Rua Flores','38220384',37,10),(20,'Apto 300','Jardim','300','Rua Pitanga','38220454',38,10),(21,'Apto 303','Jardim','300','Rua Flores','38220384',41,11),(22,'Apto 300','Jardim','300','Rua Pitanga','38220454',42,11),(23,'Apto 303','Jardim','300','Rua Flores','38220384',45,12),(24,'Apto 300','Jardim','300','Rua Pitanga','38220454',46,12),(25,'Apto 303','Jardim','300','Rua Flores','38220384',49,13),(26,'Apto 300','Jardim','300','Rua Pitanga','38220454',50,13);
/*!40000 ALTER TABLE `tb_address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-02 19:33:24
