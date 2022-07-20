-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: dump20220710
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `tbl_cuahang`
--

DROP TABLE IF EXISTS `tbl_cuahang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cuahang` (
  `Date` datetime NOT NULL,
  `doanhthu` double DEFAULT NULL,
  PRIMARY KEY (`Date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cuahang`
--

LOCK TABLES `tbl_cuahang` WRITE;
/*!40000 ALTER TABLE `tbl_cuahang` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_cuahang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dianhac`
--

DROP TABLE IF EXISTS `tbl_dianhac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dianhac` (
  `id` int NOT NULL,
  `ten` varchar(45) NOT NULL,
  `caSy` varchar(45) DEFAULT NULL,
  `theLoaiNhac` varchar(45) DEFAULT NULL,
  `album` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_1_dianhac` FOREIGN KEY (`id`) REFERENCES `tbl_sanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dianhac`
--

LOCK TABLES `tbl_dianhac` WRITE;
/*!40000 ALTER TABLE `tbl_dianhac` DISABLE KEYS */;
INSERT INTO `tbl_dianhac` VALUES (16,'Mang tiền về cho mẹ','Rap','Đen vâu','Rap'),(17,'Never stop me','Rap','tkay maidza','Rap');
/*!40000 ALTER TABLE `tbl_dianhac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_diaphim`
--

DROP TABLE IF EXISTS `tbl_diaphim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_diaphim` (
  `id` int NOT NULL,
  `ten` varchar(45) NOT NULL,
  `daoDien` varchar(45) DEFAULT NULL,
  `bienKich` varchar(45) DEFAULT NULL,
  `dienVien` varchar(45) DEFAULT NULL,
  `hangSanXuat` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_1_diaphim` FOREIGN KEY (`id`) REFERENCES `tbl_sanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_diaphim`
--

LOCK TABLES `tbl_diaphim` WRITE;
/*!40000 ALTER TABLE `tbl_diaphim` DISABLE KEYS */;
INSERT INTO `tbl_diaphim` VALUES (13,'naruto','kishimoto','kishimoto','Naruto','A1 Picture'),(14,'Truyen vui','Kim Đồng','Văn A','Truyện','abc'),(15,'Truyen vui','Kim Đồng','Văn A','Truyện','null');
/*!40000 ALTER TABLE `tbl_diaphim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_giohang`
--

DROP TABLE IF EXISTS `tbl_giohang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_giohang` (
  `id` int NOT NULL,
  `hoadon_id` int DEFAULT NULL,
  `sanpham_id` int DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_1_giohang_idx` (`sanpham_id`),
  KEY `fk_2_giohang_idx` (`hoadon_id`),
  CONSTRAINT `fk_1_giohang` FOREIGN KEY (`sanpham_id`) REFERENCES `tbl_sanpham` (`id`),
  CONSTRAINT `fk_2_giohang` FOREIGN KEY (`hoadon_id`) REFERENCES `tbl_hoadon` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_giohang`
--

LOCK TABLES `tbl_giohang` WRITE;
/*!40000 ALTER TABLE `tbl_giohang` DISABLE KEYS */;
INSERT INTO `tbl_giohang` VALUES (0,1,1,5),(1,5,5,10),(2,5,5,10),(6,1,6,5),(7,5,7,3),(9,3,7,5),(10,5,8,2),(11,3,8,2),(12,5,9,5),(13,3,9,5),(14,1,9,5),(15,10,15,3),(16,10,14,3),(17,10,16,3),(18,10,3,3),(19,11,15,4),(20,11,14,4),(21,11,16,5),(22,11,3,3);
/*!40000 ALTER TABLE `tbl_giohang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_hoadon`
--

DROP TABLE IF EXISTS `tbl_hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_hoadon` (
  `id` int NOT NULL,
  `discount` int DEFAULT NULL,
  `giaTriDonHang` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_hoadon`
--

LOCK TABLES `tbl_hoadon` WRITE;
/*!40000 ALTER TABLE `tbl_hoadon` DISABLE KEYS */;
INSERT INTO `tbl_hoadon` VALUES (1,0,1025000),(2,0,350000),(3,0,350000),(4,0,350000),(5,0,350000),(6,0,600000),(7,0,325000),(8,0,70000),(9,0,350000),(10,0,465000),(11,50,317500);
/*!40000 ALTER TABLE `tbl_hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_nhanvienfulltime`
--

DROP TABLE IF EXISTS `tbl_nhanvienfulltime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_nhanvienfulltime` (
  `username` varchar(45) NOT NULL,
  `ten` varchar(45) DEFAULT NULL,
  `namSinh` int DEFAULT NULL,
  `luongThang` double DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `fk_1_nvfulltime` FOREIGN KEY (`username`) REFERENCES `tbl_taikhoan` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_nhanvienfulltime`
--

LOCK TABLES `tbl_nhanvienfulltime` WRITE;
/*!40000 ALTER TABLE `tbl_nhanvienfulltime` DISABLE KEYS */;
INSERT INTO `tbl_nhanvienfulltime` VALUES ('hand2','Nguyễn Hà',2002,5000000),('hand2002','Nguyễn Hà',2002,10000000),('maile','Mai Lê',2002,0);
/*!40000 ALTER TABLE `tbl_nhanvienfulltime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_nhanvienparttime`
--

DROP TABLE IF EXISTS `tbl_nhanvienparttime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_nhanvienparttime` (
  `username` varchar(45) NOT NULL,
  `ten` varchar(45) DEFAULT NULL,
  `namSinh` int DEFAULT NULL,
  `luongTheoGio` double DEFAULT NULL,
  `gioLam` int DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `fk_1_nvparttime` FOREIGN KEY (`username`) REFERENCES `tbl_taikhoan` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_nhanvienparttime`
--

LOCK TABLES `tbl_nhanvienparttime` WRITE;
/*!40000 ALTER TABLE `tbl_nhanvienparttime` DISABLE KEYS */;
INSERT INTO `tbl_nhanvienparttime` VALUES ('hadimsc','Nguyễn hà',2002,50000,5),('hand','duong gay',2002,30000,0),('hand2003','duong gay',2002,50000,0);
/*!40000 ALTER TABLE `tbl_nhanvienparttime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_quanly`
--

DROP TABLE IF EXISTS `tbl_quanly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_quanly` (
  `username` varchar(45) NOT NULL,
  `ten` varchar(45) DEFAULT NULL,
  `namSinh` int DEFAULT NULL,
  `luongThang` double DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `fk1_quanly` FOREIGN KEY (`username`) REFERENCES `tbl_taikhoan` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_quanly`
--

LOCK TABLES `tbl_quanly` WRITE;
/*!40000 ALTER TABLE `tbl_quanly` DISABLE KEYS */;
INSERT INTO `tbl_quanly` VALUES ('binhduong','Bình Dương',2002,8000000),('hadimsctn1','Nguyễn Hà',2002,0),('haprosc10','Nguyễn Hà',2002,0);
/*!40000 ALTER TABLE `tbl_quanly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sach`
--

DROP TABLE IF EXISTS `tbl_sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_sach` (
  `id` int NOT NULL,
  `ten` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci NOT NULL,
  `nhaXuatBan` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci DEFAULT NULL,
  `tacGia` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci DEFAULT NULL,
  `theLoai` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_1_sach` FOREIGN KEY (`id`) REFERENCES `tbl_sanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sach`
--

LOCK TABLES `tbl_sach` WRITE;
/*!40000 ALTER TABLE `tbl_sach` DISABLE KEYS */;
INSERT INTO `tbl_sach` VALUES (3,'Truyen cuoi','Kim Đồng','Văn A','Truyện'),(12,'Naruto','kishimoto','Manga','Kim Đồng');
/*!40000 ALTER TABLE `tbl_sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sanpham`
--

DROP TABLE IF EXISTS `tbl_sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_sanpham` (
  `id` int NOT NULL,
  `giaMua` double DEFAULT NULL,
  `giaBan` double DEFAULT NULL,
  `soLuong` int DEFAULT NULL,
  `namRaMat` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sanpham`
--

LOCK TABLES `tbl_sanpham` WRITE;
/*!40000 ALTER TABLE `tbl_sanpham` DISABLE KEYS */;
INSERT INTO `tbl_sanpham` VALUES (1,30000,35000,85,2016),(3,30000,35000,77,2016),(4,30000,35000,100,2016),(5,20000,35000,75,2016),(6,20000,35000,100,2016),(7,20000,35000,100,2016),(8,20000,35000,100,2016),(9,20000,35000,100,2016),(10,20000,35000,100,2020),(12,7000,15000,-20,1993),(13,30000,50000,-5,2000),(14,20000,35000,73,2016),(15,20000,35000,93,2016),(16,30000,50000,42,2022),(17,30000,50000,50,2022);
/*!40000 ALTER TABLE `tbl_sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_taikhoan`
--

DROP TABLE IF EXISTS `tbl_taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_taikhoan` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `position` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_taikhoan`
--

LOCK TABLES `tbl_taikhoan` WRITE;
/*!40000 ALTER TABLE `tbl_taikhoan` DISABLE KEYS */;
INSERT INTO `tbl_taikhoan` VALUES ('binhduong','12345678','admin'),('Dinoman','12345678','admin'),('Dinoman1','12345678','admin'),('duongdt','123456','admin'),('duongdt1','123456','admin'),('hadimsc','12345678','employee part time'),('hadimsc3','12345678','employee part time'),('hadimsctn1','12345678','admin'),('hand','12345678','employee part time'),('hand2','12345678','employee full time'),('hand2002','12345678','employee full time'),('hand2003','12345678','employee part time'),('haprosc','12345678','Nhân viên part time'),('haprosc1','12345678','Nhân viên part time'),('haprosc10','12345678','admin'),('maile','12345678','employee full time');
/*!40000 ALTER TABLE `tbl_taikhoan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-20 14:12:01
