package week.four.nine;

public class Student {
    private String name;
    private String studentId;
    private double[] grades;
    private int gradeCount;

    private static int totalStudents = 0;

    public Student (String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new double[10];
        this.gradeCount = 0;
        totalStudents++;
    }

    public void addGrade(double grade) {
        if (gradeCount < 10){
            grades[gradeCount] = grade;
            gradeCount++;
        }else {
            System.out.println("Cannot add more than 10 grades for " + name);
        }
    }

    public double getAverage() {
        if (gradeCount == 0) return 0;

        double sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        return sum / gradeCount;
    }

    public double getHighest() {
        if (gradeCount == 0) return 0;
        double max = 0;
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    public double getLowest() {
        if (gradeCount == 0) return 0;
        double min = 0;
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i] < min) {
                min = grades[i];
            }
        }
        return min;
    }

    public String getLetterGrade(){
        double average = getAverage();
        if (average > 90) return "A";
        else if (average > 80) return "B";
        else if (average > 70) return "C";
        else if (average > 60) return "D";
        else return "F";
    }

    public void printReport() {
        System.out.println("----- Student Report -----");
        System.out.println("Name: " + name);
        System.out.println("ID: " + studentId);
        System.out.println("Average: " + getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
        System.out.println("Letter Grade: " + getLetterGrade());
        System.out.println();
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ibrahim", "S001");
        s1.addGrade(95);
        s1.addGrade(88);
        s1.addGrade(92);

        Student s2 = new Student("Ali", "S002");
        s2.addGrade(70);
        s2.addGrade(65);
        s2.addGrade(78);
        s2.addGrade(80);

        s1.printReport();
        s2.printReport();

        System.out.println("Total Students: " + Student.getTotalStudents());
    }
}
