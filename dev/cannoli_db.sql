CREATE DATABASE  IF NOT EXISTS `cannoli_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cannoli_db`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: cannoli_db
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombreCategoria` varchar(30) NOT NULL,
  `fotografia` varchar(100) NOT NULL,
  `estatus` int NOT NULL,
  PRIMARY KEY (`idCategoria`),
  KEY `idEstatus_idx` (`estatus`),
  CONSTRAINT `estatus` FOREIGN KEY (`estatus`) REFERENCES `estatus` (`idEstatus`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'corales','C:\\Users\\Usuario\\Documents\\github\\Cannoli-escritorio\\img\\pasteles.png',1),(4,'donas','C:/cannoli/categorias//donas.png',1),(5,'ghfhgghfh','C:/cannoli/categorias//ghfhgghfh.png',1),(6,'dos','C:/cannoli/categorias//dos.png',1),(7,'hy','C:/cannoli/categorias//hy.png',1),(8,'hjgjh','C:/cannoli/categorias//hjgjh.png',1),(9,'nu','C:/cannoli/categorias//nu.png',1),(10,'nur','C:/cannoli/categorias//nur.png',1),(11,'ju','C:/cannoli/categorias//ju.png',1);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `persona` int DEFAULT NULL,
  `curp` varchar(18) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `fotografia` varchar(255) DEFAULT NULL,
  `contrasenia` varchar(30) NOT NULL,
  `rol` int DEFAULT NULL,
  `estatus` int DEFAULT NULL,
  `sesion` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idEmpleado`),
  UNIQUE KEY `curp` (`curp`),
  UNIQUE KEY `correo` (`correo`),
  UNIQUE KEY `username` (`username`),
  KEY `persona` (`persona`),
  KEY `rol` (`rol`),
  KEY `estatus` (`estatus`),
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `personas` (`idPersona`),
  CONSTRAINT `empleados_ibfk_2` FOREIGN KEY (`rol`) REFERENCES `roles` (`idRol`),
  CONSTRAINT `empleados_ibfk_3` FOREIGN KEY (`estatus`) REFERENCES `estatus` (`idEstatus`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (11,16,'ASDFa','apocosi@gmail.com','122','C:/file/file','1234567',1,2,0),(21,30,'Liz123','Liz@gmail.com','Liz2343','C:/empleados/Liz123/Liz123.jpg','123456',1,1,0),(25,36,'qwertgfd','admin@gmail.com','user','C:/cannoli/empleados/qwertgfd/qwertgfd.png','12345',1,1,0),(32,46,'adsjajld','asbdkajskd','jdjadsa','C:/cannoli/empleados/adsjajld/adsjajld.png','asdnansld',1,1,1),(33,47,'asdasd','adasda','asdasd','C:/cannoli/empleados/asdasd/asdasd.png','adasda',1,1,1),(34,48,'asae','azara','volvol','C:/cannoli/empleados/asae/asae.png','12qw',1,1,1),(38,52,'asl','marilu@gmail.com','askk','C:/cannoli/empleados/asl/asl.png','password',1,1,1),(39,54,'NIE','lalo@gmail.com','caracolito','C:/cannoli/empleados/NIE/NIE.png','12345',1,1,0),(40,55,'6554564EAGGBEFRERR','vbvkhvhkgk@gmail.com','jhghjghjgj','C:/cannoli/empleados/6554564EAGGBEFRERR/6554564EAGGBEFRERR.png','Caracoles123',1,1,1),(41,56,'GBSHYY46YH44GBNGNH','bjh@gmail.com','hgjh','C:/cannoli/empleados/GBSHYY46YH44GBNGNH/GBSHYY46YH44GBNGNH.png','estoghhg554VD',1,1,1),(42,57,'HETREREYHTH43543HT','fgf@hjgjhghj.com','hghjgj','C:/cannoli/empleados/HETREREYHTH43543HT/HETREREYHTH43543HT.png','8897bqDS',2,1,1);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `eliminarEmpleado` AFTER DELETE ON `empleados` FOR EACH ROW BEGIN 
	DELETE FROM personas WHERE idPersona = OLD.persona AND OLD.sesion = 0;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `entregas`
--

DROP TABLE IF EXISTS `entregas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entregas` (
  `idEntrega` int NOT NULL AUTO_INCREMENT,
  `fechaEntrega` date NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `idEmpleado` int NOT NULL,
  `idProveedor` int NOT NULL,
  PRIMARY KEY (`idEntrega`),
  KEY `empleado` (`idEmpleado`),
  KEY `proveedor` (`idProveedor`),
  CONSTRAINT `entregas_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `empleados` (`idEmpleado`),
  CONSTRAINT `entregas_ibfk_2` FOREIGN KEY (`idProveedor`) REFERENCES `proveedores` (`idProveedor`),
  CONSTRAINT `proveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedores` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entregas`
--

LOCK TABLES `entregas` WRITE;
/*!40000 ALTER TABLE `entregas` DISABLE KEYS */;
/*!40000 ALTER TABLE `entregas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `idEstado` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estatus`
--

DROP TABLE IF EXISTS `estatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estatus` (
  `idEstatus` int NOT NULL AUTO_INCREMENT,
  `nombreEstatus` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idEstatus`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estatus`
--

LOCK TABLES `estatus` WRITE;
/*!40000 ALTER TABLE `estatus` DISABLE KEYS */;
INSERT INTO `estatus` VALUES (1,'Activo'),(2,'Inactivo');
/*!40000 ALTER TABLE `estatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_pago`
--

DROP TABLE IF EXISTS `forma_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forma_pago` (
  `idForma_pago` int NOT NULL AUTO_INCREMENT,
  `forma_pago` varchar(30) NOT NULL,
  PRIMARY KEY (`idForma_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_pago`
--

LOCK TABLES `forma_pago` WRITE;
/*!40000 ALTER TABLE `forma_pago` DISABLE KEYS */;
INSERT INTO `forma_pago` VALUES (1,'Efectivo'),(2,'Transferencia');
/*!40000 ALTER TABLE `forma_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_producto`
--

DROP TABLE IF EXISTS `pedido_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_producto` (
  `idProducto` int NOT NULL,
  `numeroPedido` int NOT NULL,
  `precio` float(20,4) NOT NULL,
  `cantidad` int NOT NULL,
  `total` int NOT NULL,
  PRIMARY KEY (`idProducto`,`numeroPedido`),
  KEY `numeroPedido` (`numeroPedido`),
  CONSTRAINT `pedido_producto_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`),
  CONSTRAINT `pedido_producto_ibfk_2` FOREIGN KEY (`numeroPedido`) REFERENCES `pedidos` (`idPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_producto`
--

LOCK TABLES `pedido_producto` WRITE;
/*!40000 ALTER TABLE `pedido_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `idPedido` int NOT NULL AUTO_INCREMENT,
  `fechaPedido` date NOT NULL,
  `fechaEntrega` date NOT NULL,
  `nombreCliente` varchar(45) NOT NULL,
  `telefono` int NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `fotografia` varchar(255) DEFAULT NULL,
  `id_formaPago` int NOT NULL,
  `id_estado` int NOT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `cliente` (`nombreCliente`),
  KEY `idForma_pago_idx` (`id_formaPago`),
  KEY `idEstado_idx` (`id_estado`),
  CONSTRAINT `idEstado` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`idEstado`),
  CONSTRAINT `idForma_pago` FOREIGN KEY (`id_formaPago`) REFERENCES `forma_pago` (`idForma_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `idPersona` int NOT NULL AUTO_INCREMENT,
  `nombrePersona` varchar(20) NOT NULL,
  `apellidoPaterno` varchar(20) NOT NULL,
  `apellidoMaterno` varchar(20) NOT NULL,
  `sexo` varchar(15) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `tipoPersona` int DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `tipoPersona` (`tipoPersona`),
  CONSTRAINT `personas_ibfk_1` FOREIGN KEY (`tipoPersona`) REFERENCES `tipopersonas` (`idTipoPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (16,'Dorian','Dorian','Dorian','Masculino','2244556644',1),(19,'Santigo','File','Lopez','Masculino','2244556644',1),(20,'Santigo','File','Lopez','Masculino','2244556644',1),(30,'Liz','Liz','Liz','Femenino','224451111',1),(36,'persona','alberto','baltazar','Masculino','228111223',1),(45,'Angel','Carrillo','Baltazar','Masculino','9988776655',1),(46,'djabskjd','abjdkja','adkabsd','Masculino','asjldasjd',1),(47,'asdasda','adasdas','adadsa','Masculino','adasdas',1),(48,'Fil','Fil','Zar','Masculino','1234',1),(52,'Marilu','Filomeno','Guti','Femenino','123456',1),(54,'Galan Galan','Cepillin','NIE','Masculino','222',1),(55,'guj','juhh','gfdd','Femenino','2281002031',1),(56,'uyuotyuyuoyuto','ghgvnbnnvh','hghvgv','Femenino','5765675765',1),(57,'fernando houoi','uiyuiyui','jgjkhjghj','Masculino','6545464546',1);
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(35) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` float(10,2) NOT NULL,
  `cantidad` int NOT NULL,
  `fechaElaboracion` date NOT NULL,
  `fechaVencimiento` date NOT NULL,
  `fotografia` varchar(255) NOT NULL,
  `estatus` int DEFAULT NULL,
  `categoria` int DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `estatus` (`estatus`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`estatus`) REFERENCES `estatus` (`idEstatus`),
  CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`categoria`) REFERENCES `categorias` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'pastel de chocolate','promoción especial',45.30,4,'2024-04-23','2024-04-27','C:\\Users\\Usuario\\Documents\\github\\Cannoli-escritorio\\src\\img\\pastel1.png',1,1),(3,'Pastel de tres leches','sadasdsadas',67.54,6,'2024-04-23','2024-04-27','C:\\Users\\Usuario\\Documents\\github\\Cannoli-escritorio\\src\\img\\pastel3.png',1,1),(4,'Pastel horneado','hgjhjg',78.00,6,'2024-04-23','2024-04-27','C:\\Users\\Usuario\\Documents\\github\\Cannoli-escritorio\\src\\img\\pastel3.png',1,1),(7,'dsddsfdsdsf','hgjhgjhhj',786.00,8,'2024-04-10','2024-04-12','C:\\Users\\Usuario\\Documents\\github\\Cannoli-escritorio\\src\\img\\pastel3.png',1,1),(9,'pastelito','jhhkjh',77.00,78,'2024-04-11','2024-04-25','C:\\Users\\Usuario\\Documents\\github\\Cannoli-escritorio\\src\\img\\pastel3.png',1,1),(11,'fac','njjkhk',7.00,5,'2024-04-11','2024-04-18','C:\\Users\\Usuario\\Documents\\github\\Cannoli-escritorio\\src\\img\\pastel3.png',1,1),(31,'hgjhgj','',12345678.00,6,'2024-05-22','2024-06-08','C:\\Users\\Usuario\\Documents\\github\\Cannoli-escritorio\\src\\img\\abajo.png',1,1),(32,'u','',8788889.00,8,'2024-05-09','2024-05-10','C:\\Users\\Usuario\\Downloads\\OIP.jpg',1,1),(34,'hgjhgjhghhgj','hgjh',9.00,7,'2024-05-18','2024-06-07','C:\\Users\\Usuario\\Downloads\\OIP.jpg',1,1),(35,'hgghfhgfhgf','',76.90,78,'2024-05-23','2024-05-24','C:\\Users\\Usuario\\Documents\\github\\Cannoli-escritorio\\src\\img\\agency.png',1,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `idProveedor` int NOT NULL AUTO_INCREMENT,
  `nombreProveedor` varchar(30) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `empresa` varchar(50) NOT NULL,
  `estatus` int DEFAULT NULL,
  PRIMARY KEY (`idProveedor`),
  KEY `estatus` (`estatus`),
  CONSTRAINT `proveedores_ibfk_1` FOREIGN KEY (`estatus`) REFERENCES `estatus` (`idEstatus`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Azucar glasssssd','2288778899','Sugar',NULL),(3,'sdadsadd','123213123','asdsad',NULL);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(20) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Comercial'),(2,'General');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopersonas`
--

DROP TABLE IF EXISTS `tipopersonas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipopersonas` (
  `idTipoPersona` int NOT NULL AUTO_INCREMENT,
  `nombreTipoPersona` varchar(20) NOT NULL,
  PRIMARY KEY (`idTipoPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopersonas`
--

LOCK TABLES `tipopersonas` WRITE;
/*!40000 ALTER TABLE `tipopersonas` DISABLE KEYS */;
INSERT INTO `tipopersonas` VALUES (1,'Empleado'),(2,'Cliente');
/*!40000 ALTER TABLE `tipopersonas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_producto`
--

DROP TABLE IF EXISTS `venta_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_producto` (
  `idVenta` int NOT NULL,
  `idProducto` int NOT NULL,
  PRIMARY KEY (`idVenta`,`idProducto`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `venta_producto_ibfk_1` FOREIGN KEY (`idVenta`) REFERENCES `ventas` (`idventa`),
  CONSTRAINT `venta_producto_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_producto`
--

LOCK TABLES `venta_producto` WRITE;
/*!40000 ALTER TABLE `venta_producto` DISABLE KEYS */;
INSERT INTO `venta_producto` VALUES (6,1),(7,1),(8,3),(9,3),(10,3),(8,4),(9,4),(8,34);
/*!40000 ALTER TABLE `venta_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `idventa` int NOT NULL AUTO_INCREMENT,
  `fechaVenta` date NOT NULL,
  `cantidad` int NOT NULL,
  `total` float(20,4) NOT NULL,
  `cambio` float NOT NULL,
  `montoRecibido` float NOT NULL,
  `idFormaPago` int NOT NULL,
  PRIMARY KEY (`idventa`),
  KEY `id_formaPago_idx` (`idFormaPago`),
  CONSTRAINT `id_formaPago` FOREIGN KEY (`idFormaPago`) REFERENCES `forma_pago` (`idForma_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,'2024-04-23',4,87.9000,0,0,2),(2,'2024-05-26',1,78.0000,767,689,1),(3,'2024-05-26',1,67.5400,67.98,0.44,1),(4,'2024-05-26',1,45.3000,76,30.7,1),(5,'2024-05-26',1,67.5400,78,10.46,1),(6,'2024-05-26',1,45.3000,76,30.7,1),(7,'2024-05-26',1,45.3000,67,21.7,1),(8,'2024-05-26',3,635.1600,700,64.84,1),(9,'2024-05-26',2,145.5400,678,532.46,1),(10,'2024-05-26',1,5268.1201,7699,2430.88,1);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'cannoli_db'
--

--
-- Dumping routines for database 'cannoli_db'
--
/*!50003 DROP PROCEDURE IF EXISTS `modificarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`DBA_General`@`localhost` PROCEDURE `modificarEmpleado`(
	IN _idEmpleado INT,
    IN _correo VARCHAR (35),
    IN _contrasenia VARCHAR (18),
    IN _fotografia VARCHAR(255),
    IN _estatus INT,
    IN _persona INT,
    IN _nombrePersona VARCHAR(35),
    IN _apellidoPaterno VARCHAR(35),
    IN _apellidoMaterno VARCHAR(35),
    IN _sexo VARCHAR(15),
    IN _telefono VARCHAR(10),
    
    INOUT _filasAfectadas INT,
    INOUT _error VARCHAR(255)
)
BEGIN

	SET @filasPersona = 0;
    SET @filasEmpleado = 0;
    SET _filasAfectadas = 0;
    SET _error = '';

	START TRANSACTION;
    BEGIN
		IF EXISTS(SELECT * FROM personas WHERE idPersona=_persona) THEN
			UPDATE personas SET 
            nombrePersona=IFNULL(_nombrePersona, nombrePersona),
            apellidoPaterno=IFNULL(_apellidoPaterno, apellidoPaterno),
            apellidoMaterno=IFNULL(_apellidoMaterno, apellidoMaterno),
            sexo=IFNULL(_sexo, sexo),
            telefono=IFNULL(_telefono, telefono)
            WHERE idPersona = _persona;
            
            SET @filasPersona = ROW_COUNT();
        ELSE
			ROLLBACK;
            SET _error = CONCAT(_error, 'La persona ingresada no se encuentra en la base de datos.');
        END IF;
    END;
    
    BEGIN
		IF EXISTS(SELECT * FROM empleados WHERE idEmpleado = _idEmpleado) THEN
			IF NOT EXISTS(SELECT * FROM empleados WHERE correo=_correo AND idEmpleado !=_idEmpleado) THEN 
				UPDATE empleados SET 
				correo = IFNULL(_correo, correo),
				contrasenia = IFNULL(_contrasenia, contrasenia),
                fotografia = IFNULL(_fotografia, fotografia),
				estatus = IFNULL(_estatus, estatus)
				WHERE idEmpleado = _idEmpleado;
            
				SET @filasEmpleado = ROW_COUNT();
            ELSE
				ROLLBACK;
                SET _error = CONCAT(_error, 'Correo repetido, favor de cambiarlo');
            END IF;
        ELSE
			ROLLBACK;
            SET _error = CONCAT(_error, 'El empleado ingresado no se encuentra en la base de datos.');
        END IF;
    END;
    
    SET _filasAfectadas = @filasPersona + @filasEmpleado;
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`DBA_General`@`localhost` PROCEDURE `registrarEmpleado`(
	IN _nombrePersona VARCHAR(20),
    IN _apellidoPaterno VARCHAR(20),
    IN _apellidoMaterno VARCHAR(20),
    IN _sexo VARCHAR(15),
    IN _telefono VARCHAR(10),
    IN _curp VARCHAR(18),
    IN _username VARCHAR(35),
    IN _correo VARCHAR(100),
    IN _contrasenia VARCHAR(35),
    IN _fotografia VARCHAR(255),
    IN _rol INT,
    
    INOUT _filasAfectadas INT,
    INOUT _error VARCHAR(255)
)
BEGIN 
	SET @idPersona = 0;
    SET @filasPersona = 0;
	SET @filasEmpleado = 0;
    SET _filasAfectadas = 0;
    SET _error = '';
    
    START TRANSACTION;
		
        BEGIN
			
            INSERT INTO personas(nombrePersona, apellidoPaterno, apellidoMaterno, sexo, telefono, tipoPersona) 
            VALUES (_nombrePersona, _apellidoPaterno, _apellidoMaterno, _sexo, _telefono, 1);
            
            SET @idPersona = LAST_INSERT_ID();
            SET @filasPersona = ROW_COUNT();
            
        END;
        
        BEGIN
        
			IF EXISTS (SELECT * FROM empleados WHERE username = _username OR correo=_correo OR curp=_curp) THEN
				ROLLBACK;
                SET _error = CONCAT(_error, 'Datos repetidos, favor de cambiarlos');
            ELSE
				IF EXISTS(SELECT * FROM roles WHERE _rol=idRol) THEN
					INSERT INTO empleados(persona, curp, correo, username, contrasenia, fotografia, rol, estatus) 
					VALUES(@idPersona, _curp, _correo, _username, _contrasenia, _fotografia, _rol, 1);
                    
                    SET @filasEmpleado = ROW_COUNT();
                   
                ELSE
					ROLLBACK;
                    SET _error = CONCAT(_error, 'El rol no existe en la base de datos');
                END IF;
            END IF;
        END;
		SET _filasAfectadas = @filasEmpleado + @filasPersona;
        COMMIT; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-27 17:32:06
