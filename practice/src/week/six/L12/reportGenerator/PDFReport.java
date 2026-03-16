package week.six.L12.reportGenerator;

public class PDFReport extends Report implements Exportable{
    public PDFReport(String title, String date) {
        super(title, date);
    }

    @Override
    public void export(String filePath) {
        System.out.println("Exporting PDF to " + filePath);
    }

    @Override
    public String getSummary() {
        return "PDF summary of " + getTitle();
    }

    @Override
    public void generate() {
        System.out.println("Generating PDF: " + getTitle());
    }

    @Override
    public String getFormat() {
        return "PDF";
    }
}
