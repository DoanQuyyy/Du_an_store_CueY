-- --------------------------------------------------------
-- Máy chủ:                      127.0.0.1
-- Server version:               9.0.1 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Phiên bản:           12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for shopcuey
CREATE DATABASE IF NOT EXISTS `shopcuey` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shopcuey`;

-- Dumping structure for table shopcuey.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `Categories_ID` int NOT NULL AUTO_INCREMENT,
  `Category_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `Parent_ID` int DEFAULT NULL,
  PRIMARY KEY (`Categories_ID`),
  KEY `Parent_ID` (`Parent_ID`),
  CONSTRAINT `categories_ibfk_1` FOREIGN KEY (`Parent_ID`) REFERENCES `categories` (`Categories_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table shopcuey.categories: ~8 rows (approximately)
DELETE FROM `categories`;
INSERT INTO `categories` (`Categories_ID`, `Category_name`, `Parent_ID`) VALUES
	(3, 'Quần Dài', NULL),
	(7, 'Áo Thun Nam Nữ', NULL),
	(8, 'Áo PoLo', NULL),
	(9, 'Áo Sơ Mi', NULL),
	(10, 'Quần Jean', NULL),
	(11, 'Phụ Kiện Thời Trang', NULL),
	(12, 'Đồ Dùng Cá Nhân', NULL),
	(13, 'Quần Short', NULL);

-- Dumping structure for table shopcuey.collection
CREATE TABLE IF NOT EXISTS `collection` (
  `Collection_ID` int NOT NULL AUTO_INCREMENT,
  `Collection_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `Image` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`Collection_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table shopcuey.collection: ~3 rows (approximately)
DELETE FROM `collection`;
INSERT INTO `collection` (`Collection_ID`, `Collection_name`, `Image`, `Description`) VALUES
	(12, 'Bộ Sưu Tập Mùa Hè Nóng Bức', 'Screenshot 2024-09-05 225401.png', 'sdsd'),
	(32, 'Bộ sưu tập Doraemon | YaMe', 'doremon _bst.jpg', 'Doraemon | YaMe: Khơi Dậy Ký Ức Tuổi Thơ, Kết Nối Yêu Thương Gia Đình\r\nAi trong chúng ta cũng từng có một tuổi thơ gắn liền với chú mèo máy Doraemon đến từ tương lai. Doraemon không chỉ là người bạn đồng hành cùng Nobita trong những chuyến phiêu lưu, mà còn là một thành viên trong gia đình, luôn yêu thương và quan tâm đến cậu bé.'),
	(43, 'Bộ sưu tập DRAGON BALL Z ', 'dragonball_bst.jpg', 'Bộ sưu tập cho giới trẻ');

-- Dumping structure for table shopcuey.color
CREATE TABLE IF NOT EXISTS `color` (
  `Color_ID` int NOT NULL AUTO_INCREMENT,
  `Color_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`Color_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table shopcuey.color: ~6 rows (approximately)
DELETE FROM `color`;
INSERT INTO `color` (`Color_ID`, `Color_name`) VALUES
	(1, 'Màu vàng'),
	(2, 'Màu Trắng'),
	(3, 'Màu Đen'),
	(4, 'Màu Xanh'),
	(5, 'Màu Hồng'),
	(6, 'Màu Tím');

-- Dumping structure for table shopcuey.invoice
CREATE TABLE IF NOT EXISTS `invoice` (
  `Invoice_ID` int NOT NULL AUTO_INCREMENT,
  `Address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `First_Name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `Invoice_Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Message` text COLLATE utf8mb4_general_ci,
  `Phone` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Total_Amount` decimal(10,2) NOT NULL,
  `User_ID` int DEFAULT NULL,
  PRIMARY KEY (`Invoice_ID`),
  KEY `User_ID` (`User_ID`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table shopcuey.invoice: ~0 rows (approximately)
DELETE FROM `invoice`;

-- Dumping structure for table shopcuey.invoice_item
CREATE TABLE IF NOT EXISTS `invoice_item` (
  `Invoice_Item_ID` int NOT NULL AUTO_INCREMENT,
  `Price` decimal(10,2) NOT NULL,
  `Quantity` int NOT NULL,
  `Invoice_ID` int NOT NULL,
  `Product_ID` int NOT NULL,
  PRIMARY KEY (`Invoice_Item_ID`),
  KEY `Invoice_ID` (`Invoice_ID`),
  KEY `Product_ID` (`Product_ID`),
  CONSTRAINT `invoice_item_ibfk_1` FOREIGN KEY (`Invoice_ID`) REFERENCES `invoice` (`Invoice_ID`),
  CONSTRAINT `invoice_item_ibfk_2` FOREIGN KEY (`Product_ID`) REFERENCES `product` (`Product_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table shopcuey.invoice_item: ~0 rows (approximately)
DELETE FROM `invoice_item`;

-- Dumping structure for table shopcuey.product
CREATE TABLE IF NOT EXISTS `product` (
  `Product_ID` int NOT NULL AUTO_INCREMENT,
  `Price` decimal(10,2) NOT NULL,
  `Description` text COLLATE utf8mb4_general_ci,
  `Color_ID` int DEFAULT NULL,
  `Image` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Product_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `Stock` int DEFAULT NULL,
  `Quanlity` int NOT NULL,
  `Collection_ID` int DEFAULT NULL,
  `Categories_ID` int DEFAULT NULL,
  `Is_Like` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`Product_ID`),
  KEY `Color_ID` (`Color_ID`),
  KEY `Collection_ID` (`Collection_ID`),
  KEY `Categories_ID` (`Categories_ID`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`Color_ID`) REFERENCES `color` (`Color_ID`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`Collection_ID`) REFERENCES `collection` (`Collection_ID`),
  CONSTRAINT `product_ibfk_3` FOREIGN KEY (`Categories_ID`) REFERENCES `categories` (`Categories_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table shopcuey.product: ~7 rows (approximately)
DELETE FROM `product`;
INSERT INTO `product` (`Product_ID`, `Price`, `Description`, `Color_ID`, `Image`, `Product_name`, `Stock`, `Quanlity`, `Collection_ID`, `Categories_ID`, `Is_Like`) VALUES
	(1, 300.00, 'Chất liệu rất dày và đẹp', 2, 'aothun3lo-sp5.jpg', 'Áo thun ba lỗ trơn', NULL, 2, NULL, 7, 0),
	(2, 200.00, '1. Kiểu sản phẩm: Áo thun cổ tròn tay dài dáng vừa\r\n2. Ưu điểm:\r\n• Kiểu dáng hiện đại dễ dàng phối đồ.\r\n• Thiết kế túi trước ngực ẩn bên trong giúp áo thẫm mỹ hơn.', 2, 'aothuntaydai-sp2.jpg', 'Áo Thun Cool Touch', NULL, 2, NULL, 7, 0),
	(3, 300.00, 'Kiểu sản phẩm: Áo thun cổ tròn tay ngắn dáng vừa\r\n2. Ưu điểm:\r\n● Thiết kế đơn giản và tinh tế mang phong cách tối giản.\r\n● Màu sắc trung tính dễ dàng kết hợp với nhiều trang phục khác nhau.', 2, 'aothuntayngan-sp1.jpg', 'Áo Thun Seventy Seven 44 Vol 24 Xám Đậm', NULL, 5, NULL, 7, 0),
	(4, 300.00, '1. Kiểu sản phẩm: Áo thun cổ tròn tay ngắn, form dáng regular fit\\\r\n2. Ưu điểm:\r\n● Vải cotton compact 2S sở hữu khả năng co giãn tối ưu theo mọi hướng, giúp bạn thoải mái vận động mà không bị gò bó.', 2, 'aothuntayngan-sp3.jpg', 'Áo Thun No Style M106 Vol 24 Nâu', NULL, 3, NULL, 7, 0),
	(21, 200.00, '1. Kiểu sản phẩm: Áo sơ mi cổ bẻ tay ngắn dáng rộng.\r\n2. Ưu điểm\r\n• Chất liệu Modal Fabric bề mặt mềm mịn, mỏng nhẹ, nhanh khô, độ bền tốt, ít vón cục.', 2, 'aosomi_sp1_noun.jpg', 'Áo Sơ Mi Cổ Bẻ Tay Ngắn', NULL, 20, NULL, 9, 0),
	(31, 127.00, '1. Kiểu sản phẩm: Quần short nam lưng thun\r\n2. Ưu điểm:\r\n• Thoáng mát, nhanh khô: Chất liệu Bird Eye Mesh giúp không khí lưu thông tốt, thấm hút mồ hôi nhanh, mang đến cảm giác thoải mái, đặc biệt trong những ngày hè nóng bức.', 3, 'quanshort_sp1_noun.jpg', 'Quần Short 9 Inch Dáng Vừa', NULL, 32, NULL, 13, 0),
	(78, 475.00, '1. Kiểu sản phẩm: Quần dài lưng gài ống đứng.\r\n2. Ưu điểm:', 2, 'QuanJean-sp1.jpg', 'Quần Dài No Style M115', NULL, 2, NULL, 10, 0);

-- Dumping structure for table shopcuey.role
CREATE TABLE IF NOT EXISTS `role` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table shopcuey.role: ~1 rows (approximately)
DELETE FROM `role`;
INSERT INTO `role` (`ID`, `Name`) VALUES
	(1, 'ADMIN');

-- Dumping structure for table shopcuey.user
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Email` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `Phone` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `Password` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table shopcuey.user: ~1 rows (approximately)
DELETE FROM `user`;
INSERT INTO `user` (`ID`, `Address`, `Email`, `Phone`, `Name`, `Password`) VALUES
	(1, 'Thôn 8', 'Doanquy237@gmail.com', '0394743238', 'Admin', '$2a$10$3pveJvGFGdzTiQ0LMp7NsOfOWLbGa.a8hwtj4C0lq8kPaWBy5Hbam');

-- Dumping structure for table shopcuey.user_roles
CREATE TABLE IF NOT EXISTS `user_roles` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Role_ID` int NOT NULL,
  `User_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Role_ID` (`Role_ID`),
  KEY `User_ID` (`User_ID`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`Role_ID`) REFERENCES `role` (`ID`),
  CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`User_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table shopcuey.user_roles: ~1 rows (approximately)
DELETE FROM `user_roles`;
INSERT INTO `user_roles` (`ID`, `Role_ID`, `User_ID`) VALUES
	(1, 1, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
