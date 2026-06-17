package model.entities;

import model.enums.ServiceType;

public class InstallationOrder extends WorkOrder {
    private Double materialCost;

    public InstallationOrder(Integer id, String client, Integer hours, Double valuePerHour, ServiceType type, Double materialCost) {
        super(id, client, hours, valuePerHour, ServiceType.INSTALLATION);
        this.materialCost = materialCost;
    }

    @Override
    public Double totalAmount() {
        return super.baseAmount() + materialCost;
    }

    public Double getMaterialCost() {
        return materialCost;
    }
}
