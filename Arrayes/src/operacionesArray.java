import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class operacionesArray {
    int[] temperaturas;
    String[] amigos;

    public void iniciarArray() {
        //int[] numeros = new int[3];
        //int[] numeros = new int[]{8, 9, 5};
        int[] numeros = {5, 9, 10, 20};
        //  System.out.println(numeros);
        // {1,9,10,20}
        numeros[0] = 1;
        // {1,9,10,15}
        numeros[3] = 15;
        //System.out.println("La longitud del array es " + numeros[numeros.length -1]);
        //System.out.println("El primer numero  es " + numeros[1]);
        //System.out.println("El ultimo numero  es " + numeros[3]);

        System.out.println("Usando foreach ");
        for (int item : numeros) {
            if (item == 10) {
                item = 100;
            }
            System.out.println("El elemento recorido es " + item);
        }
        System.out.println("Usando for ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("El elemento de posicion " + i + " es " + numeros[i]);
        }


    }

    public void realizarBusqueda() {

        int[] numeros = {1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};


        /*boolean esta = false;

        for (int item : numeros){
            if (item == 70){
                System.out.println("Encontrado");
                esta = true;
                break;
            }
        }

        if (!esta){
            System.out.println("no esta el elemento");
        }


         */
        if (estaElemento(10, numeros)) {
            System.out.println("El numero esta ");
        } else {
            System.out.println("El numero no esta ");
        }


    }

    public boolean estaElemento(int numeroBuscar, int[] arrayBuscar) {
        for (int item : arrayBuscar) {
            if (item == numeroBuscar) {
                return true;
            }
        }
        return false;
    }
    // pedir al usuario cuantas temperaturas va a introducir.10
    // pido las 10 temperaturas y las quardo
    // que quieres hacer
    // 1. Sacar temperatura max
    // 2. Sacar temperatura min
    // 3. Sacar temperatura media
    // 4. Contarar cuantas temperaturas-> 23 -> 5yeces 23
    // 5. listar todas las temperaturas
    // NO SE PUEDEN METER TEMPERARURAS NEGATIVAS
    // En caso de introducir una temperatura negativa volvera

    public void ejercicio() {
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.println("Cuantas temoperaturas ");
        int numerotemperaturas = lectorTeclado.nextInt();
        temperaturas = new int[numerotemperaturas];

        for (int i = 0; i < numerotemperaturas; i++) {
            System.out.println("Introduzca temperaturas ");
            int temperatura;
            do {
                temperatura = lectorTeclado.nextInt();
                if (temperatura < 0) {
                    System.out.println("Incorecto introduzca temperatura positiva ");
                }
            } while (temperatura < 0);
            temperaturas[i] = temperatura;
        }

        int opcion;
        do {
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("1. Sacar temperatura max");
            System.out.println("2. Sacar temperatura min");
            System.out.println("3. Sacar temperatura media");
            System.out.println("4. Contarar cuantas temperaturas");
            System.out.println("5. listar todas las temperaturas");
            System.out.println("6. Salir ");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("\nQue eliges? ");

            Arrays.sort(temperaturas);
            for (int item : temperaturas) {
            }

            int max = temperaturas[temperaturas.length - 1], min = temperaturas[0];
            opcion = lectorTeclado.nextInt();
            double resultado;
            switch (opcion) {
                case 1 -> {
                    System.out.println("Temperatura maxima es " + max);
                }
                case 2 -> {
                    System.out.println("temperatura minimo es " + min);
                }
                case 3 -> {
                    double suma = 0;
                    for (int item : temperaturas) {
                        suma += item;

                        resultado = suma / temperaturas.length;
                        System.out.println("La media es " + resultado);
                    }
                }
                case 4 -> {

                }
                case 5 -> {
                    for (int item : temperaturas) {
                        System.out.println(item + " ");
                    }
                }
                case 6 -> {
                    System.out.println("Saliendo del programa ");
                }
                default -> {
                    System.out.println("Elegiste opcion no valida");
                }
            }
        } while (opcion != 6);
    }

    //dime que direccion quieres rotar 1.izquierda 2.derecha
    public void lst() {
        Scanner lectorTeclado = new Scanner(System.in);
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int opcion = 0;
        do {
            System.out.println("1. quiers rotar numeros a la izquierda: ");
            System.out.println("2. quiers rotar numeros a la derecha: ");
            System.out.println("3. quieres que te mostra la lista: ");
            System.out.println("4. Salir");
            opcion = lectorTeclado.nextInt();
            switch (opcion) {
                case 1 -> {
                    int aux = numeros[0];
                    for (int i = 0; i < numeros.length - 1; i++) {
                        numeros[i] = numeros[i + 1];
                    }
                    numeros[numeros.length - 1] = aux;
                }
                case 2 -> {
                    int aux = numeros[numeros.length - 1];
                    for (int i = numeros.length - 1; i > 0; i--) {
                        numeros[i] = numeros[i - 1];
                    }
                    numeros[0] = aux;
                }
                case 3 -> {
                    for (int item : numeros) {
                        System.out.print(item + " ");
                    }
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Saliendo ");
                }
                default -> {
                    System.out.println("no hay");
                }
            }
        } while (opcion != 4);
    }

    public void ejercicioInversa() {

        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < numeros.length / 2; i++) {
            //System.out.println(numeros[i]);
            int auxiliar = numeros[i];
            numeros[i] = numeros[numeros.length - 1 - i];
            numeros[numeros.length - 1 - i] = auxiliar;
        }
    }

    public void ejercicioRotacionPares() {
        int[] numeros = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < numeros.length; i += 2) {
            int aux = numeros[i];
            numeros[i] = numeros[i + 1];
            numeros[i + 1] = aux;
        }
    }

    public void amigoAmigoInvisible() {

        //El programa pide cuantos amigos entran en la bolsa
        // si me dicen qe los amigos son inpares, vuelvo a pedir numeros de amigos
        // hasta que no me digan un par no continua
        //10
        //2. pide los nombres de 10 amigos
        // no pone dos nimbres iguales
        // si mete un nombre igual, me pide nuevamente el nombre
        //3. se realiza un sorteo
        // hace parejas y las muesttras -> Borja - maria
        //hace parejas y las muestra -> juan - paco
        Scanner lectorTeclado = new Scanner(System.in);
        int numeroDeAmidos = 0;

        do {
            System.out.println("numero de personas ");
            numeroDeAmidos = lectorTeclado.nextInt();
            if (numeroDeAmidos % 2 != 0) {
                System.out.println("Cantidad de sitios tiene que ser par: ");
            }

        } while (numeroDeAmidos % 2 != 0);

        amigos = new String[numeroDeAmidos];

        for (int i = 0; i < amigos.length; i++) {
            System.out.print("Introduce el nombre del amigo " + (i + 1) + ": ");
            String nombre = lectorTeclado.next();

            if (estaNombre(nombre)) {
                System.out.println("Ya has entrodusido este nombre ");
                i--;
            } else {
                amigos[i] = nombre;
            }
        }

        for (int i = 0; i < 10; i++) {
            agruparAmigos();
        }


        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("Resultado del sorteo: ");
        for (int i = 0; i < amigos.length; i += 2) {
            System.out.println(amigos[i] + " regala a " + amigos[i + 1]);
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-");

    }

    private boolean estaNombre(String nombre) {

        for (String item : amigos) {
            if (item != null && item.equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    private void agruparAmigos() {
        for (int i = amigos.length - 1; i > 0; i--) {
            int ex = (int) (Math.random() * amigos.length);
            String aux = amigos[i];
            amigos[i] = amigos[ex];
            amigos[ex] = aux;
        }
    }

    
}
