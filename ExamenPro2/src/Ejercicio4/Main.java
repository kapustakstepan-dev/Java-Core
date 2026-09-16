package Ejercicio4;

import Ejercicio3.Ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*Ejercico4 ejercicio4 = new Ejercico4();
        ejercicio4.tabla();

        int opcion = 0;
        do {
            System.out.println("---MENU---");
            System.out.println("Añadir contactos: ");
            System.out.println("Listar personas: ");
            System.out.println("Buscar personas: ");
            System.out.println("salir");
            System.out.println("Que eliges:");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1 ->{
                    System.out.println("introduzca nombre");
                    String nombre = scanner.next();
                    System.out.println("introduzca telefono");
                    int telefono = scanner.nextInt();
                    System.out.println("introduzca corro");
                    String correo = scanner.next();
                    ejercicio4.agregarPersonas(nombre,telefono,correo);

                }
                case 2 ->{ejercicio4.listar();
                    }
                case 3 ->{System.out.println("Introduzca el nombre para buscarlo ");
                    String nombre = scanner.next();
                    ejercicio4.obtenerInfo(nombre);

                }





            }
        } while (opcion != 4);
        System.out.println("saliendo...");

         */
        Ejercico4 eje = new Ejercico4();
        eje.listarContactos();
        int opcion;

        /*System.out.println("Indica el nombre");
        String nombre = scanner.next();
        System.out.println("Indica el correo");
        String correo = scanner.next();
        System.out.println("Indica el numero");
        int numero = scanner.nextInt();
        System.out.println("Indica el anios");
        int anios = scanner.nextInt();
        eje.aniadirContactoe(new Object[]{nombre, correo, numero, anios});*/
        /*eje.aniadirContactoe(new Object[]{"Stepan1", "stepankapustiak1@gmail.com", 123123, 30});
        eje.aniadirContactoe(new Object[]{"Stepan2", "stepankapustiak2@gmail.com", 123123, 30});
        eje.aniadirContactoe(new Object[]{"Stepan2", "stepankapustiak2@gmail.com", 123123, 30});
        eje.listarContactos();*/

        do {
            System.out.println("1.Aniadir");
            System.out.println("2.Listar");
            System.out.println("3.Buscar");
            System.out.println("4.Eliminar");
            System.out.println("5.Ordenar");
            System.out.println("6.Vasiar");
            System.out.println("7.Comparar por edad");
            opcion = scanner.nextInt();
            switch (opcion){

                case 1->{
                    System.out.println("Indica el nombre");
                    String nombre = scanner.next();
                    System.out.println("Indica el correo");
                    String correo = scanner.next();
                    System.out.println("Indica el numero");
                    int numero = scanner.nextInt();
                    System.out.println("Indica el edad");
                    int edad = scanner.nextInt();
                    eje.aniadirContactoe(new Object[]{nombre, correo, numero, edad});
                }
                case 2->{eje.listarContactos();}
                case 3->{
                    System.out.println("Dime que nombre quieres buscar");
                    String nombre = scanner.next();
                    Object[] contactoBuscado = eje.buscarContactoNombre(nombre);
                    if (contactoBuscado!= null){
                        System.out.println("Imprimiendo los datos");
                        for (Object item : contactoBuscado){
                            System.out.println("\t" + item);
                        }
                    } else {
                        System.out.println("Coontato no encontrado ");
                    }

                }
                case 4->{
                    System.out.println("Indica el correo ");
                    String correo = scanner.next();
                    eje.eliminarObject(correo);
                }
                case 5->{
                    eje.ordenarListaEdad();
                }
                case 6->{eje.vaciarLista();}
                case 7->{eje.compararPorEdad();}


            }

        } while (opcion!=8);









    }
}
