package modelo;

public class Tarea {

    // Atributos privados (encapsulamiento)
    private int id;
    private String titulo;
    private String descripcion;
    private String estado; 

    // Constructor: el estado inicia siempre como PENDIENTE
    public Tarea(int id, String titulo, String descripcion) {
        this.id = id;
        setTitulo(titulo);           
        setDescripcion(descripcion);
        this.estado = "PENDIENTE";
    }

    // ===== GETTERS =====
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    // ===== SETTERS CON VALIDACIÓN =====

    // Valida que el título no sea nulo ni vacío
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        } else {
            System.out.println("Titulo invalido");
        }
    }

    // Valida que la descripción no sea nula ni vacía
    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
        } else {
            System.out.println("Descripcion invalida");
        }
    }

    // ===== MÉTODOS DE NEGOCIO =====

    // Marca la tarea como completada si aún no lo está
    public void completar() {
        if (estado.equals("COMPLETADA")) {
            System.out.println("La tarea ya esta completada");
        } else {
            estado = "COMPLETADA";
            System.out.println("Tarea marcada como completada");
        }
    }

    // Retorna true si la tarea está completada
    public boolean estaCompletada() {
        return estado.equals("COMPLETADA");
    }

    // Muestra la información formateada de la tarea
    public void mostrarInfo() {
        System.out.println("ID: " + id + " | " + estado);
        System.out.println("Titulo: " + titulo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println();
    }
}