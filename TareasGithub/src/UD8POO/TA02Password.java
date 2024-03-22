package UD8POO;

import java.util.Random;
import javax.swing.JOptionPane;

public class TA02Password {
	
	    // Atributos
	    private int longitud;
	    private String contraseña;

	    // Constructores
	    public TA02Password() {
	        this.longitud = 8; // Longitud por defecto
	        generarContraseñaAleatoria();
	    }

	    public TA02Password(int longitud) {
	        this.longitud = longitud;
	        generarContraseñaAleatoria();
	    }

	    // Métodos para generar una contraseña aleatoria
	    private void generarContraseñaAleatoria() {
	        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder contraA = new StringBuilder();

	        Random random = new Random();
	        for (int i = 0; i < longitud; i++) {
	            int index = random.nextInt(caracteres.length());
	            contraA.append(caracteres.charAt(index));
	        }

	        contraseña = contraA.toString();
	    }

	    // Getters y setters
	    public int getLongitud() {
	        return longitud;
	    }

	    public void setLongitud(int longitud) {
	        this.longitud = longitud;
	    }

	    public String getContraseña() {
	        return contraseña;
	    }

	    public void setContraseña(String contraseña) {
	        this.contraseña = contraseña;
	    }

	    // Método toString para mostrar la información de la contraseña
	    @Override
	    public String toString() {
	        return "Contraseña: " + contraseña + "\nLongitud: " + longitud;
	    }

	    public void mostrarInfo() {
	        JOptionPane.showMessageDialog(null, "Contraseña: " + contraseña + "\nLongitud: " + longitud);
	    }

	    public static void main(String[] args) {
	        // Ejemplo de uso
	    	TA02Password contraseñaPorDefecto = new TA02Password();
	        JOptionPane.showMessageDialog(null, "Contraseña por defecto:\n" + contraseñaPorDefecto);

	        TA02Password contraseñaPersonalizada = new TA02Password(12);
	        JOptionPane.showMessageDialog(null, "Contraseña con longitud personalizada:\n" + contraseñaPersonalizada);
	    }
}