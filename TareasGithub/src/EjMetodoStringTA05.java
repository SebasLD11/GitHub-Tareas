
public class EjMetodoStringTA05 {
	public static void main(String[] args) {

        String str = "Hola Mundo";

        // METODO STRING EJEMPLO 1
        
        char ch = str.charAt(7); // ch SERÁ IGUAL AL CARACTER 'n' DEL "Hola Mundo".
        int index = str.indexOf("Mundo"); // 5 será el valor donde esta indexada la palabra "Mundo"

        String str2 = "Hola Mundo, Mundo Feliz";
        int lastIndex = str2.lastIndexOf("Mundo"); // 12

        boolean endsWith = str.endsWith("Mundo"); // true
        boolean startsWith = str.startsWith("Hola"); // true
        int length = str.length(); // 10
        String subStr1 = str.substring(5); // "Mundo"
        String subStr2 = str.substring(0, 4); // "Hola"

        String upperCaseStr = str.toUpperCase(); // "HOLA MUNDO"
        String lowerCaseStr = str.toLowerCase(); // "hola mundo"

        String replacedStr = str.replace('o', 'x'); // "Hxla Mundx"

        // Ejercicio cálculo del último caracter del String
        char ultimoChar = str.charAt(str.length() - 1);

        // Muestro resultados
        System.out.println("EL valor del índice 0 es " + ch 
                            + "\nEL último 'valor' acaba en \"Mundo\"? " 
                            + endsWith );

        System.out.println("El último caracter es: " + ultimoChar);
        
        // Mostramos el resto de Variables
        System.out.println("El índice de la primera aparición de \"Mundo\" es: " + index);
        System.out.println("El último índice de la palabra \"Mundo\" es: " + lastIndex);
        System.out.println("¿La cadena comienza con \"Hola\"? " + startsWith);
        System.out.println("La longitud de la cadena es: " + length);
        System.out.println("La subcadena desde el índice 5 es: " + subStr1);
        System.out.println("La subcadena desde el índice 0 hasta el 4 es: " + subStr2);
        System.out.println("La cadena en mayúsculas es: " + upperCaseStr);
        System.out.println("La cadena en minúsculas es: " + lowerCaseStr);
        System.out.println("La cadena con las 'o' reemplazados por 'x' es: " + replacedStr);
        System.out.println("El cálculo del último caracter es: " + ultimoChar);
    }
}



