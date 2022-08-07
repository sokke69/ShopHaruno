-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
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
-- Table structure for table `as_categories`
--

DROP TABLE IF EXISTS `as_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `as_categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `a_category_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `a_category_name` (`a_category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `as_categories`
--

LOCK TABLES `as_categories` WRITE;
/*!40000 ALTER TABLE `as_categories` DISABLE KEYS */;
INSERT INTO `as_categories` VALUES (4,'カメラ関連製品'),(5,'その他'),(2,'デジタルカメラ'),(1,'デジタル一眼カメラ'),(3,'レンズ');
/*!40000 ALTER TABLE `as_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bs_categories`
--

DROP TABLE IF EXISTS `bs_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bs_categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `b_category_name` varchar(20) NOT NULL,
  `a_category_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bs_categories`
--

LOCK TABLES `bs_categories` WRITE;
/*!40000 ALTER TABLE `bs_categories` DISABLE KEYS */;
INSERT INTO `bs_categories` VALUES (27,'ニコン',1),(28,'SONY',1),(29,'CANON',1),(30,'富士フイルム',1),(31,'オリンパス',1),(32,'OMデジタルソリューションズ',1),(33,'パナソニック',1),(34,'ペンタックス',1),(35,'ライカ',1),(36,'シグマ',1),(37,'ハッセルブラッド',1),(38,'CANON',2),(39,'SONY',2),(40,'ニコン',2),(41,'パナソニック',2),(42,'リコー',2),(43,'富士フイルム',2),(44,'オリンパス',2),(45,'カシオ',2),(46,'ライカ',2),(47,'ケンコー',2),(48,'シグマ',2),(49,'標準ズーム',3),(50,'望遠ズーム',3),(51,'広角ズーム',3),(52,'単焦点',3);
/*!40000 ALTER TABLE `bs_categories` ENABLE KEYS */;
UNLOCK TABLES;

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
  `category_b` int DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1 テスト1','https://www.amazon.co.jp/',1,1,'./imgs/1/main.jpg','./imgs/1/sub_01.jpg','./imgs/1/sub_02.jpg','./imgs/1/sub_03.jpg','./imgs/1/sub_04.jpg','./imgs/1/sub_05.jpg','./imgs/1/sub_06.jpg','./imgs/1/sub_07.jpg','./imgs/1/sub_08.jpg','2022-08-02 13:08:49',NULL,NULL,NULL),(2,'テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 テスト2 ','https://www.google.co.jp/',1,1,'./imgs/2/main.jpg','./imgs/2/sub_01.jpg','./imgs/2/sub_02.jpg','./imgs/2/sub_03.jpg','./imgs/2/sub_04.jpg','./imgs/2/sub_05.jpg','./imgs/2/sub_06.jpg','./imgs/2/sub_07.jpg','./imgs/2/sub_08.jpg','2022-08-02 13:09:30',NULL,'2022-08-04 13:35:42',NULL),(13,'テスト3 テスト3 テスト3 テスト3 テスト3 テスト3 テスト3 テスト3 テスト3 テスト3 テスト3 テスト3 テスト3 ','https://テスト3.jp',2,2,'./imgs/3/main.jpg','./imgs/3/sub_01.jpg','./imgs/3/sub_02.jpg','./imgs/3/sub_03.jpg','./imgs/3/sub_04.jpg','./imgs/3/sub_05.jpg','./imgs/3/sub_06.jpg','./imgs/3/sub_07.jpg','./imgs/3/sub_08.jpg','2022-08-04 14:56:53',NULL,'2022-08-04 06:00:55',NULL),(15,'test4 test4 test4 test4 test4 test4 test4 test4 test4 test4 test4 test4 ','https://test4.com/',3,3,'./imgs/4/main.jpg','./imgs/4/sub_01.jpg','./imgs/4/sub_02.jpg','./imgs/4/sub_03.jpg','./imgs/4/sub_04.jpg','./imgs/4/sub_05.jpg','./imgs/4/sub_06.jpg','./imgs/4/sub_07.jpg','./imgs/4/sub_08.jpg','2022-08-04 15:13:05',NULL,NULL,NULL),(16,'てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 てすと5 テスト5 ','https://test5.jp/',2,2,'./imgs/5/main.jpg','./imgs/5/sub_01.jpg','./imgs/5/sub_02.jpg','./imgs/5/sub_03.jpg','./imgs/5/sub_04.jpg','./imgs/5/sub_05.jpg','./imgs/5/sub_06.jpg','./imgs/5/sub_07.jpg','./imgs/5/sub_08.jpg','2022-08-04 22:43:11',NULL,NULL,NULL),(17,'test6','https://test6.jp/',3,3,'./imgs/6/main.jpg','./imgs/6/sub_01.jpg','./imgs/6/sub_02.jpg','./imgs/6/sub_03.jpg','./imgs/6/sub_04.jpg','./imgs/6/sub_05.jpg','./imgs/6/sub_06.jpg','./imgs/6/sub_07.jpg','./imgs/6/sub_08.jpg','2022-08-05 12:32:45',NULL,'2022-08-05 03:58:27',NULL);
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'master','$2a$08$GzImC.LElmrREYUXbXXjTO2De92lcDslS/1kS5SCmot0BJhnk.MFW',1),(2,'user','$2a$08$JQ3Ty7qMLzj4Y7QQe4Up2OqAEnBGOpEOVMzTqPZxnteZCXRQHqV/q',2),(3,'test','$2a$08$3JkiEGWb5XxMkkK/va871uY.GzgJuQR78XgGDaKvzIhmz8SkhS1ue',3),(7,'happy','$2a$10$sf/hUkDIX87qavPRYRdOhu/FUL1yBqV5L1KBOhyadC.vuEEm/tAQi',2),(8,'chibi','$2a$10$ytxoOAwqcl.o2X5srdP0kupyq6uj9F0So.72wlHaYtt.5QZtU1e0q',1),(10,'fuji','$2a$10$MxkZsOld7ZDER7HUqcINt.fh1ao0Ebfl3WDvs8SXImwhFOKQMSq.G',2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_types`
--

DROP TABLE IF EXISTS `users_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_types` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_name` (`type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_types`
--

LOCK TABLES `users_types` WRITE;
/*!40000 ALTER TABLE `users_types` DISABLE KEYS */;
INSERT INTO `users_types` VALUES (1,'master'),(3,'test'),(2,'user');
/*!40000 ALTER TABLE `users_types` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-08  1:18:44
