package hello.springmvc.basic.domain.team.exception;

public abstract class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException(String message) {
        super(message);
    }

    public CustomNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}