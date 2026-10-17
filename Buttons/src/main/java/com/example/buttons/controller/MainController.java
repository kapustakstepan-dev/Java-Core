package com.example.buttons.controller;

import com.example.buttons.MyApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.Blend;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button boton1, boton2;

    @FXML
    private CheckBox check1, check2;

    @FXML
    private FlowPane flowRadio;

    @FXML
    private GridPane gridGeneral;

    @FXML
    private ImageView image;

    @FXML
    private Label label1, label2;

    @FXML
    private RadioButton radio1, radio2, radio3, radio4;

    @FXML
    private ToggleButton toggle;

    private ToggleGroup grupoRadio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actions();
        instences();
        initGUI();
    }

    private void instences() {
        grupoRadio = new ToggleGroup();
    }

    private void initGUI() {

        grupoRadio.getToggles().setAll(radio1,radio2,radio3,radio4);

        //al boton 1 pongo una imagen
        configButton(boton1, "images/application.png");
        configButton(boton2, "images/stop.png");

    }

    private void actions() {
        check1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                toggle.setDisable(!newValue);
            }
        });
        toggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                check1.setDisable(!newValue);
            }
        });
        grupoRadio.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.printf(((RadioButton)t1).getText());

            }
        });
    }
    private void configButton(Button button, String path){
        button.setGraphic(new ImageView(new Image(Objects.requireNonNull(MyApplication.class.getResourceAsStream(path)))));
        button.setText("");
        button.setBackground(null);
        button.setBorder(null);
        button.setOnMouseExited(new ManejoRaton());
        button.setOnMouseEntered(new ManejoRaton());
    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            Button button = (Button) mouseEvent.getSource();
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                button.setEffect(new DropShadow());
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                button.setEffect(null);
            }
        }
    }





}
