import controller.GestorFicheros;
import model.Contacto;

import java.io.IOException;

public class EntradaPruebas {
    public static void main(String[] args) throws IOException {
        GestorFicheros gestorFichero = new GestorFicheros();
        gestorFichero.escribirContacto(new Contacto("Stepan", "Kapustiak", "1234A"));
    }
}
