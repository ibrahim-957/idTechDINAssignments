package week.five.ten.employeHierarchy;

public class Intern extends Employee {

    public Intern(String name, int id, double baseSalary) {
        super(name, id, baseSalary);
    }

    @Override
    public double getSalary() {
        return getBaseSalary() * 0.5;
    }
}
