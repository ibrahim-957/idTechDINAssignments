package week.six.L13.coffeeShop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var order1 = new Order(CoffeeSize.LARGE, CoffeeType.LATTE, 2);
        var order2 = new Order(CoffeeSize.SMALL, CoffeeType.ESPRESSO, 1);
        var order3 = new Order(CoffeeSize.MEDIUM, CoffeeType.CAPPUCCINO, 3);

        var orders = new ArrayList<Order>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        List<Integer> quantities = new ArrayList<>();
        for (Order o : orders){
            quantities.add(o.getQuantity());
        }

        System.out.println("========== RECEIPT ==========");
        System.out.printf("%-15s %-10s %5s  %8s%n", "TYPE", "SIZE", "QTY", "PRICE");
        System.out.println("-----------------------------");

        double grandTotal = 0;
        for (Order o : orders){
            System.out.printf("%-15s %-10s %5d  $%7.2f%n",
                    o.getType(),
                    o.getSize(),
                    o.getQuantity(),
                    o.getTotalPrice()
            );
            grandTotal += o.getTotalPrice();
        }

        System.out.println("-----------------------------");
        System.out.printf("%-15s %16s$%6.2f%n", "TOTAL", "", grandTotal);

        int totalItems = 0;
        for (Integer q :  quantities){
            totalItems += q;
        }

        System.out.println("Total items ordered: " + totalItems);
    }
}
