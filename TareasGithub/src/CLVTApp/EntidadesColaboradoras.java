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
        // Lógica para pedir información común a todas las clases
        super.pedirInformacion();

        // Pedir información específica de EntidadesColaboradoras
        String proyecto = JOptionPane.showInputDialog("Ingrese el proyecto en colaboración:");
        setProyecto(proyecto);

        String añoColabora = JOptionPane.showInputDialog("Ingrese el año de colaboración:");
        setAñoColabora(añoColabora);
    }

}
