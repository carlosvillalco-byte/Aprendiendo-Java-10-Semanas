import servicio.GestorTareas;
import java.util.Scanner;

public class Main {

    // Instancia del gestor que maneja todas las operaciones
    static GestorTareas gestor = new GestorTareas();
    // Scanner para leer datos desde teclado
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        // Bucle principal del menú
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> gestor.listar();
                case 3 -> gestor.listarPendientes();
                case 4 -> gestor.listarCompletadas();
                case 5 -> completar();
                case 6 -> eliminar();
                case 7 -> estadisticas();
                case 8 -> System.out.println("Adios!");
                default -> System.out.println("Opcion invalida");
            }

        } while (opcion != 8);
    }

    // Muestra el menú principal
    static void mostrarMenu() {
        System.out.println("\n=== GESTOR DE TAREAS ===");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar todas");
        System.out.println("3. Listar pendientes");
        System.out.println("4. Listar completadas");
        System.out.println("5. Completar tarea");
        System.out.println("6. Eliminar tarea");
        System.out.println("7. Estadisticas");
        System.out.println("8. Salir");
        System.out.print("Opcion: "); 
    }

    // Solicita datos y agrega una nueva tarea
    static void agregar() {
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        gestor.agregar(titulo, descripcion);
    }

    // Marca una tarea como completada
    static void completar() {
        System.out.print("ID a completar: ");
        int id = scanner.nextInt();
        gestor.completar(id);
    }

    // Elimina una tarea por ID
    static void eliminar() {
        System.out.print("ID a eliminar: ");
        int id = scanner.nextInt();
        gestor.eliminar(id);
    }

    // Muestra estadísticas generales
    static void estadisticas() {
        int total = gestor.totalTareas();
        int pendientes = gestor.totalPendientes();
        int completadas = gestor.totalCompletadas();
        double porcentaje = total == 0 ? 0 : (completadas * 100.0) / total;

        System.out.println("=== ESTADISTICAS ===");
        System.out.println("Total de tareas: " + total);
        System.out.println("Pendientes: " + pendientes);
        System.out.println("Completadas: " + completadas);
        System.out.printf("Porcentaje completado: %.1f%%\n", porcentaje);
    }
}