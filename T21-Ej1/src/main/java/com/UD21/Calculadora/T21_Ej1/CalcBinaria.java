package com.UD21.Calculadora.T21_Ej1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcBinaria extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    public JTextField display;
    private boolean[] operation = new boolean[8]; // Operaciones binarias: AND, OR, XOR, Shift left, Shift right
    public JButton[] buttons = new JButton[20]; // Botones para dígitos binarios, operaciones binarias y conversiones

    private StringBuilder currentBinary = new StringBuilder();
    private int firstOperand;
    private int secondOperand;
    private int memoryStore;

    public CalcBinaria() {
        setTitle("Calculadora Binaria");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4)); // 5x4 grid for buttons

        String[] buttonText = {
            "HEX", "DEC", "OCT", "BIN",
            "1", "2", "3", "AND",
            "4", "5", "6", "OR",
            "7", "8", "9", "XOR",
            "C", "0", "=", "/", "MS"
        };

        for (int i = 0; i < 20; i++) {
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
                case "HEX":
                    display.setText(Integer.toHexString(Integer.parseInt(currentBinary.toString(), 2)));
                    break;
                case "DEC":
                    display.setText(Integer.toString(Integer.parseInt(currentBinary.toString(), 2)));
                    break;
                case "OCT":
                    display.setText(Integer.toOctalString(Integer.parseInt(currentBinary.toString(), 2)));
                    break;
                case "BIN":
                    display.setText(currentBinary.toString());
                    break;
                case "C":
                    clear();
                    break;
                case "=":
                    secondOperand = Integer.parseInt(currentBinary.toString(), 2);
                    currentBinary.setLength(0); // Clear StringBuilder
                    int result = 0;

                    if (operation[0]) {
                        result = firstOperand & secondOperand; // AND operation
                    } else if (operation[1]) {
                        result = firstOperand | secondOperand; // OR operation
                    } else if (operation[2]) {
                        result = firstOperand ^ secondOperand; // XOR operation
                    } else if (operation[7]) {
                        result = firstOperand >> secondOperand; // Right shift operation
                    } else {
                        throw new IllegalArgumentException("Operación no válida");
                    }

                    display.setText(Integer.toBinaryString(result));
                    clear();
                    break;
                case "/":
                    operation[7] = true; // Right shift operation placeholder
                    break;
                case "MS":
                    memoryStore();
                    break;
                default:
                    if (isBinaryDigit(command)) {
                        currentBinary.append(command);
                        display.setText(currentBinary.toString());
                    } else if (isDecimalDigit(command)) {
                        convertDecimalToBinary(command);
                    } else {
                        throw new IllegalArgumentException("Entrada no válida: " + command);
                    }
                    break;
            }
        } catch (NumberFormatException ex) {
            display.setText("Error: Entrada no válida");
        } catch (Exception ex) {
            ex.printStackTrace(); // Manejo de cualquier otra excepción no controlada
        }
    }


    private boolean isBinaryDigit(String digit) {
        return digit.equals("0") || digit.equals("1");
    }

    private boolean isDecimalDigit(String digit) {
        return digit.matches("[0-9]");
    }

    private void convertDecimalToBinary(String decimalDigit) {
        int decimalValue = Integer.parseInt(decimalDigit);
        String binaryValue = Integer.toBinaryString(decimalValue);
        display.setText(binaryValue);
        currentBinary.append(binaryValue);
    }

    private void clear() {
        currentBinary.setLength(0);
        display.setText("");
        for (int i = 0; i < 8; i++) {
            operation[i] = false;
        }
    }

    private void memoryStore() {
        memoryStore = Integer.parseInt(currentBinary.toString(), 2);
        JOptionPane.showMessageDialog(this, "Data stored in memory: " + Integer.toBinaryString(memoryStore));
        currentBinary.setLength(0); // Clear StringBuilder
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalcBinaria calculadora = new CalcBinaria();
            calculadora.setVisible(true);
        });
    }
}
