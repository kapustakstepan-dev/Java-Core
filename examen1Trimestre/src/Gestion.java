import java.util.HashMap;
import java.util.Set;

public class Gestion {
    HashMap<String, Object[]> listaAlumnos;

        //constructor:
    public Gestion() {
        listaAlumnos = new HashMap<>();

    }
    //aniadir alumnos a la lista:
    public Object[] aniadirAlumnos(String nombre, String matricula, String apellido, double notamedia){
        Object[] alumno = {nombre, matricula, apellido, notamedia};
        if (listaAlumnos.putIfAbsent(matricula, alumno) == null){
            System.out.println("Alumno aniadido corectamente ");
            return alumno;
        } else {
            System.out.println("no se puede aniadir aluno con la misma amtricula ");
            return null;
        }
    }
    //mirar la lista toda
    public void listarAlumnos(){
        Set<String> key = listaAlumnos.keySet();
        if (listaAlumnos.isEmpty()){
            System.out.println("No hay alumnos enn la lista ");
        } else {
            System.out.println("Informacion del alumno");
            for (Object item : key){
                System.out.println("\t " + item);
            }
        }
    }
    //buscar alumnos por la matricula:
    public Object[] buscaAlumnoMatricula(String matricula){
        Object[] alumno = listaAlumnos.get(matricula);
        if (alumno != null){
            System.out.println("Alumno " + alumno[0] + " matricula " + alumno[1] + " apellido " + alumno[2] + " notaMedia " + alumno[3]);
        } else {
            System.out.println("Alumno no se encuentra");
        }
        return alumno;
    }
    //Expulsar los alumnos por la matricula
    public void expulsarMatricula(String matricula){
        if (listaAlumnos.remove(matricula) != null){
            System.out.println("Alumno esta expulsado de la lista");
        } else {
            System.out.println("Alumno no se encuetra por la matricula introducida");
        }
    }
    //sacar alumno con la nota mas alta de la lista:
    public void mediaAlta(double notaMedia){
        System.out.println("Alumnos con nota mas alta de la lista es " + notaMedia);
        for (Object[] item : listaAlumnos.values()){
            if ((double) item [3] >= notaMedia){
                System.out.println("\t" + item[0]);
            }
        }


    }
}
