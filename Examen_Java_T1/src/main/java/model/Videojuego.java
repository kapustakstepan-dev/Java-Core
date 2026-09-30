package model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public abstract class Videojuego {

    private long id;
    private String titulo;
    private String desarrollador;
    private int añoLanzamiento;
    private int tamaño;
    private double precio;
    private  ClaificacionEdad claificacionEdad;

    public Videojuego(String titulo, String desarrollador, int añoLanzamiento, int tamaño, double precio, ClaificacionEdad claificacionEdad) {
        this.titulo = titulo;
        this.desarrollador = desarrollador;
        this.añoLanzamiento = añoLanzamiento;
        this.tamaño = tamaño;
        this.precio = precio;
        this.claificacionEdad = claificacionEdad;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", añoLanzamiento=" + añoLanzamiento +
                ", tamaño=" + tamaño +
                ", precio=" + precio +
                ", claificacionEdad=" + claificacionEdad +
                '}';
    }

    public void showData(){
        System.out.println("titulo = " + titulo);
        System.out.println("desarrollador = " + desarrollador);
        System.out.println("añoLanzamiento = " + añoLanzamiento);
        System.out.println("tamaño = " + tamaño);
        System.out.println("precio = " + precio);
        System.out.println("claificacionEdad = " + claificacionEdad);
    }

    public abstract double calcularPrecioFinal();


}
