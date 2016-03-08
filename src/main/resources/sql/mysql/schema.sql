/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.19-log : Database - musictag
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`musictag` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `musictag`;

/*Table structure for table `album` */

DROP TABLE IF EXISTS `album`;

CREATE TABLE `album` (
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
  `album_name` VARCHAR(50) NOT NULL,
  `pk_singer` VARCHAR(32) NOT NULL,
  `release_time` VARCHAR(19) DEFAULT NULL,
  `description` VARCHAR(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `album` */

/*Table structure for table `musictag` */

DROP TABLE IF EXISTS `musictag`;

CREATE TABLE `musictag` (
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
  `pk_song` VARCHAR(32) NOT NULL,
  `song_name` VARCHAR(100) DEFAULT NULL,
  `pk_tag` VARCHAR(32) NOT NULL,
  `tag_name` VARCHAR(50) DEFAULT NULL,
  `ts` CHAR(19) NOT NULL,
  `creator` VARCHAR(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `musictag` */

/*Table structure for table `singer` */

DROP TABLE IF EXISTS `singer`;

CREATE TABLE `singer` (
  `id` BIGINT(32) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `alias` VARCHAR(50) DEFAULT NULL,
  `birthday` VARCHAR(10) DEFAULT NULL,
  `sex` CHAR(1) NOT NULL,
  `pk_country` VARCHAR(32) NOT NULL,
  `detail` VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `singer` */

/*Table structure for table `song` */

DROP TABLE IF EXISTS `song`;

CREATE TABLE `song` (
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
  `song_name` VARCHAR(100) NOT NULL,
  `pk_singer` VARCHAR(32) NOT NULL,
  `pk_album` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `song` */

/*Table structure for table `tag` */

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `create_time` CHAR(19) DEFAULT NULL,
  `creator` VARCHAR(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `tag` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `login_name` VARCHAR(64) DEFAULT NULL,
  `user_name` VARCHAR(64) DEFAULT NULL,
  `password` VARCHAR(255) DEFAULT NULL,
  `salt` VARCHAR(64) DEFAULT NULL,
  `register_date` CHAR(19) DEFAULT NULL,
  `sex` INT(1) DEFAULT NULL,
  `birthday` CHAR(19) DEFAULT NULL,
  `introduction` VARCHAR(200) DEFAULT NULL,
  `avatar_url` VARCHAR(255) DEFAULT NULL,
  `user_type` INT(1) DEFAULT NULL,
  `province` VARCHAR(10) DEFAULT NULL,
  `city` VARCHAR(10) DEFAULT NULL,
  `email` VARCHAR(50) DEFAULT NULL,
  `phone` VARCHAR(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
