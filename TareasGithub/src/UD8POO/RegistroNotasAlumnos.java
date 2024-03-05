package UD8POO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistroNotasAlumnos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el número de alumnos
        System.out.print("Ingrese el número de alumnos/as en la clase: ");
        int numAlumnos = scanner.nextInt();

        // Crear un HashMap para almacenar nombres y notas
        Map<String, Alumno> alumnos = new HashMap<>();

        // Pedir información para cada alumno
        for (int i = 1; i <= numAlumnos; i++) {
            System.out.print("Ingrese el nombre del alumno/a " + i + ": ");
            String nombre = scanner.next();

            // Crear un objeto Alumno y agregarlo al HashMap
            Alumno alumno = new Alumno();
            alumnos.put(nombre, alumno);

            // Pedir dos notas parciales
            for (int j = 1; j <= 2; j++) {
                System.out.print("Ingrese la nota parcial " + j + " para " + nombre + ": ");
                double nota = scanner.nextDouble();
                alumno.agregarNota(nota);
            }
        }

        // Mostrar la información almacenada
        System.out.println("\nInformación de los alumnos/as:");
        for (Map.Entry<String, Alumno> entry : alumnos.entrySet()) {
            String nombre = entry.getKey();
            Alumno alumno = entry.getValue();
            System.out.println("Nombre: " + nombre);
            System.out.println("Notas parciales: " + alumno.getNotas());
            System.out.println("Promedio: " + alumno.calcularPromedio());
            System.out.println();
        }
    }
}

class Alumno {
    private double nota1;
    private double nota2;

    public void agregarNota(double nota) {
        if (nota1 == 0) {
            nota1 = nota;
        } else {
            nota2 = nota;
        }
    }

    public double calcularPromedio() {
        return (nota1 + nota2) / 2;
    }

    public String getNotas() {
        return nota1 + ", " + nota2;
    }
}