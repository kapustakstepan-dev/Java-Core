package controller;

import model.Alumnos;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio3 {
    BufferedReader bufferedReader;
    Alumnos alumnos;

    public void leerFichero(){

        try {
            bufferedReader = new BufferedReader(new FileReader("src/main/java/files/alumnos.txt"));
            String linea;

            while ((linea=bufferedReader.readLine())!=null){
                String [] datos = linea.split(",");
                alumnos = new Alumnos(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]));
            }

            
        } catch (FileNotFoundException e) {
            System.out.println("Error en la ruta de fichero");
        } catch (IOException e) {
            System.out.println("Error al cerrado  de fichero");
        }

    }

    public void notaMedia(){
       // double nota = (double) alumnos.getNota() / alumnos.;


    }


}
