-- Insertar 10 tuplas en la tabla 'cientificos'
INSERT INTO cientificos (idcient, nomApels) VALUES
('12345678', 'Juan Pérez Sánchez'),
('23456789', 'María Gómez Martínez'),
('34567890', 'Pedro Rodríguez López'),
('45678901', 'Ana García Fernández'),
('56789012', 'Luis Martínez Pérez'),
('67890123', 'Laura Sánchez Gómez'),
('78901234', 'Carlos Fernández Rodríguez'),
('89012345', 'Sofía López Martínez'),
('90123456', 'Pablo Pérez Rodríguez'),
('11234567', 'Elena Martínez García');

-- Insertar 10 tuplas en la tabla 'proyectos'
INSERT INTO proyectos (idproyec, nomProy, horas) VALUES
('1', 'Desarrollo de Software', 100),
('2', 'Investigación Médica', 200),
('3', 'Ingeniería Ambiental', 150),
('4', 'Robótica Avanzada', 180),
('5', 'Inteligencia Artificial', 220),
('6', 'Nanotecnología', 120),
('7', 'Bioinformática', 190),
('8', 'Realidad Virtual', 160),
('9', 'Exploración Espacial', 240),
('10', 'Biotecnología', 170);

-- Insertar 10 tuplas en la tabla 'asignado'
-- Se asignan aleatoriamente científicos y proyectos
INSERT INTO asignadoA (idcient, idproyec) VALUES
('12345678', '1'),
('23456789', '2'),
('34567890', '3'),
('45678901', '4'),
('56789012', '5'),
('67890123', '6'),
('78901234', '7'),
('89012345', '8'),
('90123456', '9'),
('11234567', '10');