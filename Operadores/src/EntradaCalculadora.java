import java.util.Scanner;

public class EntradaCalculadora {
    public static void main(String[] args) {
        Scanner lecTec = new Scanner(System.in);
        OperacionesDeCalculadora operaciones = new OperacionesDeCalculadora();
        int opcion;
        int op1 = 0, op2 = 0;
        int resultado = 0;
        do {
            System.out.println("Que quieres elegir: ");
            System.out.println("1. Sumar ");
            System.out.println("2. Restar ");
            System.out.println("3. Multiplicar ");
            System.out.println("4. Dividir ");
            System.out.println("5. Salir ");

            opcion = lecTec.nextInt();
            if (opcion > 0 && opcion < 5){
                System.out.println("Numero 1: ");
                op1 = lecTec.nextInt();
                System.out.println("Numero 2: ");
                op2 = lecTec.nextInt();
                System.out.println("Vamos a calcular");
            } else {
                System.out.println("Todavia no hay esta opcion");
                break;
            }

            switch (opcion){
                case 1:
                    System.out.println("El resultado de la suma es " +operaciones.sumar(op1,op2));
                    break;
                case 2:
                    if (operaciones.restar(op1,op2) != null) {
                        System.out.println("El resultado de la suma es " + operaciones.restar(op1, op2));
                    } else {
                        System.out.println("No se podia reallizar la resta ");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println();

            }
        } while (opcion != 5);


    }
}
