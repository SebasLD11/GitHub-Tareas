package CLVTApp;
import javax.swing.JOptionPane;

public class Servicios extends MenuControlador {
    private String nombre;
    private String descripcion;
    private double precio;
    private String claseServicios;

    // Constructor con atributos predeterminados
    public Servicios() {
        this.setNombre("");
        this.setDescripcion("");
        this.setPrecio(0.0); // Precio predeterminado
        this.setClaseServicios(""); // La clase de servicio se pedirá al mostrar las opciones
    }

    // Constructor con parámetros
    public Servicios(String nombre, String descripcion, double precio, String claseServicios) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
        this.setClaseServicios(claseServicios);
    }

    // Método para mostrar las opciones de servicio
    public void mostrarOpcionesServicio() {
        // Mostrar las opciones de servicio usando un bucle switch
        StringBuilder opciones = new StringBuilder("Opciones de Servicio:\n");
        opciones.append("1. Taller básico (25€ - Reducido, 35€ - Completo, 50€ - Reducido + 2h particulares, 70€ - Completo + 4h particulares)\n");
        opciones.append("2. Programa STAIRS (MENSUAL: 120€/mes, TRIMESTRAL: 345€/trimestre, SEMESTRAL: 630€/semestre, ANUAL: 1140€/año)\n");
        opciones.append("3. Clases particulares (Daniel Carrillo - 20€/h, Sebastián López - 35€/h)\n");
        opciones.append("4. Campus Workout (Individual 2h: 40€, Parcial 3 días 4h/día: 110€, Completo 5 días: 180€)\n");
        opciones.append("5. Alquiler de material (Skate - 5€/h, Scooter - 7€/h)\n");

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
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    
    // Método para mostrar las opciones
    
    private void mostrarOpcionesTallerBasico() {
        String[] opciones = {
                "Taller básico - Reducido (25€)",
                "Taller básico - Completo (35€)",
                "Taller básico - Reducido + 2h particulares (50€)",
                "Taller básico - Completo + 4h particulares (70€)"
        };

        int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione una opción de taller básico:",
                "Opciones de Taller Básico", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]);

        switch (opcionSeleccionada) {
            case 0:
                contratarTallerBasico("Taller básico - Reducido", 25);
                break;
            case 1:
                contratarTallerBasico("Taller básico - Completo", 35);
                break;
            case 2:
                contratarTallerBasico("Taller básico - Reducido + 2h particulares", 50);
                break;
            case 3:
                contratarTallerBasico("Taller básico - Completo + 4h particulares", 70);
                break;
            default:
                break;
        }
    }

    // Método para mostrar las opciones de campus workout
    private void mostrarOpcionesCampusWorkout() {
        String[] opciones = {
                "Servicio individual de 2h (40€)",
                "Campus parcial de 3 días (110€)",
                "Campus completo de 5 días (180€)"
        };

        int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione una opción de campus workout:",
                "Opciones de Campus Workout", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]);

        switch (opcionSeleccionada) {
            case 0:
                contratarCampusWorkout("Servicio individual de 2h", 40);
                break;
            case 1:
                contratarCampusWorkout("Campus parcial de 3 días", 110);
                break;
            case 2:
                contratarCampusWorkout("Campus completo de 5 días", 180);
                break;
            default:
                break;
        }
    }

    // Método para mostrar las opciones de alquiler de material
    private void mostrarOpcionesAlquilerMaterial() {
        String[] opciones = {
                "Alquiler de Skate (5€/h)",
                "Alquiler de Scooter (7€/h)"
        };

        int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione una opción de alquiler de material:",
                "Opciones de Alquiler de Material", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]);

        switch (opcionSeleccionada) {
            case 0:
                contratarAlquilerMaterial("Alquiler de Skate", 5);
                break;
            case 1:
                contratarAlquilerMaterial("Alquiler de Scooter", 7);
                break;
            default:
                break;
        }
    }

    
    private void mostrarOpcionesProgramaSTAIRS() {
        StringBuilder opciones = new StringBuilder("Opciones de Programa STAIRS:\n");
        opciones.append("1. MENSUAL: 120€/mes\n");
        opciones.append("2. TRIMESTRAL: 345€/trimestre\n");
        opciones.append("3. SEMESTRAL: 630€/semestre\n");
        opciones.append("4. ANUAL: 1140€/año\n");

        int opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(opciones.toString() + "\nSeleccione una opción:"));
        double precioServicio = 0.0;
        switch (opcionElegida) {
            case 1:
                precioServicio = 120.0;
                break;
            case 2:
                precioServicio = 345.0;
                break;
            case 3:
                precioServicio = 630.0;
                break;
            case 4:
                precioServicio = 1140.0;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        contratarServicio("Programa STAIRS", precioServicio);
    }

    // Método para mostrar las opciones de clases particulares
    private void mostrarOpcionesClasesParticulares() {
        StringBuilder opciones = new StringBuilder("Opciones de Clases Particulares:\n");
        opciones.append("1. Daniel Carrillo - 20€/h\n");
        opciones.append("2. Sebastián López - 35€/h\n");

        int opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(opciones.toString() + "\nSeleccione una opción:"));
        double precioServicio = 0.0;
        switch (opcionElegida) {
            case 1:
                precioServicio = 20.0;
                break;
            case 2:
                precioServicio = 35.0;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        contratarServicio("Clases Particulares", precioServicio);
    }

    // Métodos para mostrar las opciones de campus workout y alquiler de material (implementa estos métodos de manera similar a mostrarOpcionesProgramaSTAIRS y mostrarOpcionesClasesParticulares)

    // Métodos para contratar el servicio seleccionado
    private void contratarServicio(String nombreServicio, double precioServicio) {
        JOptionPane.showMessageDialog(null, "Contratando servicio: " + nombreServicio);

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
                "Precio: " + precioServicio);
    }

    // (Implementa los métodos para contratar el servicio seleccionado de manera similar a contratarServicio, mostrando la información del servicio contratado)

