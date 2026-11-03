package com.example.tienda.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.net.URL;
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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
