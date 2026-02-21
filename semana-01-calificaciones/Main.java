import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    // Validaciones de datos

    public static String leerNombre(Scanner sc, String msg) {
        String nombre;
        do {
            System.out.print(msg);
            nombre = sc.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacio.");
            }

        } while (nombre.isEmpty());

        return nombre;
    }

    public static int leerEntero(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int valor = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un numero valido.");
                sc.nextLine();
            }
        }
    }

    public static int leerEnteroRango(Scanner sc, String msg, int min, int max) {
        int valor;
        while (true) {
            valor = leerEntero(sc, msg);

            if (valor < min || valor > max) {
                System.out.println("Error: El numero debe estar entre " + min + " y " + max);
            } else {
                return valor;
            }
        }
    }


    public static void calcularPromedios(int[][] notas, double[] promedios) {
        for (int i = 0; i < notas.length; i++) {
            int suma = 0;
            for (int j = 0; j < notas[i].length; j++) {
                suma += notas[i][j];
            }
            promedios[i] = suma / (double) notas[i].length;
        }
    }

    public static void mostrarResultados(String[] nombres, int[][] notas, double[] promedios) {

        System.out.println("========== RESULTADOS ==========");
        System.out.printf("%-15s %4s %4s %4s %6s %10s%n",
                "Nombre", "N1", "N2", "N3", "Prom", "Estado");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < nombres.length; i++) {

            String estado = (promedios[i] >= 51) ? "APROBADO" : "REPROBADO";

            System.out.printf("%-15s %4d %4d %4d %6.1f %10s%n",
                    nombres[i],
                    notas[i][0],
                    notas[i][1],
                    notas[i][2],
                    promedios[i],
                    estado);
        }
    }

    public static void mostrarEstadisticas(double[] promedios, int[][] notas) {

        int aprobados = 0;
        int reprobados = 0;

        double sumaGeneral = 0;

        for (int i = 0; i < promedios.length; i++) {
            sumaGeneral += promedios[i];

            if (promedios[i] >= 51)
                aprobados++;
            else
                reprobados++;
        }

        double promedioGeneral = sumaGeneral / promedios.length;

        int max = notas[0][0];
        int min = notas[0][0];

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] > max) max = notas[i][j];
                if (notas[i][j] < min) min = notas[i][j];
            }
        }

        double porcAprob = aprobados * 100.0 / promedios.length;
        double porcReprob = reprobados * 100.0 / promedios.length;

        System.out.println("\n========== ESTADISTICAS ==========");
        System.out.printf("Promedio general del curso: %.2f%n", promedioGeneral);
        System.out.println("Nota mas alta: " + max);
        System.out.println("Nota mas baja: " + min);
        System.out.printf("Aprobados: %d (%.1f%%)%n", aprobados, porcAprob);
        System.out.printf("Reprobados: %d (%.1f%%)%n", reprobados, porcReprob);
    }

    // -------------Main--------------

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int CANT_ESTUDIANTES = 5;
        final int CANT_NOTAS = 3;

        String[] nombres = new String[CANT_ESTUDIANTES];
        int[][] notas = new int[CANT_ESTUDIANTES][CANT_NOTAS];
        double[] promedios = new double[CANT_ESTUDIANTES];

        System.out.println("=== SISTEMA DE CALIFICACIONES ===\n");

        for (int i = 0; i < CANT_ESTUDIANTES; i++) {

            System.out.println("Estudiante " + (i + 1));

            nombres[i] = leerNombre(sc, "Nombre: ");

            for (int j = 0; j < CANT_NOTAS; j++) {
                notas[i][j] = leerEnteroRango(sc,
                        "Nota " + (j + 1) + ": ",
                        0, 100);
            }

            System.out.println();
        }

        calcularPromedios(notas, promedios);
        mostrarResultados(nombres, notas, promedios);
        mostrarEstadisticas(promedios, notas);

        sc.close();
    }
}