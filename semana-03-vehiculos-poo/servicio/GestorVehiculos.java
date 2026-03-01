package servicio;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.*;

public class GestorVehiculos {

    private ArrayList<Vehiculo> flota;
    private Scanner sc;

    public GestorVehiculos() {
        flota = new ArrayList<>();
        sc = new Scanner(System.in);

        // Vehiculos iniciales
        flota.add(new Auto("Toyota", "Corolla", 2024, 4));
        flota.add(new Moto("Honda", "CB500", 2023, false));
        flota.add(new Camion("Volvo", "FH16", 2022, 24.0));
        flota.add(new AutoElectrico("Tesla", "Model 3", 2024, 4, 80));
        flota.add(new MotoElectrica("NIU", "NQi", 2023, 60));
    }

    // =========================
    // MENU PRINCIPAL
    // =========================
    public void menu() {
        int opcion;

        do {
            System.out.println("\n=== GESTION DE VEHICULOS ===");
            System.out.println("1. Listar todos");
            System.out.println("2. Filtrar por tipo");
            System.out.println("3. Ver electricos y baterias");
            System.out.println("4. Cargar baterias bajas");
            System.out.println("5. Demostrar polimorfismo");
            System.out.println("6. Estadisticas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> listarTodos();
                case 2 -> filtrarPorTipo();
                case 3 -> mostrarElectricos();
                case 4 -> cargarBateriasBajas();
                case 5 -> demostrarPolimorfismo();
                case 6 -> estadisticas();
                case 7 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida");
            }

        } while (opcion != 7);
    }

    // =========================
    // METODOS DEL SISTEMA
    // =========================

    private void listarTodos() {
        System.out.println("\n--- LISTA DE VEHICULOS ---");
        for (Vehiculo v : flota) {
            System.out.println(v);
        }
    }

    private void filtrarPorTipo() {
        System.out.print("Ingrese tipo (Auto/Moto/Camion): ");
        String tipo = sc.next();

        for (Vehiculo v : flota) {
            if (v.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                System.out.println(v);
            }
        }
    }

    private void mostrarElectricos() {
        System.out.println("\n--- VEHICULOS ELECTRICOS ---");
        for (Vehiculo v : flota) {
            if (v instanceof Electrico e) {
                System.out.println(v + " - Bateria: " + e.getNivelBateria() + "%");
            }
        }
    }

    private void cargarBateriasBajas() {
        System.out.println("\n--- CARGANDO BATERIAS ---");
        for (Vehiculo v : flota) {
            if (v instanceof Electrico e && e.necesitaCarga()) {
                e.cargarBateria();
                System.out.println(v + " fue cargado");
            }
        }
    }

    private void demostrarPolimorfismo() {
        System.out.println("\n== DEMOSTRACION DE POLIMORFISMO ==");
        for (Vehiculo v : flota) {
            v.acelerar();
        }
    }

    private void estadisticas() {
        System.out.println("\nTotal de vehiculos: " + flota.size());
    }
}