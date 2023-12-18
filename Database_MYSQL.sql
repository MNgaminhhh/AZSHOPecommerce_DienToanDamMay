-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: azshop
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `bill_details`
--

DROP TABLE IF EXISTS `bill_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_details` (
  `detail_id` int NOT NULL AUTO_INCREMENT,
  `bill_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `bill_id` (`bill_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `bill_details_ibfk_1` FOREIGN KEY (`bill_id`) REFERENCES `bills` (`bill_id`),
  CONSTRAINT `bill_details_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_details`
--

LOCK TABLES `bill_details` WRITE;
/*!40000 ALTER TABLE `bill_details` DISABLE KEYS */;
INSERT INTO `bill_details` VALUES (1,1,1,2,599.99),(2,2,4,3,699.99),(3,2,10,2,49.99),(4,3,3,2,899.99),(5,3,8,1,599.99),(6,3,9,1,39.99),(7,4,3,2,899.99),(8,4,8,1,599.99),(9,5,12,3,29.99),(10,6,9,1,39.99),(11,6,5,2,129.99),(12,6,11,1,75.20),(14,7,1,1,29954700.00),(15,8,1,1,29954700.00),(16,8,2,1,25296700.00),(17,8,3,1,20694700.00),(18,8,6,1,13798700.00);
/*!40000 ALTER TABLE `bill_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `bill_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `total_amount` decimal(10,2) NOT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bills_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (1,4,'2023-12-01 10:30:00',120.50,NULL,NULL,NULL),(2,4,'2023-11-30 15:45:00',89.99,NULL,NULL,NULL),(3,5,'2023-12-01 08:15:00',300.75,NULL,NULL,NULL),(4,6,'2023-12-01 12:45:00',45.50,NULL,NULL,NULL),(5,6,'2023-11-30 18:30:00',75.20,NULL,NULL,NULL),(6,6,'2023-11-29 09:55:00',160.00,NULL,NULL,NULL),(7,13,'2023-12-14 00:00:00',29954710.00,'123','123','123'),(8,13,'2023-12-14 00:00:00',89744808.00,'asd','asd','asd');
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `carts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `carts_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
INSERT INTO `carts` VALUES (1,4,1,1),(2,4,7,2),(3,4,4,3),(4,5,3,2),(5,5,8,1),(6,5,9,3),(7,6,5,1),(8,6,11,2);
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Điện thoại'),(2,'Gia dụng'),(3,'Quần áo');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `description` text,
  `price` float NOT NULL,
  `category_id` int DEFAULT NULL,
  `supplier_id` int DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `images` text,
  `stock_quantity` int NOT NULL DEFAULT '0',
  `sold_quantity` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`),
  KEY `category_id` (`category_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`),
  CONSTRAINT `products_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'iPhone 13','Điện thoại cao cấp từ Apple với nhiều tính năng mới.',29954700,1,1,'iphone13.jpg','iphone13.jpg',47,3),(2,'Galaxy S21','Điện thoại hàng đầu từ Samsung với camera mạnh mẽ.',25296700,1,2,'s21.jpg','iphone13.jpg',39,1),(3,'Oppo Find X3','Smartphone cao cấp với thiết kế đẹp và hiệu suất mạnh mẽ.',20694700,1,3,'findx3.jpg','iphone13.jpg',29,1),(4,'Xiaomi Mi 11','Điện thoại Android hàng đầu với giá trị tốt.',16092700,1,4,'mi11.jpg','iphone13.jpg',60,0),(5,'Bếp Điện Shimono','Bếp điện từ hiện đại và tiện ích.',5749470,2,5,'induction-cooker.jpg','iphone13.jpg',35,0),(6,'Tivi Toshiba 4K','Tivi 4K với hình ảnh sắc nét và chất lượng âm thanh tốt.',13798700,2,6,'4k-tv.jpg','iphone13.jpg',24,1),(7,'Máy Giặt Panasinic','Máy giặt công nghệ mới với nhiều chương trình giặt.',10345700,2,7,'washing-machine.jpg','iphone13.jpg',20,0),(8,'Điều Hòa Sunhouse','Điều hòa nhiệt độ thông minh và tiết kiệm điện năng.',18394700,2,8,'air-conditioner.jpg','iphone13.jpg',15,0),(9,'Áo Polo ClownZ','Áo thun Polo thoáng khí và thoải mái.',689470,3,9,'polo-shirt.jpg','iphone13.jpg',80,0),(10,'Quần Jean Dirty Coins','Quần jean phong cách với sự thoải mái.',1149470,3,10,'jeans.jpg','iphone13.jpg',60,0),(11,'Áo Sơ Mi Hades','Áo sơ mi nam dáng dài với kiểu dáng thanh lịch.',919470,3,11,'shirt.jpg','iphone13.jpg',50,0),(12,'iPhone 13','Điện thoại cao cấp từ Apple với nhiều tính năng mới.',29954700,1,1,'iphone13.jpg','iphone13.jpg',50,0),(13,'Galaxy S21','Điện thoại hàng đầu từ Samsung với camera mạnh mẽ.',25296700,1,2,'s21.jpg','iphone13.jpg',40,0),(14,'Oppo Find X3','Smartphone cao cấp với thiết kế đẹp và hiệu suất mạnh mẽ.',20694700,1,3,'findx3.jpg','iphone13.jpg',30,0),(15,'Xiaomi Mi 11','Điện thoại Android hàng đầu với giá trị tốt.',16092700,1,4,'mi11.jpg','iphone13.jpg',60,0),(16,'Bếp Điện Shimono','Bếp điện từ hiện đại và tiện ích.',5749470,2,5,'induction-cooker.jpg','iphone13.jpg',35,0),(17,'Tivi Toshiba 4K','Tivi 4K với hình ảnh sắc nét và chất lượng âm thanh tốt.',13798700,2,6,'4k-tv.jpg','iphone13.jpg',25,0),(18,'Máy Giặt Panasinic','Máy giặt công nghệ mới với nhiều chương trình giặt.',10345700,2,7,'washing-machine.jpg','iphone13.jpg',20,0),(19,'Điều Hòa Sunhouse','Điều hòa nhiệt độ thông minh và tiết kiệm điện năng.',18394700,2,8,'air-conditioner.jpg','iphone13.jpg',15,0),(20,'Áo Polo ClownZ','Áo thun Polo thoáng khí và thoải mái.',689470,3,9,'polo-shirt.jpg','iphone13.jpg',80,0),(21,'Quần Jean Dirty Coins','Quần jean phong cách với sự thoải mái.',1149470,3,10,'jeans.jpg','iphone13.jpg',60,0),(22,'Áo Sơ Mi Hades','Áo sơ mi nam dáng dài với kiểu dáng thanh lịch.',919470,3,11,'shirt.jpg','iphone13.jpg',50,0),(23,'iPhone 13','Điện thoại cao cấp từ Apple với nhiều tính năng mới.',29954700,1,1,'iphone13.jpg','iphone13.jpg',50,0),(24,'Galaxy S21','Điện thoại hàng đầu từ Samsung với camera mạnh mẽ.',25296700,1,2,'s21.jpg','iphone13.jpg',40,0),(25,'Oppo Find X3','Smartphone cao cấp với thiết kế đẹp và hiệu suất mạnh mẽ.',20694700,1,3,'findx3.jpg','iphone13.jpg',30,0),(26,'Xiaomi Mi 11','Điện thoại Android hàng đầu với giá trị tốt.',16092700,1,4,'mi11.jpg','iphone13.jpg',60,0),(27,'Bếp Điện Shimono','Bếp điện từ hiện đại và tiện ích.',5749470,2,5,'induction-cooker.jpg','iphone13.jpg',35,0),(28,'Tivi Toshiba 4K','Tivi 4K với hình ảnh sắc nét và chất lượng âm thanh tốt.',13798700,2,6,'4k-tv.jpg','iphone13.jpg',25,0),(29,'Máy Giặt Panasinic','Máy giặt công nghệ mới với nhiều chương trình giặt.',10345700,2,7,'washing-machine.jpg','iphone13.jpg',20,0),(30,'Điều Hòa Sunhouse','Điều hòa nhiệt độ thông minh và tiết kiệm điện năng.',18394700,2,8,'air-conditioner.jpg','iphone13.jpg',15,0),(31,'Áo Polo ClownZ','Áo thun Polo thoáng khí và thoải mái.',689470,3,9,'polo-shirt.jpg','iphone13.jpg',80,0),(32,'Quần Jean Dirty Coins','Quần jean phong cách với sự thoải mái.',1149470,3,10,'jeans.jpg','iphone13.jpg',60,0),(33,'Áo Sơ Mi Hades','Áo sơ mi nam dáng dài với kiểu dáng thanh lịch.',919470,3,11,'shirt.jpg','iphone13.jpg',50,0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers` (
  `supplier_id` int NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(255) NOT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'Apple'),(2,'Samsung'),(3,'Oppo'),(4,'Xiaomi'),(5,'Shimono'),(6,'Toshiba'),(7,'Panasinic'),(8,'Sunhouse'),(9,'ClownZ'),(10,'Dirty Coins'),(11,'Hades');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `role` int NOT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  CONSTRAINT `users_chk_1` CHECK ((`role` in (0,1,2)))
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin123','admin@example.com',NULL,0,1),(2,'manager1','manager123','manager1@example.com',NULL,1,1),(3,'manager2','manager123','manager2@example.com',NULL,1,1),(4,'user1','user123','user1@example.com',NULL,2,1),(5,'user2','user123','user2@example.com',NULL,2,1),(6,'user3','user123','user3@example.com',NULL,2,1),(13,'hungphong','Phong@123','hungphong.canhan@gmail.com','332758',2,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viewed_products`
--

DROP TABLE IF EXISTS `viewed_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viewed_products` (
  `viewed_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `view_date` datetime DEFAULT NULL,
  PRIMARY KEY (`viewed_id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `viewed_products_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `viewed_products_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viewed_products`
--

LOCK TABLES `viewed_products` WRITE;
/*!40000 ALTER TABLE `viewed_products` DISABLE KEYS */;
INSERT INTO `viewed_products` VALUES (1,3,1,'2023-12-12 09:27:22'),(2,4,2,'2023-01-14 11:45:36'),(3,5,3,'2023-03-14 06:25:57'),(4,6,4,'2023-11-17 20:52:59'),(5,3,5,'2023-12-13 13:07:03'),(6,4,6,'2023-03-18 02:56:17'),(7,5,7,'2023-02-04 23:20:19'),(8,6,8,'2023-10-21 11:52:49'),(9,3,9,'2023-11-18 13:23:03'),(10,4,10,'2023-02-03 07:16:48'),(11,5,11,'2023-08-31 20:14:55'),(13,13,1,'2023-12-14 00:00:00'),(14,13,2,'2023-12-14 00:00:00'),(15,13,3,'2023-12-14 00:00:00'),(16,13,6,'2023-12-14 00:00:00');
/*!40000 ALTER TABLE `viewed_products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-15  5:22:58
