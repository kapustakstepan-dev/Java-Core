package controller;

import model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {

    private File file;
    private FileWriter fileWriter;
    private String pathBase = "src/main/java/files/";

/*
    public void importCSV(ArrayList<String[]> taskList){

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((linea = bufferedReader.readLine()) != null) {

                String[] datos = linea.split(coma);

                taskList.add(datos);

                for (String dato : datos) {
                    System.out.print(dato.trim() + " | ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error en la importacion de datos al fichero .csv");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el file");
            }
        }


    }

    public void exportCSV(ArrayList<String[]> taskList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            for (String[] fila : taskList) {
                String lineaCSV = String.join(coma, fila);

                bufferedWriter.write(lineaCSV);
                bufferedWriter.newLine();
            }

            System.out.println("Exportación a CSV completada con exito.");

        } catch (IOException e) {
            System.out.println("Error en la exportación de datos al fichero .csv: " + e.getMessage());
        }
    }

 */


    public void exportAll(List<Task> liasAll, String mail) throws IOException {
        file = new File(pathBase + mail + "all.csv");
        if (!file.exists()){
            file.createNewFile();
        }

        fileWriter = new FileWriter(file);
        fileWriter.write("ID, TITLE, LEVEL, MAIL, TYPE");
        for (int i = 0; i < liasAll.size()-1; i++) {
            fileWriter.write(liasAll.get(i).toCSV()+"\n");
        }
        fileWriter.write(liasAll.getLast().toCSV());

    }

    public void expotByMail(List<Task> liasMail, String mail) throws IOException {
        if (mail == null){
            file = new File(pathBase + "all.csv");
        } else {
            file = new File(pathBase + mail + "all.csv");
        }


        if (!file.exists()){
            file.createNewFile();
        }

        fileWriter = new FileWriter(file);
        fileWriter.write("ID, TITLE, LEVEL, MAIL, TYPE");
        for (int i = 0; i < liasMail.size()-1; i++) {
            fileWriter.write(liasMail.get(i).toCSV()+"\n");
        }
        fileWriter.write(liasMail.getLast().toCSV());

    }


}
