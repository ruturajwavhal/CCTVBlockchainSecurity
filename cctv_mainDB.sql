-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema cctv_video_securing
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ cctv_video_securing;
USE cctv_video_securing;

--
-- Table structure for table `cctv_video_securing`.`admin_info`
--

DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `username` varchar(45) NOT NULL default '',
  `password` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cctv_video_securing`.`admin_info`
--

/*!40000 ALTER TABLE `admin_info` DISABLE KEYS */;
INSERT INTO `admin_info` (`username`,`password`) VALUES 
 ('admin','a');
/*!40000 ALTER TABLE `admin_info` ENABLE KEYS */;


--
-- Table structure for table `cctv_video_securing`.`file_info`
--

DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info` (
  `sr` varchar(45) NOT NULL default '',
  `username` varchar(45) NOT NULL default '',
  `filename` varchar(45) NOT NULL default '',
  `date-time` varchar(45) NOT NULL default '',
  `hashkey` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`sr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cctv_video_securing`.`file_info`
--

/*!40000 ALTER TABLE `file_info` DISABLE KEYS */;
INSERT INTO `file_info` (`sr`,`username`,`filename`,`date-time`,`hashkey`) VALUES 
 ('1','r','bicycle.mp4','20-12-2024/ 6:30:24 PM','20b39aadffe2c701dff1c42c92148ae3'),
 ('10','r','football.mp4','20-12-2024/ 8:3:19 PM','e8685eaab91c1ca91e9e4c1ac9f973ed'),
 ('11','r','leopard.mp4','20-12-2024/ 8:4:15 PM','fda3637e70764bac6496bb3f0fa19385'),
 ('2','r','bullet.mp4','20-12-2024/ 6:30:37 PM','31c21335b633790512c1c493dec4efe9'),
 ('3','r','butterfly.mp4','20-12-2024/ 6:30:49 PM','003ba88810eda8d0dfff38babdef0d5f'),
 ('4','r','car speedometer.mp4','20-12-2024/ 6:31:1 PM','7ca2bf2b40d3ce4467be755540114a96'),
 ('5','r','cat.mp4','20-12-2024/ 6:31:11 PM','eb0d74a28b171a467b084d4ae73d7497'),
 ('6','r','cricket ground.mp4','20-12-2024/ 6:32:39 PM','675e6bd8da0da224b4a75f04b5a7bbe3'),
 ('7','r','dog.mp4','20-12-2024/ 6:32:54 PM','89d0453b14353b2390c0d99088ebe14f'),
 ('8','r','parrot.mp4','20-12-2024/ 8:1:40 PM','df825f1255ba3cd1810399bf8eed617c'),
 ('9','r','rose.mp4','20-12-2024/ 8:2:41 PM','00fc4eae2f1e283562da6e01efa682ac');
/*!40000 ALTER TABLE `file_info` ENABLE KEYS */;


--
-- Table structure for table `cctv_video_securing`.`registration_info`
--

DROP TABLE IF EXISTS `registration_info`;
CREATE TABLE `registration_info` (
  `name` varchar(45) NOT NULL default '',
  `mobile` varchar(45) NOT NULL default '',
  `email` varchar(45) NOT NULL default '',
  `username` varchar(45) NOT NULL default '',
  `password` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cctv_video_securing`.`registration_info`
--

/*!40000 ALTER TABLE `registration_info` DISABLE KEYS */;
INSERT INTO `registration_info` (`name`,`mobile`,`email`,`username`,`password`) VALUES 
 ('Ruturaj Wavhal','0881083191','ruturajwavhal10@gmail.com','r','1');
/*!40000 ALTER TABLE `registration_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
