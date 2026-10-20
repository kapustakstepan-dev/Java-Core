package com.example.buttons.controller;

import com.example.buttons.MyApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
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
    private TextArea textArea;

    @FXML
    private RadioButton radio1, radio2, radio3, radio4;

    @FXML
    private ToggleButton toggle;

    private ToggleGroup grupoRadio;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instances();
        initGUI();
        actions();
    }

    private void instances() {
        grupoRadio = new ToggleGroup();
    }

    private void actions() {
        check1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                toggle.setDisable(!newValue);
                textArea.appendText("Selected check " +newValue+"\n");
            }
        });
        toggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                check1.setDisable(!newValue);
                textArea.appendText("Selected check " +newValue+"\n");
            }
        });
        grupoRadio.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                textArea.appendText(((RadioButton)newValue).getText()+"\n");
            }
        });
        boton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean estadoCheck = check1.isSelected();
                boolean estadoToggele = toggle.isSelected();
                RadioButton estadoGrupo = (RadioButton) grupoRadio.getSelectedToggle();
                textArea.appendText("Selected formulario\n");
                textArea.appendText("Check "+estadoCheck +"\n");
                textArea.appendText("Toggle "+estadoToggele +"\n");
                textArea.appendText("RadioButton "+estadoGrupo +"\n");




            }
        });


    }


    private void initGUI() {
        textArea.setEditable(false); // no se puede escribir en textArea


        //textArea.setText("fda\ndsa"); // escribe el texto
        //textArea.appendText("faas\nad"); // escribe el texto

        grupoRadio.getToggles().setAll(radio1,radio2,radio3,radio4);
        // al boton 1 le pongo una imagen
        configButton(boton1, "images/koala.png");
        configButton(boton2, "images/stop.png");
    }

    private void configButton(Button button, String path) {

        button.setGraphic(new ImageView(
                new Image(Objects.requireNonNull(MyApplication.class.getResourceAsStream(path)))));
        button.setText("");
        button.setBackground(null);
        button.setBorder(null);
        button.setOnMouseEntered(new ManejoRaton());
        button.setOnMouseExited(new ManejoRaton());
        button.setOnMousePressed(new ManejoRaton());
        button.setOnMouseReleased(new ManejoRaton());

    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            Button button = (Button) event.getSource();
            if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                button.setEffect(new DropShadow());
                button.setCursor(Cursor.HAND);
            } else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                button.setCursor(Cursor.CLOSED_HAND);
            } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                button.setCursor(Cursor.OPEN_HAND);
            } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                button.setEffect(null);
                button.setCursor(Cursor.CROSSHAIR);
            }
        }
    }


}
