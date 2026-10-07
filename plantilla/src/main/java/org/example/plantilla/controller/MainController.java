package org.example.plantilla.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button btnSalir, btnSaludar, btnVaciar;

    @FXML
    private TextField editNombre;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle){
        System.out.println("Inicializando la parte logica.");
        initanse();
        initGUI();
        actions();

    }


    public void initanse(){

    }
    public void initGUI(){

    }
    public void actions(){

    }

}
