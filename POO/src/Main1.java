import Model1.Alumno;
import Model1.Asignatura;
import Model1.Profe;

public class Main1 {
    public static void main (String[] args){
        Asignatura a1 = new Asignatura(1);
        Asignatura a2 = new Asignatura(2);
        Asignatura a3 = new Asignatura(3);
        Alumno borja = new Alumno(a1, a2, a3);
        Profe profesor1 = new Profe();
        profesor1.ponerNotas(borja);
        System.out.printf("La media del alumno es %.2f\n",profesor1.calcularMedia(borja));

        /*
        borja.getA1().setCalificacion(4.0);
        borja.getA2().setCalificacion(7.0);
        borja.getA3().setCalificacion(9.0);
        borja.mostrarExpediente();
         */
        // Alumno borja = new Alumno(1, 2, 3);
        // Alumno maria = new Alumno(1, 2, 3);
        // System.out.println("La calificacion de esta asignatura es "+a3.getCalificacion());
    }
}
