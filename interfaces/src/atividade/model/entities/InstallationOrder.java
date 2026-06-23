package atividade.model.entities;

import atividade.model.enums.ServiceType;

public class InstallationOrder extends WorkerOrder {
    private Double materialCost;

    public InstallationOrder(Integer id, String client, String description, Double hours, Double valuePerHour, ServiceType type, Double materialCost) {
        super(id, client, description, hours, valuePerHour, type);
        this.materialCost = materialCost;
    }

    @Override
    public Double serviceAmount() {
        return super.baseAmount() + materialCost;
    }

    public Double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(Double materialCost) {
        this.materialCost = materialCost;
    }
}

