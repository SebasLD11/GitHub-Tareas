
import java.text.SimpleDateFormat;
import java.util.Date;

public class EjercicioSwitchHora {
	public static void main(String[] args) {	
		//EJEMPLO CON DATE
		
		 Date fecha = new Date();
		 System.out.println(fecha);
		 
		 String mensaje = null;
         SimpleDateFormat formatoHora = new SimpleDateFormat("h");
         int hora = Integer.parseInt(formatoHora.format(fecha));
         
		switch (hora) {
         	case 11:
         			mensaje = "Buenos días";
         			break;
         	case 13:
         			mensaje = "Buenas tardes" ;
         			break;
         	case 21:
         			mensaje = "Buenas noches";
         			break;
         		default : mensaje = "Pasa buen dia";
        }
		System.out.println( "Es la " + hora + "." + mensaje);

	}	
}
