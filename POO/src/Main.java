import Model.Vehiculo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        Vehiculo vehiculo = null;

        do {
            System.out.println("1. Crear coche");
            System.out.println("2. Mostrar datos del coche");
            System.out.println("3. Sumar CV a lo actuales CV");
            System.out.println("4. Contratar accesorio");
            System.out.println("5. Eliminar coche");
            System.out.println("6. Salir");
            System.out.println("Que eliges?");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1 ->{
                    System.out.println("Introduzca Marca del coche ");
                    String marca = scanner.next();
                    System.out.println("Introduzca Modelo del coche ");
                    String modelo = scanner.next();
                    System.out.println("Introduzca tipo del coche ");
                    String tipo = scanner.next();
                    System.out.println("Introduzca CV del coche ");
                    int cv = scanner.nextInt();
                    System.out.println("Introduzca CC del coche ");
                    int cc = scanner.nextInt();
                    vehiculo = new Vehiculo(marca, modelo, tipo, cv, cc);

                }
                case 2 ->{if (vehiculo != null){
                    vehiculo.motrarDatos();
                } else {
                    System.out.println("Crea coche ");
                }
                    }
                case 3 ->{
                    if (vehiculo != null){
                        System.out.println("Cuantos CV quieres sumar? ");
                        int cv = scanner.nextInt();
                        vehiculo.setCv(vehiculo.getCv()+cv);
                    } else {
                        System.out.println("Crea coche ");
                    }

                }
                case 4 ->{if (vehiculo != null){
                    System.out.println("Introduzca el nombre del Accsorrio ");
                    String accesorio = scanner.next();
                    vehiculo.getListaAccesorio().add(accesorio);
                } else {
                    System.out.println("No puedes agregar  el coche");
                }
                }
                case 5 ->{vehiculo = null;}
                case 6 ->{
                    System.out.println("SAliendo...");
                }
            }
        }while (opcion != 6);


    }
}
