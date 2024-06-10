package com.UD22.MVC.TA22_Ejercicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class controllerEj1T22 {
 private vistaEj1T22 vista;
 private ClienteAdmin admin;

 public controllerEj1T22(vistaEj1T22 vista, ClienteAdmin admin) {
     this.vista = vista;
     this.admin = admin;

     this.vista.addInsertListener(new InsertListener());
     this.vista.addListListener(new ListListener());
     // Add more listeners for update and delete
 }

 class InsertListener implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent e) {
         String nombre = vista.getNombre();
         String apellido = vista.getApellido();
         String direccion = vista.getDireccion();
         int dni = vista.getDni();
         Date fecha = vista.getFecha();

         Cliente cliente = new Cliente();
         cliente.setNombre(nombre);
         cliente.setApellido(apellido);
         cliente.setDireccion(direccion);
         cliente.setDni(dni);
         cliente.setFecha(fecha);

         admin.insertCliente(cliente);
		 vista.showMessage("Cliente añadido correctamente!");
     }
 }

 class ListListener implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent e) {
         try {
             vista.displayClientes(admin.listAllClientes());
         } catch (SQLException ex) {
             vista.showError("Error al listar clientes: " + ex.getMessage());
         }
     }
 }
 class UpdateListener implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent e) {
         int id = vista.getId();
         String nombre = vista.getNombre();
         String apellido = vista.getApellido();
         String direccion = vista.getDireccion();
         int dni = vista.getDni();
         Date fecha = vista.getFecha();

         Cliente cliente = new Cliente();
         cliente.setId(id);
         cliente.setNombre(nombre);
         cliente.setApellido(apellido);
         cliente.setDireccion(direccion);
         cliente.setDni(dni);
         cliente.setFecha(fecha);

         try {
             admin.updateCliente(cliente);
             vista.showMessage("Cliente actuaizado correctamente!");
         } catch (SQLException ex) {
             vista.showError("Error al actualizar cliente: " + ex.getMessage());
         }
     }
 }

 class DeleteListener implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent e) {
         int id = vista.getId();

         try {
             admin.deleteCliente(id);
             vista.showMessage("Cliente eliminado correctamente!");
         } catch (SQLException ex) {
             vista.showError("Error borrando cliente: " + ex.getMessage());
         }
     }
 }
}
