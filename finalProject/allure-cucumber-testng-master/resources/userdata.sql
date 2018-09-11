-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.1.41-community - MySQL Community Server (GPL)
-- Операционная система:         Win32
-- HeidiSQL Версия:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных userdata
CREATE DATABASE IF NOT EXISTS `userdata` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `userdata`;

-- Дамп структуры для таблица userdata.emaildata
CREATE TABLE IF NOT EXISTS `emaildata` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(20) NOT NULL DEFAULT 'yuta_yuta@tut.by',
  `moreemails` varchar(100) DEFAULT NULL,
  `subject` varchar(20) NOT NULL DEFAULT 'test',
  `body` varchar(100) NOT NULL DEFAULT 'test test test',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы userdata.emaildata: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `emaildata` DISABLE KEYS */;
INSERT INTO `emaildata` (`id`, `email`, `moreemails`, `subject`, `body`) VALUES
	(1, 'yuta_yuta@tut.by', 'lana_zelenkova@tut.by nika.benz@tut.by', 'test', 'test test test'),
	(2, 'yuta_yuta@tut.by', 'lana_zelenkova@tut.by nika.benz@tut.by', 'subject from DB', 'text body from DB');
/*!40000 ALTER TABLE `emaildata` ENABLE KEYS */;

-- Дамп структуры для таблица userdata.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(25) NOT NULL,
  `domain` varchar(10) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы userdata.user: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `login`, `domain`, `password`) VALUES
	(1, 'zelenkova-sveta', '@bk.ru', 'Benz2503');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
