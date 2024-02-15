package ud5JavaBasics;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class EjSorteoExtra {

	public static void main(String[] args) {
		//pedir strings por pantalla
		//realizar recorrido del array y mostrar participantes en lista
		//con método Math.random escoger ganador/a
		//rango del 0 al 2(lenght-1) te arroje un ganador.
		
		Scanner scanner = new Scanner(System.in);
        String[] participantes = new String[10];

        // Nombres de los participantes y lista 
        
        for (int i = 0; i < participantes.length; i++) {
        	
//          System.out.print("Ingrese el nombre del participante " 
//          				+ (i + 1) + ": ");
//          participantes[i] = scanner.nextLine();
      	
      	participantes[i] = JOptionPane.showInputDialog("Participante " + (i +1) );
     
		JOptionPane.showMessageDialog(null, "\nLista de participantes: " + participantes[i]);
		
		// Mostrar los participantes
		
		for (String participante : participantes) {
   		System.out.println("* " + participante);
					
}
        
        // Sorteo
        
		int indiceGanador = (int) (Math.random() * participantes.length);
        String ganador = participantes[indiceGanador];
//        System.out.println("\n¡El ganador del sorteo es: " + ganador + "!");
        JOptionPane.showMessageDialog(null, "\n¡El ganador del sorteo es: " + ganador + "!");
        
    }
}
}