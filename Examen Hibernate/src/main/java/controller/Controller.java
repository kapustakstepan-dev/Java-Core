package controller;

import dao.AutorDAO;
import dao.BibliotecaDAO;
import dao.LibroDAO;
import model.Autor;
import model.Biblioteca;
import model.Libro;

import java.io.*;
import java.util.List;

public class Controller {
    private AutorDAO autorDAO;
    private BibliotecaDAO bibliotecaDAO;
    private LibroDAO libroDAO;

    public Controller(){
        autorDAO = new AutorDAO();
        bibliotecaDAO = new BibliotecaDAO();
        libroDAO = new LibroDAO();
    }

    public void insertAutor(Autor autorInsert){
        Autor autor = autorDAO.insertarAutor(autorInsert);
        if (autor!=null){
            System.out.println("Autor insertado correctamente");
        } else {
            System.out.println("No se puede insertar autor");
        }

    }

    public void insertLibro(Libro libroInsert){
        Libro libro = libroDAO.getLibro(libroInsert);
        if (libro!=null){
            System.out.println("Autor insertado correctamente");
        } else {
            System.out.println("No se puede insertar autor");
        }

    }
    public void getAutor(Autor autorInsert){
        Autor autor = autorDAO.getPorDni(autorInsert.getDni());
        if (autor!=null){
            System.out.println("Autor insertado correctamente");
        } else {
            System.out.println("No se puede insertar autor");
        }

    }

    public List<Libro> insertarLibroCSV(String nombreCSV){
        List<Libro> lista = libroDAO.getLibros();

        try {
            PrintWriter printWriter = new PrintWriter("src/main/java/csv/" + nombreCSV);
            lista.forEach(libro -> {
                printWriter.printf("%s,%d,%d,%s,%s,%s",
                        libro.getIsdn(),
                        libro.getAnio(),
                        libro.getNumero_pag(),
                        libro.getTipo(),
                        libro.getAutor().getNombre(),
                        libro.getBiblioteca().getCalle()
                );
            });
            printWriter.write();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return lista;
    }




}
