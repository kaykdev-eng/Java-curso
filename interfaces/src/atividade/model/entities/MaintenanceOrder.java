package atividade.model.entities;

import atividade.model.enums.ServiceType;

public class MaintenanceOrder extends WorkerOrder{

    public MaintenanceOrder(Integer id, String client, String description, Double hours, Double valuePerHour, ServiceType type) {
        super(id, client, description, hours, valuePerHour, type);
    }

    @Override
    public Double serviceAmount() {
        return super.baseAmount();
    }

}
