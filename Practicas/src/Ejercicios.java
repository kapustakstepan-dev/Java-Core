import java.util.*;

public class Ejercicios {
    private Scanner scanner = new Scanner(System.in);

    public void ejercicio1() {
        Scanner lectorTeclado = new Scanner(System.in);

        int numeros = 0;
        int cont = 0;
        do {
            System.out.println("Introduzca los numero: ");
            numeros = lectorTeclado.nextInt();

            if (numeros % 2 == 0) {
                cont++;
            } else if (numeros % 2 != 0) {
                break;
            }
        } while (true);
        System.out.println("la cantidad de pares " + cont);
    }

    public void ejercicio2() {
        Scanner lectorTeclado = new Scanner(System.in);

        int numeros = 0;
        int contador = 0;
        do {
            numeros = (int) (Math.random() * 1001);
            System.out.println("numero generado " + numeros);

            if (numeros != 0 && numeros % 2 == 0) {
                contador++;
            }

        } while (numeros != 0);
        System.out.println(contador);


    }

    public void ejercicio3() {
        Scanner lectorTeclado = new Scanner(System.in);

        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduzca los numeros: ");
            numeros[i] = lectorTeclado.nextInt();
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("[%d] %d%n", i, numeros[i]);
        }
    }

    public void ejercicio4() {
        int[] numAlea = new int[30];
        for (int i = 1; i < 30; i++) {
            numAlea[i] = (int) (Math.random() * 11);
        }
        int suma = Arrays.stream(numAlea).sum();
        double media = (double) suma / numAlea.length;
        System.out.println("Puntos: " + numAlea.length);
        System.out.print("Valores: ");
        for (int i = 0; i < numAlea.length; i++) {
            System.out.print(numAlea[i]);
            if (i < numAlea.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.printf("%nMedia: %.2f%n", media);
    }

    public void ejercicio5() {
        Scanner lectorTeclado = new Scanner(System.in);

        int[] numeros1 = new int[10];

        for (int i = 0; i < numeros1.length; i++) {
            System.out.println("Introduzca numero: " + (i + 1) + ": ");
            numeros1[i] = lectorTeclado.nextInt();
        }
        int[] numeros2 = Arrays.copyOf(numeros1, 10);

        for (int i = 0; i < numeros2.length / 2; i++) {
            int aux = numeros2[i];
            numeros2[i] = numeros2[numeros2.length - 1 - i];
            numeros2[numeros2.length - 1 - i] = aux;
        }
        System.out.print("Orden normal: ");
        for (int i = 0; i < numeros1.length; i++) {
            System.out.print(numeros1[i] + " ");
        }
        System.out.println();

        System.out.print("Orden inverso: ");
        for (int i = 0; i < numeros2.length; i++) {
            System.out.print(numeros2[i] + " ");
        }
    }

    public void ejercicio6() {
        int[] numerosNorm = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] numerosCuad = Arrays.copyOf(numerosNorm, 20);
        int[] numerosCubo = Arrays.copyOf(numerosNorm, 20);

        for (int i = 0; i < numerosCuad.length; i++) {
            numerosCuad[i] = numerosCuad[i] * numerosCuad[i];
        }
        for (int i = 0; i < numerosCubo.length; i++) {
            numerosCubo[i] = numerosCubo[i] * numerosCubo[i] * numerosCubo[i];
        }


        System.out.printf(" %-5s  %-7s  %-7s%n ", "num", "cuad ", "cubo");
        for (int i = 0; i < numerosNorm.length; i++) {
            System.out.printf("%-5d  %-7d  %d%n ", numerosNorm[i], numerosCuad[i], numerosCubo[i]);
        }
    }

    public void ejercicio7() {
        Scanner lectorTeclado = new Scanner(System.in);

        int[] numeros = new int[8];

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduzca numeros interos: ");
            numeros[i] = lectorTeclado.nextInt();
        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.printf("%d %s%n", numeros[i], "par");
            } else if (numeros[i] % 2 != 0) {
                System.out.printf("%d %s%n", numeros[i], "impar");
            }
        }
    }

    public void ejercicio8() {
        int[] numeros = new int[20];
        int modificaciones = 0;

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 31);
        }

        System.out.println("Entrada");
        System.out.print("Array inicial: ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == 6) {
                numeros[i] = 8;
                modificaciones++;
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        System.out.println();
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == 7) {
                numeros[i] = 15;
                modificaciones++;
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == 20) {
                numeros[i] = 10;
                modificaciones++;
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                numeros[i] = numeros[i] - 1;
                modificaciones++;
            }
        }
        System.out.println("Salida");
        System.out.print("Array final: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("Modificaciones realizadas: " + modificaciones);
    }

    public void ejercicio9() {
        Scanner lectorTeclado = new Scanner(System.in);
        String[] palabras = new String[10];

        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Introduzca palabra: ");
            palabras[i] = lectorTeclado.next();
        }

        int opcion = 0;

        do {
            System.out.println("1. ");
        } while (opcion != 7);
    }

    public void ejercicioex1() {
        Scanner lectorTeclado = new Scanner(System.in);
        int opcion;
        int operador1 = 0, operador2 = 0;
        double resultado;

        do {
            System.out.print("Introduce el primer número: ");
            operador1 = lectorTeclado.nextInt();
            System.out.print("Introduce el segundo número: ");
            operador2 = lectorTeclado.nextInt();

            System.out.println("*-*-*-*-*-*-*-*-*");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            System.out.println("*-*-*-*-*-*-*-*-*");
            System.out.print("Elige una opción: ");
            opcion = lectorTeclado.nextInt();

            if (operador1 >= 0 && operador2 >= 0) {
                switch (opcion) {
                    case 1 -> {
                        resultado = operador1 + operador2;
                        System.out.println("Resultado es -> " + resultado);
                    }
                    case 2 -> {
                        resultado = operador1 - operador2;
                        System.out.println("Resultado es -> " + resultado);
                    }
                    case 3 -> {
                        resultado = operador1 * operador2;
                        System.out.println("Resultado es -> " + resultado);
                    }
                    case 4 -> {
                        if (operador2 == 0) {
                            System.out.println("No se puede dividir entre cero.");
                        } else {
                            resultado = (double) operador1 / operador2;
                            System.out.println("Resultado de la división: " + resultado);
                        }
                    }
                    case 5 -> {
                        System.out.println("Saliendo del programa");
                    }
                    default -> {
                        System.out.println("Error");
                    }
                }

            } else {
                System.out.println("No se pueden realizar operaciones con números negativos.");
            }
        } while (opcion != 5);
        lectorTeclado.close();
    }

    public void ejercicioex2() {
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.println("introduzca un numero etre 1 y 100 para jugar al bonoloto: ");
        int numeroUsuario = lectorTeclado.nextInt();

        if (numeroUsuario > 0 && numeroUsuario <= 100) {

            int[] numeroRandom = new int[10];

            for (int i = 1; i < numeroRandom.length; i++) {
                numeroRandom[i] = (int) (Math.random() * 101);
            }
            System.out.println("numeros generados: ");
            for (int i = 1; i < numeroRandom.length; i++) {
                System.out.print(numeroRandom[i] + " ");
            }
            System.out.println();

            int numeroGrande = Arrays.stream(numeroRandom).max().getAsInt();
            System.out.println("es " + numeroGrande);
            int numeroPequenio = Arrays.stream(numeroRandom).min().getAsInt();
            System.out.println(numeroPequenio);
            double numeroMedio = Arrays.stream(numeroRandom).average().getAsDouble();
            System.out.printf("%.0f%n", numeroMedio);
            int suma = Arrays.stream(numeroRandom).sum();
            System.out.println(suma);

            boolean encontrado = false;

            for (int item : numeroRandom) {
                if (item == numeroUsuario) {
                    encontrado = true;
                }
            }
            System.out.println("El numero encontrado en bonoloto " + encontrado);
        } else {
            System.out.println("El numero tiene que ser entre 0 y 100 ");
        }

    }

    public void cambiarDecimal( int base) {
        int resultado = 0;
        System.out.println("Introduzca numero binario: ");
        String numeroOriginal = scanner.next();
        System.out.println("introduzca en que base (2/8/16)");

        for (int i = 0; i < numeroOriginal.length(); i++) {
            String numeroSTR = String.valueOf(numeroOriginal.charAt(i));
            int numeroInd = Integer.parseInt(numeroSTR);
            System.out.println(numeroSTR);
            resultado += numeroInd * Math.pow(base, (numeroOriginal.length() - 1 - i));
            if (base == 16) {
                if (Character.isDigit(numeroOriginal.charAt(i))) {
                    numeroInd = Integer.parseInt(numeroSTR);

                } else {
                    switch (numeroOriginal.charAt(i)) {
                        case 'A' -> {
                            numeroInd = 10;
                        }
                        case 'B' -> {
                            numeroInd = 11;
                        }
                        case 'C' -> {
                            numeroInd = 12;
                        }
                        case 'D' -> {
                            numeroInd = 13;
                        }
                        case 'E' -> {
                            numeroInd = 14;
                        }
                        case 'F' -> {
                            numeroInd = 15;
                        }
                    }
                }
            } else {
                numeroInd = Integer.parseInt(numeroSTR);
            }
            resultado += numeroInd * Math.pow(base, (numeroOriginal.length() - 1 - i));
        }
        System.out.println("El resultado es " + resultado);

    }

    public void ejer7() {
        Scanner sc = new Scanner(System.in);

        String[] palabras = new String[10];
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Introduzca una palabra: ");
            palabras[i] = sc.next();
        }
        int opcion = 0;
        do {
            System.out.println("*--**-*-*-*-*-*-*-*");
            System.out.println("1.Ver todas las palabras ");
            System.out.println("2.Obtener una palabra al azar");
            System.out.println("3.Ver número total de letras entre todas las palabras ");
            System.out.println("4.Ver media de letras");
            System.out.println("5.Ver palabra con más letras");
            System.out.println("6.Ver palabra con menos letras");
            System.out.println("7.Salir");
            System.out.println("*--**-*-*-*-*-*-*-*");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    for (String item : palabras) {
                        System.out.println(item);
                    }
                }
                case 2 -> {
                    for (int i = 0; i < palabras.length; i++) {
                        int pocicionPalabra = (int) (Math.random() * 10);
                        String pocicion = palabras[pocicionPalabra];
                        System.out.println("Palabra del azar es " + pocicion);
                        break;
                    }
                }
                case 3 -> {
                    int letras = 0;
                    for (String item : palabras) {
                        letras += item.length();
                    }
                    System.out.println("Numero total de letras es: " + letras);
                }
                case 4 -> {
                    int suma = 0;
                    for (String item : palabras) {
                        suma += item.length();
                    }
                    double media = (double) suma / palabras.length;
                    System.out.println("La media de letras es " + media);
                }
                case 5 -> {
                    String mayor = palabras[0];
                    for (String item : palabras){
                        if (item.length() > mayor.length()){
                            mayor = item;
                        }
                    }
                    System.out.println("Palabra con mayor numero de letras es " + mayor);
                }
                case 6 -> {
                    String menor = palabras[0];
                    for (String item : palabras){
                        if (item.length() < menor.length()){
                            menor = item;
                        }
                    }
                    System.out.println("Palabra con menor numero de letras es " + menor);
                }
                case 7 -> {

                }

            }
        } while (opcion != 7);
        System.out.println("Saliendo...");
    }
    public void multiplicarArray(){

        int[] numeros = new int[5];

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("\nIntroduzca un numero: ");
            numeros[i] = scanner.nextInt();

        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Elemento" + (i +1) + ":" + numeros[i]);
        }
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = numeros[i] * 2;
            System.out.println("Elemento " + (i+1) + " ahora vale " + numeros[i]);
        }
        int suma = 0;
        double media = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
            media = (double) suma / numeros.length;
        }
        System.out.println("La suma es " + suma);
        System.out.println("La media es " + media);
    }

    public void MayorArray(){
        System.out.println("Introduzca la longitud de array ");

        int longitud = scanner.nextInt();
        int[] numeros = new int[longitud];

        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Introduce el elemento %d: ",(i+1) );
            numeros[i] = scanner.nextInt();
        }
        int mayor = numeros[0];
        int menor = numeros[0];
        for (int i = 0; i < numeros.length; i++) {
            if (mayor < numeros[i]){
            mayor = numeros[i];
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            if (menor > numeros[i]){
                menor = numeros[i];
            }
        }
        System.out.println();
        System.out.println("El elemento mayor es: " + mayor);
        System.out.println("El elemento menor es: " + menor);
    }
    public void SumaArrays(){
        System.out.println("Introduzca la longitud de array ");
        int longitud1 = scanner.nextInt();
        int[] numeros1 = new int[longitud1];
        int[] numeros2 = new int[longitud1];

        for (int i = 0; i < numeros1.length; i++) {
            numeros1[i] = (int)(Math.random()*35);
        }
        System.out.println("Array 1: " + Arrays.toString(numeros1));
        for (int i = 0; i < numeros2.length; i++) {
            numeros2[i] = (int)(Math.random()*35);
        }
        System.out.println("Array 2: " + Arrays.toString(numeros2));
        int[] numeros3 = new int[longitud1];
        for (int i = 0; i < numeros3.length; i++) {
            numeros3[i] = numeros1[i] + numeros2[i];
            System.out.printf("Posicion %d: %d + %d = %d\n",i,numeros1[i],numeros2[i],numeros3[i]);
        }
        System.out.println("Array 3 es: "+Arrays.toString(numeros3));
    }
    public void PosicionesArray(){
        System.out.println("Introduzca la longitud de array ");
        int longitud1 = scanner.nextInt();
        int[] numeros = new int[longitud1];
        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Introduce elemento %d: ",i+1 );
            numeros[i] = scanner.nextInt();
        }
        System.out.println("Array original: " + Arrays.toString(numeros));

        int aux = numeros[numeros.length -1];
        for (int i = numeros.length -1; i > 0; i--) {
            numeros[i] = numeros[i -1];
        }
        numeros[0] = aux;

        System.out.println("Moviendo una posición a la derecha:");
        System.out.println("Nuevo array: " + Arrays.toString(numeros));


        for (int i =0 ; i < numeros.length -1; i++) {
            numeros[i] = numeros[i + 1];
        }
        numeros[numeros.length -1] = aux;

        System.out.println("Moviendo una posición a la izquierda:");
        System.out.println("Nuevo array: " + Arrays.toString(numeros));
    }

    public void OperacionesArray(){

    }















}










