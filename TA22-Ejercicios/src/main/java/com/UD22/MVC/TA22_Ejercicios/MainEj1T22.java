package com.UD22.MVC.TA22_Ejercicios;

import Controlador.controllerEj1T22;
import Modelo.ClienteAdmin;
import Vista.vistaEj1T22;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainEj1T22 {
    // Datos de conexión a la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/ejt22mvc";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");

            // Crear la tabla de clientes si no existe
            createTable(conexion);

            // Inicializar el administrador, la vista y el controlador
            ClienteAdmin admin = new ClienteAdmin(conexion);
            vistaEj1T22 vista = new vistaEj1T22();
            new controllerEj1T22(vista, admin);

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    private static void createTable(Connection conexion) {
        Statement statement = null;
        try {
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
            System.out.println("Error al crear la tabla: " + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar el Statement: " + e.getMessage());
            }
        }
    }
}
