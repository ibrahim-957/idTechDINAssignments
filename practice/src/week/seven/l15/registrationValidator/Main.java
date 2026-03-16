package week.seven.l15.registrationValidator;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Multiple Catch ===");
        try {
            validateEmail("not an email");
        } catch (InvalidEmailException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        try {
            validateAge(200);
        } catch (AgeOutOfRangeException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\n=== Union Catch ===");
        try {
            validateEmail("also invalid");
        } catch (InvalidEmailException | RuntimeException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        System.out.println("\n=== Valid Inputs ===");
        try {
            validateEmail("user@gmail.com");
            validateAge(25);
        } catch (InvalidEmailException e) {
            System.out.println("Should not reach here");
        }

        System.out.println("\n=== Swallowed Exception (bad) ===");
        try {
            validateEmail("bad email");
        } catch (InvalidEmailException e) {
        }
        System.out.println("Program continues after swallowed exception...");
    }


    public static void validateEmail(String email) throws InvalidEmailException {
        if (!email.contains("@")) {
            throw new InvalidEmailException("Invalid email");
        }
        System.out.println("Email is valid");
    }

    public static void validateAge(int age){
        if (age < 0 || age > 150) {
            throw new AgeOutOfRangeException("Invalid age");
        }
        System.out.println("Age is valid");
    }
}
