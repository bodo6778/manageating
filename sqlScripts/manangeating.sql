CREATE DATABASE IF NOT EXISTS `restaurant`;
USE `restaurant`;

--
-- Table structure for table `employee`
--


DROP TABLE IF EXISTS `users_roles`;
DROP TABLE IF EXISTS `listaProdus`;
DROP TABLE IF EXISTS `produs`;
DROP TABLE IF EXISTS `comanda`;
DROP TABLE IF EXISTS `masa`;
DROP TABLE IF EXISTS `staff`;

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE staff (
  idstaff int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `email` varchar(50) NOT NULL,
  nume varchar(45) DEFAULT NULL,
  prenume varchar(45) DEFAULT NULL,
  nrcomlivrate int(11) DEFAULT NULL,
  PRIMARY KEY (idstaff)
);

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`role_id`),
  
  KEY `FK_ROLE_idx` (`role_id`),
  
  CONSTRAINT `FK_STAFF_05` FOREIGN KEY (`user_id`) 
  REFERENCES `staff` (`idstaff`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;



CREATE TABLE masa (
	idmasa int NOT NULL AUTO_INCREMENT,
    locuri int,
    PRIMARY KEY (idmasa)
);



CREATE TABLE comanda (
  idcomanda int(11) NOT NULL AUTO_INCREMENT,
  idstaff int(11) NOT NULL,
  idmasa int(11) NOT NULL,
  datacomanda datetime DEFAULT NULL,
  total int DEFAULT 0,
  finalizata boolean DEFAULT FALSE,
  PRIMARY KEY (idcomanda),
  FOREIGN KEY (idmasa) 
	references masa(idmasa) on delete cascade,
  FOREIGN KEY (idstaff) 
	references staff(idStaff) on delete cascade
);



CREATE TABLE produs (
  idprodus int NOT NULL AUTO_INCREMENT,
  nume varchar(20) NOT NULL,
  tip varchar(20) NOT NULL ,
  cantitate varchar(10) NOT NULL,
  pret int NOT NULL,
  popularitate int DEFAULT 0,
  descriere varchar(100),
  PRIMARY KEY (idprodus)
);



CREATE TABLE listaProdus (
  idlistaProdus int NOT NULL AUTO_INCREMENT,
  idcomanda int NOT NULL,
  idprodus int NOT NULL,
  cantitate int DEFAULT 1,
  PRIMARY KEY (idlistaProdus),
  FOREIGN KEY (idcomanda) 
	references comanda(idcomanda) on delete cascade,
  FOREIGN KEY (idprodus) 
	references produs(idprodus) on delete cascade
);

--
-- Data for table `restaurant`
--



INSERT INTO produs VALUES 

    (1,'Cartofi prajiti','garnitura','250g',15,0,'Cartofi cu sare'),
	(2,'Cola','Suc','0.5L',5,0,'Bautura carbogazoasa'),
	(3,'Fanta','Suc','0.5L',5,0,'Bautura carbogazoasa'),
	(4,'Sprite','Suc','0.5L',5,0,'Bautura carbogazoasa'),
	(5,'Pepsi','Suc','0.5L',5,0,'Bautura carbogazoasa'),
	(6,'7Up','Suc','0.5L',5,0,'Bautura carbogazoasa'),
	(7,'Mirinda','suc','0.5L',5,0,'Bautura carbogazoasa'),
	(8,'Dorna','Apa plata','0.5L',3,0,'Bautura necarbogazoasa'),
	(9,'Borsec','Apa minerala','0.5L',2,0,'Bautura carbogazoasa'),
	(10,'Zizin','Apa plata','0.5L',2,0,'Bautura necarbogazoasa'),
	(11,'Heineken','Bere','0.5L',8,0,'Bautura alcoolica'),
	(12,'Skol','Bere','0.5L',8,0,'Bautura alcoolica'),
	(13,'Tuborg','Bere','0.5L',9,0,'Bautura alcoolica'),
	(14,'Fuzetea','Suc','0.5L',5,0,'Bautura necarbogazoasa'),
	(15,'Prigat','Suc','0.5L',5,0,'Bautura necarbogazoasa'),
	(16,'B52','Shot','0.03L',10,0,'Bautura spirtoasa'),
	(17,'Godfather','Shot','0.03L',10,0,'Bautura spirtoasa'),
	(18,'Blowjob','Shot','0.03L',10,0,'Bautura spirtoasa'),
	(19,'Sangrita','Shot','0.03L',10,0,'Bautura spirtoasa'),
    (20,'Burning Cherry','Shot','0.03L',10,0,'Bautura spirtoasa'),
	(21,'Kamikaze','Shot','0.03L',10,0,'Bautura spirtoasa'),
	(22,'Cotnari','Vin','0.7L',20,0,'Bautura alcoolica'),
    (23,'Sex on the beach','Cocktail','0.3L',12,0,'Bautura alcoolica'),
    (24,'Old Cuban','Cocktail','0.3L',12,0,'Bautura alcoolica'),
     (25,'Carbonara','Paste','300g',25,0,'Spaghetti'),
    (26,'Bolognese','Paste','300g',25,0,'Spaghetti'),
    (27,'Salata cu creveti','Salate','250g',20,0,'Contine alergeni'),
    (28,'Salata Taraneasca','Salate','300g',20,0,'Contine alergeni'),
    (29,'Salata Bulgareasca','Salate','250g',20,0,'Contine alergeni'),
    (30,'Piure de cartofi','garnitura','250g',10,0,'Nu contine alergeni'),
    (31,'Mamaliga','garnitura','150g',5,0,'Polenta:))'),
    (32,'Supa de legume','Supe','250g',13,0,'Crema'),
    (33,'Salata de linte','Supe','250g',13,0,'Crema'),
    (34,'Big King XXL','Burgeri','300g',10,0,'Extra Large'),
    (35,'Double Steakhouse','Burgeri','300g',10,0,'Extra Pleasure'),
    (36,'Pepper King','Burgeri','350g',13,0,'Spicy'),
    (37,'Frigarui de porc','Friptura','250g',7,0,'Gratar'),
    (38,'Cotlet de porc','Friptura','450g',20,0,'Gratar'),
    (39,'Rata crocanta','Friptura','350g',50,0,'Cu sos de prune'),
    (40,'Frigarui de pui','Friptura','250g',15,0,'Gratar'),
    (41,'Muschi de vita','Friptura','350g',35,0,'Cu sos de trufe'),
    (42,'Capriciosa','Pizza','450g',22,0,'Blat pufos'),
    (43,'Pollo','Pizza','450g',22,0,'Blat pufos'),
    (44,'Quattro stagioni','Pizza','450g',22,0,'Blat pufos'),
    (45,'Diavola','Pizza','450g',22,0,'Blat pufos'),
    (46,'Somon la gratar','Peste','200g',17,0,'Garnitura inclusa'),
    (47,'Dorada la gratar','Peste','200g',17,0,'Garnitura inclusa'),
    (48,'Inele de calamar','Peste','200g',27,0,'Garnitura inclusa'),
    (49,'Crap prajit','Peste','200g',17,0,'Garnitura inclusa'),
    (50,'Sashimi','Peste','200g',23,0,'5 buc');




INSERT INTO masa VALUES
	(1,4),
    (2,4),
    (3,4),
    (4,4),
    (5,6),
    (6,6),
    (7,6),
    (8,6),
    (9,2),
    (10,2),
    (11,2),
    (12,2),
    (13,8),
    (14,8),
    (15,8),
    (16,8);



INSERT INTO staff VALUES
	(1, 'mihai', '$2a$10$mOhk.IsJwZpuenhznpRyyuRauiXHT0UbFcPUAhuglcvWfL7MUjzdK','mihai@email.com','Popescu','Mihai',0),
    (2, 'adrian', '$2a$10$mOhk.IsJwZpuenhznpRyyuRauiXHT0UbFcPUAhuglcvWfL7MUjzdK','adrian@email.com','Ionescu','Adrian',0),
    (3, 'bogdan', '$2a$10$mOhk.IsJwZpuenhznpRyyuRauiXHT0UbFcPUAhuglcvWfL7MUjzdK','bogdan@email.com','Marinescu','Bogdan',0);
   # (4,'Vasile','Andreea',0,'andreea123'),
   # (5,'Matei','Ana',0,'ana123'),
   # (6,'Neagu','George',0,'george123'),
   #	(7,'Macovei','Catalin',0,'catalin123'),
   # (8,'Dragomir','Laura',0,'laura123'),
   # (9,'Luca','Daniela',0,'daniela123'),
   # (10,'Marin','Andrei',0,'andrei123'),
   # (11,'Anghel','Laurentiu',0,'laurentiu123'),
   # (12,'Dragan','Mihaela',0,'mihaela123');
    
INSERT INTO `role` (name)
VALUES 
('ROLE_CHELNER'),('ROLE_ADMIN');    
    
INSERT INTO `users_roles` (user_id,role_id)
VALUES 
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 2)  ;
    
    
