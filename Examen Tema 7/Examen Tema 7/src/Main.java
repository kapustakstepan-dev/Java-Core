import controller.Tienda;
import model.*;


public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        tienda.construirAlmacen(4);

        tienda.agregarBici(new BicicletaMTB(27,29,15, 150,"L", Tipo.MTP));
        tienda.agregarBici(new BicicletaPaseo(2, 27, 15, 200, "M", Tipo.PASEO));
        tienda.agregarBici(new BicicletaCarretera(8, 24, 15, 40, "S", Tipo.CARRETERA));

        tienda.mostrarDatosStock();

        int posicion = (int)(Math.random()*20)+1;

        tienda.agregarBicicletaReparar(posicion);
        if (tienda.)


    }
}
