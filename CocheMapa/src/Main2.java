import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        gestion gestion = new gestion();
        Scanner scanner=new Scanner(System.in);
        int opcion=0;


        do {
            System.out.println("Menu");
            System.out.println("1. Añadir coche al taller");
            System.out.println("2. Listar coches");
            System.out.println("3. Buscar coche");
            System.out.println("4. Mostrar costes");
            System.out.println("5. Eliminar coche");
            System.out.println("6. Vaciar garaje");
            System.out.println("7.Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1->{
                    System.out.println("Matricula: ");
                    String matricula = scanner.nextLine();
                    System.out.println("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.println("Modelo:");
                    String modelo = scanner.nextLine();
                    System.out.println("Precio de reparacion: ");
                    int precio = scanner.nextInt();
                    System.out.println("que eliges? ");
                    scanner.nextLine();

                    Object[] coche = { matricula, marca, modelo, precio};
                    gestion.anadirCoche(coche);

                }
                case 2->{
                    gestion.listarCoches();
                }
                case 3->{
                    System.out.println("Introduzca la mattricula para buscar ");
                    String matricula = scanner.nextLine();
                    gestion.buscarCoche(matricula);}
                case 4->{System.out.print("Introduce la matrícula: ");
                    String matricula = scanner.nextLine();
                    gestion.mostrarCostes(matricula);}
                case 5->{
                    System.out.print("Introduce la matrícula: ");
                    String matricula = scanner.nextLine();
                    gestion.eliminarCoche(matricula);}
                case 6->{ gestion.vaciorGaraje();}
                case 7->{System.out.println("Saliendo..");}
                default -> {
                    System.out.println("opcion no valida");
                }

            }
        }while (opcion !=5);
    }
}
