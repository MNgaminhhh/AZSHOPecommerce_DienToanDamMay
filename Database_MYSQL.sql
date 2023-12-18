CREATE database AZSHOP;
USE AZSHOP;

CREATE TABLE `bill_details` (
  `detail_id` int NOT NULL AUTO_INCREMENT,
  `bill_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`detail_id`)
)
INSERT INTO `bill_details` VALUES (1,1,8,1,249.99),(2,1,1,1,1299.99),(3,1,11,1,799.99),(4,3,10,1,449.99),(5,3,13,1,49.99),(6,4,1,1,1299.99);

CREATE TABLE `bills` (
  `bill_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `total_amount` decimal(10,2) NOT NULL,
  `receiver` varchar(255) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `address` varchar(1000) NOT NULL,
  PRIMARY KEY (`bill_id`)
)

INSERT INTO `bills` VALUES (1,13,'2023-12-10 00:00:00',259.99,'Phong','0981141044','Chung cư dreamhome 2'),(2,13,'2023-12-10 00:00:00',2109.98,'Phong','0981141044','Chung cư dreamhome 2'),(3,13,'2023-12-10 00:00:00',509.98,'Phong','0981141044','Chung cư dreamhome 2'),(4,13,'2023-12-10 00:00:00',1309.99,'asd','asd','asd');

CREATE TABLE `carts` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) 

INSERT INTO `carts` VALUES (1,4,1,2),(2,4,7,1),(3,4,4,1),(4,5,3,2),(5,5,8,1),(6,5,9,3),(7,6,5,1),(8,6,11,2),(34,13,3,3),(35,13,5,1),(36,13,13,1),(37,13,12,1),(38,13,1,3);

CREATE TABLE `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`)
)

INSERT INTO `categories` VALUES (1,'Điện thoại'),(2,'Gia dụng'),(3,'Quần áo');

CREATE TABLE `permissions` (
  `permission_id` int NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) NOT NULL,
  PRIMARY KEY (`permission_id`)
)

INSERT INTO `permissions` VALUES (1,'Quản lý hàng hóa'),(2,'Quản lý danh mục'),(3,'Quản lý hóa đơn'),(4,'Quản lý khách hàng'),(5,'Quản lý doanh thu'),(6,'Thống kê');

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
  `rating` int DEFAULT '0',
  PRIMARY KEY (`product_id`)
)

INSERT INTO `products` VALUES (1,'iPhone 15','DT  ',1299.99,1,0,'iphone13.jpg',NULL,0,0,0),(2,'iPhone 13','Điện thoại cao cấp từ Apple với nhiều tính năng mới.',1299.99,1,1,'iphone13.jpg','iphone13.jpg',50,0,0),(3,'iPhone 13','Điện thoại cao cấp từ Apple với nhiều tính năng mới.',1299.99,1,1,'iphone13.jpg','iphone13.jpg',50,0,0),(4,'iPhone 13','Điện thoại cao cấp từ Apple với nhiều tính năng mới.',1299.99,1,1,'iphone13.jpg','iphone13.jpg',50,0,0),(5,'Galaxy S21','Điện thoại hàng đầu từ Samsung với camera mạnh mẽ.',1099.99,1,2,'s21.jpg','iphone13.jpg',40,2,0),(6,'Oppo Find X3','Smartphone cao cấp với thiết kế đẹp và hiệu suất mạnh mẽ.',899.99,1,3,'findx3.jpg','iphone13.jpg',30,0,0),(7,'Xiaomi Mi 11','Điện thoại Android hàng đầu với giá trị tốt.',699.99,1,4,'mi11.jpg','iphone13.jpg',60,1,0),(8,'Bếp Điện Shimono','Bếp điện từ hiện đại và tiện ích.',249.99,2,5,'induction-cooker.jpg','iphone13.jpg',35,0,0),(9,'Tivi Toshiba 4K','Tivi 4K với hình ảnh sắc nét và chất lượng âm thanh tốt.',599.99,2,6,'4k-tv.jpg','iphone13.jpg',25,0,0),(10,'Máy Giặt Panasinic','Máy giặt công nghệ mới với nhiều chương trình giặt.',449.99,2,7,'washing-machine.jpg','iphone13.jpg',20,3,0),(11,'Điều Hòa Sunhouse','Điều hòa nhiệt độ thông minh và tiết kiệm điện năng.',799.99,2,8,'air-conditioner.jpg','iphone13.jpg',15,0,0),(12,'Áo Polo ClownZ','Áo thun Polo thoáng khí và thoải mái.',29.99,3,9,'polo-shirt.jpg','iphone13.jpg',80,0,0),(13,'Quần Jean Dirty Coins','Quần jean phong cách với sự thoải mái.',49.99,3,10,'jeans.jpg','iphone13.jpg',60,0,0),(14,'Áo Sơ Mi Hades','Áo sơ mi nam dáng dài với kiểu dáng thanh lịch.',39.99,3,11,'shirt.jpg','iphone13.jpg',50,0,0);

