module com.example.tienda {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.base;
    requires org.json;
    requires com.google.gson;
    requires java.net.http;
    requires jdk.compiler;
    requires static lombok;


    opens com.example.tienda to javafx.fxml;
    exports com.example.tienda;
    exports com.example.tienda.controller;
    opens com.example.tienda.controller to javafx.fxml, org.json, com.google.gson;
    exports com.example.tienda.data;
    opens com.example.tienda.data to javafx.fxml,  org.json, com.google.gson;
    exports com.example.tienda.model;
    opens com.example.tienda.model to org.json, com.google.gson;

}