import javax.swing.JOptionPane;

public class Ej10T05 {
	
	public static void main(String[] args) {
		
		//Valor entero. Input de usuario
		
		int numVentas = Integer.parseInt(JOptionPane.
				 		showInputDialog("Introduce el número de ventas: "));
		
		//Variables para el calculo de las ventas
		
		double valorVenta=0, sumaTotal=0;
		
		//Variable para el número de iteraciones en el bucle
		
		int i = 1;
		
		while(i <= numVentas) {

			valorVenta = Double.parseDouble(JOptionPane.
					 showInputDialog("Introduce un valor " 
							 + i + " de la venta: "));
			sumaTotal = sumaTotal + valorVenta;
			i++;
		}
		 
		 JOptionPane.showMessageDialog(null, ""
		 		+ "La suma total es: " + sumaTotal);

	}

}

