/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.18-MariaDB : Database - database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fudbal` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `fudbal`;



DROP TABLE IF EXISTS `Administrator`;

CREATE TABLE `Administrator` (
  `AdministratorID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(30) NOT NULL,
  `Prezime` VARCHAR(30) NOT NULL,
  `Username` VARCHAR(30) NOT NULL,
  `Password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`AdministratorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Administrator` VALUES 
(1,'Kosta','Mugosa','kosta','kosta123'),
(2,'Aleksandar','Simjanoski','aleksandar','aleksandar');



DROP TABLE IF EXISTS `Fudbaler`;

CREATE TABLE `Fudbaler` (
  `FudbalerID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ImeFudbalera` VARCHAR(30) NOT NULL,
  `PrezimeFudbalera` VARCHAR(30) NOT NULL,
  `Godine` INT(7) NOT NULL,
  PRIMARY KEY (`FudbalerID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Fudbaler` VALUES 
(1,'Filip', 'Gavranovic',24),
(2,'Jovan', 'Colic', 33),
(3,'Uros', 'Lekic', 21),
(4,'Marko', 'Vujin', 22),
(5,'Momir', 'Ilic', 26),
(6,'Ruben', 'Marchain', 25),
(7,'Gonzalo', 'Vargas', 31),
(8,'Raul', 'Entrerrios', 21),
(9,'Stefano', 'Arcieri', 19),
(10,'Andrea', 'Parisini', 24),
(11,'Nicolo', 'Dantino', 26),
(12,'Andreas', 'Wolff', 27),
(13,'Simon', 'Ernst', 28),
(14,'Philipp', 'Weber', 29),
(15,'Nikola', 'Karabatic', 23),
(16,'Luka', 'Karabatic', 21),
(17,'Dika', 'Hansen', 20),
(18,'Mikel', 'Hansen', 26),
(19,'Niklas', 'Landin', 25),
(20,'Lasse', 'Svan', 22);




DROP TABLE IF EXISTS `Tim`;

CREATE TABLE `Tim` (
  `TimID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivTima` VARCHAR(50)  NOT NULL,
  PRIMARY KEY (`TimID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT  INTO `Tim` VALUES 
(1,'Zvezda'),
(2,'Partizan'),
(3,'Radnicki Nis'),
(4,'Balkan Mirijevo'),
(5,'OFK Beograd');


DROP TABLE IF EXISTS `Igrac`;

CREATE TABLE `Igrac` (
  `TimID` BIGINT(10) UNSIGNED NOT NULL,
  `BrojNaDresu` INT(7) NOT NULL,
  `Pozicija` VARCHAR(50) NOT NULL,
  `FudbalerID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`TimID`,`BrojNaDresu`),
  CONSTRAINT `fk_tim_id` FOREIGN KEY (`TimID`) REFERENCES `Tim` (`TimID`) ON DELETE CASCADE,
  CONSTRAINT `fk_fudbaler_id` FOREIGN KEY (`FudbalerID`) REFERENCES `Fudbaler` (`FudbalerID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Igrac` VALUES 
(1,1,'Golman', 1),
(1,2,'Stoper', 2),
(1,3,'Bek', 3),
(1,4,'Krilo', 4),
(1,5,'Spic', 5),
(2,1,'Golman', 6),
(2,2,'Stoper', 7),
(2,3,'Bek', 8),
(2,4,'Krilo', 9),
(2,5,'Spic', 10),
(3,1,'Golman', 11),
(3,2,'Stoper', 12),
(3,3,'Bek', 13),
(3,4,'Krilo', 14),
(3,5,'Spic', 15),
(4,1,'Golman', 16),
(4,2,'Stoper', 17),
(4,3,'Bek', 18),
(4,4,'Krilo', 19),
(4,5,'Spic', 20);





DROP TABLE IF EXISTS `Turnir`;

CREATE TABLE `Turnir` (
  `TurnirID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NazivTurnira` VARCHAR(50)  NOT NULL,
  `DatumOd` DATE NOT NULL,
  `DatumDo` DATE NOT NULL,
  `Grad` VARCHAR(50) NOT NULL,
  `AdministratorID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`TurnirID`),
  CONSTRAINT `fk_admin_id` FOREIGN KEY (`AdministratorID`) REFERENCES `Administrator` (`AdministratorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT  INTO `Turnir` VALUES 
(1,'Letnji turnir', '2023-06-25', '2023-06-30', 'Beograd', 1);


DROP TABLE IF EXISTS `Utakmica`;

CREATE TABLE `Utakmica` (
  `TurnirID` BIGINT(10) UNSIGNED NOT NULL,
  `RbUtakmice` INT(7) UNSIGNED NOT NULL,
  `BrojGolovaPrvi` INT(7),
  `BrojGolovaDrugi` INT(7),
  `Pobednik` VARCHAR(50) NOT NULL,
  `PrviTimID` BIGINT(10) UNSIGNED NOT NULL,
  `DrugiTimID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`TurnirID`,`RbUtakmice`),
  CONSTRAINT `fk_turnir_id` FOREIGN KEY (`TurnirID`) REFERENCES `Turnir` (`TurnirID`) ON DELETE CASCADE,
  CONSTRAINT `fk_prvi_id` FOREIGN KEY (`PrviTimID`) REFERENCES `Tim` (`TimID`),
  CONSTRAINT `fk_drugi_id` FOREIGN KEY (`DrugiTimID`) REFERENCES `Tim` (`TimID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Utakmica` VALUES 
(1, 1, 3, 0, 'Partizan', 2, 1),
(1, 2, 0, 2, 'Balkan Mirijevo', 3, 4);






/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
