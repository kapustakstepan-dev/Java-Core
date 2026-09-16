public class EntradaForeach {
    public static void main(String[] args) {

        int[] numeros = new int[5];
        int[] numerosLlenos = {7, 8, 10, 20}; // [7, 8, 10, 20]

        for (int i = 0; i < numerosLlenos.length; i++) {
            System.out.println(numerosLlenos[i]);
        }

        //saca solomente primer par en la lista utilizando break;
        // foreach
        for (int item : numerosLlenos) {
            if (item % 2 == 0) {
                System.out.println(item);
                break;
            }
        }

        //while
        int numero = 5;
        while (numero > 0) {
            numero --;

        }

        // do-while
        int n = 5;
        n--;
        do {
            n++;
        } while (n > 0);











    }
}