CREATE DATABASE empleadosDepart;
USE empleadosDepart;

CREATE TABLE departamentos (
    codigo INT AUTO_INCREMENT,
    nombre NVARCHAR(100),
    presupuesto INT,
    Primary Key (codigo));

CREATE TABLE EMPLEADOS (
    dni VARCHAR(9) NOT NULL,
    nombre NVARCHAR(100),
    apellidos NVARCHAR(255),
    departamento INT,
    PRIMARY KEY (dni),
    FOREIGN KEY (departamento),
    REFERENCES departamentos(codigo),
    ON DELETE CASCADE,
    ON UPDATE CASCADE)

