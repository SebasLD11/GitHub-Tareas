import javax.swing.JOptionPane;

public class Ejercicio3T05 {

	public static void main(String[] args) {
		
		//Cálculo con Double.parseDouble
		
		double pi = 3.14;
		String text_num = JOptionPane.showInputDialog("Radio de circulo");
		
		final double areacirculo = Double.parseDouble(text_num);
		
		JOptionPane.showMessageDialog(null,
				"El area de la circulo es " + 
				(areacirculo + (areacirculo + (areacirculo * pi))));

	}

}
