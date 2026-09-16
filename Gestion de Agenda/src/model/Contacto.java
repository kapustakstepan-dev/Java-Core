package model;

public class Contacto {
    private String nombre, dni, apellido;

    public Contacto() {}

    public Contacto(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("dni = " + dni);
        System.out.println("apellido = " + apellido);
    }
    @Override
    public String toString(){
        return String.format("%s, %s, %s",nombre, apellido, dni);
    }

    public String exportarDatos(){
        return String.format("%s, %s, %s",nombre, apellido, dni);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
