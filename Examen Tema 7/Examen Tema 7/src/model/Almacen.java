package model;

import java.util.ArrayList;

public class Almacen {
    private int numeroPlazas;
    private ArrayList<Bicis> listaBicisReparados;

    public Almacen(){}

    public Almacen(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
        listaBicisReparados = new ArrayList<>();
    }

    public void agregarBici(Bicis bicis) throws ExepcionPersonalizada{
        if (listaBicisReparados.size() >= numeroPlazas){
            throw new ExepcionPersonalizada("No hay plazas en el Almacen");
        } else {
            listaBicisReparados.add(bicis);
            System.out.println("La bici esta en lista reparados");
        }
    }



    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public ArrayList<Bicis> getListaBicisReparados() {
        return listaBicisReparados;
    }

    public void setListaBicisReparados(ArrayList<Bicis> listaBicisReparados) {
        this.listaBicisReparados = listaBicisReparados;
    }
}
