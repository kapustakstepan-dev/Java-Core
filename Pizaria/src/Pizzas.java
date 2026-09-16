import java.util.ArrayList;
import java.util.HashMap;

public class Pizzas {
    ArrayList<Object[]> pedido;
    HashMap<String, Integer> ingredientes;
    int precio;
    int caja;

    public Pizzas(){
        pedido = new ArrayList<>();
        ingredientes = new HashMap<>();
        precio = 0;
        meterIngredientes();
    }
    public void Pedido(String nombre, String tamanio, ArrayList<String> masIngredientes) {
        int precioPedido = 0;
        switch (tamanio) {
            case "s" -> {precioPedido+=5;}
            case "m" -> {precioPedido+=7;}
            case "xl" -> {precioPedido+=10;}
            default -> {precioPedido+=0;}
        }
        if (masIngredientes != null) {
            for (String item : masIngredientes) {
                precioPedido += ingredientes.getOrDefault(item, 0);
            }
        }

        int id = (int)(Math.random()*100)+1;

        Object[] pedidos = {nombre, tamanio, id , precioPedido, false};
        pedido.add(pedidos);
        System.out.println("Pedido añadido correctamente: Cliente " + nombre + ", Id " + id + ", Precio: " + precioPedido);

    }
    public void meterIngredientes() {
        ingredientes.put("queso", 5);
        ingredientes.put("carne", 5);
        ingredientes.put("salsa", 3);
        ingredientes.put("chorizo", 4);
        ingredientes.put("jamon", 2);
    }
    public void servirPedido(){
        boolean encontrado = false;
        for (Object[] item : pedido) {
            if (!(boolean) item[4]) {
                item[4] = true;
                caja += (int) item[3];
                System.out.println("Pedido servido: Cliente " + item[0] + " Id " + item[2] + ", Precio: " + item[3]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No hay pedidos pendientes para servir.");
        }
    }
    public void verPedido(){
        boolean pendiente = false;
        for (Object[] item : pedido){
            if (!(boolean)item[4]){
                System.out.println("Cliente: " + item[0] + " Tamaño: " + item[1] + " Id " +  item[2] + " Precio: " + item[3]);
                pendiente = true;
            }
            if (!pendiente){
                System.out.println("no hay pedidos pendientes");
            }
        }
    }
    public void verCaja(){
        System.out.println("dinero en la caja"+caja);
    }
}
