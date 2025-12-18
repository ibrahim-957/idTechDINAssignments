package Ex5;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Manager("Alice", 5000),
                new Developer("Bob", 4500),
                new Developer("Charlie", 4800)
        };

        for (Employee emp : employees) {
            System.out.println(
                    emp.name + " salary: " + emp.calculateSalary()
            );
        }

    }
}
