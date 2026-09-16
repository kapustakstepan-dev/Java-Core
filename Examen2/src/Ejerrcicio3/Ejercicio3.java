package Ejerrcicio3;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {

    private Scanner scaner = new Scanner(System.in);


    public void ejercicio3(){

        System.out.println("Introduzca un numero");
        int numeroUsuario = scaner.nextInt();
        if (numeroUsuario>0 && numeroUsuario<=100){

            int[] numerosRandom = new int[10];
            for (int i = 0; i < numerosRandom.length; i++) {
                numerosRandom[i] = (int)(Math.random()*100)+1;
                System.out.print(numerosRandom[i] + " ");
            }
            int resultado = 0;
            resultado = Arrays.stream(numerosRandom).max().getAsInt();
            System.out.println("\nEl número más grande generado  " + resultado);
            resultado = Arrays.stream(numerosRandom).min().getAsInt();
            System.out.println("El número más pequeño generado  " +resultado);
            double medio = Arrays.stream(numerosRandom).average().getAsDouble();
            System.out.println("El número medio generado "+medio);
            int suma = Arrays.stream(numerosRandom).sum();
            System.out.println("La suma de todos los números " + suma);

            boolean encontrado = false;
            for (int item : numerosRandom){
                if (item == numeroUsuario){
                    encontrado=true;
                }
            }
            System.out.println("El numero habia encontrado: " + encontrado);
        } else {
            System.out.println("Error, los numeros introducidos tienen que ser entre 1-100");
        }











    }
}
