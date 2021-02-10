CREATE TABLE ville(
num_ville INT PRIMARY KEY AUTO_INCREMENT,
nom_ville VARCHAR(30) UNIQUE,
superficie INT,
pays VARCHAR(30),
num_pays INT NOT null,
FOREIGN KEY (num_pays) REFERENCES pays(num_pays)
);


CREATE TABLE pays(
num_pays INT PRIMARY KEY auto_increment,
nom_pays VARCHAR(30) unique not NULL,
nombre_habitant INT,
nombre_ville INT
);