package UD09Herencias;

public class Videojuego implements Entregable {
    // Atributos
    private String titulo;
    private int horasEstimadas;
    private boolean entregado;
    private String genero;
    private String compañia;

    // Constructor por defecto
    public Videojuego() {
        this("", 10, false, "", "");
    }

    // Constructor con titulo y horas estimadas
    public Videojuego(String titulo, int horasEstimadas) {
        this(titulo, horasEstimadas, false, "", "");
    }

    // Constructor con todos los atributos excepto entregado
    public Videojuego(String titulo, int horasEstimadas, String genero, String compañia) {
        this(titulo, horasEstimadas, false, genero, compañia);
    }

    // Constructor con todos los atributos
    public Videojuego(String titulo, int horasEstimadas, boolean entregado, String genero, String compañia) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.entregado = entregado;
        this.genero = genero;
        this.compañia = compañia;
    }

    // Métodos get
    public String getTitulo() {
        return titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public String getCompañia() {
        return compañia;
    }

    // Métodos set
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

 // Implementación de los métodos de la interfaz Entregable
    @Override
    public void entregar() {
        entregado = true;
    }

    @Override
    public void devolver() {
        entregado = false;
    }

    @Override
    public boolean isEntregado() {
        return entregado;
    }

    @Override
    public int compareTo(Object obj) {
        if (obj instanceof Videojuego) {
            Videojuego otroVideojuego = (Videojuego) obj;
            return Integer.compare(horasEstimadas, otroVideojuego.horasEstimadas);
        }
        return 0;
    }

    // Sobrescritura del método toString
    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", horasEstimadas=" + horasEstimadas +
                ", entregado=" + entregado +
                ", genero='" + genero + '\'' +
                ", compañia='" + compañia + '\'' +
                '}';
    }
}
