package controller;

import java.io.*;

public class Controller {

    BufferedReader bufferedReader;


    public void decodificar(){
        try {
            bufferedReader = new BufferedReader(new FileReader("src/main/java/files/fichero.txt"));
            String linea = bufferedReader.readLine();
            String[] codigoStr = linea.split(" ");
            for (String item: codigoStr){
                int codigo = Integer.parseInt(item);
                char letra = (char) codigo;
                System.out.print(letra);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en la ruta");
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        }
    }






}
