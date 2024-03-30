package CLVTApp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Servicios extends MenuControlador {
    private static String nombre;
    private String descripcion;
    private double precio;
    private String claseServicios;
    private static List<String> serviciosContratados;
    
    // Constructor con atributos predeterminados
    public Servicios() {
        this.setNombre("");
        this.setDescripcion("");
        this.setPrecio(0.0); 
        this.setClaseServicios("");
        serviciosContratados = new ArrayList<>();
    }

    // Constructor con parámetros
    public Servicios(String nombre, String descripcion, double precio, String claseServicios) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
        this.setClaseServicios(claseServicios);
    }

    // Método para mostrar las opciones de servicio
    public static void mostrarOpcionesServicio() {
        // Mostrar las opciones de servicio usando un bucle switch
        StringBuilder opciones = new StringBuilder("Opciones de Servicio:\n");
        opciones.append("1. Taller básico (25€ - Reducido, 35€ - Completo, 50€ - Reducido + 2h particulares, 80€ - Completo + 4h particulares)\n");
        opciones.append("2. Programa STAIRS (MENSUAL: 120€/mes, TRIMESTRAL: 345€/trimestre, SEMESTRAL: 630€/semestre, ANUAL: 1140€/año)\n");
        opciones.append("3. Clases particulares (Daniel Carrillo - 20€/h, Sebastián López - 35€/h)\n");
        opciones.append("4. Campus Workout (Individual 2h: 40€, Parcial 3 días 4h/día: 110€, Completo 5 días: 180€)\n");
        opciones.append("5. Alquiler de material (Skate - 5€/h, Scooter - 7€/h)\n");
        opciones.append("6. Salidas Individuales (Asociad@s y externos - 20€, Riders/Alumn@s - 10€)\n");

        JOptionPane.showMessageDialog(null, opciones.toString(), "Opciones de Servicio", JOptionPane.INFORMATION_MESSAGE);

        // Pedir al usuario que elija una opción
        int opcionElegida = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción:"));
        switch (opcionElegida) {
            case 1: 
                mostrarOpcionesTallerBasico();
                break;
            case 2:
                mostrarOpcionesProgramaSTAIRS();
                break;
            case 3:
                mostrarOpcionesClasesParticulares();
                break;
            case 4:
                mostrarOpcionesCampusWorkout();
                break;
            case 5:
                mostrarOpcionesAlquilerMaterial();
                break;
            case 6:
                mostrarOpcionesSalidas();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    
    // Método para mostrar las opciones
    
    private static void mostrarOpcionesTallerBasico() {
    	StringBuilder opciones = new StringBuilder("Opciones de Taller Básico: taller de entrenamiento grupal\n"
    			+ "de skate y scooter. Conocimientos básicos: equilibrio, posicionamiento, fluidez. Horario de tarde,\n"
    			+ "de 16:30h a 18:30h.\n");
    	
   	 opciones.append("1. Reducido - 25€. 4 días/mes en fin de semana, 2h/día.\n");
   	 opciones.append("2. Completo - 35€. 8 días/mes en fin de semana, 2h/día.\n");
   	 opciones.append("3. Reducido + 2hparticulares/mes - 50€. 4 días/mes en fin de semana, 2h/día.\n");
   	 opciones.append("4. Completo + 4hparticulares/mes - 80€. 8 días/mes en fin de semana, 2h/día.\n");
 
   	 int opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(opciones.toString() + "\nSeleccione una opción:"));
     double precio = 0.0;

     switch (opcionElegida) {
        case 1:
        	precio = 25.0;
        	break;
        case 2:
        	precio = 35.0;
            break;
        case 3:
        	precio = 50.0;
            break;
        case 4:
        	precio = 80.0;
            break;
        default:
            break;
    }
    contratarServicio("Taller Básico", precio);
}


    private static void mostrarOpcionesCampusWorkout() {
    	StringBuilder opciones = new StringBuilder("Opciones de Campus: 4 horas de servicios variados, en  los\n"
    			+ "que encontramos: entrenamiento personal, entrenamiento dirigido, tecnificación de skate/scooter y\n"
    			+ "casal ludico-recreativo. Donde tanto niñ@s como adultos tendrán la opción de escoger solo 2h de un servicio\n"
    			+ "o bien, disfrutar las 4 horas de campus de forma parcial (3 días) o completa (5 días).\n");
    	
    	 opciones.append("1. Servicio individual de 2h, 40€\n");
    	 opciones.append("2. Campus parcial de 3 días, 4h/dia, 110€\n");
    	 opciones.append("3. Campus completo de 5 días,  4h/dia, 180€\n");
        
    	 int opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(opciones.toString() + "\nSeleccione una opción:"));
         double precio = 0.0;

        switch (opcionElegida) {
            case 1:
            	precio = 40.0;
            	break;
            case 2:
            	precio = 110.0;
                break;
            case 3:
            	precio = 180.0;
                break;
            default:
                break;
        }
        contratarServicio("Campus Workout", precio);
    }

    private static void mostrarOpcionesAlquilerMaterial() {
    	StringBuilder opciones = new StringBuilder("Opciones de Alquiler: ¿No tienes skate o scooter? No te preocupes, en nuestra\n"
    			+ "entidad contamos con skate y scooters completos y funcionales con los que disfrutar de cualquier sesión de entrenamiento.\n");
    	
        opciones.append("1. Skate - 5€/2h\n");
        opciones.append("2. Scooter - 7€/2h\n");
        int opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(opciones.toString() + "\nSeleccione una opción:"));
        double precio = 0.0;
        switch (opcionElegida) {
            case 1:
            	precio = 5.0;
                break;
            case 2:
            	precio = 7.0;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        contratarServicio("Alquiler de material", precio);
    }

    private static void mostrarOpcionesProgramaSTAIRS() {
        StringBuilder opciones = new StringBuilder("Opciones de Programa STAIRS: \n"
        		+ "Programa de entrenamiento focalizado y personalizado. Cuenta con: \n"
        		+ "\r\n"
        		+ "- Seguro y registro federativo.\n"
        		+ "- 8 días mensuales de entrenamiento.\n"
        		+ "- 2 horas por día.\n"
        		+ "- Preparación física y técnica.\n"
        		+ "- 9 categorías de entrenamiento.\n"
        		+ "- Salidas, actividades y sesiones especiales.|n"
        		+ "- Eventos y celebraciones.\n"
        		+ "- Merchandising de regalo.\n"
        		+ "- Para particulares y entidades.\n");
        
        opciones.append("1. MENSUAL: 120€/mes\n");
        opciones.append("2. TRIMESTRAL: 345€/trimestre\n");
        opciones.append("3. SEMESTRAL: 630€/semestre\n");
        opciones.append("4. ANUAL: 1140€/año\n");

        int opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(opciones.toString() + "\nSeleccione una opción:"));
        double precio = 0.0;
        switch (opcionElegida) {
            case 1:
            	precio = 120.0;
                break;
            case 2:
            	precio = 345.0;
                break;
            case 3:
            	precio = 630.0;
                break;
            case 4:
            	precio = 1140.0;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        contratarServicio("Programa STAIRS", precio);
    }

    private static void mostrarOpcionesClasesParticulares() {
        StringBuilder opciones = new StringBuilder("Opciones de Clases Particulares: ¿Quieres aprender y no tienes quien te ayude?\n"
        		+ "¿Dispones de escasas horas para aprender a patinar y quieres que alguien te ayude en esos momentos?\n"
        		+ "No esperes más y disfruta de horas particulares, centradas en ti y tus necesidades. Nuestros riders con años\n"
        		+ "de experiencia te ayudaran a completar cualquier parte de tu aprendizaje. \n");
        
        opciones.append("1. Daniel Carrillo (Scooter) - 20€/h\n");
        opciones.append("2. Sebastián López (Skate) - 35€/h\n");

        int opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(opciones.toString() + "\nSeleccione una opción:"));
        double precio = 0.0;
        switch (opcionElegida) {
            case 1:
            	precio = 20.0;
                break;
            case 2:
            	precio = 35.0;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        contratarServicio("Clases Particulares", precio);
    }
    
    private static void mostrarOpcionesSalidas() {
    	StringBuilder opciones = new StringBuilder("Opciones de Salidas particulares:"
    			+ "Salidas privadas organizadas por los riders y miembros de la entidad en las cuales\n"
    			+ "se pretende tener sesiones de entrenamiento especiales en otros lugares de la provincia\n"
    			+ "y cercanias, donde conocemos otros skateparks y personas de la comunidad.\n");
    	
    	opciones.append("1. Riders/Alumn@s - 10€");
    	opciones.append("2. Asociad@s y extern@s - 20€");
    	int opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(opciones.toString() + "\nSeleccione una opción:"));
        double precio = 0.0;
        switch (opcionElegida) {
            case 1:
            	precio = 10.0;
                break;
            case 2:
            	precio = 20.0;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        contratarServicio("Salidas Particulares", precio);
    }

    // Métodos para contratar el servicio seleccionado
 // Métodos para contratar el servicio seleccionado
    private static void contratarServicio(String nombreServicio, double precioServicio) {
        JOptionPane.showMessageDialog( null, "Contratando servicio: " + nombreServicio);

        String nombreCliente = JOptionPane.showInputDialog("Ingrese su nombre:");
        String dniCliente = JOptionPane.showInputDialog("Ingrese su DNI:");
        String poblacionCliente = JOptionPane.showInputDialog("Ingrese su población:");
        String edadClienteStr = JOptionPane.showInputDialog("Ingrese su edad:");
        int edadCliente = Integer.parseInt(edadClienteStr);
        String correoElectronicoCliente = JOptionPane.showInputDialog("Ingrese su correo electrónico:");

        // Aquí puedes procesar la información del cliente y realizar otras operaciones
        JOptionPane.showMessageDialog(null, "Servicio contratado con éxito:\n" +
                "Nombre: " + nombreCliente + "\n" +
                "DNI: " + dniCliente + "\n" +
                "Población: " + poblacionCliente + "\n" +
                "Edad: " + edadCliente + "\n" +
                "Correo electrónico: " + correoElectronicoCliente + "\n" +
                "Nombre del Servicio: " + nombreServicio + "\n" +
                "Precio: " + precioServicio+"€");
        JOptionPane.showMessageDialog(null, "¡Gracias por contratar nuestro servicio! En un plazo máximo de 48h contactaremos contigo.");
    }

//getters y setters
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	Servicios.nombre = nombre;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

public String getClaseServicios() {
	return claseServicios;
}

public void setClaseServicios(String opciones) {
	this.claseServicios = opciones;
}

public static List<String> getServiciosContratados() {
	return serviciosContratados;
}

public static void setServiciosContratados(List<String> serviciosContratados) {
	Servicios.serviciosContratados = serviciosContratados;
}

public static void mainIniciarServicios (String[] args) {
	Servicios.mostrarOpcionesServicio();
}
}