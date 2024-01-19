create database Students;
use Students;

CREATE TABLE `student` (
	`student_id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(45) NOT NULL,
	`email` varchar(45) NOT NULL,
	`university` varchar(45) NOT NULL,
	PRIMARY KEY (`student_id`),
	UNIQUE KEY `student_id_UNIQUE` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1