package Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Carrera;
import model.CarreraCoches;
import model.Coche;

import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.util.ArrayList;
import java.util.Iterator;

@Data
@AllArgsConstructor
public class Campeonato {
    private ArrayList<CarreraCoches> listaCarrera;
    private ArrayList<Coche> listaParticipantes;

    public Campeonato(){
        listaCarrera = new ArrayList<>();
        listaParticipantes = new ArrayList<>();
    }

    public void iniciarCampeonato(){
        for (CarreraCoches item : listaCarrera){
            System.out.println("Coriendo la carrera " + item.getNombre());
            item.setParticipantes(listaParticipantes);
            item.iniciarCarrera();
        }
    }
    public  void inscribirCarrera(CarreraCoches carrera){
        this.listaCarrera.add(carrera);
    }

    public void inscribirParticipante(Coche coche) {
        if (buscarCoche(coche.getMatricula()) != null) {
            System.out.println("Coche ya en la lista de participantes");
        } else {
            if (listaParticipantes.size() < 20) {
                listaParticipantes.add(coche);
                System.out.println("Participante agregado correctamente");
            } else {
                System.out.println("Lista completa");
            }

        }
    }

    private Coche buscarCoche(String mat) {

        for (Coche coche : listaParticipantes) {
            if (coche.getMatricula().equals(mat)) {
                return coche;
            }
        }
        return null;
    }
}
