import java.util.HashMap;
import java.util.Set;

public class GarajeControler {

    private HashMap<String, Object[]> garaje;

    public GarajeControler(){
        garaje = new HashMap<>();
    }

    public void aniadirCoche(Object[] coche){
        if (garaje.putIfAbsent(coche[0].toString(), coche) == null){
            System.out.println("Coche guardado correctamente.");
        } else {
            System.out.println("El coche ya está en la lista, NO se puede agregar.");
        }
    }

    public void obtenerTamano(){
        System.out.println("El tamaño del garaje es " + garaje.size());
    }

    public void eliminarCoche(String matricula){
        if (garaje.remove(matricula) == null){
            System.out.println("No existe un coche con esa matrícula.");
        } else {
            System.out.println("Coche eliminado correctamente.");
        }
    }

    public void buscarCoche(String matricula){
        Object[] coche = garaje.get(matricula);
        if (coche == null){
            System.out.println("El coche no está en la lista.");
        } else {
            System.out.println("Datos del coche:");
            for (Object dato : coche){
                System.out.println("\t" + dato);
            }
        }
    }

    public void listarCoches(){
        Set<String> claves = garaje.keySet();
        if (claves.isEmpty()){
            System.out.println("Garaje vacío.");
            return;
        }

        for (String matricula : claves){
            buscarCoche(matricula);
        }
    }

    public void busquedaPersonalizada(){
        Set<String> keys = garaje.keySet();

        for (String key : keys){
            Object[] coche = garaje.get(key);

            int precio = (int) coche[4];
            int cv = (int) coche[3];

            if (precio < 20000 && cv > 100){
                buscarCoche(key);
            }
        }
    }
}
