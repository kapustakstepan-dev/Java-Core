package model;

import java.util.PrimitiveIterator;

public abstract class Bicis {
    private int velocidades, pulgadas, peso, precio;
    private String tamanio;
    private boolean estado;
    private Tipo tipo;

    public Bicis(){}

    public Bicis(int velocidades, int pulgadas, int peso, int precio, String tamanio, boolean estado, Tipo tipo) {
        this.velocidades = velocidades;
        this.pulgadas = pulgadas;
        this.peso = peso;
        this.precio = precio;
        this.tamanio = tamanio;
        this.estado = false;
    }

    public void mostrarDatos(){
        System.out.println("Datos de la Bici");
        System.out.println("velocidades = " + velocidades);
        System.out.println("pulgadas = " + pulgadas);
        System.out.println("peso = " + peso);
        System.out.println("precio = " + precio);
        System.out.println("tamanio = " + tamanio);
        System.out.println("estado = " + estado);
    }

    public abstract double reparar();

    public int getVelocidades() {
        return velocidades;
    }

    public void setVelocidades(int velocidades) {
        this.velocidades = velocidades;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
