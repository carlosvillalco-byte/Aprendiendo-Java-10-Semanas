package servicio;

import modelo.Tarea;
import java.util.ArrayList;

public class GestorTareas {

    // Lista dinámica que almacena todas las tareas
    private ArrayList<Tarea> tareas;

    // Controlador para generar IDs automáticos y secuenciales
    private int proximoId;

    // Constructor: inicializa la lista y el contador de IDs
    public GestorTareas() {
        tareas = new ArrayList<>();
        proximoId = 1;
    }

    // Crea una nueva tarea y la agrega a la lista
    public void agregar(String titulo, String descripcion) {
        Tarea nueva = new Tarea(proximoId, titulo, descripcion);
        tareas.add(nueva);

        System.out.println("Tarea agregada con ID: " + proximoId);
        proximoId++; 
    }

    // Muestra todas las tareas registradas
    public void listar() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas");
            return;
        }

        System.out.println("=== TODAS LAS TAREAS ===");
        for (Tarea t : tareas) {
            t.mostrarInfo();
        }
    }

    // Filtra y muestra solo las tareas pendientes
    public void listarPendientes() {
        System.out.println("=== TAREAS PENDIENTES ===");
        boolean hay = false;

        for (Tarea t : tareas) {
            if (!t.estaCompletada()) {
                t.mostrarInfo();
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay tareas pendientes");
        }
    }

    // Filtra y muestra solo las tareas completadas
    public void listarCompletadas() {
        System.out.println("=== TAREAS COMPLETADAS ===");
        boolean hay = false;

        for (Tarea t : tareas) {
            if (t.estaCompletada()) {
                t.mostrarInfo();
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay tareas completadas");
        }
    }

    // Busca una tarea por ID (retorna null si no existe)
    public Tarea buscar(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    // Marca una tarea como completada
    public void completar(int id) {
        Tarea t = buscar(id);

        if (t != null) {
            t.completar();
        } else {
            System.out.println("ID no encontrado");
        }
    }

    // Elimina una tarea existente por ID
    public void eliminar(int id) {
        Tarea t = buscar(id);

        if (t != null) {
            tareas.remove(t);
            System.out.println("Tarea eliminada");
        } else {
            System.out.println("ID no encontrado");
        }
    }

    // Retorna el total de tareas registradas
    public int totalTareas() {
        return tareas.size();
    }

    // Cuenta cuántas tareas siguen pendientes
    public int totalPendientes() {
        int c = 0;

        for (Tarea t : tareas) {
            if (!t.estaCompletada()) {
                c++;
            }
        }
        return c;
    }

    // Cuenta cuántas tareas están completadas
    public int totalCompletadas() {
        int c = 0;

        for (Tarea t : tareas) {
            if (t.estaCompletada()) {
                c++;
            }
        }
        return c;
    }
}
