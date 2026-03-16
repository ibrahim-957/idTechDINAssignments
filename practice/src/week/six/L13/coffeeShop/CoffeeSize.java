package week.six.L13.coffeeShop;

public enum CoffeeSize {
    SMALL(2.5),
    MEDIUM(3.5),
    LARGE(4.5);

    private final double price;

    CoffeeSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
