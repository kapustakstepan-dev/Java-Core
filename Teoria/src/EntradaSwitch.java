public class EntradaSwitch {

    public static void main(String[] args) {

        int numero = 4;
        switch (numero) {
            /*case 1:
                //el cuerpo del caso
                System.out.println("Ejecutado en caso 1 ");
                break;
            case 2:
                //el cuerpo del caso
                System.out.println("Ejecutado en caso 2 ");
                break;
            case 3:
                //el cuerpo del caso
                System.out.println("Ejecutado en caso 3 ");
                break;
            case 4:
                //el cuerpo del caso
               // System.out.println("Ejecutado en caso 4 ");
               break;
             */

            case 1,2,3,4,5,6,7,8,9:
                System.out.println("Ejecutado en caso por vien ");
                break;
            default:
                System.out.println("Ejecutado en caso por defecto ");
                //cuerpo del restante
                break;


        }

        char letra = 'A';
        switch (letra) {
            case 'A':
                System.out.println("Ejecutando letra A ");
                break;
            case 'B':
                System.out.println("Ejecutando letra B");
                break;
            case 'C':
                System.out.println("Ejecutando letra C ");
                break;
            default:
                System.out.println("No puede ejecutar");
                break;


        }

        String nombre = "Stepan";
        switch (nombre.toLowerCase()) {
            case "stepan" -> {
                String mensaje = "esta variable es de bloque";
                System.out.println("EL nombre es Stepan");
                if (nombre.length() > 6){
                    System.out.println("el nombre tiene mas que 6 letras");
                }
            }

            case "borja" -> {
                System.out.println("EL nombre es Borja");
            }

            case "maria" -> {
                System.out.println("EL nombre es Maria");
            }

            case "eugenio" -> {
                System.out.println("EL nombre es Eugenio");
            }

            default -> {
                System.out.println("El nombre no esta ");

            }

        }

        System.out.println("Terminando el programa ");

    }
}
