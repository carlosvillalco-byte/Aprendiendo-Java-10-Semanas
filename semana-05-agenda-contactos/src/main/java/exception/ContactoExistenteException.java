package exception;

public class ContactoExistenteException extends Exception {

    public ContactoExistenteException(String id) {
        super("El contacto con ID '" + id + "' ya existe.");
    }
}