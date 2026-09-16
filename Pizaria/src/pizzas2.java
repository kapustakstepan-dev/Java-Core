import java.util.ArrayList;
import java.util.HashMap;

public class pizzas2 {
    HashMap<String, Integer> ingredientes;
    ArrayList<Object[]> pedido;
    int caja;
    int precio;


    public pizzas2(){
        ingredientes = new HashMap<>();
        pedido = new ArrayList<>();
        caja = 0;
        precio=0;
        meterIngredientes();
    }
    public  void pedido(String nombre, String tamanio, ArrayList<String> masIngredientes){
        int precioPedido = 0;
        switch (tamanio){
            case "s" ->{precioPedido += 5;}
            case "m" ->{precioPedido += 7;}
            case "xl" ->{precioPedido += 10;}
            default -> {precioPedido +=0;}
        }
        if (masIngredientes != null){
            for (String item : masIngredientes){
                precioPedido += ingredientes.getOrDefault(item, 0);
            }
        }
        int id = (int)(Math.random()*100)+1;
        Object[] pedidos = {nombre,tamanio,id , precioPedido, false};
        pedido.add(pedidos);
        System.out.println("Pedido añadido correctamente: Cliente " + nombre + ", Id " + id + ", Precio: " + precioPedido);
    }
    public void meterIngredientes(){
        ingredientes.put("queso", 5);
        ingredientes.put("carne", 5);
        ingredientes.put("salsa", 3);
        ingredientes.put("chorizo", 4);
        ingredientes.put("jamon", 2);

    }
    public void servirPedido(){
        boolean encontrado = false;
        for (Object[] item : pedido){
            if (!(boolean)item[4]){
                item[4] = true;
                caja += (int)item[3];
                System.out.println("Pedido servido: Cliente " + item[0] + " Id " + item[2] + ", Precio: " + item[3]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("No hay pedidos encontrados");
        }
    }
    public void verPedido(){
        boolean pendientes = false;
        for (Object[] item : pedido){
            if (!(boolean)item[4]){
                item[4] = true;
                System.out.println("Pedido servido: Cliente " + item[0] + " Id " + item[2] + ", Precio: " + item[3]);
                pendientes = true;
                break;
            }
        }
        if (!pendientes){
            System.out.println("No hay pedidos pendientes");
        }
    }
    public void verCaja(){
        System.out.println("Dinero en la caja -> " + caja);
    }

}
