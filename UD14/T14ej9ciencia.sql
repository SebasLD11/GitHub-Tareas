CREATE DATABASE cientProy;
USE cientProy;

CREATE TABLE cientificos (
    idcient INT NOT NULL ,
    nomApels VARCHAR (100) NOT NULL,
    PRIMARY KEY(idcient));

CREATE TABLE proyectos (
    idproyec INT NOT NULL,
    nomProy VARCHAR (100) NOT NULL,
    horas INT,
    PRIMARY KEY(idproyec));

CREATE TABLE asignadoA (
    idcient INT NOT NULL,
    idproyec INT NOT NULL,
    PRIMARY KEY(idcient,idproyec),
    FOREIGN KEY (idcient) 
    REFERENCES cientificos (idcient) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
    FOREIGN KEY (idproyec) 
    REFERENCES proyectos (idproyec) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE);

    