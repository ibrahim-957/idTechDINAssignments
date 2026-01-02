package course;

public class Main {
    public static void main(String[] args) {
        OnlineCourse course = new OnlineCourse("Java", "Engin", 8, "Udemy", 45);
        course.display();

        if (course.isEligibleForCertificate(35)){
            System.out.println("Certificate is Eligible");
        }
        else{
            System.out.println("Certificate is not Eligible");
        }
    }
}
