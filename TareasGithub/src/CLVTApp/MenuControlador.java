package CLVTApp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MenuControlador {

	public static void main(String[] args) {
	    mostrarMenuControlador();
	}
		public static void mostrarMenuControlador() {
			String[] opcionesMenu = {"Sobre nosotros", "CLVT Store", "Servicios", "Proyectos","Eventos", "Información adicional", "Salir"};
	        while (true) {
	            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
	                    "~~~ASOCIACIÓN CUTLIVATE~~~", JOptionPane.PLAIN_MESSAGE, null, opcionesMenu, opcionesMenu[0]);
	            if (opcionSeleccionada == null || opcionSeleccionada.equals("Salir")) {
	                JOptionPane.showMessageDialog(null, "Saliendo de la aplicación.");
	                break;
	            }
	            switch (opcionSeleccionada) {
	                case "Sobre nosotros":
	                    agregarInfoNosotros();
	                    break;
	                case "CLVT Store":
	                    CLVTStore.Iniciar();
	                    break;
	                case "Servicios":
	                    mostrarServicios();
	                    break;
	                case "Proyectos":
	                    mostrarProyectos();
	                    break;
	                case "Eventos":
	                    mostrarEventos();
	                    break;
	                case "Información adicional":
	                    mostrarinfoAdicional();
	                    break;
	                default:
	                    JOptionPane.showMessageDialog(null, "Opción no válida.");
	            }
	        }
	    }
		
		protected static double formatoDosDecimales(double valor) {
		        return Math.round(valor * 100.0) / 100.0;
		    }
		

		public static void agregarInfoNosotros() {
		    String textoInfo = JOptionPane.showInputDialog(null, "Por favor, ingrese un texto explicativo sobre nuestra entidad:");
		    if (textoInfo != null && !textoInfo.isEmpty()) {
		        // Aquí puedes guardar el texto en alguna estructura de datos o simplemente mostrarlo
		        JOptionPane.showMessageDialog(null, "Información agregada correctamente:\n" + textoInfo);
		    } else {
		        JOptionPane.showMessageDialog(null, "No se ingresó ningún texto. La información no se ha guardado.");
		    }
		}

}
