package servicio;
import modelo.Estudiante;
import java.util.*;

public class GestorEstudiantes {

    private HashMap<String, Estudiante> mapaEstudiantes;
    private TreeSet<Estudiante> ranking;
    private ArrayList<Estudiante> lista;

    public GestorEstudiantes() {
        mapaEstudiantes = new HashMap<>();
        ranking = new TreeSet<>();
        lista = new ArrayList<>();
    }

    public boolean agregarEstudiante(Estudiante e) {

        if (mapaEstudiantes.containsKey(e.getCarnet())) {
            return false;
        }

        mapaEstudiantes.put(e.getCarnet(), e);
        ranking.add(e);
        lista.add(e);

        return true;
    }

    public Estudiante buscarPorCarnet(String carnet) {
        return mapaEstudiantes.get(carnet);
    }

    public List<Estudiante> listarTodos() {
        return lista;
    }

    public Set<Estudiante> obtenerRanking() {
        return ranking;
    }
}