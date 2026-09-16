public class ArrayDimencional {
    public void arrayDemencional(){
        int[][] cuanrado = new int[3][3];
        cuanrado[0][0] = 1;
        cuanrado[0][2] = 3;
        cuanrado[2][0] = 7;
        cuanrado[2][2] = 9;

        System.out.println("el numeros de filas es " + cuanrado.length);
        System.out.println("El ultimo elemento de cuadrado es " + cuanrado[2][2]);
        System.out.println("*-*--*-*-*-*-");
        for (int i = 0; i < cuanrado.length; i++) {
            for (int j = 0; j < cuanrado[i].length; j++) {
                if (j == 2){
                    cuanrado[i][j]=5;
                }
                System.out.print(cuanrado[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("*-*--*-*-*-*-");

        int[][] cuadrado = new int[3][3];
        int suma=0;

        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                cuadrado[i][j] = (int)(Math.random()*11);
            }
        }
        for (int[] fila : cuadrado){
            for (int item : fila){
                System.out.print(item + " ");
                suma+=item;

            }
            System.out.println();
        }
        System.out.println("La suma de los elementos es " + suma);

        System.out.println("*-*--*-*-*-*-");
    }
}
