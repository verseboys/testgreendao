/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.6.38 : Database - testgreedao
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`testgreedao` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `testgreedao`;

/*Table structure for table `father` */

DROP TABLE IF EXISTS `father`;

CREATE TABLE `father` (
  `fateher_id` int(2) NOT NULL AUTO_INCREMENT COMMENT '父亲id',
  `father_name` varchar(2) NOT NULL COMMENT '父亲名字',
  `father_age` int(2) NOT NULL COMMENT '父亲年纪',
  `father_pic` varchar(2) NOT NULL COMMENT '父亲头像',
  PRIMARY KEY (`fateher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `father` */

insert  into `father`(`fateher_id`,`father_name`,`father_age`,`father_pic`) values (1,'黎明',56,'jj');

/*Table structure for table `son` */

DROP TABLE IF EXISTS `son`;

CREATE TABLE `son` (
  `son_id` int(2) NOT NULL AUTO_INCREMENT COMMENT '儿子id',
  `son_name` varchar(2) NOT NULL COMMENT '儿子名字',
  `son_age` int(2) DEFAULT NULL COMMENT '儿子年纪',
  `son_pic` varchar(2) NOT NULL COMMENT '儿子头像',
  `father_id` int(2) NOT NULL COMMENT '父亲id',
  PRIMARY KEY (`son_id`),
  KEY `FK_son` (`father_id`),
  CONSTRAINT `FK_son` FOREIGN KEY (`father_id`) REFERENCES `father` (`fateher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `son` */

insert  into `son`(`son_id`,`son_name`,`son_age`,`son_pic`,`father_id`) values (1,'li',45,'ll',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
