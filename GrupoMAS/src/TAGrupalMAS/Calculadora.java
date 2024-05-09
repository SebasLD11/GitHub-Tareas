package TAGrupalMAS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calculadora extends JFrame {

    private JTextPane display;
    private StringBuilder currentNumber;
    private double firstOperand;
    private String operator;
    private boolean startNewNumber;

    public Calculadora() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 400));

        JPanel panel = new JPanel(new BorderLayout());

        display = new JTextPane();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        panel.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "C", "+",
            "="
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String buttonText = ((JButton) e.getSource()).getText();
            if (Character.isDigit(buttonText.charAt(0)) || buttonText.equals(".")) {
                if (startNewNumber) {
                    display.setText("");
                    currentNumber = new StringBuilder();
                    startNewNumber = false;
                }
                currentNumber.append(buttonText);
                display.setText(display.getText() + buttonText);
            } else if (buttonText.equals("C")) {
                display.setText("");
                currentNumber = new StringBuilder();
                startNewNumber = false;
            } else if (buttonText.equals("=")) {
                if (!startNewNumber) {
                    double secondOperand = Double.parseDouble(currentNumber.toString());
                    double result = performOperation(firstOperand, secondOperand, operator);
                    display.setText(formatResult(result));
                    startNewNumber = true;
                }
            } else {
                if (!startNewNumber) {
                    firstOperand = Double.parseDouble(currentNumber.toString());
                    operator = buttonText;
                    startNewNumber = true;
                }
            }
        }
    }

    private double performOperation(double op1, double op2, String operator) {
        switch (operator) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                if (op2 == 0) {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                } else {
                    return op1 / op2;
                }
            default:
                return 0;
        }
    }

    private String formatResult(double result) {
        DecimalFormat df = new DecimalFormat("#.##########");
        return df.format(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculadora().setVisible(true));
    }
}
