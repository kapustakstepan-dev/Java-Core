package Ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {
    public void ejercicio3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el tamanio e array");
        int tamanio = scanner.nextInt();
        int[][] array1 = new int[tamanio][tamanio];
        int[][] array2 = new int[tamanio][tamanio];

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j <array1.length ; j++) {
                array1[i][j] = (int) (Math.random()*51);
                array2[i][j] = (int) (Math.random()*51);
            }

        }
        System.out.println("Array 1");
        for (int[] item : array1){
            for (int p : item){
                System.out.print(p + " ");
            }
            System.out.println();
        }
        System.out.println("Array 2");
        System.out.println("*-*-*-*-*-");
        for (int[] item : array2){
            for (int p : item){
                System.out.print(p + " ");
            }
            System.out.println();
        }
        int[][] sumaMatrices = new int[tamanio][tamanio];
        for (int i = 0; i < sumaMatrices.length; i++) {
            for (int j = 0; j < sumaMatrices.length; j++) {
                sumaMatrices[i][j] = array1[i][j] + array2[i][j];

            }
        }
        System.out.println("sumaMatrices");
        for (int[] item : sumaMatrices){
            for (int p : item){
                System.out.print(p + " ");
            }
            System.out.println();
        }

    }


}
