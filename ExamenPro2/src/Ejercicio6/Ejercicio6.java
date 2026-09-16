package Ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {
    public void ejercicio6() {
        Scanner scanner = new Scanner(System.in);
        double[] lista = new double[10];


        for (int i = 0; i < lista.length; i++) {
            double notas;
            do {
                System.out.println("Introduzca las notas");
                notas = scanner.nextDouble();
            } while (notas < 0 || notas >= 10);
            lista[i] = notas;
        }

        int suma =0;
        for (double item : lista){
            suma += item;
        }
        double  media = (double) suma / lista.length;

        double max = lista[0];
        double min = lista[0];
        for (double item : lista){
            if (item > max){
                max = item;
            }
            if (item < min){
                min = item;
            }
        }
        System.out.println("Numero maximo es " + max);
        System.out.println("Numero minimo es " + min);
        int aprovados = 0;
        int suspensos = 0;

        for (double item : lista){
            if (item > 5){
                aprovados++;
            } else {
                suspensos++;
            }
        }
        System.out.println("La cantidad de alumnos aprovados son " + aprovados);
        System.out.println("La cantidad de alumnos suspensos son " + suspensos);
    }
}
