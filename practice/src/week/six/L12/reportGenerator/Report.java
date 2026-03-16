package week.six.L12.reportGenerator;

public abstract class Report implements Reportable{
    private String title;
    private String date;

    public Report(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public abstract String getSummary();
}
