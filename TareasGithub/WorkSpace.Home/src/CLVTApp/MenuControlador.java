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
        listaProyectos.add(new Proyectos("Proyecto 1", "Descripción del proyecto 1", null, 0, 0));
        listaProyectos.add(new Proyectos("Proyecto 2", "Descripción del proyecto 2", null, 0, 0));

        listaEventos.add(new Eventos("Evento 1", "Fecha evento 1", "Descripción evento 1", new String[]{"Organizador 1"}, new ArrayList<>(), "ABIERTO"));
        listaEventos.add(new Eventos("Evento 2", "Fecha evento 2", "Descripción evento 2", new String[]{"Organizador 2"}, new ArrayList<>(), "FINALIZADO"));

        mostrarMenuControlador();
    }

    public static void mostrarMenuControlador() {
        String[] opcionesMenu = {"Sobre nosotros", "CLVT Store", "Servicios", "Proyectos", "Eventos", "Información adicional", "Salir"};
        while (true) {
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
                    "~~~ASOCIACIÓN CUTLIVATE~~~", JOptionPane.PLAIN_MESSAGE, null, opcionesMenu, opcionesMenu[0]);
            if (opcionSeleccionada == null || opcionSeleccionada.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo de la aplicación.");
                break;
            }
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
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private static void mostrarInfoNosotros() {
        JOptionPane.showMessageDialog(null, getInfoNosotros(), "Sobre Nosotros", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void iniciarCLVTStore() {
        CLVTStore.main(null);
    }

    private static void mostrarServicios() {
        JOptionPane.showMessageDialog(null, "Mostrando servicios disponibles...");

        // Aquí puedes implementar la lógica para mostrar los servicios disponibles
        String[] servicios = {"Talleres básicos", "Clases particulares", "Programa 'STAIRS'",
                "Campus Workout"};

        String servicioSeleccionado = (String) JOptionPane.showInputDialog(null,
                "Seleccione un servicio:", "Servicios disponibles",
                JOptionPane.QUESTION_MESSAGE, null, servicios, servicios[0]);

        if (servicioSeleccionado != null) {
            // Aquí puedes agregar lógica adicional según el servicio seleccionado
            switch (servicioSeleccionado) {
                case "Talleres básicos":
                    // Lógica para los talleres básicos
                    break;
                case "Clases particulares":
                    // Lógica para las clases particulares
                    break;
                case "Programa STAIRS":
                    // Lógica para el programa STAIRS
                    break;
                case "Campus Workout":
                    // Lógica para el Campus Workout
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Servicio no válido.");
            }
        }
    }

    private static void mostrarProyectos() {
        StringBuilder proyectosInfo = new StringBuilder("Proyectos:\n");
        for (Proyectos proyecto : listaProyectos) {
            proyectosInfo.append(proyecto.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, proyectosInfo.toString());
    }

    private static void mostrarEventos() {
        // Crear un array de Strings para mostrar los nombres de los eventos en el menú
        String[] nombresEventos = new String[listaEventos.size()];
        for (int i = 0; i < listaEventos.size(); i++) {
            nombresEventos[i] = listaEventos.get(i).getNombre();
        }

        // Mostrar el menú de selección de eventos
        String eventoSeleccionado = (String) JOptionPane.showInputDialog(
                null, "Seleccione un evento:", "Eventos disponibles",
                JOptionPane.QUESTION_MESSAGE, null, nombresEventos, nombresEventos[0]);

        // Mostrar la información del evento seleccionado
        if (eventoSeleccionado != null) {
            for (Eventos evento : listaEventos) {
                if (evento.getNombre().equals(eventoSeleccionado)) {
                    evento.mostrarEventos();

                    // Preguntar si el usuario quiere participar en el evento
                    int opcion = JOptionPane.showConfirmDialog(null,
                            "¿Desea participar en este evento?", "Participar en evento",
                            JOptionPane.YES_NO_OPTION);
                    if (opcion == JOptionPane.YES_OPTION) {
                        evento.participarEnEvento();
                    }
                    break;
                }
            }
        }
    }

    protected static void mostrarInfoAdicional() {
        MenuControlador.mostrarInfoAdicional();
    }
}

