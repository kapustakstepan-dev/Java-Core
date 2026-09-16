import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GarajeControler gc = new GarajeControler();
        int opcion;

        do {
            System.out.println("\n--- MENÚ GARAJE ---");
            System.out.println("1. Añadir coche");
            System.out.println("2. Listar coches");
            System.out.println("3. Buscar coche");
            System.out.println("4. Eliminar coche");
            System.out.println("5. Tamaño del garaje");
            System.out.println("6. Búsqueda personalizada");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();

                    System.out.print("CV: ");
                    int cv = sc.nextInt();

                    System.out.print("Precio: ");
                    int precio = sc.nextInt();
                    sc.nextLine();

                    Object[] coche = {matricula, marca, modelo, cv, precio};
                    gc.aniadirCoche(coche);
                    break;

                case 2:
                    gc.listarCoches();
                    break;

                case 3:
                    System.out.print("Introduce matrícula: ");
                    matricula = sc.nextLine();
                    gc.buscarCoche(matricula);
                    break;

                case 4:
                    System.out.print("Introduce matrícula a eliminar: ");
                    matricula = sc.nextLine();
                    gc.eliminarCoche(matricula);
                    break;

                case 5:
                    gc.obtenerTamano();
                    break;

                case 6:
                    gc.busquedaPersonalizada();
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 7);

        sc.close();
    }
}
