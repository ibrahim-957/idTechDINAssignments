public class Car {
    Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    void startCar()
    {
        System.out.println("Car is preparing to start...");
        engine.startEngine();
    }
}
