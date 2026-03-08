import modelo.Estudiante;
import servicio.GestorEstudiantes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorEstudiantes gestor = new GestorEstudiantes();

        int opcion;

        do {

            System.out.println("\n=== SISTEMA DE ESTUDIANTES ===");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Buscar por carnet");
            System.out.println("3. Actualizar promedio");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Ver ranking");
            System.out.println("6. Ver top 5");
            System.out.println("7. Filtrar por carrera");
            System.out.println("8. Ver historial");
            System.out.println("0. Salir");

            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

        } while (opcion != 0);

        sc.close();
    }
}