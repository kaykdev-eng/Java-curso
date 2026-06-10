package polimorfismo.system_product.entites;

public class ImportedProduct extends Product{
    private Double customsFree;

    public ImportedProduct(String name, Double price, Double customsFree) {
        super(name, price);
        this.customsFree = customsFree;
    }

    public Double totalPrice () {
        return price + customsFree;
    }

    @Override
    public String priceTag() {
        return getName() + " $ " + totalPrice() + " (Custom free: $ " + getCustomsFree() + " )";
    }

    public Double getCustomsFree() {
        return customsFree;
    }

    public void setCustomsFree(Double customsFree) {
        this.customsFree = customsFree;
    }
}
