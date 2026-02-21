import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[5];
        int[][] notas = new int[5][3];
        double[] promedios = new double[5];

        System.out.println("=== SISTEMA DE CALIFICACIONES ===\n");

        // INGRESO DE DATOS
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese datos del estudiante " + (i + 1) + ":");

            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();

            for (int j = 0; j < 3; j++) {
                int nota;
                do {
                    System.out.print("Nota " + (j + 1) + ": ");
                    nota = sc.nextInt();
                } while (nota < 0 || nota > 100);
                notas[i][j] = nota;
            }
            sc.nextLine(); // limpiar buffer
            System.out.println();
        }

        // CALCULAR PROMEDIOS
        for (int i = 0; i < 5; i++) {
            int suma = 0;
            for (int j = 0; j < 3; j++) {
                suma += notas[i][j];
            }
            promedios[i] = suma / 3.0;
        }

        // RESULTADOS
        System.out.println("========== RESULTADOS ==========");
        System.out.printf("%-15s %4s %4s %4s %6s %10s%n",
                "Nombre", "N1", "N2", "N3", "Prom", "Estado");
        System.out.println("---------------------------------------------");

        int aprobados = 0;
        int reprobados = 0;

        for (int i = 0; i < 5; i++) {
            String estado;
            if (promedios[i] >= 51) {
                estado = "APROBADO";
                aprobados++;
            } else {
                estado = "REPROBADO";
                reprobados++;
            }

            System.out.printf("%-15s %4d %4d %4d %6.1f %10s%n",
                    nombres[i],
                    notas[i][0],
                    notas[i][1],
                    notas[i][2],
                    promedios[i],
                    estado);
        }

        // ESTADISTICAS
        double sumaGeneral = 0;
        for (int i = 0; i < 5; i++) {
            sumaGeneral += promedios[i];
        }
        double promedioGeneral = sumaGeneral / 5;

        int max = notas[0][0];
        int min = notas[0][0];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (notas[i][j] > max) max = notas[i][j];
                if (notas[i][j] < min) min = notas[i][j];
            }
        }

        double porcAprob = aprobados * 100.0 / 5;
        double porcReprob = reprobados * 100.0 / 5;

        System.out.println("\n========== ESTADISTICAS ==========");
        System.out.printf("Promedio general del curso: %.2f%n", promedioGeneral);
        System.out.println("Nota mas alta: " + max);
        System.out.println("Nota mas baja: " + min);
        System.out.printf("Aprobados: %d de 5 (%.1f%%)%n", aprobados, porcAprob);
        System.out.printf("Reprobados: %d de 5 (%.1f%%)%n", reprobados, porcReprob);

        sc.close();
    }
}