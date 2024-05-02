INSERT INTO peliculas (codigo, nombre, calidad) VALUES
(1, 'El Padrino', 18),
(2, 'La La Land', 12),
(3, 'Pulp Fiction', 18),
(4, 'Forrest Gump', 12),
(5, 'El Señor de los Anillos: La Comunidad del Anillo', 12),
(6, 'Titanic', 12),
(7, 'Jurassic Park', 7),
(8, 'Los Vengadores', 7),
(9, 'Harry Potter y la Piedra Filosofal', 7),
(10, 'Shrek', 7);

INSERT INTO salas (codigo, nombre, peliculas) VALUES
(1, 'Sala 1', 1),
(2, 'Sala 2', 2),
(3, 'Sala 3', 3),
(4, 'Sala 4', 4),
(5, 'Sala 5', 5),
(6, 'Sala 6', 6),
(7, 'Sala 7', NULL),
(8, 'Sala 8', NULL),
(9, 'Sala 9', NULL),
(10, 'Sala 10', NULL);

SELECT * FROM peliculas;
SELECT DISTINCT califEdad FROM peliculas;
SELECT * FROM peliculas WHERE califEdad IS NULL;
SELECT * FROM salas WHERE pelicula IS NULL;
SELECT s.*, p.* FROM salas s LEFT JOIN peliculas p ON s.pelicula = p.codigo;
SELECT p.*, s.* FROM peliculas p LEFT JOIN salas s ON p.codigo = s.pelicula;
SELECT peliculas.nombre FROM peliculas LEFT JOIN salas ON peliculas.codigo = salas.pelicula WHERE salas.pelicula IS NULL;
INSERT INTO peliculas (nombre, califEdad) VALUES ('Uno, Dos, Tres', 7);
UPDATE peliculas SET califEdad = 13 WHERE califEdad IS NULL;
DELETE FROM salas WHERE pelicula IN (SELECT codigo FROM peliculas WHERE califEdad = 0);

