CREATE DATABASE librarydb;
USE librarydb;

CREATE TABLE user (
id_user INT NOT NULL AUTO_INCREMENT, 
name VARCHAR(45),
surname VARCHAR(45), 
address VARCHAR(45), 
email VARCHAR(45),
password VARCHAR(45),
nLoan INT, 
PRIMARY KEY(id_user)
);

CREATE TABLE book (
id_book INT NOT NULL AUTO_INCREMENT, 
title VARCHAR(45),
author VARCHAR(45), 
quantity INT, 
editor VARCHAR(45),
position VARCHAR(45),
PRIMARY KEY(id_book)
);

CREATE TABLE loan (
id_loan INT NOT NULL AUTO_INCREMENT, 
id_user INT NOT NULL,
id_book INT NOT NULL, 
assignment_date VARCHAR(45), 
expiration_date VARCHAR(45),
state VARCHAR(45),
PRIMARY KEY(id_loan),
FOREIGN KEY (id_user) REFERENCES user(id_user),
FOREIGN KEY (id_book) REFERENCES book(id_book)
);

CREATE TABLE profile (
id_profile INT NOT NULL AUTO_INCREMENT, 
type VARCHAR(45),
PRIMARY KEY(id_profile)
);


CREATE TABLE role (
id_role INT NOT NULL AUTO_INCREMENT, 
id_user INT NOT NULL,
id_profile INT NOT NULL, 
PRIMARY KEY (id_role),
FOREIGN KEY (id_user) REFERENCES user(id_user),
FOREIGN KEY (id_profile) REFERENCES book(id_profile)
);

INSERT INTO User(
name, 
surname, 
address, 
email, 
password,
nLoan)VALUES(
'Alfio',
'Rossi',
'via roma 10',
'alfio@gmail.com',
'prova',
0);


INSERT INTO User(
name, 
surname, 
address, 
email, 
password)VALUES(
'Gimmy',
'King',
'via tuscolana 3',
'gimmy@gmail.com',
'prova');


INSERT INTO User(
name, 
surname, 
address, 
email, 
password)VALUES(
'Franco',
'Tomassini',
'via belvedere 12',
'franco@gmail.com',
'prova');

INSERT INTO profile( 
type 
)VALUES(
'Admin');

INSERT INTO profile( 
type 
)VALUES(
'Employee');


INSERT INTO profile( 
type 
)VALUES(
'User');

INSERT INTO book( 
title,
author,
quantity,
editor,
collocation 
)VALUES(
'tutto cotlin',
'Lezze',
'2',
'LezeriniEditor',
'a1');

INSERT INTO book( 
title,
author,
quantity,
editor,
collocation 
)VALUES(
'java Mattone',
'Massimo Pericolo',
'5',
'javaEditor',
'b2');

INSERT INTO book( 
title,
author,
quantity,
editor,
collocation 
)VALUES(
'c++ very fast',
'pretty solero',
'30',
'lsdEditor',
'b2');


INSERT INTO loan( 
id_user,
id_book,
assignment_date,
expiration_date,
state
)VALUES(
'1',
'3',
'2020/4/10',
'2020/5/10',
'riconsegnato');


INSERT INTO loan( 
id_user,
id_book,
assignment_date,
expiration_date,
state
)VALUES(
'2',
'1',
'2020/6/26',
'2020/7/26',
'scaduto');


INSERT INTO loan( 
id_user,
id_book,
assignment_date,
expiration_date,
state
)VALUES(
'3',
'2',
'2020/7/6',
'2020/8/5',
'in corso');


INSERT INTO role( 
id_user,
id_profile
)VALUES(
'1',
'2');


INSERT INTO role( 
id_user,
id_profile
)VALUES(
'2',
'3');


INSERT INTO role( 
id_user,
id_profile
)VALUES(
'3',
'1');
