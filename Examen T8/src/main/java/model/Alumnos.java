package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumnos {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private int nota;
    private boolean calificado;
    private int id_curso;


    public Alumnos(String nombre, String apellido, String correo, int id_curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nota = 0;
        this.calificado = false;
        this.id_curso = id_curso;
    }
}
