package com.example.tienda.controller;

import com.example.tienda.TiendaApplication;
import com.example.tienda.data.DataSet;
import com.example.tienda.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private Button btnADD, btnDetail, btnLogOut, btnRemove;

    @FXML
    private Text btnSaludo, txtAdmin, txtName ,txtUsers ;

    @FXML
    private ListView<User> listView;


    private User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initGUI();
        actions();
    }

    private void initGUI() {

       listView.setItems(DataSet.getList());
       refreshNumbers();

    }

    private void actions() {
        btnADD.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(TiendaApplication.class.getResource("register-view.fxml"));
            try {
                Parent root = loader.load();
                RegisterController registerController = loader.getController();
                registerController.setAdminController(AdminController.this);
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });
        btnRemove.setOnAction(actionEvent -> {
            User userDEl = listView.getSelectionModel().getSelectedItem();

            if (userDEl == null){
                mostrarAlerta(Alert.AlertType.WARNING, "Aviso","Selecciona un usuario de la lista");
                return;
            }
            if (userDEl == user){
                mostrarAlerta(Alert.AlertType.WARNING, "Aviso","No puedes borrarte a ti mismo");
                return;
            }

            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("User deleted");
            confirmation.setHeaderText(null);
            confirmation.setContentText("Quieres borrar a " + userDEl);
            Optional<ButtonType> response = confirmation.showAndWait();

            if (response.isPresent() && response.get() == ButtonType.OK){
                DataSet.removeUser(userDEl);
                refreshNumbers();
            }
        });

        btnDetail.setOnAction(actionEvent -> {
            User userDetail = listView.getSelectionModel().getSelectedItem();

            if (userDetail == null){
                mostrarAlerta(Alert.AlertType.WARNING, "Aviso", "Selecciona un usuario de la lista");
                return;
            }

            FXMLLoader loader = new FXMLLoader(TiendaApplication.class.getResource("detail-view.fxml"));

            try {
                Parent root = loader.load();
                DetailController detailController = loader.getController();
                detailController.setUser(userDetail);
                Stage stage =new Stage();
                stage.setTitle("Detalle");
                stage.setScene(new Scene(root));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }




        });

        btnLogOut.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader(TiendaApplication.class.getResource("main-view.fxml"));
            try {
                Parent root = loader.load();
                Stage stage = (Stage) btnLogOut.getScene().getWindow();
                stage.setScene(new Scene(root));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }

    public void refreshNumbers(){
        txtUsers.setText("El total de usuarios es de "+DataSet.getList().size());
        txtAdmin.setText("El total de usuarios es de "+DataSet.getAdmins());
    }



    public void setUser(String corrreo) {
        this.user = DataSet.getUser(corrreo);
        txtName.setText("Bienvenido "+user.getName());
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
