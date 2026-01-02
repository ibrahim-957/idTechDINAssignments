package inheritanceAndPolymorphism;

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        System.out.println("Area of circle: " + s1.area());
        Shape s2 = new Rectangle(5, 8);
        System.out.println("Area of Rectangle: " + s2.area());
    }
}
