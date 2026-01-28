package fourteenAndFifteen;

import java.util.Comparator;
import java.util.List;

public class SortEmployeesBySalary {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee("John", 1500),
                new Employee("Jane", 2500),
                new Employee("Jack", 2000));

        List<String> sorted = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .map(name -> name.getName())
                .toList();

        System.out.println(sorted);
    }
}
