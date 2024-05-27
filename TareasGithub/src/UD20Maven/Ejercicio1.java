package UD20Maven;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Crear un nuevo marco (ventana)
        JFrame frame = new JFrame("Interfaz Gráfica");
        
        // Configurar la operación de cierre para salir de la aplicación
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Añadir una etiqueta al contenido de la ventana
        JLabel label = new JLabel("¡Bienvenido a mi aplicación!", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(300, 200)); // Tamaño preferido para la etiqueta
        frame.getContentPane().add(label);

        // Permitir cambiar el tamaño de la ventana
        frame.setResizable(true);

        // Ajustar el tamaño del marco de la ventana al contenido preferido
        frame.pack();
        
        // Hacer visible la ventana
        frame.setVisible(true);
        
        // Configurar el comportamiento al cerrar la ventana usando WindowAdapter
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
