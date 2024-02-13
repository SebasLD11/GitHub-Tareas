
public class EjScopeTA05 {
		
		static int variableGlobal = 11;
		
		public static void metodoPrueba(){
			int variableMetodo=30;
			for (int i=0;i<11;i++) {
				System.out.println("La variable i vale " + i); 
				}
			System.out.println("Muestra variableMetodo " + variableMetodo);
		}

		public static void main(String[] args) {

			int variableLocal=70;
			if (variableGlobal==11) {
				int variableLocal1=50;
				System.out.println("La variable local  vale " 
						+ variableLocal1);
			}
			int variableLocal1 = 50;
			System.out.println("La variable local 1 vale " 
					+ variableLocal1);
			System.out.println("La variable global vale " 
					+ variableGlobal);
			metodoPrueba();
			
		}

	
}


