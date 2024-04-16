-- C:\xampp\mysql\bin>mysql -u root
SHOW databases;
CREATE DATABASE prueba;
USE prueba;
CREATE TABLE tabla1 (id INT, nombre VARCHAR(50), PRIMARY KEY (id);
SELECT * FROM `tabla1`;
INSERT INTO `tabla1` (`id`, `nombre`) VALUES ('1', 'Sebas');
SELECT * FROM `tabla1`;
CREATE TABLE tabla3 (id INT, nombre VARCHAR(50), correo VARCHAR(200), PRIMARY KEY (id));
INSERT INTO `tabla3` (`id`, `nombre`, `correo`) VALUES ('1', 'fdfdfd', 'fdfdfdf');

-- Consulta en HeidiSQL para crear una tabnla nueva
CREATE TABLE `tablaheidi` (
	`id` INT NULL,
	`nombre` VARCHAR(50) NULL DEFAULT NULL,
	`telef` INT NULL,
	`correo` VARCHAR(150) NULL DEFAULT NULL
)
COLLATE='utf8mb4_general_ci'
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='prueba';
SHOW TABLE STATUS FROM `prueba`;
SHOW FUNCTION STATUS WHERE `Db`='prueba';
SHOW PROCEDURE STATUS WHERE `Db`='prueba';
SHOW TRIGGERS FROM `prueba`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='prueba';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='prueba' AND TABLE_NAME='tablaheidi' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `tablaheidi` FROM `prueba`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='prueba'   AND TABLE_NAME='tablaheidi'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   TABLE_SCHEMA='prueba'   AND TABLE_NAME='tablaheidi'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SHOW CREATE TABLE `prueba`.`tablaheidi`;
SELECT CONSTRAINT_NAME, CHECK_CLAUSE FROM `information_schema`.`CHECK_CONSTRAINTS` WHERE CONSTRAINT_SCHEMA='prueba' AND TABLE_NAME='tablaheidi';
/* Entrando a la sesión "Conexion" */
SHOW CREATE TABLE `prueba`.`tablaheidi`;
SELECT * FROM `prueba`.`tablaheidi` LIMIT 1000;