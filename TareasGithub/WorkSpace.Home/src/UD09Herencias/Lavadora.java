package UD09Herencias;

import javax.swing.JOptionPane;

public class Lavadora extends T9Ej1Electrodomesticos {
    // Atributo
    private int carga;
    private static final int CARGA_DEFAULT = 5;

    // Constructores
    public Lavadora() {
        this(PRECIO_BASE_DEFAULT, PESO_DEFAULT, COLOR_DEFAULT, CONSUMO_ENERGETICO_DEFAULT, CARGA_DEFAULT);
    }

    public Lavadora(double precioBase, double peso) {
        this(precioBase, peso, COLOR_DEFAULT, CONSUMO_ENERGETICO_DEFAULT, CARGA_DEFAULT);
    }

    public Lavadora(double precioBase, double peso, String color, char consumoEnergetico, int carga) {
        super(precioBase, peso, color, consumoEnergetico);
        this.carga = carga;
    }

    // Método get de carga
    public int getCarga() {
        return carga;
    }

    // Método precioFinal
    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (carga > 30) {
            precioFinal += 50;
        }

        return precioFinal;
    }

    public static void main(String[] args) {
        double precioBase = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio base:"));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Introduce el peso:"));
        String color = JOptionPane.showInputDialog("Introduce el color:");
        char consumoEnergetico = JOptionPane.showInputDialog("Introduce el consumo energético (de A a F):").charAt(0);
        int carga = Integer.parseInt(JOptionPane.showInputDialog("Introduce la carga:"));

        Lavadora lavadora = new Lavadora(precioBase, peso, color, consumoEnergetico, carga);

        JOptionPane.showMessageDialog(null, "Información de la lavadora:\n" +
                "Precio Base: " + lavadora.getPrecioBase() + " €\n" +
                "Color: " + lavadora.getColor() + "\n" +
                "Consumo Energético: " + lavadora.getConsumoEnergetico() + "\n" +
                "Peso: " + lavadora.getPeso() + " kg\n" +
                "Carga: " + lavadora.getCarga() + " kg\n" +
                "Precio Final: " + lavadora.precioFinal() + " €");
    }
}