import java.util.Scanner;

public class EntradaMenu {
    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);
            int opcion;
            int operador1 = 0 ,operador2 = 0;
            double resultado = 0;
        do {
            System.out.println("1. Sumar: ");
            System.out.println("2. Restar: ");
            System.out.println("3. Multiplicar: ");
            System.out.println("4. Dividir: ");
            System.out.println("5. Salir: ");
            System.out.println("Que quieres hacer: ");
            opcion = lectorTeclado.nextInt();
            if (opcion > 0 && opcion <5){
                System.out.println("introduzca primer operador: ");
                operador1 = lectorTeclado.nextInt();
                System.out.println("introduzca segundo operador: ");
                operador2 = lectorTeclado.nextInt();
            }
            switch (opcion){
                case 1:
                    System.out.println("Selecccionaste Sumar ");
                    resultado = operador1 + operador2;
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Selecccionaste Restar ");
                    resultado = operador1 - operador2;
                    break;
                case 3:
                    System.out.println("Selecccionaste Multiplicar ");
                    resultado = operador1 * operador2;
                    break;
                case 4:
                    System.out.println("Selecccionaste Dividir ");
                    resultado = (double) operador1 / operador2;
                    break;
                case 5:
                    System.out.println("Selecccionaste Salir ");
                    break;
                default:
                    System.out.println("Caso no complentado");
            }
            if (opcion > 0 && opcion <5) {
                System.out.println("El resultado es: " + resultado);
            }
        } while (opcion != 5);
        System.out.println("Terminando el programa...");

    }
}
