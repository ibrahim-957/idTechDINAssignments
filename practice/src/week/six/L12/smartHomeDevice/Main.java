package week.six.L12.smartHomeDevice;

public class Main {
    public static void main(String[] args) {

        Switchable s = () -> System.out.println("Device toggled!");
        s.toggle();

        SmartLight light = new SmartLight("Living Room Light", "Philips");
        SmartThermostat thermostat = new SmartThermostat("Hall Thermostat", "Nest", 22.5);

        light.schedule("07:00");
        thermostat.schedule("08:30");

        light.cancelSchedule();
        thermostat.cancelSchedule();

        System.out.println(light.getStatus());
        System.out.println(thermostat.getStatus());

        if (light instanceof SmartDevice) {
            System.out.println(light.getName() + " is a smart device");
        }
        if (thermostat instanceof SmartDevice) {
            System.out.println(thermostat.getName() + " is a smart device");
        }
    }

}
