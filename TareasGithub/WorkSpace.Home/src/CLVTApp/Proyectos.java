package CLVTApp;

import java.util.ArrayList;
import java.util.List;

public class Proyectos extends MenuControlador{
    private String nombre;
    private String descripcion;
    private List<String> personasResponsables;
    private double inversionEntrar;
    private double rentabilidadTrimestral;

    public Proyectos(String nombre, String descripcion, List<String> personasResponsables,
                    double inversionEntrar, double rentabilidadTrimestral) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.personasResponsables = new ArrayList<>(personasResponsables);
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
        this.nombre = "PROYECTO EMPRESARIAL VALODI SERVICES";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = "Empresa multiservicios para el desarrollo de proyectos y el desarrollo comunitario."
        		+ "Creamos comunidades y acercamos tus proyectos a la realidad. "
        		+ "Creemos, Creamos, Construimos!";
    }

    public List<String> getPersonasResponsables() {
        return personasResponsables;
    }

    public void setPersonasResponsables(List<String> personasResponsables) {
        personasResponsables.add("Sebastián López, CEO. Rama fisico-deportiva y Mundo Digital.");
        personasResponsables.add("Marina Figueras, Cofunder. Rama AMZN FBA.");
        personasResponsables.add("Milena López, Cofunder. Rama Terapeutica.");
        personasResponsables.add("Ingrid, Cofunder. Rama artistica.");
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

}
