package UD18ConexionJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio5Insert{
    // Datos de conexión a la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/directores_despachos";
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

            // Insertar 5 registros en la tabla 'despachos'. Ejercicio 3
            //statement.executeUpdate("INSERT INTO despachos (num, capacidad) VALUES ('11','15')");
            //statement.executeUpdate("INSERT INTO despachos (num, capacidad) VALUES ('12','24')");
            //statement.executeUpdate("INSERT INTO despachos (num, capacidad) VALUES ('13','10')");
            // statement.executeUpdate("INSERT INTO despachos (num, capacidad) VALUES ('14','30')");
            //statement.executeUpdate("INSERT INTO despachos (num, capacidad) VALUES ('15','45')");
            
            // Insertar 5 registros en la tabla 'directores'. Ejercicio 3
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, despacho) VALUES ('254157','Juan', '111', '11')");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, despacho) VALUES ('258746','Cris', '', '11')");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, despacho) VALUES ('257489','Fermin', '', '11')");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, despacho) VALUES ('245785','Aaron', '222', '11')");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, despacho) VALUES ('635744','Camilo', '333', '11')");                    
            
            // Consultar registros en la tabla 'despachos y directores'
            ResultSet resultSet = statement.executeQuery("SELECT * FROM despachos");
            System.out.println("Registros en la tabla 'Despachos':");
            while (resultSet.next()) {
                System.out.println("Número: " + resultSet.getInt("num") + 
                                   " Capacidad: " + resultSet.getString("capacidad"));
            } 
            ResultSet resultSetDirectores = statement.executeQuery("SELECT * FROM directores");
            System.out.println("Registros en la tabla 'Directores':");
            while (resultSetDirectores.next()) {
                System.out.println(" DNI: " + resultSetDirectores.getString("DNI") + 
                                   " Nombre: " + resultSetDirectores.getString("NomApels") +
                                   " DNI Jefe: " + resultSetDirectores.getString("DNIJefe") +
                                   " Despacho: " + resultSetDirectores.getString("despacho"));}
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
