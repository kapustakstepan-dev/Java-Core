import controller.Controller;
import dao.AutorDAO;
import dao.BibliotecaDAO;
import dao.LibroDAO;
import model.Autor;
import model.Biblioteca;
import model.Libro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        AutorDAO autorDAO = new AutorDAO();
        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        LibroDAO libroDAO = new LibroDAO();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("-- Gestion Biblioteca --");
            System.out.println("1. Insertar autor");
            System.out.println("2. Insertar un libro");
            System.out.println("3. Obtener todos los libros de biblioteca");
            System.out.println("4. Obtener todos los autores");
            System.out.println("5. Exportar todos los libros de Autor al .csv");
            System.out.println("6. Salir");
            System.out.println("Que eliges?");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1->{
                    System.out.println("\n\tIntroduzca nombre de autor:");
                    String nombre = scanner.nextLine();
                    System.out.println("\n\tIntroduzca apellidos de autor:");
                    String apellido = scanner.nextLine();
                    System.out.println("\n\tIntroduzca dni de autor:");
                    String dni = scanner.nextLine();

                    if (autorDAO.getPorDni(dni) != null){
                        System.out.println("\n\tNo se puede meter diferentes autores con mismo dni");
                        System.out.println("\tIntroduzca nievo dni de este autor");
                        String dniNuevo = scanner.nextLine();
                        controller.insertAutor(new Autor(nombre,apellido,dniNuevo));
                    }
                    controller.insertAutor(new Autor(nombre,apellido,dni));
                }
                case 2->{
                    System.out.println("\n\tIntroduzca isdn de libro:");
                    String isdn = scanner.nextLine();
                    System.out.println("\n\tIntroduzca anio de fabricacion de libro:");
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("\n\tIntroduzca numero de paginas de libro:");
                    int n_pag = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("\n\tIntroduzca tipo de libro:");
                    String tipo = scanner.nextLine();
                    System.out.println("\n\tIntroduzca autor del libro:");
                    String autor = scanner.nextLine();
                    System.out.println("\n\tIntroduzca calle de biblioteca:");
                    String biblioteca = scanner.nextLine();

                    controller.insertLibro(new Libro(isdn,anio,n_pag,tipo,new Autor(),new Biblioteca()));


                }
                case 3->{

                }
                case 4->{

                }
                case 5->{
                    System.out.println("Introduzca npmbre de archivo .csv");
                    String name = scanner.nextLine();
                    controller.insertarLibroCSV(name);
                }
                case 6->{
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Este punto de menu todavia no esta disponible, elige otro.");
                }
            }

        } while (opcion!=6);
    }
}
