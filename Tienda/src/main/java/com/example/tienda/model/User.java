package com.example.tienda.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User {

    private Long id;
    private String name, surname, mail, pass;
    private int profile;
    private ObservableList<Product> carrito = FXCollections.observableArrayList();

    public User() {}

    public User(String name, String surname, String mail, String pass, int profile) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.pass = pass;
        this.profile = profile;
    }


    public double getTotalCarrito(){
        return carrito.stream().mapToDouble(Product::getPrice).sum();
    }



    public String getPass() {
        return pass;
    }

    public ObservableList<Product> getCarrito() {
        return carrito;
    }

    public void setCarrito(ObservableList<Product> carrito) {
        this.carrito = carrito;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }


    @Override
    public String toString() {
        return name + " " + surname;
    }
}
