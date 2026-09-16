package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_coche", nullable = false)
    private Coche coche;

    @Column(nullable = false)
    private int precio;

    public Compra(Cliente cliente, Coche coche) {
        this.cliente = cliente;
        this.coche = coche;
        this.precio = coche.getPrecio();
    }
}
