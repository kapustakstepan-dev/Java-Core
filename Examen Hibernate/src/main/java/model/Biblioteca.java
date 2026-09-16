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
@Table(name = "bibliotecas")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String localidad;

    @Column(nullable = false)
    private String provinvia;

    @OneToMany(mappedBy = "biblioteca")
    private List<Libro> libros;

    public Biblioteca(String calle, String localidad, String provinvia) {
        this.calle = calle;
        this.localidad = localidad;
        this.provinvia = provinvia;
    }

    public void showData(){
        System.out.println("calle = " + calle);
        System.out.println("localidad = " + localidad);
        System.out.println("provinvia = " + provinvia);
    }
}
