package ud5JavaBasics;
import javax.swing.JOptionPane;

public class Ejercicio2T05 {

	public static void main(String[] args) {
		
		//Modificación usando JOptionPAne
		
		String name = JOptionPane.showInputDialog("Introduce tu nombre:");
		
		JOptionPane.showInternalMessageDialog(null,
				"Bien tu nombre es " + name);
		

	}

}
