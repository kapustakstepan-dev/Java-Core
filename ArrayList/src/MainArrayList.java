import java.util.ArrayList;

public class MainArrayList {
    public static void main(String[] args) {
        ArrayList listaDatos = new ArrayList();

        System.out.println("El tamanio actual de la lista es " + listaDatos.size());
        //[]
        listaDatos.add(1);
        listaDatos.add(2);
        listaDatos.add(3);
        listaDatos.add(4);
        listaDatos.add("palabras");
        listaDatos.add(new Object[]{1,"dato",false, 0.0});
        System.out.println("El tamanio actual de la lista es " + listaDatos.size());
        System.out.println("Procedemos a sacar tof#dos de la lista");
        for (Object item : listaDatos){
            System.out.println(item);
        }
        Object[] temporal = (Object[])listaDatos.getLast();
        temporal[0] = 999;

        for (Object item: (Object[])listaDatos.getLast()){
            System.out.println(item);
        }
        Object item = listaDatos.getFirst();
        item = false;
        for (Object data : listaDatos){
            System.out.println(data);
        }


    }

}
