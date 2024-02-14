
public class MetMayorZeroUN6 {

	public static void main(String[] args) {
		int op1 = 3;
		int op2 = 9;
		int resultado = sumaNumeros(op1, op2);
		System.out.println("El resultado es: " + resultado);
		
		if (positivos(resultado)) {
			System.out.println("El resultado es mayor o igual 0");
		} else {
			System.out.println("El resultado es negativo");
		}
	}
	
	public static int sumaNumeros(int num1, int num2)  {
		
		return num1+num2;
}
	public static boolean positivos(int param1) {
		
		if (param1 >=0) {
			return true;
		} else {
			return false;
		}
		
	}
	

}