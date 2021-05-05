CREATE SCHEMA IF NOT EXISTS `bookstoredb` ;
CREATE TABLE `hibernate_sequence` (
  `sequence_name` varchar(45) NOT NULL,
  `next_val` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `sequence_name` varchar(45) NOT NULL,
  `next_val` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `bookstoredb`.`book` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `book_name` varchar(100) NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `category_idx` (`category_id`),
  CONSTRAINT `category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='attribute about entity [book]';

CREATE TABLE IF NOT EXISTS `bookstore` (
  `store_id` int NOT NULL,
  `store_name` varchar(100) NOT NULL,
  `book_id` int NOT NULL,
  `book_price` decimal(10,2) NOT NULL,
  `city` varchar(45) NOT NULL,
  PRIMARY KEY (`store_id`),
  KEY `book_id_idx` (`book_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT=' bookstores in different cities';

CREATE TABLE `category` (
  `category_id` int NOT NULL,
  `category_name` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='every book belong to category, category may be same or multiple';

