import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);

        //variable de control, defino dentro de for
        //el final  del control
        // el incremento de la variable de control
        // rango actual [0, 9]
        // rango actual [0, 10]
       /* System.out.println("rango incremental");
        for (int i = 0; i < 10; i += 2) {
            System.out.printf("%d-Ejecutacion del for%n", i);

        }
        System.out.println("rango decremental");
        for (int i = 4; i >= 0; i--) {
            System.out.printf("%d-Ejecutacion del for%n", i);

        }
*/
        /*for (int i = 0; i <= 10; i ++) {
            System.out.printf("la  tabla es %d es:%n", i);
            for (int j = 0; j < 10; j++) {
                System.out.printf("\t%d * %d = %d%n", i, j, j * i);
            }
        }
*/


        /*System.out.println("Introduzca ena frase  paracontar las vocales: ");
        String frase = lectorTeclado.nextLine().toLowerCase();

        int conVocales = 0;

        for (int i = 0; i < frase.length() ; i++) {
            char d = frase.charAt(i);
            if ( d == 'a' || d == 'u' || d == 'i' || d == 'o') {
                conVocales ++;
            }
        }
        System.out.println("la fras tiene " + conVocales + " vocales");

         */
/*
        String frase = "Alli ves sevilla";

        frase = frase.toLowerCase().replaceAll(" ", "");

        boolean esPalindromo = false;

        for (int i = 0; i < frase.length() / 2; i++) {
            if (frase.charAt(i) == frase.charAt(frase.length() -1 -i)) {
                esPalindromo = true;
            } else {
                esPalindromo = false;
                System.out.println("La palabra no es palindromo ");
                break;
            }

        }
        if (esPalindromo){
            System.out.println("La palabra es polindromo ");

        }


 */

/*
        int numeroCaja = (int) (Math.random() * 1001);

        System.out.println("Cuantos intentos quieres: ");
        int numInten = lectorTeclado.nextInt();

        for (int i = 1; i <= numInten + 1; i++) {
            System.out.println("Introduzca un numero de 0 al 1000: ");
            int numero = lectorTeclado.nextInt();
            if (numero == numeroCaja){
                System.out.println("Coencide, has ganado intento " + i);
                break;
            } else {
                System.out.println("No coencide, pruebe otra vez " + i);
            }
        }

 */

        //int [] numero = new int[4];
        // [nº] -> nº numero de vuecos que quiero usar en un list
        //int[] numeros = new int[] {8, 7, 4, 9, 3};

        int[] lst = {4, 7, 9, 2, 1};
        //System.out.println(lst.length);
        // cantidad de numeros
        //System.out.println(lst[lst.length - 1]);
        // saca el numero ultimo de la lista


        //saca numeros index par
/*      for (int i = 0; i < lst.length; i++) {
            System.out.println(lst[i]);
            if (i % 2 == 0){
                System.out.println("numeros en un index par " + i);
            }

        }

 */
        // saca numeros pares dentro de lst
        for ( int item : lst) {
            if (item % 2 == 0){
                System.out.println(item);
            }
        }


    }
}
