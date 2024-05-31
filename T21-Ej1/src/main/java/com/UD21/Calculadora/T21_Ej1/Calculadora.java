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
    private double memory = 0.0; // Variable de memoria
    private boolean[] operation = new boolean[4]; // /, *, -, +
    private JButton[] buttons = new JButton[21]; // 17 botones originales + 4 botones de memoria

    public Calculadora() {
        setTitle("Calculadora");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4)); // Aumentamos a 6 filas para incluir los botones de memoria

        String[] buttonText = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "MC", "MR", "M+", "M-" // Botones de borrado y memoria
        };

        for (int i = 0; i < 21; i++) {
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
                        display.setText(String.valueOf(divide(tempFirst, tempSecond)));
                    } else if (operation[1]) {
                        display.setText(String.valueOf(multiply(tempFirst, tempSecond)));
                    } else if (operation[2]) {
                        display.setText(String.valueOf(subtract(tempFirst, tempSecond)));
                    } else if (operation[3]) {
                        display.setText(String.valueOf(add(tempFirst, tempSecond)));
                    }
                    clearOperationFlags();
                    break;
                case "C":
                    display.setText("");
                    clearOperationFlags();
                    break;
                case "MC":
                    memoryClear();
                    break;
                case "MR":
                    memoryRecall();
                    break;
                case "M+":
                    memoryAdd(Double.parseDouble(display.getText()));
                    break;
                case "M-":
                    memorySubtract(Double.parseDouble(display.getText()));
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

    public void memoryClear() {
        memory = 0.0;
    }

    public void memoryRecall() {
        display.setText(String.valueOf(memory));
    }

    public void memoryAdd(double value) {
        memory += value;
    }

    public void memorySubtract(double value) {
        memory -= value;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora calculadora = new Calculadora();
            calculadora.setVisible(true);
        });
    }
}
