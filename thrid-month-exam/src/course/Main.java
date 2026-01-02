package course;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        OnlineCourse course = new OnlineCourse("Java", "Engin", BigDecimal.valueOf(10), "Udemy", 45);
        course.display();

        if (course.isEligibleForCertificate(35)){
            System.out.println("Certificate is Eligible");
        }
        else{
            System.out.println("Certificate is not Eligible");
        }
    }
}
