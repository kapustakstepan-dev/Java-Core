package model;

import controller.Tienda;

public class BicicletaPaseo extends Bicis {
    private int paso;
    Tienda tienda;


    public BicicletaPaseo(){}

    public BicicletaPaseo(int velocidades, int pulgadas, int peso, int precio, String tamanio, Tipo tipo) {
        super(velocidades, pulgadas, peso, precio, tamanio, false, tipo);
        this.paso = paso;
    }

    public void ponerCesta() throws ExepcionPersonalizada{

    }

    @Override
    public double reparar() {
        return tienda.setCaja((int)(Math.random()*50)+50);
    }


    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    }
}
