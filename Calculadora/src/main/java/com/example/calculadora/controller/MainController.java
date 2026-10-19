package com.example.calculadora.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btnAC;

    @FXML
    private Button btnBorar;

    @FXML
    private Button btnCos;

    @FXML
    private Button btnDividir;

    @FXML
    private Button btnIgual;

    @FXML
    private Button btnMultiplicar;

    @FXML
    private Button btnNumeroCinco;

    @FXML
    private Button btnNumeroCuatro;

    @FXML
    private Button btnNumeroDos;

    @FXML
    private Button btnNumeroNueve;

    @FXML
    private Button btnNumeroOcho;

    @FXML
    private Button btnNumeroSeis;

    @FXML
    private Button btnNumeroSiete;

    @FXML
    private Button btnNumeroTres;

    @FXML
    private Button btnNumeroUno;

    @FXML
    private Button btnNumeroZero;

    @FXML
    private Button btnProcentaje;

    @FXML
    private Button btnRestar;

    @FXML
    private Button btnSin;

    @FXML
    private Button btnSumar;

    @FXML
    private Button btnTan;

    @FXML
    private CheckBox chkRegistro;

    @FXML
    private Label display;

    @FXML
    private Label lblModo;

    @FXML
    private RadioButton rbBasica;

    @FXML
    private RadioButton rbCientifica;

    @FXML
    private ToggleGroup tipo;

    @FXML
    private TextArea txtRegistro;

    @FXML
    private VBox vbCientifica;

    private static final int MAX_DIGITS=12;

    private double accumulator = 0;
    private String operator = null;
    private boolean newNumber = true;
    private boolean error = false;


    @FXML
    private void initialize(){
        vbCientifica.managedProperty().bind(vbCientifica.visibleProperty());
        txtRegistro.managedProperty().bind(txtRegistro.visibleProperty());

        rbCientifica.selectedProperty()
                .addListener((obs, oldValue,newValue) ->{
                    vbCientifica.setVisible(newValue);
                    lblModo.setText(newValue ? "modo: Cientifica" : "modo: Basica");
                    resizeWindow();


        });
    }



    private void resizeWindow() {
        if (borderPane.getScene() != null && borderPane.getScene().getWindow() != null){
            borderPane.getScene().getWindow().sizeToScene();
        }
    }

}
