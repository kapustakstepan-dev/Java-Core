package controller;

import java.io.*;

public class Gestor {
    File file;
    FileReader reader;
    BufferedReader bufferedReader;
    FileWriter fileWriter;
    PrintWriter printWriter;

    public void codificar(String mensaje, int face){
        try {
            fileWriter = new FileWriter("src/ficheros/mensaje.txt", true);
            for (int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);
                int codigo = letra;
                fileWriter.write(codigo*face);

            }
        } catch (IOException e) {
            System.out.println("La ruta es incorrecta");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error en cerrado el flugo");
            }
        }
    }

    public void decodificar(int face){
        try {
            reader = new FileReader("src/ficheros/mensaje.txt");
            int codigo;
            while ((codigo= reader.read())!= -1){
                char letra = (char) (codigo/face);
                System.out.print(letra);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("La ruta es incorrecta");
        } catch (IOException e){
            System.out.println("Error en la lectura");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("");
            }
        }


    }

    public void desencriptar(){
       /* try {
            bufferedReader = new BufferedReader(new FileReader("src/main/java/ficheros/codigo.txt"));
            String linea = bufferedReader.readLine();
            String[] codigoStr = linea.split(" ");
            for (String item: codigoStr){
                int codigo = Integer.parseInt(item);
                char letra = (char) codigo;
                System.out.println(letra);

            }

        } catch (FileNotFoundException e) {
            System.out.println("Error no se encuentra el fichero");
        } catch (IOException e){
            System.out.println("Error en la lectura");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        */
        BufferedReader bufferedReader1 = null;
        try {
            bufferedReader1 = new BufferedReader(new FileReader("src/ficheros/mensaje.txt"));
            String mensaje = bufferedReader1.readLine();
            if (mensaje != null) {
                for (char item : mensaje.toCharArray()) {
                    System.out.print((int) item + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }

    public void encriptar(String mensaje, int face){
        try {
            fileWriter = new FileWriter("src/ficheros/mensaje0101.txt");
            for (int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);
                int codigo = letra;
                String codigoLetra = String.valueOf(codigo);
                fileWriter.write(codigoLetra);
                fileWriter.write(" ");

            }

        } catch (IOException e) {
            System.out.println("Error en la ruta del fichero");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error en caraminto del fichero");
            }
        }

    }

}
