CREATE DATABASE tiendax;
USE tiendax;

-- CREAR PROVEEDORES
CREATE TABLE proveedores(
    id_proveedor INT,
    nom_prove VARCHAR(100),
    PRIMARY KEY (id_proveedor),
    FOREIGN KEY (nom_prove) REFERENCES proveedores (nom_prove));

-- CREAR PRODUCTOS
CREATE TABLE productos(
    id_producto CHAR(4), -- Simboliza el listado de los productos y da lugar a la capacidad max. de la tienda (100 productos, 0-99).
    PRIMARY KEY (id_producto),
    nom_prod VARCHAR(50),
    qty_producto INT,
    bruto_prod DECIMAL(8,2),
    tipo_prod CHAR(1) NOT NULL CHECK (tipo_prod IN ('E', 'N')),
    IVA DECIMAL (5,2),
    neto_prod DECIMAL(8,2) -- DECIMAL (p, s). p --> precision, numero total de digitos. s --> escala, decimales despues de la coma
);

-- CREAR FACTURAS
CREATE TABLE facturas (
    id_factura CHAR(4),
    linea_factura INT,
    id_producto CHAR(4),
    qty_suministro INT,
    coste_prod_suministro DECIMAL(8,2),
    descripcion VARCHAR(100),
    fecha_factura DATE NOT NULL,
    PRIMARY KEY (id_factura, linea_factura),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);


-- CREAR SUMINISTRAR
CREATE TABLE suministrar (
    id_factura CHAR(4),
    id_proveedor INT, 
    nom_proveedor VARCHAR(100) UNIQUE NOT NULL,  
    PRIMARY KEY (id_factura, id_proveedor),
    FOREIGN KEY (id_factura) REFERENCES facturas(id_factura),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor),
    FOREIGN KEY (nom_proveedor) REFERENCES proveedores(nom_prove)
);

--CREAR CLIENTE
CREATE TABLE clientes (
    id_cliente CHAR(4),
    PRIMARY KEY (id_cliente),
    nombre VARCHAR (30) NOT NULL,
    apel1 VARCHAR(30) NOT NULL,
    apel2 VARCHAR(30),
    DNI VARCHAR(9) UNIQUE NOT NULL,
    fecha_nacimiento DATE,
    telefono INT,
    mail VARCHAR(50)
);

-- CREAR PEDIDOS
CREATE TABLE pedidos (
    id_pedido CHAR(10),
    PRIMARY KEY (id_pedido),
    coste_compra_bruto DECIMAL (8,2),
    coste_compra_neto DECIMAL (8,2),
    pago_realizado DECIMAL (8,2),
    devolución DECIMAL(8,2),
    id_cliente CHAR(4),
        FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente),
    fecha_pedido DATE DEFAULT CURRENT_DATE -- Se establece automáticamente la fecha actual al momento de la inserción de datos
);

CREATE TABLE incluir (
    id_pedido CHAR(10),
    linea_pedido INT,  -- Nuevo campo para identificar cada línea de pedido
    PRIMARY KEY (id_pedido, linea_pedido),  -- Clave primaria compuesta
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
    id_producto CHAR(2),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto),
    qty_prod_pedido INT
);