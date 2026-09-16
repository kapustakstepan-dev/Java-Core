package Model1;

public class Profe {


    public Profe(){}
    public void ponerNotas(Alumno alumno){
        alumno.getAsignatura1().setCalificacion(Math.random()*10);
        alumno.getAsignatura2().setCalificacion(Math.random()*10);
        alumno.getAsignatura3().setCalificacion(Math.random()*10);

    }
    public double calcularMedia(Alumno alumno){
        double media = (double)(alumno.getAsignatura1().getCalificacion() +
                alumno.getAsignatura3().getCalificacion() +
                alumno.getAsignatura3().getCalificacion())/3;
        //suma de  la nota de las tres asignaturas
        return media;
    }




}
