package ud5JavaBasics;

public class Ej8T05 {

	public static void main(String[] args) {		
		//varición del ej anterior con bucle for
		//		declaramos variables y asignamos valores	
			//		int i=1, j=100;		
		//Incremento ir de 1 a 100		
			//		while (i<=100) {
			//			System.out.println(i);
			//			i++;
			//	} 		
		//Uso del for
		
	for (int i=1;i<=100;i++) {
		System.out.println(i);
	}
	for (int i=1;i<=100;i+=2) { 
		//i=i+2 saltaria de 2 en 2
		System.out.println(i);
	}
		
	//Ejercicio 9: del 1 al 100 divisibles entre 2 y 3
		
		for (int i=1;i<=100;i++) {
			if ((i%2==0)&&(i%3==0)) {
//				System.out.println(i);
			} else {
				System.out.println(i + "(no es divisible)");
			}
			//Divisible entre 2 o entre 3
			if ((i%2==0)||(i%3==0)) {
				System.out.println(i);
			} 
		}
		
	}


	}


