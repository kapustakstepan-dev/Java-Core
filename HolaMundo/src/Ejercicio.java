import java.util.Scanner;

public class Ejercicio {

    Scanner lectorTeclado;

    public void ejercicioif1() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Inscribe tu edad");
        int edad = lectorTeclado.nextInt();
        lectorTeclado.close();

        if (edad != 18) {
            System.out.println("Perdon eres menor de edad ");
        } else {
            System.out.println("Eres mayor de edad ");
        }

    }

    public void ejercicioif2() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Inscribe tu salario anual");
        int salario_anual = lectorTeclado.nextInt();
        int salario = 0;
        lectorTeclado.close();

        if (salario_anual <= 10000) {
            System.out.println("Tienes menos de 10000 euro el " +
                    "salario no tienes que pagar los impuestos ");
        } else if (salario_anual <= 20000) {
            salario = salario_anual - ((salario_anual * 5) / 100);
            System.out.println("Tines pagar 5% de impuestos " + salario);
        } else if (salario_anual <= 35000) {
            salario = salario_anual - ((salario_anual * 15) / 100);
            System.out.println("Tienes que pagar 15% de impuestos " + salario);
        } else {
            salario = salario_anual - ((salario_anual * 20) / 100);
            System.out.println("Tienes que pagar 20% de impuestos " + salario);
        }
        System.out.println("Tu salario original es " + salario_anual +
                " y con los imuestos sale " + salario);

    }

    public void ejercicioif3() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Intoduzca numero 1 ");
        int numero1 = lectorTeclado.nextInt();
        System.out.println("Intoduzca numero 2 ");
        int numero2 = lectorTeclado.nextInt();
        System.out.println("Intoduzca numero 3 ");
        int numero3 = lectorTeclado.nextInt();
        lectorTeclado.close();

        if (numero1 > numero2 && numero1 > numero3) {
            System.out.println("Numero 1 mayor de todos ");
        } else if (numero2 > numero1 && numero2 > numero3) {
            System.out.println("Numero 2 mayor de todos ");
        } else {
            System.out.println("Numero 3 mayor de todos ");
        }
    }

    public void ejercicioif4() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Introduzca primer nota ");
        int nota1 = lectorTeclado.nextInt();
        System.out.println("Introduzca sugunda nota ");
        int nota2 = lectorTeclado.nextInt();
        System.out.println("Introduzca tercer nota ");
        int nota3 = lectorTeclado.nextInt();
        lectorTeclado.close();

        double promedio = (double) (nota1 + nota2 + nota3) / 3;

        if (promedio < 5) {
            System.out.printf("Supenso tu nota es: %.2f ", promedio);
        } else if (promedio >= 5 && promedio <= 6.9) {
            System.out.printf("Aprobado tu nota es: %.2f ", promedio);
        } else if (promedio >= 7 && promedio <= 8.9) {
            System.out.printf("Notable tu nota es: %.2f ", promedio);
        } else {
            System.out.printf("Sobresaliente tu nota es: %.2f ", promedio);
        }
    }

    public void ejercicioif5() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Intoduzca cual quier año -> ");
        int anio = lectorTeclado.nextInt();
        lectorTeclado.close();

        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            System.out.println("El año es bisiesto ");
        } else {
            System.out.println("El año no es bisiesto");
        }
    }

    public void ejercicioif6() {
        lectorTeclado = new Scanner(System.in);
        System.out.println("Introduzca el numero del 1 al 7 para sacar el dia ed la semana :");
        int numero = lectorTeclado.nextInt();
        lectorTeclado.close();

        switch (numero) {
            case 1:
                System.out.println("EL numero corresponde a Lunes ");
                break;
            case 2:
                System.out.println("EL numero corresponde a Martes ");
                break;
            case 3:
                System.out.println("EL numero corresponde a Miercoles ");
                break;
            case 4:
                System.out.println("EL numero corresponde a Jueves ");
                break;
            case 5:
                System.out.println("EL numero corresponde a Viernes ");
                break;
            case 6:
                System.out.println("EL numero corresponde a Sabado ");
                break;
            case 7:
                System.out.println("EL numero corresponde a Domingo ");
                break;
            default:
                System.out.println("Introduiste numero no corespondiente " +
                        "del un dia de la semana");

        }
    }

    public void ejercicioif7() {
        lectorTeclado = new Scanner(System.in);
        System.out.println("Introduzca numero 1: ");
        int numero1 = lectorTeclado.nextInt();
        System.out.println("Introduzca numero 2: ");
        int numero2 = lectorTeclado.nextInt();

        if (numero2 <= 0) {
            System.out.println("Error, no se puede dividir entre 0 ");
        } else {

            System.out.println("1: Suma\n2: Resta\n3: Multiplicación\n4: División\nelige in numero");
            int operacion = lectorTeclado.nextInt();
            lectorTeclado.close();

            double resultado = 0;

            switch (operacion) {
                case 1:
                    resultado = numero1 + numero2;
                    break;
                case 2:
                    resultado = numero1 - numero2;
                    break;
                case 3:
                    resultado = numero1 * numero2;
                    break;
                case 4:
                    resultado = (double) numero1 / numero2;
                    break;
                default:
                    System.out.println("Opcion no valida ");
                    break;

            }
            System.out.printf("Resultado de operacion es %.2f", resultado);
        }
    }

    public void ejercicioif8() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Escribe el numero de 1 al 12 para saber que mes es ");
        int numero_mes = lectorTeclado.nextInt();
        lectorTeclado.close();

        switch (numero_mes) {
            case 1:
                System.out.println("El numero coresponde a Enero – January ");
                break;
            case 2:
                System.out.println("El numero coresponde a Febrero – February ");
                break;
            case 3:
                System.out.println("El numero coresponde a Marzo – March ");
                break;
            case 4:
                System.out.println("El numero coresponde a Abril – April ");
                break;
            case 5:
                System.out.println("El numero coresponde a Mayo – May ");
                break;
            case 6:
                System.out.println("El numero coresponde a Junio – June ");
                break;
            case 7:
                System.out.println("El numero coresponde a Julio – July ");
                break;
            case 8:
                System.out.println("El numero coresponde a Agosto – August ");
                break;
            case 9:
                System.out.println("El numero coresponde a Septiembre – September ");
                break;
            case 10:
                System.out.println("El numero coresponde a Octubre – October ");
                break;
            case 11:
                System.out.println("El numero coresponde a Noviembre – November ");
                break;
            case 12:
                System.out.println("El numero coresponde a Diciembre – December ");
                break;
            default:
                System.out.println("El numero no corresponde a ningun de los meses ");
                break;
        }
    }

    public void ejercicioif9() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Escribe una letra ");
        char letra = lectorTeclado.next().charAt(0);
        lectorTeclado.close();

        switch (letra) {
            case 'A', 'E', 'O', 'U', 'I', 'Y':
                System.out.println("Letra es mayúscula  y vocal ");
                break;
            case 'a', 'e', 'o', 'u', 'i', 'y':
                System.out.println("Letra es minúscula y vocal ");
                break;
            default:
                System.out.println("Letra es consonante ");
        }


    }

    public void ejercicioif10() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("1.De centímetros a pulgadas\n2.De kilogramos a libras\n" +
                "3.De euros a dólares\n4.De kilómetros a millas");
        int numero = lectorTeclado.nextInt();
        System.out.println("Que cantidad quieres covertir: ");
        int cantidad = lectorTeclado.nextInt();
        lectorTeclado.close();

        double resultado = 0;

        switch (numero) {
            case 1:
                double pulga = 2.54;
                resultado = cantidad * pulga;
                break;

            case 2:
                double kilos = 2.2046;
                resultado = cantidad * kilos;
                break;
            case 3:
                final double euro = 1.10;
                resultado = cantidad * euro;
                break;
            case 4:
                double kilom = 0.621371;
                resultado = cantidad * kilom;
                break;
            default:
                System.out.println("Error, elegiste mal el numero ");
        }
        System.out.println("El resultado de operacion es " + resultado);

    }

    public void ejercicion() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Ecribe un numero ");
        int numero = lectorTeclado.nextInt();
        lectorTeclado.close();

        int dias_semana = numero / 7;
        int resto_dia = numero % 7;

        System.out.println(numero + " días equivalen a " + dias_semana + " semana(s) y " + resto_dia + " día(s).");

    }

    public void ejercicioarea() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("1. Calcular área de un cuadrado\n" +
                "2. Calcular área de un rectángulo\n" +
                "3. Calcular área de un círculo\n" +
                "elige el numero ");

        int numero = lectorTeclado.nextInt();

        double area = 0;

        switch (numero) {
            case 1:
                System.out.println("Introduzaca el lado: ");
                double lado = lectorTeclado.nextDouble();
                area = lado * lado;
                break;
            case 2:
                System.out.println("");
                System.out.println("Introduzaca el base: ");
                double base = lectorTeclado.nextDouble();
                System.out.println("Introduzaca el altura: ");
                double altura = lectorTeclado.nextDouble();
                area = base * altura;
                break;
            case 3:
                System.out.println("Introduce el radio del círculo: ");
                double radio = lectorTeclado.nextDouble();
                area = Math.PI * Math.pow(radio, 2);
                break;
            default:
                System.out.println("Error, elige otro numero");
                break;
        }

        if (numero >= 1 && numero <= 3){
                System.out.println("El área calculada es: " + area);
        }


    }


}





