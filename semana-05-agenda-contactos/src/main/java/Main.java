import modelo.Contacto;
import servicio.AgendaContactos;
import exception.DatoInvalidoException;

import java.util.Scanner;

public class Main {

    static AgendaContactos agenda = new AgendaContactos();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int op;

        do {

            menu();
            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> buscar();
                case 4 -> eliminar();
                case 5 -> estadisticas();
                case 6 -> System.out.println("Saliendo...");

            }

        } while (op != 6);
    }

    static void menu() {

        System.out.println("\n=== AGENDA DE CONTACTOS ===");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Listar todos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Estadisticas");
        System.out.println("6. Salir");

        System.out.print("Opcion: ");
    }

    static void agregar() {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        String telefono;

        while (true) {

            try {

                System.out.print("Telefono: ");
                telefono = sc.nextLine();

                if (!telefono.matches("\\d{7,8}"))
                    throw new DatoInvalidoException("telefono", "debe tener entre 7 y 8 digitos");

                break;

            } catch (DatoInvalidoException e) {

                System.out.println("Error: Dato invalido en '" + e.getCampo() + "': " + e.getMessage());
            }
        }

        String email;

        while (true) {

            try {

                System.out.print("Email: ");
                email = sc.nextLine();

                if (!email.contains("@"))
                    throw new DatoInvalidoException("email", "debe contener @");

                break;

            } catch (DatoInvalidoException e) {

                System.out.println("Error: Dato invalido en '" + e.getCampo() + "': " + e.getMessage());
            }
        }

        System.out.print("Direccion (opcional): ");
        String direccion = sc.nextLine();

        String id = "C00" + (agenda.total() + 1);

        Contacto c = new Contacto(id, nombre, telefono, email, direccion);

        agenda.agregar(c);

        System.out.println("Contacto agregado con ID: " + id);
    }

    static void listar() {

        var lista = agenda.listarTodos();

        System.out.println("\n=== TODOS LOS CONTACTOS (" + lista.size() + ") ===");

        System.out.println("ID    | Nombre           | Telefono  | Email");
        System.out.println("-----------------------------------------------");

        for (var c : lista)
            System.out.println(c);
    }

    static void buscar() {

        System.out.print("Nombre a buscar: ");
        String texto = sc.nextLine();

        var lista = agenda.buscarPorNombre(texto);

        for (var c : lista)
            System.out.println(c);
    }

    static void eliminar() {

        System.out.print("ID a eliminar: ");
        String id = sc.nextLine();

        agenda.eliminar(id);

        System.out.println("Contacto eliminado");
    }

    static void estadisticas() {

        int total = agenda.total();
        int conEmail = agenda.totalConEmail();

        System.out.println("\n=== ESTADISTICAS ===");
        System.out.println("Total contactos: " + total);
        System.out.println("Con email: " + conEmail);
        System.out.println("Sin email: " + (total - conEmail));
    }
}