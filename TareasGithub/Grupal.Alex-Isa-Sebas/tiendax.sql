CREATE DATABASE tiendax;
USE tiendax;

CREATE TABLE proveedores(
    id_proveedor INT,
    PRIMARY KEY (id_proveedor),
    nombre_proveedor VARCHAR(100));

CREATE TABLE facturas(
    id_factura CHAR(4),
    PRIMARY KEY (id_factura),
    descripcion VARCHAR(100),
    fecha_factura DATE NOT NULL);

CREATE TABLE productos(
    id_producto CHAR(2), 
    PRIMARY KEY (id_producto),
    nom_prod VARCHAR(50) UNIQUE NOT NULL,
    qty_producto INT,
    bruto DECIMAL (8,2),
    tipo_prod CHAR(1) NOT NULL CHECK (tipo_prod IN ('E', 'N')),
    IVA DECIMAL (5,2) 
        DEFAULT (CASE WHEN tipo_prod = 'E' THEN 4.00 ELSE 21.00 END), 
    neto DECIMAL(8,2) DEFAULT (bruto * (1 + IVA/100))); 

CREATE TABLE suministrar (
    id_factura CHAR(4),
    id_producto CHAR(2),
    id_proveedor INT,
    qty_suministro INT,
    precio_prod_proveedor DECIMAL (8,2),
    IVA DECIMAL (5,2),
    coste_suministro DECIMAL (8,2) AS (precio_prod_proveedor * (1 + IVA/100)),
    PRIMARY KEY (id_factura, id_producto, id_proveedor),
    FOREIGN KEY (id_factura) REFERENCES facturas(id_factura),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor));

CREATE TABLE clientes (
    id_cliente CHAR(4),
    PRIMARY KEY (id_cliente),
    nombre VARCHAR(30),
    apel1 VARCHAR(30),
    apel2 VARCHAR(30),
    DNI VARCHAR(9) UNIQUE NOT NULL,
    fecha_nacimiento DATE,
    telefono INT,
    mail VARCHAR(50));

CREATE TABLE incluir (
    id_pedido CHAR(10),
    nom_prod VARCHAR(50),
    qty_prod_pedido INT,
    PRIMARY KEY (id_pedido),
    FOREIGN KEY (nom_prod) REFERENCES productos(nom_prod));


CREATE TABLE pedidos (
    id_pedido CHAR(10) UNIQUE NOT NULL,
    PRIMARY KEY (id_pedido),
    qty_prod_pedido INT,
    bruto DECIMAL (8,2),
    IVA DECIMAL (5,2),
    neto DECIMAL(8,2), -- Definir la columna neto
    coste_compra_bruto DECIMAL (8,2) AS (qty_prod_pedido * bruto) STORED, -- Calcular el coste bruto basado en las columnas existentes
    coste_compra_neto DECIMAL (8,2) AS (qty_prod_pedido * neto) STORED, -- Calcular el coste neto basado en las columnas existentes
    tipo_pago CHAR(1) NOT NULL CHECK (tipo_pago IN ('E', 'T')),
    pago_realizado DECIMAL (8,2),
    devolucion DECIMAL(8,2),
    id_cliente CHAR(4),
    FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente),
    fecha_pedido DATE DEFAULT CURRENT_DATE);