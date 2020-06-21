DROP SCHEMA IF EXISTS `one-to-many`;

CREATE SCHEMA `one-to-many`;

use `one-to-many`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(128) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO user(id, first_name, last_name,email)
VALUES('1','akmal','makhmudov','aki@gmail.com');

INSERT INTO user(id, first_name, last_name,email)
VALUES('2','firdavs','mutalipov','firdavs@gmail.com');

DROP TABLE IF EXISTS `Countries`;

CREATE TABLE `Countries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `visit` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`user_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO Countries(id, name,picture,visit,user_id)
VALUES('1','South Korea','pic url','2020.02.23','1');
INSERT INTO Countries(id, name,picture,visit,user_id)
VALUES('2','South Korea','pic url','2020.02.23','2');

DROP TABLE IF EXISTS `Cities`;

CREATE TABLE `Cities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `visit` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  KEY `FK_USER_idx` (`user_id`),
  CONSTRAINT `FK_USER` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

INSERT INTO Cities(id, name,picture,visit,user_id)
VALUES('1','Seoul','pic url','2020.02.24','1');
INSERT INTO Cities(id, name,picture,visit,user_id)
VALUES('2','Seoul','pic url','2020.02.24','2');

DROP TABLE IF EXISTS `Airports`;
CREATE TABLE `Airports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `visit` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  

  
  KEY `FK_Airports_idx` (`user_id`),
  
  CONSTRAINT `FK_Airports` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


INSERT INTO Airports(id, name,picture,visit,user_id)
VALUES('1','Inch AIport','pic url','2020.02.23','1');
INSERT INTO Airports(id, name,picture,visit,user_id)
VALUES('2','Inch AIport','pic url','2020.02.23','2');


DROP TABLE IF EXISTS `hotels`;

CREATE TABLE `hotels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `visit` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
 
  
  KEY `FK_hotels_idx` (`user_id`),
  
  CONSTRAINT `FK_hotels` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


INSERT INTO hotels(id, name,picture,visit,user_id)
VALUES('1','Silla','pic url','2020.02.23','1');
INSERT INTO hotels(id, name,picture,visit,user_id)
VALUES('2','Hamilton','pic url','2020.02.23','2');





DROP TABLE IF EXISTS `Restaurants`;

CREATE TABLE `Restaurants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `visit` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  
  KEY `FK_Restaurants_idx` (`user_id`),
  
  CONSTRAINT `FK_Restaurants` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO Restaurants(id, name,picture,visit,user_id)
VALUES('1','King Kebab','pic url','2020.02.25','1');
INSERT INTO Restaurants(id, name,picture,visit,user_id)
VALUES('2','Sushi','pic url','2020.02.24','2');


DROP TABLE IF EXISTS `Culture`;

CREATE TABLE `Culture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `visit` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  
  
  KEY `FK_Culture_idx` (`user_id`),
  
  CONSTRAINT `FK_Culture` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO Culture(id, name,picture,visit,user_id)
VALUES('1','Namsan Tower','pic url','2020.02.24','1');
INSERT INTO Culture(id, name,picture,visit,user_id)
VALUES('2','Lottee Tower','pic url','2020.02.24','2');



DROP TABLE IF EXISTS `ShoppingHall`;

CREATE TABLE `ShoppingHall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `visit` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  
  
  KEY `FK_ShoppingHall_idx` (`user_id`),
  
  CONSTRAINT `FK_ShoppingHall` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO ShoppingHall(id, name,picture,visit,user_id)
VALUES('1','Meong dong','pic url','2020.02.27','1');
INSERT INTO ShoppingHall(id, name,picture,visit,user_id)
VALUES('2','Dongdemun','pic url','2020.02.26','2');

DROP TABLE IF EXISTS `Atttraction`;

CREATE TABLE `Atttraction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `visit` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  
  
  KEY `FK_Atttraction_idx` (`user_id`),
  
  CONSTRAINT `FK_Atttraction` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO Atttraction(id, name,picture,visit,user_id)
VALUES('1','children grand park','pic url','2020.02.28','1');
INSERT INTO Atttraction(id, name,picture,visit,user_id)
VALUES('2','children grand park','pic url','2020.02.29','2');
