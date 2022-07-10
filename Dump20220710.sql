-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: oop20212
-- ------------------------------------------------------
-- Server version	8.0.28

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
  `giaMua` double DEFAULT NULL,
  `giaBan` double DEFAULT NULL,
  `soLuong` int DEFAULT NULL,
  `namRaMat` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_1_dianhac` FOREIGN KEY (`id`) REFERENCES `tbl_sanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dianhac`
--

LOCK TABLES `tbl_dianhac` WRITE;
/*!40000 ALTER TABLE `tbl_dianhac` DISABLE KEYS */;
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
  `giaMua` double DEFAULT NULL,
  `giaBan` double DEFAULT NULL,
  `soLuong` int DEFAULT NULL,
  `namRaMat` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_1_diaphim` FOREIGN KEY (`id`) REFERENCES `tbl_sanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_diaphim`
--

LOCK TABLES `tbl_diaphim` WRITE;
/*!40000 ALTER TABLE `tbl_diaphim` DISABLE KEYS */;
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
  `tenKhachHang` varchar(45) DEFAULT NULL,
  `discount` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_hoadon`
--

LOCK TABLES `tbl_hoadon` WRITE;
/*!40000 ALTER TABLE `tbl_hoadon` DISABLE KEYS */;
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
  `ten` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `nhaXuatBan` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tacGia` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `theLoai` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_1_sach` FOREIGN KEY (`id`) REFERENCES `tbl_sanpham` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sach`
--

LOCK TABLES `tbl_sach` WRITE;
/*!40000 ALTER TABLE `tbl_sach` DISABLE KEYS */;
INSERT INTO `tbl_sach` VALUES (1,'Truyen cuoi','Văn A','Kim Đồng','Truyện');
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
INSERT INTO `tbl_sanpham` VALUES (1,30000,35000,100,2016);
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
INSERT INTO `tbl_taikhoan` VALUES ('duongdt','123456','admin'),('duongdt1','123456','admin');
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

-- Dump completed on 2022-07-10 16:21:09
