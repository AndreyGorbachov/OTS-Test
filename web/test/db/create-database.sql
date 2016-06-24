CREATE DATABASE jtest;
USE jtest;
CREATE TABLE employees (
	id					INT NOT NULL AUTO_INCREMENT,
	name				VARCHAR(50) NOT NULL,
	surname				VARCHAR(50) NOT NULL,
	post				VARCHAR(50),
	department			VARCHAR(50),
	PRIMARY KEY (id)
)ENGINE=INNODB;