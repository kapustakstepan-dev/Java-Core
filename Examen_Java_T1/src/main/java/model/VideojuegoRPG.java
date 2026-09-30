package model;

public class VideojuegoRPG extends Videojuego implements Descargable{

    private boolean mundoAbierto;
    private int horasHistoriaPrincipal;

    public VideojuegoRPG(String titulo, String desarrollador, int añoLanzamiento, int tamaño, double precio,
                         ClaificacionEdad claificacionEdad, boolean mundoAbierto, int horasHistoriaPrincipal) {
        super(titulo, desarrollador, añoLanzamiento, tamaño, precio, claificacionEdad);
        this.mundoAbierto = mundoAbierto;
        this.horasHistoriaPrincipal = horasHistoriaPrincipal;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioFinal = getPrecio();
        if (mundoAbierto){
            precioFinal = precioFinal*1.15;
        }
        precioFinal = precioFinal *(((horasHistoriaPrincipal/10)*0.02)+1);

        return precioFinal;
    }

    @Override
    public double calcularTiempoDescarga(double velocidadInternet) {
        return getTamaño() / velocidadInternet;
    }

    @Override
    public double obtenerTamanioGB() {
        return (getTamaño() * 3) /1024.0 ;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("mundoAbierto = " + mundoAbierto);
        System.out.println("horasHistoriaPrincipal = " + horasHistoriaPrincipal);
    }
}
