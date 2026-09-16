import javax.imageio.ImageTranscoder;
import java.util.HashMap;
import java.util.Set;

public class gestion {
    HashMap<String, Object[]> garaje;

    public gestion() {
        garaje = new HashMap<>();
    }

    public void anadirCoche(Object[] coche) {
        if (garaje.putIfAbsent(coche[0].toString(), coche) == null) {
            System.out.println("Coche esta guardado: ");
        } else {
            System.out.println("No se puede guardar coche, ya esta en la lista ");
        }
    }

    public void buscarCoche(String matricula) {
        Object[] coche = garaje.get(matricula);
        if (coche == null) {
            System.out.println("No esta coche con esa matricula en el garaje");
        } else {
            System.out.println("Datos del coche ");
            for (Object item : coche) {
                System.out.println("\t " + item);
            }
        }
    }

    public void listarCoches() {
        Set<String> clave = garaje.keySet();
        if (clave.isEmpty()) {
            System.out.println("Garaje es vacio");
        } else {
            for (String matricula : clave) {
                buscarCoche(matricula);
            }
        }
    }

    public void mostrarCostes(String matricula) {
        Object[] coche = garaje.get(matricula);
        if (coche == null) {
            System.out.println("Coche no wsta en el garage");
        } else {
            System.out.println("El precio  de reparacio del coche " + coche[0] + " precio fainal es " + coche[3]);
        }

    }

    public void eliminarCoche(String matricula) {
        if (garaje.remove(matricula) != null) {
            System.out.println("Coche esta eliminado ");
        } else {
            System.out.println("Coche con esta matricula no se puede eliminar");
        }
    }

    public void vaciorGaraje() {
        garaje.clear();
        listarCoches();
    }
}
