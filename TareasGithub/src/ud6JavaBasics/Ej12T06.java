package ud6JavaBasics;

import java.util.Random;

import javax.swing.JOptionPane;

public class Ej12T06 {

		public static void main(String[] args) {
	        int dimension = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño de las arrays"));

	        int[] array = new int[dimension];
	        rellenarArray(array);

	        System.out.println("ARRAY GENERADA :");
	        mostrarArray(array);

	        int digito = Integer.parseInt(JOptionPane.showInputDialog("Introduce un dígito del 0 al 9"));
	        while (digito < 0 || digito > 9) {
	            digito = Integer.parseInt(JOptionPane.showInputDialog("Dígito no válido. Introduce un dígito del 0 al 9"));
	        }

	        System.out.println("\nNúmeros de la array que terminan en " + digito);
	        mostrarArrayDigito(array, digito);

	    }

	    // Rellena una array con enteros aleatorios entre 1 y 300
	    public static void rellenarArray(int[] a) {
	        Random r = new Random();
	        for (int i = 0; i < a.length; i++) {
	            a[i] = r.nextInt(300) + 1;
	        }
	    }

	    // Imprime por consola el contenido de una array
	    public static void mostrarArray(int[] a) {
	        for (int i = 0; i < a.length; i++) {
	            System.out.println("a[" + i + "] : " + a[i]);
	        }
	    }

	    // Imprime por consola los valores del array que teminan en n
	    public static void mostrarArrayDigito(int[] a, int n) {
	        for (int i = 0; i < a.length; i++) {
	            if (a[i] % 10 == n) {
	                System.out.println("a[" + i + "] : " + a[i]);
	            }
	        }
	    }
	}