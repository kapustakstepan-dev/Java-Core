package com.example.tienda.controller;

import com.example.tienda.TiendaApplication;
import com.example.tienda.data.DataSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import static org.controlsfx.control.action.ActionMap.action;

public class LoginController implements Initializable, EventHandler<ActionEvent> {

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

    @FXML
    private ComboBox<?> comboProfile;

    @FXML
    private TextField editPass2;

    @FXML
    private Spinner<?> spinnerAge;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurname;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        action();

        //En caso de pulsar el boton Login, si los datos son incorrectos
            // en el texto ->login correcto
            // en el texto ->login fallido
    }

    private void action() {
        bottonLogin.setOnAction(this);
        botonRegistro.setOnAction(this);


    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bottonLogin){
            String mail = editCorreo.getText();
            String pass = editPass.getText();
            int loginNumeber = DataSet.getLogin(mail,pass);
            if (loginNumeber!=-1){
                textWarning.setFill(Color.GREEN);
                System.out.print("Login corecto");
            } else {
                textWarning.setFill(Color.RED);
                System.out.print("Login incorecto");
            }

        } else if (actionEvent.getSource() == botonRegistro) {
            FXMLLoader loader = new FXMLLoader(TiendaApplication.class.getResource("register-view.fxml"));
            try {
                Stage stage = (Stage) botonRegistro.getScene().getWindow();
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                // TODO mensaje de aviso
                throw new RuntimeException(e);
            }
        }

    }
}
