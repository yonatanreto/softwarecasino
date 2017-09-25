-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: casino
-- ------------------------------------------------------
-- Server version	5.5.54-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `area_de_trabajos`
--

DROP TABLE IF EXISTS `area_de_trabajos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area_de_trabajos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_de_trabajos`
--

LOCK TABLES `area_de_trabajos` WRITE;
/*!40000 ALTER TABLE `area_de_trabajos` DISABLE KEYS */;
INSERT INTO `area_de_trabajos` VALUES (1,'01','PLANTA 1');
/*!40000 ALTER TABLE `area_de_trabajos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `codigo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (1,'GERENTE','01'),(2,'INGENIERO DE SISTEMAS','02');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuracion_impresion_orden`
--

DROP TABLE IF EXISTS `configuracion_impresion_orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuracion_impresion_orden` (
  `id` int(11) NOT NULL,
  `consecutivo_orden` int(11) DEFAULT NULL,
  `encabezado_impresion_orden` varchar(200) DEFAULT NULL,
  `piedepagina_impresion_orden` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuracion_impresion_orden`
--

LOCK TABLES `configuracion_impresion_orden` WRITE;
/*!40000 ALTER TABLE `configuracion_impresion_orden` DISABLE KEYS */;
INSERT INTO `configuracion_impresion_orden` VALUES (1,27,' BAUCHE PARA RESTAURANTE',' VALIDO POR UNICA OCASION');
/*!40000 ALTER TABLE `configuracion_impresion_orden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(50) NOT NULL,
  `tipo_documento` varchar(45) DEFAULT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `apellido1` varchar(50) DEFAULT NULL,
  `apellido2` varchar(50) DEFAULT NULL,
  `area_de_trabajo` int(11) DEFAULT NULL,
  `cargo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cedula_UNIQUE` (`cedula`),
  KEY `area_de_trabajo_idx` (`area_de_trabajo`),
  KEY `cargo_idx` (`cargo`),
  CONSTRAINT `area_de_trabajo` FOREIGN KEY (`area_de_trabajo`) REFERENCES `area_de_trabajos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cargo` FOREIGN KEY (`cargo`) REFERENCES `cargos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'7938103','CE','Yonatan ','Reyes','Torres',1,1),(2,'73196817','CC','FERNANDO ALBERTO','GUZMAN','PAJARO',1,2);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenes`
--

DROP TABLE IF EXISTS `ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordenes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` int(11) NOT NULL,
  `estado` int(11) DEFAULT '0',
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `empleado` int(11) NOT NULL,
  `restaurante` int(11) NOT NULL,
  `usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `empleado_idx` (`empleado`),
  KEY `restaurante_idx` (`restaurante`),
  KEY `usuario_idx` (`usuario`),
  CONSTRAINT `empleado` FOREIGN KEY (`empleado`) REFERENCES `empleados` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `restaurante` FOREIGN KEY (`restaurante`) REFERENCES `restaurantes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usuario` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
INSERT INTO `ordenes` VALUES (3,1,0,'2017-09-10','21:33:03',1,6,1),(4,2,0,'2017-09-10','21:34:09',1,6,1),(5,3,0,'2017-09-10','21:40:01',1,6,1),(6,4,0,'2017-09-10','21:47:01',1,6,1),(7,5,0,'2017-09-10','21:49:41',1,6,1),(8,6,0,'2017-09-11','22:07:11',1,6,1),(9,7,0,'2017-09-11','22:16:34',1,6,1),(10,8,0,'2017-09-11','22:16:39',1,6,1),(11,9,0,'2017-09-11','22:18:58',1,6,1),(12,10,0,'2017-09-11','22:19:04',1,7,1),(13,11,0,'2017-09-11','22:30:11',1,6,1),(14,12,0,'2017-09-11','22:33:17',1,6,1),(15,13,0,'2017-09-11','22:35:53',1,7,1),(16,14,0,'2017-09-11','22:36:59',1,6,1),(17,15,0,'2017-09-11','22:38:28',1,8,1),(18,16,0,'2017-09-11','22:56:32',1,8,1),(19,17,0,'2017-09-12','00:03:37',1,7,1),(20,18,0,'2017-09-12','00:05:15',1,24,1),(21,19,0,'2017-09-12','00:10:50',1,7,1),(22,20,0,'2017-09-12','00:16:50',1,6,1),(23,21,0,'2017-09-12','00:19:07',1,6,1),(24,22,0,'2017-09-12','23:47:45',1,9,1),(25,23,0,'2017-09-20','21:54:34',1,9,1),(26,24,0,'2017-09-20','21:56:34',1,24,1),(27,25,0,'2017-09-23','11:49:01',2,25,1),(28,26,0,'2017-09-23','11:49:47',1,7,1);
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurantes`
--

DROP TABLE IF EXISTS `restaurantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurantes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `nit` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurantes`
--

LOCK TABLES `restaurantes` WRITE;
/*!40000 ALTER TABLE `restaurantes` DISABLE KEYS */;
INSERT INTO `restaurantes` VALUES (6,'BROADWAY','12345'),(7,'CASINO 2','321212'),(8,'Restaurante 2','5544433'),(9,'REstaurante 3','234413'),(23,'Restaurante 4','qwqwqw'),(24,'3232322','22222'),(25,'RESTAURANTE LA MOSCA ELEGANTE','12121212121');
/*!40000 ALTER TABLE `restaurantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin','ADMINISTRADOR'),(3,'Yonatan','123','LIMITADO'),(5,'asdasdas','asd','LIMITADO');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'casino'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-25 17:37:32
