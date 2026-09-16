package Model1;

public class Asignatura {
    private int id;
    private double calificacion;

    //constructor

    public Asignatura(int id){
        this.id = id;
    }
    public Asignatura(double calificacion){
        this.calificacion = calificacion;
    }



    //setters

    public void setId(int id) {
        this.id = id;
    }
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    //getters

    public int getId() {
        return id;
    }
    public double getCalificacion() {
        return calificacion;
    }
}