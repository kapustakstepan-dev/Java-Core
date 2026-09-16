package OperacionesFichero;

import OperacionesFichero.controller.OperacionesFichero;

public class Main {
    public static void main(String[] args) {
        OperacionesFichero operacionesFichero = new OperacionesFichero();
        //operacionesFichero.infoCarpeta("src/main/java/OperacionesFichero/resources");
        //operacionesFichero.listarFicheros("src/");
        //operacionesFichero.crearFichero("src/main/java/OperacionesFichero/resources/file1.txt");
        //operacionesFichero.crearCarpeta("src/main/java/OperacionesFichero/resources/carpeta1");
        //operacionesFichero.crearFichero("src/main/java/OperacionesFichero/resources/fichero1.txt");
        //operacionesFichero.crearCarpeta("src/main/java/OperacionesFichero/resources/pruebas/datos");
        //operacionesFichero.crearCarpeta("src/main/java/OperacionesFichero/resources/pruebas/analisis");
        //operacionesFichero.leerFihero("src/main/java/OperacionesFichero/resources/file1.txt");
        //System.out.println();
        //System.out.println();
        //operacionesFichero.leerFicheroLineas("src/main/java/OperacionesFichero/resources/file1.txt");
        operacionesFichero.decifrar("src/main/java/OperacionesFichero/resources/fichero1.txt");
    }
}
