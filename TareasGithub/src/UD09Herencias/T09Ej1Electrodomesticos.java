package UD09Herencias;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class T09Ej1Electrodomesticos {
    // Constantes
    protected static final List<String> COLORES_DISPONIBLES = Arrays.asList("blanco", "negro", "rojo", "azul", "gris");
    protected static final char CONSUMO_ENERGETICO_DEFAULT = 'F';
    protected static final double PRECIO_BASE_DEFAULT = 100;
    protected static final double PESO_DEFAULT = 5;
    protected static final String COLOR_DEFECTO = "blanco";

    // Atributos
    protected double precioBase;
    protected String color;
    protected static char consumoEnergetico;
    protected double peso;
    private String nuevoColor;

    // Constructores
    public T09Ej1Electrodomesticos() {
        this(PRECIO_BASE_DEFAULT, PESO_DEFAULT,COLOR_DEFECTO, CONSUMO_ENERGETICO_DEFAULT);
    }

    public T09Ej1Electrodomesticos(double precioBase, double peso) {
        this(precioBase, peso, COLOR_DEFECTO, CONSUMO_ENERGETICO_DEFAULT);
    }

    public T09Ej1Electrodomesticos(double precioBase, double peso, String color, char consumoEnergetico) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = comprobarColor(color);
        T09Ej1Electrodomesticos.consumoEnergetico = comprobarConsumoEnergetico();
    }

    // Métodos get
    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    public String getNuevoColor() {
        return nuevoColor;
    }
 
    public void setNuevoColor(String nuevoColor) {
        this.nuevoColor = nuevoColor;
    }

    // Métodos
    private char comprobarConsumoEnergetico() {
        String entrada;
        char letra = CONSUMO_ENERGETICO_DEFAULT;
        boolean valido = false;
        while (!valido) {
            entrada = JOptionPane.showInputDialog(null, "Introduce el consumo energético (de A a F):");
            if (entrada != null && entrada.length() == 1) {
                letra = Character.toUpperCase(entrada.charAt(0));
                if (letra >= 'A' && letra <= 'F') {
                    valido = true;
                }
            }
            if (!valido) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese una letra de A a F.");
            }
        }
        return letra;
    }

    private String comprobarColor(String color) {
        if (COLORES_DISPONIBLES.contains(color.toLowerCase())) {
            return color.toLowerCase();
        } else if(COLORES_DISPONIBLES!=null){
        }
		return nuevoColor();
    }
    public void cambiarColor() {
        String nuevoColor = JOptionPane.showInputDialog(null, "Introduce el nuevo color:");
        if (nuevoColor != null && !nuevoColor.isEmpty()) {
            if (!nuevoColor.equalsIgnoreCase(color)) {
                setColor(nuevoColor);
                JOptionPane.showMessageDialog(null, "El color introducido se ha modificado con éxito: " + nuevoColor, "El nuevo color es:", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El color introducido es el mismo que el predeterminado.", "Color no modificado", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha introducido ningún color.", "Color no especificado", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void mostrarInfo() {
        StringBuilder info = new StringBuilder("Información del electrodoméstico:\n");
        info.append("Precio Base: ").append(precioBase).append("€\n");
        info.append("Consumo Energético: ").append(consumoEnergetico).append("\n");
        switch (consumoEnergetico) {
            case 'A':
                info.append("Recargo por consumo energético: +100€\n");
                break;
            case 'B':
                info.append("Recargo por consumo energético: +80€\n");
                break;
            case 'C':
                info.append("Recargo por consumo energético: +60€\n");
                break;
            case 'D':
                info.append("Recargo por consumo energético: +50€\n");
                break;
            case 'E':
                info.append("Recargo por consumo energético: +30€\n");
                break;
            case 'F':
                info.append("Recargo por consumo energético: +10€\n");
                break;
            default:
                info.append("Recargo por consumo energético: +0€\n");
                break;
        }
        info.append("Peso: ").append(peso).append("Kg\n");
        if (peso >= 0 && peso < 20) {
            info.append("Recargo por peso: +10€\n");
        } else if (peso >= 20 && peso < 50) {
            info.append("Recargo por peso: +50€\n");
        } else if (peso >= 50 && peso < 80) {
            info.append("Recargo por peso: +80€\n");
        } else if (peso >= 80) {
            info.append("Recargo por peso: +100€\n");
        }
        info.append("Color: ").append(color).append("\n");

        JOptionPane.showMessageDialog(null, info.toString());
    }


    public static void main (String[] args) {
        T09Ej1Electrodomesticos info = new T09Ej1Electrodomesticos();
        info.mostrarInfo();
        info.cambiarColor();
    }
}