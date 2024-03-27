package CLVTApp;

import javax.swing.JOptionPane;

public class EntidadesColaboradoras extends MiembroBase {
    private String proyecto;
    private String añoColabora;

    public EntidadesColaboradoras() {
        super(); // Llamada al constructor vacío de la superclase
        this.proyecto = "";
        this.añoColabora = "";
       
    }

    public EntidadesColaboradoras(String nombre, String poblacion, String proyecto, String añoColabora) {
        super(nombre, poblacion); // Llamada al constructor de la superclase con nombre y población
        this.proyecto = proyecto;
        this.añoColabora = añoColabora;
  
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