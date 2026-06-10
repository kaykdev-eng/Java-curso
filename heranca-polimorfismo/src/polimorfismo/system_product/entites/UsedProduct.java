package polimorfismo.system_product.entites;

import java.time.LocalDate;

public class UsedProduct extends Product{
    private LocalDate manufactureDate;

    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        return getName() + " (Used) " + getPrice() + " (Manufacture Date: " + getManufactureDate() + " )";
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }
}
