package week.five.ten.employeHierarchy;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[3];

        employees[0] = new Employee("Alice", 1, 3000);
        employees[1] = new Manager("Bob", 2, 5000, 1500);
        employees[2] = new Intern("Charlie", 3, 2000);

        for (Employee e : employees) {
            System.out.println(
                    e.getName() + " salary: " + e.getSalary()
            );
        }
    }
}
