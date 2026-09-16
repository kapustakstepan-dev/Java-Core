package model;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.PrintStream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "FromAPI")
public class Product {

    @Id
    private int id;

    @Column (name = "name")
    private String title;

    @Column (name = "descripcion")
    private String description;

    @Column (name = "categoria")
    private String category;

    @Column (name = "precio")
    private double price;

    @Column (name = "stock")
    private int stock;

    public void showData(){
        System.out.println("\nid = " + id);
        System.out.println("\ntitle = " + title);
        System.out.println("\ndescription = " + description);
        System.out.println("\ncategory = " + category);
        System.out.println("\nprice = " + price);
        System.out.println("\nstock = " + stock);
    }
}
