package CLVTApp;

import javax.swing.JOptionPane;

public class Riders extends MiembroBase {
    private String funciones;
    private String sueldo;
    private String bonoTransporte;
    private String bonoMerchandising;
    private String bonoFirma;
    private String bonoGira;

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
             
        // Opciones para seleccionar la info especial de Riders
        Object[] opcionessueldo = {"10€/h", "15€/h", "20-25€/h", "30-35€/h", "50€/h"};
        int opcionsueldo = JOptionPane.showOptionDialog(null, "¿Que sueldo recibe?",
                "sueldo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opcionessueldo, opcionessueldo[0]);
        this.sueldo = opcionessueldo[opcionsueldo].toString();

        Object[] opcionesfunciones = {"Coordinador/a", "Monitor/a", "Responsable de Skate", "Responsable de Scooter", "Colaborador/a"};
        int opcionfunciones = JOptionPane.showOptionDialog(null, "¿Que funciones tiene?",
                "funciones", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opcionesfunciones, opcionesfunciones[0]);
        this.funciones = opcionesfunciones[opcionfunciones].toString();
        
        Object[] opcionesBonoTransporte = {"Sí, mensual", "Si, parcial", "No"};
        int opcionBonoTransporte = JOptionPane.showOptionDialog(null, "¿Recibe bono de transporte?",
                "Bono de Transporte", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opcionesBonoTransporte, opcionesBonoTransporte[0]);
        this.bonoTransporte = opcionesBonoTransporte[opcionBonoTransporte].toString();
        
        Object[] opcionesBonoMerchandising = {"Sí, todos los productos", "Si, parcial", "No"};
        int opcionBonoMerchandising = JOptionPane.showOptionDialog(null, "¿Recibe bono de merchandising?",
                "Bono de Merchandising", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opcionesBonoMerchandising, opcionesBonoMerchandising[0]);
        this.bonoMerchandising = opcionesBonoMerchandising[opcionBonoMerchandising].toString();
        
        // Opciones para seleccionar el bono de firma
        Object[] opcionesBonoFirma = {"Sí. 50% de ventas de la firma", "No"};
        int opcionBonoFirma = JOptionPane.showOptionDialog(null, "¿Recibe bono de firma?",
                "Bono de Firma", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opcionesBonoFirma, opcionesBonoFirma[0]);
        this.bonoFirma = opcionesBonoFirma[opcionBonoFirma].toString();
        
        // Opciones para seleccionar el bono de gira
        Object[] opcionesBonoGira = {"Sí. % no liquidado de sueldos", "No"};
        int opcionBonoGira = JOptionPane.showOptionDialog(null, "¿Recibe bono de gira?",
                "Bono de Gira", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opcionesBonoGira, opcionesBonoGira[0]);
        this.bonoGira = opcionesBonoGira[opcionBonoGira].toString();
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