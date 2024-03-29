package CLVTApp;

public class Donativo extends InfoAdicional {
    
	private String nombre;
    private String documento;
    private double cantidad;
    private String telefono;
    private String correo;
	
    public Donativo(String nombre, String documento, double cantidad, String telefono, String correo) {
    	this.nombre = "";
    	this.documento = "";
    	this.cantidad = 0.0;
    	this.telefono = "";
    	this.correo = "";
    }
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

}