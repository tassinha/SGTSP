-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.28


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema slcl
--

CREATE DATABASE IF NOT EXISTS sgtsp;
USE sgtsp;



--
-- Definition of table `papel`
--

DROP TABLE IF EXISTS `Papel`;
CREATE TABLE `Papel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `nome` varchar(20) NOT NULL,
  `Sistema_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4952166536D6BDF` (`Sistema_id`),
  CONSTRAINT `FK4952166536D6BDF` FOREIGN KEY (`Sistema_id`) REFERENCES `sistema` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `papel`
--

/*!40000 ALTER TABLE `Papel` DISABLE KEYS */;
INSERT INTO `Papel` (`id`,`descricao`,`nome`,`Sistema_id`) VALUES 
 (1,'Coordenador','Coordenador',2),
 (2,'Professor','Professor',2),
 (3,'Administrador','Administrador',2);
/*!40000 ALTER TABLE `Papel` ENABLE KEYS */;


--
-- Definition of table `papeldousuario`
--

DROP TABLE IF EXISTS `PapelDoUsuario`;
CREATE TABLE `PapelDoUsuario` (
  `Papel_id` int(11) NOT NULL,
  `Usuario_id` int(11) NOT NULL,
  KEY `FKE8008D5D7A46405F` (`Usuario_id`),
  KEY `FKE8008D5DAAFD969F` (`Papel_id`),
  CONSTRAINT `FKE8008D5DAAFD969F` FOREIGN KEY (`Papel_id`) REFERENCES `papel` (`id`),
  CONSTRAINT `FKE8008D5D7A46405F` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `papeldousuario`
--

INSERT INTO `PapelDoUsuario` (`Papel_id`,`Usuario_id`) VALUES 
 (2,1),
 (3,1),
 (4,2),
 (5,3);
/*!40000 ALTER TABLE `PapelDoUsuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `PapelDoUsuario` ENABLE KEYS */;


--
-- Definition of table `sistema`
--

DROP TABLE IF EXISTS `Sistema`;
CREATE TABLE `Sistema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sistema`
--

/*!40000 ALTER TABLE `Sistema` DISABLE KEYS */;
INSERT INTO `Sistema` (`id`,`descricao`,`sigla`) VALUES 
 (2,'Sistema de Gerenciamento de Troca e Substituição de Professores','SGTSP');
/*!40000 ALTER TABLE `Sistema` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `Usuario`;
CREATE TABLE `Usuario` (
  `DTYPE` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `login` varchar(30) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `papel_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5B4D8B0EAAFD969F` (`papel_id`),
  CONSTRAINT `FK5B4D8B0EAAFD969F` FOREIGN KEY (`papel_id`) REFERENCES `Papel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` (`DTYPE`,`id`,`email`,`login`,`nome`,`senha`,`papel_id`) VALUES 
('Professor',2,'testerson@teste.com','testerson','Testerson Teste','teste123',2),
('Professor',3,'testelvina@teste.com','testelvina','Testelvina Teste','teste345',2),
('Coordenador',4,'testelvaldo@teste.com','testelvaldo','Testelvaldo Teste','teste234',1),
('Administrador',5,'admin@admin.com','admin','Administrador do Sistema','admin123',3);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

