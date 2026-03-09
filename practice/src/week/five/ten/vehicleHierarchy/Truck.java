package week.five.ten.vehicleHierarchy;

public class Truck extends Vehicle {
    private double payloadKg;

    public Truck(String brand, double speed, String fuelType, double payloadKg) {
        super(brand, speed, fuelType);
        this.payloadKg = payloadKg;
    }
    public double getPayloadKg() {
        return payloadKg;
    }

    public void setPayloadKg(double payloadKg) {
        this.payloadKg = payloadKg;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "brand='" + getBrand() + '\'' +
                ", speed=" + getSpeed() +
                ", fuelType='" + fuelType + '\'' +
                ", payloadKg=" + payloadKg +
                '}';
    }
}
