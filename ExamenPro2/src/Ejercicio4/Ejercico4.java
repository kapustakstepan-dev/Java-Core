package Ejercicio4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class Ejercico4 {
    private ArrayList<Object[]> listaContactos;

    public Ejercico4() {
        listaContactos = new ArrayList<>();
    }

    public void aniadirContactoe(Object[] contacto) {
        if (buscarContactoCorreo(contacto[1].toString()) == null) {
            System.out.println("Contacto aniadido correctamente");
            listaContactos.add(contacto);
        } else {
            System.out.println("Contacto no se puede porduplicado");
        }
    }

    public Object[] buscarContactoCorreo(String correo) {
        for (Object[] contacto : listaContactos) {
            if (correo.equals(contacto[1])) {
                return contacto;
            }
        }
        return null;
    }

    public void listarContactos() {
        if (listaContactos.isEmpty()) {
            System.out.println("Lista esta vacia ");
        } else {
            int contador = 0;
            for (Object[] contacto : listaContactos) {
                System.out.println("Imprimiendo contacto " + contador);
                for (Object dato : contacto) {
                    System.out.println("\t" + dato);
                }
                contador++;
            }
        }
    }

    public Object[] buscarContactoNombre(String nombre) {
        for (Object[] contacto : listaContactos) {
            if (nombre.equals(contacto[0])) {
                return contacto;
            }
        }
        return null;
    }

    public void eliminarObject(String correo) {
        if (listaContactos.remove(buscarContactoCorreo(correo))) {
            System.out.println("Contacto borraddo correctamente");
        } else {
            System.out.println("No se encontra");
        }
    }

    public void eliminarPosicion(String correo) {
        for (int i = 0; i < listaContactos.size(); i++) {
            if (listaContactos.get(i)[1].equals(correo)) {
                listaContactos.remove(i);
                break;
            }
        }
    }

    public void eliminarNombre(String nombre) {
        listaContactos.removeIf(new Predicate<Object[]>() {
            @Override
            public boolean test(Object[] objects) {
                return nombre.equals(objects[0]);
            }
        });
    }

    public void ordenarListaEdad() {
        Object[] mayor = listaContactos.getFirst();
        for (Object[] contacto : listaContactos) {
            if ((int) contacto[3] > (int) mayor[3]) {
                mayor = contacto;
            }
        }
        System.out.println("El contacto mayor de tu lista es " + mayor[0]);
    }

    public void vaciarLista() {
        listaContactos.clear();
    }

    public void compararPorEdad() {


        listaContactos.sort(new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                if ((int) o1[3] > (int) o2[3]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

    }
}
