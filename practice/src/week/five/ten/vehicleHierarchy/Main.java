package week.five.ten.vehicleHierarchy;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Toyota", 120, "Petrol");
        Vehicle v2 = new ElectricVehicle("Tesla", 150, "Electric", 75);
        Vehicle v3 = new Truck("Volvo", 90, "Diesel", 12000);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }
}
