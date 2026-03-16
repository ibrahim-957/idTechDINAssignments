package week.six.L12.smartHomeDevice;

public class SmartLight extends Appliance implements Schedulable{
    public SmartLight(String name, String brand) {
        super(name, brand);
    }

    @Override
    public String getStatus() {
        return getName() + " is ON";
    }

    @Override
    public void schedule(String time) {
        System.out.println(getName() + " scheduling " + time);
    }

    @Override
    public void cancelSchedule() {
        Schedulable.super.cancelSchedule();
    }
}
