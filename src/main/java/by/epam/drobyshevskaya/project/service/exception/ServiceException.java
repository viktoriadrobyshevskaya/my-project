package by.epam.drobyshevskaya.project.service.exception;

import java.io.Serial;

public class ServiceException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
