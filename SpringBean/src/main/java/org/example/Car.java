package org.example;

public class Car {
    private Engine engine;

    public void setEngine(Engine engine){
        this.engine = engine;
    }

    public void drive(){
        engine.start();
        System.out.println("Car started");
    }
}
