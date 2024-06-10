package com.UD22.MVC.TA22_Ejercicios;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Date;

public class ClienteAdmin {
    private String URL;
    private String USER;
    private String PASSWORD;
    private Connection dbcConnection;

    public ClienteAdmin() {
        loadDBProperties();
    }

    private void loadDBProperties() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("resources/database.properties")) {
            properties.load(input);
            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");
        } catch (IOException ex) {
            ex.printStackTrace();
            // Manejar la excepción apropiadamente según tu aplicación
        }
    }

    protected void connect() throws SQLException {
        if (dbcConnection == null || dbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                dbcConnection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                throw new SQLException(e);
            }
        }
    }

    protected void disconnect() {
        try {
            if (dbcConnection != null && !dbcConnection.isClosed()) {
                dbcConnection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción apropiadamente según tu aplicación
        }
    }

    public boolean insertCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?)";
        try {
            connect();
            PreparedStatement statement = dbcConnection.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getDireccion());
            statement.setInt(4, cliente.getDni());
            statement.setDate(5, new java.sql.Date(cliente.getFecha().getTime()));
            boolean rowInserted = statement.executeUpdate() > 0;
            statement.close();
            return rowInserted;
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente según tu aplicación
            return false;
        } finally {
            disconnect();
        }
    }

public List<Cliente> listAllClientes() throws SQLException {
     List<Cliente> listCliente = new ArrayList<>();

     String sql = "SELECT * FROM cliente";

     connect();

     Statement statement = dbcConnection.createStatement();
     ResultSet resultSet = statement.executeQuery(sql);

     while (resultSet.next()) {
         int id = resultSet.getInt("id");
         String nombre = resultSet.getString("nombre");
         String apellido = resultSet.getString("apellido");
         String direccion = resultSet.getString("direccion");
         int dni = resultSet.getInt("dni");
         Date fecha = resultSet.getDate("fecha");

         Cliente cliente = new Cliente();
         cliente.setId(id);
         cliente.setNombre(nombre);
         cliente.setApellido(apellido);
         cliente.setDireccion(direccion);
         cliente.setDni(dni);
         cliente.setFecha(fecha);

         listCliente.add(cliente);
     }

     resultSet.close();
     statement.close();

     disconnect();

     return listCliente;
 }
 public boolean updateCliente(Cliente cliente) throws SQLException {
     String sql = "UPDATE cliente SET nombre = ?, apellido = ?, direccion = ?, dni = ?, fecha = ? WHERE id = ?";
     connect();

     PreparedStatement statement = dbcConnection.prepareStatement(sql);
     statement.setString(1, cliente.getNombre());
     statement.setString(2, cliente.getApellido());
     statement.setString(3, cliente.getDireccion());
     statement.setInt(4, cliente.getDni());
     statement.setDate(5, (java.sql.Date) cliente.getFecha());
     statement.setInt(6, cliente.getId());

     boolean rowUpdated = statement.executeUpdate() > 0;
     statement.close();
     disconnect();
     return rowUpdated;
 }

 public boolean deleteCliente(int id) throws SQLException {
     String sql = "DELETE FROM cliente WHERE id = ?";

     connect();

     PreparedStatement statement = dbcConnection.prepareStatement(sql);
     statement.setInt(1, id);

     boolean rowDeleted = statement.executeUpdate() > 0;
     statement.close();
     disconnect();
     return rowDeleted;
 }
}
