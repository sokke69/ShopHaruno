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

--
-- Table structure for table `user_types`
--

DROP TABLE IF EXISTS `user_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_types` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_name` (`type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_types`
--

LOCK TABLES `user_types` WRITE;
/*!40000 ALTER TABLE `user_types` DISABLE KEYS */;
INSERT INTO `user_types` VALUES (1,'master'),(3,'test'),(2,'user');
/*!40000 ALTER TABLE `user_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(12) NOT NULL,
  `user_pass` char(60) NOT NULL,
  `user_type` int NOT NULL DEFAULT '2',
  `regist_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'test','$2a$08$3JkiEGWb5XxMkkK/va871uY.GzgJuQR78XgGDaKvzIhmz8SkhS1ue',3,'2022-08-01 22:46:18');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-02 15:10:40
