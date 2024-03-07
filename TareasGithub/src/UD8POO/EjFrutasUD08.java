package UD8POO;

public class EjFrutasUD08 {

	// Atributos
		String nombre;
		String color;
		double precio;
		
	//constructores		
		public EjFrutasUD08() {
		
			this.nombre = "";
			this.color = "";
			this.precio = 0.0;
		}
		public EjFrutasUD08(String param1) {
		this.nombre = param1;
		this.color = "";
		this.precio = 0.0;
	}
		public EjFrutasUD08(String param1, double param2) {
			this.nombre = param1;
			this.color = "";
			this.precio = param2;
		}
		public EjFrutasUD08(String param1, String param3) {
			this.nombre = param1;
			this.color = param3;
			this.precio = 0.0;
		}
		public EjFrutasUD08(String param1, String param2, double param3) {
			this.nombre = param1;
			this.color = param2;
			this.precio = param3;
		}
		
		public static void main(String[] args) {
			
		//instantaciones siempre en el main
			
		EjFrutasUD08 manzana = new EjFrutasUD08();
		EjFrutasUD08 platano = new EjFrutasUD08("Platano");
		EjFrutasUD08 arandanos = new EjFrutasUD08("Arandanos", "lila");
		EjFrutasUD08 albaricoque = new EjFrutasUD08("Albaricoque", "naranja", 10.15);
			
		System.out.println("Mi primera fruta es " + manzana.nombre + ", tiene color " + manzana.color + " y un precio de " + manzana.precio);
		System.out.println("Mi segunda fruta es " + platano.nombre + ", tiene color " + platano.color + " y un precio de " + platano.precio);
		System.out.println("Mi tercer fruta es " + arandanos.nombre + ", tiene color " + arandanos.color + " y un precio de " + arandanos.precio);
		System.out.println("Mi cuarta fruta es " + albaricoque.nombre + ", tiene color " + albaricoque.color + " y un precio de " + albaricoque.precio);
		
		//reasignar valores
		manzana.nombre = "manzana";
		manzana.color = "verde";
		manzana.precio = 1.50;
		platano.color = "amarillo";
		platano.precio = 1.75;
		arandanos.precio = 5.00;
		
		System.out.println("Mi primera fruta es " + manzana.nombre + ", tiene color " + manzana.color + " y un precio de " + manzana.precio);
		System.out.println("Mi segunda fruta es " + platano.nombre + ", tiene color " + platano.color + " y un precio de " + platano.precio);
		System.out.println("Mi tercer fruta es " + arandanos.nombre + ", tiene color " + arandanos.color + " y un precio de " + arandanos.precio);
		System.out.println("Mi cuarta fruta es " + albaricoque.nombre + ", tiene color " + albaricoque.color + " y un precio de " + albaricoque.precio);	
}
}
	