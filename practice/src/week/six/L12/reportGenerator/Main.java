package week.six.L12.reportGenerator;

public class Main {
    public static void main(String[] args) {

        Reportable[] reports = {
                new PDFReport("Sales Report", "2024-01-01"),
                new CSVReport("User Data", "2024-01-02")
        };

        for (Reportable r : reports) {
            r.printHeader();        // default method — same for both
            r.generate();           // each class does it differently
            System.out.println("Format: " + r.getFormat());
            System.out.println("---");
        }

        Exportable e1 = (Exportable) reports[0];
        e1.export("/files/sales.pdf");

        Exportable e2 = (Exportable) reports[1];
        e2.export("/files/users.csv");
    }
}