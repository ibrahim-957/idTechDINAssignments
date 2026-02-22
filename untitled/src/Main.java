public class Main {
    public static void main(String[] args) {
        String password = "123654";
        String hashed = new BCryptPasswordEncoder().encode(password);
        System.out.println(hashed);
    }
}