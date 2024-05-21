package UD18ConexionJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio7Insert{
    // Datos de conexión a la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/cientproy";
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

            // Insertar 5 registros en la tabla 'cientificos'. Ejercicio 6
            //statement.executeUpdate("INSERT INTO cientificos (idcient,nomApels) VALUES ('32587435', 'Milena López Diaz')");
            //statement.executeUpdate("INSERT INTO cientificos (idcient,nomApels) VALUES ('25478359', 'Raquel Fisiote')");
            //statement.executeUpdate("INSERT INTO cientificos (idcient,nomApels) VALUES ('15496875', 'Marina FigLa' )");
            //statement.executeUpdate("INSERT INTO cientificos (idcient,nomApels) VALUES ('68359752', 'Silvia ClavAra')");
            //statement.executeUpdate("INSERT INTO cientificos (idcient,nomApels) VALUES ('36528475', 'Ayman Barkane')");
            
            //Insertar 5 registros en la tabla 'proyectos'. Ejercicio 6
            //statement.executeUpdate("INSERT INTO proyectos (idproyec,nomProy,horas) VALUES ('11', 'Ciencias terapeuticas naturales', '10000')");
            //statement.executeUpdate("INSERT INTO proyectos (idproyec,nomProy,horas) VALUES ('12', 'Fisioterapia Deportiva y Clinica', '10000')");
            //statement.executeUpdate("INSERT INTO proyectos (idproyec,nomProy,horas) VALUES ('13', 'Comportamiento en el consumo y ventas', '1500')");
            statement.executeUpdate("INSERT INTO proyectos (idproyec,nomProy,horas) VALUES ('14', 'Ciencias psicológicas y mentales', '2000')");
            statement.executeUpdate("INSERT INTO proyectos (idproyec,nomProy,horas) VALUES ('15', 'Biomencánica del deporte en la defensa personal', '3000')");
            
          //Insertar 5 registros en la tabla 'asignadoa'. Ejercicio 6
            statement.executeUpdate("INSERT INTO asignadoa (idcient, idproyec) VALUES ('32587435','11')");
            statement.executeUpdate("INSERT INTO asignadoa (idcient, idproyec) VALUES ('25478359','12')");
            statement.executeUpdate("INSERT INTO asignadoa (idcient, idproyec) VALUES ('15496875','13')");
            statement.executeUpdate("INSERT INTO asignadoa (idcient, idproyec) VALUES ('68359752','14')");
            statement.executeUpdate("INSERT INTO asignadoa (idcient, idproyec) VALUES ('36528475','15')");
            
         // Consultar registros en la tabla 'piezas, proveedores y suministra'
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cientificos");
            System.out.println("Registros en la tabla 'Piezas':");
            while (resultSet.next()) {
                System.out.println("Código: " + resultSet.getInt("idcient") + 
                                   "Nombre: " + resultSet.getString("nomApels"));
            } 
            ResultSet resultSetProy = statement.executeQuery("SELECT * FROM proyectos");
            System.out.println("Registros en la tabla 'Proyectos':");
            while (resultSetProy.next()) {
                System.out.println(" Código: " + resultSetProy.getString("idproyec") + 
                                   " Nombre: " + resultSetProy.getString("nomProy") +
                                   " Horas: " + resultSetProy.getString("horas"));}
            
            ResultSet resultSetAsigna = statement.executeQuery("SELECT * FROM asignadoa");
            System.out.println("Registros en la tabla 'Asignado a':");
            while (resultSetAsigna.next()) {
                System.out.println(" Científico: " + resultSetAsigna.getString("idcient") + 
                                   " Proyecto: " + resultSetAsigna.getString("idproyec"));}
            
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
