package modelo;

public class Contacto {

    private String id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    public Contacto(String id, String nombre, String telefono, String email, String direccion) {

        setId(id);
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getDireccion() { return direccion; }

    public void setId(String id) {

        if(id == null || id.trim().isEmpty())
            throw new IllegalArgumentException("id no puede estar vacío");

        this.id = id;
    }

    public void setNombre(String nombre) {

        if(nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("nombre no puede estar vacío");

        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {

        if(telefono == null || telefono.trim().isEmpty())
            throw new IllegalArgumentException("telefono no puede estar vacío");

        if(!telefono.matches("\\d+"))
            throw new IllegalArgumentException("telefono solo debe contener números");

        if(telefono.length() < 7 || telefono.length() > 8)
            throw new IllegalArgumentException("telefono debe tener 7 u 8 dígitos");

        this.telefono = telefono;
    }

    public void setEmail(String email) {

        if(email != null && !email.trim().isEmpty()){

            if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
                throw new IllegalArgumentException("formato de email inválido");
        }

        this.email = email;
    }

    public void setDireccion(String direccion) {

        this.direccion = direccion;
    }

    @Override
    public String toString(){

        return String.format("%-5s | %-15s | %-9s | %s",
                id,nombre,telefono,email);
    }
}