package Controller;

import DAO.ClienteDAO;
import DAO.CocheDAO;
import DAO.CompraDAO;
import Model.Cliente;
import Model.Coche;
import Model.Combustible;
import Model.Compra;

import java.io.PrintWriter;
import java.util.List;

public class Controller {
    private CocheDAO cocheDAO;
    private ClienteDAO clienteDAO;
    private CompraDAO compraDAO;
    private FileController fileController;

    public Controller(){
        cocheDAO = new CocheDAO();
        compraDAO = new CompraDAO();
        clienteDAO = new ClienteDAO();
        fileController = new FileController();
    }

    public List<Coche> aniadiendoCochesDeCSV(){
        List<Coche> coche = fileController.importarCoches();
        if (coche != null && !coche.isEmpty()){
            System.out.println("Coches estan aniadidos correctamente al stock");
        } else {
            System.out.println("No se puede aniadir los coches al stock");
        }
        return coche;
    }

    public void showDataCoches(){
        List<Coche> lista = cocheDAO.showData();
        if (lista!=null && !lista.isEmpty()){
            System.out.println("\n\tMostrando los coches de BD:");
            lista.forEach(coche -> {
                System.out.printf("ID: %d %n Fecha de fabricacion: %d %n " +
                        "Color: %s %n Km: %d %n Matricula: %s %n Modelo: %s " +
                        "%n Precio %d %n Combustible: %s %n Estado: %s %n Marca: %s %n",
                        coche.getId(),coche.getAnio_fabricacion(),coche.getColor(), coche.getKm(),
                        coche.getMatricula(), coche.getModelo(), coche.getPrecio(),
                        coche.getCombustible().getTipo(), coche.getEstado().getNombre(),
                        coche.getMarca().getMarca());
            });
        } else {
            System.out.println("No se puede sacar los coches de BD");
        }
    }

    public void getByMatricula(String matricula){
        Coche coche = cocheDAO.sacarPorMatricula(matricula);
        if (coche != null){
            System.out.println("\n\tDatos de coche:");
            coche.showData();
        } else {
            System.out.println("La matricula no es valida");
        }

    }

    public void getByMarca(String marca){
        List<Coche> lista = cocheDAO.getPorMarca(marca);
        if (lista!=null){
            System.out.println("\t\nDatos de Coche:");
            lista.forEach(coche -> {
                System.out.printf("ID: %d %n Fecha de fabricacion: %d %n " +
                                "Color: %s %n Km: %d %n Matricula: %s %n Modelo: %s " +
                                "%n Precio %d %n Combustible: %s %n Estado: %s %n Marca: %s %n",
                        coche.getId(),coche.getAnio_fabricacion(),coche.getColor(), coche.getKm(),
                        coche.getMatricula(), coche.getModelo(), coche.getPrecio(),
                        coche.getCombustible().getTipo(), coche.getEstado().getNombre(),
                        coche.getMarca().getMarca());
            });
        } else {
            System.out.println("No se puede sacar datos este coche");
        }

    }

    public void getByModelo(String modelo){
        List<Coche> lista = cocheDAO.getPorModelo(modelo);
        if (lista!=null&&!lista.isEmpty()){
            System.out.println("\n\tDatos de coche:");
            lista.forEach(coche -> {
                System.out.printf("ID: %d %n Fecha de fabricacion: %d %n " +
                                "Color: %s %n Km: %d %n Matricula: %s %n Modelo: %s " +
                                "%n Precio %d %n Combustible: %s %n Estado: %s %n Marca: %s %n",
                        coche.getId(),coche.getAnio_fabricacion(),coche.getColor(), coche.getKm(),
                        coche.getMatricula(), coche.getModelo(), coche.getPrecio(),
                        coche.getCombustible().getTipo(), coche.getEstado().getNombre(),
                        coche.getMarca().getMarca());
            });
        } else {
            System.out.println("No hay coche con este modelo");
        }

    }

    public void getBetweenPrice(int min, int max){
        List<Coche> lista = cocheDAO.getRangoPrecio(min, max);
        if (lista!=null&&!lista.isEmpty()){
            System.out.printf("\n\tCoches en rango de %d hasta %d euros %n", min,max);
            lista.forEach(coche -> {
                System.out.printf("ID: %d %n Fecha de fabricacion: %d %n " +
                                "Color: %s %n Km: %d %n Matricula: %s %n Modelo: %s " +
                                "%n Precio %d %n Combustible: %s %n Estado: %s %n Marca: %s %n",
                        coche.getId(),coche.getAnio_fabricacion(),coche.getColor(), coche.getKm(),
                        coche.getMatricula(), coche.getModelo(), coche.getPrecio(),
                        coche.getCombustible().getTipo(), coche.getEstado().getNombre(),
                        coche.getMarca().getMarca());
            });
        } else {
            System.out.printf("No hay coches en rango de precio de %d hasta %d",min,max);
        }

    }

