package test05;

public class NotExistIdException
extends Exception {
    public NotExistIdException() {}
    public NotExistIdException(String message) {
        super(message);
    }
}
