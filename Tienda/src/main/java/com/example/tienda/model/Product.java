package com.example.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private long id;
    private String title;
    private String description;
    private double price;
    private double discountPercentage;
    private long stock;

    public void mostrarDatos(){
        System.out.println("title = " + title);
        System.out.println("description = " + description);
        System.out.println("price = " + price);
        System.out.println("discountPercentage = " + discountPercentage);
        System.out.println("stock = " + stock);

    }

    @Override
    public String toString() {
        return getTitle() + " " +
                "price=" + price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
}