package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor


public class Car extends Auto{

    private int numDoors;


    public Car(String tuition, int year, int cv, String marc, String color, int km, Owner owner, double price,
               int numDoors) {
        super(tuition, year, cv, marc, color, km, owner, price);
        this.numDoors = numDoors;
    }

    @Override
    public void calcPrice() {
        setPrice(10000 + (getCv()*100) - (getKm()*0.05));
        if (getPrice() <1000){
            setPrice(1000);
        }
    }

    @Override
    public void sell() {
        if (isSold()){
            System.out.println("Ya esta vendido");
        } else {
            if (getOwner().getEmail().contains("@")){
                setSold(true);
            }
        }

    }

    @Override
    public String getExtra() {
        return String.valueOf(getNumDoors());
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("numDoors = " + numDoors);
    }
}
