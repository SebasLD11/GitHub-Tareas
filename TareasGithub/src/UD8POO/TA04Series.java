package UD8POO;

import javax.swing.JOptionPane;

public class TA04Series {
	//Atributos
	
	protected String titulo;
	protected int tempos;
	protected boolean temporadas;
	protected String genero;
	protected String creador;
	
	//constructores
	
	public TA04Series(String titulo, int tempos, boolean temporadas, String genero, String creador) {
		this.titulo = titulo;
		this.tempos = tempos;
		this.temporadas = temporadas;
		this.genero = genero;
		this.creador = creador;
	}

	public TA04Series() {
		this.titulo = "";
		this.tempos = 0;
		this.temporadas = false;
		this.genero = "";
		this.creador = "";
	}
	
	//getters y setters
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTempos() {
		return tempos;
	}

	public void setTempos(int tempos) {
		this.tempos = tempos;
	}

	public boolean isTemporadas() {
		return temporadas;
	}

	public void setTemporadas(boolean temporadas) {
		this.temporadas = temporadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public void pedirInformacion() {
	    
	    setTitulo(JOptionPane.showInputDialog("Introduzca el titulo de la serie:"));
	    setTempos(Integer.parseInt(JOptionPane.showInputDialog("Número de temporadas:")));
	    setTemporadas(Boolean.parseBoolean(JOptionPane.showInputDialog("¿Estan entregadas estas temporadas?")));
	    setGenero(JOptionPane.showInputDialog("Genero del contenido:"));
		setCreador(JOptionPane.showInputDialog("Creador:"));    
		}

	public void mostrarInfo() {
        JOptionPane.showMessageDialog(null, "Titulo: " + titulo + "\nNº de temporadas: " + tempos +
        		"\n¿Estan todas las temporadas entregadas? " + temporadas + "\nGenero: " + genero + "\nCreador: " + creador);
    }
	public static void main(String[] args) {
		TA04Series info = new TA04Series();
    	info.pedirInformacion();
    	info.mostrarInfo();
    }
}


