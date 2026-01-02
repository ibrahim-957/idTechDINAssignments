package product;

import java.math.BigDecimal;

public class ElectronicsProduct {
    private Long id;
    private String name;
    private BigDecimal price;

    public ElectronicsProduct(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal applyDiscount(BigDecimal discount) {
        return price.subtract(discount);
    }

    public void display(){
        System.out.println("Product ID: " + getId());
        System.out.println("Product Name: " + getName());
        System.out.println("Product Price: " + getPrice());
    }
}
