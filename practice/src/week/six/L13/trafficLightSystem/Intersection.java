package week.six.L13.trafficLightSystem;

public final class Intersection {
    private final String name;
    private final TrafficLight initialState;

    public Intersection(String name, TrafficLight initialState) {
        this.name = name;
        this.initialState = initialState;
    }

    public String getName() {
        return name;
    }
    public TrafficLight getInitialState() {
        return initialState;
    }
}
