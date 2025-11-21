public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.horsePower = 100;
        Car car = new Car(engine);
        car.startCar();
    }
}