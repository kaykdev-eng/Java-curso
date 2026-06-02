package Atividade_final_modulo.entites;

public class Product {
    private final int ID;
    private String NAME;
    private double PRICE;
    private int QUANTITY;

    public Product(int ID, String NAME, double PRICE, int QUANTITY) {
        this.ID = ID;
        this.NAME = NAME;
        this.PRICE = PRICE;
        setQUANTITY(QUANTITY);
    }

    public Product(int ID,String NAME, double PRICE) {
        this.ID = ID;
        this.NAME = NAME;
        this.PRICE = PRICE;
    }

    public int getID() {
        return ID;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public double getPRICE() {
        return PRICE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void addToStock(int x) {
        this.QUANTITY += x;
    }

    public void removeToStock(int x) {
        this.QUANTITY -= x;
    }

    public void applyDiscount(int amount) {
        this.PRICE -= this.PRICE * amount / 100;
    }

    public void increasePrice(double amount) {
        this.PRICE += this.PRICE * amount / 100;
    }

    public double totalInStock() {
        return this.PRICE * this.QUANTITY;
    }

    public String toString() {
        return "ID: " + getID() + "\n" +
                "Name: " + getNAME() + "\n" +
                "Price: " + String.format("%.2f", getPRICE()) + "\n" +
                "Quantity: " + getQUANTITY();
    }
}
