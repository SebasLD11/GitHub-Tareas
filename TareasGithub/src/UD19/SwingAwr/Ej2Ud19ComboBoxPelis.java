package UD19.SwingAwr;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ej2Ud19ComboBoxPelis extends JFrame {
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JComboBox<String> comboBox;
	    private JTextField textField;

	    public Ej2Ud19ComboBoxPelis() {
	        setTitle("Lista de Películas");
	        setSize(300, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new FlowLayout());

	        // Crear el JComboBox
	        comboBox = new JComboBox<>();
	        comboBox.setPreferredSize(new Dimension(200, 25));
	        add(comboBox);

	        // Crear el JTextField
	        textField = new JTextField();
	        textField.setPreferredSize(new Dimension(200, 25));
	        add(textField);

	        // Crear el botón
	        JButton addButton = new JButton("Añadir");
	        addButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                agregarPelicula();
	            }
	        });
	        add(addButton);

	        setVisible(true);
	    }

	    private void agregarPelicula() {
	        String pelicula = textField.getText();
	        if (!pelicula.isEmpty()) {
	            comboBox.addItem(pelicula);
	            textField.setText("");
	        }
	    }

	    public static void main(String[] args) {
	    	 // Crear una instancia de la ventana
	    	Ej2Ud19ComboBoxPelis ventana = new Ej2Ud19ComboBoxPelis();
	        // Hacer visible la ventana
	        ventana.setVisible(true);
	    }
	}

