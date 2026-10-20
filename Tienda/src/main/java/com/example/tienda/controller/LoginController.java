package com.example.tienda.controller;

import com.example.tienda.data.DataSet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button botonRegistro, bottonLogin;

    @FXML
    private CheckBox checkRecordar;

    @FXML
    private TextField editCorreo, editPass;

    @FXML
    private GridPane gridPane;

    @FXML
    private Text textWarning;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DataSet.initListUser();
        //En caso de pulsar el boton Login, si los datos son incorrectos
            // en el texto ->login correcto
            // en el texto ->login fallido
    }
}
