package Model;

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
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca", unique = true)
    private String marca;

    @Column
    private String detalle;

    @OneToMany(mappedBy = "marca")
    private List<Coche> listaCoches;

    public Marca(String marca, String detalle) {
        this.marca = marca;
        this.detalle = detalle;
    }
}
