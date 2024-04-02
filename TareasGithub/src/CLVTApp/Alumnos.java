package CLVTApp;

import javax.swing.JOptionPane;

public class Alumnos extends MiembroBase {
    protected String tarifa;
    protected int numClases;
    protected String esRider;
    protected String aportacion;
    protected String servDisfrutados;

    //constructors por defecto
    public Alumnos(String nombre, String poblacion, int edad, String dNI, String sexo, double peso, double altura,
			String camiseta, String tarifa, int numClases, String esRider, String aportacion, String servDisfrutados) {
		super(nombre, poblacion, edad, dNI, sexo, peso, altura, camiseta);
		this.tarifa = tarifa;
		this.numClases = numClases;
		this.esRider = esRider;
		this.aportacion = aportacion;
		this.servDisfrutados = servDisfrutados;
	}

	public Alumnos() {
		// TODO Auto-generated constructor stub
	}

	//getters y setters
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

    public String getEsRider() {
        return esRider;
    }

    public void setEsRider(String esRider) {
        this.esRider = esRider;
    }

    public String getAportacion() {
        return aportacion;
    }

    public void setAportacion(String aportacion) {
        this.aportacion = aportacion;
    }

    public String getServDisfrutados() {
        return servDisfrutados;
    }

    public void setServDisfrutados(String servDisfrutados) {
        this.servDisfrutados = servDisfrutados;
    }

    //pedir y mostrar info
    @Override
    public void pedirInformacion() {
        super.pedirInformacion();
        this.numClases = Integer.parseInt(JOptionPane.showInputDialog("Número de clases:"));
        
        // Opciones para seleccionar si es Rider
        
        Object[] opcionesEsRider = {"Sí", "No", "Proyecto amateur"};
        int opcionEsRider = JOptionPane.showOptionDialog(null, "¿Es Rider?",
                "Rider", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opcionesEsRider, opcionesEsRider[0]);
        this.esRider = opcionesEsRider[opcionEsRider].toString();
        
        Object[] opcionestarifa = {"Reducida", "Completa", "Reducida +2h particulares", "Completa +4h particulares"};
        int opciontarifa = JOptionPane.showOptionDialog(null, "¿Que tarifa tiene?",
                "tarifa", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opcionestarifa, opcionestarifa[0]);
        this.tarifa = opcionestarifa[opciontarifa].toString();
        
        Object[] opcionesaportacion = {"25€", "35€", "50€", "80€"};
        int opcionaportacion = JOptionPane.showOptionDialog(null, "¿Aportación de la tarifa?",
                "aportacion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opcionesaportacion, opcionesaportacion[0]);
        this.aportacion = opcionesaportacion[opcionaportacion].toString();
        
        Object[] opcionesservDisfrutados = {"Taller Básico Skate/Scooter Completo", "Taller Básico Skate/Scooter Reducido", "Taller Básico Skate/Scooter Reducido+2h", "Taller Básico Skate/Scooter Completo+4h"};
        int opcionservDisfrutados = JOptionPane.showOptionDialog(null, "¿Aportación de la tarifa?",
                "servDisfrutados", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opcionesservDisfrutados, opcionesservDisfrutados[0]);
        this.servDisfrutados = opcionesservDisfrutados[opcionservDisfrutados].toString();
       
    }



    @Override
    public String toString() {
        return super.toString() + "\nTarifa: " + tarifa +
                "\nNúmero de Clases: " + numClases +
                "\nEs Rider: " + esRider +
                "\nAportación Mensual: " + aportacion +
                "\nServicios Disfrutados: " + servDisfrutados;
    }

}
