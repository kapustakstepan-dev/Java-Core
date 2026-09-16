package Controller;

import DAO.CombustibleDAO;
import DAO.EstadoDAO;
import DAO.MarcaDAO;
import Model.Coche;
import Model.Combustible;
import Model.Estado;
import Model.Marca;

import java.io.*;
import java.util.ArrayList;

public class FileController {
    private MarcaDAO marcaDAO;
    private CombustibleDAO combustibleDAO;
    private EstadoDAO estadoDAO;


    public FileController(){
        marcaDAO = new MarcaDAO();
        combustibleDAO = new CombustibleDAO();
        estadoDAO = new EstadoDAO();
    }

    public ArrayList<Coche> importarCoches() {
        //File -> FileReader -> BufferedReader
        ArrayList<Coche> coches = new ArrayList<>();

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("src/main/java/coches.csv"));
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split(",");

                int idMarca = Integer.parseInt(datos[1]);
                Marca marca = marcaDAO.getMarcaPorId(idMarca);
                int idCombustible = Integer.parseInt(datos[4]);
                Combustible combustible = combustibleDAO.getCombustiblePorId(idCombustible);
                int idEstado = Integer.parseInt(datos[8]);
                Estado estado = estadoDAO.getEstadoPorId(idEstado);

                Coche coche = new Coche(datos[0], marca,
                        datos[2], datos[3], combustible,
                        Integer.parseInt(datos[5]),Integer.parseInt(datos[6]),
                        Integer.parseInt(datos[7]), estado);

                if (marca == null || combustible == null || estado == null){
                    System.out.println("Marca, combustible y estado no estan cargados en la BD");
                    continue;
                }

                coches.add(coche);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) {
            System.out.println("Fallo el permiso de lectura");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("error al cerrar el flujo");
            }
        }
        return coches;
    }
}
