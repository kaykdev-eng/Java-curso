package Atividade.entites;

public class Product {
    private String productName;
    private Double productPrice;
    private Integer productQuantity;

    public Product(String productName, Double productPrice, Integer productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public Double totalAmount() {
        return productPrice += this.productPrice * productQuantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getProductName());
        sb.append(", ");
        sb.append(String.format("%.2f", totalAmount()));
        sb.append(", ");
        sb.append(getProductQuantity());
        sb.append("\n");
        return sb.toString();
    }
}
