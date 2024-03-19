package UD8POO;

public class EjPersonaClase {
	
	    // Atributos (o campos/propiedades)
	    private String nombre;
	    private int edad;
	    private String sexo;
	    private String dni;
	    private double peso;
	    private double altura;
	    
	 // Constructor(es)
	    public EjPersonaClase(String nombre, int edad, String sexo, String dni, double peso, double altura) {
			this.nombre = nombre;
			this.edad = edad;
			this.sexo = sexo;
			this.dni = dni;
			this.peso = peso;
			this.altura = altura;
		}
	    
	    // Métodos (o funciones)
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public int getEdad() {
	        return edad;
	    }

	    public void setEdad(int edad) {
	        this.edad = edad;
	    }

	    public String getsexo() {
	        return sexo;
	    }

	    public void setsexo(String sexo) {
	        this.sexo = sexo;
	    }

	    public double getPeso() {
			return peso;
		}

		public void setPeso(double peso) {
			this.peso = peso;
		}

		public double getAltura() {
			return altura;
		}

		public void setAltura(double altura) {
			this.altura = altura;
		}
		@Override
	    public String toString() {
	        return "Persona{" +
	                "nombre='" + nombre + '\'' +
	                ", edad=" + edad +
	                ", sexo='" + sexo + '\'' +
	                ", dni=" + dni +
	                '}';
	    }
}
