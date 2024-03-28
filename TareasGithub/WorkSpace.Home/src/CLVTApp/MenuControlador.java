package CLVTApp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MenuControlador {
    private static String infoNosotros;
    private static List<Proyectos> listaProyectos = new ArrayList<>();
    private static List<Eventos> listaEventos = new ArrayList<>();
    private static InfoAdicional infoAdicional = new InfoAdicional();

    public static String getInfoNosotros() {
        return infoNosotros;
    }

    public static void setInfoNosotros(String infoNosotros) {
        MenuControlador.infoNosotros = infoNosotros;
    }

    public static void main(String[] args) {
    	
        mostrarMenuControlador();
    }

    public static void mostrarMenuControlador() {
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
                	   listaProyectos.add(new Proyectos("Proyecto 1", "Descripción del proyecto 1", null, 0, 0));
                       listaProyectos.add(new Proyectos("Proyecto 2", "Descripción del proyecto 2", null, 0, 0));
                    mostrarProyectos();
                    break;
                case "Eventos":
                	 listaEventos.add(new Eventos());
                     listaEventos.add(new Eventos());
                    mostrarEventos();
                    break;
                case "Información adicional":
                    mostrarInfoAdicional();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }if (opcionSeleccionada == null || opcionSeleccionada.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo de la aplicación.");
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
        JOptionPane.showMessageDialog(null, "Mostrando servicios disponibles...");

        // Implementa la lógica para mostrar los servicios
    }

    private static void mostrarProyectos() {
        StringBuilder proyectosInfo = new StringBuilder("Proyectos:\n");
        for (Proyectos proyecto : listaProyectos) {
            proyectosInfo.append(proyecto.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, proyectosInfo.toString());
    }

    private static void mostrarEventos() {
        StringBuilder eventosInfo = new StringBuilder("Eventos:\n");
        for (Eventos evento : listaEventos) {
            eventosInfo.append(evento.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, eventosInfo.toString());
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
}
