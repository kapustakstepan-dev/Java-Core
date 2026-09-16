import java.util.ArrayList;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        pizzas2 pizzas2 = new pizzas2();
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
                    System.out.println("Inntrodusca nombre ");
                    String nombre  = scanner.nextLine();
                    System.out.println("Inntrodusca tamanio s/m/xl ");
                    String tamanio  = scanner.nextLine().toLowerCase();
                    ArrayList<String> ingred = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Ingredientes disponibles -> queso, chorizo, jamon, salsa, carne");
                        String masIngredientes = scanner.nextLine();
                        ingred.add(masIngredientes);
                    }
                    pizzas2.pedido(nombre,tamanio, ingred);
                }
                case 2->{pizzas2.servirPedido();}
                case 3->{pizzas2.verPedido();}
                case 4->{pizzas2.verCaja();}
                case 5->{
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opcion no valida");
                }

            }
        } while (opcion != 5);
    }
}
