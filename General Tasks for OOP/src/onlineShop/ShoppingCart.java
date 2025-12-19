package onlineShop;

public class ShoppingCart {
    private CartItem[] cartItems;
    private int count;

    public ShoppingCart(int capacity) {
        cartItems = new CartItem[capacity];
        count = 0;
    }

    public CartItem[] getCartItems() {
        return cartItems;
    }

    public int getCount() {
        return count;
    }

    public void addItem(Product product, int quantity) {
        if (count < cartItems.length) {
            cartItems[count] = new CartItem(product, quantity);
            count++;
        }
        else {
            System.out.println("ShoppingCart is full");
        }
    }

    public void removeItem(String productName) {
        for (int i = 0; i < count; i++) {
            if (cartItems[i].getProduct().getName().equals(productName)) {
                for (int j = i; j < count - 1; j++) {
                    cartItems[j] = cartItems[j + 1];
                }
                cartItems[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += cartItems[i].getTotalPrice();
        }
        return total;
    }
}
