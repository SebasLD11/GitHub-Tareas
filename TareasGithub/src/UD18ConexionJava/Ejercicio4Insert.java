package UD18ConexionJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio4Insert{
    // Datos de conexión a la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/cine";
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

            // Insertar 5 registros en la tabla 'peliculas'. Ejercicio 3
            statement.executeUpdate("INSERT INTO peliculas (nombre, califEdad) VALUES ('Garfield: Fuera de Casa ', '10 ')");
            statement.executeUpdate("INSERT INTO peliculas (nombre, califEdad) VALUES ('El Planeta de los Simios: Nuevo Reino', '13 ')");
            statement.executeUpdate("INSERT INTO peliculas (nombre, califEdad) VALUES ('Furiosa', '17 ')");
            statement.executeUpdate("INSERT INTO peliculas (nombre, califEdad) VALUES ('Hasta el Fin del Mundo', '17 ')");
            statement.executeUpdate("INSERT INTO peliculas (nombre, califEdad) VALUES ('Amigos Imaginarios', '13 ')");
            
            // Insertar 5 registros en la tabla 'salas'. Ejercicio 3
            statement.executeUpdate("INSERT INTO salas (nombre, pelicula) VALUES ('Sala 11','12')");
            statement.executeUpdate("INSERT INTO salas (nombre, pelicula) VALUES ('Sala 12','11 ')");
            statement.executeUpdate("INSERT INTO salas (nombre, pelicula) VALUES ('Sala 13',' 8')");
            statement.executeUpdate("INSERT INTO salas (nombre, pelicula) VALUES ('Sala 14','9')");
            statement.executeUpdate("INSERT INTO salas (nombre, pelicula) VALUES ('Sala 15','7')");                    
            
            // Consultar registros en la tabla 'peliculas y salas'
            ResultSet resultSet = statement.executeQuery("SELECT * FROM peliculas");
            System.out.println("Registros en la tabla 'Peliculas':");
            while (resultSet.next()) {
                System.out.println("Código: " + resultSet.getInt("codigo") + 
                                   " Nombre: " + resultSet.getString("nombre") +
                                   " Calificación de edad: " + resultSet.getString("califEdad"));
            } 
            ResultSet resultSetSalas = statement.executeQuery("SELECT * FROM salas");
            System.out.println("Registros en la tabla 'Salas':");
            while (resultSetSalas.next()) {
                System.out.println(" Código: " + resultSetSalas.getString("codigo") + 
                                   " Nombre: " + resultSetSalas.getString("nombre") +
                                   " Pelicula: " + resultSetSalas.getString("pelicula"));}
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
