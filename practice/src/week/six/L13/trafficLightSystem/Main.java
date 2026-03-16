package week.six.L13.trafficLightSystem;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var intersection = new Intersection("Main St & 1st Ave", TrafficLight.RED);

        System.out.println("Intersection: " + intersection.getName());
        System.out.println("Initial state: " + intersection.getInitialState());
        System.out.println();

        System.out.println("=== All Traffic Light States ===");

        for (TrafficLight light : TrafficLight.values()) {
            System.out.printf("%-8s | %3ds | %s%n",
                    light, light.getDuration(), light.message());
        }
        System.out.println();

        var durations = new ArrayList<Integer>();
        for (TrafficLight light : TrafficLight.values()) {
            durations.add(light.getDuration());
        }

        int totalCycleTime = 0;
        for (Integer d : durations) {
            totalCycleTime += d;
        }

        System.out.println("Total cycle time: " + totalCycleTime + "s");
        System.out.println();

        System.out.println("=== Simulating One Full Cycle ===");
        var current = intersection.getInitialState();
        for (int i = 0; i < 6; i++) {
            System.out.println("Current: " + current + " → " + current.message());
            current = current.next();
        }
    }
}
