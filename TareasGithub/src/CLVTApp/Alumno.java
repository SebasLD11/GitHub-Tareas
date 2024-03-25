package CLVTApp;

import javax.swing.JOptionPane;

class Alumno extends ClvtMiembros {
    // Atributos adicionales para Alumno
	public Alumno() {
			super();
	}
	protected String tarifa;
    protected int numClases;
    protected String esRider;
    
    public void pedirInformacion() {
        super.pedirInformacion();
        setTarifa(JOptionPane.showInputDialog("Tipo de tarifa:"));
        setNumClases(Integer.parseInt(JOptionPane.showInputDialog("Número de clases:")));
        setEsRider(JOptionPane.showInputDialog("¿Este/a alumn@ es rider?"));  
    }
	public String getTarifa() {
		return tarifa;
	}
	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}
	public int getNumClases() {
		return numClases;
	}
	public void setNumClases(int numClases) {
		this.numClases = numClases;
	}
	public String isEsRider() {
		return esRider;
	}
	public void setEsRider(String esRider) {
		this.esRider = esRider;
	}
}