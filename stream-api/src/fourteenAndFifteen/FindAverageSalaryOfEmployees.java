package fourteenAndFifteen;

import java.util.List;
import java.util.stream.Collectors;

public class FindAverageSalaryOfEmployees {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee("John", 1500),
                new Employee("Jane", 2500),
                new Employee("Jack", 2000));

        double averageSalary = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(averageSalary);
    }
}
