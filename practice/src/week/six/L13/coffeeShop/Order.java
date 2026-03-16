package week.six.L13.coffeeShop;

public final class Order {
    private final CoffeeSize size;
    private final CoffeeType type;
    private final int quantity;

    public Order(CoffeeSize size, CoffeeType type, int quantity) {
        this.size = size;
        this.type = type;
        this.quantity = quantity;
    }

    public CoffeeSize getSize() {
        return size;
    }

    public CoffeeType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return size.getPrice() * quantity;
    }
}
