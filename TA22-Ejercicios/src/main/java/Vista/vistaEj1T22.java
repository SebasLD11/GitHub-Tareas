package Vista;
	import Modelo.Cliente;
	import javax.swing.*;
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
	        setTitle("Cliente Management");
	        setSize(400, 500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new FlowLayout());

	        idField = new JTextField(20);
	        nombreField = new JTextField(20);
	        apellidoField = new JTextField(20);
	        direccionField = new JTextField(20);
	        dniField = new JTextField(20);
	        fechaField = new JTextField(20);

	        insertButton = new JButton("Insert");
	        listButton = new JButton("List All");
	        updateButton = new JButton("Update");
	        deleteButton = new JButton("Delete");

	        displayArea = new JTextArea(10, 30);

	        add(new JLabel("ID:"));
	        add(idField);
	        add(new JLabel("Nombre:"));
	        add(nombreField);
	        add(new JLabel("Apellido:"));
	        add(apellidoField);
	        add(new JLabel("Direccion:"));
	        add(direccionField);
	        add(new JLabel("DNI:"));
	        add(dniField);
	        add(new JLabel("Fecha (YYYY-MM-DD):"));
	        add(fechaField);

	        add(insertButton);
	        add(listButton);
	        add(updateButton);
	        add(deleteButton);

	        add(new JScrollPane(displayArea));

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

