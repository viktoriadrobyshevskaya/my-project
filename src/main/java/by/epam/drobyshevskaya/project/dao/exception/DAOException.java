package by.epam.drobyshevskaya.project.dao.exception;

import java.io.Serial;

public class DAOException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception cause) {
        super(cause);
    }

    public DAOException(String message, Exception cause) {
        super(message, cause);
    }
}
