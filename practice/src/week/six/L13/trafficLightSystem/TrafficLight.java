package week.six.L13.trafficLightSystem;

public enum TrafficLight {
    RED(60),
    YELLOW(10),
    GREEN(45);

    private final int duration;
    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String message() {
        return switch (this) {
            case RED -> "Stop!";
            case YELLOW -> "Get ready...";
            case GREEN -> "Go!";
        };
    }

    public TrafficLight next() {
        return switch (this) {
            case GREEN -> YELLOW;
            case RED -> GREEN;
            default -> RED;
        };
    }
}
