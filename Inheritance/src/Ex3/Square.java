package Ex3;

public class Square extends Shape {
    private double side;
    public Square(double side) {
        this.side = side;
    }

    @Override
    void area() {
        System.out.println("Area of square: " + side * side);
    }
}