//Método para contratar el servicio seleccionado del taller básico
private void contratarTallerBasico(String tipoTaller, double precioTaller) {
 JOptionPane.showMessageDialog(null, "Contratando servicio: " + tipoTaller);

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
         "Tipo de Taller: " + tipoTaller + "\n" +
         "Precio: " + precioTaller);
}

//Método para contratar el servicio seleccionado del programa STAIRS
@SuppressWarnings("unused")
private void contratarProgramaSTAIRS(String tipoPrograma, double precioPrograma) {
 JOptionPane.showMessageDialog(null, "Contratando servicio: " + tipoPrograma);

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
         "Tipo de Programa: " + tipoPrograma + "\n" +
         "Precio: " + precioPrograma);
}
//Método para contratar el servicio seleccionado de clases particulares
@SuppressWarnings("unused")
private void contratarClasesParticulares(String tipoClases, double precioClases) {
  JOptionPane.showMessageDialog(null, "Contratando servicio: " + tipoClases);

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
          "Tipo de Clases: " + tipoClases + "\n" +
          "Precio: " + precioClases);
}

//Método para contratar el servicio seleccionado de campus workout
private void contratarCampusWorkout(String tipoCampus, double precioCampus) {
  JOptionPane.showMessageDialog(null, "Contratando servicio: " + tipoCampus);

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
          "Tipo de Campus: " + tipoCampus + "\n" +
          "Precio: " + precioCampus);
}

//Método para contratar el servicio seleccionado de alquiler de material
private void contratarAlquilerMaterial(String tipoMaterial, double precioMaterial) {
  JOptionPane.showMessageDialog(null, "Contratando servicio: " + tipoMaterial);

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
          "Tipo de Material: " + tipoMaterial + "\n" +
          "Precio: " + precioMaterial);
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
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
}
