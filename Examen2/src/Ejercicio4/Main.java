package Ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ejercicicoexamen3 ejercicico4 = new Ejercicicoexamen3();
        ejercicico4.tabla();
        Scanner scanner = new Scanner(System.in);

        int opcion =0;
        do {
            System.out.println("---MENU---");
            System.out.println("1.Agregar persona ");
            System.out.println("2.Buscar persona ");
            System.out.println("3.Listar persona ");
            System.out.println("Salir");
            System.out.println("Que eliges ");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1 -> {
                    System.out.println("---Agregando persona---");
                    System.out.println("Introduzca nombre de persona: ");
                    String nombre = scanner.next();
                    System.out.println("Introduzca el apellido: ");
                    String apellido = scanner.next();
                    System.out.println("Introduzca el telefono ");
                    int telefono = scanner.nextInt();
                    System.out.println("Introduzca dni ");
                    String dni = scanner.next();
                    ejercicico4.agregarPersona(nombre,apellido,telefono,dni);
                }
                case 2 -> {
                    System.out.println("Introduzca dni: ");
                    String dni = scanner.next();
                    ejercicico4.obtenerInfo(dni);
                }
                case 3 -> {ejercicico4.listarPersona();}
                case 4 -> {
                }
            }
        } while (opcion != 4);
        System.out.println("saliendo...");












    }
}
