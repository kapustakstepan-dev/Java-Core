package model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class VideojuegoAccion extends Videojuego implements Descargable{

    private int levelViolense;
    private boolean modMultiPlayer;

    public VideojuegoAccion(String titulo, String desarrollador, int añoLanzamiento, int tamaño, double precio,
                            ClaificacionEdad claificacionEdad, int levelViolense, boolean modMultiPlayer) {
        super(titulo, desarrollador, añoLanzamiento, tamaño, precio, claificacionEdad);
        this.levelViolense = levelViolense;
        this.modMultiPlayer = modMultiPlayer;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioFinal  = getPrecio();
        if (levelViolense > 3){
            precioFinal = precioFinal *1.05;
        }
        if (modMultiPlayer){
            precioFinal = precioFinal *1.10;
        }
        return precioFinal;
    }

    @Override
    public double calcularTiempoDescarga(double velocidadInternet) {
        return getTamaño()/ velocidadInternet;
    }

    @Override
    public double obtenerTamanioGB() {
        return (getTamaño()*2) / 1024.0 ;
    }

    @Override
    public String toString() {
        return super.toString() +
                "VideojuegoAccion{" +
                "levelViolense=" + levelViolense +
                ", modMultiPlayer=" + modMultiPlayer +
                '}';

    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("levelViolense = " + levelViolense);
        System.out.println("modMultiPlayer = " + modMultiPlayer);
    }
}
