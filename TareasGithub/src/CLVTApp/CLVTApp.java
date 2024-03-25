package CLVTApp;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class CLVTApp {
    private static final String PASSWORD = "CLVT22";
    private static final int MAX_INTENTOS = 3;
    private static int intentos = 0;
    private static Map<String, MiembroBase> personas = new HashMap<>();

    public static void main(String[] args) {
        while (!autenticar()) {
            intentos++;
            if (intentos >= MAX_INTENTOS) {
                JOptionPane.showMessageDialog(null, "Has excedido el número máximo de intentos.");
                return;
            }
        }
        mostrarMenuPrincipal();
    }

    private static boolean autenticar() {
        String input = JOptionPane.showInputDialog("Introduce la contraseña:");
        return input != null && input.equals(PASSWORD);
    }

    public static void mostrarMenuPrincipal() {
    	int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "~~~BIENVENID@ AL MODO ADMIN~~~\n\n" +
                            "1. Añadir miembro\n" +
                            "2. Mostrar información de todos los miembros\n" +
                            "3. Mostrar información de un miembro\n" +
                            "4. Actualizar información de un miembro\n" +
                            "5. Eliminar miembro\n" +
                            "6. Salir"
            ));

            switch (opcion) {
                case 1:
                    añadirMiembro();
                    break;
                case 2:
                    mostrarInfoTotal();
                    break;
                case 3:
                    mostrarInfoPersona();
                    break;
                case 4:
                    actualizarMiembro();
                    break;
                case 5:
                    eliminarMiembro();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, selecciona una opción válida.");
            }
        } while (opcion != 6);
    }

    public static void añadirMiembro() {
        int tipoMiembro = Integer.parseInt(JOptionPane.showInputDialog(
                "Selecciona el tipo de miembro a añadir:\n" +
                        "1. Rider\n" +
                        "2. Alumno\n" +
                        "3. Entidad Colaboradora"
        ));

        switch (tipoMiembro) {
            case 1:
                Riders rider = new Riders();
                rider.pedirInformacion();
                personas.put(rider.getNombre(), rider);
                break;
            case 2:
                Alumnos alumno = new Alumnos();
                alumno.pedirInformacion();
                personas.put(alumno.getNombre(), alumno);
                break;
            case 3:
                EntidadesColaboradoras entidad = new EntidadesColaboradoras();
                entidad.pedirInformacion();
                personas.put(entidad.getNombre(), entidad);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de miembro no válido. Por favor, selecciona un tipo válido.");
        }
    }

    public static void mostrarInfoTotal() {
        StringBuilder infoTotal = new StringBuilder();
        for (Map.Entry<String, MiembroBase> entry : personas.entrySet()) {
            MiembroBase miembro = entry.getValue();
            if (miembro != null) {
                infoTotal.append("Nombre: ").append(miembro.getNombre()).append("\n");
                if (miembro instanceof Riders) {
                    infoTotal.append("Tipo de Miembro: Rider\n\n");
                } else if (miembro instanceof Alumnos) {
                    infoTotal.append("Tipo de Miembro: Alumno\n\n");
                } else if (miembro instanceof EntidadesColaboradoras) {
                    infoTotal.append("Tipo de Miembro: Entidad colaboradora\n\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, infoTotal.toString());
    }

    public static void mostrarInfoPersona() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del miembro:");
        MiembroBase persona = personas.get(nombre);
        StringBuilder infoPersona = new StringBuilder();

        if (persona != null) {
            infoPersona.append("~~~MIEMBROS CLVT~~~\n\n");
            infoPersona.append("Nombre: ").append(persona.getNombre()).append("\n");
            infoPersona.append("Población: ").append(persona.getPoblacion()).append("\n");
            if (persona instanceof Riders) {
                infoPersona.append("Tipo de Miembro: Rider\n\n");
                infoPersona.append("Funciones: ").append(((Riders) persona).getFunciones()).append("\n");
                infoPersona.append("Sueldo: ").append(((Riders) persona).getSueldo()).append("\n");
                infoPersona.append("Bono transporte: ").append(((Riders) persona).getBonoTransporte()).append("\n");
                infoPersona.append("Bono Merchandising: ").append(((Riders) persona).getBonoMerchandising()).append("\n");
                infoPersona.append("Bono Firma: ").append(((Riders) persona).getBonoFirma()).append("\n");
                infoPersona.append("Bono Gira: ").append(((Riders) persona).getBonoGira()).append("\n");
            } else if (persona instanceof Alumnos) {
                infoPersona.append("Tipo de Miembro: Alumno\n\n");
                infoPersona.append("Tarifa: ").append(((Alumnos) persona).getTarifa()).append("\n");
                infoPersona.append("Número de clases: ").append(((Alumnos) persona).getNumClases()).append("\n");
                infoPersona.append("¿Es Rider? ").append(((Alumnos) persona).getEsRider()).append("\n");
                infoPersona.append("Aportación: ").append(((Alumnos) persona).getAportacion()).append("\n");
                infoPersona.append("Servicios que disfruta: ").append(((Alumnos) persona).getServDisfrutados()).append("\n");
            } else if (persona instanceof EntidadesColaboradoras) {
                infoPersona.append("Tipo de Miembro: Entidad colaboradora\n\n");
                infoPersona.append("NIF de la entidad: ").append(((EntidadesColaboradoras) persona).getNIF()).append("\n");
                infoPersona.append("Proyecto en colaboración: ").append(((EntidadesColaboradoras) persona).getProyecto()).append("\n");
                infoPersona.append("Año de colaboración: ").append(((EntidadesColaboradoras) persona).getAñoColabora()).append("\n");
            }

            JOptionPane.showMessageDialog(null, infoPersona.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Persona no encontrada en la base de datos.");
        }
    }

    private static void actualizarMiembro() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del miembro a actualizar:");
        MiembroBase miembro = personas.get(nombre);

        if (miembro != null) {
            if (miembro instanceof Riders) {
                Riders rider = (Riders) miembro;
                rider.pedirInformacion();
                JOptionPane.showMessageDialog(null, "Rider actualizado correctamente.");
            } else if (miembro instanceof Alumnos) {
                Alumnos alumno = (Alumnos) miembro;
                alumno.pedirInformacion();
                JOptionPane.showMessageDialog(null, "Alumno actualizado correctamente.");
            } else if (miembro instanceof EntidadesColaboradoras) {
                EntidadesColaboradoras entidad = (EntidadesColaboradoras) miembro;
                entidad.pedirInformacion();
                JOptionPane.showMessageDialog(null, "Entidad colaboradora actualizada correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Miembro no encontrado en la base de datos.");
        }
    }

    public static void eliminarMiembro() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del miembro a eliminar:");
        MiembroBase persona = personas.remove(nombre);
        if (persona != null) {
            JOptionPane.showMessageDialog(null, "Miembro eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Persona no encontrada en la base de datos.");
        }
    }
}

