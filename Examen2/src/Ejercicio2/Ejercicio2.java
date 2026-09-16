package Ejercicio2;

public class Ejercicio2 {
    public void ejercicio2(){
        int[][] array1 = new int[3][3];
        int[][] array2 = new int[3][3];

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                array1[i][j] = (int) (Math.random()*11);
                array2[i][j] = (int) (Math.random()*11);
            }
        }
        int contadorIgual = 0;
        int contadorMenos = 0;
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i][j] == array2[i][j]){
                    contadorIgual++;
                } else{
                    contadorMenos++;
                }
            }
        }
        for (int[] item : array1){
            for (int i : item){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("*-*-*-*-*-*-*-");
        for (int[] item : array2){
            for (int i : item){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("Coincidencias exactas (misma posición): " + contadorIgual);
        System.out.println("Coincidencias en posiciones diferentes: " + contadorMenos);




    }
}
