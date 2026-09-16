package Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "coches")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String matricula;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "color")
    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_combustible", nullable = false)
    private Combustible combustible;

    @Column(name = "anio_fabricacion")
    private int anio_fabricacion;

    @Column(name = "precio")
    private int precio;

    @Column(name = "km")
    private int km;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;



    public Coche(String matricula, Marca marca, String modelo, String color, Combustible combustible, int anio_fabricacion, int precio, int km, Estado estado) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.combustible = combustible;
        this.anio_fabricacion = anio_fabricacion;
        this.precio = precio;
        this.km = km;
        this.estado = estado;
    }

    public void showData(){
        System.out.println("id = " + id);
        System.out.println("matricula = " + matricula);
        System.out.println("marca = " + marca.getMarca());
        System.out.println("modelo = " + modelo);
        System.out.println("color = " + color);
        System.out.println("combustible = " + combustible.getTipo());
        System.out.println("anio_fabricacion = " + anio_fabricacion);
        System.out.println("precio = " + precio);
        System.out.println("km = " + km);
        System.out.println("estado = " + estado.getNombre());
    }

}
