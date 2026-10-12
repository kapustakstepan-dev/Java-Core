package com.example.calculadora.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btnAC;

    @FXML
    private Button btnBorar;

    @FXML
    private Button btnComa;

    @FXML
    private Button btnDividir;

    @FXML
    private Button btnIgual;

    @FXML
    private Button btnMultiplicar;

    @FXML
    private Button btnNUmeroSeis;

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
    private Button btnSumar;

    @FXML
    private Button btnCambioSigno;

    @FXML
    private Label display;


    @FXML
    private void initialize(){
        display.setStyle("-fx-text-fill: white;");
        borderPane.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        btnBorar.setStyle("-fx-background-color: lightgrey; -fx-text-fill: white;");
        btnAC.setStyle("-fx-background-color: lightgrey; -fx-text-fill: white;");
        btnProcentaje.setStyle("-fx-background-color: lightgrey; -fx-text-fill: white;");
        btnDividir.setStyle("-fx-background-color: orange; -fx-text-fill: white;");
        btnMultiplicar.setStyle("-fx-background-color: orange; -fx-text-fill: white;");
        btnRestar.setStyle("-fx-background-color: orange; -fx-text-fill: white;");
        btnSumar.setStyle("-fx-background-color: orange; -fx-text-fill: white;");
        btnIgual.setStyle("-fx-background-color: orange; -fx-text-fill: white;");
        btnNumeroUno.setStyle("-fx-background-color: darkgrey;");
        btnNumeroDos.setStyle("-fx-background-color: darkgrey;");
        btnNumeroTres.setStyle("-fx-background-color: darkgrey;");
        btnNumeroCuatro.setStyle("-fx-background-color: darkgrey;");
        btnNumeroCinco.setStyle("-fx-background-color: darkgrey;");
        btnNUmeroSeis.setStyle("-fx-background-color: darkgrey;");
        btnNumeroSiete.setStyle("-fx-background-color: darkgrey;");
        btnNumeroOcho.setStyle("-fx-background-color: darkgrey;");
        btnNumeroNueve.setStyle("-fx-background-color: darkgrey;");
        btnNumeroZero.setStyle("-fx-background-color: darkgrey;");
        btnCambioSigno.setStyle("-fx-background-color: darkgrey;");
        btnComa.setStyle("-fx-background-color: darkgrey;");

    }

}
