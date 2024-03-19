package UD8POO;

import java.util.Scanner;

public class EjClase1Empleado {
	//Atributos
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected static int edad;
	protected double salario;
	protected Scanner sc;

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
		public EjClase1Empleado(String apellido2, double salario, int edad) {
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
			System.out.print("Ingrese el nombre: ");
				Scanner scanner = new Scanner(System.in);
				this.nombre = scanner.nextLine();

				System.out.print("Ingrese el primer apellido: ");
				this.apellido1 = scanner.nextLine();

				System.out.print("Ingrese el segundo apellido: ");
				this.apellido2 = scanner.nextLine();

				System.out.print("Ingrese la edad: ");
				EjClase1Empleado.edad = scanner.nextInt();
				
				System.out.print("Ingrese el salario: ");
				this.salario = scanner.nextDouble();

				// Mostrar resultados
				System.out.println("\nInformación almacenada:");
				System.out.println("Nombre: " + this.nombre);
				System.out.println("Primer apellido: " + this.apellido1);
				System.out.println("Segundo apellido: " + this.apellido2);
				System.out.println("Edad: " + EjClase1Empleado.edad);
				System.out.println("Salario: " + this.salario);
}

			public static void main(String[] args) {
				// Ejemplo de uso
				EjClase1Empleado empleado = new EjClase1Empleado();
				empleado.solicitarYMostrarInformacion();
}
}