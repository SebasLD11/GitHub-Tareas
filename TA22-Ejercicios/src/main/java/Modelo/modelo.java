package Modelo;


public class modelo{
	
private double moneda;
private double cantidad;
private double resultado;

public void setMoneda(double moneda) {
	this.moneda = moneda;
}	
public void setCantidad (double cantidad) {
	this.cantidad = cantidad;
}
public double getResultado() {
	return resultado;
}
public void convertirDolaraEuro() {
	resultado = cantidad * moneda;
	}
public void convertirEuroaDolar() {
	resultado = cantidad * moneda;
	}	

}
