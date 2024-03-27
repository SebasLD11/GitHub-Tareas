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
	                    iniciaCLVTStore();
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
		public static void iniciaCLVTStore() {
		    final String CONTRASEÑA = "CultiStore";

		    List<Producto> catalogo = new ArrayList<>();
		    catalogo.add(new Producto("Camiseta Asociad@", 19.99, 35, 21));
		    catalogo.add(new Producto("Gorra Green Olive", 14.99, 10, 21));
		    catalogo.add(new Producto("Gorra Gris", 14.99, 10, 21));
		    catalogo.add(new Producto("Sudadera Gris", 39.99, 15, 21));
		    catalogo.add(new Producto("Sudadera Negro", 39.99, 15, 21));
		    catalogo.add(new Producto("Sudadera Navy",  39.99, 10, 21));
		    catalogo.add(new Producto("Loto Candle: modelo 'Fire'", 14.99, 25, 21));
		    catalogo.add(new Producto("Loto Candle: modelo 'Purple'", 54.99, 25, 21));
		    catalogo.add(new Producto("Tabla de Skate CLVT ONE", 54.99, 25, 21));
		    catalogo.add(new Producto("Brain Pocket Wax (para Skate/Scooter)", 6.95, 20, 21));

		    List<Producto> carrito = new ArrayList<>();

		    while (true) {
		        String opcion = JOptionPane.showInputDialog(null, "~~~ CLVT STORE ~~~\n" + "1. Catalogo \n"
		                + "2. Comprar producto\n" + "3. Modo Admin\n" + "4. Salir\n" + "Seleccione una opción:");

		        if (opcion == null) {
		            return;
		        }

		        switch (opcion) {
		            case "1":
		                mostrarProductos(catalogo);
		                break;
		            case "2":
		                comprarProductos(catalogo, carrito);
		                break;
		            case "3":
		                String password = JOptionPane.showInputDialog("Ingrese la contraseña de administrador:");
		                if (password != null && password.equals(CONTRASEÑA)) {
		                    modoAdmin(catalogo);
		                } else {
		                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Inténtelo de nuevo.");
		                }
		                break;
		            case "4":
		                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
		                return;
		            default:
		                JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
		        }
		    }mostrarProductos();
		    comprar
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
