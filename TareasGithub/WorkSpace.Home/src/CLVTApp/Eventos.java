package CLVTApp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Eventos extends MenuControlador{
    private static String nombre;
    private static String fecha;
    private static String descripcion;
    private static String[] organizadores;
    private static List<Participante> participantes = new ArrayList<Participante>();
    private static String estado;
    private static List<Eventos> listaEventos = new ArrayList<Eventos>();

    // Constructor que establece la información preestablecida
	
    public Eventos(String nombre, String fecha, String descripción, String[] organizadores, List<Participante> participantes, String estado) {      
    	Eventos.nombre = nombre;
        Eventos.fecha = fecha;
        Eventos.descripcion = descripción;;
        Eventos.organizadores = new String[]{"Asociación Cultivate, CLVT", "Joventut Cambrils"};;
        Eventos.participantes = new ArrayList<Participante>(participantes);
        Eventos.estado = estado;
    }
    public Eventos( String[] organizadores, List<Participante> participantes, String estado) {      
    	Eventos.nombre = "";
        Eventos.fecha = "";
        Eventos.descripcion = "";;
        Eventos.organizadores = new String[]{"Asociación Cultivate, CLVT", "Joventut Cambrils"};;
        Eventos.participantes = new ArrayList<Participante>(participantes);
        Eventos.estado = "";
    }
    
    public Eventos( List<Participante> participantes, String estado) {      
    	Eventos.nombre = "";
        Eventos.fecha = "";
        Eventos.descripcion = "";;
        Eventos.organizadores = new String[]{"Asociación Cultivate, CLVT", "Joventut Cambrils"};;
        Eventos.participantes = new ArrayList<Participante>(participantes);
        Eventos.estado = "";
    }
    
    public static void inicializarEventos() {
        listaEventos.add(new Eventos("Evento verano: CLVT Fest", "8 y 9 de junio","La programación engloba las dos modalidades,"
        		+ " skate y scooter, siendo la misma para los dos días. Las competiciones"
        		+ " se llevarán a cabo en días diferentes y NO en el mismo día las dos modalidades;"
        		+ " es decir, sábado skate y domingo scooter; "
        		+ "en horarios de 10h a 14:30h. Y los talleres de iniciación de 16:00h a 19:00h.",
        		new String[]{"Asociación Cultivate, CLVT", "Joventut Cambrils"}, new ArrayList<Participante>(participantes),
        		"ABIERTO"));
        
        listaEventos.add(new Eventos("Evento otoño: HALLOWEEN Skate Jam Party - HSK8jPTY", "Domingo 27 de octubre", 
        		"El evento será "       	
        		+ " cercano al día de Halloween, por lo que será un evento temático donde participantes, asistentes"
        		+ " y organizadores tendrán la opción de ir disfrazados. Además los que vengan"
        		+ " disfrazados entrarán en un sorteo, junto con asociados y participantes, que se celebrará antes de"
        		+ " finalizar el evento.\r\n"
        		+ "\r\n"
        		+ " ", new String[]{"Asociación Cultivate, CLVT", "Joventut Cambrils"}, new ArrayList<Participante>(participantes), "ABIERTO"));
    }// Agrega más eventos según sea necesario 
    
    public static void mostrarEventos() {
        inicializarEventos(); 
        
        // Mostrar información detallada de cada evento antes de preguntar por la participación
        for (Eventos evento : listaEventos) {
            StringBuilder infoEventoCLVTFest = new StringBuilder();
            infoEventoCLVTFest.append("Nombre: ").append(evento.getNombre()).append("\n");
            infoEventoCLVTFest.append("Fecha: ").append(evento.getFecha()).append("\n");
            infoEventoCLVTFest.append("Descripción: ").append(evento.getDescripcion()).append("\n");
            infoEventoCLVTFest.append("Organizadores: ").append(String.join(", ", evento.getOrganizadores())).append("\n");
            infoEventoCLVTFest.append("Estado: ").append(Eventos.getEstado()).append("\n");

            JOptionPane.showMessageDialog(null, infoEventoCLVTFest.toString(), "Detalles del Evento", JOptionPane.INFORMATION_MESSAGE);

            // Preguntar si el usuario desea participar en el evento actual
            int opcion = JOptionPane.showConfirmDialog(null,
                    "¿Desea participar en este evento?", "Participar en evento",
                    JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                Eventos.participarEnEvento(); // Llamar al método para participar en el evento
            }
        }
    }

    // Método para que una persona participe en el evento
    public static void participarEnEvento() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:"));
        String email = JOptionPane.showInputDialog("Ingrese su email:");
        String telefono = JOptionPane.showInputDialog("Ingrese su teléfono de contacto:");

        Participante nuevoParticipante = new Participante(nombre, edad, email, telefono);
        agregarParticipante(nuevoParticipante);

        JOptionPane.showMessageDialog(null, "¡Gracias por participar en el evento! Recuerda apuntar las fechas. Proporcionaremos más información" 
        		+ "relevante al respecto en nuestra página principal.");
    }

    public static void agregarParticipante(Participante participante) {
    	Eventos.participantes.add(participante);
    }
    
	//getters y setters
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		Eventos.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		Eventos.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		Eventos.descripcion = descripcion;
	}

	public String[] getOrganizadores() {
		return organizadores;
	}

	public void setOrganizadores(String[] organizadores) {
		Eventos.organizadores = organizadores;
	}

	public static List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		Eventos.participantes = participantes;
	}

	public static void setEstado(String estado) {
		Eventos.estado = estado;
	}
	

    public static String getEstado() {
        return estado;
    }


	public static List<Eventos> getListaEventos() {
		return listaEventos;
	}
	public static void setListaEventos(List<Eventos> listaEventos) {
		Eventos.listaEventos = listaEventos;
	}
}
