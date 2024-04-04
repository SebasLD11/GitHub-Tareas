package UD09Herencias;

public class Televisor extends T9Ej1Electrodomesticos {
    // Atributos
    private double resolucion;
    private boolean sintonizadorTDT;
    private static final double RESOLUCION_DEFAULT = 20;
    private static final boolean SINTONIZADOR_TDT_DEFAULT = false;

    // Constructores
    public Televisor() {
        this(PRECIO_BASE_DEFAULT, PESO_DEFAULT, COLOR_DEFAULT, CONSUMO_ENERGETICO_DEFAULT, RESOLUCION_DEFAULT, SINTONIZADOR_TDT_DEFAULT);
    }

    public Televisor(double precioBase, double peso) {
        this(precioBase, peso, COLOR_DEFAULT, CONSUMO_ENERGETICO_DEFAULT, RESOLUCION_DEFAULT, SINTONIZADOR_TDT_DEFAULT);
    }

    public Televisor(double precioBase, double peso, String color, char consumoEnergetico, double resolucion, boolean sintonizadorTDT) {
        super(precioBase, peso, color, consumoEnergetico);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    // Métodos get de resolución y sintonizador TDT
    public double getResolucion() {
        return resolucion;
    }

    public boolean tieneSintonizadorTDT() {
        return sintonizadorTDT;
    }

    // Método precioFinal
    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (resolucion > 40) {
            precioFinal *= 1.3; // Incremento del 30%
        }

        if (sintonizadorTDT) {
            precioFinal += 50;
        }

        return precioFinal;
    }
}