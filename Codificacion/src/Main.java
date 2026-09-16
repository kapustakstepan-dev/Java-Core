import controller.Gestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Gestor gestor = new Gestor();
        int opcion;

        do {
            System.out.println("1-Codificacion");
            System.out.println("2-Decodifiar");
            System.out.println("3-Bin text to ASCII");
            System.out.println("4-Salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1->{
                    System.out.println("Introdizca el mensaje");
                    String mensaje = bufferedReader.readLine();
                    System.out.println("Indica cual es la face");
                    int face = bufferedReader.read();
                    gestor.codificar(mensaje, face);
                }
                case 2->{
                    System.out.println("Indica cual es la face de decifrando");
                    int face = bufferedReader.read();
                    gestor.decodificar(face);
                }
                case 3->{
                    System.out.println("Introdizca el mensaje");
                    String mensaje = bufferedReader.readLine();
                    System.out.println("Indica cual es la face");
                    int face = bufferedReader.read();
                    gestor.encriptar(mensaje, face);
                }
                case 4->{
                    gestor.desencriptar();
                }
            }

        } while (opcion!=5);








    }
}