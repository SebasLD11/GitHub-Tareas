package CLVTApp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Producto {
	private String nombre;
    private double precio;
    private int cantidadDisponible;
    private int iva;
    private static double totalVentas = 0; // Nuevo atributo para almacenar el total de ventas
    private static List<String> informacionVentas = new ArrayList<>();
    
    // Constructores
    
    public Producto(String nombre, double precio, int cantidadDisponible, int iva) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
		this.iva = iva;
	}

	public Producto(double precio, int cantidadDisponible, int iva, String nom) {
		super();
		this.nombre = "";
		this.precio = 0.0;
		this.cantidadDisponible = 0;
		this.iva = 0;
	}

	public Producto(String nombre, double precio, int cantidadDisponible) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
	}

	public Producto( double precio,String nombre, int iva) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.iva = iva;
	}

	public Producto() {
		super();
		this.nombre = "";
		this.precio = 0.0;
		this.cantidadDisponible = 0;
		this.iva = 0;
	}

	// Getters y Setters
       
    public String getNombre() {
        return nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

	public static double getTotalVentas() {
		return totalVentas;
	}

	public static void setTotalVentas(double totalVentas) {
		Producto.totalVentas = totalVentas;
	}
    
    public void setmodificarIva(int iva) {
        this.iva = iva;
    }
    
    public static List<String> getInformacionVentas() {
        return informacionVentas;
    }

	public static void setInformacionVentas(List<String> informacionVentas) {
		Producto.informacionVentas = informacionVentas;
	}
	
	// Método toString para imprimir información del producto
    
		@Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidadDisponible=" + cantidadDisponible +
                ", iva=" + iva +
                '}';
    }

    //Método para que el producto forme parte de una array list que contabilice el stock
    
    public static void registrarProductoEnStock(List<Producto> stockProductos, Producto producto) {
        stockProductos.add(producto);
    }

    public static void registrarVenta(double montoVenta, Producto producto, int cantidadVendida) {
        totalVentas += montoVenta;
        informacionVentas.add("Producto: " + producto.getNombre() + " - Precio: " + formatoDosDecimales(producto.getPrecio()) + "€ - Cantidad vendida: " + cantidadVendida);
    }
    
    private static String formatoDosDecimales(double valor) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(valor);
    }
    
    public boolean stockBajo() {
        return cantidadDisponible <= 5;
    }

}