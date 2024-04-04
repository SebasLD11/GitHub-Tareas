package UD09Herencias;

public class AppEjecutable {

	    public static void main(String[] args) {
	        // Crear arrays de Series y Videojuegos
	        Serie[] series = new Serie[5];
	        Videojuego[] videojuegos = new Videojuego[5];

	        // Crear objetos en cada posición de los arrays
	        series[0] = new Serie("Game of Thrones", 8, "Fantasía", "George R. R. Martin");
	        series[1] = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
	        series[2] = new Serie("The Office", 9, "Comedia", "Greg Daniels");
	        series[3] = new Serie("Stranger Things", 4, "Ciencia ficción", "The Duffer Brothers");
	        series[4] = new Serie("Friends", 10, "Comedia", "David Crane");

	        videojuegos[0] = new Videojuego("The Legend of Zelda: Breath of the Wild", 50, "Aventura", "Nintendo");
	        videojuegos[1] = new Videojuego("Grand Theft Auto V", 40, "Acción", "Rockstar Games");
	        videojuegos[2] = new Videojuego("The Witcher 3: Wild Hunt", 80, "Rol", "CD Projekt");
	        videojuegos[3] = new Videojuego("Red Dead Redemption 2", 60, "Aventura", "Rockstar Games");
	        videojuegos[4] = new Videojuego("Super Mario Odyssey", 30, "Plataformas", "Nintendo");

	        // Entregar algunos videojuegos y series
	        series[0].entregar();
	        series[2].entregar();
	        videojuegos[1].entregar();
	        videojuegos[4].entregar();

	        // Contar cuántos Series y Videojuegos hay entregados y devolverlos
	        int seriesEntregadas = contarEntregados(series);
	        int videojuegosEntregados = contarEntregados(videojuegos);

	        System.out.println("Número de Series entregadas: " + seriesEntregadas);
	        System.out.println("Número de Videojuegos entregados: " + videojuegosEntregados);

	        // Encontrar el videojuego con más horas estimadas
	        Videojuego videojuegoMasHoras = encontrarMasHoras(videojuegos);
	        // Encontrar la serie con más temporadas
	        Serie serieMasTemporadas = encontrarMasTemporadas(series);

	        // Mostrar la información del videojuego con más horas estimadas y de la serie con más temporadas
	        System.out.println("\nVideojuego con más horas estimadas:\n" + videojuegoMasHoras);
	        System.out.println("\nSerie con más temporadas:\n" + serieMasTemporadas);
	    }

	    // Método para contar los objetos entregados en un array de Entregable
	    public static int contarEntregados(Entregable[] array) {
	        int contador = 0;
	        for (Entregable item : array) {
	            if (item.isEntregado()) {
	                contador++;
	            }
	        }
	        return contador;
	    }

	    // Método para encontrar el videojuego con más horas estimadas en un array de Videojuego
	    public static Videojuego encontrarMasHoras(Videojuego[] array) {
	        Videojuego masHoras = array[0];
	        for (int i = 1; i < array.length; i++) {
	            if (array[i].compareTo(masHoras) > 0) {
	                masHoras = array[i];
	            }
	        }
	        return masHoras;
	    }

	    // Método para encontrar la serie con más temporadas en un array de Serie
	    public static Serie encontrarMasTemporadas(Serie[] array) {
	        Serie masTemporadas = array[0];
	        for (int i = 1; i < array.length; i++) {
	            if (array[i].compareTo(masTemporadas) > 0) {
	                masTemporadas = array[i];
	            }
	        }
	        return masTemporadas;
	    }
	}

