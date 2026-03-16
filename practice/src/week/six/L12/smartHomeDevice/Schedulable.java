package week.six.L12.smartHomeDevice;

public interface Schedulable {
    void schedule(String time);
    default void cancelSchedule() {
        System.out.println("Cancelled");
    }
}
