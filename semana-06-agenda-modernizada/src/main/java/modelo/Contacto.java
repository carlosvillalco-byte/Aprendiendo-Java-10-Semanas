package modelo;

import exception.DatoInvalidoException;

public class Contacto {

    private String id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private String categoria; 

    public Contacto(String id, String nombre, String telefono, String email, String direccion, String categoria) {

        setId(id);
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        this.categoria = categoria; 
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getDireccion() { return direccion; }
    public String getCategoria() { return categoria; } 

    public void setId(String id) {

        if(id == null || id.trim().isEmpty())
            throw new DatoInvalidoException("id","no puede estar vacío");

        this.id = id;
    }

    public void setNombre(String nombre) {

        if(nombre == null || nombre.trim().isEmpty())
            throw new DatoInvalidoException("nombre","no puede estar vacío");

        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {

        if(telefono == null || telefono.trim().isEmpty())
            throw new DatoInvalidoException("telefono","no puede estar vacío");

        if(!telefono.matches("\\d+"))
            throw new DatoInvalidoException("telefono","solo números");

        if(telefono.length() < 7 || telefono.length() > 8)
            throw new DatoInvalidoException("telefono","debe tener 7 u 8 dígitos");

        this.telefono = telefono;
    }

    public void setEmail(String email) {

        if(email != null && !email.trim().isEmpty()){

            if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
                throw new DatoInvalidoException("email","formato de email inválido");
        }

        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString(){

        return String.format("%-5s | %-15s | %-9s | %s | %s",
                id,nombre,telefono,email,categoria);
    }
}