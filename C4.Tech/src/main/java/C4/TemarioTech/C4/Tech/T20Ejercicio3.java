package C4.TemarioTech.C4.Tech;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class T20Ejercicio3 {
    public static void main(String[] args) {
        // Crear el marco (ventana)
        JFrame frame = new JFrame("Contador de Clics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(2, 2));

        // Crear las etiquetas
        JLabel label1 = new JLabel("Botón 1: 0 clics", SwingConstants.CENTER);
        JLabel label2 = new JLabel("Botón 2: 0 clics", SwingConstants.CENTER);

        // Crear los botones
        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");

        // Contadores de clics
        final int[] clickCount1 = {0};
        final int[] clickCount2 = {0};

        // Añadir comportamiento a los botones
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount1[0]++;
                label1.setText("Botón 1: " + clickCount1[0] + " clics");
            }
        });
 
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount2[0]++;
                label2.setText("Botón 2: " + clickCount2[0] + " clics");
            }
        });

        // Añadir componentes al marco
        frame.add(label1);
        frame.add(label2);
        frame.add(button1);
        frame.add(button2);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
