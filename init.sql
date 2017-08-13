/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.5.27 : Database - m1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`m1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `m1`;

/*Table structure for table `colinfo` */

DROP TABLE IF EXISTS `colinfo`;

CREATE TABLE `colinfo` (
  `COLID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `TYPE` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `UNIQUE` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `TABLEID` int(11) DEFAULT NULL,
  PRIMARY KEY (`COLID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `colinfo` */

insert  into `colinfo`(`COLID`,`NAME`,`TYPE`,`UNIQUE`,`TABLEID`) values 
(1,'1',NULL,NULL,NULL);

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `DEPT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `FDEPT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DEPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `dept` */

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `JOB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOB_NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `DEPT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `job` */

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `PERSON_ID` int(11) NOT NULL AUTO_INCREMENT,
  `P_NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `INFO` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `DEPT_ID` int(11) DEFAULT NULL,
  `JOB_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `person` */

/*Table structure for table `tableinfo` */

DROP TABLE IF EXISTS `tableinfo`;

CREATE TABLE `tableinfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tableinfo` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
