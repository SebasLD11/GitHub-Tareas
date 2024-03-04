package UD8POO;

public class EjClase1Empleado {
	//Atributos
	
	private String nombre;
	private	String apellido;
	private int edad;
	private double salario;
	
	//métodos
	public boolean plus(double sueldoPlus) {
		boolean aumento=false;
				if (edad>40) {
					salario+=sueldoPlus;
					aumento=true;
				}
				return aumento;
	}
}
