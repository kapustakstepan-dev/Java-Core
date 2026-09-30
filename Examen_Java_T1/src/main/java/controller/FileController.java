package controller;

import model.Videojuego;

import java.io.FileWriter;
import java.io.IOException;

public class FileController {

    FileWriter fileWriter= null;
    PlataformaJuegos plataformaJuegos = null;
    public void exportarDatos() {
        if (plataformaJuegos.getCarrito().isEmpty()) {
            System.out.println("Carrito es vacio. ");
            return;
        }
        try {
            fileWriter = new FileWriter("src/main/java/files/juegos.csv");

            fileWriter.write("TITULO,DESARROLLADOR, ANIO, TAMANIO, PRECIO, CLASIFICACION\n");
            for (Videojuego videojuego:plataformaJuegos.getCarrito()){
                fileWriter.write(videojuego.getTitulo() +", " +
                        videojuego.getDesarrollador() +", " +
                        videojuego.getAñoLanzamiento() +", " +
                        videojuego.getTamaño() +", " +
                        videojuego.getPrecio() +", " +
                        videojuego.getClaificacionEdad());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
