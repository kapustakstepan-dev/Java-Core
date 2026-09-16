import Modulo.Circuito;
import Modulo.Cuadrado;
import Modulo.Triangulo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Triángulo ");
            System.out.println("2. Círculo");
            System.out.println("3. Cuadrado");
            System.out.println("4. Salir del aplicacion ");
            System.out.println("Con que figura quieres trabajar? ");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1->{

                    System.out.println("para calcular area del Circuito introduzca los datos");
                    System.out.println("Introduzca radio");
                    int radio = scanner.nextInt();
                    Circuito circuito = new Circuito(radio);
                    System.out.println("Los datos del circuito son: ");
                    circuito.mostrarDatos();

                }
                case 2->{
                    System.out.println("para calcular area del Triangulo introduzca los datos");
                    System.out.println("Introduzca la base");
                    int base = scanner.nextInt();
                    System.out.println("Introduzca la altura");
                    int altura = scanner.nextInt();
                    Triangulo triangulo = new Triangulo(base, altura);
                    System.out.println("Los datos del triangulo son: ");
                    triangulo.mostrarDatos();


                }
                case 3->{
                    System.out.println("para calcular area del Cuadrado introduzca los datos");
                    System.out.println("Introduzca base");
                    int base = scanner.nextInt();
                    System.out.println("Introduzca altura");
                    int altura = scanner.nextInt();
                    Cuadrado cuadrado = new Cuadrado(base, altura);
                    System.out.println("Los datos del cuadrado son: ");
                    cuadrado.mostrarDatos();

                }
                case 4->{
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opcion no valida");
                }
            }

        } while (opcion != 4);
    }
}
