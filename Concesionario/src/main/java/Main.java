import Controller.Controller;
import Controller.FileController;
import DAO.*;
import Database.HibernateUtil;
import Model.*;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.rmi.server.ExportException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction;

        CocheDAO cocheDAO = new CocheDAO();
        MarcaDAO marcaDAO = new MarcaDAO();
        CombustibleDAO combustibleDAO = new CombustibleDAO();
        EstadoDAO estadoDAO = new EstadoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        CompraDAO compraDAO = new CompraDAO();

        int opcion;

        do {
            System.out.println("\n--- CONCESIONARIO ---");
            System.out.println("1. Cargar coches desde CSV");
            System.out.println("2. Mostrar todos los coches");
            System.out.println("3. Buscar por matrícula");
            System.out.println("4. Buscar por marca");
            System.out.println("5. Buscar por modelo");
            System.out.println("6. Buscar por rango de precio");
            System.out.println("7. Buscar por estado de venta");
            System.out.println("8. Agregar coche manualmente");
            System.out.println("9. Modificar datos de coche");
            System.out.println("10. Vender un coche");
            System.out.println("11. Eliminar un coche");
            System.out.println("12. Mostrar por combustible");
            System.out.println("13. Mostrar por marca concreta");
            System.out.println("14. Mostrar coches disponibles");
            System.out.println("15. Mostrar coches vendidos");
            System.out.println("16. Guardar cambios en CSV");
            System.out.println("17. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    List<Coche> lista = controller.aniadiendoCochesDeCSV();
                    if (lista!=null && !lista.isEmpty()) {
                        transaction = session.beginTransaction();
                        try {

                            lista.forEach(session::persist);

                            transaction.commit();
                        } catch (NoResultException e){
                            System.out.println("Sin resultados");
                        } catch (Exception e){
                            transaction.rollback();
                        }
                    }
                }
                case 2 -> {
                    controller.showDataCoches();
                }
                case 3 -> {
                    System.out.println("\nIntroduzca la matricula para buscar un coche");
                    String matricula = scanner.nextLine();
                    controller.getByMatricula(matricula);
                }
                case 4 -> {
                    System.out.println("\nIntroduzca la marca para buscar un coche");
                    String marca = scanner.nextLine();
                    controller.getByMarca(marca);
                }
                case 5 -> {
                    System.out.println("\nIntroduzca la modelo para buscar un coche");
                    String modelo = scanner.nextLine();
                    controller.getByModelo(modelo);
                }
                case 6 -> {
                    System.out.println("\nIntroduzca la precio min para buscar un coche");
                    int min = scanner.nextInt();
                    System.out.println("\nIntroduzca la precio max para buscar un coche");
                    int max = scanner.nextInt();
                    controller.getBetweenPrice(min,max);
                    scanner.nextLine();
                }
                case 7 -> {
                    System.out.println("Incica que estado de coche prefieres hay vendido, stock y nuevo");
                    String estado = scanner.nextLine();
                    controller.getPorEstado(estado);
                }
                case 8 -> {
                    System.out.println("\tPara meter coche al stock necesitamos que introduzcas datos siguientes:");

                    System.out.println("Introduzca matricula de coche:");
                    String matricula = scanner.nextLine();
                    System.out.println("Introduzca de que pais este coche:");

                    String pais = scanner.nextLine();
                    System.out.println("Introduzca la marca de coche:");
                    String marca = scanner.nextLine();
                    System.out.println("Introduzca modelo de coche:");

                    String modelo = scanner.nextLine();
                    System.out.println("Introduzca color de coche:");
                    String color = scanner.nextLine();

                    System.out.println("Introduzca el tipo de combustible de coche (hay gasolina, diesel, electrico y hibrido):");
                    String combustible = scanner.nextLine();

                    System.out.println("Introduzca anio de fabricacion de coche:");
                    int fabricacion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduzca su precio:");
                    int precio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduzca km que tiene coche:");
                    int km = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduzca estado de coche (hay vendido, stock y nuevo):");
                    String estado = scanner.nextLine();

                    Marca mar = marcaDAO.getMarca(marca);
                    Estado est = estadoDAO.getEstado(estado);
                    Combustible comb = combustibleDAO.getCombustible(combustible);

                    if (mar == null) {
                        System.out.println("Marca nueva detectada: " + marca);
                        mar = new Marca(marca, pais);
                    }

                    if (est!= null && comb!=null){
                        controller.insertCocheMano(new Coche(
                                matricula,
                                mar,
                                modelo,
                                color,
                                comb,
                                fabricacion,
                                precio,
                                km,
                                est));
                    }
                }
                case 9 -> {
                    System.out.println("Introduzca matricula de coche:");
                    String matricula = scanner.nextLine();
                    System.out.println("Buscando ...");

                    System.out.println("Introduzca nuevos km de coche:");
                    int km = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduzca nuevo estado de coche:");
                    String estado = scanner.nextLine();
                    System.out.println("Introuzca nuevo precio de coche:");
                    int precio = scanner.nextInt();
                    scanner.nextLine();

                    controller.cambioDatosCoche(matricula,km,estado,precio);

                }
                case 10 -> {
                    System.out.println("\n\tIntroduzca matricula de vehiculo que quieres vender: ");
                    String matricula = scanner.nextLine();
                    controller.getParaVentaPorMatricula(matricula);

                    Coche cocheVenta = cocheDAO.getPorMatriculaVenta(matricula);

                    if (cocheVenta!=null){
                        if (cocheVenta.getEstado().getNombre().equalsIgnoreCase("vendido")){
                            System.out.println("No se puede comprar el coche que ya eta vendido");
                        } else {
                            System.out.println("Introduzca nif para entrar a la cuenta de cliente");
                            String nif = scanner.nextLine();
                            Cliente cliente = clienteDAO.getClienteByNif(nif);

                            if (cliente==null){
                                System.out.println("No se encuentra el cliente, pasamos a registracion");
                                System.out.println("-- Registro --");
                                System.out.println("\tIntroduzca nombre:");
                                String nombre = scanner.nextLine();
                                System.out.println("\tIntroduzca apelido:");
                                String apellido = scanner.nextLine();
                                System.out.println("\tIntroduzca mif:");
                                String nifnuevo = scanner.nextLine();

                                cliente = new Cliente();
                                cliente.setNombre(nombre);
                                cliente.setApellidos(apellido);
                                cliente.setNif(nifnuevo);
                                controller.insertarCliente(cliente);
                            } else {
                                System.out.println("Bienvenido al Stock " + cliente.getNombre() +" "+cliente.getApellidos());
                            }

                            Estado estadoVenta = estadoDAO.getEstado("vendido");

                            if (estadoVenta != null) {
                                cocheVenta.setEstado(estadoVenta);

                                Compra nuevaCompra = new Compra();
                                nuevaCompra.setCliente(cliente);
                                nuevaCompra.setCoche(cocheVenta);
                                nuevaCompra.setPrecio(cocheVenta.getPrecio());

                                controller.registroCompra(nuevaCompra, cocheVenta);
                            }
                        }
                    }


                }
                case 11 -> {
                    System.out.println("Introduzca matricula para borrar un coche");
                    String matricula = scanner.nextLine();
                    controller.eliminarCochePorMatricula(matricula);
                }
                case 12 -> {
                    System.out.println("Introduzca tipo de combustible");
                    String combustible = scanner.nextLine();
                    controller.getCochesPorCombustible(combustible);
                }
                case 13 -> {
                    System.out.println("Introduzca la marca concreta para mostrar sus coches:");
                    String marca = scanner.nextLine();
                    controller.mostrarPorMarca(marca);
                }
                case 14 -> {
                    controller.mostrarDisponibles();
                }
                case 15 ->{
                    controller.mostrarVendidos();
                }
                case 16 ->{
                    System.out.println("Introduzca el nombre del archivo (ej: coches_exportados.csv):");
                    String nombreArchivo = scanner.nextLine();
                    controller.exportarCSV(nombreArchivo);
                }
                case 17 -> {
                    System.out.println("Saliendo ...");
                    session.close();
                }
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 17);

    }
}
