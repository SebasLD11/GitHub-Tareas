package UD18ConexionJava;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	
		public class Ejercicio2Insert {
		    // Datos de conexión a la base de datos
		    static final String URL = "jdbc:mysql://localhost:3306/empleadosdepart";
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

		            //Insertar 5 registros en la tabla 'departamentos'. Ejercicio 1
	            statement.executeUpdate("INSERT INTO departamentos (nombre, presupuesto) VALUES ('ACTIVIDADES EXTERNAS', '5000')");
		        statement.executeUpdate("INSERT INTO departamentos (nombre, presupuesto) VALUES ('EQUIPOS', '10000')");
		        statement.executeUpdate("INSERT INTO departamentos (nombre, presupuesto) VALUES ('LOGISTICA', '20000')");
		        statement.executeUpdate("INSERT INTO departamentos (nombre, presupuesto) VALUES ('REDES Y TELECOMUNICACIONES', '6500')");
		        statement.executeUpdate("INSERT INTO departamentos (nombre, presupuesto) VALUES ('I+D', '15000')");
		            
	            //Insertar 5 registros en la tabla 'empleados'. Ejercicio 1
		        statement.executeUpdate("INSERT INTO empleados (nombre, apellidos, departamento) VALUES ('Oriol', 'Basols Muñoz', '1'");
		        statement.executeUpdate("INSERT INTO empleados (nombre, apellidos, departamento) VALUES ('Sergi', 'Nacarino', '10'");
		        statement.executeUpdate("INSERT INTO empleados (nombre, apellidos, departamento) VALUES ('Cesar', 'Saday Peña', '1'");
		        statement.executeUpdate("INSERT INTO empleados (nombre, apellidos, departamento) VALUES ('Ayman', 'Mohammed Haouri', '5'");
		        statement.executeUpdate("INSERT INTO empleados (nombre, apellidos, departamento) VALUES ('Ingrid', 'López', '5'");
	     
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM empleadosdepart");
	            System.out.println("Registros en la tabla 'Empleados-Departamentos':");
	            while (resultSet.next()) {
	                System.out.println("Código: " + resultSet.getInt("codigo") + 
	                					"Nombre: " + resultSet.getString("nombre") +
	                					"Presupuesto:" + resultSet.getString("presupuesto"));
	                System.out.println("DNI: " + resultSet.getInt("dni") + 
        					"Nombre: " + resultSet.getString("nombre" + "apellidos") +
        					"Departamento:" + resultSet.getString("departamento"));
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


