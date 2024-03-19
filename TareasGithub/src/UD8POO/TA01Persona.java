package UD8POO;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    private List<TA01Persona> personas;

    public BaseDeDatos() {
        this.personas = new ArrayList<>();
    }

    public void agregarPersona(TA01Persona persona) {
        personas.add(persona);
    }

    public void mostrarInfoTotal() {
        StringBuilder infoTotal = new StringBuilder();
        for (TA01Persona persona : personas) {
            infoTotal.append(persona.toString()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, "Información total de personas en la base de datos:\n\n" + infoTotal);
    }

    public TA01Persona buscarPersona(String nombre) {
        for (TA01Persona persona : personas) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }
        return null;
    }

    public void modificarParametros(String nombre) {
        TA01Persona persona = buscarPersona(nombre);
        if (persona != null) {
            persona.pedirInformacion();
            JOptionPane.showMessageDialog(null, "Parámetros modificados exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Persona no encontrada en la base de datos.");
        }
    }

    public static void main(String[] args) {
        BaseDeDatos baseDeDatos = new BaseDeDatos();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menú:\n" +
                            "1. Agregar nueva persona\n" +
                            "2. Ver información total de personas\n" +
                            "3. Ver información de una persona específica\n" +
                            "4. Modificar parámetros de una persona\n" +
                            "5. Salir\n" +
                            "Ingrese el número de la opción deseada:"));
            switch (opcion) {
                case 1:
                    agregarPersona(baseDeDatos);
                    break;
                case 2:
                    baseDeDatos.mostrarInfoTotal();
                    break;
                case 3:
                    mostrarInfoPersona(baseDeDatos);
                    break;
                case 4:
                    modificarParametros(baseDeDatos);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);
    }

    public static void agregarPersona(BaseDeDatos baseDeDatos) {
        int opcionTipoPersona = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione el tipo de persona:\n" +
                        "1. Persona\n" +
                        "2. Rider\n" +
                        "3. Alumno"));
        switch (opcionTipoPersona) {
            case 1:
                baseDeDatos.agregarPersona(new TA01Persona());
                JOptionPane.showMessageDialog(null, "Persona agregada exitosamente a la base de datos.");
                break;
            case 2:
                baseDeDatos.agregarPersona(new Rider());
                JOptionPane.showMessageDialog(null, "Rider agregado exitosamente a la base de datos.");
                break;
            case 3:
                baseDeDatos.agregarPersona(new Alumno());
                JOptionPane.showMessageDialog(null, "Alumno agregado exitosamente a la base de datos.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
                break;
        }
    }

    public static void mostrarInfoPersona(BaseDeDatos baseDeDatos) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona:");
        TA01Persona persona = baseDeDatos.buscarPersona(nombre);
        if (persona != null) {
            JOptionPane.showMessageDialog(null, "Información de la persona:\n\n" + persona.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Persona no encontrada en la base de datos.");
        }
    }

    public static void modificarParametros(BaseDeDatos baseDeDatos) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona a modificar:");
        baseDeDatos.modificarParametros(nombre);
    }
}
