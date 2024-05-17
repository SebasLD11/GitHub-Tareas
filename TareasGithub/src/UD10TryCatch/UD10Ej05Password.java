package UD10TryCatch;

import java.util.Random;

public class UD10Ej05Password {
    private int longitud;
    private String contraseña;
    private static final int LONGITUD_POR_DEFECTO = 8;

    public UD10Ej05Password() {
        this(LONGITUD_POR_DEFECTO);
    }

    public UD10Ej05Password(int longitud) {
        this.longitud = longitud;
        generarPassword();
    }

    public boolean esFuerte() {
        int mayusculas = 0;
        int minusculas = 0;
        int numeros = 0;

        for (char c : contraseña.toCharArray()) {
            if (Character.isUpperCase(c)) {
                mayusculas++;
            } else if (Character.isLowerCase(c)) {
                minusculas++;
            } else if (Character.isDigit(c)) {
                numeros++;
            }
        } 
        return (mayusculas == 2 && minusculas == 1 && numeros == 5);
    }

    public void generarPassword() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(longitud);

        for (int i = 0; i < longitud; i++) {
            int choice = rand.nextInt(3);
            switch (choice) {
                case 0:
                    sb.append((char) (rand.nextInt(10) + 48)); // números
                    break;
                case 1:
                    sb.append((char) (rand.nextInt(26) + 65)); // mayúsculas
                    break;
                case 2:
                    sb.append((char) (rand.nextInt(26) + 97)); // minúsculas
                    break;
            }
        }

        contraseña = sb.toString();
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
        generarPassword();
    }
}

