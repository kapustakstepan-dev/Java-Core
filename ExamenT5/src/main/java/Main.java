import controller.Biblioteca;
import model.Libro;
import model.Prestamo;
import model.Socio;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Doce de Octubre");

        Socio socio1 = new Socio("Stepan","1234A","643555280");
        Socio socio2 = new Socio("Eduardo", "1234B","643511234");

        Libro libro1 = new Libro("Marichca", "Taras Shevchenko","1234AB");
        Libro libro2 = new Libro("Uganda","Maguairo Madagascariño","1234BB");
        Libro libro3 = new Libro("Ciber Seguridad","Jesus Ninoc","1234CB");
        Libro libro4 = new Libro("Como programar en Java","Borja","1234DB");

        Prestamo prestamo1 = new Prestamo(socio1,libro3,5,20,true);
        Prestamo prestamo2 = new Prestamo(socio2,libro4,0,1,true);

        biblioteca.resgistrarPrestamo(prestamo1);
        biblioteca.resgistrarPrestamo(prestamo2);

        prestamo1.setDiasRetras(10);
        prestamo1.setDiasRetras(23);
        System.out.println();

        biblioteca.finalizarPrestamo("1234A");
        biblioteca.finalizarPrestamo("1234B");

        biblioteca.listarPrestamo();
        System.out.println("Valor total de la recaudacion son " + biblioteca.getRecaudacion() + " euros");

    }
}
