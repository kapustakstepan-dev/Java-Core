package Ejercicio4;
public class Ejercicicoexamen3 {

    private Object[][] lista;

    public void tabla() {
        lista = new Object[10][4];
    }

    public void agregarPersona(String nombre,
                               String apellido,
                               int telefono,
                               String dni) {
        int huecosLlenos = 0;
        Object[] personaBuscada = estaPersona(dni);
        if (personaBuscada != null) {
            System.out.println("la persona esta guardada. ");
        } else {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i][0] == null) {
                    lista[i] = new Object[]{nombre, apellido, telefono, dni};
                    System.out.println("Guardado corectamente: ");
                    break;
                } else {
                    huecosLlenos++;
                }
            }
            if (huecosLlenos == lista.length){
                System.out.println("No hay sitio para personas: ");
            }
        }
    }
    private Object[] estaPersona(String dni) {
        for (Object[] item : lista) {
            if (item[3] != null && item[3].equals(dni)) {
                return item;
            }
        }
        return null;
    }

    public void obtenerInfo(String dni){
        if (estaPersona(dni) != null){
            for ( Object dato : estaPersona(dni)){
                System.out.println(dato);
            }
        } else{
            System.out.println("No esta la persona ");
        }
    }

    public void listarPersona() {
        for (Object[] item : lista) {
            for (Object p : item) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }

}
