package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isdn;

    @Column(nullable = false)
    private int numero_pag;

    @Column(nullable = false)
    private String tipo;

    @Column(name = "anio_publicacion", nullable = false)
    private int anio;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_biblioteca")
    private Biblioteca biblioteca;


    public Libro(int numero_pag, String tipo, int anio, Autor autor, Biblioteca biblioteca) {
        this.numero_pag = numero_pag;
        this.tipo = tipo;
        this.anio = anio;
        this.autor = autor;
        this.biblioteca = biblioteca;
    }

    public void showData(){
        System.out.println("\nautor = " + autor);
        System.out.println("numero_pag = " + numero_pag);
        System.out.println("tipo = " + tipo);
        System.out.println("anio_fabricacion = " + anio);
        System.out.println("autor = " + autor.getNombre() + " " + autor.getApellido());
        System.out.println("biblioteca = " + biblioteca.getCalle());

    }
}
