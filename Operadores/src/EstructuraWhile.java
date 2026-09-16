import java.util.Scanner;

public class EstructuraWhile {
    public static void main(String[] args) {

        /*int numero = 5;
        boolean condicion = true;
        while (condicion) {
            //cuerpo de repiticion
            System.out.println("Repepitiendo el bucle while ");
            //condicion = false;
            break;
        }


         */
        Scanner lectorTeclado = new Scanner(System.in);
        /*System.out.println("Cuamtas veses cuieres ejecutar ");
        int numero = lectorTeclado.nextInt();
        boolean condicion = true;
        while (numero > 0) {

            //cuerpo de repiticion
            System.out.println("Repepitiendo el bucle while ");
            //condicion = false;
            numero --;

        }

         */


        int contadorPares = 0;
        int contadorInpares = 0;
        int contadorNumeros = 0;
        int numeroLeido = 0;
        int sumatorio = 0;
        double media;

        while (numeroLeido >= 0) {
            System.out.println("Introduse el numero: ");
            numeroLeido = lectorTeclado.nextInt();
            if (numeroLeido >= 0){
                sumatorio += numeroLeido;
                contadorNumeros ++;
                if (numeroLeido % 2 == 0){

                } else {
                    contadorInpares ++;
                }
            }
        }
        media = (double) sumatorio / contadorNumeros;
        System.out.println("Numero de positivis leidos " + numeroLeido);
        System.out.println("Numero de pares leidos " + contadorPares);
        System.out.println("Numero de sumario es " + sumatorio);
        System.out.println("El numero media es " + media);



    }
}
