package CLVTApp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Proyectos extends MenuControlador {
    private String nombre;
    private String descripcion;
    private List<String> personasResponsables;
    private double inversionEntrar;
    private double rentabilidadTrimestral;
    private static List<Participante> participantes;
	private static List<Proyectos> listaProyectos;
	private static List<String> responsablesNewPark;


    public Proyectos(String nombre, String descripcion, List<String> personasResponsables,
                    double inversionEntrar, double rentabilidadTrimestral) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.personasResponsables = new ArrayList<>(personasResponsables);
        personasResponsables.add("Sebastián López, CEO. Rama fisico-deportiva y Mundo Digital.");
        personasResponsables.add("Marina Figueras, Cofunder. Rama AMZN FBA.");
        personasResponsables.add("Milena López, Cofunder. Rama Terapeutica.");
        personasResponsables.add("Ingrid, Cofunder. Rama artistica.");
        this.inversionEntrar = inversionEntrar;
        this.rentabilidadTrimestral = rentabilidadTrimestral;
    }
    
    public Proyectos(List<String> personasResponsables) {
		super();
		this.nombre = "";
		this.descripcion = "";
		this.personasResponsables = personasResponsables;
		this.inversionEntrar = 0.0;
		this.rentabilidadTrimestral = 0.0;
	}

	// Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = "PROYECTO EMPRESARIAL VALODI SERVICES Group";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = "Empresa multiservicios para el desarrollo de proyectos y el desarrollo comunitario.\n"
        		+ "Creamos comunidades y acercamos tus proyectos a la realidad.\n "
        		+ "En VALODI SERVICES Group nos acompañan las tres 'Cs' como pilares fundamentales de nuestros valores,\n"
        		+ "Creemos, Creamos, Construimos!\n";
    }

    public List<String> getPersonasResponsables() {
        return personasResponsables;
    }

    public void setPersonasResponsables(List<String> personasResponsables) {
    	this.personasResponsables = personasResponsables;
    }

    public double getInversionEntrar() {
        return inversionEntrar;
    }

    public void setInversionEntrar(double inversionEntrar) {
        this.inversionEntrar = 500.0;
    }

    public double getRentabilidadTrimestral() {
        return rentabilidadTrimestral;
    }

    public void setRentabilidadTrimestral(double rentabilidadTrimestral) {
        this.rentabilidadTrimestral = 2.0;
    }
    
    public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participante) {
		Proyectos.participantes = participante;
	}
    
	public  List<Proyectos> getListaProyectos() {
		return listaProyectos;
	}

	public  void setListaProyectos(List<Proyectos> listaProyectos) {
		Proyectos.listaProyectos = listaProyectos;
	}
	
	public static List<String> getResponsablesNewPark() {
		return responsablesNewPark;
	}

	public static void setResponsablesNewPark(List<String> responsablesNewPark) {
		Proyectos.responsablesNewPark = responsablesNewPark;
	}	

	//mostrar info
    @Override
    public String toString() {
        StringBuilder infoProyecto = new StringBuilder();
        infoProyecto.append("Nombre del proyecto: ").append(nombre).append("\n");
        infoProyecto.append("Descripción: ").append(descripcion).append("\n");
        infoProyecto.append("Responsables del proyecto: ").append(personasResponsables).append("\n");
        infoProyecto.append("Inversión inicial: ").append(inversionEntrar).append("€.\n");
        infoProyecto.append("Rentabilidad trimestral: ").append(rentabilidadTrimestral).append("%.\n");

        // Agregar información de los participantes
        if (participantes != null && !participantes.isEmpty()) {
            infoProyecto.append("\nParticipantes:\n");
            for (Participante participante : participantes) {
                infoProyecto.append("- ").append(participante.toString()).append("\n");
            }
        }

        return infoProyecto.toString();
    }

   
 // Método para participar en el proyecto
    public void participarProyecto() {
        // Preguntar al usuario si desea participar en algún proyecto
        int opcionParticipar = JOptionPane.showConfirmDialog(null, "¿Desea participar en alguno de estos proyectos?", "Participación en Proyectos", JOptionPane.YES_NO_OPTION);
        if (opcionParticipar == JOptionPane.YES_OPTION) {
            String[] opcionesProyectos = {"Proyecto empresarial VALODI SERVICES Group", "Proyecto Skatepark nuevo Cambrils"};
            String proyectoSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el proyecto en el que desea participar:", "Selección de Proyecto", JOptionPane.QUESTION_MESSAGE, null, opcionesProyectos, opcionesProyectos[0]);

            // Crear un nuevo participante
            String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:"));
            String email = JOptionPane.showInputDialog("Ingrese su email:");
            String telefono = JOptionPane.showInputDialog("Ingrese su teléfono de contacto:");
            Participante participante = new Participante(nombre, edad, email, telefono);

            // Según el proyecto seleccionado, llamar al método para participar en él
            switch (proyectoSeleccionado) {
                case "Proyecto empresarial VALODI SERVICES Group":
                    agregarParticipante(participante);
                    break;
                case "Proyecto Skatepark nuevo Cambrils":
                    agregarParticipante(participante);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Accediendo...");
            }

            JOptionPane.showMessageDialog(null, "¡Gracias por participar en el proyecto! En un plazo máximo de 72h contactaremos contigo.");
        }else {
            // Mostrar información de los proyectos nuevamente
            JOptionPane.showMessageDialog(null, listaProyectos.get(0).toString(), "Información del Proyecto", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, listaProyectos.get(1).toString(), "Información del Proyecto", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void agregarParticipante(Participante participante) {
        participantes.add(participante);
    }
 
    public static void mostrarListaParticipantes() {
        StringBuilder participantesInfo = new StringBuilder("Lista de Participantes:\n");
        for (Participante participante : participantes) {
            participantesInfo.append(participante.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, participantesInfo.toString(), "Lista de Participantes", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        // Inicializar listas
        listaProyectos = new ArrayList<>();
        participantes = new ArrayList<>();
        responsablesNewPark = new ArrayList<>();

        // Crear una lista de personas responsables para un proyecto
        List<String> personasResponsables = new ArrayList<>();
        personasResponsables.add("1.Sebastián López, CEO. Rama fisico-deportiva y Mundo Digital.\n");
        personasResponsables.add("2.Marina Figueras, Cofunder. Rama AMZN FBA.\n");
        personasResponsables.add("3.Milena López, Cofunder. Rama Terapeutica.\n");
        personasResponsables.add("4.Ingrid, Cofunder. Rama artistica.\n");

        // Agregar responsables para el nuevo parque
        responsablesNewPark.add("1.Asociación Cultivate.\n");
        responsablesNewPark.add("2.Ayuntaminento de Cambrils.\n");
        responsablesNewPark.add("3.SkateArquitechs.\n");

        // Crear proyectos
        Proyectos proyectoVALODI = new Proyectos("PROYECTO EMPRESARIAL VALODI SERVICES Group",
                "- Empresa multiservicios para el desarrollo de proyectos y el desarrollo comunitario.\n"
                        + "- Creamos comunidades y acercamos tus proyectos a la realidad. \n"
                        + "- En VALODI SERVICES Group nos acompañan las tres 'Cs' como pilares fundamentales de nuestros valores.\n"
                        + "- Creemos, Creamos, Construimos!\n",
                personasResponsables, 500.0, 2.0);
        Proyectos proyectoParque = new Proyectos("PROYECTO SkatePark Nuevo",
                " - Remodelación y ampliación del actual parque.\n"
                        + " - Trabajo hecho mediante reuniones con Joventut Cambrils y Skatearquitechs. \n"
                        + " - Para dicho proyecto no es necesaria inversión, dado que es público y se encarga el ayuntamiento.\n"
                        + " - Si están abiertos los donativos para intentar agilizar los trámites y construcción.\n",
                responsablesNewPark, 0.0, 0.0);

        // Agregar proyectos a la lista
        listaProyectos.add(proyectoVALODI);
        listaProyectos.add(proyectoParque);

        // Mostrar información del proyecto utilizando JOptionPane
        JOptionPane.showMessageDialog(null, proyectoVALODI.toString(), "Información del Proyecto", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, proyectoParque.toString(), "Información del Proyecto", JOptionPane.INFORMATION_MESSAGE);

        // Participar en el proyecto
        proyectoParque.participarProyecto();
        proyectoVALODI.participarProyecto();
        Proyectos.mostrarListaParticipantes();
    }
}