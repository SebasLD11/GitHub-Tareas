-- modificación de datos introducidos.
UPDATE articulos
SET fabricante = 4
WHERE codart = 2;

UPDATE articulos
SET fabricante = 5
WHERE codart = 3;

UPDATE articulos
SET fabricante = 6
WHERE codart = 4;

-- consultas propias de los ejercicios del 1 al 20.

SELECT nomArt FROM articulos;
SELECT nomArt, precio FROM articulos;
SELECT nomArt FROM articulos WHERE precio <= 200;
SELECT * FROM articulos WHERE precio BETWEEN 60 AND 120;
SELECT nomArt, precio * 166.386 AS precio_pesetas FROM articulos;
SELECT AVG(precio) AS precio_medio FROM articulos;
SELECT AVG(precio) AS precio_medio FROM articulos 
    WHERE fabricante = 2;
SELECT COUNT(*) AS num_articulos FROM articulos
    WHERE precio >= 180;
SELECT nomArt, precio FROM articulos 
    WHERE precio >= 180
    ORDER BY precio DESC, nomArt ASC;
SELECT a.codart, a.nomArt AS nombre_articulo, a.precio, f.codigo AS codigo_fabricante, f.nombre AS nombre_fabricante
    FROM articulos AS a
    JOIN fabricantes AS f ON a.fabricante = f.codigo;
SELECT a.nomArt AS nombre_articulo, a.precio, f.nombre AS nombre_fabricante FROM articulos AS a
    JOIN fabricantes AS f ON a.fabricante = f.codigo;
SELECT fabricante, AVG(precio) AS precio_medio FROM articulos
    GROUP BY fabricante;
SELECT f.nombre AS nombre_fabricante, AVG(a.precio) AS precio_medio FROM articulos AS a
    JOIN fabricantes AS f ON a.fabricante = f.codigo
    GROUP BY f.nombre;
SELECT f.nombre AS nombre_fabricante FROM fabricantes AS f
    JOIN articulos AS a ON f.codigo = a.fabricante
    GROUP BY f.codigo, f.nombre HAVING AVG(a.precio) >= 150;
SELECT nomArt AS nombre_articulo, precio FROM articulos
    WHERE precio = (SELECT MIN(precio) FROM articulos);
SELECT a.nomArt AS nombre_articulo, a.precio, f.nombre AS nombre_fabricante FROM articulos AS a
    JOIN fabricantes AS f ON a.fabricante = f.codigo
    WHERE (a.fabricante, a.precio) IN (SELECT fabricante, MAX(precio) 
        FROM articulos GROUP BY fabricante);
INSERT INTO articulos (nomArt, precio, fabricante) VALUES
('Altavoces LG', 69.99,2);
UPDATE articulos SET nomArt = 'Impresora laser'
    WHERE codart = 8;
UPDATE articulos SET precio = precio * 0.9;
UPDATE articulos SET precio = precio - 10
    WHERE precio >= 120;

-- extra para ver la tabla entera al detalle
SELECT articulos.codart, articulos.nomArt, articulos.precio, fabricantes.nombre AS fabricante
FROM articulos
JOIN fabricantes ON articulos.fabricante = fabricantes.codigo
ORDER BY articulos.codart ASC;
