
public class CalculaIva {

	public static void main(String[] args) {
		int precioProducto=300;
		final double Iva=0.21;
		System.out.println("informacion del producto");
		
		System.out.println("El precio del produto es" + precioProducto);
		
		System.out.println("El precio del producto, incluyendo Iva, es "+(precioProducto + precioProducto*Iva));
	}

}
