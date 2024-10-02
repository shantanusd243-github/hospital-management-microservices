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
-- Table structure for table `tb_city`
--

DROP TABLE IF EXISTS `tb_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1rn7oty4mwqviyw8vk67crapo` (`state_id`),
  CONSTRAINT `FK1rn7oty4mwqviyw8vk67crapo` FOREIGN KEY (`state_id`) REFERENCES `tb_state` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_city`
--

LOCK TABLES `tb_city` WRITE;
/*!40000 ALTER TABLE `tb_city` DISABLE KEYS */;
INSERT INTO `tb_city` VALUES (1,'Uberlândia',1),(2,'São Paulo',2),(3,'Campinas',2),(4,'Diamantina',1),(5,'Uberlândia',3),(6,'São Paulo',4),(7,'Campinas',4),(8,'Diamantina',3),(9,'Uberlândia',5),(10,'São Paulo',6),(11,'Campinas',6),(12,'Diamantina',5),(13,'Uberlândia',7),(14,'São Paulo',8),(15,'Campinas',8),(16,'Diamantina',7),(17,'Uberlândia',9),(18,'São Paulo',10),(19,'Campinas',10),(20,'Diamantina',9),(21,'Uberlândia',11),(22,'São Paulo',12),(23,'Campinas',12),(24,'Diamantina',11),(25,'Uberlândia',13),(26,'São Paulo',14),(27,'Campinas',14),(28,'Diamantina',13),(29,'Uberlândia',15),(30,'São Paulo',16),(31,'Campinas',16),(32,'Diamantina',15),(33,'Uberlândia',17),(34,'São Paulo',18),(35,'Campinas',18),(36,'Diamantina',17),(37,'Uberlândia',19),(38,'São Paulo',20),(39,'Campinas',20),(40,'Diamantina',19),(41,'Uberlândia',21),(42,'São Paulo',22),(43,'Campinas',22),(44,'Diamantina',21),(45,'Uberlândia',23),(46,'São Paulo',24),(47,'Campinas',24),(48,'Diamantina',23),(49,'Uberlândia',25),(50,'São Paulo',26),(51,'Campinas',26),(52,'Diamantina',25);
/*!40000 ALTER TABLE `tb_city` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-02 19:33:07
