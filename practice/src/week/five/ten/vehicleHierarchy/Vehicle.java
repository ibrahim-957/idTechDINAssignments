package week.five.ten.vehicleHierarchy;

public class Vehicle {
    private String brand;
    private double speed;
    protected String fuelType;

    public Vehicle(String brand, double speed, String fuelType) {
        this.brand = brand;
        setSpeed(speed);
        this.fuelType = fuelType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed >= 0) {
            this.speed = speed;
        } else {
            System.out.println("Speed cannot be negative");
            this.speed = 0;
        }
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", speed=" + speed +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
