import java.util.ArrayList;

public class Repaso {

    public void ejercicio1(){
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Stepan");
        nombres.add("Borja");
        nombres.add("Aitaly");
        nombres.add("Pedro");
        nombres.add("Auan");
        /*System.out.println(nombres.get(1));
        nombres.set(1, "JAJAJJAJAJ" );
        System.out.println("*-*-*-*-*-*-*-*");
        System.out.println(nombres.get(1));
        System.out.println("*-*-*-*-*-*-*-*");
        nombres.remove("Stepan");
        System.out.println("*-*-*-*-*-*-*-*");
        System.out.println(nombres.size());
        System.out.println(nombres.contains("Pedro"));
        for (String item : nombres){
            System.out.println(item );
        }
        System.out.println("*-*-*-*-*-*-*-*");
        nombres.set(1, "Sofia");
        nombres.remove("Juan");
        for (String item : nombres){
            System.out.println(item);
        }
        System.out.println("*-*-*-*-*-*-*-*");*/
        /*ArrayList<String> nombres2 = new ArrayList<>(nombres);
        for (String item : nombres2){
            System.out.println(item);
        }*/
        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(i).startsWith("A")){
                nombres.remove(i);
            }
        }
        for (int i = 0; i < nombres.size(); i++) {

        }


    }

}