    public void getPorEstado(String estado){
        List<Coche> lista = cocheDAO.getPorEstado(estado);
        if (lista!=null&&!lista.isEmpty()){
            System.out.println("Datos con estado " + estado+ ": \n");
            lista.forEach(coche -> {
                System.out.printf("ID: %d %n Fecha de fabricacion: %d %n " +
                                "Color: %s %n Km: %d %n Matricula: %s %n Modelo: %s " +
                                "%n Precio %d %n Combustible: %s %n Estado: %s %n Marca: %s %n",
                        coche.getId(),coche.getAnio_fabricacion(),coche.getColor(), coche.getKm(),
                        coche.getMatricula(), coche.getModelo(), coche.getPrecio(),
                        coche.getCombustible().getTipo(), coche.getEstado().getNombre(),
                        coche.getMarca().getMarca());
            });
        } else {
            System.out.println("No hay coches con este estado "+estado);
        }

    }

    public void insertCocheMano(Coche insert){
        Coche coche = cocheDAO.insertarCoche(insert);
        if (coche!=null){
            System.out.println("Coche esta guardado perfectamente en stock");
        } else {
            System.out.println("No se puede guardar el coche");
        }
    }

    public void cambioDatosCoche(String matricula, int km, String estado, int precio){
        Coche coche = cocheDAO.actualizarDatosCoche(matricula,km,estado,precio);
        if (coche!=null){
            System.out.println("Actualizaste datos de un coche");
            coche.showData();
        } else {
            System.out.println("No hay coche con esta matricula");
        }


    }

    public void getParaVentaPorMatricula(String matricula){
        Coche coche = cocheDAO.getPorMatriculaVenta(matricula);
        if (coche!=null){
            System.out.println("\n\tDatos de la coche con la matricula " + matricula+": ");
            coche.showData();
        } else {
            System.out.println("Con este matricula no se encuentra el coche");
        }

    }

    public void registroCompra(Compra compraInsert, Coche coche){
         compraDAO.registrarCompra(compraInsert,coche);
    }

    public void insertarCliente(Cliente cliente){
        clienteDAO.insertCliente(cliente);
    }

    public void eliminarCochePorMatricula(String matricula){
        try {
            int resulado = cocheDAO.eliminarCochePorMatricula(matricula);

            if (resulado > 0) {
                System.out.println("Coche esta eliminado correctamente con la matricula : " + matricula);
            } else {
                System.out.println("No se puede borrar coche con matricula: " + matricula);
            }
        } catch (Exception e){
            System.out.println("Error al borrar el coche");
        }

    }

    public void getCochesPorCombustible(String combustible){
        List<Coche> lista = cocheDAO.getCochesPorCombustible(combustible);
        if (lista!=null&&!lista.isEmpty()){
            System.out.printf("Coches con combustible %s son siguientes: \n",combustible);
            lista.forEach(coche -> {
                System.out.printf("ID: %d %n Fecha de fabricacion: %d %n " +
                                "Color: %s %n Km: %d %n Matricula: %s %n Modelo: %s " +
                                "%n Precio %d %n Combustible: %s %n Estado: %s %n Marca: %s %n",
                        coche.getId(),coche.getAnio_fabricacion(),coche.getColor(), coche.getKm(),
                        coche.getMatricula(), coche.getModelo(), coche.getPrecio(),
                        coche.getCombustible().getTipo(), coche.getEstado().getNombre(),
                        coche.getMarca().getMarca());
            });
        } else {
            System.out.println("No hay coches con este tipo de combustible");
        }

    }

    public void mostrarPorMarca(String marca) {
        List<Coche> coches = cocheDAO.getCochesPorMarca(marca);
        if (coches == null && coches.isEmpty()) {
            System.out.println("No hay coches de la marca: " + marca);
        } else {
            System.out.println("\nListado de la marca unica: " + marca + "\n");
            coches.forEach(Coche::showData);
        }
    }

    public void mostrarDisponibles() {
        List<Coche> coches = cocheDAO.getCochesDisponibles();
        if (coches == null && coches.isEmpty()) {
            System.out.println("No hay coches disponibles.");
        } else {
            System.out.println("\n-- COCHES EN STOCK --");
            coches.forEach(Coche::showData);
        }
    }

    public void mostrarVendidos() {
        List<Coche> coches = cocheDAO.getCochesVendidos();
        if (coches == null || coches.isEmpty()) {
            System.out.println("No hay coches vendidos.");
        } else {
            System.out.println("\n-- COCHES VENDIDOS --");
            coches.forEach(Coche::showData);        }
    }

    public void exportarCSV(String nombreArchivo) {
        List<Coche> coches = cocheDAO.getTodosCoches();
        if (coches != null) {
            try {
                PrintWriter printWriter = new PrintWriter(("src/main/java/"+ nombreArchivo));
                printWriter.println("Matricula,Marca,Modelo,Color,Combustible,Anio,Km,Precio,Estado");
                coches.forEach(c -> {
                    printWriter.printf("%s,%s,%s,%s,%s,%d,%d,%d,%s%n",
                            c.getMatricula(),
                            c.getMarca().getMarca(),
                            c.getModelo(),
                            c.getColor(),
                            c.getCombustible().getTipo(),
                            c.getAnio_fabricacion(),
                            c.getKm(),
                            c.getPrecio(),
                            c.getEstado().getNombre()
                    );
                });

                printWriter.close();
                System.out.println("Archivo CSV guardado con éxito.");
            } catch (Exception e) {
                System.out.println("Error al crear el CSV: " + e.getMessage());
            }
        }
    }
}
