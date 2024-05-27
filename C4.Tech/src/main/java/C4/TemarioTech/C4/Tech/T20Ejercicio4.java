package C4.TemarioTech.C4.Tech;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class T20Ejercicio4 {
    public static void main(String[] args) {
        // Crear el marco (ventana)
        JFrame frame = new JFrame("Eventos de Ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        
        // Crear una etiqueta
        JLabel label = new JLabel("Eventos de Ventana:", SwingConstants.CENTER);

        // Crear un área de texto para mostrar los eventos
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // El área de texto no debe ser editable
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Añadir un WindowListener para capturar los eventos de ventana
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                textArea.append("Ventana abierta\n");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                textArea.append("Ventana cerrándose\n");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                textArea.append("Ventana cerrada\n");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                textArea.append("Ventana minimizada\n");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                textArea.append("Ventana restaurada\n");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                textArea.append("Ventana activada\n");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                textArea.append("Ventana desactivada\n");
            }
        });

        // Establecer el diseño del marco
        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}

