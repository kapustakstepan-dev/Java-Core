import java.util.Scanner;

public class EstructuraDoWhile {
    public static void main(String[] args) {

        Scanner lectorTeccclado = new Scanner(System.in);
        /*int numeroLeido;
        do {
            System.out.println("Introduzca el numer: " );
            numeroLeido = lectorTeccclado.nextInt();
            System.out.println("Ejecutando cosas de do ");
        } while (numeroLeido != -1);


         */

/*        String palabras;
        do {
            System.out.println("Introduzca palabra o palabras: ");
            palabras = lectorTeccclado.next();
        } while (palabras.length() != 10);
            System.out.println("tiene mas de 10 letras");



 */
        String contrasena = "programacion";
        int intentos = 0;
        String contrUsuario;

        do {
            System.out.println("Introduzca la contracenia: ");
            contrUsuario = lectorTeccclado.next();
            intentos++;
            if (contrUsuario.equalsIgnoreCase(contrasena)){
                System.out.println("Palabra secreta, has abuerto la caja. ");
                break;
            }
            if (intentos == 5) {
                System.out.println("Caja bloqueada");
            }
        } while (intentos < 5);

        System.out.println("Terminando programa de palabra secreta ");




    }
}
