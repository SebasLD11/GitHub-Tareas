package UD09Herencias;

public class Pelicula {
	private String titulo;
    private int año;
    private int edadMinima;
    private String director;

    public Pelicula(String titulo, int año, int edadMinima, String director) {
        this.titulo = titulo;
        this.año = año;
        this.edadMinima = edadMinima;
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAño() {
        return año;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public String getDirector() {
        return director;
    }
}

