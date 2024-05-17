package UD10TryCatch;

import java.util.Scanner;

public class UD10Ej05PasswordApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Indica la cantidad de Passwords a generar: ");
        int tamañoArray = scanner.nextInt();

        UD10Ej05Password[] passwords = new UD10Ej05Password[tamañoArray];
        boolean[] esFuerteArray = new boolean[tamañoArray];

        System.out.print("Indica la longitud de los Passwords: ");
        int longitudPasswords = scanner.nextInt();

        for (int i = 0; i < tamañoArray; i++) {
            passwords[i] = new UD10Ej05Password(longitudPasswords);
            esFuerteArray[i] = passwords[i].esFuerte();
        }

        for (int i = 0; i < tamañoArray; i++) {
            System.out.println(passwords[i].getContraseña() + " " + esFuerteArray[i]);
        }

        scanner.close();
    }
}
