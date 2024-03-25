package CLVTApp;

import javax.swing.JOptionPane;

public class MiembroBase extends CLVTApp {
    protected String nombre;
    protected String poblacion;
    protected int edad;
    protected String DNI;
    protected String sexo;
    protected double peso;
    protected double altura;
    protected String camiseta;

    //Constructors
    public MiembroBase(String nombre, String poblacion, int edad, String dNI, String sexo, double peso, double altura,
			String camiseta) {
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.edad = edad;
		DNI = dNI;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		this.camiseta = camiseta;
	}

	public MiembroBase() {
		this.nombre = "";
		this.poblacion =  "";
		this.edad = 0;
		DNI =  "";
		this.sexo = "";
		this.peso = 0.0;
		this.altura = 0.0;
		this.camiseta = "";
	}

	public MiembroBase(String nombre, String poblacion) {
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.edad = 0;
		DNI = "";
		this.sexo = "";
		this.peso = 0.0;
		this.altura = 0.0;
		this.camiseta = "";
	}

	public MiembroBase(int edad, String dNI, String sexo, double peso, double altura,
			String camiseta) {
		this.nombre = "";
		this.poblacion = "";
		this.edad = edad;
		DNI = dNI;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		this.camiseta = camiseta;
	}

	// Getters y setters para los atributos
	public String getNombre() {
    return nombre;
}

	public void setNombre(String nombre) {
    this.nombre = nombre;
}

	public String getPoblacion() {
    return poblacion;
}

	public void setPoblacion(String poblacion) {
    this.poblacion = poblacion;
}

	public int getEdad() {
    return edad;
}

	public void setEdad(int edad) {
    this.edad = edad;
}

	public String getDNI() {
    return DNI;
}

	public void setDNI(String dNI) {
    DNI = dNI;
}

	public String getSexo() {
    return sexo;
}

	public void setSexo(String sexo) {
    this.sexo = sexo;
}

	public double getPeso() {
    return peso;
}

	public void setPeso(double peso) {
    this.peso = peso;
}

	public double getAltura() {
    return altura;
}

	public void setAltura(double altura) {
    this.altura = altura;
}

	public String getCamiseta() {
    return camiseta;
}

	public void setCamiseta(String camiseta) {
    this.camiseta = camiseta;
}
	
	//método para pedir info
	public void pedirInformacion() {
        this.nombre = JOptionPane.showInputDialog("Nombre:");
        this.poblacion = JOptionPane.showInputDialog("Población:");
        this.edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
        this.DNI = JOptionPane.showInputDialog("DNI:");
        
        // Opciones para seleccionar el sexo
        Object[] opcionesSexo = {"Masculino", "Femenino", "Otro"};
        int opcionSexo = JOptionPane.showOptionDialog(null, "Seleccione el sexo:", "Sexo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesSexo, opcionesSexo[0]);
        this.sexo = opcionesSexo[opcionSexo].toString();
        
        // Opciones para seleccionar la talla de camiseta
        Object[] opcionesCamiseta = {"S", "M", "L"};
        int opcionCamiseta = JOptionPane.showOptionDialog(null, "Seleccione la talla de camiseta:", "Talla de Camiseta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesCamiseta, opcionesCamiseta[0]);
        this.camiseta = opcionesCamiseta[opcionCamiseta].toString();

        this.peso = Double.parseDouble(JOptionPane.showInputDialog("Peso:"));
        this.altura = Double.parseDouble(JOptionPane.showInputDialog("Altura:"));
    }

	 public static void agregarMiembroBase() {
		    MiembroBase nuevoMiembroBase = new MiembroBase();
		    nuevoMiembroBase.pedirInformacion();
		    String nombre = nuevoMiembroBase.getNombre();
		    if (!personas.containsKey(nombre)) {
		        personas.put(nombre, nuevoMiembroBase);
		        JOptionPane.showMessageDialog(null, "Miembro Base agregado correctamente.");
		    } else {
		        JOptionPane.showMessageDialog(null, "Ya existe un miembro con ese nombre.");
		    }
		}

	    @Override
	 public String toString() {
	        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + DNI + "\nSexo: " + sexo +
	                "\nCamiseta: " + camiseta;
	    }
}