CREATE TABLE `reviews` (
  `review_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `comment` text,
  PRIMARY KEY (`review_id`),
  CONSTRAINT `reviews_chk_1` CHECK ((`rating` in (1,2,3,4,5)))
) 

INSERT INTO `reviews` VALUES (1,1,1,5,'Sản phẩm tuyệt vời, đáng đồng tiền bát gáo.'),(2,1,2,4,'Mình rất hài lòng với chất lượng camera của iPhone 13.'),(3,1,3,5,'Thiết kế sang trọng và hiệu năng mạnh mẽ.'),(4,4,4,4,'Giá trị tốt, hiệu năng ổn định.'),(5,4,5,3,'Pin không lâu như mình mong đợi, nhưng mọi thứ khác đều tốt.'),(6,4,6,5,'Xiaomi Mi 11 thực sự là một chiếc điện thoại đáng mua.'),(7,7,7,5,'Bếp Shimono làm mọi bữa ăn trở nên dễ dàng hơn.'),(8,7,8,4,'Công nghệ điều chỉnh nhiệt độ rất tốt.'),(9,7,9,5,'Giá cả hợp lý và chất lượng đỉnh cao.'),(10,10,10,5,'Áo Polo ClownZ rất thoải mái và phù hợp với mọi hoạt động.'),(11,10,11,4,'Chất liệu khá tốt, giá thành hợp lý.'),(12,10,12,5,'Thích hợp cho mọi dịp từ công việc đến cuộc hẹn.'),(13,13,13,5,'Điều hòa Sunhouse làm mát nhanh chóng và hiệu quả.'),(14,13,14,3,'Tiếng ồn hơi lớn, nhưng làm mát tốt.'),(15,13,15,4,'Thiết kế hiện đại và dễ sử dụng.');

CREATE TABLE `suppliers` (
  `supplier_id` int NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(255) NOT NULL,
  PRIMARY KEY (`supplier_id`)
)
INSERT INTO `suppliers` VALUES (1,'Apple'),(2,'Samsung'),(3,'Oppo'),(4,'Xiaomi'),(5,'Shimono'),(6,'Toshiba'),(7,'Panasinic'),(8,'Sunhouse'),(9,'ClownZ'),(10,'Dirty Coins'),(11,'Hades');

CREATE TABLE `user_permissions` (
  `user_id` int DEFAULT NULL,
  `permission_id` int DEFAULT NULL
)
INSERT INTO `user_permissions` VALUES (2,1),(2,2),(2,3),(2,4),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6);

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
)
INSERT INTO `users` VALUES (1,'admin','admin123','admin@example.com',NULL,0,1),(2,'manager1','manager123','manager1@example.com',NULL,1,1),(3,'manager2','manager123','manager2@example.com',NULL,1,1),(4,'user1','user123','user1@example.com',NULL,2,1),(5,'user2','user123','user2@example.com',NULL,2,1),(6,'user3','user123','user3@example.com',NULL,2,1),(13,'minhnguyen','Minh12345','minhngltt@gmail.com','332758',2,1);

CREATE TABLE `viewed_products` (
  `viewed_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `view_date` datetime DEFAULT NULL,
  PRIMARY KEY (`viewed_id`)
)
INSERT INTO `viewed_products` VALUES (1,13,1,'2023-12-10 00:00:00'),(2,13,2,'2023-12-10 00:00:00'),(3,13,5,'2023-12-10 00:00:00'),(4,13,7,'2023-12-10 00:00:00'),(5,13,6,'2023-12-10 00:00:00'),(25,13,3,'2023-12-12 00:00:00'),(41,13,13,'2023-12-12 00:00:00'),(42,13,12,'2023-12-12 00:00:00');
