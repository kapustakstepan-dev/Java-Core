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
@Table(name = "Combustibles")
public class Combustible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tipo;

    @Column
    private String descripcion;

    @OneToMany(mappedBy = "combustible")
    private List<Coche> listaCoches;

    public Combustible(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
}
