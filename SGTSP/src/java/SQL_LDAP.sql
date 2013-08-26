-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.63-0ubuntu0.11.10.1


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema saa
--

CREATE DATABASE IF NOT EXISTS saa;
USE saa;

--
-- Definition of table `saa`.`Sistema`
--

DROP TABLE IF EXISTS `saa`.`Sistema`;
CREATE TABLE  `saa`.`Sistema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sigla` varchar(10) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saa`.`Sistema`
--

/*!40000 ALTER TABLE `Sistema` DISABLE KEYS */;
LOCK TABLES `Sistema` WRITE;
INSERT INTO `saa`.`Sistema` VALUES  (1,'saa','Sistema de Autenticacao e Autorização');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Sistema` ENABLE KEYS */;


--
-- Definition of table `saa`.`Usuario`
--

DROP TABLE IF EXISTS `saa`.`Usuario`;
CREATE TABLE  `saa`.`Usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saa`.`Usuario`
--

/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
/* senha = login */;
LOCK TABLES `Usuario` WRITE;
INSERT INTO `saa`.`Usuario` VALUES 
 (1,'Administrador','admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','admin@gmail.com'),
 (2,'Gerente','gerente','98ec4ee87e461aa980d5ef58d68042c4a5b9b1d957bd04eac40f8b2fc582816a','gerente@gmail.com'),
 (3,'Usuario','usuario','9250e222c4c71f0c58d4c54b50a880a312e9f9fed55d5c3aa0b0e860ded99165','usuario@gmail.com');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;


--
-- Definition of table `saa`.`Papel`
--

DROP TABLE IF EXISTS `saa`.`Papel`;
CREATE TABLE  `saa`.`Papel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `Sistema_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Papel_Sistema_id` (`Sistema_id`),
  CONSTRAINT `FK_Papel_Sistema_id` FOREIGN KEY (`Sistema_id`) REFERENCES `Sistema` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `saa`.`Papel`
--

/*!40000 ALTER TABLE `Papel` DISABLE KEYS */;
LOCK TABLES `Papel` WRITE;
INSERT INTO `saa`.`Papel` VALUES 
 (1,'admin','Administrador',1),
 (2,'gerente','Gerente',1),
 (3,'usuario','Usuario comum',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Papel` ENABLE KEYS */;


--
-- Definition of table `saa`.`PapelDoUsuario`
--

DROP TABLE IF EXISTS `saa`.`PapelDoUsuario`;
CREATE TABLE  `saa`.`PapelDoUsuario` (
  `Usuario_id` int(11) NOT NULL,
  `Papel_id` int(11) NOT NULL,
  PRIMARY KEY (`Usuario_id`,`Papel_id`),
  KEY `FK_PapelDoUsuario_Papel_id` (`Papel_id`),
  CONSTRAINT `FK_PapelDoUsuario_Papel_id` FOREIGN KEY (`Papel_id`) REFERENCES `Papel` (`id`),
  CONSTRAINT `FK_PapelDoUsuario_Usuario_id` FOREIGN KEY (`Usuario_id`) REFERENCES `Usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saa`.`PapelDoUsuario`
--

/*!40000 ALTER TABLE `PapelDoUsuario` DISABLE KEYS */;
LOCK TABLES `PapelDoUsuario` WRITE;
INSERT INTO `saa`.`PapelDoUsuario` VALUES 
 (1,1),
 (2,2),
 (3,3);
UNLOCK TABLES;
/*!40000 ALTER TABLE `PapelDoUsuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;