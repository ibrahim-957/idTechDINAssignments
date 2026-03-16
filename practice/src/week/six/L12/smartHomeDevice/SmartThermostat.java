package week.six.L12.smartHomeDevice;

public class SmartThermostat extends Appliance implements Schedulable{
    private double temperature;

    public SmartThermostat(String name, String brand, double temperature) {
        super(name, brand);
        this.temperature = temperature;
    }

    @Override
    String getStatus() {
        return getName() + " set to " + temperature +"C";
    }

    @Override
    public void schedule(String time) {
        System.out.println(getName() + " scheduled for " + time);
    }
}
