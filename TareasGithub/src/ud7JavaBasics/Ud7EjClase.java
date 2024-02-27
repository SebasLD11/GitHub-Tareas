package ud7JavaBasics;

import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ud7EjClase {
	private static boolean nuevosAlumnos;
	private static int edadAlumno;
	private static Scanner scanner;
	private static String nombreAlumno;
	private static int edadAlumno2;
	private static int edadNuevos;

	public static void main(String[] args) {
        // Crear un HashMap con clave de tipo String y valor de tipo Integer
        HashMap<String, Integer> edadesAlumnos = new HashMap<>();


        // Agregar elementos al HashMap
        edadesAlumnos.put("Ruben", 62);
        edadesAlumnos.put("Milena", 44);
        edadesAlumnos.put("Sebas", 29);
        edadesAlumnos.put("Aaron", 28);
        edadesAlumnos.put("Camilo", 27 );
        
        //edadesAlumnos {
        // 		"Ruben"=> 62,
        //		"Milena"=> 44,
        //		"Sebas"=> 29
        //		"Aaron"=> 28
        //		"Camilo"=> 27
        //}

        // Obtener el valor asociado a una clave
        int edadDeRuben = edadesAlumnos.get("Ruben"); //62
        int edadDeMilena = edadesAlumnos.get("Milena"); //44
        int edadDeSebas = edadesAlumnos.get("Sebas"); //29
        int edadDeAaron = edadesAlumnos.get("Aaron"); //28
        int edadDeCamilo = edadesAlumnos.get("Camilo"); //27
        System.out.println("Edad de Ruben: " + edadDeRuben);
        System.out.println("Edad de Milena: " + edadDeMilena);
        System.out.println("Edad de Sebas: " + edadDeSebas);
        System.out.println("Edad de Aaron: " + edadDeAaron);
        System.out.println("Edad de Camilo: " + edadDeCamilo);

        // Iterar sobre las claves del HashMap
        System.out.println("Claves en el edadesAlumnos:");
        for (String nombre : edadesAlumnos.keySet()) {
            System.out.println(nombre);
        }

        // Iterar sobre los valores del HashMap
        System.out.println("Valores en el edadesAlumnos:");
        for (int edad : edadesAlumnos.values()) {
            System.out.println(edad);
        }

        // Comprobar si una clave está en el HashMap
        boolean contieneSebas = edadesAlumnos.containsKey("Sebas");
        System.out.println("¿El edadesAlumnos contiene a Sebas? " + contieneSebas);
        
        // Obtener el tamaño del HashMap
        int tamaño = edadesAlumnos.size();
        tamaño = edadesAlumnos.size();
        System.out.println("Tamaño del edadesAlumnos: " + tamaño);
        
        // Eliminar un elemento del HashMap
        //edadesAlumnos.remove("Milena");

        //Actualizar valor "SETEAR" 

        //edadesAlumnos.put("Sebas", 30);
        //edadDeSebas = edadesAlumnos.get("Sebas"); //Ahora 30
        //System.out.println("Edad de Sebas: " + edadDeSebas);
        
//		  Ejercicio HASHMAP / HASTABLE
//        A través de un método que realice los put() para asinar key=>value
//        pedirle al usuario por INPUT estos dos parámetros clave y valor
//        para crear dos alumnos más en edadesAlumnos
       
		while (nuevosAlumnos) {
			 scanner = new Scanner(System.in);
			nombreAlumno = (JOptionPane
					.showInputDialog("Nombre de alumno/a : "));
			edadNuevos = Integer.parseInt(JOptionPane
					.showInputDialog("Edad de alumno/a: "));	
						
			 System.out.println("Lista de alumnos: " + edadesAlumnos);
			
		    }
}
}