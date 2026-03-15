import modelo.Contacto;
import servicio.AgendaContactos;
import exception.*;

import java.util.Scanner;

public class Main {

    static AgendaContactos agenda = new AgendaContactos();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        int op;

        do{

            mostrarMenu();
            op = Integer.parseInt(sc.nextLine());

            switch(op){

                case 1 -> agregarContacto();
                case 2 -> listarContactos();
                case 3 -> buscarContacto();
                case 4 -> eliminarContacto();
                case 5 -> mostrarEstadisticas();
                case 6 -> System.out.println("Fin del programa");

                default -> System.out.println("Opcion invalida");
            }

        }while(op!=6);
    }

    static void mostrarMenu(){

        System.out.println("\n=== AGENDA DE CONTACTOS ===");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Listar todos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Estadisticas");
        System.out.println("6. Salir");
        System.out.print("Opcion: ");
    }

    static void agregarContacto(){

        try{

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Telefono: ");
            String tel = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Direccion: ");
            String dir = sc.nextLine();

            agenda.agregar(new Contacto(id,nombre,tel,email,dir));

            System.out.println("Contacto agregado");

        }
        catch(ContactoExistenteException e){

            System.out.println("Error: "+e.getMessage());
        }
        catch(DatoInvalidoException e){

            System.out.println("Dato invalido en "+e.getCampo());
        }
    }

    static void listarContactos(){

        var lista = agenda.listarTodos();

        if(lista.isEmpty()){

            System.out.println("No hay contactos");
            return;
        }

        System.out.println("\nID    | Nombre          | Telefono   | Email");

        for(var c : lista)
            System.out.println(c);
    }

    static void buscarContacto(){

        System.out.print("Ingrese nombre o ID: ");
        String dato = sc.nextLine();

        Contacto c = agenda.buscarPorId(dato);

        if(c != null){

            System.out.println(c);
            return;
        }

        var lista = agenda.buscarPorNombre(dato);

        if(lista.isEmpty())
            System.out.println("No encontrado");
        else
            lista.forEach(System.out::println);
    }

    static void eliminarContacto(){

        System.out.print("ID a eliminar: ");
        String id = sc.nextLine();

        try{

            agenda.eliminar(id);
            System.out.println("Contacto eliminado");

        }
        catch(ContactoNoEncontradoException e){

            System.out.println(e.getMessage());
        }
    }

    static void mostrarEstadisticas(){

        int total = agenda.total();
        int conEmail = agenda.totalConEmail();

        System.out.println("\nTotal contactos: "+total);
        System.out.println("Con email: "+conEmail);
        System.out.println("Sin email: "+(total-conEmail));
    }
}