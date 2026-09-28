package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class Bus extends Auto {

    private int numPassengers;

    public Bus(String tuition, int year, int cv, String marc, String color, int km, Owner owner, double price, int numPassengers) {
        super(tuition, year, cv, marc, color, km, owner, price);
        this.numPassengers = numPassengers;
    }

    @Override
    public void calcPrice() {
        setPrice(50000 + (getNumPassengers() *500) - (getKm() * 0.1));
        if (getPrice() < 5000) {
            setPrice(5000);
        }
    }

    @Override
    public void sell() {
        if (isSold()){
            System.out.println("Coche ya esta vendido");
            return;
        }

        if (getKm()>= 1000000){
            System.out.println("No se vende el Bus, necesita ITV");
        } else {
            setSold(true);
        }
    }

    @Override
    public String getExtra() {
        return String.valueOf(getNumPassengers());
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("numPassengers = " + numPassengers);
    }
}
