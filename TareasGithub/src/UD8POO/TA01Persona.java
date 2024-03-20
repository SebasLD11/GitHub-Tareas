package UD8POO;
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
    protected String camiseta;
    protected String riderOalumno;
    protected static final char SEXO_POR_DEFECTO = 'H';

    // Constructores y métodos omitidos para simplificar

    // Método para pedir información
    public void pedirInformacion() {
    
        setNombre(JOptionPane.showInputDialog("Ingrese el nombre:"));
        setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:")));
        setDNI(JOptionPane.showInputDialog("Ingrese el DNI:"));
        String sexoInput = JOptionPane.showInputDialog("Ingrese el sexo (H para hombre, M para mujer):");
        setSexo(sexoInput.toUpperCase().charAt(0));
        setPeso(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso:")));
        setAltura(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura en metros:")));
        setCamiseta(JOptionPane.showInputDialog("Ingrese el tipo de camiseta:"));
    }

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

	public String getCamiseta() {
		return camiseta;
	}

	public void setCamiseta(String camiseta) {
		this.camiseta = camiseta;
	}

	public String getRiderOalumno() {
		return riderOalumno;
	}

	public void setRiderOalumno(String riderOalumno) {
		this.riderOalumno = riderOalumno;
	}

	public static char getSexoPorDefecto() {
		return SEXO_POR_DEFECTO;
	}

	// Método toString para mostrar información de la persona
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + DNI + "\nSexo: " + sexo +
                "\nPeso: " + peso + "\nAltura: " + altura + "\nTipo de camiseta: " + camiseta;
    }

	public void mostrarInfoPersona(String nombre2) {
		// TODO Auto-generated method stub
		
	}

	public void modificarParametros(String nombre2) {
		// TODO Auto-generated method stub
		
	}

	public void eliminarPersona(String nombre2) {
		// TODO Auto-generated method stub
		
	}
}

// Subclase Rider
class Rider extends TA01Persona {
    // Atributos adicionales
    private double sueldo;
    private boolean bonoTransporte;
    private boolean bonoMerchandising;
    private boolean bonoFirma;
    private boolean bonoGira;

    // Constructor
    public Rider() {
        super();
    }

    // Getters y setters para los atributos adicionales
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean getBonoTransporte() {
        return bonoTransporte;
    }

    public void setBonoTransporte(boolean bonoTransporte) {
        this.bonoTransporte = bonoTransporte;
    }

    public boolean isBonoMerchandising() {
        return bonoMerchandising;
    }

    public void setBonoMerchandising(boolean bonoMerchandising) {
        this.bonoMerchandising = bonoMerchandising;
    }

    public boolean getBonoFirma() {
        return bonoFirma;
    }

    public void setBonoFirma(boolean bonoFirma) {
        this.bonoFirma = bonoFirma;
    }

    public boolean getBonoGira() {
        return bonoGira;
    }

    public void setBonoGira(boolean bonoGira) {
        this.bonoGira = bonoGira;
    }
}

// Subclase Alumno
class Alumno1 extends TA01Persona {
    // Atributos adicionales
    private String tarifa;
    private int numClases;
    private boolean esRider;

    // Constructor
    public Alumno() {
        super();
    }

    // Getters y setters para los atributos adicionales
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

    public boolean isEsRider() {
        return esRider;
    }

    public void setEsRider(boolean esRider) {
        this.esRider = esRider;
    }
}
