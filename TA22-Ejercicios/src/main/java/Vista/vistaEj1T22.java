package Vista;

import Modelo.Cliente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

public class vistaEj1T22 extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField idField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField direccionField;
    private JTextField dniField;
    private JTextField fechaField;
    private JButton insertButton;
    private JButton listButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTextArea displayArea;

    public vistaEj1T22() {
        setTitle("Cliente CRUD");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Añadir margen al topPanel
        
        idField = new JTextField(20);
        nombreField = new JTextField(20);
        apellidoField = new JTextField(20);
        direccionField = new JTextField(20);
        dniField = new JTextField(20);
        fechaField = new JTextField(20);

        insertButton = new JButton("Insertar");
        listButton = new JButton("Listar Todos");
        updateButton = new JButton("Actualizar");
        deleteButton = new JButton("Eliminar");

        displayArea = new JTextArea(30, 50);

        topPanel.add(new JLabel("ID:"));
        topPanel.add(idField);
        topPanel.add(new JLabel("Nombre:"));
        topPanel.add(nombreField);
        topPanel.add(new JLabel("Apellido:"));
        topPanel.add(apellidoField);
        topPanel.add(new JLabel("Direccion:"));
        topPanel.add(direccionField);
        topPanel.add(new JLabel("DNI:"));
        topPanel.add(dniField);
        topPanel.add(new JLabel("Fecha (YYYY-MM-DD):"));
        topPanel.add(fechaField);

     // Panel para botones CRUD
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Añadir margen al buttonPanel
        
        buttonPanel.add(insertButton);
        buttonPanel.add(listButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        
     // Añadir los paneles al panel superior
        JPanel combinedTopPanel = new JPanel(new BorderLayout());
        combinedTopPanel.add(topPanel, BorderLayout.CENTER);
        combinedTopPanel.add(buttonPanel, BorderLayout.SOUTH);

        displayArea = new JTextArea(15, 50);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10)); // Añadir margen al scrollPane
        
        add(combinedTopPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public int getId() {
        return Integer.parseInt(idField.getText());
    }

    public String getNombre() {
        return nombreField.getText();
    }

    public String getApellido() {
        return apellidoField.getText();
    }

    public String getDireccion() {
        return direccionField.getText();
    }

    public int getDni() {
        return Integer.parseInt(dniField.getText());
    }

    public Date getFecha() {
        return Date.valueOf(fechaField.getText());
    }

    public void addInsertListener(ActionListener listener) {
        insertButton.addActionListener(listener);
    }

    public void addListListener(ActionListener listener) {
        listButton.addActionListener(listener);
    }

    public void addUpdateListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void displayClientes(List<Cliente> clientes) {
        displayArea.setText("");
        for (Cliente cliente : clientes) {
            displayArea.append(cliente.toString() + "\n");
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
