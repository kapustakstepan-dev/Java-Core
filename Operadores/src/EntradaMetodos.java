import java.util.Scanner;

public class EntradaMetodos {
    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);
        String palabra = "Ejemplo";
        OperacionesMatematicos operaciones = new OperacionesMatematicos();
        operaciones.realizarSaludo("Borja");

        System.out.println("Numero 1: ");
        int op1 = lectorTeclado.nextInt();

        System.out.println("Numero 2: ");
        int op2 = lectorTeclado.nextInt();
        // En caso de sumar y que el resultado sea par, pon mendsaje suma corecta
        // En caso de sumar y que el resultado sea inpar, pon mendsaje suma incorecta
       /* if (operaciones.realizarSuma(op1, op2) % 2 == 0){
            System.out.println("La suma es par ");
        } else {
            System.out.println("La suma es inpar");
        }
        */

        operaciones.realizarSuma(8, -9);
        /*if (operaciones.numerosValidos(op1, op2)){
            System.out.println("Los nunmeros son validos");
        } else {
            System.out.println("Los numeros no son valisdos ");
        }


         */




    }
}
