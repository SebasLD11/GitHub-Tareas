package ud6JavaBasics;

import java.util.Scanner;

public class Ej8T06 {

	public static void main(String[] args) {
		
		int mtrz [] = new int [10];
		Scanner sc = new Scanner(System.in);
		System.out.println( "Dame un valor:");
		
		for (int i=0; i<10; i++) {
			int numero = sc.nextInt();
			mtrz[i]=numero;
		
		System.out.println(mtrz[6] );
		
		
		}

	}
}