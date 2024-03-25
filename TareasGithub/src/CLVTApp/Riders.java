package CLVTApp;

import javax.swing.JOptionPane;

public class Riders extends ClvtMiembros {
	
	public Riders() {
	    	super();
	    }
	protected String Funciones;
	protected String sueldo;
    protected String bonoTransporte;
    protected String bonoMerchandising;
    protected String bonoFirma;
    protected String bonoGira;
    protected String contraUsuario;

	public void pedirInformacion() {
        super.pedirInformacion();
        setFunciones(JOptionPane.showInputDialog("¿Que funciones tiene este rider?"));
        setSueldo(JOptionPane.showInputDialog("Ingrese el sueldo:"));
        setBonoTransporte(JOptionPane.showInputDialog("¿Tiene bono transporte?"));
        setBonoMerchandising(JOptionPane.showInputDialog("Bono de merchandising:"));
        setBonoFirma(JOptionPane.showInputDialog("¿Tiene bono de firma?"));
        setBonoGira(JOptionPane.showInputDialog("¿Tiene bono de gira?"));
    }
    
    // Getters y setters para los atributos adicionales
    public String getFunciones() {
    	return Funciones;
    }    
    public String setFunciones(String Func) {
		return Func;    	
    }    
    public String getSueldo() {
        return sueldo;
    }
    public void setSueldo(String sueldo) {
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
    public String getContraUsuario() {
  		return contraUsuario;
  	}
  	public void setContraUsuario(String contraUsuario) {
  		this.contraUsuario = contraUsuario;
  	}
}