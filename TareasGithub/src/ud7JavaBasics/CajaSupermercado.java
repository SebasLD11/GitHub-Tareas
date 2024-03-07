package ud7JavaBasics;

import java.util.HashMap;
import java.util.Map;

public class CajaSupermercado {

	private Map<String, Integer> carrito;
    private double iva;

    public CajaSupermercado() {
        carrito = new HashMap<>();
        iva = 0.21; // 
    }

    public void agregarProducto(String nombre, int cantidad) {
        carrito.put(nombre, cantidad);
    }

    public double calcularTotalBruto(Map<String, Double> preciosUnitarios) {
        double totalBruto = 0;
        for (Map.Entry<String, Integer> entry : carrito.entrySet()) {
            String nombreProducto = entry.getKey();
            int cantidad = entry.getValue();
            double precioUnitario = preciosUnitarios.get(nombreProducto);
            totalBruto += cantidad * precioUnitario;
        }
        return totalBruto;
    }

    public double calcularIVA(double totalBruto) {
        return totalBruto * iva;
    }

    public double calcularTotalConIVA(double totalBruto) {
        return totalBruto + calcularIVA(totalBruto);
    }

    public int calcularNumeroArticulos() {
        int numeroArticulos = 0;
        for (int cantidad : carrito.values()) {
            numeroArticulos += cantidad;
        }
        return numeroArticulos;
    }

    public double procesarPago(double cantidadPagada, double totalConIVA) {
        return cantidadPagada - totalConIVA;
    }

    public void mostrarInformacionVenta(double cantidadPagada, Map<String, Double> preciosUnitarios) {
        double totalBruto = calcularTotalBruto(preciosUnitarios);
        double totalConIVA = calcularTotalConIVA(totalBruto);
        
        System.out.println("IVA aplicado: " + (iva * 100) + "%");
        System.out.println("Precio total bruto: " + totalBruto);
        System.out.println("Precio total con IVA: " + totalConIVA);
        System.out.println("Número de artículos comprados: " + calcularNumeroArticulos());
        System.out.println("Cantidad pagada: " + cantidadPagada);
        double cambio = procesarPago(cantidadPagada, totalConIVA);
        System.out.println("Cambio a devolver al cliente: " + cambio);
    }

    public static void main1(String[] args) {
        CajaSupermercado caja = new CajaSupermercado();
        caja.agregarProducto("Leche", 2);
        caja.agregarProducto("Pan", 3);
        caja.agregarProducto("Manzanas", 1);

      
        Map<String, Double> preciosUnitarios = new HashMap<>();
        preciosUnitarios.put("Leche", 1.20);
        preciosUnitarios.put("Pan", 0.80);
        preciosUnitarios.put("Manzanas", 2.50);

        double cantidadPagada = 10.0;
        caja.mostrarInformacionVenta(cantidadPagada, preciosUnitarios);
}
}