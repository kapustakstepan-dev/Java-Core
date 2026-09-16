package controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Prestamo;
import model.Socio;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Biblioteca {
    private String nombre;
    private int recaudacion;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        prestamos = new ArrayList<>();
    }

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        prestamos = new ArrayList<>();
    }

    public void resgistrarPrestamo(Prestamo prestamo) {
        for (Prestamo item : prestamos) {
            if (item.getSocio().getDni().equals(item.getSocio().getDni()) && item.isActivo()) {
                System.out.println("El Socio ya tiene ativo el prestamo");
                return;
            }
        }
        prestamos.add(prestamo);
    }

    public void finalizarPrestamo(String dniSocio) {
        for (Prestamo item : prestamos) {
            if (item.getSocio().getDni().equals(dniSocio) && item.isActivo()) {
                item.setActivo(false);
                int multa = item.calcularMulta(0);
                recaudacion += multa;

                System.out.println("Datos del recibo: ");
                item.getSocio().mostrarInfo();
                System.out.println("Datos de libro elegido: ");
                System.out.println();
                item.getLibro().mostrarInfo();
                System.out.println("Fecha de devolución en " + item.getDiasPrest() + " dias");
                return;
            }
        }
    }
    public void listarPrestamo(){
        System.out.println();
        System.out.println("Datos de prestamo: ");
        for (Prestamo item : prestamos){
            item.mostrarInfo();
        }

    }
    public void listarPrestamosActivos(){

    }
}