package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class Truck extends Auto {

    private double maxLoad;

    public Truck(String tuition, int year, int cv, String marc, String color, int km, Owner owner, double price, double maxLoad) {
        super(tuition, year, cv, marc, color, km, owner, price);
        this.maxLoad = maxLoad;
    }

    @Override
    public void calcPrice() {
        setPrice(30000 + (getMaxLoad()*2000) - (getKm()*0.08));
        if (getPrice() < 3000){
            setPrice(3000);
        }
    }

    @Override
    public void sell() {
        if (isSold()){
            System.out.println("a esta vendido");
        } else {
            System.out.println("Aviso para conducir al camion necesitas categoria C");
            setSold(true);
        }
    }

    @Override
    public String getExtra() {
        return String.valueOf(getMaxLoad());
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("maxLoad = " + maxLoad);
    }
}
