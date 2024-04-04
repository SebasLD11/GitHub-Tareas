package UD09Herencias;

public class Raices {
	private double a;
	private double b;
	private double c;

	// Constructor
	public Raices(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	// Método para obtener el discriminante
	public double getDiscriminante() {
		return Math.pow(b, 2) - 4 * a * c;
	}

	// Método para comprobar si tiene dos soluciones
	public boolean tieneRaices() {
		return getDiscriminante() > 0;
	}

	// Método para comprobar si tiene una única solución
	public boolean tieneRaiz() {
		return getDiscriminante() == 0;
	}

	// Método para calcular e imprimir las posibles soluciones
	public void calcular() {
		if (tieneRaices()) {
			obtenerRaices();
		} else if (tieneRaiz()) {
			obtenerRaiz();
		} else {
			System.out.println("No tiene soluciones reales.");
		}
	}
	// Método para imprimir las dos posibles soluciones
	public void obtenerRaices() {
		double discriminante = getDiscriminante();
		double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
		double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
		System.out.println("Las raíces son: " + raiz1 + " y " + raiz2);
	}
	// Método para imprimir la única raíz
	public void obtenerRaiz() {
			double raizUnica = -b / (2 * a);
			System.out.println("La única raíz es: " + raizUnica);
	}

	public static void main(String[] args) {
			// Ejemplo de uso
			Raices ecuacion = new Raices(5, 25, 3);
//	        System.out.println("Discriminante: " + ecuacion.getDiscriminante());
//	        System.out.println("¿Tiene raíces? " + ecuacion.tieneRaices());
//	        System.out.println("¿Tiene raíz única? " + ecuacion.tieneRaiz());
	        ecuacion.calcular();
	        	
//	        	Con dos soluciones reales:
//	        	Coeficientes: a = 1, b = -3, c = 2
//	        	Coeficientes: a = 2, b = 5, c = -3
//	        	Coeficientes: a = 1, b = -6, c = 9
//	        	Con una solución real:
//	        	Coeficientes: a = 1, b = -4, c = 4
//	        	Coeficientes: a = 2, b = -8, c = 8
//	        	Coeficientes: a = 3, b = -18, c = 27
//	        	Sin soluciones reales:
//	        	Coeficientes: a = 1, b = 2, c = 3
//	        	Coeficientes: a = 4, b = 2, c = 1
//	        	Coeficientes: a = 1, b = 1, c = 1
		}

	}
