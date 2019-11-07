--Script 
CREATE DATABASE benchmark;

CREATE TABLE pessoa 
(id int NOT NULL AUTO_INCREMENT, nome varchar(100) NOT NULL, 
sobre_nome varchar(100) NOT NULL, email varchar(150) NOT NULL, 
PRIMARY KEY (id));