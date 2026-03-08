import modelo.Estudiante;
import servicio.GestorEstudiantes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorEstudiantes gestor = new GestorEstudiantes();

        cargarDatosPrueba(gestor);

        int opcion;

        do {

            System.out.println("\n=== SISTEMA DE ESTUDIANTES ===");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Buscar por carnet");
            System.out.println("3. Actualizar promedio");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Ver ranking completo");
            System.out.println("6. Ver top 5");
            System.out.println("7. Filtrar por carrera");
            System.out.println("8. Ver historial");
            System.out.println("9. Ver estadísticas");
            System.out.println("0. Salir");

            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> {
                    System.out.print("Carnet: ");
                    String carnet = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Carrera: ");
                    String carrera = sc.nextLine();

                    System.out.print("Promedio: ");
                    double prom = sc.nextDouble();
                    sc.nextLine();

                    boolean ok = gestor.agregar(
                            new Estudiante(carnet, nombre, carrera, prom));

                    System.out.println(ok ?
                            "Estudiante registrado." :
                            "Error: carnet ya existe.");
                }

                case 2 -> {
                    System.out.print("Carnet: ");
                    String carnet = sc.nextLine();

                    Estudiante e = gestor.buscar(carnet);

                    System.out.println(e != null ? e : "No encontrado.");
                }

                case 3 -> {
                    System.out.print("Carnet: ");
                    String carnet = sc.nextLine();

                    System.out.print("Nuevo promedio: ");
                    double p = sc.nextDouble();
                    sc.nextLine();

                    boolean ok = gestor.actualizarPromedio(carnet, p);

                    System.out.println(ok ?
                            "Promedio actualizado." :
                            "Carnet no existe.");
                }

                case 4 -> {
                    System.out.print("Carnet: ");
                    String carnet = sc.nextLine();

                    boolean ok = gestor.eliminar(carnet);

                    System.out.println(ok ?
                            "Estudiante eliminado." :
                            "Carnet no encontrado.");
                }

                case 5 -> gestor.mostrarRanking();

                case 6 -> gestor.mostrarTop5();

                case 7 -> {
                    System.out.print("Carrera: ");
                    String carrera = sc.nextLine();
                    gestor.filtrarPorCarrera(carrera);
                }

                case 8 -> gestor.mostrarHistorial();

                case 9 -> gestor.mostrarEstadisticas();
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void cargarDatosPrueba(GestorEstudiantes g) {

        g.agregar(new Estudiante("2021001","Ana Torres","Sistemas",75.5));
        g.agregar(new Estudiante("2021002","Carlos Quispe","Industrial",88.0));
        g.agregar(new Estudiante("2021003","Maria Condori","Sistemas",92.3));
        g.agregar(new Estudiante("2021004","Luis Mamani","Civil",61.0));
        g.agregar(new Estudiante("2021005","Rosa Flores","Industrial",79.5));
        g.agregar(new Estudiante("2021006","Pedro Vargas","Sistemas",55.0));
        g.agregar(new Estudiante("2021007","Silvia Choque","Civil",83.5));
        g.agregar(new Estudiante("2021008","Hugo Espejo","Industrial",70.0));
        g.agregar(new Estudiante("2021009","Patricia Lima","Sistemas",95.0));
        g.agregar(new Estudiante("2021010","Diego Arce","Civil",67.5));
    }
}