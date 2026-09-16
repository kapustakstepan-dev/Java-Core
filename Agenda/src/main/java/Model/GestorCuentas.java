package Model;

import java.util.HashMap;

public class GestorCuentas {
    private HashMap<Integer, Cuenta> cuentas = new HashMap<>();
    public void registrarCuenta(int id){
        cuentas.put(id, new Cuenta(id));
    }

    public void agregarArticulo(int idCuenta, Articulo articulo){
        Cuenta cuenta = cuentas.get(idCuenta);
        if (cuenta == null) {
            System.out.println("Cuenta no encotrada");
        } else {
            cuenta.agregarArticulo(articulo);
        }
    }
    public double obtenerCoste(int idCoste){
        Cuenta cuenta = cuentas.get(idCoste);
        if (cuenta == null){
            return 0;
        } else {
            return cuenta.getCoste();
        }
    }
    public void cambiarEstado(int idCuenta, String nEstado){
        Cuenta cuenta = cuentas.get(idCuenta);
        if (cuenta == null){
            System.out.println("Cuenta no encontrada");
        } else {
            cuenta.setEstado(nEstado);
        }
    }
    public Cuenta getCuenta(int idCuenta){
        return cuentas.get(idCuenta);
    }
}
