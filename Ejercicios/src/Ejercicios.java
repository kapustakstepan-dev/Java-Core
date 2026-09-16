import java.util.Scanner;

public class Ejercicios {

    Scanner lectorTeclado;

    public void ejercicio1() {
        System.out.println("Ejercicio 1");
        final String nombreCompleto = "Stepan Kapustiak";
        final String DIRECCION = "C/Estocolmo";
        final String NUM_PORTAL = "1A";
        final int PISO = 1;
        final int COD_POSTAL = 28921;
        final String LOCALIDAD = "Alcorcon";
        final String PROVINCIA = "Madrid";
        final String PAIS = "ESPAÑA";

        System.out.println(nombreCompleto);
        System.out.printf("%s, %s, %d\n", DIRECCION, NUM_PORTAL, PISO);
        System.out.printf("%d, %s, %s\n", COD_POSTAL, LOCALIDAD, PROVINCIA);
        System.out.println(PAIS);
    }

    public void ejercicio2() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Escribe nombre y apellido");
        String nombreCompleto = lectorTeclado.nextLine();

        System.out.println("Escribe tu edad");
        int edad = lectorTeclado.nextInt();

        System.out.println("¿Tienes carnet de conducir? (true/false)");
        boolean carne_conducir = lectorTeclado.nextBoolean();

        System.out.println("Escribe tu altura (ej: 1.75)");
        float altura = lectorTeclado.nextFloat();

        lectorTeclado.close();

