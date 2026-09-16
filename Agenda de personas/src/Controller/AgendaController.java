import model.Contacto;

import java.util.HashMap;
import java.util.Set;

@Data
public class AgendaController {
    private HashMap<String, Contacto> listaContactos;
    public AgendaController(){

    public AgendaController() {
            listaContactos = new HashMap<>();
        }

        // metodos logicos que quiero ejecutar
        // añadir
        // buscar
        // borrar
        // listar

        // agregar
        public boolean agregarUsuario(Contacto) {
            if (!listaContactos.containsKey(contacto.getDni())) {
                listaContactos.put(contacto.getDni(), contacto);
                return true;
            }
            return false;
        }

        public void mostrarUsuarios() {

            if (listaContactos.isEmpty()) {
                System.out.println("Lista vacia");
            } else {
                Set<String> keys = listaContactos.keySet();
                for (String item : keys) {
                    Contacto contacto = listaContactos.get(item);
                    contacto.mostrarDatos();
                }
            }
        /*for ( Contacto item : listaContactos.values() ) {

        }*/
        }

        public boolean buscarContacto(String dni) {
            Contacto contacto = listaContactos.get(dni);
            if (contacto != null) {
                contacto.mostrarDatos();
            }
            return contacto != null;
        }

        public Contacto borrarContacto(String dni) {
            // Contacto contacto = listaContactos.remove(dni);
            // boolean borrado = listaContactos.remove(dni,listaContactos.get(dni));
            return listaContactos.remove(dni);
        }

        public void editarContacto(String dni, Contacto contacto) {
            if (listaContactos.containsKey(dni)) {
                listaContactos.replace(dni, contacto);
            } else {
                System.out.println("Usuario no encontrado");
            }
        }

        public void editarContacto(String dni) {

            Contacto contacto = listaContactos.get(dni);
            if (contacto != null) {
                contacto.setApellido("Nuevo");
                contacto.setNombre("Nuevo");
                contacto.setTelefono(2345);
                listaContactos.replace(dni, contacto);
            } else {
                System.out.println("El contacto no se encuentra en la lista");
            }

        }

        public boolean agregarUsuario(String nombre, String apellido, String dni, int telefono, String correo) {
            String inicialNombre = String.valueOf(nombre.charAt(0));
            String inicialApellido = String.valueOf(apellido.charAt(0));
            // borja1234@gmail.com
            // String correoNombre = correo.substring(0,correo.indexOf("@"));
            String correoNombre = correo.split("@")[0];
            return true;
        }
    }