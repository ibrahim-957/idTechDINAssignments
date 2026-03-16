package week.seven.l15.registrationValidator;

public class AgeOutOfRangeException extends RuntimeException {
    public AgeOutOfRangeException(String message) {
        super(message);
    }
}
