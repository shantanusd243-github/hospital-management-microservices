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
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `crm` varchar(6) NOT NULL,
  `specialty` enum('ORTHOPEDICS','CARDIOLOGY','GYNECOLOGY','DERMATOLOGY','ACCOUNTING','ENGINEERING','RESEARCH_AND_DEVELOPMENT','RADIOLOGY','PEDIATRICS','OPHTHALMOLOGY','NEUROLOGY','MARKETING','INFORMATION_TECHNOLOGY','HUMAN_RESOURCES_MANAGEMENT','GASTROENTEROLOGY') NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `street` varchar(100) NOT NULL,
  `neighborhood` varchar(100) NOT NULL,
  `zip_code` varchar(9) NOT NULL,
  `additional_details` varchar(100) DEFAULT NULL,
  `house_number` varchar(20) DEFAULT NULL,
  `state` varchar(2) NOT NULL,
  `city` varchar(100) NOT NULL,
  `active` bit(1) NOT NULL,
  `employee_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `crm` (`crm`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,'John Doe','johndoe@example.com','12345','CARDIOLOGY','+1234567890','123 Elm Street','Downtown','12345678','Apartment 4B','456','NY','New York',_binary '',153),(2,'Alice Smith','alice.smith@example.com','987654','DERMATOLOGY','+19876543210','456 Maple Avenue','Uptown','87654321','Suite 101','789','CA','Los Angeles',_binary '',154),(3,'Ethan Taylor','ethan.taylor@example.com','123456','ACCOUNTING','+19876543210','456 Maple Avenue','Uptown','87654321','Suite 101','789','CA','Los Angeles',_binary '',157),(5,'Charlotte Green','charlotte.green@example.com','654321','PEDIATRICS','+19873456789','101 Pine Road','Midtown','34567890','Near the school','987','TX','Houston',_binary '',159),(6,'Liam Miller','liam.miller@example.com','567890','RADIOLOGY','+12123456789','202 Birch Boulevard','Old Town','45678901','Corner house, near library','321','AZ','Phoenix',_binary '',160),(7,'Sophia Davis','sophia.davis@example.com','345678','ENGINEERING','+19876543210','789 Oak Street','Suburbia','23456789','Near Central Park','654','IL','Chicago',_binary '',161);
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-02 19:33:22
