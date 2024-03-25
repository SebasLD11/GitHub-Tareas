package CLVTApp;

import javax.swing.JOptionPane;

public class Riders extends MiembroBase {
    protected String funciones;
    protected String sueldo;
    protected String bonoTransporte;
    protected String bonoMerchandising;
    protected String bonoFirma;
    protected String bonoGira;

    //constructors por defecto
    public Riders(String nombre, String poblacion, int edad, String dNI, String sexo, double peso, double altura,
 			String camiseta, String funciones, String sueldo, String bonoTransporte, String bonoMerchandising,
 			String bonoFirma, String bonoGira) {
 		super(nombre, poblacion, edad, dNI, sexo, peso, altura, camiseta);
 		this.funciones = funciones;
 		this.sueldo = sueldo;
 		this.bonoTransporte = bonoTransporte;
 		this.bonoMerchandising = bonoMerchandising;
 		this.bonoFirma = bonoFirma;
 		this.bonoGira = bonoGira;
 	}

    public Riders() {
		// TODO Auto-generated constructor stub
	}

	//getters y setters
    public String getFunciones() {
        return funciones;
    }

	public void setFunciones(String funciones) {
        this.funciones = funciones;
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

    public void setBonoTransporte(String bonoTransporte) {
        this.bonoTransporte = bonoTransporte;
    }

    public String getBonoMerchandising() {
        return bonoMerchandising;
    }

    public void setBonoMerchandising(String bonoMerchandising) {
        this.bonoMerchandising = bonoMerchandising;
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

    //pedir y mostrar info
    @Override
    public void pedirInformacion() {
        super.pedirInformacion();
        setFunciones(JOptionPane.showInputDialog("¿Qué funciones tiene este rider?"));
        setSueldo(JOptionPane.showInputDialog("Ingrese el sueldo:"));
        setBonoTransporte(JOptionPane.showInputDialog("¿Tiene bono transporte?"));
        setBonoMerchandising(JOptionPane.showInputDialog("Bono de merchandising:"));
        setBonoFirma(JOptionPane.showInputDialog("¿Tiene bono de firma?"));
        setBonoGira(JOptionPane.showInputDialog("¿Tiene bono de gira?"));
    }

    @Override
    public String toString() {
        return super.toString() + "\nFunciones: " + funciones +
                "\nSueldo: " + sueldo +
                "\nBono de Transporte: " + bonoTransporte +
                "\nBono de Merchandising: " + bonoMerchandising +
                "\nBono de Firma: " + bonoFirma +
                "\nBono de Gira: " + bonoGira;
    }

}
