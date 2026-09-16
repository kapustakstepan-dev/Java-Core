import java.util.Scanner;

public class Ejercicio5 {

    public void ejercicio5(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.println("Introduzca tu nombre y apellido ");
        String nombre = lectorTeclado.nextLine();

        System.out.println("1. Hamburguesa\n" +
                "2. Pizza\n" +
                "3. Ensalada\n" +
                "Elige el numero: ");
        int numero = lectorTeclado.nextInt();

        double cuesta = 0;

        switch (numero) {
            case 1:
                cuesta = 6.5;
                System.out.println("Hamburguesa cuesta: " + cuesta + " euros");
                break;
            case 2:
                cuesta = 7.0;
                System.out.println("Pizza cuesta: " + cuesta + " euros");
                break;
            case 3:
                cuesta = 5.0;
                System.out.println("Ensalada cuesta: " + cuesta + " euros");
                break;
            default:
                System.out.println("Error el numero ni corresponde a ningun pedido");
        }


    }


}
