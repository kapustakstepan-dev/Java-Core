package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private String  nombre;
    private int precio;

    public void mostrarInformacion(){
        System.out.println("El pedido es por nombre " + nombre + " su pedido vale " + precio);
    }

}

