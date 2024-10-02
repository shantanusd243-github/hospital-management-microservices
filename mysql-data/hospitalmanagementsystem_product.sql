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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`DEPARTMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Consultation','General consultation with a cardiologist',100.00,9),(2,'ECG Test','Electrocardiogram to monitor heart activity',150.00,9),(3,'Heart Surgery','Surgical procedure for heart conditions',5000.00,9),(4,'Consultation','General consultation with a neurologist',120.00,10),(5,'EEG Test','Electroencephalogram to detect brain activity',200.00,10),(6,'Brain Surgery','Surgical procedure for neurological conditions',8000.00,10),(7,'Consultation','General consultation with an orthopedic surgeon',110.00,11),(8,'Bone X-ray','X-ray to diagnose bone fractures',100.00,11),(9,'Joint Replacement Surgery','Surgical procedure to replace a joint',7000.00,11),(10,'Consultation','General consultation with a pediatrician',90.00,12),(11,'Child Vaccination','Vaccination service for children',50.00,12),(12,'Pediatric Checkup','Comprehensive health checkup for children',130.00,12),(13,'Consultation','General consultation with a dermatologist',100.00,13),(14,'Skin Allergy Test','Test for detecting skin allergies',120.00,13),(15,'Acne Treatment','Treatment for severe acne',200.00,13),(16,'Consultation','General consultation with an ophthalmologist',100.00,14),(17,'Eye Exam','Comprehensive eye examination',80.00,14),(18,'Cataract Surgery','Surgical procedure to treat cataracts',4000.00,14),(19,'Consultation','General consultation with a gastroenterologist',130.00,15),(20,'Endoscopy','Procedure to examine the digestive tract',1000.00,15),(21,'Liver Biopsy','Procedure to remove a small piece of liver tissue for examination',2500.00,15),(22,'Consultation','General consultation with a radiologist',120.00,16),(23,'MRI Scan','Magnetic Resonance Imaging scan',2000.00,16),(24,'CT Scan','Computed Tomography scan',1500.00,16);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-02 19:33:03
