import java.util.Scanner;

public class Ejercicios {

    public void ejercicio1(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.println("Escribe tu nombre y apellido: ");
        String nombre_completo = lectorTeclado.nextLine();

        System.out.println("Que cantidad de dinero tienes: ");
        int dinero = lectorTeclado.nextInt();

        System.out.println("Cuanto cuesta play 5 que quieres comprar pero sin IVA: ");
        double cuesta_pc5 = lectorTeclado.nextDouble();

        System.out.println("Cuanto cuesta iPhone 15 que quieres comprar pero sin IVA: ");
        double cuesta_iPhone15 = lectorTeclado.nextDouble();

        System.out.println("Puedes escribir IVA acticual: ");
        int IVA = lectorTeclado.nextInt();

        double tot_pc5 = cuesta_pc5 + ((cuesta_pc5 * IVA) / 100);
        double tot_ip15 = cuesta_iPhone15 + ((cuesta_iPhone15 * IVA) / 100);

        boolean puede_pc5 = dinero > tot_pc5;
        boolean puede_ip15 = dinero > tot_ip15;
        boolean puede_tod = dinero > (tot_pc5 + tot_ip15);

        System.out.println(nombre_completo + " puede comprar la play: " + puede_pc5 +
                "\nTe puedes comprar el iphone: " + puede_ip15 +
                "\nTe puedes comprar las dos cosas: " + puede_tod);

    }
}
