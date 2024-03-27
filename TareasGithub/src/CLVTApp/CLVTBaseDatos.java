package CLVTApp;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class CLVTBaseDatos {

    private static final String CONTRASENA = "CLVT22";
    private static final int MAX_INTENTOS = 3;
    private static int intentosRestantes = MAX_INTENTOS;
    protected static final Map<String, MiembroBase> personas = new HashMap<>();

    public static void main(String[] args) {
        iniciarSesion();
    }

    public static void iniciarSesion() {
        String contrasenaIngresada = "";
        while (!contrasenaIngresada.equals(CONTRASENA) && intentosRestantes > 0) {
            contrasenaIngresada = JOptionPane.showInputDialog("Ingrese la contraseña:");
            if (!contrasenaIngresada.equals(CONTRASENA)) {
                intentosRestantes--;
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Intentos restantes: " + intentosRestantes);
            }
        }
        if (contrasenaIngresada.equals(CONTRASENA)) {
            mostrarMenuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Has agotado el número de intentos. Saliendo de la aplicación.");
        }
    }

    public static void mostrarMenuPrincipal() {
        String[] opcionesMenu = {"Agregar miembro", "Actualizar miembro", "Eliminar miembro", "Mostrar información total", "Mostrar información de un miembro", "Salir"};
        while (true) {
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
                    "Menú Principal", JOptionPane.PLAIN_MESSAGE, null, opcionesMenu, opcionesMenu[0]);
            if (opcionSeleccionada == null || opcionSeleccionada.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo de la aplicación.");
                break;
            }
            switch (opcionSeleccionada) {
                case "Agregar miembro":
                    agregarMiembro();
                    break;
                case "Actualizar miembro":
                    actualizarMiembro();
                    break;
                case "Eliminar miembro":
                    eliminarMiembro();
                    break;
                case "Mostrar información total":
                    mostrarInfoTotal();
                    break;
                case "Mostrar información de un miembro":
                    mostrarInfoMiembro();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    public static void agregarMiembro() {
        String[] tiposMiembro = {"Rider", "Alumno", "Entidad Colaboradora", "Miembro Base"};
        String tipoMiembro = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de miembro a agregar:",
                "Agregar Miembro", JOptionPane.PLAIN_MESSAGE, null, tiposMiembro, tiposMiembro[0]);
        switch (tipoMiembro) {
            case "Rider":
                agregarRider();
                break;
            case "Alumno":
                agregarAlumno();
                break;
            case "Entidad Colaboradora":
                agregarEntidadColaboradora();
                break;
            case "Miembro Base":
                agregarMiembroBase();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de miembro no válido.");
        }
    }

	public static void agregarRider() {
		    Riders nuevoRider = new Riders();
		    nuevoRider.pedirInformacion();
		    String nombre = nuevoRider.getNombre();
		    if (!personas.containsKey(nombre)) {
		        personas.put(nombre, nuevoRider);
		        JOptionPane.showMessageDialog(null, "Rider agregado correctamente.");
		    } else {
		        JOptionPane.showMessageDialog(null, "Ya existe un miembro con ese nombre.");
		    }
		}
	
	public static void agregarAlumno() {
	    Alumnos nuevoAlumno = new Alumnos();
	    nuevoAlumno.pedirInformacion();
	    String nombre = nuevoAlumno.getNombre();
	    if (!personas.containsKey(nombre)) {
	        personas.put(nombre, nuevoAlumno);
	        JOptionPane.showMessageDialog(null, "Alumno agregado correctamente.");
	    } else {
	        JOptionPane.showMessageDialog(null, "Ya existe un miembro con ese nombre.");
	    }
	}
	
	public static void agregarEntidadColaboradora() {
	    EntidadesColaboradoras nuevaEntidad = new EntidadesColaboradoras();
	    nuevaEntidad.pedirInformacion();
	    String nombre = nuevaEntidad.getNombre();
	    if (!personas.containsKey(nombre)) {
	        personas.put(nombre, nuevaEntidad);
	        JOptionPane.showMessageDialog(null, "Entidad Colaboradora agregada correctamente.");
	    } else {
	        JOptionPane.showMessageDialog(null, "Ya existe un miembro con ese nombre.");
	    }
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
                }  else if (miembro instanceof MiembroBase) {
                        infoTotal.append("Tipo de Miembro: Miembro Base\n\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, infoTotal.toString());
    }
    
    private static void mostrarInfoMiembro() {
        String[] tiposMiembro = {"Rider", "Alumno", "Entidad Colaboradora", "Miembro Base"};
        String tipoMiembro = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de miembro:",
                "Mostrar Información de Miembro", JOptionPane.QUESTION_MESSAGE, null, tiposMiembro, tiposMiembro[0]);

        if (tipoMiembro != null) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del miembro:");
            MiembroBase miembro = personas.get(nombre);

            if (miembro != null) {
                StringBuilder infoMiembro = new StringBuilder();
                infoMiembro.append("~~~INFORMACIÓN DEL MIEMBRO~~~\n\n");
                infoMiembro.append("Nombre: ").append(miembro.getNombre()).append("\n");
                infoMiembro.append("Población: ").append(miembro.getPoblacion()).append("\n");
                infoMiembro.append("Edad: ").append(miembro.getEdad()).append("\n");
                infoMiembro.append("DNI: ").append(miembro.getDNI()).append("\n");
                infoMiembro.append("Sexo: ").append(miembro.getSexo()).append("\n");

                switch (tipoMiembro) {
                    case "Rider":
                        if (miembro instanceof Riders) {
                            Riders rider = (Riders) miembro;
                            infoMiembro.append("Tipo de Miembro: Rider\n");
                            infoMiembro.append("Funciones: ").append(rider.getFunciones()).append("\n");
                            infoMiembro.append("Sueldo: ").append(rider.getSueldo()).append("\n");
                            infoMiembro.append("Bono de Transporte: ").append(rider.getBonoTransporte()).append("\n");
                            infoMiembro.append("Bono de Merchandising: ").append(rider.getBonoMerchandising()).append("\n");
                            infoMiembro.append("Bono de Firma: ").append(rider.getBonoFirma()).append("\n");
                            infoMiembro.append("Bono de Gira: ").append(rider.getBonoGira()).append("\n");
                        }
                        break;
                    case "Alumno":
                        if (miembro instanceof Alumnos) {
                            Alumnos alumno = (Alumnos) miembro;
                            infoMiembro.append("Tipo de Miembro: Alumno\n");
                            infoMiembro.append("Tarifa: ").append(alumno.getTarifa()).append("\n");
                            infoMiembro.append("Número de Clases: ").append(alumno.getNumClases()).append("\n");
                            infoMiembro.append("Es Rider: ").append(alumno.getEsRider()).append("\n");
                            infoMiembro.append("Aportación: ").append(alumno.getAportacion()).append("\n");
                            infoMiembro.append("Servicios Disfrutados: ").append(alumno.getServDisfrutados()).append("\n");
                        }
                        break;
                    case "Entidad Colaboradora":
                        if (miembro instanceof EntidadesColaboradoras) {
                            EntidadesColaboradoras entidad = (EntidadesColaboradoras) miembro;
                            infoMiembro.append("Tipo de Miembro: Entidad Colaboradora\n");
                            infoMiembro.append("Proyecto en Colaboración: ").append(entidad.getProyecto()).append("\n");
                            infoMiembro.append("Año de Colaboración: ").append(entidad.getAñoColabora()).append("\n");
                        }
                        break;
                    case "Miembro Base":
                        if (miembro instanceof MiembroBase) {
                            // Aquí agregamos la información específica de MiembroBase
                            infoMiembro.append("Este miembro es de la clase MiembroBase").append("\n");
                            // Agregamos la información común a todas las clases
                            infoMiembro.append("Edad: ").append(((MiembroBase) miembro).getEdad()).append("\n");
                            infoMiembro.append("DNI: ").append(((MiembroBase) miembro).getDNI()).append("\n");
                            infoMiembro.append("Sexo: ").append(((MiembroBase) miembro).getSexo()).append("\n");
                            infoMiembro.append("Altura: ").append(((MiembroBase) miembro).getAltura()).append("\n");
                            infoMiembro.append("Peso: ").append(((MiembroBase) miembro).getPeso()).append("\n");
                            infoMiembro.append("Talla de camiseta: ").append(((MiembroBase) miembro).getCamiseta()).append("\n");
                        }
                        break;
                }
                JOptionPane.showMessageDialog(null, infoMiembro.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Miembro no encontrado en la base de datos.");
            }
        }
    }

    private static void actualizarMiembro() {
        String[] tiposMiembro = {"Rider", "Alumno", "Entidad Colaboradora"};
        String tipoMiembro = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de miembro a actualizar:",
                "Actualizar Miembro", JOptionPane.QUESTION_MESSAGE, null, tiposMiembro, tiposMiembro[0]);

        if (tipoMiembro != null) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del miembro a actualizar:");
            MiembroBase miembro = personas.get(nombre);

            if (miembro != null) {
                switch (tipoMiembro) {
                    case "Rider":
                        if (miembro instanceof Riders) {
                            Riders rider = (Riders) miembro;
                            rider.pedirInformacion();
                            JOptionPane.showMessageDialog(null, "Rider actualizado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "El miembro no es un Rider.");
                        }
                        break;
                    case "Alumno":
                        if (miembro instanceof Alumnos) {
                            Alumnos alumno = (Alumnos) miembro;
                            alumno.pedirInformacion();
                            JOptionPane.showMessageDialog(null, "Alumno actualizado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "El miembro no es un Alumno.");
                        }
                        break;
                    case "Entidad Colaboradora":
                        if (miembro instanceof EntidadesColaboradoras) {
                            EntidadesColaboradoras entidad = (EntidadesColaboradoras) miembro;
                            entidad.pedirInformacion();
                            JOptionPane.showMessageDialog(null, "Entidad colaboradora actualizada correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "El miembro no es una Entidad Colaboradora.");
                        }
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Miembro no encontrado en la base de datos.");
            }
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