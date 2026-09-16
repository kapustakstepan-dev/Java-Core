package model;

import controller.Tienda;

public class BicicletaMTB extends Bicis{
    private Tipo tipo;
    Tienda tienda;

    public BicicletaMTB(){}

    public BicicletaMTB(int velocidades, int pulgadas, int peso, int precio, String tamanio, Tipo tipo) {
        super(velocidades, pulgadas, peso, precio, tamanio, false, tipo);
    }

    public void hacerCaballito() throws ExepcionPersonalizada {
        throw new ExepcionPersonalizada("El biciMTB esta haciendo el caballito.");
    }

    @Override
    public double reparar() {
        getVelocidades() += setVelocidades(2);
        return tienda.setCaja((int)(Math.random()*100)+100);
    }
}
