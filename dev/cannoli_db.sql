CREATE DATABASE  IF NOT EXISTS `cannoli_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cannoli_db`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cannoli_db
-- ------------------------------------------------------
-- Server version	8.0.35

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
  `descripcion` varchar(255) DEFAULT NULL,
  `estatus` int DEFAULT NULL,
  PRIMARY KEY (`idCategoria`),
  KEY `estatus` (`estatus`),
  CONSTRAINT `categorias_ibfk_1` FOREIGN KEY (`estatus`) REFERENCES `estatus` (`idEstatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
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
  `contrasenia` varchar(30) NOT NULL,
  `fotografia` varchar(255) NOT NULL,
  `rol` int DEFAULT NULL,
  `estatus` int DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,1,'ASDFGHJKLQWERTYUIO','dar@gmail.com','dar12','12345','C:/codigo',1,1),(2,5,'ASDFGHZXCVBN','filete@gmail.com','qwer12','123456','C:/codig/tw/',1,1),(5,8,'ASDFGHZ','filete12@gmail.com','12345678','123456','C:/codig/tw/',1,1),(6,9,'ASDFGHZo','filete123@gmail.com','1234567','123456','C:/codig/tw/',1,1),(7,11,'ASDFGHZo1','filete1234@gmail.com','12345698','123456','C:/codig/tw/',1,1),(11,16,'ASDFa','apocosi@gmail.com','122','1234567','C:/file/file',1,2);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

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
  `empleado` int DEFAULT NULL,
  `proveedor` int DEFAULT NULL,
  PRIMARY KEY (`idEntrega`),
  KEY `empleado` (`empleado`),
  KEY `proveedor` (`proveedor`),
  CONSTRAINT `entregas_ibfk_1` FOREIGN KEY (`empleado`) REFERENCES `empleados` (`idEmpleado`),
  CONSTRAINT `entregas_ibfk_2` FOREIGN KEY (`proveedor`) REFERENCES `proveedores` (`idProveedor`)
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
  CONSTRAINT `pedido_producto_ibfk_2` FOREIGN KEY (`numeroPedido`) REFERENCES `pedidos` (`numeroPedido`)
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
  `numeroPedido` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `cliente` int DEFAULT NULL,
  `formaPago` varchar(50) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `fotografia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`numeroPedido`),
  KEY `cliente` (`cliente`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`cliente`) REFERENCES `personas` (`idPersona`)
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'Erick','Lopez','Mendez','Masculino','2233445566',1),(5,'Crhistian','Filete','Lopez','M','2244556644',1),(8,'Crhistian','Filete','Lopez','M','2244556644',1),(9,'Crhistian','Filete','Lopez','M','2244556644',1),(11,'Crhistian','Filete','Lopez','M','2244556644',1),(16,'Dorian','Dorian','Dorian','Masculino','2244556644',1);
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
  `codigo` varchar(16) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` float(10,4) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
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
  `numeroVenta` int NOT NULL,
  `idProducto` int NOT NULL,
  `precio` float(20,4) NOT NULL,
  `cantidad` int NOT NULL,
  `total` int NOT NULL,
  PRIMARY KEY (`numeroVenta`,`idProducto`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `venta_producto_ibfk_1` FOREIGN KEY (`numeroVenta`) REFERENCES `ventas` (`numeroVenta`),
  CONSTRAINT `venta_producto_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_producto`
--

LOCK TABLES `venta_producto` WRITE;
/*!40000 ALTER TABLE `venta_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `numeroVenta` int NOT NULL AUTO_INCREMENT,
  `fechaVenta` date NOT NULL,
  `formaPago` varchar(50) NOT NULL,
  `pedido` int DEFAULT NULL,
  PRIMARY KEY (`numeroVenta`),
  KEY `pedido` (`pedido`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`pedido`) REFERENCES `pedidos` (`numeroPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

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
        
			IF EXISTS (SELECT * FROM empleados WHERE username = _username AND correo=_correo AND curp=_curp) THEN
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

-- Dump completed on 2024-03-06 17:49:05
