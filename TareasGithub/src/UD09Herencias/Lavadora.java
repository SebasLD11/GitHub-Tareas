package UD09Herencias;

public class Lavadora extends T09Ej1Electrodomesticos {
    // Atributos
    private int carga;
    private static final int CARGA_DEFAULT = 5;

    // Constructores
    public Lavadora() {
        this(PRECIO_BASE_DEFAULT, PESO_DEFAULT, COLOR_DEFECTO, CONSUMO_ENERGETICO_DEFAULT, CARGA_DEFAULT);
    }

    public Lavadora(double precioBase, double peso) {
        this(precioBase, peso, COLOR_DEFECTO, CONSUMO_ENERGETICO_DEFAULT, CARGA_DEFAULT);
    }

    public Lavadora(int carga, double precioBase, double peso, String color, char consumoEnergetico) {
        super(precioBase, peso, color, consumoEnergetico);
        this.carga = carga;
    }

    // Método get de carga
    public int getCarga() {
        return carga;
    }

    // Método precioFinal
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (carga > 30) {
            precioFinal += 50;
        }

        return precioFinal;
    }

    public static void main(String[] args) {
        Lavadora lavadora = new Lavadora();
        System.out.println("Precio Base: " + lavadora.getPrecioBase() + " €");
        System.out.println("Color: " + lavadora.getColor());
        System.out.println("Consumo Energético: " + lavadora.getConsumoEnergetico());
        System.out.println("Peso: " + lavadora.getPeso() + " kg");
        System.out.println("Carga: " + lavadora.getCarga() + " kg");
        System.out.println("Precio Final: " + lavadora.precioFinal() + " €");
    }
}
