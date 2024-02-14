package ud5JavaBasics;
import javax.swing.JOptionPane;

public class Ejercicio4T05 {

	public static void main(String[] args) {
		// Cálculo final de IVA para producto CVLT
		
		double precioProducto = 45.45;
		final double IVA = 0.21;

		JOptionPane.showMessageDialog(null,
						"El precio del producto, incluido el IVA es " + 
						(precioProducto + (precioProducto * IVA)));

	}

}
