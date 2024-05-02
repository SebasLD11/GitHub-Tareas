---Tuplas para ejercicios.
INSERT INTO departamentos (codigo, nombre, presupuesto) VALUES 
    (1, 'DEPORTES', 20000),
    (2, 'CULTURA', 10000),
    (3, 'CHARLAS', 5500),
    (4, 'EVENTOS', 25000),
    (5, 'PROYECTOS', 25000),
    (6, 'SALIDAS', 5000),
    (7, 'ALQUILERES', 2000),
    (8, 'ADMINISTRACIÓN Y CONTRATACIONES', 150000),
    (9, 'COMPRA/VENTA', 5000),
    (10, 'MARKETING', 10000);

INSERT INTO EMPLEADOS (dni, nombre, apellidos, departamento) VALUES 
    ('xxxxxxxR', 'Juan Sebastián', 'López Díaz', 8),
    ('xxxxxxxP', 'Sergio', 'Morales Segura', 8),
    ('xxxxxxxL', 'Lucas', 'Caballero', 1),
    ('xxxxxxxD', 'Daniel', 'Carrilo', 1),
    ('xxxxxxxC', 'Nacho', 'Climent', 1),
    ('xxxxxxxJ', 'Joel', 'Oliveira', 1),
    ('xxxxxxxF', 'Ramón', 'Ferran', 1),
    ('xxxxxxxT', 'Tina', 'Perez', 8),
    ('xxxxxxxS', 'Sergio', 'Guerrero', 2),
    ('xxxxxxxM', 'Milena', 'López Díaz', 9);

INSERT INTO EMPLEADOS_DEPARTAMENTOS (dni, departamento) VALUES 
    ('xxxxxxxR', 2), ('xxxxxxxR', 3), ('xxxxxxxR', 4), ('xxxxxxxR', 5), ('xxxxxxxR', 6), ('xxxxxxxR', 10), ('xxxxxxxR', 11);
INSERT INTO EMPLEADOS_DEPARTAMENTOS (dni, departamento) VALUES     
    ('xxxxxxxP', 2), ('xxxxxxxP', 4), ('xxxxxxxP', 5), ('xxxxxxxP', 10);
INSERT INTO EMPLEADOS_DEPARTAMENTOS (dni, departamento) VALUES 
    ('xxxxxxxL', 4), ('xxxxxxxL', 5), ('xxxxxxxL', 6), ('xxxxxxxL', 10);
INSERT INTO EMPLEADOS_DEPARTAMENTOS (dni, departamento) VALUES 
    ('xxxxxxxD', 4), ('xxxxxxxD', 5), ('xxxxxxxD', 6), ('xxxxxxxD', 10);
INSERT INTO EMPLEADOS_DEPARTAMENTOS (dni, departamento) VALUES 
    ('xxxxxxxC', 4), ('xxxxxxxC', 5), ('xxxxxxxC', 6), ('xxxxxxxC', 10);
INSERT INTO EMPLEADOS_DEPARTAMENTOS (dni, departamento) VALUES 
    ('xxxxxxxJ', 4), ('xxxxxxxJ', 5), ('xxxxxxxJ', 6), ('xxxxxxxJ', 10);
INSERT INTO EMPLEADOS_DEPARTAMENTOS (dni, departamento) VALUES 
    ('xxxxxxxF', 4), ('xxxxxxxF', 5), ('xxxxxxxF', 6), ('xxxxxxxF', 10);
INSERT INTO EMPLEADOS_DEPARTAMENTOS (dni, departamento) VALUES 
    ('xxxxxxxT', 2), ('xxxxxxxT', 4), ('xxxxxxxT', 6);
INSERT INTO EMPLEADOS_DEPARTAMENTOS (dni, departamento) VALUES 
    ('xxxxxxxS', 2), ('xxxxxxxS', 9);
INSERT INTO EMPLEADOS_DEPARTAMENTOS (dni, departamento) VALUES 
    ('xxxxxxxM', 2), ('xxxxxxxM', 9),('xxxxxxxM', 11);


--Ejercicio 2, DEL 1 AL 20

SELECT apellidos FROM EMPLEADOS;
SELECT DISTINCT apellidos FROM EMPLEADOS;
SELECT * FROM EMPLEADOS WHERE apellidos = 'López Díaz';
SELECT * FROM EMPLEADOS WHERE apellidos = 'López Díaz' OR apellidos = 'Pérez';
SELECT * FROM EMPLEADOS WHERE departamento = 14;
SELECT * FROM EMPLEADOS WHERE departamento = 37 OR departamento = 77;
SELECT * FROM EMPLEADOS WHERE apellidos LIKE 'P%';
SELECT SUM(presupuesto) AS presupuesto_total
    FROM departamentos;
SELECT d.nombre AS nombre_departamento, COUNT(*) AS numero_empleados FROM departamentos d 
    LEFT JOIN empleados e ON d.codigo = e.departamento
    GROUP BY d.nombre;
SELECT e.*, d.nombre AS nombre_departamento, d.presupuesto
    FROM empleados e
    LEFT JOIN departamentos d ON e.departamento = d.codigo;
SELECT e.nombre, e.apellidos, d.nombre AS nombre_departamento, d.presupuesto
    FROM empleados e
    LEFT JOIN departamentos d ON e.departamento = d.codigo;
SELECT e.nombre, e.apellidos FROM empleados e INNER JOIN departamentos d ON e.departamento = d.codigo
    WHERE d.presupuesto > 60000;
SELECT * FROM departamentos
    WHERE presupuesto > (SELECT AVG(presupuesto) FROM departamentos);
SELECT d.nombre FROM departamentos d 
    INNER JOIN empleados e ON d.codigo = e.departamento 
    GROUP BY d.nombre HAVING COUNT(*) > 2;
INSERT INTO departamentos (codigo, nombre, presupuesto) VALUES (11, 'CALIDAD', 40000);
INSERT INTO EMPLEADOS (dni, nombre, apellidos, departamento) VALUES ('89267109', 'Esther', 'Vázquez', 11);
UPDATE departamentos
    SET presupuesto = presupuesto * 0.9;
UPDATE empleados
    SET departamento = 14
    WHERE departamento = 77;
DELETE FROM empleados
    WHERE departamento = 14;
DELETE FROM empleados
    WHERE departamento IN (SELECT codigo FROM departamentos WHERE presupuesto > 60000);
DELETE FROM empleados
    WHERE departamento IN (SELECT codigo FROM departamentos WHERE presupuesto > 60000);
DELETE FROM empleados;

