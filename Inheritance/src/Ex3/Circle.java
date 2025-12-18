package Ex3;

public class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void area() {
        System.out.println("Area of circle: " + Math.PI * Math.pow(radius, 2));
    }
}
