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
-- Table structure for table `tb_client`
--

DROP TABLE IF EXISTS `tb_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf_or_cnpj` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_client` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_client`
--

LOCK TABLES `tb_client` WRITE;
/*!40000 ALTER TABLE `tb_client` DISABLE KEYS */;
INSERT INTO `tb_client` VALUES (1,'12345678910','maria@gmail.com','Maria da Silva',1),(2,'12345678910','maria@gmail.com','Maria da Silva',1),(3,'12345678910','maria@gmail.com','Maria da Silva',1),(4,'12345678910','maria@gmail.com','Maria da Silva',1),(5,'12345678910','maria@gmail.com','Maria da Silva',1),(6,'12345678910','maria@gmail.com','Maria da Silva',1),(7,'12345678910','maria@gmail.com','Maria da Silva',1),(8,'12345678910','maria@gmail.com','Maria da Silva',1),(9,'12345678910','maria@gmail.com','Maria da Silva',1),(10,'12345678910','maria@gmail.com','Maria da Silva',1),(11,'12345678910','maria@gmail.com','Maria da Silva',1),(12,'12345678910','maria@gmail.com','Maria da Silva',1),(13,'12345678910','maria@gmail.com','Maria da Silva',1);
/*!40000 ALTER TABLE `tb_client` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-02 19:33:10
