package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ClienteAdmin {
 private String dbcURL;
 private String dbcUsername;
 private String dbcPassword;
 private Connection jdbcConnection;

 public ClienteAdmin(String dbcURL, String dbcUsername, String dbcPassword) {
     this.dbcURL = dbcURL;
     this.dbcUsername = dbcUsername;
     this.dbcPassword = dbcPassword;
 }

 protected void connect() throws SQLException {
     if (jdbcConnection == null || jdbcConnection.isClosed()) {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             throw new SQLException(e);
         }
         jdbcConnection = DriverManager.getConnection(dbcURL, dbcUsername, dbcPassword);
     }
 }

 protected void disconnect() throws SQLException {
     if (jdbcConnection != null && !jdbcConnection.isClosed()) {
         jdbcConnection.close();
     }
 }

 public boolean insertCliente(Cliente cliente) throws SQLException {
     String sql = "INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?)";
     connect();

     PreparedStatement statement = jdbcConnection.prepareStatement(sql);
     statement.setString(1, cliente.getNombre());
     statement.setString(2, cliente.getApellido());
     statement.setString(3, cliente.getDireccion());
     statement.setInt(4, cliente.getDni());
     statement.setDate(5, (java.sql.Date) cliente.getFecha());

     boolean rowInserted = statement.executeUpdate() > 0;
     statement.close();
     disconnect();
     return rowInserted;
 }

 public List<Cliente> listAllClientes() throws SQLException {
     List<Cliente> listCliente = new ArrayList<>();

     String sql = "SELECT * FROM cliente";

     connect();

     Statement statement = jdbcConnection.createStatement();
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

     PreparedStatement statement = jdbcConnection.prepareStatement(sql);
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

     PreparedStatement statement = jdbcConnection.prepareStatement(sql);
     statement.setInt(1, id);

     boolean rowDeleted = statement.executeUpdate() > 0;
     statement.close();
     disconnect();
     return rowDeleted;
 }
}
