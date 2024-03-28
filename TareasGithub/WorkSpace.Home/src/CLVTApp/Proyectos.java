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

    public Proyectos(String nombre, String descripcion, List<String> personasResponsables,
                    double inversionEntrar, double rentabilidadTrimestral) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.personasResponsables = new ArrayList<>(personasResponsables);
        this.inversionEntrar = inversionEntrar;
        this.rentabilidadTrimestral = rentabilidadTrimestral;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        this.inversionEntrar = inversionEntrar;
    }

    public double getRentabilidadTrimestral() {
        return rentabilidadTrimestral;
    }

    public void setRentabilidadTrimestral(double rentabilidadTrimestral) {
        this.rentabilidadTrimestral = rentabilidadTrimestral;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", personasResponsables=" + personasResponsables +
                ", inversionEntrar=" + inversionEntrar +
                ", rentabilidadTrimestral=" + rentabilidadTrimestral +
                '}';
    }

}
