package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    private String titulo, autor, codigo;

    public void mostrarInfo() {
        System.out.println("titulo = " + titulo);
        System.out.println("autor = " + autor);
        System.out.println("codigo = " + codigo);

    }
}
