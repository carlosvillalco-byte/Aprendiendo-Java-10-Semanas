import modelo.Contacto;
import servicio.AgendaContactos;

import java.util.Scanner;

public class Main {

    static AgendaContactos agenda = new AgendaContactos();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int op;

        do{
            menu();
            op = Integer.parseInt(sc.nextLine());

            switch(op){
                case 1 -> agregar();
                case 2 -> buscarPorNombre();
                case 3 -> listar();
                case 4 -> listarOrdenados();
                case 5 -> filtrarCategoria();
                case 6 -> verNombres();
                case 7 -> {
                    agenda.guardar();
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opcion invalida");
            }

        }while(op != 7);
    }

    static void menu(){
        System.out.println("\n=== AGENDA DE CONTACTOS ===");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar por nombre");
        System.out.println("3. Listar todos");
        System.out.println("4. Listar ordenados");
        System.out.println("5. Filtrar por categoria");
        System.out.println("6. Ver nombres");
        System.out.println("7. Guardar y salir");
        System.out.print("Opcion: ");
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

            System.out.print("Categoria: ");
            String categoria = sc.nextLine();

            String id = "C00" + (agenda.total()+1);

            Contacto c = new Contacto(id, nombre, telefono, email, direccion, categoria);

            agenda.agregar(c);

            System.out.println("Contacto agregado");

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    static void buscarPorNombre(){
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();

        var resultado = agenda.buscarPorNombreExacto(nombre);

        if(resultado.isPresent()){
            var c = resultado.get();
            System.out.println("Contacto encontrado: " 
                + c.getNombre() + " - " 
                + c.getTelefono() + " (" 
                + c.getCategoria() + ")");
        }else{
            System.out.println("No se encontro ningun contacto con ese nombre.");
        }
    }

    static void listar(){
        var lista = agenda.listarTodos();

        for(var c : lista){
            System.out.println(c);
        }
    }
    static void listarOrdenados(){
        var lista = agenda.listarTodos();

        lista.sort((a,b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));

        for(var c : lista){
            System.out.println(c);
        }
    }
    static void filtrarCategoria(){
        System.out.print("Categoria: ");
        String cat = sc.nextLine();

        var lista = agenda.filtrarPorCategoria(cat);

        System.out.println("Contactos en " + cat + " (" + lista.size() + "):");

        for(var c : lista){
            System.out.println(c.getNombre() + " - " + c.getTelefono());
        }
    }
    static void verNombres(){
        var nombres = agenda.obtenerNombres();

        for(String n : nombres){
            System.out.println(n);
        }
    }
}