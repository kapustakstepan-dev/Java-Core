package com.example.tienda;

import com.example.tienda.data.DataSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TiendaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DataSet.initListUser();
        FXMLLoader fxmlLoader = new FXMLLoader(TiendaApplication.class.getResource("main-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
