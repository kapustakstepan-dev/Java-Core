package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socio {
    private String nombre, dni, telefono;

    public void mostrarInfo() {
        System.out.println();
        System.out.println("nombre = " + nombre);
        System.out.println("dni = " + dni);
        System.out.println("telefono = " + telefono);
        System.out.println();
    }

}
