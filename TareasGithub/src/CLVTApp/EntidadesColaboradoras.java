package CLVTApp;

import javax.swing.JOptionPane;

public class EntidadesColaboradoras extends MiembroBase {
    private String proyecto;
    private String añoColabora;
    private String NIF;

    public EntidadesColaboradoras() {
        super(); // Llamada al constructor vacío de la superclase
        this.proyecto = "";
        this.añoColabora = "";
        this.NIF = "";
    }

    public EntidadesColaboradoras(String nombre, String poblacion, String proyecto, String añoColabora, String NIF) {
        super(nombre, poblacion); // Llamada al constructor de la superclase con nombre y población
        this.proyecto = proyecto;
        this.añoColabora = añoColabora;
        this.NIF = NIF;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getAñoColabora() {
        return añoColabora;
    }

    public void setAñoColabora(String añoColabora) {
        this.añoColabora = añoColabora;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void pedirInformacion() {
        // Pedir nombre y población de la superclase MiembroBase
        setNombre(JOptionPane.showInputDialog("Nombre de la entidad:"));
        setPoblacion(JOptionPane.showInputDialog("Población de la entidad:"));
        setProyecto(JOptionPane.showInputDialog("Proyecto de colaboración:"));
        setAñoColabora(JOptionPane.showInputDialog("Fecha de colaboración:"));
        setNIF(JOptionPane.showInputDialog("NIF de la entidad:"));
    }
}
