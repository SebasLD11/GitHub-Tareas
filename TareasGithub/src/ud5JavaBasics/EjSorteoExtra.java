package ud5JavaBasics;

import java.util.Scanner;

public class EjSorteoExtra {

	public static void main(String[] args) {
		// pedir 3 strings por pantalla
		//realizar recorrido del array y mostrar 3 participantes en lista
		//con un método Math.random
		//rango del 0 al 2(lenght-1) te arroje un ganador.
		
		Scanner scanner = new Scanner(System.in);
        String[] participantes = new String[10];

        // Nombres de los participantes
        
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el nombre del participante " + (i + 1) + ": ");
            participantes[i] = scanner.nextLine();
        }
        // Mostrar los participantes
        
        System.out.println("\nLista de participantes:");
        for (String participante : participantes) {
            System.out.println("- " + participante);
        }
     // Sorteo
        
        int indiceGanador = (int) (Math.random() * participantes.length);
        String ganador = participantes[indiceGanador];
        System.out.println("\n¡El ganador del sorteo es: " + ganador + "!");
    }
}
	