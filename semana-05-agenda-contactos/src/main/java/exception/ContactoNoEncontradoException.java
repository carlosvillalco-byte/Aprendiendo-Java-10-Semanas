package exception;

public class ContactoNoEncontradoException extends Exception {

    public ContactoNoEncontradoException(String id) {
        super("No se encontro contacto con ID '" + id + "'");
    }
}