package ud08POO;

import java.util.Scanner;

public class EjClase1Empleado {
		
		//Atributos
		public int numEmpleado;
		public String nombre;
		public	String apellido1;
		public	String apellido2;
		public static int edad;
		public static double salario;
		public static boolean Plus;
		public void Plus1 (double sueldoPlus) {
			boolean aumento=false;{
			if (edad>40) {
				salario+=sueldoPlus;
			}else	aumento=true;
		} }
		 // Constructor
		
	    public EjClase1Empleado(String nombre, String apellido1, String apellido2, int edad, double salario, boolean Plus) {
	        this.nombre = nombre;
	        this.apellido1 = apellido1;
	        this.apellido2 = apellido2;
	        this.edad = edad;
	        this.salario = salario;
	    }

	    // Método para pedir información y mostrar resultados
	    
	    public void solicitarYMostrarInformacion() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Ingrese el nombre: ");
	        this.nombre = scanner.nextLine();

	        System.out.print("Ingrese el primer apellido: ");
	        this.apellido1 = scanner.nextLine();

	        System.out.print("Ingrese el segundo apellido: ");
	        this.apellido2 = scanner.nextLine();

	        System.out.print("Ingrese la edad: ");
	        this.edad = scanner.nextInt();

	        System.out.print("Ingrese el salario: ");
	        this.salario = scanner.nextDouble();
	    }    
	    public boolean Plus (double sueldoPlus) {
				boolean aumento=false;{
				if (edad>40) {
					salario+=sueldoPlus;
					aumento=true;
				} 
				return aumento;
			}
	    }

	    public static void main(String[] args) {
	        String i = null;
			// Ejemplo de uso
	        EjClase1Empleado empleado = new EjClase1Empleado(i, i, i, edad, salario, Plus);
	        empleado.solicitarYMostrarInformacion();
	    }
	}	
