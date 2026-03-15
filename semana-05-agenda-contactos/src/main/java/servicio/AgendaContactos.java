package servicio;

import modelo.Contacto;
import util.ManejadorJSON;
import exception.ContactoExistenteException;
import exception.ContactoNoEncontradoException;

import java.util.List;

public class AgendaContactos {

    private List<Contacto> contactos;

    public AgendaContactos() {
        contactos = ManejadorJSON.leerContactos();
    }

    public void agregarContacto(Contacto contacto) throws ContactoExistenteException {

        for (Contacto c : contactos) {
            if (c.getId().equals(contacto.getId())) {
                throw new ContactoExistenteException("El contacto ya existe");
            }
        }

        contactos.add(contacto);
        ManejadorJSON.guardarContactos(contactos);
    }

    public List<Contacto> listarContactos() {
        return contactos;
    }

    public Contacto buscarContacto(String id) throws ContactoNoEncontradoException {

        for (Contacto c : contactos) {
            if (c.getId().equals(id)) {
                return c;
            }
        }

        throw new ContactoNoEncontradoException("Contacto no encontrado");
    }

    public void eliminarContacto(String id) throws ContactoNoEncontradoException {

        Contacto contacto = buscarContacto(id);

        contactos.remove(contacto);

        ManejadorJSON.guardarContactos(contactos);
    }
}