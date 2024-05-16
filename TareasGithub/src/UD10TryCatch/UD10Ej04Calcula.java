package UD10TryCatch;

import java.util.Scanner;
import UD10TryCatchExceptions.CalculadoraException;
import UD10TryCatchExceptions.DivisionX0Except;

public class UD10Ej04Calcula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();

            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();

            System.out.println("Seleccione la operación:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz cuadrada");
            System.out.println("7. Raíz cúbica");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            double resultado = 0;

            switch (opcion) {
                case 1:
                    resultado = num1 + num2;
                    break;
                case 2:
                    resultado = num1 - num2;
                    break;
                case 3:
                    resultado = num1 * num2;
                    break;
                case 4:
                    if (num2 == 0) {
                        throw new DivisionX0Except("¡Error! División por cero.");
                    }
                    resultado = num1 / num2;
                    break;
                case 5:
                    resultado = Math.pow(num1, num2);
                    break;
                case 6:
                    if (num1 < 0) {
                        throw new CalculadoraException("¡Error! No se puede calcular la raíz cuadrada de un número negativo.");
                    }
                    resultado = Math.sqrt(num1);
                    break;
                case 7:
                    if (num1 < 0) {
                        throw new CalculadoraException("¡Error! No se puede calcular la raíz cúbica de un número negativo.");
                    }
                    resultado = Math.cbrt(num1);
                    break;
                default:
                    throw new CalculadoraException("¡Error! Opción inválida.");
            }

            System.out.println("El resultado es: " + resultado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
