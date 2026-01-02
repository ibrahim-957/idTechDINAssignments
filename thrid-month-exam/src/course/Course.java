package course;

import java.math.BigDecimal;

public class Course {
    private String courseName;
    private String instructorName;
    private BigDecimal credit;

    public Course(String courseName, String instructorName, BigDecimal credit) {
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.credit = credit;
    }

    public void display() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor Name: " + instructorName);
        System.out.println("Credit: " + credit);
    }
}
