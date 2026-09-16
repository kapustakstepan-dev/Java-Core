package controller;

import model.Usuario;

import java.io.*;
import java.util.ArrayList;

public class Gestor {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public void escribirObjeto(Usuario usuario){

        try {
            objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream("src/ficheros/objetos.obj"));
            objectOutputStream.writeObject(usuario);
        } catch (IOException e) {
            System.out.println("La ruta no es correcta");
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            }
        }

    }

    public void leerObjeto(){
        try (ObjectInputStream objectInputStream1 = new ObjectInputStream(
                new FileInputStream("src/ficheros/objetos.obj"))) {

            Usuario usuario = (Usuario) objectInputStream1.readObject();

            // Sacar la información directamente
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("DNI: " + usuario.getDni());

        } catch (IOException e) {
            System.out.println("Error en la lectura fichero: " + e.getMessage());
        } catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("Error en la clase asociada");
        }
    }

    public ArrayList<Usuario> importarLista(){
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("src/ficheros/agenda.obj"));
            lista = (ArrayList<Usuario>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("El fichero no se puede leer");
        } catch (ClassNotFoundException e) {
            System.out.println("El objeto no se puede leer");
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return lista;
    }

    public void exportarListar(ArrayList<Usuario> lista){

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("src/ficheros/agenda.obj")));
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error en la ruta indicada");
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}