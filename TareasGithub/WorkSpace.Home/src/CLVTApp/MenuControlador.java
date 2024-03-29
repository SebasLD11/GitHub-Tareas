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

    public static void main(String[] args) {
    	
    	IniciaMenuControlador();
    }

    public static void IniciaMenuControlador() {
        String[] opcionesMenu = {"Sobre nosotros", "CLVT Store", "Servicios", "Proyectos", "Eventos", "Información adicional", "Salir"};
        while (true) {
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
                    "~~~ASOCIACIÓN CUTLIVATE~~~", JOptionPane.PLAIN_MESSAGE, null, opcionesMenu, opcionesMenu[0]);
          
            switch (opcionSeleccionada) {
                case "Sobre nosotros":
                    mostrarInfoNosotros();
                    break;
                case "CLVT Store":
                    iniciarCLVTStore();
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
                	mostrarInfoAdicional();
                    break;
                default:                   
            }if (opcionSeleccionada == null || opcionSeleccionada.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Cultiva tu mente, cultiva tu cuerpo, CULTIVATE!");
                JOptionPane.showMessageDialog(null, "Hasta la próxima!");
                break;
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
    	Proyectos.mainIniciarProyectos(null);
    }
    protected static void mostrarEventos() {
     Eventos.mostrarEventos();
    }
    
    protected static void mostrarInfoAdicional() {
        InfoAdicional.mostrarInfoAdicional();
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
}
