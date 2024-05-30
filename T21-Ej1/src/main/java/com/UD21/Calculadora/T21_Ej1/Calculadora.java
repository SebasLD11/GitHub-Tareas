package com.UD21.Calculadora.T21_Ej1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField display;
    private double tempFirst = 0.0;
    private double tempSecond = 0.0;
    private boolean[] operation = new boolean[4];
    private JButton[] buttons = new JButton[16];

    public Calculadora() {
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttonText = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(buttonText[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 30));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case ".":
                    display.setText(display.getText() + command);
                    break;
                case "/":
                    tempFirst = Double.parseDouble(display.getText());
                    operation[0] = true;
                    display.setText("");
                    break;
                case "*":
                    tempFirst = Double.parseDouble(display.getText());
                    operation[1] = true;
                    display.setText("");
                    break;
                case "-":
                    tempFirst = Double.parseDouble(display.getText());
                    operation[2] = true;
                    display.setText("");
                    break;
                case "+":
                    tempFirst = Double.parseDouble(display.getText());
                    operation[3] = true;
                    display.setText("");
                    break;
                case "=":
                    tempSecond = Double.parseDouble(display.getText());
                    if (operation[0]) {
                        display.setText(String.valueOf(tempFirst / tempSecond));
                    } else if (operation[1]) {
                        display.setText(String.valueOf(tempFirst * tempSecond));
                    } else if (operation[2]) {
                        display.setText(String.valueOf(tempFirst - tempSecond));
                    } else if (operation[3]) {
                        display.setText(String.valueOf(tempFirst + tempSecond));
                    }
                    clearOperationFlags();
                    break;
            }
        } catch (NumberFormatException ex) {
            display.setText("Error: Entrada no válida");
        } catch (ArithmeticException ex) {
            display.setText("Error: " + ex.getMessage());
        }
    }

    private void clearOperationFlags() {
        for (int i = 0; i < 4; i++) {
            operation[i] = false;
        }
    }
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero");
        }
        return a / b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double add(double a, double b) {
        return a + b;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora calculadora = new Calculadora();
            calculadora.setVisible(true);
        });
    }
}
