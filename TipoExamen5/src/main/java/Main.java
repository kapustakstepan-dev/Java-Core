import Controller.Restaurante;
import Model.Cliente;
import Model.Pedido;
import Model.Producto;

public class Main {
    public static void main(String[] args) {

        Restaurante restaurante = new Restaurante("Puf", "1234A");

        Cliente cliente1 = new Cliente("Stepan", "1234B");
        Cliente cliente2 = new Cliente("Borja", "1234C");
        Cliente cliente3 = new Cliente("Ana", "1234D");

        Producto producto1 = new Producto("Hamburgesa", 1);
        Producto producto2 = new Producto("Patatas", 2);
        Producto producto3 = new Producto("Cerveza", 3);

        Pedido pedido1 = new Pedido(cliente1);
        Pedido pedido2 = new Pedido(cliente2);
        Pedido pedido3 = new Pedido(cliente3);

        pedido1.agregarProducto(producto1);
        pedido2.agregarProducto(producto2);
        pedido3.agregarProducto(producto3);

        restaurante.agregarPedido(pedido1);
        restaurante.agregarPedido(pedido2);
        restaurante.agregarPedido(pedido3);

        restaurante.listarPedidos();

        System.out.println("\nCobrando a Stepan");
        restaurante.cobrar("1234B");
        System.out.println("\nCobrando a Boeja");
        restaurante.cobrar("1234C");
        System.out.println("\nCobrando a Ana");
        restaurante.cobrar("1234D");

        System.out.println("Pedidos cobrados ");
        restaurante.listarCobrados();

        System.out.println("\nEn la caja hay " + restaurante.getCaja() + "€");

    }


}
