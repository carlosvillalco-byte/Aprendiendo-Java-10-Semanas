import modelo.Contacto;
import servicio.AgendaContactos;
import exception.DatoInvalidoException;

import java.util.Scanner;

public class Main {

    static AgendaContactos agenda = new AgendaContactos();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int op = 0;

        do {

            menu();

            try{
                op = Integer.parseInt(sc.nextLine());
            }
            catch(Exception e){
                op = 0;
            }

            switch(op){

                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> buscar();
                case 4 -> editar();
                case 5 -> eliminar();
                case 6 -> estadisticas();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }

        }while(op != 7);
    }

    static void menu(){

        System.out.println("\n=== AGENDA CONTACTOS ===");
        System.out.println("1. Agregar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar");
        System.out.println("4. Editar");
        System.out.println("5. Eliminar");
        System.out.println("6. Estadísticas");
        System.out.println("7. Salir");

        System.out.print("Opción: ");
    }

    static void agregar(){

        try{

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Telefono: ");
            String telefono = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Direccion: ");
            String direccion = sc.nextLine();

            String id = "C00"+(agenda.total()+1);

            Contacto c = new Contacto(id,nombre,telefono,email,direccion);

            agenda.agregar(c);

            System.out.println("Contacto agregado");

        }catch(DatoInvalidoException e){

            System.out.println("Error en "+e.getCampo()+": "+e.getMessage());
        }
    }

    static void listar(){

        var lista = agenda.listarTodos();

        System.out.println("\nID | Nombre | Telefono | Email");
        System.out.println("--------------------------------");

        for(var c : lista)
            System.out.println(c);
    }

    static void buscar(){

        System.out.print("Nombre o ID: ");
        String texto = sc.nextLine();

        Contacto c = agenda.buscarPorId(texto);

        if(c != null){
            System.out.println(c);
            return;
        }

        var lista = agenda.buscarPorNombre(texto);

        for(var x : lista)
            System.out.println(x);
    }

    static void editar(){

        System.out.print("ID contacto: ");
        String id = sc.nextLine();

        Contacto c = agenda.buscarPorId(id);

        if(c == null){

            System.out.println("No encontrado");
            return;
        }

        try{

            System.out.print("Nuevo telefono: ");
            c.setTelefono(sc.nextLine());

            System.out.print("Nuevo email: ");
            c.setEmail(sc.nextLine());

            agenda.guardar();

            System.out.println("Contacto actualizado");

        }catch(DatoInvalidoException e){

            System.out.println("Error "+e.getCampo());
        }
    }

    static void eliminar(){

        System.out.print("ID a eliminar: ");
        String id = sc.nextLine();

        System.out.print("Confirmar (s/n): ");
        String conf = sc.nextLine();

        if(conf.equalsIgnoreCase("s")){

            agenda.eliminar(id);
            System.out.println("Eliminado");
        }
    }

    static void estadisticas(){

        int total = agenda.total();
        int conEmail = agenda.totalConEmail();

        System.out.println("\nTotal contactos: "+total);
        System.out.println("Con email: "+conEmail);
        System.out.println("Sin email: "+(total-conEmail));
    }
}