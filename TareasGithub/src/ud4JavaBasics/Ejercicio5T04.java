package ud4JavaBasics;

public class Ejercicio5T04 {

	public static void main(String[] args) {
		// // Declaración e inicialización de las variables A, B, C y D
        int A = 1;
        int B = 3;
        int C = 9;
        int D = 7; 

        // Muestra los valores iniciales
        System.out.println("Valores iniciales: A = " + A + ", B = " + B + ", C = " + C + ", D = " + D);
        
        /*
        // Intercambio de valores
        int temp = B; // Se utiliza una variable temporal para almacenar el valor de B
        //A es 1; B es 3; C es 9; D es 7;
        B = C; 
        //A es 1; B es 3; C es 9; D es 7;
        C = A;
        //A es 1; B es 3; C es 9; D es 7;
        A = D;
        //A es 1; B es 3; C es 9; D es 7;
        D = temp;
        //A es 1; B es 3; C es 9; D es 7;
         *
         */
        B = B + C; // B es 12
        C = B - C; // C es -6
        B = B - C; // B es -6

        C = C + A; // C es 10
        A = C - A; // A es 8
        C = C - A; // C es 8

        A = A + D; // A es 8
        D = A - D; // D es -6
        A = A - D; // A es 3

        // Muestra los valores después del intercambio
        System.out.println("Valores después del intercambio: A = " + A + ", B = " + B + ", C = " + C + ", D = " + D);
    }
}