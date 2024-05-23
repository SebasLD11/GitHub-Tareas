package UD18ConexionJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio9Insert{
    // Datos de conexión a la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/invest";
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

   //Insertar 5 registros en la tabla 'investigadores'. Ejercicio 6
       statement.executeUpdate("INSERT INTO investigadores (dni,nomapels,codFac) VALUES ('32548971J', 'Carla Guirao', '3')");
       statement.executeUpdate("INSERT INTO investigadores (dni,nomapels,codFac) VALUES ('24577927K', 'Miguel Contreras', '5')");
       statement.executeUpdate("INSERT INTO investigadores (dni,nomapels,codFac) VALUES ('64497821E', 'Jose Pablo Kito', '7')");
       statement.executeUpdate("INSERT INTO investigadores (dni,nomapels,codFac) VALUES ('65872216R', 'Mauricio Ponci', '9')");
       statement.executeUpdate("INSERT INTO investigadores (dni,nomapels,codFac) VALUES ('36548789W', 'Juan Fernando Saez', '1')");
           
   //Insertar 5 registros en la tabla 'facultades'. Ejercicio 6
       statement.executeUpdate("INSERT INTO facultades (nombre) VALUES ('Facultad de ciencias del deporte')");
       statement.executeUpdate("INSERT INTO facultades (nombre) VALUES ('Facultad de ciencias matemáticas aplicadas')");
       statement.executeUpdate("INSERT INTO facultades (nombre) VALUES ('Facultad de Derecho')");
       statement.executeUpdate("INSERT INTO facultades (nombre) VALUES ('Facultad de Diseño y arte')");
       statement.executeUpdate("INSERT INTO facultades (nombre) VALUES ('Facultad de ciencias de la comunicación')");
            
   //Insertar 5 registros en la tabla 'equipos'. Ejercicio 6
       statement.executeUpdate("INSERT INTO equipos (numserie, nombre, codFac) VALUES ('E11', 'Equipo de Investigación "
   																							+ "en procesos deportivos', '11')");
       statement.executeUpdate("INSERT INTO equipos (numserie, nombre, codFac) VALUES ('E12', 'Equipo de Investigación "
   																							+ "en matemáticas sociales', '12')");
       statement.executeUpdate("INSERT INTO equipos (numserie, nombre, codFac) VALUES ('E13', 'Equipo de Investigación"
   																							+ " en derecho civil, laboral y cooporativo', '13')");
       statement.executeUpdate("INSERT INTO equipos (numserie, nombre, codFac) VALUES ('E14', 'Equipo de Investigación"
   																							+ " en procesos artisticos y creativos', '14')");
       statement.executeUpdate("INSERT INTO equipos (numserie, nombre, codFac) VALUES ('E15', 'Equipo de Investigación "
   																							+ "en procesos y medios comunicativos', '15')");
            
  //Insertar 5 registros en la tabla 'reserva'. Ejercicio 6
            statement.executeUpdate("INSERT INTO reserva (dni, numserie, comienzo, fin) VALUES ('67890123F', 'E11', '2024-01-01', '2025-01-01')");
            statement.executeUpdate("INSERT INTO reserva (dni, numserie, comienzo, fin) VALUES ('65872216R', 'E12', '2024-02-10', '2025-01-01')");
            statement.executeUpdate("INSERT INTO reserva (dni, numserie, comienzo, fin) VALUES ('32548971J', 'E13', '2024-02-21', '2025-01-01')");
            statement.executeUpdate("INSERT INTO reserva (dni, numserie, comienzo, fin) VALUES ('64497821E', 'E14', '2024-03-15', '2025-01-01')");
            statement.executeUpdate("INSERT INTO reserva (dni, numserie, comienzo, fin) VALUES ('24577927K', 'E15', '2024-03-20', '2025-01-01')");
            
  //Consultar registros en la tabla 'productos, cajeros, máquinas y venta'
    ResultSet resultSet = statement.executeQuery("SELECT * FROM investigadores");
    System.out.println("Registros en la tabla 'Investigadores':");
    while (resultSet.next()) {
      System.out.println(" DNI: " + resultSet.getString("dni") + 
                         " Nombre: " + resultSet.getString("nomapels")+ 
                		 " Facultad: " + resultSet.getString("codFac"));}
            
            ResultSet resultSetFac = statement.executeQuery("SELECT * FROM facultades");
            System.out.println("Registros en la tabla 'Facultades':");
            while (resultSetFac.next()) {
                System.out.println(" Código: " + resultSetFac.getString("cod") + 
                                   " Nombre: " + resultSetFac.getString("nombre"));}
                                   
            
            ResultSet resultSetEq = statement.executeQuery("SELECT * FROM equipos");
            System.out.println("Registros en la tabla 'Equipos':");
            while (resultSetEq.next()) {
                System.out.println(" Serie: " + resultSetEq.getString("numserie") +
                                   " Nombre: " + resultSetEq.getString("nombre") +
                                   " Facultad: " + resultSetEq.getString("codFac"));
            }
    
            ResultSet resultSetRes = statement.executeQuery("SELECT * FROM reserva");
            System.out.println("Registros en la tabla 'Reserva':");
            while (resultSetRes.next()) {
                System.out.println(" DNI: " + resultSetRes.getString("dni") + 
                                   " Serie: " + resultSetRes.getString("numserie") +
                				   " Inicio: " + resultSetRes.getString("comienzo") + 
                				   " Fin: " + resultSetRes.getString("fin"));}
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
