CREATE DATABASE cientProy;
USE cientProy;

CREATE TABLE cientificos (
    idcient INT AUTO_INCREMENT ,
    nombre VARCHAR (100) NOT NULL,
    PRIMARY KEY(idcient));

CREATE TABLE proyectos (
    idproyec INT AUTO_INCREMENT ,
    nombre VARCHAR (100) NOT NULL,
    PRIMARY KEY(idproyec));

CREATE TABLE asignadoA (
    idcient INT,
    idproyec INT,
    PRIMARY KEY(idcient,idproyec),
    FOREIGN KEY (idcient) 
    REFERENCES cientificos (idcient) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
    FOREIGN KEY (idproyec) 
    REFERENCES proyectos (idproyec) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE);

    