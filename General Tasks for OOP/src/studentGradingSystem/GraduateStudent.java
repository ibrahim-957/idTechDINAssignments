package studentGradingSystem;

public class GraduateStudent extends Student {
    private static final double bonus = 5;

    public GraduateStudent(String name, double grade) {
        super(name, grade);
    }

    @Override
    public double getFinalGrade() {
        return grade + bonus;
    }
}
