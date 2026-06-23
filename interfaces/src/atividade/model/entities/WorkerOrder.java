package atividade.model.entities;

import atividade.model.enums.ServiceType;
import atividade.model.exceptions.DomainException;

import java.security.Provider;

public abstract class WorkerOrder {
    private Integer id;
    private String client;
    private String description;
    private Double hours;
    private Double valuePerHour;

    private ServiceType type;
    private Invoice invoice;

    public WorkerOrder(Integer id, String client, String description, Double hours, Double valuePerHour, ServiceType type){
        if(id == null) {
            throw new DomainException("ID is required!");
        }
        if(client == null || client.isBlank()) {
            throw new DomainException("Client is required!");
        }
        if(description == null || description.isBlank()) {
            throw new DomainException("Description is required!");
        }
        if(hours == null) {
            throw new DomainException("Hours is required!");
        }
        if(valuePerHour == null) {
            throw new DomainException("valuePerHour is required!");
        }
        this.id = id;
        this.client = client;
        this.description = description;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
        this.type = type;
    }

    protected Double baseAmount() {
        return hours * valuePerHour;
    }

    public abstract Double serviceAmount();

    public Integer getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public ServiceType getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append("\n");
        sb.append("Client: ").append(getClient()).append("\n");
        sb.append("Type: ").append(getType()).append("\n");
        sb.append("Description: ").append(getDescription()).append("\n");
        sb.append("Basic payment: ").append(getInvoice().getBasicPayment()).append("\n");
        sb.append("Tax: $ ").append(getInvoice().getTax()).append("\n");
        sb.append("Total payment: ").append(String.format("%.2f", getInvoice().getTotalPayment())).append("\n");
        return sb.toString();
    }
}
