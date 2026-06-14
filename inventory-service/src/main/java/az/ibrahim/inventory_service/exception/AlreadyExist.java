package az.ibrahim.inventory_service.exception;

public class AlreadyExist extends RuntimeException {
    public AlreadyExist(String message) {
        super(message);
    }
}
