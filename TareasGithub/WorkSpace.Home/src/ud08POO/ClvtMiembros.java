package ud08POO;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class ClvtMiembros {
    protected String nombre;
    protected int edad;
    protected String DNI;
    protected char sexo;
    protected double peso;
    protected double altura;
    protected String camiseta;
    protected static Map<String, ClvtMiembros> personas = new HashMap<>();
    private static final String ADMIN_PASSWORD = "CLVT22";

    public void accederMenuPrincipal() {
        String password = JOptionPane.showInputDialog("Ingrese la contraseña de administrador:");
        if (!password.equals(ADMIN_PASSWORD)) {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Acceso denegado.");
            return;
        }

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menú Principal:\n" +
                            "1. Agregar nueva persona\n" +
                            "2. Ver información total de personas\n" +
                            "3. Ver información de una persona específica\n" +
                            "4. Modificar parámetros de una persona\n" +
                            "5. Eliminar persona\n" +
                            "6. Salir\n" +
                            "Ingrese el número de la opción deseada:"));
            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    mostrarInfoTotal();
                    break;
                case 3:
                    mostrarInfoPersona();
                    break;
                case 4:
                    modificarParametros();
                    break;
                case 5:
                    eliminarPersona();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 6);
    }

    public static void agregarPersona() {
        String tipoPersona = JOptionPane.showInputDialog("Ingrese el tipo de persona (R para Rider, A para Alumno, cualquier otra letra para Miembro Básico):").toUpperCase();
        ClvtMiembros miembro;
        switch (tipoPersona) {
            case "R":
            	miembro = new Riders();
               ((Riders) miembro).pedirInformacion();
                break;
            case "A":
            	miembro = new Alumno();
                ((Alumno) miembro).pedirInformacion();
                break;
            default:
            	miembro = new ClvtMiembros();
            	miembro.pedirInformacion();
                break;
        }
        personas.put(miembro.getNombre(), miembro);
        JOptionPane.showMessageDialog(null, "Persona agregada exitosamente a la base de datos.");
    }

    public static void mostrarInfoTotal() {
        StringBuilder infoTotal = new StringBuilder();
        for (ClvtMiembros persona : personas.values()) {
            infoTotal.append(persona.toString()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, "Información total de personas en la base de datos:\n\n" + infoTotal);
    }

    public static void mostrarInfoPersona() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona:");
        ClvtMiembros persona = personas.get(nombre);
        if (persona != null) {
            JOptionPane.showMessageDialog(null, "Información de la persona:\n\n" + persona.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Persona no encontrada en la base de datos.");
        }
    }

    public static void modificarParametros() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona a modificar:");
        ClvtMiembros persona = personas.get(nombre);
        if (persona != null) {
            persona.pedirInformacion();
            JOptionPane.showMessageDialog(null, "Parámetros modificados exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Persona no encontrada en la base de datos.");
        }
    }

    public static void eliminarPersona() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona a eliminar:");
        if (personas.containsKey(nombre)) {
            personas.remove(nombre);
            JOptionPane.showMessageDialog(null, "Persona eliminada de la base de datos.");
        } else {
            JOptionPane.showMessageDialog(null, "Persona no encontrada en la base de datos.");
        }
    }

    public void pedirInformacion() {
        setNombre(JOptionPane.showInputDialog("Ingrese el nombre:"));
        setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:")));
        setDNI(JOptionPane.showInputDialog("Ingrese el DNI:"));
        String sexoInput;
        do {
            sexoInput = JOptionPane.showInputDialog("Ingrese el sexo (H para hombre, M para mujer):");
            sexoInput = sexoInput.toUpperCase();
        } while (!sexoInput.equals("H") && !sexoInput.equals("M"));
        setSexo(sexoInput.charAt(0));
        setPeso(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso:")));
        setAltura(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura en metros:")));
        setCamiseta(JOptionPane.showInputDialog("Ingrese el tipo de camiseta:"));
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + DNI + "\nSexo: " + sexo +
                "\nPeso: " + peso + "\nAltura: " + altura + "\nTipo de camiseta: " + camiseta;
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
}

class Riders extends ClvtMiembros {
    private String sueldo;
    private double bonoTransporte;
    private boolean bonoMerchandising;
    private int bonoFirma;
    private boolean bonoGira;

    public void pedirInformacion() {
        super.pedirInformacion();
        setSueldo(JOptionPane.showInputDialog("Ingrese el sueldo:"));
        setBonoTransporte(Double.parseDouble(JOptionPane.showInputDialog("¿Tiene bono de transporte? (true/false):")));
        setBonoMerchandising(Boolean.parseBoolean(JOptionPane.showInputDialog("¿Tiene bono de merchandising? (true/false):")));
        setBonoFirma(Integer.parseInt(JOptionPane.showInputDialog("¿Tiene bono de firma? (true/false):")));
        setBonoGira(Boolean.parseBoolean(JOptionPane.showInputDialog("¿Tiene bono de gira? (true/false):")));
    }
    public Riders() {
    	super();
    }
    
    // Getters y setters para los atributos adicionales
    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public double getBonoTransporte() {
        return bonoTransporte;
    }

    public void setBonoTransporte(double b) {
        this.bonoTransporte = b;
    }

    public boolean getBonoMerchandising() {
        return bonoMerchandising;
    }

    public void setBonoMerchandising(boolean bonoMerchandising) {
        this.bonoMerchandising = bonoMerchandising;
    }

    public int getBonoFirma() {
        return bonoFirma;
    }

    public void setBonoFirma(int bonoFirma) {
        this.bonoFirma = bonoFirma;
    }

    public boolean getBonoGira() {
        return bonoGira;
    }

    public void setBonoGira(boolean bonoGira) {
        this.bonoGira = bonoGira;
    }
}

class Alumno extends ClvtMiembros {
    // Atributos adicionales para Alumno
	private String tarifa;
    private int numClases;
    private boolean esRider;
    
    public void pedirInformacion() {
        super.pedirInformacion();
        // Añadir aquí solicitudes de información específicas para alumnos, si es necesario.
    }
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

    public static void main(String[] args) {
        ClvtMiembros programa = new ClvtMiembros();
        programa.accederMenuPrincipal();
    }
}