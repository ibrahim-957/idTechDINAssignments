package enumInSwitch;

public class Main {
    public static void main(String[] args) {
        TrafficLight light = TrafficLight.GREEN;
        switch (light) {
            case GREEN:
                System.out.println("Green");
                break;
            case YELLOW:
                System.out.println("Yellow");
                break;
            case RED:
                System.out.println("Red");
                break;
        }

    }
}
