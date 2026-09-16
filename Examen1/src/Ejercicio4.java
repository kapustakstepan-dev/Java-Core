import java.util.Scanner;

public class Ejercicio4 {


    public void ejercicio4(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.println("Introduzca tu nombre y apellido: ");
        String nombre_comp = lectorTeclado.nextLine();

        System.out.println("Que sueldo esperas resibir: ");
        int sueldo = lectorTeclado.nextInt();

        System.out.println("Introduzca tu edad: ");
        int edad = lectorTeclado.nextInt();

        System.out.println("introduzca dia de tu cumple de 1 al 31: ");
        int cumple = lectorTeclado.nextInt();

        System.out.println("Tienes carne de conducir (si o no): ");
        String carne = lectorTeclado.nextLine();

        

        if (edad < 50 && sueldo < 40000 && carne.equals("si")){
            System.out.println("Has cumplido lascondiciones eres valido");
        } else if (edad > 45 && sueldo < 20000  && cumple %2 == 0 && (carne.equals("no") || carne.equals("si")) ) {
            System.out.println("Has cumplido lascondiciones eres valido");
        }

    }
}
