import java.util.Scanner;

public class EjerciciosTarea5 {

	public static void main(String[] args) {
		
		//Mensaje de bienvenida con mi nombre
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("--Bienvenido/a a la ASOCIACIÓN CULTIVATE--");
			System.out.println("--Introduce tu nombre--");
			
			String name = sc.next();
			sc.close();
			
			System.out.println("Hola " + name.toUpperCase());
			
			
	}	

}
