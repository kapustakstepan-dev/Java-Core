public class OperacionesDeCalculadora {

    public int sumar(int operador1, int operador2){
        if (validarNumeros(operador1, operador2)){
            return operador1 + operador2;
        }
        return 0;
    }

    public Integer restar(int operado1, int operado2){
        if (validarNumeros(operado1, operado2)){
            return operado1 - operado2;

        }
        return null;
    }
    public boolean validarNumeros(int op1, int op2) {


        return op1>0 && op2>0;
    }
}
