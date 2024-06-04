	package com.UD21.Calculadora.T21_Ej1;
	
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.HashMap;
	import java.util.Map;
	
	public class CalcDivisas extends JFrame implements ActionListener {
	    private static final long serialVersionUID = 1L;
	    protected JTextField display;
	    private JTextArea historyArea;
	    private JButton convertButton;
	    private JButton[] numberButtons;
	    private JButton dotButton, clearButton;
	    private Map<String, Double> rateCache = new HashMap<>();
	    protected StringBuilder currentInput = new StringBuilder();
	
	    public CalcDivisas() {
	        setTitle("Calculadora de Divisas");
	        setSize(500, 500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());
	
	        // Panel superior con título
	        JPanel topPanel = new JPanel();
	        topPanel.setLayout(new BorderLayout());
	        topPanel.setBackground(new Color(30, 144, 255));
	
	        JLabel titleLabel = new JLabel("Calculadora de Divisas", JLabel.CENTER);
	        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
	        titleLabel.setForeground(Color.WHITE);
	        topPanel.add(titleLabel, BorderLayout.CENTER);
	
	        add(topPanel, BorderLayout.NORTH);
	
	        // Panel central con display, botones y historial
	        JPanel centerPanel = new JPanel();
	        centerPanel.setLayout(new BorderLayout());
	        centerPanel.setBackground(new Color(240, 248, 255));
	
	        display = new JTextField();
	        display.setEditable(false);
	        display.setFont(new Font("Arial", Font.BOLD, 24));
	        display.setHorizontalAlignment(JTextField.RIGHT);
	        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        centerPanel.add(display, BorderLayout.NORTH);
	
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
	        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	
	        // Crear botones numéricos
	        numberButtons = new JButton[10];
	        for (int i = 0; i < 10; i++) {
	            numberButtons[i] = new JButton(String.valueOf(i));
	            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 24));
	            numberButtons[i].setBackground(new Color(211, 211, 211));
	            numberButtons[i].setFocusPainted(false);
	            numberButtons[i].addActionListener(this);
	            buttonPanel.add(numberButtons[i]);
	        }
	
	        dotButton = new JButton(".");
	        dotButton.setFont(new Font("Arial", Font.BOLD, 24));
	        dotButton.setBackground(new Color(211, 211, 211));
	        dotButton.setFocusPainted(false);
	        dotButton.addActionListener(this);
	        buttonPanel.add(dotButton);
	
	        clearButton = new JButton("C");
	        clearButton.setFont(new Font("Arial", Font.BOLD, 24));
	        clearButton.setBackground(new Color(255, 69, 0));
	        clearButton.setForeground(Color.WHITE);
	        clearButton.setFocusPainted(false);
	        clearButton.addActionListener(this);
	        buttonPanel.add(clearButton);
	
	        convertButton = new JButton("Convertir");
	        convertButton.setFont(new Font("Arial", Font.BOLD, 24));
	        convertButton.setBackground(new Color(30, 144, 255));
	        convertButton.setForeground(Color.WHITE);
	        convertButton.setFocusPainted(false);
	        convertButton.addActionListener(this);
	        buttonPanel.add(convertButton);
	
	        centerPanel.add(buttonPanel, BorderLayout.CENTER);
	
	        // Historial de conversiones
	        historyArea = new JTextArea();
	        historyArea.setEditable(false);
	        historyArea.setFont(new Font("Arial", Font.PLAIN, 16));
	        JScrollPane scrollPane = new JScrollPane(historyArea);
	        scrollPane.setBorder(BorderFactory.createTitledBorder("Historial de conversiones"));
	        centerPanel.add(scrollPane, BorderLayout.SOUTH);
	
	        add(centerPanel, BorderLayout.CENTER);
	
	        // Inicializar tasas de cambio estáticas
	        initializeStaticRates();
	    }
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        Object source = e.getSource();
	
	        if (source == convertButton) {
	            try {
	                convertCurrency();
	            } catch (Exception ex) {
	                display.setText("Error: No se pudo realizar la conversión");
	            }
	        } else if (source == clearButton) {
	            currentInput.setLength(0);
	            display.setText("");
	        } else if (source == dotButton) {
	            if (!currentInput.toString().contains(".")) {
	                currentInput.append(".");
	                display.setText(currentInput.toString());
	            }
	        } else {
	            for (int i = 0; i < 10; i++) {
	                if (source == numberButtons[i]) {
	                    currentInput.append(i);
	                    display.setText(currentInput.toString());
	                    break;
	                }
	            }
	        }
	    }
	
	    protected void convertCurrency() throws Exception {
	        String amountText = currentInput.toString();
	        if (amountText.isEmpty()) {
	            display.setText("Error: Entrada no válida");
	            return;
	        }
	
	        double amount;
	        try {
	            amount = Double.parseDouble(amountText);
	        } catch (NumberFormatException e) {
	            display.setText("Error: Entrada no válida");
	            return;
	        }
	
	        String fromCurrency = (String) JOptionPane.showInputDialog(this, "De moneda:", "Moneda", JOptionPane.QUESTION_MESSAGE, null, new String[]{"USD", "EUR", "GBP"}, "USD");
	        String toCurrency = (String) JOptionPane.showInputDialog(this, "A moneda:", "Moneda", JOptionPane.QUESTION_MESSAGE, null, new String[]{"USD", "EUR", "GBP"}, "USD");
	
	        if (fromCurrency == null || toCurrency == null) {
	            display.setText("Error: Moneda no seleccionada");
	            return;
	        }
	
	        double rate = getExchangeRate(fromCurrency, toCurrency);
	        double result = amount * rate;
	        display.setText(String.format("%.2f %s", result, toCurrency));
	
	        // Actualizar historial
	        historyArea.append(String.format("%s %s = %.2f %s\n", amountText, fromCurrency, result, toCurrency));
	        currentInput.setLength(0);
	    }
	
	    protected void initializeStaticRates() {
	        // Tasas de cambio simuladas
	        rateCache.put("USDUSD", 1.0);
	        rateCache.put("USDEUR", 0.85);
	        rateCache.put("USDGBP", 0.75);
	        rateCache.put("EURUSD", 1.18);
	        rateCache.put("EUREUR", 1.0);
	        rateCache.put("EURGBP", 0.88);
	        rateCache.put("GBPUSD", 1.33);
	        rateCache.put("GBPEUR", 1.14);
	        rateCache.put("GBPGBP", 1.0);
	    }
	
	    protected double getExchangeRate(String from, String to) {
	        String key = from + to;
	        return rateCache.getOrDefault(key, 1.0); // Default to 1.0 if no rate is found
	    }
	
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            CalcDivisas converter = new CalcDivisas();
	            converter.setVisible(true);
	        });
	    }
	}
