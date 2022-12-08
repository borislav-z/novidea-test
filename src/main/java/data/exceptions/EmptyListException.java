package data.exceptions;

public class EmptyListException extends RuntimeException {

    private static final String MESSAGE = "List is empty";

    public EmptyListException() {
        super(MESSAGE);
    }
}
