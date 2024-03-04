package ud6JavaBasics;

import java.util.Scanner;

public class Ej07TA06 {

		 public static void main(String[] args) {
		        
		        Scanner scanner = new Scanner(System.in);

		        System.out.println("Ingresa la cantidad de euros a convertir: ");
		        double cantidadEuros = scanner.nextDouble();

		        System.out.println("Ingresa la moneda a la que quieres convertir (libras, dolares o yenes): ");
		        String monedaDestino = scanner.next().toLowerCase();

		        convertirDivisas(cantidadEuros, monedaDestino);

		        scanner.close();
		    }

		    public static void convertirDivisas(double cantidadEuros, String monedaDestino) {
		        double tasaCambio = 0.0;
		        String nombreMoneda = "";

		        switch (monedaDestino) {
		            case "libras":
		                tasaCambio = 0.86;
		                nombreMoneda = "libras";
		                break;
		            case "dolares":
		                tasaCambio = 1.28611;
		                nombreMoneda = "dólares";
		                break;
		            case "yenes":
		                tasaCambio = 129.852;
		                nombreMoneda = "yenes";
		                break;
		            default:
		                System.out.println("Moneda no válida. Ingresa libras, dólares o yenes.");
		                return; // Sale del método si la moneda no es válida
		        }

		        double cantidadConvertida = cantidadEuros * tasaCambio;
		        System.out.println(cantidadEuros + " euros es igual a " + cantidadConvertida + " " + nombreMoneda);
		    }

		}