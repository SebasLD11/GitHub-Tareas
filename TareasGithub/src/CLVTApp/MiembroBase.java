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
	        setNombre(JOptionPane.showInputDialog("Ingrese el nombre:"));
	        setPoblacion(JOptionPane.showInputDialog("Población:"));
	        setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:")));
	        setDNI(JOptionPane.showInputDialog("Ingrese el DNI:"));
	        setSexo(JOptionPane.showInputDialog("Ingrese el sexo (H=hombre, M=mujer, NE=No especificado"));
	        setCamiseta(JOptionPane.showInputDialog("Ingrese el tipo de camiseta:"));
	        setAltura(Double.parseDouble(JOptionPane.showInputDialog("Altura:")));
	        setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso:")));	       
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