package model.entities;

import model.enums.ServiceType;
import model.exceptions.DomainException;

public abstract class WorkOrder {
    private Integer id;
    private String client;
    private Integer hours;
    private Double valuePerHour;
    private ServiceType type;

    public WorkOrder(Integer id, String client, Integer hours, Double valuePerHour, ServiceType type) {
        if(client == null || client.isBlank()) {
            throw new DomainException("ERROR: Client name is required.");
        } else if(id == null) {
            throw new DomainException("ERROR: ID is required.");
        } else if (hours <= 0) {
            throw new DomainException("ERROR: Worked hours must be greater than zero: ");
        } else if (valuePerHour <= 0) {
            throw new DomainException("ERROR: Value per hour must be greater than zero");
        }

        this.id = id;
        this.client = client;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
        this.type = type;
    }

    protected Double baseAmount() {
        return this.hours * this.valuePerHour;
    }

    public abstract Double totalAmount();

    public Integer getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public Integer getHours() {
        return hours;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public ServiceType getType() {
        return type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ");
        sb.append(getId());
        sb.append("\n");
        sb.append("Client: ");
        sb.append(getClient());
        sb.append("\n");
        sb.append("Type: ");
        sb.append(getType());
        sb.append("\n");
        sb.append("Total amount: $ ");
        sb.append(String.format("%.2f", totalAmount()));
        sb.append("\n");
        return sb.toString();
    }
}
