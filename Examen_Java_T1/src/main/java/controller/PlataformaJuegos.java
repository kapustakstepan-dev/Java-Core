package controller;

import lombok.Getter;
import model.ClaificacionEdad;
import model.Videojuego;
import model.VideojuegoAccion;

import java.util.ArrayList;
import java.util.Comparator;

@Getter

public class PlataformaJuegos {

    private long id;
    private ArrayList<Videojuego> videojuegos;
    private ArrayList<Videojuego> carrito;

    public PlataformaJuegos(){
        videojuegos = new ArrayList<>();
        carrito = new ArrayList<>();
    }

    public void addGame(Videojuego videojuego){
        videojuegos.add(videojuego);
        id++;
        videojuego.setId(id);
    }

    public void removeGame(int indice){
        if (indice >= 0 && indice < videojuegos.size()){
            videojuegos.remove(indice);
        }
    }

    public Videojuego buscarId(int id){
        Videojuego videojuego = null;
        if ( id >=0 && id< getVideojuegos().size()){
            videojuego = getVideojuegos().get(id);
            System.out.println(videojuego);
        } else {
            System.out.println("No existe este juego el la lista");
        }
        return videojuego;
    }

    public void addCarrito(String titulo){
        for (Videojuego videojuego : videojuegos){
            if (videojuego.getTitulo().equalsIgnoreCase(titulo)){
                carrito.add(videojuego);
                return;
            } else {
                System.out.println("No existe este video juego.");
            }
        }
    }

    public void removeGameCarritoTitle(String titulo) {
        for (Videojuego videojuego : carrito) {
            if (videojuego.getTitulo().equalsIgnoreCase(titulo)) {
                carrito.remove(videojuego);
                return;
            }
        }
    }

    public void mostrarVideoJuegos(){
        videojuegos.sort(Comparator.comparingDouble(Videojuego::calcularPrecioFinal));
        for (int i = 0; i < videojuegos.size(); i++) {
            System.out.println("Precio final -> " + videojuegos.get(i).calcularPrecioFinal());
        }
    }

    public void mostrarAll(){
        videojuegos.forEach(Videojuego::showData);
    }

    public void filterEdad(ClaificacionEdad edad){
         for (Videojuego videojuego : videojuegos){
             if (videojuego.getClaificacionEdad() == edad){
                 System.out.println(videojuego);
             }
         }
    }

    public double calcPrice(){
        double precioTotal =0;
        for (Videojuego videojuego : videojuegos){
            precioTotal += videojuego.calcularPrecioFinal();
        }
        return precioTotal;
    }

}
