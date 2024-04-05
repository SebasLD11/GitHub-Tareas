package CLVTApp;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Eventos {
    private String nombre;
    private String fecha;
    private String descripcion;
    private String[] organizadores;
    private List<Participante> participantes;
    private String estado;

    private static List<Eventos> listaEventos = new ArrayList<>();

    public Eventos(String nombre, String fecha, String descripcion, String[] organizadores, List<Participante> participantes, String estado) {      
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.organizadores = organizadores;
        this.participantes = new ArrayList<>(participantes);
        this.estado = estado;
    }

    public static void inicializarEventos() {
        listaEventos.add(new Eventos("Evento verano: CLVT Fest", "8 y 9 de junio\n"
            + "\r\n"
            ,"La programación engloba las dos modalidades skate y scooter, siendo\n"
            + " la misma para los dos días. Las competiciones se llevarán a cabo en\n"
            + " días diferentes y NO en el mismo día las dos modalidades; es decir,\n"
            + " sábado skate y domingo scooter;en horarios de 10h a 14:30h. Y los\n"
            + " talleres de iniciación de 16:00h a 19:00h.\n"
            , new String[]{"Asociación Cultivate, CLVT", "Joventut Cambrils"}
            , new ArrayList<>(),
            "ABIERTO"));
        
        listaEventos.add(new Eventos("Evento otoño: HALLOWEEN Skate Jam Party - HSK8jPTY.\n"
            + "\r\n"
            ,"Domingo 27 de octubre", 
            "El evento será cercano al día de Halloween, por lo que será un evento temático donde participantes,\n"
            + " asistentes y organizadores tendrán la opción de ir disfrazados. Además l@s que vengan disfrazad@s\n"
            + " entrarán en un sorteo, junto con asociados y participantes, que se celebrará antes de finalizar el evento.\n"
            + "\r\n"
            , new String[]{"Asociación Cultivate, CLVT", "Joventut Cambrils"}
            , new ArrayList<>(), "ABIERTO"));
    }
    public static void mostrarMenuEventos() {
        // Mostrar el menú de eventos y obtener la opción seleccionada
        String opcionSeleccionada = JOptionPane.showInputDialog(
                null, 
                getMenuText(), 
                "Menú de Eventos", 
                JOptionPane.PLAIN_MESSAGE);
        
        // Manejar la opción seleccionada del menú de eventos
        switch (opcionSeleccionada) {
            case "1": 
                mostrarEventos();
                break;
            case "2":
            	mostrarEventos();
                
                // Preguntar al usuario por el índice del evento en el que desea participar
                int indiceEvento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del evento en el que desea participar:"));

                // Verificar si el índice ingresado es válido
                if (indiceEvento >= 1 && indiceEvento <= listaEventos.size()) {
                    // Obtener el evento seleccionado por el usuario
                    Eventos eventoSeleccionado = listaEventos.get(indiceEvento - 1);
                    
                    // Preguntar si el usuario desea participar en el evento seleccionado
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Desea participar en este evento?", "Participar en evento", JOptionPane.YES_NO_OPTION);
                    
                    if (opcion == JOptionPane.YES_OPTION) {
                        // Llamar al método para participar en el evento seleccionado
                        participarEnEvento(eventoSeleccionado);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Índice de evento no válido. Por favor, ingrese un número válido.");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
                break;
            case "3":
                // Mostrar eventos disponibles
                mostrarEventos();

                // Preguntar al usuario por el índice del evento del que desea ver la lista de participantes
                int indiceEventoListaParticipantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del evento del que desea ver la lista de participantes:"));

                // Verificar si el índice ingresado es válido
                if (indiceEventoListaParticipantes >= 1 && indiceEventoListaParticipantes <= listaEventos.size()) {
                    // Obtener el evento seleccionado por el usuario
                    Eventos eventoSeleccionadoListaParticipantes = listaEventos.get(indiceEventoListaParticipantes - 1);

                    // Mostrar la lista de participantes del evento seleccionado
                    mostrarListaParticipantes(eventoSeleccionadoListaParticipantes);
                } else {
                    JOptionPane.showMessageDialog(null, "Índice de evento no válido. Por favor, ingrese un número válido.");
                }
                break;

            case "4":              
                return;
            
        }
    }

    
    public static void mostrarEventos() {
        inicializarEventos(); 
        
        // Mostrar información detallada de cada evento antes de preguntar por la participación
        for (Eventos evento : listaEventos) {
            StringBuilder infoEvento = new StringBuilder();
            infoEvento.append("Nombre: ").append(evento.getNombre()).append("\n");
            infoEvento.append("Fecha: ").append(evento.getFecha()).append("\n");
            infoEvento.append("Descripción: ").append(evento.getDescripcion()).append("\n");
            infoEvento.append("Organizadores: ").append(String.join(", ", evento.getOrganizadores())).append("\n");
            infoEvento.append("Estado: ").append(evento.getEstado()).append("\n");

            JOptionPane.showMessageDialog(null, infoEvento.toString(), "Detalles del Evento", JOptionPane.INFORMATION_MESSAGE);
    }
}
    public static void participarEnEvento(Eventos evento) {
    	
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:"));
        String email = JOptionPane.showInputDialog("Ingrese su email:");
        String telefono = JOptionPane.showInputDialog("Ingrese su teléfono de contacto:");

        Participante nuevoParticipante = new Participante(nombre, edad, email, telefono);
        evento.agregarParticipante(nuevoParticipante);

        JOptionPane.showMessageDialog(null, "¡Gracias por participar en el evento! Recuerda apuntar las fechas.\n"
        		+ " Proporcionaremos más información relevante al respecto en nuestra página principal.");
        }
    
    public static void mostrarListaParticipantes(Eventos evento) {
        StringBuilder participantesInfo = new StringBuilder("Lista de Participantes:\n");
        for (Participante participante : evento.getParticipantes()) {
            participantesInfo.append("Nombre: ").append(participante.getNombre()).append(", Edad: ").append(participante.getEdad()).append("\n");
        }
        JOptionPane.showMessageDialog(null, participantesInfo.toString(), "Lista de Participantes", JOptionPane.INFORMATION_MESSAGE);
    }

	 // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String[] getOrganizadores() {
        return organizadores;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public String getEstado() {
        return estado;
    }

    public static List<Eventos> getListaEventos() {
        return listaEventos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setOrganizadores(String[] organizadores) {
        this.organizadores = organizadores;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void agregarParticipante(Participante participante) {
        this.participantes.add(participante);
    }
    
    public static String getMenuText() {
        // Crear el texto del menú de eventos usando StringBuilder
        StringBuilder menuText = new StringBuilder();
        menuText.append("1. Ver Eventos\n");
        menuText.append("2. Participar en Eventos\n");
        menuText.append("3.Lista de participantes\n");
        menuText.append("4.Volver\n");
        menuText.append("Seleccione una opción:");
        return menuText.toString();
    }

}