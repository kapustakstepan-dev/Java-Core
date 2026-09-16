package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestamo {
    private Socio socio;
    private Libro libro;
    private int diasPrest;
    private int diasRetras;
    private boolean activo;

    public int calcularMulta(int multa){
        if (diasRetras == 0){
            return 0;
        }
        if (diasRetras >= 1 && diasRetras< 10){
            return multa = (int)(Math.random()*6)+5;
        } else {
            return multa = (int)(Math.random()*11)+10;
        }
    }
    public void mostrarInfo(){
        System.out.println("socio = " + socio);
        System.out.println("libro = " + libro);
        System.out.println("diasPrest = " + diasPrest);
        System.out.println("diasRetras = " + diasRetras);
        System.out.println("actico = " + activo);
    }
}
