public class Main {
    public static void main(String[] args) {
        Address address = new Address("Dilare Aliyeva", "Baku", 1000);
        Employee employee = new Employee("Ibrahim", 1100, address);

        employee.showEmployeeDetails();
    }
}
