package controller;

import com.google.gson.Gson;
import dao.ProductDAO;
import dao.UserDAO;
import model.Product;
import model.ProductResponse;
import model.Profile;
import model.User;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class TiendaController {

    private UserDAO userDAO;
    private ProductDAO productDAO;

    public TiendaController() {
        userDAO = new UserDAO();
        productDAO = new ProductDAO();
    }

    public void signInUser(User user) {
        // logica de negocio
        // dar de alta un usuario
        userDAO.insertUser(user);
        // mandarle un correo de bienvenida
        // activarle una caracteristica de 1ª compra
    }

    public void loginUser(int id) {
        User user = userDAO.getUserById(id);
        if (user != null) {
            user.showData();
        } else {
            System.out.println("No existe este usuario");
        }
    }

    public void findUsers(String name) {
        List<User> lista = userDAO.getUserByName(name);
        if (!lista.isEmpty()) {
            lista.forEach(User::showData);
        } else {
            System.out.println("No hay usuarios con la condicioon de busqueda");
        }
    }

    public void updateUser(String name, String lastName, String newMail) {
        User user = userDAO.updateUserByLastNameAndName(name, lastName, newMail);
        if (user != null) {
            System.out.println("Actualizados los datos del usuarios: ");
            user.showData();
        } else {
            System.out.println("No se han encontrado usuarios con los criterios");
        }
    }

    public void importProducts() {
        HttpClient client;
        Gson gson = new Gson();
        try {
            client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .GET()
                    .uri(URI.create("https://dummyjson.com/products"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ProductResponse productResponse = gson.fromJson(response.body(), ProductResponse.class);
            productDAO.insertProducts(productResponse.getProducts());

            if (productResponse != null && productResponse.getProducts() !=null){
                productDAO.insertProducts(productResponse.getProducts());
                System.out.println("Insertaron los productos al Base de Datos");
            } else {
                System.out.println("sin respuesta");
            }

        } catch (Exception e) {
            System.out.println("Fallo en la conexion");
            e.printStackTrace();
        }
    }

    public void getProfileUser(int id){
        User user = userDAO.getUserById(id);
        if(user != null){
            System.out.println("El perfil del usuario es ");
            System.out.println(user.getProfile().getName());
        }

    }

    public void getUsersProfile(int id){
        List<User> users = userDAO.getUsersByProfile(id);
        if (users != null){
            users.forEach(User::showData);
        }
    }

    public void uptadeStock(int id, int cantidad){
        Product product = productDAO.compraProducto(id, cantidad);
        if (product != null){
            System.out.printf("Compraste producto con id %d en cantidad %d", id, cantidad);
        } else {
            System.out.println("No se encuentra este producto");
        }
    }

    public void cambioPrecio(int id, double price){
        Product product = productDAO.cambioDePrecio(id, price);
        if (product!=null){
            System.out.printf("Cambiaste el precio en producto con id %d por %d euros", id, price);
        } else {
            System.out.println("No se encuentra el producto");
        }
    }

    public void showData(){
        List<Product> lista = productDAO.showData();
        if (lista.isEmpty()){
            System.out.println("El stock es bacio");
        } else {
            System.out.println("Los productos de stock son siguientes:\n");
            lista.forEach(p -> {
                System.out.printf("ID: %d %n Name: %s %n Descripcion: %s %n Categoria: %s %n Precio: %.2f euros %n Cantidad: %d %n",
                        p.getId(), p.getTitle(), p.getDescription(), p.getCategory(), p.getPrice(), p.getStock());
            });
        }
    }

    public void compra(int idUser, int idProducto, int cantidad){
        Product product = productDAO.compra(idUser, idProducto, cantidad);
        if (product != null){
            System.out.println("Gracias por comprar un producto en nuestro stock ");
        } else {
            System.out.println("No se encuentra el producto en el stock");
        }
    }

    public void eliminarProducto(int id){
        Product product = productDAO.eliminarProducto(id);
        if (product != null){
            System.out.println("Eliminaste el producto con id " + product.getId());
        } else {
            System.out.println("No se puede eliminar el producto");
        }
    }

}