package com.example.tienda.controller;

import com.almasb.fxgl.app.scene.Pixel;
import com.example.tienda.TiendaApplication;
import com.example.tienda.data.DataSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
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
        //cargar JSON en la tabla




    }

}
