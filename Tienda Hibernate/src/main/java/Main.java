import controller.TiendaController;
import model.Product;
import model.Profile;
import model.User;

public class Main {

    public static void main(String[] args) {
        Profile profile = new Profile();
        Product product = new Product();
        //profile.setId(2L);

        System.out.println("Gestor TIENDA");
        TiendaController controller = new TiendaController();
        //controller.signInUser(new User("Borja", "Martin", "borja@gmail.com", "123123", profile));
        //controller.loginUser(5);
        //controller.findUsers("Borja");
        //controller.updateUser("Borja", "Martin","nuevo@gmail.com");
        //controller.importProducts();
        //controller.getProfileUser(5);
        //controller.getUsersProfile(2);


        controller.showData();
        //controller.uptadeStock(1, 10);
        //controller.cambioPrecio(12, 2999.99);
        //controller.compra(5, 12, 1);
        //controller.eliminarProducto(30);
    }


}