package Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public void bonoloto() {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[6];
        System.out.println("Introduzca los numeros para jugar en bonoloto:");
        int numeroUsuario = scanner.nextInt();
        if (numeroUsuario > 0 && numeroUsuario <50){

            for (int i = 0; i < numeros.length; i++) {
                numeros[i] = (int) (Math.random() * 49) + 1;
            }
            for (int i = 0; i < numeros.length; i++) {
                if (numeroUsuario == numeros[i]){
                    System.out.println("Has ganado ");
                } else {
                    System.out.println("Repite la accion");
                }
            }
            for (int item:numeros){
                System.out.print(item+" ");
            }

        } else {
            System.out.println("El numero tiene que ser entre 1-50");
        }

    }
}
