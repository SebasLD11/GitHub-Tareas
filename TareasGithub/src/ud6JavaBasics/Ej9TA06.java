package ud6JavaBasics;

import java.util.Scanner;

public class Ej9TA06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println( "Entra un valor de array:");
		
		int size = scanner.nextInt();
		int array9[]= new int [size];
		for (int i = 0; i < array9.length; i++) {
			array9 [i] = (int) (Math.random()*10);
	}
		for (int i = 0; i < array9.length; i++) {
			if (i==0) {
			System.out.println("{"+ array9 [i]);
		}	else if (i<array9.length -1) {
				System.out.print(array9[i] + ",");
		} 	else {
			System.out.print(array9[i] + "}");
		}
		}
		for (int i= 0; i<array9.length; i++) {
			int sumaTotal = 0;
				sumaTotal += array9[i];
			
		}
		scanner.close();
		System.out.print("La suma total es:" + [sumaTotal]);
	}
}