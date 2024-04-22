CREATE DATABASE G-almacen;
USE G-almacen;

CREATE TABLE productos (
    codigoProd INT AUTO_INCREMENT ,
    nombre NVARCHAR (100) NOT NULL,
    precio INT NOT NULL,
    PRIMARY KEY(codigoProd));

CREATE TABLE cajeros (
    codCaje INT AUTO_INCREMENT ,
    nomApels NVARCHAR (100) NOT NULL,
    PRIMARY KEY(codCaje));

CREATE TABLE maqRegistra (
    codMaqReg INT AUTO_INCREMENT ,
    piso INT NOT NULL,
    PRIMARY KEY(codCaje));

CREATE TABLE venta (
    codMaqReg INT,
    idproyec INT,
    PRIMARY KEY(codigoProd,codCaje,codMaqReg),
    FOREIGN KEY (idcient) 
    REFERENCES cientificos (idcient) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
    FOREIGN KEY (idproyec) 
    REFERENCES proyectos (idproyec) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE);
