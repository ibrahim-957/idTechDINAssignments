public class Rectangle {
    double width;
    double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle() {
    }

    public void getArea() {
        System.out.println("Area of rectangle is " + width * length);
    }

    public void getPerimeter() {
        System.out.println("Perimeter of rectangle is " + 2 * (width + length));
    }
}
