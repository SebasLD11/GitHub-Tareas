package CLVTApp;

import javax.swing.JOptionPane;

class Riders extends ClvtMiembros {
	
	public Riders() {
	    	super();
	    }
	protected double sueldo;
    protected String bonoTransporte;
    protected String bonoMerchandising;
    protected String bonoFirma;
    protected String bonoGira;

    public void pedirInformacion() {
        super.pedirInformacion();
        setSueldo(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo:")));
        setBonoTransporte(JOptionPane.showInputDialog("¿Tiene bono transporte?"));
        setBonoMerchandising(JOptionPane.showInputDialog("Bono de merchandising:"));
        setBonoFirma(JOptionPane.showInputDialog("¿Tiene bono de firma?"));
        setBonoGira(JOptionPane.showInputDialog("¿Tiene bono de gira?"));
    }
    
    // Getters y setters para los atributos adicionales
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getBonoTransporte() {
        return bonoTransporte;
    }

    public void setBonoTransporte(String bT) {
        this.bonoTransporte = bT;
    }

    public String getBonoMerchandising() {
        return bonoMerchandising;
    }

    public void setBonoMerchandising(String bonoMerchandising) {
        this.bonoMerchandising = "";
    }

    public String getBonoFirma() {
        return bonoFirma;
    }

    public void setBonoFirma(String bonoFirma) {
        this.bonoFirma = bonoFirma;
    }

    public String getBonoGira() {
        return bonoGira;
    }

    public void setBonoGira(String bonoGira) {
        this.bonoGira = bonoGira;
    }
}