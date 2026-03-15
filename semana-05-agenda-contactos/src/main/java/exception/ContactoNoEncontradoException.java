package exception;

public class ContactoNoEncontradoException extends Exception {

    public ContactoNoEncontradoException(String id) {
        super("No se encontró contacto con ID '" + id + "'");
    }
}