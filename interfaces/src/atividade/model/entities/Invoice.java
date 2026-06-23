package atividade.model.entities;

public class Invoice {
    private Double basicPayment;
    private Double tax;

    public Invoice(Double tax, Double basicPayment) {
        this.tax = tax;
        this.basicPayment = basicPayment;
    }

    public Double getTotalPayment() {
        return getBasicPayment() + getTax();
    }

    public Double getTax() {
        return tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }
}
