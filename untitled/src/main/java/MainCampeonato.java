import Controller.Campeonato;

import model.CarreraCoches;
import model.Coche;

public class MainCampeonato {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato();
        campeonato.inscribirCarrera(new CarreraCoches(7000, "Abudabi"));
        campeonato.inscribirCarrera(new CarreraCoches(10000, "Las Vegas"));
        campeonato.inscribirCarrera(new CarreraCoches(17000, "Valencia"));
        campeonato.inscribirCarrera(new CarreraCoches(12000, "Barcelona"));
        campeonato.inscribirCarrera(new CarreraCoches(9000, "Italia"));
        campeonato.inscribirParticipante(new Coche("Ford1", "Focus1", "1234A", 100));
        campeonato.inscribirParticipante(new Coche("Ford2", "Focus2", "1234B", 120));
        campeonato.inscribirParticipante(new Coche("Ford3", "Focus3", "1234C", 130));
        campeonato.inscribirParticipante(new Coche("Ford4", "Focus4", "1234D", 140));

    }
}
