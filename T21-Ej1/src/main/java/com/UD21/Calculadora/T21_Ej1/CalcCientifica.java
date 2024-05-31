package com.UD21.Calculadora.T21_Ej1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcCientifica extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    public JTextField display; // Aseguramos que display es público para las pruebas
    private double tempFirst = 0.0;
    private double tempSecond = 0.0;
    public double memory = 0.0; // Aseguramos que memory es público para las pruebas
    private boolean[] operation = new boolean[4]; // /, *, -, +
    public JButton[] buttons = new JButton[28]; // Botones adicionales para la funcionalidad científica

    public CalcCientifica() {
        setTitle("Calculadora Científica");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 4)); // Aumentamos a 7 filas para incluir los botones científicos

        String[] buttonText = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "MC", "MR", "M+", "M-",
            "sin", "cos", "tan", "log", "ln", "sqrt", "π", "^"
        };

        for (int i = 0; i < 28; i++) {
            buttons[i] = new JButton(buttonText[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
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
                case "0": case "1": case "2": case "3": case "4":
                case "5": case "6": case "7": case "8": case "9":
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
                case "sin":
                    display.setText(String.valueOf(Math.sin(Double.parseDouble(display.getText()))));
                    break;
                case "cos":
                    display.setText(String.valueOf(Math.cos(Double.parseDouble(display.getText()))));
                    break;
                case "tan":
                    display.setText(String.valueOf(Math.tan(Double.parseDouble(display.getText()))));
                    break;
                case "log":
                    display.setText(String.valueOf(Math.log10(Double.parseDouble(display.getText()))));
                    break;
                case "ln":
                    display.setText(String.valueOf(Math.log(Double.parseDouble(display.getText()))));
                    break;
                case "sqrt":
                    display.setText(String.valueOf(Math.sqrt(Double.parseDouble(display.getText()))));
                    break;
                case "π":
                    display.setText(String.valueOf(Math.PI));
                    break;
                case "^":
                    tempFirst = Double.parseDouble(display.getText());
                    display.setText("");
                    operation[0] = true; // Usamos el mismo indicador para operaciones
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
            CalcCientifica calculadora = new CalcCientifica();
            calculadora.setVisible(true);
    });}}
