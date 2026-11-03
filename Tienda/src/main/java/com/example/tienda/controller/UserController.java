package com.example.tienda.controller;

import com.example.tienda.data.DataSet;
import com.example.tienda.model.Product;
import com.example.tienda.model.ResponseProducts;
import com.google.gson.Gson;
import com.sun.source.util.TaskListener;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    private Button btnComp, btnLOGOUT, btnVac, btnVerCar;

    @FXML
    private TableColumn<?, ?> colID, colNamem, colPrice;

    @FXML
    private TextField editFiltrar;

    @FXML
    private TableView<?> tableViewProd;

    @FXML
    private Text txtTotal;

    private Task<List<Product>> tasklist;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instances();
        initGUI();
    }

    private void initGUI() {
        Thread thread = new Thread(tasklist);
        thread.setDaemon(true);
        thread.start();
    }

    private void instances() {

        tasklist = new Task<List<Product>>() {
            @Override
            protected List<Product> call() throws Exception {
                try {
                    Gson gson = null;
                    String URL = "https://dummyjson.com/products";
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).GET().build();
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    String body = response.body();

                    ResponseProducts responseProducts = gson.fromJson(body, ResponseProducts.class);
                    return responseProducts.getProducts();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                return new ArrayList<Product>();
            }
        };

        //cargar JSON en la tabla

    }




}
