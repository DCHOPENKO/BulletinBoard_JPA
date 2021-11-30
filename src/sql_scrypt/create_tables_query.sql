CREATE DATABASE bulletin_board;
USE bulletin_board;

CREATE TABLE address
(
address_id INT AUTO_INCREMENT PRIMARY KEY,
country VARCHAR(50) NOT NULL,
city VARCHAR(50) NOT NULL,
street VARCHAR(50) NOT NULL,
street_number INT NOT NULL,
building_number INT,
apartment INT NOT NULL,
version INT NOT NULL
);

CREATE TABLE email
(
email_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
version INT NOT NULL
);

CREATE TABLE author
(
author_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
FK_Author_Address INT NOT NULL,
FK_Author_Email INT NOT NULL,
version INT NOT NULL,
FOREIGN KEY (FK_Author_Address) REFERENCES address(address_id),
FOREIGN KEY (FK_Author_Email) REFERENCES email(email_id)
);

CREATE TABLE phone
(
phone_id INT AUTO_INCREMENT PRIMARY KEY,
country_code VARCHAR(5) NOT NULL,
phone_number VARCHAR(11) NOT NULL,
FK_Author_Phone INT NOT NULL,
version INT NOT NULL,
FOREIGN KEY (FK_Author_Phone) REFERENCES author(author_id)
);

CREATE TABLE category
(
category_id INT AUTO_INCREMENT PRIMARY KEY,
category_type VARCHAR(30) NOT NULL,
version INT NOT NULL
);

CREATE TABLE advert
(
advert_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(20) NOT NULL,
title VARCHAR(255) NOT NULL,
publication_date DATE NOT NULL,
price DECIMAL(19,2) NOT NULL,
FK_Advert_Category INT NOT NULL,
FK_Advert_Author INT NOT NULL,
is_active BOOLEAN NOT NULL, 
version INT NOT NULL,
FOREIGN KEY (FK_Advert_Category) REFERENCES category(category_id),
FOREIGN KEY (FK_Advert_Author) REFERENCES author(author_id)
);

CREATE TABLE matching_ad
(
matching_ad_id INT AUTO_INCREMENT PRIMARY KEY,
key_words VARCHAR(50) NOT NULL,
price_to DECIMAL(19,2) NOT NULL,
price_from DECIMAL(19,2) NOT NULL,
FK_Matching_ad_Author INT NOT NULL,
FK_Matching_ad_Category INT NOT NULL,
is_active BOOLEAN NOT NULL, 
version INT NOT NULL,
FOREIGN KEY (FK_Matching_ad_Category) REFERENCES category(category_id),
FOREIGN KEY (FK_Matching_ad_Author) REFERENCES author(author_id)
);