import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        int numeros, numerosPares = 0;
        do {
            numeros = (int)(Math.random()*1001);
            System.out.println("numero generasdo " + numeros);

            if (numeros % 2 == 0){
                numerosPares++;
            }

        } while (numeros != 0);
        System.out.println("Numeros pares sale " + numerosPares);





    }
}
