package course;

public class Course {
    private String courseName;
    private String instructorName;
    private int credit;

    public Course() {
    }

    public Course(String courseName, String instructorName, int credit) {
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.credit = credit;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void display(){
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor Name: " + instructorName);
        System.out.println("Credit: " + credit);
    }
}
