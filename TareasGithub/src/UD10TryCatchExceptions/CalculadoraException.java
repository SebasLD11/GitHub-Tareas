package UD10TryCatchExceptions;

public class CalculadoraException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculadoraException(String mensaje) {
        super(mensaje);
    }
}