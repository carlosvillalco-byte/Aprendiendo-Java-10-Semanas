package modelo;
import exception.DatoInvalidoException;

public class Contacto {

    private String id;
    private String nombre;
    private String telefono;

    public Contacto(String id, String nombre, String telefono) {
        setId(id);
        setNombre(nombre);
        setTelefono(telefono);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId(String id) {

        if(id == null || id.trim().isEmpty())
            throw new DatoInvalidoException("id","no puede estar vacio");

        this.id = id.trim();
    }

    public void setNombre(String nombre) {

        if(nombre == null || nombre.trim().isEmpty())
            throw new DatoInvalidoException("nombre","no puede estar vacio");

        this.nombre = nombre.trim();
    }

    public void setTelefono(String telefono) {

        if(telefono == null || telefono.trim().isEmpty())
            throw new DatoInvalidoException("telefono","no puede estar vacio");

        this.telefono = telefono.trim();
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " - Tel: " + telefono;
    }
}