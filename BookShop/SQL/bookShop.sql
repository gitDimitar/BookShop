CREATE DATABASE IF NOT EXISTS `bookShop`;

USE `bookShop`;

/*Table structure for table `bookshop` */

DROP TABLE IF EXISTS `userLog`;

	
	DROP TABLE IF EXISTS `userInfo`;

	CREATE TABLE `userInfo`(
	userID int AUTO_INCREMENT,
	`userName` varchar(20) UNIQUE,
	`userPassword` varchar(20) NOT NULL,
	`firstName` varchar(20) NOT NULL,
	`lastName` varchar(20) NOT NULL,
	`address1` varchar(25) NOT NULL,
	`address2` varchar(20) NOT NULL,
	`city` varchar(20) NOT NULL,
	`country` varchar(30) NOT NULL,
	`phone` varchar(30) NOT NULL,
	`dob` varchar(20) NOT NULL,
	`adminb` boolean NOT NULL default 0,
	PRIMARY KEY (userID));
	
	INSERT INTO `userInfo`(`userName`, `userPassword`,`firstName`, `lastName`,`address1` , `address2` , `city` , `country` , `phone` , `dob`,  `adminb`) 
	values 	("Bob123" , "123qwe","Bob", "White", "35 Rivington Lane" , "Dublin Road " , "Dundalk", "Ireland" , "00353867469936", '1982-08-15', 0),
			("vinnie1" , "asdqwe","Vincent", "Chase", "115 Hollywood Lane" , "Malibu Avenu " , "Los Angelis", "United States" , "0051749012349712", '1979-10-08', 0),
			("dimitar" , "123asd","Dimitar", "Papazikov", "11 Snow White" , "Fairy Street " , "Dundalk", "Ireland" , "00353861231123", '1993-03-25', 1);
	
	DROP TABLE IF EXISTS `books`;

	CREATE TABLE books(
 	bookID INTEGER AUTO_INCREMENT PRIMARY KEY,
 	bookName VARCHAR(60) NOT NULL,
 	author VARCHAR(30) NOT NULL,
	quantity int(4) NOT NULL,
	genre VARCHAR(20),
	price double(10,2),
	image varchar(50) default 'no image');
	
	INSERT INTO `books`(`bookName`, `author`, `quantity` , `genre`, `price`,image)
	values 	('Day of the Dragon' , 'Richard A. Knaack', 15 , 'Fiction' ,7.99,'css/day-of-the-dragon.jpg'), 
			('Tides of War' , 'Christie Golden', 10 , 'Fiction' , 10.99,'css/tides-of-war.jpg'),
			('Rise of the Horde' , 'Christie Golden', 28 , 'Fiction' , 5.99,'css/rise-of-the-horde.jpg');
			
	DROP TABLE IF EXISTS `orders`;
	
	CREATE TABLE `orders`(
	`orderID` INT AUTO_INCREMENT,
	`userID` INT(10) NOT NULL,
	PRIMARY KEY (`orderID`),
	FOREIGN KEY (userID) REFERENCES userInfo(userID));
	
	CREATE TABLE orderItems (
	lineID int AUTO_INCREMENT PRIMARY KEY,
	orderID int,
	bookID int,
	quantity int(4) not null,
	FOREIGN KEY (bookID) REFERENCES books(bookID) ON DELETE CASCADE,
	FOREIGN KEY (orderID) REFERENCES orders(orderID)
	ON DELETE CASCADE);
		
	