        System.out.printf("Tu nombre es %s, tienes %d años y tu altura es %.2f m\n",
                nombreCompleto, edad, altura);
        System.out.println("Tienes carnet de conducir: " + carne_conducir);
    }

    public void ejercicio3() {

        lectorTeclado = new Scanner(System.in);

        System.out.println("Escribe primer número para calcular");
        int numero1 = lectorTeclado.nextInt();
        System.out.println("Escribe segundo número para calcular");
        int numero2 = lectorTeclado.nextInt();

        int res_suma = numero1 + numero2;
        System.out.println("El resultado de la suma es " + res_suma);

        int res_resta = numero1 - numero2;
        System.out.println("El resultado de la resta es " + res_resta);

        int res_multi = numero1 * numero2;
        System.out.println("El resultado de la multiplicación es " + res_multi);

        int res_division = numero1 / numero2;
        System.out.println("El resultado de la división entera es " + res_division);

        int res_resto = numero1 % numero2;
        System.out.println("El resto es " + res_resto);

        double res_divi_real = (double) numero1 / numero2;
        System.out.println("El resultado de la división real es " + res_divi_real);
        lectorTeclado.close();
    }

    public void ejecrcicio4() {

        lectorTeclado = new Scanner(System.in);
        System.out.println("Cuantas bebidas quereis");
        int num_bebidas = lectorTeclado.nextInt();
        System.out.println("Cuantas bocatas quereis");
        int num_bocadillos = lectorTeclado.nextInt();
        lectorTeclado.close();


        final double coste_de_bebida = 1.25;
        final double coste_de_bocata = 2.05;

        double suma_bebida = num_bebidas * coste_de_bebida;
        double suma_bocatas = num_bocadillos * coste_de_bocata;
        double suma_total = suma_bebida + suma_bocatas;

        System.out.println("La suma de bebidas es " + suma_bebida +
                "\nLa suma de bocadillos es " + suma_bocatas +
                "\nEl total es " + suma_total);
    }

    public void ejercicio5() {
        int segundos_tot = 24973;

        int horas = segundos_tot / 3600;
        int resto1 = segundos_tot % 3600;
        int minutos = resto1 / 60;
        int segundos = resto1 % 60;

        System.out.printf("Número de segundos: %d\n%d horas\n%d minutos\n%d segundos\n",
                segundos_tot, horas, minutos, segundos);
    }

    public void ejercicio6() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Inntrodussca el valor de compra: ");
        double valor_compra = lectorTeclado.nextDouble();
        System.out.println("Inntrodussca el valor de IVA en la compra: ");
        double valor_IVA = lectorTeclado.nextDouble();
        lectorTeclado.close();

        double cuesta_real_de_IVA = valor_compra % valor_IVA;
        double cuesta_de_compra_real = cuesta_real_de_IVA + valor_compra;

        System.out.printf("La compra vale %.2f", cuesta_de_compra_real);
        System.out.println("\nla IVA fue  " + cuesta_real_de_IVA);
    }

    public void ejercicio7() {
        lectorTeclado = new Scanner(System.in);
        System.out.println("Por favor introduce el radio de circunferencia ");
        double radio = lectorTeclado.nextDouble();
        lectorTeclado.close();

        //2*PI*r
        double longitud = 2 * Math.PI * radio;
        //PI*radio2
        double area = Math.PI * Math.pow(radio, 2);
        System.out.printf("El area de la circunferencia es: %.3f\n", area);
        System.out.printf("El area de la longitud es: %.3f\n", longitud);
    }

    public void ejercicio8() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Escribe los grados centigrados: ");
        float grad_cent = lectorTeclado.nextFloat();
        float grad_far = (9 * grad_cent) / 5 + 32;
        float grad_kelv = grad_cent + 273.15f;
        System.out.printf("Farenheit: %.2f y Kelvin: %.2f\n", grad_far, grad_kelv);

        System.out.println("Escribe los grados Farenheit: ");
        grad_far = lectorTeclado.nextFloat();
        grad_cent = (5 * (grad_far - 32)) / 9;
        grad_kelv = (float) ((double) (5 * (grad_far - 32) / 9) + 273.15);
        System.out.printf("Centigrados: %.2f y  Kelvin: %.2f\n", grad_cent, grad_kelv);


        System.out.println("Escribe los grados Kelvin: ");
        grad_kelv = lectorTeclado.nextFloat();
        grad_cent = grad_kelv - 273.15f;
        grad_far = (float) (9 * (grad_kelv - 273.15) / 5 + 32);
        System.out.printf("Centigrados: %.2f y Farenheit: %.2f\n", grad_far, grad_cent);
        lectorTeclado.close();
    }

    public void ejercicio9() {
        lectorTeclado = new Scanner(System.in);

        final float precio_beb = 1.20f;
        final float precio_bocat = 2.05f;


        System.out.println("¿Que cantidad de bebidas quiéreis?");
        float num_beb = lectorTeclado.nextFloat();
        System.out.println("¿Que cantidad de bocadillos quiéreis?");
        float num_bocat = lectorTeclado.nextFloat();
        lectorTeclado.close();


        float cuesta_beb = precio_beb * num_beb;
        float cuesta_bocat = precio_bocat * num_bocat;

        System.out.println("------------------------------------");
        System.out.println("ARTICULO\t CANTIDAD PRECIO  COSTE");
        System.out.println("============ ======== ======= ======");
        System.out.printf("Bebida\t\t\t    %.0f\t%.2f    %.2f\n", num_beb, precio_beb, cuesta_beb);
        System.out.printf("Bocadillo\t\t    %.0f\t%.2f   %.2f\n", num_bocat, precio_bocat, cuesta_bocat);
        System.out.println("TOTAL\t\t\t\t\t\t  ======");
        System.out.println("------------------------------------");


    }

    public void ejercicio10() {
        lectorTeclado = new Scanner(System.in);

        System.out.println(" Introduzca el numero: ");
        int numero = lectorTeclado.nextInt();
        lectorTeclado.close();


        int decenas_de_mil = numero / 10000;
        int unidades_mil = (numero / 1000) % 10;
        int centenas = (numero / 100) % 10;
        int decenas = (numero / 10) % 10;
        int unidades = numero % 10;

        System.out.println("Decennas de mil: " + decenas_de_mil);
        System.out.println("Unidades mil: " + unidades_mil);
        System.out.println("Centenas: " + centenas);
        System.out.println("Decenas: " + decenas);
        System.out.println("Unidades: " + unidades);
    }

    public void ejercicio11() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("introduzca cual quier numero (0-100)");
        int numero = lectorTeclado.nextInt();
        lectorTeclado.close();


        boolean es_par = numero % 2 == 0;
        boolean mayor_50 = numero > 50;

        System.out.println("El número es par: " + es_par + "\nEs más que 50: " + mayor_50);
    }

    public void ejercicio12() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("introduzca primer linea: ");
        String prim_line = lectorTeclado.nextLine();

        System.out.println("introduzca segunda linea: ");
        String seg_line = lectorTeclado.nextLine();
        lectorTeclado.close();


        boolean iguales = prim_line.equals(seg_line);
        boolean prim_menor = prim_line.length() > seg_line.length();
        boolean distintas = !iguales;

        System.out.printf("La lineas son iguales-> %s\n" +
                "Primer linea es menor que segunda-> %s\n" +
                "Son distintas-> %s", iguales, prim_menor, distintas);
    }

    public void ejercicio13() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Escribe un número entre 0 y 9");
        int num1 = lectorTeclado.nextInt();
        System.out.println("Escribe un número entre 0 y 9");
        int num2 = lectorTeclado.nextInt();
        lectorTeclado.close();


        boolean par1 = (num1 % 2 == 0 && num2 % 2 != 0);
        ;
        System.out.printf("El primero es par y el segundo impar -> %b\n", par1);

        boolean sup_doble = (num1 ^ 2) == num2 && num2 < 8;
        System.out.printf("El primero es superior al doble del segundo e inferior a 8 -> %b\n", sup_doble);

        boolean iguales = (double) num1 == num2 || (num1 - num2) < 2;
        System.out.printf("Son iguales o la diferencia entre el primero y el segundo es menor que 2 -> %b", iguales);
    }

    public void ejercicio14() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Introduzca tus años ->");
        int anos = lectorTeclado.nextInt();

        System.out.println("Introduzca tu nivel de estudios (0-10)->");
        int niv_estud = lectorTeclado.nextInt();

        System.out.println("Introduzca yus ingreesos ->");
        int ingresos = lectorTeclado.nextInt();
        lectorTeclado.close();

        boolean mayor_q = anos > 40 && (niv_estud > 5) || (niv_estud < 8) && ingresos < 15000;
        System.out.println("Mas de 40 años y estudios entre 5 y 8 y gana menos de 15000: " + mayor_q);
    }

    public void ejercicio15() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Introduzca el número");
        int numero = lectorTeclado.nextInt();
        lectorTeclado.close();

        int sumar = numero += 5;
        int restar = numero -= 3;
        int multi = numero *= 10;
        int divid = numero /= 10;
        int numero1 = numero;

        System.out.println("ENTERO" + numero1);
        System.out.println("Incrementar 5 unidades: " + sumar);
        System.out.println("Decrementar 3 unidades: " + restar);
        System.out.println("Multiplicar por 10: " + multi);
        System.out.println("Dividir por 2: " + divid);
    }

    public void metodosPalabra() {
        String palabra = "Hola que tal estas";
        System.out.println(palabra.length());
        System.out.println("Son iguales" + palabra.equalsIgnoreCase("Hola que tal"));
        System.out.println("Son iguales" + palabra.toLowerCase().equals("hola que tal"));
        System.out.println("Hola son iguales" + palabra.toUpperCase().equals("HOLA QUE TAL"));
        int numewoLetras = palabra.replaceAll(" ", "").length();
        System.out.println("El numero de letras es" + numewoLetras);
        String[] palabras = palabra.split(" ");
        System.out.println("El numero de letras es" + palabras.length);
        // si contiene algo
        boolean contiene1 = palabra.contains("A");
        System.out.println(contiene1);

        char letra = palabra.charAt(palabra.length() - 1);
        System.out.println(letra);

    }

    public void ejercicios() {
        lectorTeclado = new Scanner(System.in);

        System.out.println("Escribe primer número para calcular");
        int numero1 = lectorTeclado.nextInt();
        System.out.println("Escribe segundo número para calcular");
        int numero2 = lectorTeclado.nextInt();

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        System.out.println("¿Que operacion quieres hacer?" +
                "\n1.suma\n2.resta\n3.multiplicacon\n4.divicion\n5.división entera\n6.división real\n7.salir");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        int operacion = lectorTeclado.nextInt();


        switch (operacion) {
            case 1:
                if (numero1 < 0 || numero2 < 0) {
                    System.out.println("No se puede calcular ");
                } else {
                    int oper_suma = numero1 + numero2;
                    System.out.println("Resultado es " + oper_suma);
                }
                break;
            case 2:
                if (numero1 < 0 || numero2 < 0) {
                    System.out.println("No se puede calcular ");
                } else {
                    int oper_resta = numero1 - numero2;
                    System.out.println("Resultado es " + oper_resta);
                }
                break;

            case 3:
                if (numero1 < 0 || numero2 < 0) {
                    System.out.println("No se puede calcular ");
                } else {
                    int oper_multip = numero1 * numero2;
                    System.out.println("Resultado es " + oper_multip);
                }
                break;

            case 4:
                if (numero1 < 0 || numero2 < 0) {
                    System.out.println("No se puede calcular ");
                } else if (numero2 == 0) {
                    System.out.println("No es posible dividir entre cero");
                } else {
                    double oper_divi = numero1 / numero2;
                    System.out.println("Resultado es " + oper_divi);
                }
                break;

            case 5:
                if (numero1 < 0 || numero2 < 0) {
                    System.out.println("No se puede calcular ");
                } else if (numero2 == 0) {
                    System.out.println("No es posible dividir entre cero");
                } else {
                    int oper_divi1 = numero1 / numero2;
                    int oper_resto = numero1 % numero2;
                    System.out.println("Resultado es " + oper_divi1 + " y la resta es " + oper_resto);
                }
                break;

            case 6:
                if (numero1 < 0 || numero2 < 0) {
                    System.out.println("No se puede calcular ");
                } else if (numero2 == 0) {
                    System.out.println("No es posible dividir entre cero");
                } else {
                    double oper_divi_real = (double) numero1 / numero2;
                    System.out.println("Resultado es " + oper_divi_real);
                }
                break;
            case 7:
                System.out.println("Seleccion salir");
                break;

            default:
                System.out.println("No se puede calcular, opción inválida ");
                break;

        }
    }

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
    public void ejercicioif3(){
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
        } else if (numero2 > numero1 && numero2 > numero3 ) {
            System.out.println("Numero 2 mayor de todos ");
        } else {
            System.out.println("Numero 3 mayor de todos ");
        }


    }




}