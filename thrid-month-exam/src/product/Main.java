package product;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        WashingMachine wm  = new WashingMachine(10L, "LG", BigDecimal.valueOf(1000), 36);
        BigDecimal finalPrice =  wm.applyDiscount(BigDecimal.valueOf(100));
        wm.display();
        System.out.println("---------------------------------");
        System.out.println("Final Price: " + finalPrice);
        System.out.println("---------------------------------");
        wm.extendWarranty(18);
        wm.display();
    }
}
