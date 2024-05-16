package UD10TryCatch;
import java.util.Random;

public class UD10Ej03NumeroAleatorio {
    public static void main(String[] args) {
        try {
            int numeroAleatorio = generarNumeroAleatorio();
            System.out.println("Generando número aleatorio... El número aleatorio generado es: " + numeroAleatorio);
            verificarParidad(numeroAleatorio);
        } catch (ParidadException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int generarNumeroAleatorio() {
        Random rand = new Random();
        return rand.nextInt(1000); // Genera un número aleatorio entre 0 y 999
    }

    public static void verificarParidad(int numero) throws ParidadException {
        if (numero % 2 == 0) {
            throw new ParidadException("Es par.");
        } else {
            throw new ParidadException("Es impar.");
        }
    }
}

class ParidadException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParidadException(String mensaje) {
        super(mensaje);
    }
}
