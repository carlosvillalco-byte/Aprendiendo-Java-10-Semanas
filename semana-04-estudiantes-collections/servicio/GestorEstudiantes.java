package servicio;

import modelo.Estudiante;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;

public class GestorEstudiantes {

    private HashMap<String, Estudiante> porCarnet;
    private TreeSet<Estudiante> ranking;
    private ArrayList<String> historial;

    public GestorEstudiantes() {
        porCarnet = new HashMap<>();
        ranking = new TreeSet<>();
        historial = new ArrayList<>();
    }

    // Agregar estudiante
    public boolean agregar(Estudiante e) {

        if (porCarnet.containsKey(e.getCarnet())) {
            return false;
        }

        porCarnet.put(e.getCarnet(), e);
        ranking.add(e);

        historial.add("AGREGAR: " + e.getCarnet() +
                " - " + e.getNombre());

        return true;
    }

    // Buscar estudiante
    public Estudiante buscar(String carnet) {
        return porCarnet.get(carnet);
    }

    // Actualizar promedio
    public boolean actualizarPromedio(String carnet, double nuevoProm) {

        Estudiante e = porCarnet.get(carnet);

        if (e == null)
            return false;

        ranking.remove(e);

        e.setPromedio(nuevoProm);

        ranking.add(e);

        historial.add("ACTUALIZAR: " + carnet +
                " promedio -> " + nuevoProm);

        return true;
    }

    // Eliminar estudiante
    public boolean eliminar(String carnet) {

        Estudiante e = porCarnet.remove(carnet);

        if (e == null)
            return false;

        ranking.remove(e);

        historial.add("ELIMINAR: " + carnet +
                " - " + e.getNombre());

        return true;
    }

    // Mostrar ranking
    public void mostrarRanking() {

        System.out.println("\n=== Ranking de estudiantes ===");

        int pos = 1;

        for (Estudiante e : ranking) {
            System.out.printf("%3d. %s%n", pos++, e);
        }
    }

    // Mostrar Top 5
    public void mostrarTop5() {

        System.out.println("\n=== Top 5 estudiantes ===");

        int count = 0;

        Estudiante[] arr = ranking.toArray(new Estudiante[0]);

        int inicio = Math.max(0, arr.length - 5);

        for (int i = arr.length - 1; i >= inicio; i--) {
            System.out.printf("%d. %s%n", ++count, arr[i]);
        }
    }

    // Filtrar por carrera
    public void filtrarPorCarrera(String carrera) {

        System.out.println("\n=== Estudiantes de " + carrera + " ===");

        for (Estudiante e : porCarnet.values()) {

            if (e.getCarrera().equalsIgnoreCase(carrera)) {
                System.out.println(e);
            }
        }
    }

    // Mostrar historial
    public void mostrarHistorial() {

        System.out.println("\n=== Historial de operaciones ===");

        if (historial.isEmpty()) {
            System.out.println("Sin operaciones registradas.");
            return;
        }

        for (String entrada : historial) {
            System.out.println(entrada);
        }
    }
}