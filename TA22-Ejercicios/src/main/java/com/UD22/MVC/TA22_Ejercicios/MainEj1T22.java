package com.UD22.MVC.TA22_Ejercicios;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MainEj1T22 {
    // Ruta al archivo de propiedades
    static final String PROPERTIES_FILE = "database.properties";

    public static void main(String[] args) {
        // Cargar las propiedades de la base de datos desde el archivo de propiedades
        Properties props = new Properties();
        try (InputStream input = MainEj1T22.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                System.out.println("Lo siento, no se pudo encontrar " + PROPERTIES_FILE);
                return;
            }
            // Cargar el archivo de propiedades
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }

        String dbcURL = props.getProperty("db.url");
        String dbcUsername = props.getProperty("db.username");
        String dbcPassword = props.getProperty("db.password");

        // Crear la tabla de clientes si no existe
        createTable(dbcURL, dbcUsername, dbcPassword);

        // Inicializar el administrador, la vista y el controlador
        ClienteAdmin admin = new ClienteAdmin();
        vistaEj1T22 vista = new vistaEj1T22();
        @SuppressWarnings("unused")
		controllerEj1T22 controller = new controllerEj1T22(vista, admin);
    }

    private static void createTable(String dbcURL, String dbcUsername, String dbcPassword) {
        Connection conexion = null;
        Statement statement = null;

        try {
            // Establecer la conexión
            conexion = DriverManager.getConnection(dbcURL, dbcUsername, dbcPassword);
            System.out.println("Conexión exitosa a la base de datos");

            // Crear un objeto Statement para ejecutar consultas SQL
            statement = conexion.createStatement();
            
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Clientes (" +
                                    "id INT(11) NOT NULL AUTO_INCREMENT, " +
                                    "nombre VARCHAR(250) DEFAULT NULL, " +
                                    "apellido VARCHAR(250) DEFAULT NULL, " +
                                    "direccion VARCHAR(250) DEFAULT NULL, " +
                                    "dni INT(11) DEFAULT NULL, " +
                                    "fecha DATE DEFAULT NULL, " +
                                    "PRIMARY KEY (id))";
            statement.executeUpdate(createTableSQL);
            System.out.println("Tabla 'Clientes' creada o ya existe");

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
