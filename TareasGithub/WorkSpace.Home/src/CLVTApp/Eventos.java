package CLVTApp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Eventos extends MenuControlador{
    private String nombre;
    private String fecha;
    private String descripcion;
    private String[] organizadores;
    private List<Participante> participantes;
    private static String estado;

    // Constructor que establece la información preestablecida
    public Eventos() {
        this.nombre = "CLVT Fest";
        this.fecha = "8 y 9 de junio.";
        this.descripcion = "La programación engloba las dos modalidades, skate y scooter, siendo la misma para los dos días. Las competiciones"
        		+ " se llevarán a cabo en días diferentes y NO en el mismo día las dos modalidades; es decir, sábado skate y domingo scooter; "
        		+ "en horarios de 10h a 14:30h. Y los talleres de iniciación de 16:00h a 19:00h.";
        this.organizadores = new String[]{"Asociación Cultivate, CLVT", "Joventut Cambrils"};
        this.participantes = new ArrayList<>();
        Eventos.estado = "ABIERTO";
    }

    public Eventos(String nombre, String fecha, String descripción, String[] organizadores, List<Participante> participantes, String estado) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripción;
        this.organizadores = organizadores;
        this.participantes = participantes;
        Eventos.estado = estado;
    }

    public void mostrarEventos() {
        // Mostrar información del evento usando JOptionPane
        StringBuilder infoEvento = new StringBuilder();
        infoEvento.append("Nombre del evento: ").append(nombre).append("\n");
        infoEvento.append("Fecha del evento: ").append(fecha).append("\n");
        infoEvento.append("Descripción del evento: ").append(descripcion).append("\n");
        infoEvento.append("Organizadores del evento: ").append(String.join(", ", organizadores)).append("\n");
        JOptionPane.showMessageDialog(null, infoEvento.toString(), "Información del evento", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para que una persona participe en el evento
    public void participarEnEvento() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:"));
        String email = JOptionPane.showInputDialog("Ingrese su email:");
        String telefono = JOptionPane.showInputDialog("Ingrese su teléfono de contacto:");

        Participante nuevoParticipante = new Participante(nombre, edad, email, telefono);
        agregarParticipante(nuevoParticipante);

        JOptionPane.showMessageDialog(null, "¡Gracias por participar en el evento!");
    }

    public void agregarParticipante(Participante participante) {
        this.participantes.add(participante);
    }

    public static String getEstado() {
        return estado;
    }

    public static void mostrarEventos(List<Eventos> listaEventos) {
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
                        evento.participarEnEvento(); // Llamar al método para participar en el evento
                    }
                    break;
                }
            }
        }
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String[] getOrganizadores() {
		return organizadores;
	}

	public void setOrganizadores(String[] organizadores) {
		this.organizadores = organizadores;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public static void setEstado(String estado) {
		Eventos.estado = estado;
	}

    // Otros getters y setters
}
