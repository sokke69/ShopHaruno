-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: shopharunodb
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `product_url` varchar(8190) NOT NULL,
  `category_a` int DEFAULT NULL,
  `category_b01` int DEFAULT NULL,
  `category_b02` int DEFAULT NULL,
  `category_b03` int DEFAULT NULL,
  `img_main` varchar(255) NOT NULL,
  `img_sub01` varchar(255) DEFAULT NULL,
  `img_sub02` varchar(255) DEFAULT NULL,
  `img_sub03` varchar(255) DEFAULT NULL,
  `img_sub04` varchar(255) DEFAULT NULL,
  `img_sub05` varchar(255) DEFAULT NULL,
  `img_sub06` varchar(255) DEFAULT NULL,
  `img_sub07` varchar(255) DEFAULT NULL,
  `img_sub08` varchar(255) DEFAULT NULL,
  `regist_date` datetime DEFAULT NULL,
  `regist_by` int DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1','https://www.amazon.co.jp/',NULL,NULL,NULL,NULL,'./imgs/1/main.jpg','./imgs/1/sub_01.jpg','./imgs/1/sub_02.jpg','./imgs/1/sub_03.jpg','./imgs/1/sub_04.jpg','./imgs/1/sub_05.jpg','./imgs/1/sub_06.jpg','./imgs/1/sub_07.jpg','./imgs/1/sub_08.jpg','2022-08-02 13:08:49',NULL,NULL,NULL),(2,'テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 ','https://www.google.co.jp/',NULL,NULL,NULL,NULL,'./imgs/2/main.jpg','./imgs/2/sub_01.jpg','./imgs/2/sub_02.jpg','./imgs/2/sub_03.jpg','./imgs/2/sub_04.jpg','./imgs/2/sub_05.jpg','./imgs/2/sub_06.jpg','./imgs/2/sub_07.jpg','./imgs/2/sub_08.jpg','2022-08-02 13:09:30',NULL,NULL,NULL);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-03 15:22:37
