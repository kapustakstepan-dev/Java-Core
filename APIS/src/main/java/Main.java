import controller.APIController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        APIController apiController = new APIController();

        int option;

        do {

            System.out.println("\n\n\t\t\tMENU");
            System.out.println("1 Busqueda general de provincias");
            System.out.println("2 Busqueda particular provincias");
            System.out.println("3 Busqueda ciudades");
            System.out.println("4 Exportar datos a fichero");
            System.out.println("5 Cambiar URL");
            System.out.println("6 Salir");
            System.out.print("Elige una opcion: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> {
                    apiController.busquedaGeneral();
                }

                case 2 -> {
                    System.out.print("Introduce nombre o id de provincia: ");
                    String nombre = scanner.nextLine();
                    apiController.busquedaParticular(nombre);
                }

                case 3 ->{
                    System.out.println("Introduzca el codigo de la provincia: ");
                    String codProv = scanner.nextLine();
                    apiController.menuProvinvias(codProv);
                }

                case 4 -> {
                    System.out.print("Esta guardado en un fichero");
                    apiController.exportToFile();
                }

                case 5 -> {
                    System.out.print("Introduce nueva URL: ");
                    String nuevaUrl = scanner.nextLine();
                    apiController.setUrl(nuevaUrl);
                }

                case 6 -> {
                    System.out.println("Saliendo...");
                }

                default -> {
                    System.out.println("Opción no valida");
                }
            }

        } while (option != 6);
    }
}