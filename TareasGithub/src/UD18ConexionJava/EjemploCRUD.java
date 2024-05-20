package UD18ConexionJava;

import java.sql.*;

public class EjemploCRUD {
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

            // Actualizar el nombre de un registro en la tabla 'fabricantes'
            //statement.executeUpdate("UPDATE fabricantes SET codigo = '12' WHERE codigo = '22'");
            //statement.executeUpdate("UPDATE fabricantes SET codigo = '13' WHERE codigo = '23'");
            //statement.executeUpdate("UPDATE fabricantes SET codigo = '14' WHERE codigo = '24'");
            //statement.executeUpdate("UPDATE fabricantes SET codigo = '15' WHERE codigo = '25'");
            //statement.executeUpdate("UPDATE fabricantes SET codigo = '16' WHERE codigo = '26'");
          
           
            // Insertar 5 registros en la tabla 'fabricantes'. Ejercicio 1
            //statement.executeUpdate("INSERT INTO fabricantes (nombre) VALUES ('Motorola')");
            //statement.executeUpdate("INSERT INTO fabricantes (nombre) VALUES ('Nokia')");
            //statement.executeUpdate("INSERT INTO fabricantes (nombre) VALUES ('Xiaomi')");
            //statement.executeUpdate("INSERT INTO fabricantes (nombre) VALUES ('Huawei')");
            //statement.executeUpdate("INSERT INTO fabricantes (nombre) VALUES ('Siemens')");

            
            // Eliminar un registro específico de la tabla 'fabricantes'
            //statement.executeUpdate("DELETE FROM fabricantes WHERE codigo = 16");

            // Consultar y mostrar los registros de la tabla 'fabricantes'
            ResultSet resultSet = statement.executeQuery("SELECT * FROM fabricantes");
            System.out.println("Registros en la tabla 'fabricantes':");
            while (resultSet.next()) {
                System.out.println("Código: " + resultSet.getInt("codigo") + ", Nombre: " + resultSet.getString("nombre"));
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
