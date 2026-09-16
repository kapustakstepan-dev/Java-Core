import java.util.Scanner;

public class CuadradoMagico {
    public void cuadradoMagico() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el tamaño del cuadrado: ");
        int tamanio = sc.nextInt();

        System.out.print("Introduce el rango máximo de los números: ");
        int rango = sc.nextInt();


        if (tamanio <= 0 || rango < tamanio * tamanio) {
            System.out.println("Error: el rango debe ser al menos igual al número total de casillas " + tamanio * tamanio );
            return;
        }

        int[][] cuadrado = new int[tamanio][tamanio];
        int intentos = 0;

        while (true) {
            intentos++;
            int numero;

            boolean[] usados = new boolean[rango + 1];
            for (int i = 0; i < tamanio; i++) {
                for (int j = 0; j < tamanio; j++) {
                    do {
                        numero = (int) (Math.random() * rango) + 1;
                    } while (usados[numero]);
                    usados[numero] = true;
                    cuadrado[i][j] = numero;
                }
            }

            int sumaPrimLinea = 0;
            for (int j = 0; j < tamanio; j++) {
                sumaPrimLinea += cuadrado[0][j];
            }


            boolean esMagic = true;
            for (int i = 1; i < tamanio; i++) {
                int sumaFila = 0;
                for (int j = 0; j < tamanio; j++) {
                    sumaFila += cuadrado[i][j];
                }
                if (sumaFila != sumaPrimLinea){
                    esMagic = false;
                }
            }


            for (int j = 0; j < tamanio; j++) {
                int sumaColumna = 0;
                for (int i = 0; i < tamanio; i++) {
                    sumaColumna += cuadrado[i][j];
                }
                if (sumaColumna != sumaPrimLinea) {
                    esMagic = false;
                }
            }


            int diagonal1 = 0, diagonal2 = 0;
            for (int i = 0; i < tamanio; i++) {
                diagonal1 += cuadrado[i][i];
                diagonal2 += cuadrado[i][tamanio - 1 - i];
            }
            if (diagonal1 != sumaPrimLinea || diagonal2 != sumaPrimLinea){
                esMagic = false;
            }

            if (esMagic) {
                System.out.println("\nCuadrado mágico encontrado en " + intentos + " intentos:");
                for (int i = 0; i < tamanio; i++) {
                    for (int j = 0; j < tamanio; j++) {
                        System.out.print(cuadrado[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("\nLa constante mágica es: " + sumaPrimLinea);
                break;
            }

        }
    }
}