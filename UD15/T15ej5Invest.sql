INSERT INTO facultades (nombre)
VALUES
("Facultad de Ciencias"),
("Facultad de Humanidades"),
("Facultad de Ciencias Sociales"),
("Facultad de Medicina"),
("Facultad de Ingeniería"),
("Facultad de Economía"),
("Facultad de Derecho"),
("Facultad de Ciencias de la Salud"),
("Facultad de Ciencias de la Tierra"),
("Facultad de Ciencias de la Vida");

INSERT INTO investigadores (dni, nomapels, codFac)
VALUES
("12345678A", "Juan Pérez", 1),
("23456789B", "María González", 2),
("34567890C", "Pedro Sánchez", 3),
("45678901D", "Ana López", 4),
("56789012E", "José Martínez", 5),
("67890123F", "Luis Hernández", 6),
("78901234G", "Eva García", 7),
("89012345H", "Carlos Díaz", 8),
("90123456I", "Sofía Rodríguez", 9),
("11234567J", "Francisco Moreno", 10);

INSERT INTO equipos (numserie, nombre, codFac)
VALUES
("E01", "Equipo de Investigación en Ciencias de la Salud", 1),
("E02", "Equipo de Investigación en Ciencias de la Tierra", 2),
("E03", "Equipo de Investigación en Ciencias de la Vida", 3),
("E04", "Equipo de Investigación en Ingeniería", 4),
("E05", "Equipo de Investigación en Economía", 5),
("E06", "Equipo de Investigación en Derecho", 6),
("E07", "Equipo de Investigación en Ciencias Sociales", 7),
("E08", "Equipo de Investigación en Ciencias de la Salud", 8),
("E09", "Equipo de Investigación en Ciencias de la Tierra", 9),
("E10", "Equipo de Investigación en Ciencias de la Vida", 10);

INSERT INTO reserva (dni, numserie, comienzo, fin)
VALUES
("12345678A", "E01", "2022-01-01", "2022-01-31"),
("23456789B", "E02", "2022-02-01", "2022-02-28"),
("34567890C", "E03", "2022-03-01", "2022-03-31"),
("45678901D", "E04", "2022-04-01", "2022-04-30"),
("56789012E", "E05", "2022-05-01", "2022-05-31"),
("67890123F", "E06", "2022-06-01", "2022-06-30"),
("78901234G", "E07", "2022-07-01", "2022-07-31"),
("89012345H", "E08", "2022-08-01", "2022-08-31"),
("90123456I", "E09", "2022-09-01", "2022-09-30"),
("11234567J", "E10", "2022-10-01", "2022-10-31");