package servicio;

import modelo.Contacto;
import util.ManejadorJSON;
import java.util.List;

public class AgendaContactos {

    private List<Contacto> contactos;

    public AgendaContactos() {
        contactos = ManejadorJSON.leerContactos();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        ManejadorJSON.guardarContactos(contactos);
    }

    public List<Contacto> listarContactos() {
        return contactos;
    }

    public Contacto buscarContacto(String id) {

        for (Contacto c : contactos) {
            if (c.getId().equals(id)) {
                return c;
            }
        }

        return null;
    }

    public void eliminarContacto(String id) {

        Contacto contacto = buscarContacto(id);

        if (contacto != null) {
            contactos.remove(contacto);
            ManejadorJSON.guardarContactos(contactos);
        }
    }
}