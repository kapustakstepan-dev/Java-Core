package Ejerciccio5;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio5 {
    public void ejercicio5(){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*20)+1;
        }
        int opcion = 0;
        do {
            System.out.println("\n       MENU       ");
            System.out.println("1.Imprimir array");
            System.out.println("2.Mover a izquierda");
            System.out.println("3.Mover a derecha");
            System.out.println("4.Invertir");
            System.out.println("5.Salir");
            System.out.println("Que eliges: ");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1 ->{for (int item : array){
                    System.out.print(item + " ");
                }
                }
                case 2 ->{
                    System.out.println("Arrays original ");
                    for (int item : array){
                        System.out.print(item + " ");
                    }
                    System.out.println("\nArray cambiado a la izquierda");

                    int aux = array[array.length -1];
                    for (int i = array.length -1; i > 0 ; i--) {
                        array[i] = array[i-1];
                    }
                    array[0] = aux;
                    for (int item : array){
                        System.out.print(item + " ");
                    }

                }
                case 3 ->{System.out.println("Arrays original ");
                    for (int item : array){
                        System.out.print(item + " ");
                    }
                    System.out.println("\nArray cambiado a la derecha");

                    int aux = array[array.length -1];
                    for (int i = 0; i < array.length -1 ; i++) {
                        array[i] = array[i+1];
                    }
                    array[array.length-1] = aux;

                    for (int item : array){
                        System.out.print(item + " ");
                    }}
                case 4 ->{
                    for (int i = 0; i < array.length /2; i++) {
                        int aux = array[i];
                        array[i] = array[array.length -1 -i];
                        array[array.length-1-i] = aux;
                    }

                }
                case 5 ->{

                }
            }


        } while (opcion !=5);
        System.out.println("Saliendo...");
    }
}
