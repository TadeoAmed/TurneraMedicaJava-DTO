package excepciones;

public class IdRepetidoException extends Exception {

    public IdRepetidoException() {
    }

    public IdRepetidoException(String message) {
        super(message);
    }

    public IdRepetidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdRepetidoException(Throwable cause) {
        super(cause);
    }
	
}
