import java.util.Scanner;

public class Ejercicio2 {


     public void ejercicio2(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);

        int num_lot = (int)(Math.random() * 9000) + 1000;

         System.out.println("Escribe cueal quier numero para jugar en loteria " +
                 "de 1000 al 9999: ");
         int num_usuario = lectorTeclado.nextInt();

         double unidades_ran = num_lot / 1;
         double decenas_ran = (num_lot / 10) % 10;
         double centenas_ran = (num_lot / 100) % 10;
         double millares_ran = (num_lot / 1000) % 10;

         double unidades_usuario = num_usuario / 1;
         double decenas_usuario = (num_usuario / 10) % 10;
         double centenas_usuario = (num_usuario / 100) % 10;
         double millares_usuario = (num_usuario / 1000) % 10;

         boolean gan_undades = unidades_ran == unidades_usuario;
         boolean gan_decenas = decenas_ran == decenas_usuario;
         boolean gan_centenas = centenas_ran == centenas_usuario;
         boolean gan_millares = millares_ran == millares_usuario;

         System.out.printf("Has acertado las unidades: %b" +
                 "\nHas acertado las decenas: %b" +
                 "\nHas acertado las centenas: %b" +
                 "\nHas acertado las millares: %b", gan_undades, gan_decenas, gan_centenas, gan_millares);
         System.out.println("\nNumero ganador: " + num_lot);

    }




}

