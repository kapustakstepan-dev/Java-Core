package model;

import controller.Tienda;

public class BicicletaCarretera extends Bicis{
    private Tipo tipo;
    Tienda tienda;

    public BicicletaCarretera(){}

    public BicicletaCarretera(int velocidades, int pulgadas, int peso, int precio, String tamanio, Tipo tipo) {
        super(velocidades, pulgadas, peso, precio, tamanio, false, tipo);
    }

    public void ponerModoSprint() throws ExepcionPersonalizada {

        throw new ExepcionPersonalizada("BicicletaCarretera entra en modo sprint.");
    }

    @Override
    public double reparar() {
        getPulgadas() += setPulgadas(2);
        return tienda.setCaja((int)(Math.random()*50)+50);
    }


}
