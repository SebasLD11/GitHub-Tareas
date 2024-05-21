package UD18ConexionJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio6Insert{
    // Datos de conexión a la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/piezprov";
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

            // Insertar 5 registros en la tabla 'piezas'. Ejercicio 6
            statement.executeUpdate("INSERT INTO piezas (nombre) VALUES ('Ejes ACE')");
            statement.executeUpdate("INSERT INTO piezas (nombre) VALUES ('Tornillos Independent')");
            statement.executeUpdate("INSERT INTO piezas (nombre) VALUES ('Ruedas Bones')");
            statement.executeUpdate("INSERT INTO piezas (nombre) VALUES ('Ruedas Ricta')");
            statement.executeUpdate("INSERT INTO piezas (nombre) VALUES ('Rodamientos Skateaholic')");
            
            //Insertar 5 registros en la tabla 'proveedores'. Ejercicio 6
            statement.executeUpdate("INSERT INTO proveedores (nombre) VALUES ('Decathlon')");
            statement.executeUpdate("INSERT INTO proveedores (nombre) VALUES ('Play GOP')");
            statement.executeUpdate("INSERT INTO proveedores (nombre) VALUES ('Etnies Skateboarding')");
            statement.executeUpdate("INSERT INTO proveedores (nombre) VALUES ('Bones Co.')");
            statement.executeUpdate("INSERT INTO proveedores (nombre) VALUES ('SkateAholic Supply Co.')");
            
          //Insertar 5 registros en la tabla 'suministra'. Ejercicio 6
            statement.executeUpdate("INSERT INTO suministra (idpiez, idprov,precio) VALUES ('11','11','19.95')");
            statement.executeUpdate("INSERT INTO suministra (idpiez, idprov,precio) VALUES ('12','12','1.5')");
            statement.executeUpdate("INSERT INTO suministra (idpiez, idprov,precio) VALUES ('13','13','35.95')");
            statement.executeUpdate("INSERT INTO suministra (idpiez, idprov,precio) VALUES ('14','14','30.50')");
            statement.executeUpdate("INSERT INTO suministra (idpiez, idprov,precio) VALUES ('15','15','27.99')");
            
         // Consultar registros en la tabla 'piezas, proveedores y suministra'
            ResultSet resultSet = statement.executeQuery("SELECT * FROM piezas");
            System.out.println("Registros en la tabla 'Piezas':");
            while (resultSet.next()) {
                System.out.println("Código: " + resultSet.getInt("idpiez") + 
                                   "Nombre: " + resultSet.getString("nombre"));
            } 
            ResultSet resultSetProveedores = statement.executeQuery("SELECT * FROM proveedores");
            System.out.println("Registros en la tabla 'Proveedores':");
            while (resultSetProveedores.next()) {
                System.out.println(" Código: " + resultSetProveedores.getString("idprov") + 
                                   " Nombre: " + resultSetProveedores.getString("nombre"));}
            
            ResultSet resultSetSuministra = statement.executeQuery("SELECT * FROM suministra");
            System.out.println("Registros en la tabla 'Suministra':");
            while (resultSetSuministra.next()) {
                System.out.println(" Pieza: " + resultSetSuministra.getString("idpiez") + 
                                   " Proveedor: " + resultSetSuministra.getString("idprov") +
                                   " Precio: " + resultSetSuministra.getString("precio"));}
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
