package ud6JavaBasics;

import java.util.Scanner;

public class Ej6TA06 {

	public static void main(String[] args) {
		 Scanner sc= new Scanner(System.in); 
	        System.out.println("Introduce un número:");  
	        String num = sc.nextLine(); 
	    
	        int numero =Integer.parseInt(num);
	        System.out.println(Factorial(numero));
	        
	        sc.close();
	    }
	    
	    public static int Factorial(int fact) {
	        int resultado=1; 
	        
	        while (fact>1) {
	            resultado = resultado *= fact;
	            fact--;
	        }
	    
	        return resultado; 
	    }

	

	    //Factorial de Manel
	    	public static int factorial(int n) {
	    		n = Math.abs(n);

	    	if (n <= 1) {
	    		return 1;
	    	} else {
	    		return n * factorial(n - 1);
    }
}
}