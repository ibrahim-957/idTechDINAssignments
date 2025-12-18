package Ex2;

import java.math.BigDecimal;

public class Employee extends Person {
    private BigDecimal salary;

    public Employee(String name, int age, BigDecimal salary) {
        super(name, age);
        this.salary = salary;
    }

    public void display(){
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Salary: " + this.salary);
    }
}
