package com.example.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor@NoArgsConstructor

public class ResponseProducts {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
}
