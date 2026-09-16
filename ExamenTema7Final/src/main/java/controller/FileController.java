package controller;

import model.Libros;

import java.io.*;
import java.util.ArrayList;


public class FileController {

    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    public void exportacion(ArrayList<Libros> libros){
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/main/java/files/favoritos.obj"));
            objectOutputStream.writeObject(libros);
        } catch (IOException e) {
            System.out.println("Error en la ruta");

        } finally {

            try {
                objectInputStream.close();
            } catch (IOException e) {
                System.out.println("Error al cerado de fichero");
            }
        }
    }

    public ArrayList<Libros> importacion(){
        ArrayList<Libros> libros = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("src/main/java/files/favoritos.obj"));
            libros = (ArrayList<Libros>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Error en la ruta de fichero");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la lectura de fichero");
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                System.out.println("Error al cerado de fichero");
            }
        }
        return libros;
    }

}
