import java.util.Scanner;

public class Ejercicio6 {


    public void ejercicio6(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.println("Introduzca cueal quier numero de 1 al 12 para " +
                "seber estacion del año");
        int numero = lectorTeclado.nextInt();

        switch (numero) {
            case 1, 2, 12:
                System.out.println("Es invierno ");
                break;
            case 3, 4, 5:
                System.out.println("Es primavera ");
                break;
            case 6, 7, 8:
                System.out.println("Es verano ");
                break;
            case 9, 10, 11:
                System.out.println("Es otoño ");
                break;
            default:
                System.out.println("Error el numero no corresponde al estacion de mes");

        }
    }
}
