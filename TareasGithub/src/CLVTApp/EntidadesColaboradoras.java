package CLVTApp;

import javax.swing.JOptionPane;

public class EntidadesColaboradoras extends ClvtMiembros{
	
	private String proyecto;
	private String añoColabora;
	//constructores

	public EntidadesColaboradoras(String nombre, String poblacion, String proyecto, String añoColabora) {
		this.proyecto = proyecto;
		this.añoColabora = añoColabora;
	}
    

	public EntidadesColaboradoras(String nombre, String poblacion, String proyecto) {
		this.proyecto = proyecto;
		this.añoColabora = "";
	}


	public EntidadesColaboradoras(String proy, String añoCola) {
		this.proyecto = proy;
		this.añoColabora = añoCola;
	}

	public EntidadesColaboradoras() {
		this.proyecto = "";
		this.añoColabora = "";
	}


	//getters y setters
    
    public String getNombre(String nombre) {
		return nombre;
	}
	public void setNombre(String nombre) {
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
    
	//método para pedir info
	public void pedirInformacion() {
        setNombre(JOptionPane.showInputDialog("Nombre de la entidad:"));
        setProyecto(JOptionPane.showInputDialog("Proyecto de colaboración:"));
        setAñoColabora(JOptionPane.showInputDialog("Fecha de colaboración:")); 
    }
}
