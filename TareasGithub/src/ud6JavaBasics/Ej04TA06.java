package ud6JavaBasics;
import java.util.Scanner;
//import javax.swing.JOptionPane;

public class Ej04TA06 {
	public static void main(String[] args) {
	int bin;
        Scanner sc = new Scanner(System.in); 
        System.out.println(" -- ¡PASO DE DECIMAL A BINARIO! --");
        System.out.println("Por favor, introduce el número entero:");            
        bin = Integer.parseInt(sc.nextLine());
        sc.close();                    
        System.out.println("El binario generado es: " +dec2bin(bin));
    }    
    public static String dec2bin (int decimal) {        
        if (decimal == 0) {
            return "0";
        }        
        StringBuilder binario = new StringBuilder();        
        do {
            int residuo = decimal % 2;
            binario.insert(0, residuo);
            decimal = decimal / 2;
            System.out.println(residuo + " " + decimal);             
            }while(decimal > 0);
        return binario.toString(); //StringBuilder --> String
   }  
}
	
	//Codigo reutilizado de Manel para simplificar el factorial, creando un método que funcione como un filtro y concretando que tipo
	//de número introduciremos que en este caso solo nos dará la opción de introducir un número entero positivo, lo cual simplificará el
	//bucle while que contará que cantidad de cifras tiene el número introducidO (ejercicio5TA06)
	
	//public static void main(String[] args) {
        //int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número entero positivo"));
        //while (numero < 0) {
          //  numero = Integer.parseInt(JOptionPane.showInputDialog("Error: Debes introducir un número entero positivo"));
        //}

        //JOptionPane.showMessageDialog(null, "El número " + numero + " tiene " + cuentaCifras(numero) + " cifra(s)");

    //}

    //public static int cuentaCifras(int n) {
        //int count = 1;
        //while (n > 9) {
          //  n = n / 10;
            //count++;
        //}
        //return count;
//    }
//}