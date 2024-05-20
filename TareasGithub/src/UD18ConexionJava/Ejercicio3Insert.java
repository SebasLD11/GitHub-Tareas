package UD18ConexionJava;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class Ejercicio3Insert {
	    // Datos de conexión a la base de datos
	    static final String URL = "jdbc:mysql://localhost:3306/almacenes";
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

	            // Insertar 5 registros en la tabla 'almacenes'. Ejercicio 3
	            statement.executeUpdate("INSERT INTO almacenes (lugar, capacidad) VALUES ('Cambrils ', '1500')");
	            statement.executeUpdate("INSERT INTO almacenes (lugar, capacidad) VALUES ('Tarragona', '1000')");
	            statement.executeUpdate("INSERT INTO almacenes (lugar, capacidad) VALUES ('Reus', '1000')");
	            statement.executeUpdate("INSERT INTO almacenes (lugar, capacidad) VALUES ('Calafell', '500')");
	            statement.executeUpdate("INSERT INTO almacenes (lugar, capacidad) VALUES ('Viella', '500')");
	            
	            // Insertar 5 registros en la tabla 'cajas'. Ejercicio 3
	            statement.executeUpdate("INSERT INTO cajas (nref, contenido, valor, almacen) VALUES ('CA001','tablas de skate', '1500', '12')");
	            statement.executeUpdate("INSERT INTO cajas (nref, contenido, valor, almacen) VALUES ('CA003','Loto Candle', '300', '12')");
	            statement.executeUpdate("INSERT INTO cajas (nref, contenido, valor, almacen) VALUES ('CA006','Camisetas CLVT', '900', '13')");
	            statement.executeUpdate("INSERT INTO cajas (nref, contenido, valor, almacen) VALUES ('CA007','Brain Pocket Wax', '160', '15')");
	            statement.executeUpdate("INSERT INTO cajas (nref, contenido, valor, almacen) VALUES ('CA011','Rodamientos', '180', '15')");                    
	            
	            // Consultar registros en la tabla 'almacenes y cajas'
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM almacenes");
	            System.out.println("Registros en la tabla 'Almacenes':");
	            while (resultSet.next()) {
	                System.out.println("Código: " + resultSet.getInt("codigo") + 
	                                   " Lugar: " + resultSet.getString("lugar") +
	                                   " Capacidad: " + resultSet.getString("capacidad"));
	            } 
	            ResultSet resultSetCajas = statement.executeQuery("SELECT * FROM cajas");
	            System.out.println("Registros en la tabla 'Cajas':");
	            while (resultSetCajas.next()) {
	                System.out.println("Número de referencia: " + resultSetCajas.getString("nref") + 
	                                   " Contenido: " + resultSetCajas.getString("contenido") +
	                                   " Valor: " + resultSetCajas.getString("valor") +
	                                   " Almacen: " + resultSetCajas.getInt("almacen"));}
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
	