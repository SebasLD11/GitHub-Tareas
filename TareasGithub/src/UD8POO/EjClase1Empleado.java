package UD8POO;

import java.util.Map;
import java.util.Scanner;

public class EjClase1Empleado {
	//Atributos
	public int numEmpleados;
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
		}{
		
	//Mostrar información de empleado/a.
		
		int numEmpleados = 0;
		for (int i = 1; i <= numEmpleados; i++) {
            System.out.print("Ingrese el nombre del alumno/a " + i + apellido1 + apellido2 + ": ");
            String nombre = new String();
          
        for (EjClase1Empleado entry : EjClase1Empleado.entrySet()) {
                String nombre1 = (String) ((Object) entry).toString();
                String apellido1 = (String) ((Object) entrySet());
                String apellido2 = (String) ((Object) entrySet());
                System.out.println("Nombre: " + nombre1 + apellido1 + apellido2);
                System.out.println("Notas parciales: " + EjClase1Empleado.getEdad());
                System.out.println("Promedio: " + EjClase1Empleado.calcularPromedio());
                System.out.println();
            }    
		
}
		}

		private static EjClase1Empleado[] entrySet() {
			// TODO Auto-generated method stub
			return null;
		}
}
