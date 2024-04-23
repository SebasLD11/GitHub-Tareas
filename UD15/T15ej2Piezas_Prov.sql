INSERT INTO piezas (idpiez, nombre) VALUES
    ('1','Camiseta asociado/a'),
    ('2','Loto Candle Purple'),
    ('3','Loto Candle Fire'),
    ('4','Ying-Yang Candle'),
    ('5','CLVT ONE Skateboard'),
    ('6','Gorra CLVT Green Olive'),
    ('7','Gorra CLVT Grey'),
    ('8','Sudadera CLVT Black'),
    ('9','Sudadera CLVT Grey light'),
    ('10','Pocket Brain Wax');
INSERT INTO proveedores (idprov, nombre) VALUES
    ('1','Needer Europar'),
    ('2','Amazon España'),
    ('3','Crit Dgital'),
    ('4','IONOS España'),
    ('5','Mercadona S.A'),
    ('6','Contro SB Barcelona'),
    ('7','Nautilus Sport'),
    ('8','DBR Scooters'),
    ('9','Cajeando S.A'),
    ('10','PixaPrint S.A');

UPDATE `proveedores` SET nombre = 'Control SB Barcelona' WHERE 'proveedores' = 'Contro SB Barcelona';
INSERT INTO suministra (idpiez, idprov, precio) VALUES
    ('1','1','19.99'),
    ('2','2', '11.99'),
    ('3','2','11.99'),
    ('4','2','14.99'),
    ('5','6','54.99'),
    ('6','1','14.99'),
    ('7','1','14.99'),
    ('8','1','39.99'),
    ('9','1','39.99'),
    ('10','2','39.99');


