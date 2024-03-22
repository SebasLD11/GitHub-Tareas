package ud08POO;
import javax.swing.JOptionPane;

public class TA03Electrodomestico {
    // Atributos
    protected double precioBase;
    protected static final String COLOR_POR_DEFECTO = "blanco";
    protected String color;
    protected String consumoEner;
    protected double peso;

    // Constructores
    public TA03Electrodomestico(double precioBase, String consumoEner, double peso) {
        this.precioBase = precioBase;
        this.consumoEner = consumoEner;
        this.peso = peso;
        this.color = COLOR_POR_DEFECTO;
    }
    
    public TA03Electrodomestico(double precioBase, double peso, String consumoEner) {
		this.precioBase = 0.0;
		this.consumoEner = consumoEner;
		this.peso = 0.0;
		this.color = COLOR_POR_DEFECTO;
	}
 
    public TA03Electrodomestico(double pb, String cE, double ps, String color) {
    	this.precioBase = pb;
    	this.consumoEner = "";
    	this.peso = ps;
    	this.color = COLOR_POR_DEFECTO;
	}

	// getter y setters

	public double getPrecioBase() {
        return precioBase;
    }

	public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getConsumoEner() {
        return consumoEner;
    }

    public void setConsumoEner(String consumoEner) {
        this.consumoEner = consumoEner;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            this.color = color;
        }
    }

    public static String getColorPorDefecto() {
        return COLOR_POR_DEFECTO;
    }
    
    //Métodos para ejecutar, perdir y mostrar información. También cambiar el color si es el caso.
    
	public void pedirInformacion() {
    
    setPrecioBase(Double.parseDouble(JOptionPane.showInputDialog("Introduzca el precio base del producto:")));
    setConsumoEner(JOptionPane.showInputDialog("Introduzca el consumo energético:"));
    setPeso(Integer.parseInt(JOptionPane.showInputDialog("Introduzca el peso del producto:")));
    color = JOptionPane.showInputDialog("Color del producto:");
	}
	
	public void mostrarInfo() {
        JOptionPane.showMessageDialog(null, "Precio Base: " + precioBase +"€" + "\nConsumo Energético: " + consumoEner +
        		"\nPeso: " + peso +"Kg" + "\nColor: " + color);
    }
	
	public void cambiarColor() {
        String nuevoColor = JOptionPane.showInputDialog(null, "Introduce el nuevo color:");
        if (nuevoColor != null && !nuevoColor.isEmpty()) {
            if (!nuevoColor.equalsIgnoreCase(COLOR_POR_DEFECTO)) {
                setColor(nuevoColor);
            } else {
                JOptionPane.showMessageDialog(null, "El color introducido es igual al color por defecto: " + COLOR_POR_DEFECTO, "Color por Defecto", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha introducido ningún color.", "Color no especificado", JOptionPane.WARNING_MESSAGE);
        }
}

	public static void main (String[] args) {
    	TA03Electrodomestico info = new TA03Electrodomestico(0.0, null, 0.0, null);
    	info.pedirInformacion();
    	info.cambiarColor();
    	info.mostrarInfo();
    }
}
