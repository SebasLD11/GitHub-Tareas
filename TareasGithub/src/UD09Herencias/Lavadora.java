package UD09Herencias;

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
}