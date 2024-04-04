package UD09Herencias;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cine {
    private Pelicula peliculaActual;
    private double precioEntrada;
    private Asiento[][] asientos;

    public Cine(double precioEntrada) {
        this.precioEntrada = precioEntrada;
        this.asientos = new Asiento[8][9];
        // Inicializar los asientos
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                this.asientos[i][j] = new Asiento((char)('A' + j), i + 1);
            }
        }
    }

    public void reproducirPelicula(Pelicula pelicula) {
        this.peliculaActual = pelicula;
        System.out.println("Se está reproduciendo la película: " + pelicula.getTitulo());
    }

    public void sentarEspectador(Espectador espectador) {
        Random rand = new Random();
        int fila;
        int columna;
        do {
            fila = rand.nextInt(8);
            columna = rand.nextInt(9);
        } while (this.asientos[fila][columna].isOcupado());

        if (espectador.getEdad() >= peliculaActual.getEdadMinima() && espectador.getDinero() >= precioEntrada) {
            this.asientos[fila][columna].ocuparAsiento(espectador);
            System.out.println("El espectador " + espectador.getNombre() + " ha sido sentado en el asiento " + (char)('A' + columna) + (fila + 1));
        } else {
            System.out.println("El espectador " + espectador.getNombre() + " no cumple los requisitos para ver la película.");
        }
    }

public static void main(String[] args) {
    Cine cine = new Cine(10.0);

    // Lista de películas
    List<Pelicula> peliculas = new ArrayList<>();
    peliculas.add(new Pelicula("Spider-Man: No Way Home", 2021, 12, "Jon Watts"));
    peliculas.add(new Pelicula("Shang-Chi and the Legend of the Ten Rings", 2021, 12, "Destin Daniel Cretton"));
    peliculas.add(new Pelicula("Eternals", 2021, 12, "Chloé Zhao"));
    peliculas.add(new Pelicula("Venom: Let There Be Carnage", 2021, 12, "Andy Serkis"));
    peliculas.add(new Pelicula("Dune", 2021, 12, "Denis Villeneuve"));
    peliculas.add(new Pelicula("No Time to Die", 2021, 12, "Cary Joji Fukunaga"));
    peliculas.add(new Pelicula("Black Widow", 2021, 12, "Cate Shortland"));
    peliculas.add(new Pelicula("The Suicide Squad", 2021, 12, "James Gunn"));
    peliculas.add(new Pelicula("Free Guy", 2021, 12, "Shawn Levy"));
    peliculas.add(new Pelicula("Jungle Cruise", 2021, 12, "Jaume Collet-Serra"));

    // Seleccionar una película aleatoria para reproducir
    Random rand = new Random();
    cine.reproducirPelicula(peliculas.get(rand.nextInt(peliculas.size())));

    // Generar espectadores aleatorios y sentarlos
    for (int i = 0; i < 20; i++) {
        String nombre = "Espectador " + (i + 1);
        int edad = rand.nextInt(50) + 10; // Edad entre 10 y 59
        double dinero = rand.nextDouble() * 50 + 5; // Dinero entre 5 y 55
        Espectador espectador = new Espectador(nombre, edad, dinero);
        cine.sentarEspectador(espectador);
    }
}
}
