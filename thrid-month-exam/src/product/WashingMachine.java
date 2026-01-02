package product;

import java.math.BigDecimal;

public class WashingMachine extends ElectronicsProduct{
    private int warrantyPeriod;

    public WashingMachine(Long id, String name, BigDecimal price, int warrantyPeriod) {
        super(id, name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void extendWarranty(int additionalMonths){
        warrantyPeriod += additionalMonths;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Warranty period: " + getWarrantyPeriod());
    }
}
