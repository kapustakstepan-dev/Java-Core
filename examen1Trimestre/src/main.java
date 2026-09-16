import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Gestion gestion = new Gestion();
        Scanner scanner = new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("1. Agregar alumnos:");
            System.out.println("2. Listar alumnos:");
            System.out.println("3. Buscar alumnos:");
            System.out.println("4. Mostrar el alumno con la media más alta");
            System.out.println("5. Expulsar un alumno:");
            System.out.println("6. Mostrar los alumnos una nota media mínima:");
            System.out.println("7 .Salir");
            System.out.println("Que eliges? ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1-> {
                    System.out.println("Introduzca la matricula del alumno ");
                    String matricula = scanner.nextLine();
                    System.out.println("Introduzca la nombre del alumno ");
                    String nombre = scanner.nextLine();
                    System.out.println("Introduzca la apellido del alumno ");
                    String apellido = scanner.nextLine();
                    System.out.println("Introduzca la la nota media con decimales del alumno ");
                    double notaMedia = scanner.nextDouble();

                    gestion.aniadirAlumnos(matricula,nombre,apellido,notaMedia);

                }

                case 2-> {gestion.listarAlumnos();}
                case 3-> {System.out.println("Introduzca la matricula ");
                    String matricula = scanner.nextLine();
                    gestion.buscaAlumnoMatricula(matricula);}
                case 4-> {
                    System.out.println("Introduzca la nota media de la clase ");
                    double notaMedia = scanner.nextInt();
                    gestion.mediaAlta(notaMedia);}
                case 5-> {
                    System.out.println("Introduzca la matricula ");
                    String matricula = scanner.nextLine();
                    gestion.expulsarMatricula(matricula);}
                case 6-> {}
                case 7-> {System.out.println("Saliendo...");}
                default -> {System.out.println("Opcion no valida ");}
            }

        } while (opcion!=7);
        System.out.println("Examen acabado :(");
    }
}
