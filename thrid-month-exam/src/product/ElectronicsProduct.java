package product;

import java.math.BigDecimal;

public class ElectronicsProduct {
    private Long id;
    private String name;
    private BigDecimal price;

    public ElectronicsProduct() {
    }

    public ElectronicsProduct(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
