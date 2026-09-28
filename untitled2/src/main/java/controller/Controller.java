package controller;

import model.Auto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private ArrayList<Auto> autoList;
    private long id;
    private FileController fileController;
    private APIController apiController;

    public Controller() {
        autoList = new ArrayList<>();
        fileController = new FileController();
        apiController = new APIController();
    }

    public boolean addAuto(Auto auto){
        if (auto == null || auto.getTuition() == null || auto.getTuition().isBlank()){
            return  false;
        }
        if (findByTuition(auto.getTuition()) != null){
            System.out.println("Ya existe un vehiculo con matricula " + auto.getTuition());
            return false;
        }

        id++;
        auto.setId(id);
        return autoList.add(auto);
    }

    public Auto findByTuition(String tuition){
        return autoList.stream().filter(i-> i.getTuition().equalsIgnoreCase(tuition))
                .findFirst().orElse(null);
    }

    public boolean removeAuto(String tuition){
        return autoList.removeIf(a-> a.getTuition().equalsIgnoreCase(tuition));
    }

    public void listAll(){
        autoList.forEach(Auto::showData);
    }

    public void listByMarc(String marc){
        autoList.stream().filter(i-> i.getMarc().equalsIgnoreCase(marc))
                .forEach(Auto::showData);
    }

    public void listSold(){
        autoList.stream().filter(Auto::isSold).forEach(Auto::showData);
    }

    public double totalValue(){
        return  autoList.stream().mapToDouble(Auto::getPrice).sum();
    }

    public boolean sellAuto(String tuition){
        Auto auto = findByTuition(tuition);
        if (auto == null){
            System.out.println("No existe la matricula " + tuition);
            return false;
        }
        auto.sell();
        return auto.isSold();
    }

    public void exportCSV(){
        try {
            fileController.exportCSV(autoList, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportCSVByMail(String mail){
        List<Auto> list = autoList.stream()
                .filter(i-> i.getOwner()!= null && i.getOwner().getEmail().equalsIgnoreCase(mail)).toList();

        try {
            fileController.exportCSV(list, mail);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void importCSV (String fileName){
        int size = autoList.size();
        for (Auto auto : fileController.importCSV(fileName)){
            addAuto(auto);
        }
        System.out.println("Importados " + (autoList.size() - size) + " vehiculos");
    }

    public void importObject(){
        for (Auto auto : fileController.importObject()){
            addAuto(auto);
        }
    }

    public void exportObject(){fileController.exportObject(autoList);}

    public void importAPI(){
        int size = autoList.size();
        for (Auto auto: apiController.getVehicles()){
            addAuto(auto);
        }
        System.out.println("Importados " + (autoList.size() - size) + " vehiculos de la API");
    }

   public ArrayList<Auto> getAutoList(){ return autoList;}

}
