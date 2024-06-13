package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import Modelo.Cliente;
import Modelo.ClienteAdmin;
import Vista.vistaEj1T22;

public class controllerEj1T22 {
    private vistaEj1T22 vista;
    private ClienteAdmin admin;

    public controllerEj1T22(vistaEj1T22 vista, ClienteAdmin admin) {
        this.vista = vista;
        this.admin = admin;

        this.vista.addInsertListener(new InsertarListener());
        this.vista.addListListener(new ListarListener());
        this.vista.addUpdateListener(new ActualizarListener());
        this.vista.addDeleteListener(new BorrarListener());
    }

    class InsertarListener implements ActionListener {
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

            admin.InsertarCliente(cliente);
            vista.showMessage("Cliente añadido correctamente!");
        }
    }

    class ListarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                vista.displayClientes(admin.ListarClientes());
            } catch (SQLException ex) {
                vista.showError("Error al listar clientes: " + ex.getMessage());
            }
        }
    }

    class ActualizarListener implements ActionListener {
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
                admin.ActualizarCliente(cliente);
                vista.showMessage("Cliente actualizado correctamente!");
            } catch (SQLException ex) {
                vista.showError("Error al actualizar cliente: " + ex.getMessage());
            }
        }
    }

    class BorrarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = vista.getId();

            try {
                admin.BorrarCliente(id);
                vista.showMessage("Cliente eliminado correctamente!");
            } catch (SQLException ex) {
                vista.showError("Error borrando cliente: " + ex.getMessage());
            }
        }
    }
}
