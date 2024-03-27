package CLVTApp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MenuControlador {

	public static void main(String[] args) {
	    mostrarMenuControlador();
	}
		public static void mostrarMenuControlador() {
			String[] opcionesMenu = {"Sobre nosotros", "CLVT Store", "Servicios", "Proyectos","Eventos", "Información adicional", "Salir"};
	        while (true) {
	            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
	                    "~~~ASOCIACIÓN CUTLIVATE~~~", JOptionPane.PLAIN_MESSAGE, null, opcionesMenu, opcionesMenu[0]);
	            if (opcionSeleccionada == null || opcionSeleccionada.equals("Salir")) {
	                JOptionPane.showMessageDialog(null, "Saliendo de la aplicación.");
	                break;
	            }
	            switch (opcionSeleccionada) {
	                case "Sobre nosotros":
	                    agregarInfoNosotros();
	                    break;
	                case "CLVT Store":
	                    iniciarCLVTStore();
	                    break;
	                case "Servicios":
	                    mostrarServicios();
	                    break;
	                case "Proyectos":
	                    mostrarProyectos();
	                    break;
	                case "Eventos":
	                    mostrarEventos();
	                    break;
	                case "Información adicional":
	                    mostrarinfoAdicional();
	                    break;
	                default:
	                    JOptionPane.showMessageDialog(null, "Opción no válida.");
	            }
	        }
	    }
		
		protected static double formatoDosDecimales(double valor) {
		        return Math.round(valor * 100.0) / 100.0;
		    }
		

		public static void agregarInfoNosotros() {
		    String textoInfo = JOptionPane.showInputDialog(null, "Por favor, ingrese un texto explicativo sobre nuestra entidad:");
		    if (textoInfo != null && !textoInfo.isEmpty()) {
		        // Aquí puedes guardar el texto en alguna estructura de datos o simplemente mostrarlo
		        JOptionPane.showMessageDialog(null, "Información agregada correctamente:\n" + textoInfo);
		    } else {
		        JOptionPane.showMessageDialog(null, "No se ingresó ningún texto. La información no se ha guardado.");
		    }
		}
		
		public static void iniciarCLVTStore() {
	        CLVTStore.main(null);
	    }

		 public static void mostrarServicios() {
		        JOptionPane.showMessageDialog(null, "Mostrando servicios disponibles...");

		        // Aquí puedes implementar la lógica para mostrar los servicios disponibles
		        String[] servicios = {"Talleres básicos", "Clases particulares", "Programa 'STAIRS'",
		                "Campus Workout"};

		        String servicioSeleccionado = (String) JOptionPane.showInputDialog(null,
		                "Seleccione un servicio:", "Servicios disponibles",
		                JOptionPane.QUESTION_MESSAGE, null, servicios, servicios[0]);

		        if (servicioSeleccionado != null) {
		            // Aquí puedes agregar lógica adicional según el servicio seleccionado
		            switch (servicioSeleccionado) {
		                case "Talleres básicos":
		                	Servicios talleresBasicos = new Servicios("Talleres Básicos", "Descripción de los talleres básicos", 0);
		                    talleresBasicos.mostrarInformacion();
		                    talleresBasicos.contratarServicio();
		                	String[] opcionesTalleres = {"Reducida", "Completa", "Reducida + 2H particulares", "Completa + 4H particulares"};
		                    String tallerSeleccionado = (String) JOptionPane.showInputDialog(null,
		                            "Seleccione una opción de taller:", "Talleres básicos",
		                            JOptionPane.QUESTION_MESSAGE, null, opcionesTalleres, opcionesTalleres[0]);

		                    if (tallerSeleccionado != null) {
		                        double precioTaller = 0;

		                        switch (tallerSeleccionado) {
		                            case "Reducida":
		                                precioTaller = 25.0;
		                                break;
		                            case "Completa":
		                                precioTaller = 35.0;
		                                break;
		                            case "Reducida + 2H particulares":
		                                precioTaller = 50.0;
		                                break;
		                            case "Completa + 4H particulares":
		                                precioTaller = 80.0;
		                                break;
		                            default:
		                                JOptionPane.showMessageDialog(null, "Opción de taller no válida.");
		                                break;
		                        }

		                        JOptionPane.showMessageDialog(null, "Usted ha seleccionado el taller: " + tallerSeleccionado +
		                                "\nPrecio: " + precioTaller + "€");
		                    }
		                    break;
		                    
		                case "Clases particulares":
		                    String[] opcionesMonitor = {"Daniel Carrillo. Scooter (20€/h)", "Sebastián López. Skate (35€/h)"};
		                    String monitorSeleccionado = (String) JOptionPane.showInputDialog(null,
		                            "Seleccione el monitor para las clases particulares:", "Clases particulares",
		                            JOptionPane.QUESTION_MESSAGE, null, opcionesMonitor, opcionesMonitor[0]);

		                    if (monitorSeleccionado != null) {
		                        double precioClases = 0;

		                        switch (monitorSeleccionado) {
		                            case "Daniel Carrillo. Scooter (20€/h)":
		                                precioClases = 20.0;
		                                break;
		                            case "Sebastián López. Skate (35€/h)":
		                                precioClases = 35.0;
		                                break;
		                            default:
		                                JOptionPane.showMessageDialog(null, "Opción de monitor no válida.");
		                                break;
		                        }

		                        JOptionPane.showMessageDialog(null, "Usted ha seleccionado el monitor para las clases particulares: " +
		                                monitorSeleccionado + "\nPrecio: " + precioClases + "€/h");
		                    }
		                    break;

		                case "Programa STAIRS":
		                    String[] opcionesBono = {"MENSUAL 120€.// 180€/mes, segundo año", "TRIMESTRAL 345€ (115€/mes).// 450€ (150€/mes, segundo año)",
		                    		"SEMESTRAL 630€ (315€/cuota trimestral).// 780€ (390€/trimestral, segundo año) ", "ANUAL 1140€ (285€/cuota trimestral).//"
		                    				+ " 1260€ (315€/trimestral, segundo año) "};
		                    String bonoSeleccionado = (String) JOptionPane.showInputDialog(null,
		                            "Seleccione el tipo de bono para el Programa STAIRS:", "Programa STAIRS",
		                            JOptionPane.QUESTION_MESSAGE, null, opcionesBono, opcionesBono[0]);

		                    if (bonoSeleccionado != null) {
		                        double precioBono = 0;

		                        switch (bonoSeleccionado) {
		                            case "MENSUAL 120€.// 180€/mes, segundo año":
		                                precioBono = 120.0;
		                                break;
		                            case "TRIMESTRAL 345€ (115€/mes).// 450€ (150€/mes, segundo año)":
		                                precioBono = 345.0;
		                                break;
		                            case "SEMESTRAL 630€ (315€/cuota trimestral).// 780€ (390€/trimestral, segundo año) ":
		                                precioBono = 630.0;
		                                break;
		                            case  "ANUAL 1140€ (285€/cuota trimestral).//"
		                    				+ " 1260€ (315€/trimestral, segundo año)":
		                                precioBono = 1140.0;
		                                break;
		                            default:
		                                JOptionPane.showMessageDialog(null, "Opción de bono no válida.");
		                                break;
		                        }

		                        JOptionPane.showMessageDialog(null, "Usted ha seleccionado el bono para el Programa STAIRS: " +
		                                bonoSeleccionado + "\nPrecio: " + precioBono + "€");
		                    }
		                    break;

		                case "Campus Workout":
		                    String[] opcionesServicio = {"Completo (180€ pack de 5 días)", "Parcial (110€ pack de 3 días)", "Servicio Individual (40€ día suelto)"};
		                    String servicioSelec = (String) JOptionPane.showInputDialog(null,
		                            "Seleccione el tipo de servicio para el Campus Workout:", "Campus Workout",
		                            JOptionPane.QUESTION_MESSAGE, null, opcionesServicio, opcionesServicio[0]);

		                    if (servicioSelec != null) {
		                        double precioServicio = 0;

		                        switch (servicioSelec) {
		                            case "Completo (180€ pack de 5 días. 4h/día)":
		                                precioServicio = 180.0;
		                                break;
		                            case "Parcial (110€ pack de 3 días. 4h/día)":
		                                precioServicio = 110.0;
		                                break;
		                            case "Servicio Individual (40€ día suelto. 2h/servicio)":
		                                String[] opcionesIndividual = {"Entrenamiento Personal", "Entrenamiento Dirigido", "Tecnificación Skate/Scooter", "Casal Lúdico/Recreativo"};
		                                String individualSeleccionado = (String) JOptionPane.showInputDialog(null,
		                                        "Seleccione el tipo de servicio individual:", "Servicio Individual",
		                                        JOptionPane.QUESTION_MESSAGE, null, opcionesIndividual, opcionesIndividual[0]);

		                                if (individualSeleccionado != null) {
		                                    switch (individualSeleccionado) {
		                                        case "Entrenamiento Personal":
		                                        case "Entrenamiento Dirigido":
		                                        case "Tecnificación Skate/Scooter":
		                                        case "Casal Lúdico/Recreativo":
		                                            precioServicio = 40.0;		                                           
		                                            break;
		                                        default:
		                                            JOptionPane.showMessageDialog(null, "Opción de servicio individual no válida.");
		                                            break;
		                                    }
		                                }
		                                break;
		                            default:
		                                JOptionPane.showMessageDialog(null, "Opción de servicio no válida.");
		                                break;
		                        }

		                        JOptionPane.showMessageDialog(null, "Usted ha seleccionado el servicio para el Campus Workout: " +
		                                servicioSelec + "\nPrecio: " + precioServicio + "€");
		                    }
		                    break;

		                default:
		                    JOptionPane.showMessageDialog(null, "Servicio no válido.");
		            }
		        }
		    }
}
