public class OperacionesMatematicos {

    //1)acceso 2)retorno 3)nombeMetodo(arg) {cuerpo}

    public void realizarSaludo(String nombre){
        System.out.println("Hola " + nombre);

    }

    public int realizarSuma(int operador1, int operador2){
        if (numerosValidos(operador1,operador2)){
            int resultado = operador1 +operador2;
            return resultado;
        }
        //System.out.printf("El resultado de la suma %d + %d es %d%n "
        //,operador1, operador2, resultado);
        return 0;
    }

    private boolean numerosValidos(int op1, int op2){
        //forma larga
        /*if (op1 >= 0 && op2 >= 0){
            return true;
            }
         */
        // forma corta
        return op1 >= 0 && op2 >= 0;
    }



}
