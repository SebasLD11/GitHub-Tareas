package CLVTApp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Proyectos extends MenuControlador{
    private String nombre;
    private String descripcion;
    private List<String> personasResponsables;
    private double inversionEntrar;
    private double rentabilidadTrimestral;
    private static List<Participante> participantes;
	private static List<Proyectos> listaProyectos;


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
        this.descripcion = "Empresa multiservicios para el desarrollo de proyectos y el desarrollo comunitario."
        		+ "Creamos comunidades y acercamos tus proyectos a la realidad. "
        		+ "En VALODI SERVICES Group nos acompañan las tres 'Cs' como pilares fundamentales de nuestros valores,"
        		+ "Creemos, Creamos, Construimos!";
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

	public void setParticipantes(List<Participante> participantes) {
		Proyectos.participantes = participantes;
	}
    

	public  List<Proyectos> getListaProyectos() {
		return listaProyectos;
	}

	public  void setListaProyectos(List<Proyectos> listaProyectos) {
		Proyectos.listaProyectos = listaProyectos;
	}
	//mostrar info
    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", personasResponsables=" + personasResponsables +
                ", inversionEntrar=" + inversionEntrar + "€" +
                ", rentabilidadTrimestral=" + rentabilidadTrimestral + "%" +
                '}';
    }


    //método para participar en el proyecto
    public static void participarProyecto() {
        // Preguntar al usuario si desea participar en algún proyecto
         int opcionParticipar = JOptionPane.showConfirmDialog(null, "¿Desea participar en alguno de estos proyectos?", "Participación en Proyectos", JOptionPane.YES_NO_OPTION);
         if (opcionParticipar == JOptionPane.YES_OPTION) {
             String[] opcionesProyectos = {"Proyecto empresarial VALODI SERVICES Group", "Proyecto Skatepark nuevo Cambrils"};
             String proyectoSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el proyecto en el que desea participar:", "Selección de Proyecto", JOptionPane.QUESTION_MESSAGE, null, opcionesProyectos, opcionesProyectos[0]);

             // Según el proyecto seleccionado, llamar al método para participar en él
             switch (proyectoSeleccionado) {
                 case "Proyecto VALODI":
                 	Proyectos.participarProyecto();
                     break;
                 default:
                     JOptionPane.showMessageDialog(null, "Proyecto no válido.");
              
    	String nombrePerson = JOptionPane.showInputDialog("Ingrese su nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:"));
        String email = JOptionPane.showInputDialog("Ingrese su email:");
        String telefono = JOptionPane.showInputDialog("Ingrese su teléfono de contacto:");

        Participante nuevoParticipante = new Participante(nombrePerson, edad, email, telefono);
        agregarParticipante(nuevoParticipante);

        JOptionPane.showMessageDialog(null, "¡Gracias por participar en el proyecto! En un plazo máximo de 72h contactaremos contigo.");
    }
         }}

    public static void agregarParticipante(Participante participante) {
        participantes.add(participante);
    }

    public static void mainIniciarProyectos(String[] args) {
            // Crear una lista de personas responsables para un proyecto
            List<String> personasResponsables = new ArrayList<>();
            personasResponsables.add("1.Sebastián López, CEO. Rama fisico-deportiva y Mundo Digital.");
            personasResponsables.add("2.Marina Figueras, Cofunder. Rama AMZN FBA.");
            personasResponsables.add("3.Milena López, Cofunder. Rama Terapeutica.");
            personasResponsables.add("4.Ingrid, Cofunder. Rama artistica.");

            listaProyectos = new ArrayList<>();
            Proyectos proyecto = new Proyectos("PROYECTO EMPRESARIAL VALODI SERVICES Group",
                       "- Empresa multiservicios para el desarrollo de proyectos y el desarrollo comunitario."
                     + "- Creamos comunidades y acercamos tus proyectos a la realidad. "
                     + "- En VALODI SERVICES Group nos acompañan las tres 'Cs' como pilares fundamentales de nuestros valores,"
                     + "- Creemos, Creamos, Construimos!",
                    personasResponsables, 500.0, 2.0);
            // Mostrar información del proyecto utilizando JOptionPane
            JOptionPane.showMessageDialog(null, proyecto.toString(), "Información del Proyecto", JOptionPane.INFORMATION_MESSAGE);

            // Participar en el proyecto
            Proyectos.participarProyecto();
        }

    }

