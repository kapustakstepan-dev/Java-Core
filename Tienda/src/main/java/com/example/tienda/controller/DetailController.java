package com.example.tienda.controller;


import com.example.tienda.model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {
    @FXML
    private Text txtNombre, txtApellido, txtCorreo, txtPerfil;

    @FXML
    private Button btnCerrar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnCerrar.setOnAction(actionEvent -> {
            Stage stage = (Stage) btnCerrar.getScene().getWindow();
            stage.close();
        });
    }

    public void setUser(User user){
        txtNombre.setText(user.getName());
        txtApellido.setText(user.getSurname());
        txtCorreo.setText(user.getMail());
        txtPerfil.setText(user.getProfile() == 0 ? "Admin" : "User");

    }
}
