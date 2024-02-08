import java.sql.Date;
import java.text.SimpleDateFormat;

public class EjercicioSwitchHora {


	private static String mensaje;

	public static void main(String[] args) {
		
		//EJEMPLO CON DATE
		
		 Date fecha = new Date(0);
		 System.out.println(fecha);
         SimpleDateFormat formatoHora = new SimpleDateFormat("h");
         int hora = Integer.parseInt(formatoHora.format(fecha));
         
		switch (hora) {
         	case 12:
         			mensaje = "Buenos días";
         			break;
         	case 18:
         			mensaje = "Buenas tardes" ;
         			break;
         	case 21:
         			mensaje = "Buenas noches";
         			break;
             
             
        }
		
		System.out.println("Hola! Son las " + hora + mensaje);

	}

	
}
