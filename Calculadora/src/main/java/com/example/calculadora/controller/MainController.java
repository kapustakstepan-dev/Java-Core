package com.example.calculadora.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

        chkRegistro.selectedProperty()
                .addListener((obs, oldValue,newValue) ->{
                    vbCientifica.setVisible(newValue);
                    resizeWindow();
                });





    }

    private void pressDigits(String digit){
        if (error){
            clearAll();
        }

        if (newNumber || display.getText().equals("0")){
            display.setText(digit);
            newNumber=false;
        } else if (countDigit(display.getText())<= MAX_DIGITS) {
            display.setText(display.getText() + digit);
        }
    }

    private void pressOperator(String operator){
        if (error){
            clearAll();
        }



    }

    private int countDigit(String text) {
        return (int) text.chars().filter(Character::isDigit).count();
    }

    private void clearAll() {
        display.setText("0");
        accumulator=0;
        operator=null;
        newNumber=true;
        error=false;
    }

    private void deleteLast(){
        if (error){
            clearAll();
            return;
        }

        if (newNumber){
            return;
        }

        String text = display.getText();
        text = text.substring(0, text.length() -1);

        if (text.isEmpty() || text.equals("-")){
            text = "0";
            newNumber=true;
        }

        display.setText(text);
    }


    private void resizeWindow() {
        if (borderPane.getScene() != null && borderPane.getScene().getWindow() != null){
            borderPane.getScene().getWindow().sizeToScene();
        }
    }

    private double readDisplay(){
        return Double.parseDouble(display.getText().replace(",","."));
    }

    private void showData(double value){
        if (Double.isNaN(value) || Double.isInfinite(value)){
            showError();
            return;
        }
        String text = format(value);
    }

    private String format(double value) {
        BigDecimal bigDecimal = new BigDecimal(value).setScale(10, RoundingMode.HALF_UP).stripTrailingZeros();
        if (bigDecimal.compareTo(BigDecimal.ZERO) == 0){
            return "0";
        }
        return bigDecimal.toPlainString().replace(",", ".");
    }

    private void showError() {
        display.setText("Error");
        error = true;
        operator = null;
        newNumber = true;
    }
    private void addHistory(String text){
        txtRegistro.appendText(text+ "\n");
    }
}
