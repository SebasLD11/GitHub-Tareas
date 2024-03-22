package ud08POO;
import javax.swing.JOptionPane;

// Clase base TA01Persona
public class TA01Persona {
    // Atributos
    protected String nombre;
    protected int edad;
    protected String DNI;
    protected char sexo;
    protected double peso;
    protected double altura;
    protected static final char SEXO_POR_DEFECTO = 'H';

    // Constructores 
	public TA01Persona(String nombre, int edad, String DNI, char sexo, double peso, double altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = DNI;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
    public TA01Persona() {
		super();
		this.nombre = "";
		this.edad = 0;
		this.DNI = "";
		this.sexo = SEXO_POR_DEFECTO;
		this.peso = 0.0;
		this.altura = 0.0;
	}

	public TA01Persona(String nombre, int edad, String dNI, char sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = dNI;
		this.sexo = sexo;
	}

	public TA01Persona(double peso, double altura) {
		super();
		this.peso = peso;
		this.altura = altura;
	}

	//getters y setters
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
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

	// Métodos para ejecutar, pedir y mostrar información
    public void pedirInformacion() {
    
        setNombre(JOptionPane.showInputDialog("Ingrese el nombre:"));
        setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:")));
        setDNI(JOptionPane.showInputDialog("Ingrese el DNI:"));
        String sexoInput = JOptionPane.showInputDialog("Ingrese el sexo (H para hombre, M para mujer):");
        setSexo(sexoInput.toUpperCase().charAt(0));
        setPeso(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso:")));
        setAltura(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura en metros:")));
    }
	
	public void mostrarInfo() {
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nEdad: " + edad +
        		"\nDNI: " + DNI + "\nSexo: " + sexo + "\nPeso: " + peso +"Kg" + "\nAltura: " + altura+"m");
    }
   
    public static void main(String[] args) {
		TA01Persona person = new TA01Persona();
		person.pedirInformacion();
		person.mostrarInfo();
		
	}
}
