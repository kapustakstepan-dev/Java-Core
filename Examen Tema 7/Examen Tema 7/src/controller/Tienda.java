package controller;

import model.Almacen;
import model.Bicis;
import model.ExepcionPersonalizada;

import java.util.ArrayList;

public class Tienda {

    private Almacen almacen;
    private ArrayList<Bicis> stock;
    private double caja;



    public void construirAlmacen(int plazas){
        almacen = new Almacen(plazas);
        stock = new ArrayList<>();
    }

    public void agregarBici(Bicis bicis){
        if (stock.isEmpty()){
            System.out.println("El stock es vacio");
        } else {
            System.out.println("Bici esta aniadido correctamente");
            stock.add(bicis);
        }
    }

    public void agregarBicicletaReparar(Bicis bicis) throws ExepcionPersonalizada {
        if (almacen == null){
            System.out.println("Almacen no es creado");
        } else {
            System.out.println("Bici esta aniadido al almacen");
            almacen.agregarBici(bicis);
        }
    }

    public void venderBicicleta(int posicion){
        Bicis bicis = stock.get(posicion);
        bicis.mostrarDatos();
        caja += bicis.getPrecio();
        stock.remove(posicion);
    }

    public void repararBicis(){
        for (Bicis bicis : almacen.getListaBicisReparados()){
            caja += bicis.reparar();
            bicis.mostrarDatos();
        }
        almacen.getListaBicisReparados().clear();
        caja += (int)(Math.random()* 50)+ 50;
    }

    public void mostrarDatosStock(){
        stock.forEach(System.out::println);
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public ArrayList<Bicis> getLista() {
        return stock;
    }

    public void setLista(ArrayList<Bicis> stock) {
        this.stock = stock;
    }

    public double getCaja() {
        return caja;
    }

    public double setCaja(double caja) {
        return this.caja = caja;
    }
}
