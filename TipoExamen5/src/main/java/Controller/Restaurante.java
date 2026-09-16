package Controller;

import Model.Pedido;
import Model.Producto;
import lombok.Data;

import java.util.ArrayList;

@Data

public class Restaurante {
    private String nif;
    private int caja;
    private String nombre;
    private ArrayList<Pedido> pedidos;

    public Restaurante(){
        pedidos = new ArrayList<>();
    }

    public Restaurante(String nombre, String nif){
        this.nombre = nombre;
        this.nif = nif;
        pedidos = new ArrayList<>();
    }
    public void agregarPedido(Pedido pedido){
        for (Pedido item : pedidos){
            if (item.getCliente().getNif().equals(pedido.getCliente().getNif()) && !item.isEstado()) {
                System.out.println("El cliente con este nif ya he pedido");
                return;
            }

        }
        pedidos.add(pedido);
        System.out.println("El pedido esta agregado");

    }


    public void cobrar(String nif){
        Pedido pedido = null;
        for (Pedido item : pedidos){
            if (item.getCliente().getNif().equals(nif) && !item.isEstado()){
                pedido = item;
                break;
            }

        }
        if (pedido == null){
            System.out.println("No encontro el pedido con el nif puesto "+nif);
        } else {
            pedido.cobrando();
            caja += pedido.getCuenta();
            factura(pedido);
        }

    }
    public void factura(Pedido pedido){
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("Factura del restaurante po nombre " + nombre + " con nif: " + nif);
        System.out.println("Cliente " + pedido.getCliente().getNombre() + " con nif: "+ pedido.getCliente().getNif());
        System.out.println("Sus productos");
        pedido.listarProducto();
        System.out.println("Precio total es: " + pedido.getCuenta() + "€");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    }

    public void listarPedidos(){
        if (pedidos.isEmpty()){
            System.out.println("No hay pedidos");
        } else {
            System.out.println("Lista de los pedidos: ");
            for (Pedido item : pedidos){
                item.listarProducto();
            }
        }
    }
    public void listarCobrados(){
        boolean cobrado = false;
        for (Pedido item : pedidos){
            if (item.isEstado()){
                System.out.println(item);
                cobrado=true;
            }
        }
        if (!cobrado){
            System.out.println("No hay pedidos cobrados");
        }
    }

}
