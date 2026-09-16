import java.util.Scanner;

public class Ejerciicio1 {


    public static void main(String[] args) {

       Scanner lectorTeclado = new Scanner(System.in);

        int numero = 0;
        int contadorPositivos = 0;
        do {
            System.out.println("Introduzca un numero: ");
            numero = lectorTeclado.nextInt();

            if (numero % 2 == 0 && numero > 0){
                contadorPositivos++;
            }

        } while (numero % 2 == 0);
        System.out.println("Numeros positivos " + contadorPositivos);




    }
}
