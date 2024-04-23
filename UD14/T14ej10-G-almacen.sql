CREATE DATABASE GrAlmacenes;
USE GrAlmacenes;

CREATE TABLE productos (
    codProd INT AUTO_INCREMENT PRIMARY KEY,
    nombre NVARCHAR(100) NOT NULL,
    precio INT NOT NULL);

CREATE TABLE cajeros (
    codCaje INT AUTO_INCREMENT PRIMARY KEY,
    nomApels NVARCHAR(100) NOT NULL);

CREATE TABLE maqRegistra (
    codMaqReg INT AUTO_INCREMENT PRIMARY KEY,
    piso INT NOT NULL);

CREATE TABLE venta (
    codProd INT,
    codCaje INT,
    codMaqReg INT,
    PRIMARY KEY(codCaje, codProd, codMaqReg),
    FOREIGN KEY (codCaje) 
        REFERENCES cajeros (codCaje) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE,
    FOREIGN KEY (codMaqReg) 
        REFERENCES maqRegistra (codMaqReg) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE,
    FOREIGN KEY (codProd) 
        REFERENCES productos (codProd) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE);
