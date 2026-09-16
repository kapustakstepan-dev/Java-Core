package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Pedido {
    private boolean estado;
    private Cliente cliente;
    private int cuenta;
    private ArrayList<Producto> productos;

    public Pedido(){
        productos = new ArrayList<>();
    }

    public Pedido(Cliente cliente){
        this.cliente = cliente;
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
        if (productos == null){
            System.out.println("No puedes agregar el producto");
        } else {
            productos.add(producto);
            cuenta += producto.getPrecio();
        }
    }
    public void listarProducto(){
        if (productos.isEmpty()){
            System.out.println("La lista de productos es vacia ");
        } else {
            System.out.println("Los productos estan hechos por nombre: " + cliente.getNombre());
            for (Producto item : productos){
                item.mostrarInformacion();
            }
            System.out.println("En la caja hay " + cuenta + "€");
        }
    }

    public void cobrando(){
        this.estado = true;
    }
}
