package excepciones;

public class MedicoTurnoException extends Exception {
	
    public MedicoTurnoException() {
    }

    public MedicoTurnoException(String message) {
        super(message);
    }

    public MedicoTurnoException(String message, Throwable cause) {
        super(message, cause);
    }

    public MedicoTurnoException(Throwable cause) {
        super(cause);
    }
	
}
