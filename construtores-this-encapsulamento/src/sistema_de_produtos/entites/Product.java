package sistema_de_produtos.entites;

public class Product {
    private String nameProduct;
    private double priceProduct;
    private int quantityProduct;

    public Product (String nameProduct, double priceProduct, int InitialQuantity) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        addQuantity(InitialQuantity);
    }

    public Product (String nameProduct, double priceProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return this.nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return this.priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getQuantityProduct () {
        return this.quantityProduct;
    }

    public void addQuantity (int quantityProduct) {
     this.quantityProduct += quantityProduct;
    }

    public void removeToStock (int quantityProduct) {
        this.quantityProduct -= quantityProduct;
    }

    public double valueTotalInStock() {
        return this.priceProduct * this.quantityProduct;
    }

    public void descontInProduct(double descontValue) {
        double discount = this.priceProduct * descontValue / 100;
        this.priceProduct -= discount;
    }

    public void increasePrice(double amount) {
        double calcAmount = this.priceProduct + (this.priceProduct * amount / 100);
        setPriceProduct(calcAmount);
    }

    public String toString() {
        return "Updated data: " +
                "Product name: " + getNameProduct() + ", " +
                "Product price: " + String.format("%.2f", getPriceProduct()) + ", " +
                "Product quantity: " + getQuantityProduct() + ", " +
                "TOTAL: " + String.format("%.2f", valueTotalInStock());
    }
}
