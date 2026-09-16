package Model;

import lombok.Data;

import java.util.ArrayList;


@Data
public class Cuenta {

    private int id;
    private String estado = "Abierto";
    private ArrayList<Articulo> articulos = new ArrayList<>();

    public Cuenta(int id){
        this.id = id;
    }


    public void agregarArticulo(Articulo articulo){
        articulos.add(articulo);

    }
    public int getNumeroArticulos(){
        return articulos.size();
    }
    public double getCoste(){
        double total = 0;
        for (Articulo item : articulos){
            total += item.getCoste();
        }
        return total;
    }

}
