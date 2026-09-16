import java.util.Scanner;

public class Ejercicos {


    public void ejercicioPotencia(int base, int exponente) {
        Scanner LectorTeclado = new Scanner(System.in);
        if (base == 0 && exponente == 0) {
            System.out.println("Error ");
        } else if (exponente == 0) {
            System.out.println("El numero de la potencia es: ");
        } else {
            int resultado = 1;
            for (int i = 0; i < exponente; i++) {
                //resultado = resultado * base;
                resultado *= 2;
            }
            System.out.println("El resultado de potencia es " + resultado);
        }


    }

    public void NumerosPares(int rango1, int rango2) {

        if (rango1 > rango2) {

        } else {
            for (int i = rango1; i <= rango2; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        }

    }

    public void EjercicioDado(int veses) {
        if (veses <= 0) {
            veses = 100;
        }
        int nUnos = 0, nDos = 0, nTres = 0, nCuatro = 0, nCinco = 0, nSeis = 0;

        for (int i = 0; i < veses; i++) {
            int tiradaDado = (int) (Math.random() * 6) + 1;
            if (tiradaDado == 1) {
                nUnos++;
            } else if (tiradaDado == 2) {
                nDos++;
            } else if (tiradaDado == 3) {
                nTres++;
            } else if (tiradaDado == 4) {
                nCuatro++;
            } else if (tiradaDado == 5) {
                nCinco++;
            } else if (tiradaDado == 6) {
                nSeis++;
            }
            System.out.println(nUnos);
        }


    }

    public String NumerosBinarios(int numero, int base) {
        int resto;
        String resultado = "";
        while (numero != 0) {
            if (base == 16) {
                resto = numero % base;
                numero = numero / base;
                switch (resto) {
                    case 10:
                        resultado = "A" + resultado;
                        break;
                    case 11:
                        resultado = "B" + resultado;
                        break;
                    case 12:
                        resultado = "C" + resultado;
                        break;
                    case 13:
                        resultado = "D" + resultado;
                        break;
                    case 14:
                        resultado = "E" + resultado;
                        break;
                    case 15:
                        resultado = "F" + resultado;
                        break;
                    default:
                        resultado = resto + resultado;

                }
            } else {
                resto = numero % base;
                numero = numero / base;
                resultado = resto + resultado;
            }
        }
        System.out.println("el resultado es " + resultado);
        return resultado;


    }

    public void cambiarDecimal(String numeroOriginal, int base) {
        int resultado = 0;

        for (int i = 0; i < numeroOriginal.length(); i++) {
            String numeroSTR = String.valueOf(numeroOriginal.charAt(i));
            int numeroInd = Integer.parseInt(numeroSTR);
            System.out.println(numeroSTR);
            resultado += numeroInd * Math.pow(base, (numeroOriginal.length() - 1 - i));
            if (base == 16) {
                if (Character.isDigit(numeroOriginal.charAt(i))) {
                    numeroInd = Integer.parseInt(numeroSTR);

                } else {
                    switch (numeroOriginal.charAt(i)) {
                        case 'A'->{numeroInd = 10;}
                        case 'B'->{numeroInd = 11;}
                        case 'C'->{numeroInd = 12;}
                        case 'D'->{numeroInd = 13;}
                        case 'E'->{numeroInd = 14;}
                        case 'F'->{numeroInd = 15;}


                    }



                }
            } else {
                numeroInd = Integer.parseInt(numeroSTR);
            }
            resultado += numeroInd * Math.pow(base, (numeroOriginal.length() - 1 - i));
        }
        System.out.println("El resultado es " + resultado);

    }


}
