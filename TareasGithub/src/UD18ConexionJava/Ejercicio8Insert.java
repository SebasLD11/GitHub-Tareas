package UD18ConexionJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio8Insert{
    // Datos de conexión a la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/gralmacenes";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        try {
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
            
            // Crear un objeto Statement para ejecutar consultas SQL
            statement = conexion.createStatement();

            // Insertar 5 registros en la tabla 'productos'. Ejercicio 6
            //statement.executeUpdate("INSERT INTO productos (nombre,precio) VALUES ('Producto K', '15')");
            //statement.executeUpdate("INSERT INTO productos (nombre,precio) VALUES ('Producto L', '12')");
            //statement.executeUpdate("INSERT INTO productos (nombre,precio) VALUES ('Producto M', '55')");
            //statement.executeUpdate("INSERT INTO productos (nombre,precio) VALUES ('Producto N', '35')");
            //statement.executeUpdate("INSERT INTO productos (nombre,precio) VALUES ('Producto O', '45')");
            
            //Insertar 5 registros en la tabla 'cajeros'. Ejercicio 6
            //statement.executeUpdate("INSERT INTO cajeros (nomApels) VALUES ('Miguel Cabrera')");
            //statement.executeUpdate("INSERT INTO cajeros (nomApels) VALUES ('Juan Jose Quiros')");
            //statement.executeUpdate("INSERT INTO cajeros (nomApels) VALUES ('Ramón Gonzalez')");
            //statement.executeUpdate("INSERT INTO cajeros (nomApels) VALUES ('Andrea Joita')");
            //statement.executeUpdate("INSERT INTO cajeros (nomApels) VALUES ('Valentina Vasquez')");
            
            //Insertar 5 registros en la tabla 'maqregistra'. Ejercicio 6
            //statement.executeUpdate("INSERT INTO maqregistra (piso) VALUES ('2')");
            //statement.executeUpdate("INSERT INTO maqregistra (piso) VALUES ('1')");
            //statement.executeUpdate("INSERT INTO maqregistra (piso) VALUES ('3')");
            //statement.executeUpdate("INSERT INTO maqregistra (piso) VALUES ('1')");
            //statement.executeUpdate("INSERT INTO maqregistra (piso) VALUES ('3')");
            
          //Insertar 5 registros en la tabla 'venta'. Ejercicio 6
            //statement.executeUpdate("INSERT INTO venta (codProd, codCaje, codMaqReg) VALUES ('11', '11','11')");
            //statement.executeUpdate("INSERT INTO venta (codProd, codCaje, codMaqReg) VALUES ('12', '12','12')");
            //statement.executeUpdate("INSERT INTO venta (codProd, codCaje, codMaqReg) VALUES ('13', '13','13')");
            //statement.executeUpdate("INSERT INTO venta (codProd, codCaje, codMaqReg) VALUES ('14', '14','14')");
            //statement.executeUpdate("INSERT INTO venta (codProd, codCaje, codMaqReg) VALUES ('15', '15','15')");
            
         // Consultar registros en la tabla 'productos, cajeros, máquinas y venta'
            ResultSet resultSet = statement.executeQuery("SELECT * FROM productos");
            System.out.println("Registros en la tabla 'Productos':");
            while (resultSet.next()) {
                System.out.println("Código: " + resultSet.getInt("codProd") + 
                                   " Nombre: " + resultSet.getString("nombre")+ 
                				   "Precio: " + resultSet.getString("precio"));}
            
            ResultSet resultSetCaj = statement.executeQuery("SELECT * FROM cajeros");
            System.out.println("Registros en la tabla 'Cajeros':");
            while (resultSetCaj.next()) {
                System.out.println(" Código: " + resultSetCaj.getString("codCaje") + 
                                   " Nombre: " + resultSetCaj.getString("nomApels"));}
                                   
            
            ResultSet resultSetMaqReg = statement.executeQuery("SELECT * FROM maqregistra");
            System.out.println("Registros en la tabla 'Máquinas Registradoras':");
            while (resultSetMaqReg.next()) {
                System.out.println(" Código: " + resultSetMaqReg.getString("codMaqReg") + 
                                   " Piso: " + resultSetMaqReg.getString("piso"));}
    
            ResultSet resultSetVenta = statement.executeQuery("SELECT * FROM venta");
            System.out.println("Registros en la tabla 'Venta':");
            while (resultSetVenta.next()) {
                System.out.println(" Producto: " + resultSetVenta.getString("codProd") + 
                                   " Cajero: " + resultSetVenta.getString("codCaje") +
                				   " Máquina registradora: " + resultSetVenta.getString("codMaqReg"));}

            }catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            } finally {
                try {
                    if (statement != null) statement.close();
                    if (conexion != null) conexion.close();
                    System.out.println("Conexión cerrada");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }