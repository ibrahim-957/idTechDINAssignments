package studentGradingSystem;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[2];

        students[0] = new UndergraduateStudent("Jon", 80);
        students[1] = new GraduateStudent("Doe", 80);

        for (Student student : students) {
            System.out.println(
                    student.name + " final grade: " + student.getFinalGrade()
            );
        }
    }
}
