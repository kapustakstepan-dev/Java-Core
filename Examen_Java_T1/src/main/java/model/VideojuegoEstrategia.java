package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class VideojuegoEstrategia extends Videojuego{

    private int difficult;
    private int timePlayed;

    public VideojuegoEstrategia(String titulo, String desarrollador, int añoLanzamiento, int tamaño, double precio,
                                ClaificacionEdad claificacionEdad, int difficult, int timePlayed) {
        super(titulo, desarrollador, añoLanzamiento, tamaño, precio, claificacionEdad);
        this.difficult = difficult;
        this.timePlayed = timePlayed;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() * ((difficult * 0.03)+1);
    }

    @Override
    public String toString() {
        return super.toString() +
                "VideojuegoEstrategia{" +
                "difficult=" + difficult +
                ", timePlayed=" + timePlayed +
                '}';
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("difficult = " + difficult);
        System.out.println("timePlayed = " + timePlayed);
    }
}
