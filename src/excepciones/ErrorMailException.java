package excepciones;



public class ErrorMailException extends RuntimeException {
	
    public ErrorMailException() {
    }

    public ErrorMailException(String message) {
        super(message);
    }

    public ErrorMailException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorMailException(Throwable cause) {
        super(cause);
    }
	
}
