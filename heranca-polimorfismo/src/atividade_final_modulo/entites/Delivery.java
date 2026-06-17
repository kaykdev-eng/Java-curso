package atividade_final_modulo.entites;

import atividade_final_modulo.Enum.TypeDelivery;

public abstract class Delivery {
    private static final double PRICE_PER_KG = 4.0;
    private final Integer Id;
    private String client;
    private Double weightKg;
    protected Double basePrice;
    private TypeDelivery statusDelivery;

    public Delivery (Integer Id, String client, Double weightKg, Double basePrice, TypeDelivery statusDelivery) {
        this.Id = Id;
        this.client = client;
        this.weightKg = weightKg;
        this.basePrice = basePrice;
        this.statusDelivery = statusDelivery;
    }

    protected Double basePriceCalc() {
        return this.basePrice + weightKg * PRICE_PER_KG;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Code: ");
        sb.append(getId());
        sb.append("\n");
        sb.append("Client: ");
        sb.append(getClient());
        sb.append("\n");
        sb.append("Type: ");
        sb.append(getStatusDelivery());
        sb.append("\n");
        sb.append("Final freight: $ ");
        sb.append(calculateShipping());
        sb.append("\n");
        return sb.toString();
    }

    public abstract Double calculateShipping();

    public Integer getId() {
        return Id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public TypeDelivery getStatusDelivery() {
        return statusDelivery;
    }
}
