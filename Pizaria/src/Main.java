import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pizzas pizzas = new Pizzas();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("     MENU   ");
            System.out.println("1. Add pedido");
            System.out.println("2. Servir pedido");
            System.out.println("3. Ver pendientes");
            System.out.println("4. Ver caja");
            System.out.println("5. Salir del menu");
            System.out.print("Que eliges? ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1->{
                    System.out.println("Introduzca nombre para pedido: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Introduzca el tamnio (s/m/xl) de la pizza: ");
                    String tamanio = scanner.nextLine().toLowerCase();
                    System.out.println("Introduzca los ingredientes que quiereis en la pizza: ");
                    ArrayList<String> ingred = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Ingredientes disponibles -> queso, chorizo, jamon, salsa, carne");
                        String ingrediente = scanner.nextLine().toLowerCase();
                        ingred.add(ingrediente);
                    }
                    pizzas.Pedido(nombre,tamanio,ingred);
                }
                case 2->{pizzas.servirPedido();}
                case 3->{pizzas.verPedido();}
                case 4->{pizzas.verCaja();}
                case 5->{
                    System.out.println("Saliendo...");
                }
                default -> {System.out.println("Todavia no hay elementos conectados a ese numero");}
            }
        } while (opcion!=5);




    }
}
