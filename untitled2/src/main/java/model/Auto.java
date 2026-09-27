package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor

public abstract class Auto implements Serializable {
    private static final long  serializableVersionUID = 1234L;


    private String tuition;
    private int year;
    private int cv;
    private String marc;
    private String color;
    private int km;
    private boolean sold;
    private Owner owner;
    private double price;


    public Auto(String tuition, int year, int cv, String marc, String color, int km, Owner owner, double price) {
        this.tuition = tuition;
        this.year = year;
        this.cv = cv;
        this.marc = marc;
        this.color = color;
        this.km = km;
        //this.sold = sold;
        this.owner = owner;
        this.price = price;
    }

    public abstract void calcPrice();

    public abstract void sell();

    public abstract String getExtra();



    public void showData(){
        System.out.println("tuition = " + tuition);
        System.out.println("year = " + year);
        System.out.println("cv = " + cv);
        System.out.println("marc = " + marc);
        System.out.println("color = " + color);
        System.out.println("km = " + km);
        System.out.println("price = " + price);
    }

}
