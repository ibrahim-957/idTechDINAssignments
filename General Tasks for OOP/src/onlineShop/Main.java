package onlineShop;

public class Main {
    public static void main(String[] args) {
        Product apple = new Product("Apple", 0.5);
        Product milk = new Product("Milk", 1.2);

        ShoppingCart cart = new ShoppingCart(10);

        cart.addItem(apple, 4);
        cart.addItem(milk, 2);

        System.out.println("Total price: " + cart.getTotalPrice());

        cart.removeItem("Apple");

        System.out.println("Total price after removal: " + cart.getTotalPrice());
    }
}
