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
        setTarifa(JOptionPane.showInputDialog("Tipo de tarifa:"));
        setAportacion(JOptionPane.showInputDialog("Aportación mensual:"));
        setNumClases(Integer.parseInt(JOptionPane.showInputDialog("Número de clases:")));
        setEsRider(JOptionPane.showInputDialog("¿Este/a alumno/a es rider?"));
        setServDisfrutados(JOptionPane.showInputDialog("¿Que servicios disfruta?"));
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
