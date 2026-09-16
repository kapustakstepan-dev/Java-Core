package Ejercicio4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainOrdenacion {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(90);
        numeros.add(10);

        ArrayList<String> palabras = new ArrayList<>();

        palabras.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()){
                    return -1;
                } else if (o1.length() < o2.length()){
                    return 1;}
                return 0;
            }
        });


        for (String item:palabras){
            System.out.println(item);
        }

        palabras.add("asdadsa");
        palabras.add("asdasdad");
        palabras.add("fsdfsdfsdfsdf");




        int menor = numeros.getFirst();
        int mayor = numeros.getFirst();

        for (int item : numeros) {
            if (mayor > item) {
                mayor = item;
            }
            if (menor > item) {
                mayor   = item;
            }
        }
        System.out.print(menor);
        System.out.print(mayor);


        Collections.sort(numeros);

        for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.get(i));

        }


    }
}