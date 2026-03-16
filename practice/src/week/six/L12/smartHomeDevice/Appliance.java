package week.six.L12.smartHomeDevice;

public abstract class Appliance implements SmartDevice{
    private String name;
    private String brand;

    public Appliance(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }
    public String getBrand() {
        return brand;
    }

    abstract String getStatus();
}
