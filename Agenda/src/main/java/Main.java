import Model.Articulo;
import Model.Cuenta;
import Model.GestorCuentas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GestorCuentas gestorCuentas = new GestorCuentas();

        gestorCuentas.registrarCuenta(17);
        gestorCuentas.agregarArticulo(17, new Articulo("Cafe", 1.80));
        gestorCuentas.agregarArticulo(17, new Articulo("Tortilla", 2.20));
        gestorCuentas.agregarArticulo(17, new Articulo("Bocada", 2.50));

        System.out.println("Coste: " + gestorCuentas.obtenerCoste(17) +"€");

        System.out.println(gestorCuentas.getCuenta(17));

        gestorCuentas.cambiarEstado(17,"Cerrada");
        System.out.println(gestorCuentas.getCuenta(17));





    }






}
