import controller.APIController;
import controller.FileController;
import controller.PlataformaJuegos;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PlataformaJuegos plataformaJuegos = new PlataformaJuegos();
        FileController fileController = new FileController();
        APIController apiController = new APIController();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Añadir juegos a la plataforma: ");
            System.out.println("2. Mostrar juegos: ");
            System.out.println("3. Filtrar juegos por clasificación de edad");
            System.out.println("4. Ver detalles de un juego específico (seleccionando por índice):");
            System.out.println("5. Calcular el tiempo de descarga de un juego específico " +
                    "(solicitando la velocidad de internet y el ID del juego): ");
            System.out.println("6. Calcular el precio total de todos los juegos: ");
            System.out.println("7. Añadir juego a carrito de compra: ");
            System.out.println("8. Exportar CSV carrito de compra: ");
            System.out.println("9. Importar juegos json: ");
            System.out.println("10. Salir del programa");
            System.out.println("\n\tQue eliges: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case  1->{
                    System.out.println("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Desarrollador: ");
                    String desarrollador = scanner.nextLine();
                    System.out.println("Anio lanzamiento: ");
                    int añoLanzamiento = scanner.nextInt();
                    System.out.println("Tamanio: ");
                    int tamanio = scanner.nextInt();
                    System.out.println("Precio: ");
                    int precio = scanner.nextInt();;
                    System.out.println("Clacificacion (PEGI8/PEGI12/PEGI18)");
                    ClaificacionEdad claificacionEdad = ClaificacionEdad.valueOf(scanner.next());

                    System.out.println("1. Accion ");
                    System.out.println("2. Estrategia ");
                    System.out.println("3. RPG ");
                    System.out.println("Tipo: ");
                    int type = scanner.nextInt();
                    switch (type){
                        case 1->{
                            System.out.println("Nivel Violencia: ");
                            int violencia = scanner.nextInt();
                            System.out.println("Modo multiplicador (true/false): ");
                            boolean modo = scanner.nextBoolean();
                            VideojuegoAccion videojuegoAccion =
                                    new VideojuegoAccion(titulo, desarrollador, añoLanzamiento, tamanio,
                                    precio, claificacionEdad, violencia, modo);

                            plataformaJuegos.addGame(videojuegoAccion);
                        }
                        case 2->{
                            System.out.println("Dificultad (de 1 a 5): ");
                            int dificult = scanner.nextInt();
                            System.out.println("Tiempo jugado: ");
                            int timePlayed = scanner.nextInt();

                            VideojuegoEstrategia videojuegoEstrategia = new VideojuegoEstrategia(
                                    titulo, desarrollador, añoLanzamiento, tamanio,
                                    precio, claificacionEdad, dificult, timePlayed
                            );
                           plataformaJuegos.addGame(videojuegoEstrategia);
                        }
                        case 3->{
                            System.out.println("Tiene mundo abiento (true/false): ");
                            boolean mundoAbierto = scanner.nextBoolean();
                            System.out.println("Horas Historia Principal: ");
                            int horasHistoriaPrincipal = scanner.nextInt();

                            VideojuegoRPG videojuegoRPG = new VideojuegoRPG(
                                    titulo, desarrollador, añoLanzamiento, tamanio,
                                    precio, claificacionEdad, mundoAbierto, horasHistoriaPrincipal
                            );
                            plataformaJuegos.addGame(videojuegoRPG);
                        }
                    }
                }
                case  2->{plataformaJuegos.mostrarAll();}
                case  3->{
                    System.out.println("Clasificacion Edad (PEGI8/PEGI12/PEGI18): ");
                    ClaificacionEdad claificacionEdad = ClaificacionEdad.valueOf(scanner.next());
                    plataformaJuegos.filterEdad(claificacionEdad);}
                case  4->{
                    System.out.println("Indice: ");
                    int id = scanner.nextInt();
                    plataformaJuegos.buscarId(id);
                }
                case  5->{
                    //no funciona
                    /*System.out.println("Indice: ");
                    int id = scanner.nextInt();
                    System.out.println("Velocidad de internet (en MB/s) : ");
                    double velocidad = scanner.nextDouble();

                    if (id >= 0 && id< plataformaJuegos.getVideojuegos().size()){
                        Videojuego videojuego =  plataformaJuegos.buscarId(id);

                        Descargable descargable = null;
                        videojuego.calcularTiempoDescarga(velocidad);

                    }

                     */
                }
                case  6->{plataformaJuegos.mostrarVideoJuegos();}
                case  7->{
                    System.out.println("Titulo: ");
                    String titulo = scanner.nextLine();
                    plataformaJuegos.addCarrito(titulo);}
                case  8->{fileController.exportarDatos();}
                case  9->{apiController.importAll();}
                case  10->{
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opcion no valida. ");

            }
        } while (opcion!= 10);

    }
}
