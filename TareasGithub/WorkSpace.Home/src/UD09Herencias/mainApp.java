package UD09Herencias;
public class mainApp{

    public static void main(String[] args) {
        // Crear un array de Electrodomesticos de 10 posiciones
    	T9Ej1Electrodomesticos[] electrodomesticos = new T9Ej1Electrodomesticos[10];

        // Asignar a cada posición un objeto de las clases anteriores con los valores deseados
        electrodomesticos[0] = new Lavadora(200, 50, "blanco", 'A', 7);
        electrodomesticos[1] = new Lavadora(300, 40, "negro", 'B', 10);
        electrodomesticos[2] = new Televisor(400, 20, "rojo", 'C', 32, true);
        electrodomesticos[3] = new Televisor(500, 30, "azul", 'D', 50, false);
        electrodomesticos[4] = new Lavadora(250, 45, "gris", 'E', 8);
        electrodomesticos[5] = new Televisor(600, 35, "negro", 'F', 42, true);
        electrodomesticos[6] = new Lavadora(350, 55, "blanco", 'A', 9);
        electrodomesticos[7] = new Televisor(700, 25, "rojo", 'B', 48, false);
        electrodomesticos[8] = new Televisor(800, 40, "azul", 'C', 55, true);
        electrodomesticos[9] = new Lavadora(400, 60, "gris", 'D', 11);

        // Recorrer el array y ejecutar el método precioFinal
        double precioTotalElectrodomesticos = 0;
        double precioTotalLavadoras = 0;
        double precioTotalTelevisores = 0;

        for (T9Ej1Electrodomesticos electrodomestico : electrodomesticos) {
            if (electrodomestico instanceof Lavadora) {
                precioTotalLavadoras += electrodomestico.precioFinal();
            } else if (electrodomestico instanceof Televisor) {
                precioTotalTelevisores += electrodomestico.precioFinal();
            }
            precioTotalElectrodomesticos += electrodomestico.precioFinal();
        }

        // Mostrar los precios por tipo de electrodoméstico y la suma total
        System.out.println("Precio total de las Lavadoras: " + precioTotalLavadoras + " €");
        System.out.println("Precio total de los Televisores: " + precioTotalTelevisores + " €");
        System.out.println("Precio total de todos los Electrodomésticos: " + precioTotalElectrodomesticos + " €");
    }
}