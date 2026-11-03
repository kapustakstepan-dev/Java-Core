package com.example.tienda.controller;

import com.example.tienda.data.DataSet;
import com.example.tienda.model.Product;
import com.example.tienda.model.ResponseProducts;
import com.google.gson.Gson;
import com.sun.source.util.TaskListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.util.function.Predicate;

public class UserController implements Initializable {

    @FXML
    private Button btnComp, btnLOGOUT, btnVac, btnVerCar;

    @FXML
    private TableColumn<?, ?> colID, colName, colPrice;

    @FXML
    private TextField editFiltrar;

    @FXML
    private TableView<Product> tableViewProd;

    @FXML
    private Text txtTotal;

    private Task<List<Product>> tasklist;
    private ObservableList<Product> observableListProducts;
    private FilteredList<Product> filteredListProducts;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instances();
        initGUI();
        actions();
    }

    private void actions() {
        editFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
               // System.out.println(newValue);
                filteredListProducts.setPredicate(new Predicate<Product>() {
                    @Override
                    public boolean test(Product product) {
                        return product.getTitle().contains(newValue);
                    }
                });
            }
        });
        btnComp.setOnAction(actionEvent -> {
            //ver cual es el seleccionado
                //seletedModel -> selectedIndex/ selectedItem
            Product productSelected = tableViewProd.getSelectionModel().getSelectedItem();
            if (productSelected!=null){
                productSelected.mostrarDatos();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Info product");
                alert.setContentText("No hay seleccion");
                alert.showAndWait();

            }



        });
    }

    private void initGUI() {
        Thread thread = new Thread(tasklist);
        thread.setDaemon(true);
        thread.start();
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("title"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tasklist.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
               // tasklist.getValue().forEach(Product::mostrarDatos);
                observableListProducts = FXCollections.observableArrayList(tasklist.getValue());
                System.out.println(observableListProducts.size());
                filteredListProducts = new FilteredList<>(observableListProducts);
                tableViewProd.setItems(filteredListProducts);
            }
        });
    }

    private void instances() {

        tasklist = new Task<List<Product>>() {
            @Override
            protected List<Product> call() throws Exception {
                try {
                    Gson gson = new Gson();
                    String URL = "https://dummyjson.com/products";
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).GET().build();
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    String body = response.body();

                    System.out.println("asd");
                    ResponseProducts responseProducts = gson.fromJson(body, ResponseProducts.class);
                    System.out.println("qwe");

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
