package course;

public class OnlineCourse extends Course {
    private String platformName;
    private double duration;

    public OnlineCourse(String courseName, String instructorName, int credit, String platformName, double duration) {
        super(courseName, instructorName, credit);
        this.platformName = platformName;
        this.duration = duration;
    }

    public String getPlatformName() {
        return platformName;
    }
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Platform Name: " + platformName);
        System.out.println("Duration: " + duration);
    }

    Boolean isEligibleForCertificate(double requirement){
        return duration >= requirement;
    }
}
