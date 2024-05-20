package UD18ConexionJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
	public class Ejercicio1Insert {
	    // Datos de conexión a la base de datos
	    static final String URL = "jdbc:mysql://localhost:3306/tiendainfo";
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

	            //Insertar 5 registros en la tabla 'fabricantes'. Ejercicio 1
            statement.executeUpdate("INSERT INTO fabricantes (nombre) VALUES ('Motorola')");
	        statement.executeUpdate("INSERT INTO fabricantes (nombre) VALUES ('Nokia')");
	        statement.executeUpdate("INSERT INTO fabricantes (nombre) VALUES ('Xiaomi')");
	        statement.executeUpdate("INSERT INTO fabricantes (nombre) VALUES ('Huawei')");
	        statement.executeUpdate("INSERT INTO fabricantes (nombre) VALUES ('Siemens')");
	            
            //Insertar 5 registros en la tabla 'articulos'. Ejercicio 1
	        statement.executeUpdate("INSERT INTO articulos (nomArt,precio, fabricante) VALUES ('Motorola Moto G Power 5G (2024)', '299', '12'");
	        statement.executeUpdate("INSERT INTO articulos (nomArt,precio, fabricante) VALUES ('Nokia 2720 Flip', '89', '13'");
	        statement.executeUpdate("INSERT INTO articulos (nomArt,precio, fabricante) VALUES ('Xiaomi Mi Band 6', '50', '14'");
	        statement.executeUpdate("INSERT INTO articulos (nomArt,precio, fabricante) VALUES ('Huawei FreeBuds Pro', '69', '15'");
	        statement.executeUpdate("INSERT INTO articulos (nomArt,precio, fabricante) VALUES ('Siemens Desigo CC', '150', '16'");
     
            ResultSet resultSet = statement.executeQuery("SELECT * FROM articulos");
            System.out.println("Registros en la tabla 'articulos':");
            while (resultSet.next()) {
                System.out.println("Código: " + resultSet.getInt("codart") + 
                					", Nombre: " + resultSet.getString("nomArt") +
                					"Precio:" + resultSet.getString("precio"));
            }

	        } catch (SQLException e) {
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
