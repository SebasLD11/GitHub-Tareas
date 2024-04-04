	package UD09Herencias;

// Interfaz IPersona
interface IPersona {
    String getNombre();
    int getEdad();
    String getSexo();
}

// Clase Persona
public abstract class Persona implements IPersona {
    protected String nombre;
    protected int edad;
    protected String sexo;

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public String getSexo() {
        return sexo;
    }
}