package CLVTApp;
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
    protected static final String ADMIN_PASSWORD = "CLVT22";

    public static void main(String[] args) {
        ClvtMiembros programa = new ClvtMiembros();
        programa.accederMenuPrincipal();
    }

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
                            "1. Agregar nuevo miembro\n" +
                            "2. Ver total de miembros\n" +
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
        String tipoMiembros = JOptionPane.showInputDialog("Ingrese el tipo de persona (R para Rider, A para Alumno, EC para Entidad Colaboradora):").toUpperCase();
        ClvtMiembros miembro;
        switch (tipoMiembros) {
            case "R":
                miembro = new Riders();
                ((Riders) miembro).pedirInformacion();
                break;
            case "A":
                miembro = new Alumno();
                ((Alumno) miembro).pedirInformacion();
                break;
            case "EC":
                miembro = new EntidadesColaboradoras();
                ((EntidadesColaboradoras) miembro).pedirInformacion();
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
        String[] opciones = {"Todos los miembros", "Riders", "Alumnos", "Entidades colaboradoras"};
        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
                "Opciones de visualización", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        StringBuilder infoTotal = new StringBuilder();
        switch (seleccion) {
            case "Todos los miembros":
                for (ClvtMiembros miembro : personas.values()) {
                    infoTotal.append(miembro.toString()).append("\n\n");
                }
                break;
            case "Riders":
                for (ClvtMiembros miembro : personas.values()) {
                    if (miembro instanceof Riders) {
                        infoTotal.append(miembro.toString()).append("\n\n");
                    }
                }
                break;
            case "Alumnos":
                for (ClvtMiembros miembro : personas.values()) {
                    if (miembro instanceof Alumno) {
                        infoTotal.append(miembro.toString()).append("\n\n");
                    }
                }
                break;
            case "Entidades colaboradoras":
                for (ClvtMiembros miembro : personas.values()) {
                    if (!(miembro instanceof Riders) && !(miembro instanceof Alumno)) {
                        infoTotal.append(miembro.toString()).append("\n\n");
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                return;
        }
        JOptionPane.showMessageDialog(null, infoTotal.toString(), "Información de miembros", JOptionPane.PLAIN_MESSAGE);
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

    	 StringBuilder infoCompleta = new StringBuilder();
         infoCompleta.append("Nombre: ").append(nombre).append("\n");
         infoCompleta.append("Edad: ").append(edad).append("\n");
         infoCompleta.append("DNI: ").append(DNI).append("\n");
         infoCompleta.append("Sexo: ").append(sexo).append("\n");
         infoCompleta.append("Peso: ").append(peso).append("\n");
         infoCompleta.append("Altura: ").append(altura).append("\n");
         infoCompleta.append("Tipo de camiseta: ").append(camiseta).append("\n");

         // Verificar si el miembro es un Rider
         if (this instanceof Riders) {
             Riders rider = (Riders) this;
             infoCompleta.append("Funciones de Rider: ").append(rider.getFunciones()).append("\n");
             infoCompleta.append("Sueldo: ").append(rider.getSueldo()).append("\n");
             infoCompleta.append("Bono Transporte: ").append(rider.getBonoTransporte()).append("\n");
             infoCompleta.append("Bono Merchandising: ").append(rider.getBonoMerchandising()).append("\n");
             infoCompleta.append("Bono Firma: ").append(rider.getBonoFirma()).append("\n");
             infoCompleta.append("Bono Gira: ").append(rider.getBonoGira()).append("\n");
         }

         // Verificar si el miembro es un Alumno
         if (this instanceof Alumno) {
             Alumno alumno = (Alumno) this;
             infoCompleta.append("Tarifa: ").append(alumno.getTarifa()).append("\n");
             infoCompleta.append("Número de Clases: ").append(alumno.getNumClases()).append("\n");
             infoCompleta.append("Es Rider: ").append(alumno.isEsRider()).append("\n");
             infoCompleta.append("Aportación: ").append(alumno.getAportacion()).append("\n");
         }

         // Verificar si el miembro es una Entidad Colaboradora
         if (this instanceof EntidadesColaboradoras) {
             EntidadesColaboradoras entidad = (EntidadesColaboradoras) this;
             infoCompleta.append("Proyecto: ").append(entidad.getProyecto()).append("\n");
             infoCompleta.append("Año de Colaboración: ").append(entidad.getAñoColabora()).append("\n");
         }
         return infoCompleta.toString();
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
