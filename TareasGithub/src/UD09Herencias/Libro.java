package UD09Herencias;

public class Libro {
	
	protected int ISBN;
	protected String titulo;
	protected String Autor;
	protected int paginas;
	
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	@Override
	public String toString() {
	     return "El libro: " + titulo + " \nCon ISBN: " + ISBN + "\nCreado por el autor: " + Autor + "\nTiene: " + paginas + " páginas";
	    }

	//Métodos
	public static void main(String[] args) {
        Libro libro1 = new Libro();
        libro1.setISBN(123456);
        libro1.setTitulo("El Señor de los Anillos");
        libro1.setAutor("J.R.R. Tolkien");
        libro1.setPaginas(1000);

        Libro libro2 = new Libro();
        libro2.setISBN(789012);
        libro2.setTitulo("Harry Potter y la Piedra Filosofal");
        libro2.setAutor("J.K. Rowling");
        libro2.setPaginas(400);

        System.out.println("Libro 1:\n" + libro1);
        System.out.println("\nLibro 2:\n" + libro2);

        if (libro1.getPaginas() > libro2.getPaginas()) {
            System.out.println("\nEl libro 1 tiene más páginas que el libro 2.");
        } else if (libro1.getPaginas() < libro2.getPaginas()) {
            System.out.println("\nEl libro 2 tiene más páginas que el libro 1.");
        } else {
            System.out.println("\nAmbos libros tienen la misma cantidad de páginas.");
        }
    }
	
}	