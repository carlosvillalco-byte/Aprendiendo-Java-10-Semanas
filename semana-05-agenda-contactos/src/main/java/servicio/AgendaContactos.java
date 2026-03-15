package servicio;

import modelo.Contacto;
import util.ManejadorJSON;

import java.util.ArrayList;

public class AgendaContactos {

    private ArrayList<Contacto> contactos;

    private final String ARCHIVO = "contactos.json";
    private final String BACKUP = "contactos.backup.json";

    public AgendaContactos() {

        contactos = ManejadorJSON.cargar(ARCHIVO);
    }

    public void guardar(){

        ManejadorJSON.guardarConBackup(contactos,ARCHIVO,BACKUP);
    }

    public void agregar(Contacto c){

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