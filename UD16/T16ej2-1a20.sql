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

--Ejercicio 2.15.
INSERT INTO departamentos (codigo, nombre, presupuesto) VALUES (11, 'CALIDAD', 40000);