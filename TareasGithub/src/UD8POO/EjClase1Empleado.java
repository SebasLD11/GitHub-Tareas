package UD8POO;

import java.util.Map;
import java.util.Scanner;

public class EjClase1Empleado {
	//Atributos
	public String nombre;
	public	String apellido1;
	public	String apellido2;
	public static int edad;
	public double salario;
	public Scanner sc = new Scanner(System.in);

	
	//Constructores
		public EjClase1Empleado() {
			this.nombre = "";
			this.apellido1 = "";
			this.apellido2 = "";
			this.edad = 0;
			this.salario = 0.0;
		}
		
		public EjClase1Empleado(String nombre, String apellido1) {
			this.nombre = nombre;
			this.apellido1 = apellido1;
			this.apellido2 = "";
			this.edad = 0;
			this.salario = 0.0;
		}
		public EjClase1Empleado(String apellido2, int edad ) {
			this.nombre = "";
			this.apellido1 = "";
			this.apellido2 = apellido2;
			this.edad = edad;
			this.salario = 0.0;
		}
		public EjClase1Empleado(double salario) {
			this.nombre = "";
			this.apellido1 = "";
			this.apellido2 = apellido2;
			this.edad = edad;
			this.salario = salario;
		}
		
		public EjClase1Empleado(String nombre, String apellido1, String apellido2, int edad, double salario) {
			super();
			this.nombre = nombre;
			this.apellido1 = apellido1;
			this.apellido2 = apellido2;
			this.edad = edad;
			this.salario = salario;
		}
		
	//Métodos
		public boolean plus (double sueldoPlus) {
			boolean aumento=false;
			if (edad>40) {
				salario+=sueldoPlus;
				aumento=true;
			} 
			return aumento;
		}
		
		//Getters y Setters
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getapellido1() {
			return getapellido1();
		}

		public void setapellido1(String apellido1) {
			this.apellido1 = apellido1;
		}
		public String getapellido2() {
			return getapellido1();
		}

		public void setapellido2(String apellido2) {
			this.apellido2 = apellido2;
		}

		public static int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public double getSalario() {
			return salario;
		}

		public void setSalario(double salario) {
			this.salario = salario;
		}
		//Método para pedir información y mostrar resultados
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

				// Mostrar resultados
				System.out.println("\nInformación almacenada:");
				System.out.println("Nombre: " + this.nombre);
				System.out.println("Primer apellido: " + this.apellido1);
				System.out.println("Segundo apellido: " + this.apellido2);
				System.out.println("Edad: " + this.edad);
				System.out.println("Salario: " + this.salario);
}

			public static void main(String[] args) {
				// Ejemplo de uso
				EjClase1Empleado empleado = new EjClase1Empleado();
				empleado.solicitarYMostrarInformacion();
}
}
