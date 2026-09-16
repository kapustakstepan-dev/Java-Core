package OperacionesFichero.controller;

import java.io.*;

public class OperacionesFichero {


    public void infoCarpeta(String path){
        File file = new File(path);

        System.out.println("El nombre del fichero es "+file.getName());
        System.out.println("Es fichero? "+file.isFile());
        System.out.println("Puedo leer? "+file.canRead());
        System.out.println("Si existe el file? "+file.exists());

        if (file.isDirectory()) {
            System.out.println("El numero de elementos que hay dentro es de: " + file.list().length);
            for (File item : file.listFiles()) {
                System.out.println(item.getName());
            }
        }
    }

    public void listarFicheros(String path){
        File file = new File(path);
        System.out.println(file.getName());
        if (file.isDirectory()){
            for (File item : file.listFiles()){
                listarFicheros(item.getAbsolutePath());
            }
        }
    }

    public void crearFichero(String path){
        File file = new File(path);

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error en la creacion del file");
            }
        } else {
            System.out.println("EL file ya existe -> " + file.getName());
        }
    }

    public void crearCarpeta(String path){
        File file = new File(path);

        if (file.mkdirs()){
            System.out.println("Carpeta esta creada");
        } else {
            System.out.println("Fallo la carpeta no se puede crear");
        }
    }

    public void leerFihero(String path){
        File file = new File(path);
        FileReader reader = null;

        try {
            reader = new FileReader(file);
            int codigo;

            while ((codigo= reader.read())!=-1){
                System.out.print((char) codigo);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir file");
        } catch (IOException e) {
            System.out.println("Error en permiso de lectura");
        } finally {
            try {
                reader.close();
            } catch (IOException | NullPointerException e){
                System.out.println("Error al cerado del file");
            }
        }
    }

    public void leerFicheroLineas(String path){
        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea;

            while ((linea = bufferedReader.readLine())!=null){
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el file");
        } catch (IOException e) {
            System.out.println("No tiene permosos de lectura");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error al cerado de file");
            }
        }
    }


    public void decifrar(String path){
        File file = new File(path);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String linea = reader.readLine();
            String[] codigo = linea.split(" ");
            for (String item : codigo){
                char letra = (char)(Integer.parseInt(item));
                System.out.print(letra);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir file");
        } catch (IOException e) {
            System.out.println("Error en permiso de leer");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error al cerrado del file");
            }
        }

    }
}
