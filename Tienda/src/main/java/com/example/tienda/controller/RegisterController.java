package com.example.tienda.controller;

import com.example.tienda.TiendaApplication;
import com.example.tienda.data.DataSet;
import com.example.tienda.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
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

    private AdminController adminController;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instances();
        initGUI();
        actions();


    }

    public void setAdminController(AdminController adminController){
        this.adminController = adminController;
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

    private void actions() {
        botonRegistro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int selectionSpinner = spinnerAge.getValue();
                //String selectionCombo = comboProfile.getValue();
                //String selectionCombo = comboProfile.getSelectionModel().getSelectedItem();
                int seleccionIndexCombo = comboProfile.getSelectionModel().getSelectedIndex();

                String name = txtName.getText();
                String surname = txtSurname.getText();
                String mail = editCorreo.getText();
                String pass = editPass.getText();
                String pass2 = editPass2.getText();


                if (name.isEmpty() && surname.isEmpty() && pass.isEmpty() && mail.isEmpty() && seleccionIndexCombo>-1){
                    User user = new User(name,surname,mail,pass,seleccionIndexCombo);
                    /*
                    if (DataSet.addUser(user)){
                        //ir al login

                        FXMLLoader loader = new FXMLLoader(TiendaApplication.class.getResource("main-view.fxml"));
                        Stage stage = (Stage) botonRegistro.getScene().getWindow();
                        try {
                            Parent root = loader.load();
                            Scene scene = new Scene(root);
                            stage.setScene(scene);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }


                        Stage stage = (Stage) botonRegistro.getScene().getWindow();
                        stage.close();

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setContentText("Correo es duplicado");
                        alert.show();
                    }

                     */
                    mostrarAlerta(Alert.AlertType.ERROR, "ERROR", "Faltan los datos");
                    return;
                }

                if (!pass.equals(pass2)){
                    mostrarAlerta(Alert.AlertType.ERROR, "ERROR","No coinciden los passwoeds");
                    return;
                }

                User user = new User(name,surname,mail,pass,seleccionIndexCombo);

                if (DataSet.addUser(user)){
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Registrado",
                            "User " + name + " con mail: " + mail+ " esta registrado");
                    volver();
                } else {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error", "Ya existe un usuario con el correo " + mail);
                }
                //System.out.println("Spinner "+ selectionSpinner);
                //System.out.println("Combo "+ comboProfile );
            }
        });

        bottonLogin.setOnAction(actionEvent -> volver());
    }

    private void volver(){
        Stage stage = (Stage) botonRegistro.getScene().getWindow();

        if (adminController !=null){
            adminController.refreshNumbers();
            stage.close();
        } else {
            FXMLLoader loader = new FXMLLoader(TiendaApplication.class.getResource("main-view.fxml"));
            try {
                Parent root = loader.load();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
