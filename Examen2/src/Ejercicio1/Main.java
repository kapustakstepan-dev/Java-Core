package Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ejercicio1 ejercicio = new Ejercicio1();
        ejercicio.ejercicio1();
        int opcion = 0;


        do {
            System.out.println("1. Crear array\n");
            System.out.println("Salir:");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1 ->{
                    System.out.println("introduzca la longitud del array: ");


                }
                case 2 ->{}



            }
        } while (opcion != 2);






    }
}
