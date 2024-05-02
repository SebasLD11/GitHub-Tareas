INSERT INTO almacenes (codigo, lugar, capacidad) VALUES
(1, 'Almacén A', 1000),
(2, 'Almacén B', 1500),
(3, 'Almacén C', 800),
(4, 'Almacén D', 2000),
(5, 'Almacén E', 1200),
(6, 'Almacén F', 500),
(7, 'Almacén G', 900),
(8, 'Almacén H', 300),
(9, 'Almacén I', 600),
(10, 'Almacén J', 700);

INSERT INTO cajas (nref, contenido, valor, almacen) VALUES 
('CA001', 'Ropa', 50.25, 1),
('CA002', 'Electrodomésticos', 200.75, 2),
('CA003', 'Herramientas', 100.00, 3),
('CA004', 'Alimentos', 75.50, 1),
('CA005', 'Electrónicos', 300.00, 4),
('CA006', 'Juguetes', 80.20, 2),
('CA007', 'Libros', 25.75, 3),
('CA008', 'Muebles', 400.00, 5),
('CA009', 'Cosméticos', 150.50, 4),
('CA010', 'Artículos deportivos', 120.00, 6);

SELECT * FROM almacenes;
SELECT * FROM cajas WHERE valor > 150;
SELECT DISTINCT contenido FROM cajas;
SELECT AVG(valor) AS valor_medio FROM cajas;
SELECT almacen FROM cajas
    GROUP BY almacen
    HAVING AVG(valor) > 150;
SELECT c.nref, a.lugar AS ciudad FROM cajas c
    JOIN almacenes a ON c.almacen = a.codigo;
SELECT almacen, COUNT(*) AS numero_de_cajas FROM cajas
    GROUP BY almacen;
SELECT codigo FROM almacenes
    WHERE (SELECT COUNT(*) FROM cajas 
    WHERE cajas.almacen = almacenes.codigo) > capacidad;
SELECT c.nref FROM cajas c
    JOIN almacenes a ON c.almacen = a.codigo
    WHERE a.lugar = 'Bilbao';
INSERT INTO almacenes (lugar, capacidad) VALUES ('Barcelona', 3);
INSERT INTO cajas (nref, contenido, valor, almacen) VALUES ('H5RT', 'Papel', 200, 2);
UPDATE cajas SET valor = valor * 0.85; -- 85% del valor original
UPDATE cajas SET valor = valor * 0.8
    WHERE valor > (SELECT AVG(valor) FROM cajas);
DELETE FROM cajas WHERE valor < 100;
DELETE FROM cajas
WHERE almacen IN (
    SELECT codigo
    FROM almacenes
    WHERE (SELECT COUNT(*) FROM cajas WHERE cajas.almacen = almacenes.codigo) > capacidad);



