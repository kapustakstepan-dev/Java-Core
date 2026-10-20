package com.example.tienda.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button botonRegistro, bottonLogin;

    @FXML
    private CheckBox checkRecordar;

    @FXML
    private TextField editCorreo, editPass, txtName, txtSurname, editPass2;

    @FXML
    private GridPane gridPane;

    @FXML
    private Text textWarning;

    @FXML
    private ObservableList<String> profileList;

    @FXML
    private ComboBox<String> comboProfile;

    private SpinnerValueFactory<Integer> spinnerValueFactory;

    @FXML
    private Spinner<Integer> spinnerAge;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instances();
        initGUI();
        actions();


    }

    private void actions() {
        botonRegistro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int selectionSpinner = spinnerAge.getValue();
                //String selectionCombo = comboProfile.getValue();
                String selectionCombo = comboProfile.getSelectionModel().getSelectedItem();




                System.out.println("Spinner "+ selectionSpinner);
                System.out.println("Combo "+selectionCombo);



            }
        });

    }

    private void instances() {
        spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(18,99,18,1);

        profileList = FXCollections.observableArrayList();
        profileList.addAll("Admin", "User");

    }

    //TODO en la pantalla de registro sacar todos los datos que introduzcas i guardar en la lista como un User.

    private void initGUI() {
        //lista de elementos
        comboProfile.setItems(profileList);

        //modelo de elementos
        spinnerAge.setValueFactory(spinnerValueFactory);


    }


}
