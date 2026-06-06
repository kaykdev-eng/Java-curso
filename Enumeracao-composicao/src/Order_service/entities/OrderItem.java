package Order_service.entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem(){}

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = product.getPrice();
        this.product = product;
    }

    public Double subTotal() {
        return this.quantity * this.price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }


    public Product getProduct() {
        return product;
    }

}
