package org.example.plantilla.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button btnSalir, btnSaludar, btnVaciar;

    @FXML
    private TextField editNombre;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle){
        System.out.println("Inicializando la parte logica.");
        initanse();
        initGUI();
        actions();



    }


    public void initanse(){

    }
    public void initGUI(){

    }
    public void actions(){
        btnSaludar.setOnAction(new ManejoPulsaciones());
        btnSalir.setOnAction(new ManejoPulsaciones());
        btnVaciar.setOnAction(new ManejoPulsaciones());

        btnSaludar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Raton por encima");
                btnSaludar.setCursor(Cursor.HAND);
            }
        });

        /*btnSaludar.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Raton saliendo");
                btnSaludar.setCursor(Cursor.CROSSHAIR);

            }
        });

         */

        btnSaludar.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Raton saliendo");
                btnSaludar.setCursor(Cursor.CROSSHAIR);            }
        });

    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Raton generica");
            btnSaludar.setCursor(Cursor.CROSSHAIR);

            if (actionEvent)
        }
    }

    class ManejoRaton implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {

            System.out.println("Raton por encima");
            btnSaludar.setCursor(Cursor.HAND);
        }
    }



}
