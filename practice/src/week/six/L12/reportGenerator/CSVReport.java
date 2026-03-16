package week.six.L12.reportGenerator;

public class CSVReport extends Report implements Exportable{
    public CSVReport(String title, String date) {
        super(title, date);
    }

    @Override
    public void export(String filePath) {
        System.out.println("Exporting CSV to " + filePath);
    }

    @Override
    public String getSummary() {
        return "CSV summary of " + getTitle();
    }

    @Override
    public void generate() {
        System.out.println("Generating CSV: " + getTitle());
    }

    @Override
    public String getFormat() {
        return "CSV";
    }
}
