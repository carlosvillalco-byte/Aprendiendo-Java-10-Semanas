package servicio;

import modelo.Contacto;
import util.ManejadorJSON;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class AgendaContactos {

    private ArrayList<Contacto> contactos;

    private final String ARCHIVO = "data/contactos.json";
    private final String BACKUP = "data/contactos.backup.json";

    public AgendaContactos(){
        contactos = ManejadorJSON.cargar(ARCHIVO);
    }

    public void guardar(){
        ManejadorJSON.guardarConBackup(contactos, ARCHIVO, BACKUP);
    }

    public void agregar(Contacto c){

        boolean existe = contactos.stream()
                .anyMatch(x -> x.getNombre().equalsIgnoreCase(c.getNombre()));

        if(existe){
            throw new RuntimeException("Contacto duplicado");
        }

        contactos.add(c);
        guardar();
    }
    public Contacto buscarPorId(String id){

        for(Contacto c : contactos){
            if(c.getId().equalsIgnoreCase(id))
                return c;
        }

        return null;
    }
    public ArrayList<Contacto> buscarPorNombre(String texto){

        ArrayList<Contacto> resultado = new ArrayList<>();

        for(Contacto c : contactos){
            if(c.getNombre().toLowerCase().contains(texto.toLowerCase()))
                resultado.add(c);
        }

        return resultado;
    }

    // ✅ T1 y T2 → Optional
    public Optional<Contacto> buscarPorNombreExacto(String nombre) {
        return contactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    // ✅ T3 → filter
    public ArrayList<Contacto> filtrarPorCategoria(String categoria) {
        return contactos.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // ✅ T4 → map
    public ArrayList<String> obtenerNombres() {
        return contactos.stream()
                .map(Contacto::getNombre)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // ✅ T5 → count
    public long contarPorCategoria(String categoria) {
        return contactos.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase(categoria))
                .count();
    }

    public ArrayList<Contacto> listarTodos(){
        return contactos;
    }

    public void eliminar(String id){

        Contacto c = buscarPorId(id);

        if(c != null){
            contactos.remove(c);
            guardar();
        }
    }

    public int total(){
        return contactos.size();
    }

    public int totalConEmail(){

        int cont = 0;

        for(Contacto c : contactos){
            if(c.getEmail()!=null && !c.getEmail().isEmpty())
                cont++;
        }

        return cont;
    }
}