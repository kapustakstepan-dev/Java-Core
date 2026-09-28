package controller;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {

    private final String pathBase = "src/main/java/fils";
    public static final String HEADER = "ID,TYPE,TUITION,MARC,COLOR,YEAR,CV,KM,PRICE,MAIL,EXTRA";


    public void exportCSV(List<Auto> list, String mail) throws IOException {
        File file;
        if (mail == null){
            file = new File(pathBase +"all.csv");
        } else {
            file = new File(pathBase + mail + ".csv");
        }

        if (!file.exists()){
            file.createNewFile();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedWriter.write(HEADER);
            for (Auto auto : list){
                bufferedWriter.newLine();
                bufferedWriter.write(auto.toCSV());
            }
        }
        System.out.println("Exportados " + list.size() + " vehiculos a " + file.getPath());
    }

    public ArrayList<Auto> importCSV(String fileName){
        ArrayList<Auto> list = new ArrayList<>();
        File file = new File(pathBase + fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) !=null){
                String[] date = line.split(",");

                Owner owner = new Owner(null, null, date[9], null);
                String tuition = date[4], marc = date[3], color = date[4];
                int year = Integer.parseInt(date[5]), cv = Integer.parseInt(date[6]), km = Integer.parseInt(date[7]);

                Auto auto;
                if (date[1].equalsIgnoreCase("Car")){
                    auto = new Car(tuition, year, cv, marc, color, km, owner, 0, Integer.parseInt(date[10]));
                } else if (date[1].equalsIgnoreCase("Bus")){
                    auto = new Bus(tuition, year, cv, marc, color, km, owner, 0, Integer.parseInt(date[10]));
                } else {
                    auto = new Truck(tuition, year, cv, marc, color, km, owner,0, Double.parseDouble(date[10]));
                }
                list.add(auto);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void exportObject(ArrayList<Auto> list){
        File file = new File(pathBase +"data.obj");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Auto> importObject() {
        File file = new File(pathBase + "data.obj");
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Auto>) ois.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.out.println("Error leyendo data.obj: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
