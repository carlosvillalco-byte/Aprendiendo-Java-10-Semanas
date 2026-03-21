import modelo.Contacto;
import servicio.AgendaContactos;
import exception.DatoInvalidoException;

import java.util.Scanner;

public class Main {

    static AgendaContactos agenda = new AgendaContactos();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int op = 0;
        do{
            menu();
            try{
                op = Integer.parseInt(sc.nextLine());
            } catch(Exception e){
                op = 0;
            }

            switch(op){
                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> buscar();
                case 4 -> editar();
                case 5 -> eliminar();
                case 6 -> estadisticas();
                case 7 -> filtrarCategoria(); 
                case 8 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }

        }while(op != 8);
    }

    static void menu(){
        System.out.println("\n=== AGENDA DE CONTACTOS ===");
        System.out.println("1. Agregar Contacto");
        System.out.println("2. Listar Todos");
        System.out.println("3. Buscar Contacto");
        System.out.println("4. Editar Contacto");
        System.out.println("5. Eliminar Contacto");
        System.out.println("6. Estadísticas");
        System.out.println("7. Filtrar por categoría"); 
        System.out.println("8. Salir");
        System.out.print("Opción: ");
    }

    static void agregar(){
        try{
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            // Teléfono
            String telefono;
            while(true){
                System.out.print("Telefono: ");
                telefono = sc.nextLine();
                try{
                    new Contacto("TMP","X",telefono,"x@x.com","dir","cat");
                    break;
                }catch(DatoInvalidoException e){
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // Email
            String email;
            while(true){
                System.out.print("Email: ");
                email = sc.nextLine();
                try{
                    new Contacto("TMP","X","1234567",email,"dir","cat");
                    break;
                }catch(DatoInvalidoException e){
                    System.out.println("Error: " + e.getMessage());
                }
            }

            System.out.print("Direccion: ");
            String direccion = sc.nextLine();
            System.out.print("Categoria: ");
            String categoria = sc.nextLine();

            String id = "C00"+(agenda.total()+1);

            Contacto c = new Contacto(id,nombre,telefono,email,direccion,categoria);

            agenda.agregar(c);

            System.out.println("Contacto agregado");

        }catch(DatoInvalidoException e){
            System.out.println("Error en " + e.getCampo() + ": " + e.getMessage());
        }
    }

    static void listar(){
        var lista = agenda.listarTodos();

        System.out.println("\nID | Nombre | Telefono | Email | Categoria");
        System.out.println("------------------------------------------------");

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

        if(lista.isEmpty())
            System.out.println("No encontrado");

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

        while(true){
            System.out.print("Nuevo telefono: ");
            try{
                c.setTelefono(sc.nextLine());
                break;
            }catch(DatoInvalidoException e){
                System.out.println(e.getMessage());
            }
        }

        while(true){
            System.out.print("Nuevo email: ");
            try{
                c.setEmail(sc.nextLine());
                break;
            }catch(DatoInvalidoException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Nueva categoria: ");
        c.setCategoria(sc.nextLine());

        agenda.guardar();

        System.out.println("Actualizado");
    }

    static void eliminar(){
        System.out.print("ID a eliminar: ");
        String id = sc.nextLine();

        System.out.print("Confirmar (s/n): ");
        if(sc.nextLine().equalsIgnoreCase("s")){
            agenda.eliminar(id);
            System.out.println("Eliminado");
        }
    }

    static void estadisticas(){
        int total = agenda.total();
        int conEmail = agenda.totalConEmail();

        System.out.println("\nTotal: "+total);
        System.out.println("Con email: "+conEmail);
        System.out.println("Sin email: "+(total-conEmail));
        System.out.print("Categoria para contar: ");
        String cat = sc.nextLine();

        long totalCat = agenda.contarPorCategoria(cat);

        System.out.println("Total en categoria '"+cat+"': "+totalCat);
    }

    static void filtrarCategoria(){
        System.out.print("Categoria: ");
        String cat = sc.nextLine();

        var lista = agenda.filtrarPorCategoria(cat);

        if(lista.isEmpty()){
            System.out.println("No hay contactos");
            return;
        }

        lista.forEach(System.out::println);
    }
}