package UD09Herencias;

public class Serie implements Entregable{
    // Atributos
    private String titulo;
    private int numeroTemporadas;
    private boolean entregado;
    private String genero;
    private String creador;

    // Constructor por defecto
    public Serie() {
        this("", 3, false, "", "");
    }

    // Constructor con titulo y creador
    public Serie(String titulo, String creador) {
        this(titulo, 3, false, "", creador);
    }

    // Constructor con todos los atributos excepto entregado
    public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
        this(titulo, numeroTemporadas, false, genero, creador);
    }

    // Constructor con todos los atributos
    public Serie(String titulo, int numeroTemporadas, boolean entregado, String genero, String creador) {
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.entregado = entregado;
        this.genero = genero;
        this.creador = creador;
    }

    // Métodos get
    public String getTitulo() {
        return titulo;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public String getGenero() {
        return genero;
    }

    public String getCreador() {
        return creador;
    }

    // Métodos set
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCreador(String creador) {
        this.creador = creador;
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
        if (obj instanceof Serie) {
            Serie otraSerie = (Serie) obj;
            return Integer.compare(numeroTemporadas, otraSerie.numeroTemporadas);
        }
        return 0;
    }

    
    // Sobrescritura del método toString
    @Override
    public String toString() {
        return "Serie{" +
                "titulo='" + titulo + '\'' +
                ", numeroTemporadas=" + numeroTemporadas +
                ", entregado=" + entregado +
                ", genero='" + genero + '\'' +
                ", creador='" + creador + '\'' +
                '}';
    }
}
	
