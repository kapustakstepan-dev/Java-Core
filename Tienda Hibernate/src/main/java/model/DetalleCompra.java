package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Detalle_Compra")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "id_compra", nullable = false)
    Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    Product product;

    @Column(name = "cantidad", nullable = false)
    int cantidad;

    @Column(name = "precio_total", nullable = false)
    double precioTotal;

}
