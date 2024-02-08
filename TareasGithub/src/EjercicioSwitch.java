public class EjercicioSwitch {

	public static void main(String[] args) {
int dia = 5; // Por ejemplo, 5 representa el viernes        
        String nomDia;        
        switch (dia) {
            case 1:
                nomDia = "Lunes";
                break;
            case 2:
                nomDia = "Martes";
                break;
            case 3:
                nomDia = "Miércoles";
                break;
            case 4:
                nomDia = "Jueves";
                break;
            case 5:
                nomDia = "Viernes";
                break;
            default:
                nomDia = "Inválido";
                break;
        }
        
        System.out.println("El día es: " + nomDia);
        
	}
}