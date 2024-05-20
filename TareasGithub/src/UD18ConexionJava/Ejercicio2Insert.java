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

            // Insertar 5 registros en la tabla 'departamentos'. Ejercicio 2
            statement.executeUpdate("INSERT INTO departamentos (nombre, presupuesto) VALUES ('ACTIVIDADES EXTERNAS', '5000')");
            statement.executeUpdate("INSERT INTO departamentos (nombre, presupuesto) VALUES ('EQUIPOS', '10000')");
            statement.executeUpdate("INSERT INTO departamentos (nombre, presupuesto) VALUES ('LOGISTICA', '20000')");
            statement.executeUpdate("INSERT INTO departamentos (nombre, presupuesto) VALUES ('REDES Y TELECOMUNICACIONES', '6500')");
            statement.executeUpdate("INSERT INTO departamentos (nombre, presupuesto) VALUES ('I+D', '15000')");
            
            // Insertar 5 registros en la tabla 'empleados'. Ejercicio 2
            statement.executeUpdate("INSERT INTO empleados (dni, nombre, apellidos, departamento) VALUES ('xxxxxxO','Oriol', 'Basols Muñoz', '1')");
            statement.executeUpdate("INSERT INTO empleados (dni, nombre, apellidos, departamento) VALUES ('xxxxxxN', 'Sergi', 'Nacarino', '10')");
            statement.executeUpdate("INSERT INTO empleados (dni, nombre, apellidos, departamento) VALUES ('xxxxxxY','Cesar', 'Saday Peña', '1')");
            statement.executeUpdate("INSERT INTO empleados (dni, nombre, apellidos, departamento) VALUES ('xxxxxxH','Ayman', 'Mohammed Haouri', '5')");
            statement.executeUpdate("INSERT INTO empleados (dni, nombre, apellidos, departamento) VALUES ('xxxxxxI','Ingrid', 'López', '5')");                    
            
            // Consultar registros en la tabla 'empleados y departamentos'
            ResultSet resultSet = statement.executeQuery("SELECT * FROM departamentos");
            System.out.println("Registros en la tabla 'Departamentos':");
            while (resultSet.next()) {
                System.out.println("Código: " + resultSet.getInt("codigo") + 
                                   " Nombre: " + resultSet.getString("nombre") +
                                   " Presupuesto: " + resultSet.getString("presupuesto"));
            } 
            ResultSet resultSetEmpleados = statement.executeQuery("SELECT * FROM empleados");
            System.out.println("Registros en la tabla 'Empleados':");
            while (resultSetEmpleados.next()) {
                System.out.println("DNI: " + resultSetEmpleados.getString("dni") + 
                                   " Nombre: " + resultSetEmpleados.getString("nombre") +
                                   " Apellidos: " + resultSetEmpleados.getString("apellidos") +
                                   " Departamento: " + resultSetEmpleados.getInt("departamento"));}
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
