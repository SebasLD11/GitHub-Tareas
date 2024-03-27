package CLVTApp;
import javax.swing.JOptionPane;

public class Servicios {
    private String nombre;
    private String descripcion;
    private double precio;
    private String claseServicios;
	private String[] OpcionesCampus;
	

    public Servicios(String nombre, String descripcion, double precio, String claseServicios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.claseServicios = claseServicios;
    }

    public Servicios() {
		this.nombre = "";
		this.descripcion = "";
		this.precio = 0.0;
		this.claseServicios = "";
	}

	public Servicios(String nombre2, String descripcion2, double precio2, String[] strings) {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getClaseServicios() {
        return claseServicios;
    }

    public void contratarServicios(MiembroBase cliente) {    	
    	    String tipoCliente = "";
    	    if (cliente instanceof MiembroBase) {
    	        tipoCliente = "Miembro Base";
    	    } else if (cliente instanceof Riders) {
    	        tipoCliente = "Rider";
    	    } else if (cliente instanceof Alumnos) {
    	        tipoCliente = "Alumno";
    	    } else if (cliente instanceof EntidadesColaboradoras) {
    	        tipoCliente = "Entidad Colaboradora";
    	    } else {
    	        tipoCliente = "Cliente Externo (No Miembro)";
    	    }

    	    JOptionPane.showMessageDialog(null, "Contratando servicio como: " + tipoCliente);

    	String nombreCliente = JOptionPane.showInputDialog("Ingrese su nombre:");
        String dniCliente = JOptionPane.showInputDialog("Ingrese su DNI:");
        String poblacionCliente = JOptionPane.showInputDialog("Ingrese su población:");
        String edadClienteStr = JOptionPane.showInputDialog("Ingrese su edad:");
        int edadCliente = Integer.parseInt(edadClienteStr);
        String correoElectronicoCliente = JOptionPane.showInputDialog("Ingrese su correo electrónico:");
        
        double precioFinal = precio;
        // Verificar el tipo de cliente y aplicar descuento si corresponde
        if (cliente instanceof MiembroBase || cliente instanceof Riders || cliente instanceof Alumnos || cliente instanceof EntidadesColaboradoras) {
            // Aplicar descuento del 30%
            precioFinal *= 0.7;
        }

        // Aquí puedes procesar la información del cliente y realizar otras operaciones
        JOptionPane.showMessageDialog(null, "Servicios contratado con éxito:\n" +
                "Nombre: " + nombreCliente + "\n" +
                "DNI: " + dniCliente + "\n" +
                "Población: " + poblacionCliente + "\n" +
                "Edad: " + edadCliente + "\n" +
                "Correo electrónico: " + correoElectronicoCliente + "\n" +
                "Nombre del Servicios: " + nombre + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Precio: " + precioFinal + "\n" +
                "Clase de Servicios: " + claseServicios);
    }

    public void pedirInformacion() {
    	 this.nombre = JOptionPane.showInputDialog("Nombre:");
    	 this.descripcion = JOptionPane.showInputDialog("Descripción:");
    	 this.precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
             
        // Opciones para seleccionar la info especial de Riders
        Object[] opcionesclasesServicio = {"Taller básico", "Programa STAIRS", "Clases particulares", "Campus Workout", "Alquiler material"};
        int opcionclaseServicios = JOptionPane.showOptionDialog(null, "¿Que sueldo recibe?",
                "Clase de Servicio", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opcionesclasesServicio, opcionesclasesServicio[0]);
        this.claseServicios = opcionesclasesServicio[opcionclaseServicios].toString();
        
}

    public static void mostrarServicios() {
        // Definir los servicios
        Servicios[] servicios = {
                new Servicios("Talleres básicos", "Descripción del taller básico", 0.0, new String[]{"Completo", "Reducido", "Completo+4H", "Reducido+2H"}),
                new Servicios("Clases particulares", "Descripción de las clases particulares", 0.0, new String[]{"Rider: Sebastián López", "Rider: Daniel Carrillo"}),
                new Servicios("Programa 'STAIRS'", "Descripción del programa STAIRS", 0.0, new String[]{"Bono día", "Bono Mensual", "Bono Trimestral", "Bono Anual"}),
                new Servicios("Campus Workout", "Descripción del Campus Workout", 0.0, new String[]{"Entreno Personal", "Entreno dirigido", "Tecnificación skate/scooter", "Casal lúdico/recreativo", "Todos los servicios"})
        };

        // Construir el mensaje con la información de los servicios
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("SERVICIOS DISPONIBLES:\n");
        for (int i = 0; i < servicios.length; i++) {
            mensaje.append(i + 1).append(". ").append(servicios[i].getNombre()).append("\n");
            mensaje.append("   Descripción: ").append(servicios[i].getDescripcion()).append("\n");
            mensaje.append("   Precio: ").append(servicios[i].getPrecio()).append("€\n");

            String[] opciones = ((servicios[i]).getOpcionesServicios());
        if (opciones != null && opciones.length > 0) {
                mensaje.append("   Opciones: ").append(String.join(", ", opciones)).append("\n");
            }

            mensaje.append("\n");
        }

        // Mostrar el mensaje
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Servicios Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }

	public String[] getOpcionesServicios() {
		return OpcionesCampus;
	}
	public void setOpcionesCampus(String[] opcionesCampus) {
		OpcionesCampus = opcionesCampus;
	}
}



