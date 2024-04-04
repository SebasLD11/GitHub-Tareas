package UD09Herencias;

public class Asiento {
	  private char letra;
	    private int numero;
	    private boolean ocupado;
	    private Espectador espectador;

	    public Asiento(char letra, int numero) {
	        this.letra = letra;
	        this.numero = numero;
	        this.ocupado = false;
	    }

	    public char getLetra() {
	        return letra;
	    }

	    public int getNumero() {
	        return numero;
	    }

	    public boolean isOcupado() {
	        return ocupado;
	    }

	    public void ocuparAsiento(Espectador espectador) {
	        this.espectador = espectador;
	        this.ocupado = true;
	    }

	    public Espectador getEspectador() {
	        return espectador;
	    }
	}