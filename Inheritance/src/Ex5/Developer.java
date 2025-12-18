package Ex5;

public class Developer extends Employee {

    public Developer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary + 1500;
    }
}
