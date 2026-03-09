package week.five.ten.vehicleHierarchy;

public class ElectricVehicle extends Vehicle {
    private double batteryCapacity;

    public ElectricVehicle(String brand, double speed, String fuelType, double batteryCapacity) {
        super(brand, speed, fuelType);
        this.batteryCapacity = batteryCapacity;
    }
    public double getBatteryCapacity() {
        return batteryCapacity;
    }
    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return "ElectricVehicle{" +
                "brand='" + getBrand() + '\'' +
                ", speed=" + getSpeed() +
                ", fuelType='" + fuelType + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                '}';
    }
}
