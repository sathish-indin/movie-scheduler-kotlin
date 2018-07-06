CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `genre` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `movieplay` (
  `playid` int(11) NOT NULL AUTO_INCREMENT,
  `playtime` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `upvote` int(11) DEFAULT NULL,
  `movieid` int(11) DEFAULT NULL,
  PRIMARY KEY (`playid`),
  KEY `FKorbhxh4hr880kgbe8600npbas` (`movieid`),
  CONSTRAINT `FKorbhxh4hr880kgbe8600npbas` FOREIGN KEY (`movieid`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
