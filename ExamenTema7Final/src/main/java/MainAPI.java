import controller.APIController;
import controller.FileController;
import model.Libros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAPI {
    public static void main(String[] args) {
        APIController apiController = new APIController();
        FileController fileController = new FileController();
        ArrayList<Libros> libros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);




        //apiController.AllAPI();
        /*System.out.println("Introduzca id de libro (1-19)");
        int id = scanner.nextInt();
        apiController.buscarID(id);

         */

        System.out.println("Introductca id de libro favorito (1-19)");
        int id = scanner.nextInt();
        apiController.AnidirFav(id);

       // fileController.exportacion(libros);

       // fileController.importacion();


    }
}
