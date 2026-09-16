package Ejecicio1;

import java.util.Scanner;

public class Ejercicio1 {
    public void Wordle() {
        Scanner scanner = new Scanner(System.in);
        //Lista de palabras
        String[] palabras = {"Perro", "Madre", "Padre", " Gatos", "Pedro",
                "Tacos", "Juego", "Estar", "Fallo", "Letra"};
        String palabraSecreta = palabras[(int) (Math.random() * palabras.length)];

        //los intentos

        for (int intentos = 1; intentos  <= 5 ; intentos++) {
            System.out.print("Queda " + intentos + " intentos");
            System.out.println("Introduzca palabra secreta: ");
            String palabraUsuario = scanner.next();

        }
    }
}
