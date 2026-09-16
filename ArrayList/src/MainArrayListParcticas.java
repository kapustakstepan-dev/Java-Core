import java.util.ArrayList;

public class MainArrayListParcticas {
    public static void main(String[] args) {

        /*ArrayList<String> frutas = new ArrayList<>();
        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Platano");
        System.out.println(frutas);
        System.out.println("*-*-*-*-*");
        frutas.add(1,"Naranja");
        System.out.println(frutas);
        System.out.println("*-*-*-*-*");
        int posicion = frutas.indexOf("Pera");
        System.out.println(posicion);
        String f = frutas.get(2);
        System.out.println(f);
        System.out.println("*-*-*-*-*");
        frutas.set(2,"Uvas");
        System.out.println(frutas);
        System.out.println("*-*-*-*-*");
        frutas.remove("Naranja");
        System.out.println(frutas);
        frutas.remove(0);
        System.out.println(frutas);
         */

    }
    public void ejercicio1(){
        ArrayList<String> animales = new ArrayList<>();

        animales.add("Perro");
        animales.add("Gato");
        animales.add("Loro");
        animales.add("Conejo");
        animales.add(2,"Tortuga");
        animales.set(animales.indexOf("Loro"), "Canario");
        animales.remove("Gato");
        for (String item : animales){
            System.out.println(item);
        }
    }
    public void ejercicio2(){
        ArrayList<String> ciudades = new ArrayList<>();
        ciudades.add("Madrid");
        ciudades.add("Roma");
        ciudades.add("Paris");
        ciudades.contains("Berlin");
        ciudades.add(0,"Berlin");
        


    }
}
