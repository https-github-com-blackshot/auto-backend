-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               8.0.14 - MySQL Community Server - GPL
-- Операционная система:         Win64
-- HeidiSQL Версия:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

set character_set_server='utf8';

-- Дамп структуры базы данных auto_core_db
DROP DATABASE IF EXISTS `auto_core_db`;
CREATE DATABASE IF NOT EXISTS `auto_core_db` 
DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

USE `auto_core_db`;

SET NAMES utf8;

-- Дамп структуры для таблица auto_core_db.feedback
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fio` varchar(128) DEFAULT NULL,
  `content` varchar(1024) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `feedback_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Дамп данных таблицы auto_core_db.feedback: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;

-- Дамп структуры для таблица auto_core_db.rating
DROP TABLE IF EXISTS `rating`;
CREATE TABLE IF NOT EXISTS `rating` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `very_low` int(11) DEFAULT NULL,
  `low` int(11) DEFAULT NULL,
  `medium` int(11) DEFAULT NULL,
  `high` int(11) DEFAULT NULL,
  `very_high` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rating_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Дамп данных таблицы auto_core_db.rating: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;

-- Дамп структуры для таблица auto_core_db.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(128) DEFAULT NULL,
  `nameRu` varchar(128) NOT NULL,
  `nameKz` varchar(128) DEFAULT NULL,
  `nameEn` varchar(128) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(128) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id_uindex` (`id`),
  UNIQUE KEY `role_code_uindex` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Дамп данных таблицы auto_core_db.roles: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Дамп структуры для таблица auto_core_db.service_book
DROP TABLE IF EXISTS `service_book`;
CREATE TABLE IF NOT EXISTS `service_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(128) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `service_book_id_uindex` (`id`),
  UNIQUE KEY `service_book_code_uindex` (`code`),
  KEY `service_book_users_id_fk` (`user_id`),
  CONSTRAINT `service_book_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Дамп данных таблицы auto_core_db.service_book: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `service_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_book` ENABLE KEYS */;

-- Дамп структуры для таблица auto_core_db.service_book_content
DROP TABLE IF EXISTS `service_book_content`;
CREATE TABLE IF NOT EXISTS `service_book_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mechanic_user_id` int(11) DEFAULT NULL,
  `content` varchar(512) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `service_book_id` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `service_book_content_id_uindex` (`id`),
  KEY `service_book_content_users_id_fk` (`mechanic_user_id`),
  KEY `service_book_content_service_book_id_fk` (`service_book_id`),
  CONSTRAINT `service_book_content_service_book_id_fk` FOREIGN KEY (`service_book_id`) REFERENCES `service_book` (`id`),
  CONSTRAINT `service_book_content_users_id_fk` FOREIGN KEY (`mechanic_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Дамп данных таблицы auto_core_db.service_book_content: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `service_book_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_book_content` ENABLE KEYS */;

-- Дамп структуры для таблица auto_core_db.service_maintenance
DROP TABLE IF EXISTS `service_maintenance`;
CREATE TABLE IF NOT EXISTS `service_maintenance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `phone_number` varchar(32) DEFAULT NULL,
  `rating_id` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `service_maintenance_id_uindex` (`id`),
  KEY `service_maintenance_rating_id_fk` (`rating_id`),
  CONSTRAINT `service_maintenance_rating_id_fk` FOREIGN KEY (`rating_id`) REFERENCES `rating` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Дамп данных таблицы auto_core_db.service_maintenance: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `service_maintenance` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_maintenance` ENABLE KEYS */;

-- Дамп структуры для таблица auto_core_db.service_maintenance_feedback_map
DROP TABLE IF EXISTS `service_maintenance_feedback_map`;
CREATE TABLE IF NOT EXISTS `service_maintenance_feedback_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_maintenance_id` int(11) DEFAULT NULL,
  `feedback_id` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `service_maintenance_feedback_map_id_uindex` (`id`),
  KEY `service_maintenance_feedback_map_service_maintenance_id_fk` (`service_maintenance_id`),
  KEY `service_maintenance_feedback_map_feedback_id_fk` (`feedback_id`),
  CONSTRAINT `service_maintenance_feedback_map_feedback_id_fk` FOREIGN KEY (`feedback_id`) REFERENCES `feedback` (`id`),
  CONSTRAINT `service_maintenance_feedback_map_service_maintenance_id_fk` FOREIGN KEY (`service_maintenance_id`) REFERENCES `service_maintenance` (`id`) ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Дамп данных таблицы auto_core_db.service_maintenance_feedback_map: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `service_maintenance_feedback_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_maintenance_feedback_map` ENABLE KEYS */;

-- Дамп структуры для таблица auto_core_db.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(128) NOT NULL,
  `firstname` varchar(128) NOT NULL,
  `lastname` varchar(128) NOT NULL,
  `middlename` varchar(128) NOT NULL,
  `birthdate` timestamp NULL DEFAULT NULL,
  `email` varchar(128) NOT NULL,
  `phone_number` varchar(128) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`),
  UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Дамп данных таблицы auto_core_db.users: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Дамп структуры для таблица auto_core_db.users_roles_map
DROP TABLE IF EXISTS `users_roles_map`;
CREATE TABLE IF NOT EXISTS `users_roles_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_role_map_id_uindex` (`id`),
  KEY `user_role_map_user_id_fk` (`user_id`),
  KEY `user_role_map_role_id_fk` (`role_id`),
  CONSTRAINT `user_role_map_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `user_role_map_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Дамп данных таблицы auto_core_db.users_roles_map: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `users_roles_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_roles_map` ENABLE KEYS */;

-- Дамп структуры для таблица auto_core_db.user_service_maintenance_map
DROP TABLE IF EXISTS `user_service_maintenance_map`;
CREATE TABLE IF NOT EXISTS `user_service_maintenance_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `service_maintenance_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_service_maintenance_map_id_uindex` (`id`),
  KEY `user_service_maintenance_map_service_maintenance_id_fk` (`service_maintenance_id`),
  KEY `user_service_maintenance_map_users_id_fk` (`user_id`),
  CONSTRAINT `user_service_maintenance_map_service_maintenance_id_fk` FOREIGN KEY (`service_maintenance_id`) REFERENCES `service_maintenance` (`id`),
  CONSTRAINT `user_service_maintenance_map_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Дамп данных таблицы auto_core_db.user_service_maintenance_map: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `user_service_maintenance_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_service_maintenance_map` ENABLE KEYS */;

-- Дамп структуры для таблица auto_core_db.working_time
DROP TABLE IF EXISTS `working_time`;
CREATE TABLE IF NOT EXISTS `working_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_weekend` tinyint(1) DEFAULT NULL,
  `star_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `service_maintenance_id` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `working_time_id_uindex` (`id`),
  KEY `working_time_service_maintenance_id_fk` (`service_maintenance_id`),
  CONSTRAINT `working_time_service_maintenance_id_fk` FOREIGN KEY (`service_maintenance_id`) REFERENCES `service_maintenance` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

create user 'auto_core_dbadmin'@'localhost' identified by 'P@ssw0rd';
grant all on auto_core_db.* to 'auto_core_dbadmin'@'localhost';

-- Дамп данных таблицы auto_core_db.working_time: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `working_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `working_time` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
