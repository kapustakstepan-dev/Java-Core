import databese.DBConector;
import dto.AlumnosDTO;
import model.Alumnos;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlumnosDTO alumnosDTO = new AlumnosDTO();

        int opcion=-1;

        do {
            System.out.println("\n\tMenu");
            System.out.println("1. Registrar un alumno");
            System.out.println("2. Calificar un alumno");
            System.out.println("3. Comprobar datos de un alumno");
            System.out.println("4. Mostrar todos los alumnos calificados");
            System.out.println("5 .Mostrar todos los alumnos aprobados");
            System.out.println("6. Mostrar alumnos de un ciclo");
            System.out.println("7. Exportar datos");
            System.out.println("Que eliges?");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1->{
                    System.out.println("Introduzca nombre de alumno");
                    String nombre = scanner.nextLine();
                    System.out.println("Introduzca apellido de alumno");
                    String apellido = scanner.nextLine();
                    System.out.println("Introduzca correo de alumno");
                    String correo = scanner.nextLine();
                    System.out.println("Introduzca id de curso (1 o 2) de alumno");
                    int idCurso = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        alumnosDTO.registrarAlumno(new Alumnos(nombre,apellido,correo,idCurso));
                    } catch (SQLException e) {
                        System.out.println("Error en el registro de alumno"+ e.getMessage());
                    }

                }
                case 2->{
                    System.out.println("Introduzca correo para vuscar alumno");
                    String correo = scanner.nextLine();
                    System.out.println("Introduzca la nota del alumno");
                    int nota = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        alumnosDTO.calificaAlumno(correo,nota);
                    } catch (SQLException e) {
                        System.out.println("Error en la calificacion de alumno" + e.getMessage());
                    }
                }
                case 3->{
                    Alumnos alumnoBus = null;

                    if (alumnoBus != null) {
                        System.out.println("ID " + alumnoBus.getId() + ", Nombre " + alumnoBus.getNombre() + ", Apellido " +
                                alumnoBus.getApellido() + ", Correo" + alumnoBus.getCorreo() + ", Nota " +
                                alumnoBus.getNota() + ", Calificado " + alumnoBus.isCalificado() +
                                ", ID Ciclo " + alumnoBus.getId_curso());
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    try {
                        alumnosDTO.sacarDatos();
                    } catch (SQLException e) {
                        System.out.println("error al sacar los datos");
                    }
                }
                case 4->{}
                case 5->{}
                case 6->{}
                case 7->{}
                default -> {
                    System.out.println("Opcion no valida");
                }

            }
         } while (opcion!=8);
    }
}
