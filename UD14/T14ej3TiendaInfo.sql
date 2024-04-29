CREATE DATABASE tiendainfo;
USE tiendainfo;

CREATE TABLE fabricantes (
    codigo INT,
    nombre NVARCHAR(100),
    PRIMARY KEY (codigo));

ALTER TABLE `fabricantes` CHANGE `codigo` `codigo` INT(11) NOT NULL AUTO_INCREMENT;
INSERT INTO fabricantes (nombre) VALUES 
    ('HP'),
    ('LG'),
    ('Samsung'),
    ('Asus'),
    ('MSI')
    ('Microsoft'),
    ('Sony'),
    ('Epson'),
    ('Wacom'),
    ('Bose'),
    ('Canon');


CREATE TABLE articulos (
    codart INT  NOT NULL  AUTO_INCREMENT,
    nombre NVARCHAR(100),
    precio FLOAT,
    fabricante INT,
    PRIMARY KEY (codart),
    FOREIGN KEY (fabricante) 
    REFERENCES fabricantes (codigo) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE);

INSERT INTO articulos (nombre, precio, fabricante) VALUES
    ('Impresora HP Deskjet', 49.95, 1), -- Aquí usamos el código 1 de HP
    ('Samsung S24+ 5G', 949.99, 3),     -- Código 3 para Samsung
    ('Portatil Asus i5', 475.50, 4),    -- Código 4 para Asus
    ('Ordenador de mesa MSI', 1150.50, 5)
    ('Teclado inalámbrico HP', 29.99, 1),
    ('Monitor HP 24" Full HD', 149.99, 1),
    ('Ratón óptico Microsoft', 19.99, 6),
    ('Auriculares Bluetooth Sony', 79.99, 7),
    ('Impresora Epson multifunción', 129.99, 8),
    ('Tableta gráfica Wacom', 199.99, 9),
    ('Smartwatch Samsung Galaxy', 249.99, 2),
    ('Router ASUS WiFi AC1200', 89.99, 3),
    ('Altavoces Bose 2.1', 199.99, 10),
    ('Cámara Canon EOS 2000D', 499.99, 11);; -- Código 5 para MSI

ALTER TABLE `articulos` CHANGE `nombre` `nomArt` NVARCHAR(150);

--Ejemplo de phpMyAdmin

CREATE TABLE `tiendainfo`.`prova` (`id` INT NOT NULL AUTO_INCREMENT , `nombre` VARCHAR(60) NOT NULL , PRIMARY KEY (`id`));