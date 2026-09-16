package Model;

import java.util.ArrayList;
import java.util.Locale;

public class Vehiculo {
    //variables -> caracteristicas que cualifica el objeto
    private String marca, modelo, tipo;
    private int cc, cv;
    private ArrayList<String> listaAccesorio;



    public Vehiculo(){
        listaAccesorio = new ArrayList<>();
    }

    public ArrayList<String> getListaAccesorio() {
        return listaAccesorio;
    }
    //constructor -> metodos especiales que permiten hacer realidad a los objetos de la clase

    public Vehiculo(String marca, String modelo, String tipo, int cv, int cc ) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.cv = cv;
        this.cc = cc;
        this.listaAccesorio = new ArrayList<>();

    }

    public void motrarDatos(){
        System.out.println("Mostrando datos del coche:");
        System.out.println("\tMarca " + marca);
        System.out.println("\tModelo " + modelo);
        System.out.println("\tCV " + cv);
        System.out.println("\tCC " + cc);
        System.out.println("\taccesorio " + listaAccesorio);
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }
}
