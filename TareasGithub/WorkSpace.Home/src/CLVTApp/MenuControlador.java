package CLVTApp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MenuControlador {
    private static String infoNosotros;
    private static List<Eventos> listaEventos = new ArrayList<>();
    private static InfoAdicional infoAdicional = new InfoAdicional();

    public static String getInfoNosotros() {
        return infoNosotros;
    }

    public static void setInfoNosotros(String infoNosotros) {
        MenuControlador.infoNosotros = infoNosotros;
    }

	public static InfoAdicional getInfoAdicional() {
		return infoAdicional;
	}

	public static void setInfoAdicional(InfoAdicional infoAdicional) {
		MenuControlador.infoAdicional = infoAdicional;
	}

	public static List<Eventos> getListaEventos() {
		return listaEventos;
	}

	public static void setListaEventos(List<Eventos> listaEventos) {
		MenuControlador.listaEventos = listaEventos;
	}
	
	public static String getMenuText() {
        // Crear el texto del menú usando StringBuilder
        StringBuilder menuText = new StringBuilder();
        menuText.append("1. Sobre nosotros\n");
        menuText.append("2. CLVT Store\n");
        menuText.append("3. Servicios\n");
        menuText.append("4. Proyectos\n");
        menuText.append("5. Eventos\n");
        menuText.append("6. Información adicional\n");
        menuText.append("7.Salir\n");
        menuText.append("Seleccione una opción:");
        return menuText.toString();
    }
    public static void main(String[] args) {
    	
    	IniciaMenuControlador();
    }

    public static void IniciaMenuControlador() {
        while (true) {
            // Mostrar el menú y obtener la opción seleccionada
            String opcionSeleccionada = JOptionPane.showInputDialog(
                    null, 
                    getMenuText(), 
                    "~~~ASOCIACIÓN CUTLIVATE~~~", 
                    JOptionPane.PLAIN_MESSAGE);

            // Manejar la opción seleccionada
            switch (opcionSeleccionada) {
                case "1":
                    mostrarInfoNosotros();
                    break;
                case "2":
                    iniciarCLVTStore();
                    break;
                case "3":
                    mostrarServicios();
                    break;
                case "4":
                    mostrarProyectos();
                    break;
                case "5":
                    Eventos.mostrarMenuEventos();
                    break;
                case "6":
                    mostrarInfoAdicional();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
                    break;
                case "7":
                	 JOptionPane.showMessageDialog(null, "Cultiva tu mente, Cultiva tu cuerpo, Cultiva tu vida. CULTIVATE!");
                     JOptionPane.showMessageDialog(null, "Hasta la próxima!");                   
                     return;

            }
        }
    }
	private static void mostrarInfoNosotros() {
        JOptionPane.showMessageDialog(null, getInfoNosotros(), "Sobre Nosotros", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void iniciarCLVTStore() {
        CLVTStore.mainIniciar(null);
    }

    private static void mostrarServicios() {
       
        Servicios.mainIniciarServicios(null); // Llama al método mostrarOpcionesServicio de la clase Servicios
    }

    private static void mostrarProyectos() {
    	Proyectos.main(null);
    }
    
    public static void mostrarEventosMenu() {
    	Eventos.mostrarEventos();
    }
    
    protected static void mostrarInfoAdicional() {
        InfoAdicional.mostrarInfoAdicional();
    }
}
