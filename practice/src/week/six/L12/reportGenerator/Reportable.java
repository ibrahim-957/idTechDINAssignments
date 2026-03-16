package week.six.L12.reportGenerator;

public interface Reportable {
    void generate();
    String getFormat();
    default void printHeader(){
        System.out.println("=== Report ===");
    }
}
