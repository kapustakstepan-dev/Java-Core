import java.util.Scanner;

public class Bingo {

    private int[][] carton;
    private boolean[][] carton2;
    private int linea;
    private boolean[] usados;
    private boolean[] numerosSacados;
    private Scanner scanner = new Scanner(System.in);

    public Bingo() {
        linea = 5;
        carton2 = new boolean[linea][linea];
        usados = new boolean[75 + 1];
        numerosSacados = new boolean[75 + 1];
    }

    public void carton() {
        int numero;
        carton = new int[linea][linea];

        usados = new boolean[75 + 1];
        for (int i = 0; i < linea; i++) {
            for (int j = 0; j < linea; j++) {
                do {
                    numero = (int) (Math.random() * 75) + 1;
                } while (usados[numero]);
                usados[numero] = true;
                carton[i][j] = numero;
            }
        }
        System.out.println("Carton generado: ");
        listarCarton();
    }

    public void listarCarton() {
        for (int i = 0; i < linea; i++) {
            for (int j = 0; j < linea; j++) {
                if (carton2[i][j])
                    System.out.print(" -- ");
                else
                    System.out.printf("%02d  ", carton[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private int sacadaNumero() {
        int numero;
        while (true) {
            System.out.println("Inserta el numero entre 1-75 ");
            numero = scanner.nextInt();

            if (numero < 1 || numero > 75) {
                System.out.println("Numero no puede ser cero, negativo o mayor que 75");
                continue;
            }
            if (numerosSacados[numero]) {
                System.out.println("Ese numero ya has insertado no puedes incertar otra vez ");
                continue;
            }
            numerosSacados[numero] = true;
            break;

        }
        return numero;
    }

    private void numerosMarcados(int numero) {
        for (int i = 0; i < linea; i++) {
            for (int j = 0; j < linea; j++) {
                if (carton[i][j] == numero) {
                    carton2[i][j] = true;
                }
            }
        }
    }

    private boolean lineasGanadores() {
        boolean completo = true;
        boolean diagVert = true;
        for (int i = 0; i < linea; i++) {
            for (int j = 0; j < linea; j++) {
                if (!carton2[i][j]) {
                    return false;
                }
            }
            if (completo){
                return true;
            }
        }

        for (int i = 0; i < linea; i++) {
            for (int j = 0; j < linea; j++) {
                if (!carton2[j][i]){
                    return false;
                }
            }
            if (completo) {
                return true;
            }
        }
        boolean diagonalIzq = true;
        for (int i = 0; i < linea ; i++) {
            if (!carton2[i][i]){
                return diagonalIzq = false;
            }
            if (!diagonalIzq){
                return true;
            }

        }
        boolean diagonaDer = true;
        for (int i = 0; i < linea; i++) {
            if (!carton2[i][linea - 1 - i]){
                return false;
            }
            if (!diagonaDer){
                return diagonaDer = true;
            }
        }
        return diagonalIzq || diagonaDer;
    }

    private boolean hayBingo(){
        for (int i = 0; i < linea; i++) {
            for (int j = 0; j < linea; j++) {
                if (!carton2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public void partida(){
        boolean partido = false;
        while (true){

            int numero = sacadaNumero();
            numerosMarcados(numero);
            listarCarton();

            if (!partido && lineasGanadores()){
                System.out.println("Has completado la linea, queda pogo!!! ");
                partido = true;
            }
            if (hayBingo()){
                System.out.println("Has completado todo el bingo, has ganado!!! ");
                break;
            }


        }
    }

}
